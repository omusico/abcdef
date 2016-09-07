package com.lvmama.lvfit.common.dto.status;

public enum OrderAuditType 
{
	NULL(""),
	AUDIT("审核"),
	OP("处理");
	
	private OrderAuditType(String cnName) {
		this.cnName = cnName;
	}

	private String cnName;
	
	public String getCnName() {
		return cnName;
	}
	
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
}
