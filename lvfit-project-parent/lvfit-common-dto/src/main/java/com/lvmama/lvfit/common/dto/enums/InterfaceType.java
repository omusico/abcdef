package com.lvmama.lvfit.common.dto.enums;

public enum InterfaceType {
	ALL("全部");
	
	private InterfaceType(String cnName) {
		this.cnName = cnName;
	}

	private String cnName;

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

}
