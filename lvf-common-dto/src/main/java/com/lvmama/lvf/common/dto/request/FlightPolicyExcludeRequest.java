package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.policy.FlightPolicyExcludeDto;

public class FlightPolicyExcludeRequest implements Serializable{

	private static final long serialVersionUID = -3074927047994284831L;

	private List<FlightPolicyExcludeDto> flightPolicyExcludeDtos = new ArrayList<FlightPolicyExcludeDto>();

	public List<FlightPolicyExcludeDto> getFlightPolicyExcludeDtos() {
		return flightPolicyExcludeDtos;
	}

	public void setFlightPolicyExcludeDtos(
			List<FlightPolicyExcludeDto> flightPolicyExcludeDtos) {
		this.flightPolicyExcludeDtos = flightPolicyExcludeDtos;
	}
	

}
