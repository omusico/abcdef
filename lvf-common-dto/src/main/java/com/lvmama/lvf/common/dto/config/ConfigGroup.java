package com.lvmama.lvf.common.dto.config;

public enum ConfigGroup {

	I_FLIGHT("国内机票"),
	F_FLIGHT("国际机票");
	
	private final String cnName;

	public String getCnName() {
		return cnName;
	}

	private ConfigGroup(String cnName) {
		this.cnName = cnName;
	}
	
	
	
}
