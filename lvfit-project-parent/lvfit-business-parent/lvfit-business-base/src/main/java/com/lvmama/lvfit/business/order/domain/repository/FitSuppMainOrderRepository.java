package com.lvmama.lvfit.business.order.domain.repository;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvf.common.domain.DomainByFkIdRepository;
import com.lvmama.lvfit.business.order.domain.FitSuppMainOrder;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;

/**
 * 订单Repository
 */
public interface FitSuppMainOrderRepository extends DomainBaseRepository<FitSuppMainOrder, FitSuppMainOrderDto>,
        DomainByFkIdRepository<FitSuppMainOrderDto>{
}
