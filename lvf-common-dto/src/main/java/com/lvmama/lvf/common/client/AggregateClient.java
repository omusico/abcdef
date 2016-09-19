package com.lvmama.lvf.common.client;

import java.io.IOException;

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

import com.lvmama.lvf.common.client.path.AggregateClientPath;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.booking.FlightBookingVerifySeatAndPriceDto;
import com.lvmama.lvf.common.dto.request.FlightBookingVerifyRequest;
import com.lvmama.lvf.common.dto.request.FlightQueryRequest;
import com.lvmama.lvf.common.dto.search.FlightSearchRecordIndex;
import com.lvmama.lvf.common.dto.search.FlightSearchRecordRequest;
import com.lvmama.lvf.common.dto.search.result.FlightSearchFlightInfoDto;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.JSONMapper;

@Component
public class AggregateClient {

    private static Logger logger = LoggerFactory.getLogger(AggregateClient.class);

    /** 聚合服务基本Url */
    @Value("aggregate.baseurl")
    private String aggregateBaseurl;
    
    /** 资源项目聚合服务基本Url */
    @Value("lvfr.aggregate.realtime.baseurl")
    private String lvfrAggregateRealtimeBaseurl;

    @Autowired
    private RestClient restClient;

    /**
     * 验舱验价
     * 
     * @param request
     * @return BaseResultDto<FlightBookingVerifySeatAndPriceDto>
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public BaseResultDto<FlightBookingVerifySeatAndPriceDto> verifySeatAndPrice(
            FlightBookingVerifyRequest verifyRequest) throws JsonParseException,JsonMappingException, IOException {
        AggregateClientPath command = AggregateClientPath.VERIFY_SEAT_AND_PRICE;
        String url = command.url(aggregateBaseurl);
        try {
            String resultString = restClient.post(url, String.class, verifyRequest);
            if (StringUtils.isNotBlank(resultString)) {
                ObjectMapper objectMapper = JSONMapper.getInstance();
                BaseResultDto<FlightBookingVerifySeatAndPriceDto> verifySeatAndPriceDtos = objectMapper
                        .readValue(resultString, new TypeReference<BaseResultDto<FlightBookingVerifySeatAndPriceDto>>() {});
                return verifySeatAndPriceDtos;
            }
            return null;

        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
    
	/**
	 * 查询机票查询记录
	 * @param baseQueryDto
	 * @return
	 */
	public BaseResponseDto<FlightSearchRecordIndex> querySearchRecord(BaseQueryDto<FlightSearchRecordRequest> baseQueryDto)
	{
		AggregateClientPath command = AggregateClientPath.SEARCH_RECORD_FROM_SOLR;
		String url = command.url(aggregateBaseurl);
		try 
		{
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult, new TypeReference<BaseResponseDto<FlightSearchRecordIndex>>(){});
		} 
		catch (Exception e) 
		{
			ExceptionWrapper ew = new ExceptionWrapper();
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**
	 * 聚合avetime查询航班可销售信息
	 * @param flightQueryRequest
	 * @return
	 * @throws Exception
	 */
	public BaseResultDto<FlightSearchFlightInfoDto> avetimeRoute(FlightQueryRequest flightQueryRequest) throws Exception{
		AggregateClientPath command = AggregateClientPath.AGG_AVETIME;
		String url = command.url(lvfrAggregateRealtimeBaseurl);
		try {
			String resultString = restClient.post(url, String.class,flightQueryRequest);
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseResultDto<FlightSearchFlightInfoDto>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch(Exception e){
			logger.error(e.getMessage(),e);
			throw e;
		}
	}
    
	
	/**
	 * 导出机票查询记录
	 * @param baseQueryDto
	 * @return
	 */
	public BaseResponseDto<FlightSearchRecordIndex> exportSearchRecord(BaseQueryDto<FlightSearchRecordRequest> baseQueryDto)
	{
		AggregateClientPath command = AggregateClientPath.EXPORT_RECORD_FROM_SOLR;
		String url = command.url(aggregateBaseurl);
		try 
		{
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult, new TypeReference<BaseResponseDto<FlightSearchRecordIndex>>(){});
		} 
		catch (Exception e) 
		{
			ExceptionWrapper ew = new ExceptionWrapper();
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
}
