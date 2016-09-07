package com.lvmama.lvf.common.dto;

public enum PersistenceType {
	
	DEFAULT(false),
	INSERT(true);
	
	private Boolean needInsert;
	
	public Boolean getNeedInsert() {
		return needInsert;
	}

	private PersistenceType(Boolean needInsert) {
		this.needInsert = needInsert;
	}

}
