package com.lvmama.lvf.common.dto.enums;

public enum SeatSpecType {
	
	NORMAL("普通舱位"),
	SPEC_PRICE("特价舱位"),
	ALL("所有");
	
	private String cnName;

	private SeatSpecType(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}
	
}
