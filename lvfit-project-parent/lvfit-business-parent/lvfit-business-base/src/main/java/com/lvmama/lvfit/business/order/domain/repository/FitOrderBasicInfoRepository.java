package com.lvmama.lvfit.business.order.domain.repository;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvfit.business.order.domain.FitOrderBasicInfo;
import com.lvmama.lvfit.common.dto.order.FitOrderBasicInfoDto;


/**
 * 订单基本信息Repository
 * @author leizhengwei
 *
 */
public interface FitOrderBasicInfoRepository extends DomainBaseRepository<FitOrderBasicInfo, FitOrderBasicInfoDto>{
	
	List<FitOrderBasicInfoDto> getByOrderMainId(Long id);
}
