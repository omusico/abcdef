package com.lvmama.lvf.common.dto.enums;

public enum OperateStatus {
	NOT_ISSUE_TICKET("未出票"),
	ISSUE_TICKET("已出票"),
	REFUNDED_TICKET("已退票"),
	CHANG_TICKET("已变更");
	
	private String cName;

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	private OperateStatus(String cName) {
		this.cName = cName;
	}
}
