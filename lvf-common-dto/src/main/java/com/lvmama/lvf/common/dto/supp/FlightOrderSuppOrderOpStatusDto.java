package com.lvmama.lvf.common.dto.supp;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.OpStatus;

/**
 * @author lutianyu
 * @date   2015-2-3
 */
public class FlightOrderSuppOrderOpStatusDto extends Entity implements Serializable{
	private static final long serialVersionUID = 2574357307401396752L;
	/** 供应商订单主键 */
	private Long suppOrderId;

	/** 创建VST订单 */
	private OpStatus createVstOrder = OpStatus.NOT_NEED;
	
	/** 资源确认 */
	private OpStatus resourceConfirm = OpStatus.NOT_NEED;
	
	/** 客服确认 */
	private OpStatus operConfirm = OpStatus.NOT_NEED;

	/** 客户确认 */
	private OpStatus customerConfirm = OpStatus.NOT_NEED;

	/** 供应商确认 */
	private OpStatus suppConfirm = OpStatus.NOT_NEED;
	
	/** 客户预授权 */
	private OpStatus preAuth = OpStatus.NOT_NEED;

	/** 客户申请付款 */
	private OpStatus customerApplyPay2LV = OpStatus.NOT_NEED;

	/** 客户付款 */
	private OpStatus customerPayed2LV = OpStatus.NOT_NEED;

	/** 申请付款给供应商 */
	private OpStatus lvApplyPay2Supp = OpStatus.NOT_NEED;

	/** 付款给供应商 */
	private OpStatus lvPayed2Supp = OpStatus.NOT_NEED;

	/** 人工申请订位 */
	private OpStatus operApplyPNR = OpStatus.NOT_NEED;
	
	/** 自动申请订位 */
	private OpStatus autoApplyPNR = OpStatus.NOT_NEED;
	
	/** 订位 */
	private OpStatus bookingPNR = OpStatus.NOT_NEED;
	
	/** 自动申请取消订位 */
	private OpStatus autoApplyCancelPNR = OpStatus.NOT_NEED;
	
	/** 取消订位 */
	private OpStatus cancelPNR = OpStatus.NOT_NEED;
	
	/** 取消订单 */
	private OpStatus cancelOrder = OpStatus.NOT_NEED;
	
	/** 申请出票 */
	private OpStatus applyTicket = OpStatus.NOT_NEED;

	/** 出票 */
	private OpStatus outTicket = OpStatus.NOT_NEED;
	
	/** 申请废票 */
	private OpStatus applyVoidTicket = OpStatus.NOT_NEED;
	
	/** 废票 */
	private OpStatus voidTicket = OpStatus.NOT_NEED;
	
	/** 申请退票 */
	private OpStatus applyRefundTicket = OpStatus.NOT_NEED;
	
	/** 退票 */
	private OpStatus refundTicket = OpStatus.NOT_NEED;

	/** 申请退款 */
	private OpStatus applyLVRefund2Customer = OpStatus.NOT_NEED;
	
	/** 退款 */
	private OpStatus lvRefund2Customer = OpStatus.NOT_NEED;

	/** 发需支付提醒邮件 */
	private OpStatus sendPayNotifyEmail = OpStatus.NOT_NEED;
	
	/** 发需支付提醒短信 */
	private OpStatus sendPayNotifySMS = OpStatus.NOT_NEED;
	
	/** 发需支付提醒传真 */
	private OpStatus sendPayNotifyFax = OpStatus.NOT_NEED;
	
	/** 打印行程单 */
	private OpStatus printBSP = OpStatus.NOT_NEED;
	
	/** 快递行程单 */
	private OpStatus expressBSP = OpStatus.NOT_NEED;
	
	/** 发出行提醒短信 */
	private OpStatus sendNotifySMS = OpStatus.NOT_NEED;
	
	/** 发出行提醒邮件 */
	private OpStatus sendNotifyEmail = OpStatus.NOT_NEED;
	
	/** 发出取消提醒短信 */
	private OpStatus sendNotifyCancelSMS = OpStatus.NOT_NEED;

	/** 供应商退废票API*/
	private OpStatus suppRtVtAPI = OpStatus.NOT_NEED;
	
	
	public Long getSuppOrderId() {
		return suppOrderId;
	}

	public void setSuppOrderId(Long suppOrderId) {
		this.suppOrderId = suppOrderId;
	}

	public OpStatus getCreateVstOrder() {
		return createVstOrder;
	}

	public void setCreateVstOrder(OpStatus createVstOrder) {
		this.createVstOrder = createVstOrder;
	}

	public OpStatus getResourceConfirm() {
		return resourceConfirm;
	}

	public void setResourceConfirm(OpStatus resourceConfirm) {
		this.resourceConfirm = resourceConfirm;
	}

	public OpStatus getOperConfirm() {
		return operConfirm;
	}

	public void setOperConfirm(OpStatus operConfirm) {
		this.operConfirm = operConfirm;
	}

	public OpStatus getCustomerConfirm() {
		return customerConfirm;
	}

	public void setCustomerConfirm(OpStatus customerConfirm) {
		this.customerConfirm = customerConfirm;
	}

	public OpStatus getSuppConfirm() {
		return suppConfirm;
	}

	public void setSuppConfirm(OpStatus suppConfirm) {
		this.suppConfirm = suppConfirm;
	}

	public OpStatus getPreAuth() {
		return preAuth;
	}

	public void setPreAuth(OpStatus preAuth) {
		this.preAuth = preAuth;
	}

	public OpStatus getCustomerApplyPay2LV() {
		return customerApplyPay2LV;
	}

	public void setCustomerApplyPay2LV(OpStatus customerApplyPay2LV) {
		this.customerApplyPay2LV = customerApplyPay2LV;
	}

	public OpStatus getCustomerPayed2LV() {
		return customerPayed2LV;
	}

	public void setCustomerPayed2LV(OpStatus customerPayed2LV) {
		this.customerPayed2LV = customerPayed2LV;
	}

	public OpStatus getLvApplyPay2Supp() {
		return lvApplyPay2Supp;
	}

	public void setLvApplyPay2Supp(OpStatus lvApplyPay2Supp) {
		this.lvApplyPay2Supp = lvApplyPay2Supp;
	}

	public OpStatus getLvPayed2Supp() {
		return lvPayed2Supp;
	}

	public void setLvPayed2Supp(OpStatus lvPayed2Supp) {
		this.lvPayed2Supp = lvPayed2Supp;
	}

	public OpStatus getOperApplyPNR() {
		return operApplyPNR;
	}

	public void setOperApplyPNR(OpStatus operApplyPNR) {
		this.operApplyPNR = operApplyPNR;
	}

	public OpStatus getAutoApplyPNR() {
		return autoApplyPNR;
	}

	public void setAutoApplyPNR(OpStatus autoApplyPNR) {
		this.autoApplyPNR = autoApplyPNR;
	}

	public OpStatus getBookingPNR() {
		return bookingPNR;
	}

	public void setBookingPNR(OpStatus bookingPNR) {
		this.bookingPNR = bookingPNR;
	}

	public OpStatus getAutoApplyCancelPNR() {
		return autoApplyCancelPNR;
	}

	public void setAutoApplyCancelPNR(OpStatus autoApplyCancelPNR) {
		this.autoApplyCancelPNR = autoApplyCancelPNR;
	}

	public OpStatus getCancelPNR() {
		return cancelPNR;
	}

	public void setCancelPNR(OpStatus cancelPNR) {
		this.cancelPNR = cancelPNR;
	}

	public OpStatus getCancelOrder() {
		return cancelOrder;
	}

	public void setCancelOrder(OpStatus cancelOrder) {
		this.cancelOrder = cancelOrder;
	}

	public OpStatus getApplyTicket() {
		return applyTicket;
	}

	public void setApplyTicket(OpStatus applyTicket) {
		this.applyTicket = applyTicket;
	}

	public OpStatus getOutTicket() {
		return outTicket;
	}

	public void setOutTicket(OpStatus outTicket) {
		this.outTicket = outTicket;
	}

	public OpStatus getApplyVoidTicket() {
		return applyVoidTicket;
	}

	public void setApplyVoidTicket(OpStatus applyVoidTicket) {
		this.applyVoidTicket = applyVoidTicket;
	}

	public OpStatus getVoidTicket() {
		return voidTicket;
	}

	public void setVoidTicket(OpStatus voidTicket) {
		this.voidTicket = voidTicket;
	}

	public OpStatus getApplyRefundTicket() {
		return applyRefundTicket;
	}

	public void setApplyRefundTicket(OpStatus applyRefundTicket) {
		this.applyRefundTicket = applyRefundTicket;
	}

	public OpStatus getRefundTicket() {
		return refundTicket;
	}

	public void setRefundTicket(OpStatus refundTicket) {
		this.refundTicket = refundTicket;
	}

	public OpStatus getApplyLVRefund2Customer() {
		return applyLVRefund2Customer;
	}

	public void setApplyLVRefund2Customer(OpStatus applyLVRefund2Customer) {
		this.applyLVRefund2Customer = applyLVRefund2Customer;
	}

	public OpStatus getLvRefund2Customer() {
		return lvRefund2Customer;
	}

	public void setLvRefund2Customer(OpStatus lvRefund2Customer) {
		this.lvRefund2Customer = lvRefund2Customer;
	}

	public OpStatus getSendPayNotifyEmail() {
		return sendPayNotifyEmail;
	}

	public void setSendPayNotifyEmail(OpStatus sendPayNotifyEmail) {
		this.sendPayNotifyEmail = sendPayNotifyEmail;
	}

	public OpStatus getSendPayNotifySMS() {
		return sendPayNotifySMS;
	}

	public void setSendPayNotifySMS(OpStatus sendPayNotifySMS) {
		this.sendPayNotifySMS = sendPayNotifySMS;
	}

	public OpStatus getSendPayNotifyFax() {
		return sendPayNotifyFax;
	}

	public void setSendPayNotifyFax(OpStatus sendPayNotifyFax) {
		this.sendPayNotifyFax = sendPayNotifyFax;
	}

	public OpStatus getPrintBSP() {
		return printBSP;
	}

	public void setPrintBSP(OpStatus printBSP) {
		this.printBSP = printBSP;
	}

	public OpStatus getExpressBSP() {
		return expressBSP;
	}

	public void setExpressBSP(OpStatus expressBSP) {
		this.expressBSP = expressBSP;
	}

	public OpStatus getSendNotifySMS() {
		return sendNotifySMS;
	}

	public void setSendNotifySMS(OpStatus sendNotifySMS) {
		this.sendNotifySMS = sendNotifySMS;
	}

	public OpStatus getSendNotifyEmail() {
		return sendNotifyEmail;
	}

	public void setSendNotifyEmail(OpStatus sendNotifyEmail) {
		this.sendNotifyEmail = sendNotifyEmail;
	}

	public OpStatus getSendNotifyCancelSMS() {
		return sendNotifyCancelSMS;
	}

	public void setSendNotifyCancelSMS(OpStatus sendNotifyCancelSMS) {
		this.sendNotifyCancelSMS = sendNotifyCancelSMS;
	}

	/**
	 * @return the suppRtVtAPI
	 */
	public OpStatus getSuppRtVtAPI() {
		return suppRtVtAPI;
	}

	/**
	 * @param suppRtVtAPI the suppRtVtAPI to set
	 */
	public void setSuppRtVtAPI(OpStatus suppRtVtAPI) {
		this.suppRtVtAPI = suppRtVtAPI;
	}
}
