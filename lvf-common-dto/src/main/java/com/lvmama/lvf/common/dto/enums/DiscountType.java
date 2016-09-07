package com.lvmama.lvf.common.dto.enums;

public enum DiscountType {

	PROMOTION("促销"),
	SALES("分销渠道"),
	ADJUST("调价"),
	CONFER("协议");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private DiscountType(String cnName) {
		this.cnName = cnName;
	}
	
}
