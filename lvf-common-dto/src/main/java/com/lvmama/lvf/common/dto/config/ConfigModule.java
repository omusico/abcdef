package com.lvmama.lvf.common.dto.config;

public enum ConfigModule {
	
	VST("VST对接"),
	FLIGHT("机票");

	private final String cnName;

	private ConfigModule(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}

	
}
