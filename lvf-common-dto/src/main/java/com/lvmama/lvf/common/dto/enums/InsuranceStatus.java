package com.lvmama.lvf.common.dto.enums;

public enum InsuranceStatus {
	INSURE_SUCCESS("投保成功"),
	INSURE_FAIL("投保失败"),
	INSURE_ING("投保中"),
	CANCEL_SUCCESS("废保成功"),
	CANCEL_FAIL("废保失败"),
	CANCEL_ING("废保中"),
	APPLY_CANCEL("申请废保"),
	CANCEL_INSURANCE("取消投保"),
	NOT_INSURE("未投保");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private InsuranceStatus(String cnName) {
		this.cnName = cnName;
	}
	
}
