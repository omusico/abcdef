package com.lvmama.lvfit.common.dto.enums;

public enum OfficeType {
	
	SELF("自有票台"),
	SUPP("供应商票台");
	
	private String cnName;

	private OfficeType(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}
}
