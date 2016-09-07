package com.lvmama.lvf.common.dto;

import java.io.Serializable;

/**
 * 
 * @author lven
 * @date 2015-3-4
 */
public class BaseAuditRequest implements Serializable {

	private static final long serialVersionUID = -7719285307898545795L;
	
	/** 审核操作ID */
	private Long auditOpId;
	
	/** 主订单主键 */
	private Long orderMainId;
	
	/** 订单主键 */
	private Long orderId;
	
	public BaseAuditRequest() {
	}

	/**
	 * @return the auditOpId
	 */
	public Long getAuditOpId() {
		return auditOpId;
	}

	/**
	 * @param auditOpId
	 *            the auditOpId to set
	 */
	public void setAuditOpId(Long auditOpId) {
		this.auditOpId = auditOpId;
	}

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

}
