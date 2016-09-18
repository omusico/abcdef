package com.lvmama.lvfit.business.sdpproduct.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSyncMsgDto;


/**
 * 自主打包产品加价规则信息
 * @author leizhengwei
 *
 */
public class FitSdpProductSynMsgDomain implements Domain<FitSdpProductSyncMsgDto> {

private FitSdpProductSyncMsgDto self;
	
	@Override
	public FitSdpProductSyncMsgDto self() {
		return self;
	}

	public FitSdpProductSynMsgDomain(FitSdpProductSyncMsgDto self) {
		super();
		this.self = self;
	}
}
