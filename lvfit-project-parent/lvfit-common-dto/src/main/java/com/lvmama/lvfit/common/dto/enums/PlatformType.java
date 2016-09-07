package com.lvmama.lvfit.common.dto.enums;

public enum PlatformType {

	FLIGHT("机票");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private PlatformType(String cnName) {
		this.cnName = cnName;
	}

	
}
