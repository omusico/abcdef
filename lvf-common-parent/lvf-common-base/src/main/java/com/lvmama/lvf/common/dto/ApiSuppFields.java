package com.lvmama.lvf.common.dto;

public enum ApiSuppFields {

	Ctrip_Search("OAE_FlightSearch"),
	Ctrip_Departure_Date_Index("Date"),
	Ctrip_Departure_City_Index("ORIG"),
	Ctrip_Arrival_City_Index("DEST"),
	Ctrip_Err_Message_Begin("ResultMsg=\""),
	Ctrip_Err_Message_End("\" />"),
	Ctrip_Book("OAE_FlightSaveOrder"),
	Ctrip_FinalResult("FinalResult"),
	Ctrip_FinalResultMsg("FinalResultMsg");
	
	private String suppValue;

	public String getSuppValue() {
		return suppValue;
	}

	private ApiSuppFields(String suppValue) {
		this.suppValue = suppValue;
	}
}
