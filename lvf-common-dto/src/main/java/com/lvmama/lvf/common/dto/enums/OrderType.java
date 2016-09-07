package com.lvmama.lvf.common.dto.enums;

/**
 * 订单类型
 * @author majun
 * @date   2015-3-9
 */
public enum OrderType 
{
	NORMAL("正常","1"),
	RTVT("退票","2"),
	CTMT("变更","3");
	
	private String cnName;
	private String typeCode;
	
	private OrderType(String cnName,String typeCode) {
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
