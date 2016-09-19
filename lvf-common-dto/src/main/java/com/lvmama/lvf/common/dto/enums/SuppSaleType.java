package com.lvmama.lvf.common.dto.enums;

public enum SuppSaleType {
	
	NA(0L, "默认"),
	BusinessPriority(1L, "商务优选"),
	TravelPackage(2L, "旅行套餐"),
	PriorityPackage(3L, "优选套餐"),
	AirLineMarketing(4L, "航司直联"),
	NORMAL(5L, "普通政策"),
	BusinessProduct(6L, "商旅产品"),
	DomesticProduct(7L, "包机切位政策"),
	GWPolicy(8L, "517官网政策");
	
	private Long longValue;
	private String cnName;

	public String getCode() {
		return this.name();
	}
	
	public Long getLongValue() {
		return longValue;
	}
	
	public String getCnName() {
		return cnName;
	}
	
	SuppSaleType(Long longValue, String cnName){
		this.cnName = cnName;
		this.longValue = longValue;
	}
	
}
