package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitOrderStatusDto;

public class FitOrderStatus implements Domain<FitOrderStatusDto> {

    private FitOrderStatusDto self;

    @Override
    public FitOrderStatusDto self() {
        return this.self;
    }
}
