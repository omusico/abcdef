package com.lvmama.lvfit.common.dto.shopping;

import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;

public class ShoppingHotelDto  extends Entity {
    private String shoppingUuid;   
    private Long hotelId;   
    private String hotelName;
    private String roomId;
    private String roomName;
    private Long planId;
    private String planName;
    private Integer roomCount;
    private String checkinTime;
    private String checkoutTime;  
    
    //版本号
    private Long versionNo;
   
	public String getShoppingUuid() {
		return shoppingUuid;
	}
	public void setShoppingUuid(String shoppingUuid) {
		this.shoppingUuid = shoppingUuid;
	}
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public Long getPlanId() {
		return planId;
	}
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public Integer getRoomCount() {
		return roomCount;
	}
	public void setRoomCount(Integer roomCount) {
		this.roomCount = roomCount;
	}
	public String getCheckinTime() {
		return checkinTime;
	}
	public void setCheckinTime(String checkinTime) {
		this.checkinTime = checkinTime;
	}
	public String getCheckoutTime() {
		return checkoutTime;
	}
	public void setCheckoutTime(String checkoutTime) {
		this.checkoutTime = checkoutTime;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public Long getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(Long versionNo) {
		this.versionNo = versionNo;
	}
	
	
	
	
	
	

	
	

}
