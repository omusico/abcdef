package com.lvmama.lvf.common.dto.supp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.SuppRefundStatus;

/**
 * 供应商订单PNR退票信息
 * @author majun
 * @date   2015-2-4
 */
public class FlightOrderSuppOrderPNRRefundDto extends Entity implements Serializable
{
	private static final long serialVersionUID = 8456035406644775338L;
	
	/** 订单主键 */
	private Long orderId;

	/** 供应商订单主键 */
	private Long suppOrderId;
	
	/** 订单PNR退票主键 */
	private Long orderPNRRefundId;

	/** 供应商订单PNR信息主键 */
	private Long suppPnrInfoId;
	
	/** 退票单号 */
	private String suppRefundNo;
	
	/** 退票申请时间 */
	private Date applyRefundTime;
	
	/** 实际退票时间 */
	private Date factRefundTime;
	
	/** 退票金额 */
	private BigDecimal refundAmount;
	
	/** 退票变动利润 */
	private BigDecimal refundChangeProfit;
	
	/** 退款状态 */
	private SuppRefundStatus suppRefundStatus; 
	
	/** 供应商订单退票票号信息 */
	private List<FlightOrderSuppOrderTicketRefundDto> flightOrderSuppOrderTicketRefunds;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getSuppOrderId() {
		return suppOrderId;
	}

	public void setSuppOrderId(Long suppOrderId) {
		this.suppOrderId = suppOrderId;
	}

	public Long getOrderPNRRefundId() {
		return orderPNRRefundId;
	}

	public void setOrderPNRRefundId(Long orderPNRRefundId) {
		this.orderPNRRefundId = orderPNRRefundId;
	}

	public Long getSuppPnrInfoId() {
		return suppPnrInfoId;
	}

	public void setSuppPnrInfoId(Long suppPnrInfoId) {
		this.suppPnrInfoId = suppPnrInfoId;
	}

	public String getSuppRefundNo() {
		return suppRefundNo;
	}

	public void setSuppRefundNo(String suppRefundNo) {
		this.suppRefundNo = suppRefundNo;
	}

	public Date getApplyRefundTime() {
		return applyRefundTime;
	}

	public void setApplyRefundTime(Date applyRefundTime) {
		this.applyRefundTime = applyRefundTime;
	}

	public Date getFactRefundTime() {
		return factRefundTime;
	}

	public void setFactRefundTime(Date factRefundTime) {
		this.factRefundTime = factRefundTime;
	}

	public BigDecimal getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	public BigDecimal getRefundChangeProfit() {
		return refundChangeProfit;
	}

	public void setRefundChangeProfit(BigDecimal refundChangeProfit) {
		this.refundChangeProfit = refundChangeProfit;
	}

	public SuppRefundStatus getSuppRefundStatus() {
		return suppRefundStatus;
	}

	public void setSuppRefundStatus(SuppRefundStatus suppRefundStatus) {
		this.suppRefundStatus = suppRefundStatus;
	}

	public List<FlightOrderSuppOrderTicketRefundDto> getFlightOrderSuppOrderTicketRefunds() {
		return flightOrderSuppOrderTicketRefunds;
	}

	public void setFlightOrderSuppOrderTicketRefunds(
			List<FlightOrderSuppOrderTicketRefundDto> flightOrderSuppOrderTicketRefunds) {
		this.flightOrderSuppOrderTicketRefunds = flightOrderSuppOrderTicketRefunds;
	}
	
	public void copyFromDto(FlightOrderSuppOrderPNRRefundDto pnrRefundRequest){
		this.setApplyRefundTime(pnrRefundRequest.getApplyRefundTime());
		this.setFactRefundTime(pnrRefundRequest.getFactRefundTime());
		this.setFlightOrderSuppOrderTicketRefunds(pnrRefundRequest.getFlightOrderSuppOrderTicketRefunds());
		this.setOrderPNRRefundId(pnrRefundRequest.getOrderPNRRefundId());
		this.setSuppPnrInfoId(pnrRefundRequest.getOrderPNRRefundId());
		this.setRefundAmount(pnrRefundRequest.getRefundAmount());
		this.setRefundChangeProfit(pnrRefundRequest.getRefundChangeProfit());
		this.setSuppOrderId(pnrRefundRequest.getSuppOrderId());
		this.setSuppRefundNo(pnrRefundRequest.getSuppRefundNo());
		
	}
}
