package com.lvmama.lvfit.persistence.mybatis.mapper;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByFkIdMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.order.FitOrderRoomDiffDto;

public interface FitOrderRoomDiffMapper extends DomainEntityBaseMapper<FitOrderRoomDiffDto, BaseQueryDto<? extends Dto>>,
		DomainEntityByFkIdMapper<FitOrderRoomDiffDto>{

}
