package com.lvmama.lvfit.common.dto.enums;

public enum VisibleStatus{
	
	NOT_VISIBLE("不显示"),
	VISIBLE("显示");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	private VisibleStatus (String cnName) {
		this.cnName = cnName;
	}

}
