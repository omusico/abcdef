package com.lvmama.lvf.common.dto.enums;

public enum DiscountCalculatorBaseType {

	PAR_PRICE("票面价"),
	ORDER_TOTAL_AMOUNT("总价");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	private DiscountCalculatorBaseType(String cnName) {
		this.cnName = cnName;
	}
	
	
	
}
