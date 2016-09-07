package com.lvmama.lvfit.common.dto.enums;

public enum CallbackType {
	
	DEFAULT("未发起"),
	SUCCESS("成功"),
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

