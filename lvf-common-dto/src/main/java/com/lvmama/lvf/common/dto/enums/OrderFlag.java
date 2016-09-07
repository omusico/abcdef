package com.lvmama.lvf.common.dto.enums;

public enum OrderFlag {

	NORMAL("正式单"),
	TEST("测试单"),
	TEST_SUPP_PAY("测试供应商支付单"),
	RISK("风险单");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private OrderFlag(String cnName) {
		this.cnName = cnName;
	}

	
}
