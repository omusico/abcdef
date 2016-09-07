package com.lvmama.lvfit.business.sdpproduct.domain.repository;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvf.common.domain.DomainByFkIdRepository;
import com.lvmama.lvfit.business.sdpproduct.domain.FitSdpProductFeeRules;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductFeeRulesDto;


/**
 * 自主打包产品加价规则Repository
 * @author leizhengwei
 *
 */
public interface FitSdpProductFeeRulesRepository extends DomainBaseRepository<FitSdpProductFeeRules, FitSdpProductFeeRulesDto>,
 DomainByFkIdRepository<FitSdpProductFeeRulesDto>{
	
	/** DomainBaseRepository.save()  */ 
	
	/** DomainBaseRepository.queryByFkId()  */ 
	
}
