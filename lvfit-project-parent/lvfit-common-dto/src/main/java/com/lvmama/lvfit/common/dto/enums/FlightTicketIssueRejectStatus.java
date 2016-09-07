package com.lvmama.lvfit.common.dto.enums;

public enum FlightTicketIssueRejectStatus {
	
	
	REJECT_ISSUE_TICKET("拒绝出票"),
	
	TRANSIENT_NOT_ISSUE_TICKET("暂时不能出票");
	
	public String cName;

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	private FlightTicketIssueRejectStatus(String cName) {
		this.cName = cName;
	}
	
}
