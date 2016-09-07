package com.lvmama.lvfit.common.dto.enums;




public enum StandardPrice {

	STANDARD_SEAT("基准舱位"),
	CURRENT_SEAT("当前舱位");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private StandardPrice(String cnName) {
		this.cnName = cnName;
	}

	
}
