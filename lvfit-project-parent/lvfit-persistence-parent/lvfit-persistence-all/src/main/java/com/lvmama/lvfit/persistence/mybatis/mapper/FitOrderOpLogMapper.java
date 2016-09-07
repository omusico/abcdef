package com.lvmama.lvfit.persistence.mybatis.mapper;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByFkIdMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.order.FitOrderOpLogDto;

/**
 * 订单操作日志信息
 * @author qihuisong
 */
public interface FitOrderOpLogMapper extends
		DomainEntityBaseMapper<FitOrderOpLogDto, BaseQueryDto<? extends Dto>>,
		DomainEntityByFkIdMapper<FitOrderOpLogDto> {
}
