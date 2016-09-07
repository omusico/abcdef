package com.lvmama.lvf.common.dto.enums;

public enum CallbackType {
	
	SUCCESS("成功"),
	PROCESSING("处理中"),
	FAIL("失败"),
	TIMEOUT("超时");
	
	private String cnName;

	private CallbackType(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	
	
}

