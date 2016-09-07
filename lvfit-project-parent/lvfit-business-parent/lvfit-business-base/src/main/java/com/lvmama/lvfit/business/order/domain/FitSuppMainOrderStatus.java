package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderStatusDto;

public class FitSuppMainOrderStatus implements Domain<FitSuppMainOrderStatusDto> {

    private FitSuppMainOrderStatusDto self = new FitSuppMainOrderStatusDto();

    @Override
    public FitSuppMainOrderStatusDto self() {
        return this.self;
    }

   
}
