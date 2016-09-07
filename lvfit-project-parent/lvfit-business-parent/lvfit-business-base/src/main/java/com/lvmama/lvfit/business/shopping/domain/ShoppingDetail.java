package com.lvmama.lvfit.business.shopping.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.shopping.ShoppingDetailDto;

public class ShoppingDetail implements Domain<ShoppingDetailDto> {

	private ShoppingDetailDto self;
	
	@Override
	public ShoppingDetailDto self() {
		return self;
	}

	public ShoppingDetail(ShoppingDetailDto self) {
		super();
		this.self = self;
	}
}