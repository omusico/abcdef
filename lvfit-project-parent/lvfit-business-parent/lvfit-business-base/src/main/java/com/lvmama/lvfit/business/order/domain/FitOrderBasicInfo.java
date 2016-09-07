package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitOrderBasicInfoDto;

public class FitOrderBasicInfo implements Domain<FitOrderBasicInfoDto> {

    private FitOrderBasicInfoDto self;

    @Override
    public FitOrderBasicInfoDto self() {
        return this.self;
    }
}

