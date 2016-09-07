package com.lvmama.lvfit.common.dto.enums;


public enum OpTimeType {

	CREATETIEM("建单时间"),
	SUBMITTMIE("提交时间"),
	FLYTIME("起飞时间"),
	ISSUETIME("出票时间"),
	UPDATETIEM("修改时间"),
	GATHERTIME("收款时间");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private OpTimeType(String cnName) {
		this.cnName = cnName;
	}
	
}
