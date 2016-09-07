package com.lvmama.lvf.common.client;

import com.lvmama.lvf.common.client.path.BatchClientPath;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.order.FlightOrderImportRecordDto;
import com.lvmama.lvf.common.dto.order.FlightOrderUnionDto;
import com.lvmama.lvf.common.dto.request.FlightOrderUnionRequest;
import com.lvmama.lvf.common.dto.request.FlightQueryBatchRequest;
import com.lvmama.lvf.common.dto.request.FlightQueryRequest;
import com.lvmama.lvf.common.dto.request.FlightSyncBatchRequest;
import com.lvmama.lvf.common.dto.search.FlightSearchIndex;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.dto.vst.FlightVstProductDto;
import com.lvmama.lvf.common.dto.vst.VstTaskConfigDto;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.trace.TraceContext;
import com.lvmama.lvf.common.trace.profile.Profile;
import com.lvmama.lvf.common.trace.profile.ProfilePoint;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class BatchClient {

    @Value("batch.baseurl")
    private String baseUrl;

    @Autowired
    private RestClient client;
    
    public static final Logger logger=Logger.getLogger(BatchClient.class);

    /**
     * 从供应商同步航班信息到DB及返回补全数据
     * 
     * @author leizhengwei
     * 
     * @return
     */
    public String syncFlightInfoFromSupRemote(FlightQueryRequest queryRequest) {
        BatchClientPath command = BatchClientPath.SYNC_FLIGHT_INFO_FROM_SUP;
        String url = command.url(baseUrl) + queryRequest.getDepartureAirportCode() + "/"
                + queryRequest.getArrivalAirportCode() + "/"
                + DateUtils.formatDate(queryRequest.getDepartureDate(), DateUtils.YYYY_MM_DD);
        try {
            return client.get(url, String.class);
        } catch (ExceptionWrapper ew) {
//        	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
    }

    /**
     * 用于验舱验价
     * @author leizhengwei
     * @return
     */
    public List<FlightSearchIndex> sync2solrall(FlightQueryRequest queryRequest) {
        BatchClientPath command = BatchClientPath.SYNC_TO_SOLR_ALL;
        String url = command.url(baseUrl);
        try {
            String resultString = client.post(url, String.class, queryRequest);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper
					.getInstance()
					.readValue(
							resultString,
							new TypeReference<List<FlightSearchIndex>>() {
							});
        } catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        } catch (Exception e) {
        	ExceptionWrapper ew = new ExceptionWrapper();
        	ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
        	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ExceptionUtils.getFullStackTrace(e));
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }

    }
	
    public List<FlightSearchIndex> sync2solr(FlightQueryRequest queryRequest) {
		logger.info("进入的时间点：batchClient:"+TraceContext.getTraceId()+":"+System.currentTimeMillis());
        BatchClientPath command = BatchClientPath.SYNC_TO_SOLR;
        String url = command.url(baseUrl);
        try {
            String resultString = client.post(url, String.class, queryRequest);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper
					.getInstance()
					.readValue(
							resultString,
							new TypeReference<List<FlightSearchIndex>>() {
							});

        } catch (ExceptionWrapper ew) {
//        	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        } catch (Exception e) {
        	ExceptionWrapper ew = new ExceptionWrapper();
        	ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
        	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ExceptionUtils.getFullStackTrace(e));
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }finally{
    		logger.info("结束的时间点：batchClient:"+TraceContext.getTraceId()+":"+System.currentTimeMillis());
        }

    }

    /**
     * 同步单条政策
     * 
     * @param flightPolicyDto
     *            预订请求对象
     * @return FlightPolicyDto 政策信息
     * @throws IOException
     */
    public Long syncOnePolicy(String suppPolicyNo) {
        BatchClientPath command = BatchClientPath.SYNC_ONE_POLICY;
        String url = command.url(baseUrl, suppPolicyNo);
        try {
            return client.get(url,Long.class);
        } catch (ExceptionWrapper ew) {
 //       	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getExceptionCode().getCode()+ew.getErrMessage());
			logger.error(ew.getExceptionCode().getCode()+ew.getErrMessage(),ew);
			throw ew;
        }
    }

    /**
     * 同步全取政策
     * 
     * @param orderMainId
     */
    public String syncAllPolicy() {
        BatchClientPath command = BatchClientPath.SYNC_ALL_POLICY;
        String url = command.url(baseUrl);
        try {
            return client.get(url, String.class);
        } catch (ExceptionWrapper ew) {
  //      	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
    }

    /**
     * 同步更新政策
     * 
     * @param orderMainId
     */
    public String syncUpdatedPolicy() {
        BatchClientPath command = BatchClientPath.SYNC_UPDATE_POLICY;
        String url = command.url(baseUrl);
        try {
            return client.get(url, String.class);
        } catch (ExceptionWrapper ew) {
  //      	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
    }
    
    /**
     * 同步VST数据
     * @param beginDate 需要同步的日期的开始日期
     * @param endDate 需要同步的日期的结束日期
     * @return
     */
    public String syncVSTData(String beginDate,String endDate){
        BatchClientPath command = BatchClientPath.SYNC_VST_DATA;
        String url = command.url(baseUrl,beginDate,endDate);
        try {
            return client.get(url, String.class);
        } catch (ExceptionWrapper ew) {
  //      	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
    }
    
    /**
     * 同步vst产品数据
     * @param beginDate
     * @param endDate
     * @return
     */
    public String syncVSTProductData(Date beginDate,Date endDate){
    	 BatchClientPath command = BatchClientPath.SYNC_VST_PRODUCT_DATA;
         String url = command.url(baseUrl,beginDate,endDate);
         try {
             return client.get(url, String.class);
         } catch (ExceptionWrapper ew) {
  //       	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
 			logger.error(ew.getErrMessage(),ew);
 			throw ew;
         }
    }
    
    /**
     * 机票端，同步vst产品规格信息
     * @param products
     * @return
     */
    public String syncVSTProductBranchData(List<FlightVstProductDto> products){
    	BatchClientPath command = BatchClientPath.SYNC_VST_PRODUCT_BRANCH_DATA;
        String url = command.url(baseUrl);
        try {
        	String jsonRequest = JSONMapper.getInstance().writeValueAsString(products);
            return client.post(url, String.class, jsonRequest);
        } catch (ExceptionWrapper ew) {
 //       	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        } catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
    
    
    public String init2solrByParam(String params){
    	BatchClientPath command = BatchClientPath.INIT_TO_SOLR_BY_PARAM;
		String url = command.url(baseUrl,params);
		try {
			return client.get(url, String.class);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    
    /**
	 * Ctrip航班运价基本信息同步
	 * @param  flightSyncBatchRequest 		航班同步Batch请求对象
	 * @return ResultStatus 				成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_PRICE_INFO_CTRIP_SYNC)
	public ResultStatus flightPriceInfoCtripSync(FlightSyncBatchRequest flightSyncBatchRequest) 
	{
		BatchClientPath command = BatchClientPath.FLIGHT_PRICE_INFO_CTRIP_SYNC;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightSyncBatchRequest);
		return resultStatus;
	}
	
	/**
	 * 51Book航班运价基本信息同步
	 * @param  flightSyncBatchRequest 		航班同步Batch请求对象
	 * @return ResultStatus 				成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_PRICE_INFO_51BOOK_SYNC)
	public ResultStatus flightPriceInfo51BookSync(FlightSyncBatchRequest flightSyncBatchRequest) 
	{
		BatchClientPath command = BatchClientPath.FLIGHT_PRICE_INFO_51BOOK_SYNC;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightSyncBatchRequest);
		return resultStatus;
	}
	
	/**
	 * Ctrip航班运价政策信息同步
	 * @param  flightSyncBatchRequest 		航班同步Batch请求对象
	 * @return ResultStatus 				成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_PRICE_POLICY_CTRIP_SYNC)
	public ResultStatus flightPricePolicyCtripSync(FlightSyncBatchRequest flightSyncBatchRequest)
	{
		BatchClientPath command = BatchClientPath.FLIGHT_PRICE_POLICY_CTRIP_SYNC;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightSyncBatchRequest);
		return resultStatus;
	}
	
	/**
	 * 51Book航班运价政策信息同步
	 * @param  flightSyncBatchRequest 		航班同步Batch请求对象
	 * @return ResultStatus 				成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_PRICE_POLICY_51BOOK_SYNC)
	public ResultStatus flightPricePolicy51BookSync(FlightSyncBatchRequest flightSyncBatchRequest)
	{
		BatchClientPath command = BatchClientPath.FLIGHT_PRICE_POLICY_51BOOK_SYNC;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightSyncBatchRequest);
		return resultStatus;
	}
	
	/**
	 * 运价库存信息同步
	 * @param  flightQueryRequest 		航班查询请求对象
	 * @return ResultStatus 			成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_PRICE_INVENTORY_SYNC)
	public ResultStatus flightPriceInventorySync(FlightQueryRequest flightQueryRequest) 
	{
		BatchClientPath command = BatchClientPath.FLIGHT_PRICE_INVENTORY_SYNC;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightQueryRequest);
		return resultStatus;
	}
	
	/**
	 * Ctrip航班基本信息同步
	 * @param  flightSyncBatchRequest 		航班同步Batch请求对象
	 * @return ResultStatus 				成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_INFO_CTRIP_SYNC)
	public ResultStatus flightInfoCtripSync(FlightSyncBatchRequest flightSyncBatchRequest) 
	{
		BatchClientPath command = BatchClientPath.FLIGHT_INFO_CTRIP_SYNC;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightSyncBatchRequest);
		return resultStatus;
	}
	
	/**
	 * Ctrip航班舱位同步
	 * @param  flightSyncBatchRequest 		航班同步Batch请求对象
	 * @return ResultStatus 				成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_SEAT_CTRIP_SYNC)
	public ResultStatus flightSeatCtripSync(FlightSyncBatchRequest flightSyncBatchRequest) 
	{
		BatchClientPath command = BatchClientPath.FLIGHT_SEAT_CTRIP_SYNC;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightSyncBatchRequest);
		return resultStatus;
	}
	
	/**
	 * Ctrip每日航班同步
	 * @param  flightSyncBatchRequest 		航班同步Batch请求对象
	 * @return ResultStatus 				成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_DAILY_CTRIP_SYNC)
	public ResultStatus flightDailyCtripSync(FlightSyncBatchRequest flightSyncBatchRequest) 
	{
		BatchClientPath command = BatchClientPath.FLIGHT_DAILY_CTRIP_SYNC;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightSyncBatchRequest);
		return resultStatus;
	}
	
	/**
	 * Ctrip运价客规同步
	 * @param  flightSyncBatchRequest 		航班同步Batch请求对象
	 * @return ResultStatus 				成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_PRICE_TICKET_RULE_CTRIP_SYNC)
	public ResultStatus flightPriceTicketRuleCtripSync(FlightSyncBatchRequest flightSyncBatchRequest) 
	{
		BatchClientPath command = BatchClientPath.FLIGHT_PRICE_TICKET_RULE_CTRIP_SYNC;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightSyncBatchRequest);
		return resultStatus;
	}
	
	/**
	 * 51Book航班基本信息同步
	 * @param  flightSyncBatchRequest 		航班同步Batch请求对象
	 * @return ResultStatus 				成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_INFO_51BOOK_SYNC)
	public ResultStatus flightInfo51BookSync(FlightSyncBatchRequest flightSyncBatchRequest) 
	{
		BatchClientPath command = BatchClientPath.FLIGHT_INFO_51BOOK_SYNC;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightSyncBatchRequest);
		return resultStatus;
	}
	
	/**
	 * 51Book航班舱位同步
	 * @param  flightSyncBatchRequest 		航班同步Batch请求对象
	 * @return ResultStatus 				成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_SEAT_51BOOK_SYNC)
	public ResultStatus flightSeat51BookSync(FlightSyncBatchRequest flightSyncBatchRequest) 
	{
		BatchClientPath command = BatchClientPath.FLIGHT_SEAT_51BOOK_SYNC;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightSyncBatchRequest);
		return resultStatus;
	}
	
	/**
	 * 51Book每日航班同步
	 * @param  flightSyncBatchRequest 		航班同步Batch请求对象
	 * @return ResultStatus 				成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_DAILY_51BOOK_SYNC)
	public ResultStatus flightDaily51BookSync(FlightSyncBatchRequest flightSyncBatchRequest) 
	{
		BatchClientPath command = BatchClientPath.FLIGHT_DAILY_51BOOK_SYNC;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightSyncBatchRequest);
		return resultStatus;
	}
	

	/**
	 * 根据航线同步VST数据,如果id不为null立即执行某个航线的同步任务
	 * @param deptCityCode
	 * @param arrvCityCode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String,Object> syncVstDataByAirline(VstTaskConfigDto task) 
	{
		BatchClientPath command = BatchClientPath.SYNC_VST_DATA_BY_AIRLINE;
		String url = command.url(baseUrl);
		try 
		{
			String result = client.post(url, String.class, task);
			try {
				return JSONMapper.getInstance().readValue(result, Map.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
		return null;
	}
	
	/**
	 * 原子化航班信息同步
	 * @param  flightQueryRequest 		航班查询请求对象
	 * @return ResultStatus 			成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_SYNC)
	public ResultStatus flightSync(FlightQueryBatchRequest flightQueryBatchRequest) 
	{
		BatchClientPath command = BatchClientPath.FLIGHT_SYNC;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightQueryBatchRequest);
		return resultStatus;
	}
    
    /**
	 * 通过51同步航班基本信息与每日航班信息(定时任务的方式缓存信息)
	 * @param  flightQueryRequest 		航班查询请求对象
	 * @return ResultStatus 			成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_BASE_INFO_SYNC_FOR_TASK)
	public ResultStatus flightBaseInfoSyncForTask(FlightQueryBatchRequest flightQueryBatchRequest) 
	{
		BatchClientPath command = BatchClientPath.FLIGHT_BASE_INFO_SYNC_FOR_TASK;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightQueryBatchRequest);
		return resultStatus;
	}
    
    /**
	 * 调用通过携程同步航班信息（定时任务的方式缓存信息）
	 * @param  flightQueryRequest 		航班查询请求对象
	 * @return ResultStatus 			成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_CTRIP_INFO_SYNC_FOR_TASK)
	public ResultStatus flightCtripInfoSyncForTask(FlightQueryBatchRequest flightQueryBatchRequest) 
	{
		BatchClientPath command = BatchClientPath.FLIGHT_CTRIP_INFO_SYNC_FOR_TASK;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightQueryBatchRequest);
		return resultStatus;
	}
	
	/**
     * 根据航线缓存低价日历数据
     * @param flightQueryRequest
     * @return
     */
   	public ResultStatus cacheFlightCalendar(FlightQueryRequest flightQueryRequest) 
   	{
   		BatchClientPath command = BatchClientPath.CACHE_FLIGHT_CALENDAR;
   		String url = command.url(baseUrl);
   		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightQueryRequest);
   		return resultStatus;
   	}
    
    /**
	 * lvmama航班基本信息同步
	 * @param  flightSyncBatchRequest 		航班同步Batch请求对象
	 * @return ResultStatus 				成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_INFO_LVMAMA_SYNC)
	public ResultStatus flightInfoLvmamaSync(FlightSyncBatchRequest flightSyncBatchRequest) 
	{
		BatchClientPath command = BatchClientPath.FLIGHT_INFO_LVMAMA_SYNC;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightSyncBatchRequest);
		return resultStatus;
	}
    
    /**
	 * Lvmama航班舱位同步
	 * @param  flightSyncBatchRequest 		航班同步Batch请求对象
	 * @return ResultStatus 				成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_SEAT_LVMAMA_SYNC)
	public ResultStatus flightSeatLvmamaSync(FlightSyncBatchRequest flightSyncBatchRequest) 
	{
		BatchClientPath command = BatchClientPath.FLIGHT_SEAT_LVMAMA_SYNC;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightSyncBatchRequest);
		return resultStatus;
	}
    
    /**
	 * Lvmama每日航班同步
	 * @param  flightSyncBatchRequest 		航班同步Batch请求对象
	 * @return ResultStatus 				成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_DAILY_LVMAMA_SYNC)
	public ResultStatus flightDailyLvmamaSync(FlightSyncBatchRequest flightSyncBatchRequest) 
	{
		BatchClientPath command = BatchClientPath.FLIGHT_DAILY_LVMAMA_SYNC;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightSyncBatchRequest);
		return resultStatus;
	}
    
    /**
	 * Lvmama航班运价基本信息同步
	 * @param  flightSyncBatchRequest 		航班同步Batch请求对象
	 * @return ResultStatus 				成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_PRICE_INFO_LVMAMA_SYNC)
	public ResultStatus flightPriceInfoLvmamaSync(FlightSyncBatchRequest flightSyncBatchRequest) 
	{
		BatchClientPath command = BatchClientPath.FLIGHT_PRICE_INFO_LVMAMA_SYNC;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightSyncBatchRequest);
		return resultStatus;
	}
    
    /**
	 * Lvmama航班运价政策信息同步
	 * @param  flightSyncBatchRequest 		航班同步Batch请求对象
	 * @return ResultStatus 				成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_PRICE_POLICY_LVMAMA_SYNC)
	public ResultStatus flightPricePolicyLvmamaSync(FlightSyncBatchRequest flightSyncBatchRequest)
	{
		BatchClientPath command = BatchClientPath.FLIGHT_PRICE_POLICY_LVMAMA_SYNC;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightSyncBatchRequest);
		return resultStatus;
	}
    
    /**
	 * lvmama_domestic航班基本信息同步
	 * @param  flightSyncBatchRequest 		航班同步Batch请求对象
	 * @return ResultStatus 				成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_INFO_LVMAMA_DOMESTIC_SYNC)
	public ResultStatus flightInfoLvmamaDomesticSync(FlightSyncBatchRequest flightSyncBatchRequest) 
	{
		BatchClientPath command = BatchClientPath.FLIGHT_INFO_LVMAMA_DOMESTIC_SYNC;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightSyncBatchRequest);
		return resultStatus;
	}
    
    /**
	 * Lvmama_domestic航班舱位同步
	 * @param  flightSyncBatchRequest 		航班同步Batch请求对象
	 * @return ResultStatus 				成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_SEAT_LVMAMA_DOMESTIC_SYNC)
	public ResultStatus flightSeatLvmamaDomesticSync(FlightSyncBatchRequest flightSyncBatchRequest) 
	{
		BatchClientPath command = BatchClientPath.FLIGHT_SEAT_LVMAMA_DOMESTIC_SYNC;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightSyncBatchRequest);
		return resultStatus;
	}
    
    /**
	 * Lvmama_domestic每日航班同步
	 * @param  flightSyncBatchRequest 		航班同步Batch请求对象
	 * @return ResultStatus 				成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_DAILY_LVMAMA_DOMESTIC_SYNC)
	public ResultStatus flightDailyLvmamaDomesticSync(FlightSyncBatchRequest flightSyncBatchRequest) 
	{
		BatchClientPath command = BatchClientPath.FLIGHT_DAILY_LVMAMA_DOMESTIC_SYNC;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightSyncBatchRequest);
		return resultStatus;
	}
    
    /**
	 * Lvmama_domestic航班运价基本信息同步
	 * @param  flightSyncBatchRequest 		航班同步Batch请求对象
	 * @return ResultStatus 				成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_PRICE_INFO_LVMAMA_DOMESTIC_SYNC)
	public ResultStatus flightPriceInfoLvmamaDomesticSync(FlightSyncBatchRequest flightSyncBatchRequest) 
	{
		BatchClientPath command = BatchClientPath.FLIGHT_PRICE_INFO_LVMAMA_DOMESTIC_SYNC;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightSyncBatchRequest);
		return resultStatus;
	}
    
    /**
	 * Lvmama_domestic航班运价政策信息同步
	 * @param  flightSyncBatchRequest 		航班同步Batch请求对象
	 * @return ResultStatus 				成功状态
	 */
    @ProfilePoint(Profile.FLIGHT_PRICE_POLICY_LVMAMA_DOMESTIC_SYNC)
	public ResultStatus flightPricePolicyLvmamaDomesticSync(FlightSyncBatchRequest flightSyncBatchRequest)
	{
		BatchClientPath command = BatchClientPath.FLIGHT_PRICE_POLICY_LVMAMA_DOMESTIC_SYNC;
		String url = command.url(baseUrl);
		ResultStatus resultStatus = client.post(url, ResultStatus.class, flightSyncBatchRequest);
		return resultStatus;
	}
    
    /**
     * 会员成长值计算订单总数接口
     * @param flightOrderUnionRequest
     * @return
     */
    public Long queryNormalOrderListCount(FlightOrderUnionRequest flightOrderUnionRequest){
    	BatchClientPath command = BatchClientPath.QUERY_FLIGHT_NORMAL_ORDER_LIST_COUNT;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(flightOrderUnionRequest);
			String jsonResult = client.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,new TypeReference<Long>(){});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    
    /**
     * 会员成长值计算退票订单总数接口
     * @param flightOrderUnionRequest
     * @return
     */
    public Long queryRTVTOrderListCount(FlightOrderUnionRequest flightOrderUnionRequest){
    	BatchClientPath command = BatchClientPath.QUERY_FLIGHT_RTVT_ORDER_LIST_COUNT;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(flightOrderUnionRequest);
			String jsonResult = client.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,new TypeReference<Long>(){});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }

    /**
     * 会员成长值计算改期订单总数接口
     * @param flightOrderUnionRequest
     * @return
     */
    public Long queryCTMTOrderListCount(FlightOrderUnionRequest flightOrderUnionRequest){
    	BatchClientPath command = BatchClientPath.QUERY_FLIGHT_CTMT_ORDER_LIST_COUNT;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(flightOrderUnionRequest);
			String jsonResult = client.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,new TypeReference<Long>(){});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    
    /**
     * 会员成长值计算订单详情接口
     * @param flightOrderUnionRequest
     * @return
     */
    public BaseResultDto<FlightOrderUnionDto> queryNormalOrderList(FlightOrderUnionRequest flightOrderUnionRequest){
    	BatchClientPath command = BatchClientPath.QUERY_FLIGHT_NORMAL_ORDER_LIST;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(flightOrderUnionRequest);
			String jsonResult = client.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,new TypeReference<BaseResultDto<FlightOrderUnionDto>>(){});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    
    /**
     * 会员成长值计算退票订单详情接口
     * @param flightOrderUnionRequest
     * @return
     */
    public BaseResultDto<FlightOrderUnionDto> queryRTVTOrderList(FlightOrderUnionRequest flightOrderUnionRequest){
    	BatchClientPath command = BatchClientPath.QUERY_FLIGHT_RTVT_ORDER_LIST;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(flightOrderUnionRequest);
			String jsonResult = client.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,new TypeReference<BaseResultDto<FlightOrderUnionDto>>(){});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }

    /**
     * 会员成长值计算改期订单详情接口
     * @param flightOrderUnionRequest
     * @return
     */
    public BaseResultDto<FlightOrderUnionDto> queryCTMTOrderList(FlightOrderUnionRequest flightOrderUnionRequest){
    	BatchClientPath command = BatchClientPath.QUERY_FLIGHT_CTMT_ORDER_LIST;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(flightOrderUnionRequest);
			String jsonResult = client.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,new TypeReference<BaseResultDto<FlightOrderUnionDto>>(){});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }


	/**
	 * 订单导入
	 */
	public BaseSingleResultDto saveImportOrders(FlightOrderImportRecordDto recordDto) {
		try {
			return client.post(BatchClientPath.SAVE_ORDER_IMPORT.url(baseUrl), BaseSingleResultDto.class, recordDto);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

}
