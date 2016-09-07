package com.lvmama.lvfit.persistence.mybatis.mapper;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByCodeMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingHotelDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingPassengerDto;

public interface ShopingPassengerMapper extends DomainEntityBaseMapper<
ShoppingPassengerDto, BaseQueryDto<? extends Dto>>,DomainEntityByCodeMapper<ShoppingPassengerDto>{
	/**
	 * 根据shopCode加载乘客信息
	 * @param code
	 * @return
	 */
	public List<ShoppingPassengerDto> getListByCode(String code);

	public List<ShoppingPassengerDto> getAllByShoppinguuid(String shoppingUuId);
}
