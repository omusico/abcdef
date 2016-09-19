/**
 * Project Name:lvfit-common-dto
 * File Name:VstClient.java
 * Package Name:com.lvmama.lvfit.common.client
 * Date:2015-11-12下午3:10:05
 * Copyright (c) 2015, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.common.client;


import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lvmama.comm.pet.po.pub.ComIps;
import com.lvmama.lvf.common.client.RestClient;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.trace.profile.Profile;
import com.lvmama.lvf.common.trace.profile.ProfilePoint;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.path.VstClientPath;
import com.lvmama.lvfit.common.dto.adapter.request.FlightBookingRequest;
import com.lvmama.lvfit.common.dto.adapter.request.FlightBookingSuccessRequest;
import com.lvmama.lvfit.common.dto.adapter.request.FlightOrderQueryRequest;
import com.lvmama.lvfit.common.dto.adapter.request.VstBookingRequest;
import com.lvmama.lvfit.common.dto.hotel.FitCommentDto;
import com.lvmama.lvfit.common.dto.hotel.FitHotelDto;
import com.lvmama.lvfit.common.dto.hotel.FitHotelTimePrice;
import com.lvmama.lvfit.common.dto.member.FitMemUserDto;
import com.lvmama.lvfit.common.dto.member.FitUserContacterDto;
import com.lvmama.lvfit.common.dto.order.FitOrderDetail;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderStatusDto;
import com.lvmama.lvfit.common.dto.request.CommHeaderRequest;
import com.lvmama.lvfit.common.dto.request.FitCommentRequest;
import com.lvmama.lvfit.common.dto.request.FitHotelPriceRequest;
import com.lvmama.lvfit.common.dto.request.FitHotelRequest;
import com.lvmama.lvfit.common.dto.request.FitOrderPassengerRequest;
import com.lvmama.lvfit.common.dto.request.MemUserRequest;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceQueryRequest;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;
import com.lvmama.lvfit.common.dto.vst.VstComment;
import com.lvmama.lvfit.common.dto.vst.VstCommentStat;
import com.lvmama.lvfit.common.form.order.FitOrderDetailResultForm;


/**
 * ClassName:VstClient <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015-11-12 下午3:10:05 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
@Component
public class FitVstClient {
	ObjectMapper objectMapper = JSONMapper.getInstance();

	 private static Logger logger = LoggerFactory.getLogger(FitVstClient.class);

	@Value("lvfit.adapter.baseurl")
	private String baseUrl;

    @Autowired
    private RestClient restClient;
    
    /**
     * 分页查询VST酒店点评列表
     * 
     * @param request
     * @return BaseResultDto<VstComment>
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public  FitCommentDto getCommentPage(FitCommentRequest request)
    		throws JsonParseException,JsonMappingException, IOException{
    	VstClientPath command = VstClientPath.QUERY_VST_COMMENT_LIST;
        String url = command.url(baseUrl);
        try {
			String jsonRequest = objectMapper.writeValueAsString(request);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,new TypeReference<FitCommentDto>(){});
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
	/**
	 * 根据产品id获取点评统计数据
	 * @param productId
	 * @return
	 */
    @Deprecated
	public FitCommentDto getVstCommentStatByProductId(FitCommentRequest request)throws JsonParseException,JsonMappingException, IOException{
    	VstClientPath command = VstClientPath.QUERY_VST_COMMENT_STATISTICS_BYPROUCTID;
        String url = command.url(baseUrl);
        try {
			String jsonRequest = objectMapper.writeValueAsString(request);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,new TypeReference<VstCommentStat>(){});
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
	}

	/**
	 * 
	 * queryCommentList:点评client. <br/>
	 * 
	 * @author liuweiguo
	 * @param request
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @since JDK 1.6
	 */
	public BaseResultDto<FitCommentDto> queryCommentList(BaseQueryDto<FitCommentRequest> request) throws JsonParseException, JsonMappingException, IOException {
		VstClientPath command = VstClientPath.QUERY_VST_COMMENT_LIST;
		String url = command.url(baseUrl);
		try {
			String jsonRequest = objectMapper.writeValueAsString(request);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult, new TypeReference<BaseResultDto<VstComment>>() {
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
	 * 
	 * getProdHotelDetail:酒店祥情. <br/>
	 *
	 * @author liuweiguo
	 * @param request
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @since JDK 1.6
	 */
	public FitHotelDto getProdHotelDetail(FitHotelRequest request) throws JsonParseException, JsonMappingException, IOException {
		VstClientPath command = VstClientPath.GET_VST_PRODUCT_DETAIL;
		String url = command.url(baseUrl);
		try {
			String jsonRequest = objectMapper.writeValueAsString(request);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult, new TypeReference<FitHotelDto>(){});
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
	 * getUserReceiverByUserId:根据用户id查找联系人. <br/>
	 *
	 * @author liuweiguo
	 * @param userId
	 * @return
	 * @since JDK 1.6
	 */
	public List<FitUserContacterDto> getUserReceiverByUserId(MemUserRequest request){
		VstClientPath command = VstClientPath.GET_USER_RECEIVERS_BY_USER_ID;
		String url = command.url(baseUrl);
		try {
			String jsonRequest = objectMapper.writeValueAsString(request);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult, new TypeReference<List<FitUserContacterDto>>(){});
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
	 * getUserByLvSessionId:根据lvSessionId获取登录用户信息. <br/>
	 *
	 * @author liuweiguo
	 * @param userId
	 * @return
	 * @since JDK 1.6
	 */
	public BaseSingleResultDto<FitMemUserDto> getUserByLvSessionId(MemUserRequest request){
		VstClientPath command = VstClientPath.GET_USER_BY_LVSESSION_ID;
		String url = command.url(baseUrl);
		try {
			String jsonRequest = objectMapper.writeValueAsString(request);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult, new TypeReference<BaseSingleResultDto<FitMemUserDto>>(){});
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
	 * getUserReceiverByLvSessionId:根据lvSessionId查找联系人. <br/>
	 *
	 * @author liuweiguo
	 * @param userId
	 * @return
	 * @since JDK 1.6
	 */
	public List<FitUserContacterDto> getUserReceiverByLvSessionId(MemUserRequest request){
		VstClientPath command = VstClientPath.GET_USER_RECEIVERS_BY_LVSESSION_ID;
		String url = command.url(baseUrl);
		try {
			String jsonRequest = objectMapper.writeValueAsString(request);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult, new TypeReference<List<FitUserContacterDto>>(){});
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
	 * saveOrderPassengerInfo:保存联系人. <br/>
	 *
	 * @author liuweiguo
	 * @param userId
	 * @return
	 * @since JDK 1.6
	 */
	public ResultStatus saveOrderPassengerInfo(FitOrderPassengerRequest request){
		VstClientPath command = VstClientPath.SAVE_ORDER_PASSENGER_INFO;
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
	}
	
	/**
	 * VST查询酒店价格
	 * @return
	 */
	@ProfilePoint(Profile.FIT_QUERY_VST_GOODS_PRICE_LIST)
	public FitHotelTimePrice findTimePriceBySpecDate(FitHotelPriceRequest request){
		VstClientPath command = VstClientPath.QUERY_VST_GOODS_PRICE_LIST;
		String url = command.url(baseUrl);
		try {
			String jsonRequest = objectMapper.writeValueAsString(request);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult, new TypeReference<FitHotelTimePrice>() {
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
	 * 请求Vst下单
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@ProfilePoint(Profile.FIT_VST_ORDER_CREATE)
	public FitSuppMainOrderDto createOrder(VstBookingRequest vstBookingRequest)   {
		VstClientPath command = VstClientPath.VST_ORDER_CREATE;
		String url = command.url(baseUrl);
		try {
			String jsonRequest = objectMapper.writeValueAsString(vstBookingRequest);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult, new TypeReference<FitSuppMainOrderDto>(){});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 机票单品预定
	 * @param request
	 */
	@ProfilePoint(Profile.FIT_FLIGHT_ORDER_CREATE)
	public FitSuppMainOrderDto booking(FlightBookingRequest request) {
		VstClientPath command = VstClientPath.FLIGHT_BOOKING;
		String url = command.url(baseUrl);
		try {
			String jsonRequest = objectMapper.writeValueAsString(request);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult, new TypeReference<FitSuppMainOrderDto>(){});
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
	 * 获得订单成功的URL
	 * @param request
	 */
	public String getPaymentUrl(FlightBookingSuccessRequest request) {
		VstClientPath command = VstClientPath.ORDER_SUCCESS_AUDIT;
		String url = command.url(baseUrl);
		String jsonResult = null;
		try {
			jsonResult = restClient.post(url, String.class, request);
			return jsonResult;
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
	 * 根据vst主单号获取vst主单状态
	 * @param vstOrderMainNo
	 * @return
	 */
	public FitSuppMainOrderStatusDto getVstOrderStatusByVstOrderMainNo(Long vstOrderMainNo) {
		
		VstClientPath command = VstClientPath.GET_VST_ORDER_STATUS_BY_VST_ORDER_MAIN_NO;
		String url = command.url(baseUrl, vstOrderMainNo);
		try {
			String jsonResult = restClient.post(url, String.class);
			return objectMapper.readValue(jsonResult, new TypeReference<FitSuppMainOrderStatusDto>(){});
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
	 * 查询vst订单详情
	 * @param vstOrderId
	 */
	public FitOrderDetail getFitOrderMainDtoByOrderMainNo(Long vstOrderMainNo) {
		
		VstClientPath command = VstClientPath.GET_FIT_ORDER_MAIN_BY_ORDER_MAIN_NO;
		String url = command.url(baseUrl, vstOrderMainNo);
		try {
			String jsonResult = restClient.post(url, String.class);
			return objectMapper.readValue(jsonResult, FitOrderDetail.class);
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
	 * 获取头信息
	 * @param commHeaderRequest
	 * @return
	 */
	public String getCommHeader(CommHeaderRequest commHeaderRequest) {
		VstClientPath command = VstClientPath.GET_COMM_HEADER;
		String url = command.url(baseUrl);
		try {
			String jsonRequest = objectMapper.writeValueAsString(commHeaderRequest);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return jsonResult;
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			//throw ew;
		} catch (Exception e) {
			ExceptionWrapper ew = new ExceptionWrapper();
			ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
			logger.error(ew.getErrMessage(), ew);
			//throw ew;
		}
		return StringUtils.EMPTY;
	}
	
	/**
	 * 获取头信息
	 * @param commHeaderRequest
	 * @return
	 */
	public ComIps getComIps(String ip) {
		VstClientPath command = VstClientPath.GET_COM_IPS;
		String url = command.url(baseUrl);
		try {
			String jsonResult = restClient.post(url, String.class, ip);

			if(StringUtils.isNotBlank(jsonResult)){
				return objectMapper.readValue(jsonResult, new TypeReference<ComIps>(){});
			}
			return null;
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			//throw ew;
		} catch (Exception e) {
			ExceptionWrapper ew = new ExceptionWrapper();
			ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
			logger.error(ew.getErrMessage(), ew);
			//throw ew;
		}
		return null;
	}
	
	/**
	 *  机+酒，动态打包，保险商品列表信息
	 * @author wanghuihui
	 * @date:2016年2月26日 下午5:18:21
	 * @param request
	 * @return
	 */
	public List<InsuranceDto>  searchInsurance(InsuranceQueryRequest request) {
		VstClientPath command = VstClientPath.INSURANCE_SEARCH;
		String url = command.url(baseUrl);
		try {
			String jsonRequest = objectMapper.writeValueAsString(request);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult, new TypeReference<List<InsuranceDto>>(){});
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
	 * 补全机票单号和供应商订单编号信息
	 */
	public FitSuppMainOrderDto completeSuppFlightInfo(FlightOrderQueryRequest flightOrderQueryRequest) {
		VstClientPath command = VstClientPath.COMPLETE_SUPP_FLIGHT_INFO;
		String url = command.url(baseUrl);
		try {
			String jsonResult = restClient.post(url, String.class, flightOrderQueryRequest);
			return objectMapper.readValue(jsonResult, new TypeReference<FitSuppMainOrderDto>(){});
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


