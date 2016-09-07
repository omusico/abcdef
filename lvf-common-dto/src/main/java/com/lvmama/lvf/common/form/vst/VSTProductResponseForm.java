package com.lvmama.lvf.common.form.vst;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.md.City;
import com.lvmama.lvf.common.dto.status.ActiveStatus;
import com.lvmama.lvf.common.dto.status.ActiveStatusEnum;
import com.lvmama.lvf.common.dto.status.BatchFlag;
import com.lvmama.lvf.common.dto.status.EffectDates;
import com.lvmama.lvf.common.dto.vst.FlightVstProductDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

public class VSTProductResponseForm implements Form, Serializable {

	private static final long serialVersionUID = -9021213480156401400L;

	private FlightVstProductDto vstProduct;
	
	public FlightVstProductDto getVstProduct() {
		return vstProduct;
	}

	public void setVstProduct(FlightVstProductDto vstProduct) {
		this.vstProduct = vstProduct;
	}
	
	public BatchFlag getBatchFlag(){
		return vstProduct.getBatchFlag();
	}
	
	public void setBatchFlag(BatchFlag batchFlag){
		vstProduct.setBatchFlag(batchFlag);
	}

	public Long getVstProductId() {
		return vstProduct.getVstProductId();
	}

	public void setVstProductId(Long vstProductId) {
		vstProduct.setVstProductId(vstProductId);
	}

	public City getDeptCity() {
		return vstProduct.getDeptCity();
	}

	public void setDeptCity(City deptCity) {
		vstProduct.setDeptCity(deptCity);
	}

	public City getArrvCity() {
		return vstProduct.getArrvCity();
	}

	public void setArrvCity(City arrvCity) {
		vstProduct.setArrvCity(arrvCity);
	}

	public Long getVstDeptCityId() {
		return vstProduct.getVstDeptCityId();
	}

	public void setVstDeptCityId(Long vstDeptCityId) {
		vstProduct.setVstDeptCityId(vstDeptCityId);
	}

	public Long getVstArrvCityId() {
		return vstProduct.getVstArrvCityId();
	}

	public void setVstArrvCityId(Long vstArrvCityId) {
		vstProduct.setVstArrvCityId(vstArrvCityId);
	}
	
	public Date getUpdateStartTime() {
		return vstProduct.getUpdateStartTime();
	}

	public void setUpdateStartTime(Date updateStartTime) {
		vstProduct.setUpdateStartTime(updateStartTime);
	}

	public Date getEffectStartTime() {
		return vstProduct.getEffectStartTime();
	}

	public void setEffectStartTime(Date effectStartTime) {
		vstProduct.setEffectStartTime(effectStartTime);
	}

	public Date getExpireStartTime() {
		return vstProduct.getExpireStartTime();
	}

	public void setExpireStartTime(Date expireStartTime) {
		vstProduct.setExpireStartTime(expireStartTime);
	}
	
	public Date getEffectDate(){
		if(vstProduct.getEffectDates()==null){
			return null;
		}
		return vstProduct.getEffectDates().getEffectDate();
	}

	public void setEffectDate(Date effectDate) {
		if(vstProduct.getEffectDates()==null){
			vstProduct.setEffectDates(new EffectDates());
		}
		vstProduct.getEffectDates().setEffectDate(effectDate);
	}

	public Date getExpireDate() {
		if(vstProduct.getEffectDates()==null){
			return null;
		}
		return vstProduct.getEffectDates().getExpireDate();
	}

	public void setExpireDate(Date expireDate) {
		if(vstProduct.getEffectDates()==null){
			vstProduct.setEffectDates(new EffectDates());
		}
		vstProduct.getEffectDates().setExpireDate(expireDate);
	}
	
	public Date getCreateTime() {
		return vstProduct.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		vstProduct.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return vstProduct.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		vstProduct.setUpdateTime(updateTime);
	}
	
	public EffectDates getEffectDates() {
		return vstProduct.getEffectDates();
	}
	
	public void setEffectDates(EffectDates effectDate) {
		vstProduct.setEffectDates(effectDate);
	}
	
	public ActiveStatus getActiveStatus() {
		return vstProduct.getActiveStatus();
	}

	public void setActiveStatus(ActiveStatus activeStatus) {
		vstProduct.setActiveStatus(activeStatus);
	}
	
	public ActiveStatusEnum getActiveStatusEnum() {
		if(vstProduct.getActiveStatus()==null){
			return null;
		}
        return vstProduct.getActiveStatus().getActiveStatus();
    }

    public void setActiveStatusEnum(ActiveStatusEnum activeStatus) {
    	if(vstProduct.getActiveStatus()==null){
    		vstProduct.setActiveStatus(new ActiveStatus());
    	}
    	vstProduct.getActiveStatus().setActiveStatus(activeStatus);
    }
	
	public String getEffectDateStr(){
		if(this.getEffectDate() != null)
			return DateUtils.formatDate(this.getEffectDate(), DateUtils.YYYY_MM_DD_HH_MM_SS);
		return null;
	}
	
	public String getExpireDateStr(){
		if(this.getExpireDate() != null)
			return DateUtils.formatDate(this.getExpireDate(), DateUtils.YYYY_MM_DD_HH_MM_SS);
		return null;
	}
	
	public String getCreateTimeStr(){
		if(this.getCreateTime() != null)
			return DateUtils.formatDate(this.getCreateTime(), DateUtils.YYYY_MM_DD_HH_MM_SS);
		return null;
	}
	
	public String getUpdateTimeStr(){
		if(this.getUpdateTime() != null)
			return DateUtils.formatDate(this.getUpdateTime(), DateUtils.YYYY_MM_DD_HH_MM_SS);
		return null;
	}
	
	public String getBatchFlagStr(){
		if(this.getBatchFlag() != null){
			return this.getBatchFlag().getCnName();
		}
		return null;
	}
	
	public String getActiveStatusStr(){
		if(this.getActiveStatusEnum() != null){
			return this.getActiveStatusEnum().getCnName();
		}
		return null;
	}

	
}
