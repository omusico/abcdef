package com.lvmama.lvfit.business.sdpproduct.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;


/**
 * 自主打包产品基本信息
 * @author leizhengwei
 *
 */
public class FitSdpProductBasicInfo implements Domain<FitSdpProductBasicInfoDto> {

private FitSdpProductBasicInfoDto self;
	
	@Override
	public FitSdpProductBasicInfoDto self() {
		return self;
	}

	public FitSdpProductBasicInfo(FitSdpProductBasicInfoDto self) {
		super();
		this.self = self;
	}
}
