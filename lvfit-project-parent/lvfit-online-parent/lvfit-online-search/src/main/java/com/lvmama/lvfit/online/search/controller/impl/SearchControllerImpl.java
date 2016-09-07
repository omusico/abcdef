package com.lvmama.lvfit.online.search.controller.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.client.FitDpClient;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.TripeType;
import com.lvmama.lvfit.common.dto.enums.VSTDistrictCityEnum;
import com.lvmama.lvfit.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvfit.common.dto.price.FitHotelPlanPriceDto;
import com.lvmama.lvfit.common.dto.search.FitPassengerRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.search.flight.FlightQueryRequest;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoForm;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;
import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelForm;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchPlanDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchRoomDto;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceQueryRequest;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceProdProduct;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceProdProductBranch;
import com.lvmama.lvfit.common.dto.search.spot.SpotQueryRequest;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotDto;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotForm;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.common.utils.HotelUtils;
import com.lvmama.lvfit.online.base.BaseController;
import com.lvmama.lvfit.online.base.utils.DateUtil;
import com.lvmama.lvfit.online.search.controller.SearchController;
import com.lvmama.lvfit.online.search.form.SearchConditionForm;
import com.lvmama.lvfit.online.utils.ServletUtil;

@SuppressWarnings("rawtypes")
@Controller
@RequestMapping("search")
public class SearchControllerImpl extends BaseController implements SearchController{
	
	private static final Logger logger = LoggerFactory.getLogger(SearchControllerImpl.class);

	@Value("getHotelFromRecommended")
	private String hotelFromRecommended;
	
	@Autowired
	private FitDpClient dpClient;
	
	/**
	 * 页面点击搜索
	 */
	@Override
	@RequestMapping(value = "/{uuid}", method = { RequestMethod.POST, RequestMethod.GET })
	public String search(Model model,@PathVariable("uuid")String uuid,SearchConditionForm input,HttpServletRequest request) {
	
		if(input.isReturnToError()){
			return "error"; 
		}
		model.addAttribute("searchform", input);
		input.setCityName(VSTDistrictCityEnum.getCnName(input.getCityCode()));
		input.setDepartureCityName(VSTDistrictCityEnum.getCnName(input.getDepartureCityCode()));
		input.setArrivalCityName(VSTDistrictCityEnum.getCnName(input.getArrivalCityCode()));
		if(this.getIsBackBooking(request).booleanValue()){
			model.addAttribute("isBackBooking", "true");
			input.setBookingSource(BookingSource.FIT_BACK);
		}
		FitSearchRequest fitSearchRequest = convertToFit(input);
		super.initModelData(model, request);
		if(null != uuid){
			input.setShoppingUUID(uuid);
			fitSearchRequest.setShoppingId(uuid);
		}
		

		try {
			FitShoppingDto shoppingDto = dpClient.getShoppingResult(fitSearchRequest);
			input.setShoppingUUID(uuid);
			model.addAttribute("searchform", input);
			if(null != shoppingDto){
				model = getShoppingInfos(model,shoppingDto,input);
			}
		} catch (ExceptionWrapper e) {
			model.addAttribute("errorMsg",e.getErrMessage());
			logger.error("获取机票及酒店信息异常",e);
			return "fh-select";
		}
		
		try {
            /** 根据sessionId 获得常用联系人信息 */
            if (ServletUtil.getSession(request, null, "SESSION_FRONT_USER") != null) {
                ServletUtil.putSession(request, null, "SESSION_FRONT_USER", ServletUtil.getSession(request, null, "SESSION_FRONT_USER"));
            }
        } catch (Exception e) {
            logger.error("根据sessionId 获得常用联系人信息",e);
        }
		return "fh-select";
	}
	
	
	/**
	 * 页面点击搜索
	 */
	@Override
	@RequestMapping(value = "", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchNoUuid(Model model,SearchConditionForm input,HttpServletRequest request) {
	
		if(this.getIsBackBooking(request).booleanValue()){
			model.addAttribute("isBackBooking", "true");
			input.setBookingSource(BookingSource.FIT_BACK);
		}
		try {
			String departureTime = input.getDepartureTime();
			String returnTime = input.getReturnTime();
			String checkInTime = input.getCheckInTime();
			String checkOutTime = input.getCheckOutTime();
			if(departureTime.contains("T")&&returnTime.contains("T")&&checkInTime.contains("T")&&checkOutTime.contains("T")){
				Integer departureTimeN = Integer.parseInt(departureTime.substring(departureTime.length()-1));
				Integer returnTimeN = Integer.parseInt(returnTime.substring(returnTime.length()-1));
				Integer checkInTimeN = Integer.parseInt(checkInTime.substring(checkInTime.length()-1));
				Integer checkOutTimeN = Integer.parseInt(checkOutTime.substring(checkOutTime.length()-1));
				if(returnTimeN>departureTimeN&&checkOutTimeN>checkInTimeN){
					Date date = new Date();
					input.setDepartureTime(DateUtils.formatDate(DateUtils.getDateAfterDateDays(date, departureTimeN)));
					input.setReturnTime(DateUtils.formatDate(DateUtils.getDateAfterDateDays(date, returnTimeN)));
					input.setCheckInTime(DateUtils.formatDate(DateUtils.getDateAfterDateDays(date, checkInTimeN)));
					input.setCheckOutTime(DateUtils.formatDate(DateUtils.getDateAfterDateDays(date, checkOutTimeN)));
				}else{
					return "error";
				}
			}
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			return "error";
		}
		if(input.isReturnToError()){
			return "error"; 
		}
		model.addAttribute("searchform", input);
		input.setCityName(VSTDistrictCityEnum.getCnName(input.getCityCode()));
		input.setDepartureCityName(VSTDistrictCityEnum.getCnName(input.getDepartureCityCode()));
		input.setArrivalCityName(VSTDistrictCityEnum.getCnName(input.getArrivalCityCode()));
		FitSearchRequest fitSearchRequest = convertToFit(input);
		//super.initModelData(model, request);
		String uuid = FitSearchRequest.createUUID();
		if(null != uuid){
			input.setShoppingUUID(uuid);
			fitSearchRequest.setShoppingId(uuid);
		}
		try {
			FitShoppingDto shoppingDto = dpClient.getShoppingResult(fitSearchRequest);
			input.setShoppingUUID(uuid);
			model.addAttribute("searchform", input);
			if(null != shoppingDto){
				model = getShoppingInfos(model,shoppingDto,input);
			}
		} catch (ExceptionWrapper e) {
			model.addAttribute("errorMsg",e.getErrMessage());
			logger.error("获取机票及酒店信息异常",e);
			return "fh-select";
		}
		return "fh-select";
	}
	

	@Override
	@RequestMapping(value = "/backToShopping", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchByShoppingUUID(Model model, HttpServletRequest request) {
		
		if(this.getIsBackBooking(request).booleanValue()){
			model.addAttribute("isBackBooking", "true");
		}
		SearchConditionForm input = new SearchConditionForm();
		
		super.initModelData(model, request);
		String shoppingUUID = request.getParameter("shoppingUUID");
		input.setShoppingUUID(shoppingUUID);
		model.addAttribute("searchform", input);
		String type = request.getParameter("type");
		try {
			//获取查询条件
			BaseSingleResultDto<FitSearchRequest> baseRequest = dpClient.getShoppingRequestByShoppingUUID(shoppingUUID);
			if(baseRequest != null ){
				FitSearchRequest searchRequest =  baseRequest.getResult();
				//单程或往返
				String tripType = searchRequest.getTripType();;
				input.setTripType(tripType);
				
				if("orderfilled".equals(type)){//订单填写页加载价格失败时，跳转
					if(null != searchRequest){
						input = this.convertToForm(searchRequest, input);
					}
					//重新查询
					dpClient.getFlightAndHotel(searchRequest);
				}
			}
		} catch (ExceptionWrapper e) {
			// TODO Auto-generated catch block
			logger.error("获取查询条件失败",e);
			model.addAttribute("errorMsg",e.getErrMessage());
			return "fh-select";
		}
		
		
		FitShoppingDto shoppingDto = new FitShoppingDto();
		BaseSingleResultDto<FitShoppingDto> baseDto;
		try {
			baseDto = dpClient.reGetShoppingByShoppingUUID(shoppingUUID);
			if(null == baseDto){
				input = this.setInputForm(input);
				return "fh-select";
			} else {
				shoppingDto  = baseDto.getResult();
			}
		} catch (ExceptionWrapper e) {
			input = this.setInputForm(input);
			model.addAttribute("errorMsg",e.getErrMessage());
			logger.error("获取机票及酒店信息异常",e);
			return "fh-select";
		}
		if(shoppingDto != null){
			FitSearchRequest searchRequest = shoppingDto.getSearchRequest();
			if(searchRequest != null){
				input = convertToForm(searchRequest,input);
			}
			getShoppingInfos(model,shoppingDto,input);
			
		} else{
			input = this.setInputForm(input);
			return "fh-select";
		}
		// TODO Auto-generated method stub
		return "fh-select";
		}

	public Model getShoppingInfos(Model model,FitShoppingDto shoppingDto,SearchConditionForm input){
		BigDecimal hotelBasePrice = shoppingDto.getHotelBasePrice();
		BigDecimal toFlightBasePrice = shoppingDto.getToFlightBasePrice();
		BigDecimal backFlightBasePrice = shoppingDto.getBackFlightBasePrice();
		
		Long days = DateUtils.getDateDiffByDay(input.getCheckOutTime(), input.getCheckInTime());
		FlightSearchFlightInfoForm departureInfo = null;
		FlightSearchFlightInfoForm returnInfo = null;
		HotelSearchHotelForm hotelSearchHotelDto = null;
		List<SpotSearchSpotForm> spotForm = null;
		InsuranceDto insuranceDto = null;
		
		List<FlightSearchFlightInfoDto> flightInfos = shoppingDto.getFlightInfos();
		List<SpotSearchSpotDto> spotDtos = shoppingDto.getSpots();
		List<HotelSearchHotelDto> hotels = shoppingDto.getHotels();
		List<InsuranceDto> insurances = shoppingDto.getInsurances();
		//---------处理机票数据-------
		if (CollectionUtils.isNotEmpty(flightInfos)) {
            departureInfo = new FlightSearchFlightInfoForm(flightInfos.get(0));
            String ddepartureDate = departureInfo.getDepartureTime().substring(0, 10);
            String darrivalDate = departureInfo.getArrivalTime().substring(0, 10);
            if(!ddepartureDate.equals(darrivalDate)){
                departureInfo.setHighLightFlag(true);
            }
            
            // 去程起飞时间和到达时间处理
            departureInfo.setDepartureTime(departureInfo.getDepartureTime().substring(11, 16));
            departureInfo.setArrivalTime(departureInfo.getArrivalTime().substring(11, 16));
            
            // 去程飞行时间处理
            String dflyTime = departureInfo.getFlyTime();
            dflyTime = dflyTime.replace("小时", "h");
            dflyTime = dflyTime.replace("分钟", "m");
            departureInfo.setFlyTime(dflyTime);
            
            //航班差价处理
            List<FlightSearchSeatDto> departureSeats = departureInfo.getSeats();
            for(FlightSearchSeatDto seat : departureSeats){
                BigDecimal curPrice = seat.getSalesPrice().multiply(new BigDecimal(input.getAdultsCount())).add(seat.getChildrenPrice().multiply(new BigDecimal(input.getChildCount())));
                seat.setDifferentPrice(curPrice.subtract(toFlightBasePrice));
            }
            departureInfo.setSeats(departureSeats);
            
            if(input.getTripType().equals(TripeType.WF.name())){
                returnInfo = new FlightSearchFlightInfoForm(flightInfos.get(1));
                
                String rdepartureDate = returnInfo.getDepartureTime().substring(0, 10);
                String rarrivalDate = returnInfo.getArrivalTime().substring(0, 10);
                if(!rdepartureDate.equals(rarrivalDate)){
                    returnInfo.setHighLightFlag(true);
                }
                
                // 返程起飞时间和到达时间处理
                returnInfo.setDepartureTime(returnInfo.getDepartureTime().substring(11, 16));
                returnInfo.setArrivalTime(returnInfo.getArrivalTime().substring(11, 16));
    
                // 返程飞行时间处理
                String rflyTime = returnInfo.getFlyTime();
                rflyTime = rflyTime.replace("小时", "h");
                rflyTime = rflyTime.replace("分钟", "m");
                returnInfo.setFlyTime(rflyTime);
                
                List<FlightSearchSeatDto> returnseats = returnInfo.getSeats();
                for(FlightSearchSeatDto seat:returnseats){
                    BigDecimal curPrice = seat.getSalesPrice().multiply(new BigDecimal(input.getAdultsCount())).add(seat.getChildrenPrice().multiply(new BigDecimal(input.getChildCount())));
                    seat.setDifferentPrice(curPrice.subtract(backFlightBasePrice));
                }
                
                returnInfo.setSeats(returnseats);
            }
            
            List<InsuranceInfoDto> flightInsuranceInfos = shoppingDto.getFlightInsuranceInfos();
            model.addAttribute("flightInsuranceInfos", flightInsuranceInfos);
        }
		
		//---------处理酒店数据----------
		if (CollectionUtils.isNotEmpty(hotels)) {
			hotelSearchHotelDto = this.handleHotelResult(shoppingDto, input, hotelBasePrice);
		}

		// 默认显示的房间
		if (hotelSearchHotelDto != null && CollectionUtils.isNotEmpty(hotelSearchHotelDto.getRooms())) {
    		this.sortHotelRooms(hotelSearchHotelDto);
		}
		
	    //---------处理门票数据---------
		if(CollectionUtils.isNotEmpty(spotDtos)){
		    spotForm = new ArrayList<SpotSearchSpotForm>();
			for (SpotSearchSpotDto spotDto : spotDtos) {
				spotForm.add(new SpotSearchSpotForm(spotDto));
			}
		}
		
		//---------处理保险数据---------
        if (CollectionUtils.isNotEmpty(insurances)) {
            insuranceDto = insurances.get(0);
            for (InsuranceProdProduct product : insuranceDto.getInsuranceProductList()) {
                int insuranceCount = 0;
                for (InsuranceProdProductBranch branch :  product.getInsuranceProductBranchList()) {
                    insuranceCount += branch.getInsuranceSuppGoodList().size();
                    product.setInsuranceCount(insuranceCount);
                }
            }
		}
		
		model.addAttribute("toFlight", departureInfo);
		model.addAttribute("backFlight", returnInfo);
		model.addAttribute("hotel", hotelSearchHotelDto);
		model.addAttribute("stayDays", days);
		model.addAttribute("baseAmount", hotelBasePrice);
		model.addAttribute("toAmount", toFlightBasePrice);
		model.addAttribute("backAmount", backFlightBasePrice);

		model.addAttribute("tripType", input.getTripType()); //单程|往返
        model.addAttribute("spots", spotForm); //景点信息
        model.addAttribute("insuranceDto", insuranceDto); //保险信息
        
		logger.info("toFlightBasePrice="+toFlightBasePrice+",backFlightBasePrice="+backFlightBasePrice+",hotelBasePrice="+hotelBasePrice);
		return model;
	}

    private HotelSearchHotelForm handleHotelResult(FitShoppingDto shoppingDto,
            SearchConditionForm input, BigDecimal hotelBasePrice) {
        HotelSearchHotelForm hotelSearchHotelDto;
        hotelSearchHotelDto = new HotelSearchHotelForm(shoppingDto.getHotels().get(0));
        List<HotelSearchRoomDto> rooms = hotelSearchHotelDto.getRooms();
        List<HotelSearchRoomDto> availableRooms = new ArrayList<HotelSearchRoomDto>();
        
        if (CollectionUtils.isNotEmpty(rooms)) {
        	for(HotelSearchRoomDto room :rooms){
        		List<HotelSearchPlanDto> sortplans = new ArrayList<HotelSearchPlanDto>();
        		List<HotelSearchPlanDto> plans= room.getPlans();
        		if(CollectionUtils.isNotEmpty(plans)){
        			for(HotelSearchPlanDto plan :plans){
        				if(CollectionUtils.isNotEmpty(plan.getDayPrice())){//价格不为空
        					sortplans.add(plan);
        				}
        			}
        		}
        		if(CollectionUtils.isNotEmpty(sortplans)){
        			room.setPlans(sortplans);
        			availableRooms.add(room);
        		}
        		for(HotelSearchPlanDto plan :sortplans){
        			BigDecimal temPrice = new BigDecimal(0);
        			BigDecimal planSalesPrice = new BigDecimal(0);//销售价
        			Integer inventoryCount = null;//商品库存
        			List<Integer> inventoryCounts = new ArrayList<Integer>();//该商品所有天的库存集合
        			
        			for(FitHotelPlanPriceDto priceDto:plan.getDayPrice()){//计算出每个plan的价格之和，只包括天数，不包括房间数
        				temPrice = temPrice.add(priceDto.getSettlePrice());
        				planSalesPrice = planSalesPrice.add(priceDto.getSalesPrice());
        				if(priceDto.getStockFlag().equals("Y")){//只查保留房的库存
	    					inventoryCount = priceDto.getInventoryCount();
	    					inventoryCounts.add(inventoryCount);
        				}
        			}
        			plan.setSettlementPrice(temPrice);
        			plan.setPrice(planSalesPrice);
        			Integer roomcount=room.getRoomCounts();
        			if(roomcount == null){
        				roomcount =HotelUtils.getMinRoomCount(input.getAdultsCount(), input.getChildCount());
        			}
        			//plan.setPriceDifferences(//roomCount  
        			//				temPrice.multiply(new BigDecimal(roomcount)).subtract(hotelBasePrice));
        			plan.setMinRoomCounts(HotelUtils.getMinRoomCount(input.getAdultsCount(), input.getChildCount()));
        			int newRoomCount = roomcount<plan.getMaxQuantity()?roomcount:plan.getMinRoomCounts();
        			if(plan.getSelectedFlag()){
        				plan.setPriceDifferences(planSalesPrice.multiply(new BigDecimal(roomcount)).subtract(hotelBasePrice));
        			}else{
        				plan.setPriceDifferences(planSalesPrice.multiply(new BigDecimal(newRoomCount)).subtract(hotelBasePrice));
        			}
        			int maxRoomCount =input.getAdultsCount()<plan.getMaxQuantity()?input.getAdultsCount():plan.getMaxQuantity();
        			if(CollectionUtils.isNotEmpty(inventoryCounts)){
        				Collections.sort(inventoryCounts);
            			plan.setMaxRoomCounts(maxRoomCount>inventoryCounts.get(0)?inventoryCounts.get(0):maxRoomCount);
        			}else{
        				plan.setMaxRoomCounts(maxRoomCount);
        			}
        			
        		}
        	}
        }
        hotelSearchHotelDto.setRooms(availableRooms);
        return hotelSearchHotelDto;
    }


    private void sortHotelRooms(HotelSearchHotelForm hotelSearchHotelDto) {
        List<HotelSearchRoomDto> rooms = hotelSearchHotelDto.getRooms();
        
        for(HotelSearchRoomDto room :rooms){
        	List<HotelSearchPlanDto>  plans= room.getPlans();
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
        // 默认显示的房间
        List<HotelSearchPlanDto> plans = new ArrayList<HotelSearchPlanDto>();
        List<HotelSearchRoomDto> newrooms = new ArrayList<HotelSearchRoomDto>();
        List<HotelSearchPlanDto> newplans = new ArrayList<HotelSearchPlanDto>();
        for(HotelSearchRoomDto room :rooms){
        	if(room.getSelectedFlag() == true){
        		newrooms.add(0,room);//将选中的房间放在最上面显示
        		plans = room.getPlans();
        		for(HotelSearchPlanDto plan:plans){
        			if(plan.getSelectedFlag() == true){
        				newplans.add(0, plan);//将选中的plan放在最上面显示
        			} else {
        				newplans.add(plan);
        			}
        		}
        	} else {
        		newrooms.add(room);
        	}
        }
        for(HotelSearchRoomDto room :newrooms){
        	if(room.getSelectedFlag() == true){
        		room.setPlans(newplans);
        	}
        }
        hotelSearchHotelDto.setRooms(newrooms);
    }

	public FitSearchRequest convertToFit(SearchConditionForm input){
		FitSearchRequest fitSearchRequest = new FitSearchRequest();
		List<FlightQueryRequest> flightSearchRequests = new ArrayList<FlightQueryRequest>();
		fitSearchRequest.setTripType(input.getTripType());
		System.out.println("##############################"+fitSearchRequest.getTripType());
		// 飞机票参数封装
		// 去程参数封装
		FlightQueryRequest toflightQuery = new FlightQueryRequest();
		toflightQuery.setDepartureDate(DateUtils.parseDate(input.getDepartureTime()));
		toflightQuery.setReturnDate(input.getReturnTime());
		toflightQuery.setDepartureCityCode(input.getDepartureCityCode());
		toflightQuery.setArrivalCityCode(input.getArrivalCityCode());
		toflightQuery.setDepartureAirportCode(input.getDepartureCityCode());
		toflightQuery.setArrivalAirportCode(input.getArrivalCityCode());
		toflightQuery.setBookingSource(input.getBookingSource());
		toflightQuery.setFacet(true);
		flightSearchRequests.add(toflightQuery);
		// 回程参数封装
		//如果是往返则封装回程参数
		if(TripeType.WF.name().equals(input.getTripType())){
			FlightQueryRequest backflightQuery = new FlightQueryRequest();
			backflightQuery.setDepartureDate(DateUtils.parseDate(input.getReturnTime()));
			backflightQuery.setDepartureCityCode(input.getArrivalCityCode());
			backflightQuery.setArrivalCityCode(input.getDepartureCityCode());
			backflightQuery.setDepartureAirportCode(input.getArrivalCityCode());
			backflightQuery.setArrivalAirportCode(input.getDepartureCityCode());
			backflightQuery.setBookingSource(input.getBookingSource());
			backflightQuery.setFacet(true);
			flightSearchRequests.add(backflightQuery);
		}
		fitSearchRequest.setDepartureCityName(input.getDepartureCityName());
		fitSearchRequest.setArrivalCityName(input.getArrivalCityName());
		fitSearchRequest.setFlightSearchRequests(flightSearchRequests);

		// 酒店查询参数封装
		HotelQueryRequest hotelQueryRequest = new HotelQueryRequest();
		hotelQueryRequest.setCityDistrictId(String.valueOf(VSTDistrictCityEnum.getDistrictId(input.getCityCode())));
		hotelQueryRequest.setCityCode(input.getCityCode());
		hotelQueryRequest.setCityName(input.getCityName());
		hotelQueryRequest.setDepartureDate(input.getCheckInTime());
		hotelQueryRequest.setReturnDate(input.getCheckOutTime());
		hotelQueryRequest.setHotelFromRecommendedOnly(getHotelFromRecommended());
		//hotelQueryRequest.setRoomCounts(HotelUtils.getMinRoomCount(input.getAdultsCount(), input.getChildCount()));
		hotelQueryRequest.setAdultCount(input.getAdultsCount());
		//按驴妈妈默认推荐排序
		//hotelQueryRequest.setParams("S27");
		List<HotelQueryRequest> hotelSearchRequests = new ArrayList<HotelQueryRequest>();
		hotelSearchRequests.add(hotelQueryRequest);
		FitPassengerRequest passengerRequest = new FitPassengerRequest();
		passengerRequest.setAdultCount(input.getAdultsCount());
		passengerRequest.setChildCount(input.getChildCount());
		fitSearchRequest.setHotelSearchRequests(hotelSearchRequests);
		fitSearchRequest.setFitPassengerRequest(passengerRequest);
		
		//景点门票参数封装
		SpotQueryRequest spotQueryRequest = new SpotQueryRequest();
		String cityCode = hotelQueryRequest.getCityCode();
        Long districtId = VSTDistrictCityEnum.getDestId(cityCode);
		
		spotQueryRequest.setDestinationId(districtId.toString());
		spotQueryRequest.setVisitorNum(passengerRequest.getAdultCount()+passengerRequest.getChildCount());
		//景点的游玩日期为入驻日期的后一天
		Date startDate = DateUtils.parseDate(hotelQueryRequest.getDepartureDate());
		spotQueryRequest.setStartDate(DateUtils.getDateAfterDateDays(startDate, 1));
		spotQueryRequest.setEndDate(DateUtils.parseDate(hotelQueryRequest.getReturnDate()));
		List<SpotQueryRequest> spotQueryRequests = new ArrayList<SpotQueryRequest>();
		spotQueryRequests.add(spotQueryRequest);
		fitSearchRequest.setSpotQueryRequests(spotQueryRequests);
		
		if (!StringUtils.isBlank(input.getShoppingUUID())) {
			fitSearchRequest.setShoppingId(input.getShoppingUUID());
		}
		// 构造requestkey用于判断缓存中的选择门票信息是否应该清空。
		StringBuffer sb = new StringBuffer();
		final String split = "-";
		String requestKey = sb.append(input.getDepartureCityCode()).append(split)
		        .append(input.getArrivalCityCode()).append(split)
		        .append(input.getCityCode()).append(split)
		        .append(input.getCheckInTime()).append(split)
		        .append(input.getDepartureTime()).append(split)
		        .append(input.getReturnTime()).append(split)
		        .append(input.getAdultsCount()).append(split)
		        .append(input.getChildCount())
		        .append(input.getTripType())
		        .toString();
		fitSearchRequest.setRequestKey(requestKey);
		
		/** 保险参数封装开始 **/
        InsuranceQueryRequest insuranceQueryRequest = new InsuranceQueryRequest();
        insuranceQueryRequest.setCurrentProductId(636165l);
        insuranceQueryRequest.setDistributorId(3l);
        if(TripeType.WF.name().equals(input.getTripType())){
			int insuranceDays = DateUtils.getDateDiffByDay(DateUtils.parseDate(input.getReturnTime()), DateUtils.parseDate(input.getDepartureTime())) + 1;
        	insuranceQueryRequest.setInsuranceDays((long)insuranceDays);
        	insuranceQueryRequest.setVistorDate(DateUtils.parseDate(input.getDepartureTime()));
        }else{ //单程的被保天数
        	insuranceQueryRequest.setInsuranceDays(1l);
        	insuranceQueryRequest.setVistorDate( DateUtils.parseDate(input.getDepartureTime()));
        }
        insuranceQueryRequest.setPersonNum(passengerRequest.getAdultCount()+passengerRequest.getChildCount());
        fitSearchRequest.setInsuranceQueryRequest(insuranceQueryRequest);
		/** 保险参数封装结束 **/
		
		return fitSearchRequest;
		
	}
	public SearchConditionForm convertToForm(FitSearchRequest searchRequest,SearchConditionForm input){
		//SearchConditionForm input = new SearchConditionForm();

		input.setAdultsCount(searchRequest.getFitPassengerRequest().getAdultCount());
		if(CollectionUtils.isNotEmpty(searchRequest.getFlightSearchRequests()) && searchRequest.getFlightSearchRequests().get(0) != null){
			input.setArrivalCityCode(searchRequest.getFlightSearchRequests().get(0).getArrivalCityCode());
			input.setDepartureCityCode(searchRequest.getFlightSearchRequests().get(0).getDepartureCityCode());
			input.setDepartureTime(DateUtil.formatDate(searchRequest.getFlightSearchRequests().get(0).getDepartureDate(), DateUtils.YYYY_MM_DD));
			input.setReturnTime(searchRequest.getFlightSearchRequests().get(0).getReturnDate());
		}
		if(CollectionUtils.isNotEmpty(searchRequest.getHotelSearchRequests()) && searchRequest.getHotelSearchRequests().get(0) != null){
			input.setCheckInTime(searchRequest.getHotelSearchRequests().get(0).getDepartureDate());
			input.setCheckOutTime(searchRequest.getHotelSearchRequests().get(0).getReturnDate());			
			input.setCityCode(searchRequest.getHotelSearchRequests().get(0).getCityCode());
			input.setCityName(searchRequest.getHotelSearchRequests().get(0).getCityName());
		}
		if(searchRequest.getFitPassengerRequest() != null){
			input.setChildCount(searchRequest.getFitPassengerRequest().getChildCount());
		}
		input.setDepartureCityName(searchRequest.getDepartureCityName());
		input.setArrivalCityName(searchRequest.getArrivalCityName());
		return input;
		
	}
	
	public SearchConditionForm setInputForm(SearchConditionForm input){
		input.setAdultsCount(2);
		input.setChildCount(0);
		String curr = DateUtils.parseDate(System.currentTimeMillis(),DateUtils.YYYY_MM_DD);
		SimpleDateFormat ft = new SimpleDateFormat(DateUtils.YYYY_MM_DD);
		Date date = new Date();
		try {
			date = ft.parse(curr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date checkInTime = DateUtils.getDateAfterDateDays(date, 2);//当前日期加两天
		input.setCheckInTime(ft.format(checkInTime));
		Date checkOutTime = DateUtils.getDateAfterDateDays(checkInTime, 3);//去程时间再加3天
		input.setCheckOutTime(ft.format(checkOutTime));
		input.setDepartureTime(ft.format(checkInTime));
		input.setReturnTime(ft.format(checkOutTime));
		 return input;
	}

	public Boolean getHotelFromRecommended() {
			
			return Boolean.valueOf(CustomizedPropertyPlaceholderConfigurer.getContextProperty(hotelFromRecommended)+"");
	}
}
