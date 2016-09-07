package com.lvmama.lvf.common.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.client.path.VstClientPath;
import com.lvmama.lvf.common.dto.BaseReponseHandleT;
import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.adapter.request.vst.VstUserReceiversRequest;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.member.FitMemUserDto;
import com.lvmama.lvf.common.dto.order.FlightOrderContacterDto;
import com.lvmama.lvf.common.dto.order.FlightOrderDto;
import com.lvmama.lvf.common.dto.order.FlightOrderExpressDto;
import com.lvmama.lvf.common.dto.request.FlightOrderPassengerRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderRefundInfoRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderSyncRequest;
import com.lvmama.lvf.common.dto.request.FlightVstProductBranchRequest;
import com.lvmama.lvf.common.dto.request.FlightVstProductRequest;
import com.lvmama.lvf.common.dto.request.MemUserRequest;
import com.lvmama.lvf.common.dto.request.SmsSendRequest;
import com.lvmama.lvf.common.dto.request.TrafficFlightRequest;
import com.lvmama.lvf.common.dto.request.UserMemberRequest;
import com.lvmama.lvf.common.dto.request.pc.CommHeaderRequest;
import com.lvmama.lvf.common.dto.request.pc.FlightPayRequest;
import com.lvmama.lvf.common.dto.request.pc.UserAddressRequest;
import com.lvmama.lvf.common.dto.settlement.SettlementOrderDto;
import com.lvmama.lvf.common.dto.sms.SmsSendDto;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.dto.vo.DistrictVo;
import com.lvmama.lvf.common.dto.vst.FlightLockSeatCallbackInfoDto;
import com.lvmama.lvf.common.dto.vst.FlightTicketCallbackInfoDto;
import com.lvmama.lvf.common.dto.vst.FlightVstBasicFlightDto;
import com.lvmama.lvf.common.dto.vst.FlightVstGoodsDto;
import com.lvmama.lvf.common.dto.vst.FlightVstGoodsTimePriceDto;
import com.lvmama.lvf.common.dto.vst.FlightVstPassengerInfoDto;
import com.lvmama.lvf.common.dto.vst.FlightVstProductBranchDto;
import com.lvmama.lvf.common.dto.vst.FlightVstProductDto;
import com.lvmama.lvf.common.dto.vst.FlightVstTrafficFlightDto;
import com.lvmama.lvf.common.dto.vst.PermUserDto;
import com.lvmama.lvf.common.dto.vst.UserAddressDto;
import com.lvmama.lvf.common.dto.vst.UserMemberDto;
import com.lvmama.lvf.common.dto.vst.VstBizDictPropDto;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.pet.po.pub.ComIps;
import com.lvmama.lvf.common.utils.JSONMapper;

/**
 * 
 * @author lutianyu
 * @date 2015-2-14
 */
@Component
public class VstClient {
	public static final String RECEIVER_PASSENGER = "passenger";
	public static final String RECEIVER_CONTACTER = "contacter";
	public static final String RECEIVER_EXPRESS = "express";

	public static final Logger logger = Logger.getLogger(VstClient.class);

	@Value("adapter-vst.baseurl")
	private String baseUrl;

	@Autowired
	private RestClient restClient;

	/**
	 * 根据用户id获取相应的乘机人
	 * 
	 * @param userId
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@SuppressWarnings("unchecked")
	public BaseResultDto<FlightVstPassengerInfoDto> getOrderPassengersByUserId(String userId) throws JsonParseException, JsonMappingException, IOException {
		VstClientPath command = VstClientPath.GET_ORDER_PASSENGERINFO_BY_USER_ID;
		String url = command.url(baseUrl, userId);
		try {
			String resultString = restClient.get(url, String.class);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseResultDto<FlightVstPassengerInfoDto>>() {});
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**
	 * 根据用户id添加修改常用联系人信息
	 * 
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ResultStatus saveOrderPassengerInfo(FlightOrderPassengerRequest passengerRequst) {
		VstClientPath command = VstClientPath.SAVE_ORDER_PASSENGERINFO;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, ResultStatus.class, passengerRequst);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	
	/**
	 * 根据用户id查找常用联系人信息
	 * 
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public BaseResultDto<FlightOrderContacterDto> getUserContacterByUserId(String userId) {
		VstClientPath command = VstClientPath.GET_USER_RECEIVERS_BY_USER_ID;
		String url = command.url(baseUrl, userId, RECEIVER_CONTACTER);
		try {
			return restClient.get(url, BaseResultDto.class);
		} catch (ExceptionWrapper ew) {

			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 根据用户id查找常用快递地址信息
	 * 
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public BaseResultDto<FlightOrderExpressDto> getUserExpressByUserId(String userId) {
		VstClientPath command = VstClientPath.GET_USER_RECEIVERS_BY_USER_ID;
		String url = command.url(baseUrl, userId, RECEIVER_EXPRESS);
		try {
			return restClient.get(url, BaseResultDto.class);
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 保存常用快递地址
	 * 
	 * @param userReceiversRequest
	 * @return
	 */
	public String saveUserExpressAddress(VstUserReceiversRequest userReceiversRequest) {
		VstClientPath command = VstClientPath.SAVE_USER_EXPRESS_ADDRESS;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, String.class, userReceiversRequest);
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 短信发送
	 * 
	 * @param smsSendRequest
	 * @return
	 */
	public String sendSms(SmsSendRequest smsSendRequest) {
		VstClientPath command = VstClientPath.SEND_SMS;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, String.class, smsSendRequest);
		} catch (ExceptionWrapper ew) {
			// e.printStackTrace();
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	/**
	 * vst订单同步
	 * 
	 * @param flightOrderSyncRequest
	 * @return
	 */
	public Integer syncOrder(FlightOrderSyncRequest flightOrderSyncRequest) {
		VstClientPath command = VstClientPath.ORDER_SYNC;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, Integer.class, flightOrderSyncRequest);
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 根据用户名称查询会员列表
	 *
	 * @param paramValue
	 * @return 会员信息
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@SuppressWarnings("unchecked")
	public BaseResultDto<UserMemberDto> getUserProxyList(UserMemberRequest userRequest) throws JsonParseException, JsonMappingException, IOException {
		VstClientPath command = VstClientPath.GET_USER_PROXY_LIST;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,userRequest);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResultDto<UserMemberDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 根据电话号码查询注册用户
	 *
	 * @param paramValue
	 * @return 会员信息
	 */
	public String getRegistUserInfo(UserMemberRequest userRequest) {
		VstClientPath command = VstClientPath.GET_REGIST_USER_INFO;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, String.class,userRequest);
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 根据用户NO取用户信息
	 *
	 * @param paramValue
	 * @return 会员信息
	 */
	public UserMemberDto getUserByUserNo(String userNo) {
		VstClientPath command = VstClientPath.GET_USER_BY_USER_NO;
		String url = command.url(baseUrl, userNo);
		try {
			return restClient.get(url, UserMemberDto.class);
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 根据用户id查询用户信息
	 *
	 * @param paramValue
	 * @return 会员信息
	 */
	public UserMemberDto getUserByPkUserId(String userId) {
		VstClientPath command = VstClientPath.GET_USER_BY_PK_USER_ID;
		String url = command.url(baseUrl, userId);
		try {
			return restClient.get(url, UserMemberDto.class);
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 出票成功调用vst出票回调
	 * 
	 * @param callbackInfoDto
	 * @return
	 */
	public String flightOrderTicketIssueCallback(FlightTicketCallbackInfoDto callbackInfoDto) {
		try {
			logger.info("VST出票回调参数（VstClient）"+JSONMapper.getInstance().writeValueAsString(callbackInfoDto));
		} catch (IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		VstClientPath command = VstClientPath.FLIGHT_ORDER_TICKET_ISSUE_CALLBACK;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, String.class, callbackInfoDto);
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 调用vst退款接口，返回结果
	 * 
	 * @param request
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public String orderOnlineRefundClient(HashMap<String, String> paramMap) {
		VstClientPath command = VstClientPath.ORDER_ONLINE_REFUND_CLIENT;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, String.class, paramMap);
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 调用vst退款接口，返回结果
	 * 
	 * @param request
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseReponseHandleT<String> refundOnlineToVst(FlightOrderRefundInfoRequest refundInfoRequest) {
		VstClientPath command = VstClientPath.FLIGHT_ORDER_REFUND_VST;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, refundInfoRequest);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseReponseHandleT<String>>() {
			});
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 新增一个基础航班
	 * @param data
	 * @return 基础航班id
	 */
	public BaseResponseDto<Long> addOneBizFlight(FlightVstBasicFlightDto data){
		VstClientPath command = VstClientPath.ADD_ONE_BIZ_FLIGHT;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, data);
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResponseDto<Long>>() { });
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 修改一个基础航班
	 * @param data
	 * @return
	 */
	public BaseResponseDto updateOneBizFlight(FlightVstBasicFlightDto data) {
		VstClientPath command = VstClientPath.UPDATE_ONE_BIZ_FLIGHT;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, data);
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResponseDto>() { });
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 新增VST商品
	 * @param data
	 * @return
	 */
	public BaseResponseDto<Long> addGoods(FlightVstGoodsDto data) {
		VstClientPath command = VstClientPath.ADD_GOODS;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, data);
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResponseDto<Long>>() { });
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 修改VST商品
	 * @param data
	 * @return
	 */
	public BaseResponseDto updateGoods(FlightVstGoodsDto data) {
		VstClientPath command = VstClientPath.UPDATE_GOODS;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, data);
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResponseDto>() { });
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 增加产品
	 * @param request
	 * @return
	 */
	public BaseResponseDto<FlightVstProductDto> addVstProduct(FlightVstProductRequest request){
		VstClientPath command = VstClientPath.ADD_PRODUCT;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, request);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResponseDto<FlightVstProductDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 更新产品
	 * @param request
	 * @return
	 */
	public BaseResponseDto<FlightVstProductDto> updateVstProduct(FlightVstProductRequest request){
		VstClientPath command = VstClientPath.UPDATE_PRODUCT;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, request);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResponseDto<FlightVstProductDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * vst端，新增或更新vst产品
	 * 
	 * @param request
	 * @return
	 */
	public BaseResponseDto<FlightVstProductDto> saveOrUpdateVstProduct(FlightVstProductRequest request) {
		VstClientPath command = VstClientPath.SAVE_UPDATE_PRODUCT;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, request);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResponseDto<FlightVstProductDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * vst端，新增或更新vst产品规格
	 * 
	 * @param request
	 * @return
	 */
	public String saveOrUpdateVstProductBranch(FlightVstProductBranchRequest request) {
		VstClientPath command = VstClientPath.SAVE_UPDATE_PRODUCT_BRANCH;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, String.class, request);
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 保存VST产品航班
	 * @param request
	 * @return
	 */
	public BaseResponseDto<FlightVstTrafficFlightDto> saveVstTrafficFlight(TrafficFlightRequest request){
		VstClientPath command = VstClientPath.ADD_TRAFFIC_FLIGHT_PRODUCT;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, request);
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResponseDto<FlightVstTrafficFlightDto>>() { });
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 更新VST产品航班
	 * @param request
	 * @return
	 */
	public BaseResponseDto<FlightVstTrafficFlightDto> updateVstTrafficFlight(TrafficFlightRequest request){
		VstClientPath command = VstClientPath.UPDATE_TRAFFIC_FLIGHT_PRODUCT;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, request);
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResponseDto<FlightVstTrafficFlightDto>>() { });
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 保存或更新商品时间价格表
	 * 
	 * @param request
	 * @return
	 */
	public BaseResponseDto<Long> saveOrUpdateGoodsTimePrice(List<FlightVstGoodsTimePriceDto> goodsTimePrices) {
		VstClientPath command = VstClientPath.SAVE_OR_UPDATE_GOODS_TIME_PRICE;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, goodsTimePrices);
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResponseDto<Long>>() {
			});
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Boolean deleteVstOrder(FlightOrderSyncRequest flightOrderSyncRequest) {
		VstClientPath command = VstClientPath.DELETE_VST_ORDER;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, Boolean.class, flightOrderSyncRequest);
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	public FlightOrderDto getVstOrder(FlightOrderSyncRequest flightOrderSyncRequest) {
		VstClientPath command = VstClientPath.GET_VST_ORDER;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, FlightOrderDto.class, flightOrderSyncRequest);
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	public List<VstBizDictPropDto> findDictPropList(Map<String, Object> params){
		VstClientPath command = VstClientPath.FIND_DICT_PROP_LIST;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, params);
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<List<VstBizDictPropDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param refundInfoRequest
	 * @return
	 */
	public BaseReponseHandleT<String> refundToVst(FlightOrderRefundInfoRequest refundInfoRequest) {
		VstClientPath command = VstClientPath.REFUND_TO_VST;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, refundInfoRequest);
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseReponseHandleT<String>>() {
			});
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 增加产品
	 * @param request
	 * @return
	 */
	public FlightVstProductDto addVstProductByAirline(FlightVstProductDto product){
		VstClientPath command = VstClientPath.ADD_PRODUCT_BY_AIRLINE;
		String url = command.url(baseUrl);
		try {
			FlightVstProductDto result = restClient.post(url, FlightVstProductDto.class, product);
			return result;
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据航线更新VST数据
	 * @param product
	 * @return
	 */
	public FlightVstProductDto updateVstProductByAirline(FlightVstProductDto product){
		VstClientPath command = VstClientPath.UPDATE_PRODUCT_BY_AIRLINE;
		String url = command.url(baseUrl);
		try {
			FlightVstProductDto result = restClient.post(url, FlightVstProductDto.class, product);
			return result;
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public FlightVstProductBranchDto saveOrUpdateProductBranchByAirline(FlightVstProductBranchDto productBranch) {
		VstClientPath command = VstClientPath.SAVE_PRODUCT_BRANCH_BY_AIRLINE;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, FlightVstProductBranchDto.class, productBranch);
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	public List<FlightVstTrafficFlightDto> saveProductTrafficFlightByAirline(FlightVstTrafficFlightDto trafficFlight) throws JsonParseException, JsonMappingException, IOException {
		VstClientPath command = VstClientPath.SAVE_TRAFFIC_FLIGHT_BY_AIRLINE;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, trafficFlight);
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<List<FlightVstTrafficFlightDto>>() {});
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	public BaseResponseDto<FlightVstTrafficFlightDto> addProductFlight(FlightVstTrafficFlightDto data){
		VstClientPath command = VstClientPath.ADD_PRODUCT_FLIGHT;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, data);
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResponseDto<FlightVstTrafficFlightDto>>() { });
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public BaseResponseDto updateProductFlight(FlightVstTrafficFlightDto data){
		VstClientPath command = VstClientPath.UPDATE_PRODUCT_FLIGHT;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, data);
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResponseDto>() { });
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据用户名获取登录用户信息
	 * 
	 * @param userName
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@SuppressWarnings("unchecked")
	public BaseReponseHandleT<PermUserDto> queryVstPermUserByUserName(String userName) throws JsonParseException, JsonMappingException, IOException {
		VstClientPath command = VstClientPath.QUERY_VST_PERMUSER_BY_USERNAME;
		String url = command.url(baseUrl, userName);
		try {
			String resultString = restClient.get(url, String.class);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseReponseHandleT<PermUserDto>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**
	 * 
	 * @param userName
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public String flightOrderBookingResultsCallback(List<FlightLockSeatCallbackInfoDto> flightLockSeatCallbackInfoDtos) throws JsonParseException, JsonMappingException, IOException {
		VstClientPath command = VstClientPath.FLIGHT_ORDER_BOOKING_ORDER_RESULTS_CALLBACK;
		String url = command.url(baseUrl);
		try {
			String jsonRequest = JSONMapper.getInstance().writeValueAsString(flightLockSeatCallbackInfoDtos);
			String result = restClient.post(url, String.class,jsonRequest);
			if (null == result || "".equals(result)) {
				return null;
			}
			return result;
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	public String flightOrderBookingResultCallback(FlightLockSeatCallbackInfoDto flightLockSeatCallbackInfoDto) throws JsonParseException, JsonMappingException, IOException {
		VstClientPath command = VstClientPath.FLIGHT_ORDER_BOOKING_ORDER_RESULT_CALLBACK;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,flightLockSeatCallbackInfoDto);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return resultString;
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	

	/**
	 * 将结算单推送至VST
	 * @param settlementOrderDto
	 * @return
	 */
	public BaseSingleResultDto<SettlementOrderDto> sendSettlementToVst(SettlementOrderDto settlementOrderDto) {
		VstClientPath command = VstClientPath.SEND_SETTLEMENT_TO_VST;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, settlementOrderDto);
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseSingleResultDto<SettlementOrderDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	 /**
     * 查询城市列表(省-市-区)
     */
    public BaseResultDto<DistrictVo> getDistrictVos(Long parentDistrictId) throws JsonParseException, JsonMappingException, IOException {
		VstClientPath command = VstClientPath.QUERY_CITY_ADDRESS_LIST;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, parentDistrictId);
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResultDto<DistrictVo>>() {
			});
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
	/**
	 * 短信批量发送
	 * @param smsSendDto
	 * @return
	 */
	public BaseSingleResultDto<SmsSendDto> smsGroupSend(SmsSendDto smsSendDto) {
		VstClientPath command = VstClientPath.SMS_GROUP_SEND;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, smsSendDto);
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseSingleResultDto<SmsSendDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取退款流水号
	 * 
	 * @param refundmentId
	 * @return
	 */
	public String getRefundmentSerialNo(String refundmentId) {
		VstClientPath command = VstClientPath.GET_REFUNDMENT_SERIALNO;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, String.class, refundmentId);
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**
	 * getUserByLvSessionId:根据lvSessionId获取登录用户信息. <br/>
	 *
	 */
	public BaseSingleResultDto<FitMemUserDto> getUserByLvSessionId(MemUserRequest request){
		VstClientPath command = VstClientPath.GET_USER_BY_LVSESSION_ID;
		String url = command.url(baseUrl);
		try {
			String jsonRequest = JSONMapper.getInstance().writeValueAsString(request);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			if(StringUtils.isNotBlank(jsonResult)){
				return JSONMapper.getInstance().readValue(jsonResult, new TypeReference<BaseSingleResultDto<FitMemUserDto>>(){});
			}
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
		return null;
	}
	
	
	/**
	 * 获得订单支付的URL
	 * @param request
	 */
	public String getPaymentUrl(FlightPayRequest request) {
		VstClientPath command = VstClientPath.GET_PAYMENT_URL;
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
	 * 获取头信息
	 * @param commHeaderRequest
	 * @return
	 */
	public ComIps getComIps(String ip) {
		VstClientPath command = VstClientPath.GET_COM_IPS;
		String url = command.url(baseUrl);
		try {
			String jsonResult = restClient.post(url, String.class, ip);
			return JSONMapper.getInstance().readValue(jsonResult, new TypeReference<ComIps>(){});
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
			String jsonRequest = JSONMapper.getInstance().writeValueAsString(commHeaderRequest);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
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
	 * 获取登录用户下的所有收货地址
	 * @param userNo
	 * @return
	 */
	public BaseResponseDto<UserAddressDto> queryAddress(String userNo){
		VstClientPath command = VstClientPath.QUERY_ADDRESS_BY_USERNO;
		String url = command.url(baseUrl);
		try {
			String jsonResult = restClient.post(url, String.class, userNo);
			return JSONMapper.getInstance().readValue(jsonResult, new TypeReference<BaseResponseDto<UserAddressDto>>(){});
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
	 * 保存收货地址
	 * @param request
	 * @return
	 */
	public String saveOrUpdateAddress(UserAddressRequest request){
		VstClientPath command = VstClientPath.SAVE_OR_UPDATE_ADDRESS;
		String url = command.url(baseUrl);
		try {
			String jsonResult = restClient.post(url, String.class, request);
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
	 * 根据vst主单号和子单号获取vst订单(子单号可选)
	 * @param vstOrderId
	 * @param vstOrderItemId
	 * @return
	 */
	public String getVstOrderInfo(Map<String, Long> param){
		VstClientPath command = VstClientPath.GET_VST_ORDER_INFO;
		String url = command.url(baseUrl);
		try {
			String jsonResult = restClient.post(url, String.class, param);
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
	 * 根据vst主单号和子单号对vst打包产品一键下单(子单号可选)
	 * @param vstOrderId
	 * @param vstOrderItemId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> oneStepBooking(Map<String, Long> param){
		VstClientPath command = VstClientPath.ONE_STEP_BOOKING;
		String url = command.url(baseUrl);
		try {
			Map<String, Object> jsonResult = restClient.post(url, Map.class, param);
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
	 * 根据订单号获取订单来源
	 * @param vstOrderId
	 * @return
	 */
	public BookingSource queryBookingSource(Long vstOrderId){
		VstClientPath command = VstClientPath.QUERY_BOOKING_SOURCE;
		String url = command.url(baseUrl);
		try {
			BookingSource jsonResult = restClient.post(url, BookingSource.class, vstOrderId);
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
}
