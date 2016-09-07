package com.lvmama.lvfit.persistence.mybatis.mapper;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByFkIdMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.order.FitOrderStatusDto;

/**
 * 订单状态Mapper
 * @author qihuisong
 */
public interface FitOrderStatusMapper
		extends
		DomainEntityBaseMapper<FitOrderStatusDto, BaseQueryDto<? extends Dto>>,
		DomainEntityByFkIdMapper<FitOrderStatusDto> {
}
