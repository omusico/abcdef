package com.lvmama.lvfit.common.dto.search.spot.result;

import java.io.Serializable;
import java.util.List;

/**
 * 景点搜索景点对象
 * 
 * @author leizhengwei
 *
 */
public class SpotSearchSpotDto implements Serializable {

	private static final long serialVersionUID = -7803585150261555452L;

	// 产品ID
	private String productId;
	// 产品名称
	private String productName;
	// 品类ID
	private String categoryId;
	// 品类名称
	private String categoryName;
	// 推荐级别
	private String recommendLevel;
	// 打包类型
	private String packageType;
	// URL ID
	private String urlId;
	//产品类型
	private String productType;
	// 图片URL
	private String photoUrl;
	// 图片内容
	private String photoContent;
	// 景点名称
	private String spotName;
	// 景点活动主题
	private String actTheme;
	// 景点特色ID
	private String featureId;
	// 景点特色描述
	private String featureDesc;
	// 商品ID
	private String goodsIds;
	// 商品名称
	private String goodsNames;
	// 促销类型
	private String promotionTypes;
	// 最高返现（PC）
	private Double maxRebateAmountPc;
	// 最高返现（Mobile）
	private Double maxRebateAmountMobile;
	// 行政区名称
	private String districtName;
	// 所属城市名称
	private String cityName;
	// 所属省份名称
	private String provinceName;
	// 主目的地ID
	private String destId;
	// 地址
	private String address;
	// 星级
	private String star;
	// 开始时间
	private String startTime;
	// 结束时间
	private String endTime;
	// 主题ID
	private String subjectId;
	// 主题名称
	private String subjectName;
	// 主题排序
	private String subjectSeq;
	// 标签名称
	private String tagName;
	// 标签比例（*10000）
	private Double tagPercent;
	// 点评数
	private String commentNum;
	// 好评率
	private Double commentGood;
	// 平均分
	private String commentScore;
	// 市场起价
	private Float marketPrice;
	// 销售起价
	private Float sellPrice;
	// 团购起价
	private Double groupPrice;
	// 秒杀起价
	private Double spikeTypePrice;
	// 分销起价
	private Double distributorPrice;
	// 驴途起价
	private Double lvmamaClientPrice;
	// 距离
	private Double distance;
	// 送保险标识
	private String freeInsuranceFlag;
	// 买赠标志
	private String buyPresentFlag;
	// 佣金
	private Double commission;
	private int boost;
	// 虚拟销量
	private String virtualSaleQuantity;
	// 百度纬度
	private Double baiduLongitude;
	// 百度经度
	private Double baiduLatitude;
	// google纬度
	private Double googleLongitude;
	// google经度
	private Double googleLatitude;
	// 商品上是否有今日票
	private String todayOnlineFlag;
	// 商品上是否有促销
	private String promotionFlag;
	// 汇总渠道
	private String distributorId;
	
	// 景点门票
	private List<SpotSearchTicketDto> spotTickets;
	

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

	public String getUrlId() {
		return urlId;
	}

	public void setUrlId(String urlId) {
		this.urlId = urlId;
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

	public String getSpotName() {
		return spotName;
	}

	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}

	public String getActTheme() {
		return actTheme;
	}

	public void setActTheme(String actTheme) {
		this.actTheme = actTheme;
	}

	public String getFeatureDesc() {
		return featureDesc;
	}

	public void setFeatureDesc(String featureDesc) {
		this.featureDesc = featureDesc;
	}

	public String getGoodsNames() {
		return goodsNames;
	}

	public void setGoodsNames(String goodsNames) {
		this.goodsNames = goodsNames;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

	public Double getDistributorPrice() {
		return distributorPrice;
	}

	public void setDistributorPrice(Double distributorPrice) {
		this.distributorPrice = distributorPrice;
	}

	public Double getLvmamaClientPrice() {
		return lvmamaClientPrice;
	}

	public void setLvmamaClientPrice(Double lvmamaClientPrice) {
		this.lvmamaClientPrice = lvmamaClientPrice;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public String getFreeInsuranceFlag() {
		return freeInsuranceFlag;
	}

	public void setFreeInsuranceFlag(String freeInsuranceFlag) {
		this.freeInsuranceFlag = freeInsuranceFlag;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Double getTagPercent() {
		return tagPercent;
	}

	public void setTagPercent(Double tagPercent) {
		this.tagPercent = tagPercent;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public String getGoodsIds() {
		return goodsIds;
	}

	public void setGoodsIds(String goodsIds) {
		this.goodsIds = goodsIds;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

	public int getBoost() {
		return boost;
	}

	public void setBoost(int boost) {
		this.boost = boost;
	}

	public String getDestId() {
		return destId;
	}

	public void setDestId(String destId) {
		this.destId = destId;
	}

	public String getVirtualSaleQuantity() {
		return virtualSaleQuantity;
	}

	public void setVirtualSaleQuantity(String virtualSaleQuantity) {
		this.virtualSaleQuantity = virtualSaleQuantity;
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

	public Double getGoogleLongitude() {
		return googleLongitude;
	}

	public void setGoogleLongitude(Double googleLongitude) {
		this.googleLongitude = googleLongitude;
	}

	public Double getGoogleLatitude() {
		return googleLatitude;
	}

	public void setGoogleLatitude(Double googleLatitude) {
		this.googleLatitude = googleLatitude;
	}

	public String getCommentScore() {
		return commentScore;
	}

	public void setCommentScore(String commentScore) {
		this.commentScore = commentScore;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectSeq() {
		return subjectSeq;
	}

	public void setSubjectSeq(String subjectSeq) {
		this.subjectSeq = subjectSeq;
	}

	public String getTodayOnlineFlag() {
		return todayOnlineFlag;
	}

	public void setTodayOnlineFlag(String todayOnlineFlag) {
		this.todayOnlineFlag = todayOnlineFlag;
	}

	public String getFeatureId() {
		return featureId;
	}

	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}

	public String getPromotionFlag() {
		return promotionFlag;
	}

	public void setPromotionFlag(String promotionFlag) {
		this.promotionFlag = promotionFlag;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(String distributorId) {
		this.distributorId = distributorId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getRecommendLevel() {
		return recommendLevel;
	}

	public void setRecommendLevel(String recommendLevel) {
		this.recommendLevel = recommendLevel;
	}

	public String getBuyPresentFlag() {
		return buyPresentFlag;
	}

	public void setBuyPresentFlag(String buyPresentFlag) {
		this.buyPresentFlag = buyPresentFlag;
	}

	public List<SpotSearchTicketDto> getSpotTickets() {
		return spotTickets;
	}

	public void setSpotTickets(List<SpotSearchTicketDto> spotTickets) {
		this.spotTickets = spotTickets;
	}


	@Override
	public String toString() {
		return "TicketBean productId=" + productId + ", productName="
				+ productName + ", sellPrice=" + sellPrice + "]";
	}

}
