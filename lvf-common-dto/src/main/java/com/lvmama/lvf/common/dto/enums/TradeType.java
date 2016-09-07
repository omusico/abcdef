package com.lvmama.lvf.common.dto.enums;
/**
 * 交易类型
 * @author jiacheng
 *
 */
public enum TradeType {
	PAYOUT("支出"),
	INCOME("收入");

	private String cnName;
	
	private TradeType(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}
	
}
