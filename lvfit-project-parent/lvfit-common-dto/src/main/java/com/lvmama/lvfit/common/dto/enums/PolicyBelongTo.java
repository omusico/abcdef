package com.lvmama.lvfit.common.dto.enums;

public enum PolicyBelongTo {

	SUPER_POLICY("上级代理政策"), 
	OTHERS_POLICY("异地政策"), 
	SELF_POLICY("自己政策");

	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private PolicyBelongTo(String cnName) {
		this.cnName = cnName;
	}
}
