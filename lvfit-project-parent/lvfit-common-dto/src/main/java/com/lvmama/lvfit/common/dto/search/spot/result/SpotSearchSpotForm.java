package com.lvmama.lvfit.common.dto.search.spot.result;

import java.io.Serializable;
import java.util.List;

/**
 * * 景点搜索景点Form
 * @author leizhengwei
 *
 */
public class SpotSearchSpotForm implements Serializable{

	
	private static final long serialVersionUID = -4543243174857295385L;
	
	private SpotSearchSpotDto spotSearchSpotDto = new SpotSearchSpotDto();
	
	public SpotSearchSpotForm(){
		
	}
	
	public List<SpotSearchTicketDto> getSpotTickets() {
        return spotSearchSpotDto.getSpotTickets();
    }

    public void setSpotTickets(List<SpotSearchTicketDto> spotTickets) {
        spotSearchSpotDto.setSpotTickets(spotTickets);
    }

    public SpotSearchSpotForm(SpotSearchSpotDto spotSearchSpotDto){
		this.spotSearchSpotDto = spotSearchSpotDto;
	}

	public SpotSearchSpotDto getSpotSearchSpotDto() {
		return spotSearchSpotDto;
	}

	public void setSpotSearchSpotDto(SpotSearchSpotDto spotSearchSpotDto) {
		this.spotSearchSpotDto = spotSearchSpotDto;
	}

	public String getProductId() {
		return spotSearchSpotDto.getProductId();
	}

	public void setProductId(String productId) {
		spotSearchSpotDto.setProductId(productId);
	}

	public String getProductName() {
		return spotSearchSpotDto.getProductName();
	}

	public void setProductName(String productName) {
		spotSearchSpotDto.setProductName(productName);
	}

	public Float getMarketPrice() {
		return spotSearchSpotDto.getMarketPrice();
	}

	public void setMarketPrice(Float marketPrice) {
		spotSearchSpotDto.setMarketPrice(marketPrice);
	}

	public Float getSellPrice() {
		return spotSearchSpotDto.getSellPrice();
	}

	public void setSellPrice(Float sellPrice) {
		spotSearchSpotDto.setSellPrice(sellPrice);
	}

	public String getUrlId() {
		return spotSearchSpotDto.getUrlId();
	}

	public void setUrlId(String urlId) {
		spotSearchSpotDto.setUrlId(urlId);
	}

	public String getPhotoUrl() {
		return spotSearchSpotDto.getPhotoUrl();
	}

	public void setPhotoUrl(String photoUrl) {
		spotSearchSpotDto.setPhotoUrl(photoUrl);
	}

	public String getPhotoContent() {
		return spotSearchSpotDto.getPhotoContent();
	}

	public void setPhotoContent(String photoContent) {
		spotSearchSpotDto.setPhotoContent(photoContent);
	}

	public String getSpotName() {
		return spotSearchSpotDto.getSpotName();
	}

	public void setSpotName(String spotName) {
		spotSearchSpotDto.setSpotName(spotName);
	}

	public String getActTheme() {
		return spotSearchSpotDto.getActTheme();
	}

	public void setActTheme(String actTheme) {
		spotSearchSpotDto.setActTheme(actTheme);
	}

	public String getFeatureDesc() {
		return spotSearchSpotDto.getFeatureDesc();
	}

	public void setFeatureDesc(String featureDesc) {
		spotSearchSpotDto.setFeatureDesc(featureDesc);
	}

	public String getGoodsNames() {
		return spotSearchSpotDto.getGoodsNames();
	}

	public void setGoodsNames(String goodsNames) {
		spotSearchSpotDto.setGoodsNames(goodsNames);
	}

	public String getPromotionTypes() {
		return spotSearchSpotDto.getPromotionTypes();
	}

	public void setPromotionTypes(String promotionTypes) {
		spotSearchSpotDto.setPromotionTypes(promotionTypes);
	}

	public Double getMaxRebateAmountPc() {
		return spotSearchSpotDto.getMaxRebateAmountPc();
	}

	public void setMaxRebateAmountPc(Double maxRebateAmountPc) {
		spotSearchSpotDto.setMaxRebateAmountPc(maxRebateAmountPc);
	}

	public Double getMaxRebateAmountMobile() {
		return spotSearchSpotDto.getMaxRebateAmountMobile();
	}

	public void setMaxRebateAmountMobile(Double maxRebateAmountMobile) {
		spotSearchSpotDto.setMaxRebateAmountMobile(maxRebateAmountMobile);
	}

	public String getAddress() {
		return spotSearchSpotDto.getAddress();
	}

	public void setAddress(String address) {
		spotSearchSpotDto.setAddress(address);
	}

	public String getStar() {
		return spotSearchSpotDto.getStar();
	}

	public void setStar(String star) {
		spotSearchSpotDto.setStar(star);
	}

	public String getStartTime() {
		return spotSearchSpotDto.getStartTime();
	}

	public void setStartTime(String startTime) {
		spotSearchSpotDto.setStartTime(startTime);
	}

	public String getEndTime() {
		return spotSearchSpotDto.getEndTime();
	}

	public void setEndTime(String endTime) {
		spotSearchSpotDto.setEndTime(endTime);
	}

	public String getSubjectName() {
		return spotSearchSpotDto.getSubjectName();
	}

	public void setSubjectName(String subjectName) {
		spotSearchSpotDto.setSubjectName(subjectName);
	}

	public String getTagName() {
		return spotSearchSpotDto.getTagName();
	}

	public void setTagName(String tagName) {
		spotSearchSpotDto.setTagName(tagName);
	}

	public String getCommentNum() {
		return spotSearchSpotDto.getCommentNum();
	}

	public void setCommentNum(String commentNum) {
		spotSearchSpotDto.setCommentNum(commentNum);
	}

	public Double getCommentGood() {
		return spotSearchSpotDto.getCommentGood();
	}

	public void setCommentGood(Double commentGood) {
		spotSearchSpotDto.setCommentGood(commentGood);
	}

	public Double getGroupPrice() {
		return spotSearchSpotDto.getGroupPrice();
	}

	public void setGroupPrice(Double groupPrice) {
		spotSearchSpotDto.setGroupPrice(groupPrice);
	}

	public Double getSpikeTypePrice() {
		return spotSearchSpotDto.getSpikeTypePrice();
	}

	public void setSpikeTypePrice(Double spikeTypePrice) {
		spotSearchSpotDto.setSpikeTypePrice(spikeTypePrice);
	}

	public Double getDistributorPrice() {
		return spotSearchSpotDto.getDistributorPrice();
	}

	public void setDistributorPrice(Double distributorPrice) {
		spotSearchSpotDto.setDistributorPrice(distributorPrice);
	}

	public Double getLvmamaClientPrice() {
		return spotSearchSpotDto.getLvmamaClientPrice();
	}

	public void setLvmamaClientPrice(Double lvmamaClientPrice) {
		spotSearchSpotDto.setLvmamaClientPrice(lvmamaClientPrice);
	}

	public Double getDistance() {
		return spotSearchSpotDto.getDistance();
	}

	public void setDistance(Double distance) {
		spotSearchSpotDto.setDistance(distance);
	}

	public String getFreeInsuranceFlag() {
		return spotSearchSpotDto.getFreeInsuranceFlag();
	}

	public void setFreeInsuranceFlag(String freeInsuranceFlag) {
		spotSearchSpotDto.setFreeInsuranceFlag(freeInsuranceFlag);
	}

	public String getProductType() {
		return spotSearchSpotDto.getProductType();
	}

	public void setProductType(String productType) {
		spotSearchSpotDto.setProductType(productType);
	}

	public String getCityName() {
		return spotSearchSpotDto.getCityName();
	}

	public void setCityName(String cityName) {
		spotSearchSpotDto.setCityName(cityName);
	}

	public String getProvinceName() {
		return spotSearchSpotDto.getProvinceName();
	}

	public void setProvinceName(String provinceName) {
		spotSearchSpotDto.setProvinceName(provinceName);
	}

	public Double getTagPercent() {
		return spotSearchSpotDto.getTagPercent();
	}

	public void setTagPercent(Double tagPercent) {
		spotSearchSpotDto.setTagPercent(tagPercent);
	}

	public String getPackageType() {
		return spotSearchSpotDto.getPackageType();
	}

	public void setPackageType(String packageType) {
		spotSearchSpotDto.setPackageType(packageType);
	}

	public String getGoodsIds() {
		return spotSearchSpotDto.getGoodsIds();
	}

	public void setGoodsIds(String goodsIds) {
		spotSearchSpotDto.setGoodsIds(goodsIds);
	}

	public Double getCommission() {
		return spotSearchSpotDto.getCommission();
	}

	public void setCommission(Double commission) {
		spotSearchSpotDto.setCommission(commission);
	}

	public int getBoost() {
		return spotSearchSpotDto.getBoost();
	}

	public void setBoost(int boost) {
		spotSearchSpotDto.setBoost(boost);
	}

	public String getDestId() {
		return spotSearchSpotDto.getDestId();
	}

	public void setDestId(String destId) {
		spotSearchSpotDto.setDestId(destId);
	}

	public String getVirtualSaleQuantity() {
		return spotSearchSpotDto.getVirtualSaleQuantity();
	}

	public void setVirtualSaleQuantity(String virtualSaleQuantity) {
		spotSearchSpotDto.setVirtualSaleQuantity(virtualSaleQuantity);
	}

	public Double getBaiduLongitude() {
		return spotSearchSpotDto.getBaiduLongitude();
	}

	public void setBaiduLongitude(Double baiduLongitude) {
		spotSearchSpotDto.setBaiduLongitude(baiduLongitude);
	}

	public Double getBaiduLatitude() {
		return spotSearchSpotDto.getBaiduLatitude();
	}

	public void setBaiduLatitude(Double baiduLatitude) {
		spotSearchSpotDto.setBaiduLatitude(baiduLatitude);
	}

	public Double getGoogleLongitude() {
		return spotSearchSpotDto.getGoogleLongitude();
	}

	public void setGoogleLongitude(Double googleLongitude) {
		spotSearchSpotDto.setGoogleLongitude(googleLongitude);
	}

	public Double getGoogleLatitude() {
		return spotSearchSpotDto.getGoogleLatitude();
	}

	public void setGoogleLatitude(Double googleLatitude) {
		spotSearchSpotDto.setGoogleLatitude(googleLatitude);
	}

	public String getCommentScore() {
		return spotSearchSpotDto.getCommentScore();
	}

	public void setCommentScore(String commentScore) {
		spotSearchSpotDto.setCommentScore(commentScore);
	}

	public String getSubjectId() {
		return spotSearchSpotDto.getSubjectId();
	}

	public void setSubjectId(String subjectId) {
		spotSearchSpotDto.setSubjectId(subjectId);
	}

	public String getSubjectSeq() {
		return spotSearchSpotDto.getSubjectSeq();
	}

	public void setSubjectSeq(String subjectSeq) {
		spotSearchSpotDto.setSubjectSeq(subjectSeq);
	}

	public String getTodayOnlineFlag() {
		return spotSearchSpotDto.getTodayOnlineFlag();
	}

	public void setTodayOnlineFlag(String todayOnlineFlag) {
		spotSearchSpotDto.setTodayOnlineFlag(todayOnlineFlag);
	}

	public String getFeatureId() {
		return spotSearchSpotDto.getFeatureId();
	}

	public void setFeatureId(String featureId) {
		spotSearchSpotDto.setFeatureId(featureId);
	}

	public String getPromotionFlag() {
		return spotSearchSpotDto.getPromotionFlag();
	}

	public void setPromotionFlag(String promotionFlag) {
		spotSearchSpotDto.setPromotionFlag(promotionFlag);
	}

	public String getDistrictName() {
		return spotSearchSpotDto.getDistrictName();
	}

	public void setDistrictName(String districtName) {
		spotSearchSpotDto.setDistrictName(districtName);
	}

	public String getDistributorId() {
		return spotSearchSpotDto.getDistributorId();
	}

	public void setDistributorId(String distributorId) {
		spotSearchSpotDto.setDistributorId(distributorId);
	}

	public String getCategoryId() {
		return spotSearchSpotDto.getCategoryId();
	}

	public void setCategoryId(String categoryId) {
		spotSearchSpotDto.setCategoryId(categoryId);
	}

	public String getCategoryName() {
		return spotSearchSpotDto.getCategoryName();
	}

	public void setCategoryName(String categoryName) {
		spotSearchSpotDto.setCategoryName(categoryName);
	}

	public String getRecommendLevel() {
		return spotSearchSpotDto.getRecommendLevel();
	}

	public void setRecommendLevel(String recommendLevel) {
		spotSearchSpotDto.setRecommendLevel(recommendLevel);
	}

	public String getBuyPresentFlag() {
		return spotSearchSpotDto.getBuyPresentFlag();
	}

	public void setBuyPresentFlag(String buyPresentFlag) {
		spotSearchSpotDto.setBuyPresentFlag(buyPresentFlag);
	}

	public String toString() {
		return spotSearchSpotDto.toString();
	}
	
	
	

    

}
