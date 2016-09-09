package com.lvmama.lvfit.adapter.flight.adapter.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.adapter.response.SuppResponse;
import com.lvmama.lvf.common.dto.enums.BindingStatus;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.dto.enums.Gender;
import com.lvmama.lvf.common.dto.enums.IDCardType;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.enums.RemarkType;
import com.lvmama.lvf.common.dto.enums.RouteType;
import com.lvmama.lvf.common.dto.order.FlightOrderAmountDto;
import com.lvmama.lvf.common.dto.order.FlightOrderContacterDto;
import com.lvmama.lvf.common.dto.order.FlightOrderCustomerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderDto;
import com.lvmama.lvf.common.dto.order.FlightOrderInsuranceDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderRemarkDto;
import com.lvmama.lvf.common.dto.order.OrderMainDto;
import com.lvmama.lvf.common.dto.order.status.FlightOrderStatusDto;
import com.lvmama.lvf.common.dto.request.FlightOrderBookingDetailRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderBookingRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderSalesOrderRelationRequest;
import com.lvmama.lvf.common.dto.status.order.OrderBookingStatus;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.adapter.flight.adapter.FlightBookingAdapter;
import com.lvmama.lvfit.common.client.FitFlightClient;
import com.lvmama.lvfit.common.dto.adapter.request.FlightBookingRequest;
import com.lvmama.lvfit.common.dto.enums.CallbackType;
import com.lvmama.lvfit.common.dto.enums.FitFlightBookingType;
import com.lvmama.lvfit.common.dto.enums.FitOrderResultStatus;
import com.lvmama.lvfit.common.dto.enums.FitOrderStatusType;
import com.lvmama.lvfit.common.dto.order.FitOrderAmountDto;
import com.lvmama.lvfit.common.dto.order.FitOrderContacterDto;
import com.lvmama.lvfit.common.dto.order.FitOrderCustomerDto;
import com.lvmama.lvfit.common.dto.order.FitOrderFlightDto;
import com.lvmama.lvfit.common.dto.order.FitOrderMsgDto;
import com.lvmama.lvfit.common.dto.order.FitOrderPassengerDto;
import com.lvmama.lvfit.common.dto.order.FitOrderRemarkDto;
import com.lvmama.lvfit.common.dto.order.FitSuppFlightOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderForFlightCallBackDto;
import com.lvmama.lvfit.common.dto.shopping.FlightInsuranceDto;
import com.lvmama.lvfit.common.dto.trace.FitOrderTraceContext;

@Service
public class FlightBookingAdapterImpl implements FlightBookingAdapter {

    private static final Logger logger = LoggerFactory.getLogger(FlightBookingAdapterImpl.class);

    @Autowired
    private FitFlightClient fitFlightClient;

    @Override
    public FitSuppMainOrderDto booking(FlightBookingRequest request) {
    	
	        String tripTypeFlag = null;
	        FitSuppMainOrderDto fitSuppMainOrderDto = request.getFitSuppMainOrderDto();
	        try {
				logger.error("请求机票单品下单前request:"+JSONMapper.getInstance().writeValueAsString(request));
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getFullStackTrace(e1));
			} 
            List<FitOrderFlightDto> fitOrderFlightDtos = request.getFitOrderFlightDtoList(); 
            for (int i = 0; i < fitOrderFlightDtos.size(); i++) {
            	   try {
                       tripTypeFlag = fitOrderFlightDtos.get(i).getTripType().name();
                       FitSuppOrderDto fitSuppOrderDto = fitSuppMainOrderDto.getByFlightTripType(fitOrderFlightDtos.get(i).getTripType());
                       FlightOrderBookingRequest flightOrderBookingRequest =this.buildFlightOrderBookingRequest(request, fitOrderFlightDtos.get(i), fitSuppMainOrderDto.getVstMainOrderNo(), fitSuppOrderDto.getVstOrderNo());
                       if(request.getFitFlightBookingType()==FitFlightBookingType.BOOKING_AFTER_VST_AUDIT){
                    	       //如果是后置下单，则先不予以调用机票侧下单，待vst回调下单即可
	                    	   FitSuppOrderForFlightCallBackDto flightCallBackDto = new FitSuppOrderForFlightCallBackDto();
	                    	   flightCallBackDto.setVstOrderMainNo(String.valueOf(fitSuppMainOrderDto.getVstMainOrderNo()));
	                    	   flightCallBackDto.setVstOrderNo(String.valueOf(fitSuppOrderDto.getVstOrderNo()));
	                    	   flightCallBackDto.setCallRequestStr(JSONMapper.getInstance().writeValueAsString(flightOrderBookingRequest));
	                    	   flightCallBackDto.setTripType(fitOrderFlightDtos.get(i).getTripType());
	                    	   flightCallBackDto.setCallbackType(CallbackType.DEFAULT);
	                    	   fitSuppOrderDto.setFlightCallBackDto(flightCallBackDto);
	                    	   continue;
                       }
                       SuppResponse suppResponse = fitFlightClient.bookingRebuild(flightOrderBookingRequest);
                       //logger.error("[adapter-flight-booking]机票单品下单返回报文SuppResponse：" + JSONMapper.getInstance().writeValueAsString(suppResponse));
                       String json = JSONMapper.getInstance().writeValueAsString(suppResponse);
                       suppResponse = JSONMapper.getInstance().readValue(json, new TypeReference<SuppResponse<OrderMainDto>>() {});
                       OrderMainDto flightOrderMain = (OrderMainDto) suppResponse.getResult();
                   	   logger.error("当前主单号【"+fitSuppMainOrderDto.getVstMainOrderNo()+"】，当前航程类型【"+tripTypeFlag+"】当前子单号【"+fitSuppOrderDto.getVstOrderNo()+"】，请求机票单品下单返回flightOrderMain:"+JSONMapper.getInstance().writeValueAsString(flightOrderMain));
                       // 如果预定成功，保存信息
                       if (flightOrderMain != null) {
                       	boolean isBookingSuccess = true;
                       	for(FlightOrderDto flightOrderDto : flightOrderMain.getFlightOrders()){
	                   			FlightOrderStatusDto statusDto = flightOrderDto.getFlightOrderStatus();
	                   			if(statusDto == null || statusDto.getOrderBookingStatus() != OrderBookingStatus.BOOKING_SUCC){
	                   				isBookingSuccess = false;
	                   				break;
	                   			}
                   		   }
	                       FitOrderStatusType orderStatusType = null; 
	                       if (tripTypeFlag.equals(FlightTripType.DEPARTURE.name())) {
	                        	orderStatusType = FitOrderStatusType.DEP_FLI_ORDER_STATUS;
	                       }
	                       if (tripTypeFlag.equals(FlightTripType.RETURN.name())) {
	                       	   orderStatusType = FitOrderStatusType.ARV_FLI_ORDER_STATUS;
	                       }
                       	   FitOrderMsgDto orderMsgDto = new FitOrderMsgDto(orderStatusType, isBookingSuccess?FitOrderResultStatus.SUCCESS:FitOrderResultStatus.FAIL, isBookingSuccess?"":"供应商下单失败");
                       	   FitOrderTraceContext.setOrderMsg(orderMsgDto);
                           
                           //根据机票子单构造机酒供应商航班订单
                           for (FlightOrderDto flightOrder : flightOrderMain.getFlightOrders()) {
                           	String curOrderPassengerType =  flightOrder.getFlightOrderDetails().get(0).getFlightOrderPassenger().getPassengerType().name();
                           	FitSuppFlightOrderDto suppFlightOrderDto = fitSuppOrderDto.getByPassengerType(com.lvmama.lvfit.common.dto.enums.PassengerType.valueOf(curOrderPassengerType));
                           	suppFlightOrderDto.setFlightOrderNo(flightOrder.getFlightOrderNo().getOrderNo());
                           	suppFlightOrderDto.setBookingStatus(com.lvmama.lvfit.common.dto.status.order.OrderBookingStatus.valueOf(flightOrder.getFlightOrderStatus().getOrderBookingStatus().name()));
                           	suppFlightOrderDto.setOrderAmount(this.getFitOrderAmount(flightOrder.getFlightOrderAmount()));
                           }
                       }
                   
       			} catch (Exception e) {
       				    logger.error("请求机票单品下单异常：", e);
       		        	FitOrderStatusType orderStatusType = null; 
       		            if (tripTypeFlag.equals(FlightTripType.DEPARTURE.name())) {
       		            	orderStatusType = FitOrderStatusType.DEP_FLI_ORDER_STATUS;
       		            }
       		            if (tripTypeFlag.equals(FlightTripType.RETURN.name())) {
       		            	orderStatusType = FitOrderStatusType.ARV_FLI_ORDER_STATUS;
       		            }
       		            if (e instanceof ExceptionWrapper) {
       		                ExceptionWrapper ew = (ExceptionWrapper) e;
       		             	FitOrderMsgDto orderMsgDto = new FitOrderMsgDto(orderStatusType, FitOrderResultStatus.FAIL, ew.getErrMessage());
       		                FitOrderTraceContext.setOrderMsg(orderMsgDto);
       		            } else {
       		            	FitOrderMsgDto orderMsgDto = new FitOrderMsgDto(orderStatusType, FitOrderResultStatus.FAIL, e.getMessage());
       		                FitOrderTraceContext.setOrderMsg(orderMsgDto);
       		            }
       			}
            }
        try {
			logger.error("请求机票单品下单后fitSuppMainOrderDto:"+JSONMapper.getInstance().writeValueAsString(fitSuppMainOrderDto));
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
        return fitSuppMainOrderDto;
    }

    private FitOrderAmountDto getFitOrderAmount(
			FlightOrderAmountDto flightOrderAmount) {
    	FitOrderAmountDto fitOrderAmount = new FitOrderAmountDto();
    	fitOrderAmount.setPayedAmount(flightOrderAmount.getOrderPayedAmount());
    	fitOrderAmount.setPrepaidAmount(flightOrderAmount.getOrderPrepaidAmount());
    	fitOrderAmount.setProfitAmount(flightOrderAmount.getOrderProfitAmount());
    	fitOrderAmount.setTotalAmount(flightOrderAmount.getOrderTotalAmount());
    	fitOrderAmount.setTotalDiscountAmount(flightOrderAmount.getOrderDiscountTotalAmount());
    	fitOrderAmount.setTotalSalesAmount(flightOrderAmount.getOrderTotalSalesAmount());
		return fitOrderAmount;
	}
    
   

	private FlightOrderBookingRequest buildFlightOrderBookingRequest(FlightBookingRequest request, FitOrderFlightDto fitFlight, Long vstMainOrderId, Long vstFlightOrderId) {
        FlightOrderBookingRequest flightOrderBookingRequest = new FlightOrderBookingRequest();

        //1.航程类型
        flightOrderBookingRequest.setRouteType(RouteType.OW);

        //2.构造订单客户信息
        FitOrderCustomerDto fitCustomer = request.getFitOrderCustomerDto();
        FlightOrderCustomerDto flightCustomer = new FlightOrderCustomerDto();
        flightCustomer.setCustomerId("" + fitCustomer.getCustomerId());
        flightCustomer.setCustomerCode(fitCustomer.getCustomerCode());
        flightCustomer.setCustomerName(fitCustomer.getCustomerName());
        flightOrderBookingRequest.setFlightOrderCustomer(flightCustomer);

        //3.构造订单联系人信息
        FitOrderContacterDto fitContacter = request.getFitOrderContacterDto();
        FlightOrderContacterDto flightContacter = new FlightOrderContacterDto();
        flightContacter.setName(fitContacter.getName());
        flightContacter.setCellphone(fitContacter.getMobile());
        flightContacter.setEmail(fitContacter.getEmail());
        flightOrderBookingRequest.setFlightOrderContacter(flightContacter);

        //4.构造订单乘机人信息
        List<FitOrderPassengerDto> fitPassengerList = request.getFitOrderPassengerDtoList();
        List<FlightOrderPassengerDto> flightPassengerList = new ArrayList<FlightOrderPassengerDto>();
        BigDecimal insTotalPrice = BigDecimal.valueOf(0);
        for (FitOrderPassengerDto fitPassenger : fitPassengerList) {
            FlightOrderPassengerDto flightPassenger = new FlightOrderPassengerDto();
            String passengerIDCardNo = fitPassenger.getPassengerIDCardNo();
            
            flightPassenger.setGender(this.getGenderByIDCardNo(passengerIDCardNo));
            flightPassenger.setCellphone(fitPassenger.getMobile());
            flightPassenger.setPassengerName(fitPassenger.getPassengerName());
            flightPassenger.setPassengerBirthday(DateUtils.parseDate(fitPassenger.getPassengerBirthday()));
            flightPassenger.setPassengerIDCardNo(fitPassenger.getPassengerIDCardNo());
            flightPassenger.setPassengerIDCardType(IDCardType.getIDCardTypeByName(fitPassenger.getPassengerIDCardType().name()));
            flightPassenger.setPassengerType(PassengerType.getPassengerTypeByName(fitPassenger.getPassengerType().name()));
            
            List<FlightOrderInsuranceDto> flightOrderInsurances = new ArrayList<FlightOrderInsuranceDto>();
            List<FlightInsuranceDto> flightInsuranceDtos = fitPassenger.getFlightInsuranceDto();
            if (CollectionUtils.isNotEmpty(flightInsuranceDtos)) {
                FlightOrderInsuranceDto flightOrderInsurance = new FlightOrderInsuranceDto();
                flightOrderInsurance.setInsuranceInfoId(flightInsuranceDtos.get(0).getInsuranceId());
                flightOrderInsurance.setFlightNo(fitFlight.getFlightNo());
                flightOrderInsurances.add(flightOrderInsurance);
 
                flightPassenger.setFlightOrderInsurances(flightOrderInsurances);
                // 下单过程，因为去程和往返单独下单，所以机票保险价格只和乘客数有关
                insTotalPrice = insTotalPrice.add(flightInsuranceDtos.get(0).getInsurancePrice());
            }
            flightPassengerList.add(flightPassenger);
        }
        flightOrderBookingRequest.setFlightOrderPassengers(flightPassengerList);

        //5.构造订单备注信息
        List<FitOrderRemarkDto> fitRemarkList = request.getFitOrderRemarkDtoList();
        List<FlightOrderRemarkDto> flightRemarkList = new ArrayList<FlightOrderRemarkDto>();
        for (FitOrderRemarkDto fitRemark : fitRemarkList) {
            FlightOrderRemarkDto flightRemark = new FlightOrderRemarkDto();
            flightRemark.setOper(fitRemark.getOper());
            flightRemark.setOperId(fitRemark.getOperId());
            flightRemark.setOperType(fitRemark.getOperType());
            flightRemark.setRemark(fitRemark.getRemark());
            flightRemark.setRemarkType(RemarkType.getRemarkTypeByName(fitRemark.getRemarkType().name()));
            flightRemarkList.add(flightRemark);
        }
        flightOrderBookingRequest.setFlightOrderRemarks(flightRemarkList);

        //6.构造预订请求明细对象参数
        List<FlightOrderBookingDetailRequest> flightList = new ArrayList<FlightOrderBookingDetailRequest>();
        FlightOrderBookingDetailRequest bookingDetail = new FlightOrderBookingDetailRequest();
        bookingDetail.setFlightTripType(FlightTripType.getFlightTripTypeByName(fitFlight.getTripType().name()));
        bookingDetail.setFlightNo(fitFlight.getFlightNo());
        bookingDetail.setDepartureDate(fitFlight.getDepartureDate());
        bookingDetail.setDepartureAirportCode(fitFlight.getDepartureAirportCode());
        bookingDetail.setArrivalAirportCode(fitFlight.getArrivalAirportCode());
        bookingDetail.setSeatClassCode(fitFlight.getSeatClassCode());
        bookingDetail.setPricePolicyId(fitFlight.getPricePolicyId());
        flightList.add(bookingDetail);
        flightOrderBookingRequest.setFlightOrderBookingDetailRequests(flightList);

        //7.机票总金额
        BigDecimal flightTotalPrice = insTotalPrice.add(fitFlight.getSalesPrice());
        
        flightOrderBookingRequest.setOrderTotalSalesAmount(flightTotalPrice);

        //8.绑定关系
        FlightOrderSalesOrderRelationRequest relationRequest = new FlightOrderSalesOrderRelationRequest();
        relationRequest.setBindingStatus(BindingStatus.BINDING);
        //外部机票子订单ID：VST主单ID
        relationRequest.setSalesMainOrderId(vstMainOrderId);
        //外部主订单ID：VST机票订单ID
        relationRequest.setSalesOrderId(vstFlightOrderId);
        flightOrderBookingRequest.setRelationRequest(relationRequest);

        //9.订单来源
        flightOrderBookingRequest.setBookingSource(request.getBookingSource().getParentSource());
        return flightOrderBookingRequest;
    }

    private Gender getGenderByIDCardNo(String passengerIDCardNo) {
        String flag = null;
        if (passengerIDCardNo.length() == 15) {
            flag = passengerIDCardNo.substring(14);
        }
        if (passengerIDCardNo.length() == 18) {
            flag = passengerIDCardNo.substring(16, 17);
        }
        if (flag != null && Integer.parseInt(flag) % 2 == 0) {
            return Gender.FEMALE;
        } else {
            return Gender.MALE;
        }
    }
	
	/**
	 * 获取乘机人key
	 * @param flightOrderPassengerDto
	 * @return
	 */
	public String passengerKey(FlightOrderPassengerDto flightOrderPassengerDto){
		  StringBuffer passengerStr = new StringBuffer();
    	  passengerStr.append(flightOrderPassengerDto.getPassengerName());
    	  passengerStr.append(flightOrderPassengerDto.getPassengerType().name());
    	  passengerStr.append(flightOrderPassengerDto.getPassengerIDCardType().name());
    	  passengerStr.append(flightOrderPassengerDto.getPassengerIDCardNo());
          return passengerStr.toString();
	}
	
}
