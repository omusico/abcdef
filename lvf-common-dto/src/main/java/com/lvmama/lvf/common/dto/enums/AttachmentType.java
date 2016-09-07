package com.lvmama.lvf.common.dto.enums;

public enum AttachmentType {

	ORDER_REMARK("订单备注附件");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private AttachmentType(String cnName) {
		this.cnName = cnName;
	}	
	
}
