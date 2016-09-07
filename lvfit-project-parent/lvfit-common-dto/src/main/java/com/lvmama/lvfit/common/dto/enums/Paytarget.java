package com.lvmama.lvfit.common.dto.enums;

//支付对象
public enum Paytarget {

	PREPAID("预付（驴妈妈）"), PAY("现付（供应商）");

	private String cnName;

	public static String getCnName(String code) {
		for (Paytarget item : Paytarget.values()) {
			if (item.getCode().equals(code)) {
				return item.getCnName();
			}
		}
		return code;
	}

	Paytarget(String name) {
		this.cnName = name;
	}

	public String getCode() {
		return this.name();
	}

	public String getCnName() {
		return this.cnName;
	}

	@Override
	public String toString() {
		return this.name();
	}
}