package com.lvmama.lvfit.common.dto.enums;

public enum VstBookingResultStatus {

	SUCCESS("成功"),
	FAIL("失败");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private VstBookingResultStatus(String cnName) {
		this.cnName = cnName;
	}
}
