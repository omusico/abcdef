package com.lvmama.lvfit.common.dto.enums;

public enum CityRange {
	
	I("适用"),
	E("不适用"),
	A("没有限制");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	private CityRange (String cnName) {
		this.cnName = cnName;
	}
}
