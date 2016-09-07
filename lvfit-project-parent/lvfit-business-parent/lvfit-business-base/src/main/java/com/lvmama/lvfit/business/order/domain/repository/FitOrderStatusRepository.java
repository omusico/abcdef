package com.lvmama.lvfit.business.order.domain.repository;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvf.common.domain.DomainByFkIdRepository;
import com.lvmama.lvfit.business.order.domain.FitOrderStatus;
import com.lvmama.lvfit.common.dto.order.FitOrderStatusDto;

/**
 * 订单Repository
 */
public interface FitOrderStatusRepository extends DomainBaseRepository<FitOrderStatus, FitOrderStatusDto>,
        DomainByFkIdRepository<FitOrderStatusDto> {
}
