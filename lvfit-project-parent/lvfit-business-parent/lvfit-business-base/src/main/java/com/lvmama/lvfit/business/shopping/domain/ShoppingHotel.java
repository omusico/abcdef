package com.lvmama.lvfit.business.shopping.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.shopping.ShoppingHotelDto;

public class ShoppingHotel implements Domain<ShoppingHotelDto> {

	private ShoppingHotelDto self;
	
	@Override
	public ShoppingHotelDto self() {
		return self;
	}

	public ShoppingHotel(ShoppingHotelDto self) {
		super();
		this.self = self;
	}
}