package com.lvmama.lvfit.common.dto.hotel;

import java.math.BigDecimal;

public class FitHotelTimePrice {
	
	private long pricePlanId;//planId
	/**
	 * 实际销售价
	 */
	private BigDecimal salesPrice;

	/**
	 * 结算价,不要传到前台去
	 */
	private BigDecimal settlePrice;
	
	
	/**优惠金额*/
	private BigDecimal promotion;


	public long getPricePlanId() {
		return pricePlanId;
	}


	public void setPricePlanId(long pricePlanId) {
		this.pricePlanId = pricePlanId;
	}


	public BigDecimal getSalesPrice() {
		return salesPrice;
	}


	public void setSalesPrice(BigDecimal salesPrice) {
		this.salesPrice = salesPrice;
	}


	public BigDecimal getSettlePrice() {
		return settlePrice;
	}


	public void setSettlePrice(BigDecimal settlePrice) {
		this.settlePrice = settlePrice;
	}


	public BigDecimal getPromotion() {
		return promotion;
	}


	public void setPromotion(BigDecimal promotion) {
		this.promotion = promotion;
	}
	
	
	
}
