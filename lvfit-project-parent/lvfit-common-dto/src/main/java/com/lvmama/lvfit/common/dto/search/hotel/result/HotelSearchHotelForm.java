package com.lvmama.lvfit.common.dto.search.hotel.result;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.lvmama.lvfit.common.dto.vst.VstProduct;

public class HotelSearchHotelForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6472647171888919495L;
	
	private HotelSearchHotelDto hotelSearchHotelDto = new HotelSearchHotelDto();
	
	public HotelSearchHotelForm(){
	}
	
	public HotelSearchHotelForm(HotelSearchHotelDto hotelSearchHotelDto){
		this.hotelSearchHotelDto = hotelSearchHotelDto;
	}
	
	

	public int hashCode() {
		return hotelSearchHotelDto.hashCode();
	}

	public String getRecommendLevel() {
		return hotelSearchHotelDto.getRecommendLevel();
	}

	public void setRecommendLevel(String recommendLevel) {
		hotelSearchHotelDto.setRecommendLevel(recommendLevel);
	}

	public String getCancelFlag() {
		return hotelSearchHotelDto.getCancelFlag();
	}

	public void setCancelFlag(String cancelFlag) {
		hotelSearchHotelDto.setCancelFlag(cancelFlag);
	}

	public String getSaleFlag() {
		return hotelSearchHotelDto.getSaleFlag();
	}

	public void setSaleFlag(String saleFlag) {
		hotelSearchHotelDto.setSaleFlag(saleFlag);
	}

	public VstProduct getProduct() {
		return hotelSearchHotelDto.getProduct();
	}

	public void setProduct(VstProduct product) {
		hotelSearchHotelDto.setProduct(product);
	}

	public String getAddress() {
		return hotelSearchHotelDto.getAddress();
	}

	public void setAddress(String address) {
		hotelSearchHotelDto.setAddress(address);
	}

	public String getFacilities() {
		return hotelSearchHotelDto.getFacilities();
	}

	public void setFacilities(String facilities) {
		hotelSearchHotelDto.setFacilities(facilities);
	}

	public String getBrandDesc() {
		return hotelSearchHotelDto.getBrandDesc();
	}

	public void setBrandDesc(String brandDesc) {
		hotelSearchHotelDto.setBrandDesc(brandDesc);
	}

	public String getStarId() {
		return hotelSearchHotelDto.getStarId();
	}

	public void setStarId(String starId) {
		hotelSearchHotelDto.setStarId(starId);
	}

	public String getStarDesc() {
		return hotelSearchHotelDto.getStarDesc();
	}

	public void setStarDesc(String starDesc) {
		hotelSearchHotelDto.setStarDesc(starDesc);
	}

	public boolean equals(Object obj) {
		return hotelSearchHotelDto.equals(obj);
	}

	public Float getMarketPrice() {
		return hotelSearchHotelDto.getMarketPrice();
	}

	public void setMarketPrice(Float marketPrice) {
		hotelSearchHotelDto.setMarketPrice(marketPrice);
	}

	public Float getSellPrice() {
		return hotelSearchHotelDto.getSellPrice();
	}

	public void setSellPrice(Float sellPrice) {
		hotelSearchHotelDto.setSellPrice(sellPrice);
	}

	public Double getDistPrice() {
		return hotelSearchHotelDto.getDistPrice();
	}

	public void setDistPrice(Double distPrice) {
		hotelSearchHotelDto.setDistPrice(distPrice);
	}

	public Double getLvtuPrice() {
		return hotelSearchHotelDto.getLvtuPrice();
	}

	public void setLvtuPrice(Double lvtuPrice) {
		hotelSearchHotelDto.setLvtuPrice(lvtuPrice);
	}

	public Double getGroupPrice() {
		return hotelSearchHotelDto.getGroupPrice();
	}

	public void setGroupPrice(Double groupPrice) {
		hotelSearchHotelDto.setGroupPrice(groupPrice);
	}

	public Double getSpikeTypePrice() {
		return hotelSearchHotelDto.getSpikeTypePrice();
	}

	public void setSpikeTypePrice(Double spikeTypePrice) {
		hotelSearchHotelDto.setSpikeTypePrice(spikeTypePrice);
	}

	public String getPhotoUrl() {
		return hotelSearchHotelDto.getPhotoUrl();
	}

	public void setPhotoUrl(String photoUrl) {
		hotelSearchHotelDto.setPhotoUrl(photoUrl);
	}

	public String getPhotoContent() {
		return hotelSearchHotelDto.getPhotoContent();
	}

	public void setPhotoContent(String photoContent) {
		hotelSearchHotelDto.setPhotoContent(photoContent);
	}

	public String getPromotionTypes() {
		return hotelSearchHotelDto.getPromotionTypes();
	}

	public void setPromotionTypes(String promotionTypes) {
		hotelSearchHotelDto.setPromotionTypes(promotionTypes);
	}

	public Double getMaxRebateAmountPc() {
		return hotelSearchHotelDto.getMaxRebateAmountPc();
	}

	public void setMaxRebateAmountPc(Double maxRebateAmountPc) {
		hotelSearchHotelDto.setMaxRebateAmountPc(maxRebateAmountPc);
	}

	public Double getMaxRebateAmountMobile() {
		return hotelSearchHotelDto.getMaxRebateAmountMobile();
	}

	public void setMaxRebateAmountMobile(Double maxRebateAmountMobile) {
		hotelSearchHotelDto.setMaxRebateAmountMobile(maxRebateAmountMobile);
	}

	public String getSellingDates() {
		return hotelSearchHotelDto.getSellingDates();
	}

	public void setSellingDates(String sellingDates) {
		hotelSearchHotelDto.setSellingDates(sellingDates);
	}

	public String getLandmarkNames() {
		return hotelSearchHotelDto.getLandmarkNames();
	}

	public void setLandmarkNames(String landmarkNames) {
		hotelSearchHotelDto.setLandmarkNames(landmarkNames);
	}

	public String getLandmarkTypes() {
		return hotelSearchHotelDto.getLandmarkTypes();
	}

	public void setLandmarkTypes(String landmarkTypes) {
		hotelSearchHotelDto.setLandmarkTypes(landmarkTypes);
	}

	public String getSubjectName() {
		return hotelSearchHotelDto.getSubjectName();
	}

	public void setSubjectName(String subjectName) {
		hotelSearchHotelDto.setSubjectName(subjectName);
	}

	public String getTagName() {
		return hotelSearchHotelDto.getTagName();
	}

	public void setTagName(String tagName) {
		hotelSearchHotelDto.setTagName(tagName);
	}

	public String getTagMemo() {
		return hotelSearchHotelDto.getTagMemo();
	}

	public void setTagMemo(String tagMemo) {
		hotelSearchHotelDto.setTagMemo(tagMemo);
	}

	public String getBuyPresentFlag() {
		return hotelSearchHotelDto.getBuyPresentFlag();
	}

	public void setBuyPresentFlag(String buyPresentFlag) {
		hotelSearchHotelDto.setBuyPresentFlag(buyPresentFlag);
	}

	public String getCommentNum() {
		return hotelSearchHotelDto.getCommentNum();
	}

	public void setCommentNum(String commentNum) {
		hotelSearchHotelDto.setCommentNum(commentNum);
	}

	public Double getCommentGood() {
		return hotelSearchHotelDto.getCommentGood();
	}

	public void setCommentGood(Double commentGood) {
		hotelSearchHotelDto.setCommentGood(commentGood);
	}

	public String getCommentScore() {
		return hotelSearchHotelDto.getCommentScore();
	}

	public void setCommentScore(String commentScore) {
		hotelSearchHotelDto.setCommentScore(commentScore);
	}

	public Double getBaiduLongitude() {
		return hotelSearchHotelDto.getBaiduLongitude();
	}

	public void setBaiduLongitude(Double baiduLongitude) {
		hotelSearchHotelDto.setBaiduLongitude(baiduLongitude);
	}

	public Double getBaiduLatitude() {
		return hotelSearchHotelDto.getBaiduLatitude();
	}

	public void setBaiduLatitude(Double baiduLatitude) {
		hotelSearchHotelDto.setBaiduLatitude(baiduLatitude);
	}

	public int getThemeFlag() {
		return hotelSearchHotelDto.getThemeFlag();
	}

	public void setThemeFlag(int themeFlag) {
		hotelSearchHotelDto.setThemeFlag(themeFlag);
	}

	public Double getDistance() {
		return hotelSearchHotelDto.getDistance();
	}

	public void setDistance(Double distance) {
		hotelSearchHotelDto.setDistance(distance);
	}

	public int getBoost() {
		return hotelSearchHotelDto.getBoost();
	}

	public void setBoost(int boost) {
		hotelSearchHotelDto.setBoost(boost);
	}

	public String getHotelType() {
		return hotelSearchHotelDto.getHotelType();
	}

	public void setHotelType(String hotelType) {
		hotelSearchHotelDto.setHotelType(hotelType);
	}

	public String getSpecialInfo() {
		return hotelSearchHotelDto.getSpecialInfo();
	}

	public void setSpecialInfo(String specialInfo) {
		hotelSearchHotelDto.setSpecialInfo(specialInfo);
	}

	public List<HotelSearchRoomDto> getRooms() {
		return hotelSearchHotelDto.getRooms();
	}

	public void setRooms(List<HotelSearchRoomDto> rooms) {
		hotelSearchHotelDto.setRooms(rooms);
	}

	public String getProductId() {
		return hotelSearchHotelDto.getProductId();
	}

	public void setProductId(String productId) {
		hotelSearchHotelDto.setProductId(productId);
	}

	public String getProductName() {
		return hotelSearchHotelDto.getProductName();
	}

	public void setProductName(String productName) {
		hotelSearchHotelDto.setProductName(productName);
	}

	public Date getCheckinTime() {
		return hotelSearchHotelDto.getCheckinTime();
	}

	public void setCheckinTime(Date checkinTime) {
		hotelSearchHotelDto.setCheckinTime(checkinTime);
	}

	public Date getCheckoutTime() {
		return hotelSearchHotelDto.getCheckoutTime();
	}

	public void setCheckoutTime(Date checkoutTime) {
		hotelSearchHotelDto.setCheckoutTime(checkoutTime);
	}

	public String toString() {
		return hotelSearchHotelDto.toString();
	}
	
	

}
