package com.lvmama.lvf.common.dto.enums;

public enum InstantaneityType {

	INSTANTANEITY_N("非实时"),INSTANTANEITY_Y("实时");

	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private InstantaneityType(String cnName) {
		this.cnName = cnName;
	}

	
}
