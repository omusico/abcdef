package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;

public class CommHeaderRequest  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2489399069127944137L;

	private String type;
	
	private Boolean isNew;
	
	private String provinceId;
	
	private String cityId;
	
	private String stationName;
	
	private String pageType;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getIsNew() {
		return isNew;
	}

	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	
}
