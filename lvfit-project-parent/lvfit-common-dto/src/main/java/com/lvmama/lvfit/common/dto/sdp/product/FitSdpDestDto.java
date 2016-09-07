package com.lvmama.lvfit.common.dto.sdp.product;

import java.io.Serializable;

/**
 * @author lizongze
 *
 */
public class FitSdpDestDto implements Serializable {

    private static final long serialVersionUID = -4842760628075735161L;

    // 地区ID
    private Long districId;
    // 地区名称
    private String districtName;
    
	private String destId;

	private String parentId;

	private String destType;

	private String destName;

	private String enName;

	private String pinyin;

	private String shortPinyin;

	private String destAlias;

	private String cityDestId;

	private String cityName;

	private String cityPinyin;

	private String provinceDestId;

	private String provinceName;

	private String provincePinyin;

	private String countryDestId;

	private String countryName;

	private String countryPinyin;

	private String continentDestId;

	private String continentName;

	private String continentPinyin;

    
    
    public Long getDistricId() {
        return districId;
    }
    public void setDistricId(Long districId) {
        this.districId = districId;
    }
    public String getDistrictName() {
        return districtName;
    }
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    public String getShortPinyin() {
        return shortPinyin;
    }
    public void setShortPinyin(String shortPinyin) {
        this.shortPinyin = shortPinyin;
    }
	public String getDestId() {
		return destId;
	}
	public void setDestId(String destId) {
		this.destId = destId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getDestType() {
		return destType;
	}
	public void setDestType(String destType) {
		this.destType = destType;
	}
	public String getDestName() {
		return destName;
	}
	public void setDestName(String destName) {
		this.destName = destName;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public String getDestAlias() {
		return destAlias;
	}
	public void setDestAlias(String destAlias) {
		this.destAlias = destAlias;
	}
	public String getCityDestId() {
		return cityDestId;
	}
	public void setCityDestId(String cityDestId) {
		this.cityDestId = cityDestId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityPinyin() {
		return cityPinyin;
	}
	public void setCityPinyin(String cityPinyin) {
		this.cityPinyin = cityPinyin;
	}
	public String getProvinceDestId() {
		return provinceDestId;
	}
	public void setProvinceDestId(String provinceDestId) {
		this.provinceDestId = provinceDestId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getProvincePinyin() {
		return provincePinyin;
	}
	public void setProvincePinyin(String provincePinyin) {
		this.provincePinyin = provincePinyin;
	}
	public String getCountryDestId() {
		return countryDestId;
	}
	public void setCountryDestId(String countryDestId) {
		this.countryDestId = countryDestId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryPinyin() {
		return countryPinyin;
	}
	public void setCountryPinyin(String countryPinyin) {
		this.countryPinyin = countryPinyin;
	}
	public String getContinentDestId() {
		return continentDestId;
	}
	public void setContinentDestId(String continentDestId) {
		this.continentDestId = continentDestId;
	}
	public String getContinentName() {
		return continentName;
	}
	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}
	public String getContinentPinyin() {
		return continentPinyin;
	}
	public void setContinentPinyin(String continentPinyin) {
		this.continentPinyin = continentPinyin;
	}
    
}
