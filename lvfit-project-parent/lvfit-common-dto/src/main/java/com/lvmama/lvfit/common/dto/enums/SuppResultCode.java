package com.lvmama.lvfit.common.dto.enums;

public enum SuppResultCode {
	INFO_001("订单提交成功"),
	INFO_002("乘客为失信人");
	
	private String cnName;
	
	private SuppResultCode(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}
	
}
