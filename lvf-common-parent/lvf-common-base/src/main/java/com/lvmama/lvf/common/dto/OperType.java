package com.lvmama.lvf.common.dto;

public enum OperType {

	SYSTEM("系统"),
	CUSTOMER("客户"),
	PM("技术产品"),
	PRODUCT("业务产品"),
	BUSINESS("业务运营"),
	CC("客服");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private OperType(String cnName) {
		this.cnName = cnName;
	}
}
