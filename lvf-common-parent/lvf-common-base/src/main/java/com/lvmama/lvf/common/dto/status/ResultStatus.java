package com.lvmama.lvf.common.dto.status;

public enum ResultStatus {
	
	INVALID("无效"),
	APPLY("发起"),
	SUCCESS("成功"),
	TIMEOUT("超时"),
	FAIL("失败");
	

	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private ResultStatus(String cnName) {
		this.cnName = cnName;
	}
	
}
