package com.lvmama.lvfit.business.order.domain.repository;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvf.common.domain.DomainByFkIdRepository;
import com.lvmama.lvfit.business.order.domain.FitOrderPassenger;
import com.lvmama.lvfit.common.dto.order.FitOrderPassengerDto;

public interface FitOrderPassengerRepository extends DomainBaseRepository<FitOrderPassenger, FitOrderPassengerDto>,
        DomainByFkIdRepository<FitOrderPassengerDto>{
}
