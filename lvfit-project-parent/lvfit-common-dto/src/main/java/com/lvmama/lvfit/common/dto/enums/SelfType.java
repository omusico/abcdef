package com.lvmama.lvfit.common.dto.enums;

public enum SelfType {

	SELF("自有"),
	INTERNAL("内部"),
	OUTSIDE("外部");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private SelfType(String cnName) {
		this.cnName = cnName;
	}
	
}
