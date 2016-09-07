package com.lvmama.lvfit.business.order.domain.repository;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvfit.business.order.domain.FitOrderFlightInsurance;
import com.lvmama.lvfit.common.dto.order.FitOrderFliInsuranceDto;

public interface FitOrderFlightInsuranceRepository extends DomainBaseRepository< FitOrderFlightInsurance, FitOrderFliInsuranceDto>{

	List<FitOrderFliInsuranceDto> getByOrderMainId(Long id);

}
