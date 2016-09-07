package com.lvmama.lvfit.persistence.mybatis.mapper;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByFkIdMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;

/**
 * VST子订单关系Mapper
 */
public interface FitSuppMainOrderMapper extends DomainEntityBaseMapper<FitSuppMainOrderDto, BaseQueryDto<? extends Dto>>,
        DomainEntityByFkIdMapper<FitSuppMainOrderDto>{
}
