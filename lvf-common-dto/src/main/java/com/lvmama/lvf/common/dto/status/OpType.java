package com.lvmama.lvf.common.dto.status;

public enum OpType {
	
	NULL(""),
	HIDDEN("隐藏"),
	CONFIRM("核对"),
	PAY("支付"),
	REFUND("退款"),
	BOOKING("订位"),
	CANCEL("取消"),
	ONBROAD("已登机"),
	ISSUE("出票"),
	RTVT("退票"),
	CTMT("变更"),
	SUPP_CTMT("供应商变更"),
	SALES_SETTLMENT("分销渠道结算"),
	SUPP_SETTLMENT("供应商结算"),
	ORDER("订单"),
	LOG("日志");

	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private OpType(String cnName) {
		this.cnName = cnName;
	}

}
