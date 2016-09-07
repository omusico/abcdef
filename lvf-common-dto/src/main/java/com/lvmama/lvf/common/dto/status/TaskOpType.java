package com.lvmama.lvf.common.dto.status;

public enum TaskOpType {
	
	NULL(""),
	ADD("新增"),
	SYSTEM_START_RUN("系统执行开始"),
	SYSTEM_END_RUN("系统执行结束"),
	UPDATE("更新"),
	DISABLE("禁用"),
	ENABLE("启用"),
	OPER_START_RUN("人工执行开始"),
	OPER_END_RUN("人工执行结束");

	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private TaskOpType(String cnName) {
		this.cnName = cnName;
	}

}
