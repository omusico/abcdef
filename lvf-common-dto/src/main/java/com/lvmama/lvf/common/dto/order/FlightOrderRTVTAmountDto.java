package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单退废票金额信息
 * @author majun
 * @date   2015-4-27
 */
public class FlightOrderRTVTAmountDto implements Serializable
{
	private static final long serialVersionUID = 2957465873528176726L;
	
	/** 应退金额 */
	private BigDecimal rtvtAmount = BigDecimal.ZERO;
	
	/** 实退金额*/
	private BigDecimal orderRefundedAmount = BigDecimal.ZERO;
	
	/** 退废票票面价*/
	private BigDecimal rtvtTicketAmount = BigDecimal.ZERO;
	
	/** 退废票优惠金额 */
	private BigDecimal rtvtDiscountAmount = BigDecimal.ZERO;
	
	/** 退废票机建费*/
	private BigDecimal rtvtAirportTaxAmount = BigDecimal.ZERO;
	
	/** 退废票燃油费*/
	private BigDecimal rtvtFuelTaxAmount = BigDecimal.ZERO;
	
	/** 退废票手续费 */
	private BigDecimal rtvtFeeAmount = BigDecimal.ZERO;
	
	/** 退废票服务费*/
	private BigDecimal rtvtSurchargeAmount = BigDecimal.ZERO;
	
	/** 退废票保险费 */
	private BigDecimal rtvtInsuranceAmount = BigDecimal.ZERO;

	public BigDecimal getRtvtAmount() {
		return rtvtAmount;
	}

	public void setRtvtAmount(BigDecimal rtvtAmount) {
		this.rtvtAmount = rtvtAmount;
	}

	public BigDecimal getOrderRefundedAmount() {
		return orderRefundedAmount;
	}

	public void setOrderRefundedAmount(BigDecimal orderRefundedAmount) {
		this.orderRefundedAmount = orderRefundedAmount;
	}

	public BigDecimal getRtvtTicketAmount() {
		return rtvtTicketAmount;
	}

	public void setRtvtTicketAmount(BigDecimal rtvtTicketAmount) {
		this.rtvtTicketAmount = rtvtTicketAmount;
	}

	public BigDecimal getRtvtDiscountAmount() {
		return rtvtDiscountAmount;
	}

	public void setRtvtDiscountAmount(BigDecimal rtvtDiscountAmount) {
		this.rtvtDiscountAmount = rtvtDiscountAmount;
	}

	public BigDecimal getRtvtAirportTaxAmount() {
		return rtvtAirportTaxAmount;
	}

	public void setRtvtAirportTaxAmount(BigDecimal rtvtAirportTaxAmount) {
		this.rtvtAirportTaxAmount = rtvtAirportTaxAmount;
	}

	public BigDecimal getRtvtFuelTaxAmount() {
		return rtvtFuelTaxAmount;
	}

	public void setRtvtFuelTaxAmount(BigDecimal rtvtFuelTaxAmount) {
		this.rtvtFuelTaxAmount = rtvtFuelTaxAmount;
	}

	public BigDecimal getRtvtFeeAmount() {
		return rtvtFeeAmount;
	}

	public void setRtvtFeeAmount(BigDecimal rtvtFeeAmount) {
		this.rtvtFeeAmount = rtvtFeeAmount;
	}

	public BigDecimal getRtvtSurchargeAmount() {
		return rtvtSurchargeAmount;
	}

	public void setRtvtSurchargeAmount(BigDecimal rtvtSurchargeAmount) {
		this.rtvtSurchargeAmount = rtvtSurchargeAmount;
	}

	public BigDecimal getRtvtInsuranceAmount() {
		return rtvtInsuranceAmount;
	}

	public void setRtvtInsuranceAmount(BigDecimal rtvtInsuranceAmount) {
		this.rtvtInsuranceAmount = rtvtInsuranceAmount;
	}

	@Override
	public String toString() {
		return "应退金额=" + rtvtAmount
				+ ",  实退金额=" + orderRefundedAmount
				+ ",  退废票票面价=" + rtvtTicketAmount
				+ ", 退废票优惠金额=" + rtvtDiscountAmount
				+ ", 退废票机建费=" + rtvtAirportTaxAmount
				+ ", 退废票燃油费=" + rtvtFuelTaxAmount
				+ ", 退废票手续费=" + rtvtFeeAmount + ", 退废票服务费="
				+ rtvtSurchargeAmount + ", 退废票保险费="
				+ rtvtInsuranceAmount ;
	}
	
	
	
}
