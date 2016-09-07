package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitOrderFlightDto;

public class FitOrderFlight implements Domain<FitOrderFlightDto> {

    private FitOrderFlightDto self = new FitOrderFlightDto();

    @Override
    public FitOrderFlightDto self() {
        return this.self;
    }

    public FitOrderFlightDto getSelf() {
        return self;
    }
}
