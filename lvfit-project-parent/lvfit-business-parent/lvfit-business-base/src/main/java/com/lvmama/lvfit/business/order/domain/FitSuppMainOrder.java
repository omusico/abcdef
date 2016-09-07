package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;

public class FitSuppMainOrder implements Domain<FitSuppMainOrderDto> {


    private FitSuppMainOrderDto self = new FitSuppMainOrderDto();

    @Override
    public FitSuppMainOrderDto self() {
        return this.self;
    }

    public FitSuppMainOrderDto getSelf() {
        return self;
    }
  
}
