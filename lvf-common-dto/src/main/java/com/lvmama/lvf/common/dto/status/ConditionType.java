package com.lvmama.lvf.common.dto.status;

public enum ConditionType {

	EQUALS("等于"),
	CONTAINS("包含");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private ConditionType(String cnName) {
		this.cnName = cnName;
	}
}
