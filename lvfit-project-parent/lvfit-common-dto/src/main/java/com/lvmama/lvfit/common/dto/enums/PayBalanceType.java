package com.lvmama.lvfit.common.dto.enums;

/**
 * 支付方式枚举
 * @author majun
 * @date   2015-1-17
 */
public enum PayBalanceType 
{
	ONE("单笔"),
	MASS("结算");
	
	private String cnName;
	
	private PayBalanceType(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}
}
