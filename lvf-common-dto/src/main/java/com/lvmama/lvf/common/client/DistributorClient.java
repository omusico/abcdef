package com.lvmama.lvf.common.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.client.path.DistributorClientPath;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.order.FlightOrderSalesOrderRelationDto;
import com.lvmama.lvf.common.dto.vst.DistFlightMainOrderDto;
import com.lvmama.lvf.common.dto.vst.DistFlightOrderDto;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.JSONMapper;

@Component
public class DistributorClient {
	
	public static final Logger logger = Logger.getLogger(DistributorClient.class);

	@Value("adapter-vst.baseurl")//现在放在VST下面
	private String baseUrl;

	@Autowired
	private RestClient restClient;
	
	/**
	 * 分销创建分销订单，并返回与机票订单ID的映射关系
	 * @param distFlightMainOrderDto
	 * @return
	 */
	public List<FlightOrderSalesOrderRelationDto> distBooking(DistFlightMainOrderDto distFlightMainOrderDto) throws JsonParseException, JsonMappingException, IOException{
		DistributorClientPath command = DistributorClientPath.DIST_ORDER_BOOKING;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, distFlightMainOrderDto);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<List<FlightOrderSalesOrderRelationDto>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**
	 * 分销退票创单
	 * @param params
	 * @return
	 */
	public FlightOrderSalesOrderRelationDto rtvtApply(Map<String, Object> params) throws JsonParseException, JsonMappingException, IOException{
		DistributorClientPath command = DistributorClientPath.DIST_ORDER_RTVTAPPLY;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, params);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<FlightOrderSalesOrderRelationDto>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**
	 * 分销改期创单
	 * @param request
	 * @return
	 */
	public FlightOrderSalesOrderRelationDto ctmtApply(DistFlightOrderDto request) throws JsonParseException, JsonMappingException, IOException{
		DistributorClientPath command = DistributorClientPath.DIST_ORDER_CTMTAPPLY;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, request);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<FlightOrderSalesOrderRelationDto>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	public BaseResultDto issuDone(Long distOrderId) throws JsonParseException, JsonMappingException, IOException{
		DistributorClientPath command = DistributorClientPath.DIST_TICKET_DONE;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, distOrderId);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseResultDto>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	@Deprecated
	public BaseResultDto refundDone(Long distOrderId) throws JsonParseException, JsonMappingException, IOException{
		DistributorClientPath command = DistributorClientPath.DIST_REFUND_DONE;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, distOrderId);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseResultDto>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	public BaseResultDto payDone(Long distOrderId) throws JsonParseException, JsonMappingException, IOException{
		DistributorClientPath command = DistributorClientPath.DIST_PAY_DONE;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, distOrderId);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseResultDto>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	public BaseResultDto cancelDone(Long distOrderMainId) throws JsonParseException, JsonMappingException, IOException{
		DistributorClientPath command = DistributorClientPath.DIST_CANCEL_DONE;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, distOrderMainId);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseResultDto>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

}
