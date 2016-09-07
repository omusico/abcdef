package com.lvmama.lvf.common.dto.response;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.flight.FlightSeatDto;
import com.lvmama.lvf.common.dto.flight.price.FlightPricePolicyDto;
import com.lvmama.lvf.common.dto.policy.FlightPolicyDto;

public class FlightSeatPolicyResponse implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6581439090694016561L;
	
	private FlightSeatDto flightSeatDto;
	
	private FlightPolicyDto flightPolicyDto;
	
	private FlightPricePolicyDto flightPricePolicyDto;
	
	public FlightSeatDto getFlightSeatDto() {
		return flightSeatDto;
	}
	public void setFlightSeatDto(FlightSeatDto flightSeatDto) {
		this.flightSeatDto = flightSeatDto;
	}
	public FlightPolicyDto getFlightPolicyDto() {
		return flightPolicyDto;
	}
	public void setFlightPolicyDto(FlightPolicyDto flightPolicyDto) {
		this.flightPolicyDto = flightPolicyDto;
	}
	public FlightPricePolicyDto getFlightPricePolicyDto() {
		return flightPricePolicyDto;
	}
	public void setFlightPricePolicyDto(FlightPricePolicyDto flightPricePolicyDto) {
		this.flightPricePolicyDto = flightPricePolicyDto;
	}
	
}
