package com.lvmama.lvf.common.dto.enums;

public enum FlightTripType {
	
	DEPARTURE("去程"),
	RETURN("回程");

	private String cnName;

	private FlightTripType(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}
	
	public static FlightTripType getFlightTripTypeByName(String name) {
		if(name==null||"".equals(name)){
			return null;
		}
		for (FlightTripType flightTripType : FlightTripType.values()) {
			if (name.equals(flightTripType.name())) {
				return flightTripType;
			}
		}
		return null;
	}
	
	
}
