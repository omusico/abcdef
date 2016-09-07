package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitOrderInsuranceDto;

public class FitOrderInsurance implements Domain<FitOrderInsuranceDto> {

	private FitOrderInsuranceDto self;
	
	@Override
	public FitOrderInsuranceDto self() {
		return self;
	}

	public FitOrderInsurance(FitOrderInsuranceDto self) {
		super();
		this.self = self;
	}
}