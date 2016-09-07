package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.lvmama.lvf.common.dto.BusinessType;
import com.lvmama.lvf.common.dto.OpLog;
import com.lvmama.lvf.common.dto.enums.AuditType;
import com.lvmama.lvf.common.dto.status.order.OrderAuditStatus;
import com.lvmama.lvf.common.dto.status.order.OrderTicketStatus;

/**
 * 订单操作日志
 * 
 * @author majun
 * @date 2015-1-13
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderOpLogDto extends OpLog implements Serializable {

	private static final long serialVersionUID = -8696022710694240305L;

	/** 主订单主键 */
	private Long orderMainId;

	/** 订单主键 */
	private Long orderId;

	/** 订单审核类型 */
	private AuditType auditType;

	/** 订单审核状态 */
	private OrderAuditStatus orderAuditStatus;

	/** 订单出退改状态枚举 */
	private OrderTicketStatus orderTicketStatus;

	
	/** 监控号 */
	private String traceNo;
	
	/** 订单操作日志代码 */
	private OrderOpLogCode orderOpLogCode;
	
	public Long getOrderMainId() {
		return orderMainId;
	}

	public void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public AuditType getAuditType() {
		return auditType;
	}

	public void setAuditType(AuditType auditType) {
		this.auditType = auditType;
	}

	public OrderAuditStatus getOrderAuditStatus() {
		return orderAuditStatus;
	}

	public void setOrderAuditStatus(OrderAuditStatus orderAuditStatus) {
		this.orderAuditStatus = orderAuditStatus;
	}

	public OrderTicketStatus getOrderTicketStatus() {
		return orderTicketStatus;
	}

	public void setOrderTicketStatus(OrderTicketStatus orderTicketStatus) {
		this.orderTicketStatus = orderTicketStatus;
	}



	public String getTraceNo() {
		return traceNo;
	}

	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}

	public OrderOpLogCode getOrderOpLogCode() {
		return orderOpLogCode;
	}

	public void setOrderOpLogCode(OrderOpLogCode orderOpLogCode) {
		this.orderOpLogCode = orderOpLogCode;
	}

	public OrderOpLogDto putOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
		return this;
	}

	public OrderOpLogDto putOrderId(Long orderId) {
		this.orderId = orderId;
		return this;
	}

	public OrderOpLogDto putResult(String result) {
		this.setResult(result);
		return this;
	}

	public OrderOpLogDto putTraceNo(String traceNo) {
		this.traceNo = traceNo;
		return this;
	}

	public OrderOpLogDto putOrderOpLogCode(OrderOpLogCode orderOpLogCode) {
		this.orderOpLogCode = orderOpLogCode;
		return this;
	}
	
	public OrderOpLogDto putOrderOpLogCode(OrderOpLogCode orderOpLogCode, Object... vars)
	{
		this.orderOpLogCode = orderOpLogCode;
		this.setRemark(orderOpLogCode.getMessage(vars));
		return this;
	}
	
	public OrderOpLogDto putRemark(String remark) {
		this.remark = remark;
		return this;
	}

	public OrderOpLogDto putDesc(String desc) {
		this.desc = desc;
		return this;
	}
	
	public OrderOpLogDto putBusinessType(BusinessType businessType) {
		super.setBusinessType(businessType);
		return this;
	}
	
	public OrderOpLogDto putBusinessId(String businessId) {
		super.setBusinessId(businessId);
		return this;
	}

	public OrderOpLogDto putBusinessNo(String businessNo) {
		super.setBusinessNo(businessNo);
		return this;
	}
}