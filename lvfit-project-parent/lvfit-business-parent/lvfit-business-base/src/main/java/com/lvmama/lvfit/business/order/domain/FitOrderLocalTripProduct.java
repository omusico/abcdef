package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitOrderLocalTripProductDto;

public class FitOrderLocalTripProduct implements Domain<FitOrderLocalTripProductDto> {

	private FitOrderLocalTripProductDto self = new FitOrderLocalTripProductDto();
	
	@Override
	public FitOrderLocalTripProductDto self() {
		return self;
	}

	public FitOrderLocalTripProduct(FitOrderLocalTripProductDto self) {
		super();
		this.self = self;
	}
}