/**
 * Project Name:lvfit-common-dto
 * File Name:FitFlightAmountDto.java
 * Package Name:com.lvmama.lvfit.common.dto.shopping
 * Date:2015-12-18上午11:30:34
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.common.dto.shopping;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * ClassName:FitFlightAmountDto <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-12-18 上午11:30:34 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
public class FitFlightAmountDto implements Serializable {
	private static final long serialVersionUID = 7973144250734563841L;
	/**
	 * 成人总金额
	 */
	private BigDecimal adultAmount;
	/**
	 * 儿童总金额
	 */
	private BigDecimal childAmount;
	/**
	 * 总金额
	 */
	private BigDecimal totalAmount;
	/**
	 * 实际销售总金额
	 */
	private BigDecimal totalSalesAmount;
	
	/**
	 * 优惠总金额
	 */
	private BigDecimal promotionAmount;
	/**
	 * adultAmount.
	 *
	 * @return  the adultAmount
	 * @since   JDK 1.6
	 */
	public BigDecimal getAdultAmount() {
		return adultAmount;
	}
	/**
	 * adultAmount.
	 *
	 * @param   adultAmount    the adultAmount to set
	 * @since   JDK 1.6
	 */
	public void setAdultAmount(BigDecimal adultAmount) {
		this.adultAmount = adultAmount;
	}
	/**
	 * childAmount.
	 *
	 * @return  the childAmount
	 * @since   JDK 1.6
	 */
	public BigDecimal getChildAmount() {
		return childAmount;
	}
	/**
	 * childAmount.
	 *
	 * @param   childAmount    the childAmount to set
	 * @since   JDK 1.6
	 */
	public void setChildAmount(BigDecimal childAmount) {
		this.childAmount = childAmount;
	}
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
