package com.lvmama.lvfit.business.shopping.domain.repository;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvfit.business.shopping.domain.ShoppingFlightInsurance;
import com.lvmama.lvfit.common.dto.shopping.FlightInsuranceDto;

public interface ShoppingFlightInsuranceRepository extends DomainBaseRepository< ShoppingFlightInsurance, FlightInsuranceDto>{
	public List<FlightInsuranceDto> getListByCode(String code);
	public List<FlightInsuranceDto> getLatestListByCode(String code);
}
