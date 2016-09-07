package com.lvmama.lvfit.common.dto.enums;

/**
 * 允许帮选政策枚举(暂为51Book接口参数)
 * @author majun
 * @date   2015-1-13
 */
public enum AllowSwitchPolicyType 
{
	DISABLE("不用"),
	ENABLE("可帮选");
	
	private String cnName;

	private AllowSwitchPolicyType(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	
}
