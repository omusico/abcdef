package com.lvmama.lvf.common.dto.enums;

public enum OrderLinkType {
	
	SAME_CUSTOMER("相同用户"),
	DUPLICATE("重复"),
	OTHER("其他");

	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private OrderLinkType(String cnName) {
		this.cnName = cnName;
	}
	
}
