package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitSuppFlightOrderDetailDto;

public class FitSuppFlightOrderDetail implements Domain<FitSuppFlightOrderDetailDto> {


    private FitSuppFlightOrderDetailDto self = new FitSuppFlightOrderDetailDto();

    @Override
    public FitSuppFlightOrderDetailDto self() {
        return this.self;
    }

    public FitSuppFlightOrderDetailDto getSelf() {
        return self;
    }
  
}
