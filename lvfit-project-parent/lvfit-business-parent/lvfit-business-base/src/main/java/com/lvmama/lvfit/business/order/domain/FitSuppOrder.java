package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderDto;

public class FitSuppOrder implements Domain<FitSuppOrderDto> {

    private FitSuppOrderDto self = new FitSuppOrderDto();

    @Override
    public FitSuppOrderDto self() {
        return this.self;
    }

   
}
