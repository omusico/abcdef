package com.lvmama.lvfit.common.dto.enums;

public enum OnlySelfPNR {

	ONLY_SELF_PNR("只用自己的PNR出票"),
	CAN_CHANGE_PNR("可以更换PNR出票");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private OnlySelfPNR(String cnName) {
		this.cnName = cnName;
	}
	
}
