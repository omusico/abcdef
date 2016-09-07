package com.lvmama.lvfit.persistence.mybatis.mapper;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByCodeMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.shopping.FlightInsuranceDto;

public interface ShoppingFlightInsuranceMapper extends
		DomainEntityBaseMapper<FlightInsuranceDto, BaseQueryDto<? extends Dto>>,
		DomainEntityByCodeMapper<FlightInsuranceDto> {
	/**
	 * 根据shopCode加载航空意外险信息
	 * 
	 * @param code
	 * @return
	 */
	public List<FlightInsuranceDto> getListByCode(String code);
	
	/**
	 * 根据shopCode加载航空意外险信息
	 * 
	 * @param code
	 * @return
	 */
	public List<FlightInsuranceDto> getLatestListByCode(String code);
}
