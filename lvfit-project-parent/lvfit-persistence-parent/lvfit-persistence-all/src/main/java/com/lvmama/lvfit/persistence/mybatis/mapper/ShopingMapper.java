package com.lvmama.lvfit.persistence.mybatis.mapper;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByCodeMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingDetailDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingHotelDto;

public interface ShopingMapper extends 
 DomainEntityBaseMapper<ShoppingDetailDto, BaseQueryDto<? extends Dto>>,
 DomainEntityByCodeMapper<ShoppingDetailDto>{
	/**
	 * 根据shopCode加载购物车信息
	 * @param code
	 * @return
	 */
	public List<ShoppingDetailDto> getListByCode(String code);

}
