/**
 * 
 */
package com.lvmama.lvf.common.dto.enums;

/**
 * 
 * @author lven
 * @date   2015-3-4
 * 
 */
public enum RefundModel {

	SUPP("供应商"),
	OP("人工");

	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private RefundModel(String cnName) {
		this.cnName = cnName;
	}

}
