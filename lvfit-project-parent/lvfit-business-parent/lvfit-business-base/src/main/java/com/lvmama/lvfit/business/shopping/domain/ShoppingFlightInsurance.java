package com.lvmama.lvfit.business.shopping.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.shopping.FlightInsuranceDto;

public class ShoppingFlightInsurance implements Domain<FlightInsuranceDto> {

	private FlightInsuranceDto self;
	
	@Override
	public FlightInsuranceDto self() {
		// TODO Auto-generated method stub
		return null;
	}

	public ShoppingFlightInsurance(FlightInsuranceDto self) {
		super();
		this.self = self;
	}

}
