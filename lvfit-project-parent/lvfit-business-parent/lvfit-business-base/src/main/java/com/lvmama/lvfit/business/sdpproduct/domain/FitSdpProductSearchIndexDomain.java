package com.lvmama.lvfit.business.sdpproduct.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexDto;


/**
 * 自主打包产品加价规则信息
 * @author leizhengwei
 *
 */
public class FitSdpProductSearchIndexDomain implements Domain<FitSdpProductSearchIndexDto> {

private FitSdpProductSearchIndexDto self;
	
	@Override
	public FitSdpProductSearchIndexDto self() {
		return self;
	}

	public FitSdpProductSearchIndexDomain(FitSdpProductSearchIndexDto self) {
		super();
		this.self = self;
	}
}
