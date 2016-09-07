package com.lvmama.lvf.common.dto.enums;

public enum PriceSource {
	
	FDNFD("敬众数据"),
	FlightSearchCacheData("航班查询缓存数据");
	
	private String cnName;
	
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	private PriceSource(String cnName) {
		this.cnName = cnName;
	}
	
}
