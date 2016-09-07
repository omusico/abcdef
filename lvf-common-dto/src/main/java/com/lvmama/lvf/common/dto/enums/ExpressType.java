package com.lvmama.lvf.common.dto.enums;

public enum ExpressType {
	
	
	SELF("自取"),
	NO_NEED("不需要"),
	EXPRESS("快递");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private ExpressType(String cnName) {
		this.cnName = cnName;
	}	
	
	public static ExpressType getExpressTypeByName(String name) {
		if(name==null||"".equals(name)){
			return null;
		}
		for (ExpressType expressType : ExpressType.values()) {
			if (name.equals(expressType.name())) {
				return expressType;
			}
		}
		return null;
	}
	
}
