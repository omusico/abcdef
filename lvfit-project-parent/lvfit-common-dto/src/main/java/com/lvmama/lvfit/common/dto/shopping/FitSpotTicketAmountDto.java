/**
 * Project Name:lvfit-common-dto
 * File Name:FitHotelAmountDto.java
 * Package Name:com.lvmama.lvfit.common.dto.shopping
 * Date:2015-12-21下午8:14:11
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.common.dto.shopping;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * ClassName:FitHotelAmountDto <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-12-21 下午8:14:11 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class FitSpotTicketAmountDto implements Serializable {
	private static final long serialVersionUID = 3333188115934240789L;
	
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

