package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitSuppFlightOrderDto;

public class FitSuppFlightOrder implements Domain<FitSuppFlightOrderDto> {


    private FitSuppFlightOrderDto self = new FitSuppFlightOrderDto();

    @Override
    public FitSuppFlightOrderDto self() {
        return this.self;
    }

    public FitSuppFlightOrderDto getSelf() {
        return self;
    }
  
}
