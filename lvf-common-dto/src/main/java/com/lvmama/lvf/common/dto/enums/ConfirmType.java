package com.lvmama.lvf.common.dto.enums;

public enum ConfirmType {

	PHONE("电话"),
	FAX("传真"),
	EMAIL("电子邮件"),
	SMS("短信"),
	MM("微信");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private ConfirmType(String cnName) {
		this.cnName = cnName;
	}
	
	public static ConfirmType getConfirmTypeByName(String name) {
		if(name==null||"".equals(name)||"null".equals(name)){
			return null;
		}
		for (ConfirmType confirmType : ConfirmType.values()) {
			if (name.equals(confirmType.name())) {
				return confirmType;
			}
		}
		return null;
	}
	
	
}
