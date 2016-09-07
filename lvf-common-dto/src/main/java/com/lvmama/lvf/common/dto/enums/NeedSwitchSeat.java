package com.lvmama.lvf.common.dto.enums;

public enum NeedSwitchSeat {

	NEED_SWITCH_SEAT("必须换舱位出票"),
	NO_NEED_SWITCH_SEAT("无需换舱位出票");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private NeedSwitchSeat(String cnName) {
		this.cnName = cnName;
	}
	
	
}
