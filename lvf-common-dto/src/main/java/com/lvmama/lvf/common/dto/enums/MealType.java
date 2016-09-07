package com.lvmama.lvf.common.dto.enums;

public enum MealType {
	
	NONE("无"),
	HAVE("有"),
	BREAKFAST("早餐"),
	LUNCH("午餐"),
	DINNER("晚餐"),
	DESSERT("甜点");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private MealType(String cnName) {
		this.cnName = cnName;
	}
	
	
}
