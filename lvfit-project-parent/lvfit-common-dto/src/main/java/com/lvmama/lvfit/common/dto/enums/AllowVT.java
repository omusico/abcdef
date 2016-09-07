package com.lvmama.lvfit.common.dto.enums;


public enum AllowVT {

	ALLOW_VT("允许废票"),
	NOT_ALLOW_VT("不得废票");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private AllowVT(String cnName) {
		this.cnName = cnName;
	}
	
}
