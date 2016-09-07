package com.lvmama.lvfit.common.dto.enums;

public enum SuppType {
	FLIGHT("机票"),
	INSURANCE("保险");
	
	private String cnName;
	
	private SuppType(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}
	
}
