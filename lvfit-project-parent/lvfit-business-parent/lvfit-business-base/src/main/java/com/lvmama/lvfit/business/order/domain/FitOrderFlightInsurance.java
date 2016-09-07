package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitOrderFliInsuranceDto;

public class FitOrderFlightInsurance implements Domain<FitOrderFliInsuranceDto> {
	private FitOrderFliInsuranceDto self;
	
	@Override
	public FitOrderFliInsuranceDto self() {
		return self;
	}

	public FitOrderFlightInsurance(FitOrderFliInsuranceDto self) {
		super();
		this.self = self;
	}
}
