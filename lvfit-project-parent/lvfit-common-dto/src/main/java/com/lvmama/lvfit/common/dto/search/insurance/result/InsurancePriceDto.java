package com.lvmama.lvfit.common.dto.search.insurance.result;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.utils.DateUtils;


public class InsurancePriceDto implements Serializable{
    private static final long serialVersionUID = 5712705527511370995L;
    private Long timePriceId;
    private Long suppGoodsId;
    private Long supplierId;
    private String onsaleFlag;			//Y可售N禁售
    private String bookLimitType;  // 预定限制
    private Date startDate;
    private Date endDate;
    private String stockFlag;
    private Long settlementPrice;
    private Long price;
    private String priceModel;
    private float priceYuan;
    private String priceYuanStr;
    private String markerPriceYuan;
    private String settlementPriceYuan;
    private String settlementPriceYuanStr;
    protected Date specDate;
    protected Long aheadBookTime;// 提前预定时间
	public final Long getTimePriceId() {
		return timePriceId;
	}
	public final void setTimePriceId(Long timePriceId) {
		this.timePriceId = timePriceId;
	}
	public final Long getSuppGoodsId() {
		return suppGoodsId;
	}
	public final void setSuppGoodsId(Long suppGoodsId) {
		this.suppGoodsId = suppGoodsId;
	}
	public final Long getSupplierId() {
		return supplierId;
	}
	public final void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public final String getOnsaleFlag() {
		return onsaleFlag;
	}
	public final void setOnsaleFlag(String onsaleFlag) {
		this.onsaleFlag = onsaleFlag;
	}
	public final String getBookLimitType() {
		return bookLimitType;
	}
	public final void setBookLimitType(String bookLimitType) {
		this.bookLimitType = bookLimitType;
	}
	public final Date getStartDate() {
		return startDate;
	}
	public final void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public final Date getEndDate() {
		return endDate;
	}
	public final void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public final String getStockFlag() {
		return stockFlag;
	}
	public final void setStockFlag(String stockFlag) {
		this.stockFlag = stockFlag;
	}
	public final Long getSettlementPrice() {
		return settlementPrice;
	}
	public final void setSettlementPrice(Long settlementPrice) {
		this.settlementPrice = settlementPrice;
	}
	public final Long getPrice() {
		return price;
	}
	public final void setPrice(Long price) {
		this.price = price;
	}
	public final String getPriceModel() {
		return priceModel;
	}
	public final void setPriceModel(String priceModel) {
		this.priceModel = priceModel;
	}
	public final float getPriceYuan() {
		return priceYuan;
	}
	public final void setPriceYuan(float priceYuan) {
		this.priceYuan = priceYuan;
	}
	public final String getPriceYuanStr() {
		return priceYuanStr;
	}
	public final void setPriceYuanStr(String priceYuanStr) {
		this.priceYuanStr = priceYuanStr;
	}
	public final String getMarkerPriceYuan() {
		return markerPriceYuan;
	}
	public final void setMarkerPriceYuan(String markerPriceYuan) {
		this.markerPriceYuan = markerPriceYuan;
	}
	public final String getSettlementPriceYuan() {
		return settlementPriceYuan;
	}
	public final void setSettlementPriceYuan(String settlementPriceYuan) {
		this.settlementPriceYuan = settlementPriceYuan;
	}
	public final String getSettlementPriceYuanStr() {
		return settlementPriceYuanStr;
	}
	public final void setSettlementPriceYuanStr(String settlementPriceYuanStr) {
		this.settlementPriceYuanStr = settlementPriceYuanStr;
	}

	public Date getSpecDate() {
		return specDate;
	}
	public void setSpecDate(Date specDate) {
		this.specDate = specDate;
	}
	public Long getAheadBookTime() {
		return aheadBookTime;
	}
	public void setAheadBookTime(Long aheadBookTime) {
		this.aheadBookTime = aheadBookTime;
	}
}