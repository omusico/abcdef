package com.lvmama.lvf.common.dto.enums;

public enum SEND_STATUS {
	
	NOT_SENDED("未发送"),
	IS_SENDED("已发送");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private SEND_STATUS(String cnName) {
		this.cnName = cnName;
	}
	
}
