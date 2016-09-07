package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lvmama.lvf.common.dto.enums.PassengerType;

public class FlightBookingVerifyRequest implements Serializable{

	private static final long serialVersionUID = -4395265326270221698L;
	
	private Boolean isBookingAgain = false;
	
	private Map<PassengerType,Integer> passengerMap = new HashMap<PassengerType, Integer>(); 
	
	private List<FlightBookingVerifyDetailRequest> verifyDetailRequests = new ArrayList<FlightBookingVerifyDetailRequest>();

	public Map<PassengerType, Integer> getPassengerMap() {
		return passengerMap;
	}

	public void setPassengerMap(Map<PassengerType, Integer> passengerMap) {
		this.passengerMap = passengerMap;
	}

	public List<FlightBookingVerifyDetailRequest> getVerifyDetailRequests() {
		return verifyDetailRequests;
	}

	public void setVerifyDetailRequests(
			List<FlightBookingVerifyDetailRequest> verifyDetailRequests) {
		this.verifyDetailRequests = verifyDetailRequests;
	}

	public Boolean getIsBookingAgain() {
		return isBookingAgain;
	}

	public void setIsBookingAgain(Boolean isBookingAgain) {
		this.isBookingAgain = isBookingAgain;
	}
	
}
