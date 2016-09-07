package com.lvmama.lvfit.common.dto.hotel;

import java.util.List;

import com.lvmama.lvfit.common.dto.vst.VstPropValue;

/**
 *  规格房型：相当于原来的branch
 * @author wanghuihui
 * @date:2015年12月8日 下午3:33:05
 */
public class FitHotelRoomDto{
	List<FitHotelPlanDto> hotelPlans;
	private Long hotelId;
	private Long roomId;  //productBranchId
	private String roomName;
    private String cancelFlag; 
    private String maxVisitor; 
    private String area; 
    private String branchDesc; 
    private String floor; 
    private List<VstPropValue> bedType; 
    private List<VstPropValue> internet; 
    private List<FitHotelPicDto> photo;
    private String recommendLevel; 
	private String saleFlag;
	
	public List<FitHotelPlanDto> getHotelPlans() {
		return hotelPlans;
	}
	public void setHotelPlans(List<FitHotelPlanDto> hotelPlans) {
		this.hotelPlans = hotelPlans;
	}
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getCancelFlag() {
		return cancelFlag;
	}
	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
	}
	public String getMaxVisitor() {
		return maxVisitor;
	}
	public void setMaxVisitor(String maxVisitor) {
		this.maxVisitor = maxVisitor;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getBranchDesc() {
		return branchDesc;
	}
	public void setBranchDesc(String branchDesc) {
		this.branchDesc = branchDesc;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public List<VstPropValue> getBedType() {
		return bedType;
	}
	public void setBedType(List<VstPropValue> bedType) {
		this.bedType = bedType;
	}
	public List<VstPropValue> getInternet() {
		return internet;
	}
	public void setInternet(List<VstPropValue> internet) {
		this.internet = internet;
	}
	public List<FitHotelPicDto> getPhoto() {
		return photo;
	}
	public void setPhoto(List<FitHotelPicDto> photo) {
		this.photo = photo;
	}
	public String getRecommendLevel() {
		return recommendLevel;
	}
	public void setRecommendLevel(String recommendLevel) {
		this.recommendLevel = recommendLevel;
	}
	public String getSaleFlag() {
		return saleFlag;
	}
	public void setSaleFlag(String saleFlag) {
		this.saleFlag = saleFlag;
	}
}
