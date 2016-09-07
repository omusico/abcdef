package com.lvmama.lvfit.common.dto.enums;

/**
 * 订单航班组合明细类型
 * @author majun
 * @date   2015-3-6
 */
public enum FlightOrderFlightCombinationDetailType 
{
	NORMAL("正常"),
	CTMT("改签");
	
	private String cnName;
	
	private FlightOrderFlightCombinationDetailType(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
}
