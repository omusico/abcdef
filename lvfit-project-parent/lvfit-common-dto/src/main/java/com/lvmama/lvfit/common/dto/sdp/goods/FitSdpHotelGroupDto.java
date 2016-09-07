package com.lvmama.lvfit.common.dto.sdp.goods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;

/**
 * 酒店分组信息
 * @author lishuiqing
 *
 */
public class FitSdpHotelGroupDto implements Serializable {

    private static final long serialVersionUID = 7859865883852602292L; 
    //分组id
    private Long groupId;   
    
    /**
     * 组的全部酒店成员列表.
     */
    private LinkedList<FitSdpHotelDto> hotels;
    
    /**
     * 组里面的最低价格.
     */
    private BigDecimal leastPrice;

    // 团期（天数）
    private Long travelDays;
    // 团期（晚）
    private String stayDays; 
    //入住日期
    private String checkIn;
    //退房日期
    private String checkOut; 
    
	public Long getGroupId() {
		return groupId;
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

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	} 

	public LinkedList<FitSdpHotelDto> getHotels() {
		return hotels;
	}

	public void setHotels(LinkedList<FitSdpHotelDto> hotels) {
		this.hotels = hotels;
	}

	public BigDecimal getLeastPrice() {
		return leastPrice;
	}

	public void setLeastPrice(BigDecimal leastPrice) {
		this.leastPrice = leastPrice;
	}
    
    
}
