package com.lvmama.lvfit.dp.booking.service.impl;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvf.common.utils.StringUtil;
import com.lvmama.lvfit.common.aspect.exception.ExceptionPoint;
import com.lvmama.lvfit.common.client.FitBusinessClient;
import com.lvmama.lvfit.common.dto.calculator.AmountCalculatorRequest;
import com.lvmama.lvfit.common.dto.calculator.BookingDetailDto;
import com.lvmama.lvfit.common.dto.calculator.FlightSimpleInfoDto;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.FitBusinessExceptionType;
import com.lvmama.lvfit.common.dto.enums.FitOrderResultStatus;
import com.lvmama.lvfit.common.dto.enums.FitOrderStatusType;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.PassengerType;
import com.lvmama.lvfit.common.dto.enums.ProductResource;
import com.lvmama.lvfit.common.dto.enums.TripeType;
import com.lvmama.lvfit.common.dto.enums.VSTDistrictCityEnum;
import com.lvmama.lvfit.common.dto.order.FitOrderAmountDto;
import com.lvmama.lvfit.common.dto.order.FitOrderBasicInfoDto;
import com.lvmama.lvfit.common.dto.order.FitOrderFlightDto;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelDto;
import com.lvmama.lvfit.common.dto.order.FitOrderInsuranceDto;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.order.FitOrderMsgDto;
import com.lvmama.lvfit.common.dto.order.FitOrderPassengerDto;
import com.lvmama.lvfit.common.dto.order.FitOrderSpotTicketDto;
import com.lvmama.lvfit.common.dto.request.CalculateAmountRequest;
import com.lvmama.lvfit.common.dto.request.FitBaseSearchRequest;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;
import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchPlanDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchRoomDto;
import com.lvmama.lvfit.common.dto.shopping.FitFlightAmountDto;
import com.lvmama.lvfit.common.dto.shopping.FitFlightPriceDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingAmountDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedInsuranceDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedTicketDto;
import com.lvmama.lvfit.common.dto.shopping.FlightInsuranceDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingDetailDto;
import com.lvmama.lvfit.common.dto.trace.FitOrderTraceContext;
import com.lvmama.lvfit.dp.booking.domain.FitOrderFlight;
import com.lvmama.lvfit.dp.booking.domain.FitOrderHotel;
import com.lvmama.lvfit.dp.booking.domain.FitOrderInsurance;
import com.lvmama.lvfit.dp.booking.domain.FitOrderSpotTicket;
import com.lvmama.lvfit.dp.booking.service.FitBookingService;
import com.lvmama.lvfit.dp.service.FitDpService;
import com.lvmama.lvfit.dp.shopping.service.ShopingCalculateService;
import com.lvmama.lvfit.dp.shopping.service.ShoppingService;
import com.lvmama.lvfit.dp.shopping.service.ShoppingViewService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class FitBookingServiceImpl implements FitBookingService {

    private static final Logger logger = LoggerFactory.getLogger(FitBookingServiceImpl.class);

    @Autowired
    private FitBusinessClient fitBusinessClient;

    @Autowired
    private ShoppingViewService shoppingViewService;

    @Autowired
    private ShopingCalculateService shopingCalculateService;

    @Autowired
    private FitDpService fitDpService; 
    
    @Autowired
    private ShoppingService shoppingService;
    
    @Override
    @ExceptionPoint(value = FitBusinessExceptionType.BOOKING_E)
    public BaseSingleResultDto<FitOrderMainDto> booking(FitOrderBookingRequest fit) {
        BaseSingleResultDto<FitOrderMainDto> bookingResult = new BaseSingleResultDto<FitOrderMainDto>();
        FitOrderMainDto orderMainDto = null;
        try {
            if(logger.isInfoEnabled()){
                logger.info("[Dp-core]预定请求参数FitOrderBookingRequest："+ JSONMapper.getInstance().writeValueAsString(fit));
            }

            //获取缓存中shopping信息，补全请求对象
            this.completeBookingRequest(fit);
             
            //计算价格
            this.checkOrderTotalSalesAmount(fit);
            if(logger.isInfoEnabled()) {
                logger.info("[Dp-core]预定请求参数FitOrderBookingRequest：" + JSONMapper.getInstance().writeValueAsString(fit));
            }
            //预定
            orderMainDto = fitBusinessClient.booking(fit);

            // 记录VST订单状态，并将异常信息保存在ThreadLocal中
            FitOrderMsgDto orderMsgDto = new FitOrderMsgDto(FitOrderStatusType.VST_ORDER_STATUS, FitOrderResultStatus.SUCCESS, "");
            FitOrderTraceContext.setOrderMsg(orderMsgDto);
            
            bookingResult.setResult(orderMainDto);
            return bookingResult;
        } catch (Exception e) {
            logger.error("[Dp-core]请求下单异常：", e);
            if(e instanceof ExceptionWrapper){
                ExceptionWrapper ew = (ExceptionWrapper)e;
                // 记录VST订单状态，并将异常信息保存在ThreadLocal中
                FitOrderMsgDto orderMsgDto = new FitOrderMsgDto(FitOrderStatusType.VST_ORDER_STATUS, FitOrderResultStatus.FAIL, ew.getErrMessage());
                FitOrderTraceContext.setOrderMsg(orderMsgDto);
                throw ew;
            }else{
                // 记录VST订单状态，并将异常信息保存在ThreadLocal中
            	FitOrderMsgDto orderMsgDto = new FitOrderMsgDto(FitOrderStatusType.VST_ORDER_STATUS, FitOrderResultStatus.FAIL, e.getMessage());
            	FitOrderTraceContext.setOrderMsg(orderMsgDto);
                throw new RuntimeException(e);
            }
        } finally {
            String uuid = fit.getShoppingUuid();
            List<FitOrderMsgDto> orderMsgDtos = FitOrderTraceContext.getOrderMsg();
            try {
                if(logger.isInfoEnabled()){
                    logger.info("错误信息map， map=" + JSONMapper.getInstance().writeValueAsString(orderMsgDtos));
                }
			} catch (Exception ep) {
				ep.printStackTrace();
			} 
            try {
                this.updOrderStatusInfo(orderMsgDtos, uuid);
            } catch (Exception e) {
                logger.error("更新订单信息到ShoppingMapper中失败， uuid=" + uuid,e);
            }
        }
    }

    private void completeBookingRequest(FitOrderBookingRequest fit) {
    	
        //1. 根据ShoppingUuid获取shopping信息
        BaseSingleResultDto<FitShoppingDto> shoppingResult = shoppingViewService.getShoppingByShoppingUUID(fit.getShoppingUuid());
        FitShoppingDto selectShoppingDto = shoppingResult.getResult();
        if (null == selectShoppingDto) {
            throw new ExceptionWrapper(ExceptionCode.UNDEF_ERROR);
        }
        //2. 调用酒店查询接口，验证酒店库存 
        this.checkHotelInventory(selectShoppingDto);
        fit.setCategoryId(com.lvmama.lvfit.common.dto.enums.BizEnum.BIZ_CATEGORY_TYPE.category_route_aero_hotel.getCategoryId());
        
        //3. 异步保存shopping信息
        FitShoppingDto oldShoppingDto = shoppingResult.getResult();
        selectShoppingDto.setContacter(fit.getFitOrderContacterDto());
        selectShoppingDto.setCustomer(fit.getFitOrderCustomerDto());
        selectShoppingDto.setPassenger(fit.getFitOrderPassengerDtos());
        selectShoppingDto.setShoppingUuid(fit.getShoppingUuid());
        selectShoppingDto.setFlightInsuranceInfos(oldShoppingDto.getFlightInsuranceInfos());
        selectShoppingDto.setSpots(oldShoppingDto.getSpots());
        selectShoppingDto.setInsurances(oldShoppingDto.getInsurances());
        selectShoppingDto.setAmount(oldShoppingDto.getAmount());
        this.saveShopping(selectShoppingDto);

        FitBaseSearchRequest searchRequest = selectShoppingDto.getSearchRequest();
        //4. 置入成人数、儿童数信息、出发到达城市等用户访问基本信息
        this.buildFitOrderBasicInfo(fit, searchRequest);
        
        //5.构造机酒订单酒店信息
        this.buildFitOrderHotelInfo(fit, selectShoppingDto);
        
        //6. 构造机酒订单航班信息
        this.buildFitOrderFlightInfo(fit, selectShoppingDto, searchRequest);
        
       //7. 构造机酒订单门票信息
        this.buildFitOrderSpotTicketInfo(fit,selectShoppingDto);
        
       //8. 构造机酒订单保险信息
        this.buildFitOrderInsuranceInfo(fit,selectShoppingDto);
        // 构造机票保险信息
        this.buildFlightInsuranceInfo(fit, selectShoppingDto);
    }

	private void buildFlightInsuranceInfo(FitOrderBookingRequest fit, FitShoppingDto shoppingDto) {
        List<FitOrderPassengerDto> fitOrderPassengerDtos = fit.getFitOrderPassengerDtos(); // 取得乘客信息
        List<FlightInsuranceDto> selectFlightInsInfo = shoppingDto.getSelectFlightInsInfo(); // 取得选中的航意险信息
        if (CollectionUtils.isEmpty(selectFlightInsInfo)) {
            return;
        }
        // 往返航班每个乘客两份保险
        List<FlightSearchFlightInfoDto> flightInfos = shoppingDto.getFlightInfos();
        
        if (shoppingDto.getSearchRequest().getTripType().equals(TripeType.WF.name())) {
            String depFlightNo = flightInfos.get(0).getFlightNo();
            String arvFlightNo = flightInfos.get(1).getFlightNo();
            for (FitOrderPassengerDto passenger : fitOrderPassengerDtos) {
                List<FlightInsuranceDto> resultList = new ArrayList<FlightInsuranceDto>();
                for (FlightInsuranceDto fliInsDto : selectFlightInsInfo) {
                    FlightInsuranceDto depfliInsuranceDto = new FlightInsuranceDto();
                    FlightInsuranceDto arvfliInsuranceDto = new FlightInsuranceDto();
                    try {
                        BeanUtils.copyProperties(depfliInsuranceDto, fliInsDto);
                        BeanUtils.copyProperties(arvfliInsuranceDto, fliInsDto);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    depfliInsuranceDto.setFlightNo(depFlightNo);
                    depfliInsuranceDto.setInsuranceCount(1);
                    arvfliInsuranceDto.setFlightNo(arvFlightNo);
                    arvfliInsuranceDto.setInsuranceCount(1);

                    resultList.add(depfliInsuranceDto);
                    resultList.add(arvfliInsuranceDto);
                }
                passenger.setFlightInsuranceDto(resultList);
            }
        }
        // 单程航班每个乘客一份保险
        if (shoppingDto.getSearchRequest().getTripType().equals(TripeType.DC.name())) {
            String FlightNo = flightInfos.get(0).getFlightNo();
            for (FitOrderPassengerDto passenger : fitOrderPassengerDtos) {
                List<FlightInsuranceDto> resultList = new ArrayList<FlightInsuranceDto>();
                for (FlightInsuranceDto fliInsDto : selectFlightInsInfo) {
                    FlightInsuranceDto fliInsuranceDto = new FlightInsuranceDto();
                    try {
                        BeanUtils.copyProperties(fliInsuranceDto, fliInsDto);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    fliInsuranceDto.setFlightNo(FlightNo);
                    fliInsuranceDto.setInsuranceCount(1);
                    
                    resultList.add(fliInsuranceDto);
                }
                passenger.setFlightInsuranceDto(resultList);
            }
        }
        fit.setFitOrderPassengerDtos(fitOrderPassengerDtos);
    }

    private void buildFitOrderBasicInfo(FitOrderBookingRequest fit,
			FitBaseSearchRequest searchRequest) {

        FitOrderBasicInfoDto fitOrderBasicInfoDto = new FitOrderBasicInfoDto();
        fitOrderBasicInfoDto.setAdultQuantity(searchRequest.getAdultsCount());
        fitOrderBasicInfoDto.setChildQuantity(searchRequest.getChildCount());
        fitOrderBasicInfoDto.setDepCityCode(VSTDistrictCityEnum.getCodeByCnName(searchRequest.getDepartureCityName()));
        fitOrderBasicInfoDto.setArriCityCode(VSTDistrictCityEnum.getCodeByCnName(searchRequest.getArrivalCityName()));
        fitOrderBasicInfoDto.setToTime(DateUtils.parseDate(searchRequest.getDepartureTime(), DateUtils.YYYY_MM_DD));
        fitOrderBasicInfoDto.setVisitTime(searchRequest.getDepartureTime());
        if(searchRequest.getTripType().equals(TripeType.WF.name())){
            fitOrderBasicInfoDto.setReturnTime(DateUtils.parseDate(searchRequest.getReturnTime(), DateUtils.YYYY_MM_DD));
        }
        fitOrderBasicInfoDto.setCheckInCityCode(searchRequest.getCityCode());
        fitOrderBasicInfoDto.setCheckInTime(DateUtils.parseDate(searchRequest.getCheckInTime()));
        fitOrderBasicInfoDto.setCheckOutTime(DateUtils.parseDate(searchRequest.getCheckOutTime()));

        fit.setFitOrderBasicInfoDto(fitOrderBasicInfoDto);
	}

	private void buildFitOrderSpotTicketInfo(FitOrderBookingRequest fit,FitShoppingDto selectShoppingDto) {

		//构造机酒订单门票信息
		List<FitOrderSpotTicketDto> fitOrderSpotTicketDtos = fit.getFitOrderSpotTicketDtos();
		for (FitShoppingSelectedTicketDto selectedTicketDto : selectShoppingDto.getSelectTicketInfo()) {
			FitOrderSpotTicketDto fitOrderSpotTicketDto = new FitOrderSpotTicketDto();
			FitOrderSpotTicket fiOrderSpotTicket = new FitOrderSpotTicket(fitOrderSpotTicketDto);
			fitOrderSpotTicketDto =  fiOrderSpotTicket.buildFitOrderSpotTicketDto(selectedTicketDto);
			fitOrderSpotTicketDtos.add(fitOrderSpotTicketDto);
		}
	}
	
	private void buildFitOrderInsuranceInfo(FitOrderBookingRequest fit,FitShoppingDto selectShoppingDto) {
		//构造机酒订单保险信息
		List<FitOrderInsuranceDto> fitOrderInsuranceDtos = fit.getFitOrderInsuranceDtos();
		for (FitShoppingSelectedInsuranceDto selectedInsuranceDto : selectShoppingDto.getSelectInsuranceInfo()) {
			FitOrderInsuranceDto fitOrderInsuranceDto = new FitOrderInsuranceDto();
			FitOrderInsurance fitOrderInsurance = new FitOrderInsurance(fitOrderInsuranceDto);
			fitOrderInsuranceDto =  fitOrderInsurance.buildFitOrderInsuranceDto(selectedInsuranceDto);
			fitOrderInsuranceDtos.add(fitOrderInsuranceDto);
		}
	}

	private void buildFitOrderFlightInfo(FitOrderBookingRequest fit, FitShoppingDto selectShoppingDto,
			FitBaseSearchRequest searchRequest) {
		//构造机酒订单航班信息
        List<FitOrderFlightDto> fitOrderFlightDtos = fit.getFitOrderFlightDtos();
        for (int i = 0 ; i < selectShoppingDto.getFlightInfos().size(); i++) {
            FlightSearchFlightInfoDto searchFlight = selectShoppingDto.getFlightInfos().get(i);
            FlightSearchSeatDto searchSeat = searchFlight.getSeats().get(0);
            //构造机酒订单航班信息
            FitOrderFlightDto fitOrderFlightDto = new FitOrderFlightDto();
            FitOrderFlight fitOrderFlight = new FitOrderFlight(fitOrderFlightDto);
            if (i == 0) {
                fitOrderFlightDto = fitOrderFlight.buildFitOrderFlightDto(searchFlight, searchSeat, FlightTripType.DEPARTURE);
            }
            if (i == 1) {
                fitOrderFlightDto = fitOrderFlight.buildFitOrderFlightDto(searchFlight, searchSeat, FlightTripType.RETURN);
            }
            //置入酒订单航班信息价格信息
            CalculateAmountRequest calculateAmountRequest = new CalculateAmountRequest();
            List<FlightSearchFlightInfoDto> selectSearchFlightInfoDtos = new ArrayList<FlightSearchFlightInfoDto>();
            selectSearchFlightInfoDtos.add(searchFlight);
            searchRequest.setBookingSource(fit.getBookingSource());
            AmountCalculatorRequest calculatorRequest = calculateAmountRequest.getFlightPriceRequest(selectSearchFlightInfoDtos, searchRequest);
            FitFlightAmountDto flightAmountDto =  shopingCalculateService.calculateFlightAmount(calculatorRequest);
            fitOrderFlightDto.setSalesPrice(flightAmountDto.getTotalSalesAmount());
            fitOrderFlightDtos.add(fitOrderFlightDto);
       }
	}

	private void buildFitOrderHotelInfo(FitOrderBookingRequest fit, FitShoppingDto shoppingDto) {
        String checkIn = shoppingDto.getSearchRequest().getCheckInTime();
        String checkOut = shoppingDto.getSearchRequest().getCheckOutTime();

        //构造机酒订单酒店信息
        List<FitOrderHotelDto> fitOrderHotelDtos = fit.getFitOrderHotelDtos();

        if (shoppingDto.getHotels() == null || CollectionUtils.isEmpty(shoppingDto.getHotels().getResults())) {
            return;
        }
        HotelSearchHotelDto selectHotel = shoppingDto.getHotels().getResults().get(0);
        HotelSearchRoomDto selectRoom = selectHotel.getRooms().get(0);
        HotelSearchPlanDto selectPlan = selectRoom.getPlans().get(0);
        //构造机酒订单酒店信息
        FitOrderHotelDto fitOrderHotelDto = new FitOrderHotelDto();
        FitOrderHotel fitOrderHotel = new FitOrderHotel(fitOrderHotelDto);
        fitOrderHotelDto = fitOrderHotel.buildFitOrderHotelDto(selectHotel, selectRoom, selectPlan);
        fitOrderHotelDto.setCheckin(DateUtils.parseDate(checkIn));
        fitOrderHotelDto.setCheckout(DateUtils.parseDate(checkOut));
        fitOrderHotelDto.setProductResource(ProductResource.VST);
        fitOrderHotelDto.setCheckInCity(shoppingDto.getSearchRequest().getCityCode());
        fitOrderHotelDtos.add(fitOrderHotelDto);
	}

    
    /**
     * 校验酒店库存是否足够
     * @param shoppingDto
     */
	private void checkHotelInventory(FitShoppingDto shoppingDto) {
		List<HotelSearchHotelDto> shoppingHotels  = shoppingDto.getHotels().getResults();
		if(CollectionUtils.isNotEmpty(shoppingHotels)) {
            FitBaseSearchRequest request = shoppingDto.getSearchRequest();

            HotelQueryRequest hotelQueryRequest = new HotelQueryRequest();
            hotelQueryRequest.setCityDistrictId(String.valueOf(VSTDistrictCityEnum.getDistrictId(request.getCityCode())));
            hotelQueryRequest.setCityCode(request.getCityCode());
            hotelQueryRequest.setCityName(request.getCityName());
            hotelQueryRequest.setDepartureDate(request.getCheckInTime());
            hotelQueryRequest.setReturnDate(request.getCheckOutTime());
            hotelQueryRequest.setHotelFromRecommendedOnly(false);
            hotelQueryRequest.setQueryId(request.getShoppingUUID());
            hotelQueryRequest.setAdultCount(request.getAdultsCount());
            hotelQueryRequest.setChildCount(request.getChildCount());

            String productId = "";
            for(HotelSearchHotelDto dto:shoppingHotels){
                productId = dto.getProductId();
            }
            if( null != hotelQueryRequest && StringUtils.isNotBlank(productId)){
                hotelQueryRequest.setKeywords(productId);
            }
            List<HotelSearchHotelDto> resultHotelList = fitDpService.hotelSearch(hotelQueryRequest);
            //酒店接口返回酒店列表的时候，已经进行了库存判断，返回结果中的酒店以及plan一定是库存充足的酒店，
            //所以只需要判断列表中是否有购物车中的酒店及酒店的plan即可
            boolean flag = false;
            String suppGoodsId = "";
            for(HotelSearchHotelDto hotel:shoppingHotels){
                HotelSearchHotelDto hotelDto= shoppingHotels.get(0);
                if(null != hotelDto){
                    List<HotelSearchRoomDto> rooms =  hotelDto.getRooms();
                    for(HotelSearchRoomDto room:rooms){
                        List<HotelSearchPlanDto> plans = room.getPlans();
                        if(CollectionUtils.isNotEmpty(plans)){
                            suppGoodsId = plans.get(0).getSuppGoodsId();
                        }
                    }
                }
            }
            Long days = DateUtils.getDateDiffByDay(hotelQueryRequest.getDepartureDate(), hotelQueryRequest.getReturnDate());
            if(CollectionUtils.isNotEmpty(resultHotelList)){
                HotelSearchHotelDto hotelDto= resultHotelList.get(0);
                if(null != hotelDto){
                    List<HotelSearchRoomDto> rooms =  hotelDto.getRooms();
                    for(HotelSearchRoomDto room:rooms){
                        List<HotelSearchPlanDto> plans = room.getPlans();
                        for(HotelSearchPlanDto plan : plans){
                            if (null != suppGoodsId || !"".equals(suppGoodsId)){
                                if(suppGoodsId.equals(plan.getSuppGoodsId())){
                                    /*if(CollectionUtils.isNotEmpty(plan.getDayPrice())){
                                        List<FitHotelPlanPriceDto> dayPrice = plan.getDayPrice();
                                        if(CollectionUtils.isNotEmpty(dayPrice) && dayPrice.size() >=days){
                                            flag = true;
                                        }
                                    }*/
                                    return;
                                }
                            }
                        }

                    }
                    if (null == suppGoodsId || "".equals(suppGoodsId)){//说明返回的结果中，没有购物车的那个酒店的plan了，所以报错吧
                        throw new ExceptionWrapper(ExceptionCode.GET_HOTEL_PRICE_FAIL);
                    }
                } else {
                    throw new ExceptionWrapper(ExceptionCode.GET_HOTEL_PRICE_FAIL);
                }

            } else {//酒店已售完
                throw new ExceptionWrapper(ExceptionCode.GET_HOTEL_PRICE_FAIL);
            }
            /*if(!flag){
                throw new ExceptionWrapper(ExceptionCode.GET_HOTEL_PRICE_FAIL);
            }*/
		}
	}

    //异步保存购物车信息
    @Async
    private void saveShopping(FitShoppingDto shoppingDto) {
        try {
            fitBusinessClient.saveOrUpdateShopping(shoppingDto);
            shoppingService.putShoppingCache(shoppingDto.getShoppingUuid(), shoppingDto);
        } catch (Exception e) {
            logger.error("[Dp-core]保存购物车信息异常：", e);
        }
    }

    @Override
    public void checkOrderTotalSalesAmount(FitOrderBookingRequest fit) {
        //计算订单总销售金额
        CalculateAmountRequest calculateAmountRequest = new CalculateAmountRequest();
        calculateAmountRequest.setShoppingUUID(fit.getShoppingUuid());
        calculateAmountRequest.setBookingSource(fit.getBookingSource());
        BaseSingleResultDto<FitShoppingAmountDto> resultDto = shopingCalculateService.calculateAmount(calculateAmountRequest);
    	
        FitShoppingAmountDto shoppingAmountDto = resultDto.getResult();
        BigDecimal totalSalesAmount = shoppingAmountDto.getTotalSalesAmount();
        
        FitOrderAmountDto calculated = new FitOrderAmountDto();
        calculated.setTotalSalesAmount(totalSalesAmount);
        fit.setFitOrderAmountDto(calculated);

        //计算：机票成人单价、机票儿童单价
        for (FitOrderFlightDto f : fit.getFitOrderFlightDtos()) {
        	
        	FitOrderFlightDto curFitOrderFlightDto = new FitOrderFlightDto();
        	try {
        		curFitOrderFlightDto = JSONMapper.getInstance().readValue(JSONMapper.getInstance().writeValueAsString(f), FitOrderFlightDto.class);
			} catch (Exception e) {
				logger.error(e.getMessage());
			} 
            if (fit.getAdultQuantity() > 0) {
            	AmountCalculatorRequest  adultRequest = this.getCalculatorRequest(curFitOrderFlightDto,PassengerType.ADULT,
            			BookingSource.valueOf(fit.getBookingSource().getParentSource().name()));
            	FitFlightPriceDto flightPrice = shopingCalculateService.calculateSingelFlightPrice(adultRequest);
	            f.setAdultPrice(flightPrice.getSalesPrice());
            }
            if (fit.getChildQuantity() > 0) {
            	AmountCalculatorRequest  childRequest =  this.getCalculatorRequest(curFitOrderFlightDto,PassengerType.CHILDREN,
            			BookingSource.valueOf(fit.getBookingSource().getParentSource().name()));
                FitFlightPriceDto flightPrice = shopingCalculateService.calculateSingelFlightPrice(childRequest);
                f.setChildPrice(flightPrice.getSalesPrice());
            }
        }
    }
    
    //将ThreadLocal中保存的错误日志信息保存到数据库中
    private void updOrderStatusInfo(List<FitOrderMsgDto> orderMsgDtos, String uuid)
            throws  Exception {
        ShoppingDetailDto shoppingDto = fitBusinessClient.getShoppingInfo(uuid);
        if(CollectionUtils.isNotEmpty(orderMsgDtos)){
        	for (FitOrderMsgDto orderMsgDto : orderMsgDtos) {
        		
        		FitOrderResultStatus status = orderMsgDto.getStatus();
		        String msg = StringUtil.getSortSring(orderMsgDto.getMsg(),100);
		        
				if(orderMsgDto.getOrderStatusType()==FitOrderStatusType.VST_ORDER_STATUS){
			            shoppingDto.setVstOrderStatus(status);
			            shoppingDto.setVstOrderMsg(msg);
				}
				
				if(orderMsgDto.getOrderStatusType()==FitOrderStatusType.DEP_FLI_ORDER_STATUS){
			            shoppingDto.setDepFliOrderStatus(status);
			            shoppingDto.setDepFliOrderMsg(msg);
				}
				
				if(orderMsgDto.getOrderStatusType()==FitOrderStatusType.ARV_FLI_ORDER_STATUS){
					   shoppingDto.setArvFliOrderStatus(status);
			           shoppingDto.setArvFliOrderMsg(msg);
				}
			}
        }
        fitBusinessClient.updShoppingInfo(shoppingDto);
    }
    
    
    /**
     * 根据订单航班信息获取机票算价请求对象
     * @param orderFlightDto
     * @return
     */
    public AmountCalculatorRequest getCalculatorRequest(FitOrderFlightDto orderFlightDto,PassengerType passengerType,BookingSource bookingSource){
    	List<BookingDetailDto>  bookingDetailDtos= new ArrayList<BookingDetailDto>();
		AmountCalculatorRequest request = new AmountCalculatorRequest();
		BookingDetailDto bookingDetailDto = new BookingDetailDto();
		FlightSimpleInfoDto flightSimpleInfoDto = new FlightSimpleInfoDto();
		flightSimpleInfoDto.setDepartureDate(DateUtils.parseDate(orderFlightDto.getDepartureDate(), DateUtils.YYYY_MM_DD));
		flightSimpleInfoDto.setFlightNo(orderFlightDto.getFlightNo());
		//flightSimpleInfoDto.setPolicyId();
		//flightSimpleInfoDto.setPricePolicyId(orderFlightDto.getPricePolicyId());
		flightSimpleInfoDto.setSeatClassCode(orderFlightDto.getSeatClassCode());
		flightSimpleInfoDto.setDepartureAirportCode(orderFlightDto.getDepartureAirportCode());
		flightSimpleInfoDto.setArrivalAirportCode(orderFlightDto.getArrivalAirportCode());
		bookingDetailDto.setFlightSimpleInfo(flightSimpleInfoDto);
		bookingDetailDto.setPassengerType(passengerType);
		bookingDetailDtos.add(bookingDetailDto);
		request.setBookingSource(bookingSource);
		request.setPassengerDetailDtos(bookingDetailDtos);
		return request;
    }
}
