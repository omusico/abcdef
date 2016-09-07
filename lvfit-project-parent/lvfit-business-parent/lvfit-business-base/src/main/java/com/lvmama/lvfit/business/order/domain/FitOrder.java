package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitOrderDto;

/**
 * @author qihuisong
 */
public class FitOrder implements Domain<FitOrderDto> {

    private FitOrderDto self;

    @Override
    public FitOrderDto self() {
        return this.self;
    }
}
