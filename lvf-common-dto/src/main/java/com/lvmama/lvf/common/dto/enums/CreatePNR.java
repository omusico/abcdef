package com.lvmama.lvf.common.dto.enums;

public enum CreatePNR {

	CREATE_PNR("创建PNR"),
	NO_CREATE_PNR("不创建PNR");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private CreatePNR(String cnName) {
		this.cnName = cnName;
	}
	
}
