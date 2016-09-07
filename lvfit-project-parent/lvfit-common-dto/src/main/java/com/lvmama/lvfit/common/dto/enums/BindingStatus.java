package com.lvmama.lvfit.common.dto.enums;

/**
 * VST订单绑定状态
 */
public enum BindingStatus 
{
	BINDING("绑定"),
	UNBINDING("解除");
	
	private String cnName;

	private BindingStatus(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
}
