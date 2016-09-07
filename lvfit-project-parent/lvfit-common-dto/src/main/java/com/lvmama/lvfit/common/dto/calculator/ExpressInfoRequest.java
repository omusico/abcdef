package com.lvmama.lvfit.common.dto.calculator;

public class ExpressInfoRequest {
	
	/**订单Id */
	private String orderMainId;
    
	/**快递公司码 */
	private String expressCode;

	public String getOrderMainId() {
		return orderMainId;
	}

	public void setOrderMainId(String orderMainId) {
		this.orderMainId = orderMainId;
	}

	public String getExpressCode() {
		return expressCode;
	}

	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}
	
}
