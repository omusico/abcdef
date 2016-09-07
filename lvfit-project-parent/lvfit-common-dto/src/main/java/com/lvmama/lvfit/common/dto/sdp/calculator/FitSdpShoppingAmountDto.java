package com.lvmama.lvfit.common.dto.sdp.calculator;

import java.io.Serializable;
import java.math.BigDecimal;

public class FitSdpShoppingAmountDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 机票金额*/
	private BigDecimal flightAmount;
	
	/** 酒店金额*/
	private BigDecimal hotelAmount;
	
	/** 酒店套餐金额*/
	private BigDecimal hotelComboAmount;
	
	/**当地游金额*/
	private BigDecimal localTripAmount;
	
    /**其他票金额 */
	private BigDecimal otherTicketAmount;
	
	/**保险金额*/
	private BigDecimal insuranceAmount;
	
	/**可选产品总价格  */
	private BigDecimal choosableTotalAmount;
	
	/**房差总价格*/
	private BigDecimal roomDiffAmount;
	
	/**组合套餐销售价*/
	private BigDecimal comboSalesAmount;
	
	/**组合套餐总价格*/
	private BigDecimal comboTotalAmount;
	
	/**组合套餐优惠价格*/
	private BigDecimal comboPromotionAmount;
	
	/**可选产品销售价*/
	private BigDecimal choosableSalesAmount;

	/**可选产品优惠价格*/
	private BigDecimal choosablePromotionAmount;
	
	/**优惠总金额*/
	private BigDecimal promotionAmount;
	
	/**实际销售金额*/
	private BigDecimal totalSalesAmount;
	
	/**总金额*/
	private BigDecimal totalAmount;

	public final BigDecimal getFlightAmount() {
		return flightAmount;
	}

	public final void setFlightAmount(BigDecimal flightAmount) {
		this.flightAmount = flightAmount;
	}

	public final BigDecimal getHotelComboAmount() {
		return hotelComboAmount;
	}

	public final void setHotelComboAmount(BigDecimal hotelComboAmount) {
		this.hotelComboAmount = hotelComboAmount;
	}

	public final BigDecimal getLocalTripAmount() {
		return localTripAmount;
	}

	public final void setLocalTripAmount(BigDecimal localTripAmount) {
		this.localTripAmount = localTripAmount;
	}

	public final BigDecimal getOtherTicketAmount() {
		return otherTicketAmount;
	}

	public final void setOtherTicketAmount(BigDecimal otherTicketAmount) {
		this.otherTicketAmount = otherTicketAmount;
	}

	public final BigDecimal getInsuranceAmount() {
		return insuranceAmount;
	}

	public final void setInsuranceAmount(BigDecimal insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}

	public final BigDecimal getChoosableTotalAmount() {
		return choosableTotalAmount;
	}

	public final void setChoosableTotalAmount(BigDecimal choosableTotalAmount) {
		this.choosableTotalAmount = choosableTotalAmount;
	}

	public final BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public final void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public final BigDecimal getRoomDiffAmount() {
		return roomDiffAmount;
	}

	public final void setRoomDiffAmount(BigDecimal roomDiffAmount) {
		this.roomDiffAmount = roomDiffAmount;
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

	public BigDecimal getChoosableSalesAmount() {
		return choosableSalesAmount;
	}

	public void setChoosableSalesAmount(BigDecimal choosableSalesAmount) {
		this.choosableSalesAmount = choosableSalesAmount;
	}

	public BigDecimal getChoosablePromotionAmount() {
		return choosablePromotionAmount;
	}

	public void setChoosablePromotionAmount(BigDecimal choosablePromotionAmount) {
		this.choosablePromotionAmount = choosablePromotionAmount;
	}

	public BigDecimal getPromotionAmount() {
		return promotionAmount;
	}

	public void setPromotionAmount(BigDecimal promotionAmount) {
		this.promotionAmount = promotionAmount;
	}

	public BigDecimal getTotalSalesAmount() {
		return totalSalesAmount;
	}

	public void setTotalSalesAmount(BigDecimal totalSalesAmount) {
		this.totalSalesAmount = totalSalesAmount;
	}

	public BigDecimal getHotelAmount() {
		return hotelAmount;
	}

	public void setHotelAmount(BigDecimal hotelAmount) {
		this.hotelAmount = hotelAmount;
	}

}
