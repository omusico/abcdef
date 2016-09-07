package com.lvmama.lvfit.business.order.domain.repository;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvf.common.domain.DomainByFkIdRepository;
import com.lvmama.lvfit.business.order.domain.FitSuppFlightOrderDetail;
import com.lvmama.lvfit.common.dto.order.FitSuppFlightOrderDetailDto;

public interface FitSuppFlightOrderDetailRepository extends DomainBaseRepository<FitSuppFlightOrderDetail, FitSuppFlightOrderDetailDto>,
DomainByFkIdRepository<FitSuppFlightOrderDetailDto>{
}

