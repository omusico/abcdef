package com.lvmama.lvfit.business.sdpproduct.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndex;


/**
 * 自主打包产品加价规则信息
 * @author leizhengwei
 *
 */
public class FitSdpProductSearchIndexDomain implements Domain<FitSdpProductSearchIndex> {

private FitSdpProductSearchIndex self;
	
	@Override
	public FitSdpProductSearchIndex self() {
		return self;
	}

	public FitSdpProductSearchIndexDomain(FitSdpProductSearchIndex self) {
		super();
		this.self = self;
	}
}
