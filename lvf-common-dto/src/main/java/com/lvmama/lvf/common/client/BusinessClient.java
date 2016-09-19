package com.lvmama.lvf.common.client;

import static com.lvmama.lvf.common.client.path.BussinessClientPath.PAY_AMOUNT_INFO;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.client.path.BussinessClientPath;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseReponseHandle;
import com.lvmama.lvf.common.dto.BaseReponseHandleT;
import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.BusinessType;
import com.lvmama.lvf.common.dto.OpLog;
import com.lvmama.lvf.common.dto.adapter.request.insurance.FlightInsuranceRequest;
import com.lvmama.lvf.common.dto.adapter.request.insurance.InsuranceInfoRequest;
import com.lvmama.lvf.common.dto.adapter.request.insurance.InsuranceOrderRequest;
import com.lvmama.lvf.common.dto.adapter.response.FlightSuppOrderChangeInfoDto;
import com.lvmama.lvf.common.dto.adapter.response.FlightSuppOrderRefundableResponse;
import com.lvmama.lvf.common.dto.adapter.response.SuppResponse;
import com.lvmama.lvf.common.dto.api.ApiCacheConfigDto;
import com.lvmama.lvf.common.dto.api.ApiFlowCountDto;
import com.lvmama.lvf.common.dto.api.ApiFlowDto;
import com.lvmama.lvf.common.dto.audit.AuditOpDto;
import com.lvmama.lvf.common.dto.booking.BookingPassengerTypeAndAmountDto;
import com.lvmama.lvf.common.dto.booking.FlightOrderIntentionRecordDto;
import com.lvmama.lvf.common.dto.booking.FlightOrderRequestRecordDto;
import com.lvmama.lvf.common.dto.calculator.AmountCalculatorDto;
import com.lvmama.lvf.common.dto.calculator.AmountCalculatorRequest;
import com.lvmama.lvf.common.dto.calculator.ChildrenCalculatorRequest;
import com.lvmama.lvf.common.dto.calculator.ExpressInfoRequest;
import com.lvmama.lvf.common.dto.calculator.FlightTicketPriceDto;
import com.lvmama.lvf.common.dto.enums.AuditType;
import com.lvmama.lvf.common.dto.flight.FlightInfoDto;
import com.lvmama.lvf.common.dto.flight.price.FlightPriceInfoDto;
import com.lvmama.lvf.common.dto.flight.price.FlightPriceInventoryDto;
import com.lvmama.lvf.common.dto.flight.price.FlightPricePolicyDto;
import com.lvmama.lvf.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvf.common.dto.insurance.InsuranceOrderDto;
import com.lvmama.lvf.common.dto.insurance.InsuranceOrderListDto;
import com.lvmama.lvf.common.dto.md.Airport;
import com.lvmama.lvf.common.dto.md.Carrier;
import com.lvmama.lvf.common.dto.md.City;
import com.lvmama.lvf.common.dto.md.ExpressWay;
import com.lvmama.lvf.common.dto.md.FlightOfficeDto;
import com.lvmama.lvf.common.dto.md.InsuranceClass;
import com.lvmama.lvf.common.dto.md.SeatClass;
import com.lvmama.lvf.common.dto.md.SmsLogDto;
import com.lvmama.lvf.common.dto.notice.NoticeInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderContacterDto;
import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.dto.order.FlightOrderDto;
import com.lvmama.lvf.common.dto.order.FlightOrderExpressDto;
import com.lvmama.lvf.common.dto.order.FlightOrderExpressListDto;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightChangeInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderImportDto;
import com.lvmama.lvf.common.dto.order.FlightOrderImportRecordDto;
import com.lvmama.lvf.common.dto.order.FlightOrderInsuranceDto;
import com.lvmama.lvf.common.dto.order.FlightOrderLinkInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPNRInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderRemarkDto;
import com.lvmama.lvf.common.dto.order.FlightOrderSalesOrderRelationDto;
import com.lvmama.lvf.common.dto.order.FlightOrderTicketInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderVstDto;
import com.lvmama.lvf.common.dto.order.OrderMainDto;
import com.lvmama.lvf.common.dto.order.OrderOpLogDto;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderPayAmountInfo;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderPayInfoDto;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderPaymentDto;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderRefundDto;
import com.lvmama.lvf.common.dto.order.result.FlightOrderAuditOpDto;
import com.lvmama.lvf.common.dto.order.result.detail.FlightOrderDetailInfoDto;
import com.lvmama.lvf.common.dto.order.result.detail.FlightOrderDetailViewDto;
import com.lvmama.lvf.common.dto.order.result.detail.FlightOrderPassengerDetailViewDto;
import com.lvmama.lvf.common.dto.order.result.list.FlightOrderListDto;
import com.lvmama.lvf.common.dto.order.status.FlightOrderStatusDto;
import com.lvmama.lvf.common.dto.request.ApiCacheConfigRequest;
import com.lvmama.lvf.common.dto.request.ApiFlowQueryRequest;
import com.lvmama.lvf.common.dto.request.FlightCommonQueryRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderAuditOpRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderBookingAgainRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderBookingRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderCancelRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderExpressQueryRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderFlightChangeInfoRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderImportAuditRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderImportRecordRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderImportRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderIntentionRecordRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderModifyRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderOfflinePayRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderOfflineRefundRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderPayInfoRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderPayRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderRefundInfoRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderRefundRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderRequestRecordRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderSalesOrderRelationRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderSettlementRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderTicketCTMTAutoRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderTicketCTMTRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderTicketIssueRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderTicketPrintRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderTicketRTVTRequest;
import com.lvmama.lvf.common.dto.request.FlightPriceInfoRequest;
import com.lvmama.lvf.common.dto.request.FlightPriceInventoryRequest;
import com.lvmama.lvf.common.dto.request.FlightPricePolicyRequest;
import com.lvmama.lvf.common.dto.request.FlightSuppOrderQueryRequest;
import com.lvmama.lvf.common.dto.request.FlightTicketBSPDetailRequest;
import com.lvmama.lvf.common.dto.request.FlightTicketBSPStatisticsRequest;
import com.lvmama.lvf.common.dto.request.FlightTicketBSPStoreRequest;
import com.lvmama.lvf.common.dto.request.FlightTicketBSPStoreSearchRequest;
import com.lvmama.lvf.common.dto.request.NoticeInfoRequest;
import com.lvmama.lvf.common.dto.request.OpLogQueryRequest;
import com.lvmama.lvf.common.dto.request.SalesRuleDisableRequest;
import com.lvmama.lvf.common.dto.request.SalesRuleSourceRequest;
import com.lvmama.lvf.common.dto.request.SalesRuleSuppRequest;
import com.lvmama.lvf.common.dto.request.SettlementOrderRequest;
import com.lvmama.lvf.common.dto.request.SmsBatchSendRequest;
import com.lvmama.lvf.common.dto.request.SmsLogQueryRequest;
import com.lvmama.lvf.common.dto.request.SmsSendRequest;
import com.lvmama.lvf.common.dto.request.SuppBookingRequest;
import com.lvmama.lvf.common.dto.request.TaskConfigQueryRequest;
import com.lvmama.lvf.common.dto.request.ToSuppBookingRequest;
import com.lvmama.lvf.common.dto.request.VSTOrderRequest;
import com.lvmama.lvf.common.dto.response.FlightSeatPolicyResponse;
import com.lvmama.lvf.common.dto.sales.Sales;
import com.lvmama.lvf.common.dto.sales.SalesRuleDisableDto;
import com.lvmama.lvf.common.dto.sales.SalesRuleSourceDto;
import com.lvmama.lvf.common.dto.sales.SalesRuleSuppDto;
import com.lvmama.lvf.common.dto.schedule.TaskConfigDto;
import com.lvmama.lvf.common.dto.search.result.FlightSearchFlightInfoDto;
import com.lvmama.lvf.common.dto.search.result.FlightSearchTicketRuleSimpleDto;
import com.lvmama.lvf.common.dto.settlement.SettlementOrderDto;
import com.lvmama.lvf.common.dto.sms.SmsSendDto;
import com.lvmama.lvf.common.dto.status.OpSource;
import com.lvmama.lvf.common.dto.status.OpType;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderDto;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderMainDto;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderRefundDto;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderStatusDto;
import com.lvmama.lvf.common.dto.supp.FlightSupOrderDetailViewDto;
import com.lvmama.lvf.common.dto.supp.FlightSupOrderDto;
import com.lvmama.lvf.common.dto.supp.Supp;
import com.lvmama.lvf.common.dto.ticket.FlightTicketBSPDetailDelegate;
import com.lvmama.lvf.common.dto.ticket.FlightTicketBSPDetailDto;
import com.lvmama.lvf.common.dto.ticket.FlightTicketBSPDto;
import com.lvmama.lvf.common.dto.ticket.FlightTicketBSPStatisticsDto;
import com.lvmama.lvf.common.dto.ticket.FlightTicketBSPStorageDto;
import com.lvmama.lvf.common.dto.ticket.FlightTicketDetailDto;
import com.lvmama.lvf.common.dto.vst.FlightVstBasicFlightDto;
import com.lvmama.lvf.common.dto.vst.FlightVstGoodsDto;
import com.lvmama.lvf.common.dto.vst.FlightVstGoodsTimePriceDto;
import com.lvmama.lvf.common.dto.vst.FlightVstProductBranchDto;
import com.lvmama.lvf.common.dto.vst.FlightVstProductDto;
import com.lvmama.lvf.common.dto.vst.FlightVstTrafficFlightDto;
import com.lvmama.lvf.common.dto.vst.VSTSyncConfigDto;
import com.lvmama.lvf.common.dto.vst.VstTaskConfigDto;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.form.config.VSTTaskConfigRequestForm;
import com.lvmama.lvf.common.form.config.VSTTaskConfigResponseForm;
import com.lvmama.lvf.common.form.vst.VSTBasicFlightRequestForm;
import com.lvmama.lvf.common.form.vst.VSTGoodsTimePriceRequestForm;
import com.lvmama.lvf.common.form.vst.VSTProductBranchRequestForm;
import com.lvmama.lvf.common.form.vst.VSTTrafficFlightRequestForm;
import com.lvmama.lvf.common.trace.profile.Profile;
import com.lvmama.lvf.common.trace.profile.ProfilePoint;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvf.common.utils.StringUtil;

/**
 * 业务接口远程调用类
 * 
 * @author majun
 * @date 2015-1-29
 */
@Component
public class BusinessClient {

	/** 远程地址 */
	@Value("business.baseurl")
	private String baseUrl;
	
	/** 聚合服务基本Url */
	@Value("aggregate.baseurl")
	private String aggregateBaseurl;

	/** 远程服务 */
	@Autowired
	private RestClient restClient;
	
	public static final Logger logger=Logger.getLogger(BusinessClient.class);

//	/**
//	 * 预订验舱
//	 * @param bookingDetailRequest
//	 * @return
//	 */
//	public FlightBookingSeatInfoDto bookingVerifySeat(FlightOrderBookingDetailRequest bookingDetailRequest) {
//		BussinessClientPath command = BussinessClientPath.BOOKING_VERIFY_SEAT;
//		String url = command.url(baseUrl);
//		try {
//			return restClient.post(url, FlightBookingSeatInfoDto.class,bookingDetailRequest);
//		} catch (ExceptionWrapper ew) {
//			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
//			logger.error(ew.getErrMessage(),ew);
//			throw ew;
//		}
//	}
	/**
	 * 预订验价
	 * 
	 * @param bookingDetailRequest
	 *            预订明细请求对象
	 * @return FlightBookingPriceInfoDto 预订验价返回的价格信息
	 */
//	public BaseReponseHandleT<FlightBookingPriceInfoDto> bookingVerifyPrice(
//			FlightOrderBookingDetailRequest bookingDetailRequest) throws JsonParseException, JsonMappingException, IOException{
//		BussinessClientPath command = BussinessClientPath.BOOKING_VERIFY_PRICE;
//		String url = command.url(baseUrl);
//		try {
//			String resultString = restClient.post(url, String.class,
//					bookingDetailRequest);
//			return JSONMapper.getInstance().readValue(resultString,
//					new TypeReference<BaseReponseHandleT<FlightBookingPriceInfoDto>>() {
//					});
//
//		} catch (ExceptionWrapper ew) {
//			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
//			logger.error(ew.getErrMessage(),ew);
//			throw ew;
//		}
//	}

	/**
	 * 去预订
	 * 
	 * @param flightOrderBookingRequest
	 *            预订请求对象
	 * @return BaseResultDto 航班搜索信息结果信息Dto
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public BaseResultDto<FlightSearchFlightInfoDto> toBooking(
			FlightOrderBookingRequest flightOrderBookingRequest)
			throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.TO_BOOKING_NEW;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,
					flightOrderBookingRequest);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper
					.getInstance()
					.readValue(
							resultString,
							new TypeReference<BaseResultDto<FlightSearchFlightInfoDto>>() {
							});

		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 去预订
	 * 
	 * @param flightOrderBookingRequest
	 *            预订请求对象
	 * @return BaseResultDto 航班搜索信息结果信息Dto
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public BaseResultDto<FlightSearchFlightInfoDto> toBookingSimple(
			FlightOrderBookingRequest flightOrderBookingRequest)
			throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.TO_BOOKING_SIMPLE;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,
					flightOrderBookingRequest);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper
					.getInstance()
					.readValue(
							resultString,
							new TypeReference<BaseResultDto<FlightSearchFlightInfoDto>>() {
							});

		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	/**
	 * 预订
	 * 
	 * @param flightOrderBookingRequest
	 *            预订请求对象
	 * @return OrderMainDto 订单信息
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	public OrderMainDto booking(
			FlightOrderBookingRequest flightOrderBookingRequest) {
		BussinessClientPath command = BussinessClientPath.BOOKING_NEW;;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, OrderMainDto.class,
					flightOrderBookingRequest);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 预订
	 * 
	 * @param flightOrderBookingRequest
	 *            预订请求对象
	 * @return OrderMainDto 订单信息
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	public SuppResponse  bookingRebuild(
			FlightOrderBookingRequest flightOrderBookingRequest) {
		BussinessClientPath command = BussinessClientPath.BOOKING_REBUILD_NEW;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, SuppResponse.class,
					flightOrderBookingRequest);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 核对预定信息
	 * 
	 * @param id
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public OrderMainDto getBooking(String orderMainId) throws JsonParseException,
			JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.GET_BOOKING_ORDER_MAIN_BY_ID;
		String url = command.url(baseUrl, orderMainId);
		try {
			String resultString = restClient.get(url, String.class);
			return JSONMapper.getInstance().readValue(resultString,
					new TypeReference<OrderMainDto>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 根据航班号获取航班信息
	 * 
	 * @param no
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public FlightInfoDto getFlightInfo(String no,String depCityCode,String arrCityCode) throws JsonParseException,
			JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.GETFLIGHTINFOBYNO;
		String url = command.url(baseUrl,depCityCode,arrCityCode);
		try {

			String resultString = restClient.post(url, String.class, no);
			return JSONMapper.getInstance().readValue(resultString,
					new TypeReference<FlightInfoDto>() {
					});

		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 根据航班号获取航班信息
	 * 
	 * @param no
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public FlightInfoDto getFlightInfoByNo(String no,String depAirportCode,String arrAirportCode) throws JsonParseException,
			JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.GETFLIGHTINFOBYNOAIRPORT;
		String url = command.url(baseUrl,depAirportCode,arrAirportCode);
		try {

			String resultString = restClient.post(url, String.class, no);
			return JSONMapper.getInstance().readValue(resultString,
					new TypeReference<FlightInfoDto>() {
					});

		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 通过三字码查询城市信息
	 * 
	 * @param code
	 * @return
	 */
	public City getCityByCode(String code) {
		BussinessClientPath command = BussinessClientPath.GET_CITY;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, City.class, code);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	/**
	 * 获取城市列表（通过热度）
	 * @return
	 */
	public List<City> queryCitysByHot() {
		BussinessClientPath command = BussinessClientPath.QUERY_CITY_BY_HOT;
		String url = command.url(baseUrl);
		try {
			
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonResult = restClient.post(url, String.class);
			return objectMapper.readValue(jsonResult,
					new TypeReference<List<City>>() {
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
	 * 查询待打印行程单
	 * 
	 * @param orderTicketPrintRequest
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public BaseResultDto<FlightTicketBSPDto> queryPrintTicket(
			FlightOrderTicketPrintRequest orderTicketPrintRequest) {
		BussinessClientPath command = BussinessClientPath.QUERY_PRINT_TICKET;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, BaseResultDto.class,
					orderTicketPrintRequest);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	public BaseResultDto<FlightOrderListDto> queryOrderList(BaseQueryDto<FlightCommonQueryRequest> baseQueryDto) 
	{
		return queryOrderList(baseQueryDto,OpType.NULL);
	}
	
	public Integer queryOrderListCount(BaseQueryDto<FlightCommonQueryRequest> baseQueryDto){
		BussinessClientPath command = BussinessClientPath.QUERY_ORDER_LIST_COUNT;
		String url = command.url(baseUrl);
		try 
		{
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,new TypeReference<Integer>(){});
		} 
		catch (ExceptionWrapper ew) 
		{
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
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
	 * 查询订单列表
	 * @param  baseQueryDto 	查询对象
	 * @return BaseResultDto<FlightOrderListResultDto> 订单列表查询结果对象
	 */
	public BaseResultDto<FlightOrderListDto> queryOrderList(BaseQueryDto<FlightCommonQueryRequest> baseQueryDto, OpType opType) 
	{
		BussinessClientPath command = BussinessClientPath.QUERY_ORDER_LIST_WITH_OPTYPE;
		String url = command.url(baseUrl,opType);
		try 
		{
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,new TypeReference<BaseResultDto<FlightOrderListDto>>(){});
		} 
		catch (ExceptionWrapper ew) 
		{
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
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
	 * xm
	 * 查询航班供应商订单列表
	 */
    public BaseResultDto<FlightSupOrderDto> queryFlightSuppOrder(
            BaseQueryDto<FlightSuppOrderQueryRequest> baseQueryDto) throws JsonParseException,
            JsonMappingException, IOException {
    	BussinessClientPath command = BussinessClientPath.QUERY_SUPP_ORDER_LIST;
        String url = command.url(baseUrl);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
            String jsonResult = restClient.post(url, String.class, jsonRequest);
            return objectMapper.readValue(jsonResult,
                    new TypeReference<BaseResultDto<FlightSupOrderDto>>() {
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
     * 查询航班供应商订单详情
     */
    public FlightSupOrderDetailViewDto querySuppOrderDetail(Long orderId) {
		BussinessClientPath command = BussinessClientPath.QUERY_SUPP_ORDER_DETAIL;
		String url = command.url(baseUrl, orderId);
		try {
			return restClient.get(url, FlightSupOrderDetailViewDto.class);
		}  catch (ExceptionWrapper ew) {
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
	 * 查询订单列表(导出)
	 * @param baseQueryDto
	 * @return
	 */
	public List<String> queryOrderListOfExport(BaseQueryDto<FlightCommonQueryRequest> baseQueryDto)
	{
		BussinessClientPath command = BussinessClientPath.QUERY_ORDER_LIST_OF_EXPORT;
		String url = command.url(baseUrl);
		try 
		{
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult, new TypeReference<List<String>>() {
			});
		} 
		catch (Exception e) 
		{
			ExceptionWrapper ew = new ExceptionWrapper();
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**
	 * api緩存配置列表
	 * @param request
	 * @return
	 */
	public BaseResultDto<ApiCacheConfigDto> queryApiCacheConfigList(BaseQueryDto<ApiCacheConfigRequest>  baseQueryDto) {
		BussinessClientPath command = BussinessClientPath.API_CACHE_CONFIG_LIST;
		String url = command.url(baseUrl);
		try {

			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<BaseResultDto<ApiCacheConfigDto>>() {
					});
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
	 * 添加缓存配置信息
	 * 
	 * @param apiCacheConfigRequest
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	public BaseReponseHandleT<ApiCacheConfigDto> insertApiCacheConfig(ApiCacheConfigRequest apiCacheConfigRequest)
			throws JsonGenerationException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.INSERT_API_CACHE_CONFIG;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,apiCacheConfigRequest);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper
					.getInstance()
					.readValue(resultString, new TypeReference<BaseReponseHandleT<ApiCacheConfigDto>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**
	 * 删除缓存配置信息
	 * 
	 * @param apiCacheConfigRequest
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	public BaseReponseHandleT<ApiCacheConfigDto> batchDeleteApiCacheConfig(ApiCacheConfigRequest apiCacheConfigRequest)
			throws JsonGenerationException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.BATCH_REMOVE_API_CACHE_CONFIG;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,apiCacheConfigRequest);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper
					.getInstance()
					.readValue(resultString,new TypeReference<BaseReponseHandleT<ApiCacheConfigDto>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 更新缓存配置有效期限制
	 * 
	 * @param request
	 * @return
	 */
	public ApiCacheConfigDto updateApiCacheConfig(ApiCacheConfigRequest apiCacheConfigRequest) {
		BussinessClientPath command = BussinessClientPath.UPDATE_API_CACHE_CONFIG;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, ApiCacheConfigDto.class, apiCacheConfigRequest);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	/**
	 * 任务配置列表
	 * @param baseQueryDto
	 * @return
	 */
	public BaseResultDto<TaskConfigDto> queryTaskConfigList(BaseQueryDto<TaskConfigQueryRequest>  baseQueryDto) {
		BussinessClientPath command = BussinessClientPath.TASK_CONFIG_LIST;
		String url = command.url(baseUrl);
		try {
			
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<BaseResultDto<TaskConfigDto>>() {
					});
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
	 * saveUpdate任务配置
	 * @param baseQueryDto
	 * @return
	 */
	public Boolean saveUpdateTaskConfig(
			TaskConfigDto taskConfigDto) {
		BussinessClientPath command = BussinessClientPath.TASK_CONFIG_SAVE;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, Boolean.class, taskConfigDto);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	/**
	 * delete任务配置
	 * @param baseQueryDto
	 * @return
	 */
	public Boolean deleteTaskConfig(
			String id) {
		BussinessClientPath command = BussinessClientPath.TASK_CONFIG_DELETE;
		String url = command.url(baseUrl,id);
		try {
			return restClient.post(url, Boolean.class);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	public TaskConfigDto loadTaskConfig(
			String id) {
		BussinessClientPath command = BussinessClientPath.TASK_CONFIG_LOAD;
		String url = command.url(baseUrl,id);
		try {
			return restClient.post(url, TaskConfigDto.class);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * order快递列表
	 * @param baseQueryDto
	 * @return
	 */
	public BaseResultDto<FlightOrderExpressListDto> queryOrderExprssList(BaseQueryDto<FlightOrderExpressQueryRequest>  baseQueryDto) {
		BussinessClientPath command = BussinessClientPath.QUERY_ORDER_EXPRESS_LIST;
		String url = command.url(baseUrl);
		try {
			
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<BaseResultDto<FlightOrderExpressListDto>>() {
					});
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
	 * saveUpdate orderExpress
	 * @param baseQueryDto
	 * @return
	 */
	public Boolean saveUpdateFlightOrderExpress(
			FlightOrderExpressDto flightOrderExpressDto) {
		BussinessClientPath command = BussinessClientPath.ORDER_EXPRESS_SAVE;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, Boolean.class, flightOrderExpressDto);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	public FlightOrderExpressDto loadFlightOrderExpress(
			String id) {
		BussinessClientPath command = BussinessClientPath.ORDER_EXPRESS_LOAD;
		String url = command.url(baseUrl,id);
		try {
			return restClient.post(url, FlightOrderExpressDto.class);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	
	/**
	 * 流量统计列表
	 * @param request
	 * @return
	 */
	public BaseResultDto<ApiFlowDto> queryApiFlowList(BaseQueryDto<ApiFlowQueryRequest>  baseQueryDto) {
		BussinessClientPath command = BussinessClientPath.API_FLOW_LIST;
		String url = command.url(baseUrl);
		try {

			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<BaseResultDto<ApiFlowDto>>() {
					});
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
	 *流量统计count
	 * @param baseQueryDto
	 * @return
 	*/
	public BaseResultDto<ApiFlowCountDto> queryApiFlowListCount(BaseQueryDto<ApiFlowQueryRequest>  baseQueryDto) {
		BussinessClientPath command = BussinessClientPath.API_FLOW_LIST_COUNT;
		String url = command.url(baseUrl);
		try {
		
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
				new TypeReference<BaseResultDto<ApiFlowCountDto>>() {
			});
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
	 * 流量统计列表CSV
	 * @param request
	 * @return
	 */
	public BaseResultDto<ApiFlowDto> queryApiFlowListCsv(BaseQueryDto<ApiFlowQueryRequest>  baseQueryDto) {
		BussinessClientPath command = BussinessClientPath.API_FLOW_LIST_CSV;
		String url = command.url(baseUrl);
		try {

			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<BaseResultDto<ApiFlowDto>>() {
					});
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
	 * 查询预定订单列H5
	 * 
	 * @param baseQueryDto
	 *            查询对象
	 * @return BaseResultDto<FlightOrderListResultDto> 订单列表查询结果对象
	 */
	@ProfilePoint(Profile.OPENAPI_QUERY_BOOKING_ORDER_LIST)
	public BaseResultDto<FlightOrderListDto> queryBookingOrderList(
			BaseQueryDto<FlightCommonQueryRequest> baseQueryDto) {
		BussinessClientPath command = BussinessClientPath.QUERY_BOOKING_ORDER_LIST;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<BaseResultDto<FlightOrderListDto>>() {
					});
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
	 * 根据订单修改请求修改订单联系人的信息
	 * @param flightOrderModifyRequest
	 * @return
	 */
	public FlightOrderContacterDto modifyOrderContacter(FlightOrderModifyRequest flightOrderModifyRequest) 
	{
		BussinessClientPath command = BussinessClientPath.MODIFY_ORDER_CONTACTER;
		String url = command.url(baseUrl);
		try 
		{
			return restClient.post(url, FlightOrderContacterDto.class, flightOrderModifyRequest);
		} 
		catch (ExceptionWrapper ew) 
		{
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}

	}

	/**
	 * 根据订单修改请求修改订单快递信息
	 * @param flightOrderModifyRequest 订单修改请求
	 * @return 航班订单信息
	 */
	public FlightOrderExpressDto modifyOrderExpress(FlightOrderModifyRequest flightOrderModifyRequest) 
	{
		BussinessClientPath command = BussinessClientPath.MODIFY_ORDER_EXPRESS;
		String url = command.url(baseUrl);
		try 
		{
			return restClient.post(url, FlightOrderExpressDto.class,
					flightOrderModifyRequest);
		} 
		catch (ExceptionWrapper ew) 
		{
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 可用快递列表
	 * 
	 * @param reqeust
	 * @return
	 */
	public List<ExpressWay> queryFlightExpressList() {
		BussinessClientPath command = BussinessClientPath.QUERY_EXPRESS_LIST;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonResult = restClient.post(url, String.class);
			return objectMapper.readValue(jsonResult,
					new TypeReference<List<ExpressWay>>() {
					});
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
	 * 取消订单
	 * 
	 * @param dto
	 * @return
	 */
	public ResultStatus cancelOrder(FlightOrderCancelRequest request) {
		BussinessClientPath command = BussinessClientPath.CANCEL_ORDER;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, ResultStatus.class, request);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	public ResultStatus eiditOrderLimitTime(FlightOrderCancelRequest request) {
		BussinessClientPath command = BussinessClientPath.EDIT_ORDER_LIMITTIME;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, ResultStatus.class, request);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 订单退废票申请
	 * @param 	auditOpDto 						审核操作对象
	 * @return 	FlightOrderTicketRTVTRequest	退废票请求对象
	 * @throws 	Exception 
	 */
	public FlightOrderTicketRTVTRequest orderTicketRTVTApply(AuditOpDto<FlightOrderTicketRTVTRequest> auditOpDto) throws Exception 
	{
		BussinessClientPath command = BussinessClientPath.ORDER_APPLY;
		String url = command.url(baseUrl, AuditType.TICKET_RTVT);
		try 
		{
			String json = JSONMapper.getInstance().writeValueAsString(auditOpDto);
			return restClient.post(url, FlightOrderTicketRTVTRequest.class, json);
		} 
		catch(ExceptionWrapper ew)
		{
			throw ew;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	/**
	 * 订单退废票审核
	 * 
	 * @param auditOpDto
	 *            退废票请求对象
	 * @return ResultStatus
	 */
	public ResultStatus orderTicketRTVTAudit(
			AuditOpDto<FlightOrderTicketRTVTRequest> auditOpDto) {
		BussinessClientPath command = BussinessClientPath.ORDER_AUDIT;
		String url = command.url(baseUrl, AuditType.TICKET_RTVT);
		try {
			String json = JSONMapper.getInstance().writeValueAsString(auditOpDto);
			return restClient.post(url, ResultStatus.class, json);
		} catch (ExceptionWrapper ew) {
			throw ew;
		} catch (Exception e) {
			return ResultStatus.FAIL;
		}
	}
	
	/**
	 * 申请供应商退废票
	 * @param 	orderId			订单主键
	 * @return	ResultStatus	结果状态
	 */
	public ResultStatus applySuppRTVT(Long orderId)
	{
		BussinessClientPath command = BussinessClientPath.APPLY_SUPP_RTVT;
		String url = command.url(baseUrl, orderId);
		return restClient.get(url, ResultStatus.class);
	}

	/**
	 * 订单退废票处理
	 * 
	 * @param auditOpDto
	 *            退废票请求对象
	 * @return ResultStatus
	 */
	public ResultStatus orderTicketRTVTOp(
			AuditOpDto<FlightOrderTicketRTVTRequest> auditOpDto) {
		BussinessClientPath command = BussinessClientPath.ORDER_OPERATION;
		String url = command.url(baseUrl, AuditType.TICKET_RTVT);
		try {
			String json = JSONMapper.getInstance().writeValueAsString(auditOpDto);
			return restClient.post(url, ResultStatus.class, json);
		} catch (ExceptionWrapper ew) {
			throw ew;
		} catch (Exception e) {
			return ResultStatus.FAIL;
		}
	}

	/**
	 * 订单改期改签申请
	 * 
	 * @param auditOpDto
	 *            改期改签请求对象
	 * @return 返回符合的数据
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public FlightOrderTicketCTMTRequest orderDetailCTMTApply(AuditOpDto<FlightOrderTicketCTMTRequest> auditOpDto)
			throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.ORDER_APPLY;
		String url = command.url(baseUrl, AuditType.TICKET_CTMT);
		try {
			String resultString = JSONMapper.getInstance().writeValueAsString(auditOpDto);
			return restClient.post(url, FlightOrderTicketCTMTRequest.class, resultString);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 订单改期改签审核
	 * 
	 * @param auditOpDto
	 *            改签请求对象
	 * @return 返回符合的数据
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public ResultStatus orderDetailCTMTAudit(
			AuditOpDto<FlightOrderTicketCTMTRequest> auditOpDto)
			throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.ORDER_AUDIT;
		String url = command.url(baseUrl, AuditType.TICKET_CTMT);
		try {
			String resultString = JSONMapper.getInstance()
					.writeValueAsString(auditOpDto);
			return restClient.post(url, ResultStatus.class, resultString);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 订单改期改签处理
	 * 
	 * @param auditOpDto
	 *            改签请求对象
	 * @return 返回符合的数据
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public ResultStatus orderDetailCTMTOperate(
			AuditOpDto<FlightOrderTicketCTMTRequest> auditOpDto)
			throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.ORDER_OPERATION;
		String url = command.url(baseUrl, AuditType.TICKET_CTMT);
		try {
			String resultString = JSONMapper.getInstance()
					.writeValueAsString(auditOpDto);
			return restClient.post(url, ResultStatus.class, resultString);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 保存申请信息
	 * 
	 * @param request
	 * @return
	 */
	public ResultStatus saveTicketIssueApplyInfo(
			AuditOpDto<FlightOrderTicketIssueRequest> request)
			throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.ORDER_APPLY;
		String url = command.url(baseUrl, AuditType.TICKET_ISSUE);
		try {
			String resultString = JSONMapper.getInstance()
					.writeValueAsString(request);
			return restClient.post(url, ResultStatus.class, resultString);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 保存审核信息
	 * 
	 * @param request
	 * @return
	 */
	public ResultStatus saveTicketIssueAuditInfo(
			AuditOpDto<FlightOrderTicketIssueRequest> request)
			throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.ORDER_AUDIT;
		String url = command.url(baseUrl, AuditType.TICKET_ISSUE);
		try {
			String resultString = JSONMapper.getInstance()
					.writeValueAsString(request);
			return restClient.post(url, ResultStatus.class, resultString);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 保存处理信息
	 * 
	 * @param request
	 * @return
	 */
	public ResultStatus saveTicketIssueOpInfo(
			AuditOpDto<FlightOrderTicketIssueRequest> request)
			throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.ORDER_OPERATION;
		String url = command.url(baseUrl, AuditType.TICKET_ISSUE);
		try {
			String resultString = JSONMapper.getInstance()
					.writeValueAsString(request);
			return restClient.post(url, ResultStatus.class, resultString);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 订单相关金额计算
	 * 
	 * @param request
	 * @return
	 */
	public AmountCalculatorDto amountCalculate(AmountCalculatorRequest request) {
		BussinessClientPath command = BussinessClientPath.AMOUNT_CALCULATE;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, AmountCalculatorDto.class, request);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 修改快递后金额计算
	 * 
	 * @param request
	 * @return
	 */
	public AmountCalculatorDto modifyExpressCalculate(ExpressInfoRequest request) {
		BussinessClientPath command = BussinessClientPath.MODIFY_EXPRESS_CALCULATE;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, AmountCalculatorDto.class, request);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 按照乘客类型区分出金额信息
	 * 
	 * @param request
	 * @return
	 */
	public List<BookingPassengerTypeAndAmountDto> amountDetailCalculate(
			AmountCalculatorDto request) {
		BussinessClientPath command = BussinessClientPath.BUILD_AMOUNT_DETAIL;
		String url = command.url(baseUrl);
		List<BookingPassengerTypeAndAmountDto> typeAmounts = null;
		try {
			String str = restClient.post(url, String.class, request);

			typeAmounts = JSONMapper
					.getInstance()
					.readValue(
							str,
							new TypeReference<List<BookingPassengerTypeAndAmountDto>>() {
							});
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return typeAmounts;
	}

	/**
	 * 根据订单Id查询订单详情
	 * 
	 * @return
	 */
	public FlightOrderDto getOrderDetailInfoById(Long orderId) {
		BussinessClientPath command = BussinessClientPath.GET_ORDER_BY_ORDER_ID;
		String url = command.url(baseUrl, orderId);
		try {
			return restClient.post(url, FlightOrderDto.class);

		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}


	/**
	 * 根据订单id删除订单
	 * 
	 * @return
	 */
	public Boolean deleteOrderById(Long orderId) {
		BussinessClientPath command = BussinessClientPath.DELETE_ORDER_BY_ORDER_ID;
		String url = command.url(baseUrl, orderId);
		try {
			return restClient.post(url, Boolean.class);

		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}



	/**
	 * 根据订单Id查询相关订单
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<FlightOrderLinkInfoDto> getOrderLinkInfosByOrderId(Long orderId) {
		BussinessClientPath command = BussinessClientPath.GET_ORDER_LINK_INFOS_BY_ORDER_ID;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, ArrayList.class, orderId);

		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 查找行程单入库记录
	 * 
	 * @param requestBaseQueryDto
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseResultDto<FlightTicketBSPStorageDto> queryTicketBSPStorages(
			BaseQueryDto<FlightTicketBSPStoreSearchRequest> requestBaseQueryDto)
			throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.QUERY_TICKET_BSP_STORAGE;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper
					.writeValueAsString(requestBaseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper
					.readValue(
							jsonResult,
							new TypeReference<BaseResultDto<FlightTicketBSPStorageDto>>() {
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
	 * 保存行程单入库信息
	 * 
	 * @param ticketBSPStoreRequest
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	public BaseReponseHandleT<FlightTicketBSPStorageDto> insertTicketBSPStorage(
			FlightTicketBSPStoreRequest ticketBSPStoreRequest)
			throws JsonGenerationException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.INSERT_TICKET_BSP_STORAGE;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,ticketBSPStoreRequest);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper
					.getInstance()
					.readValue(
							resultString,
							new TypeReference<BaseReponseHandleT<FlightTicketBSPStorageDto>>() {
							});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 更新行程单入库信息
	 * 
	 * @param ticketBSPStoreRequest
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	public FlightTicketBSPStorageDto updateTicketBSPStorageStatus(
			FlightTicketBSPStoreRequest ticketBSPStoreRequest)
			throws JsonGenerationException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.UPDATE_TICKET_BSP_STORAGE_STATUS;
		String url = command.url(baseUrl);
		try {
			String resultString = JSONMapper.getInstance()
					.writeValueAsString(ticketBSPStoreRequest);
			return restClient.post(url, FlightTicketBSPStorageDto.class,
					resultString);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 查询行程单明细信息
	 * 
	 * @param requestBaseQueryDto
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseResultDto<FlightTicketBSPDetailDelegate> queryTicketBSPDetail(
			BaseQueryDto<FlightTicketBSPDetailRequest> requestBaseQueryDto)
			throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.QUERY_TICKET_BSPDETAIL;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(requestBaseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper
					.readValue(
							jsonResult,
							new TypeReference<BaseResultDto<FlightTicketBSPDetailDelegate>>() {
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
	 *  通过订单号查询出所有关联票号信息和pnr
	 * 
	 * @param requestBaseQueryDto
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseResultDto<FlightTicketBSPDetailDelegate> queryBspTickInfoByOrderNoAjax(
			FlightTicketBSPDetailRequest ticketBSPDetailRequest)
			throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.QUERY_BSPDETAIL_TICKINFO_BY_ORDERNO;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, ticketBSPDetailRequest);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResultDto<FlightTicketBSPDetailDelegate>>() {
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
	 * 更新行程单的操作状态
	 * 
	 * @param FlightTicketBSPDetailDto
	 * @return
	 */
	public FlightTicketBSPDetailDto updateTicketBSPDetailStatus(
			FlightTicketBSPDetailRequest ticketBSPDetailRequest) {
		BussinessClientPath command = BussinessClientPath.UPDATE_TICKET_BSPDETAIL_STATUS;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, FlightTicketBSPDetailDto.class,
					ticketBSPDetailRequest);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	
	/**
	 * 更新行程单的操作状态
	 * 
	 * @param FlightTicketBSPDetailDto
	 * @return
	 */
	public FlightTicketBSPDetailDto updateBspStatusUnused(
			FlightTicketBSPDetailRequest ticketBSPDetailRequest) {
		BussinessClientPath command = BussinessClientPath.UPDATE_BSP_STATUS_UNUSED;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, FlightTicketBSPDetailDto.class,
					ticketBSPDetailRequest);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	
	/**
	 * 取消作废
	 * 
	 * @param FlightTicketBSPDetailDto
	 * @return
	 */
	public FlightTicketBSPDetailDto updateBspStatusCancelInvalid(FlightTicketBSPDetailRequest ticketBSPDetailRequest) {
		BussinessClientPath command = BussinessClientPath.UPDATE_BSP_STATUS_CANCEL_INVALID;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, FlightTicketBSPDetailDto.class,
					ticketBSPDetailRequest);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 验证行程单所对应票号信息
	 * 
	 * @param FlightTicketBSPDetailDto
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public BaseReponseHandleT<FlightTicketBSPDetailDto> validateBspDetailTicketNo(
			FlightTicketBSPDetailRequest ticketBSPDetailRequest) throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.VALIDATE_BSPDETAIL_TICKETNO;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, ticketBSPDetailRequest);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseReponseHandleT<FlightTicketBSPDetailDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 查询统计行程单信息
	 * 
	 * @param requestBaseQueryDto
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseResultDto<FlightTicketBSPStatisticsDto> queryFlightTicketBSPStatistics(
			BaseQueryDto<FlightTicketBSPStatisticsRequest> requestBaseQueryDto)
			throws JsonParseException, JsonMappingException, IOException {

		BussinessClientPath command = BussinessClientPath.QUERY_TICKET_BSP_STATISTICS;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper
					.writeValueAsString(requestBaseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper
					.readValue(
							jsonResult,
							new TypeReference<BaseResultDto<FlightTicketBSPStatisticsDto>>() {
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
	 * 行程单的操作日志
	 * 
	 * @param FlightTicketBSPDetailDto
	 * @return
	 */
	public FlightTicketBSPDetailDto operBSPDetailLog(
			FlightTicketBSPDetailRequest ticketBSPDetailRequest) {
		BussinessClientPath command = BussinessClientPath.OPER_TICKET_BSPNO_LOG;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, FlightTicketBSPDetailDto.class,
					ticketBSPDetailRequest);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 加载office配置信息
	 * 
	 * @return
	 */
	public List<FlightOfficeDto> loadOffice() throws IOException {
		BussinessClientPath command = BussinessClientPath.LOAD_OFFICE;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class);
			if (StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,
					new TypeReference<List<FlightOfficeDto>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 人工出票
	 */
	@SuppressWarnings("unchecked")
	public List<FlightOrderDetailDto> ticketIssueOp(
			FlightOrderTicketIssueRequest request) {
		BussinessClientPath command = BussinessClientPath.TICKET_ISSUE_OPERATION;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, List.class, request);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 查询出票改签退票审核/处理列表
	 * 
	 * @param request
	 * @return BaseResultDto<FlightOrderAuditOpDto>
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseResultDto<FlightOrderAuditOpDto> queryAuditOpList(
			BaseQueryDto<FlightOrderAuditOpRequest> request)
			throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.QUERY_AUDIT_OP_LIST;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(request);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<BaseResultDto<FlightOrderAuditOpDto>>() {
					});
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 查询渠道列表
	 * 
	 * @param baseQueryDto
	 *            查询对象
	 * @return BaseResultDto<Sales> 渠道列表查询结果对象
	 */
	public BaseResultDto<Sales> querySalesList(BaseQueryDto<Sales> baseQueryDto) {
		BussinessClientPath command = BussinessClientPath.QUERY_SALES;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<BaseResultDto<Sales>>() {
					});
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
	 * 保存订单备注信息
	 * 
	 * @param request
	 * @return
	 */
	public ResultStatus addFlightOrderRemark(FlightOrderRemarkDto orderRemarkDto) {
		BussinessClientPath command = BussinessClientPath.ADD_ORDER_REMARK;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, ResultStatus.class, orderRemarkDto);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 查询订单备注列表
	 * 
	 * @param baseQueryDto
	 *            查询对象
	 * @return BaseResultDto<FlightOrderRemarkDto> 渠道列表查询结果对象
	 */
	public BaseResultDto<FlightOrderRemarkDto> queryOrderRemarkList(
			BaseQueryDto<FlightOrderRemarkDto> baseQueryDto) {
		BussinessClientPath command = BussinessClientPath.QUERY_ORDER_REMARK_LIST;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<BaseResultDto<FlightOrderRemarkDto>>() {
					});
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
	 * 查询订单PNR文本信息
	 * @param orderId 
	 * @return List<FlightOrderPNRInfoDto> 
	 */
	public List<FlightOrderPNRInfoDto> queryOrderPnrByOrderId(Long orderId) {
		BussinessClientPath command = BussinessClientPath.QUERY_ORDER_PNR;
		String url = command.url(baseUrl);
		try {
			String result = restClient.post(url, String.class, orderId);
			return JSONMapper.getInstance().readValue(result, new TypeReference<List<FlightOrderPNRInfoDto>>() {
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
	 * 保存订单PNR文本信息
	 * 
	 * @param flightOrderPNRInfoDto
	 * @return ResultStatus
	 */
	public ResultStatus savePnrText(FlightOrderPNRInfoDto flightOrderPNRInfoDto) {
		BussinessClientPath command = BussinessClientPath.SAVE_ORDER_PNR;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, ResultStatus.class, flightOrderPNRInfoDto);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	/**
	 * 查询订单详情视图信息
	 * 
	 * @param orderMainId
	 *            主订单主键
	 * @param orderId
	 *            订单主键
	 * @param opSource
	 *            操作源
	 * @return FlightOrderDetailViewDto 订单详情视图信息
	 */
	public FlightOrderDetailViewDto queryOrderDetailView(Long orderMainId,
			Long orderId, OpSource opSource, OpType opType) {
		BussinessClientPath command = BussinessClientPath.QUERY_ORDER_DETAIL_VIEW;
		String url = command.url(baseUrl, orderMainId, orderId, opSource,
				opType);
		try {
			return restClient.get(url, FlightOrderDetailViewDto.class);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	/**
	 * 根据子订单号拿订单详情
	 */
	public FlightOrderDetailViewDto queryOrderDetailViewByOrderNo(String orderNo, OpSource opSource, OpType opType) {
		BussinessClientPath command = BussinessClientPath.QUERY_ORDER_DETAIL_VIEW_BY_ORDERNO;
		String url = command.url(baseUrl,orderNo , opSource,opType);
		try {
			logger.error("=cpsOrderDetail=url:"+url);
			return restClient.get(url, FlightOrderDetailViewDto.class);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 查询订单详情视图信息包含乘客详细信息
	 *
	 * @param orderMainId
	 *            主订单主键
	 * @param orderId
	 *            订单主键
	 * @param opSource
	 *            操作源
	 * @return FlightOrderPassengerDetailViewDto 订单详情视图信息,包含乘客详细信息
	 */
	public FlightOrderPassengerDetailViewDto queryOrderPassengerDetailView(Long orderMainId,
														 Long orderId, OpSource opSource, OpType opType) {
		BussinessClientPath command = BussinessClientPath.QUERY_ORDER_PASSENGER_DETAIL_VIEW;
		String url = command.url(baseUrl, orderMainId, orderId, opSource,
				opType);
		try {
			FlightOrderDetailViewDto flightOrderDetailViewDto = restClient.get(url, FlightOrderDetailViewDto.class);
			FlightOrderPassengerDetailViewDto flightOrderPassengerDetailViewDto = new FlightOrderPassengerDetailViewDto(flightOrderDetailViewDto);
			flightOrderPassengerDetailViewDto.setFlightOrderPassengerDetailRelations((List) flightOrderDetailViewDto.getFlightOrderDetailRelations());
			flightOrderPassengerDetailViewDto.setSameOrderPassengerDetailRelations((List) flightOrderDetailViewDto.getSameOrderDetailRelations());
			return flightOrderPassengerDetailViewDto;
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 查询订单详情视图信息byId
	 * 
	 * @param orderId
	 *            订单主键
	 * @param opSource
	 *            操作源
	 * @return FlightOrderDetailViewDto 订单详情视图信息
	 */
	public FlightOrderDetailViewDto queryOrderDetailViewById(Long orderId, OpSource opSource, OpType opType) {
		BussinessClientPath command = BussinessClientPath.QUERY_ORDER_DETAIL_VIEW_BY_ID;
		String url = command.url(baseUrl, orderId, opSource, opType);
		try {
			return restClient.get(url, FlightOrderDetailViewDto.class);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 查询订单详情视图信息byId, 包含详细乘客信息
	 *
	 * @param orderId
	 *            订单主键
	 * @param opSource
	 *            操作源
	 * @return FlightOrderPassengerDetailViewDto 订单详情视图信息
	 */
	public FlightOrderPassengerDetailViewDto queryOrderPassengerDetailViewById(Long orderId, OpSource opSource, OpType opType) {
		BussinessClientPath command = BussinessClientPath.QUERY_ORDER_PASSENGER_DETAIL_VIEW_BY_ID;
		String url = command.url(baseUrl, orderId, opSource, opType);
		try {
			FlightOrderDetailViewDto flightOrderDetailViewDto = restClient.get(url, FlightOrderDetailViewDto.class);
			FlightOrderPassengerDetailViewDto flightOrderPassengerDetailViewDto = new FlightOrderPassengerDetailViewDto(flightOrderDetailViewDto);
			flightOrderPassengerDetailViewDto.setFlightOrderPassengerDetailRelations((List) flightOrderDetailViewDto.getFlightOrderDetailRelations());
			flightOrderPassengerDetailViewDto.setSameOrderPassengerDetailRelations((List) flightOrderDetailViewDto.getSameOrderDetailRelations());
			return flightOrderPassengerDetailViewDto;
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 查询订单详情明细信息
	 * 
	 * @param orderMainId
	 *            主订单主键
	 * @param orderId
	 *            订单主键
	 * @return FlightOrderDetailInfoDto 订单详情明细信息
	 */
	public FlightOrderDetailInfoDto queryOrderDetailInfo(Long orderMainId,
			Long orderId) {
		BussinessClientPath command = BussinessClientPath.QUERY_ORDER_DETAIL_INFO;
		String url = command.url(baseUrl, orderMainId, orderId);
		try {
			return restClient.get(url, FlightOrderDetailInfoDto.class);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 查询客票明细列表
	 * 
	 * @param baseQueryDto
	 *            查询对象
	 * @return BaseResultDto<FlightTicketListResultDto> 订单列表查询结果对象
	 */
	public BaseResultDto<FlightTicketDetailDto> queryFlightTicketDetails(
			BaseQueryDto<FlightCommonQueryRequest> baseQueryDto) {
		BussinessClientPath command = BussinessClientPath.QUERY_TICKET_DETAIL_LIST;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance().setVisibility(
					JsonMethod.FIELD, Visibility.ANY);
			objectMapper.configure(
					DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			if(StringUtil.isEmptyString(jsonResult)) {
				return null;
			}
			return objectMapper.readValue(jsonResult,
					new TypeReference<BaseResultDto<FlightTicketDetailDto>>() {
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
	 * 查询客票明细列表(导出)
	 * @param baseQueryDto
	 * @return
	 */
	public List<String> queryTicketDetailListOfExport(BaseQueryDto<FlightCommonQueryRequest> baseQueryDto)
	{
		BussinessClientPath command = BussinessClientPath.QUERY_TICKET_DETAIL_LIST_OF_EXPORT;
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
	
	/**
	 * 根据vst平台机票子订单Id查询机票系统主订单信息
	 * 
	 * @param vstFlightOrderId
	 * @return
	 */
	public OrderMainDto getOrderMainByVstFlightOrderId(Long vstFlightOrderId) {
		BussinessClientPath command = BussinessClientPath.GET_ORDER_MAIN_BY_VST_FLIGHT_ORDER_ID;
		String url = command.url(baseUrl, vstFlightOrderId);
		try {
			return restClient.get(url, OrderMainDto.class);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 后台线上退款，保存退款信息
	 * 
	 * @param request
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseReponseHandleT<FlightOrderRefundDto> saveOrderOnlineRefundInfo(FlightOrderRefundInfoRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.SAVE_ORDER_ONLINE_REFUND_INFO;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, request);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseReponseHandleT<FlightOrderRefundDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 后台线下退款，保存退款信息
	 * 
	 * @param request
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseReponseHandleT<FlightOrderRefundDto> saveOrderOfflineRefundInfo(FlightOrderOfflineRefundRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.SAVE_ORDER_OFFLINE_REFUND_INFO;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, request);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseReponseHandleT<FlightOrderRefundDto>>() {
			});
		}catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 后台线下退款，查询对应的退款结果信息
	 * 
	 * @param request
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseResultDto<FlightOrderRefundDto> searchOrderRefundInfo(FlightOrderRefundRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.QUERY_ORDER_REFUND_INFO;
		String url = command.url(baseUrl);
		try {
			String jsonResult = restClient.post(url, String.class, request);
			if(StringUtil.isEmptyString(jsonResult)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(jsonResult, new TypeReference<BaseResultDto<FlightOrderRefundDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 退款回调，回填成功/失败的信息到订单上并更新订单退款信息表中的数据(更新退款信息表)
	 * 
	 * @param request
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseReponseHandleT<FlightOrderRefundDto> refundCallBack(FlightOrderRefundRequest request) throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.REFUND_CALLBACK;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, request);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseReponseHandleT<FlightOrderRefundDto>>() {
			});
		}catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	
	
	
	/**
	 * 落地并保存退款信息(新建退款信息表)
	 * 
	 * @param request
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseResultDto<FlightOrderRefundDto> toRefund(FlightOrderRefundRequest request) throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.TO_REFUND;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, request);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResultDto<FlightOrderRefundDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	
	
	/**
	 * 落地并保存退款信息(新建退款信息表)
	 * 
	 * @param request
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseResultDto<FlightOrderRefundDto> refund(FlightOrderRefundRequest request) throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.REFUND;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, request);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResultDto<FlightOrderRefundDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	

	/**
	 *  更新退款状态为解冻（解锁）
	 * @param request
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseReponseHandle updateRefundStatus(FlightOrderRefundRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.UPDATE_REFUND_STATUS;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, request);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseReponseHandle>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	
	public BaseResultDto<FlightOrderPaymentDto> queryPayments(BaseQueryDto<FlightOrderOfflinePayRequest> requestBaseQueryDto) throws JsonGenerationException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.QUERY_PAYMENTS;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(requestBaseQueryDto);
			String resultString = restClient.post(url, String.class, jsonRequest);
			if (StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResultDto<FlightOrderPaymentDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	
	
	
	/**
	 * 退款监控查询支付记录
	 * @param flightOrderRefundRequest
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseResultDto<FlightOrderRefundDto> queryRefunds(BaseQueryDto<FlightOrderRefundRequest> requestBaseQueryDto) throws JsonGenerationException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.QUERY_REFUNDS;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(requestBaseQueryDto);
			String resultString = restClient.post(url, String.class, jsonRequest);
			if (StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResultDto<FlightOrderRefundDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	
	
	/**
	 * 退款监控查询支付记录
	 * @param flightOrderRefundRequest
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public List<String> exportPaymentsByCsv(BaseQueryDto<FlightOrderOfflinePayRequest> requestBaseQueryDto) throws JsonGenerationException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.EXPORT_PAYMENTS_BY_CVS;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(requestBaseQueryDto);
			String resultString = restClient.post(url, String.class, jsonRequest);
			if (StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<List<String>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	
	
	/**
	 * 导出退款记录（Csv）
	 * @param flightOrderRefundRequest
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public List<String> exportRefundsByCsv(BaseQueryDto<FlightOrderRefundRequest> requestBaseQueryDto) throws JsonGenerationException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.EXPORT_REFUNDS_BY_CVS;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(requestBaseQueryDto);
			String resultString = restClient.post(url, String.class, jsonRequest);
			if (StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<List<String>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	
	
	
	/**
	 * 取得可退信息
	 * @param request
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseReponseHandleT<FlightOrderPayAmountInfo> getAmountInfo(FlightOrderPayInfoRequest request) throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = PAY_AMOUNT_INFO;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, request);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseReponseHandleT<FlightOrderPayAmountInfo>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	

	/**
	 * 支付回调，回填成功/失败的信息到订单上并更新订单支付表中的数据(更新订单支付表)
	 * 
	 * @param request
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseReponseHandleT<FlightOrderPaymentDto> payCallback(FlightOrderPayRequest request) throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.PAY_CALLBACK;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, request);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseReponseHandleT<FlightOrderPaymentDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 落地并保存支付信息(新建订单支付)
	 * 
	 * @param request
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseReponseHandleT<FlightOrderPaymentDto> pay(FlightOrderPayInfoRequest request) throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.PAY;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, request);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseReponseHandleT<FlightOrderPaymentDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**是否满足主单支付条件
	 * 1：如满足条件则：返回主订单号，不满足则返回“”
	 * @param baseQueryDto
	 * @param opType
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public Boolean isCanMainPay(BaseQueryDto<FlightCommonQueryRequest> baseQueryDto, OpType opType) throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.IS_CAN_MAIN_PAY;
		String url = command.url(baseUrl,opType);
		try 
		{
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult, Boolean.class);
		} 
		catch (ExceptionWrapper ew) 
		{
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public Map getOrderPayCount( String orderNo) throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.GET_ORDER_PAY_COUNT;
		String url = command.url(baseUrl,orderNo);
		try 
		{
			Map map = restClient.post(url, Map.class);
			return map;
		} 
		catch (ExceptionWrapper ew) 
		{
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	public Map repeatRefund( String paymentNo,String refundRemark) throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.REPEAT_REFUND;
		String url = command.url(baseUrl,paymentNo,refundRemark);
		try 
		{
			Map map = restClient.post(url, Map.class);
			return map;
		} 
		catch (ExceptionWrapper ew) 
		{
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
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
	 * 后台线下支付，保存支付信息
	 * 
	 * @param request
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseReponseHandleT<FlightOrderPaymentDto> saveOrderOfflinePayInfo(FlightOrderOfflinePayRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.SAVE_ORDER_OFFLINE_PAY_INFO;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, request);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseReponseHandleT<FlightOrderPaymentDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 后台线下支付，查询对应的支付结果信息
	 * 
	 * @param request
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseResultDto<FlightOrderPaymentDto> searchOrderPayInfo(FlightOrderOfflinePayRequest request) {
		BussinessClientPath command = BussinessClientPath.QUERY_ORDER_PAY_INFO;
		String url = command.url(baseUrl);
		try {
			String jsonResult = restClient.post(url, String.class, request);
			if(StringUtil.isEmptyString(jsonResult)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(jsonResult,
					new TypeReference<BaseResultDto<FlightOrderPaymentDto>>() {
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
	 * 取得支付信息
	 * 
	 * @param FlightOrderPayInfoDto
	 * @return
	 */
	public FlightOrderPayInfoDto getPaymentInfo(FlightOrderPayInfoRequest request) {
		BussinessClientPath command = BussinessClientPath.GET_PAYMENT_INFO;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, FlightOrderPayInfoDto.class, request);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	
	/**
	 * 获取支付信息 from vst
	 * @param paymentTradeNo
	 * @return
	 */
	public BaseReponseHandleT<FlightOrderPaymentDto>  getPayInfoFromVST(String paymentTradeNo) throws JsonGenerationException, JsonMappingException, IOException  {
		BussinessClientPath command = BussinessClientPath.GET_PAY_INFO_FROM_VST;
		String url = command.url(baseUrl,paymentTradeNo);
		try {
			String resultString = restClient.post(url, String.class);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseReponseHandleT<FlightOrderPaymentDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**
     * 人工同步供应商退废票信息 
     * @param 	orderId			订单主键
     * @param 	suppRefundNo	供应商退废票单号
     * @return	ResultStatus
     */
	public ResultStatus manualSyncSuppRTVT(Long orderId, String suppRefundNo)
	{
		BussinessClientPath command = BussinessClientPath.MANUAL_SYNC_SUPP_RTVT;
		String url = command.url(baseUrl, orderId, suppRefundNo);
		return restClient.post(url, ResultStatus.class);
	}

	/**
	 * 供应商订单退废票信息同步
	 * @param 	FlightOrderSuppOrderRefundDto				供应商退废票单信息
	 * @return 	FlightOrderSuppOrderDto 	供应商订单信息
	 */
	public FlightOrderSuppOrderDto syncSuppOrderRefund(FlightOrderSuppOrderRefundDto flightOrderSuppOrderRefundDto) {
		BussinessClientPath command = BussinessClientPath.SUPP_ORDER_REFUND_SYNC;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, FlightOrderSuppOrderDto.class,flightOrderSuppOrderRefundDto);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 根据供应商订单No更新订单信息
	 * 
	 * @param suppOrderNo
	 * @param newPnr 517Na出票通知那块回填新的pnr
	 */
	public FlightOrderDto syncOrderBySuppOrderNo(String suppOrderNo) {
		BussinessClientPath command = BussinessClientPath.SYNC_ORDER_BY_SUPP_ORDER_NO;
		String url = command.url(baseUrl, suppOrderNo);
		try {
			return restClient.get(url, FlightOrderDto.class);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 根据供应商订单No获取supp订单信息，主要用于回调记录日志
	 * 
	 * @param suppOrderNo
	 */
	public FlightOrderSuppOrderDto getSuppOrderBySuppOrderNo(String suppOrderNo) {
		BussinessClientPath command = BussinessClientPath.GET_SUPP_ORDER_BY_SUPP_ORDER_NO;
		String url = command.url(baseUrl, suppOrderNo);
		try {
			return restClient.get(url, FlightOrderSuppOrderDto.class);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 自动投保
	 * 
	 * @param FlightOrderInsuranceDto
	 * @return
	 */
	public FlightOrderInsuranceDto singleInsuring(InsuranceOrderRequest request) {
		BussinessClientPath command = BussinessClientPath.SINGLE_INSURING;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, FlightOrderInsuranceDto.class, request);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 人工投保
	 * 
	 * @param FlightOrderInsuranceDto
	 * @return
	 */
	public BaseReponseHandle artificialInsuring(
			InsuranceOrderRequest request) {
		BussinessClientPath command = BussinessClientPath.ARTIFICIAL_INSURING;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, BaseReponseHandle.class, request);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 退保
	 * 
	 * @param InsuranceOrderDto
	 * @return
	 */
	public BaseSingleResultDto<InsuranceOrderDto> hesitateCancel(
			FlightInsuranceRequest request) {
		BussinessClientPath command = BussinessClientPath.HESITATE_CANCEL;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, request);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseSingleResultDto<InsuranceOrderDto>>() {
					});
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}

	/**
	 * 查询可用保险列表
	 * 
	 * 
	 */
	public List<InsuranceInfoDto> queryInsurance() {
		BussinessClientPath command = BussinessClientPath.QUERY_INSURANCE;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,
					new TypeReference<List<InsuranceInfoDto>>() {
					});
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}

	/**
     * 查询保险产品列表
     * 
     * 
     */
    public BaseResultDto<InsuranceInfoDto> queryInsuranceList(BaseQueryDto<InsuranceInfoRequest> request) throws JsonGenerationException, JsonMappingException, IOException {
        BussinessClientPath command = BussinessClientPath.QUERY_INSURANCE_LIST;
        String url = command.url(baseUrl);
        try {
        	 ObjectMapper objectMapper = JSONMapper.getInstance();
             String jsonRequest = objectMapper.writeValueAsString(request);
             String jsonResult = restClient.post(url, String.class, jsonRequest);
             return objectMapper.readValue(jsonResult,
					 new TypeReference<BaseResultDto<InsuranceInfoDto>>() {
					 });
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
     * 查询保险主数据列表
     * 
     * 
     */
    public BaseResultDto<InsuranceClass> queryInsuranceClass(BaseQueryDto<InsuranceClass> request) throws JsonGenerationException, JsonMappingException, IOException {
        BussinessClientPath command = BussinessClientPath.QUERY_INSURANCE_CLASS;
        String url = command.url(baseUrl);
        try {
        	 ObjectMapper objectMapper = JSONMapper.getInstance();
             String jsonRequest = objectMapper.writeValueAsString(request);
             String jsonResult = restClient.post(url, String.class, jsonRequest);
             return objectMapper.readValue(jsonResult,
                     new TypeReference<BaseResultDto<InsuranceClass>>() {
                     });
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
     * 添加或修改保险产品
     * @param request
     * @return
     */
    public BaseReponseHandle saveInsurance(InsuranceInfoRequest request){
    	BussinessClientPath command = BussinessClientPath.SAVE_INSURANCE;
    	String url = command.url(baseUrl);
    	try {
            return restClient.post(url, BaseReponseHandle.class, request);
        } catch (ExceptionWrapper ew) {
        	//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
        }
    }
    
	/**
	 * 查询保单列表orderInsurance
	 * 
	 * @param baseQueryDto
	 *            查询对象
	 * @return BaseResultDto<InsuranceOrderListDto> 保单列表查询结果对象
	 */
	public BaseResultDto<InsuranceOrderListDto> queryInsuranceOrderList(
			BaseQueryDto<FlightInsuranceRequest> baseQueryDto) {
		BussinessClientPath command = BussinessClientPath.QUERY_INSURANCE_ORDER_LIST;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<BaseResultDto<InsuranceOrderListDto>>() {
					});
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
	 * 查询保单列表 insuranceOrder
	 * 
	 * @param baseQueryDto
	 *            查询对象
	 * @return BaseResultDto<InsuranceOrderListDto> 保单列表查询结果对象
	 */
	public BaseResultDto<InsuranceOrderListDto> queryInsuranceOrders(
			BaseQueryDto<FlightInsuranceRequest> baseQueryDto) {
		BussinessClientPath command = BussinessClientPath.QUERY_INSURANCE_ORDERS;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<BaseResultDto<InsuranceOrderListDto>>() {
					});
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
	 * 查询保单列表 insuranceOrder
	 */
	public BaseResultDto<InsuranceOrderDto> searchInsuranceOrderList(
			BaseQueryDto<FlightInsuranceRequest> baseQueryDto) {
		BussinessClientPath command = BussinessClientPath.SEARCH_INSURANCE_ORDER_LIST;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<BaseResultDto<InsuranceOrderDto>>() {
					});
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
	 * 查询保单列表(导出)
	 * 
	 * @param baseQueryDto
	 *            查询对象
	 * @return BaseResultDto<InsuranceOrderDto> 保单列表查询结果对象
	 */
	public List<String> queryInsuranceOrderListofExport(
			BaseQueryDto<FlightInsuranceRequest> baseQueryDto) {
		BussinessClientPath command = BussinessClientPath.QUERY_INSURANCE_ORDER_LIST_OF_EXPORT;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<List<String>>() {
					});
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
	 * 根据保单Id查询保单详情
	 * 
	 * @param insuranceId
	 * @return
	 */
	public InsuranceOrderDto queryInsuranceOrderDetail(Long insuranceOrderId) {
		BussinessClientPath command = BussinessClientPath.QUERY_INSURANCE_ORDER_DETAIL;
		String url = command.url(baseUrl, insuranceOrderId);
		try {
			return restClient.get(url, InsuranceOrderDto.class);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 查询供应商信息
	 * 
	 * 
	 */
	public List<Supp> querySuppList(BaseQueryDto<Supp> baseQueryDto) {
		BussinessClientPath command = BussinessClientPath.QUERY_SUPP_LIST;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<List<Supp>>() {
					});
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
	 * 根据供应商查询保险产品
	 * 
	 * @param suppId
	 * @return
	 */
	public List<InsuranceInfoDto> getInsuranceBySupp(Long suppId) {
		BussinessClientPath command = BussinessClientPath.GET_INSURANCE_BY_SUPP;
		String url = command.url(baseUrl, suppId);
		try {
			String resultString = restClient.get(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<List<InsuranceInfoDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 根据供应商查询有效保险产品
	 * 
	 * @param suppId
	 * @return
	 */
	public List<InsuranceInfoDto> getValidBySuppId(Long suppId) {
		BussinessClientPath command = BussinessClientPath.GET_VALID_BY_SUPP_ID;
		String url = command.url(baseUrl, suppId);
		try {
			String resultString = restClient.get(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<List<InsuranceInfoDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 根据ID查询保险产品详情
	 * @param id
	 * @return
	 */
	public InsuranceInfoDto getInsuranceById(Long id) {
		BussinessClientPath command = BussinessClientPath.GET_INSURANCE_BY_ID;
		String url = command.url(baseUrl, id);
		try {
			String resultString = restClient.get(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<InsuranceInfoDto>() {
					});
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 根据ID删除保险产品（修改产品状态）
	 * @param id
	 * @return
	 */
	public InsuranceInfoDto updateInsuranceById(Long id) {
		BussinessClientPath command = BussinessClientPath.UPDATE_INSURANCE_BY_ID;
		String url = command.url(baseUrl, id);
		try {
			String resultString = restClient.get(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<InsuranceInfoDto>() {
					});
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 根据ID删除保险产品（修改产品状态）
	 * @param id
	 * @return
	 */
	public BaseSingleResultDto<Integer> updateInsuranceDefaultRule(Long id,String insuranceType,String productTypes) {
		BussinessClientPath command = BussinessClientPath.UPDATE_INSURANCE_DEFAULT_RULE;
		String url = command.url(baseUrl, id, insuranceType,productTypes);
		try {
			String resultString = restClient.get(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseSingleResultDto<Integer>>() {
					});
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	
	/**
	 * 根据vst商品Id查询vst基础航班信息
	 * 
	 * @param vstGoodsId
	 * @return
	 */
	public FlightVstBasicFlightDto getFlightInfosByGoodsId(Long vstGoodsId) {
		BussinessClientPath command = BussinessClientPath.GET_FLIGHT_INFO_BY_GOODS_ID;
		String url = command.url(baseUrl, vstGoodsId);
		try {
			return restClient.get(url, FlightVstBasicFlightDto.class);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 根据vst商品Id查询vst商品信息
	 * 
	 * @param vstGoodsId
	 * @return
	 */
	public FlightVstGoodsDto getFlightGoodsByGoodsId(Long vstGoodsId) {
		BussinessClientPath command = BussinessClientPath.GET_FLIGHT_VST_GOODS_BY_GOODS_ID;
		String url = command.url(baseUrl, vstGoodsId);
		try {
			return restClient.get(url, FlightVstGoodsDto.class);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 
	 * 根据航空公司码获取航空公司信息
	 * 
	 * @param code
	 * @return
	 */
	public Carrier queryCarrierByCode(String code) {
		BussinessClientPath command = BussinessClientPath.QUERY_CARRIER_BY_CODE;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, Carrier.class, code);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 查询航空公司信息
	 * 
	 * 
	 */
	public List<Carrier> queryCarrierList() {
		BussinessClientPath command = BussinessClientPath.QUERY_CARRIER_LIST;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,
					new TypeReference<List<Carrier>>() {
					});
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}


//	/**
//	 * 根据政策ID获取政策详情信息
//	 * 
//	 * @param policyId
//	 * @return
//	 */
//	public FlightPolicyDto queryPolicyById(Long policyId) {
//		BussinessClientPath command = BussinessClientPath.GET_POLICY_DETAIL;
//		String url = command.url(baseUrl, policyId);
//		try {
//			return restClient.get(url, FlightPolicyDto.class);
//		} catch (ExceptionWrapper ew) {
//			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
//			logger.error(ew.getErrMessage(),ew);
//			throw ew;
//		}
//	}

	/**
	 * 根据航班信息获取政策详情信息
	 * 
	 * @param flightQueryRequest
	 * @return
	 */
//	public FlightPolicyDto getFlightPolicyByFlightInfo(
//			FlightQueryRequest flightQueryRequest) {
//		BussinessClientPath command = BussinessClientPath.GET_POLICY_BY_FLIGHT_INFO;
//		String url = command.url(baseUrl);
//		try {
//			return restClient.post(url, FlightPolicyDto.class,
//					flightQueryRequest);
//		} catch (ExceptionWrapper ew) {
//			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
//			logger.error(ew.getErrMessage(),ew);
//			throw ew;
//		}
//	}
	
	/**
	 * 查询政策列表
	 * @param baseQueryDto
	 * @return
	 */
//	public BaseResultDto<FlightPolicyListDto> queryPolicyList(
//			BaseQueryDto<FlightPolicyListRequest> baseQueryDto) {
//		BussinessClientPath command = BussinessClientPath.QUERY_POLICY_LIST;
//		String url = command.url(baseUrl);
//		try {
//			ObjectMapper objectMapper = JSONMapper.getInstance();
//			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
//			String jsonResult = restClient.post(url, String.class, jsonRequest);
//			return objectMapper.readValue(jsonResult,
//					new TypeReference<BaseResultDto<FlightPolicyListDto>>() {
//					});
//		} catch (ExceptionWrapper ew) {
//			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
//			logger.error(ew.getErrMessage(),ew);
//			throw ew;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
//	/**
//	 * 根据政策ID查询不适用的航班
//	 * @param policyId
//	 * @return
//	 */
//	public List<FlightPolicyExcludeDto> queryPolicyExcludeList(Long policyId) {
//		BussinessClientPath command = BussinessClientPath.QUERY_POLICY_EXCLUDE_LIST;
//		String url = command.url(baseUrl, policyId);
//		try {
//			String resultString = restClient.get(url, String.class);
//			if (null == resultString && "".equals(resultString)) {
//				return null;
//			}
//			return JSONMapper.getInstance().readValue(resultString, new TypeReference<List<FlightPolicyExcludeDto>>() {
//			});
//		} catch (ExceptionWrapper ew) {
//			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
//			logger.error(ew.getErrMessage(),ew);
//			throw ew;
//		} catch (IOException exception) {
//			throw new RuntimeException();
//		}
//	}
	
//	public Boolean deletePolicyExclude(FlightPolicyExcludeRequest request) {
//		BussinessClientPath command = BussinessClientPath.DELETE_POLICY_EXCLUDE;
//		String url = command.url(baseUrl);
//		try {
//			return restClient.post(url, Boolean.class, request);
//
//		} catch (ExceptionWrapper ew) {
//			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
//			logger.error(ew.getErrMessage(),ew);
//			throw ew;
//		}
//	}

	/**
	 * 根据vst订单信息（主单id，子单id）查询机票主单信息
	 * 
	 * @return List<OrderMainDto>
	 * @throws IOException
	 */
	public List<OrderMainDto> queryOrderMainByVstOrderInfo(FlightOrderVstDto dto)
			throws IOException {
		BussinessClientPath command = BussinessClientPath.QUERY_ORDER_MAIN_BY_VST_ORDER_INFO;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, dto);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,
					new TypeReference<List<OrderMainDto>>() {
					});
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 保存vst机票订单关联信息
	 * 
	 * @param vstDtos
	 * @return
	 */
	public Integer saveBatchFlightOrderVstInfo(List<FlightOrderVstDto> vstDtos) {
		BussinessClientPath command = BussinessClientPath.SAVE_BATCH_FLIGHT_ORDER_VST_INFO;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(vstDtos);
			Integer count = restClient.post(url, Integer.class, jsonRequest);
			return count;
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
	 * 绑定VST航班号
	 * 
	 * @param request
	 * @return
	 */
	public BaseReponseHandle bindingVstOrder(VSTOrderRequest request) {
		BussinessClientPath command = BussinessClientPath.BINDING_VST_ORDER;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, BaseReponseHandle.class, request);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 解除绑定VST航班号
	 * 
	 * @param request
	 * @return
	 */
	public BaseReponseHandle unbindingVstOrder(VSTOrderRequest request) {
		BussinessClientPath command = BussinessClientPath.UNBINDING_VST_ORDER;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, BaseReponseHandle.class, request);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 根据vst信息查询机票订单支付信息
	 * 
	 * @param vstDto
	 * @return
	 */
	public List<FlightOrderPaymentDto> queryOrderPaymentInfoByVstOrderInfo(
			FlightOrderVstDto vstDto) {
		BussinessClientPath command = BussinessClientPath.QUERY_ORDER_PAYMENT_INFO_BY_VST_ORDER_INFO;
		String url = command.url(baseUrl);
		try {
			String result = restClient.post(url, String.class, vstDto);
			return JSONMapper.getInstance().readValue(result,
					new TypeReference<List<FlightOrderPaymentDto>>() {
					});
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
	 * 根据票号查询乘机人、航班等信息
	 * 
	 * @param ticketNo
	 */
	public FlightOrderTicketInfoDto queryOrderTicket(String ticketNo,String orderNo) {
		BussinessClientPath command = BussinessClientPath.QUERY_ORDER_TICKET_INFO;
		String url = command.url(baseUrl, ticketNo, orderNo);
		try {
			return restClient.get(url, FlightOrderTicketInfoDto.class);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 根据订单主键查询主订单信息
	 * 
	 * @param orderMainId
	 */
	public OrderMainDto getOrderMainById(Long orderMainId) {
		BussinessClientPath command = BussinessClientPath.GET_ORDER_MAIN_BY_ID;
		String url = command.url(baseUrl, orderMainId);
		try {
			return restClient.get(url, OrderMainDto.class);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 根据vst信息查询绑定的主单号
	 * 
	 * @param vstDto
	 * @return
	 */
	public List<OrderMainDto> queryBindingOrderMainByVstOrderInfo(
			FlightOrderVstDto vstDto) {
		BussinessClientPath command = BussinessClientPath.QUERY_BINDING_ORDER_MAIN_BY_VST_ORDER_INFO;
		String url = command.url(baseUrl);
		try {
			String result = restClient.post(url, String.class, vstDto);
			return JSONMapper.getInstance().readValue(result,
					new TypeReference<List<OrderMainDto>>() {
					});
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
	 *
	 * 
	 * @param request
	 * @return
	 */
	public BaseReponseHandle createSettlement(FlightOrderSettlementRequest request){
		BussinessClientPath command = BussinessClientPath.CREATE_SETTLEMENT;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, BaseReponseHandle.class, request);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**
	 * 新增日志信息
	 * 
	 * @param request
	 * @return
	 */
	public BaseReponseHandle addOpLog(VSTOrderRequest request) {
		BussinessClientPath command = BussinessClientPath.BINDING_VST_ORDER;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, BaseReponseHandle.class, request);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	
	/**
	 * 新增日志信息
	 * 
	 * @param request
	 * @return
	 */
	public OpLog addOpLogMessage(OpLog opLog) {
		BussinessClientPath command = BussinessClientPath.ADD_OP_LOG;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, OpLog.class, opLog);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	/**
	 * 新增订单日志信息
	 * 
	 * @param request
	 * @return
	 */
	public OrderOpLogDto addOrderOpLog(OrderOpLogDto orderOpLogDto) {
		BussinessClientPath command = BussinessClientPath.ADD_ORDER_OP_LOG;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, OrderOpLogDto.class, orderOpLogDto);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	public Boolean addOrderOpLogList(List<OrderOpLogDto> orderOpLogs) {
		BussinessClientPath command = BussinessClientPath.ADD_ORDER_OP_LOG_LIST;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(orderOpLogs);
		
			return restClient.post(url, Boolean.class, jsonRequest);
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
	 * 简单条件的日志查询
	 * @param businessId
	 * @param businessType
	 * @return
	 */
	public List<OpLog> queryOpLog(String businessId, BusinessType businessType) {
		BussinessClientPath command = BussinessClientPath.QUERY_OP_LOG;
		String url = command.url(baseUrl, businessId, businessType);
		try {
			String resultString = restClient.get(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<List<OpLog>>() {
			});
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 日志列表查询
	 * @param businessId
	 * @param businessType
	 * @param operType
	 * @param page
	 * @param rows
	 * @param records
	 * @param total
	 * @return
	 */
	public BaseResultDto<OpLog> queryOpLogList(String businessId,BusinessType businessType,
			String operType,Integer page,Integer rows) {
		BussinessClientPath command = BussinessClientPath.QUERY_OP_LOG_LIST;
		String url = command.url(baseUrl, businessId, businessType,operType,page,rows);
		try {
			String resultString = restClient.get(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseResultDto<OpLog>>() {
					});
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	public BaseResultDto<OrderOpLogDto> queryOrderOpLogList(String orderId,String operType,Integer page,Integer rows) {
		BussinessClientPath command = BussinessClientPath.QUERY_ORDER_OP_LOG_LIST;
		String url = command.url(baseUrl, orderId,operType,page,rows);
		try {
			String resultString = restClient.get(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseResultDto<OrderOpLogDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 查询儿童舱位政策信息
	 * @param flightNo
	 * @param seatCode
	 * @param policyId
	 * @param departDate
	 * @return
	 */
	public FlightSeatPolicyResponse getChildSeatAndPolicy(String flightNo,String seatCode,Long policyId,String departDate
			,String bookingSource
			,String depCityCode
			,String arrCityCode){
		BussinessClientPath command = BussinessClientPath.GET_CHILD_SEAT_POLICY;
		String url = command.url(baseUrl, flightNo, seatCode,policyId,departDate,bookingSource,depCityCode,arrCityCode);
		try {
			FlightSeatPolicyResponse reponse = restClient.get(url, FlightSeatPolicyResponse.class);
			return reponse;
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
	}
	
	/**
	 * 查询儿童舱位政策信息
	 * @param flightNo
	 * @param seatCode
	 * @param policyId
	 * @param departDate
	 * @return
	 */
	public FlightSeatPolicyResponse getChildSeatAndPolicyAggregate(ChildrenCalculatorRequest childrenCalculatorRequest){
		BussinessClientPath command = BussinessClientPath.GET_CHILD_SEAT_POLICY_AGGREGATE;
		String url = command.url(baseUrl);
		try {
			FlightSeatPolicyResponse reponse = restClient.post(url, FlightSeatPolicyResponse.class, childrenCalculatorRequest);
			return reponse;
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
	}
	
	public String getSmsContent(String orderId,String smsTypeName) {
		BussinessClientPath command = BussinessClientPath.GET_SMS_CONTENT;
		String url = command.url(baseUrl, orderId, smsTypeName);
		try {
			return restClient.get(url, String.class);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	public Boolean sendSms(SmsSendRequest smsSendRequest) {
		BussinessClientPath command = BussinessClientPath.SEND_SMS;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, Boolean.class, smsSendRequest);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
/**
	 * 保存外部订单与机票订单关联信息
	 * 
	 * @param FlightOrderSalesOrderRelationDto
	 * @return
	 */
	public FlightOrderSalesOrderRelationDto saveFlightOrderSalesOrderRelation(FlightOrderSalesOrderRelationDto dto) {
		BussinessClientPath command = BussinessClientPath.SAVE_FLIGHT_ORDER_SALES_ORDER_RELATION;
		String url = command.url(baseUrl);
		try {
			FlightOrderSalesOrderRelationDto result = restClient.post(url, FlightOrderSalesOrderRelationDto.class, dto);
			return result;
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
	 * 外部订单绑定机票订单
	 * 
	 * @param request
	 * @return
	 */
	public BaseReponseHandle bindingSalesOrder(FlightOrderSalesOrderRelationRequest request) {
		BussinessClientPath command = BussinessClientPath.BINDING_SALES_ORDER;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, BaseReponseHandle.class, request);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 外部订单解除绑定机票订单
	 * 
	 * @param request
	 * @return
	 */
	public BaseReponseHandle unbindingSalesOrder(FlightOrderSalesOrderRelationRequest request) {
		BussinessClientPath command = BussinessClientPath.UNBINDING_SALES_ORDER;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, BaseReponseHandle.class, request);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**
	 * 根据vst信息查询绑定的主单号
	 * 
	 * @param vstDto
	 * @return
	 */
	public List<OrderMainDto> queryBindingOrderMainByOrderRelation(
			FlightOrderSalesOrderRelationDto dto) {
		BussinessClientPath command = BussinessClientPath.QUERY_BINDING_ORDER_MAIN_BY_ORDER_RELATION;
		String url = command.url(baseUrl);
		try {
			String result = restClient.post(url, String.class, dto);
			return JSONMapper.getInstance().readValue(result,
					new TypeReference<List<OrderMainDto>>() {
					});
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public List<FlightOrderPaymentDto> queryOrderPaymentInfoBySalesOrderRelation(
			FlightOrderSalesOrderRelationDto dto) {
		BussinessClientPath command = BussinessClientPath.QUERY_ORDER_PAYMENT_INFO_BY_SALES_ORDER_RELATION;
		String url = command.url(baseUrl);
		try {
			String result = restClient.post(url, String.class, dto);
			return JSONMapper.getInstance().readValue(result,
					new TypeReference<List<FlightOrderPaymentDto>>() {
					});
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
	 * 短信日志查询List
	 * @param baseQueryDto
	 * @return
	 */
	public BaseResultDto<SmsLogDto> querySmsLogList(BaseQueryDto<SmsLogQueryRequest> baseQueryDto) 
			throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.QUERY_SMS_LOG_LIST;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,baseQueryDto);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(
					resultString, new TypeReference<BaseResultDto<SmsLogDto>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**
	 * 按条件查询操作日志List
	 * @param baseQueryDto
	 * @return
	 */
	public BaseResultDto<OpLog> queryOpLogListByCondition(BaseQueryDto<OpLogQueryRequest> baseQueryDto) 
			throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.QUERY_OP_LOG_LIST_BY_CONDITION;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,baseQueryDto);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(
					resultString, new TypeReference<BaseResultDto<OpLog>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 按条件查询操作黑名单日志List
	 * @param baseQueryDto
	 * @return
	 */
	public BaseResultDto<OpLog> queryOpBlackLogList(String businessId, String businessNo, Integer page, Integer rows) 
			throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.QUERY_OP_BLACK_LOG_LIST;
		String url = command.url(baseUrl,businessId,businessNo,page,rows);
		try {
			String resultString = restClient.get(url, String.class);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(
					resultString, new TypeReference<BaseResultDto<OpLog>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	
	/**
	 * 查询VST同步信息
	 * @param baseQueryDto
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseResultDto<VSTSyncConfigDto> queryVSTSyncConfigDatas(BaseQueryDto<VSTSyncConfigDto> baseQueryDto) throws JsonParseException, JsonMappingException, IOException{
		BussinessClientPath command = BussinessClientPath.QUERY_VST_SYNC_CONFIG_DATAS;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,baseQueryDto);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(
					resultString, new TypeReference<BaseResultDto<VSTSyncConfigDto>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 重置VST同步任务状态
	 * @param dto
	 * @return
	 */
	public String resetVSTSyncConfigStatus(VSTSyncConfigDto dto){
		BussinessClientPath command = BussinessClientPath.RESET_VST_SYNC_CONFIG_STATUS;
		String url = command.url(baseUrl);
		try {
			String result = restClient.post(url, String.class,dto);
			return result;
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 
	 * @param baseQueryDto
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseResultDto<FlightVstProductDto> queryVSTProducts(BaseQueryDto<FlightVstProductDto> baseQueryDto) throws JsonParseException, JsonMappingException, IOException{
		BussinessClientPath command = BussinessClientPath.QUERY_VST_PRODUCTS;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,baseQueryDto);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(
					resultString, new TypeReference<BaseResultDto<FlightVstProductDto>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	
	/**
	 * 根据条件查询VST商品信息
	 * @param baseQueryDto
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseResultDto<FlightVstGoodsDto> queryVstGoods(BaseQueryDto<FlightVstGoodsDto> baseQueryDto) throws JsonParseException, JsonMappingException, IOException{
		BussinessClientPath command = BussinessClientPath.QUERY_VST_GOODS;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,baseQueryDto);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(
					resultString, new TypeReference<BaseResultDto<FlightVstGoodsDto>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 根据条件查询商品时间价格信息
	 * @param baseQueryDto
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseResultDto<FlightVstGoodsTimePriceDto> queryVstGoodsTimePrices(BaseQueryDto<VSTGoodsTimePriceRequestForm> baseQueryDto) throws JsonParseException, JsonMappingException, IOException{
		BussinessClientPath command = BussinessClientPath.QUERY_VST_GOODS_TIME_PRICES;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,baseQueryDto);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(
					resultString, new TypeReference<BaseResultDto<FlightVstGoodsTimePriceDto>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 根据条件查询VST航班信息
	 * @param baseQueryDto
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseResultDto<FlightVstTrafficFlightDto> queryVstTrafficFlights(BaseQueryDto<VSTTrafficFlightRequestForm> baseQueryDto) throws JsonParseException, JsonMappingException, IOException{
		BussinessClientPath command = BussinessClientPath.QUERY_VST_TRAFFIC_FLIGHTS;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,baseQueryDto);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(
					resultString, new TypeReference<BaseResultDto<FlightVstTrafficFlightDto>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 根据条件查询VST规格信息
	 * @param baseQueryDto
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseResultDto<FlightVstProductBranchDto> queryVstProductBranches(BaseQueryDto<VSTProductBranchRequestForm> baseQueryDto) throws JsonParseException, JsonMappingException, IOException{
		BussinessClientPath command = BussinessClientPath.QUERY_VST_PRODUCT_BRANCHES;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,baseQueryDto);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(
					resultString, new TypeReference<BaseResultDto<FlightVstProductBranchDto>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 根据条件查询VST基础航班信息
	 * @param baseQueryDto
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseResultDto<FlightVstBasicFlightDto> queryVstBasicFlights(BaseQueryDto<VSTBasicFlightRequestForm> baseQueryDto) throws JsonParseException, JsonMappingException, IOException{
		BussinessClientPath command = BussinessClientPath.QUERY_VST_BASIC_FLIGHTS;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,baseQueryDto);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(
					resultString, new TypeReference<BaseResultDto<FlightVstBasicFlightDto>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 根据条件查询vst任务配置信息
	 * @param baseQueryDto
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaseResultDto<VstTaskConfigDto> queryVstTaskConfigs(BaseQueryDto<VSTTaskConfigRequestForm> baseQueryDto) throws JsonParseException, JsonMappingException, IOException{
		BussinessClientPath command = BussinessClientPath.QUERY_VST_TASK_CONFIGS;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,baseQueryDto);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(
					resultString, new TypeReference<BaseResultDto<VstTaskConfigDto>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 保存VST任务配置信息
	 * @param form
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public VSTTaskConfigResponseForm saveVstTaskConfig(VSTTaskConfigRequestForm form) throws Exception{
		BussinessClientPath command = BussinessClientPath.SAVE_VST_TASK_CONFIG;
		String url = command.url(baseUrl);
		try {
			VSTTaskConfigResponseForm response = restClient.post(url, VSTTaskConfigResponseForm.class, form);
			return response;
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 根据ID查询VST任务配置信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public VstTaskConfigDto getVstTaskConfigById(Long id) throws Exception{
		BussinessClientPath command = BussinessClientPath.GET_VST_TASK_CONFIG_BY_ID;
		String url = command.url(baseUrl,id);
		try {
			VstTaskConfigDto dto = restClient.get(url, VstTaskConfigDto.class);
			return dto;
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
     * 重新下单前验舱验价<br>
     * 
     * @param flightOrderBookingAgainRequest
     *            重新下单请求对象
     * @return BaseReponseHandleT 验舱验价返回的订单信息
     */
    public BaseReponseHandleT<OrderMainDto> verifyBookingAgain(FlightOrderBookingAgainRequest flightOrderBookingAgainRequest)
            throws JsonParseException, JsonMappingException, IOException {
        BussinessClientPath command = BussinessClientPath.VERIFY_BOOKING_AGAIN;
        String url = command.url(aggregateBaseurl);
        try {
            String resultString = restClient.post(url, String.class, flightOrderBookingAgainRequest);
            return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseReponseHandleT<OrderMainDto>>() {});
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }

    /**
     * 重新下单<br>
     * 
     * @param flightOrderBookingAgainRequest 
     *            重新下单请求对象
     * @return BaseReponseHandleT 重新下单后返回的订单信息
     */
    public BaseReponseHandleT<OrderMainDto> bookingAgain(FlightOrderBookingAgainRequest flightOrderBookingAgainRequest)
            throws JsonParseException, JsonMappingException, IOException {
    	BussinessClientPath command = command = BussinessClientPath.BOOKING_AGAIN_NEW;
        String url = command.url(baseUrl);
        try {
            String resultString = restClient.post(url, String.class, flightOrderBookingAgainRequest);
            return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseReponseHandleT<OrderMainDto>>() {});
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
    
    
    /**
     * 保存禁售规则
     * @param request 禁售规则请求
     * @return 禁售规则对象 
     */
    public BaseSingleResultDto<SalesRuleDisableDto> saveSalesRuleDisable(SalesRuleDisableRequest request)throws JsonParseException, JsonMappingException, IOException {
    	   BussinessClientPath command = BussinessClientPath.SAVE_SALES_RULE_DISABLE;
           String url = command.url(baseUrl);
           try {
               String resultString = restClient.post(url, String.class, request);
               return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseSingleResultDto<SalesRuleDisableDto>>() {});
           } catch (ExceptionWrapper ew) {
               logger.error(ew.getErrMessage(), ew);
               throw ew;
           }
    }
    
    
    /**
     * 根据ID查询指定禁售规则
     * @param request
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public BaseSingleResultDto<SalesRuleDisableDto> getSalesRuleDisable(SalesRuleDisableRequest request)throws JsonParseException, JsonMappingException, IOException {
 	   BussinessClientPath command = BussinessClientPath.GET_SALES_RULE_DISABLE;
        String url = command.url(baseUrl);
        try {
            String resultString = restClient.post(url, String.class, request);
            return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseSingleResultDto<SalesRuleDisableDto>>() {
			});
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
 }
    
    
    
    
    /**查询禁售规则列表
     * @param request 查询列表对象
     * @return 查询列表
     */
    public BaseResultDto<SalesRuleDisableDto> querySalesRuleDisable(BaseQueryDto<SalesRuleDisableRequest> request)throws JsonParseException, JsonMappingException, IOException {
 	   BussinessClientPath command = BussinessClientPath.QUERY_SALES_RULE_DISABLE;
        String url = command.url(baseUrl);
        try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(request);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult, new TypeReference<BaseResultDto<SalesRuleDisableDto>>() {
			});
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
 }
    

	/**
	 * 航班运价政策信息查询
	 * @param baseQueryDto
	 * @return BaseResultDto
	 */
	public BaseResultDto<FlightPricePolicyDto> queryFlightPricePolicyList(BaseQueryDto<FlightPricePolicyRequest>  baseQueryDto) {
		BussinessClientPath command = BussinessClientPath.QUERY_FLIGHT_PRICE_POLICY_LIST;
		String url = command.url(baseUrl);
		try {

			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<BaseResultDto<FlightPricePolicyDto>>() {
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
	 * 根据航班运价政策ID获取航班运价政策详情信息
	 * 
	 * @param 	pricePolicyId
	 * @return	FlightPricePolicyDto
	 */
	public FlightPricePolicyDto getFlightPricePolicyById(Long pricePolicyId) {
		BussinessClientPath command = BussinessClientPath.GET_FLIGHT_PRICE_POLICY_BY_ID;
		String url = command.url(baseUrl, pricePolicyId);
		try {
			return restClient.post(url, FlightPricePolicyDto.class);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**
	 * 批量删除航班运价政策信息
	 * 
	 * @param flightPricePolicyRequest
	 * @return BaseResultDto
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	public BaseResultDto<FlightPricePolicyDto> batchDelFlightPricePolicy(FlightPricePolicyRequest flightPricePolicyRequest)
			throws JsonGenerationException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.BATCH_DEL_FLIGHT_PRICE_POLICY;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,flightPricePolicyRequest);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper
					.getInstance()
					.readValue(resultString, new TypeReference<BaseResultDto<FlightPricePolicyDto>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**
	 * 航班运价库存信息查询
	 * @param baseQueryDto
	 * @return BaseResultDto
	 */
	public BaseResultDto<FlightPriceInventoryDto> queryFlightPriceInventoryList(BaseQueryDto<FlightPriceInventoryRequest>  baseQueryDto) {
		BussinessClientPath command = BussinessClientPath.QUERY_FLIGHT_PRICE_INVENTORY_LIST;
		String url = command.url(baseUrl);
		try {

			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<BaseResultDto<FlightPriceInventoryDto>>() {
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
	 * 批量删除航班运价库存信息
	 * @param flightPricePolicyRequest
	 * @return BaseResultDto
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	public BaseResultDto<FlightPriceInventoryDto> batchDelFlightPriceInventory(FlightPriceInventoryRequest flightPriceInventoryRequest)
			throws JsonGenerationException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.BATCH_DEL_FLIGHT_PRICE_INVENTORY;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,flightPriceInventoryRequest);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper
					.getInstance()
					.readValue(resultString, new TypeReference<BaseResultDto<FlightPriceInventoryDto>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**
	 * 航班运价基本信息查询
	 * @param baseQueryDto
	 * @return BaseResultDto
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	public BaseResultDto<FlightPriceInfoDto> queryFlightPriceInfoList(BaseQueryDto<FlightPriceInfoRequest>  baseQueryDto) 
			throws JsonGenerationException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.QUERY_FLIGHT_PRICE_INFO_LIST;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult, new TypeReference<BaseResultDto<FlightPriceInfoDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} 
	}
	
	/**
	 * 批量删除航班运价基本信息
	 * @param flightPricePolicyRequest
	 * @return BaseResultDto
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	public BaseResultDto<FlightPriceInfoDto> batchDelFlightPriceInfo(FlightPriceInfoRequest flightPriceInfoRequest)
			throws JsonGenerationException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.BATCH_DEL_FLIGHT_PRICE_INFO;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,flightPriceInfoRequest);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResultDto<FlightPriceInfoDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	/**
	 * 保存营销调控规则
	 * @param request
	 * @return
	 */
    public BaseSingleResultDto<SalesRuleSourceDto> saveSalesRuleSource(SalesRuleSourceRequest request)throws JsonParseException, JsonMappingException, IOException {
    	   BussinessClientPath command = BussinessClientPath.SAVE_SALES_RULE_SOURCE;
           String url = command.url(baseUrl);
           try {
               String resultString = restClient.post(url, String.class, request);
               return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseSingleResultDto<SalesRuleSourceDto>>() {});
           } catch (ExceptionWrapper ew) {
               logger.error(ew.getErrMessage(), ew);
               throw ew;
           }
    }
	
	/**
	 * 根据id修改营销调控状态
	 * @param request
	 * @return
	 */
	public BaseSingleResultDto<SalesRuleSourceDto> updateSalesRuleSource(SalesRuleSourceRequest salesRuleSourceRequest) {
		BussinessClientPath command = BussinessClientPath.UPDATE_SALES_RULE_SOURCE;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,salesRuleSourceRequest);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseSingleResultDto<SalesRuleSourceDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 批量删除营销调控数据(将显示状态修改为不显示)
	 * @param salesRuleSourceRequest
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public BaseSingleResultDto<SalesRuleSourceDto> batchDeleteSalesRuleSource(SalesRuleSourceRequest salesRuleSourceRequest) throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.BATCH_DELETE_SALES_RULE_SOURCE;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, salesRuleSourceRequest);
			if (null == resultString || "".equals(resultString)) {
				return null;
			}
			return JSONMapper
					.getInstance()
					.readValue(resultString, new TypeReference<BaseSingleResultDto<SalesRuleSourceDto>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 根据id查询营销调控详情
	 * @param id
	 * @return
	 */
	public  BaseSingleResultDto<SalesRuleSourceDto> getSalesRuleSource(Long id) {
		BussinessClientPath command = BussinessClientPath.GET_SALES_RULE_SOURCE_BY_ID;
		String url = command.url(baseUrl, id);
		try {
			String resultString = restClient.get(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseSingleResultDto<SalesRuleSourceDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 查询营销调控列表
	 * @param request
	 * @return
	 */
	public BaseResultDto<SalesRuleSourceDto> querySalesRuleSource(
			BaseQueryDto<SalesRuleSourceRequest> baseQueryDto) {
		BussinessClientPath command = BussinessClientPath.QUERY_SALES_RULE_SOURCE;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<BaseResultDto<SalesRuleSourceDto>>() {
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
	 * 保存虚拟调控规则
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public BaseSingleResultDto<SalesRuleSuppDto>  saveSalesRuleSupp(SalesRuleSuppRequest request) throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.SAVE_SALES_RULE_SUPP;
		String url = command.url(baseUrl);
		try {
			 String resultString = restClient.post(url, String.class, request);
             return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseSingleResultDto<SalesRuleSuppDto>>() {
			 });

		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}
	
	/**
	 * 根据id修改虚拟调控状态
	 * @param id
	 * @return
	 */
	public BaseSingleResultDto<SalesRuleSuppDto> updateSalesRuleSupp(SalesRuleSuppRequest salesRuleSuppRequest) {
		BussinessClientPath command = BussinessClientPath.UPDATE_SALES_RULE_SUPP;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,salesRuleSuppRequest);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseSingleResultDto<SalesRuleSuppDto>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 根据id删除虚拟调控数据(将显示状态修改为不显示)
	 * @param id
	 * @return
	 */
	public BaseSingleResultDto<SalesRuleSuppDto> batchDeleteSalesRuleSupp(SalesRuleSuppRequest salesRuleSuppRequest) {
		BussinessClientPath command = BussinessClientPath.BATCH_DELETE_SALES_RULE_SUPP;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, salesRuleSuppRequest);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseSingleResultDto<SalesRuleSuppDto>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 根据id查询虚拟调控详情
	 * @param id
	 * @return
	 */
	public BaseSingleResultDto<SalesRuleSuppDto> getSalesRuleSupp(Long id) {
		BussinessClientPath command = BussinessClientPath.GET_SALES_RULE_SUPP_BY_ID;
		String url = command.url(baseUrl, id);
		try {
			String resultString = restClient.get(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseSingleResultDto<SalesRuleSuppDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 查询虚拟调控列表
	 * @param request
	 * @return
	 */
	public BaseResultDto<SalesRuleSuppDto> querySalesRuleSupp(
			BaseQueryDto<SalesRuleSuppRequest> baseQueryDto) {
		BussinessClientPath command = BussinessClientPath.QUERY_SALES_RULE_SUPP;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<BaseResultDto<SalesRuleSuppDto>>() {
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
	 * 查询所有的航空公司机场信息
	 * @return
	 */
	public List<Airport> queryAirportList() {
		BussinessClientPath command = BussinessClientPath.QUERY_AIRPORT_LIST;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,
					new TypeReference<List<Airport>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 查询所有的机场城市信息
	 * @return
	 */
	public List<City> queryCityList() {
		BussinessClientPath command = BussinessClientPath.QUERY_CITY_LIST;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,
					new TypeReference<List<City>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 查询结算列表
	 * @param baseQueryDto
	 * @return
	 */
	public BaseResultDto<SettlementOrderDto> querySettlementOrderList(
			BaseQueryDto<SettlementOrderRequest> baseQueryDto) {
		BussinessClientPath command = BussinessClientPath.QUERY_SETTLEMENT_ORDER_LIST;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<BaseResultDto<SettlementOrderDto>>() {
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
	 * 将结算单推送至VST
	 * @param settlementOrderRequest
	 * @return
	 */
	public BaseSingleResultDto<SettlementOrderDto> sendSettlementOrderToVst(SettlementOrderRequest settlementOrderRequest) {
		BussinessClientPath command = BussinessClientPath.SEND_SETTLEMENT_ORDER_TO_VST;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,settlementOrderRequest);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseSingleResultDto<SettlementOrderDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 批量结算单推送至VST
	 * @param settlementOrderDtos
	 * @return
	 */
	public BaseResultDto<SettlementOrderDto> batchSendSettlementOrderToVst(List<Long> ids) {
		BussinessClientPath command = BussinessClientPath.BATCH_SEND_SETTLEMENT_ORDER_TO_VST;
		String url = command.url(baseUrl);
		try {
			
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(ids);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<BaseResultDto<SettlementOrderDto>>() {
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
	 * 批量结算单推送至VST
	 * @param settlementOrderDtos
	 * @return
	 */
	public BaseResultDto<SettlementOrderDto> batchSaveSettlementOrder(List<Long> orderIds) {
		BussinessClientPath command = BussinessClientPath.BATCH_SAVE_SETTLEMENT_ORDER;
		String url = command.url(baseUrl);
		try {
			
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(orderIds);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<BaseResultDto<SettlementOrderDto>>() {
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
	 * 生成结算单
	 * @param settlementOrderDto
	 * @return
	 */
	public BaseSingleResultDto<SettlementOrderDto> saveSettlementOrder(Long orderId) {
		BussinessClientPath command = BussinessClientPath.SAVE_SETTLEMENT_ORDER;
		String url = command.url(baseUrl, orderId);
		try {
			String resultString = restClient.get(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseSingleResultDto<SettlementOrderDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 保存通知规则信息
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public BaseSingleResultDto<NoticeInfoDto> saveNoticeInfo(NoticeInfoRequest request) throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.SAVE_NOTICE_INFO;
		String url = command.url(baseUrl);
		try {
			 String resultString = restClient.post(url, String.class, request);
             return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseSingleResultDto<NoticeInfoDto>>() {});

		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 根据id修改通知规则信息
	 * @param id
	 * @return
	 */
	public BaseSingleResultDto<NoticeInfoDto> updateNoticeInfo(NoticeInfoRequest request) {
		BussinessClientPath command = BussinessClientPath.UPDATE_NOTICE_INFO;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,request);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseSingleResultDto<NoticeInfoDto>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 根据id删除通知规则信息(将显示状态修改为不显示)
	 * @param id
	 * @return
	 */
	public BaseSingleResultDto<NoticeInfoDto> deleteNoticeInfo(NoticeInfoRequest request) {
		BussinessClientPath command = BussinessClientPath.DELETE_NOTICE_INFO;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, request);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseSingleResultDto<NoticeInfoDto>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 根据id查询通知规则信息详情
	 * @param id
	 * @return
	 */
	public BaseSingleResultDto<NoticeInfoDto> getNoticeInfoById(Long id) {
		BussinessClientPath command = BussinessClientPath.GET_NOTICE_INFO_BY_ID;
		String url = command.url(baseUrl, id);
		try {
			String resultString = restClient.get(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseSingleResultDto<NoticeInfoDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 查询通知规则信息列表
	 * @param request
	 * @return
	 */
	public BaseResultDto<NoticeInfoDto> queryNoticeInfo(
			BaseQueryDto<NoticeInfoRequest> baseQueryDto) {
		BussinessClientPath command = BussinessClientPath.QUERY_NOTICE_INFO;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<BaseResultDto<NoticeInfoDto>>() {
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
	 * 查询通知规则信息详情
	 * @param id
	 * @return
	 */
	public BaseResultDto<NoticeInfoDto> getNoticeInfo(NoticeInfoRequest request) {
		BussinessClientPath command = BussinessClientPath.GET_NOTICE_INFO;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class,request);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResultDto<NoticeInfoDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	
	/**
     * 验证供应商国内机票可退票/改签查询<br>
     * 
     * @param request
     * @return BaseResponseDto<FlightSuppOrderRefundableResponse>
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public BaseResponseDto<FlightSuppOrderRefundableResponse> findSuppTicketCTMTApply(FlightOrderTicketCTMTRequest request)
            throws JsonParseException, JsonMappingException, IOException {
        BussinessClientPath command = BussinessClientPath.FIND_SUPP_TICKET_CTMT_APPLY;
        String url = command.url(baseUrl);
        try {
            String resultString = restClient.post(url, String.class, request);
            return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResponseDto<FlightSuppOrderRefundableResponse>>() {
			});
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
    
    /**
     * 可改签后搜索可改签航班列表页<br>
     * 
     * @param request
     * @return BaseResultDto<FlightSuppOrderChangeInfoDto>
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public BaseResultDto<FlightSuppOrderChangeInfoDto> searchSuppChangeFlightInfoApply(BaseQueryDto<FlightOrderTicketCTMTRequest> request)
            throws JsonParseException, JsonMappingException, IOException {
        BussinessClientPath command = BussinessClientPath.SEARCH_SUPP_CHANGE_FLIGHT_INFO_APPLY;
        String url = command.url(baseUrl);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonRequest = objectMapper.writeValueAsString(request);
            String jsonResult = restClient.post(url, String.class, jsonRequest);
            return objectMapper.readValue(jsonResult, new TypeReference<BaseResultDto<FlightSuppOrderChangeInfoDto>>() {
			});
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
	
    /**
	 * 保存需发送的短信信息
	 * @param smsSendDto
	 * @return
	 */
	public SmsSendDto saveSms(SmsSendDto smsSendDto) {
		BussinessClientPath command = BussinessClientPath.SAVE_SMS;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, SmsSendDto.class, smsSendDto);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
    
    /**
	 * 查询需发送的短信信息
	 * @param baseQueryDto
	 * @return
	 */
	public BaseResultDto<SmsSendDto> querySmses(BaseQueryDto<SmsBatchSendRequest> baseQueryDto) {
		BussinessClientPath command = BussinessClientPath.QUERY_SMSES;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, baseQueryDto);
			if(StringUtil.isEmptyString(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(
					resultString, new TypeReference<BaseResultDto<SmsSendDto>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 短信群发
	 * @param id
	 * @return
	 */
	public BaseSingleResultDto<SmsSendDto> smsGroupSend(Long id) {
		BussinessClientPath command = BussinessClientPath.SMS_GROUP_SEND;
		String url = command.url(baseUrl, id);
		try {
			String resultString = restClient.get(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseSingleResultDto<SmsSendDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 短信批量群发
	 * @param ids
	 * @return
	 */
	public BaseResultDto<SmsSendDto> batchSmsGroupSend(List<Long> ids) {
		BussinessClientPath command = BussinessClientPath.BATCH_SMS_GROUP_SEND;
		String url = command.url(baseUrl);
		try {
			
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(ids);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<BaseResultDto<SmsSendDto>>() {
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
     * 根据选择的变更航班,并进行落地
     * 
     * @param request
     * @return
     */
    public ResultStatus finishFlightChangeApply(FlightOrderTicketCTMTRequest request) {
        BussinessClientPath command = BussinessClientPath.FINISH_FLIGHT_CHANGE_APPLY;
        String url = command.url(baseUrl);
        try {
            return restClient.post(url, ResultStatus.class, request);
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }

	 /**
     * 供应商改签申请
     * 
     * @param request
     * @return
     */
    public ResultStatus autoChangeApply(FlightOrderTicketCTMTAutoRequest request) {
        BussinessClientPath command = BussinessClientPath.AUTO_CHANGE_APPLY;
        String url = command.url(baseUrl);
        try{
            return restClient.post(url, ResultStatus.class, request);
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }

    /**
     * 根据订单ID同步供应商改签票信息
     * 
     * @param orderId
     * @return FlightOrderDto
     */
    public FlightOrderDto syncCtmtTicketbySuppOrder(Long orderId) {
        BussinessClientPath command = BussinessClientPath.SYNC_CTMT_TICKET_BY_SUPP_ORDER;
        String url = command.url(baseUrl, orderId);
        try {
            return restClient.get(url, FlightOrderDto.class);
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }

	/**
	 * 订单航变通知
	 * @param dto
	 * @return
	 */
	public ResultStatus orderFlightchangeNotify(FlightOrderFlightChangeInfoDto dto) {
		BussinessClientPath command = BussinessClientPath.ORDER_FLIGHT_CHANGE_NOTIFY;
		String url = command.url(baseUrl);
		try{
			return restClient.post(url, ResultStatus.class, dto);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
	}

	/**
	 * 订单航变信息查询
	 *
	 * @param baseQuery
	 */
	public BaseResultDto<FlightOrderFlightChangeInfoDto> queryFlightChangeInfoList(BaseQueryDto<FlightOrderFlightChangeInfoRequest> baseQuery) {
		BussinessClientPath command = BussinessClientPath.QUERY_ORDER_FLIGHT_CHANGE_INFO_LIST;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, baseQuery);
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResultDto<FlightOrderFlightChangeInfoDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	public List<SeatClass>  getSeatClass(){
		BussinessClientPath command = BussinessClientPath.AUTO_START_GET_SEAT_CLASS_CODE;
		String url = command.url(baseUrl);
		try{
			String returnStr = restClient.get(url, String.class);
			try {
				return JSONMapper.getInstance().readValue(returnStr, new TypeReference<List<SeatClass>>() {});
			} catch (IOException exception) {
				throw new RuntimeException();
			}
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		}
		//BussinessClientPath command = 
		
	}
	
	/**
	 * 
	 * <p>根据订单ID号修改T_FORD_ORDER_STATUS的订单取消状态
	 * ORDER_BACK_STATUS 订单后台状态   也要改为NORMAL</p> 
	 * @author 杨小龙
	 * @date 2016-7-11 下午1:37:16
	 * @param orderId
	 * @param cancelStatus
	 * @return
	 * @see
	 */
	public BaseSingleResultDto<FlightOrderStatusDto> updateOrderCancelByOrderId(Long orderId,String cancelStatus) {
		BussinessClientPath command = BussinessClientPath.UPDATE_ORDER_CANCEL_BY_ORDER_ID;
        String url = command.url(baseUrl, orderId,cancelStatus);
        try {
        	String resultString = restClient.get(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseSingleResultDto<FlightOrderStatusDto>>() {
			});
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (IOException exception) {
			throw new RuntimeException();
		}
    }
	
	/**
	 * 根据订单ID修改下单账号类型
	 * @param orderId
	 * @param orderFlag
	 * @return
	 */
	public BaseSingleResultDto<FlightOrderStatusDto> updateOrderFlagByOrderId(Long orderId,String orderFlag) {
        BussinessClientPath command = BussinessClientPath.UPDATE_ORDER_FLAG_BY_ORDER_ID;
        String url = command.url(baseUrl, orderId,orderFlag);
        try {
        	String resultString = restClient.get(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseSingleResultDto<FlightOrderStatusDto>>() {
			});
			
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (IOException exception) {
			throw new RuntimeException();
		}
    }
	
	
	/**
	 * 根据订单ID修改下单账号类型
	 * @param orderId
	 * @param orderFlag
	 * @return
	 */
	public BaseSingleResultDto<FlightOrderDto> updatePayAmountByOrderId(Long orderId,BigDecimal orderDirectReductionAmount) {
        BussinessClientPath command = BussinessClientPath.UPDATE_PAY_AMOUNT_BY_ORDER_ID;
        String url = command.url(baseUrl, orderId,orderDirectReductionAmount);
        try {
        	String resultString = restClient.get(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseSingleResultDto<FlightOrderDto>>() {
			});
			
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (IOException exception) {
			throw new RuntimeException();
		}
    }
	
	/**
     * 获取成人和儿童的退改签规则
     * @return
     */
    public List<FlightSearchTicketRuleSimpleDto> viewTicketRule(ToSuppBookingRequest request) {
        BussinessClientPath command = BussinessClientPath.VIEW_TICKET_RULES;
        String url = command.url(baseUrl);
        try {
            String resultString = restClient.post(url, String.class, request);
            if (null == resultString && "".equals(resultString)) {
                return null;
            }
            return JSONMapper.getInstance().readValue(resultString, new TypeReference<List<FlightSearchTicketRuleSimpleDto>>() {
            });
            
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (IOException exception) {
            throw new RuntimeException();
        }
    }
    
    /**
     * 获取成人和儿童的商品价格信息
     * @return
     */
    public List<FlightTicketPriceDto> viewProductRule(ToSuppBookingRequest request) {
        BussinessClientPath command = BussinessClientPath.VIEW_PRODUCT_PRICES;
        String url = command.url(baseUrl);
        try {
            String resultString = restClient.post(url, String.class, request);
            if (null == resultString && "".equals(resultString)) {
                return null;
            }
            return JSONMapper.getInstance().readValue(resultString, new TypeReference<List<FlightTicketPriceDto>>() {});
            
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (IOException exception) {
            throw new RuntimeException();
        }
    }

	/**
	 * 根据外部订单信息查询订单详情视图信息
	 */
	public BaseResultDto<FlightOrderDetailViewDto> queryDetailViewListBySalesOrderRelation(FlightOrderSalesOrderRelationDto dto) {
		BussinessClientPath command = BussinessClientPath.QUERY_DETAIL_VIEW_LIST_BY_SALES_ORDERRELATION;
		String url = command.url(baseUrl);
		try {
			String result = restClient.post(url, String.class, dto);
			return JSONMapper.getInstance().readValue(result, new TypeReference<BaseResultDto<FlightOrderDetailViewDto>>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 根据OrderId获取供应商订单的状态
	 * @param orderId
	 * @return
	 */
	public BaseSingleResultDto<FlightOrderSuppOrderStatusDto> checkSuppOrderStatusByOrderId(Long orderId) {
		BussinessClientPath command = BussinessClientPath.CHECK_SUPP_ORDER_STATUS_BY_ORDER_ID;
		String url = command.url(baseUrl, orderId);
		try {
			String resultString = restClient.post(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseSingleResultDto<FlightOrderSuppOrderStatusDto>>() {
			});
			
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	public FlightOrderDto suppOrderPay(Long orderId) {
		BussinessClientPath command = BussinessClientPath.SUPP_ORDER_PAY;
		String url = command.url(baseUrl, orderId);
		try {
			return restClient.post(url, FlightOrderDto.class);
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } 
	}
	/**
	 * TASK #32247 
	 * 客户预订意向记录
	 * @param flightOrderBookingRequest
	 * @return
	 */
	public ResultStatus saveOrdIntentionInfo(FlightOrderBookingRequest request){
		BussinessClientPath command = BussinessClientPath.SAVE_FLIGHT_ORDER_INTENTION;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, ResultStatus.class, request);
		} catch (ExceptionWrapper ew) {
			ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/***
	 * TASK #32247 客户预订意向记录查询接口
	 * @param baseQueryDto
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
    public BaseResultDto<FlightOrderIntentionRecordDto> queryFlightOrderIntentionRecordList(
            BaseQueryDto<FlightOrderIntentionRecordRequest> baseQueryDto) throws JsonParseException,
            JsonMappingException, IOException {
    	BussinessClientPath command = BussinessClientPath.QUERY_FLIGHT_ORDER_INTENTION_RECORD_LIST;
        String url = command.url(baseUrl);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
            String jsonResult = restClient.post(url, String.class, jsonRequest);
            return objectMapper.readValue(jsonResult,
                    new TypeReference<BaseResultDto<FlightOrderIntentionRecordDto>>() {
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
    
    /***
     * 导出客户预订意向记录信息
     */
    public List<String> queryFOrderIntentionRecordExport(
			BaseQueryDto<FlightOrderIntentionRecordRequest> baseQueryDto) {
    	BussinessClientPath command = BussinessClientPath.QUERY_FLIGHT_ORDER_INTENTION_RECORD_LIST_EXPORT;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<List<String>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
	
	/***
	 * 查询下单请求记录
	 * @param baseQueryDto
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
    public BaseResultDto<FlightOrderRequestRecordDto> queryFlightOrderReqRecordList(
            BaseQueryDto<FlightOrderRequestRecordRequest> baseQueryDto) throws JsonParseException,
            JsonMappingException, IOException {
    	BussinessClientPath command = BussinessClientPath.QUERY_FLIGHT_ORDER_REQ_RECORD_LIST;
        String url = command.url(baseUrl);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
            String jsonResult = restClient.post(url, String.class, jsonRequest);
            return objectMapper.readValue(jsonResult,
                    new TypeReference<BaseResultDto<FlightOrderRequestRecordDto>>() {
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
    /***
     * 导出下单请求记录信息
     */
    public List<String> queryFOrderReqRecordExport(
			BaseQueryDto<FlightOrderRequestRecordRequest> baseQueryDto) {
    	BussinessClientPath command = BussinessClientPath.QUERY_FLIGHT_ORDER_REQ_RECORD_LIST_OF_EXPORT;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<List<String>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    
    /***
     * 导出风控管理-流量统计列表
     */
    public List<String> queryApiFlowListCountExportCsv(BaseQueryDto<ApiFlowQueryRequest> baseQueryDto){
    	BussinessClientPath command = BussinessClientPath.API_FLOW_LIST_COUNT_EXPORT_CSV;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<List<String>>() {
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
     * 根据订单Id查询退款记录
     * @param orderId
     * @return
     */
    public List<FlightOrderRefundDto>  queryReFundsByOrderId(Long orderId){
    	BussinessClientPath command = BussinessClientPath.QUERY_ORDER_REFUND_INFO_BYORDERID;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(orderId);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<List<FlightOrderRefundDto>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    
    public List<FlightOrderSuppOrderMainDto> suppBooking(SuppBookingRequest suppBookingRequest) {
		BussinessClientPath command = BussinessClientPath.SUPP_BOOKING;
		String url = command.url(baseUrl);
		try {
			String result = restClient.post(url, String.class, suppBookingRequest);
			return JSONMapper.getInstance().readValue(result, new TypeReference<List<FlightOrderSuppOrderMainDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

    
    /*
    public FlightOrderDto syncticketCTMTOp(FlightOrderTicketCTMTRequest request) {
		BussinessClientPath command = BussinessClientPath.SYNC_CTMT_TICKET_INFO_HANDLE;
		String url = command.url(baseUrl);
		try {
			String result = restClient.post(url, String.class, request);
			return JSONMapper.getInstance().readValue(result, new TypeReference<FlightOrderDto>() {});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}*/

    
    /**
     * 根据订单Id查询订单操作
     * @param orderMainId
     * @param orderId
     * @param opType
     * @return
     */
    public Boolean opValidByOrderId(Long orderMainId, Long orderId, OpType opType) {
    	BussinessClientPath command = BussinessClientPath.OP_VALID_BY_ORDER_ID;
    	String url = command.url(baseUrl, orderMainId, orderId, opType);
		try {
			return restClient.post(url, Boolean.class);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
    }

    public FlightOrderDto syncSuppOrderPay(Long orderId) {
		BussinessClientPath command = BussinessClientPath.SYNC_SUPP_ORDER_PAY;
		String url = command.url(baseUrl, orderId);
		try {
			return restClient.post(url, FlightOrderDto.class);
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } 
	}
    
    /**
	 * 根据订单ID修改供应商信息
	 * @param orderId
	 * @param orderFlag
	 * @return
	 */
	public BaseSingleResultDto<FlightOrderStatusDto> updateSuppOrderSuppByOrderId(Long orderId,String suppCode) {
        BussinessClientPath command = BussinessClientPath.UPDATE_SUPP_ORDER_SUPP_BY_ORDER_ID;
        String url = command.url(baseUrl, orderId,suppCode);
        try {
        	String resultString = restClient.get(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseSingleResultDto>() {
			});
			
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (IOException exception) {
			throw new RuntimeException();
		}
    }

    
    /**
	 * 自动投保
	 * 
	 * @param FlightOrderInsuranceDto
	 * @return
	 */
	public BaseSingleResultDto<InsuranceOrderDto> singleInsurance(InsuranceOrderRequest insuranceRequest) {
		BussinessClientPath command = BussinessClientPath.SINGLE_INSURANCE;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, insuranceRequest);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseSingleResultDto<InsuranceOrderDto>>() {
					});
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}

	/**
	 * 人工投保
	 * 
	 * @param FlightOrderInsuranceDto
	 * @return
	 */
	public BaseSingleResultDto<InsuranceOrderDto> artificialInsurance(InsuranceOrderRequest insuranceRequest){
		BussinessClientPath command = BussinessClientPath.ARTIFICIAL_TINSURANCE;
		String url = command.url(baseUrl);
		try {
			String resultString = restClient.post(url, String.class, insuranceRequest);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseSingleResultDto<InsuranceOrderDto>>() {
					});
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	public BaseResultDto<OrderOpLogDto> queryOrderOpMainLogList(String orderMainId,String orderId,String operType,Integer page,Integer rows) {
		BussinessClientPath command = BussinessClientPath.QUERY_ORDER_OP_MAIN_LOG_LIST;
		String url = command.url(baseUrl, orderMainId,orderId,operType,page,rows);
		try {
			String resultString = restClient.get(url, String.class);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString,new TypeReference<BaseResultDto<OrderOpLogDto>>() {
			});
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (IOException exception) {
			throw new RuntimeException();
		}
	}
	
	/**
	 * 订单来源为分销机票的订单同步状态到分销
	 * @param orderNo
	 * @return
	 */
	public BaseResponseDto distSyncStatus(String orderNo) {
        BussinessClientPath command = BussinessClientPath.DIST_SYNC_ORDER_STATUS;
        String url = command.url(baseUrl);
        try {
        	String resultString = restClient.post(url, String.class, orderNo);
			if (null == resultString && "".equals(resultString)) {
				return null;
			}
			return JSONMapper.getInstance().readValue(resultString, new TypeReference<BaseResponseDto>() {
			});
			
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (IOException exception) {
			throw new RuntimeException();
		}
    }
	
	/**
	 * 支付单号获得对应分销单号
	 * @param orderNo
	 * @return
	 */
	public Long getTntIdByPaymentNo(String paymentNo) {
        BussinessClientPath command = BussinessClientPath.DIST_GET_TNTID;
        String url = command.url(baseUrl);
        try {
        	Long resultString = restClient.post(url, Long.class, paymentNo);
			return resultString;
			
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
	
	/**
	 * 退款单号获取待退款的退票单号
	 * @param refundNo
	 * @param refundAmount
	 * @return
	 */
	public String getOrderNoByRefundNo(String refundNo, Long refundAmount) {
        BussinessClientPath command = BussinessClientPath.DIST_GET_ORDERNO_BY_REFUNDNO;
        String url = command.url(baseUrl, refundNo, refundAmount);
        try {
        	String resultString = restClient.post(url, String.class);
			return resultString;
			
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
	
	/**
	 * 根据主单No查询主订单信息
	 * 
	 * @param orderNo
	 */
	public OrderMainDto getOrderMainByNo(String orderNo) {
		BussinessClientPath command = BussinessClientPath.GET_ORDER_MAIN_BY_NO;
		String url = command.url(baseUrl, orderNo);
		try {
			return restClient.get(url, OrderMainDto.class);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
	
	/**
	 * 根据子单No查询主订单信息
	 * 
	 * @param orderNo
	 */
	public FlightOrderDto getOrderByNo(String orderNo) {
		BussinessClientPath command = BussinessClientPath.GET_ORDER_BY_NO;
		String url = command.url(baseUrl, orderNo);
		try {
			return restClient.get(url, FlightOrderDto.class);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 查询操作记录
	 */
	public BaseResultDto<FlightOrderImportRecordDto> queryImportRecordList(BaseQueryDto<FlightOrderImportRecordRequest> recordRequest) {
		try {
			String jsonResult = restClient.post(BussinessClientPath.QUERY_ORDER_IMPORT_RECORD_LIST.url(baseUrl), String.class, recordRequest);
			return JSONMapper.getInstance().readValue(jsonResult,
					new TypeReference<BaseResultDto<FlightOrderImportRecordDto>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			logger.error("查询已导入订单操作记录异常：", e);
		}
		return null;
	}

	/**
	 * 查询已导入订单
	 */
	public BaseResultDto<FlightOrderImportDto> queryImportList(BaseQueryDto<FlightOrderImportRequest> importRequest) {
		try {
			String jsonResult = restClient.post(BussinessClientPath.QUERY_ORDER_IMPORT_LIST.url(baseUrl), String.class, importRequest);
			return JSONMapper.getInstance().readValue(jsonResult,
					new TypeReference<BaseResultDto<FlightOrderImportDto>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(), ew);
			throw ew;
		} catch (Exception e) {
			logger.error("查询已导入订单异常：", e);
		}
		return null;
	}
	
	/**
	 * 获取是否使用优惠券开关(PC&H5)
	 * @return
	 */
	public BaseReponseHandleT<Boolean> getCouponSwitch(){
		BussinessClientPath command = BussinessClientPath.GET_COUPON_SWITCH;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonResult = restClient.get(url, String.class);
			return objectMapper.readValue(jsonResult, new TypeReference<BaseReponseHandleT<Boolean>>() {
			});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	/**
	 * 导单审核列表
	 * @param request
	 * @return
	 */
	public BaseResultDto<FlightOrderImportDto> queryOrderImportAuditList(BaseQueryDto<FlightOrderImportAuditRequest> request){
		BussinessClientPath command = BussinessClientPath.QUERY_ORDER_IMPORT_AUDIT_LIST;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonResult = restClient.post(url, String.class, request);
			return objectMapper.readValue(jsonResult, new TypeReference<BaseResultDto<FlightOrderImportDto>>(){});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	/**
	 * 导入订单审核&出票
	 * 
	 * @param request
	 * @return
	 */
	public ResultStatus auditIssueImportOrder(
			AuditOpDto<FlightOrderTicketIssueRequest> request)
			throws JsonParseException, JsonMappingException, IOException {
		BussinessClientPath command = BussinessClientPath.AUDIT_ISSUE_IMPORT_ORDER;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, ResultStatus.class, request);
		} catch (ExceptionWrapper ew) {
			//ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url)+ew.getErrMessage());
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}

	/**
	 * 制单
	 * @param importId
	 * @return
	 */
	public BaseSingleResultDto generateOrderByImportId(Long importId) {
		BussinessClientPath command = BussinessClientPath.GENERATE_ORDER_IMPORT_BY_IMPORT_ID;
		String url = command.url(baseUrl, importId);
		try {
			return restClient.get(url, BaseSingleResultDto.class);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
	}
}
