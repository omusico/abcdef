package com.lvmama.lvfit.common.dto.hotel;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.form.Form;

public class FitConRecomHotelInputForm implements Serializable,Form {

	
	private static final long serialVersionUID = -5802922284194236343L;
	
	private FitConRecomHotelDto fitConRecomHotelDto = new FitConRecomHotelDto();
	
	private Pagination pagination = new Pagination();

	public FitConRecomHotelDto getFitConRecomHotelDto() {
		return fitConRecomHotelDto;
	}

	public void setFitConRecomHotelDto(FitConRecomHotelDto fitConRecomHotelDto) {
		this.fitConRecomHotelDto = fitConRecomHotelDto;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
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

	public void setRowsByCustom(int customRows) {
		pagination.setRowsByCustom(customRows);
	}

	public int getRecords() {
		return pagination.getRecords();
	}

	public void setRecords(int records) {
		pagination.setRecords(records);
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

	@Override
	public boolean equals(Object obj) {
		return pagination.equals(obj);
	}
	
	
	
	
}
