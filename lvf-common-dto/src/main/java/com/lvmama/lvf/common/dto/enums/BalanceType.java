package com.lvmama.lvf.common.dto.enums;

/**
 * 收支类型
 * @author zengzhimin
 * @date   2016-07-26
 */
public enum BalanceType 
{
	INCOME("收入","1"),
	PAYOUT("支出","2");
	
	private String cnName;
	private String typeCode;
	
	private BalanceType(String cnName,String typeCode) {
		this.cnName = cnName;
		this.typeCode = typeCode;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	
	
}
