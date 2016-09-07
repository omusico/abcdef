package com.lvmama.lvf.common.dto.enums;

public enum SuppTicketRefundStatus {
	REFUND("有退废票"), UNREFUND("无退废票");
	private String cnName;

	private SuppTicketRefundStatus(String cnName) {
		this.cnName=cnName;
	}

	public String getCnName() {
		return cnName;
	}
}
