package com.lvmama.lvf.common.dto.policy;

import java.io.Serializable;

public class FlightPolicyTicketRuleDto implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -611207026401373304L;
	
	/** 修改和退票描述 */
	private String modifyAndRefundDesc;
	
	/** 修改描述 */
	private String modifyDesc;
	
	/** 改签描述 */
	private String changerDesc;
	
	/** 退票描述 */
	private String rTDesc;
	
	/** 废票描述 */
	private String vTDesc;
	
	public String getModifyAndRefundDesc() {
		return modifyAndRefundDesc;
	}
	public void setModifyAndRefundDesc(String modifyAndRefundDesc) {
		this.modifyAndRefundDesc = modifyAndRefundDesc;
	}
	public String getModifyDesc() {
		return modifyDesc;
	}
	public void setModifyDesc(String modifyDesc) {
		this.modifyDesc = modifyDesc;
	}
	public String getChangerDesc() {
		return changerDesc;
	}
	public void setChangerDesc(String changerDesc) {
		this.changerDesc = changerDesc;
	}
	public String getrTDesc() {
		return rTDesc;
	}
	public void setrTDesc(String rTDesc) {
		this.rTDesc = rTDesc;
	}
	public String getvTDesc() {
		return vTDesc;
	}
	public void setvTDesc(String vTDesc) {
		this.vTDesc = vTDesc;
	}
	
	
	
	
}
