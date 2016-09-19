package com.lvmama.lvf.common.client;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.client.path.SearchClientPath;
import com.lvmama.lvf.common.dto.calculator.FlightTicketPriceDto;
import com.lvmama.lvf.common.dto.request.FlightQueryRequest;
import com.lvmama.lvf.common.dto.search.FlightSearchIndexRelateSolr;
import com.lvmama.lvf.common.dto.search.FlightSearchResult;
import com.lvmama.lvf.common.dto.search.result.FlightSearchFlightInfoDto;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.trace.profile.Profile;
import com.lvmama.lvf.common.trace.profile.ProfilePoint;
import com.lvmama.lvf.common.utils.JSONMapper;

/**
 * 航班查询及同步供聚合调用的Client
 * @author leizhengwei
 * 2015年8月13日
 */
@Component
public class SearchForAggregateClient 
{
	private static Logger logger = LoggerFactory.getLogger(SearchForAggregateClient.class);
	
	@Value("search.baseurl")
	private String baseUrl;
	
	@Autowired
	private RestClient restClient;
	
	/**
	 * 从Solr获取航班数据
	 * @param queryRequest
	 * @return
	 * @throws Exception
	 */
	@ProfilePoint(Profile.SEARCH_FLIGHT_INFO_FROM_SOLR)
    public FlightSearchResult<FlightSearchFlightInfoDto> searchFromSolr(FlightQueryRequest queryRequest) throws Exception{
    	SearchClientPath command = SearchClientPath.SEARCHF_ROM_SOLR;
    	String url = command.url(baseUrl);
    	try{
    		String resultStr = restClient.post(url, String.class,queryRequest);
    		if(StringUtils.isBlank(resultStr)){
    			return null;
    		}
    		FlightSearchResult<FlightSearchFlightInfoDto> result = JSONMapper.getInstance().readValue(
    				resultStr,new TypeReference<FlightSearchResult<FlightSearchFlightInfoDto>>() {});
    		return result;
    	}catch(ExceptionWrapper ew){
    		throw ew;
    	}
    }
    
    /**
     * 从数据库同步数据到Solr
     * @param queryRequest
     * @return
     * @throws Exception
     */
    public List<FlightSearchIndexRelateSolr> syncToSolrFromDB(FlightQueryRequest queryRequest) throws Exception{
    	SearchClientPath command = SearchClientPath.SYNC_TO_SOLR_FROM_DB;
    	String url = command.url(baseUrl);
    	try{
//    		System.out.println("syncToSolrFromDB--"+url);
    		String resultStr = restClient.post(url, String.class,queryRequest);
//    		System.out.println("queryRequest"+JSONMapper.getInstance().writeValueAsString(queryRequest));
    		if(StringUtils.isBlank(resultStr)){
    			return null;
    		}
    		List<FlightSearchIndexRelateSolr> result = JSONMapper.getInstance().readValue(
    				resultStr,new TypeReference<List<FlightSearchIndexRelateSolr>>() {});
    		return result;
    	}catch(ExceptionWrapper ew){
    		throw ew;
    	}
    }
    
    /**
     * 从solr计算舱位价格
     * @param queryRequest
     * @return
     * @throws Exception
     */
    public List<FlightTicketPriceDto> calculatorFlightPriceFromSolr(FlightQueryRequest queryRequest) {
    	SearchClientPath command = SearchClientPath.CALCULATOR_FLIGHT_PRICE_FROM_SOLR;
    	String url = command.url(baseUrl);
    	try{
    		String resultStr = restClient.post(url, String.class,queryRequest);
//    		logger.error("queryRequest:"+JSONMapper.getInstance().writeValueAsString(queryRequest));
    		if(StringUtils.isBlank(resultStr)){
    			return null;
    		}
    		List<FlightTicketPriceDto> result = JSONMapper.getInstance().readValue(resultStr,new TypeReference<List<FlightTicketPriceDto>>() {});
    		return result;
    	}catch(ExceptionWrapper ew){
    		throw ew;
    	}catch(Exception e){
    		ExceptionWrapper ew = new ExceptionWrapper();
			ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
			logger.error(ew.getErrMessage(), ew);
			throw ew;
    	}
    }
    
    
}
