package com.lvmama.lvfit.common.dto.enums;

public enum SalesType {
	
	SELF("自有"),
	INTERNAL("内部"),
	B2B("B2B"),
	B2C("B2C");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private SalesType(String cnName) {
		this.cnName = cnName;
	}
}
