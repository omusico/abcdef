package com.lvmama.lvfit.common.dto.hotel;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.enums.SymbolType;

public class FitConRecomHotelDto implements Dto,Serializable{
	
	private static final long serialVersionUID = 1722126974153763075L;
	//id
	private Long id;
	//行政id
	private Long districtCityId ;
	//入住城市
	private String cityName;
	//产品id
	private String productId;
	//酒店名称
	private String hotelName;
	//创建时间
	private Date createTime;
	//更改时间
	private Date updateTime;
	//是否默认为推荐酒店
	private SymbolType isDefault; 
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Long getDistrictCityId() {
		return districtCityId;
	}
	public void setDistrictCityId(Long districtCityId) {
		this.districtCityId = districtCityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	@Override
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public SymbolType getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(SymbolType isDefault) {
		this.isDefault = isDefault;
	}
	
	
	
}
