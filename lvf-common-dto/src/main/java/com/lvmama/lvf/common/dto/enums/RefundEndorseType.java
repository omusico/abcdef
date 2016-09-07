package com.lvmama.lvf.common.dto.enums;

public enum RefundEndorseType {
	REFUND("退票"),
	ENDORSE("改签");
	
	private String cnName;
	
	private RefundEndorseType(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}
}
