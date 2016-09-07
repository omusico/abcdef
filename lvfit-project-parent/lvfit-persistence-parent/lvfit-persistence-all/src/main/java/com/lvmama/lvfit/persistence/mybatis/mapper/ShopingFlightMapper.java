package com.lvmama.lvfit.persistence.mybatis.mapper;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByCodeMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingFlightDto;

public interface ShopingFlightMapper extends DomainEntityBaseMapper<
ShoppingFlightDto, BaseQueryDto<? extends Dto>>,DomainEntityByCodeMapper<ShoppingFlightDto>{
	/**
	 * 根据shoppingCode加载航班信息
	 * @param code
	 * @return
	 */
	public List<ShoppingFlightDto> getListByCode(String code);

	public List<ShoppingFlightDto> getAllByShoppinguuid(String shoppingUuId);

}
