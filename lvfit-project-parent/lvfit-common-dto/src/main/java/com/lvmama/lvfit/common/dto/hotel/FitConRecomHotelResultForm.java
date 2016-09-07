package com.lvmama.lvfit.common.dto.hotel;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.dto.enums.SymbolType;

public class FitConRecomHotelResultForm implements Serializable, Form{

	private static final long serialVersionUID = 5962566936207741894L;
	
	private FitConRecomHotelDto fitConRecomHotelDto;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public FitConRecomHotelResultForm(FitConRecomHotelDto fitConRecomHotelDto) {
		super();
		this.fitConRecomHotelDto = fitConRecomHotelDto;
	}


	public FitConRecomHotelDto getFitConRecomHotelDto() {
		return fitConRecomHotelDto;
	}

	public void setFitConRecomHotelDto(FitConRecomHotelDto fitConRecomHotelDto) {
		this.fitConRecomHotelDto = fitConRecomHotelDto;
	}

	public Date getCreateTime() {
		return fitConRecomHotelDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		fitConRecomHotelDto.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return fitConRecomHotelDto.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		fitConRecomHotelDto.setUpdateTime(updateTime);
	}

	public Long getDistrictCityId() {
		return fitConRecomHotelDto.getDistrictCityId();
	}

	public void setDistrictCityId(Long districtCityId) {
		fitConRecomHotelDto.setDistrictCityId(districtCityId);
	}

	public String getCityName() {
		return fitConRecomHotelDto.getCityName();
	}

	public void setCityName(String cityName) {
		fitConRecomHotelDto.setCityName(cityName);
	}

	public String getProductId() {
		return fitConRecomHotelDto.getProductId();
	}

	public void setProductId(String productId) {
		fitConRecomHotelDto.setProductId(productId);
	}

	public String getHotelName() {
		return fitConRecomHotelDto.getHotelName();
	}

	public void setHotelName(String hotelName) {
		fitConRecomHotelDto.setHotelName(hotelName);
	}

	public Long getId() {
		return fitConRecomHotelDto.getId();
	}

	public void setId(Long id) {
		fitConRecomHotelDto.setId(id);
	}
	
	public String getCreateTimeStr() {
		if(fitConRecomHotelDto.getCreateTime() != null)
			return DateUtils.formatDate(fitConRecomHotelDto.getCreateTime(), DateUtils.YYYY_MM_DD_HH_MM_SS);
		return null;
	}
	
	public String getUpdateTimeStr(){
		if(fitConRecomHotelDto.getCreateTime() != null)
			return DateUtils.formatDate(fitConRecomHotelDto.getUpdateTime(), DateUtils.YYYY_MM_DD_HH_MM_SS);
		return null;
	}

	public String getIsDefault() {
		return fitConRecomHotelDto.getIsDefault().getCnName();
	}

	public void setIsDefault(SymbolType isDefault) {
		fitConRecomHotelDto.setIsDefault(isDefault);
	}
	
}
