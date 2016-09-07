package com.lvmama.lvfit.persistence.mybatis.mapper;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByFkIdMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.order.FitOrderExpressDto;

/**
 * 订单快递信息Mapper
 * @author qihuisong
 */
public interface FitOrderExpressMapper
		extends
		DomainEntityBaseMapper<FitOrderExpressDto, BaseQueryDto<? extends Dto>>,
		DomainEntityByFkIdMapper<FitOrderExpressDto> {
}
