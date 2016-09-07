package com.lvmama.lvfit.persistence.mybatis.mapper;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByFkIdMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductTrafficRulesDto;

public interface FitSdpProductTrafficRulesMapper 
	extends 
	DomainEntityBaseMapper<FitSdpProductTrafficRulesDto, BaseQueryDto<? extends FitSdpProductTrafficRulesDto>>,
	DomainEntityByFkIdMapper<FitSdpProductTrafficRulesDto>{

}
