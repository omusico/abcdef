package com.lvmama.lvfit.business.order.domain.repository;

import org.apache.ibatis.annotations.Param;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvf.common.domain.DomainByFkIdRepository;
import com.lvmama.lvfit.business.order.domain.FitSuppOrderStatus;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderStatusDto;

/**
 * 订单Repository
 */
public interface FitSuppOrderStatusRepository extends DomainBaseRepository<FitSuppOrderStatus, FitSuppOrderStatusDto>, DomainByFkIdRepository<FitSuppOrderStatusDto>{
	
	
	FitSuppOrderStatusDto updateByVstOrderNo(FitSuppOrderStatusDto r);
	
	/**
	 * 根据vstOrderNo查询供应商订单状态
	 * @param FitSuppOrderStatusDto
	 * @return
	 */
	FitSuppOrderStatusDto getByVstOrderNo(@Param("vstOrderNo")Long vstOrderNo);
	
}
