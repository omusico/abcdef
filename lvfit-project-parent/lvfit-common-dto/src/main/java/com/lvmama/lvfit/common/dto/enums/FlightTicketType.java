package com.lvmama.lvfit.common.dto.enums;

public enum FlightTicketType {
	
	BSP("BSP"),
	B2B("B2B"),
	CRS("CRS");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private FlightTicketType(String cnName) {
		this.cnName = cnName;
	}
	
}
