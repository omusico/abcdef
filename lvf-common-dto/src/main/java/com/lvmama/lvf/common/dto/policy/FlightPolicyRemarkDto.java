package com.lvmama.lvf.common.dto.policy;

import java.io.Serializable;

public class FlightPolicyRemarkDto implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 6639288546166061852L;
	
	/** 业务备注 */
	private String backRemark;
	
	/** 供应商备注 */
	private String suppRemark;
	
	public String getBackRemark() {
		return backRemark;
	}
	public void setBackRemark(String backRemark) {
		this.backRemark = backRemark;
	}
	public String getSuppRemark() {
		return suppRemark;
	}
	public void setSuppRemark(String suppRemark) {
		this.suppRemark = suppRemark;
	}
	
	
}
