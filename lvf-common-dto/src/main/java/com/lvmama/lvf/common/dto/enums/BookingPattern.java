package com.lvmama.lvf.common.dto.enums;

/**
 * 产品类型
 */
public enum BookingPattern
{
	INDIVIDUAL("散客"),
	TEAM("团队");

	private String cnName;

	private BookingPattern(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
}
