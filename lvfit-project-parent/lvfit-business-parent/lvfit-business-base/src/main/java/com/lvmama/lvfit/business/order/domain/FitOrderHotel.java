package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelDto;

public class FitOrderHotel implements Domain<FitOrderHotelDto> {

    private FitOrderHotelDto self = new FitOrderHotelDto();

    @Override
    public FitOrderHotelDto self() {
        return this.self;
    }

    public FitOrderHotelDto getSelf() {
        return self;
    }

   
}
