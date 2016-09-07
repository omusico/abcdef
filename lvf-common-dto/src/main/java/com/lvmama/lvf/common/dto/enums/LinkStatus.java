package com.lvmama.lvf.common.dto.enums;

public enum LinkStatus {

	LINK("关联"), REMOVE_LINK("解除关联");

	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private LinkStatus(String cnName) {
		this.cnName = cnName;
	}

}
