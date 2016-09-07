package com.lvmama.lvfit.business.shopping.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.shopping.ShoppingInsuranceDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingSpotTicketDto;

public class ShoppingInsurance implements Domain<ShoppingInsuranceDto> {

	private ShoppingInsuranceDto self;
	
	@Override
	public ShoppingInsuranceDto self() {
		return self;
	}

	public ShoppingInsurance(ShoppingInsuranceDto self) {
		super();
		this.self = self;
	}
}