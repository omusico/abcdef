package com.lvmama.lvf.common.dto.status.order;

public enum OrderReservedStatus {
	BEFORE("先定位"),
	AFTER("后定位");
	
	private String cnName;
	
	private OrderReservedStatus(String cnName){
		this.cnName = cnName;
	}
	
	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
}
