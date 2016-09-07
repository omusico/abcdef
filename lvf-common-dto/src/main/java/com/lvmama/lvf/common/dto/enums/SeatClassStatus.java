package com.lvmama.lvf.common.dto.enums;

public enum SeatClassStatus {

	//DEFAULT(""),
	IS_COMPLEMENTED("已补全"),
	NO_COMPLEMENTED("未补全");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private SeatClassStatus(String cnName) {
		this.cnName = cnName;
	}

	
}
