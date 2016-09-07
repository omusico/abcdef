package com.lvmama.lvfit.common.dto.enums;

public enum PolicyModifyType {
	
	ADD("新增"),
	MOD_Y_AUDIT ("修改后已审核"),
	MOD_N_AUDIT("修改后待审核"),
	MOD_Y_AUDIT_N("修改后审核未通过"),
	DELETE("删除"),
	HANG("挂起");
	
	private String cnName;

	private PolicyModifyType(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}

}
