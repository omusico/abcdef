package com.lvmama.lvfit.sonline.search.controller.form;

import java.io.Serializable;

import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductCalendarRequest;

public class SearchRequestForm implements Serializable,Form{

	private static final long serialVersionUID = -8577953574517001354L;
	
    private FitSdpProductCalendarRequest calendarRequest = new FitSdpProductCalendarRequest();

	public FitSdpProductCalendarRequest getCalendarRequest() {
		return calendarRequest;
	}

	public void setCalendarRequest(FitSdpProductCalendarRequest calendarRequest) {
		this.calendarRequest = calendarRequest;
	}

	public Long getProductId() {
		return calendarRequest.getProductId();
	}

	public void setProductId(Long productId) {
		calendarRequest.setProductId(productId);
	}

	public Long getPackagedProductId() {
		return calendarRequest.getPackagedProductId();
	}

	public void setPackagedProductId(Long packagedProductId) {
		calendarRequest.setPackagedProductId(packagedProductId);
	}

	public String getDepartureCityCode() {
		return calendarRequest.getDepartureCityCode();
	}

	public void setDepartureCityCode(String departureCityCode) {
		calendarRequest.setDepartureCityCode(departureCityCode);
	}

	public String getArrivalCityCode() {
		return calendarRequest.getArrivalCityCode();
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		calendarRequest.setArrivalCityCode(arrivalCityCode);
	}

	public String getCategoryId() {
		return getCalendarRequest().getCategoryId();
	}

	public void setCategoryId(String categoryId) {
		calendarRequest.setCategoryId(categoryId);
	}
}
