package com.lvmama.lvfit.common.dto.enums;

public enum InventoryType {

	INQUIRE_NO_STOCK("现询-未知库存"),
	INQUIRE_WITH_STOCK("现询-已知库存"),
	CONTROL("控位");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private InventoryType(String cnName) {
		this.cnName = cnName;
	}
	
}
