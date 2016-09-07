package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.vst.FlightVstPassengerInfoDto;

/**
 * 
 * 常用联系人Request
 * 
 * @author zzs
 * 
 */
public class FlightOrderPassengerRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userId;
	
	private List<FlightVstPassengerInfoDto> flightOrderPassengers = new ArrayList<FlightVstPassengerInfoDto>();

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<FlightVstPassengerInfoDto> getFlightOrderPassengers() {
		return flightOrderPassengers;
	}

	public void setFlightOrderPassengers(List<FlightVstPassengerInfoDto> flightOrderPassengers) {
		this.flightOrderPassengers = flightOrderPassengers;
	}

}
