package com.lvmama.lvfit.common.dto.enums;


public enum DefaultSupp {

	DEFAULT("默认"),
	NOT_DEFAULT("不默认");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private DefaultSupp(String cnName) {
		this.cnName = cnName;
	}
	
}
