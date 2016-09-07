package com.lvmama.lvfit.common.dto.search.hotel.result;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.lvmama.lvfit.common.dto.price.FitHotelPlanPriceDto;
import com.lvmama.lvfit.common.dto.vst.VstGoods;

public class HotelSearchPlanDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5598664714659389580L;
	// 商品时间价格表
	private List<FitHotelPlanPriceDto> dayPrice;

	
	// VstGoods
	private VstGoods goods;
		
	// planId
	private String suppGoodsId;
	
	// 产品ID
	private String productId;
	
	// 
	private String productBranchId;
	// 商品名称
	private String goodsName;

	// 支付对象
	private String payTarget;
	
	// 结算价格
	private BigDecimal settlementPrice;
	// 售价
	private BigDecimal price;
	// 早餐
	private Integer breakfast;
	//扣款数值（金额/百分比）
	private BigDecimal deductValue;
	//差价
	private BigDecimal priceDifferences;
	//单个房间的差价
	private BigDecimal priceDifferencesSingle;
	/**
	 * 选中plan
	 */
	private Boolean selectedFlag =  false;

	/**商品是否有效*/
	private String cancelFlag;
	
	/**最小房间数 用于前台页面下拉框控制展现*/
	private Integer minRoomCounts;

	/**最大房间数 用于前台页面下拉框控制展现*/
	private Integer maxRoomCounts;
	
	public VstGoods getGoods() {
		return goods;
	}

	public void setGoods(VstGoods goods) {
		this.goods = goods;
	}

	public String getSuppGoodsId() {
		return suppGoodsId;
	}

	public void setSuppGoodsId(String suppGoodsId) {
		this.suppGoodsId = suppGoodsId;
	}

	public String getProductBranchId() {
		return productBranchId;
	}

	public void setProductBranchId(String productBranchId) {
		this.productBranchId = productBranchId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getPayTarget() {
		return payTarget;
	}

	public void setPayTarget(String payTarget) {
		this.payTarget = payTarget;
	}

	public String getAheadBookTime() {
		return aheadBookTime;
	}

	public void setAheadBookTime(String aheadBookTime) {
		this.aheadBookTime = aheadBookTime;
	}

	public String getAperiodicFlag() {
		return aperiodicFlag;
	}

	public void setAperiodicFlag(String aperiodicFlag) {
		this.aperiodicFlag = aperiodicFlag;
	}

	public String getBuyPresentFlag() {
		return buyPresentFlag;
	}

	public void setBuyPresentFlag(String buyPresentFlag) {
		this.buyPresentFlag = buyPresentFlag;
	}

	public Double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagMemo() {
		return tagMemo;
	}

	public void setTagMemo(String tagMemo) {
		this.tagMemo = tagMemo;
	}

	public String getPromotionFlag() {
		return promotionFlag;
	}

	public void setPromotionFlag(String promotionFlag) {
		this.promotionFlag = promotionFlag;
	}

	public String getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(String promotionType) {
		this.promotionType = promotionType;
	}

	public String getRebatePc() {
		return rebatePc;
	}

	public void setRebatePc(String rebatePc) {
		this.rebatePc = rebatePc;
	}

	public String getRebateMobile() {
		return rebateMobile;
	}

	public void setRebateMobile(String rebateMobile) {
		this.rebateMobile = rebateMobile;
	}

	public String getSpecDate() {
		return specDate;
	}

	public void setSpecDate(String specDate) {
		this.specDate = specDate;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getCancelStrategy() {
		return cancelStrategy;
	}

	public void setCancelStrategy(String cancelStrategy) {
		this.cancelStrategy = cancelStrategy;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	// 提前预定时间
	private String aheadBookTime;
	// 是否期票
	private String aperiodicFlag;
	// 买赠标志
    private String buyPresentFlag;

	// 市场价格
	private Double marketPrice;
	// 销售价格
	private Double sellPrice;

	// 标签名称
	private String tagName;
	// 标签描述
	private String tagMemo;

	// 促销标示
	private String promotionFlag;

	// 促销标签
	private String promotionType;

	// 返现金额(PC)
	private String rebatePc;
	
	// 返现金额(MOBILE)
	private String rebateMobile;

	// 团购结束时间
	private String specDate;

	// 产品图片URL
	private String photoUrl;
	// 退改类型
	private String cancelStrategy;

	// 产品名称
	private String productName;
	
	private Integer minStayDay;//最小连住天数
	
	private Integer maxStayDay;//最大连住天数
	//** 最少起订量**/
	private Integer minQuantity;
	/** 最大起订量**/
	private Integer maxQuantity;
	//最大预定量
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	
	public BigDecimal getSettlementPrice() {
		return settlementPrice;
	}

	public void setSettlementPrice(BigDecimal settlementPrice) {
		this.settlementPrice = settlementPrice;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(Integer breakfast) {
		this.breakfast = breakfast;
	}

	public BigDecimal getDeductValue() {
		return deductValue;
	}

	public void setDeductValue(BigDecimal deductValue) {
		this.deductValue = deductValue;
	}

	/**
	 * selectedFlag.
	 *
	 * @return the selectedFlag
	 * @since JDK 1.6
	 */
	public Boolean getSelectedFlag() {
		if (null == selectedFlag) {
			return Boolean.FALSE;
		}
		return selectedFlag;
	}

	/**
	 * selectedFlag.
	 *
	 * @param   selectedFlag    the selectedFlag to set
	 * @since   JDK 1.6
	 */
	public void setSelectedFlag(Boolean selectedFlag) {
		this.selectedFlag = selectedFlag;
	}

	public BigDecimal getPriceDifferences() {
		return priceDifferences;
	}

	public void setPriceDifferences(BigDecimal priceDifferences) {
		this.priceDifferences = priceDifferences;
	}

	public BigDecimal getPriceDifferencesSingle() {
		return priceDifferencesSingle;
	}

	public void setPriceDifferencesSingle(BigDecimal priceDifferencesSingle) {
		this.priceDifferencesSingle = priceDifferencesSingle;
	}

	public List<FitHotelPlanPriceDto> getDayPrice() {
		return dayPrice;
	}

	public void setDayPrice(List<FitHotelPlanPriceDto> dayPrice) {
		this.dayPrice = dayPrice;
	}

	public String getCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	public Integer getMinStayDay() {
		return minStayDay;
	}

	public void setMinStayDay(Integer minStayDay) {
		this.minStayDay = minStayDay;
	}

	public Integer getMaxStayDay() {
		return maxStayDay;
	}

	public void setMaxStayDay(Integer maxStayDay) {
		this.maxStayDay = maxStayDay;
	}

	public Integer getMinRoomCounts() {
		return minRoomCounts;
	}

	public void setMinRoomCounts(Integer minRoomCounts) {
		this.minRoomCounts = minRoomCounts;
	}

	public Integer getMaxRoomCounts() {
		return maxRoomCounts;
	}

	public void setMaxRoomCounts(Integer maxRoomCounts) {
		this.maxRoomCounts = maxRoomCounts;
	}

	public Integer getMinQuantity() {
		return minQuantity;
	}

	public void setMinQuantity(Integer minQuantity) {
		this.minQuantity = minQuantity;
	}

	public Integer getMaxQuantity() {
		return maxQuantity;
	}

	public void setMaxQuantity(Integer maxQuantity) {
		this.maxQuantity = maxQuantity;
	}
}
