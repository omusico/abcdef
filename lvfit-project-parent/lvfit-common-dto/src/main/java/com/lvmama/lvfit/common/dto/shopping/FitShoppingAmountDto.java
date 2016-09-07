/**
 * Project Name:lvfit-common-dto
 * File Name:FitShoppingAmountDto.java
 * Package Name:com.lvmama.lvfit.common.dto.shopping
 * Date:2015-12-16下午1:37:37
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.common.dto.shopping;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * ClassName:FitShoppingAmountDto <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-12-16 下午1:37:37 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
public class FitShoppingAmountDto implements Serializable {
	private static final long serialVersionUID = 4017942089084636379L;
	/**
	 * 机票金额
	 */
	private BigDecimal flightAmount;
	/**
	 * 酒店金额
	 */
	private BigDecimal hotelAmount;
	
    /**门票金额 */
	private BigDecimal ticketAmount;
	
	/**航意险总价格 */
	private BigDecimal fliInsuranceAmount;
	
	/**保险金额*/
	private BigDecimal insuranceAmount;
	/**
	 * 组合套餐销售价
	 */
	private BigDecimal comboSalesAmount;
	
	/**组合套餐总价格  */
	private BigDecimal comboTotalAmount;
	
	/**组合套餐优惠价格  */
	private BigDecimal comboPromotionAmount;
	
	
	/**
	 * 可选产品销售价
	 */
	private BigDecimal choosableSalesAmount;
	
	/**可选产品中价格  */
	private BigDecimal choosableTotalAmount;
	
	/**可选产品优惠价格  */
	private BigDecimal choosablePromotionAmount;
	
	/**
	 * 总金额
	 */
	private BigDecimal totalAmount;
	/**
	 * 优惠总金额
	 */
	private BigDecimal promotionAmount;
	/**
	 * 实际销售金额
	 */
	private BigDecimal totalSalesAmount;
	/**
	 * flightAmount.
	 *
	 * @return  the flightAmount
	 * @since   JDK 1.6
	 */
	public BigDecimal getFlightAmount() {
		return flightAmount;
	}
	/**
	 * flightAmount.
	 *
	 * @param   flightAmount    the flightAmount to set
	 * @since   JDK 1.6
	 */
	public void setFlightAmount(BigDecimal flightAmount) {
		this.flightAmount = flightAmount;
	}
	/**
	 * hotelAmount.
	 *
	 * @return  the hotelAmount
	 * @since   JDK 1.6
	 */
	public BigDecimal getHotelAmount() {
		return hotelAmount;
	}
	/**
	 * hotelAmount.
	 *
	 * @param   hotelAmount    the hotelAmount to set
	 * @since   JDK 1.6
	 */
	public void setHotelAmount(BigDecimal hotelAmount) {
		this.hotelAmount = hotelAmount;
	}
	
	
	
	public BigDecimal getTicketAmount() {
		return ticketAmount;
	}
	
	public void setTicketAmount(BigDecimal ticketAmount) {
		this.ticketAmount = ticketAmount;
	}
	
	
	public BigDecimal getChoosableSalesAmount() {
		return choosableSalesAmount;
	}
	public void setChoosableSalesAmount(BigDecimal choosableSalesAmount) {
		this.choosableSalesAmount = choosableSalesAmount;
	}
	public BigDecimal getChoosableTotalAmount() {
		return choosableTotalAmount;
	}
	public void setChoosableTotalAmount(BigDecimal choosableTotalAmount) {
		this.choosableTotalAmount = choosableTotalAmount;
	}
	public BigDecimal getChoosablePromotionAmount() {
		return choosablePromotionAmount;
	}
	public void setChoosablePromotionAmount(BigDecimal choosablePromotionAmount) {
		this.choosablePromotionAmount = choosablePromotionAmount;
	}
	public BigDecimal getComboSalesAmount() {
		return comboSalesAmount;
	}
	public void setComboSalesAmount(BigDecimal comboSalesAmount) {
		this.comboSalesAmount = comboSalesAmount;
	}
	public BigDecimal getComboTotalAmount() {
		return comboTotalAmount;
	}
	public void setComboTotalAmount(BigDecimal comboTotalAmount) {
		this.comboTotalAmount = comboTotalAmount;
	}
	public BigDecimal getComboPromotionAmount() {
		return comboPromotionAmount;
	}
	public void setComboPromotionAmount(BigDecimal comboPromotionAmount) {
		this.comboPromotionAmount = comboPromotionAmount;
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
	public BigDecimal getInsuranceAmount() {
		return insuranceAmount;
	}
	public void setInsuranceAmount(BigDecimal insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}
    public BigDecimal getFliInsuranceAmount() {
        return fliInsuranceAmount;
    }
    public void setFliInsuranceAmount(BigDecimal fliInsuranceAmount) {
        this.fliInsuranceAmount = fliInsuranceAmount;
    }
	

}
