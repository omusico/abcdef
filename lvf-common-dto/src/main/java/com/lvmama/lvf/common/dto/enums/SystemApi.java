package com.lvmama.lvf.common.dto.enums;


public enum SystemApi {

	API("线上对接"),
	OFFLINE("线下对接");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private SystemApi(String cnName) {
		this.cnName = cnName;
	}
	
}
