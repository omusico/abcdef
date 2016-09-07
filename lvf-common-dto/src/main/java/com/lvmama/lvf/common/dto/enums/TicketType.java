package com.lvmama.lvf.common.dto.enums;

/**
 * 订单明细客票类型
 * @author yuanweihong
 * @date   2015-3-3
 */
public enum TicketType 
{
	NORMAL("正常票"), 
	RTVT("退票"), 
	CTMT("改签票");
	
	private String cnName;

	private TicketType(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
}
