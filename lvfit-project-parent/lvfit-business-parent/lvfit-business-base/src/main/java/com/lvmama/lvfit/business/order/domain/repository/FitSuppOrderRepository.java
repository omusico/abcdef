package com.lvmama.lvfit.business.order.domain.repository;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvf.common.domain.DomainByFkIdRepository;
import com.lvmama.lvf.common.domain.DomainByNoRepository;
import com.lvmama.lvfit.business.order.domain.FitSuppOrder;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderDto;

/**
 * 订单Repository
 */
public interface FitSuppOrderRepository extends DomainBaseRepository<FitSuppOrder, FitSuppOrderDto>, DomainByFkIdRepository<FitSuppOrderDto>,DomainByNoRepository<FitSuppOrderDto>{
}
