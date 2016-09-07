package com.lvmama.lvf.common.dto.request;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.lvmama.lvf.common.dto.calculator.BookingDetailDto;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.enums.RouteType;
import com.lvmama.lvf.common.dto.flight.FlightAirLineDto;
import com.lvmama.lvf.common.dto.order.FlightOrderCPSInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderContacterDto;
import com.lvmama.lvf.common.dto.order.FlightOrderCustomerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderExpressDto;
import com.lvmama.lvf.common.dto.order.FlightOrderLoscInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderOperDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderRemarkDto;
import com.lvmama.lvf.common.dto.vst.UserMemberDto;

/**
 * 预订请求对象
 * @author majun
 * @date   2015-1-21
 */
public class FlightOrderBookingRequest implements Serializable 
{
	private static final long serialVersionUID = -6264309781036547799L;
	
	/** 航线类型 */
	private RouteType routeType;
	
	/** 航线信息 */
	private FlightAirLineDto flightAirLine;
	
	/** 订单客户信息 */
	private FlightOrderCustomerDto flightOrderCustomer;
	
	/** 联系人信息 */
	private FlightOrderContacterDto flightOrderContacter;
	
	/** 预订请求明细对象列表 */
	private List<FlightOrderBookingDetailRequest> flightOrderBookingDetailRequests = new ArrayList<FlightOrderBookingDetailRequest>(); 
	
	/** 乘客信息列表 */
	private List<FlightOrderPassengerDto> flightOrderPassengers = new ArrayList<FlightOrderPassengerDto>();
	
	/** 配送信息(订单快递信息) */
	private FlightOrderExpressDto flightOrderExpress;
	
	/** 订单操作者信息 */
	private FlightOrderOperDto flightOrderOper;
	
	/** 订单备注信息 */
	private List<FlightOrderRemarkDto> flightOrderRemarks = new ArrayList<FlightOrderRemarkDto>();
	
	/** 预订来源 */
	private BookingSource bookingSource = BookingSource.LAMAMA_BACK;
	
	/** VST订单预订参数 */
	private VSTOrderRequest vstOrderRequest;
	
	private FlightOrderSalesOrderRelationRequest relationRequest;
	
	private BigDecimal orderTotalSalesAmount;
	
	/** 乘客保险信息*/
	private List<BookingDetailDto> passengerDetailDtos = new ArrayList<BookingDetailDto>();
	
	/**会员信息Dto*/
	private UserMemberDto userMemberDto;
	
	private Boolean isRebooking = false;
	
	/** 供应商code */
	private String suppCode;
	
	/**订单记录推广losc**/
	private FlightOrderLoscInfoDto flightOrderLoscInfoDto;
	
	/**大交通&CPS对接项目记录*/
	private FlightOrderCPSInfoDto flightOrderCPSInfoDto;
	
	private String equipmentNo;
	
	private String realRT; //是否为真往返（暂时用于包机切位）
	
	//优惠券code
	private String couponCode;
	
	public String getCouponCode() {
		return couponCode;
	}
	
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	
	public List<BookingDetailDto> getPassengerDetailDtos() {
		return passengerDetailDtos;
	}

	public void setPassengerDetailDtos(List<BookingDetailDto> passengerDetailDtos) {
		this.passengerDetailDtos = passengerDetailDtos;
	}

	public RouteType getRouteType() {
		return routeType;
	}

	public void setRouteType(RouteType routeType) {
		this.routeType = routeType;
	}

	public FlightAirLineDto getFlightAirLine() {
		return flightAirLine;
	}

	public void setFlightAirLine(FlightAirLineDto flightAirLine) {
		this.flightAirLine = flightAirLine;
	}

	public List<FlightOrderBookingDetailRequest> getFlightOrderBookingDetailRequests() {
		if(flightOrderBookingDetailRequests == null)
			flightOrderBookingDetailRequests = new ArrayList<FlightOrderBookingDetailRequest>();
		return flightOrderBookingDetailRequests;
	}

	public void setFlightOrderBookingDetailRequests(
			List<FlightOrderBookingDetailRequest> flightOrderBookingDetailRequests) {
		this.flightOrderBookingDetailRequests = flightOrderBookingDetailRequests;
	}

	public List<FlightOrderPassengerDto> getFlightOrderPassengers() {
		return flightOrderPassengers;
	}

	public void setFlightOrderPassengers(
			List<FlightOrderPassengerDto> flightOrderPassengers) {
		this.flightOrderPassengers = flightOrderPassengers;
	}

	public FlightOrderContacterDto getFlightOrderContacter() {
		return flightOrderContacter;
	}

	public void setFlightOrderContacter(FlightOrderContacterDto flightOrderContacter) {
		this.flightOrderContacter = flightOrderContacter;
	}

	public FlightOrderExpressDto getFlightOrderExpress() {
		return flightOrderExpress;
	}

	public void setFlightOrderExpress(FlightOrderExpressDto flightOrderExpress) {
		this.flightOrderExpress = flightOrderExpress;
	}

	public FlightOrderOperDto getFlightOrderOper() {
		return flightOrderOper;
	}

	public void setFlightOrderOper(FlightOrderOperDto flightOrderOper) {
		this.flightOrderOper = flightOrderOper;
	}

	public FlightOrderCustomerDto getFlightOrderCustomer() {
		return flightOrderCustomer;
	}

	public void setFlightOrderCustomer(FlightOrderCustomerDto flightOrderCustomer) {
		this.flightOrderCustomer = flightOrderCustomer;
	}

	public List<FlightOrderRemarkDto> getFlightOrderRemarks() {
		return flightOrderRemarks;
	}

	public void setFlightOrderRemarks(List<FlightOrderRemarkDto> flightOrderRemarks) {
		this.flightOrderRemarks = flightOrderRemarks;
	}

	public BookingSource getBookingSource() {
		return bookingSource;
	}

	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}

	public VSTOrderRequest getVstOrderRequest() {
		return vstOrderRequest;
	}

	public void setVstOrderRequest(VSTOrderRequest vstOrderRequest) {
		this.vstOrderRequest = vstOrderRequest;
	}

	public BigDecimal getOrderTotalSalesAmount() {
		return orderTotalSalesAmount;
	}

	public void setOrderTotalSalesAmount(BigDecimal orderTotalSalesAmount) {
		this.orderTotalSalesAmount = orderTotalSalesAmount;
	}
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		String x = "{\"routeType\":\"OW\",\"deptCityName\":\"北京(PEK)\",\"arrvCityName\":\"大连(DLC)\",\"insuranceInfo\":\"48_1,\",\"flightOrderExpress\":{\"expressType\":\"EXPRESS\",\"recipient\":\"雷正伟\",\"cellphone\":\"15221819731\",\"telephone\":\"\",\"address\":\"金沙江路\",\"postCode\":\"200333\",\"expressWay\":{\"code\":\"100\"}},\"flightOrderRemarks\":[{\"remarkType\":\"CUSTOMER\",\"remark\":\"\"},{\"remarkType\":\"BACK\",\"remark\":\"\"}],\"flightOrderContacter\":{\"name\":\"雷正伟\",\"cellphone\":\"15221819731\",\"email\":\"\"},\"flightOrderBookingDetailRequests\":[{\"departureAirportCode\":\"PEK\",\"arrivalAirportCode\":\"DLC\",\"departureDate\":\"2015-10-03\",\"flightNo\":\"CA8904\",\"flightTripType\":\"DEPARTURE\",\"parPrice\":\"710\",\"policyId\":\"22225\",\"seatClassCode\":\"Y\"}],\"flightOrderPassengers\":[{\"uuid\":\"\",\"passengerType\":\"ADULT\",\"passengerName\":\"雷正伟\",\"gender\":\"MALE\",\"passengerIDCardType\":\"ID\",\"passengerIDCardNo\":\"420521198707300415\",\"passengerBirthday\":\"1987-07-29T16:00:00.000Z\",\"cellphone\":\"15221819731\"}],\"flightOrderCustomer\":{\"customerId\":\"12707\",\"customerName\":\"113498182\",\"customerLevel\":\"\",\"customerCode\":\"f2d0c2991d9adc8d011d9bacad12000d\"}}";
	    System.out.println(new ObjectMapper().readValue(x, FlightOrderBookingRequest.class));
	}

	public FlightOrderSalesOrderRelationRequest getRelationRequest() {
		return relationRequest;
	}

	public void setRelationRequest(FlightOrderSalesOrderRelationRequest relationRequest) {
		this.relationRequest = relationRequest;
	}

	public Boolean getIsRebooking() {
		return isRebooking;
	}

	public void setIsRebooking(Boolean isRebooking) {
		this.isRebooking = isRebooking;
	}

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	public UserMemberDto getUserMemberDto() {
		return userMemberDto;
	}

	public void setUserMemberDto(UserMemberDto userMemberDto) {
		this.userMemberDto = userMemberDto;
	}
	
	/**
	 * 是否含有儿童
	 * @param 
	 * @return
	 */
	public Boolean isAllAdultType() {
		for(FlightOrderPassengerDto flightOrderPassengerDto:flightOrderPassengers){
			if(PassengerType.CHILDREN.equals(flightOrderPassengerDto.getPassengerType()))
				return false;
		}
		return true;
	}

	public FlightOrderLoscInfoDto getFlightOrderLoscInfoDto() {
		return flightOrderLoscInfoDto;
	}

	public void setFlightOrderLoscInfoDto(
			FlightOrderLoscInfoDto flightOrderLoscInfoDto) {
		this.flightOrderLoscInfoDto = flightOrderLoscInfoDto;
	}

	public String getEquipmentNo() {
		return equipmentNo;
	}

	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}

	public FlightOrderCPSInfoDto getFlightOrderCPSInfoDto() {
		return flightOrderCPSInfoDto;
	}

	public void setFlightOrderCPSInfoDto(FlightOrderCPSInfoDto flightOrderCPSInfoDto) {
		this.flightOrderCPSInfoDto = flightOrderCPSInfoDto;
	}

	public String getRealRT() {
		return realRT;
	}

	public void setRealRT(String realRT) {
		this.realRT = realRT;
	}

}
