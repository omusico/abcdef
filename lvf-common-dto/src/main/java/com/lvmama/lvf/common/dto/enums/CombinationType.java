package com.lvmama.lvf.common.dto.enums;

public enum CombinationType {
	
	AUTO("自动"),
	MANGER("业务经理");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private CombinationType(String cnName) {
		this.cnName = cnName;
	}
	
	
}
