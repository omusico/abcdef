package com.lvmama.lvf.common.client;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.cache.CacheBoxConvert;
import com.lvmama.lvf.common.cache.CacheKey;
import com.lvmama.lvf.common.cache.CachePoint;
import com.lvmama.lvf.common.client.path.AdapterClientPath;
import com.lvmama.lvf.common.dto.BaseInsuranceResponseDto;
import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.dto.adapter.request.insurance.FlightInsuranceRequest;
import com.lvmama.lvf.common.dto.adapter.request.insurance.InsuranceOrderRequest;
import com.lvmama.lvf.common.dto.adapter.request.supp.FlightSuppOrderChangeRequest;
import com.lvmama.lvf.common.dto.adapter.request.supp.FlightSuppOrderRefundRequest;
import com.lvmama.lvf.common.dto.adapter.request.supp.FlightSuppOrderSimpleOpRequest;
import com.lvmama.lvf.common.dto.adapter.response.FlightSuppOrderChangeResponse;
import com.lvmama.lvf.common.dto.adapter.response.FlightSuppOrderRefundableResponse;
import com.lvmama.lvf.common.dto.adapter.response.PolicyPushQueryResponse;
import com.lvmama.lvf.common.dto.adapter.response.SuppResponse;
import com.lvmama.lvf.common.dto.calculator.FlightTicketPriceDto;
import com.lvmama.lvf.common.dto.flight.FlightDayPriceDto;
import com.lvmama.lvf.common.dto.flight.FlightInfoDto;
import com.lvmama.lvf.common.dto.flight.FlightInfosDto;
import com.lvmama.lvf.common.dto.flight.price.FlightPriceInventoryDto;
import com.lvmama.lvf.common.dto.insurance.InsuranceOrderDto;
import com.lvmama.lvf.common.dto.insurance.InsuranceSuppDto;
import com.lvmama.lvf.common.dto.order.verify.FlightBookingVerifyInfosDto;
import com.lvmama.lvf.common.dto.policy.FlightPolicyDtos;
import com.lvmama.lvf.common.dto.request.FlightQueryRequest;
import com.lvmama.lvf.common.dto.search.FlightSearchResult;
import com.lvmama.lvf.common.dto.search.result.FlightSearchFlightInfoDto;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderDto;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderMainDto;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderRefundDto;
import com.lvmama.lvf.common.dto.ticket.FlightTicketRuleInfo;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.trace.profile.Profile;
import com.lvmama.lvf.common.trace.profile.ProfilePoint;
import com.lvmama.lvf.common.utils.JSONMapper;

@Component
public class AdapterClient {

    @Value("adapter.baseurl")
    private String baseUrl;

    @Autowired
    private RestClient client;
    
    public static final Logger logger=Logger.getLogger(AdapterClient.class);


    /**
     * 根据航班号查询座位情况
     * 
     * @param suppFlightQueryRequest
     * @return
     */
    public FlightInfoDto getFlightSeatByFlightNo(FlightQueryRequest flightQueryRequest) {
        AdapterClientPath command = AdapterClientPath.GET_FLIGHT_SEAT_BY_FLIGHT_NO;
        String url = command.url(baseUrl);
        try {
            return client.post(url, FlightInfoDto.class, flightQueryRequest);
        } catch (ExceptionWrapper ew) {
        	
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
    }

    /**
     * 根据航班列表舱位出发日期等查询政策及运价
     * 
     * @param flightQueryRequest
     * @return
     */
    public FlightBookingVerifyInfosDto getPolicyAndFareByFlights(
            FlightQueryRequest flightQueryRequest) {
        AdapterClientPath command = AdapterClientPath.GET_POLICY_AND_FARE_BY_FIIGHTS;
        String url = command.url(baseUrl);
        try {
            return client.post(url, FlightBookingVerifyInfosDto.class, flightQueryRequest);
        } catch (ExceptionWrapper ew) {
        	
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
    }
    
    /**
     * 根据航班舱位出发日期实时匹配儿童政策 [PQ7]
     * 
     * @param flightQueryRequest
     * @return
     */
    public SuppResponse<FlightBookingVerifyInfosDto> getChildPolicyAndFlight(FlightQueryRequest flightQueryRequest)  
            throws JsonParseException, JsonMappingException, IOException {
        AdapterClientPath command = AdapterClientPath.GET_CHILD_POLICY_AND_FIIGHT;
        String url = command.url(baseUrl);
        try {
            String resultJson = client.post(url, String.class, flightQueryRequest);
            return JSONMapper.getInstance().readValue(resultJson, new TypeReference<SuppResponse<FlightBookingVerifyInfosDto>>() {
            });
        } catch (ExceptionWrapper ew) {
        	
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
    }

    /**
     * 根据旅客信息创建PNR及订单
     * 
     * @return
     */
	@ProfilePoint(Profile.SUPPORDER_BOOKING_FROM_ADPATER)
    public SuppResponse<FlightOrderSuppOrderDto> createOrder(FlightOrderSuppOrderDto flightOrderSuppOrder) {
        AdapterClientPath command = AdapterClientPath.CREATE_ORDER;
        String url = command.url(baseUrl);
        try 
        {
        	String resultJson = client.post(url, String.class, flightOrderSuppOrder);
        	return new ObjectMapper().readValue(resultJson, new TypeReference<SuppResponse<FlightOrderSuppOrderDto>>() {
            });
        }
        catch(Exception e)
        {
        	return null;
        }
    }

    /**
     * 航班查询（含票面价、返佣）
     * 
     * @return
     */
	@ProfilePoint(Profile.SYNC_FLIGHT_INFO_FROM_ADPATER)
    public FlightInfosDto getFlightInfo(FlightQueryRequest flightQueryRequest) {
        AdapterClientPath command = AdapterClientPath.GET_AVAILABLE_FLIGHT_WITH_PRICE_AND_COMMISION;
        try {
            return client.post(command.url(baseUrl), FlightInfosDto.class, flightQueryRequest);
        } catch (ExceptionWrapper ew) {
        	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl))+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
    }

    /**
     * 全取接口通讯
     * 
     * @param request
     * @return SuppResponse<FlightPolicyDtos>
     */
	@ProfilePoint(Profile.GET_POLICY_ADPATER)
    public SuppResponse<FlightPolicyDtos> getPolicyRemote(Integer page) throws JsonParseException,
    JsonMappingException, IOException {
        AdapterClientPath command = AdapterClientPath.GET_POLICY;
        try {
            String url = command.url(baseUrl, page);
            String resultJson = client.get(url, String.class);
            return JSONMapper.getInstance().readValue(resultJson, new TypeReference<SuppResponse<FlightPolicyDtos>>() {
            });
        } catch (ExceptionWrapper ew) {
        	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl))+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
    }

    /**
     * 同步接口通讯
     * 
     * @param request
     * @return SuppResponse<FlightPolicyDtos>
     */
	@ProfilePoint(Profile.SYN_POLICY_ADPATER)
    public SuppResponse<FlightPolicyDtos> syncPolicyRemote(String lastPolicyId, String lastUpdateTime) throws JsonParseException,
    JsonMappingException, IOException {
        AdapterClientPath command = AdapterClientPath.SYNC_POLICY;
        try {
            String url = command.url(baseUrl, lastPolicyId, lastUpdateTime);
            String resultJson = client.get(url, String.class);
            return JSONMapper.getInstance().readValue(resultJson,new TypeReference<SuppResponse<FlightPolicyDtos>>() {});
        } catch (ExceptionWrapper ew) {
        	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl))+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
    }
    
    /**
     * 根据政策ID获取政策（校验政策）
     * 
     * @param request
     * @return SuppResponse<FlightPolicyDtos>
     */
	@ProfilePoint(Profile.GET_POLICY_BY_ID_ADPATER)
    public SuppResponse<FlightPolicyDtos> getPolicyById(String suppPolicyNo) throws JsonParseException,
	JsonMappingException, IOException {
        AdapterClientPath command = AdapterClientPath.GET_POLICY_BY_ID;
        try {
        	String url = command.url(baseUrl, suppPolicyNo);
        	String resultJson = client.get(url, String.class);
        	return JSONMapper.getInstance().readValue(resultJson,new TypeReference<SuppResponse<FlightPolicyDtos>>() {});
        } catch (ExceptionWrapper ew) {
        	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl))+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
    }
    /**
     * Five17Na同步全量政策接口
     */
	@ProfilePoint(Profile.Flight_Policy_517Na_FULL_SYNC)
    public PolicyPushQueryResponse syncPolicyPushFull() throws Exception {
        AdapterClientPath command = AdapterClientPath.FIVE17NA_SYNC_POLICY_PUSH_FULL;
        try {
            String url = command.url(baseUrl);
            String resultJson = client.post(url, String.class);
            return JSONMapper.getInstance().readValue(resultJson,new TypeReference<PolicyPushQueryResponse>() {});
        } catch (ExceptionWrapper ew) {
        	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl))+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
    }
	
    /**
     * Five17Na同步增量政策接口
     */
	@ProfilePoint(Profile.Flight_Policy_517Na_ADD_SYNC)
    public PolicyPushQueryResponse syncPolicyPushAdd() throws Exception {
        AdapterClientPath command = AdapterClientPath.FIVE17NA_SYNC_POLICY_PUSH_ADD;
        try {
            String url = command.url(baseUrl);
            String resultJson = client.post(url, String.class);
            return JSONMapper.getInstance().readValue(resultJson,new TypeReference<PolicyPushQueryResponse>() {});
        } catch (ExceptionWrapper ew) {
        	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl))+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
    }
	
    /**
     * 获取所有退改签规定
     * 
     * @return
     * @author hedandan
     */
    public FlightTicketRuleInfo getFlightTicketRule() {
        AdapterClientPath command = AdapterClientPath.GET_TICKET_RULE;
        try {
            return client.get(command.url(baseUrl), FlightTicketRuleInfo.class);
        } catch (ExceptionWrapper ew) {
        	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl))+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
    }
    
    /**
     * 获取退改签规定
     * 
     * @return
     * @author hedandan
     * @param request 
     */
    public FlightTicketRuleInfo getFlightTicketRuleByCondition(FlightQueryRequest request) {
        AdapterClientPath command = AdapterClientPath.GET_TICKET_RULE_BY_CONDITION;
        try {
            return client.post(command.url(baseUrl), FlightTicketRuleInfo.class, request);
        } catch (ExceptionWrapper ew) {
        	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl))+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
    }

	/**
	 * 根据订单号查询供应商订单
	 * 
	 * @param suppOrderNo
	 * @return SuppResponse<FlightOrderSuppOrderDto>
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public SuppResponse<FlightOrderSuppOrderDto> getSuppOrderByOrderNo(String suppOrderNo) throws JsonParseException,
			JsonMappingException, IOException {
		AdapterClientPath command = AdapterClientPath.GET_SUPPORDER_BY_ORDER_NO;
		try {
			String url = command.url(baseUrl, suppOrderNo);
			String resultJson = client.get(url, String.class);
			return JSONMapper.getInstance().readValue(resultJson, new TypeReference<SuppResponse<FlightOrderSuppOrderDto>>() {
            });
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl)) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

    /**
     * 取消订单的状态
     * 
     * @param request
     *            供应商订单支付、取消、详情、退废票简单操作对象
     * @return SuppResponse<String>
     */
	@ProfilePoint(Profile.CANCEL_SUPPORDER_FROM_ADPATER)
    @SuppressWarnings("rawtypes")
    public SuppResponse cancelSuppOrder(String suppOrderNo, Boolean cancelPNR) {
        AdapterClientPath command = AdapterClientPath.CANCELORDER;
        try {
            return client.get(command.url(baseUrl, suppOrderNo, cancelPNR), SuppResponse.class);
        } catch (ExceptionWrapper ew) {
        	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl))+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
    }
	
	/**
	 * 517Na取消pnr
	 */
	public SuppResponse five17NaCancelPnr(FlightSuppOrderSimpleOpRequest request){
        AdapterClientPath command = AdapterClientPath.FIVE17NA_CANCEL_PNR;
        try {
            return client.post(command.url(baseUrl), SuppResponse.class, request);
        } catch (ExceptionWrapper ew) {
        	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl))+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
	}
    /**
     * 路由取消订单
     * @param  request
     * @return SuppResponse
     */
	@ProfilePoint(Profile.ROUTE_CANCEL_ORDER)
    @SuppressWarnings("rawtypes")
    public SuppResponse cancelSuppOrderRoute(FlightSuppOrderSimpleOpRequest request) {
        AdapterClientPath command = AdapterClientPath.ROUTE_CANCEL_ORDER;
        try {
            return client.post(command.url(baseUrl), SuppResponse.class, request);
        } catch (ExceptionWrapper ew) {
        	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl))+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
    }

    /**
     * 根据退废票单号查询退废票详情。
     * 
     * @param suppRefundNo
     * @return
     */
    public FlightOrderSuppOrderRefundDto getRefundDetail(FlightSuppOrderSimpleOpRequest request) {
        AdapterClientPath command = AdapterClientPath.GET_REFUND_DETAIL;
        try {
            return client.post(command.url(baseUrl), FlightOrderSuppOrderRefundDto.class, request);
        } catch (ExceptionWrapper ew) {
        	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl))+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
    }
    /**
     * 路由根据退废票单号查询退废票详情。
     * @return
     */
    @ProfilePoint(Profile.ROUTE_GET_REFUND_DETAIL)
    public FlightOrderSuppOrderRefundDto getRefundDetailRoute(FlightSuppOrderSimpleOpRequest request, String suppCode) {
        AdapterClientPath command = AdapterClientPath.ROUTE_GET_REFUND_DETAIL;
        try {
            return client.post(command.url(baseUrl, suppCode), FlightOrderSuppOrderRefundDto.class, request);
        } catch (ExceptionWrapper ew) {
        	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl))+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
    }

    /**
     * 提交退废票申请
     * @param request
     * @return
     */
    public BaseResponseDto<FlightOrderSuppOrderRefundDto> applyPolicyOrderRefund(FlightSuppOrderRefundRequest request) throws Exception
    {
        AdapterClientPath command = AdapterClientPath.APPLY_POLICY_ORDER_REFUND;
        String url = command.url(baseUrl);
        try 
        {
        	String json = client.post(url, String.class, request);
            return new ObjectMapper().readValue(json, new TypeReference<BaseResponseDto<FlightOrderSuppOrderRefundDto>>() {
            });
        }
        catch (ExceptionWrapper ew) 
        {
        	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl))+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
    }

    /**
     * 订单支付
     * 
     * @param suppOrderLvNo
     * @param suppOrderNo
     * @return SuppResponse<FlightOrderSuppOrderDto>
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    public SuppResponse<FlightOrderSuppOrderDto> pay(String suppOrderLvNo, String suppOrderNo)
            throws JsonParseException, JsonMappingException, IOException {
        AdapterClientPath command = AdapterClientPath.PAY;
        try {
            String url = command.url(baseUrl, suppOrderLvNo, suppOrderNo);
            String resultJson = client.get(url, String.class);
            return JSONMapper.getInstance().readValue(resultJson, new TypeReference<SuppResponse<FlightOrderSuppOrderDto>>() {
            });
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }

    /**
     * 根据出发、抵达城市及起始、结束日期查询这个时间段这个航程之内的最低价航班，时间段最长一个月。
     * 
     * @param flightQueryRequest
     * @return
     */
    public FlightDayPriceDto getDailyLowestPrice(FlightQueryRequest flightQueryRequest) {
        AdapterClientPath command = AdapterClientPath.GET_DAILY_LOWEST_PRICE;
        String url = command.url(baseUrl);
        try {
            return client.post(url, FlightDayPriceDto.class, flightQueryRequest);
        } catch (ExceptionWrapper ew) {
        	
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
    }

    /**
     * 退保
     * 
     * @param request
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public BaseInsuranceResponseDto<InsuranceOrderDto> hesitateCancel(FlightInsuranceRequest request)
            throws JsonParseException, JsonMappingException, IOException {
        AdapterClientPath command = AdapterClientPath.APPLY_INSURANCE_HESITATE_CANCEL;
        String url = command.url(baseUrl);
        try {
            String resultString = client.post(url, String.class, request);
            if (null == resultString && "".equals(resultString)) {
                return null;
            }
            return JSONMapper.getInstance().readValue(resultString,
                    new TypeReference<BaseInsuranceResponseDto<InsuranceOrderDto>>() {
                    });
        } catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
    }

    /**
     * 投保
     * 
     * @param request
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public BaseInsuranceResponseDto<InsuranceOrderDto> singleInsuring(InsuranceOrderRequest request)
            throws JsonParseException, JsonMappingException, IOException {
        AdapterClientPath command = AdapterClientPath.APPLY_INSURANCE_SINGLE_INSURING;
        String url = command.url(baseUrl);
        try {
            String resultString = client.post(url, String.class, request);
            if (null == resultString && "".equals(resultString)) {
                return null;
            }
            return JSONMapper.getInstance().readValue(resultString,
                    new TypeReference<BaseInsuranceResponseDto<InsuranceOrderDto>>() {
                    });
        } catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
        }
    }
    
	public InsuranceSuppDto getSuppInsurance(String insuranceOrderNo) throws JsonParseException,
			JsonMappingException, IOException {
		AdapterClientPath command = AdapterClientPath.QUERY_INSURANCE_SUPP;
		try {
			String url = command.url(baseUrl, insuranceOrderNo);
			String resultJson = client.get(url, String.class);
			return JSONMapper.getInstance().readValue(resultJson,new TypeReference<InsuranceSuppDto>() {});
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(
					command.cnName, command.url(baseUrl)) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
   
    /**
     * 查询航班信息(路由方式)
     * @param 	flightQueryRequest		航班查询请求对象
     * @param 	suppCode				供应商编码	
     * @return	FlightInfosDto			航班信息s
     */
    @ProfilePoint(Profile.ROUTE_QUERY_FLIGHT_INFO)
    public FlightInfosDto queryFlightInfoOfRoute(FlightQueryRequest flightQueryRequest, String suppCode) 
    {
    	if(StringUtils.isBlank(suppCode))
    	{
    		throw new ExceptionWrapper(ExceptionCode.EMPTY_SUPP_CODE);
    	}
    	AdapterClientPath adapterClientPath = AdapterClientPath.ROUTE_QUERY_FLIGHT_INFO;
    	String url = adapterClientPath.url(baseUrl, suppCode);
    	
    	return client.post(url, FlightInfosDto.class, flightQueryRequest);
    }
    
    /**
     * 验舱验价(路由方式)
     * @param 	flightQueryRequest		         航班查询请求对象
     * @param 	suppCode				         供应商编码	
     * @return	FlightBookingVerifyInfosDto 航班信息s
     */
    @ProfilePoint(Profile.ROUTE_VERIFY_SEAT_AND_PRICE)
    public FlightBookingVerifyInfosDto verifySeatAndPriceOfRoute(FlightQueryRequest flightQueryRequest, String suppCode) 
    {
    	if(StringUtils.isBlank(suppCode))
    	{
    		throw new ExceptionWrapper(ExceptionCode.EMPTY_SUPP_CODE);
    	}
    	AdapterClientPath adapterClientPath = AdapterClientPath.ROUTE_VERIFY_SEAT_AND_PRICE;
    	String url = adapterClientPath.url(baseUrl, suppCode);
    	
    	return client.post(url, FlightBookingVerifyInfosDto.class, flightQueryRequest);
    }
    
    /**
     * 携程创建订单(路由方式)
     * @param 	flightOrderSuppOrderMainDto		 			供应商主订单信息请求对象
     * @param 	suppCode				         			供应商编码	
     * @return	SuppResponse<FlightOrderSuppOrderMainDto> 	供应商主订单信息返回结果
     * @throws 	IOException 
     * @throws 	JsonMappingException 
     * @throws 	JsonParseException 
     */
    @ProfilePoint(Profile.ROUTE_CREATE_ORDER)
    public SuppResponse<FlightOrderSuppOrderMainDto> createOrderRoute(FlightOrderSuppOrderMainDto flightOrderSuppOrderMainDto, String suppCode) 
    		throws JsonParseException, JsonMappingException, IOException 
    {
    	if(StringUtils.isBlank(suppCode))
    	{
    		throw new ExceptionWrapper(ExceptionCode.EMPTY_SUPP_CODE);
    	}
    	AdapterClientPath adapterClientPath = AdapterClientPath.ROUTE_CREATE_ORDER;
    	String url = adapterClientPath.url(baseUrl, suppCode);
    	try {
    		String resultString = client.post(url, String.class, flightOrderSuppOrderMainDto);
    		if(StringUtils.isEmpty(resultString)){
    			return null;
    		}
    		return JSONMapper.getInstance().readValue(resultString,
    				new TypeReference<SuppResponse<FlightOrderSuppOrderMainDto>>() {
    		});
    	} catch (ExceptionWrapper ew) {
    		ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(
	    			adapterClientPath.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
    	}
    }
    
    /**
     * 供应商支付路由
     * @param flightOrderSuppOrderMainDto
     * @param suppCode
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    @ProfilePoint(Profile.ROUTE_FLIGHT_SUPP_ORDER_PAY)
    public SuppResponse<FlightOrderSuppOrderDto> flightSuppOrderPayRoute(FlightOrderSuppOrderMainDto flightOrderSuppOrderMainDto,
    		String suppCode) throws JsonParseException,JsonMappingException, IOException {
    	if(StringUtils.isBlank(suppCode))
    	{
    		throw new ExceptionWrapper(ExceptionCode.EMPTY_SUPP_CODE);
    	}
    	AdapterClientPath adapterClientPath = AdapterClientPath.ROUTE_FLIGHT_SUPP_ORDER_PAY;
    	String url = adapterClientPath.url(baseUrl, suppCode);
	    try{
	    	String resultString = client.post(url, String.class,flightOrderSuppOrderMainDto);
	    	if(StringUtils.isEmpty(resultString)){
	    		return null;
	    	}
	    	return JSONMapper.getInstance().readValue(resultString, new TypeReference<SuppResponse<FlightOrderSuppOrderDto>>() {
			});
	    }catch(ExceptionWrapper ew){
	    	ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(
	    			adapterClientPath.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
	    }
    }
    
    /**
     * 获取客规(路由方式)
     * @param 	flightQueryRequest		      航班查询请求对象
     * @return	FlightTicketRuleInfo		  客规结果集对象
     */
    @ProfilePoint(Profile.ROUTE_GET_FLIGHT_TICKET_RULE)
    public FlightTicketRuleInfo getFlightTicketRuleRoute(FlightQueryRequest flightQueryRequest) 
    {
    	AdapterClientPath adapterClientPath = AdapterClientPath.ROUTE_GET_FLIGHT_TICKET_RULE;
    	String url = adapterClientPath.url(baseUrl);
    	return client.post(url, FlightTicketRuleInfo.class, flightQueryRequest);
    }
    
    /**
     * 提交退废票申请(路由方式)
     * @param  flightSuppOrderRefundRequest
     * @param  suppCode
     * @return BaseResponseDto<FlightOrderSuppOrderRefundDto>
     */
    @ProfilePoint(Profile.ROUTE_APPLY_SUPP_ORDER_REFUND)
    public BaseResponseDto<FlightOrderSuppOrderRefundDto> applySuppOrderRefundRoute(FlightSuppOrderRefundRequest flightSuppOrderRefundRequest, 
    		String suppCode) throws Exception
    {
    	if(StringUtils.isBlank(suppCode))
    	{
    		throw new ExceptionWrapper(ExceptionCode.EMPTY_SUPP_CODE);
    	}
    	AdapterClientPath command = AdapterClientPath.ROUTE_APPLY_SUPP_ORDER_REFUND;
    	String url = command.url(baseUrl, suppCode);
    	try 
    	{
    		String resultString = client.post(url, String.class, flightSuppOrderRefundRequest);
    		return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResponseDto<FlightOrderSuppOrderRefundDto>>() {
    		});
    	}
    	catch (ExceptionWrapper ew) 
    	{
    		ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
    		logger.error(ew.getErrMessage(),ew);
    		throw ew;
    	}
    }
    
	/**
	 * 根据订单号查询供应商订单
	 * 
	 * @param suppOrderNo
	 * @return SuppResponse<FlightOrderSuppOrderDto>
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
    @ProfilePoint(Profile.ROUTE_GET_SUPPORDER_BY_ORDER_NO)
	public SuppResponse<FlightOrderSuppOrderDto> getSuppOrderByOrderNoRoute(FlightOrderSuppOrderDto flightOrderSuppOrder) throws JsonParseException,
			JsonMappingException, IOException {
    	String suppCode = flightOrderSuppOrder.getSupp().getCode();
		if(StringUtils.isBlank(suppCode))
    	{
    		throw new ExceptionWrapper(ExceptionCode.EMPTY_SUPP_CODE);
    	}
		AdapterClientPath command = AdapterClientPath.ROUTE_GET_SUPPORDER_BY_ORDER_NO;
		String url = command.url(baseUrl);
		try {
			String resultJson = client.post(url, String.class,flightOrderSuppOrder);
			return JSONMapper.getInstance().readValue(resultJson,new TypeReference<SuppResponse<FlightOrderSuppOrderDto>>() {});
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage());
			throw ew;
		}
	}
    
    /**
     * 国内机票可退票/改签查询(路由方式)
     * 
     * @param suppOrderNo
     * @return SuppResponse<FlightSuppOrderRefundableResponse>
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    public SuppResponse<FlightSuppOrderRefundableResponse> flightReviseCondition(String suppOrderNo) throws JsonParseException,
            JsonMappingException, IOException {
        AdapterClientPath command = AdapterClientPath.ROUTE_FLIGHT_REVISE_CONDITION;
        try {
            String url = command.url(baseUrl, suppOrderNo);
            String resultJson = client.get(url, String.class);
            return JSONMapper.getInstance().readValue(resultJson,new TypeReference<SuppResponse<FlightSuppOrderRefundableResponse>>() {});
        } catch (ExceptionWrapper ew) {
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl)) + ew.getErrMessage());
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
    
    
    /**
     * 国内机票可改航班查询(路由方式)
     * 
     * @param suppOrderNo
     * @return SuppResponse<FlightSuppOrderChangeResponse>
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @ProfilePoint(Profile.ROUTE_RESCHEDULE_SEARCH)
    public SuppResponse<FlightSuppOrderChangeResponse> rescheduleSearch(
            FlightSuppOrderChangeRequest request) throws JsonParseException, JsonMappingException,IOException {
        AdapterClientPath command = AdapterClientPath.ROUTE_RESCHEDULE_SEARCH;
        try {
            String url = command.url(baseUrl);
            String resultJson = client.post(url, String.class, request);
            return JSONMapper.getInstance().readValue(resultJson,new TypeReference<SuppResponse<FlightSuppOrderChangeResponse>>() {});
        } catch (ExceptionWrapper ew) {
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl)) + ew.getErrMessage());
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
    
    /**
     * 向供应商申请改签(路由方式)
     * 
     * @param request
     * @return SuppResponse
     */
    @ProfilePoint(Profile.FLIGHT_APPLY_CHANGE)
    public SuppResponse autoChangeApply(FlightSuppOrderChangeRequest request) throws Exception {
        AdapterClientPath command = AdapterClientPath.ROUTE_AUTO_CHANGE_APPLY;
        try {
            return client.post(command.url(baseUrl), SuppResponse.class, request);
        } catch (ExceptionWrapper ew) {
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl))+ew.getErrMessage());
            logger.error(ew.getErrMessage(),ew);
            throw ew;
        }
    }
    
    /**
     * 查询517Na询价政策
     * 
     * @param suppOrderLvNo
     * @param suppOrderNo
     * @return List<FlightOrderSuppOrderDto>
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    public List<FlightPriceInventoryDto>  getPolicyPriceFromFive17Na(FlightQueryRequest flightQueryRequest)
            throws JsonParseException, JsonMappingException, IOException {
        AdapterClientPath command = AdapterClientPath.FIVE17NA_VERIFY_SEAT_AND_PRICE;
        try {
            String url = command.url(baseUrl);
            String resultJson = client.post(url, String.class, flightQueryRequest);
            if(StringUtils.isEmpty(resultJson)){
	    		return null;
	    	}
            return JSONMapper.getInstance().readValue(resultJson, new TypeReference<List<FlightPriceInventoryDto>>() {
            });
        } catch (ExceptionWrapper ew) {
        	 ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl)) + ew.getErrMessage());
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
    
    /**
     * 根据旅客信息创建PNR信息
     * @param flightOrderSuppOrderDto
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public SuppResponse<FlightOrderSuppOrderDto> createPnrRoute(FlightOrderSuppOrderDto flightOrderSuppOrderDto)
    		throws JsonParseException, JsonMappingException, IOException{
    	 AdapterClientPath command = AdapterClientPath.ROUTE_CREATE_PNR;
         try {
             String url = command.url(baseUrl);
             String resultJson = client.post(url, String.class, flightOrderSuppOrderDto);
             if(StringUtils.isEmpty(resultJson)){
 	    		return null;
 	    	}
             return JSONMapper.getInstance().readValue(resultJson, new TypeReference<SuppResponse<FlightOrderSuppOrderDto>>() {});
         } catch (ExceptionWrapper ew) {
         	 ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl)) + ew.getErrMessage());
             logger.error(ew.getErrMessage(), ew);
             throw ew;
         }
    }
    
    /**
     * 取消PNR
     * @param suppCode
     * @param pnr
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    @SuppressWarnings("rawtypes")
	public SuppResponse xePnrRoute(String suppCode, String pnr) throws JsonParseException, JsonMappingException, IOException{
    	 AdapterClientPath command = AdapterClientPath.ROUTE_XE_PNR;
         try {
             String url = command.url(baseUrl, suppCode);
             String resultJson = client.post(url, String.class, pnr);
             if(StringUtils.isEmpty(resultJson)){
 	    		return null;
 	    	}
             return JSONMapper.getInstance().readValue(resultJson, new TypeReference<SuppResponse>() {});
         } catch (ExceptionWrapper ew) {
         	 ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl, suppCode)) + ew.getErrMessage());
             logger.error(ew.getErrMessage(), ew);
             throw ew;
         }
    }
    
    /**
     * PATA
     * @param flightQueryRequest
     * @return SuppResponse<List<FlightTicketPriceDto>>
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    //@CachePoint(value=CacheBoxConvert.SuppResponsePata,cacheSizeLimit=50,cacheExpireTimeKey="pata.cacheExpireTime")
	public SuppResponse<List<FlightTicketPriceDto>> pataRoute(FlightQueryRequest flightQueryRequest) throws JsonParseException, JsonMappingException, IOException{
    	 AdapterClientPath command = AdapterClientPath.ROUTE_PATA;
         try {
             String url = command.url(baseUrl);
             String resultJson = client.post(url, String.class, flightQueryRequest);
             if(StringUtils.isEmpty(resultJson)){
 	    		return null;
 	    	}
             return JSONMapper.getInstance().readValue(resultJson, new TypeReference<SuppResponse<List<FlightTicketPriceDto>>>() {});
         } catch (ExceptionWrapper ew) {
         	 ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl)) + ew.getErrMessage());
             logger.error(ew.getErrMessage(), ew);
             throw ew;
         }
    }
    
    /**
     * AVH(查询航班可销售信息)
     * @param FlightQueryRequest
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
	public FlightSearchResult<FlightSearchFlightInfoDto> avhRoute(FlightQueryRequest flightQueryRequest) throws JsonParseException, JsonMappingException, IOException{
    	 AdapterClientPath command = AdapterClientPath.ROUTE_AVH;
         try {
             String url = command.url(baseUrl);
             String resultJson = client.post(url, String.class, flightQueryRequest);
             if(StringUtils.isEmpty(resultJson)){
 	    		return null;
 	    	}
             return JSONMapper.getInstance().readValue(resultJson, new TypeReference<FlightSearchResult<FlightSearchFlightInfoDto>>() {});
         } catch (ExceptionWrapper ew) {
         	 ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl)) + ew.getErrMessage());
             logger.error(ew.getErrMessage(), ew);
             throw ew;
         }
    }
    
    /**
     * AVETIME(查询航班可销售信息)
     * @param FlightQueryRequest
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
	public FlightSearchResult<FlightSearchFlightInfoDto> avetimeRoute(FlightQueryRequest flightQueryRequest) throws JsonParseException, JsonMappingException, IOException{
    	 AdapterClientPath command = AdapterClientPath.ROUTE_AVETIME;
         try {
             String url = command.url(baseUrl);
             String resultJson = client.post(url, String.class, flightQueryRequest);
             if(StringUtils.isEmpty(resultJson)){
 	    		return null;
 	    	}
             return JSONMapper.getInstance().readValue(resultJson, new TypeReference<FlightSearchResult<FlightSearchFlightInfoDto>>() {});
         } catch (ExceptionWrapper ew) {
         	 ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl)) + ew.getErrMessage());
             logger.error(ew.getErrMessage(), ew);
             throw ew;
         }
    }

    /**
     * 路由解析PNR
     * @param suppCode
     * @param pnr
     * @return
     * @throws Exception
     */
    public SuppResponse<FlightOrderSuppOrderMainDto> rtPnrRoute(String suppCode, String pnr) throws Exception{
        AdapterClientPath command = AdapterClientPath.ROUTE_RT_PNR;
        try {
            String url = command.url(baseUrl, suppCode);
            String resultJson = client.post(url, String.class, pnr);
            if(StringUtils.isEmpty(resultJson)){
                return null;
            }
            return JSONMapper.getInstance().readValue(resultJson, new TypeReference<SuppResponse<FlightOrderSuppOrderMainDto>>() {});
        } catch (ExceptionWrapper ew) {
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl, suppCode)) + ew.getErrMessage());
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }

    /**
     * 路由批量解析PNR
     * @param suppCode
     * @param pnr
     * @return
     * @throws Exception
     */
    public Map<String, SuppResponse<FlightOrderSuppOrderMainDto>> rtPnrBatchRoute(String suppCode, String[] pnr) throws Exception{
        AdapterClientPath command = AdapterClientPath.ROUTE_RT_PNR_BATCH;
        try {
            String url = command.url(baseUrl, suppCode);
            String resultJson = client.post(url, String.class, pnr);
            if(StringUtils.isEmpty(resultJson)){
                return null;
            }
            return JSONMapper.getInstance().readValue(resultJson, new TypeReference<Map<String, SuppResponse<FlightOrderSuppOrderMainDto>>>() {});
        } catch (ExceptionWrapper ew) {
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, command.url(baseUrl, suppCode)) + ew.getErrMessage());
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
}
