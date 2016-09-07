package com.lvmama.lvfit.common.dto.hotel;

import com.lvmama.lvfit.common.dto.price.FitHotelPlanPriceDto;

public class FitHotelPlanDto {
	private FitHotelPlanPriceDto priceDto; 
	private Long suppGoodsId;//商品ID
    private String goodsName;//商品名称
    private Long dailyAverage;//日均价
	private Integer breakfast;//入住第一天价格早餐情况
    private Long minStock;  //商品紧张状态下的库存
    private long stockStatusOfTimeRange; 
	private long stockOfTimeRange;   
	private Boolean isOrNotSelled;
	private Boolean hasPriceValueOfTimeRange;
	private Boolean onsaleFlagValueOfTimeRange;
	
	
	public FitHotelPlanPriceDto getPriceDto() {
		return priceDto;
	}
	public void setPriceDto(FitHotelPlanPriceDto priceDto) {
		this.priceDto = priceDto;
	}
	public Long getSuppGoodsId() {
		return suppGoodsId;
	}
	public void setSuppGoodsId(Long suppGoodsId) {
		this.suppGoodsId = suppGoodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Long getDailyAverage() {
		return dailyAverage;
	}
	public void setDailyAverage(Long dailyAverage) {
		this.dailyAverage = dailyAverage;
	}
	public Integer getBreakfast() {
		return breakfast;
	}
	public void setBreakfast(Integer breakfast) {
		this.breakfast = breakfast;
	}
	public Long getMinStock() {
		return minStock;
	}
	public void setMinStock(Long minStock) {
		this.minStock = minStock;
	}
	public long getStockStatusOfTimeRange() {
		return stockStatusOfTimeRange;
	}
	public void setStockStatusOfTimeRange(long stockStatusOfTimeRange) {
		this.stockStatusOfTimeRange = stockStatusOfTimeRange;
	}
	public long getStockOfTimeRange() {
		return stockOfTimeRange;
	}
	public void setStockOfTimeRange(long stockOfTimeRange) {
		this.stockOfTimeRange = stockOfTimeRange;
	}
	public Boolean getIsOrNotSelled() {
		return isOrNotSelled;
	}
	public void setIsOrNotSelled(Boolean isOrNotSelled) {
		this.isOrNotSelled = isOrNotSelled;
	}
	public Boolean getHasPriceValueOfTimeRange() {
		return hasPriceValueOfTimeRange;
	}
	public void setHasPriceValueOfTimeRange(Boolean hasPriceValueOfTimeRange) {
		this.hasPriceValueOfTimeRange = hasPriceValueOfTimeRange;
	}
	public Boolean getOnsaleFlagValueOfTimeRange() {
		return onsaleFlagValueOfTimeRange;
	}
	public void setOnsaleFlagValueOfTimeRange(Boolean onsaleFlagValueOfTimeRange) {
		this.onsaleFlagValueOfTimeRange = onsaleFlagValueOfTimeRange;
	}
	
}
