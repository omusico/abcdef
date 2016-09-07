package com.lvmama.lvfit.common.dto.md;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.NameCode;

/**
 * 机场信息
 * @author majun
 * @date   2015-3-14
 */
public class Airport extends NameCode implements Serializable 
{
	private static final long serialVersionUID = 7986528295290536839L;
	private City city;
	private Location location;
	/**
	 * 机场全称
	 */
	private String fullName;
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
}
