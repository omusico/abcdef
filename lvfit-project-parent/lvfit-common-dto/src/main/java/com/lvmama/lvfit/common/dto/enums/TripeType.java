/**
 * 
 */
package com.lvmama.lvfit.common.dto.enums;

/**
 * @author chenshuang
 *
 */
public enum TripeType {
	DC("单程"), 
	WF("往返");
	
	private String cnName;

	private TripeType(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
}
