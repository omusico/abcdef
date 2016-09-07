package com.lvmama.lvfit.common.dto.enums;

/**
 * 是否包括特殊政策枚举
 * @author majun
 * @date   2015-1-13
 */
public enum NeedSpeRulePolicyType 
{
	EXCLUDE("不包括"),
	INCLUDE("包括");
	
	/** 枚举对应描述 */
	private String name;
	
	private NeedSpeRulePolicyType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
