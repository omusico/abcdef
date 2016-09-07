package com.lvmama.lvfit.common.dto.enums;

public enum NeedAuth {

	NEED_AUTH("编码需要授权"),
	NO_NEED_AUTH("编码无需授权");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private NeedAuth(String cnName) {
		this.cnName = cnName;
	}
	
	
}
