package com.lvmama.lvfit.common.dto.app;

import com.lvmama.lvfit.common.dto.enums.BookingSource;

import java.io.Serializable;

/**
 * 详情页查询请求对象
 */
public class FitAppSearchRequest implements Serializable{

	private static final long serialVersionUID = 801736863683899924L;

	//出行类型(DC, WF)
	private String tripType;
	//出发地的三字码
	private String departureCityCode;
	//目的地的三字码
	private String arrivalCityCode;
	//入住城市三字码
	private String cityCode;
	//去程时间(YYYY-MM-DD)
	private String departureTime;
	//返程时间(YYYY-MM-DD)
	private String returnTime;
	//入住时间(YYYY-MM-DD)
	private String checkInTime;
	//离店时间(YYYY-MM-DD)
	private String checkOutTime;
	//成人数
	private int adultsCount;
	//儿童数
	private int childCount;
	/** 购物车ID*/
	private String shoppingUuid;
	/** bookingSource */
	private BookingSource bookingSource;

	public FitAppSearchRequest() {

	}

	public String getTripType() {
		return tripType;
	}

	public void setTripType(String tripType) {
		this.tripType = tripType;
	}

	public String getDepartureCityCode() {
		return departureCityCode;
	}

	public void setDepartureCityCode(String departureCityCode) {
		this.departureCityCode = departureCityCode;
	}

	public String getArrivalCityCode() {
		return arrivalCityCode;
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		this.arrivalCityCode = arrivalCityCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public int getAdultsCount() {
		return adultsCount;
	}

	public void setAdultsCount(int adultsCount) {
		this.adultsCount = adultsCount;
	}

	public int getChildCount() {
		return childCount;
	}

	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}

	public String getShoppingUuid() {
		return shoppingUuid;
	}

	public void setShoppingUuid(String shoppingUuid) {
		this.shoppingUuid = shoppingUuid;
	}

	public BookingSource getBookingSource() {
		return bookingSource;
	}

	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}

	public static void main(String[] args) {
		System.out.println("11");
	}
}






