package com.lvmama.lvfit.common.dto.sdp.goods;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 酒店房型信息
 * 
 * @author lishuiqing
 * 
 */
public class FitSdpHotelTimePriceDto implements Serializable {
	private static final long serialVersionUID = 7859865883852602292L;
	private String dateStr;
	private BigDecimal price;
	private BigDecimal settlementPrice; 
	// 库存。
	private Long stock;
	// 保留房标示》N：非保留房，不用验证库存
	private String stockFlag;
	// 总库存
	private Long totalStock;

	public BigDecimal getPrice() {
		return price;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public String getStockFlag() {
		return stockFlag;
	}

	public void setStockFlag(String stockFlag) {
		this.stockFlag = stockFlag;
	}

	public Long getTotalStock() {
		return totalStock;
	}

	public void setTotalStock(Long totalStock) {
		this.totalStock = totalStock;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getSettlementPrice() {
		return settlementPrice;
	}

	public void setSettlementPrice(BigDecimal settlementPrice) {
		this.settlementPrice = settlementPrice;
	}

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

}
