package com.lvmama.lvf.common.dto.md;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.NameCode;

public class City extends NameCode implements Serializable {

	/**地区属性*/
	private CountryArea countryArea;
	
	/**经纬度信息*/
	private Location location;
	
	/**城市全拼*/
	private String pinYin;
	
	/**城市简拼*/
	private String jianPin;
	
	/**首字母*/
	private String firstLetter;
	
	/**热度*/
	private Integer hot;
	
	/**三字码*/
	private String cityCode;

    /**对应机场城市*/
    private City airportCity;


	public CountryArea getCountryArea() {
		return countryArea;
	}

	public void setCountryArea(CountryArea countryArea) {
		this.countryArea = countryArea;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getPinYin() {
		return pinYin;
	}

	public void setPinYin(String pinYin) {
		this.pinYin = pinYin;
	}
	
	public String getJianPin() {
		return jianPin;
	}

	public void setJianPin(String jianPin) {
		this.jianPin = jianPin;
	}

	public String getFirstLetter() {
		return firstLetter;
	}

	public void setFirstLetter(String firstLetter) {
		this.firstLetter = firstLetter;
	}

	public Integer getHot() {
		return hot;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}

    public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public City getAirportCity() {
        return airportCity;
    }

    public void setAirportCity(City airportCity) {
        this.airportCity = airportCity;
    }
}
