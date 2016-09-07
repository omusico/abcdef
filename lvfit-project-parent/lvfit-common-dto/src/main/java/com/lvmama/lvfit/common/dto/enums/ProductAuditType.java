package com.lvmama.lvfit.common.dto.enums;


public enum ProductAuditType {

	AUDITTYPE_NO_SUBMIT("待提交"),
	AUDITTYPE_TO_PM("待产品经理审核"),
	AUDITTYPE_BACK_PM("产品经理退回,待提交"),
	AUDITTYPE_TO_QA("待QA审核"),
	AUDITTYPE_BACK_QA("QA退回，待提交"),
	AUDITTYPE_TO_BUSINESS("待商务审核"),
	AUDITTYPE_BACK_BUSINESS("商务退回，待提交"),
	AUDITTYPE_PASS("审核通过");
	
	
	private String cnName;
	
	ProductAuditType(String name) {
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

	public static String getCnName(String code) {
		for (ProductAuditType item : ProductAuditType.values()) {
			if (item.getCode().equals(code)) {
				return item.getCnName();
			}
		}
		return code;
	}
}
