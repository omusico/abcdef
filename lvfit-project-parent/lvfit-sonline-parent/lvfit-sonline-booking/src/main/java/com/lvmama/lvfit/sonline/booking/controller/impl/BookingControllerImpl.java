package com.lvmama.lvfit.sonline.booking.controller.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvf.common.utils.StringUtil;
import com.lvmama.lvfit.common.client.FitSdpClient;
import com.lvmama.lvfit.common.client.FitVstClient;
import com.lvmama.lvfit.common.dto.adapter.request.FlightBookingSuccessRequest;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.member.FitMemUserDto;
import com.lvmama.lvfit.common.dto.member.FitPassengerInfoDto;
import com.lvmama.lvfit.common.dto.order.FitOrderAmountDto;
import com.lvmama.lvfit.common.dto.order.FitOrderContacterDto;
import com.lvmama.lvfit.common.dto.order.FitOrderCustomerDto;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.order.FitOrderPassengerDto;
import com.lvmama.lvfit.common.dto.order.FitPaymentUrlDto;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;
import com.lvmama.lvfit.common.dto.request.FitOrderPassengerRequest;
import com.lvmama.lvfit.common.dto.request.MemUserRequest;
import com.lvmama.lvfit.common.form.booking.BookingInputForm;
import com.lvmama.lvfit.common.form.booking.BookingResultForm;
import com.lvmama.lvfit.sonline.booking.BookingController;
import com.lvmama.lvfit.sonline.exception.BaseExceptionHandler;
import com.lvmama.lvfit.sonline.utils.IpUtils;
import com.lvmama.lvfit.sonline.utils.ServletUtil;

@Controller
public class BookingControllerImpl extends BaseExceptionHandler implements BookingController<BookingInputForm, BaseResponseDto<BookingResultForm>>{

	private final static Logger logger = org.slf4j.LoggerFactory.getLogger(BookingControllerImpl.class);
	/**	 * 预授权页面	 */
	private final String PREPAID_PAGE="http://pay.lvmama.com/payfront/view/preSalePowerView.do";
	
	@Autowired
    private FitVstClient vstClient;
	
	@Autowired
	private FitSdpClient fitSdpClient;
	
	@Override
	@RequestMapping(value = "/order/Booking", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> booking(Model model, HttpServletRequest request, HttpServletResponse response, BookingInputForm bookingForm) {
		Map<String,Object> map = new HashMap<String, Object>();
		//1.当前用户信息
		bookingForm = this.getInputForm(request, bookingForm);
		
		//2.保存游玩人信息
		this.savePassengers(request,bookingForm);
		
		//3.下单()
		FitOrderBookingRequest bookRequest = buildBookingRequest(bookingForm);
		BaseSingleResultDto<FitOrderMainDto> resultDto = new BaseSingleResultDto<FitOrderMainDto>() ;
		resultDto = fitSdpClient.booking(bookRequest);
		
		//4.下单完成之后跳转至支付页面
		FitOrderMainDto orderMainDto = resultDto.getResult();
		FlightBookingSuccessRequest bookResultRequest = new FlightBookingSuccessRequest();
		FitPaymentUrlDto fitPaymentUrlDto = buildPayParam(bookRequest, orderMainDto);
		String orderNameKey="order_title_"+fitPaymentUrlDto.getOrderName();
		ServletUtil.putSession(request, response, orderNameKey, orderMainDto.getProductName());
		bookResultRequest.setFitPaymentUrlDto(fitPaymentUrlDto);
		
		String url = vstClient.getPaymentUrl(bookResultRequest);
		map.put("successUrl",PREPAID_PAGE+url);
		
		return map;
	}

	/**
	 * 
	 * @param bookRequest
	 * @param result
	 * @return
	 */
	private FitPaymentUrlDto buildPayParam(FitOrderBookingRequest bookRequest, FitOrderMainDto result) {
		 FitPaymentUrlDto fitPaymentUrlDto = new FitPaymentUrlDto();
		 if(result == null){
			return fitPaymentUrlDto;
		 }
		 String  approveTime=DateUtils.formatDate(new Date(), "yyyyMMddHHmmss");
		 String visitTime=bookRequest.getVisitTime().replaceAll("-", "")+ "000000";
		 fitPaymentUrlDto.setWaitPayment(String.valueOf(60)); //默认一个小时
		 fitPaymentUrlDto.setVisitTime(visitTime);
		 fitPaymentUrlDto.setApproveTime(approveTime);
		 fitPaymentUrlDto.setOrderId(result.getFitSuppMainOrderDto().getVstMainOrderNo());
		 fitPaymentUrlDto.setPreOrNormal("PRE");    // pre:是预授权  "NORMAL":正常
		 UUID uuid = UUID.randomUUID();
		 fitPaymentUrlDto.setOrderName(uuid.toString());
		 return fitPaymentUrlDto;
	}
	
	
	/**
	 * 构建下单request
	 * @param bookingForm
	 * @return
	 */
	private FitOrderBookingRequest buildBookingRequest(BookingInputForm bookingForm) {
		FitOrderBookingRequest bookingRequest = bookingForm.getFitOrderBookingRequest();
		bookingRequest.setBookingSource(BookingSource.FIT_SDP_FRONT);
		bookingRequest.setVisitTime(bookingForm.getVisitTime());
		bookingRequest.setShoppingUuid(bookingForm.getShoppingUUID());
		bookingRequest.setProductName(bookingForm.getProductName());
		FitOrderAmountDto fitOrderAmountDto = new FitOrderAmountDto();
		fitOrderAmountDto.setTotalAmount(bookingForm.getTotalPrice());
		bookingRequest.setFitOrderAmountDto(fitOrderAmountDto);
		//设置游玩人信息
		bookingRequest.setFitOrderPassengerDtos(getPassengers(bookingForm));
		return bookingRequest;
	}

	/**
	 * 保存游玩人信息
	 * @param bookingForm
	 */
	private void savePassengers(HttpServletRequest request,BookingInputForm bookingForm) {
		List<FitOrderPassengerDto> passengerList = getPassengers(bookingForm);
		bookingForm.setFitOrderPassengerDtos(passengerList);
		
		List<FitPassengerInfoDto> fitPassengers = new ArrayList<FitPassengerInfoDto>();
		fitPassengers = getFitPassengerInfoList(fitPassengers,passengerList); 
		
		FitOrderCustomerDto customer = bookingForm.getFitOrderCustomerDto();
		String userCode = customer.getCustomerId();
		FitOrderPassengerRequest passRequest = new FitOrderPassengerRequest();
		fitPassengers = getFitPassenger(fitPassengers,bookingForm);
		passRequest.setFitPassengers(fitPassengers);
		passRequest.setUserId(userCode);
		
		try {
			vstClient.saveOrderPassengerInfo(passRequest);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage());
		}
	}

	/**
	 * @param bookingForm
	 * @return
	 */
	private List<FitOrderPassengerDto> getPassengers(
			BookingInputForm bookingForm) {
		List<FitOrderPassengerDto> passengerList = new ArrayList<FitOrderPassengerDto>();
		try {
			passengerList = JSONMapper.getInstance().readValue(bookingForm.getPlayerList(), new TypeReference<List<FitOrderPassengerDto>>() {
			});
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return passengerList;
	}

	/**
	 * 获取当前用户信息
	 * @param request
	 * @param inputForm
	 * @return
	 */
	private BookingInputForm getInputForm(HttpServletRequest request, BookingInputForm inputForm) {
    	FitOrderContacterDto fitOrderContacterDto = new FitOrderContacterDto();
    	fitOrderContacterDto.setEmail(inputForm.getEmail());
    	fitOrderContacterDto.setName(inputForm.getName());
    	fitOrderContacterDto.setMobile(inputForm.getMobile());
    	inputForm.setFitOrderContacterDto(fitOrderContacterDto);
        //获得sessionId
        MemUserRequest userRequest = new MemUserRequest();
    	String lvSessionId = ServletUtil.getLvSessionId(request, null);
    	userRequest.setLvSessionId(lvSessionId);
	
		BaseSingleResultDto<FitMemUserDto> result= vstClient.getUserByLvSessionId(userRequest);
		FitMemUserDto userDto = result.getResult();
		//FitMemUserDto userDto = new FitMemUserDto();
		//userDto.setUserId(3895882L);
		//userDto.setUserName("bbbbbb1");
		//userDto.setUserNo("3895882");
		if (null == userDto || null == userDto.getUserId() || StringUtils.isBlank(userDto.getUserName())) {
			throw new ExceptionWrapper(ExceptionCode.NOT_CUSTOMER_ORDER_ERROR);
		}
		/** 根据sessionId 获得其它信息 */
		FitOrderCustomerDto customerDto = new FitOrderCustomerDto();
		customerDto.setCustomerId(userDto.getUserNo());
		customerDto.setCustomerCode(String.valueOf(userDto.getUserId()));
		customerDto.setCustomerName(userDto.getUserName());
		customerDto.setCustomerIP(IpUtils.getIpAddr(request));
		inputForm.setFitOrderCustomerDto(customerDto);
		return inputForm;
	}
	
	/**
	 * 转换可保存的联系人信息
	 * @param fitPassengers
	 * @param passengerList
	 * @return
	 */
	private List<FitPassengerInfoDto> getFitPassengerInfoList(List<FitPassengerInfoDto> fitPassengers,
			List<FitOrderPassengerDto> passengerList) {
		if(CollectionUtils.isNotEmpty(passengerList)){
			for(FitOrderPassengerDto order:passengerList){
				FitPassengerInfoDto passenger = new FitPassengerInfoDto();
				if(order.getPassengerBirthday() != null){
					passenger.setBirthday(DateUtils.parseDate(order.getPassengerBirthday()));
				}
				passenger.setCertNo(order.getPassengerIDCardNo());
				passenger.setCertType(order.getPassengerIDCardType().name());  // 政件类型
				passenger.setMobileNumber(order.getMobile());
				passenger.setPeopleType(order.getPassengerType().name()); //乘客类型
				passenger.setReceiverId(String.valueOf(order.getPassengerId()));
				passenger.setReceiverName(order.getPassengerName());
				fitPassengers.add(passenger);
			}
		}
		return fitPassengers;
	}
	
	/**
     *  根据登陆人和游玩人  获得所有人信息 组装
     * @author wanghuihui
     * @date:2015年12月30日 下午2:59:06
     * @param fitPassengers
     * @param customer
     * @param inputForm 
     * @return
     */
    private List<FitPassengerInfoDto> getFitPassenger(List<FitPassengerInfoDto> fitPassengers, BookingInputForm inputForm) {
    	if(null == fitPassengers || fitPassengers.size() ==0){
    		throw new ExceptionWrapper("游玩人信息为空！");
    	}
		boolean isNotExist = true;
		for(int i=0;i<fitPassengers.size();i++){
			FitPassengerInfoDto passenger = fitPassengers.get(i);
			if(!StringUtils.isEmpty(passenger.getReceiverId()) && !StringUtils.isEmpty(inputForm.getReceiverId())){
				if(passenger.getReceiverId().equals(inputForm.getReceiverId()+"")){
					isNotExist = false;
					passenger.setEmail(inputForm.getEmail());
					fitPassengers.set(i, passenger);
					break;
				}
			}
			if(StringUtils.isEmpty(passenger.getReceiverId()) && StringUtils.isEmpty(inputForm.getReceiverId())){
				if(passenger.getReceiverName().equals(inputForm.getName()) && passenger.getMobileNumber().equals(inputForm.getMobile())){
					isNotExist = false;
					passenger.setEmail(inputForm.getEmail());
					fitPassengers.set(i, passenger);
					break;
				}
				
			}
		}
		if(isNotExist){
			FitPassengerInfoDto passenger = new FitPassengerInfoDto();
			if(StringUtil.isNotEmptyString(inputForm.getBirthday())){
				passenger.setBirthday(DateUtils.parseDate(inputForm.getBirthday()));
			}
			passenger.setCertNo(inputForm.getCertNo());
			passenger.setCertType(inputForm.getCertType());  // 政件类型
			passenger.setMobileNumber(inputForm.getMobile());
			passenger.setPeopleType(inputForm.getPeopleType()); //乘客类型
			passenger.setEmail(inputForm.getEmail());//邮件
			passenger.setReceiverId(String.valueOf(inputForm.getReceiverId()));
			passenger.setReceiverName(inputForm.getName());
			fitPassengers.add(passenger);
		}
		return fitPassengers;
	}
}
