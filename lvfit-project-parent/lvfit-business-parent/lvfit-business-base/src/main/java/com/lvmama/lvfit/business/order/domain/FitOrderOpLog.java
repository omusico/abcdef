package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitOrderOpLogDto;

public class FitOrderOpLog implements Domain<FitOrderOpLogDto> {

    private FitOrderOpLogDto self;

    @Override
    public FitOrderOpLogDto self() {
        return this.self;
    }
}
