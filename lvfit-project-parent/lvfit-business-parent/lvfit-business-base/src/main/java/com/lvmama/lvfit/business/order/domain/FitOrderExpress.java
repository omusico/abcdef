package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitOrderExpressDto;

public class FitOrderExpress implements Domain<FitOrderExpressDto> {

    private FitOrderExpressDto self;

    @Override
    public FitOrderExpressDto self() {
        return this.self;
    }
}
