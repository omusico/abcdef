package com.lvmama.lvf.common.dto.enums;

/**
 * 支付类型
 * @author lven
 *
 */
public enum PayType {
	ONLINE("在线"),
	MOBILE("移动"),
	CASH("现金"),
	POS("POS"),
	PHONE("电话"),
	POINT("积分"),
	COUPON("抵用券"),
	DUMMY("虚拟"),
	CARD("线下拉卡"),
	OTHER("其它");

	private String cnName;
	
	private PayType(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}
	

	public static PayType getPayTypeName(String name) {
		if(name==null||"".equals(name)){
			return null;
		}
		for (PayType payType : PayType.values()) {
			if (name.equals(payType.name())) {
				return payType;
			}
		}
		return null;
	}
}
