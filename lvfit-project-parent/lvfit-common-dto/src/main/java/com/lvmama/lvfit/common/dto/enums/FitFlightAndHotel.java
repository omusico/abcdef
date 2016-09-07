package com.lvmama.lvfit.common.dto.enums;

public enum FitFlightAndHotel {
	FIT_FLIGHT_DEPARTURE("去程机票查询结果"),
	FIT_FLIGHT_RETURN("返程机票查询结果"),
	FIT_HOTEL("酒店查询结果"),
	FIT_INSURANCES("保险查询结果"),
	FIT_SPOTS("景点查询结果");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	private FitFlightAndHotel(String cnName) {
		this.cnName = cnName;
	}
}
