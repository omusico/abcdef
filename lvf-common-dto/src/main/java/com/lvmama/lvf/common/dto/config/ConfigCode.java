package com.lvmama.lvf.common.dto.config;

public enum ConfigCode {

	CRATE_ORDER("创建订单接口");

	private final String cnName;

	public String getCnName() {
		return cnName;
	}

	private ConfigCode(String cnName) {
		this.cnName = cnName;
	}

	

}
