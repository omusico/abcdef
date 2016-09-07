package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitOrderRemarkDto;

public class FitOrderRemark implements Domain<FitOrderRemarkDto> {

    private FitOrderRemarkDto self;

    @Override
    public FitOrderRemarkDto self() {
        return this.self;
    }
}
