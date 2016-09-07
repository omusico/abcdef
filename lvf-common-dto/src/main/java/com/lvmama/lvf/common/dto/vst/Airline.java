package com.lvmama.lvf.common.dto.vst;

import java.io.Serializable;

/**
 * 航空公司dto
 * 
 */
public class Airline implements Serializable {

	private static final long serialVersionUID = 4761242668908316674L;

	private Long placeAirlineId;

	private String airlineName;

	private String airlineIcon;

	private String airlineCode;

	public Long getPlaceAirlineId() {
		return placeAirlineId;
	}

	public void setPlaceAirlineId(Long placeAirlineId) {
		this.placeAirlineId = placeAirlineId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getAirlineIcon() {
		return airlineIcon;
	}

	public void setAirlineIcon(String airlineIcon) {
		this.airlineIcon = airlineIcon;
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

}
