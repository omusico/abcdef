package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitOrderSpotTicketDto;

public class FitOrderSpotTicket implements Domain<FitOrderSpotTicketDto> {

	private FitOrderSpotTicketDto self;
	
	@Override
	public FitOrderSpotTicketDto self() {
		return self;
	}

	public FitOrderSpotTicket(FitOrderSpotTicketDto self) {
		super();
		this.self = self;
	}
}