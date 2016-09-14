package com.lvmama.lvfit.business.sdpproduct.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexTraffic;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSynMsg;


/**
 * 自主打包产品加价规则信息
 * @author leizhengwei
 *
 */
public class FitSdpProductSearchIndexTrafficDomain implements Domain<FitSdpProductSearchIndexTraffic> {

private FitSdpProductSearchIndexTraffic self;
	
	@Override
	public FitSdpProductSearchIndexTraffic self() {
		return self;
	}

	public FitSdpProductSearchIndexTrafficDomain(FitSdpProductSearchIndexTraffic self) {
		super();
		this.self = self;
	}
}
