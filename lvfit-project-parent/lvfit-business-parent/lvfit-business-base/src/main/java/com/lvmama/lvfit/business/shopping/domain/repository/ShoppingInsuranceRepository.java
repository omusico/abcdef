package com.lvmama.lvfit.business.shopping.domain.repository;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvfit.business.shopping.domain.ShoppingInsurance;
import com.lvmama.lvfit.common.dto.shopping.ShoppingInsuranceDto;

public interface ShoppingInsuranceRepository extends DomainBaseRepository< ShoppingInsurance, ShoppingInsuranceDto>{
	public List<ShoppingInsuranceDto> getListByCode(String code);
	public List<ShoppingInsuranceDto> getLatestListByCode(String code);
}
