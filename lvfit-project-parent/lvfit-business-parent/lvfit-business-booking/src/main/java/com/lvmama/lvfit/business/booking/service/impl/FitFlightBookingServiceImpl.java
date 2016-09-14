package com.lvmama.lvfit.business.booking.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.dto.request.FlightOrderBookingRequest;
import com.lvmama.lvf.common.event.Event;
import com.lvmama.lvf.common.event.EventPoint;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvf.common.utils.ZipUnZipUtils;
import com.lvmama.lvfit.business.booking.service.FitFlightBookingService;
import com.lvmama.lvfit.business.order.domain.repository.FitSuppOrderForFlightCallBackRepository;
import com.lvmama.lvfit.common.client.FitFlightClient;
import com.lvmama.lvfit.common.client.FitVstClient;
import com.lvmama.lvfit.common.dto.adapter.request.FlightBookingRequest;
import com.lvmama.lvfit.common.dto.booking.FitFliCallBackResponseVSTDto;
import com.lvmama.lvfit.common.dto.enums.BookingBusinessType;
import com.lvmama.lvfit.common.dto.enums.CallbackType;
import com.lvmama.lvfit.common.dto.enums.FitBusinessExceptionType;
import com.lvmama.lvfit.common.dto.enums.FitFlightBookingType;
import com.lvmama.lvfit.common.dto.enums.SuppSaleType;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderForFlightCallBackDto;
import com.lvmama.lvfit.common.dto.request.FitFliBookingCallBackRequest;
import com.lvmama.lvfit.common.dto.trace.FitOpLogTraceContext;

/**
 * 机票单品下单
 * @author qihuisong
 */
@Service
public class FitFlightBookingServiceImpl implements FitFlightBookingService {

    private static final Logger logger = LoggerFactory.getLogger(FitFlightBookingServiceImpl.class);

    @Autowired
    private FitSuppOrderForFlightCallBackRepository  fitSuppOrderForFlightCallBackRepository;
    
    @Autowired
    private FitVstClient fitVstClient;
    
    @Autowired
    private FitFlightClient fitFlightClient;
    
    @Value("isFitFlightBookingAfterVstAudit")
	private String isFitFlightBookingAfterVstAudit;

    @EventPoint(Event.ORDER_BOOKING_FINISH)
    @Override
    @Async
    public FitOrderMainDto flightBooking(FitOrderMainDto orderMainDto) {
        try {
            //机票单品下单
        	logger.error("机票单品下单前orderMainDto："+JSONMapper.getInstance().writeValueAsString(orderMainDto));
            FitSuppMainOrderDto suppMainOrderDto = fitVstClient.booking(this.buildFlightOrderBookingRequest(orderMainDto));
            logger.error("机票单品下单后orderMainDto："+JSONMapper.getInstance().writeValueAsString(orderMainDto));
            logger.error("机票单品下单结果："+JSONMapper.getInstance().writeValueAsString(suppMainOrderDto));
            orderMainDto.setFitSuppMainOrderDto(suppMainOrderDto);
        } catch (Exception e) {
            logger.error("机票单品下单异常，后需人工补单：", e);
        }
        return orderMainDto;
    }

	private FlightBookingRequest buildFlightOrderBookingRequest(FitOrderMainDto fit) {
        FlightBookingRequest flightRequest = new FlightBookingRequest();
        flightRequest.setFitOrderFlightDtoList(fit.getFitOrderFlightDtos());
        flightRequest.setFitOrderContacterDto(fit.getFitOrderContacter());
        flightRequest.setFitOrderCustomerDto(fit.getFitOrderCustomer());
        flightRequest.setFitOrderPassengerDtoList(fit.getFitOrderPassengers());
        flightRequest.setFitOrderRemarkDtoList(fit.getFitOrderRemarks());
        flightRequest.setOrderTotalSalesAmount(fit.getOrderAmount().getFlightTotalSalesAmount());
        flightRequest.setFitSuppMainOrderDto(fit.getFitSuppMainOrderDto());
        flightRequest.setBookingSource(fit.getBookingSource());
        //默认是审批之后下单。
        flightRequest.setFitFlightBookingType(FitFlightBookingType.BOOKING_AFTER_VST_AUDIT);
        //包机切位都是审批前下单
        if(CollectionUtils.isNotEmpty(fit.getFitOrderFlightDtos())){
        	if(SuppSaleType.DomesticProduct.name().equals(fit.getFitOrderFlightDtos().get(0).getSaleType())){
        		 flightRequest.setFitFlightBookingType(FitFlightBookingType.BOOKING_BEFORE_VST_AUDIT);
        	}
        }
        
        //动态打包的只有机票的订单就提前下单
        if(fit.getBookingSource().getBookingBusinessType().name().equals(BookingBusinessType.FIT.name())){
        	if(CollectionUtils.isEmpty(fit.getFitOrderHotelDtos())
            		&&CollectionUtils.isEmpty(fit.getFitOrderInsuranceDtos())
            		&&CollectionUtils.isEmpty(fit.getFitOrderSpotTicketDtos())){
         	   flightRequest.setFitFlightBookingType(FitFlightBookingType.BOOKING_BEFORE_VST_AUDIT);
            }
        }
        
        //机+X机票预订方式目前部分时段，统一设为后置下单（即vst资源审核通过之后下机票单 
        /*if(this.getIsFitFlightBookingAfterVstAudit().booleanValue()){
        	   flightRequest.setFitFlightBookingType(FitFlightBookingType.BOOKING_AFTER_VST_AUDIT);
        }else{
        	   flightRequest.setFitFlightBookingType(FitFlightBookingType.BOOKING_BEFORE_VST_AUDIT);
        }
        if(fit.getBookingSource()==BookingSource.FIT_FRONT&&CollectionUtils.isEmpty(fit.getFitOrderHotelDtos())
        		&&CollectionUtils.isEmpty(fit.getFitOrderInsuranceDtos())
        		&&CollectionUtils.isEmpty(fit.getFitOrderSpotTicketDtos())){
     	   flightRequest.setFitFlightBookingType(FitFlightBookingType.BOOKING_BEFORE_VST_AUDIT);
        }*/
        return flightRequest;
    }

	@Override
	public BaseResponseDto<FitFliCallBackResponseVSTDto> flightCallBackBooking(List<FitFliBookingCallBackRequest> callBackRequests) {
		
		  BaseResponseDto<FitFliCallBackResponseVSTDto> responseVSTDto = new BaseResponseDto<FitFliCallBackResponseVSTDto>();
		  List<FitFliCallBackResponseVSTDto> callBackResponseVSTDtos = new ArrayList<FitFliCallBackResponseVSTDto>();
		  if(CollectionUtils.isNotEmpty(callBackRequests)){
				  for (FitFliBookingCallBackRequest callBackRequest : callBackRequests) {
					  FitFliCallBackResponseVSTDto callBackResponseVSTDto = new FitFliCallBackResponseVSTDto();
					  callBackResponseVSTDto.setCallBackRequest(callBackRequest);
					  callBackResponseVSTDto.setSuccessFlag(true);
				  }
		  }
		  responseVSTDto.setResults(callBackResponseVSTDtos);
	      return responseVSTDto;
	}
 
	public Boolean getIsFitFlightBookingAfterVstAudit() {
		return Boolean.valueOf(CustomizedPropertyPlaceholderConfigurer.getContextProperty(isFitFlightBookingAfterVstAudit)+"");
    }

	@Override
	@Async
	public void fitFlightBookingAsync(List<FitFliBookingCallBackRequest> callBackRequests) {
		
		 String gid = UUID.randomUUID().toString(); 
		  try {
			logger.error("订单留库开始异步请求开始【"+gid+"】：【"+JSONMapper.getInstance().writeValueAsString(callBackRequests)+"】");
		  } catch (Exception e) {
		     logger.error(ExceptionUtils.getFullStackTrace(e));
		  }
		  if(CollectionUtils.isNotEmpty(callBackRequests)){
			  for (FitFliBookingCallBackRequest callBackRequest : callBackRequests) {
				  FitFliCallBackResponseVSTDto callBackResponseVSTDto = new FitFliCallBackResponseVSTDto();
				  callBackResponseVSTDto.setCallBackRequest(callBackRequest);
				   Long vstOrderMainNo = callBackRequest.getVstOrderMainNo();
				   Long vstOrderNo = callBackRequest.getVstOrderNo();
       		   FitSuppOrderForFlightCallBackDto  callBackDto = null;
       		   FlightOrderBookingRequest flightOrderBookingRequest = null;
       		   CallbackType callbackType = CallbackType.SUCCESS;
       		   try {
       			       long start = System.currentTimeMillis();
       			       long end = 0;
       			       Thread.sleep(2000l);
	       			   while(callBackDto==null){
	       				   callBackDto = fitSuppOrderForFlightCallBackRepository.loadByVstNos(String.valueOf(vstOrderMainNo), String.valueOf(vstOrderNo));
	       				   if(callBackDto==null){
	       				      Thread.sleep(5000l);
	       				   }
	       				   end = System.currentTimeMillis();
	       				   if(end-start>1000*60){
	       					 logger.error("未从db获取到回调信息！当前vstOrderMainNo【"+vstOrderMainNo+"】，vstOrderNo【"+vstOrderNo+"】");
	       					 throw new RuntimeException();
	       				   }
	       			   }
					   String callRequestStr = ZipUnZipUtils.getInstance().unzipBase642String(callBackDto.getCallRequestStr());
					   flightOrderBookingRequest = JSONMapper.getInstance().readValue(callRequestStr,new TypeReference<FlightOrderBookingRequest>() {});
					   
					   logger.error("订单留库开始航班请求参数【"+vstOrderMainNo+","+vstOrderNo+"】"+JSONMapper.getInstance().writeValueAsString(flightOrderBookingRequest));
					   fitFlightClient.bookingRebuild(flightOrderBookingRequest);
					} catch (Exception e) {
						logger.error(ExceptionUtils.getFullStackTrace(e));
						FitOpLogTraceContext.setFitOpLog(flightOrderBookingRequest,e, vstOrderMainNo+"/"+vstOrderNo, FitBusinessExceptionType.FLIGHT_CALLBACK_BOOKING);
						callbackType = CallbackType.FAIL;
					}finally{
						if(null!=callBackDto){
							callBackDto.setCallbackType(callbackType);
							callBackDto.setCallbackTime(new Date());
							fitSuppOrderForFlightCallBackRepository.save(callBackDto);
						}
					}
       		    
		      }
	    }
	    logger.error("订单留库开始异步请求结束【"+gid+"】");
		
	}
	
	
}


