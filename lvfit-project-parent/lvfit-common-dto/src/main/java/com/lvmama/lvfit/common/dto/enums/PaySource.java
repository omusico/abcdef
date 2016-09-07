package com.lvmama.lvfit.common.dto.enums;
/**
 * 支付来源
 * @author lven
 *
 */
public enum PaySource {
	PAY_CENTER("支付中心",true),//线上支付，回调是支付中心
	CALL_CENTER("客服中心",false),//
	RESELLER("分销商",false),
	LVF_CENTER("后台中心",false),
	VST("VST",false);
	
	private String cnName;
	private Boolean needCallRefund;
	
	public Boolean getNeedCallRefund() {
		return needCallRefund;
	}

	public void setNeedCallRefund(Boolean needCallRefund) {
		this.needCallRefund = needCallRefund;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	private PaySource(String cnName,Boolean needCallRefund) {
		this.cnName = cnName;
		this.needCallRefund = needCallRefund;
	}

}
