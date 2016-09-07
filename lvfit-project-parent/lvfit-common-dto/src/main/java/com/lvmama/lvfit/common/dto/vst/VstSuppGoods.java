package com.lvmama.lvfit.common.dto.vst;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VstSuppGoods  implements Serializable{

	/**
	 * serialVersionUID:TODO.
	 * @since JDK 1.6
	 */
	private static final long serialVersionUID = -611989165818269237L;
	
    private Long suppGoodsId;//商品ID
   
    private String goodsName;//商品名称
    
    private Long dailyAverage;//日均价
	private Integer breakfast;//入住第一天价格早餐情况
	//商品紧张状态下的库存
    private Long minStock;
    private long stockStatusOfTimeRange;
	private long stockOfTimeRange;
	private Boolean isOrNotSelled;
	private Boolean hasPriceValueOfTimeRange;
	private Boolean onsaleFlagValueOfTimeRange;
    //酒店退改规则
  	private Map<String,String> hotelCancelStrategyDesc;
    private List<VstSuppGoodPrice> suppGoodPrices = new ArrayList<VstSuppGoodPrice>();

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

	

	public List<VstSuppGoodPrice> getSuppGoodPrices() {
		return suppGoodPrices;
	}

	public void setSuppGoodPrices(List<VstSuppGoodPrice> suppGoodPrices) {
		this.suppGoodPrices = suppGoodPrices;
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

	public Map<String, String> getHotelCancelStrategyDesc() {
		return hotelCancelStrategyDesc;
	}

	public void setHotelCancelStrategyDesc(
			Map<String, String> hotelCancelStrategyDesc) {
		this.hotelCancelStrategyDesc = hotelCancelStrategyDesc;
	}
	

    
   
   
	
}
