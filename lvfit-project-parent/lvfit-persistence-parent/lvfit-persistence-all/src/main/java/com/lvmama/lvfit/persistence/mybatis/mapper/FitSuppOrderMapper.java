package com.lvmama.lvfit.persistence.mybatis.mapper;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByFkIdMapper;
import com.lvmama.lvf.common.domain.DomainEntityByNoMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderDto;

/**
 * VST子订单关系Mapper
 */
public interface FitSuppOrderMapper extends DomainEntityBaseMapper<FitSuppOrderDto, BaseQueryDto<? extends Dto>>, DomainEntityByFkIdMapper<FitSuppOrderDto>,DomainEntityByNoMapper<FitSuppOrderDto> {
}
