package com.lvmama.lvf.common.form.md;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.BusinessType;
import com.lvmama.lvf.common.dto.OpLog;
import com.lvmama.lvf.common.dto.OperType;
import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.AuditType;
import com.lvmama.lvf.common.dto.order.OrderOpLogDto;
import com.lvmama.lvf.common.dto.status.order.OrderAuditStatus;
import com.lvmama.lvf.common.dto.status.order.OrderTicketStatus;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;


public class OrderOpLogViewForm implements Serializable, Form{

	private static final long serialVersionUID = -9215364606063668677L;

	private String createDate;

	private OrderOpLogDto orderOpLogDto = new OrderOpLogDto();
	
	
	private String auditTypeCnName;
	
	private String orderAuditStatusCnName;
	
	private String orderTicketStatusCnName;
	
	
	private String operTypeName;
	
	
	
	
	
	

	public String getOperTypeName() {
		return operTypeName;
	}

	public void setOperTypeName(String operTypeName) {
		this.operTypeName = operTypeName;
	}

	public String getTraceNo() {
		return orderOpLogDto.getTraceNo();
	}

	public void setTraceNo(String traceNo) {
		orderOpLogDto.setTraceNo(traceNo);
	}

	public String getResult() {
		return orderOpLogDto.getResult();
	}

	public void setResult(String result) {
		orderOpLogDto.setResult(result);
	}

	public String getAuditTypeCnName() {
		return auditTypeCnName;
	}

	public void setAuditTypeCnName(String auditTypeCnName) {
		this.auditTypeCnName = auditTypeCnName;
	}

	public String getOrderAuditStatusCnName() {
		return orderAuditStatusCnName;
	}

	public void setOrderAuditStatusCnName(String orderAuditStatusCnName) {
		this.orderAuditStatusCnName = orderAuditStatusCnName;
	}

	public String getOrderTicketStatusCnName() {
		return orderTicketStatusCnName;
	}

	public void setOrderTicketStatusCnName(String orderTicketStatusCnName) {
		this.orderTicketStatusCnName = orderTicketStatusCnName;
	}

	public String getCreateDate() {
		return DateUtils.formatCnHmDateS(orderOpLogDto.getCreateTime());
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public OrderOpLogDto getOrderOpLogDto() {
		return orderOpLogDto;
	}

	public void setOrderOpLogDto(OrderOpLogDto orderOpLogDto) {
		this.orderOpLogDto = orderOpLogDto;
	}

	public PersistenceType getPtype() {
		return orderOpLogDto.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		orderOpLogDto.setPtype(ptype);
	}

	public String getSequence() {
		return orderOpLogDto.getSequence();
	}

	public Long getId() {
		return orderOpLogDto.getId();
	}

	public String getOperId() {
		return orderOpLogDto.getOperId();
	}

	public void setId(Long id) {
		orderOpLogDto.setId(id);
	}

	public void setOperId(String operId) {
		orderOpLogDto.setOperId(operId);
	}

	public String getUuid() {
		return orderOpLogDto.getUuid();
	}

	public String getOper() {
		return orderOpLogDto.getOper();
	}

	public void setUuid(String uuid) {
		orderOpLogDto.setUuid(uuid);
	}

	public Long getOrderMainId() {
		return orderOpLogDto.getOrderMainId();
	}

	public void setOper(String oper) {
		orderOpLogDto.setOper(oper);
	}

	public Date getCreateTime() {
		return orderOpLogDto.getCreateTime();
	}

	public void setOrderMainId(Long orderMainId) {
		orderOpLogDto.setOrderMainId(orderMainId);
	}

	public String getRemark() {
		return orderOpLogDto.getRemark();
	}

	public void setCreateTime(Date createTime) {
		orderOpLogDto.setCreateTime(createTime);
	}

	public void setRemark(String remark) {
		orderOpLogDto.setRemark(remark);
	}

	public Long getOrderId() {
		return orderOpLogDto.getOrderId();
	}

	public Date getUpdateTime() {
		return orderOpLogDto.getUpdateTime();
	}

	public String getDesc() {
		return orderOpLogDto.getDesc();
	}

	public void setOrderId(Long orderId) {
		orderOpLogDto.setOrderId(orderId);
	}

	public void setDesc(String desc) {
		orderOpLogDto.setDesc(desc);
	}

	public void setUpdateTime(Date updateTime) {
		orderOpLogDto.setUpdateTime(updateTime);
	}

	public AuditType getAuditType() {
		return orderOpLogDto.getAuditType();
	}

	public BusinessType getBusinessType() {
		return orderOpLogDto.getBusinessType();
	}

	public void setAuditType(AuditType auditType) {
		orderOpLogDto.setAuditType(auditType);
	}

	public void setBusinessType(BusinessType businessType) {
		orderOpLogDto.setBusinessType(businessType);
	}

	public OrderAuditStatus getOrderAuditStatus() {
		return orderOpLogDto.getOrderAuditStatus();
	}

	public String getBusinessId() {
		return orderOpLogDto.getBusinessId();
	}

	public void setOrderAuditStatus(OrderAuditStatus orderAuditStatus) {
		orderOpLogDto.setOrderAuditStatus(orderAuditStatus);
	}

	public void setBusinessId(String businessId) {
		orderOpLogDto.setBusinessId(businessId);
	}

	public String getBusinessNo() {
		return orderOpLogDto.getBusinessNo();
	}

	public OrderTicketStatus getOrderTicketStatus() {
		return orderOpLogDto.getOrderTicketStatus();
	}

	public void setBusinessNo(String businessNo) {
		orderOpLogDto.setBusinessNo(businessNo);
	}

	public void setOrderTicketStatus(OrderTicketStatus orderTicketStatus) {
		orderOpLogDto.setOrderTicketStatus(orderTicketStatus);
	}

	public OperType getOperType() {
		return orderOpLogDto.getOperType();
	}

	public void setOperType(OperType operType) {
		orderOpLogDto.setOperType(operType);
	}
	
	
	
	
	

	
}
