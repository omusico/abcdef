package com.lvmama.lvfit.common.dto.audit;

import com.lvmama.lvf.common.dto.BaseAuditRequest;
import com.lvmama.lvf.common.dto.BusinessType;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.OpLog;
import com.lvmama.lvfit.common.dto.status.OrderAuditType;
import com.lvmama.lvfit.common.dto.status.order.OrderAuditStatus;

/**
 * 订单审核对象
 * @author qihuisong
 * @param <I>
 */
public class OrderAuditDto<I extends BaseAuditRequest> extends Entity {

	private I request;
	
	private OpLog opLog;
	
	private OrderAuditStatus auditStatus;

	private OrderAuditType auditType;

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

	public OrderAuditStatus getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(OrderAuditStatus auditStatus) {
		this.auditStatus = auditStatus;
	}

	public OrderAuditType getAuditType() {
		return auditType;
	}

	public void setAuditType(OrderAuditType auditType) {
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
