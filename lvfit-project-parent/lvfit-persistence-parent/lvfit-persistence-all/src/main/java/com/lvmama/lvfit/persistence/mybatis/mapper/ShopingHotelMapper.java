package com.lvmama.lvfit.persistence.mybatis.mapper;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByCodeMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingFlightDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingHotelDto;

public interface ShopingHotelMapper extends DomainEntityBaseMapper<
ShoppingHotelDto, BaseQueryDto<? extends Dto>>,DomainEntityByCodeMapper<ShoppingHotelDto>{
	/**
	 * 根据shopCode加载酒店信息
	 * @param code
	 * @return
	 */
	public List<ShoppingHotelDto> getListByCode(String code);

	public List<ShoppingHotelDto> getAllByShoppinguuid(String shoppingUuId);
}
