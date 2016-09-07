package com.lvmama.lvfit.common.dto.enums;

/**
 * 符号枚举
 * @author leizhengwei
 *
 */
public enum SymbolType {

	Y("是"),
	N("否");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private SymbolType(String cnName) {
		this.cnName = cnName;
	} 
	
}
