package com.lvmama.lvfit.common.dto.vst;

import java.io.Serializable;

public class VstGoods implements Serializable {

	/**
	 * serialVersionUID:TODO.
	 * 
	 * @since JDK 1.6
	 */
	private static final long serialVersionUID = -677854236598833280L;
	// 供应商商品ID
	private String suppGoodsId;
	// 产品ID
	private String productId;
	// 商品ID
	private String productBranchId;
	// 商品名称
	private String goodsName;

	// 支付对象
	private String payTarget;
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

	// 商品描述
	private VstGoodsDesc goodsDescs;

	public final String getSuppGoodsId() {
		return suppGoodsId;
	}

	public final void setSuppGoodsId(String suppGoodsId) {
		this.suppGoodsId = suppGoodsId;
	}

	public final String getProductId() {
		return productId;
	}

	public final void setProductId(String productId) {
		this.productId = productId;
	}

	public final String getProductBranchId() {
		return productBranchId;
	}

	public final void setProductBranchId(String productBranchId) {
		this.productBranchId = productBranchId;
	}

	public final String getGoodsName() {
		return goodsName;
	}

	public final void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public final String getPayTarget() {
		return payTarget;
	}

	public final void setPayTarget(String payTarget) {
		this.payTarget = payTarget;
	}

	public final String getAheadBookTime() {
		return aheadBookTime;
	}

	public final void setAheadBookTime(String aheadBookTime) {
		this.aheadBookTime = aheadBookTime;
	}

	public final String getAperiodicFlag() {
		return aperiodicFlag;
	}

	public final void setAperiodicFlag(String aperiodicFlag) {
		this.aperiodicFlag = aperiodicFlag;
	}

	public final String getBuyPresentFlag() {
		return buyPresentFlag;
	}

	public final void setBuyPresentFlag(String buyPresentFlag) {
		this.buyPresentFlag = buyPresentFlag;
	}

	public final Double getMarketPrice() {
		return marketPrice;
	}

	public final void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public final Double getSellPrice() {
		return sellPrice;
	}

	public final void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public final String getTagName() {
		return tagName;
	}

	public final void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public final String getTagMemo() {
		return tagMemo;
	}

	public final void setTagMemo(String tagMemo) {
		this.tagMemo = tagMemo;
	}

	public final String getPromotionFlag() {
		return promotionFlag;
	}

	public final void setPromotionFlag(String promotionFlag) {
		this.promotionFlag = promotionFlag;
	}

	public final String getPromotionType() {
		return promotionType;
	}

	public final void setPromotionType(String promotionType) {
		this.promotionType = promotionType;
	}

	public final String getRebatePc() {
		return rebatePc;
	}

	public final void setRebatePc(String rebatePc) {
		this.rebatePc = rebatePc;
	}

	public final String getRebateMobile() {
		return rebateMobile;
	}

	public final void setRebateMobile(String rebateMobile) {
		this.rebateMobile = rebateMobile;
	}

	public final String getSpecDate() {
		return specDate;
	}

	public final void setSpecDate(String specDate) {
		this.specDate = specDate;
	}

	public final String getPhotoUrl() {
		return photoUrl;
	}

	public final void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public final String getCancelStrategy() {
		return cancelStrategy;
	}

	public final void setCancelStrategy(String cancelStrategy) {
		this.cancelStrategy = cancelStrategy;
	}

	public final String getProductName() {
		return productName;
	}

	public final void setProductName(String productName) {
		this.productName = productName;
	}

	public final VstGoodsDesc getGoodsDescs() {
		return goodsDescs;
	}

	public final void setGoodsDescs(VstGoodsDesc goodsDescs) {
		this.goodsDescs = goodsDescs;
	}

}
