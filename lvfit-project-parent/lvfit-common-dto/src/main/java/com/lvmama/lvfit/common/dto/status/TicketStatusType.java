package com.lvmama.lvfit.common.dto.status;

public enum TicketStatusType {

	NULL(""),
	BOOKING("订位"){
		public boolean isBooking() {
			return true;
		}
	},
	ISSUE("出票") {
		@Override
		public boolean isIssue() {
			return true;
		}
	},
	CTMT("变更") {
		@Override
		public boolean isCtmt() {
			return true;
		}
	},
	RTVT("退票") {
		@Override
		public boolean isRtvt() {
			return true;
		}
	};
	
	private String cnName;
	
	private TicketStatusType(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	public boolean isBooking(){
		return false;
	};
	public boolean isIssue(){
		return false;
	};
	public boolean isCtmt(){
		return false;
	};
	public boolean isRtvt(){
		return false;
	};
	
}
