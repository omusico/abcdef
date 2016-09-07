package com.lvmama.lvfit.business.sdpproduct.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSynMsg;


/**
 * 自主打包产品加价规则信息
 * @author leizhengwei
 *
 */
public class FitSdpProductSynMsgDomain implements Domain<FitSdpProductSynMsg> {

private FitSdpProductSynMsg self;
	
	@Override
	public FitSdpProductSynMsg self() {
		return self;
	}

	public FitSdpProductSynMsgDomain(FitSdpProductSynMsg self) {
		super();
		this.self = self;
	}
}
