package com.lvmama.lvf.common.dto.enums;

/**
 * 订单模式类型
 * @author majun
 * @date   2015-3-16
 */
public enum ProductType{
	
	PACKAGE("打包"),
	FLIGHT("机票"),
	HOTEL("酒店"),
	TICKET("门票"),
	TRAIN("火车票"),
	VISA("签证"),
	SETTLEMENT("结算"),
	INSURANCE("保险"),
	REFUND("退款"),
	PAYMENT("支付");
	
	private String cnName;
	
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	private ProductType(String cnName) {
		this.cnName = cnName;
	}

}
