package com.lvmama.lvfit.common.dto.enums;


public enum OpPersonType {

	CREATEPER("创建人"),
	PAYPER("付款人"),
	AUDITPER("审核员"),
	ISSUEPER("出票员"),
	GATHERPER("收款员");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private OpPersonType(String cnName) {
		this.cnName = cnName;
	}
	
}
