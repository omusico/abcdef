package com.lvmama.lvfit.persistence.mybatis.mapper;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityRMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.order.FitOrderRemarkDto;

/**
 * 备注信息
 * @author qihuisong
 */
public interface FitOrderRemarkMapper
		extends
		DomainEntityBaseMapper<FitOrderRemarkDto, BaseQueryDto<? extends Dto>>,
		DomainEntityRMapper<FitOrderRemarkDto> {
}