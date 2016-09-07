package com.lvmama.lvf.common.form.policy;

import java.util.List;

import com.lvmama.lvf.common.dto.policy.FlightPolicyExcludeDto;
import com.lvmama.lvf.common.dto.request.FlightPolicyExcludeRequest;
import com.lvmama.lvf.common.form.Form;

public class FlightPolicyExcludeInputForm implements Form{

	private FlightPolicyExcludeRequest request = new FlightPolicyExcludeRequest();

	public FlightPolicyExcludeRequest getRequest() {
		return request;
	}

	public void setRequest(FlightPolicyExcludeRequest request) {
		this.request = request;
	}

	public List<FlightPolicyExcludeDto> getFlightPolicyExcludeDtos() {
		return request.getFlightPolicyExcludeDtos();
	}

	public void setFlightPolicyExcludeDtos(
			List<FlightPolicyExcludeDto> flightPolicyExcludeDtos) {
		request.setFlightPolicyExcludeDtos(flightPolicyExcludeDtos);
	}

	
}
