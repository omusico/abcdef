package com.lvmama.lvfit.sdp.booking.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.enums.SuppSaleType;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.aspect.exception.ExceptionPoint;
import com.lvmama.lvfit.common.client.FitBusinessClient;
import com.lvmama.lvfit.common.dto.calculator.AmountCalculatorRequest;
import com.lvmama.lvfit.common.dto.calculator.BookingDetailDto;
import com.lvmama.lvfit.common.dto.calculator.CalculateRuleDto;
import com.lvmama.lvfit.common.dto.calculator.FlightSimpleInfoDto;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.FitBusinessExceptionType;
import com.lvmama.lvfit.common.dto.enums.PassengerType;
import com.lvmama.lvfit.common.dto.enums.ProductResource;
import com.lvmama.lvfit.common.dto.order.FitOrderAmountDto;
import com.lvmama.lvfit.common.dto.order.FitOrderBasicInfoDto;
import com.lvmama.lvfit.common.dto.order.FitOrderFlightDto;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelComboDto;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelDto;
import com.lvmama.lvfit.common.dto.order.FitOrderInsuranceDto;
import com.lvmama.lvfit.common.dto.order.FitOrderLocalTripProductDto;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.order.FitOrderOtherTicketDto;
import com.lvmama.lvfit.common.dto.order.FitOrderRoomDiffDto;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;
import com.lvmama.lvfit.common.dto.sdp.calculator.FitSdpShoppingAmountDto;
import com.lvmama.lvfit.common.dto.sdp.calculator.request.FitSdpCalculateAmountRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelRoomtypeDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductFeeRulesDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpSelectInsuranceDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpSelectOtherTicketDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpShoppingDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.request.FitSdpShoppingRequest;
import com.lvmama.lvfit.common.dto.search.FitPassengerRequest;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;
import com.lvmama.lvfit.common.dto.shopping.FitFlightAmountDto;
import com.lvmama.lvfit.sdp.booking.domain.FitOrderFlight;
import com.lvmama.lvfit.sdp.booking.domain.FitOrderHotel;
import com.lvmama.lvfit.sdp.booking.domain.FitOrderHotelCombo;
import com.lvmama.lvfit.sdp.booking.domain.FitOrderInsurance;
import com.lvmama.lvfit.sdp.booking.domain.FitOrderLocalTripProduct;
import com.lvmama.lvfit.sdp.booking.domain.FitOrderOtherTicket;
import com.lvmama.lvfit.sdp.booking.domain.FitOrderRoomDiff;
import com.lvmama.lvfit.sdp.booking.service.FitSdpBookingService;
import com.lvmama.lvfit.sdp.shopping.FitSdpShopingCalculateService;
import com.lvmama.lvfit.sdp.shopping.FitSdpShoppingService;

@Service
public class FitSdpBookingServiceImpl implements FitSdpBookingService {
	
	private static final Logger logger = LoggerFactory.getLogger(FitSdpBookingServiceImpl.class);
	
	@Autowired
	private FitSdpShoppingService fitSdpShoppingService; 
	
	@Autowired
	private FitSdpShopingCalculateService fitSdpShopingCalculateService;
	
	@Autowired
	private FitBusinessClient fitBusinessClient; 
	
	@Override
	@ExceptionPoint(FitBusinessExceptionType.FIT_SDP_BOOKING_E)
	public BaseSingleResultDto<FitOrderMainDto> booking(FitOrderBookingRequest bookingRequest) {
		
		BaseSingleResultDto<FitOrderMainDto> resultDto = new BaseSingleResultDto<FitOrderMainDto>();
		try {
			//组装订单的请求参数信息
			this.completeBookingRequest(bookingRequest);
			//计算订单销售价
	        this.setOrderSalesAmount(bookingRequest);
	        logger.info("下单请求报文22：bookingRequest="+JSONMapper.getInstance().writeValueAsString(bookingRequest));
	        FitOrderMainDto orderMainDto  = fitBusinessClient.booking(bookingRequest);
	        resultDto.setResult(orderMainDto);
		} catch (Exception e) {
		    logger.error("[sdp-core]请求下单异常：", e);
            if(e instanceof ExceptionWrapper){
                ExceptionWrapper ew = (ExceptionWrapper)e;
                throw ew;
            }else{
                throw new RuntimeException(e);
            }
		}
		return resultDto;
	}
	
	@Override
	public BaseSingleResultDto<FitOrderMainDto> bookingByDetail(FitOrderBookingRequest bookingRequest) {
		
		BaseSingleResultDto<FitOrderMainDto> resultDto = new BaseSingleResultDto<FitOrderMainDto>();
		try {
	        FitOrderMainDto orderMainDto  = fitBusinessClient.booking(bookingRequest);
	        resultDto.setResult(orderMainDto);
		} catch (Exception e) {
		    logger.error("[sdp-core]请求下单异常：", e);
            if(e instanceof ExceptionWrapper){
                ExceptionWrapper ew = (ExceptionWrapper)e;
                throw ew;
            }else{
                throw new RuntimeException(e);
            }
		}
		return resultDto;
	}

	private void completeBookingRequest(FitOrderBookingRequest bookingRequest) { 
		FitSdpShoppingDto shoppingDto = fitSdpShoppingService.getFitSdpShoppingDto(bookingRequest.getShoppingUuid()); 
        if (null == shoppingDto) {
            throw new ExceptionWrapper(ExceptionCode.UNDEF_ERROR);
        }

        bookingRequest.setProductId(Long.valueOf(shoppingDto.getFitSdpShoppingRequest().getProductId()));
        bookingRequest.setCategoryId(Long.valueOf(shoppingDto.getFitSdpShoppingRequest().getCategoryId()));
        bookingRequest.setLineRouteId(Long.valueOf(shoppingDto.getFitSdpShoppingRequest().getLineRouteId()));
		bookingRequest.setDistributionChannel(shoppingDto.getFitSdpShoppingRequest().getDistributionChannel());
		bookingRequest.setDistributorCode(shoppingDto.getFitSdpShoppingRequest().getDistributorCode());

        //构建订单基本信息
        this.buildFitOrderBasicInfo(bookingRequest,shoppingDto);
        
        //构建订单航班信息:设置bookingRequest里面的fitOrderFlightDtos对象
        this.buildFitOrderFlightInfo(bookingRequest, shoppingDto);
        
        //构造机酒订单酒店信息
        this.buildFitOrderHotelInfo(bookingRequest, shoppingDto);
        
        //构建订单酒店套餐信息
        this.buildFitOrderHotelComboInfo(bookingRequest, shoppingDto);
        
        //构建订单地接产品信息
        this.buildFitOrderLocalTripProductInfo(bookingRequest, shoppingDto);
        
        //构建订单其他票信息
        this.buildFitOrderOtherTicketDto(bookingRequest, shoppingDto);

        //构造订单保险信息
        this.buildFitOrderInsuranceInfo(bookingRequest, shoppingDto);
        
        //构造房差信息
        this.buidFitOrderRoomDiffInfoDto(bookingRequest, shoppingDto);
        
	}


	/**
	 * 构造房差信息
	 * @param bookingRequest
	 * @param shoppingDto
	 */
	private void buidFitOrderRoomDiffInfoDto(FitOrderBookingRequest bookingRequest, FitSdpShoppingDto shoppingDto) {
		if(null != shoppingDto.getSelectRoomDiffs()){
			FitOrderRoomDiff fitOrderRoomDiff = new FitOrderRoomDiff();
			FitOrderRoomDiffDto fitOrderRoomDiffDto = fitOrderRoomDiff.buildFitOrderRoomDiffDto(shoppingDto.getSelectRoomDiffs());
			bookingRequest.setFitOrderRoomDiffDto(fitOrderRoomDiffDto);
		}
	}

	/**
	 * 构建订单基本信息
	 * @param bookingRequest
	 * @param shoppingDto
	 */
	private void buildFitOrderBasicInfo(FitOrderBookingRequest bookingRequest, FitSdpShoppingDto shoppingDto) {
		FitSdpShoppingRequest shoppingRequest = shoppingDto.getFitSdpShoppingRequest();
		//shoppingRequest.setVisitDate("2016-07-18");
		//shoppingRequest.setDepCityCode("SHA");
		//shoppingRequest.setArrCityCode("PEK");
		//shoppingRequest.setStayNum(2);
		FitPassengerRequest fitPassengerRequest =shoppingDto.getFitSdpShoppingRequest().getFitPassengerRequest();
        FitOrderBasicInfoDto fitOrderBasicInfoDto = new FitOrderBasicInfoDto();
        fitOrderBasicInfoDto.setAdultQuantity(fitPassengerRequest.getAdultCount()*shoppingRequest.getQuantity().intValue());
        fitOrderBasicInfoDto.setChildQuantity(fitPassengerRequest.getChildCount()*shoppingRequest.getQuantity().intValue());
        fitOrderBasicInfoDto.setDepCityCode(shoppingRequest.getDepCityCode());
        fitOrderBasicInfoDto.setArriCityCode(shoppingRequest.getArrCityCode());
        fitOrderBasicInfoDto.setToTime(DateUtils.parseDate(shoppingDto.getSelectedFlightInfos().get(0).getDepartureDate()));
        fitOrderBasicInfoDto.setReturnTime(DateUtils.parseDate(shoppingDto.getSelectedFlightInfos().get(1).getDepartureDate()));
	    fitOrderBasicInfoDto.setCheckInCityCode(shoppingRequest.getArrCityCode());
	    fitOrderBasicInfoDto.setVisitTime(shoppingRequest.getVisitDate());
	    fitOrderBasicInfoDto.setCheckInTime(DateUtils.parseDate(shoppingRequest.getVisitDate()));
	    fitOrderBasicInfoDto.setCheckOutTime(DateUtils.getDateAfterDateDays(fitOrderBasicInfoDto.getCheckInTime(), shoppingRequest.getStayNum()));
	    bookingRequest.setFitOrderBasicInfoDto(fitOrderBasicInfoDto);		
	} 
	
	
	/**
	 * 构建订单航班信息.准备放到机酒里面的快照库里面，和vst订单是一一对应的。
	 * @param bookingRequest
	 * @param shoppingDto
	 */
	private void buildFitOrderFlightInfo(FitOrderBookingRequest bookingRequest, FitSdpShoppingDto shoppingDto) {
        List<FitOrderFlightDto> fitOrderFlightDtos = bookingRequest.getFitOrderFlightDtos();
        FitSdpShoppingRequest fitSdpShoppingRequest =shoppingDto.getFitSdpShoppingRequest();
        
        //获取航班加价规则，下单时放入到总价中,现都加入到去程总价中
        BigDecimal fligtFeeAmount = new BigDecimal(0);
        fligtFeeAmount = this.getProductFeeRulesByProductId(fitSdpShoppingRequest.getProductId(),fligtFeeAmount);
        bookingRequest.setFlightFeeAmount(fligtFeeAmount); 
        
        //对于包机切位的航班如何加价？
        
        for (FlightSearchFlightInfoDto searchFlight : shoppingDto.getSelectedFlightInfos()) {
	    	 FlightSearchSeatDto searchSeat = searchFlight.getSeats().get(0);
	    	 FitOrderFlightDto fitOrderFlightDto = new FitOrderFlightDto();
	    	 //设置销售类型，标明是否是包机切位航班.
	    	 fitOrderFlightDto.setSaleType(searchFlight.getSaleType());
	         FitOrderFlight fitOrderFlight = new FitOrderFlight(fitOrderFlightDto); 
	         fitOrderFlightDto = fitOrderFlight.buildFitOrderFlightDto(searchFlight, searchSeat);
	         FitSdpCalculateAmountRequest calculateAmountRequest = new FitSdpCalculateAmountRequest(); 
	         List<FlightSearchFlightInfoDto> selectSearchFlightInfoDtos = new ArrayList<FlightSearchFlightInfoDto>();
	         fitSdpShoppingRequest.setBookingSource(bookingRequest.getBookingSource());
	         //如果是包机切位,只计算第一个单程的价格，也就是只计算包机切位的去程的价格.包机切位的返程是通过去程里面的returnFlight出来的，不可以拿到实际的后台去查询价格
	         if(SuppSaleType.DomesticProduct.name().equals(searchFlight.getSaleType())){
	        	 selectSearchFlightInfoDtos.add(shoppingDto.getSelectedFlightInfos().get(0));
	         }
	         //以前默认的处理方式，处理往返程.
	         else{
	        	 selectSearchFlightInfoDtos.add(searchFlight); 
	         }
			 
	         //根据航段+乘客类型，构造查询航班价格请求对象. 
	         AmountCalculatorRequest calculatorRequest = calculateAmountRequest.getFlightPriceRequest(selectSearchFlightInfoDtos, fitSdpShoppingRequest);
	         //查询价格.
	         FitFlightAmountDto flightAmountDto =  fitSdpShopingCalculateService.calculateFlightAmount(calculatorRequest);
	         
	         //如果是包机切位
	         if(SuppSaleType.DomesticProduct.name().equals(searchFlight.getSaleType())){
		        int childCount = bookingRequest.getChildQuantity();
         		int adultCount = bookingRequest.getAdultQuantity();
         		BigDecimal salesPrice = flightAmountDto.getTotalSalesAmount();
         		salesPrice = salesPrice.divide(new BigDecimal(2));
	        	//如果是包机切位，总价格/2,每一程的价格
	        	fitOrderFlightDto.setSalesPrice(salesPrice);
	        	BigDecimal singlePrice = salesPrice.divide(new BigDecimal(childCount+adultCount));
	        	//如果是包机切位，成人价，儿童价都是一样的，每个价格一样。所以单价就是总价/总人数.
	        	fitOrderFlightDto.setAdultPrice(singlePrice);
	        	fitOrderFlightDto.setChildPrice(singlePrice);
	         }
	         //默认的航班
	         else{  
	        	 fitOrderFlightDto.setSalesPrice(flightAmountDto.getTotalSalesAmount());	        	
	         } 
	         fitOrderFlightDtos.add(fitOrderFlightDto); 
       }
	}
	
	
	/**构建订单酒店信息
	 * @param fit
	 * @param selectShoppingDto
	 */
	private void buildFitOrderHotelInfo(FitOrderBookingRequest bookingRequest, FitSdpShoppingDto shoppingDto) {
        //TODO
		List<FitOrderHotelDto>  fitOrderHotelDtos = bookingRequest.getFitOrderHotelDtos();
		List<FitSdpHotelRoomtypeDto> roomTypeDtos = shoppingDto.getSelectedRoomtypes();
		if(CollectionUtils.isNotEmpty(roomTypeDtos)){
			for(FitSdpHotelRoomtypeDto roomTypeDto : roomTypeDtos){
				//构造机酒订单酒店信息
           	 	FitOrderHotelDto fitOrderHotelDto = new FitOrderHotelDto();
           	 	FitOrderHotel fitOrderHotel = new FitOrderHotel(fitOrderHotelDto); 
           	 	fitOrderHotelDto = fitOrderHotel.buildFitOrderHotelDto(roomTypeDto);
           	 	fitOrderHotelDto.setCheckin(DateUtils.parseDate(roomTypeDto.getCheckIn()));
           	 	fitOrderHotelDto.setCheckout(DateUtils.parseDate(roomTypeDto.getCheckOut()));
           	 	fitOrderHotelDto.setProductResource(ProductResource.VST);
	           	//fitOrderHotelDto.setCheckInCity();
           	 	fitOrderHotelDtos.add(fitOrderHotelDto);
           	 	
			}
		}
        
	}
	
	/**
	 * 构建订单酒店套餐信息
	 * @param bookingRequest
	 * @param shoppingDto
	 */
	private void buildFitOrderHotelComboInfo(FitOrderBookingRequest bookingRequest,FitSdpShoppingDto shoppingDto) {
		if(CollectionUtils.isNotEmpty(shoppingDto.getHotelCombos())){
			FitOrderHotelCombo fitOrderHotelCombo = new FitOrderHotelCombo();
			FitOrderHotelComboDto fitOrderHotelComboDto = fitOrderHotelCombo.buildFitOrderHotelComboDto(shoppingDto);
			bookingRequest.setFitOrderHotelComboDto(fitOrderHotelComboDto);
		}
	}
	
	/**
	 * 构建订单地接产品信息
	 * @param bookingRequest
	 * @param shoppingDto
	 */
	private void buildFitOrderLocalTripProductInfo(FitOrderBookingRequest bookingRequest, FitSdpShoppingDto shoppingDto) {
		if(null != shoppingDto.getSelectLocalTripPrduct()){
			FitOrderLocalTripProduct fitOrderLocalTripProduct = new FitOrderLocalTripProduct();
			FitOrderLocalTripProductDto fitOrderLocalTripProductDto = fitOrderLocalTripProduct.buildFitOrderLocalTripProductDto(shoppingDto);
			bookingRequest.setFitOrderLocalTripProductDto(fitOrderLocalTripProductDto);
		}
	}
	
	/**
	 * 构造订单其他票信息
	 * @param bookingRequest
	 * @param shoppingDto
	 */
	private void buildFitOrderOtherTicketDto(FitOrderBookingRequest bookingRequest, FitSdpShoppingDto shoppingDto) {
		List<FitOrderOtherTicketDto> fitOrderOtherTicketDtos = bookingRequest.getFitOrderOtherTicketDtos();
		List<FitSdpSelectOtherTicketDto> selectOtherTickets  = shoppingDto.getSelectOtherTickets();
		if(CollectionUtils.isNotEmpty(selectOtherTickets)){
			for (FitSdpSelectOtherTicketDto selectOtherTicketDto : selectOtherTickets) {
				FitOrderOtherTicketDto fitOrderOtherTicketDto = new FitOrderOtherTicketDto();
				FitOrderOtherTicket fitOrderOtherTicket = new FitOrderOtherTicket(fitOrderOtherTicketDto);
				fitOrderOtherTicketDto = fitOrderOtherTicket.buildFitOrderOtherTicketDto(selectOtherTicketDto);
				fitOrderOtherTicketDtos.add(fitOrderOtherTicketDto);
			}
		}
	}
	
	/**
	 * 构建订单保险信息
	 * @param bookingRequest
	 * @param shoppingDto
	 */
	private void buildFitOrderInsuranceInfo(FitOrderBookingRequest bookingRequest, FitSdpShoppingDto shoppingDto) {
		List<FitOrderInsuranceDto> fitOrderInsuranceDtos = bookingRequest.getFitOrderInsuranceDtos();
		List<FitSdpSelectInsuranceDto> selectInsurances = shoppingDto.getSelectInsurances();
		if(CollectionUtils.isNotEmpty(selectInsurances)){
			for (FitSdpSelectInsuranceDto selectSdpInsuranceDtos : selectInsurances) {
				FitOrderInsuranceDto fitOrderInsuranceDto = new FitOrderInsuranceDto();
				FitOrderInsurance fitOrderInsurance = new FitOrderInsurance(fitOrderInsuranceDto);
				fitOrderInsuranceDto =  fitOrderInsurance.buildFitOrderInsuranceDto(selectSdpInsuranceDtos);
				fitOrderInsuranceDtos.add(fitOrderInsuranceDto);
			}
		}
	}
	
    public void setOrderSalesAmount(FitOrderBookingRequest bookingRequest) {
        //计算订单总销售金额
    	FitSdpCalculateAmountRequest calculateAmountRequest = new FitSdpCalculateAmountRequest();
        calculateAmountRequest.setShoppingUUID(bookingRequest.getShoppingUuid());
        calculateAmountRequest.setBookingSource(bookingRequest.getBookingSource());
    	try {
			logger.error(JSONMapper.getInstance().writeValueAsString(calculateAmountRequest));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
    	BaseSingleResultDto<FitSdpShoppingAmountDto> resultDto = fitSdpShopingCalculateService.calculateAmount(calculateAmountRequest);
    	
    	FitSdpShoppingAmountDto shoppingAmountDto = resultDto.getResult();
        BigDecimal totalAmount = shoppingAmountDto.getTotalAmount();
        
        FitOrderAmountDto calculated = new FitOrderAmountDto();
        calculated.setTotalSalesAmount(totalAmount);
        bookingRequest.setFitOrderAmountDto(calculated);

        //计算：机票成人单价、机票儿童单价
        for (FitOrderFlightDto f : bookingRequest.getFitOrderFlightDtos()) {
        	//如果当前是包机切位的航班，就不计算单价了。因为已经在completeBookingRequest()中计算了.
        	if(SuppSaleType.DomesticProduct.name().equals(f.getSaleType())){
        		continue;
			}
        	
        	FitOrderFlightDto curFitOrderFlightDto = new FitOrderFlightDto();
        	try {
        		curFitOrderFlightDto = JSONMapper.getInstance().readValue(JSONMapper.getInstance().writeValueAsString(f), FitOrderFlightDto.class);
			} catch (Exception e) {
				logger.error(ExceptionUtils.getStackTrace(e));
			} 
            if (bookingRequest.getAdultQuantity() > 0) {
            	AmountCalculatorRequest  adultRequest = null;
            	adultRequest = this.getCalculatorRequest(curFitOrderFlightDto,PassengerType.ADULT,bookingRequest.getBookingSource());
            	try {
					logger.error(JSONMapper.getInstance().writeValueAsString(adultRequest));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	FitFlightAmountDto flightPrice = fitSdpShopingCalculateService.calculateFlightAmount(adultRequest);
	            f.setAdultPrice(flightPrice.getTotalSalesAmount());
            }
            if (bookingRequest.getChildQuantity() > 0) {
            	AmountCalculatorRequest  childRequest =  this.getCalculatorRequest(curFitOrderFlightDto,PassengerType.CHILDREN,bookingRequest.getBookingSource());
            	FitFlightAmountDto flightPrice = fitSdpShopingCalculateService.calculateFlightAmount(childRequest);
                f.setChildPrice(flightPrice.getTotalSalesAmount());
            }
        }
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
		request.setBookingSource(BookingSource.valueOf(bookingSource.getParentSource().name()));
		request.setPassengerDetailDtos(bookingDetailDtos);
		return request;
    }
    
    /**
	 * 获取加价规则
	 * @param productId
	 * @param flightAmount 
	 * @return
	 */
	private BigDecimal getProductFeeRulesByProductId(String productId, BigDecimal flightAmount) {
		List<FitSdpProductFeeRulesDto> productFeeRules = fitBusinessClient.getProductFeeRulesByProductId(Long.valueOf(productId));
		if(CollectionUtils.isNotEmpty(productFeeRules)){
			FitSdpProductFeeRulesDto productFeeRulesDto = productFeeRules.get(0);
			CalculateRuleDto calculateRuleDto = new CalculateRuleDto();
			calculateRuleDto.setSalesPrice(flightAmount);
			calculateRuleDto.setOperateValue(productFeeRulesDto.getOprationValue());
			return  productFeeRulesDto.getFeeRuleType().calculate(calculateRuleDto);
		}
		return flightAmount;
	}
}
