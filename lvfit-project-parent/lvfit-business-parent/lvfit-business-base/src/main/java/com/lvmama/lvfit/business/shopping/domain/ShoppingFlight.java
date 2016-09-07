package com.lvmama.lvfit.business.shopping.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.shopping.ShoppingFlightDto;

public class ShoppingFlight implements Domain<ShoppingFlightDto> {

	private ShoppingFlightDto self;
	
	@Override
	public ShoppingFlightDto self() {
		return self;
	}

	public ShoppingFlight(ShoppingFlightDto self) {
		super();
		this.self = self;
	}
}