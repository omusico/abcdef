package com.lvmama.lvf.common.dto.enums;

public enum FormulaBase {

	PAR_PRICE("票面价"),
	PAR_SETTLE_PRICE("票面价结算价");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	private FormulaBase(String cnName) {
		this.cnName = cnName;
	}
	
	
	
}
