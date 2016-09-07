package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitOrderOtherTicketDto;

public class FitOrderOtherTicket implements Domain<FitOrderOtherTicketDto> {

	private FitOrderOtherTicketDto self = new FitOrderOtherTicketDto();
	
	@Override
	public FitOrderOtherTicketDto self() {
		return self;
	}

	public FitOrderOtherTicket(FitOrderOtherTicketDto self) {
		super();
		this.self = self;
	}
}