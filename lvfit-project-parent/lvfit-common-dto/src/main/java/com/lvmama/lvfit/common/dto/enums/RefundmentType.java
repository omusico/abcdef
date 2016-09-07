package com.lvmama.lvfit.common.dto.enums;
/**
 * 支付方式
 * @author lven
 *
 */
public enum RefundmentType {
//	ALIPAY("支付宝 ",RefundType.ONLINE),
	PAY("支付宝 ",RefundType.ONLINE),
	WEIXIN("微信",RefundType.MOBILE),
	BAIDU("百度支付",RefundType.ONLINE),
	UNION_PAY("银联",RefundType.ONLINE),
	POS("POS",RefundType.POS),
	POINT("积分",RefundType.PHONE),
	CASH("现金",RefundType.CASH),
	COUPON("抵用劵",RefundType.COUPON),
    
	YEE("易宝电话",RefundType.PHONE),
	HUNDRED("百付电话",RefundType.PHONE),
	OFFLINE_CARD("线下拉卡",RefundType.CARD),
    KENDRION("彬德POS",RefundType.POS),
    DUMMY("虚拟",RefundType.DUMMY),
    OTHER("其他",RefundType.OTHER);

	private String cnName;
	private RefundType refundType;
	
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	public RefundType getRefundType() {
		return refundType;
	}

	public void setRefundType(RefundType refundType) {
		this.refundType = refundType;
	}

	private RefundmentType(String cnName, RefundType refundType) {
		this.cnName = cnName;
		this.refundType = refundType;
	}
	
	public static RefundmentType getRefundmentTypeName(String name) {
		if(name==null||"".equals(name)){
			return null;
		}
		for (RefundmentType refundType : RefundmentType.values()) {
			if (name.equals(refundType.name())) {
				return refundType;
			}
		}
		return null;
	}
}
