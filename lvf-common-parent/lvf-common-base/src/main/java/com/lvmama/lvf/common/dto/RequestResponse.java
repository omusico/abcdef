package com.lvmama.lvf.common.dto;

public enum RequestResponse {

	RE("请求"),
	RS("响应");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private RequestResponse(String cnName) {
		this.cnName = cnName;
	}

	
}
