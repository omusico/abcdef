package com.lvmama.lvf.common.dto.search.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jiacheng
 * @date   2016-7-19
 */
public class Avh2SolrRequest implements Serializable 
{

	private static final long serialVersionUID = -4604945605794152079L;

	private List<FlightSearchFlightInfoDto> flightSearchFlightInfoDtos = new ArrayList<FlightSearchFlightInfoDto>();
	
	/** 出发日期 */
	private Date departureDate;
	
	/**出发城市code */
	private String departureCityCode; 
	
	/**到达城市code */
	private String arrivalCityCode;

	public List<FlightSearchFlightInfoDto> getFlightSearchFlightInfoDtos() {
		return flightSearchFlightInfoDtos;
	}

	public void setFlightSearchFlightInfoDtos(
			List<FlightSearchFlightInfoDto> flightSearchFlightInfoDtos) {
		this.flightSearchFlightInfoDtos = flightSearchFlightInfoDtos;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureCityCode() {
		return departureCityCode;
	}

	public void setDepartureCityCode(String departureCityCode) {
		this.departureCityCode = departureCityCode;
	}

	public String getArrivalCityCode() {
		return arrivalCityCode;
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		this.arrivalCityCode = arrivalCityCode;
	}
}
