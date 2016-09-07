package com.lvmama.lvfit.business.sdpproduct.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpCityGroupDto;


/**
 * 自主打包产品加价规则信息
 * @author leizhengwei
 *
 */
public class FitSdpCityGroup implements Domain<FitSdpCityGroupDto> {

private FitSdpCityGroupDto self;
	
	@Override
	public FitSdpCityGroupDto self() {
		return self;
	}

	public FitSdpCityGroup(FitSdpCityGroupDto self) {
		super();
		this.self = self;
	}
}
