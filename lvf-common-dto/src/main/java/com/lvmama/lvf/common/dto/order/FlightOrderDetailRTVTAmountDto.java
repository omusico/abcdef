package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单明细退废金额
 * @author majun
 * @date 2015-6-19
 */
public class FlightOrderDetailRTVTAmountDto implements Serializable
{
	private static final long serialVersionUID = 2752652658559382566L;
	
	/** 费率 */
	private BigDecimal feeRate = BigDecimal.ZERO;
	
	/** 手续费*/
	private BigDecimal fee = BigDecimal.ZERO;
	
	/** 附加费 服务费*/
	private BigDecimal surcharge = BigDecimal.ZERO;
	
	/** 平台费*/
	private BigDecimal platformFee = BigDecimal.ZERO;
	
	/** 供应商应退*/
	private BigDecimal supplierRefundAmount = BigDecimal.ZERO;
	
	/** 供应商实退*/
	private BigDecimal supplierActualRefundAmount = BigDecimal.ZERO;
	
	/** 应退*/
	private BigDecimal refundAmount = BigDecimal.ZERO;
	
	/** 实退*/
	private BigDecimal actualRefundAmount = BigDecimal.ZERO;

	public BigDecimal getFeeRate() {
		return feeRate;
	}

	public void setFeeRate(BigDecimal feeRate) {
		this.feeRate = feeRate;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public BigDecimal getSurcharge() {
		return surcharge;
	}

	public void setSurcharge(BigDecimal surcharge) {
		this.surcharge = surcharge;
	}

	public BigDecimal getPlatformFee() {
		return platformFee;
	}

	public void setPlatformFee(BigDecimal platformFee) {
		this.platformFee = platformFee;
	}

	public BigDecimal getSupplierRefundAmount() {
		return supplierRefundAmount;
	}

	public void setSupplierRefundAmount(BigDecimal supplierRefundAmount) {
		this.supplierRefundAmount = supplierRefundAmount;
	}

	public BigDecimal getSupplierActualRefundAmount() {
		return supplierActualRefundAmount;
	}

	public void setSupplierActualRefundAmount(BigDecimal supplierActualRefundAmount) {
		this.supplierActualRefundAmount = supplierActualRefundAmount;
	}

	public BigDecimal getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	public BigDecimal getActualRefundAmount() {
		return actualRefundAmount;
	}

	public void setActualRefundAmount(BigDecimal actualRefundAmount) {
		this.actualRefundAmount = actualRefundAmount;
	}
}
