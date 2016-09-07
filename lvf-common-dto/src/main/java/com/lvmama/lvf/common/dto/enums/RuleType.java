package com.lvmama.lvf.common.dto.enums;

public enum RuleType {
	/**
	 * 退票：RT 
	 * 废票：VT 
	 * 签转：MT  不同航空公司
	 * 改期/更改：CT 同航空公司
	 */
	
	VT("废票"),
	RT("退票"),
	MT("签转"),
	CT("改期");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private RuleType(String cnName) {
		this.cnName = cnName;
	}

	public static String getRuleTypeKey(RuleType type){
		return type.getCnName()+"费";//TODO (此处标准命名待定)
	}
	
}
