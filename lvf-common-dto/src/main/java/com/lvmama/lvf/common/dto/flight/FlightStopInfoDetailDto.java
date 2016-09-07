package com.lvmama.lvf.common.dto.flight;

import java.io.Serializable;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.md.Airport;
import com.lvmama.lvf.common.dto.md.City;

/**
 * 航班经停明细信息
 * @author majun
 * @date   2015-1-19
 */
public class FlightStopInfoDetailDto extends Entity implements Serializable
{
	private static final long serialVersionUID = 5566257801156307991L;
	
	/** 停靠机场 */
	@FkId
	@Deprecated
	private Airport airport;
	
	/** 停靠城市 */
	private City city;
	
	/** 停靠时间 */
	private String stopTime;
	
	/** 停靠顺序 */
	private Integer stopSort;
	
	@FkId
	private FlightInfoDto flightInfo;
	
	public FlightInfoDto getFlightInfo() {
		return flightInfo;
	}

	public void setFlightInfo(FlightInfoDto flightInfo) {
		this.flightInfo = flightInfo;
	}

	@Deprecated
	public Airport getAirport() {
		return airport;
	}

	@Deprecated
	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getStopTime() {
		return stopTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}

	public Integer getStopSort() {
		return stopSort;
	}

	public void setStopSort(Integer stopSort) {
		this.stopSort = stopSort;
	}
	
}
