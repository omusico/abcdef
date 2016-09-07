package com.lvmama.lvf.common.form.order;

import java.util.List;

import com.lvmama.lvf.common.dto.order.FlightOrderLinkInfoDto;
import com.lvmama.lvf.common.form.Form;

public class FlightOrderLinkInfoResultForm implements Form {

	
	private List<FlightOrderLinkInfoDto> flightOrderLinkInfoDtos;

	public List<FlightOrderLinkInfoDto> getFlightOrderLinkInfoDtos() {
		return flightOrderLinkInfoDtos;
	}

	public void setFlightOrderLinkInfoDtos(
			List<FlightOrderLinkInfoDto> flightOrderLinkInfoDtos) {
		this.flightOrderLinkInfoDtos = flightOrderLinkInfoDtos;
	}

	
}
