package com.lvmama.lvfit.business.sdpproduct.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductTrafficRulesDto;


/**
 * 自主打包产品交通规则信息
 * @author leizhengwei
 *
 */
public class FitSdpProductTrafficRules implements Domain<FitSdpProductTrafficRulesDto> {

private FitSdpProductTrafficRulesDto self;
	
	@Override
	public FitSdpProductTrafficRulesDto self() {
		return self;
	}

	public FitSdpProductTrafficRules(FitSdpProductTrafficRulesDto self) {
		super();
		this.self = self;
	}
}
