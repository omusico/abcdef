package com.lvmama.lvf.common.dto.enums;

public enum AllowLowPrice {

	ALLOW_LOW_PRICE("头等舱"),
	NOT_ALLOW_LOW_PRICE("经济舱"),
	ALL("所有");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private AllowLowPrice(String cnName) {
		this.cnName = cnName;
	}

	
}
