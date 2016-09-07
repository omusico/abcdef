package com.lvmama.lvfit.business.sdpproduct.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductFeeRulesDto;


/**
 * 自主打包产品加价规则信息
 * @author leizhengwei
 *
 */
public class FitSdpProductFeeRules implements Domain<FitSdpProductFeeRulesDto> {

private FitSdpProductFeeRulesDto self;
	
	@Override
	public FitSdpProductFeeRulesDto self() {
		return self;
	}

	public FitSdpProductFeeRules(FitSdpProductFeeRulesDto self) {
		super();
		this.self = self;
	}
}
