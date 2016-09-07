package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderStatusDto;

public class FitSuppOrderStatus implements Domain<FitSuppOrderStatusDto> {

    private FitSuppOrderStatusDto self = new FitSuppOrderStatusDto();

    @Override
    public FitSuppOrderStatusDto self() {
        return this.self;
    }

   
}
