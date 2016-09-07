package com.lvmama.lvfit.common.dto.enums;

/**
 * 状态
 * @author majun
 * @date   2015-2-6
 */
public enum Status 
{
	VALID("有效"),
	INVALID("无效");
	
	private String cnName;

	private Status(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
}
