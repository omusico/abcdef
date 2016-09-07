package com.lvmama.lvfit.common.dto.price;

import java.io.Serializable;
import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.status.ActiveStatus;
import com.lvmama.lvfit.common.dto.enums.PassengerType;
import com.lvmama.lvfit.common.dto.md.PriceFormula;

/**
 * 票价信息
 * @date   2015-1-13
 */
public class FitFlightTicketPriceDto  extends FitBasePriceDto implements Serializable
{
	private static final long serialVersionUID = 5315384569037627139L;
	
	/**
	 * Y舱票面价
	 */
	private BigDecimal yParPrice;
	
	/**
	 * 票面价
	 */
	private BigDecimal parPrice;
	/**
	 * 燃油税
	 */
	private BigDecimal fuelsurTax;
	/**
	 * 机场建设费
	 */
	private BigDecimal airportFee;
	
	/**
	 * 儿童燃油税
	 */
	private BigDecimal childrenFuelsurTax;
	/**
	 * 儿童机场建设费
	 */
	private BigDecimal childrenAirportFee;	
	
	/**
	 * 含税票面价
	 */
	private BigDecimal totalParPrice;
	/**
	 * 实际销售价
	 */
	private BigDecimal salesPrice;

	/**
	 * 票面销售价 即 销售价--燃油--基建
	 */
	private BigDecimal salesParPrice;
	
	/**
	 * 结算价
	 */
	private BigDecimal settlePrice;
	
	/**折扣*/
	private BigDecimal discount;
	
	/**优惠金额*/
	private BigDecimal promotion;
	
	/**优惠公式*/
	private PriceFormula promotionFormula;

	/**佣金*/
	private PriceFormula profit;
	
	/**佣金金额*/
	private BigDecimal profitAmount;
	
	/**原始销售金额*/
	private BigDecimal originalSalesPrice;

	/**
	 * 成人/儿童
	 * @return
	 */
	private PassengerType passengerType;

	private ActiveStatus activeStatus = new ActiveStatus();
	
	/**库存数量 */
	private Integer inventoryCount;
	
	
	public BigDecimal getSalesParPrice() {
		
		if(null==salesParPrice
				&&null!=parPrice
				&&null!=promotion){
			salesParPrice=parPrice.subtract(promotion);
		}
		
		return salesParPrice;
	}

	public void setSalesParPrice(BigDecimal salesParPrice) {
		this.salesParPrice = salesParPrice;
	}

	public BigDecimal getChildrenFuelsurTax() {
		return childrenFuelsurTax;
	}

	public void setChildrenFuelsurTax(BigDecimal childrenFuelsurTax) {
		this.childrenFuelsurTax = childrenFuelsurTax;
	}

	public BigDecimal getChildrenAirportFee() {
		return childrenAirportFee;
	}

	public void setChildrenAirportFee(BigDecimal childrenAirportFee) {
		this.childrenAirportFee = childrenAirportFee;
	}

	public void setActive(boolean active){};
	
//	@JsonIgnore
	public Boolean getActive() {
		return activeStatus.getActive();
	}

//	@JsonIgnore
	public ActiveStatus getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(ActiveStatus activeStatus) {
		this.activeStatus = activeStatus;
	}

	public BigDecimal getProfitAmount() {
		return profitAmount;
	}

	public void setProfitAmount(BigDecimal profitAmount) {
		this.profitAmount = profitAmount;
	}

	public BigDecimal getyParPrice() {
		return yParPrice;
	}

	public void setyParPrice(BigDecimal yParPrice) {
		this.yParPrice = yParPrice;
	}

	public PriceFormula getPromotionFormula() {
		return promotionFormula;
	}

	public void setPromotionFormula(PriceFormula promotionFormula) {
		this.promotionFormula = promotionFormula;
	}

	public BigDecimal getYParPrice() {
		return yParPrice;
	}

	public void setYParPrice(BigDecimal yParPrice) {
		this.yParPrice = yParPrice;
	}

	public BigDecimal getParPrice() {
		return parPrice;
	}

	public void setParPrice(BigDecimal parPrice) {
		this.parPrice = parPrice;
	}

	public BigDecimal getFuelsurTax() {
		return fuelsurTax;
	}

	public void setFuelsurTax(BigDecimal fuelsurTax) {
		this.fuelsurTax = fuelsurTax;
	}

	public BigDecimal getAirportFee() {
		return airportFee;
	}

	public void setAirportFee(BigDecimal airportFee) {
		this.airportFee = airportFee;
	}

	public BigDecimal getTotalParPrice() {
		return totalParPrice;
	}

	public void setTotalParPrice(BigDecimal totalParPrice) {
		this.totalParPrice = totalParPrice;
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

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getPromotion() {
		return promotion;
	}

	public void setPromotion(BigDecimal promotion) {
		this.promotion = promotion;
	}

	public PriceFormula getProfit() {
		return profit;
	}

	public void setProfit(PriceFormula profit) {
		this.profit = profit;
	}

	public PassengerType getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}

	public BigDecimal getOriginalSalesPrice() {
		return originalSalesPrice;
	}

	public void setOriginalSalesPrice(BigDecimal originalSalesPrice) {
		this.originalSalesPrice = originalSalesPrice;
	}

	public Integer getInventoryCount() {
		return inventoryCount;
	}

	public void setInventoryCount(Integer inventoryCount) {
		this.inventoryCount = inventoryCount;
	}

	
}
