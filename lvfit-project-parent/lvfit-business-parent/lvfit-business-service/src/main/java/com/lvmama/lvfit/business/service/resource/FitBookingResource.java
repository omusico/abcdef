package com.lvmama.lvfit.business.service.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.business.booking.service.FitBookingService;
import com.lvmama.lvfit.business.booking.service.FitFlightBookingService;
import com.lvmama.lvfit.common.client.path.BussinessClientPath;
import com.lvmama.lvfit.common.dto.booking.FitFliCallBackResponseVSTDto;
import com.lvmama.lvfit.common.dto.request.FitFliBookingCallBackRequest;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;

@Component
@Path("")
public class FitBookingResource {

	private static Logger logger = LoggerFactory.getLogger(FitBookingResource.class);

	@Autowired
	private FitBookingService fitBookingService;
	
	@Autowired
	private FitFlightBookingService fitFlightBookingService;

	/**
	 * 预订
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.BOOKING)
	public Response booking(FitOrderBookingRequest fitOrderBookingRequest) {
		return Response.ok(fitBookingService.booking(fitOrderBookingRequest)).build();
	}
	
	/**
	 * 校验乘客信息是否正确填写
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.VALIDATE_PASSENGERS)
	public Response validatePassengers(FitOrderBookingRequest fitOrderBookingRequest) {
		return Response.ok(fitBookingService.validatePassengers(fitOrderBookingRequest)).build();
	}
	/**
	 * VST侧回调机票下单
	 * @param vstOrderNoMap
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.FLIGHT_CALLBACK_BOOKING)
	public Response fitForFlightCallBack(String requestStr) {
		
		logger.info("订单留库开始请求开始【"+requestStr+"】");
		 List<FitFliBookingCallBackRequest> callBackRequests = null;
		 try {
				callBackRequests = JSONMapper.getInstance().readValue(requestStr, new TypeReference<List<FitFliBookingCallBackRequest>>() {});
		 } catch (Exception e1) {
			  logger.error(e1.getMessage(),e1);
		 }
		fitFlightBookingService.fitFlightBookingAsync(callBackRequests);
		BaseResponseDto<FitFliCallBackResponseVSTDto> responseDto = fitFlightBookingService.flightCallBackBooking(callBackRequests);
		try {
			if(logger.isInfoEnabled()){
				logger.info("订单留库开始请求开始【"+JSONMapper.getInstance().writeValueAsString(responseDto)+"】");
			}
		} catch (Exception e) {
			 logger.error(e.getMessage(),e);
		}
		return Response.ok(responseDto).build();
	}
	
}
