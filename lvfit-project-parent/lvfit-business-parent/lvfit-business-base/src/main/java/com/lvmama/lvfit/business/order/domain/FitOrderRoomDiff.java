package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitOrderRoomDiffDto;

public class FitOrderRoomDiff implements Domain<FitOrderRoomDiffDto>{

	private FitOrderRoomDiffDto self;
	
	@Override
	public FitOrderRoomDiffDto self() {
		return self;
	}

	public FitOrderRoomDiff(FitOrderRoomDiffDto self) {
		super();
		this.self = self;
	}
}
