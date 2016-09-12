package com.lvmama.lvfit.common.client;

import java.io.IOException;
import java.util.List;

import com.lvmama.lvfit.common.cache.CacheBoxConvert;
import com.lvmama.lvfit.common.cache.CacheKey;
import com.lvmama.lvfit.common.cache.CachePoint;
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
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.path.AggregateClientPath;
import com.lvmama.lvfit.common.dto.hotel.FitCommentDto;
import com.lvmama.lvfit.common.dto.hotel.FitHotelDto;
import com.lvmama.lvfit.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvfit.common.dto.request.FitCommentRequest;
import com.lvmama.lvfit.common.dto.request.FitHotelRequest;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpGoodsRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductCalendarDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductGroupQueryRequest;
import com.lvmama.lvfit.common.dto.sdp.product.result.FitSdpGroupCalendarSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.FlightQueryRequest;
import com.lvmama.lvfit.common.dto.search.flight.FlightSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.MockUtil;
import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceQueryRequest;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceSearchResult;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;
import com.lvmama.lvfit.common.dto.search.spot.SpotQueryRequest;
import com.lvmama.lvfit.common.dto.search.spot.SpotSearchResult;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotDto;

@Component
public class FitAggregateClient {

    private static Logger logger = LoggerFactory.getLogger(FitAggregateClient.class);

    /** 机+酒 聚合服务基本Url */
    @Value("lvfit.aggregate.baseurl")
    private String lvfitaggregateBaseurl;

    @Autowired
    private RestClient restClient;
    
    /**
     * 机票查询
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
     * 
     * */
    public FlightSearchResult<FlightSearchFlightInfoDto> searchFlightInfo(FlightQueryRequest request) {
    	AggregateClientPath command = AggregateClientPath.FLIGHT_INFO_SEARCH;
    	String url = StringUtils.EMPTY;
    	url = command.url(lvfitaggregateBaseurl);
    	try
    	{
    		MockUtil.writeFile("d:\\log_test\\查询航班"+System.currentTimeMillis()+".txt", MockUtil.toJsonStr(request));
    		String result = restClient.post(url, String.class, request);
    		if(StringUtils.isNotBlank(result))
    		{
    			ObjectMapper objectMapper = JSONMapper.getInstance();
    			FlightSearchResult<FlightSearchFlightInfoDto> flightSearchResult = objectMapper.readValue(result, 
    				new TypeReference<FlightSearchResult<FlightSearchFlightInfoDto>>(){});
    			return flightSearchResult;		
    		}
    		return null;
    	}catch (ExceptionWrapper ew) {
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
     * 酒店查询
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
     * 
     * **/
    
    public HotelSearchResult<HotelSearchHotelDto> searchHotelInfo(HotelQueryRequest request){
    	AggregateClientPath command = AggregateClientPath.HOTEL_SEARCH;
    	String url = StringUtils.EMPTY;
    	url = command.url(lvfitaggregateBaseurl);
    	try
    	{
    		String result = restClient.post(url, String.class, request);
    		if(StringUtils.isNotBlank(result))	
    		{
    			ObjectMapper objectMapper = JSONMapper.getInstance();
    			HotelSearchResult<HotelSearchHotelDto> hotelSearchResult = objectMapper.readValue(result, 
    				new TypeReference<HotelSearchResult<HotelSearchHotelDto>>(){});
    					//new TypeReference<HotelSearchResult>(){});
    			return hotelSearchResult;		
    		}
    		return null;
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
     * 保险查询
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
     * 
     * **/
    
    public List<InsuranceInfoDto> searchFlightInsurance() throws JsonParseException, JsonMappingException, IOException{
    	AggregateClientPath command = AggregateClientPath.FLIGHT_INSURANCE_SEARCH;
    	String url = StringUtils.EMPTY;
    	url = command.url(lvfitaggregateBaseurl);
    	try {
    		String result = restClient.post(url, String.class);
    		if(StringUtils.isNotBlank(result)) {
    			ObjectMapper objectMapper = JSONMapper.getInstance();
    			List<InsuranceInfoDto>  list = objectMapper.readValue(result, new TypeReference<List<InsuranceInfoDto>>(){});
    			return list;		
    		}
    		return null;
    	} catch(ExceptionWrapper ew) {
    		logger.error("调用保险接口返回数据异常"+url);
    		throw ew;
    	}
    }
    /**
     * 点评查询
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
     * 
     * **/
    
    public FitCommentDto getCommentPage(FitCommentRequest request) throws JsonParseException, JsonMappingException, IOException{
    	AggregateClientPath command = AggregateClientPath.COMMENT_QUERY;
    	String url = StringUtils.EMPTY;
    	url = command.url(lvfitaggregateBaseurl);
    	try
    	{
    		String result = restClient.post(url, String.class,request);
    		if(StringUtils.isNotBlank(result))	
    		{
    			ObjectMapper objectMapper = JSONMapper.getInstance();
    			FitCommentDto dto = objectMapper.readValue(result,new TypeReference<FitCommentDto>(){});
    			return dto;		
    		}
    		return null;
    	}
    	catch(ExceptionWrapper ew)
    	{
    		logger.error("调用点评信息异常"+url);
    		throw ew;
    	}
    	
    }
    
    
    public FitHotelDto getHotelDetail(FitHotelRequest request) throws JsonParseException, JsonMappingException, IOException{
    	AggregateClientPath command = AggregateClientPath.HOTEL_DETAIL;
    	String url = StringUtils.EMPTY;
    	url = command.url(lvfitaggregateBaseurl);
    	try
    	{
    		String result = restClient.post(url, String.class, request);
    		if(StringUtils.isNotBlank(result))	
    		{
    			ObjectMapper objectMapper = JSONMapper.getInstance();
    			FitHotelDto hotelResult = objectMapper.readValue(result, new TypeReference<FitHotelDto>(){});
    			return hotelResult;		
    		}
    		return null;
    	}
    	catch(ExceptionWrapper ew){
    		ew.printStackTrace();
    		logger.error("调用酒店接口返回数据异常"+url);
    		throw ew;
    	}
    }
    
    /**
     * 景点搜索聚合接口
     * @param request
     * @return
     */
    public SpotSearchResult<SpotSearchSpotDto> searchSpot(SpotQueryRequest request){
    	AggregateClientPath command = AggregateClientPath.SPOT_SEARCH;
    	String url = StringUtils.EMPTY;
    	url = command.url(lvfitaggregateBaseurl);
    	try
    	{
    		String result = restClient.post(url, String.class, request);
    		if(StringUtils.isNotBlank(result))	
    		{
    			ObjectMapper objectMapper = JSONMapper.getInstance();
    			SpotSearchResult<SpotSearchSpotDto> spotSearchResult = objectMapper.readValue(result, 
    				new TypeReference<SpotSearchResult<SpotSearchSpotDto>>(){});
    			return spotSearchResult;		
    		}
    		return null;
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
     *  保险接口查询
     * @author wanghuihui
     * @date:2016年3月22日 下午4:59:42
     * @param request
     * @return
     */
	public InsuranceSearchResult<InsuranceDto> searchInsuranceFromVst(InsuranceQueryRequest request) {
		AggregateClientPath command = AggregateClientPath.INSURANCE_SEARCH;
    	String url = StringUtils.EMPTY;
    	url = command.url(lvfitaggregateBaseurl);
    	try
    	{
    		String result = restClient.post(url, String.class, request);
    		if(StringUtils.isNotBlank(result))	
    		{
    			ObjectMapper objectMapper = JSONMapper.getInstance();
    			InsuranceSearchResult<InsuranceDto> searchResult = objectMapper.readValue(result, 
    					new TypeReference<InsuranceSearchResult<InsuranceDto>>(){});
    			return searchResult;		
    		}
    		return null;
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
	 * 获取被打包产品价格日历
	 * @param fitProductGroupQueryRequest
	 * @return
	 */
	public FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> searchProductGroupFromVst(@CacheKey FitSdpProductGroupQueryRequest fitProductGroupQueryRequest) {
		AggregateClientPath command = AggregateClientPath.PRODUCT_CALENDAR_SEARCH;
    	String url = command.url(lvfitaggregateBaseurl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(fitProductGroupQueryRequest);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			if (StringUtils.isBlank(jsonResult)) {
			    return new FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto>();
			}
			return objectMapper.readValue(jsonResult, new TypeReference<FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto>>() {});
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
     * 获取被打包产品基本信息
     */
	@CachePoint(value = CacheBoxConvert.FitSdpProductBasicInfoDto, cacheExpireTimeKey = "lvfit.product.cacheTime")
    public FitSdpProductBasicInfoDto searchProductBasicInfo(@CacheKey Long productId) {
        AggregateClientPath command = AggregateClientPath.PACKAGE_PRODUCT_BASIC_INFO_SEARCH;
        String url = command.url(lvfitaggregateBaseurl, productId);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonResult = restClient.post(url, String.class);
            if (StringUtils.isBlank(jsonResult)) {
                return null;
            }
            return objectMapper.readValue(jsonResult, new TypeReference<FitSdpProductBasicInfoDto>() {});
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
 
    public FitSdpProductBasicInfoDto searchProductInfoOnly(@CacheKey Long productId) {
        AggregateClientPath command = AggregateClientPath.PACKAGE_PRODUCT_INFO_ONLY_SEARCH;
        String url = command.url(lvfitaggregateBaseurl, productId);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonResult = restClient.post(url, String.class);
            if (StringUtils.isBlank(jsonResult)) {
                return null;
            }
            return objectMapper.readValue(jsonResult, new TypeReference<FitSdpProductBasicInfoDto>() {});
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
	 * 实时查询产品基本信息，并更新缓存
	 * @param productId
	 * @return
     */
	@CachePoint(value = CacheBoxConvert.FitSdpProductBasicInfoDto, cacheExpireTimeKey = "lvfit.product.cacheTime", isCacheEnable = false)
	public FitSdpProductBasicInfoDto getProBasicInfoAndFlushCache(@CacheKey Long productId) {
		AggregateClientPath command = AggregateClientPath.PACKAGE_PRODUCT_BASIC_INFO_SEARCH;
		String url = command.url(lvfitaggregateBaseurl, productId);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonResult = restClient.post(url, String.class);
			if (StringUtils.isBlank(jsonResult)) {
				return null;
			}
			return objectMapper.readValue(jsonResult, new TypeReference<FitSdpProductBasicInfoDto>() {});
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
     * 获取被打包产品商品信息
     */
    public BaseSingleResultDto<FitSdpGoodsDto> searchProductGoodsInfo(FitSdpGoodsRequest req) {
        AggregateClientPath command = AggregateClientPath.PACKAGE_GOODS_INFO_SEARCH;
        String url = command.url(lvfitaggregateBaseurl);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonRequest = objectMapper.writeValueAsString(req);
            String jsonResult = restClient.post(url, String.class, jsonRequest);
            if (StringUtils.isBlank(jsonResult)) {
                return null;
            }
            return objectMapper.readValue(jsonResult, new TypeReference<BaseSingleResultDto<FitSdpGoodsDto>>() {});
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
     * 获取合同
     */
    public BaseSingleResultDto<String> getContracts(FitOrderBookingRequest req) {
        AggregateClientPath command = AggregateClientPath.CONTRACTS;
        String url = command.url(lvfitaggregateBaseurl);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonRequest = objectMapper.writeValueAsString(req);
            String jsonResult = restClient.post(url, String.class, jsonRequest);
            if (StringUtils.isBlank(jsonResult)) {
                return null;
            }
            return objectMapper.readValue(jsonResult, new TypeReference<BaseSingleResultDto<String>>() {});
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
