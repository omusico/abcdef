package com.lvmama.lvf.common.form.booking;

import java.util.List;

import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.RouteType;
import com.lvmama.lvf.common.dto.flight.FlightAirLineDto;
import com.lvmama.lvf.common.dto.order.FlightOrderContacterDto;
import com.lvmama.lvf.common.dto.order.FlightOrderCustomerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderExpressDto;
import com.lvmama.lvf.common.dto.order.FlightOrderOperDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderRemarkDto;
import com.lvmama.lvf.common.dto.request.FlightOrderBookingDetailRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderBookingRequest;
import com.lvmama.lvf.common.form.Form;

/**
 * @author lutianyu
 * @date   2015-2-10
 */
public class ToBookingInputForm implements Form{
	private FlightOrderBookingRequest flightOrderBookingRequest = new FlightOrderBookingRequest();
	
	/** 出发城市名 */
	private String deptCityName;
	
	/** 到达城市名 */
	private String arrvCityName;
	
	private String vstOrderId;
	
	private String vstOrderMainId;

	/** 快递地址*/
	private List<FlightOrderExpressDto> addressList;
	
	/** 判读往返是否为真往返*/
	private String realRT;
	
	private UserMemberForm userMemberForm = new UserMemberForm();
	
	public String getUserId() {
		return userMemberForm.getUserId();
	}

	public void setUserId(String userId) {
		userMemberForm.setUserId(userId);
	}

	public String getUserName() {
		return userMemberForm.getUserName();
	}

	public void setUserName(String userName) {
		userMemberForm.setUserName(userName);
	}

	public String getGrade() {
		return userMemberForm.getGrade();
	}

	public void setGrade(String grade) {
		userMemberForm.setGrade(grade);
	}

	public String getUserCode() {
		return userMemberForm.getUserCode();
	}

	public void setUserCode(String userCode) {
		userMemberForm.setUserCode(userCode);
	}

	public int hashCode() {
		return userMemberForm.hashCode();
	}

	public boolean equals(Object obj) {
		return userMemberForm.equals(obj);
	}

	public String toString() {
		return userMemberForm.toString();
	}

	public FlightOrderBookingRequest getFlightOrderBookingRequest() {
		return flightOrderBookingRequest;
	}

	public void setFlightOrderBookingRequest(
			FlightOrderBookingRequest flightOrderBookingRequest) {
		this.flightOrderBookingRequest = flightOrderBookingRequest;
	}

	public String getDeptCityName() {
		return deptCityName;
	}

	public void setDeptCityName(String deptCityName) {
		this.deptCityName = deptCityName;
	}

	public String getArrvCityName() {
		return arrvCityName;
	}

	public void setArrvCityName(String arrvCityName) {
		this.arrvCityName = arrvCityName;
	}

	public RouteType getRouteType() {
		return flightOrderBookingRequest.getRouteType();
	}

	public void setRouteType(RouteType routeType) {
		flightOrderBookingRequest.setRouteType(routeType);
	}

	public FlightAirLineDto getFlightAirLine() {
		return flightOrderBookingRequest.getFlightAirLine();
	}

	public void setFlightAirLine(FlightAirLineDto flightAirLine) {
		flightOrderBookingRequest.setFlightAirLine(flightAirLine);
	}

	public List<FlightOrderBookingDetailRequest> getFlightOrderBookingDetailRequests() {
		return flightOrderBookingRequest.getFlightOrderBookingDetailRequests();
	}

	public void setFlightOrderBookingDetailRequests(
			List<FlightOrderBookingDetailRequest> flightOrderBookingDetailRequests) {
		flightOrderBookingRequest
				.setFlightOrderBookingDetailRequests(flightOrderBookingDetailRequests);
	}

	public List<FlightOrderPassengerDto> getFlightOrderPassengers() {
		return flightOrderBookingRequest.getFlightOrderPassengers();
	}

	public void setFlightOrderPassengers(
			List<FlightOrderPassengerDto> flightOrderPassengers) {
		flightOrderBookingRequest
				.setFlightOrderPassengers(flightOrderPassengers);
	}

	public FlightOrderContacterDto getFlightOrderContacter() {
		return flightOrderBookingRequest.getFlightOrderContacter();
	}

	public void setFlightOrderContacter(
			FlightOrderContacterDto flightOrderContacter) {
		flightOrderBookingRequest.setFlightOrderContacter(flightOrderContacter);
	}

	public FlightOrderExpressDto getFlightOrderExpress() {
		return flightOrderBookingRequest.getFlightOrderExpress();
	}

	public void setFlightOrderExpress(FlightOrderExpressDto flightOrderExpress) {
		flightOrderBookingRequest.setFlightOrderExpress(flightOrderExpress);
	}

	public FlightOrderOperDto getFlightOrderOper() {
		return flightOrderBookingRequest.getFlightOrderOper();
	}

	public void setFlightOrderOper(FlightOrderOperDto flightOrderOper) {
		flightOrderBookingRequest.setFlightOrderOper(flightOrderOper);
	}

	public FlightOrderCustomerDto getFlightOrderCustomer() {
		return flightOrderBookingRequest.getFlightOrderCustomer();
	}

	public void setFlightOrderCustomer(
			FlightOrderCustomerDto flightOrderCustomer) {
		flightOrderBookingRequest.setFlightOrderCustomer(flightOrderCustomer);
	}

	public List<FlightOrderRemarkDto> getFlightOrderRemarks() {
		return flightOrderBookingRequest.getFlightOrderRemarks();
	}

	public void setFlightOrderRemarks(
			List<FlightOrderRemarkDto> flightOrderRemarks) {
		flightOrderBookingRequest.setFlightOrderRemarks(flightOrderRemarks);
	}

	public List<FlightOrderExpressDto> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<FlightOrderExpressDto> addressList) {
		this.addressList = addressList;
	}

	public UserMemberForm getUserMemberForm() {
		return userMemberForm;
	}

	public void setUserMemberForm(UserMemberForm userMemberForm) {
		this.userMemberForm = userMemberForm;
	}

	public String getVstOrderId() {
		return vstOrderId;
	}

	public void setVstOrderId(String vstOrderId) {
		this.vstOrderId = vstOrderId;
	}

	public BookingSource getBookingSource() {
		return flightOrderBookingRequest.getBookingSource();
	}

	public void setBookingSource(BookingSource bookingSource) {
		flightOrderBookingRequest.setBookingSource(bookingSource);
	}

	public String getVstOrderMainId() {
		return vstOrderMainId;
	}

	public void setVstOrderMainId(String vstOrderMainId) {
		this.vstOrderMainId = vstOrderMainId;
	}

	public String getRealRT() {
		return realRT;
	}

	public void setRealRT(String realRT) {
		this.realRT = realRT;
	}
}
