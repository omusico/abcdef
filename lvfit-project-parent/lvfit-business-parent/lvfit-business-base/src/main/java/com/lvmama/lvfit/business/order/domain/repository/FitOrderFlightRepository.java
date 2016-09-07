package com.lvmama.lvfit.business.order.domain.repository;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvfit.business.order.domain.FitOrderFlight;
import com.lvmama.lvfit.common.dto.order.FitOrderFlightDto;

public interface FitOrderFlightRepository extends DomainBaseRepository<FitOrderFlight, FitOrderFlightDto> {
    public List<FitOrderFlightDto> getOldFitOrderMainData(String vstOrderMainNo);
}
