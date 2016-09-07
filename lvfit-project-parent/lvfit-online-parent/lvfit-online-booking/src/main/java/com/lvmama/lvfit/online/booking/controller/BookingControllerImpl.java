package com.lvmama.lvfit.online.booking.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.codehaus.jackson.type.JavaType;
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
import com.lvmama.lvfit.common.client.FitDpClient;
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
import com.lvmama.lvfit.online.base.BaseController;
import com.lvmama.lvfit.online.base.utils.DateUtil;
import com.lvmama.lvfit.online.base.utils.IpUtils;
import com.lvmama.lvfit.online.utils.ServletUtil;


@Controller
public class BookingControllerImpl extends BaseController implements BookingController<BookingInputForm, BaseResponseDto<BookingResultForm>>{
	private final static Logger logger = org.slf4j.LoggerFactory.getLogger(BookingControllerImpl.class);
	/**	 * 预授权页面	 */
	private final String PREPAID_PAGE="http://pay.lvmama.com/payfront/view/preSalePowerView.do";
	@Autowired
	private FitDpClient dpclient;

    @Autowired
    private FitVstClient vstClient;

    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/order/Booking", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> booking(Model model,HttpServletRequest request, HttpServletResponse response,BookingInputForm inputForm) {
    	
	    Map<String,Object> map = new HashMap<String, Object>();
		BaseSingleResultDto<FitOrderMainDto> resultDto = new BaseSingleResultDto<FitOrderMainDto>() ;
		List<FitPassengerInfoDto> fitPassengers = null;
		FitOrderBookingRequest bookRequest = inputForm.getFitOrderBookingRequest();
		JavaType javaType = JSONMapper.getInstance().getTypeFactory().constructParametricType(ArrayList.class, FitOrderPassengerDto.class);
		List<FitOrderPassengerDto> passengerList = new ArrayList<FitOrderPassengerDto>();
		try {
			passengerList = (List<FitOrderPassengerDto>)JSONMapper.getInstance().readValue(inputForm.getPlayerList(), javaType);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 
		inputForm.setFitOrderPassengerDtos(passengerList);
		fitPassengers = getFitPassengerInfoList(fitPassengers,passengerList); 
		//1. 获得联系人
		inputForm = this.getInputForm(request,inputForm);
		FitOrderCustomerDto customer = inputForm.getFitOrderCustomerDto();
		String userCode = customer.getCustomerId();
		FitOrderPassengerRequest passRequest = new FitOrderPassengerRequest();
		fitPassengers = getFitPassenger(fitPassengers,inputForm);
		passRequest.setFitPassengers(fitPassengers);
		passRequest.setUserId(userCode);
		//2. 保存联系人(保存联系人失败不影响下单)
		try {
			vstClient.saveOrderPassengerInfo(passRequest);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage());
		}
		bookRequest.setShoppingUuid(inputForm.getShoppingUUID());
		FitOrderAmountDto amountDto = new FitOrderAmountDto();
		amountDto.setTotalAmount(inputForm.getTotalPrice());
		bookRequest.setFitOrderAmountDto(amountDto);
		bookRequest.setVisitTime(inputForm.getVisitTime());
		if(this.getIsBackBooking(request).booleanValue()){
			bookRequest.setBookingSource(BookingSource.FIT_BACK);
		}else{
			bookRequest.setBookingSource(BookingSource.FIT_FRONT);
		}
		bookRequest.setProductName(inputForm.getProductName());
		//3. 下单
		resultDto = dpclient.booking(bookRequest);
		FitOrderMainDto orderMainDto = resultDto.getResult();
		FlightBookingSuccessRequest bookResultRequest = new FlightBookingSuccessRequest();
		FitPaymentUrlDto fitPaymentUrlDto = buildPayParam(bookRequest, orderMainDto);
		String orderNameKey="order_title_"+fitPaymentUrlDto.getOrderName();
		ServletUtil.putSession(request, response, orderNameKey, orderMainDto.getProductName());
		bookResultRequest.setFitPaymentUrlDto(fitPaymentUrlDto);
		
		if(this.getIsBackBooking(request)){
			try {
				Thread.sleep(15*1000l);
			} catch (InterruptedException e) {
			    ExceptionUtils.getStackTrace(e);
			}
			String url = request.getContextPath()+"/order/viewDetail?orderId="+orderMainDto.getFitSuppMainOrderDto().getVstMainOrderNo();
			map.put("successUrl",url);
		}else{
			String url = vstClient.getPaymentUrl(bookResultRequest);
			map.put("successUrl",PREPAID_PAGE+url);
		}
		return map;
       
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
    
    /**
     *  获得 系统登陆人信息
     * @author wanghuihui
     * @date:2015年12月30日 下午2:58:29
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

	private List<FitPassengerInfoDto> getFitPassengerInfoList(List<FitPassengerInfoDto> fitPassengers,
			List<FitOrderPassengerDto> passengerList) {
		if(null != passengerList && passengerList.size() >0){
			fitPassengers = new ArrayList<FitPassengerInfoDto>();
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
			return fitPassengers;
		}
		return null;
	}

	private FitPaymentUrlDto buildPayParam(FitOrderBookingRequest bookRequest, FitOrderMainDto result) {
    	FitPaymentUrlDto fitPaymentUrlDto = new FitPaymentUrlDto();
		if(result == null){
			return fitPaymentUrlDto;
		}
		 String  approveTime=DateUtil.formatDate(new Date(), "yyyyMMddHHmmss");
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
	
	private FitPaymentUrlDto buildPayParamTemp(FitOrderBookingRequest bookRequest) {
		FitPaymentUrlDto fitPaymentUrlDto = new FitPaymentUrlDto();
		String  approveTime=DateUtil.formatDate(new Date(), "yyyyMMddHHmmss");
		String visitTime=bookRequest.getVisitTime().replaceAll("-", "")+ "000000";
		fitPaymentUrlDto.setWaitPayment(String.valueOf(60)); //默认一个小时
		fitPaymentUrlDto.setVisitTime(visitTime);
		fitPaymentUrlDto.setApproveTime(approveTime);
		fitPaymentUrlDto.setOrderId(20022823L);
//		 fitPaymentUrlDto.setOrderId(result.getFitSuppMainOrderDto().getVstMainOrderId());
		fitPaymentUrlDto.setPreOrNormal("PRE");    // pre:是预授权  "NORMAL":正常
		return fitPaymentUrlDto;
	}
    
    
    @RequestMapping(value = "/order/bookfailed", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
	@Override
	public Map<String, Object> bookingFail(Model model, HttpServletRequest request,
			HttpServletResponse response, BookingInputForm inputForm) {
    	Map<String,Object> map = new HashMap<String, Object>();
    	BaseSingleResultDto baseResult = new BaseSingleResultDto();
		if(!StringUtils.isEmpty(inputForm.getShoppingUUID())){
			try {
				baseResult = dpclient.putShoppingInfo(inputForm.getShoppingUUID());
				if("success".equals(baseResult.getErrCode())){
					map.put("errCode","success" );
			        map.put("desc", "刷新缓存成功!");
				}else{
					map.put("errCode","fail" );
			        map.put("desc", "刷新缓存失败!");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				map.put("errCode","fail" );
		        map.put("desc", "刷新缓存失败!");
			}
		}
		return map;
		
	}
    
}

