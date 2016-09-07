package com.lvmama.lvfit.common.dto.enums;

public enum AuditStatus {

	NULL(""),
	APPLY("申请"),
	AUDIT("审核"),
	OP("处理");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private AuditStatus(String cnName) {
		this.cnName = cnName;
	}
	
}
