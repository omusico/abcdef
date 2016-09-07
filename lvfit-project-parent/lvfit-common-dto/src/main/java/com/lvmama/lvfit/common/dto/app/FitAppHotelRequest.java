package com.lvmama.lvfit.common.dto.app;

import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.dto.enums.FitBusinessType;

import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;

/**
 * 更换航班查询独享
 */
public class FitAppHotelRequest implements Serializable{

	private static final long serialVersionUID = 2562363814071499389L;

	/**关键字*/
	private String keywords;

	/** 城市代码 */
	private String cityCode;

	/**出发时间*/
	private String departureDate;

	/**返程日期*/
	private String returnDate;

	/**放置各种参数的字段 （注意参数的规则，请查看PC）*/
	private String params;

	/**queryId*/
	private String queryId;

	/**是否只从默认推荐的酒店中取数据*/
	private Boolean hotelFromRecommendedOnly;

	/**成人数*/
	private int adultCount;

	/**儿童数*/
	private int childCount;

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

	public int getAdultCount() {
		return adultCount;
	}

	public void setAdultCount(int adultCount) {
		this.adultCount = adultCount;
	}

	public int getChildCount() {
		return childCount;
	}

	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}

	public static void main(String[] args) {
		FitAppHotelRequest req = new FitAppHotelRequest();
		req.setHotelFromRecommendedOnly(false);
		req.setReturnDate("2016-08-20");
		req.setQueryId(UUID.randomUUID().toString());
		req.setAdultCount(1);
		req.setChildCount(0);
		req.setCityCode("SHA");
		req.setDepartureDate("2016-08-17");

		try {
			String s = JSONMapper.getInstance().writeValueAsString(req);
			System.out.println(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}






