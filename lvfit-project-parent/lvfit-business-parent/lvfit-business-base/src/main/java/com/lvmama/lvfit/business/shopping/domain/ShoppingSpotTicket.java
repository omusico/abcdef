package com.lvmama.lvfit.business.shopping.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.shopping.ShoppingSpotTicketDto;

public class ShoppingSpotTicket implements Domain<ShoppingSpotTicketDto> {

	private ShoppingSpotTicketDto self;
	
	@Override
	public ShoppingSpotTicketDto self() {
		return self;
	}

	public ShoppingSpotTicket(ShoppingSpotTicketDto self) {
		super();
		this.self = self;
	}
}