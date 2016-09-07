package com.lvmama.lvf.common.dto.enums;

public enum PolicyType {
	
	NORMAL("普通政策"),
	SPEC("特殊政策"),
	SPEC_PRICE("特价政策");
	
	private String cnName;

	private PolicyType(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}
	
}
