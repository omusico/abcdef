package com.lvmama.lvfit.common.dto.enums;

/**
 * 快递状态
 */
public enum ExpressStatus {
	
	NOT_DELIVERY("未投递"),
	DELIVERED("已投递"),
	RECYCLING("已回收");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private ExpressStatus(String cnName) {
		this.cnName = cnName;
	}
	
	public static ExpressStatus getExpressStatusByName(String name) {
		if(name==null||"".equals(name)){
			return null;
		}
		for (ExpressStatus expressStatus : ExpressStatus.values()) {
			if (name.equals(expressStatus.name())) {
				return expressStatus;
			}
		}
		return null;
	}
	
}
