package com.lvmama.lvfit.common.dto.enums;

public enum SeatClassType {

	F("头等舱"),
	C("公务舱"),
	Y("经济舱");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private SeatClassType(String cnName) {
		this.cnName = cnName;
	}

	
}
