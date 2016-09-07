package com.lvmama.lvfit.common.dto.status;

public enum OpAction {
	
	APPLY("申请"),
	WAIT("等待"),
	AUDIT_PASS("审核通过"),
	AUDIT_REJECT("审核驳回"),
	APPLY_SUPP_OP("申请供应商处理"),
	SYNC_SUPP_OP("同步供应商信息"),
	SUPP_OP_PASS("供应商处理通过"),
	SUPP_OP_REJECT("供应商处理驳回"),
	OP_PASS("处理通过"),
	OP_REJECT("处理驳回"),
	OP_OUTTIME("处理超时"),
	OP_REMAK("查看备注"),
	OP_LOG("查看日志");

	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private OpAction(String cnName) {
		this.cnName = cnName;
	}

}
