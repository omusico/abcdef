package com.lvmama.lvfit.dp.core.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.trace.TraceContext;
import com.lvmama.lvfit.common.aspect.exception.ExceptionPoint;
import com.lvmama.lvfit.common.dto.enums.FitBusinessExceptionType;
import com.lvmama.lvfit.common.dto.enums.SymbolType;
import com.lvmama.lvfit.common.dto.search.FitRecordSearchIndex;
import com.lvmama.lvfit.common.dto.trace.FitOpLogTraceContext;
import com.lvmama.lvfit.solrClient.extend.FitMainSearchSolrClient;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.enums.DefaultRule;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.exception.FitExceptionCode;
import com.lvmama.lvf.common.task.Task;
import com.lvmama.lvf.common.task.TaskContext;
import com.lvmama.lvf.common.task.TaskGroup;
import com.lvmama.lvf.common.task.TaskMainGroup;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.client.FitAggregateClient;
import com.lvmama.lvfit.common.client.FitBusinessClient;
import com.lvmama.lvfit.common.dto.app.FitAppHotelRequest;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.FitBusinessType;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.TripeType;
import com.lvmama.lvfit.common.dto.enums.VSTDistrictCityEnum;
import com.lvmama.lvfit.common.dto.hotel.FitConRecomHotelDto;
import com.lvmama.lvfit.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvfit.common.dto.price.FitFlightTicketPriceDto;
import com.lvmama.lvfit.common.dto.price.FitHotelPlanPriceDto;
import com.lvmama.lvfit.common.dto.request.FitBaseSearchRequest;
import com.lvmama.lvfit.common.dto.request.FitFilterFlightRequest;
import com.lvmama.lvfit.common.dto.request.FlightBackQueryRequest;
import com.lvmama.lvfit.common.dto.request.FlightToQueryRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.FlightQueryRequest;
import com.lvmama.lvfit.common.dto.search.flight.FlightSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.SearchResultUtil;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;
import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchPlanDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchRoomDto;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceQueryRequest;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;
import com.lvmama.lvfit.common.dto.search.spot.SpotQueryRequest;
import com.lvmama.lvfit.common.dto.search.spot.SpotSearchResult;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedInsuranceDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedTicketDto;
import com.lvmama.lvfit.common.dto.shopping.FlightInsuranceDto;
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
    FitMainSearchSolrClient fitMainSearchSolrClient;
	
	@Autowired
	ShoppingService shoppingService;

    @Autowired
    FitBusinessClient fitBusinessClient;

    @Value("getHotelFromRecommended")
    private String hotelFromRecommended;
	
	@Override
	public FitShoppingDto search(FitBaseSearchRequest request) {
        long start = System.currentTimeMillis();

        // 获取查询结果集
        FitSearchResult fitSearchResult = this.searchResult(request);
        // 处理返回结果集
        this.handleSearchResult(fitSearchResult, request.getAdultsCount(), request.getChildCount());
        // 构造购物车信息
        FitShoppingDto shoppingDto = this.genFitShoppingDto(request, fitSearchResult);
        // 将搜索记录计入solr
        long end = System.currentTimeMillis();
        this.saveIndexToSolr(request, shoppingDto, end - start);

        return shoppingDto;
	}

    private FitShoppingDto genFitShoppingDto(FitBaseSearchRequest request, FitSearchResult fitSearchResult) {
        FitShoppingDto shoppingDto = shoppingService.getFitShopping(request.getShoppingUUID());
        StringBuffer sb = new StringBuffer();
        final String split = "-";
        String requestKey = sb.append(request.getDepartureCityCode()).append(split)
            .append(request.getArrivalCityCode()).append(split)
            .append(request.getCityCode()).append(split)
            .append(request.getCheckInTime()).append(split)
            .append(request.getDepartureTime()).append(split)
            .append(request.getReturnTime()).append(split)
            .append(request.getAdultsCount()).append(split)
            .append(request.getChildCount())
            .append(request.getTripType())
            .toString();
        if (shoppingDto == null) {
            shoppingDto = new FitShoppingDto();
        } else {
            String oldRequestKey = shoppingDto.getRequestKey();
            if (oldRequestKey != null && !requestKey.equals(oldRequestKey)) {
                shoppingDto.setSelectToFlight(null);
                shoppingDto.setSelectBackFlight(null);
                shoppingDto.setSelectHotel(null);
                shoppingDto.setSelectTicketInfo(new ArrayList<FitShoppingSelectedTicketDto>());
                shoppingDto.setSelectInsuranceInfo(new ArrayList<FitShoppingSelectedInsuranceDto>());
                shoppingDto.setSelectFlightInsInfo(new ArrayList<FlightInsuranceDto>());
                shoppingDto.setFliInsDelFlag(false);
            }
        }
        shoppingDto.setRequestKey(requestKey);

        FlightSearchResult<FlightSearchFlightInfoDto> toFlightSearchResult = fitSearchResult.getDistinctFlightMap().get(FlightTripType.DEPARTURE.name());
        FlightSearchResult<FlightSearchFlightInfoDto> backFlightSearchResult = fitSearchResult.getDistinctFlightMap().get(FlightTripType.RETURN.name());

        shoppingDto.setToFlightInfos(toFlightSearchResult);
        if (toFlightSearchResult != null && CollectionUtils.isNotEmpty(toFlightSearchResult.getResults())) {
            shoppingDto.setSelectToFlight(toFlightSearchResult.getResults().get(0));
        }
        shoppingDto.setBackFlightInfos(backFlightSearchResult);
        if (backFlightSearchResult != null && CollectionUtils.isNotEmpty(backFlightSearchResult.getResults())) {
            shoppingDto.setSelectBackFlight(backFlightSearchResult.getResults().get(0));
        }

        shoppingDto.setHotels(fitSearchResult.getHotelSearchResult());
        if (fitSearchResult.getHotelSearchResult() != null && CollectionUtils.isNotEmpty(fitSearchResult.getHotelSearchResult().getResults())) {
            shoppingDto.setSelectHotel(fitSearchResult.getHotelSearchResult().getResults().get(0));
        }

        if (CollectionUtils.isNotEmpty(fitSearchResult.getFlightInsuranceResult())) {
            handleFlightIns(fitSearchResult.getFlightInsuranceResult());
            shoppingDto.setFlightInsuranceInfos(fitSearchResult.getFlightInsuranceResult());
            // 设置默认航意险信息
            this.setDefaultfliInsurance(shoppingDto, request);
        }
        shoppingDto.setSpots(fitSearchResult.getSpotSearchResult());
        shoppingDto.setInsurances(fitSearchResult.getInsuranceResult());
        shoppingDto.setSearchRequest(request);

        shoppingService.putShoppingCache(request.getShoppingUUID(), shoppingDto);

        return shoppingDto;
    }

    /**
     * 设置默认选中航意险信息
     * @param shoppingDto
     * @param request
     */
    private void setDefaultfliInsurance(FitShoppingDto shoppingDto, FitBaseSearchRequest request) {
        InsuranceInfoDto flightInsDto = shoppingDto.getFlightInsuranceInfos().get(0);

        if (flightInsDto != null) {
            FlightInsuranceDto fInsDto = new FlightInsuranceDto();
            fInsDto.setInsuranceId(flightInsDto.getId());
            fInsDto.setInsuranceName(flightInsDto.getInsuranceClass().getName() + flightInsDto.getInsuranceRemark());
            fInsDto.setInsurancePrice(flightInsDto.getInsurancePrice());
            fInsDto.setInsuranceDesc(flightInsDto.getInsuranceDesc());
            fInsDto.setSuppName(flightInsDto.getSupp().getName());
            int count = request.getAdultsCount() + request.getChildCount();
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

    /**
     * 将默认的航意险放在首位
     * @param flightInsList
     */
    private void handleFlightIns(List<InsuranceInfoDto> flightInsList) {
        Collections.sort(flightInsList, new Comparator<InsuranceInfoDto>() {
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
    }


	/**根据请求参数获取查询结果集
	 * @param request
	 * @return
	 * @throws ExceptionWrapper
	 */
	private FitSearchResult searchResult(FitBaseSearchRequest request)
			throws ExceptionWrapper {
		//1. 构造任务执行参数以及生成执行组（机票、酒店）
		TaskContext context = new TaskContext();
        context.put("request", request);
		TaskMainGroup<FitSearchResult> taskMainGroup = this.initTaskGroup(context);
		
		//2. 执行并发线程组并获取执行结果
		@SuppressWarnings("unchecked")
		int size = (Integer) context.get("taskSize")	;
		FitSearchResult fitSearchResult = taskMainGroup.getResult(size);

		return fitSearchResult;
	}

	/**
	 * 1.设置选择的机票和酒店, 基准价
	 * 2.将信息保存到缓存中
	 * 3.将返回为空的产品，记录为业务异常，保存到context中
	 * @param
	 * @param fitSearchResult
	 */
	private void handleSearchResult(FitSearchResult fitSearchResult, int adultCount, int childCount) {
	    Map<String, FlightSearchResult<FlightSearchFlightInfoDto>> flightMap = fitSearchResult.getDistinctFlightMap();
        // 处理机票数据（过滤，去库存，排序)
        for (String key : flightMap.keySet()) {
            FlightSearchResult<FlightSearchFlightInfoDto> flightSearchResult = flightMap.get(key);
            if (flightSearchResult!= null && CollectionUtils.isNotEmpty(flightSearchResult.getResults())) {
                flightSearchResult.setResults(this.handleFlights(flightSearchResult.getResults(), adultCount, childCount));
            }
        }

        // 处理机票航意险数据
        if (CollectionUtils.isNotEmpty(fitSearchResult.getFlightInsuranceResult())) {
            // 过滤非航空意外险，并按默认航意险排序
            fitSearchResult.setFlightInsuranceResult(handleFliInsResult(fitSearchResult.getFlightInsuranceResult()));
        }
        // 处理酒店数据, 酒店差价计算
        if (fitSearchResult.getHotelSearchResult() != null && CollectionUtils.isNotEmpty(fitSearchResult.getHotelSearchResult().getResults())) {
            List<HotelSearchHotelDto> hotelList = fitSearchResult.getHotelSearchResult().getResults();
            HotelSearchPlanDto planDto = hotelList.get(0).getRooms().get(0).getPlans().get(0);
            BigDecimal hotelBasePrice = planDto.getPrice().multiply(BigDecimal.valueOf(planDto.getPlanCounts()));
            for (HotelSearchHotelDto hotel : hotelList) {
                for (HotelSearchRoomDto room : hotel.getRooms()) {
                    for (HotelSearchPlanDto plan : room.getPlans()) {
                        plan.setPriceDifferences(plan.getPrice().multiply(BigDecimal.valueOf(plan.getPlanCounts())).subtract(hotelBasePrice));
                    }
                }
            }
        }
    }

    /**
     * 构造index信息，将搜索记录放入solr
     * @return
     */
    private void saveIndexToSolr(FitBaseSearchRequest fitSearchRequest, FitShoppingDto shoppingDto, long usedTime) {
        StringBuilder errMsg = new StringBuilder();
        String SPLIT = "~~~~";
        if (shoppingDto.getToFlightInfos() == null || CollectionUtils.isEmpty(shoppingDto.getToFlightInfos().getResults())) {
            errMsg.append(NO_DEP_FLI_RESULT ).append(SPLIT);
        }
        if (fitSearchRequest.getTripType().equals(TripeType.WF.name())) {
            if (shoppingDto.getBackFlightInfos() == null || CollectionUtils.isEmpty(shoppingDto.getBackFlightInfos().getResults())) {
                errMsg.append(NO_RE_FLI_RESULT ).append(SPLIT);
            }
        }
        if (shoppingDto.getHotels() == null || CollectionUtils.isEmpty(shoppingDto.getHotels().getResults())) {
            errMsg.append(NO_HOTEL_RESULT).append(SPLIT);
        }
        if (CollectionUtils.isEmpty(shoppingDto.getFlightInsuranceInfos())) {
            errMsg.append(NO_FLIGHT_INSURANCE_RESULT).append(SPLIT);
        }
        if (CollectionUtils.isEmpty(shoppingDto.getSpots())) {
            errMsg.append(NO_SPOT_RESULT).append(SPLIT);
        }
        if (CollectionUtils.isEmpty(shoppingDto.getInsurances())) {
            errMsg.append(NO_INSURANCE_RESULT).append(SPLIT);
        }

        FitRecordSearchIndex recordIndex = new FitRecordSearchIndex();
        recordIndex.setQueryDate(DateUtils.formatDate(new Date()));
        recordIndex.setQueryTime(System.currentTimeMillis());
        recordIndex.setDepartureCityCode(fitSearchRequest.getDepartureCityCode());
        recordIndex.setArrivalCityCode(fitSearchRequest.getArrivalCityCode());
        recordIndex.setDepartureDate(fitSearchRequest.getDepartureTime());
        if (fitSearchRequest.getTripType().equals(TripeType.WF.name())) {
            recordIndex.setReturnDate(fitSearchRequest.getReturnTime());
        }
        recordIndex.setStayCityCode(fitSearchRequest.getCityCode());
        recordIndex.setCheckInDate(fitSearchRequest.getCheckInTime());
        recordIndex.setCheckOutDate(fitSearchRequest.getCheckOutTime());
        recordIndex.setIndexId(recordIndex.getDepartureCityCode()+ "_"+recordIndex.getArrivalCityCode()+ "_" + System.nanoTime());
        recordIndex.setAdultCount(fitSearchRequest.getAdultsCount());
        recordIndex.setChildrenCount(fitSearchRequest.getChildCount());
        recordIndex.setErrMsg(errMsg.toString());
        if (StringUtils.isNotEmpty(errMsg.toString())) {
            recordIndex.setResultStatus(ResultStatus.FAIL);
        } else {
            recordIndex.setResultStatus(ResultStatus.SUCCESS);
        }
        recordIndex.setUsedTime(usedTime);
        recordIndex.setTraceId(TraceContext.getTraceId());
        recordIndex.setIp(TraceContext.getIp());
        List<FitRecordSearchIndex> indexs = new ArrayList<FitRecordSearchIndex>();
        indexs.add(recordIndex);
        try {
            fitMainSearchSolrClient.add(indexs, FitRecordSearchIndex.class);
        } catch (Exception e) {
            logger.error("将搜索记录保存到solr失败", e);
        }
    }

    private List<InsuranceInfoDto> handleFliInsResult(List<InsuranceInfoDto> flightInsurances) {
        List<InsuranceInfoDto> filterInsurances = new ArrayList<InsuranceInfoDto>();
        // 机票保险过滤
        for (InsuranceInfoDto insurance : flightInsurances) {
            if (insurance.getInsuranceType().equals(com.lvmama.lvf.common.dto.enums.InsuranceType.ACCIDENT_INS)) {
                filterInsurances.add(insurance);
            }
        }
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
        return filterInsurances;
    }

	/**
	 * 此方法返回对舱位进行排序后的机票信息，排序后，每个航班的每种舱位类型中最多只有一个最低价的舱位(也可能某种舱位类型下，没有舱位)
	 * 
	 * */
	 public void getYCFLowPriceSeats(List<FlightSearchFlightInfoDto> list) {
		 for(FlightSearchFlightInfoDto flightInfo : list) {
             List<FlightSearchSeatDto> seatlist = SearchResultUtil.getYCFLowPriceSeats(flightInfo);
             flightInfo.setSeats(seatlist);
		 }
	 }

	 /**
	  * 去除库存不足的数据
	  * 
	  * */
	 public List<FlightSearchFlightInfoDto> getAvailableSeats(List<FlightSearchFlightInfoDto> list, int adultCount, int childCount){
         List<FlightSearchFlightInfoDto> availableflightlist = new ArrayList<FlightSearchFlightInfoDto>();
         if (CollectionUtils.isNotEmpty(list)) {
             for (FlightSearchFlightInfoDto flightInfoDto : list) {
                 flightInfoDto = SearchResultUtil.isAvailableSeat(flightInfoDto, adultCount, childCount);
                 if (CollectionUtils.isNotEmpty(flightInfoDto.getSeats())) {//这里的舱位列表已经进行过处理，没有库存的舱位已经去除
                     availableflightlist.add(flightInfoDto);
                 }
             }
         }
         return availableflightlist;
	 }
	 /**
	  * 此方法返回最低价位的航班及舱位，结果中至多只有两个值(去程和返程)
	  * */
	 public void sortFlight(List<FlightSearchFlightInfoDto> list) {
         for (FlightSearchFlightInfoDto flightInfo : list) {
             List<FlightSearchSeatDto> seats = flightInfo.getSeats();
             Collections.sort(seats, new Comparator<FlightSearchSeatDto>() {
                 @Override
                 public int compare(FlightSearchSeatDto o1, FlightSearchSeatDto o2) {
                     if (o1.getSalesPrice().doubleValue() > o2.getSalesPrice().doubleValue()) {
                         return 1;
                     }
                     if (o1.getSalesPrice().doubleValue() < o2.getSalesPrice().doubleValue()) {
                         return -1;
                     }
                     return 0;
                 }
             });
             flightInfo.setSeats(seats);
         }
         Collections.sort(list, new Comparator<FlightSearchFlightInfoDto>() {
             @Override
             public int compare(FlightSearchFlightInfoDto o1, FlightSearchFlightInfoDto o2) {
                 if (o1.getSeats().get(0).getSalesPrice()
                     .compareTo(o2.getSeats().get(0).getSalesPrice()) == 0) {
                     DateUtils.parseDate(o1.getDepartureTime()).compareTo(DateUtils.parseDate(o2.getDepartureTime()));
                 }
                 if (o1.getSeats().get(0).getSalesPrice().doubleValue() > o2.getSeats().get(0).getSalesPrice().doubleValue()) {
                     return 1;
                 }
                 if (o1.getSeats().get(0).getSalesPrice().doubleValue() < o2.getSeats().get(0).getSalesPrice().doubleValue()) {
                     return -1;
                 }
                 return 0;
             }
         });
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
        hotelQueryReq.setChildCount(request.getChildCount());

        HotelSearchResult<HotelSearchHotelDto> hotelSearchResult = getHotelSearchResult(hotelQueryReq);
        return hotelSearchResult;
    }

    private HotelSearchResult<HotelSearchHotelDto> getHotelSearchResult(HotelQueryRequest hotelQueryReq) {
        //1. 根据新的查询条件调用酒店接口
        HotelSearchResult<HotelSearchHotelDto> hotelSearchResult = fitAggregateClient.searchHotelInfo(hotelQueryReq);

        if (hotelSearchResult == null || CollectionUtils.isEmpty(hotelSearchResult.getResults())) {
            throw new ExceptionWrapper(FitExceptionCode.FIT_NO_HOTEL_RESULT);
        }

        List<HotelSearchHotelDto> returnList = new ArrayList<HotelSearchHotelDto>();

        //2. 对酒店数据进行过滤
        if(hotelQueryReq.getParams().contains("P1") && StringUtils.isBlank(hotelQueryReq.getKeywords())) {
            try {
                StringBuilder sb = new StringBuilder();
                FitConRecomHotelDto condition = new FitConRecomHotelDto();
                condition.setDistrictCityId(Long.valueOf(hotelQueryReq.getCityDistrictId()));
                BaseQueryDto<FitConRecomHotelDto> baseQueryDto = new BaseQueryDto<FitConRecomHotelDto>(condition);

                BaseResultDto<FitConRecomHotelDto> recomHotels = fitBusinessClient.getFitConRecomHotelsAll(baseQueryDto);
                String defHotelId = "";
                if (CollectionUtils.isNotEmpty(recomHotels.getResults())) {
                    for (FitConRecomHotelDto recomHotel : recomHotels.getResults()) {
                        sb.append(recomHotel.getProductId()).append(",");
                        if (recomHotel.getIsDefault().equals(SymbolType.Y)) {
                            defHotelId = recomHotel.getProductId();
                        }
                    }
                    if (StringUtils.isNotEmpty(sb.toString())) {
                        String productIds = sb.toString().substring(0, sb.toString().length() - 1);
                        hotelQueryReq.setKeywords(productIds);
                        HotelSearchResult<HotelSearchHotelDto> recomHotelResult = fitAggregateClient.searchHotelInfo(hotelQueryReq);
                        if (recomHotelResult != null && CollectionUtils.isNotEmpty(recomHotelResult.getResults())) {
                            List<HotelSearchHotelDto> recomHotelList = recomHotelResult.getResults();
                            // 将默认的推荐酒店放在首位
                            if (StringUtils.isNotEmpty(defHotelId)) {
                                HotelSearchHotelDto defHotel = null;
                                for (int i = 0; i < recomHotelList.size(); i++) {
                                    if (defHotelId.equals(recomHotelList.get(i).getProductId())) {
                                        defHotel = recomHotelList.get(i);
                                        recomHotelList.remove(i);
                                        break;
                                    }
                                }
                                if (defHotel != null) {
                                    recomHotelList.add(0, defHotel);
                                }
                            }

                            returnList.addAll(recomHotelList); // 添加推荐酒店信息
                            for (HotelSearchHotelDto hotelDto : hotelSearchResult.getResults()) { // 添加去掉推荐酒店后的酒店信息
                                if (!productIds.contains(hotelDto.getProductId())) {
                                    returnList.add(hotelDto);
                                }
                            }
                            hotelSearchResult.setResults(returnList);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 过滤时间价格为空的酒店
        Long days = DateUtils.getDateDiffByDay(hotelQueryReq.getReturnDate(), hotelQueryReq.getDepartureDate());
        List<HotelSearchHotelDto> hotelList = filterHotel(days, hotelSearchResult.getResults());
        // 设置房间数和可预订的最大房间数
        this.setHotelRoomCount(hotelList, hotelQueryReq.getAdultCount(), hotelQueryReq.getChildCount());
        // 根据时间价格设置房间规格的价格
        this.setHotelPlanPrice(hotelList);
        hotelSearchResult.setResults(hotelList);
        return hotelSearchResult;
    }

    private void setHotelPlanPrice(List<HotelSearchHotelDto> hotelList) {
        for (HotelSearchHotelDto hotel : hotelList) {
            for (HotelSearchRoomDto room : hotel.getRooms()) {
                for (HotelSearchPlanDto plan : room.getPlans()) {
                    BigDecimal settlePrice = BigDecimal.ZERO;
                    BigDecimal salesPrice = BigDecimal.ZERO;
                    for (FitHotelPlanPriceDto priceDto:plan.getDayPrice()) {//计算出每个plan的价格之和，只包括天数，不包括房间数
                        settlePrice = settlePrice.add(priceDto.getSettlePrice());
                        salesPrice = salesPrice.add(priceDto.getSalesPrice());
                    }
                    plan.setSettlementPrice(settlePrice);
                    plan.setPrice(salesPrice);
                }
            }
        }
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
        for (HotelSearchHotelDto hotel : hotels) {
            for (HotelSearchRoomDto room : hotel.getRooms()) {
                int roomCount = HotelUtils.getMinRoomCount(adultCount, childCount, Integer.parseInt(room.getMaxVisitor()));
                for (HotelSearchPlanDto plan : room.getPlans()) {
                    int maxQuantity = plan.getMaxQuantity();
                    List<FitHotelPlanPriceDto> dayPrice = plan.getDayPrice();
                    int minInventory = Integer.MAX_VALUE;
                    for (FitHotelPlanPriceDto planPrice : dayPrice) {
                        if (planPrice.getStockFlag().equals("Y") && planPrice.getInventoryCount() < minInventory) {
                            minInventory = planPrice.getInventoryCount();
                        }
                    }
                    int maxCount = minInventory < maxQuantity ? minInventory : maxQuantity;
                    maxCount = maxCount < adultCount ? maxCount : adultCount;
                    plan.setMaxPlanCounts(maxCount);
                    int minCount = roomCount < plan.getMinQuantity() ? plan.getMinQuantity() : roomCount;
                    plan.setMinPlanCounts(minCount);
                    plan.setPlanCounts(minCount);
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
	
	/**
	 * @param context
	 * @return
	 */
	private TaskMainGroup<FitSearchResult> initTaskGroup(TaskContext context) {
		
		// 组装查询信息任务组
		TaskGroup queryGroup = this.genTaskGroup(context);
        context.put("taskSize", queryGroup.getTasks().size());
		// 组装MainGroup
		TaskMainGroup<FitSearchResult> mainGroup = new TaskMainGroup<FitSearchResult>();
		// 加入主任务组
	    mainGroup.addGroup(queryGroup);
	    // 搜集各线程的查询结果
		mainGroup.putContext(context).putGetResult(new Task<FitSearchResult>() {
			@SuppressWarnings({ "unchecked" })
			@Override
			public FitSearchResult execute(TaskContext context) {
				FitSearchResult fitSearchResult = new FitSearchResult();

                Map<String, FlightSearchResult<FlightSearchFlightInfoDto>> flightMap = new HashMap<String, FlightSearchResult<FlightSearchFlightInfoDto>>();

                FlightSearchResult<FlightSearchFlightInfoDto> toFlight = (FlightSearchResult<FlightSearchFlightInfoDto>) context.get(FitBusinessType.FIT_Q_T.name());
                FlightSearchResult<FlightSearchFlightInfoDto> backFlight = (FlightSearchResult<FlightSearchFlightInfoDto>)context.get(FitBusinessType.FIT_Q_R.name());

                flightMap.put(FlightTripType.DEPARTURE.name(), toFlight);
                flightMap.put(FlightTripType.RETURN.name(), backFlight);

                fitSearchResult.setDistinctFlightMap(flightMap);
				fitSearchResult.setHotelSearchResult((HotelSearchResult<HotelSearchHotelDto>)context.get(FitBusinessType.FIT_Q_H.name()));
				fitSearchResult.setSpotSearchResult((List<SpotSearchSpotDto>) context.get(FitBusinessType.FIT_Q_S.name()));
				fitSearchResult.setInsuranceResult((List<InsuranceDto>) context.get(FitBusinessType.FIT_QUERY_INSURANCE.name()));
				fitSearchResult.setFlightInsuranceResult((List<InsuranceInfoDto>) context.get(FitBusinessType.FIT_QUERY_FLIGHT_INSURANCE.name()));

				return fitSearchResult;
			}
		});
		return mainGroup;
	}
	
	/**
	 * 组装线程组
	 * @param
	 * @param
	 * @return
	 */
	private TaskGroup genTaskGroup(TaskContext taskContext) {
        FitBaseSearchRequest request = (FitBaseSearchRequest)taskContext.get("request");
        TaskGroup taskGroup = new TaskGroup();

        this.addToFlightQueryTask(request, taskGroup);
        if (request.getTripType().equals(TripeType.WF.name())) {
            this.addBackFlightQueryTask(request, taskGroup);
        }
        this.addFlightInsQueryTask(taskGroup);
        this.addHotelQueryTask(request, taskGroup);
        this.addSpotQueryTask(request, taskGroup);
        this.addInsuranceQueryTask(request, taskGroup);

		return taskGroup;
	}

    private void addToFlightQueryTask(final FitBaseSearchRequest request, TaskGroup taskGroup) {
        taskGroup.addTask(new Task<Boolean>() {
            @Override
            public Boolean execute(TaskContext context) {
                FlightToQueryRequest toflightQuery = new FlightToQueryRequest();
                toflightQuery.setDepartureDate(DateUtils.parseDate(request.getDepartureTime()));
                toflightQuery.setReturnDate(request.getReturnTime());
                toflightQuery.setDepartureCityCode(request.getDepartureCityCode());
                toflightQuery.setArrivalCityCode(request.getArrivalCityCode());
                toflightQuery.setDepartureAirportCode(request.getDepartureCityCode());
                toflightQuery.setArrivalAirportCode(request.getArrivalCityCode());
                toflightQuery.setBookingSource(request.getBookingSource());
                toflightQuery.setFacet(true);

                FlightSearchResult<FlightSearchFlightInfoDto> searchResult = fitAggregateClient.searchFlightInfoWithDP(toflightQuery);
                context.put(FitBusinessType.FIT_Q_T.name(), searchResult);
                return true;
            }
        });
    }

    private void addBackFlightQueryTask(final FitBaseSearchRequest request, TaskGroup taskGroup) {
        taskGroup.addTask(new Task<Boolean>() {
            @Override
            public Boolean execute(TaskContext context) {
                FlightBackQueryRequest backflightQuery = new FlightBackQueryRequest();
                backflightQuery.setDepartureDate(DateUtils.parseDate(request.getReturnTime()));
                backflightQuery.setDepartureCityCode(request.getArrivalCityCode());
                backflightQuery.setArrivalCityCode(request.getDepartureCityCode());
                backflightQuery.setDepartureAirportCode(request.getArrivalCityCode());
                backflightQuery.setArrivalAirportCode(request.getDepartureCityCode());
                backflightQuery.setBookingSource(request.getBookingSource());
                backflightQuery.setFacet(true);

                FlightSearchResult<FlightSearchFlightInfoDto> searchResult = fitAggregateClient.searchFlightInfoWithDP(backflightQuery);
                context.put(FitBusinessType.FIT_Q_R.name(), searchResult);
                return true;
            }
        });
    }

    private void addHotelQueryTask(final FitBaseSearchRequest request, TaskGroup taskGroup) {
        taskGroup.addTask(new Task<Boolean>() {
            @Override
            public Boolean execute(TaskContext context) {
                HotelQueryRequest hotelQueryReq = new HotelQueryRequest();

                hotelQueryReq.setCityCode(request.getCityCode());
                hotelQueryReq.setCityName(request.getCityName());
                hotelQueryReq.setCityDistrictId(VSTDistrictCityEnum.getDistrictId(request.getCityCode()).toString());

                hotelQueryReq.setDepartureDate(request.getCheckInTime());
                hotelQueryReq.setReturnDate(request.getCheckOutTime());
                hotelQueryReq.setParams("P1");
                hotelQueryReq.setQueryId(request.getShoppingUUID());
                hotelQueryReq.setHotelFromRecommendedOnly(getHotelFromRecommended());
                hotelQueryReq.setAdultCount(request.getAdultsCount());
                hotelQueryReq.setChildCount(request.getChildCount());

                HotelSearchResult<HotelSearchHotelDto> hotelSearchResult = getHotelSearchResult(hotelQueryReq);
                context.put(FitBusinessType.FIT_Q_H.name(), hotelSearchResult);
                return true;
            }
        });
    }

    private void addFlightInsQueryTask(TaskGroup taskGroup) {
        taskGroup.addTask(new Task<Boolean>() {
            @Override
            public Boolean execute(TaskContext context) {
                List<InsuranceInfoDto> flightInsurances = null;
                try {
                    flightInsurances = fitAggregateClient.searchFlightInsurance();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                context.put(FitBusinessType.FIT_QUERY_FLIGHT_INSURANCE.name(), flightInsurances);
                return true;
            }
        });
    }

    private void addSpotQueryTask(final FitBaseSearchRequest request, TaskGroup taskGroup) {
        taskGroup.addTask(new Task<Boolean>() {
            @Override
            public Boolean execute(TaskContext context) {
                SpotQueryRequest spotQueryRequest = new SpotQueryRequest();
                String cityCode = request.getCityCode();
                Long districtId = VSTDistrictCityEnum.getDestId(cityCode);

                spotQueryRequest.setDestinationId(districtId.toString());
                spotQueryRequest.setVisitorNum(request.getAdultsCount() + request.getChildCount());

                Date startDate = DateUtils.parseDate(request.getDepartureTime());
                spotQueryRequest.setStartDate(DateUtils.getDateAfterDateDays(startDate, 1));
                spotQueryRequest.setEndDate(DateUtils.parseDate(request.getReturnTime()));

                SpotSearchResult<SpotSearchSpotDto> spotSearchResult = null;
                try {
                    spotSearchResult = fitAggregateClient.searchSpot(spotQueryRequest);
                } catch (Exception e) {

                }
                context.put(FitBusinessType.FIT_Q_S.name(), spotSearchResult.getResults());
                return true;
            }
        });
    }

    private void addInsuranceQueryTask(final FitBaseSearchRequest request, TaskGroup taskGroup) {
        taskGroup.addTask(new Task<Boolean>() {
            @Override
            public Boolean execute(TaskContext context) {
                InsuranceQueryRequest insuranceQueryRequest = new InsuranceQueryRequest();
                insuranceQueryRequest.setCurrentProductId(636165L);
                insuranceQueryRequest.setDistributorId(3L);
                if(TripeType.WF.name().equals(request.getTripType())){
                    int insuranceDays = DateUtils.getDateDiffByDay(DateUtils.parseDate(request.getReturnTime()), DateUtils.parseDate(request.getDepartureTime())) + 1;
                    insuranceQueryRequest.setInsuranceDays((long)insuranceDays);
                }else{ //单程的被保天数
                    insuranceQueryRequest.setInsuranceDays(1L);
                }
                insuranceQueryRequest.setVistorDate(DateUtils.parseDate(request.getDepartureTime()));
                insuranceQueryRequest.setPersonNum(request.getAdultsCount() + request.getChildCount());
                List<InsuranceDto> insuranceDtoList = new ArrayList<InsuranceDto>();
                try {
                    insuranceDtoList = fitAggregateClient.searchInsuranceFromVst(insuranceQueryRequest);
                } catch (Exception e) {

                }
                context.put(FitBusinessType.FIT_QUERY_INSURANCE.name(), insuranceDtoList);
                return true;
            }
        });
    }
	
	/**
	 * 对航班结果集进行处理
	 * @param list
	 * @return
	 */
	private List<FlightSearchFlightInfoDto> handleFlights(List<FlightSearchFlightInfoDto> list, int adultCount, int childCount) {
		list = getAvailableSeats(list, adultCount, childCount);
		// 去掉优惠为负数的航班
        this.filterFlight(list);
		// 结果集中，每个航班只留一个YFC舱
		this.getYCFLowPriceSeats(list);
        // 过滤儿童舱
        if (childCount > 0) {
            filterNoChildFlight(list);
        }
		// 默认价格为最低价排序，如存在多组往返航班价格相同，按起飞时间排序
		this.sortFlight(list);
        // 判断是否为隔夜航班
        this.setOvernightFlag(list);
        // 设置初始化的航班差价
        if (CollectionUtils.isNotEmpty(list)) {
            FlightSearchSeatDto baseSeat = list.get(0).getSeats().get(0);
            BigDecimal basePrice = baseSeat.getSalesPrice().multiply(BigDecimal.valueOf(adultCount)).add(baseSeat.getChildrenPrice().multiply(BigDecimal.valueOf(childCount)));
            for (FlightSearchFlightInfoDto flightInfo : list) {
                for (FlightSearchSeatDto seatDto : flightInfo.getSeats()) {
                    BigDecimal curPrice = seatDto.getSalesPrice().multiply(BigDecimal.valueOf(adultCount)).add(seatDto.getChildrenPrice().multiply(BigDecimal.valueOf(childCount)));
                    seatDto.setDifferentPrice(curPrice.subtract(basePrice));
                }
            }
        }

        return list;
	}

    /**
     * 如果有儿童过滤掉没有儿童舱位的航班以及舱位
     * @param flightInfoDtos
     */
    private void filterNoChildFlight(List<FlightSearchFlightInfoDto> flightInfoDtos) {
        List<FlightSearchFlightInfoDto> noUsefulFlightInfoDtos = new ArrayList<FlightSearchFlightInfoDto>();
        for (FlightSearchFlightInfoDto searchFlightInfoDto : flightInfoDtos) {
            Map<String,FlightSearchSeatDto> childrenSeats = searchFlightInfoDto.getChildrenSeats();
            List<FlightSearchSeatDto> usefulSeats = new ArrayList<FlightSearchSeatDto>();
            if(null !=searchFlightInfoDto.getSeats()&&CollectionUtils.isNotEmpty(searchFlightInfoDto.getSeats())&& MapUtils
                .isNotEmpty(childrenSeats)){
                for (FlightSearchSeatDto seatDto : searchFlightInfoDto.getSeats()) {
                    if(childrenSeats.containsKey(seatDto.getSeatClassCode())&&childrenSeats.get(seatDto.getSeatClassCode())!=null) {
                        usefulSeats.add(seatDto);
                    }
                }
                if(CollectionUtils.isNotEmpty(usefulSeats)) {
                    searchFlightInfoDto.setSeats(usefulSeats);
                }else{
                    noUsefulFlightInfoDtos.add(searchFlightInfoDto);
                }
            }
        }
        flightInfoDtos.removeAll(noUsefulFlightInfoDtos);
    }

    /**
     * 判断是否为隔夜航班
     * @param list
     */
    private void setOvernightFlag(List<FlightSearchFlightInfoDto> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            for (FlightSearchFlightInfoDto flightInfo : list) {
                Date depDate = DateUtils.parseDate(flightInfo.getDepartureTime(), DateUtils.YYYY_MM_DD);
                Date arvDate = DateUtils.parseDate(flightInfo.getArrivalTime(), DateUtils.YYYY_MM_DD);
                if (!depDate.equals(arvDate)) {
                    flightInfo.setHighLightFlag(true); // 设置隔夜航班标准
                }
            }
        }
    }

    /**
	 * 过滤优惠价格为负数的航班
	 * @param
	 * @return
	 */
	private void filterFlight(List<FlightSearchFlightInfoDto> list) {

        List<FlightSearchFlightInfoDto> newFlightInfo = new ArrayList<FlightSearchFlightInfoDto>();
        if (CollectionUtils.isNotEmpty(list)) {
            for (FlightSearchFlightInfoDto flightInfoDto : list) {
                List<FlightSearchSeatDto> seats = flightInfoDto.getSeats();
                List<FlightSearchSeatDto> newFlightSeat = new ArrayList<FlightSearchSeatDto>();
                for (FlightSearchSeatDto flightSearchSeatDto : seats) {
                    FitFlightTicketPriceDto flightTicketPriceDto =
                        flightSearchSeatDto.getFlightTicketPriceDto();
                    if (flightTicketPriceDto.getPromotion().compareTo(BigDecimal.ZERO) >= 0) {
                        newFlightSeat.add(flightSearchSeatDto);
                    }
                }
                if (CollectionUtils.isNotEmpty(newFlightSeat)) {
                    flightInfoDto.setSeats(newFlightSeat);
                    newFlightInfo.add(flightInfoDto);
                }
            }
        }
	}

	/**
	 * 检索景点门票
	 * */
	public SpotSearchResult<SpotSearchSpotDto> searchSpotTicket(SpotQueryRequest spotQueryRequest){
		
		SpotSearchResult<SpotSearchSpotDto> searchResult = new SpotSearchResult<SpotSearchSpotDto>();
		searchResult = fitAggregateClient.searchSpot(spotQueryRequest);
		return searchResult;
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

    /**
     * 根据筛选条件对航班信息进行筛选
     */
    @Override
    public List<FlightSearchFlightInfoDto> getFlightInfos(final FitFilterFlightRequest request) {
        FitShoppingDto shoppingDto = shoppingService.getFitShopping(request.getShoppingUuid());
        List<FlightSearchFlightInfoDto> flightInfos = null;
        if (request.getFlightTripType().equals(FlightTripType.DEPARTURE.name())) {
            flightInfos = shoppingDto.getToFlightInfos().getResults();
        }
        if (request.getFlightTripType().equals(FlightTripType.RETURN.name())) {
            flightInfos = shoppingDto.getBackFlightInfos().getResults();
        }
        // 获取选中的航班
        FlightSearchFlightInfoDto selectFlight = flightInfos.get(0);
        // 根据筛选条件，过滤航班信息
        String depTimeSegmentKey = request.getDepTimeSegmentKey();
        String arvTimeSegmentKey = request.getArvTimeSegmentKey();
        String carrierNameCodeKey = request.getCarrierNameCodeKey();
        String depAirpotNameCodeKey = request.getDepAirportNameCodeKey();
        String arvAirpotNameCodeKey = request.getArvAirportNameCodeKey();

        List<FlightSearchFlightInfoDto> newFlightInfos = new ArrayList<FlightSearchFlightInfoDto>();
        for (FlightSearchFlightInfoDto flightInfo : flightInfos) {
            String departureSegment = flightInfo.getDepartureTimeSegment();
            String arrivalSegment = flightInfo.getArrivalTimeSegment();
            String carrierCode = flightInfo.getCarrierCode();
            String departureAirportCode = flightInfo.getDepartureAirportCode();
            String arrivalAirportCode = flightInfo.getArrivalAirportCode();

            if (StringUtils.isNotEmpty(depTimeSegmentKey)
                && !depTimeSegmentKey.contains(departureSegment)) {
                continue;
            }
            if (StringUtils.isNotEmpty(arvTimeSegmentKey)
                && !arvTimeSegmentKey.contains(arrivalSegment)) {
                continue;
            }
            if (StringUtils.isNotEmpty(carrierNameCodeKey)
                && !carrierNameCodeKey.contains(carrierCode)) {
                continue;
            }
            if (StringUtils.isNotEmpty(depAirpotNameCodeKey)
                && !depAirpotNameCodeKey.contains(departureAirportCode)) {
                continue;
            }
            if (StringUtils.isNotEmpty(arvAirpotNameCodeKey)
                && !arvAirpotNameCodeKey.contains(arrivalAirportCode)) {
                continue;
            }
            newFlightInfos.add(flightInfo);
        }
        // 根据排序规则排序
        Collections.sort(newFlightInfos, new Comparator<FlightSearchFlightInfoDto>(){
            @Override
            public int compare(FlightSearchFlightInfoDto f1,
                FlightSearchFlightInfoDto f2) {
                String time1 = f1.getDepartureTime();
                String time2 = f2.getDepartureTime();
                if(request.getSortField().equals("DEPARTURE_TIME")) {
                    return "ASC".equals(request.getSortType())?time1.compareTo(time2) : (-1) * time1.compareTo(time2);
                }
                if(request.getSortField().equals("DIFF_PRICE")){
                    BigDecimal price1 = f1.getSeats().get(0).getSalesPrice();
                    BigDecimal price2 = f2.getSeats().get(0).getSalesPrice();
                    return "ASC".equals(request.getSortType())?price1.compareTo(price2) : (-1) * price1.compareTo(price2);
                }
                return 0;
            }
        });
        // 置顶选中的航班信息
        topSelectFlight(newFlightInfos, selectFlight);

        return newFlightInfos;
    }

    private void topSelectFlight(List<FlightSearchFlightInfoDto> flightInfos,
        FlightSearchFlightInfoDto selectFlight) {
        for (int i = 0; i < flightInfos.size(); i++) {
            if (flightInfos.get(i).getFlightNo().equals(selectFlight.getFlightNo())) {
                selectFlight = flightInfos.get(i);
                flightInfos.remove(i);
                break;
            }
        }
        if (selectFlight != null) {
            FlightSearchSeatDto selectSeat = null;
            for (int j = 0; j < selectFlight.getSeats().size(); j++) {
                if (selectFlight.getSeats().get(j).getSeatClassCode().equals(selectFlight.getSeats().get(0).getSeatClassCode())) {
                    selectSeat = selectFlight.getSeats().get(j);
                    selectFlight.getSeats().remove(j);
                    break;
                }
            }
            if (selectSeat != null) {
                selectFlight.getSeats().add(0, selectSeat);
            }
            flightInfos.add(0, selectFlight);
        }
    }

    public Boolean getHotelFromRecommended() {
        return Boolean.valueOf(
            CustomizedPropertyPlaceholderConfigurer.getContextProperty(hotelFromRecommended)+"");
    }
}
