package com.lvmama.lvfit.persistence.mybatis.mapper;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByFkIdMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.order.FitSuppFlightOrderDetailDto;

/**
 * VST子订单关系Mapper
 */
public interface FitSuppFlightOrderDetailMapper extends DomainEntityBaseMapper<FitSuppFlightOrderDetailDto, BaseQueryDto<? extends Dto>>, DomainEntityByFkIdMapper<FitSuppFlightOrderDetailDto> {
}
