package com.lvmama.lvfit.business.order.domain.repository;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvf.common.domain.DomainByFkIdRepository;
import com.lvmama.lvfit.business.order.domain.FitSuppMainOrderStatus;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderStatusDto;

/**
 * 订单Repository
 */
public interface FitSuppMainOrderStatusRepository extends DomainBaseRepository<FitSuppMainOrderStatus, FitSuppMainOrderStatusDto>, DomainByFkIdRepository<FitSuppMainOrderStatusDto>{
	
	/**
	 * 根据
	 * @param suppMainOrderStatusDto
	 * @return
	 */
	FitSuppMainOrderStatusDto updateByVstMainOrderNo(FitSuppMainOrderStatusDto r);
	
	/**
	 * 获取需同步的vst主订单状态信息
	 * @return
	 */
	List<FitSuppMainOrderStatusDto> queryNeedToSync();
	
}
