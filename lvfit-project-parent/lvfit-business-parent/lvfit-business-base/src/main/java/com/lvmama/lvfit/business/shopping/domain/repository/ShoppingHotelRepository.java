package com.lvmama.lvfit.business.shopping.domain.repository;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvfit.business.shopping.domain.ShoppingHotel;
import com.lvmama.lvfit.common.dto.shopping.ShoppingFlightDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingHotelDto;

public interface ShoppingHotelRepository extends DomainBaseRepository< ShoppingHotel, ShoppingHotelDto>{
	public List<ShoppingHotelDto> getListByCode(String code);

	public List<ShoppingHotelDto> getAllByShoppinguuid(String shoppingUuId);

}
