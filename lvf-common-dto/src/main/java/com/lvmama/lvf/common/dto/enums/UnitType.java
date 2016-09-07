package com.lvmama.lvf.common.dto.enums;

public enum UnitType {
	
	people("人"),
	parPrice_Percent("票面价百分比");
	
	private String cnName;

	private UnitType(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}
	
	
	
}
