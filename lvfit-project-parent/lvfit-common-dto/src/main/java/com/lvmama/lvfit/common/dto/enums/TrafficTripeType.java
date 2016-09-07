package com.lvmama.lvfit.common.dto.enums;

public enum TrafficTripeType {

	GO_WAY("去程"),
	BACK_WAY("返程");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	private TrafficTripeType (String cnName) {
		this.cnName = cnName;
	}
}
