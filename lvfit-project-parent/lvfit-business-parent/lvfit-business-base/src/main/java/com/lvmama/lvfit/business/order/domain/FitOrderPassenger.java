package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitOrderPassengerDto;

public class FitOrderPassenger implements Domain<FitOrderPassengerDto> {

    private FitOrderPassengerDto self;

    @Override
    public FitOrderPassengerDto self() {
        return this.self;
    }
}
