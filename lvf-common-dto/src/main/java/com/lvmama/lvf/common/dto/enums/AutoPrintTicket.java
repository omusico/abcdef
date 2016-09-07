package com.lvmama.lvf.common.dto.enums;

public enum AutoPrintTicket {
	
	AUTO_PRINT_TICKET("自动出票"),
	CC_PRINT_TICKET("人工出票");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private AutoPrintTicket(String cnName) {
		this.cnName = cnName;
	}
}
