package com.lvmama.lvfit.persistence.mybatis.mapper;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByFkIdMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.order.FitSuppFlightOrderDto;

/**
 * VST子订单关系Mapper
 */
public interface FitSuppFlightOrderMapper extends DomainEntityBaseMapper<FitSuppFlightOrderDto, BaseQueryDto<? extends Dto>>, DomainEntityByFkIdMapper<FitSuppFlightOrderDto> {
}
