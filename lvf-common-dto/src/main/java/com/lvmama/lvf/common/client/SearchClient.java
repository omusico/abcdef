package com.lvmama.lvf.common.client;

import java.io.IOException;
import java.util.List;

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

import com.lvmama.lvf.common.cache.CacheBoxConvert;
import com.lvmama.lvf.common.cache.CacheKey;
import com.lvmama.lvf.common.cache.CachePoint;
import com.lvmama.lvf.common.client.path.SearchClientPath;
import com.lvmama.lvf.common.dto.flight.FlightDayPriceAllInOneDto;
import com.lvmama.lvf.common.dto.request.FlightQueryRequest;
import com.lvmama.lvf.common.dto.request.FlightTicketRequest;
import com.lvmama.lvf.common.dto.search.FlightSearchResult;
import com.lvmama.lvf.common.dto.search.result.FlightSearchFlightInfoDto;
import com.lvmama.lvf.common.dto.search.result.FlightSearchTicketRuleDto;
import com.lvmama.lvf.common.dto.search.result.FlightSearchTicketRuleSimpleDto;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.trace.profile.Profile;
import com.lvmama.lvf.common.trace.profile.ProfilePoint;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvf.common.utils.JSONMapper;

@Component
public class SearchClient extends SolrClient{
	
	@Value("search.baseurl")
	private String baseUrl;
	
	/** 聚合服务基本Url */
	@Value("aggregate.baseurl")
	private String aggregateBaseurl;
	
	@Autowired
	private RestClient restClient;
	
	private static Logger logger = LoggerFactory.getLogger(SearchClient.class);
	
	@Value("solr.host")
    private String solrHost;

    @Value("solr.core_flight")
    private String solrCore;

    @Override
    public String getSolrUrl() {
        String solrHosts = CustomizedPropertyPlaceholderConfigurer.getContextProperty(solrHost);
        String solrCores = CustomizedPropertyPlaceholderConfigurer.getContextProperty(solrCore);
        return solrHosts+solrCores;
    }

	/**
	 * 获得每天航班最低价
	 * 
	 * @param request
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
    @ProfilePoint(Profile.GET_DAILYMINPRICE_FROM_CLIENT)
    @CachePoint(CacheBoxConvert.FlightDayPriceAllInOne)
	public List<FlightDayPriceAllInOneDto> getDailyMinPrice(
			@CacheKey FlightQueryRequest request) throws JsonParseException,
			JsonMappingException, IOException {
		SearchClientPath command = SearchClientPath.GET_DAILY_MIN_PRICE;
		String url = command.url(baseUrl);
		try {
			String st = restClient.post(url, String.class, request);
			List<FlightDayPriceAllInOneDto> dtos = JSONMapper
					.getInstance()
					.readValue(
							st,
							new TypeReference<List<FlightDayPriceAllInOneDto>>() {
							});

			return dtos;
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
     * 验证航班及舱位或客票信息
     * @param request
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public FlightSearchResult<FlightSearchFlightInfoDto> verify(FlightQueryRequest request) throws Exception{
    	SearchClientPath command = SearchClientPath.FLIGHT_VERIFY;
    	String url = command.url(baseUrl);
    	try{
    		String st = restClient.post(url, String.class,request);
    		if(st == null || st.equals("")){
    			return null;
    		}
    		FlightSearchResult<FlightSearchFlightInfoDto> results = JSONMapper
    				.getInstance()
    				.readValue(
    						st,
    						new TypeReference<FlightSearchResult<FlightSearchFlightInfoDto>>() {
    						});
    		return results;
    	}catch(ExceptionWrapper ew){
    		throw ew;
    	}
    }
	
	/**
     * 查询航班及舱位或客票信息
     * @param request
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    @ProfilePoint(Profile.SEARCH_FLIGHT_INFO_FROM_CLIENT)
    //@CachePoint(CacheBoxConvert.FlightSearchResult)
    public FlightSearchResult<FlightSearchFlightInfoDto> getSearchFlightInfoNoCache(@CacheKey FlightQueryRequest request) throws Exception
    {
    	//1、根据useAggregate设置不同的Url
    	SearchClientPath command = SearchClientPath.FLIGHT_INFO_SEARCH;
    	String url = command.url(aggregateBaseurl);
    	
    	//2、调用航班搜索
    	try
    	{
    		String result = restClient.post(url, String.class, request);
    		if(StringUtils.isNotBlank(result))
    		{
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
    @CachePoint(CacheBoxConvert.FlightSearchResult)
    public FlightSearchResult<FlightSearchFlightInfoDto> getSearchFlightInfo(@CacheKey FlightQueryRequest request) throws Exception{
    	return getSearchFlightInfoNoCache(request);
    }
    
    
	/**
     * 查询航班列表
     * @param request
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    @ProfilePoint(Profile.SEARCH_FLIGHT_INFO_FROM_CLIENT)
//    @CachePoint(CacheBoxConvert.FlightSearchResult)
    public FlightSearchResult<FlightSearchFlightInfoDto> getSearchFlightsNoCache(@CacheKey FlightQueryRequest request) throws Exception{
        logger.info("查询航班进入时间点 :SEARCH_FLIGHT_INFO_FROM_CLIENT " + (System.currentTimeMillis()));
    	SearchClientPath command = SearchClientPath.FLIGHT_LIST_SEARCH;
    	String url = command.url(baseUrl);
    	try{
    		String st = restClient.post(url, String.class,request);
    		if(st == null || st.equals("")){
    			return null;
    		}
    		FlightSearchResult<FlightSearchFlightInfoDto> results = JSONMapper
    				.getInstance()
    				.readValue(
    						st,
    						new TypeReference<FlightSearchResult<FlightSearchFlightInfoDto>>() {
    						});
    		return results;
    	}catch(ExceptionWrapper ew){
    		throw ew;
    	}
    }
    
    @ProfilePoint(Profile.SEARCH_FLIGHT_INFO_FROM_CLIENT)
    @CachePoint(CacheBoxConvert.FlightSearchResult)
    public FlightSearchResult<FlightSearchFlightInfoDto> getSearchFlights(@CacheKey FlightQueryRequest request) throws Exception{
    	return getSearchFlightsNoCache(request);
    }
    
    /**
     * 根据航班查询客规信息
     * @param request
     * @return
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
     */
    @CachePoint(CacheBoxConvert.FlightSearchTicketRule)
    public FlightSearchTicketRuleDto getFlightTicketRule(@CacheKey FlightTicketRequest request) throws Exception{
    	SearchClientPath command = SearchClientPath.FLIGHT_TICKET_RULE_SEARCH;
    	String url = command.url(baseUrl);
    	try{
    		FlightSearchTicketRuleDto result = restClient.post(url, FlightSearchTicketRuleDto.class,request);
    		return result;
    	}catch(ExceptionWrapper ew){
    		throw ew;
    	}
    }
    
    /**
     * 根据航班查询简单客规信息
     * @param request
     * @return
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
     */
    @CachePoint(CacheBoxConvert.FlightSearchTicketRuleSimple)
    public FlightSearchTicketRuleSimpleDto getFlightTicketRuleSimple(@CacheKey FlightTicketRequest request) throws Exception{
    	SearchClientPath command = SearchClientPath.FLIGHT_TICKET_RULE_SIMPLE_SEARCH;
    	String url = command.url(baseUrl);
    	try{
    		FlightSearchTicketRuleSimpleDto result = restClient.post(url, FlightSearchTicketRuleSimpleDto.class,request);
    		return result;
    	}catch(ExceptionWrapper ew){
    		throw ew;
    	}
    }
    
}
