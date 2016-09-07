package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FlightQueryBatchRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8526611980414654913L;
	
	private List<FlightQueryRequest> flightQueryRequests;

	public List<FlightQueryRequest> getFlightQueryRequests() {
		return flightQueryRequests;
	}

	public void setFlightQueryRequests(List<FlightQueryRequest> flightQueryRequests) {
		this.flightQueryRequests = flightQueryRequests;
	}
	
}
