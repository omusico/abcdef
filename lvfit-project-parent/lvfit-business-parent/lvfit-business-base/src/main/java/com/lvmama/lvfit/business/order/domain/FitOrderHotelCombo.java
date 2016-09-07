package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelComboDto;

public class FitOrderHotelCombo implements Domain<FitOrderHotelComboDto> {

	private FitOrderHotelComboDto self = new FitOrderHotelComboDto();
	
	@Override
	public FitOrderHotelComboDto self() {
		return self;
	}

	public FitOrderHotelCombo(FitOrderHotelComboDto self) {
		super();
		this.self = self;
	}
}