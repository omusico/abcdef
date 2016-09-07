package com.lvmama.lvf.common.dto;

public enum BusinessType {

	ORDER_MAIN("主单"),
	SUPP_ORDER("供应商订单"),
	ORDER("子单"),
	ORDER_DETAIL("订单明细"),
	PNR("订位"),
	TICKET("票"),
	BSP("行程单"),
    BSP_STORAGE("行程单入库单"),
    BSP_STORAGE_DETAIL("行程单明细单"),
    INSURANCE_ORDER("保险订单"),
    INSURANCE_PRO("保险产品"),
    ORDER_PAY("支付单"),
    @Deprecated
    ORDER_PAY_BACK("支付单回调"),
    ORDER_REFUND("退款单"),
    @Deprecated
    ORDER_REFUND_BACK("退款单回调"),
    SETTLEMENT("结算单"),
    SMS("短信"),
	LOGIN("登录"),
	SUPP_POLICY("供应商政策"),
	EXPRESS("配送服务"),
	SALES_RULES_DISABLE("禁售规则"),
	USERMEMBER("会员"),
	SALES_RULES_SOURCE("营销调控规则"),
	SALES_RULES_SUPP("虚拟调控规则"),
	LVMAMA_TRAFFIC("驴妈妈自订"),
	ORDER_CANCEL("取消单"),

	FLIGHT_ORDER_MAIN("机票主单"),
	FLIGHT_SUPP_ORDER("机票供应商订单"),
	FLIGHT_ORDER("机票子单"),
	FLIGHT_ORDER_DETAIL("机票订单明细"),
	NOTICE("通知规则"),
	BLACK_ID("黑名单操作");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private BusinessType(String cnName) {
		this.cnName = cnName;
	}
}
