package com.lvmama.lvfit.common.client;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.client.RestClient;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.request.FlightOrderBookingRequest;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.path.BussinessClientPath;
import com.lvmama.lvfit.common.client.path.ReportClientPath;
import com.lvmama.lvfit.common.dto.FitOpLog;
import com.lvmama.lvfit.common.dto.hotel.FitConRecomHotelDto;
import com.lvmama.lvfit.common.dto.hotel.FitConRecomHotelRequestForm;
import com.lvmama.lvfit.common.dto.order.FitOrderDetail;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.order.FitOrderQueryListDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderForFlightCallBackDto;
import com.lvmama.lvfit.common.dto.request.*;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpCityGroupDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductFeeRulesDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexTraffic;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSyncMsgDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductTrafficRulesDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductBasicInfoRequest;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingDbDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingDetailDto;
import com.lvmama.lvfit.common.form.booking.BookingInputForm;
import com.lvmama.lvfit.common.form.order.FitOrderOpLogForm;
import com.lvmama.lvfit.common.form.product.FitSuppOrderForFlightCallBackRequest;

/**
 * 业务接口远程调用类
 * 
 * @author majun
 * @date 2015-1-29
 */
@Component
public class FitBusinessClient {

	/** 远程地址 */
	@Value("lvfit.business.baesurl")
	private String baseUrl;
	
	/** 聚合服务基本Url */
	@Value("lvfit.aggregate.baseurl")
	private String aggregateBaseurl;

	/** 远程服务 */
	@Autowired
	private RestClient restClient;
	
	public static final Logger logger=Logger.getLogger(FitBusinessClient.class);

	@Value("flight.controller.useAggregate")
	private String useAggregate;



	/**
	 * 订单航变通知
	 * @param dto
	 * @return
	 */
	public ResultStatus changeShopping(FitShoppingDto dto) {
		BussinessClientPath command = BussinessClientPath.CHANGE_SHOPPING;
		String url = command.url(baseUrl);
		try{
			return restClient.post(url, ResultStatus.class, dto);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**
	 * 根据订单ID修改下单账号类型
	 * @param orderId
	 * @param orderFlag
	 * @return
	 */
	public BaseSingleResultDto<FitShoppingDto> getShopping(Long orderId,String orderFlag) {
        BussinessClientPath command = BussinessClientPath.GET_SHOPPING;
        String url = command.url(baseUrl, orderId,orderFlag);
        try {
        	String resultString = restClient.get(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseSingleResultDto<FitShoppingDto>>() {
			});
			
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (IOException exception) {
			throw new RuntimeException();
		}
    }
	
	/**
	 * 保存shopping信息
	 * @param dto
	 * @return
	 */
	public BaseSingleResultDto saveOrUpdateShopping(FitShoppingDto dto) {
		BussinessClientPath command = BussinessClientPath.SAVE_SHOPPING;
		String url = command.url(baseUrl);
		try{
			return restClient.post(url, BaseSingleResultDto.class, dto);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	public FitOrderMainDto booking(FitOrderBookingRequest fitOrderBookingRequest){
		
		BussinessClientPath command = BussinessClientPath.BOOKING;
		String url = command.url(baseUrl);
		try{
			return restClient.post(url, FitOrderMainDto.class, fitOrderBookingRequest);
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
	
	public ResultStatus validatePassengers(FitOrderBookingRequest fitOrderBookingRequest){
		
		BussinessClientPath command = BussinessClientPath.VALIDATE_PASSENGERS;
		String url = command.url(baseUrl);
		try{
			return restClient.post(url, ResultStatus.class, fitOrderBookingRequest);
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
	
	
	public ShoppingDbDto loadShoppingDbInfoByUuId(String shoppingUuId){
		BussinessClientPath command = BussinessClientPath.GETDP_SHOPPING;
		String url = command.url(baseUrl);
		try{
			return restClient.post(url, ShoppingDbDto.class, shoppingUuId);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**
	 * 机酒后台 订单列表
	 * @author wanghuihui
	 * @date:2016年1月13日 上午11:21:43
	 * @param baseQuery
	 * @return
	 */
	public BaseResultDto<FitOrderQueryListDto> queryOrderList(BaseQueryDto<FitOrderQueryRequest> baseQuery) {
		BussinessClientPath command = BussinessClientPath.BACK_ORDER_QUERY_LIST;
		String url = command.url(baseUrl);
		try 
		{
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQuery);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,new TypeReference<BaseResultDto<FitOrderQueryListDto>>(){});
		} 
		catch (ExceptionWrapper ew) 
		{
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 查询shopping购物车信息列表
	 * @param baseQueryDto
	 * @return
	 */
	public BaseResultDto<ShoppingDetailDto> queryShoppingList(BaseQueryDto<FitShoppingListRequest> baseQueryDto){
		BussinessClientPath command = BussinessClientPath.QUERY_SHOPPING;
		String url = command.url(baseUrl);
		try 
		{
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,new TypeReference<BaseResultDto<ShoppingDetailDto>>(){});
		} 
		catch (ExceptionWrapper ew) 
		{
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	
	}
	
	/**
	 * 查询购物车列表(导出)
	 * @param baseQueryDto
	 * @return
	 */
	public List<String> queryShoppingListForExprot(BaseQueryDto<FitShoppingListRequest> baseQueryDto)
	{
		BussinessClientPath command = BussinessClientPath.QUERY_SHOPPING_EXPROT;
		String url = command.url(baseUrl);
		try 
		{
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult, new TypeReference<List<String>>(){});
		} 
		catch (Exception e) 
		{
			ExceptionWrapper ew = new ExceptionWrapper();
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	public BaseResultDto<FitConRecomHotelDto> getFitConRecomHotelsAll(BaseQueryDto<FitConRecomHotelDto> baseQuery) throws JsonParseException, JsonMappingException, IOException{
		BussinessClientPath command = BussinessClientPath.GET_RECOMMEND_HOTELS_ALL;
		String url = command.url(baseUrl);
		try{
			String jsonStr = restClient.post(url, String.class,JSONMapper.getInstance().writeValueAsString(baseQuery));
			return JSONMapper.getInstance().readValue(jsonStr, new TypeReference<BaseResultDto<FitConRecomHotelDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	/**
	 * 批量导入酒店数据
	 * @param fitConRecomHotelRequestForm
	 * @return
	 */
	public Boolean batchSaveRecomHotel(
			FitConRecomHotelRequestForm fitConRecomHotelRequestForm) {
		BussinessClientPath command = BussinessClientPath.BATCH_RECOMMEND_HOTELS_ALL;
		String url = command.url(baseUrl);
		try {
			String jsonStr = restClient.post(url, String.class,fitConRecomHotelRequestForm);
			return true;
		} catch (ExceptionWrapper ew) {
			//
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
		
	}
	/**
	 * 新增默认酒店数据
	 * @param dto
	 * @return
	 */
	public Boolean saveRecomHotel(FitConRecomHotelDto dto){
		BussinessClientPath command = BussinessClientPath.SAVE_RECOMMEND_HOTEL;
		String url = command.url(baseUrl);
		try {	
			String jsonStr = restClient.post(url, String.class, dto);
			//System.out.println("jsonStr:"+jsonStr);
			return Boolean.valueOf(jsonStr);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;		
		}
	} 

	

	public FitConRecomHotelDto getRecomHotel(Long id) throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.GET_RECOMMEND_HOTEL;
		String url = command.url(baseUrl);
		try {
			String jsonStr = restClient.post(url, String.class,id);
			return JSONMapper.getInstance().readValue(jsonStr, new TypeReference<FitConRecomHotelDto>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} 
		
	}
	
	/**
	 * 修改默认酒店数据
	 * @param dto
	 * @return
	 */
	public Boolean updateRecomHotel(FitConRecomHotelDto dto) {
		BussinessClientPath command = BussinessClientPath.UPDATE_RECOMMEND_HOTEL;
		String url = command.url(baseUrl);
		
		try {
			String jsonStr = restClient.post(url, String.class, dto);
			return Boolean.valueOf(jsonStr);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
		
		
	}

	public Boolean deleteRecomHotel(Long id) {
		BussinessClientPath command = BussinessClientPath.DELETE_RECOMMEND_HOTEL;
		String url = command.url(baseUrl);
		
		try {
			String jsonStr = restClient.post(url, String.class, id);
			return Boolean.valueOf(jsonStr);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	
	}
	
	public List<FitConRecomHotelDto> getFitConRecomHotelsAll() throws Exception{
		BussinessClientPath command = BussinessClientPath.GET_ALL_RECOM_HOTEL;
		String url = command.url(baseUrl);
		try {
			String jsonStr = restClient.post(url, String.class);
			return JSONMapper.getInstance().readValue(jsonStr, new TypeReference<List<FitConRecomHotelDto>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
		
	} 
	
	/**
     * 查询操作日志
     * @param baseQueryDto
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public BaseResultDto<FitOpLog> viewFitOpLog(BaseQueryDto<FitOpLogQueryRequest>  baseQueryDto)  throws JsonParseException, JsonMappingException, IOException  {
        BussinessClientPath command = BussinessClientPath.VIEW_OP_LOG;
        String url = command.url(baseUrl);
        ObjectMapper objectMapper = JSONMapper.getInstance();
        String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
        try {
            String jsonStr = restClient.post(url, String.class, jsonRequest);
            return objectMapper.readValue(jsonStr, new TypeReference<BaseResultDto<FitOpLog>>(){});
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } 
    }
    
    /**
     * 订单查询 操作日志列表
     * @author wanghuihui
     * @date:2016年1月18日 下午3:17:13
     * @param fitOrderQueryRequest
     * @return
     */
	public BaseResultDto<FitOrderOpLogForm> queryOrderLogList(
			FitOrderQueryRequest fitOrderQueryRequest) {
		BussinessClientPath command = BussinessClientPath.BACK_ORDER_QUERY_LOG_LIST;
		String url = command.url(baseUrl);
		try 
		{
			ObjectMapper objectMapper = JSONMapper.getInstance();
			//String jsonRequest = objectMapper.writeValueAsString(fitOrderQueryRequest);
			String jsonResult = restClient.post(url, String.class, fitOrderQueryRequest);
			return objectMapper.readValue(jsonResult,new TypeReference<BaseResultDto<FitOrderOpLogForm>>(){});
		} 
		catch (ExceptionWrapper ew) 
		{
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	} 
	
	/**
	 *  机酒报表
	 * @author wanghuihui
	 * @date:2016年1月25日 上午10:40:43
	 * @param baseQueryDto
	 * @return
	 */
	public List<String> queryOrderAllExportCsv(	BaseQueryDto<FitOrderQueryRequest> baseQueryDto) {
		ReportClientPath command = ReportClientPath.QUERY_ORDER_ALL_REPORT;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonResult = restClient.post(url, String.class, baseQueryDto);
			return objectMapper.readValue(jsonResult,new TypeReference<List<String>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 *  机票报表
	 * @author wanghuihui
	 * @date:2016年1月25日 上午10:40:59
	 * @param baseQueryDto
	 * @return
	 */
	public List<String> orderFlightExportCsv(BaseQueryDto<FitOrderQueryRequest> baseQueryDto) {
		ReportClientPath command = ReportClientPath.QUERY_ORDER_FLIGHT_REPORT;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonResult = restClient.post(url, String.class, baseQueryDto);
			return objectMapper.readValue(jsonResult,new TypeReference<List<String>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 *  酒店报表
	 * @author wanghuihui
	 * @date:2016年1月25日 上午10:41:18
	 * @param baseQueryDto
	 * @return
	 */
	public List<String> orderHotelExportCsv(BaseQueryDto<FitOrderQueryRequest> baseQueryDto) {
		ReportClientPath command = ReportClientPath.QUERY_ORDER_HOTEL_REPORT;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonResult = restClient.post(url, String.class, baseQueryDto);
			return objectMapper.readValue(jsonResult,new TypeReference<List<String>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

    
  /**
   * 根据UUID获取购物车信息
   * @param uuid
   * @return
   * @throws JsonParseException
   * @throws JsonMappingException
   * @throws IOException
   */
  public ShoppingDetailDto getShoppingInfo(String uuid) throws JsonParseException, JsonMappingException, IOException {
      BussinessClientPath command = BussinessClientPath.GET_SHOPPING_INFO_BY_UUID;
      String url = command.url(baseUrl, uuid);
      ObjectMapper objectMapper = JSONMapper.getInstance();
      try {
          String jsonStr = restClient.post(url, String.class);
          return objectMapper.readValue(jsonStr, new TypeReference<ShoppingDetailDto>() {});
      } catch (ExceptionWrapper ew) {
          logger.error(ew.getErrMessage(), ew);
          throw ew;
      } 
  }
  
  /**
   * 保存或更新购物车信息
   * @param dtlDto
   */
  public void updShoppingInfo(ShoppingDetailDto dtlDto) {
      BussinessClientPath command = BussinessClientPath.UPD_SHOPPING_INFO;
      String url = command.url(baseUrl);
      try {
          restClient.post(url, Integer.class, dtlDto);
      } catch (ExceptionWrapper ew) {
          logger.error(ew.getErrMessage(), ew);
          throw ew;
      } 
  }
  
  
  
    /**
     * 根据机酒主订单号查询订单详情
     * @param vstOrderMainNo
     * @return
     * @throws Exception
     */
	public FitOrderMainDto queryOrderMainByVstOrderMainNo(Long vstOrderMainNo) throws Exception {
		try{
			return restClient.post(BussinessClientPath.QUERY_ORDER_MAIN_BY_VST_ORDER_MAIN_NO.url(baseUrl, vstOrderMainNo), FitOrderMainDto.class);
		} catch (Exception e) {
			logger.error("查询订单详情异常：", e);
			throw e;
		}
	}
	
	/**
     * 根据机酒主订单号查询订单详情
     * @param vstOrderMainNo
     * @return
     * @throws Exception
     */
	public List<FlightOrderBookingRequest> queryFlightOrderByVstOrderMainNo(FitFlightOrderQueryRequest fitFlightOrderQueryRequest) {

		BussinessClientPath command = BussinessClientPath.QUERY_FLIGHT_ORDER_BY_VST_ORDER_MAIN_NO;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonResult = restClient.post(url, String.class, fitFlightOrderQueryRequest);
			return objectMapper.readValue(jsonResult,new TypeReference<List<FlightOrderBookingRequest>>() {});

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
  
    
	public FitOrderDetail oldOrderDataTransfer(Long vstOrderMainNo) throws Exception {
        BussinessClientPath command = BussinessClientPath.OLD_ORDER_DATA_TRANSFER;
        String url = command.url(baseUrl, vstOrderMainNo);
        try {
            String jsonResult = restClient.post(url, String.class);
            return JSONMapper.getInstance().readValue(jsonResult, FitOrderDetail.class);
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
	
   public String flightCallBackBooking(String requestStr){
		
		BussinessClientPath command = BussinessClientPath.FLIGHT_CALLBACK_BOOKING;
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
   
   public BaseSingleResultDto<FitSdpProductBasicInfoDto> getSdpProductBasicInfoByProductId(Long productId){
		
	   BussinessClientPath command = BussinessClientPath.GET_SDP_PRODUCT_BASICI_NFO_BY_ID;
       String url = command.url(baseUrl, productId);
       try {
           String jsonResult = restClient.get(url, String.class);
           return JSONMapper.getInstance().readValue(jsonResult, new TypeReference<BaseSingleResultDto<FitSdpProductBasicInfoDto>>() {});
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
   
   public FitSdpProductBasicInfoDto saveOrUpdateSdpProductBasicInfo(FitSdpProductBasicInfoDto productBasicInfoDto){
		
	    BussinessClientPath command = BussinessClientPath.SAVE_OR_UPDATE_PRODUCTBASICINFO;
		String url = command.url(baseUrl);
		try{
			return restClient.post(url, FitSdpProductBasicInfoDto.class, productBasicInfoDto);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}catch (Exception e) {
	           ExceptionWrapper ew = new ExceptionWrapper();
	           ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
	           ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
	           logger.error(ew.getErrMessage(), ew);
	           throw ew;
	    }
 	}
   
	public BaseResultDto<FitSdpProductBasicInfoDto> querySdpProductBasicInfoList(BaseQueryDto<FitSdpProductBasicInfoRequest> baseQuery) {
		BussinessClientPath command = BussinessClientPath.BACK_SDP_PRODUCT_BASIC_INFO_QUERY_LIST;
		String url = command.url(baseUrl);
		try 
		{
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQuery);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,new TypeReference<BaseResultDto<FitSdpProductBasicInfoDto>>(){});
		} 
		catch (ExceptionWrapper ew) 
		{
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
   public List<FitSdpCityGroupDto> getProductCityGroupByProductId(Long productId){
		
	   BussinessClientPath command = BussinessClientPath.GET_SDP_PRODUCT_CITY_GROUP_BY_PRODUCT_ID;
       String url = command.url(baseUrl, productId);
       try {
           String jsonResult = restClient.get(url, String.class);
           return JSONMapper.getInstance().readValue(jsonResult,new TypeReference<List<FitSdpCityGroupDto>>(){});
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
   
   
   public FitSdpCityGroupDto getProductCityGroupById(Long id){
		
	   BussinessClientPath command = BussinessClientPath.GET_SDP_PRODUCT_CITY_GROUP_BY_ID;
       String url = command.url(baseUrl, id);
       try {
           String jsonResult = restClient.get(url, String.class);
           return JSONMapper.getInstance().readValue(jsonResult,new TypeReference<FitSdpCityGroupDto>(){});
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
   
   public List<FitSdpCityGroupDto> getSelectProductCityGroupByProductId(Long productId){
		
	   BussinessClientPath command = BussinessClientPath.GET_SDP_PRODUCT_SELECT_CITY_GROUP_BY_PRODUCT_ID;
       String url = command.url(baseUrl, productId);
       try {
           String jsonResult = restClient.get(url, String.class);
           return JSONMapper.getInstance().readValue(jsonResult,new TypeReference<List<FitSdpCityGroupDto>>(){});
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
   
   @SuppressWarnings("unchecked")
   public ResultStatus saveOrUpdateProductCityGroup(List<FitSdpCityGroupDto> fitSdpCityGroupDtos){
		
	    BussinessClientPath command = BussinessClientPath.SAVE_OR_UPDATE_SDP_PRODUCT_CITY_GROUP;
		String url = command.url(baseUrl);
		try{
			return restClient.post(url, ResultStatus.class, fitSdpCityGroupDtos);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}catch (Exception e) {
	           ExceptionWrapper ew = new ExceptionWrapper();
	           ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
	           ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
	           logger.error(ew.getErrMessage(), ew);
	           throw ew;
	    }
	}
   
   @SuppressWarnings("unchecked")
   public ResultStatus updateCityUseFlagBatch(List<FitSdpCityGroupDto> fitSdpCityGroupDtos){
		
	    BussinessClientPath command = BussinessClientPath.UPDATE_CITY_USE_FLAG_BATCH;
		String url = command.url(baseUrl);
		try{
			return restClient.post(url, ResultStatus.class, fitSdpCityGroupDtos);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}catch (Exception e) {
	           ExceptionWrapper ew = new ExceptionWrapper();
	           ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
	           ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
	           logger.error(ew.getErrMessage(), ew);
	           throw ew;
	    }
	}
   
   public ResultStatus updateOneCityGroup(FitSdpCityGroupDto fitSdpCityGroupDto){
	   
	    BussinessClientPath command = BussinessClientPath.UPDATE_ONE_CITY_GROUP;
		String url = command.url(baseUrl);
		try{
			return restClient.post(url, ResultStatus.class, fitSdpCityGroupDto);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}catch (Exception e) {
	           ExceptionWrapper ew = new ExceptionWrapper();
	           ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
	           ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
	           logger.error(ew.getErrMessage(), ew);
	           throw ew;
	    }
	}
	
   public List<FitSdpProductTrafficRulesDto> getProductTrafficRulesByProductId(Long productId){
		
	   BussinessClientPath command = BussinessClientPath.GET_SDP_PRODUCT_TRAFFIC_RULES_BY_PRODUCT_ID;
       String url = command.url(baseUrl, productId);
       try {
           String jsonResult = restClient.get(url, String.class);
           return JSONMapper.getInstance().readValue(jsonResult,new TypeReference<List<FitSdpProductTrafficRulesDto>>(){});
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
   
   public String saveOrUpdateProductTrafficRules(List<FitSdpProductTrafficRulesDto> productTrafficRulesDtos){
		
	    BussinessClientPath command = BussinessClientPath.SAVE_OR_UPDATE_SDP_PRODUCT_TRAFFIC_RULES;
		String url = command.url(baseUrl);
		try{
			return restClient.post(url, String.class, productTrafficRulesDtos);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}catch (Exception e) {
	           ExceptionWrapper ew = new ExceptionWrapper();
	           ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
	           ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
	           logger.error(ew.getErrMessage(), ew);
	           throw ew;
	    }
	}
   
   public List<FitSdpProductFeeRulesDto> getProductFeeRulesByProductId(Long productId){
		
	   BussinessClientPath command = BussinessClientPath.GET_SDP_PRODUCT_FEE_RULES_BY_PRODUCT_ID;
       String url = command.url(baseUrl, productId);
       try {
           String jsonResult = restClient.get(url, String.class);
           return JSONMapper.getInstance().readValue(jsonResult,new TypeReference<List<FitSdpProductFeeRulesDto>>(){});
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
   
   public String saveOrUpdateProductFeeRules(List<FitSdpProductFeeRulesDto> feeRulesDtos){
		
	    BussinessClientPath command = BussinessClientPath.SAVE_OR_UPDATE_SDP_PRODUCT_FEE_RULES;
		String url = command.url(baseUrl);
		try{
			return restClient.post(url, String.class, feeRulesDtos);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}catch (Exception e) {
	           ExceptionWrapper ew = new ExceptionWrapper();
	           ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
	           ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
	           logger.error(ew.getErrMessage(), ew);
	           throw ew;
	    }
	}
   
   public ResultStatus deleteSdpProductInfoByProductId(Long productId){
	    BussinessClientPath command = BussinessClientPath.DELETE_SDP_PRODUCT_INFO_BY_PRODUCT_ID;
		String url = command.url(baseUrl, productId);
		try{
			return restClient.post(url, ResultStatus.class);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}catch (Exception e) {
	           ExceptionWrapper ew = new ExceptionWrapper();
	           ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
	           ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
	           logger.error(ew.getErrMessage(), ew);
	           throw ew;
	    }
	
   }

    
   public BaseSingleResultDto<Integer> setDefaultHotel(Long id,Long districtCityId) {
		BussinessClientPath command = BussinessClientPath.SET_DEFAULT_HOTEL;
		String url = command.url(baseUrl, id, districtCityId);
		try {
			String resultString = restClient.get(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseSingleResultDto<Integer>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 *  SDP产品报表导出
	 * @author wanghuihui
	 * @date:2016年1月25日 上午10:40:43
	 * @param baseQueryDto
	 * @return
	 */
	public List<String> querySdpProductExportCsv(BaseQueryDto<FitSdpProductBasicInfoRequest> baseQueryDto) {
		BussinessClientPath command = BussinessClientPath.QUERY_SDP_PRODUCT_REPORT;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonResult = restClient.post(url, String.class, baseQueryDto);
			return objectMapper.readValue(jsonResult,new TypeReference<List<String>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	 
	
	/**
	 *  查询产品ID索引
	 * @author dingli
	 * @date:2016年8月25日 上午18:18:43
	 * @param productId
	 * @return
	 */
	public BaseResultDto<FitSdpProductSearchIndexDto> querySdpProductSearchIndexList(BaseQueryDto<Long> baseQuery) {
		BussinessClientPath command = BussinessClientPath.BACK_SDP_PRODUCT_SEARCH_INDEX_QUERY_LIST;
		String url = command.url(baseUrl);
	    try {
	           String jsonResult = restClient.post(url, String.class,baseQuery);
	           return JSONMapper.getInstance().readValue(jsonResult,new TypeReference<BaseResultDto<FitSdpProductSearchIndexDto>>(){});
	    }
		catch (ExceptionWrapper ew) 
		{
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
		catch (Exception e) 
		{
			 ExceptionWrapper ew = new ExceptionWrapper();
	         ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
	         ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
	         logger.error(ew.getErrMessage(), ew);
	         throw ew;
		}
	}

	
	/**
	 *  查询产品同步时间信息
	 * @author dingli
	 * @date:2016年8月29日 上午10:18:43
	 * @param productId
	 * @return
	 */
	public BaseResultDto<FitSdpProductSyncMsgDto> querySdpProductSynInfoList(
			BaseQueryDto<Long> baseQuery) {
		BussinessClientPath command = BussinessClientPath.BACK_SDP_PRODUCT_SYN_INFO_QUERY_LIST;
		String url = command.url(baseUrl);
	    try {
	           String jsonResult = restClient.post(url, String.class,baseQuery);
	           return JSONMapper.getInstance().readValue(jsonResult,new TypeReference<BaseResultDto<FitSdpProductSyncMsgDto>>(){});
	    }
		catch (ExceptionWrapper ew) 
		{
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
		catch (Exception e) 
		{
			ExceptionWrapper ew = new ExceptionWrapper();
	        ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
	        ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
	        logger.error(ew.getErrMessage(), ew);
	        throw ew;
		}
	}

	public BaseResultDto<FitSdpProductSearchIndexTraffic> querySdpProductIndexTrafficList(
			BaseQueryDto<Long> baseQuery) {
		BussinessClientPath command = BussinessClientPath.BACK_SDP_PRODUCT_INDEX_TRAFFIC;
		String url = command.url(baseUrl);
	    try {
	           String jsonResult = restClient.post(url, String.class,baseQuery);
	           return JSONMapper.getInstance().readValue(jsonResult,new TypeReference<BaseResultDto<FitSdpProductSearchIndexTraffic>>(){});
	    }
		catch (ExceptionWrapper ew) 
		{
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
		catch (Exception e) 
		{
			ExceptionWrapper ew = new ExceptionWrapper();
	        ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
	        ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
	        logger.error(ew.getErrMessage(), ew);
	        throw ew;
		}
	}

	public BaseResultDto<FitSdpCityGroupDto> querySdpProductDepartureCityList(BaseQueryDto<FitSdpCityGroupDto> baseQuery) {
		BussinessClientPath command = BussinessClientPath.BACK_SDP_PRODUCT_DEPART_CITY;
		String url = command.url(baseUrl);
	    try {
	    	ObjectMapper objectMapper = JSONMapper.getInstance();
	    	String jsonRequest = objectMapper.writeValueAsString(baseQuery);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,new TypeReference<BaseResultDto<FitSdpCityGroupDto>>() {});
	    }
		catch (ExceptionWrapper ew) 
		{
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
		catch (Exception e) 
		{
			ExceptionWrapper ew = new ExceptionWrapper();
	        ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
	        ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
	        logger.error(ew.getErrMessage(), ew);
	        throw ew;
		}
	}

	public BaseResultDto<FitSuppOrderForFlightCallBackDto> getSuppOrderForFlightCallBack(BaseQueryDto<FitSuppOrderForFlightCallBackRequest> baseQuery) {
		BussinessClientPath command = BussinessClientPath.BACK_SUPP_ORDER_FLIGHT_CALL_BACK;
		String url = command.url(baseUrl);
	    try {
	    	ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQuery);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
	        return JSONMapper.getInstance().readValue(jsonResult,new TypeReference<BaseResultDto<FitSuppOrderForFlightCallBackDto>>(){});
	    }
		catch (ExceptionWrapper ew) 
		{
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
		catch (Exception e) 
		{
			ExceptionWrapper ew = new ExceptionWrapper();
	        ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
	        ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
	        logger.error(ew.getErrMessage(), ew);
	        throw ew;
		}
	}

	public FitSdpProductSearchIndexTraffic getTrafficIndexById(Long id) {
		  BussinessClientPath command = BussinessClientPath.GET_SDP_PRODUCT_TRAFFIC_INDEX_BY_ID;
	       String url = command.url(baseUrl, id);
	       try {
	           String jsonResult = restClient.get(url, String.class);
	           return JSONMapper.getInstance().readValue(jsonResult,new TypeReference<FitSdpProductSearchIndexTraffic>(){});
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
	
	public ResultStatus updateTrafficIndex(FitSdpProductSearchIndexTraffic dto){
		    BussinessClientPath command = BussinessClientPath.UPDATE_SDP_PRODUCT_TRAFFIC_INDEX;
			String url = command.url(baseUrl);
			try{
				return restClient.post(url, ResultStatus.class, dto);
			} catch (ExceptionWrapper ew) {
				logger.error(ew.getErrMessage(), ew);
				throw ew;
			}catch (Exception e) {
		           ExceptionWrapper ew = new ExceptionWrapper();
		           ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
		           ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
		           logger.error(ew.getErrMessage(), ew);
		           throw ew;
		    }
		}

	public String getFitFliBookingCallBackByVstMainNo(
			BaseQueryDto<FitFliBookingCallBackRequest> baseQuery) {
		BussinessClientPath command = BussinessClientPath.GET_FLIGHT_CALL_BACK_BY_VST_NO;
		String url = command.url(baseUrl);
	    try {
	           String jsonResult = restClient.post(url, String.class,baseQuery);
	           return jsonResult;
	    }
		catch (ExceptionWrapper ew) 
		{
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
		catch (Exception e) 
		{
			ExceptionWrapper ew = new ExceptionWrapper();
	        ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
	        ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
	        logger.error(ew.getErrMessage(), ew);
	        throw ew;
		}
	}

	public BaseResultDto<FitSdpProductSyncMsgDto> querySdpProductSynMsgInfo(BaseQueryDto<Long> baseQuery) {
		BussinessClientPath command = BussinessClientPath.BACK_SDP_PRODUCT_ALL_SYN_INFO;
		String url = command.url(baseUrl);
	    try {
	           String jsonResult = restClient.post(url, String.class,baseQuery);
	           return JSONMapper.getInstance().readValue(jsonResult,new TypeReference<BaseResultDto<FitSdpProductSyncMsgDto>>(){});
	    }
		catch (ExceptionWrapper ew) 
		{
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
		catch (Exception e) 
		{
			ExceptionWrapper ew = new ExceptionWrapper();
	        ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
	        ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
	        logger.error(ew.getErrMessage(), ew);
	        throw ew;
		}
	}
	
	/**
	 * 存储同步时间信息到数据库
	 * @return
	 */
/*	public ResultStatus saveSynTimeInfo(FitSdpProductSyncMsgDto request){
		BussinessClientPath command = BussinessClientPath.SAVE_SYN_TIME_INFO;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, ResultStatus.class, request);
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
	}*/
	
}



