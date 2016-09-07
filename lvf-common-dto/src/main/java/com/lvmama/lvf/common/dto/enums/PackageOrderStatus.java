package com.lvmama.lvf.common.dto.enums;

/**
 * VST/Fit下订单状态
 */
public enum PackageOrderStatus 
{
	ORDERSUCC("成功"),
	ORDERFAIL("失败");
	
	private String cnName;

	private PackageOrderStatus(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
}
