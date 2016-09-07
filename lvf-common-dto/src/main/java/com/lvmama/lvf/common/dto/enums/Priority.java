package com.lvmama.lvf.common.dto.enums;

/**
 * 适用场景
 * @author hedandan
 * @date   2015-8-10
 */
public enum Priority{
	
	ZERO("0"),
	ONE("1"),
	TWO("2"),
	THREE("3");
	
	private String cnName;
	
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	private Priority(String cnName) {
		this.cnName = cnName;
	}

}
