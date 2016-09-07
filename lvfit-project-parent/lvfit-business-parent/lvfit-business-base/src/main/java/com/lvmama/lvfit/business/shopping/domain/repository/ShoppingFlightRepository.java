package com.lvmama.lvfit.business.shopping.domain.repository;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvfit.business.shopping.domain.ShoppingFlight;
import com.lvmama.lvfit.common.dto.shopping.ShoppingFlightDto;

public interface ShoppingFlightRepository extends DomainBaseRepository< ShoppingFlight, ShoppingFlightDto>{

	public List<ShoppingFlightDto> getListByCode(String code);

	public List<ShoppingFlightDto> getAllByShoppinguuid(String shoppingUuId);
}
