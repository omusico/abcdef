package com.lvmama.lvfit.common.dto.enums;

/**
 * 支付方式
 * @author lven
 *
 */
public enum PaymentType {
//	ALIPAY("支付宝 ",PayType.ONLINE),
	PAY("支付宝 ",PayType.ONLINE),
	WEIXIN("微信",PayType.MOBILE),
	BAIDU("百度支付",PayType.ONLINE),
	UNION_PAY("银联",PayType.ONLINE),
	POS("POS",PayType.POS),
	POINT("积分",PayType.PHONE),
	CASH("现金",PayType.CASH),
	COUPON("抵用劵",PayType.COUPON),
    
	YEE("易宝电话",PayType.PHONE),
	HUNDRED("百付电话",PayType.PHONE),
	OFFLINE_CARD("线下拉卡",PayType.CARD),
    KENDRION("彬德POS",PayType.POS),
    DUMMY("虚拟",PayType.DUMMY),
    OTHER("其他",PayType.OTHER);

	private String cnName;
	private PayType payType;
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	public PayType getPayType() {
		return payType;
	}
	public void setPayType(PayType payType) {
		this.payType = payType;
	}
	private PaymentType(String cnName, PayType payType) {
		this.cnName = cnName;
		this.payType = payType;
	}
	

	public static PaymentType getPaymentTypeName(String name) {
		if(name==null||"".equals(name)){
			return null;
		}
		for (PaymentType paymentType : PaymentType.values()) {
			if (name.equals(paymentType.name())) {
				return paymentType;
			}
		}
		return null;
	}
}
