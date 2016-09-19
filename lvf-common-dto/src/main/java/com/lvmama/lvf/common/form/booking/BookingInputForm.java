package com.lvmama.lvf.common.form.booking;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.RouteType;
import com.lvmama.lvf.common.dto.flight.FlightAirLineDto;
import com.lvmama.lvf.common.dto.order.FlightOrderContacterDto;
import com.lvmama.lvf.common.dto.order.FlightOrderCustomerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderExpressDto;
import com.lvmama.lvf.common.dto.order.FlightOrderInsuranceDto;
import com.lvmama.lvf.common.dto.order.FlightOrderOperDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderRemarkDto;
import com.lvmama.lvf.common.dto.request.FlightOrderBookingDetailRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderBookingRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderSalesOrderRelationRequest;
import com.lvmama.lvf.common.form.Form;

/**
 * @author lutianyu
 * @date   2015-2-11
 */
public class BookingInputForm implements Form {
	private FlightOrderBookingRequest flightOrderBookingRequest = new FlightOrderBookingRequest();
	
	/** 出发城市名 */
	private String deptCityName;
	
	/** 到达城市名 */
	private String arrvCityName;
	
	/** 保险信息 */
	private String insuranceInfo;
	
	public BigDecimal getOrderTotalSalesAmount() {
		return flightOrderBookingRequest.getOrderTotalSalesAmount();
	}

	public void setOrderTotalSalesAmount(BigDecimal orderTotalSalesAmount) {
		flightOrderBookingRequest
				.setOrderTotalSalesAmount(orderTotalSalesAmount);
	}

	private List<ToBookingSegmentForm> flights = new ArrayList<ToBookingSegmentForm>();
	
	private UserMemberForm userMemberForm = new UserMemberForm();
	
	public FlightOrderBookingRequest getFlightOrderBookingRequest() {
		String insuranceInfo = this.getInsuranceInfo();
		List<FlightOrderPassengerDto> flightOrderPassengers = this.getFlightOrderPassengers();
		List<FlightOrderBookingDetailRequest> flightOrderBookingDetailRequests = this.getFlightOrderBookingDetailRequests();
		if(StringUtils.isNotBlank(insuranceInfo)){
			String[] insuranceInfos = insuranceInfo.split(",");
			if(CollectionUtils.isNotEmpty(flightOrderPassengers)){
					for (FlightOrderPassengerDto orderPassenger : flightOrderPassengers) {
						List<FlightOrderInsuranceDto> orderInsurances = new ArrayList<FlightOrderInsuranceDto>();
						for (FlightOrderBookingDetailRequest bookingDetailRequest : flightOrderBookingDetailRequests) { 
							for (String curInsuranceInfo : insuranceInfos) {
								String[] curInsuranceInfos = curInsuranceInfo.split("_");
								String insuranceInfoId = curInsuranceInfos[0];
								Integer insuranceInfoCount = Integer.parseInt(curInsuranceInfos[1]);
								for (int i = 0; i < insuranceInfoCount; i++) {
									FlightOrderInsuranceDto orderInsurance = new FlightOrderInsuranceDto();
									orderInsurance.setFlightNo(bookingDetailRequest.getFlightNo());
									orderInsurance.setInsuranceInfoId(Long.valueOf(insuranceInfoId));
									orderInsurances.add(orderInsurance);
								}
							}
						orderPassenger.setFlightOrderInsurances(orderInsurances);
				      }
				   }
			}
		}
		return flightOrderBookingRequest;
	}

	public void setFlightOrderBookingRequest(
			FlightOrderBookingRequest flightOrderBookingRequest) {
		this.flightOrderBookingRequest = flightOrderBookingRequest;
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
	
	public String getInsuranceInfo() {
		return insuranceInfo;
	}

	public void setInsuranceInfo(String insuranceInfo) {
		this.insuranceInfo = insuranceInfo;
	}

	public List<ToBookingSegmentForm> getFlights() {
		return flights;
	}

	public void setFlights(List<ToBookingSegmentForm> flights) {
		this.flights = flights;
	}

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


	public void setIsRebooking(Boolean isRebooking) {
		flightOrderBookingRequest.setIsRebooking(isRebooking);
	}

	public Boolean getIsRebooking() {
		return flightOrderBookingRequest.getIsRebooking();
	}

	public String getUserCellphone() {
		return userMemberForm.getUserCellphone();
	}

	public void setUserCellphone(String userCellphone) {
		userMemberForm.setUserCellphone(userCellphone);
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

	public UserMemberForm getUserMemberForm() {
		return userMemberForm;
	}

	public void setUserMemberForm(UserMemberForm userMemberForm) {
		this.userMemberForm = userMemberForm;
	}

	public BookingSource getBookingSource() {
		return flightOrderBookingRequest.getBookingSource();
	}

	public void setBookingSource(BookingSource bookingSource) {
		flightOrderBookingRequest.setBookingSource(bookingSource);
	}

	public FlightOrderSalesOrderRelationRequest getRelationRequest() {
		return flightOrderBookingRequest.getRelationRequest();
	}

	public void setRelationRequest(FlightOrderSalesOrderRelationRequest relationRequest) {
		flightOrderBookingRequest.setRelationRequest(relationRequest);
	}

	public void setRealRT(String realRT) {
		flightOrderBookingRequest.setRealRT(realRT);
	}

	public String getRealRT() {
		return flightOrderBookingRequest.getRealRT();
	}
	
	public void setCouponCode(String couponCode){
		flightOrderBookingRequest.setCouponCode(couponCode);
	}
	
	public String getCouponCode(){
		return flightOrderBookingRequest.getCouponCode();
	}
}
