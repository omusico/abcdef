package com.lvmama.lvfit.business.order.domain.repository;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvf.common.domain.DomainByFkIdRepository;
import com.lvmama.lvfit.business.order.domain.FitSuppFlightOrder;
import com.lvmama.lvfit.common.dto.order.FitSuppFlightOrderDto;

public interface FitSuppFlightOrderRepository extends DomainBaseRepository<FitSuppFlightOrder, FitSuppFlightOrderDto>,
DomainByFkIdRepository<FitSuppFlightOrderDto>{
}
