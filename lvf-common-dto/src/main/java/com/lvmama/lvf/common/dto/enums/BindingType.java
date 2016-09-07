package com.lvmama.lvf.common.dto.enums;

/**
 * 机票订单与外部订单绑定类型
 */
public enum BindingType 
{
	MAIN("主单关联"),
	SUB("子单关联");
	
	private String cnName;

	private BindingType(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
}
