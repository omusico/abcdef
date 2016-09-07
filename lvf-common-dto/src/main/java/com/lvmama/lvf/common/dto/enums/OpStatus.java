package com.lvmama.lvf.common.dto.enums;

public enum OpStatus {
	
	NOT_DONE("未执行"),
	PART_DONE("部分执行"),
	ALL_DONE("已执行"),
	NOT_NEED("不需要");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	private OpStatus(String cnName) {
		this.cnName = cnName;
	}
	
	
}
