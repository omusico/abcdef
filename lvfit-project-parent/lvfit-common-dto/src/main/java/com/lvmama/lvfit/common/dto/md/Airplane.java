package com.lvmama.lvfit.common.dto.md;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.NameCode;

/**
 * 机型信息
 * @author majun
 * @date   2015-1-13
 */
public class Airplane extends NameCode implements Serializable 
{
	private static final long serialVersionUID = 3065185816421643684L;
	
	/** 飞机类型 */
	private String airplaneType;
	
	/** 最小座位数 */
	private int minSeats;
	
	/** 最大座位数 */
	private int maxSeats;
	
	/** 飞机所属航空公司信息 */
	private AirplaneCompany airplaneCompany;
	
	/** 飞机简称 */
	private String simpleName;

	public String getAirplaneType() {
		return airplaneType;
	}

	public void setAirplaneType(String airplaneType) {
		this.airplaneType = airplaneType;
	}

	public int getMinSeats() {
		return minSeats;
	}

	public void setMinSeats(int minSeats) {
		this.minSeats = minSeats;
	}

	public int getMaxSeats() {
		return maxSeats;
	}

	public void setMaxSeats(int maxSeats) {
		this.maxSeats = maxSeats;
	}

	public AirplaneCompany getAirplaneCompany() {
		return airplaneCompany;
	}

	public void setAirplaneCompany(AirplaneCompany airplaneCompany) {
		this.airplaneCompany = airplaneCompany;
	}

	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}
}	
