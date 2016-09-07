package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.ApplyRefundType;
import com.lvmama.lvf.common.dto.enums.RefundModel;
import com.lvmama.lvf.common.dto.status.detail.DetailAuditStatus;
import com.lvmama.lvf.common.dto.status.detail.DetailSuppAuditStatus;
import com.lvmama.lvf.common.dto.status.detail.DetailTicketStatus;

/**
 * 订单明细退废票申请
 * @author lven
 * @date   2015-2-9
 */
public class FlightOrderDetailRTVTDto extends Entity implements Serializable 
{
	private static final long serialVersionUID = -7108224837662857227L;

	/** 订单明细主键 */
	private long orderDetailId;
	
	/** 订单明细退废金额 */
	private FlightOrderDetailRTVTAmountDto flightOrderDetailRTVTAmountDto = new FlightOrderDetailRTVTAmountDto();
	
	/** 审核状态 */
    private DetailAuditStatus detailAuditStatus;  
    
    /** 明细供应商审核状态 */
    private DetailSuppAuditStatus detailSuppAuditStatus;
    
    /** 票号状态 */
    private DetailTicketStatus detailTicketStatus;
	
	/** 退票类型*/
	private ApplyRefundType applyRefundType;
	
	/**是否需要取消位置*/
	private boolean cancelPNR;
	
	/** 退款原因*/
	private String refundReason;
	
	/** 退废票模式有人工、供应商两种，默认是人工出票*/
	private RefundModel refundModel = RefundModel.OP;
	
	/** 审核操作ID*/
	private Long auditOpId;
	
	public long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public FlightOrderDetailRTVTAmountDto getFlightOrderDetailRTVTAmountDto() {
		return flightOrderDetailRTVTAmountDto;
	}


	public void setFlightOrderDetailRTVTAmountDto(
			FlightOrderDetailRTVTAmountDto flightOrderDetailRTVTAmountDto) {
		this.flightOrderDetailRTVTAmountDto = flightOrderDetailRTVTAmountDto;
	}


	public BigDecimal getFeeRate() {
		return flightOrderDetailRTVTAmountDto.getFeeRate();
	}


	public void setFeeRate(BigDecimal feeRate) {
		flightOrderDetailRTVTAmountDto.setFeeRate(feeRate);
	}


	public BigDecimal getFee() {
		return flightOrderDetailRTVTAmountDto.getFee();
	}


	public void setFee(BigDecimal fee) {
		flightOrderDetailRTVTAmountDto.setFee(fee);
	}


	public BigDecimal getSurcharge() {
		return flightOrderDetailRTVTAmountDto.getSurcharge();
	}


	public void setSurcharge(BigDecimal surcharge) {
		flightOrderDetailRTVTAmountDto.setSurcharge(surcharge);
	}


	public BigDecimal getPlatformFee() {
		return flightOrderDetailRTVTAmountDto.getPlatformFee();
	}


	public void setPlatformFee(BigDecimal platformFee) {
		flightOrderDetailRTVTAmountDto.setPlatformFee(platformFee);
	}


	public BigDecimal getSupplierRefundAmount() {
		return flightOrderDetailRTVTAmountDto.getSupplierRefundAmount();
	}


	public void setSupplierRefundAmount(BigDecimal supplierRefundAmount) {
		flightOrderDetailRTVTAmountDto
				.setSupplierRefundAmount(supplierRefundAmount);
	}


	public BigDecimal getSupplierActualRefundAmount() {
		return flightOrderDetailRTVTAmountDto.getSupplierActualRefundAmount();
	}


	public void setSupplierActualRefundAmount(
			BigDecimal supplierActualRefundAmount) {
		flightOrderDetailRTVTAmountDto
				.setSupplierActualRefundAmount(supplierActualRefundAmount);
	}


	public BigDecimal getRefundAmount() {
		return flightOrderDetailRTVTAmountDto.getRefundAmount();
	}


	public void setRefundAmount(BigDecimal refundAmount) {
		flightOrderDetailRTVTAmountDto.setRefundAmount(refundAmount);
	}


	public BigDecimal getActualRefundAmount() {
		return flightOrderDetailRTVTAmountDto.getActualRefundAmount();
	}


	public void setActualRefundAmount(BigDecimal actualRefundAmount) {
		flightOrderDetailRTVTAmountDto
				.setActualRefundAmount(actualRefundAmount);
	}


	public DetailAuditStatus getDetailAuditStatus() {
		return detailAuditStatus;
	}


	public void setDetailAuditStatus(DetailAuditStatus detailAuditStatus) {
		this.detailAuditStatus = detailAuditStatus;
	}

	public DetailSuppAuditStatus getDetailSuppAuditStatus() {
		return detailSuppAuditStatus;
	}
	
	public void setDetailSuppAuditStatus(
			DetailSuppAuditStatus detailSuppAuditStatus) {
		this.detailSuppAuditStatus = detailSuppAuditStatus;
	}
	
	public DetailTicketStatus getDetailTicketStatus() {
		return detailTicketStatus;
	}


	public void setDetailTicketStatus(DetailTicketStatus detailTicketStatus) {
		this.detailTicketStatus = detailTicketStatus;
	}


	public ApplyRefundType getApplyRefundType() {
		return applyRefundType;
	}


	public void setApplyRefundType(ApplyRefundType applyRefundType) {
		this.applyRefundType = applyRefundType;
	}


	public boolean getCancelPNR() {
		return cancelPNR;
	}


	public void setCancelPNR(boolean cancelPNR) {
		this.cancelPNR = cancelPNR;
	}


	public String getRefundReason() {
		return refundReason;
	}


	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}


	public RefundModel getRefundModel() {
		return refundModel;
	}


	public void setRefundModel(RefundModel refundModel) {
		this.refundModel = refundModel;
	}


	public Long getAuditOpId() {
		return auditOpId;
	}


	public void setAuditOpId(Long auditOpId) {
		this.auditOpId = auditOpId;
	}


	@Override
	@JsonIgnore
	public String getSequence() {
		return "S_FORD_ORDER_DETAIL_RTVT";
	}
}
