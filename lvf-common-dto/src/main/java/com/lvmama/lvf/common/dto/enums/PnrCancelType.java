package com.lvmama.lvf.common.dto.enums;

public enum PnrCancelType {
	
	SEAT_KEEP("保留座位",null,null),
	SEAT_CANCEL("取消座位",null,null),
	SEAT_CANCELED("座位已取消",ApplyRefundActionType.RT_FREEWILL,null),
	SEAT_CANCEL_BEFORE_DEPARTURE("起飞前取消",null,ApplyRefundActionType.RT_FREEWILL),
	SEAT_CANCEL_AFTER_DEPARTURE("起飞后取消",null,ApplyRefundActionType.RT_FREEWILL);
	
	private String cnName;
	private ApplyRefundActionType notAllow;
	private ApplyRefundActionType allow;
	
	public String getCnName() {
		return cnName;
	}

	public ApplyRefundActionType getNotAllow() {
		return notAllow;
	}
	
	public ApplyRefundActionType getAllow() {
		return allow;
	}

	private PnrCancelType(String cnName, ApplyRefundActionType notAllow,
			ApplyRefundActionType allow) {
		this.cnName = cnName;
		this.notAllow = notAllow;
		this.allow = allow;
	}
	
}
