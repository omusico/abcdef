package com.lvmama.lvfit.common.dto.order;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.SuppVstInfoAuditStatus;
import com.lvmama.lvfit.common.dto.enums.SuppVstOrderItemStatus;
import com.lvmama.lvfit.common.dto.enums.SuppVstOrderStatus;
import com.lvmama.lvfit.common.dto.enums.SuppVstPaymentStatus;
import com.lvmama.lvfit.common.dto.enums.SuppVstResAuditStatus;


/**
 * 机酒供应商订单状态
 * @author leizhengwei
 *
 */
public class FitSuppOrderStatusDto extends Entity {
	
	
	private static final long serialVersionUID = 2418876606230894695L;
	
	private Long suppOrderId;
	
	private Long vstOrderNo;
	
    private SuppVstOrderStatus orderStatus;
	
    private SuppVstResAuditStatus resAuditStatus;
    
    private SuppVstInfoAuditStatus infoAuditStatus;
	
	private SuppVstPaymentStatus paymentStatus;

	private SuppVstOrderItemStatus orderItemStatus;
	
	 /**
     * 是否需要资源审核
     * */
    private String needResourceConfirm;
	
	public Long getSuppOrderId() {
		return suppOrderId;
	}

	public void setSuppOrderId(Long suppOrderId) {
		this.suppOrderId = suppOrderId;
	}

	public Long getVstOrderNo() {
		return vstOrderNo;
	}

	public void setVstOrderNo(Long vstOrderNo) {
		this.vstOrderNo = vstOrderNo;
	}

	public SuppVstOrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(SuppVstOrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public SuppVstResAuditStatus getResAuditStatus() {
		return resAuditStatus;
	}

	public void setResAuditStatus(SuppVstResAuditStatus resAuditStatus) {
		this.resAuditStatus = resAuditStatus;
	}

	public SuppVstInfoAuditStatus getInfoAuditStatus() {
		return infoAuditStatus;
	}

	public void setInfoAuditStatus(SuppVstInfoAuditStatus infoAuditStatus) {
		this.infoAuditStatus = infoAuditStatus;
	}

	public SuppVstPaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(SuppVstPaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public SuppVstOrderItemStatus getOrderItemStatus() {
		
		if(this.getInfoAuditStatus()==SuppVstInfoAuditStatus.UNVERIFIED&&this.getResAuditStatus()==SuppVstResAuditStatus.UNVERIFIED){
			return SuppVstOrderItemStatus.UNVERIFIED;
		}
		
		if(this.getInfoAuditStatus()==SuppVstInfoAuditStatus.INFOPASS&&this.getResAuditStatus()==SuppVstResAuditStatus.AMPLE){
			return SuppVstOrderItemStatus.VERIFIED;
		}
		
		if(this.getInfoAuditStatus()==SuppVstInfoAuditStatus.INFOPASS||this.getResAuditStatus()==SuppVstResAuditStatus.AMPLE){
			return SuppVstOrderItemStatus.VERIFIEDING;
		}
		
		if(this.getInfoAuditStatus()==SuppVstInfoAuditStatus.INFOFAIL||this.getResAuditStatus()==SuppVstResAuditStatus.LOCK){
			return SuppVstOrderItemStatus.NOVERIFIED;
		}
		return orderItemStatus;
	}

	public void setOrderItemStatus(SuppVstOrderItemStatus orderItemStatus) {
		this.orderItemStatus = orderItemStatus;
	}

	public String getNeedResourceConfirm() {
		return needResourceConfirm;
	}

	public void setNeedResourceConfirm(String needResourceConfirm) {
		this.needResourceConfirm = needResourceConfirm;
	}
	
}
