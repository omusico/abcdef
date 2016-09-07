package com.lvmama.lvf.common.dto.enums;

public enum DirectType {

	DIRECT("直飞"),
	NOT_DIRECT("经停");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private DirectType(String cnName) {
		this.cnName = cnName;
	}
	
}
