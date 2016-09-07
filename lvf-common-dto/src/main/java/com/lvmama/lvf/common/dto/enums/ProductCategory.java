package com.lvmama.lvf.common.dto.enums;

/**
 * 适用场景
 * @author hedandan
 * @date   2015-8-10
 */
public enum ProductCategory{
	
	FLIGHT("机票"),
	FLIGHT_AND_LINE("机+线路"),
	FLIGHT_AND_HOTEL("机+酒"),
	FLIGHT_AND_TRAIN("机+高铁"),
	FLIGHT_AND_CAR("机+租车"),
	FLIGHT_AND_SHIP("机+邮轮");
	
	private String cnName;
	
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	private ProductCategory(String cnName) {
		this.cnName = cnName;
	}

}
