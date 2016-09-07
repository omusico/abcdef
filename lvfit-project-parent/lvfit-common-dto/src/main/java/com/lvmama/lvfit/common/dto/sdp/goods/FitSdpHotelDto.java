package com.lvmama.lvfit.common.dto.sdp.goods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;

/**
 * 酒店信息
 * @author lishuiqing
 *
 */
public class FitSdpHotelDto implements Serializable {

    private static final long serialVersionUID = 7859865883852602292L;
    
    // 产品ID，使用hotelid 
    private Long productId;
    // 产品名称，使用hotelName 
    private String productName;
    // 酒店id
    private Long hotelId;  
	// 酒店名称
    private String hotelName;
    //urlid
  	private String urlId; 
    // 团期（天数）
    private Long travelDays;
    // 团期（晚）
    private String stayDays; 
    //入住日期
    private String checkIn;
    //退房日期
    private String checkOut; 
    //是否有需要修改按钮
    private String haveChangeButton;
    //表示当前branchid
    private Long currentProductBranchId; 
    //分组id
    private Long groupDivId;  
    //是否早餐
    private String breakfast;
    //早餐价格
    private String breakfastAddValue;
    // 是否可以取消,
 	private String cancelFlag;
 	// 是否可以销售,
 	private String saleFlag;  
//	//最晚离店时间
//	private String latestLeaveTime;
//	//最早达到时间
//	private String earliestArriveTime; 
	//酒店房型.
	private LinkedList<FitSdpHotelRoomtypeDto> fangXinList;
	//酒店地址
	private String address; 
	//酒店图片.
	private String hotelPhoto;
	//描述信息
	private String description;
	//开业时间
	private String establishmentDate; 
	//酒店星级
	private String startRate;
	//酒店类型
	private String hotelType; 
//	// 规格ID
//    private Long branchId;
//    // 规格名
//    private String branchName;
    // 规格详情
    private String branchDesc;
	// 产品组名
    private String groupName;
    // 开始日期
    private Date startDay;
    // 第*天
    private String dayOfDuration; 
    // 开始日期Str
    private String startDayStr;
    //停留几晚
    private Long startDays; 
    private String goodType = "hotel";//商品类型--酒店 
    // 是否被选中
    private String isBeSelected; 
    // 差价
    private BigDecimal diffPrice;
    //分组关系id
    private Long groupId;
	public Long getProductId() {
		return productId;
	} 
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getHotelPhoto() {
		return hotelPhoto;
	}
	public void setHotelPhoto(String hotelPhoto) {
		this.hotelPhoto = hotelPhoto;
	}
	public String getProductName() {
		return productName;
	} 
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public String getUrlId() {
		return urlId;
	}
	public void setUrlId(String urlId) {
		this.urlId = urlId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public Long getTravelDays() {
		return travelDays;
	}
	public void setTravelDays(Long travelDays) {
		this.travelDays = travelDays;
	}
	public String getStayDays() {
		return stayDays;
	}
	public void setStayDays(String stayDays) {
		this.stayDays = stayDays;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public String getHaveChangeButton() {
		return haveChangeButton;
	}
	public void setHaveChangeButton(String haveChangeButton) {
		this.haveChangeButton = haveChangeButton;
	}
	public Long getCurrentProductBranchId() {
		return currentProductBranchId;
	}
	public void setCurrentProductBranchId(Long currentProductBranchId) {
		this.currentProductBranchId = currentProductBranchId;
	}
	public Long getGroupDivId() {
		return groupDivId;
	}	
	public String getBreakfast() {
		return breakfast;
	}
	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	} 
	public String getBreakfastAddValue() {
		return breakfastAddValue;
	}
	public void setBreakfastAddValue(String breakfastAddValue) {
		this.breakfastAddValue = breakfastAddValue;
	}
	public void setGroupDivId(Long groupDivId) {
		this.groupDivId = groupDivId;
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
	 
	 
	public LinkedList<FitSdpHotelRoomtypeDto> getFangXinList() {
		return fangXinList;
	}
	public void setFangXinList(LinkedList<FitSdpHotelRoomtypeDto> fangXinList) {
		this.fangXinList = fangXinList;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEstablishmentDate() {
		return establishmentDate;
	}
	public void setEstablishmentDate(String establishmentDate) {
		this.establishmentDate = establishmentDate;
	}
	public String getStartRate() {
		return startRate;
	}
	public void setStartRate(String startRate) {
		this.startRate = startRate;
	}
	public String getHotelType() {
		return hotelType;
	}
	public void setHotelType(String hotelType) {
		this.hotelType = hotelType;
	}
	public String getBranchDesc() {
		return branchDesc;
	}
	public void setBranchDesc(String branchDesc) {
		this.branchDesc = branchDesc;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Date getStartDay() {
		return startDay;
	}
	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}
	public String getDayOfDuration() {
		return dayOfDuration;
	}
	public void setDayOfDuration(String dayOfDuration) {
		this.dayOfDuration = dayOfDuration;
	}
	public String getStartDayStr() {
		return startDayStr;
	}
	public void setStartDayStr(String startDayStr) {
		this.startDayStr = startDayStr;
	}
	public Long getStartDays() {
		return startDays;
	}
	public void setStartDays(Long startDays) {
		this.startDays = startDays;
	}
	public String getGoodType() {
		return goodType;
	}
	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}
	public BigDecimal getDiffPrice() {
		return diffPrice;
	}
	public void setDiffPrice(BigDecimal diffPrice) {
		this.diffPrice = diffPrice;
	}
	public String getIsBeSelected() {
		return isBeSelected;
	}
	public void setIsBeSelected(String isBeSelected) {
		this.isBeSelected = isBeSelected;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	} 
}
