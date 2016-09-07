package com.lvmama.lvf.common.form.md;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.md.Airplane;
import com.lvmama.lvf.common.dto.md.AirplaneCompany;
import com.lvmama.lvf.common.form.Form;

public class AirPlaneForm implements Serializable,Form{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1202514724683328758L;
	
	private  Airplane airPlane=new Airplane();
	
	public Airplane getAirPlane() {
		return airPlane;
	}

	public void setAirPlane(Airplane airPlane) {
		this.airPlane = airPlane;
	}
	
	public Long getId() {
		return airPlane.getId();
	}

	public void setId(Long id) {
		this.airPlane.setId(id);
	}
	
	public String getName() {
		return airPlane.getName();
	}
	public void setName(String name) {
		this.airPlane.setName(name);
	}
	public String getCode() {
		return airPlane.getCode();
	}
	public void setCode(String code) {
		this.airPlane.setCode(code);
	}
	
	public String getAirplaneType() {
		return airPlane.getAirplaneType();
	}

	public void setAirplaneType(String airplaneType) {
		this.airPlane.setAirplaneType(airplaneType);
	}

	public int getMinSeats() {
		return airPlane.getMinSeats();
	}

	public void setMinSeats(int minSeats) {
		this.airPlane.setMinSeats(minSeats);
	}

	public int getMaxSeats() {
		return airPlane.getMaxSeats();
	}

	public void setMaxSeats(int maxSeats) {
		this.airPlane.setMaxSeats(maxSeats);
	}

	public AirplaneCompany getAirplaneCompany() {
		return airPlane.getAirplaneCompany();
	}

	public void setAirplaneCompany(AirplaneCompany airplaneCompany) {
		this.airPlane.setAirplaneCompany(airplaneCompany);
	}
	
	public String getSimpleName() {
		return airPlane.getSimpleName();
	}
	public void setSimpleName(String simpleName) {
		this.airPlane.setSimpleName(simpleName);
	}
}
