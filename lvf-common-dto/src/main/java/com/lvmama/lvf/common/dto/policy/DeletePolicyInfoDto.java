package com.lvmama.lvf.common.dto.policy;

import java.io.Serializable;

public class DeletePolicyInfoDto implements Serializable{
	private String policyid;
	private String modifytime;
	public String getPolicyid() {
		return policyid;
	}
	public void setPolicyid(String policyid) {
		this.policyid = policyid;
	}
	public String getModifytime() {
		return modifytime;
	}
	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}
}
