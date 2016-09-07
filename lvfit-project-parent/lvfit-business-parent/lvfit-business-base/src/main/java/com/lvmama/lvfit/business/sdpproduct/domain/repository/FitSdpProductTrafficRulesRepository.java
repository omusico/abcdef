package com.lvmama.lvfit.business.sdpproduct.domain.repository;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvf.common.domain.DomainByFkIdRepository;
import com.lvmama.lvfit.business.sdpproduct.domain.FitSdpProductTrafficRules;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductTrafficRulesDto;

/**
 * 自主打包产品交通规则Repository
 */
public interface FitSdpProductTrafficRulesRepository extends DomainBaseRepository<FitSdpProductTrafficRules, FitSdpProductTrafficRulesDto>,
     DomainByFkIdRepository<FitSdpProductTrafficRulesDto>{
	
	/** DomainBaseRepository.save()  */ 
	
	/** DomainBaseRepository.queryByFkId()  */ 
	
}
