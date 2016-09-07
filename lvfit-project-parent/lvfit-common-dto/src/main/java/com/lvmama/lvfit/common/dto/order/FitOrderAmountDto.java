package com.lvmama.lvfit.common.dto.order;

import java.io.Serializable;
import java.math.BigDecimal;

public class FitOrderAmountDto implements Serializable {

	private static final long serialVersionUID = -1994418531861820772L;

	/** 总金额 */
	private BigDecimal totalAmount;
	/** 总销售金额 */
	private BigDecimal totalSalesAmount;
	/** 总优惠金额 */
	private BigDecimal totalDiscountAmount;
	/** 利润金额 */
	private BigDecimal profitAmount;
	/** 预付金额 */
	private BigDecimal prepaidAmount;
	/** 支付金额 */
	private BigDecimal payedAmount;
	/** 机票：总金额（机票单品预定核算价格必须项） */
	private BigDecimal flightTotalSalesAmount; //TODO 待废除
	/** 机票：成人总价（VST算价必须项） */
	private BigDecimal adultAmount; //TODO 待废除
	/** 机票：儿童总价（VST算价必须项） */
	private BigDecimal childAmount; //TODO 待废除

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getTotalSalesAmount() {
		return totalSalesAmount;
	}

	public void setTotalSalesAmount(BigDecimal totalSalesAmount) {
		this.totalSalesAmount = totalSalesAmount;
	}

	public BigDecimal getTotalDiscountAmount() {
		return totalDiscountAmount;
	}

	public void setTotalDiscountAmount(BigDecimal totalDiscountAmount) {
		this.totalDiscountAmount = totalDiscountAmount;
	}

	public BigDecimal getProfitAmount() {
		return profitAmount;
	}

	public void setProfitAmount(BigDecimal profitAmount) {
		this.profitAmount = profitAmount;
	}

	public BigDecimal getPrepaidAmount() {
		return prepaidAmount;
	}

	public void setPrepaidAmount(BigDecimal prepaidAmount) {
		this.prepaidAmount = prepaidAmount;
	}

	public BigDecimal getPayedAmount() {
		return payedAmount;
	}

	public void setPayedAmount(BigDecimal payedAmount) {
		this.payedAmount = payedAmount;
	}

	public BigDecimal getFlightTotalSalesAmount() {
		return flightTotalSalesAmount;
	}

	public void setFlightTotalSalesAmount(BigDecimal flightTotalSalesAmount) {
		this.flightTotalSalesAmount = flightTotalSalesAmount;
	}

	public BigDecimal getAdultAmount() {
		return adultAmount;
	}

	public void setAdultAmount(BigDecimal adultAmount) {
		this.adultAmount = adultAmount;
	}

	public BigDecimal getChildAmount() {
		return childAmount;
	}

	public void setChildAmount(BigDecimal childAmount) {
		this.childAmount = childAmount;
	}
}
