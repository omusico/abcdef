package com.lvmama.lvf.common.dto.vst;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.VSTEntity;
import com.lvmama.lvf.common.dto.md.City;

/**
 * VST产品航线
 */
public class FlightVstProductDto extends VSTEntity implements Serializable {

	private static final long serialVersionUID = -6869109747464144123L;

	/**
	 * vst返回的产品id
	 */
	private Long vstProductId;
	
	/**
	 * 出发城市
	 */
	private City deptCity;
	
	/**
	 * 到达城市
	 */
	private City arrvCity;
	
	/**
	 * vst出发城市id
	 */
	private Long vstDeptCityId;
	
	/**
	 * vst到达城市id
	 */
	private Long vstArrvCityId;
	
	/**
	 * 用于查询数据时存放"更新时间"起始时间条件
	 */
	private Date updateStartTime;
	
	/**
	 * 用于查询数据时存放"开始日期"起始时间条件
	 */
	private Date effectStartTime;
	
	/**
	 * 用于查询数据时存放"到期日期"起始时间条件
	 */
	private Date expireStartTime;

	public Long getVstProductId() {
		return vstProductId;
	}

	public void setVstProductId(Long vstProductId) {
		this.vstProductId = vstProductId;
	}

	public City getDeptCity() {
		return deptCity;
	}

	public void setDeptCity(City deptCity) {
		this.deptCity = deptCity;
	}

	public City getArrvCity() {
		return arrvCity;
	}

	public void setArrvCity(City arrvCity) {
		this.arrvCity = arrvCity;
	}

	public Long getVstDeptCityId() {
		return vstDeptCityId;
	}

	public void setVstDeptCityId(Long vstDeptCityId) {
		this.vstDeptCityId = vstDeptCityId;
	}

	public Long getVstArrvCityId() {
		return vstArrvCityId;
	}

	public void setVstArrvCityId(Long vstArrvCityId) {
		this.vstArrvCityId = vstArrvCityId;
	}

	@Override
	public String toString() {
		return "FlightVstProductDto [vstProductId=" + vstProductId
				+ ", deptCity=" + deptCity.getId() + ", arrvCity=" + arrvCity.getId()
				+ ", vstDeptCityId=" + vstDeptCityId + ", vstArrvCityId="
				+ vstArrvCityId + "]";
	}

	public Date getUpdateStartTime() {
		return updateStartTime;
	}

	public void setUpdateStartTime(Date updateStartTime) {
		this.updateStartTime = updateStartTime;
	}

	public Date getEffectStartTime() {
		return effectStartTime;
	}

	public void setEffectStartTime(Date effectStartTime) {
		this.effectStartTime = effectStartTime;
	}

	public Date getExpireStartTime() {
		return expireStartTime;
	}

	public void setExpireStartTime(Date expireStartTime) {
		this.expireStartTime = expireStartTime;
	}

}
