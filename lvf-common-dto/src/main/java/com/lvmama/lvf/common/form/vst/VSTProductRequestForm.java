package com.lvmama.lvf.common.form.vst;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.md.City;
import com.lvmama.lvf.common.dto.status.BatchFlag;
import com.lvmama.lvf.common.dto.vst.FlightVstProductDto;
import com.lvmama.lvf.common.form.Form;

public class VSTProductRequestForm implements Form, Serializable{

	private static final long serialVersionUID = 6423178441589571306L;
	
	private FlightVstProductDto vstProduct = new FlightVstProductDto();
	
	private String updateBeginTime;
	
	private String updateEndTime;
	
	private String deptCityCode;
	
	private String arrvCityCode;
	
	private Pagination pagination = new Pagination();
	
	public FlightVstProductDto getVstProduct() {
		return vstProduct;
	}

	public void setVstProduct(FlightVstProductDto vstProduct) {
		this.vstProduct = vstProduct;
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
	
	public Date getUpdateTime() {
		return vstProduct.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		vstProduct.setUpdateTime(updateTime);
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

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
	public int getPage() {
		return pagination.getPage();
	}

	public void setPage(int page) {
		pagination.setPage(page);
	}

	public int getRows() {
		return pagination.getRows();
	}

	public void setRows(int rows) {
		pagination.setRows(rows);
	}

	public int getRecords() {
		return pagination.getRecords();
	}

	public void setRecords(int records) {
		pagination.setRecords(records);
	}

	public void countRecords(int records) {
		pagination.countRecords(records);
	}

	public int getTotal() {
		return pagination.getTotal();
	}

	public void setTotal(int total) {
		pagination.setTotal(total);
	}

	public String getSidx() {
		return pagination.getSidx();
	}

	public void setSidx(String sidx) {
		pagination.setSidx(sidx);
	}

	public String getSord() {
		return pagination.getSord();
	}

	public void setSord(String sord) {
		pagination.setSord(sord);
	}

	public int getStartRow() {
		return pagination.getStartRow();
	}

	public int getEndRow() {
		return pagination.getEndRow();
	}

	public boolean isSearch() {
		return pagination.isSearch();
	}

	public void setSearch(boolean search) {
		pagination.setSearch(search);
	}

	public String getUpdateBeginTime() {
		return updateBeginTime;
	}

	public void setUpdateBeginTime(String updateBeginTime) {
		this.updateBeginTime = updateBeginTime;
	}

	public String getUpdateEndTime() {
		return updateEndTime;
	}

	public void setUpdateEndTime(String updateEndTime) {
		this.updateEndTime = updateEndTime;
	}

	public BatchFlag getBatchFlag() {
		return vstProduct.getBatchFlag();
	}

	public void setBatchFlag(BatchFlag batchFlag) {
		vstProduct.setBatchFlag(batchFlag);
	}

	public String getDeptCityCode() {
		return deptCityCode;
	}

	public void setDeptCityCode(String deptCityCode) {
		this.deptCityCode = deptCityCode;
	}

	public String getArrvCityCode() {
		return arrvCityCode;
	}

	public void setArrvCityCode(String arrvCityCode) {
		this.arrvCityCode = arrvCityCode;
	}

}
