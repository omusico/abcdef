package com.lvmama.lvfit.persistence.mybatis.mapper;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByCodeMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingInsuranceDto;

public interface ShoppingInsuranceMapper extends
		DomainEntityBaseMapper<ShoppingInsuranceDto, BaseQueryDto<? extends Dto>>,
		DomainEntityByCodeMapper<ShoppingInsuranceDto> {
	/**
	 * 根据shopCode加载门票信息
	 * 
	 * @param code
	 * @return
	 */
	public List<ShoppingInsuranceDto> getListByCode(String code);
	
	/**
	 * 根据shopCode加载门票信息
	 * 
	 * @param code
	 * @return
	 */
	public List<ShoppingInsuranceDto> getLatestListByCode(String code);
}
