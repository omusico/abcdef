package com.lvmama.lvf.common.dto.enums;

public enum CRUDType {

	NULL(""),
	SELECT("查询"),
	INSERT("添加"),
	UPDATE("更新"),
	DELETE("删除");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private CRUDType(String cnName) {
		this.cnName = cnName;
	}

	
}
