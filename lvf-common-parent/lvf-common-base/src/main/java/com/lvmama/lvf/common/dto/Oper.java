package com.lvmama.lvf.common.dto;

import java.io.Serializable;

public class Oper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5095205994112519087L;

	/** 操作者 */
	public String oper;
	
	/** 操作者Id */
	public String operId;
	
	/**操作者类型*/
	public OperType operType;

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public OperType getOperType() {
		return operType;
	}

	public void setOperType(OperType operType) {
		this.operType = operType;
	}
	
}
