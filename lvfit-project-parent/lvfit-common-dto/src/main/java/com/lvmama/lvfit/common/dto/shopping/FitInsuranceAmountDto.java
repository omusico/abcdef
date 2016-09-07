package com.lvmama.lvfit.common.dto.shopping;

import java.io.Serializable;
import java.math.BigDecimal;

public class FitInsuranceAmountDto implements Serializable{
	
	private static final long serialVersionUID = 3053762692589157830L;
	
	/**
	 * 总金额
	 */
	private BigDecimal totalAmount;
	/**
	 * 实际销售总金额
	 */
	private BigDecimal totalSalesAmount;
	
	/**
	 * 总优惠金额
	 */
	private BigDecimal promotionAmount;

	/**
	 * totalAmount.
	 *
	 * @return  the totalAmount
	 * @since   JDK 1.6
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	/**
	 * totalAmount.
	 *
	 * @param   totalAmount    the totalAmount to set
	 * @since   JDK 1.6
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * totalSalesAmount.
	 *
	 * @return  the totalSalesAmount
	 * @since   JDK 1.6
	 */
	public BigDecimal getTotalSalesAmount() {
		return totalSalesAmount;
	}

	/**
	 * totalSalesAmount.
	 *
	 * @param   totalSalesAmount    the totalSalesAmount to set
	 * @since   JDK 1.6
	 */
	public void setTotalSalesAmount(BigDecimal totalSalesAmount) {
		this.totalSalesAmount = totalSalesAmount;
	}

	/**
	 * promotionAmount.
	 *
	 * @return  the promotionAmount
	 * @since   JDK 1.6
	 */
	public BigDecimal getPromotionAmount() {
		return promotionAmount;
	}

	/**
	 * promotionAmount.
	 *
	 * @param   promotionAmount    the promotionAmount to set
	 * @since   JDK 1.6
	 */
	public void setPromotionAmount(BigDecimal promotionAmount) {
		this.promotionAmount = promotionAmount;
	}
	

}
