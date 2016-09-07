package com.lvmama.lvfit.business.shopping.domain.repository;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvfit.business.shopping.domain.ShoppingPassenger;
import com.lvmama.lvfit.common.dto.shopping.ShoppingHotelDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingPassengerDto;

public interface ShoppingPassengerRepository extends DomainBaseRepository< ShoppingPassenger, ShoppingPassengerDto>{
	
	public int deletesUpdate(List<ShoppingPassengerDto> list);
    
	public List<ShoppingPassengerDto> getListByCode(String code);

	public List<ShoppingPassengerDto> getAllByShoppinguuid(String shoppingUuId);

}
