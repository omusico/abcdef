package com.lvmama.lvf.common.dto.enums;

public enum OrderNoType {

	ORDERNO("子订单号"),
	ORDERMAINNO("主订单号"),
	PURORDERNO("采购订单"),
	SUPPORDERNO("供应订单");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private OrderNoType(String cnName) {
		this.cnName = cnName;
	}
	
}
