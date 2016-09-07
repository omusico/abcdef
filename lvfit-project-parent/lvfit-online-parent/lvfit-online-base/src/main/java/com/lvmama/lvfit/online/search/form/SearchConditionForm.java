package com.lvmama.lvfit.online.search.form;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.dto.enums.BookingSource;


/**
 * 页面提交的参数信息
 * @author zhoubinbin
 *
 */
public class SearchConditionForm implements Serializable,Form{
	//出发地
	private String departureCityName;
	//目的地城市行政id
	private String arrivalCityDistrictCode;
	//目的地的三字码
	private String arrivalCityCode;
	//出发地的三字码
	private String departureCityCode;
	//入住城市三字码
	private String cityCode;
	//目的地
	private String arrivalCityName;
	//去程时间
	private String departureTime;
	//返程时间
	private String returnTime;
	//入住城市
	private String cityName;
	//入住时间
	private String checkInTime;
	//离店时间
	private String checkOutTime;
	//成人数
	private int adultsCount;
	//儿童数
	private int childCount;
	
	//订单号
	private String  shoppingUUID;
	//出行类型
	private String tripType;//单程 singleTrip-->单程 roundTrip-->往返
	
	private BookingSource bookingSource = BookingSource.FIT_FRONT;
	
	public BookingSource getBookingSource() {
		return bookingSource;
	}
	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}
	public int getAdultsCount() {
		return adultsCount;
	}
	public int getChildCount() {
		return childCount;
	}
	public void setAdultsCount(int adultsCount) {
		this.adultsCount = adultsCount;
	}
	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}
	
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getArrivalCityDistrictCode() {
		return arrivalCityDistrictCode;
	}
	public void setArrivalCityDistrictCode(String arrivalCityDistrictCode) {
		this.arrivalCityDistrictCode = arrivalCityDistrictCode;
	}
	public String getArrivalCityCode() {
		return arrivalCityCode;
	}
	public void setArrivalCityCode(String arrivalCityCode) {
		this.arrivalCityCode = arrivalCityCode;
	}
	public String getDepartureCityCode() {
		return departureCityCode;
	}
	public void setDepartureCityCode(String departureCityCode) {
		this.departureCityCode = departureCityCode;
	}
	public String getDepartureCityName() {
		return departureCityName;
	}
	public void setDepartureCityName(String departureCityName) {
		this.departureCityName = departureCityName;
	}
	public String getArrivalCityName() {
		return arrivalCityName;
	}
	public void setArrivalCityName(String arrivalCityName) {
		this.arrivalCityName = arrivalCityName;
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
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
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
	
	public String getShoppingUUID() {
		return shoppingUUID;
	}
	public void setShoppingUUID(String shoppingUUID) {
		this.shoppingUUID = shoppingUUID;
	}

	public boolean isReturnToError(){
	   boolean isReturnToError = true;
	   if(StringUtils.isNotBlank(this.getDepartureCityCode())
		 &&StringUtils.isNotBlank(this.getArrivalCityCode())
		 &&StringUtils.isNotBlank(this.getDepartureTime())
	     &&StringUtils.isNotBlank(this.getReturnTime())
		 &&StringUtils.isNotBlank(this.getCityCode())
		 &&StringUtils.isNotBlank(this.getCheckInTime())
		 &&StringUtils.isNotBlank(this.getCheckOutTime())
		 &&StringUtils.isNotBlank(this.getCheckOutTime())
		 &&this.getAdultsCount()!=0){
		   isReturnToError = false;
	   }
	   if(this.getAdultsCount() <1 || this.getAdultsCount() >9 || this.getChildCount() <0 || this.getChildCount() >4){
			return true;
		}
		if(this.getChildCount() > 2*this.getAdultsCount()){
			return true;
		}
		if(this.getAdultsCount() + this.getChildCount() < 1 || this.getAdultsCount() + this.getChildCount() >9){
			return true;
		}
		Long days = DateUtils.getDateDiffByDay(this.getCheckOutTime(), this.getCheckInTime());
		if(days >20){
			return true;
		}
	   return isReturnToError;
	}
	
	public String getTripType() {
		return tripType;
	}
	public void setTripType(String tripType) {
		this.tripType = tripType;
	}
}
