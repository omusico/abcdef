package com.lvmama.lvfit.persistence.mybatis.mapper;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByFkIdMapper;
import com.lvmama.lvf.common.domain.DomainEntityByNoMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.order.FitOrderFliInsuranceDto;

public interface FitOrderFliInsuranceMapper
		extends
		DomainEntityBaseMapper<FitOrderFliInsuranceDto, BaseQueryDto<? extends Dto>>,
		DomainEntityByNoMapper<FitOrderFliInsuranceDto>,
		DomainEntityByFkIdMapper<FitOrderFliInsuranceDto> {

	List<FitOrderFliInsuranceDto> getByOrderMainId(Long id);


}
