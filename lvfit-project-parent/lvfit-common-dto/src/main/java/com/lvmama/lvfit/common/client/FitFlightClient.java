package com.lvmama.lvfit.common.client;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.client.RestClient;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.adapter.request.insurance.InsuranceInfoRequest;
import com.lvmama.lvf.common.dto.adapter.response.SuppResponse;
import com.lvmama.lvf.common.dto.enums.InterfaceKey;
import com.lvmama.lvf.common.dto.flight.FlightAirLineDto;
import com.lvmama.lvf.common.dto.flight.FlightDayPriceAllInOneDto;
import com.lvmama.lvf.common.dto.md.City;
import com.lvmama.lvf.common.dto.request.FlightOrderBookingRequest;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.trace.profile.Profile;
import com.lvmama.lvf.common.trace.profile.ProfilePoint;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.aspect.exception.ExceptionPoint;
import com.lvmama.lvfit.common.aspect.suppinterface.SuppInterfacePoint;
import com.lvmama.lvfit.common.cache.CacheKey;
import com.lvmama.lvfit.common.client.path.FlightClientPath;
import com.lvmama.lvfit.common.dto.calculator.AmountCalculatorDto;
import com.lvmama.lvfit.common.dto.calculator.AmountCalculatorRequest;
import com.lvmama.lvfit.common.dto.enums.FitBusinessExceptionType;
import com.lvmama.lvfit.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.FlightQueryRequest;
import com.lvmama.lvfit.common.dto.search.flight.FlightSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.MockUtil;
import com.lvmama.lvfit.common.utils.FitLoggerHandler;

@Component
public class FitFlightClient {
	
	@Value("lvf.search.baseurl")
	private String searchBaseurl;
	
	/** 聚合服务基本Url */
	@Value("lvf.aggregate.baseurl")
	private String lvfaggregateBaseurl;
	
	@Value("lvf.business.baseurl")
	private String businessBaseUrl;
	
	/** 航班控制是否使用Aggregate */
	@Value("flight.controller.useAggregate")
	private String useAggregate;
	
	/** 远程地址 */
	@Value("lvf.business.maindataurl")
	private String lvfmaindataurl;
	
	@Autowired
	private RestClient restClient;
	
	private static Logger logger = LoggerFactory.getLogger(FitFlightClient.class);
	
	@Autowired
	private FitLoggerHandler fitLoggerHandler;
 
	/**
     * 查询航班及舱位或客票信息
     * @param request
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    @ProfilePoint(Profile.SEARCH_FLIGHT_INFO_FROM_CLIENT)
    public FlightSearchResult<FlightSearchFlightInfoDto> getSearchFlightInfoNoCache(@CacheKey FlightQueryRequest request) throws Exception
    {
    	//1、根据useAggregate设置不同的Url
    	FlightClientPath command = FlightClientPath.FLIGHT_INFO_SEARCH;
    	String url = StringUtils.EMPTY;
    	url = command.url(lvfaggregateBaseurl);
    	try
    	{
    		MockUtil.writeJsonToFile("d:\\log_test\\最终查询航班"+System.currentTimeMillis()+".txt",request);
    		String result = restClient.post(url, String.class, request);
    		if(StringUtils.isNotBlank(result))
    		{
    			MockUtil.writeFile("e:\\hangban"+File.separator+System.currentTimeMillis()+".txt",result);
    			ObjectMapper objectMapper = JSONMapper.getInstance();
    			FlightSearchResult<FlightSearchFlightInfoDto> flightSearchResult = objectMapper.readValue(result, 
    				new TypeReference<FlightSearchResult<FlightSearchFlightInfoDto>>(){});
    			return flightSearchResult;		
    		}
    		return null;
    	}
    	catch(ExceptionWrapper ew)
    	{
    		throw ew;
    	}
    }
    
    
    @ProfilePoint(Profile.SEARCH_FLIGHT_INFO_FROM_CLIENT)
    @SuppInterfacePoint(InterfaceKey.SearchFlight)
	@ExceptionPoint(FitBusinessExceptionType.FIT_SDP_GO_FLIGHT_QUERY_E)
    public FlightSearchResult<FlightSearchFlightInfoDto> getSearchFlights(@CacheKey FlightQueryRequest request) throws Exception{
	    FlightSearchResult<FlightSearchFlightInfoDto > flightSearchResult =  this.getSearchFlightInfoNoCache(request);
    	return flightSearchResult;
    }
    
    public Boolean getUseAggregate() {
    	return Boolean.valueOf(CustomizedPropertyPlaceholderConfigurer.getContextProperty(this.useAggregate).toString());
	}
    
    /**
	 * 查询可用保险列表
	 * 
	 */
	public BaseResultDto<InsuranceInfoDto> queryInsurance(BaseQueryDto<InsuranceInfoRequest> request) {
		FlightClientPath command = FlightClientPath.QUERY_INSURANCE;
		String url = command.url(businessBaseUrl);
		try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonRequest = objectMapper.writeValueAsString(request);
            String jsonResult = restClient.post(url, String.class, jsonRequest);
            return objectMapper.readValue(jsonResult, new TypeReference<BaseResultDto<InsuranceInfoDto>>() {});
        } catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 订单相关金额计算
	 * 
	 * @param request
	 * @return
	 */
    @SuppInterfacePoint(InterfaceKey.FIT_AMOUNTCALCULATE_FLIGHT)
	public AmountCalculatorDto amountCalculate(AmountCalculatorRequest request) {
	    
		FlightClientPath command = FlightClientPath.AMOUNT_CALCULATE;
		String url = command.url(businessBaseUrl);
		try {
			MockUtil.writeFile("D:\\log_test\\amount"+System.currentTimeMillis()+".txt", MockUtil.toJsonStr(request));
			String resultString = restClient.post(url,String.class,request);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,
					new TypeReference<AmountCalculatorDto>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			ExceptionWrapper ew = new ExceptionWrapper();
			ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**
	 * 根据目的地从机票侧获取航线数据
	 * @param arrivalCityCode
	 * @return
	 * @throws Exception
	 */
	public BaseResultDto<FlightAirLineDto> getFlightLines(String arrivalCityCode) {
		
		   FlightClientPath command = FlightClientPath.QUERY_AIRLINES_BY_CITY;
		   FlightAirLineDto condition = new FlightAirLineDto();
		   City arriveCity = new City();
		   arriveCity.setCode(arrivalCityCode);
		   condition.setArriveCity(arriveCity);
		   BaseQueryDto<FlightAirLineDto> baseQueryDto = new BaseQueryDto<FlightAirLineDto>(condition);
	       String url = command.url(lvfmaindataurl);
	       try {
	    	   ObjectMapper objectMapper = JSONMapper.getInstance();
				String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
				String jsonResult = restClient.post(url, String.class, jsonRequest);
				return objectMapper.readValue(jsonResult,new TypeReference<BaseResultDto<FlightAirLineDto>>(){});
	       } catch (ExceptionWrapper ew) {
	           logger.error(ew.getErrMessage(), ew);
	           throw ew;
	       } catch (Exception e) {
	           ExceptionWrapper ew = new ExceptionWrapper();
	           ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
	           ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
	           logger.error(ew.getErrMessage(), ew);
	           throw ew;
	       }
    }
	
	
	/**
	 * 从机票侧获取低价日历数据
	 * @param request
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public List<FlightDayPriceAllInOneDto> getDailyMinPrice(FlightQueryRequest request) {
		FlightClientPath command = FlightClientPath.GET_DAILY_MIN_PRICE;
		String url = command.url(searchBaseurl);
		try {
			String st = restClient.post(url, String.class, request);
			List<FlightDayPriceAllInOneDto> dtos = JSONMapper.getInstance().readValue(st,new TypeReference<List<FlightDayPriceAllInOneDto>>() {});
			return dtos;
		} catch (ExceptionWrapper ew) {
	           logger.error(ew.getErrMessage(), ew);
	           throw ew;
	       } catch (Exception e) {
	           ExceptionWrapper ew = new ExceptionWrapper();
	           ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
	           ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
	           logger.error(ew.getErrMessage(), ew);
	           throw ew;
	       }
	}
	
	/**
	 * 调用机票侧下单
	 * @param flightOrderBookingRequest
	 * @return
	 */
	@SuppInterfacePoint(InterfaceKey.FIT_BOOKING_FLIGHT)
	public SuppResponse  bookingRebuild(FlightOrderBookingRequest flightOrderBookingRequest) {
		FlightClientPath command = FlightClientPath.BOOKING_REBUILD_NEW;
		String url = command.url(businessBaseUrl);
		try {
			MockUtil.writeJsonToFile("d:\\flightrequest\\航班下单请求"+System.currentTimeMillis()+".txt", flightOrderBookingRequest);
			return restClient.post(url, SuppResponse.class,flightOrderBookingRequest);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
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
