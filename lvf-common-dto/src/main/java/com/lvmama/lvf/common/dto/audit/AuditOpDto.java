package com.lvmama.lvf.common.dto.audit;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.BaseAuditRequest;
import com.lvmama.lvf.common.dto.BusinessType;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.OpLog;
import com.lvmama.lvf.common.dto.enums.AuditStatus;
import com.lvmama.lvf.common.dto.enums.AuditType;

@XmlRootElement
public class AuditOpDto<I extends BaseAuditRequest> extends Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6197014369798039963L;

	/**
	 * 对应的request
	 */
	private I request;
	
	private OpLog opLog;
	
	private AuditStatus auditStatus;

	private AuditType auditType;

	private BusinessType businessType;
	
	private String businessId;

	private String businessNo;
	
	private String taskId;
	
	private String attachmentId;
	
	private Long preAuditOpId;
	
	private String remark;
	
	public BusinessType getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
	}

	public Long getPreAuditOpId() {
		return preAuditOpId;
	}

	public void setPreAuditOpId(Long preAuditOpId) {
		this.preAuditOpId = preAuditOpId;
	}


	public OpLog getOpLog() {
		return opLog;
	}

	public void setOpLog(OpLog opLog) {
		this.opLog = opLog;
	}

	public AuditStatus getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(AuditStatus auditStatus) {
		this.auditStatus = auditStatus;
	}

	public AuditType getAuditType() {
		return auditType;
	}

	public void setAuditType(AuditType auditType) {
		this.auditType = auditType;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the request
	 */
	public I getRequest() {
		return request;
	}

	/**
	 * @param request the request to set
	 */
	public void setRequest(I request) {
		this.request = request;
	}




}
