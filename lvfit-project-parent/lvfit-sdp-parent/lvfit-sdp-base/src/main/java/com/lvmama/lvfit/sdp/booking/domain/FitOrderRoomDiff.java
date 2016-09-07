package com.lvmama.lvfit.sdp.booking.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitOrderRoomDiffDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpRoomDiff;

public class FitOrderRoomDiff implements Domain<FitOrderRoomDiffDto>{
	
	FitOrderRoomDiffDto self = new FitOrderRoomDiffDto();

	
	public FitOrderRoomDiff() {
	}


	@Override
	public FitOrderRoomDiffDto self() {
		return this.self;
	}
	
	public FitOrderRoomDiff(FitOrderRoomDiffDto self) {
        super();
        this.self = self;
    }

	public FitOrderRoomDiffDto buildFitOrderRoomDiffDto(FitSdpRoomDiff selectRoomDiff) {
        this.self.setSelectCount(Long.valueOf(selectRoomDiff.getCount()));
        this.self.setSelectPrice(selectRoomDiff.getRoomDiffPrice());
        return this.self;
    }
}
