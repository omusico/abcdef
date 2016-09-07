package com.lvmama.lvfit.common.dto.search.hotel.result;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.lvmama.lvfit.common.dto.vst.VstProduct;

public class HotelSearchHotelDto implements Serializable {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * @since JDK 1.6
	 */
	private static final long serialVersionUID = 8110540069602840704L;
	
	private VstProduct product;
	
	/*
	 * XXX 产品属性相关字段
	 */
	// 产品ID
	private String productId;
	// 产品名称
	private String productName;
	// 地址
	private String address;
	// 设施（字典ID）
	private String facilities;
	// 品牌
	private String brandDesc;
	// 星级（字典ID）
	private String starId;
	// 星级
	private String starDesc;
	//facilities
	/*
	 * XXX 产品起价相关字段
	 */
	// 市场起价
	private Float marketPrice;
	// 销售起价
	private Float sellPrice;
	// 分销起价
	private Double distPrice;
	// 驴途起价
	private Double lvtuPrice;
	// 团购起价
	private Double groupPrice;
	// 秒杀起价
	private Double spikeTypePrice;

	/*
	 * XXX 产品图片相关字段
	 */
	// 图片URL
	private String photoUrl;
	// 图片内容
	private String photoContent;

	/*
	 * XXX 商品相关字段（聚合）
	 */
	// 促销类型
	private String promotionTypes;
	// 最高返现（PC）
	private Double maxRebateAmountPc;
	// 最高返现（Mobile）
	private Double maxRebateAmountMobile;
	// 三个月内的可售日期
	private String sellingDates;

	/*
	 * XXX 地标相关字段（聚合）
	 */
	// 地标名称
	private String landmarkNames;
	// 地标类型
	private String landmarkTypes;

	/*
	 * XXX 主题相关字段（聚合）
	 */
	// 主题名称
	private String subjectName;

	/*
	 * XXX 标签相关字段（聚合）
	 */
	// 标签名称
	private String tagName;
	// 标签描述
	private String tagMemo;
	// 买赠标志
    private String buyPresentFlag;

	/*
	 * XXX 点评相关字段
	 */
	// 点评数
	private String commentNum;
	// 好评率
	private Double commentGood;
	// 平均分
	private String commentScore;
	// 百度纬度
	private Double baiduLongitude;
	// 百度经度
	private Double baiduLatitude;

	/*
	 * XXX 标志位字段
	 */
	// 产品主题标志
	private int themeFlag;
	// 距离
	private Double distance;

	private int boost;
	//酒店类型
    private String hotelType;
    
    // 是否有效
 	private String cancelFlag;
 	
 // 推荐级别
 	private String recommendLevel;
 	
 	//入住时间
 	private Date checkinTime;
 	//离店时间
    private Date checkoutTime; 
 	public String getRecommendLevel() {
		return recommendLevel;
	}

	public void setRecommendLevel(String recommendLevel) {
		this.recommendLevel = recommendLevel;
	}

	public String getCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	public String getSaleFlag() {
		return saleFlag;
	}

	public void setSaleFlag(String saleFlag) {
		this.saleFlag = saleFlag;
	}

	// 是否可售
 	private String saleFlag;
	public VstProduct getProduct() {
		return product;
	}

	public void setProduct(VstProduct product) {
		this.product = product;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public String getBrandDesc() {
		return brandDesc;
	}

	public void setBrandDesc(String brandDesc) {
		this.brandDesc = brandDesc;
	}

	public String getStarId() {
		return starId;
	}

	public void setStarId(String starId) {
		this.starId = starId;
	}

	public String getStarDesc() {
		return starDesc;
	}

	public void setStarDesc(String starDesc) {
		this.starDesc = starDesc;
	}

	public Float getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(Float marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Float getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Float sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Double getDistPrice() {
		return distPrice;
	}

	public void setDistPrice(Double distPrice) {
		this.distPrice = distPrice;
	}

	public Double getLvtuPrice() {
		return lvtuPrice;
	}

	public void setLvtuPrice(Double lvtuPrice) {
		this.lvtuPrice = lvtuPrice;
	}

	public Double getGroupPrice() {
		return groupPrice;
	}

	public void setGroupPrice(Double groupPrice) {
		this.groupPrice = groupPrice;
	}

	public Double getSpikeTypePrice() {
		return spikeTypePrice;
	}

	public void setSpikeTypePrice(Double spikeTypePrice) {
		this.spikeTypePrice = spikeTypePrice;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getPhotoContent() {
		return photoContent;
	}

	public void setPhotoContent(String photoContent) {
		this.photoContent = photoContent;
	}

	public String getPromotionTypes() {
		return promotionTypes;
	}

	public void setPromotionTypes(String promotionTypes) {
		this.promotionTypes = promotionTypes;
	}

	public Double getMaxRebateAmountPc() {
		return maxRebateAmountPc;
	}

	public void setMaxRebateAmountPc(Double maxRebateAmountPc) {
		this.maxRebateAmountPc = maxRebateAmountPc;
	}

	public Double getMaxRebateAmountMobile() {
		return maxRebateAmountMobile;
	}

	public void setMaxRebateAmountMobile(Double maxRebateAmountMobile) {
		this.maxRebateAmountMobile = maxRebateAmountMobile;
	}

	public String getSellingDates() {
		return sellingDates;
	}

	public void setSellingDates(String sellingDates) {
		this.sellingDates = sellingDates;
	}

	public String getLandmarkNames() {
		return landmarkNames;
	}

	public void setLandmarkNames(String landmarkNames) {
		this.landmarkNames = landmarkNames;
	}

	public String getLandmarkTypes() {
		return landmarkTypes;
	}

	public void setLandmarkTypes(String landmarkTypes) {
		this.landmarkTypes = landmarkTypes;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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

	public String getBuyPresentFlag() {
		return buyPresentFlag;
	}

	public void setBuyPresentFlag(String buyPresentFlag) {
		this.buyPresentFlag = buyPresentFlag;
	}

	public String getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(String commentNum) {
		this.commentNum = commentNum;
	}

	public Double getCommentGood() {
		return commentGood;
	}

	public void setCommentGood(Double commentGood) {
		this.commentGood = commentGood;
	}

	public String getCommentScore() {
		return commentScore;
	}

	public void setCommentScore(String commentScore) {
		this.commentScore = commentScore;
	}

	public Double getBaiduLongitude() {
		return baiduLongitude;
	}

	public void setBaiduLongitude(Double baiduLongitude) {
		this.baiduLongitude = baiduLongitude;
	}

	public Double getBaiduLatitude() {
		return baiduLatitude;
	}

	public void setBaiduLatitude(Double baiduLatitude) {
		this.baiduLatitude = baiduLatitude;
	}

	public int getThemeFlag() {
		return themeFlag;
	}

	public void setThemeFlag(int themeFlag) {
		this.themeFlag = themeFlag;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public int getBoost() {
		return boost;
	}

	public void setBoost(int boost) {
		this.boost = boost;
	}

	public String getHotelType() {
		return hotelType;
	}

	public void setHotelType(String hotelType) {
		this.hotelType = hotelType;
	}

	public String getSpecialInfo() {
		return specialInfo;
	}

	public void setSpecialInfo(String specialInfo) {
		this.specialInfo = specialInfo;
	}

	public List<HotelSearchRoomDto> getRooms() {
		return rooms;
	}

	public void setRooms(List<HotelSearchRoomDto> rooms) {
		this.rooms = rooms;
	}

	//特色信息
	private String specialInfo;
	
	private List<HotelSearchRoomDto> rooms;
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getCheckinTime() {
		return checkinTime;
	}

	public void setCheckinTime(Date checkinTime) {
		this.checkinTime = checkinTime;
	}

	public Date getCheckoutTime() {
		return checkoutTime;
	}

	public void setCheckoutTime(Date checkoutTime) {
		this.checkoutTime = checkoutTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelSearchHotelDto other = (HotelSearchHotelDto) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}
	
}
