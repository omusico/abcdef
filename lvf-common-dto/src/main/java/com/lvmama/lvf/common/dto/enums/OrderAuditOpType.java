package com.lvmama.lvf.common.dto.enums;

import com.lvmama.lvf.common.dto.status.OpType;

/**
 * 订单视图类型
 * @author majun
 * @date   2015-3-9
 */
public enum OrderAuditOpType 
{
	ISSUEAUDIT("出票审核", OpType.ISSUE),
	ISSUEOP("出票处理", OpType.ISSUE),
	CTMTAUDIT("改签审核", OpType.CTMT),
	CTMTOP("改签处理", OpType.CTMT),
	RTVTAUDIT("退票审核", OpType.RTVT),
	RTVTOP("退票确认", OpType.RTVT);
	
	private String cnName;
	
	private OpType opType; 
	
	private OrderAuditOpType(String cnName, OpType opType) {
		this.cnName = cnName;
		this.opType = opType;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public OpType getOpType() {
		return opType;
	}

	public void setOpType(OpType opType) {
		this.opType = opType;
	}
}
