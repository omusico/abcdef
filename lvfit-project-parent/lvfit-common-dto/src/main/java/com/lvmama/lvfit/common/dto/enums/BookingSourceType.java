package com.lvmama.lvfit.common.dto.enums;

public enum BookingSourceType {
	
	WAP("WAP"),
	APP("APP"),
	VST("主站"),
	BACK("机票后台"),
	FRONT("网站"),
	SALES("分销"),
	DEFAULT("默认");
	
	private String cnName;

	private BookingSourceType(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	
	
}

