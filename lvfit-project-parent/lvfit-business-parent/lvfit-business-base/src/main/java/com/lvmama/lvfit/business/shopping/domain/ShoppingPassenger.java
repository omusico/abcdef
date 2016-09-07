package com.lvmama.lvfit.business.shopping.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.shopping.ShoppingPassengerDto;

public class ShoppingPassenger implements Domain<ShoppingPassengerDto> {

	private ShoppingPassengerDto self;
	
	@Override
	public ShoppingPassengerDto self() {
		return self;
	}

	public ShoppingPassenger(ShoppingPassengerDto self) {
		super();
		this.self = self;
	}
}