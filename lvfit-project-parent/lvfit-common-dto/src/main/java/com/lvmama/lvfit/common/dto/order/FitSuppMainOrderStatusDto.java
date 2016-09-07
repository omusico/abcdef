package com.lvmama.lvfit.common.dto.order;

import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.SuppVstAuditStatus;
import com.lvmama.lvfit.common.dto.enums.SuppVstOrderStatus;
import com.lvmama.lvfit.common.dto.enums.SuppVstOrderViewStatus;
import com.lvmama.lvfit.common.dto.enums.SuppVstPaymentStatus;


/**
 * 机酒供应商订单状态
 * @author leizhengwei
 *
 */
public class FitSuppMainOrderStatusDto extends Entity {
	
	private static final long serialVersionUID = 2418876606230894695L;
	
	private Long suppMainOrderId;
	
	private Long vstMainOrderNo;
	
	private SuppVstOrderViewStatus orderViewStatus;

	private SuppVstOrderStatus orderStatus;
	
	private SuppVstAuditStatus auditStatus;
	
	private SuppVstPaymentStatus paymentStatus;
	
	private Long waitPayTime;
	
	private List<FitSuppOrderStatusDto> suppOrderStatusDtos = new ArrayList<FitSuppOrderStatusDto>();

	public Long getSuppMainOrderId() {
		return suppMainOrderId;
	}

	public void setSuppMainOrderId(Long suppMainOrderId) {
		this.suppMainOrderId = suppMainOrderId;
	}

	public Long getVstMainOrderNo() {
		return vstMainOrderNo;
	}

	public void setVstMainOrderNo(Long vstMainOrderNo) {
		this.vstMainOrderNo = vstMainOrderNo;
	}

	public SuppVstOrderViewStatus getOrderViewStatus() {
		return orderViewStatus;
	}

	public void setOrderViewStatus(SuppVstOrderViewStatus orderViewStatus) {
		this.orderViewStatus = orderViewStatus;
	}

	public SuppVstOrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(SuppVstOrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public SuppVstAuditStatus getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(SuppVstAuditStatus auditStatus) {
		this.auditStatus = auditStatus;
	}

	public SuppVstPaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(SuppVstPaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Long getWaitPayTime() {
		return waitPayTime;
	}

	public void setWaitPayTime(Long waitPayTime) {
		this.waitPayTime = waitPayTime;
	}

	public List<FitSuppOrderStatusDto> getSuppOrderStatusDtos() {
		return suppOrderStatusDtos;
	}

	public void setSuppOrderStatusDtos(
			List<FitSuppOrderStatusDto> suppOrderStatusDtos) {
		this.suppOrderStatusDtos = suppOrderStatusDtos;
	}

}
