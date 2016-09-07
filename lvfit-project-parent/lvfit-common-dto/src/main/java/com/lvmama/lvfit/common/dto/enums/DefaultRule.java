package com.lvmama.lvfit.common.dto.enums;


public enum DefaultRule {

	DEFAULT("默认"),
	NOT_DEFAULT("不默认");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private DefaultRule(String cnName) {
		this.cnName = cnName;
	}
	
}
