package com.lvmama.lvf.common.client;

import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.client.path.FitBussinessClientPath;
import com.lvmama.lvf.common.dto.request.FlightOrderBookingRequest;
import com.lvmama.lvf.common.dto.request.VSTOrderRequest;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.JSONMapper;

/**
 * 业务接口远程调用类
 * 
 * @author majun
 * @date 2015-1-29
 */
@Component
public class FlightToFitBusinessClient {

	/** 远程地址 */    
	@Value("lvfit.business.baesurl")
	private String baseUrl;

	/** 远程服务 */
	@Autowired
	private RestClient restClient;
	
	public static final Logger logger=Logger.getLogger(FlightToFitBusinessClient.class);

    public String flightCallBackBooking(String requestStr){
		
    	FitBussinessClientPath command = FitBussinessClientPath.FLIGHT_CALLBACK_BOOKING;
		String url = command.url(baseUrl);
		try{
			String jsonResult = restClient.post(url, String.class, requestStr);
			return jsonResult;
		} catch (ExceptionWrapper ew) {
			throw ew;
		} catch (Exception e) {
			ExceptionWrapper ew = new ExceptionWrapper();
			ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
    
    
    public List<FlightOrderBookingRequest> getFlightBookingOrder(VSTOrderRequest vstOrderRequest){

    	FitBussinessClientPath command = FitBussinessClientPath.GET_FLIGHT_BOOKING_ORDER;
		String url = command.url(baseUrl);
		try{
			String jsonResult = restClient.post(url, String.class, vstOrderRequest);
			if (null == jsonResult && "".equals(jsonResult)) {
				return null;
			}
			logger.error(jsonResult);
			return JSONMapper.getInstance().readValue(jsonResult,new TypeReference<List<FlightOrderBookingRequest>>() {});
		} catch (ExceptionWrapper ew) {
			throw ew;
		} catch (Exception e) {
			ExceptionWrapper ew = new ExceptionWrapper();
			ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
    	
    }
	
}
