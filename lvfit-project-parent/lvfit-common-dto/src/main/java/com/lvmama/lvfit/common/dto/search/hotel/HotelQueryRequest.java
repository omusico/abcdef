package com.lvmama.lvfit.common.dto.search.hotel;

import java.io.Serializable;




public class HotelQueryRequest  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3867133754209123876L;

	/**关键字*/
	private String keywords;
	
	/** 城市代码 */
	private String cityCode;
	
	/** 城市名称*/
	private String cityName;
	
	/**城市行政id*/
    private String cityDistrictId;
	
	/**出发时间*/
	private String departureDate;
	
	/**返程日期*/
	private String returnDate;
	
	/**放置各种参数的字段 （注意参数的规则，请查看PC）*/
	private String params;
	
	/**queryId*/
	private String queryId;
	

	
	/**成人数*/
	private Integer adultCount;
	/**儿童数*/
	private  Integer childCount;
	/** ---------老数据适配，不作为传入参数------- */
	private int roomCounts;
	/** ---------老数据适配，不作为传入参数------- */
	private Boolean hotelFromRecommendedOnly;
	
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getCityDistrictId() {
		return cityDistrictId;
	}

	public void setCityDistrictId(String cityDistrictId) {
		this.cityDistrictId = cityDistrictId;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getQueryId() {
		return queryId;
	}

	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}

	public Boolean getHotelFromRecommendedOnly() {
		return hotelFromRecommendedOnly;
	}

	public void setHotelFromRecommendedOnly(Boolean hotelFromRecommendedOnly) {
		this.hotelFromRecommendedOnly = hotelFromRecommendedOnly;
	}

	public final Integer getAdultCount() {
		return adultCount;
	}

	public final void setAdultCount(Integer adultCount) {
		this.adultCount = adultCount;
	}

	public Integer getChildCount() {
		return childCount;
	}

	public void setChildCount(Integer childCount) {
		this.childCount = childCount;
	}

	public int getRoomCounts() {
		return roomCounts;
	}

	public void setRoomCounts(int roomCounts) {
		this.roomCounts = roomCounts;
	}
}
