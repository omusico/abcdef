package com.lvmama.lvfit.common.dto.status;

public enum OpSource {
	
	FRONT("前端"),
	BACK("后端"),
	SALES("分销"),
	SUPP("供应商");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private OpSource(String cnName) {
		this.cnName = cnName;
	}

}
