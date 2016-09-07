package com.lvmama.lvfit.business.order.domain.repository;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvfit.business.order.domain.FitOrderRoomDiff;
import com.lvmama.lvfit.common.dto.order.FitOrderRoomDiffDto;

public interface FitOrderRoomDiffRepository extends DomainBaseRepository< FitOrderRoomDiff, FitOrderRoomDiffDto>{
	
	List<FitOrderRoomDiffDto>	getByOrderMainId(Long id);
}
