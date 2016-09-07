package com.lvmama.lvf.common.dto.adapter.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.policy.DeletePolicyInfoDto;
import com.lvmama.lvf.common.dto.policy.PolicyPushQueryDto;
/**
 * 517Na政策推送接口响应类
 */
public class PolicyPushQueryResponse implements Serializable{
	private List<DeletePolicyInfoDto> deleteallpolicyinfo = new ArrayList<DeletePolicyInfoDto>();
	private List<DeletePolicyInfoDto> deletepolicyinfo = new ArrayList<DeletePolicyInfoDto>();
	private List<PolicyPushQueryDto> policyinfo = new ArrayList<PolicyPushQueryDto>();
	
	public PolicyPushQueryResponse() {
		
	}
	
	public PolicyPushQueryResponse(
			List<DeletePolicyInfoDto> deleteallpolicyinfo,
			List<DeletePolicyInfoDto> deletepolicyinfo,
			List<PolicyPushQueryDto> policyinfo) {
		this.deleteallpolicyinfo = deleteallpolicyinfo;
		this.deletepolicyinfo = deletepolicyinfo;
		this.policyinfo = policyinfo;
	}

	public List<DeletePolicyInfoDto> getDeleteallpolicyinfo() {
		return deleteallpolicyinfo;
	}
	public void setDeleteallpolicyinfo(List<DeletePolicyInfoDto> deleteallpolicyinfo) {
		this.deleteallpolicyinfo = deleteallpolicyinfo;
	}
	public List<DeletePolicyInfoDto> getDeletepolicyinfo() {
		return deletepolicyinfo;
	}
	public void setDeletepolicyinfo(List<DeletePolicyInfoDto> deletepolicyinfo) {
		this.deletepolicyinfo = deletepolicyinfo;
	}
	public List<PolicyPushQueryDto> getPolicyinfo() {
		return policyinfo;
	}
	public void setPolicyinfo(List<PolicyPushQueryDto> policyinfo) {
		this.policyinfo = policyinfo;
	}
}
