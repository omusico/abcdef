package com.lvmama.lvf.common.form.search;

public class AirplaneModel {
	/** 飞机类型 */
	private String airplaneType;
	
	/** 最小座位数 */
	private int minSeats;
	
	/** 最大座位数 */
	private int maxSeats;
	
	//所属航空公司的名称
	private String carrierName;
	
	//like  空客
	private String name;
	
	//简称
	private String simpleName;
	
	//机型名称
	private String code;

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

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
