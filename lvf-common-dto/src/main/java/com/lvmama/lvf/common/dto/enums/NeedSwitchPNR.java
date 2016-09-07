package com.lvmama.lvf.common.dto.enums;

public enum NeedSwitchPNR {

	NEED_SWITCH_PNR("必须更换PNR出票"),
	NO_NEED_SWITCH_PNR("无需更换PNR");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private NeedSwitchPNR(String cnName) {
		this.cnName = cnName;
	}
	
	
}
