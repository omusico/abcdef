package com.lvmama.lvf.common.form.md;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.md.Airport;
import com.lvmama.lvf.common.dto.md.City;
import com.lvmama.lvf.common.dto.md.Location;
import com.lvmama.lvf.common.form.Form;

public class AirportResult implements Serializable,Form{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8090900468372749422L;
	
	private  Airport airport=new Airport();
	
	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}
	
	public Long getId() {
		return airport.getId();
	}

	public void setId(Long id) {
		this.airport.setId(id);
	}
	
	public String getName() {
		return airport.getName();
	}
	public void setName(String name) {
		this.airport.setName(name);
	}
	public String getCode() {
		return airport.getCode();
	}
	public void setCode(String code) {
		this.airport.setCode(code);
	}
	public String getFullName() {
		return airport.getFullName();
	}
	public void setFullName(String fullName) {
		this.airport.setFullName(fullName);
	}
	
	public City getCity() {
		return airport.getCity();
	}

	public void setCity(City city) {
		this.airport.setCity(city);
	}

	public Location getLocation() {
		return airport.getLocation();
	}

	public void setLocation(Location location) {
		this.airport.setLocation(location);
	}

}
