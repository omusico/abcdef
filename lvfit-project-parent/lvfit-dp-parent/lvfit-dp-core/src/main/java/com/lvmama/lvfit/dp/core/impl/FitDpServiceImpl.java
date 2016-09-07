package com.lvmama.lvfit.dp.core.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.enums.DefaultRule;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.exception.FitExceptionCode;
import com.lvmama.lvf.common.task.Task;
import com.lvmama.lvf.common.task.TaskContext;
import com.lvmama.lvf.common.task.TaskGroup;
import com.lvmama.lvf.common.task.TaskMainGroup;
import com.lvmama.lvf.common.trace.TraceContext;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.FitAggregateClient;
import com.lvmama.lvfit.common.client.FitBusinessClient;
import com.lvmama.lvfit.common.dto.InsuranceType;
import com.lvmama.lvfit.common.dto.RequestWithException;
import com.lvmama.lvfit.common.dto.app.FitAppHotelRequest;
import com.lvmama.lvfit.common.dto.config.FitConRecomHotelConfig;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.FitBusinessExceptionType;
import com.lvmama.lvfit.common.dto.enums.FitBusinessType;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.SymbolType;
import com.lvmama.lvfit.common.dto.enums.TripeType;
import com.lvmama.lvfit.common.dto.enums.VSTDistrictCityEnum;
import com.lvmama.lvfit.common.dto.hotel.FitConRecomHotelDto;
import com.lvmama.lvfit.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvfit.common.dto.price.FitFlightTicketPriceDto;
import com.lvmama.lvfit.common.dto.price.FitHotelPlanPriceDto;
import com.lvmama.lvfit.common.dto.search.FitPassengerRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.FlightQueryRequest;
import com.lvmama.lvfit.common.dto.search.flight.FlightSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.SearchResultUtil;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;
import com.lvmama.lvfit.common.dto.search.hotel.HotelFacetType;
import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchPlanDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchRoomDto;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceQueryRequest;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceSearchResult;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceProdProduct;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceProdProductBranch;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceSuppGoods;
import com.lvmama.lvfit.common.dto.search.spot.SpotQueryRequest;
import com.lvmama.lvfit.common.dto.search.spot.SpotSearchResult;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedInsuranceDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedTicketDto;
import com.lvmama.lvfit.common.dto.shopping.FlightInsuranceDto;
import com.lvmama.lvfit.common.dto.trace.FitOpLogTraceContext;
import com.lvmama.lvfit.common.utils.HotelUtils;
import com.lvmama.lvfit.dp.service.FitDpService;
import com.lvmama.lvfit.dp.shopping.service.ShoppingService;

@Service
public class FitDpServiceImpl implements FitDpService{
	
	private static final Logger logger = LoggerFactory.getLogger(FitDpServiceImpl.class);
	
	public static final String LOW_SEAT_KEY = "LowestSeat";
	
	public static final String NO_HOTEL_RESULT = "未查到酒店数据";
	public static final String NO_DEP_FLI_RESULT = "未查到去程机票数据";
	public static final String NO_RE_FLI_RESULT = "未查到返程机票数据";
	public static final String NO_SPOT_RESULT = "未查到景点门票数据";
	public static final String NO_INSURANCE_RESULT = "未查到保险数据";
	public static final String UUID_IS_NULL = "购物车UUID为空";
	public static final String UUID_IS_NULL_IN_CACHE = "缓存中不存在购物车UUID";
	public static final String NO_FLIGHT_INSURANCE_RESULT = "未查到飞机航意险数据";
	public static final String CONFIG_RECOMHOTEL_ID="配置默认推荐酒店ID";
	
	@Autowired
	FitAggregateClient fitAggregateClient;
	
	@Autowired
	ShoppingService shoppingService;

    @Autowired
    FitBusinessClient fitBusinessClient;
	
	@Override
	public  String search(FitSearchRequest request) {
	      
        //1. 设置购物车UUID
        String uuid = null; 
        if(StringUtils.isNotBlank(request.getShoppingId())){//在产品选择页发起的查询
            uuid = request.getShoppingId();
        } else {//在入口页发起的查询
            uuid = FitSearchRequest.createUUID();
            request.setShoppingId(uuid);
        }
    
        //2. 获取查询结果集
        FitSearchResult fitSearchResult = this.searchResult(request);
        
        //3. 处理查询数据
        this.handleFitSearchResult(request, fitSearchResult);
        
        return uuid;
	}

	/**根据请求参数获取查询结果集
	 * @param request
	 * @return
	 * @throws ExceptionWrapper
	 */
	private FitSearchResult searchResult(FitSearchRequest request)
			throws ExceptionWrapper {
		//1. 构造任务执行参数以及生成执行组（机票、酒店）
		TaskContext context = this.initTaskContext(request);
		TaskMainGroup<FitSearchResult> taskMainGroup = this.initTaskGroup(context);
		
		//2. 执行并发线程组并获取执行结果
		@SuppressWarnings("unchecked")
		Map<String,Object> taskMap = (Map<String,Object>)context.get("taskMap")	;
		FitSearchResult fitSearchResult = taskMainGroup.getResult(taskMap.keySet().size());
		
		//3. 如果查询结果出现业务异常需进行处理
		this.handleException(context);
		return fitSearchResult;
	}

	/**
	 * 1.设置选择的机票和酒店, 基准价
	 * 2.将信息保存到缓存中
	 * 3.将返回为空的产品，记录为业务异常，保存到context中
	 * @param request
	 * @param fitSearchResult
	 */
	private void handleFitSearchResult(FitSearchRequest request,FitSearchResult fitSearchResult){
	    List<FlightSearchResult<FlightSearchFlightInfoDto>> flightSearchResults = fitSearchResult.getFlightSearchResult(); //[0]:去程，[1]返程
		List<HotelSearchResult<HotelSearchHotelDto>> hotelSearchResults = fitSearchResult.getHotelSearchResult();
		List<FlightSearchFlightInfoDto> flights = new ArrayList<FlightSearchFlightInfoDto>();
		List<HotelSearchHotelDto> hotels = new ArrayList<HotelSearchHotelDto>();
		List<SpotSearchSpotDto> spots = new ArrayList<SpotSearchSpotDto>();
		List<InsuranceDto> insurances = new ArrayList<InsuranceDto>();
        Map<String,List<FlightSearchFlightInfoDto>> flightMap = new LinkedHashMap<String,List<FlightSearchFlightInfoDto>>();
        String recomHotelId = fitSearchResult.getRecomHotelId();
        // 当搜索条件变化时，清空产品选中信息
        FitShoppingDto shoppingDto = shoppingService.getFitShopping(request.getShoppingId());
        String requestKey = request.getRequestKey();
        if (shoppingDto == null) {
            shoppingDto = new FitShoppingDto();
        } else {
            String oldRequestKey = shoppingDto.getRequestKey();
            if (oldRequestKey != null && requestKey != null && !requestKey.equals(oldRequestKey)) {
                shoppingDto.setSelectTicketInfo(new ArrayList<FitShoppingSelectedTicketDto>());
                shoppingDto.setSelectInsuranceInfo(new ArrayList<FitShoppingSelectedInsuranceDto>());
                shoppingDto.setSelectFlightInsInfo(new ArrayList<FlightInsuranceDto>());
                shoppingDto.setFliInsDelFlag(false);
            }
        }
        shoppingDto.setRequestKey(requestKey);
        try {
            //1. 处理机票数据
            List<FlightSearchFlightInfoDto> toFlights = null;
            List<FlightSearchFlightInfoDto> backFlights = null;
            
            if (CollectionUtils.isNotEmpty(flightSearchResults)) {
                flightSearchResults = this.handleFlights(request, flightSearchResults);
                if(CollectionUtils.isNotEmpty(flightSearchResults)){
                	toFlights = flightSearchResults.get(0).getResults();
                    flightMap.put(FitBusinessType.FIT_Q_T.name(), toFlights);
                    if (flightSearchResults.size() > 1) {
                        backFlights = flightSearchResults.get(1).getResults();
                    }
                    flightMap.put(FitBusinessType.FIT_Q_R.name(), backFlights);

                    fitSearchResult.setDistinctFlightMap(flightMap);

                    for (Map.Entry<String, List<FlightSearchFlightInfoDto>> entry : flightMap.entrySet()) {
                        if (CollectionUtils.isNotEmpty(entry.getValue()) && entry.getValue().get(0) != null) {
                            entry.getValue().get(0).getSeats().get(0).setSelectFlag(Boolean.TRUE);
                            flights.add(entry.getValue().get(0));
                        }
                    }
                }
                // 1.1 处理机票航意险数据
                List<InsuranceInfoDto> flightInsurances = fitSearchResult.getFlightInsuranceResult();
                List<InsuranceInfoDto> filterInsurances = new ArrayList<InsuranceInfoDto>();
                
                if (CollectionUtils.isEmpty(flightInsurances)) {
                    FitOpLogTraceContext.setExThreadLocal(new ExceptionWrapper(NO_FLIGHT_INSURANCE_RESULT, ExceptionCode.GET_NO_AFFLI_RESULT));
                }
                
                if (CollectionUtils.isNotEmpty(flightInsurances)) {
                    // 机票保险过滤
                    for (InsuranceInfoDto insurance : flightInsurances) {
                        if (insurance.getInsuranceType().equals(com.lvmama.lvf.common.dto.enums.InsuranceType.ACCIDENT_INS)) {
                            filterInsurances.add(insurance);
                        }
                    }
                    // 默认航空意外险
                    this.setDefaultfliInsurance(request, shoppingDto, filterInsurances);
                    // 默认的航空意外险排在首位
                    Collections.sort(filterInsurances, new Comparator<InsuranceInfoDto>() {
                        @Override
                        public int compare(InsuranceInfoDto o1, InsuranceInfoDto o2) {
                            if (DefaultRule.DEFAULT.equals(o1.getDefaultRule())) {
                                return -1;
                            }
                            if (DefaultRule.DEFAULT.equals(o2.getDefaultRule())) {
                                return 1;
                            }
                            return 0;
                        }
                    });
                    shoppingDto.setFlightInsuranceInfos(filterInsurances);
                }
            }

            if (CollectionUtils.isEmpty(flightMap.get(FitBusinessType.FIT_Q_T.name()))
                    || flightMap.get(FitBusinessType.FIT_Q_T.name()).get(0) == null) {
                FitOpLogTraceContext.setExThreadLocal(new ExceptionWrapper(NO_DEP_FLI_RESULT, ExceptionCode.GET_NO_RESULT));
            }
            if (request.getTripType().equals(TripeType.WF.name())) {
                if (CollectionUtils.isEmpty(flightMap.get(FitBusinessType.FIT_Q_R.name()))
                        || flightMap.get(FitBusinessType.FIT_Q_R.name()).get(0) == null) {
                    FitOpLogTraceContext.setExThreadLocal(new ExceptionWrapper(NO_RE_FLI_RESULT, ExceptionCode.GET_NO_RESULT));
                }
            }
            
            shoppingDto.setFlightInfos(flights);
    		
            //2. 处理酒店数据
    		if (CollectionUtils.isNotEmpty(hotelSearchResults) && CollectionUtils.isNotEmpty(hotelSearchResults.get(0).getResults())) {
    			
    			hotelSearchResults = this.getDefaultHotelInfo(hotelSearchResults, request);//过滤没有库存的酒店，选择默认酒店		
    			
    			if(hotelSearchResults!=null){
    				if(CollectionUtils.isNotEmpty(hotelSearchResults.get(0).getResults()) 
    				  && hotelSearchResults.get(0).getResults().get(0) != null
    				  && CollectionUtils.isNotEmpty(hotelSearchResults.get(0).getResults().get(0).getRooms())){
    					
    					for(int i = 0; i <hotelSearchResults.get(0).getResults().get(0).getRooms().size();i++){
    						hotelSearchResults.get(0).getResults().get(0).getRooms().get(i).setRoomCounts(request.getHotelSearchRequests().get(0).getRoomCounts());
    					}
    					hotelSearchResults.get(0).getResults().get(0).getRooms().get(0).setSelectedFlag(true);
    					
    					if(hotelSearchResults.get(0).getResults().get(0).getRooms().get(0) != null 
    						&& CollectionUtils.isNotEmpty(hotelSearchResults.get(0).getResults().get(0).getRooms().get(0).getPlans())){
    						if( hotelSearchResults.get(0).getResults().get(0).getRooms().get(0).getPlans().get(0) != null){
    							hotelSearchResults.get(0).getResults().get(0).getRooms().get(0).getPlans().get(0).setSelectedFlag(true);
    						}
    					}
    					List<HotelSearchHotelDto> results = hotelSearchResults.get(0).getResults();
    					//配置中默认为推荐的酒店，放到产品选择页
    					HotelSearchHotelDto finalHotel = this.handFinalHotel(results,recomHotelId,request.getHotelSearchRequests().get(0).getRoomCounts());
    					hotels.add(finalHotel);
    					shoppingDto.setHotelCounts(hotelSearchResults.get(0).getResults().size());
    					shoppingDto.setRecommendedHotels(hotelSearchResults.get(0).getResults());//保证在更换酒店页第一页出现默认推荐的酒店
    				}
    			}
    		}
    		
            if(CollectionUtils.isEmpty(hotels) || hotels.get(0) == null) {
                FitOpLogTraceContext.setExThreadLocal(new ExceptionWrapper(NO_HOTEL_RESULT, ExceptionCode.GET_NO_AFFLI_RESULT));
            }
            shoppingDto.setHotels(hotels);
            
            // 3. 处理门票结果
            if (fitSearchResult.getSpotSearchResult().get(0) != null) {
                spots = fitSearchResult.getSpotSearchResult().get(0).getResults();
                if (CollectionUtils.isEmpty(spots)) {
                    FitOpLogTraceContext.setExThreadLocal(new ExceptionWrapper(NO_SPOT_RESULT, ExceptionCode.GET_NO_AFFLI_RESULT));
                }
            }
            shoppingDto.setSpots(spots);
            
            // 4. 处理保险结果
            if (fitSearchResult.getInsuranceResult() != null) {
            	insurances = fitSearchResult.getInsuranceResult().getResults();
            	if (CollectionUtils.isEmpty(insurances)) {
            		FitOpLogTraceContext.setExThreadLocal(new ExceptionWrapper(NO_INSURANCE_RESULT, ExceptionCode.GET_NO_AFFLI_RESULT));
            	} else {
            		InsuranceDto insuranceDto = insurances.get(0);
            		// 保险每个产品只显示一条
                    this.filterOneInsuranceTypeOneProduct(insuranceDto);

                    // 保险排序
                    this.sortInsurance(insuranceDto);
            	}
            }
            shoppingDto.setInsurances(insurances);
    
    		shoppingDto.setSearchRequest(request);
    		//----设置机票基准价-----
    	    this.setFlightBasePrice(request, flightMap, shoppingDto);
    
            //----设置酒店基准价-----
            this.setHotelBasePrice(hotels, shoppingDto);
		} catch(Exception e) {
		    e.printStackTrace();
		} finally {
		    shoppingService.putShoppingCache(request.getShoppingId(), shoppingDto);
		}
    }

	/**
	 * 将默认配置的酒店作为选中的
	 * @param results
	 * @param recomHotelId
	 * @param roomCounts 
	 * @return
	 */
    private HotelSearchHotelDto handFinalHotel(List<HotelSearchHotelDto> results, String recomHotelId, Integer roomCounts) {
		Boolean isDefault = Boolean.FALSE;
		HotelSearchHotelDto hotel = new HotelSearchHotelDto();
		for (HotelSearchHotelDto hotelSearchHotelDto : results) {
			if(hotelSearchHotelDto.getProductId().equals(recomHotelId)){
				isDefault = Boolean.TRUE;
				hotelSearchHotelDto.getRooms().get(0).setSelectedFlag(Boolean.TRUE);
				for (HotelSearchRoomDto room : hotelSearchHotelDto.getRooms()) {
					room.setRoomCounts(roomCounts);
				}
				hotelSearchHotelDto.getRooms().get(0).getPlans().get(0).setSelectedFlag(Boolean.TRUE);
				hotel = hotelSearchHotelDto;
				break;
			}
		}
    	if(isDefault){
    		return hotel;
    	}
    	return results.get(0);
	}

	private void setDefaultfliInsurance(FitSearchRequest request, FitShoppingDto shoppingDto,
            List<InsuranceInfoDto> filterInsurances) {
        if (shoppingDto.getFliInsDelFlag() == false && CollectionUtils.isEmpty(shoppingDto.getSelectFlightInsInfo())) {
            InsuranceInfoDto flightInsDto = null;
            for (InsuranceInfoDto filterIns : filterInsurances) {
                if (DefaultRule.DEFAULT.equals(filterIns.getDefaultRule())) {
                    flightInsDto = filterIns;
                }
            }
            if (flightInsDto != null) {
                FlightInsuranceDto fInsDto = new FlightInsuranceDto();
                fInsDto.setInsuranceId(flightInsDto.getId());
                fInsDto.setInsuranceName(flightInsDto.getInsuranceClass().getName() + flightInsDto.getInsuranceRemark());
                fInsDto.setInsurancePrice(flightInsDto.getInsurancePrice());
                fInsDto.setInsuranceDesc(flightInsDto.getInsuranceDesc());
                fInsDto.setSuppName(flightInsDto.getSupp().getName());
                int count = request.getFitPassengerRequest().getAdultCount() + request.getFitPassengerRequest().getChildCount();
                if (request.getTripType().equals("WF")) {
                    count = count * 2;
                }
                fInsDto.setInsuranceCount(count);
                fInsDto.setInsuranceClassCode(flightInsDto.getInsuranceClass().getCode());
                
                List<FlightInsuranceDto> flightInsDtos = new ArrayList<FlightInsuranceDto>();
                flightInsDtos.add(fInsDto);
                shoppingDto.setSelectFlightInsInfo(flightInsDtos);
            }
        }
    }

    private void sortInsurance(InsuranceDto insuranceDto) {
        for (InsuranceProdProduct insuranceProduct : insuranceDto.getInsuranceProductList()) {
            for (InsuranceProdProductBranch branch : insuranceProduct.getInsuranceProductBranchList()) {
                List<InsuranceSuppGoods> suppGoodsList = branch.getInsuranceSuppGoodList();
                if (suppGoodsList != null) {
                    // 统一规格按价格由低到高
                    Collections.sort(suppGoodsList, new Comparator<InsuranceSuppGoods>() {
                        public int compare(InsuranceSuppGoods arg0, InsuranceSuppGoods arg1) {
                            return arg0.getInsPrice().getPrice().compareTo(arg1.getInsPrice().getPrice());
                        }
                    });
                }
            }
            // 统一产品规格按推荐级别由高到低
            Collections.sort(insuranceProduct.getInsuranceProductBranchList(), new Comparator<InsuranceProdProductBranch>() {
                public int compare(InsuranceProdProductBranch arg0, InsuranceProdProductBranch arg1) {
                    return arg1.getRecommendLevel().compareTo(arg0.getRecommendLevel());
                }
            });
        }
    }

    private void filterOneInsuranceTypeOneProduct(InsuranceDto insuranceDto) {
        List<InsuranceProdProduct> products = new ArrayList<InsuranceProdProduct>();
        List<String> filterIds = new ArrayList<String>();
        for (InsuranceProdProduct insuranceProduct : insuranceDto.getInsuranceProductList()) {
            Object o = insuranceProduct.getPropValue().get("insurance_type");
            try {
                String json = JSONMapper.getInstance().writeValueAsString(o);
                InsuranceType insuranceType = JSONMapper.getInstance().readValue(json, InsuranceType[].class)[0];
                String id = insuranceType.getId();
                if (filterIds.contains(id)) {
                    continue;
                }
                filterIds.add(id);
                products.add(insuranceProduct);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        insuranceDto.setInsuranceProductList(products);
    }

	/**
	 * 默认第一条保险选中，份数为总人数
	 */
    private FitShoppingSelectedInsuranceDto getDefaultInsurance(List<InsuranceDto> insurances, int count,Date visitDate) {
        InsuranceDto defaultInsurance = insurances.get(0);
        FitShoppingSelectedInsuranceDto selInsurance = new FitShoppingSelectedInsuranceDto();
        selInsurance.setProductId(String.valueOf(defaultInsurance.getInsuranceProductList().get(0).getProductId()));
        selInsurance.setProductType(String.valueOf(defaultInsurance.getInsuranceProductList().get(0).getInsuranceType()));
        selInsurance.setProductName(defaultInsurance.getInsuranceProductList().get(0).getProductName());
        selInsurance.setBranchId(defaultInsurance.getInsuranceProductList().get(0).getInsuranceProductBranchList().get(0).getProductBranchId().toString());
        selInsurance.setBranchName(defaultInsurance.getInsuranceProductList().get(0).getInsuranceProductBranchList().get(0).getBranchName());
        selInsurance.setSuppGoodsId(defaultInsurance.getInsuranceProductList().get(0).getInsuranceProductBranchList().get(0).getInsuranceSuppGoodList().get(0).getSuppGoodsId().toString());
        selInsurance.setSuppGoodsName(defaultInsurance.getInsuranceProductList().get(0).getInsuranceProductBranchList().get(0).getInsuranceSuppGoodList().get(0).getGoodsName());
        selInsurance.setInsuranceCount(count);
        selInsurance.setInsuranceDetail(defaultInsurance.getInsuranceProductList().get(0).getInsuranceProductBranchList().get(0).getInsuranceSuppGoodList().get(0).getInsuranceGoodBranch().getInsuranceDesc());
        selInsurance.setVisitDate(visitDate);
        BigDecimal bd = new BigDecimal(defaultInsurance.getInsuranceProductList().get(0).getInsuranceProductBranchList().get(0).getInsuranceSuppGoodList().get(0).getInsPrice().getPriceYuan());
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        selInsurance.setInsurancePrice(bd);
        return selInsurance;
    }

	/**
	 * 设计机票基准价
	 * @param request
	 * @param flightMap
	 * @param shoppingDto
	 */
    @SuppressWarnings("unused")
	private void setFlightBasePrice(FitSearchRequest request,
    		Map<String,List<FlightSearchFlightInfoDto>> flightMap, FitShoppingDto shoppingDto) {
    	
        if(MapUtils.isEmpty(flightMap)){
        	return;
        }
        BigDecimal toFlightBasePrice = new BigDecimal(0);
    	BigDecimal backFlightBasePrice = new BigDecimal(0);
        int adultCount = request.getFitPassengerRequest().getAdultCount();
	    int childCount = request.getFitPassengerRequest().getChildCount();
        for(Map.Entry<String,List<FlightSearchFlightInfoDto>> entry : flightMap.entrySet()){
			if(CollectionUtils.isNotEmpty(entry.getValue())&&entry.getValue().get(0)!=null){
				FlightSearchSeatDto seat = entry.getValue().get(0).getSeats().get(0);
				if(entry.getKey().equals(FitBusinessType.FIT_Q_T.name())){
					toFlightBasePrice = seat.getSalesPrice().multiply(new BigDecimal(adultCount)).add(seat.getChildrenPrice().multiply(new BigDecimal(childCount)));
					shoppingDto.setToFlightBasePrice(toFlightBasePrice);
				}else if(entry.getKey().equals(FitBusinessType.FIT_Q_R.name())){
					backFlightBasePrice = seat.getSalesPrice().multiply(new BigDecimal(adultCount)).add(seat.getChildrenPrice().multiply(new BigDecimal(childCount)));
					shoppingDto.setBackFlightBasePrice(backFlightBasePrice);
				}
			}
			
		}
    }

    private void setHotelBasePrice(List<HotelSearchHotelDto> hotels, FitShoppingDto shoppingDto) {
        if (CollectionUtils.isEmpty(hotels)) {
            return;
        }
        int roomCount;
        List<HotelSearchRoomDto> rooms = hotels.get(0).getRooms();
        BigDecimal hotelBasePrice = BigDecimal.valueOf(0);
        for(HotelSearchRoomDto room :rooms){
            if (room.getSelectedFlag()){//选中的房间
                List<HotelSearchPlanDto> plans = room.getPlans();
                roomCount = room.getRoomCounts();
                for(HotelSearchPlanDto plan :plans){
                    if(plan.getSelectedFlag()){//选中的plan
                        for(FitHotelPlanPriceDto priceDto:plan.getDayPrice()){
                            //hotelBasePrice = hotelBasePrice.add(priceDto.getSettlePrice());
                            hotelBasePrice = hotelBasePrice.add(priceDto.getSalesPrice());//销售价取销售价的字段
                        }
                        hotelBasePrice = hotelBasePrice.multiply(new BigDecimal(roomCount));
                    } 
                }
            }
        }
        shoppingDto.setHotelBasePrice(hotelBasePrice);
    }

	/**
	 * @param context
	 * @throws ExceptionWrapper
	 */
	private void handleException(TaskContext context) {
        String traceId = (String) context.get("traceId");
        Set<String> exceptionKeys = context.keySet();
        List<Exception> exceptions = new ArrayList<Exception>();
        for (String key : exceptionKeys) {
            if (key.endsWith(FitBusinessExceptionType._E.name())) {
            	RequestWithException requestWithException = (RequestWithException)context.get(FitBusinessExceptionType.valueOf(key).name());
            	Object request = requestWithException.getRequest();
                Exception curException = requestWithException.getE();
                if (curException != null) {
                    FitOpLogTraceContext.setFitOpLog(request,curException, traceId, FitBusinessExceptionType.valueOf(key));
                    exceptions.add(curException);
                }
            }
        }
        if (CollectionUtils.isNotEmpty(exceptions)) {
            for (Exception exception : exceptions) {
                if (exception instanceof ExceptionWrapper) {
                    ExceptionWrapper ew = (ExceptionWrapper) exception;
                    FitOpLogTraceContext.setExThreadLocal(ew);
                } else {
                    new RuntimeException(exception);
                }
            }
        }
    }

	/**
	 * 此方法返回对舱位进行排序后的机票信息，排序后，每个航班的每种舱位类型中最多只有一个最低价的舱位(也可能某种舱位类型下，没有舱位)
	 * 
	 * */
	 public List<FlightSearchResult<FlightSearchFlightInfoDto>> getSortedFlightList(List<FlightSearchResult<FlightSearchFlightInfoDto>> list){
		 List<FlightSearchResult<FlightSearchFlightInfoDto>> resultlist = new ArrayList<FlightSearchResult<FlightSearchFlightInfoDto>>();
		 
		 for(FlightSearchResult<FlightSearchFlightInfoDto> flightResult:list){
			 List<FlightSearchFlightInfoDto> flightInfolist= flightResult.getResults();
			 for(FlightSearchFlightInfoDto flightInfoDto:flightInfolist){//每个舱位类型，按照价格进行排序
				List<FlightSearchSeatDto> seatlist = SearchResultUtil.getYCFLowPriceSeats(flightInfoDto);
				flightInfoDto.setSeats(seatlist);
			 }
			 flightResult.setResults(flightInfolist);
			 resultlist.add(flightResult);
		 }
		 return resultlist;
		 
	 }

	 /**
	  * 去除库存不足的数据
	  * 
	  * */
	 public List<FlightSearchResult<FlightSearchFlightInfoDto>> getAvailableSeats(List<FlightSearchResult<FlightSearchFlightInfoDto>> list,FitSearchRequest request){
		 List<FlightSearchResult<FlightSearchFlightInfoDto>> resultlist = new ArrayList<FlightSearchResult<FlightSearchFlightInfoDto>>();
		  for(FlightSearchResult<FlightSearchFlightInfoDto> flightResult:list){
			  if(null != flightResult){
				  List<FlightSearchFlightInfoDto> flightInfolist= flightResult.getResults();
					 List<FlightSearchFlightInfoDto> availableflightlist= new ArrayList<FlightSearchFlightInfoDto>();
					 for(FlightSearchFlightInfoDto flightInfoDto:flightInfolist){
						 flightInfoDto = SearchResultUtil.isAvailableSeat(flightInfoDto,request);
						 if(CollectionUtils.isNotEmpty(flightInfoDto.getSeats())){//这里的舱位列表已经进行过处理，没有库存的舱位已经去除
							 availableflightlist.add(flightInfoDto);
						 }
					 }
					 flightResult.setResults(availableflightlist);
					 resultlist.add(flightResult);  
			  }
		 }
		 return resultlist;
	 }
	 /**
	  * 此方法返回最低价位的航班及舱位，结果中至多只有两个值(去程和返程)
	  * */
	 public List<FlightSearchResult<FlightSearchFlightInfoDto>> getLowestList(List<FlightSearchResult<FlightSearchFlightInfoDto>> list){
		 List<FlightSearchResult<FlightSearchFlightInfoDto>> resultlist = new ArrayList<FlightSearchResult<FlightSearchFlightInfoDto>>();
		 Map<String,FlightSearchFlightInfoDto> seatMap = new HashMap<String,FlightSearchFlightInfoDto>();
		 Map<String,FlightSearchSeatDto> lowestMap = new HashMap<String,FlightSearchSeatDto>();
		 for(FlightSearchResult<FlightSearchFlightInfoDto> flightResult:list){//此list里只有两个元素  去程和返程，所以第一次循环得到的是去程的航班，第二次得到的是返程的航班
			 List<FlightSearchFlightInfoDto> flightInfolist= flightResult.getResults();
			 
			 for(FlightSearchFlightInfoDto flightInfoDto:flightInfolist){
				 FlightSearchSeatDto seatDto = SearchResultUtil.getLowestPriceSeat(flightInfoDto.getSeats());
				 
				if(lowestMap.size() >0){
					if(lowestMap.get(LOW_SEAT_KEY).getSalesPrice().compareTo(seatDto.getSalesPrice())>0){
						lowestMap.put(LOW_SEAT_KEY, seatDto);
						seatMap.put(LOW_SEAT_KEY, flightInfoDto);
					} else if (lowestMap.get(LOW_SEAT_KEY).getSalesPrice().compareTo(seatDto.getSalesPrice())==0){
						//说明两个价格相等，取起飞时间最早的航班
						if(DateUtils.parseDate(seatMap.get(LOW_SEAT_KEY).getDepartureTime()).after(DateUtils.parseDate(flightInfoDto.getDepartureTime()))){
							lowestMap.put(LOW_SEAT_KEY, seatDto);
							seatMap.put(LOW_SEAT_KEY, flightInfoDto);
						}
					}
				} else {
					lowestMap.put(LOW_SEAT_KEY, seatDto);
					seatMap.put(LOW_SEAT_KEY, flightInfoDto);
				}
				List<FlightSearchSeatDto> seats = new ArrayList<FlightSearchSeatDto>();
				if( null != seatMap.get(LOW_SEAT_KEY).getSeats()){
					seats = seatMap.get(LOW_SEAT_KEY).getSeats();
				}
				Collections.sort(seats, new Comparator<FlightSearchSeatDto>() {//航班的舱位进行排序
					  @Override
					public int compare(FlightSearchSeatDto seat0, FlightSearchSeatDto seat1) {
			                BigDecimal price0 = seat0.getSalesPrice();
			                BigDecimal price1 = seat1.getSalesPrice();
			                if (price1.compareTo(price0) <0) {  
			                    return 1;  
			                } else if (price1.equals(price0)) {  
			                    return 0;  
			                } else {  
			                    return -1;  
			                }  
			            } 
				 });
			 }
			 flightInfolist.clear();
			 flightInfolist.add(seatMap.get(LOW_SEAT_KEY));
			 seatMap.clear();
			 lowestMap.clear();
			 flightResult.setResults(flightInfolist);
			 resultlist.add(flightResult);
		 }
	  return resultlist;
		 
	 }
	 
	 
	 /**
	  * 根据搜索条件获取往返的航班列表
	  * 
	  * */
	 @Override
	 public FitSearchResult queryToBackFlights(FitSearchRequest request){
		 FitSearchResult fitSearchResult = this.searchResult(request);
		 List<FlightSearchResult<FlightSearchFlightInfoDto>>  searchResults = fitSearchResult.getFlightSearchResult();
		 searchResults = this.handleFlights(request, searchResults);
		 fitSearchResult.setFlightSearchResult(searchResults);
		 return fitSearchResult;
	 }
	 
	/**
	 * 
	 * @param fitSearchRequest
	 * @return
	 */
	private TaskContext initTaskContext(FitSearchRequest fitSearchRequest){
		TaskContext taskContext = new TaskContext();
		String traceNo = TraceContext.getTraceId();
		Map<String,Object> taskMap = new HashMap<String, Object>();
		taskMap.put(FitBusinessType.FIT_Q_T.name(), fitSearchRequest.getFlightSearchRequests().get(0));
		if(fitSearchRequest.getFlightSearchRequests().size()>1){
			taskMap.put(FitBusinessType.FIT_Q_R.name(), fitSearchRequest.getFlightSearchRequests().get(1));
		}
		if(CollectionUtils.isNotEmpty(fitSearchRequest.getHotelSearchRequests())){
			HotelQueryRequest hotelQueryRequest = fitSearchRequest.getHotelSearchRequests().get(0);
			hotelQueryRequest.setQueryId(fitSearchRequest.getShoppingId());
			List<HotelQueryRequest> hotelRequests = fitSearchRequest.getHotelSearchRequests();
			int roomCount = HotelUtils.getMinRoomCount(fitSearchRequest.getFitPassengerRequest().getAdultCount(), fitSearchRequest.getFitPassengerRequest().getChildCount());
			//将房间数传到接口里
			for(HotelQueryRequest hotelRequest:hotelRequests){
				hotelRequest.setRoomCounts(roomCount);
			}
			fitSearchRequest.setHotelSearchRequests(hotelRequests);
			taskMap.put(FitBusinessType.FIT_Q_H.name(), hotelQueryRequest);
		}
		if (CollectionUtils.isNotEmpty(fitSearchRequest.getSpotQueryRequests())) {
		    SpotQueryRequest sqr = fitSearchRequest.getSpotQueryRequests().get(0);
		    taskMap.put(FitBusinessType.FIT_Q_S.name(), sqr);
		}
		if (null != fitSearchRequest.getInsuranceQueryRequest()) {
			InsuranceQueryRequest request =  fitSearchRequest.getInsuranceQueryRequest();
			taskMap.put(FitBusinessType.FIT_QUERY_INSURANCE.name(), request);
		}
		
		taskContext.put("taskMap", taskMap);
		taskContext.put("traceId",traceNo);
		return taskContext;
	}
	
	/**
	 * 更换航班
	 * 
	 * */
	@Override
	public FitSearchResult flightChangeSearch(String uuid,String method) {

		FitSearchResult fitSearchResult = new FitSearchResult();
		List<FlightSearchResult<FlightSearchFlightInfoDto>> flightResultList = new ArrayList<FlightSearchResult<FlightSearchFlightInfoDto>>();
		FlightSearchResult<FlightSearchFlightInfoDto> flightSearchResult = new FlightSearchResult<FlightSearchFlightInfoDto>();
		
		FitShoppingDto fitShoppingDto = shoppingService.getFitShopping(uuid);
		if(null == fitShoppingDto){
			throw new ExceptionWrapper(UUID_IS_NULL_IN_CACHE, ExceptionCode.GET_NO_CACHE_SHOPPING);
		}
		FitSearchRequest request = fitShoppingDto.getSearchRequest();
		FlightQueryRequest flightQueryRequest;
		FlightSearchFlightInfoDto flightSearchFlightInfoDto;
		if("to".equals(method)){
			flightQueryRequest = request.getFlightSearchRequests().get(0);
			flightSearchFlightInfoDto = fitShoppingDto.getFlightInfos().get(0);
		} else {
			flightQueryRequest = request.getFlightSearchRequests().get(1);
			flightSearchFlightInfoDto = fitShoppingDto.getFlightInfos().get(1);
		}
		try {
			flightSearchResult = fitAggregateClient.searchFlightInfo(flightQueryRequest);
		} catch (Exception e) {
			logger.error("获取航班列表失败:",e);
			FitOpLogTraceContext.setFitOpLog(flightQueryRequest,e, TraceContext.getTraceId(), FitBusinessExceptionType.CHG_FLI_E);
		} 
		if(flightSearchResult != null){
			flightResultList.add(flightSearchResult);
			flightResultList = this.filterFlight(flightResultList);
			List<FlightSearchFlightInfoDto> flightinfos = flightSearchResult.getResults();
			List<FlightSearchFlightInfoDto> flightinfosNew = new ArrayList<FlightSearchFlightInfoDto>();
			for(FlightSearchFlightInfoDto flightinfoDto :flightinfos){
				flightinfoDto = SearchResultUtil.isAvailableSeat(flightinfoDto, request);
				if(CollectionUtils.isNotEmpty(SearchResultUtil.getYCFLowPriceSeats(flightinfoDto))){
					flightinfoDto.setSeats(SearchResultUtil.getYCFLowPriceSeats(flightinfoDto));
					flightinfosNew.add(flightinfoDto);
				}
			}
			Collections.sort(flightinfosNew, new Comparator<FlightSearchFlightInfoDto>() {//对每个航班进行排序
				  @Override
				public int compare(FlightSearchFlightInfoDto flightinfo1, FlightSearchFlightInfoDto flightinfo2) { 
					 BigDecimal price1 = new BigDecimal(0);
					 BigDecimal price2 = new BigDecimal(0);
					 price1 = flightinfo1.getSeats().get(0).getSalesPrice();
					 price2 = flightinfo2.getSeats().get(0).getSalesPrice();
		              if (price1.compareTo(price2) >0) { 
		                    return 1;  
		                } else if (price1.equals(price1)) {  
		                    return 0;  
		                } else {  
		                    return -1;  
		                }  
		            } 
			 });
			//对每个航班的舱位进行排序
			for(FlightSearchFlightInfoDto flightinfoDto:flightinfosNew){
				List<FlightSearchSeatDto> seats = new ArrayList<FlightSearchSeatDto>();
				seats = flightinfoDto.getSeats();
				Collections.sort(seats, new Comparator<FlightSearchSeatDto>() {//对每个航班的舱位进行排序
					  @Override
					public int compare(FlightSearchSeatDto seat0, FlightSearchSeatDto seat1) {
				      BigDecimal price0 = seat0.getSalesPrice();
				      BigDecimal price1 = seat1.getSalesPrice();
				      if (price1.compareTo(price0) <0) {  
				         return 1;  
				      } else if (price1.equals(price0)) {  
				         return 0;  
				      } else {  
				        return -1;  
				      }  
				    }  
				 });
			}
			
			List<FlightSearchSeatDto> oldSeats = flightSearchFlightInfoDto.getSeats();
			String seatClassCode = "" ;
			for (FlightSearchSeatDto flightSearchSeatDto : oldSeats) {
				if(flightSearchSeatDto.getSelectFlag()){
					seatClassCode = flightSearchSeatDto.getSeatClassCode();
				}
			}
			for (FlightSearchFlightInfoDto searchInfo : flightinfosNew) {
				if(flightSearchFlightInfoDto.getFlightNo().equals(searchInfo.getFlightNo())){
					for(FlightSearchSeatDto fss : searchInfo.getSeats()){
						if(fss.getSeatClassCode().equals(seatClassCode)){
							fss.setSelectFlag(true);
						}
					}
				}
			}
			
			flightSearchResult.setResults(flightinfosNew);
			
			List<FlightSearchResult<FlightSearchFlightInfoDto>> list = new ArrayList<FlightSearchResult<FlightSearchFlightInfoDto>>();
			list.add(flightSearchResult);
			fitSearchResult.setFlightSearchResult(list);
			fitSearchResult.setSearchRequest(request);

			shoppingService.putFlightSearchResult(request.getShoppingId(),fitSearchResult);
			
			return fitSearchResult;
		}
		return null;
	}


    /**
     * 过滤得到可售的酒店
     */
	@Override
	public List<HotelSearchResult<HotelSearchHotelDto>> getDefaultHotelInfo(List<HotelSearchResult<HotelSearchHotelDto>> hotelList,FitSearchRequest request) {
		
		List<HotelQueryRequest> hotelQuerys = request.getHotelSearchRequests();
		Long days = 0L;
		HotelQueryRequest hotelRequest = new HotelQueryRequest();
		if(CollectionUtils.isNotEmpty(hotelQuerys)){
			hotelRequest = hotelQuerys.get(0);
			if(null != hotelRequest){
				days = DateUtils.getDateDiffByDay(hotelRequest.getDepartureDate(), hotelRequest.getReturnDate());
			}
		}
		List<HotelSearchHotelDto> hoteldtos = new ArrayList<HotelSearchHotelDto>();
		List<HotelSearchHotelDto> availablehotels = new ArrayList<HotelSearchHotelDto>();
		for(HotelSearchResult<HotelSearchHotelDto> hotelresult:hotelList){//实际上只会有一个元素
			hoteldtos=hotelresult.getResults();//获取到的是酒店列表
			for (HotelSearchHotelDto hotelDto:hoteldtos){//判断酒店房间下面是否有plan,如果没有，将该room视为无效
				List<HotelSearchRoomDto> availableRooms = new ArrayList<HotelSearchRoomDto>();
				List<HotelSearchRoomDto> rooms = hotelDto.getRooms();
				for(HotelSearchRoomDto room:rooms){
					List<HotelSearchPlanDto> availablePlans = new ArrayList<HotelSearchPlanDto>();
					for(HotelSearchPlanDto plan:room.getPlans()){
						if(CollectionUtils.isNotEmpty(plan.getDayPrice()) && plan.getDayPrice().size() >= days){//去除没有价格的plan
							availablePlans.add(plan);
						} 
					}
					if(CollectionUtils.isNotEmpty(availablePlans)){
						room.setPlans(availablePlans);
						availableRooms.add(room);
					}
				}
				if(CollectionUtils.isNotEmpty(availableRooms)){
					hotelDto.setRooms(availableRooms);
					availablehotels.add(hotelDto);
				}
		}
			if(CollectionUtils.isNotEmpty(availablehotels)){//酒店列表
				hotelresult.setResults(availablehotels);
				hotelList.add(hotelresult);
				if(CollectionUtils.isNotEmpty(hotelList)){
					return getSortedHotels(hotelList);
				}
			}
	}
		
		return null;
}
	
	public List<HotelSearchResult<HotelSearchHotelDto>> getSortedHotels(List<HotelSearchResult<HotelSearchHotelDto>> hotelList) {
		for(HotelSearchResult<HotelSearchHotelDto> hotelSearchResult:hotelList){
			List<HotelSearchHotelDto> hotels = hotelSearchResult.getResults();
			for(HotelSearchHotelDto hotelDto:hotels){
				List<HotelSearchRoomDto> rooms = hotelDto.getRooms();
				for(HotelSearchRoomDto room:rooms){
					List<HotelSearchPlanDto> plans = room.getPlans();
					if(plans != null && plans.size() >1){//多于1个才有必要排序
						 Collections.sort(plans, new Comparator<HotelSearchPlanDto>() {//对每个房间的plan进行排序
							  @Override
							public int compare(HotelSearchPlanDto plan0, HotelSearchPlanDto plan1) {  
					                BigDecimal price0 = plan0.getDayPrice().get(0).getSettlePrice();
					                BigDecimal price1 = plan1.getDayPrice().get(0).getSettlePrice();
					                if (price1.compareTo(price0) <0) { 
					                    return 1;  
					                } else if (price1.equals(price0)) {  
					                    return 0;  
					                } else {  
					                    return -1;  
					                }  
					            } 
						 });
						 room.setPlans(plans);
					}
				}
				if(rooms != null && rooms.size() >1){
					Collections.sort(rooms, new Comparator<HotelSearchRoomDto>() {//对每个酒店的房间进行排序
						  @Override
						public int compare(HotelSearchRoomDto room0, HotelSearchRoomDto room1) {  
				                BigDecimal price0 = room0.getPlans().get(0).getDayPrice().get(0).getSettlePrice();
				                BigDecimal price1 = room1.getPlans().get(0).getDayPrice().get(0).getSettlePrice(); 
				                if (price1.compareTo(price0) <0) {  
				                    return 1;  
				                } else if (price1.equals(price0)) {  
				                    return 0;  
				                } else {  
				                    return -1;  
				                }  
				            } 
					 });
				}
				 hotelDto.setRooms(rooms);
			}
			hotelSearchResult.setResults(hotels);
		}
		return hotelList;
	} 
	/**
	 * 更换酒店
	 */
	@Override
	public FitSearchResult hotelChangeSearch(FitSearchRequest request) {
		
		FitSearchResult fitSearchResult = new FitSearchResult();
		HotelQueryRequest hotelQueryRequest = request.getHotelSearchRequests().get(0);
		HotelSearchResult<HotelSearchHotelDto> hotelSearchResult = new HotelSearchResult<HotelSearchHotelDto>();
		
		//1. 根据新的查询条件调用酒店接口
		try {
			hotelSearchResult = fitAggregateClient.searchHotelInfo(hotelQueryRequest);
		} catch (Exception e) {
			logger.error("更换酒店时未能查到酒店数据",e);
			FitOpLogTraceContext.setFitOpLog(request,e, TraceContext.getTraceId(), FitBusinessExceptionType.CHG_HOTEL_E);
		}
		
		//2. 对酒店数据进行过滤
		if(null != hotelSearchResult){
			List<HotelSearchResult<HotelSearchHotelDto>> hotellist = new ArrayList<HotelSearchResult<HotelSearchHotelDto>>();
			if(hotelQueryRequest.getParams().equals("P1")&&null==hotelQueryRequest.getKeywords()){
				FitShoppingDto fitShopping = shoppingService.getFitShopping(request.getShoppingId());
				List<HotelSearchHotelDto> recommendedHotels = fitShopping.getRecommendedHotels();
				List<HotelSearchHotelDto> newRecommendHotels = new ArrayList<HotelSearchHotelDto>();
				List<HotelSearchHotelDto> results = hotelSearchResult.getResults();
				if(CollectionUtils.isNotEmpty(recommendedHotels)){
					for (HotelSearchHotelDto hotelSearchHotelDto : recommendedHotels) {
						if(results.contains(hotelSearchHotelDto)){
							newRecommendHotels.add(hotelSearchHotelDto);
						}
					}
				}
				results.addAll(newRecommendHotels);
				hotelSearchResult.setResults(results);
				shoppingService.putHotelCondition(request.getShoppingId(), (Map<String, Object>) hotelSearchResult.getFacetMap().get(HotelFacetType.selectMap));
			}
			hotellist.add(hotelSearchResult);
			fitSearchResult.setHotelSearchResult(hotellist);
			shoppingService.putHotelSearchResult(request.getShoppingId(),fitSearchResult.getHotelSearchResult().get(0).getResults());
			return fitSearchResult;
			
		}
		return null;
	}

    @Override
    public HotelSearchResult<HotelSearchHotelDto> searchHotelInfos(FitAppHotelRequest request) {
        HotelQueryRequest hotelQueryReq = new HotelQueryRequest();
        hotelQueryReq.setKeywords(request.getKeywords());

        String cityCode = request.getCityCode();
        VSTDistrictCityEnum cityEnum = VSTDistrictCityEnum.valueOf(cityCode);
        hotelQueryReq.setCityCode(cityCode);
        hotelQueryReq.setCityName(cityEnum.getCnName());
        hotelQueryReq.setCityDistrictId(cityEnum.getDistrictId().toString());

        hotelQueryReq.setDepartureDate(request.getDepartureDate());
        hotelQueryReq.setReturnDate(request.getReturnDate());
        hotelQueryReq.setParams(StringUtils.isNotEmpty(request.getParams())? request.getParams() : "P1");
        hotelQueryReq.setQueryId(request.getQueryId());
        hotelQueryReq.setHotelFromRecommendedOnly(request.getHotelFromRecommendedOnly());
        hotelQueryReq.setAdultCount(request.getAdultCount());

        int roomCount = HotelUtils.getMinRoomCount(request.getAdultCount(), request.getChildCount());
        hotelQueryReq.setRoomCounts(roomCount);


        //1. 根据新的查询条件调用酒店接口
        HotelSearchResult<HotelSearchHotelDto> hotelSearchResult = fitAggregateClient.searchHotelInfo(hotelQueryReq);

        if (hotelSearchResult == null || CollectionUtils.isEmpty(hotelSearchResult.getResults())) {
            throw new ExceptionWrapper(FitExceptionCode.FIT_NO_HOTEL_RESULT);
        }

        List<HotelSearchHotelDto> returnList = new ArrayList<HotelSearchHotelDto>();

        //2. 对酒店数据进行过滤
        if(hotelQueryReq.getParams().contains("P1") && null == hotelQueryReq.getKeywords()) {
            try {
                StringBuilder sb = new StringBuilder();
                List<FitConRecomHotelDto> recomHotelsAll = fitBusinessClient.getFitConRecomHotelsAll();
                for (FitConRecomHotelDto recomHotel : recomHotelsAll) {
                    if (recomHotel.getDistrictCityId() != null
                        && recomHotel.getDistrictCityId().toString().equals(hotelQueryReq.getCityDistrictId())) {
                        sb.append(recomHotel.getProductId()).append(",");
                    }
                }
                if (StringUtils.isNotEmpty(sb.toString())) {
                    String productIds = sb.toString().substring(0, sb.toString().length() - 1);
                    hotelQueryReq.setKeywords(productIds);
                    HotelSearchResult<HotelSearchHotelDto> recomHotelResult = fitAggregateClient.searchHotelInfo(hotelQueryReq);
                    if (recomHotelResult != null && CollectionUtils.isNotEmpty(recomHotelResult.getResults())) {
                        returnList.addAll(recomHotelResult.getResults()); // 添加推荐酒店信息
                        for (HotelSearchHotelDto hotelDto : hotelSearchResult.getResults()) { // 添加去掉推荐酒店后的酒店信息
                            for (HotelSearchHotelDto recomHotelDto : recomHotelResult.getResults()) {
                                if (!hotelDto.getProductId().equals(recomHotelDto.getProductId())) {
                                    returnList.add(hotelDto);
                                }
                            }
                        }
                        hotelSearchResult.setResults(returnList);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Long days = DateUtils.getDateDiffByDay(request.getReturnDate(), request.getDepartureDate());
        List<HotelSearchHotelDto> hotelList = filterHotel(days, hotelSearchResult.getResults());
        this.setHotelRoomCount(hotelList, request.getAdultCount(), request.getChildCount());
        hotelSearchResult.setResults(hotelList);
        return hotelSearchResult;
    }

    /**
     * 过滤价格为空的酒店信息
     * @param days
     * @param hotels
     * @return
     */
    private List<HotelSearchHotelDto> filterHotel(Long days, List<HotelSearchHotelDto> hotels) {
        List<HotelSearchHotelDto> filterHotels = new ArrayList<HotelSearchHotelDto>();
        for (HotelSearchHotelDto hotel : hotels) {
            if (CollectionUtils.isNotEmpty(hotel.getRooms())) {
                List<HotelSearchRoomDto> roomList = new ArrayList<HotelSearchRoomDto>();
                for (HotelSearchRoomDto room : hotel.getRooms()) {
                    if (CollectionUtils.isNotEmpty(room.getPlans())) {
                        List<HotelSearchPlanDto> planList = new ArrayList<HotelSearchPlanDto>();
                        for (HotelSearchPlanDto plan : room.getPlans()) {
                            if(CollectionUtils.isNotEmpty(plan.getDayPrice()) && plan.getDayPrice().size() == days){
                                planList.add(plan);
                            }
                        }

                        if (CollectionUtils.isNotEmpty(planList)) {
                            room.setPlans(planList);
                            roomList.add(room);
                        }
                    }
                }

                if (CollectionUtils.isNotEmpty(roomList)) {
                    hotel.setRooms(roomList);
                    filterHotels.add(hotel);
                }
            }
        }

        return filterHotels;
    }

    /**
     * 设置房间最大最小间数，房间数
     */
    private void setHotelRoomCount(List<HotelSearchHotelDto> hotels, int adultCount, int childCount) {
        int roomcount = HotelUtils.getMinRoomCount(adultCount, childCount);
        for (HotelSearchHotelDto hotel : hotels) {
            for (HotelSearchRoomDto room : hotel.getRooms()) {
                room.setRoomCounts(roomcount);
                for (HotelSearchPlanDto plan : room.getPlans()) {
                    int maxQuantity = plan.getMaxQuantity();
                    List<FitHotelPlanPriceDto> dayPrice = plan.getDayPrice();
                    int minInventory = dayPrice.get(0).getInventoryCount();
                    for (FitHotelPlanPriceDto planPrice : dayPrice) {
                        if (planPrice.getInventoryCount() < minInventory) {
                            minInventory = planPrice.getInventoryCount();
                        }
                    }
                    int maxCount = minInventory < maxQuantity ? minInventory : maxQuantity;
                    maxCount = maxCount < adultCount ? maxCount : adultCount;
                    plan.setMaxQuantity(maxCount);
                }
            }
        }
    }


    /**
	 * 请求酒店接口
	 */
	@Override
	public List<HotelSearchHotelDto> hotelSearch(HotelQueryRequest hotelQueryRequest){
			
	    HotelSearchResult<HotelSearchHotelDto> hotelSearchResult = fitAggregateClient.searchHotelInfo(hotelQueryRequest);
		if(null != hotelSearchResult && CollectionUtils.isNotEmpty(hotelSearchResult.getResults())){
		    return hotelSearchResult.getResults();
		}
		throw new ExceptionWrapper(ExceptionCode.GET_HOTEL_PRICE_FAIL);
	}
	
	public FitShoppingDto getShoppingResult(FitSearchRequest request){
        FitShoppingDto shoppingDto =  new FitShoppingDto();
        
        String shoppingUUID = this.search(request);
        if(null == shoppingUUID){//没有查到数据
            logger.error("没有查到数据");
            throw new ExceptionWrapper(UUID_IS_NULL, ExceptionCode.GET_NO_RESULT);
        } else {
            shoppingDto = shoppingService.getFitShopping(shoppingUUID);
            if(null == shoppingDto){//没能够从缓存中获得数据
                logger.error("从缓存中加载信息失败");
                throw new ExceptionWrapper(UUID_IS_NULL_IN_CACHE, ExceptionCode.GET_NO_CACHE_SHOPPING);
            }
        }
        
        return shoppingDto;
	}
	
	/**
	 * @param context
	 * @return
	 */
	private TaskMainGroup<FitSearchResult> initTaskGroup(TaskContext context) {
		
		//组装查询信息任务组
		TaskGroup flightSelectInfoGroup = this.generatorSelectInfoTaskGroup(context);
		//组装MainGroup
		TaskMainGroup<FitSearchResult> mainGroup = new TaskMainGroup<FitSearchResult>();
		//加入主任务组
	    mainGroup.addGroup(flightSelectInfoGroup);
	    //购物主任务组执行任务
		mainGroup.putContext(context).putGetResult(new Task<FitSearchResult>() {
			@SuppressWarnings({ "unchecked" })
			@Override
			public FitSearchResult execute(TaskContext context) {
				FitSearchResult fitSearchResult = new FitSearchResult();
				List<FlightSearchResult<FlightSearchFlightInfoDto>> flightlist = new ArrayList<FlightSearchResult<FlightSearchFlightInfoDto>>();
				List<HotelSearchResult<HotelSearchHotelDto>> hotellist = new ArrayList<HotelSearchResult<HotelSearchHotelDto>>();
				List<SpotSearchResult<SpotSearchSpotDto>> spotList = new ArrayList<SpotSearchResult<SpotSearchSpotDto>>();
				InsuranceSearchResult<InsuranceDto> insuranceResult = new InsuranceSearchResult<InsuranceDto>();
				List<InsuranceInfoDto> flightInsuranceResult = new ArrayList<InsuranceInfoDto>();
				String recomHotelId = "";
				
				flightlist.add((FlightSearchResult<FlightSearchFlightInfoDto>)context.get(FitBusinessType.FIT_Q_T.name()));
				FlightSearchResult<FlightSearchFlightInfoDto> returnFlight = (FlightSearchResult<FlightSearchFlightInfoDto>)context.get(FitBusinessType.FIT_Q_R.name());
				flightlist.add(returnFlight==null?new FlightSearchResult<FlightSearchFlightInfoDto>():returnFlight);
				
				hotellist.add((HotelSearchResult<HotelSearchHotelDto>)context.get(FitBusinessType.FIT_Q_H.name()));
				spotList.add((SpotSearchResult<SpotSearchSpotDto>) context.get(FitBusinessType.FIT_Q_S.name()));
				insuranceResult = (InsuranceSearchResult<InsuranceDto>) context.get(FitBusinessType.FIT_QUERY_INSURANCE.name());
				flightInsuranceResult = (List<InsuranceInfoDto>) context.get(FitBusinessType.FIT_QUERY_FLIGHT_INSURANCE.name());
				recomHotelId = (String) context.get(CONFIG_RECOMHOTEL_ID);
				
				fitSearchResult.setFlightSearchResult(flightlist);
				fitSearchResult.setHotelSearchResult(hotellist);
				fitSearchResult.setSpotSearchResult(spotList);
				fitSearchResult.setInsuranceResult(insuranceResult);
				fitSearchResult.setFlightInsuranceResult(flightInsuranceResult);
				fitSearchResult.setRecomHotelId(recomHotelId);
				return fitSearchResult;
			}
		});
		return mainGroup;
	}
	
	/**
	 * 组装线程组
	 * @param context
	 * @param
	 * @return
	 */
	private TaskGroup generatorSelectInfoTaskGroup(TaskContext context) {
		TaskGroup hotelAndFligthGroup = new TaskGroup();
		@SuppressWarnings("unchecked")
		Map<String, Object> taskMap = (Map<String, Object>) context.get("taskMap");
		final String mainTraceId = TraceContext.getTraceId();
		for(Map.Entry<String, Object> entry : taskMap.entrySet()){
			final String taskName = entry.getKey();
			final Object request= entry.getValue();
			hotelAndFligthGroup.addTask(new Task<Boolean>() {

				@Override
				public Boolean execute(TaskContext context) {
					
					TraceContext.setTraceId(mainTraceId);
					if(request instanceof HotelQueryRequest) {
						HotelSearchResult<HotelSearchHotelDto> hotelSearchResult = new HotelSearchResult<HotelSearchHotelDto>();
						HotelQueryRequest hotelRequest = (HotelQueryRequest)request;
						String key ="";
						String recomHotelId ="";
						try{
							List<FitConRecomHotelDto> list = FitConRecomHotelConfig.dbMaps.get(Long.valueOf(hotelRequest.getCityDistrictId()));
							if(CollectionUtils.isNotEmpty(list)){
								for(FitConRecomHotelDto dto:list){
									key = key+dto.getProductId()+",";
									if(dto.getIsDefault().equals(SymbolType.Y)){
										recomHotelId = recomHotelId+dto.getProductId();
									}
								}
							}
							if((!"".equals(key))&&key.lastIndexOf(",") == key.length()-1){
								key = key.substring(0, key.length()-1);
							}
							if(StringUtils.isNotBlank(key)){
								hotelRequest.setKeywords(key);	
							}
						}catch(Exception e){
						    logger.error("获取推荐酒店异常:",e);
						}
						if(("".equals(key) || null == key)&&hotelRequest.getHotelFromRecommendedOnly()){
							context.put(taskName,hotelSearchResult);
							context.put(CONFIG_RECOMHOTEL_ID, recomHotelId);
							return true;
						} else {
							try {
								hotelSearchResult = fitAggregateClient.searchHotelInfo(hotelRequest);
								//如果默认推荐的酒店没有数据，配置的参数没有要求必须是推荐的酒店时，放宽搜索条件
								FitSearchRequest fitSearchRequest = new FitSearchRequest();
								List<HotelQueryRequest> hotelSearchRequests = new ArrayList<HotelQueryRequest>();
								hotelSearchRequests.add(hotelRequest);
								fitSearchRequest.setHotelSearchRequests(hotelSearchRequests);
								List<HotelSearchResult<HotelSearchHotelDto>> hotelResults = new ArrayList<HotelSearchResult<HotelSearchHotelDto>>();
								hotelResults.add(hotelSearchResult);
								hotelResults = getDefaultHotelInfo(hotelResults,fitSearchRequest);
								if((hotelSearchResult == null || CollectionUtils.isEmpty(hotelResults) || CollectionUtils.isEmpty(hotelSearchResult.getResults()))&&!hotelRequest.getHotelFromRecommendedOnly()){
									hotelRequest.setKeywords(null);
									hotelSearchResult = fitAggregateClient.searchHotelInfo(hotelRequest);
								}
							} catch (Exception e) {
							    logger.error("酒店接口调用异常",e);
							    RequestWithException requestWithException = new RequestWithException(e, request);
							    context.put(FitBusinessType.valueOf(taskName).getBusinessExceptionType().name(), requestWithException);
							} 
						}
						context.put(taskName,hotelSearchResult);
						context.put(CONFIG_RECOMHOTEL_ID, recomHotelId);
					} else if (request instanceof FlightQueryRequest) {
						FlightSearchResult<FlightSearchFlightInfoDto> flightSearchResult = new FlightSearchResult<FlightSearchFlightInfoDto>();
						FlightQueryRequest fligthRequest = (FlightQueryRequest)request;
						try {
							flightSearchResult = fitAggregateClient.searchFlightInfo(fligthRequest);
						} catch (Exception e) {
							logger.error(taskName+"异常",e);
							RequestWithException requestWithException = new RequestWithException(e, request);
							context.put(FitBusinessType.valueOf(taskName).getBusinessExceptionType().name(), requestWithException);
						}
						context.put(taskName,flightSearchResult);
						
						// 当机票查询结果不为空时，查询机票航意险
                        if (flightSearchResult != null) {
                            try {
                                List<InsuranceInfoDto> flightInsurances = fitAggregateClient.searchFlightInsurance();
                                context.put(FitBusinessType.FIT_QUERY_FLIGHT_INSURANCE.name(), flightInsurances);
                            } catch (Exception e) {
                                context.put(FitBusinessExceptionType.FIT_QUERY_FLIGHT_INSURANCE_E.name(), new RequestWithException(e, null));
                            }
                        }
                    } else if (request instanceof SpotQueryRequest) {
                        SpotSearchResult<SpotSearchSpotDto> spotSearchResult = new SpotSearchResult<SpotSearchSpotDto>();
                        try {
                            spotSearchResult = fitAggregateClient.searchSpot((SpotQueryRequest) request);
                        } catch (Exception e) {
                            logger.error("门票接口调用异常", e);
                        	RequestWithException requestWithException = new RequestWithException(e, request);
                            context.put(FitBusinessType.valueOf(taskName).getBusinessExceptionType().name(), requestWithException);
                        }
                        context.put(taskName, spotSearchResult);
                    } else if (request instanceof InsuranceQueryRequest) {
                    	InsuranceSearchResult<InsuranceDto> insuranceSearchResult = new InsuranceSearchResult<InsuranceDto>();
                        try {
                            insuranceSearchResult = fitAggregateClient.searchInsuranceFromVst((InsuranceQueryRequest) request);
                        } catch (Exception e) {
                            logger.error("保险接口调用异常", e);
                        	RequestWithException requestWithException = new RequestWithException(e, request);
                            context.put(FitBusinessType.valueOf(taskName).getBusinessExceptionType().name(), requestWithException);
                        }
                        context.put(taskName, insuranceSearchResult);
                    }
					return true;
				}
				
			});
		}
		return hotelAndFligthGroup;
	}
	
	/**
	 * 对航班结果集进行处理
	 * @param request
	 * @param list
	 * @return
	 */
	private List<FlightSearchResult<FlightSearchFlightInfoDto>> handleFlights(
			FitSearchRequest request,
			List<FlightSearchResult<FlightSearchFlightInfoDto>> list) {
		list = getAvailableSeats(list,request);
		list = this.filterFlight(list);
		//结果集中，每个航班只留一个YFC舱
		list = this.getSortedFlightList(list);
		//对结果集再进行处理，对去程和返程，各返回一个符合条件的航班，页面上的要求为 
		//调机票航班查询接口，默认价格为最低价的往返航班，如存在多组往返航班价格相同，取去程和回程最早的起飞时间一组。
		list = this.getLowestList(list);
		//把优惠金额为负数的过滤 
		return list;
	}

	/**
	 * 过滤优惠价格为负数的航班
	 * @param list
	 * @return
	 */
	private List<FlightSearchResult<FlightSearchFlightInfoDto>> filterFlight(
			List<FlightSearchResult<FlightSearchFlightInfoDto>> list) {
		List<FlightSearchResult<FlightSearchFlightInfoDto>> resultlist = new ArrayList<FlightSearchResult<FlightSearchFlightInfoDto>>();
		 
		 for(FlightSearchResult<FlightSearchFlightInfoDto> flightResult:list){
			 List<FlightSearchFlightInfoDto> flightInfolist= flightResult.getResults();
			 List<FlightSearchFlightInfoDto> newFlightInfo = new ArrayList<FlightSearchFlightInfoDto>();
			 if(CollectionUtils.isNotEmpty(flightInfolist)){
				 for(FlightSearchFlightInfoDto flightInfoDto:flightInfolist){
					 List<FlightSearchSeatDto> seats = flightInfoDto.getSeats();
					 List<FlightSearchSeatDto> newFlightSeat = new ArrayList<FlightSearchSeatDto>();
					 for (FlightSearchSeatDto flightSearchSeatDto : seats) {
						 FitFlightTicketPriceDto flightTicketPriceDto = flightSearchSeatDto.getFlightTicketPriceDto();
						 if(flightTicketPriceDto.getPromotion().compareTo(BigDecimal.ZERO)>=0){
							 newFlightSeat.add(flightSearchSeatDto);
						 }
					}
					if(CollectionUtils.isNotEmpty(newFlightSeat)){
						flightInfoDto.setSeats(newFlightSeat);
						newFlightInfo.add(flightInfoDto);
					}
				 }
				 flightResult.setResults(newFlightInfo);
				 resultlist.add(flightResult);
			 }
		 }
		 return resultlist;
	}

	/**
	 * 检索景点门票
	 * */
	public SpotSearchResult<SpotSearchSpotDto> searchSpotTicket(SpotQueryRequest spotQueryRequest){
		
		SpotSearchResult<SpotSearchSpotDto> searchResult = new SpotSearchResult<SpotSearchSpotDto>();
		searchResult = fitAggregateClient.searchSpot(spotQueryRequest);
		return searchResult;
	}

	@Override
	public FlightSearchResult<FlightSearchFlightInfoDto> handleFlights(FlightSearchResult<FlightSearchFlightInfoDto> searchResult) {
		FitSearchRequest request = new FitSearchRequest();
		FitPassengerRequest fitPassengerRequest = new FitPassengerRequest();
		fitPassengerRequest.setAdultCount(1);
		fitPassengerRequest.setChildCount(0);
		request.setFitPassengerRequest(fitPassengerRequest);
		List<FlightSearchResult<FlightSearchFlightInfoDto>> list = new ArrayList<FlightSearchResult<FlightSearchFlightInfoDto>>();
		list.add(searchResult);
		return this.handleFlights(request, list).get(0);
	}

    /**
     * 查询机票信息，并处理结果集
     * @param tripeType
     * @param departureDate
     * @param returnDate
     * @param depCityCode
     * @param arvCityCode
     * @param bookingSource
     * @return
     */
    @Override
    public Map<String,FlightSearchResult<FlightSearchFlightInfoDto>> getAllFlightInfos(TripeType tripeType,
        String departureDate, String returnDate, String depCityCode, String arvCityCode, BookingSource bookingSource) {
        Map<String,FlightSearchResult<FlightSearchFlightInfoDto>> map = new HashMap<String, FlightSearchResult<FlightSearchFlightInfoDto>>();

        Map<String, Object> requestMap = this.genFlightRequestMap(tripeType, departureDate, returnDate, depCityCode, arvCityCode,
            bookingSource);
        TaskMainGroup<Boolean> mainGroup = new TaskMainGroup<Boolean>();
        final TaskContext context = new TaskContext();

        for (Map.Entry<String, Object> entry : requestMap.entrySet()) {
            final String key = entry.getKey();
            final Object request = entry.getValue();
            mainGroup.addTask(new Task<Boolean>() {
                @Override
                public Boolean execute(TaskContext taskContext) {
                    // 机票查询
                    if (request instanceof FlightQueryRequest) {
                        context.put(key, fitAggregateClient.searchFlightInfo((FlightQueryRequest) request));
                    }
                    return true;
                }
            });
        }
        mainGroup.putContext(context).getResult(requestMap.keySet().size());

        FlightSearchResult<FlightSearchFlightInfoDto> depFlightInfos = (FlightSearchResult<FlightSearchFlightInfoDto>)context.get(
            FlightTripType.DEPARTURE.name());

        FitSearchRequest searchRequest = new FitSearchRequest();


        map.put(FlightTripType.DEPARTURE.name(), depFlightInfos);
        if (tripeType.equals(TripeType.WF)) {
            FlightSearchResult<FlightSearchFlightInfoDto> arvFlightInfos =
                (FlightSearchResult<FlightSearchFlightInfoDto>) context.get(FlightTripType.RETURN.name());
            map.put(FlightTripType.RETURN.name(), arvFlightInfos);
        }
        return map;
    }

    private Map<String, Object> genFlightRequestMap(TripeType tripeType, String departureDate, String returnDate,
        String depCityCode, String arvCityCode, BookingSource bookingSource) {
        Map<String, Object> requestMap = new HashMap<String, Object>();

        FlightQueryRequest toFlightQuery = new FlightQueryRequest();
        toFlightQuery.setDepartureDate(DateUtils.parseDate(departureDate));
        toFlightQuery.setReturnDate(returnDate);
        toFlightQuery.setDepartureCityCode(depCityCode);
        toFlightQuery.setArrivalCityCode(arvCityCode);
        toFlightQuery.setDepartureAirportCode(depCityCode);
        toFlightQuery.setArrivalAirportCode(arvCityCode);
        toFlightQuery.setBookingSource(bookingSource);
        toFlightQuery.setFacet(true);
        requestMap.put(FlightTripType.DEPARTURE.name(), toFlightQuery);
        if (tripeType.equals(TripeType.WF)) {
            FlightQueryRequest backFlightQuery = new FlightQueryRequest();
            backFlightQuery.setDepartureDate(DateUtils.parseDate(returnDate));
            backFlightQuery.setReturnDate(departureDate);
            backFlightQuery.setDepartureCityCode(arvCityCode);
            backFlightQuery.setArrivalCityCode(depCityCode);
            backFlightQuery.setDepartureAirportCode(arvCityCode);
            backFlightQuery.setArrivalAirportCode(depCityCode);
            backFlightQuery.setBookingSource(bookingSource);
            backFlightQuery.setFacet(true);
            requestMap.put(FlightTripType.RETURN.name(), backFlightQuery);
        }
        return requestMap;
    }
}
