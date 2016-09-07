package com.lvmama.lvf.common.dto.enums;

public enum InsuranceType{
	
	DELAY_INS("延误险","航班延误无忧！"),
	ACCIDENT_INS("意外险","让关心你的人放心！");
	
	private String cnName;
	private String desc;
	private InsuranceType(String cnName, String desc) {
		this.cnName = cnName;
		this.desc = desc;
	}
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

}
