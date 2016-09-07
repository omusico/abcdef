package com.lvmama.lvfit.common.dto.enums;

public enum FitFlightBookingType {

	BOOKING_BEFORE_VST_AUDIT("前置下单（即vst资源审核通过之前下机票单）"),
	BOOKING_AFTER_VST_AUDIT("后置下单（即vst资源审核通过之后下机票单）");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private FitFlightBookingType(String cnName) {
		this.cnName = cnName;
	}

	
}
