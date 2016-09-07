package com.lvmama.lvfit.common.dto.search.flight.result;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.md.Airport;
import com.lvmama.lvfit.common.dto.md.TerminalBuilding;

/**
 * 机场线路信息
 * @author majun
 * @date   2015-2-9
 */
public class FlightAirportLineDto implements Serializable, Dto
{
	private static final long serialVersionUID = -8712309112136202525L;
	
	/** 航班信息主键 */
	private Long flightInfoId;

	/**出发机场 */
	private Airport departureAirport;
	
	/**到达机场 */
	private Airport arrivalAirport;
	
	/**出发航站楼 */
	private TerminalBuilding departureTermainalBuilding;
	
	/**到达航站楼 */
	private TerminalBuilding arrivalTerminalBuilding;

	public Long getFlightInfoId() {
		return flightInfoId;
	}

	public void setFlightInfoId(Long flightInfoId) {
		this.flightInfoId = flightInfoId;
	}

	public Airport getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}

	public Airport getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public TerminalBuilding getDepartureTermainalBuilding() {
		return departureTermainalBuilding;
	}

	public void setDepartureTermainalBuilding(
			TerminalBuilding departureTermainalBuilding) {
		this.departureTermainalBuilding = departureTermainalBuilding;
	}

	public TerminalBuilding getArrivalTerminalBuilding() {
		return arrivalTerminalBuilding;
	}

	public void setArrivalTerminalBuilding(TerminalBuilding arrivalTerminalBuilding) {
		this.arrivalTerminalBuilding = arrivalTerminalBuilding;
	}

	@JsonIgnore
	@Override
	public Long getId() {
		return flightInfoId;
	}
}
