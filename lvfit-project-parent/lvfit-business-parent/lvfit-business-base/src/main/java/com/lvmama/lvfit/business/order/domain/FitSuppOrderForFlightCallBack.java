package com.lvmama.lvfit.business.order.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderForFlightCallBackDto;

public class FitSuppOrderForFlightCallBack implements Domain<FitSuppOrderForFlightCallBackDto> {


    private FitSuppOrderForFlightCallBackDto self = new FitSuppOrderForFlightCallBackDto();

    @Override
    public FitSuppOrderForFlightCallBackDto self() {
        return this.self;
    }

    public FitSuppOrderForFlightCallBackDto getSelf() {
        return self;
    }
  
}
