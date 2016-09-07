package com.lvmama.lvfit.persistence.mybatis.mapper;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByFkIdMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.order.FitOrderPassengerDto;

/**
 * 订单乘机人信息
 * @author qihuisong
 */
public interface FitOrderPassengerMapper
		extends
		DomainEntityBaseMapper<FitOrderPassengerDto, BaseQueryDto<? extends Dto>>,
		DomainEntityByFkIdMapper<FitOrderPassengerDto> {
}
