package com.lvmama.lvf.common.dto.calculator;

import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.dto.enums.PassengerType;

public class BookingDetailDto {
	
	/** 去程或回程 */
	private FlightTripType flightTripType;

	/** 乘客类型*/
	private PassengerType passengerType;
	
	/**航班相关信息*/
	private FlightSimpleInfoDto flightSimpleInfo;

	/**保险类型+数量 */
	private List<InsuranceCalculatRequest> insuranceCalculatRequests = new ArrayList<InsuranceCalculatRequest>();

	public PassengerType getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}


	public FlightSimpleInfoDto getFlightSimpleInfo() {
		return flightSimpleInfo;
	}

	public void setFlightSimpleInfo(FlightSimpleInfoDto flightSimpleInfo) {
		this.flightSimpleInfo = flightSimpleInfo;
	}

	public List<InsuranceCalculatRequest> getInsuranceCalculatRequests() {
		return insuranceCalculatRequests;
	}

	public void setInsuranceCalculatRequests(
			List<InsuranceCalculatRequest> insuranceCalculatRequests) {
		this.insuranceCalculatRequests = insuranceCalculatRequests;
	}

	public FlightTripType getFlightTripType() {
		return flightTripType;
	}

	public void setFlightTripType(FlightTripType flightTripType) {
		this.flightTripType = flightTripType;
	}
}
