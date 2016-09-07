package com.lvmama.lvfit.business.order.domain.repository;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvf.common.domain.DomainByFkIdRepository;
import com.lvmama.lvf.common.domain.DomainQueryRepository;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.business.order.domain.FitOrder;
import com.lvmama.lvfit.common.dto.order.FitOrderDto;

/**
 * 订单Repository
 */
public interface FitOrderRepository extends DomainBaseRepository<FitOrder, FitOrderDto>,
        DomainQueryRepository<FitOrderDto, BaseQueryDto<? extends Dto>>,DomainByFkIdRepository<FitOrderDto> {

	FitOrderDto updateByOrderNo(FitOrderDto fitOrderDto);
}
