package com.lvmama.lvfit.online.search.form;

import java.io.Serializable;

import com.lvmama.lvfit.common.dto.request.FitBaseSearchRequest;
import org.apache.commons.lang3.StringUtils;

import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.dto.enums.BookingSource;


/**
 * 页面提交的参数信息
 * @author zhoubinbin
 *
 */
public class SearchConditionForm implements Serializable, Form {

	FitBaseSearchRequest request = new FitBaseSearchRequest();

	public FitBaseSearchRequest getRequest() {
		return request;
	}

	public void setRequest(FitBaseSearchRequest request) {
		this.request = request;
	}

	public String getArrivalCityCode() {
		return request.getArrivalCityCode();
	}

	public void setReturnTime(String returnTime) {
		request.setReturnTime(returnTime);
	}

	public String getCityCode() {
		return request.getCityCode();
	}

	public String getArrivalCityName() {
		return request.getArrivalCityName();
	}

	public void setChildCount(int childCount) {
		request.setChildCount(childCount);
	}

	public void setShoppingUUID(String shoppingUUID) {
		request.setShoppingUUID(shoppingUUID);
	}

	public String getShoppingUUID() {
		return request.getShoppingUUID();
	}

	public String getReturnTime() {
		return request.getReturnTime();
	}

	public void setCheckInTime(String checkInTime) {
		request.setCheckInTime(checkInTime);
	}

	public void setCheckOutTime(String checkOutTime) {
		request.setCheckOutTime(checkOutTime);
	}

	public String getDepartureCityCode() {
		return request.getDepartureCityCode();
	}

	public void setAdultsCount(int adultsCount) {
		request.setAdultsCount(adultsCount);
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		request.setArrivalCityCode(arrivalCityCode);
	}

	public int getAdultsCount() {
		return request.getAdultsCount();
	}

	public void setTripType(String tripType) {
		request.setTripType(tripType);
	}

	public void setCityCode(String cityCode) {
		request.setCityCode(cityCode);
	}

	public void setBookingSource(BookingSource bookingSource) {
		request.setBookingSource(bookingSource);
	}

	public BookingSource getBookingSource() {
		return request.getBookingSource();
	}

	public String getDepartureCityName() {
		return request.getDepartureCityName();
	}

	public String getDepartureTime() {
		return request.getDepartureTime();
	}

	public void setDepartureCityCode(String departureCityCode) {
		request.setDepartureCityCode(departureCityCode);
	}

	public String getCityName() {
		return request.getCityName();
	}

	public String getCheckOutTime() {
		return request.getCheckOutTime();
	}

	public String getCheckInTime() {
		return request.getCheckInTime();
	}

	public String getTripType() {
		return request.getTripType();
	}

	public int getChildCount() {
		return request.getChildCount();
	}

	public void setDepartureTime(String departureTime) {
		request.setDepartureTime(departureTime);
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
}
