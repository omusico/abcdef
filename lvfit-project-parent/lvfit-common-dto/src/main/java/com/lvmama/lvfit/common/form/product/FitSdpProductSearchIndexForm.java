package com.lvmama.lvfit.common.form.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexDto;

public class FitSdpProductSearchIndexForm implements Serializable, Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1001906511602158076L;

	private FitSdpProductSearchIndexDto fitSdpProductSearchIndexDto;

	/** 查询 分页信息  **/
	private Pagination pagination = new Pagination();
	
	public FitSdpProductSearchIndexDto getFitSdpProductSearchIndexDto() {
		return fitSdpProductSearchIndexDto;
	}

	public void setFitSdpProductSearchIndexDto(
			FitSdpProductSearchIndexDto fitSdpProductSearchIndexDto) {
		this.fitSdpProductSearchIndexDto = fitSdpProductSearchIndexDto;
	}

	public PersistenceType getPtype() {
		return fitSdpProductSearchIndexDto.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		fitSdpProductSearchIndexDto.setPtype(ptype);
	}

	public String getSequence() {
		return fitSdpProductSearchIndexDto.getSequence();
	}

	public Long getId() {
		return fitSdpProductSearchIndexDto.getId();
	}

	public Long getProductId() {
		return fitSdpProductSearchIndexDto.getProductId();
	}

	public void setId(Long id) {
		fitSdpProductSearchIndexDto.setId(id);
	}

	public void setProductId(Long productId) {
		fitSdpProductSearchIndexDto.setProductId(productId);
	}

	public String getUuid() {
		return fitSdpProductSearchIndexDto.getUuid();
	}

	public void setUuid(String uuid) {
		fitSdpProductSearchIndexDto.setUuid(uuid);
	}

	public Long getStartDistrictId() {
		return fitSdpProductSearchIndexDto.getStartDistrictId();
	}

	public Date getCreateTime() {
		return fitSdpProductSearchIndexDto.getCreateTime();
	}

	public void setStartDistrictId(Long startDistrictId) {
		fitSdpProductSearchIndexDto.setStartDistrictId(startDistrictId);
	}

	public void setCreateTime(Date createTime) {
		fitSdpProductSearchIndexDto.setCreateTime(createTime);
	}

	public BigDecimal getLowestMarketPrice() {
		return fitSdpProductSearchIndexDto.getLowestMarketPrice();
	}

	public Date getUpdateTime() {
		return fitSdpProductSearchIndexDto.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		fitSdpProductSearchIndexDto.setUpdateTime(updateTime);
	}

	public void setLowestMarketPrice(BigDecimal lowestMarketPrice) {
		fitSdpProductSearchIndexDto.setLowestMarketPrice(lowestMarketPrice);
	}

	public BigDecimal getLowestSaledPrice() {
		return fitSdpProductSearchIndexDto.getLowestSaledPrice();
	}

	public void setLowestSaledPrice(BigDecimal lowestSaledPrice) {
		fitSdpProductSearchIndexDto.setLowestSaledPrice(lowestSaledPrice);
	}

	public BigDecimal getAppLowestMarketPrice() {
		return fitSdpProductSearchIndexDto.getAppLowestMarketPrice();
	}

	public void setAppLowestMarketPrice(BigDecimal appLowestMarketPrice) {
		fitSdpProductSearchIndexDto
				.setAppLowestMarketPrice(appLowestMarketPrice);
	}

	public BigDecimal getAppLowestSaledPrice() {
		return fitSdpProductSearchIndexDto.getAppLowestSaledPrice();
	}

	public void setAppLowestSaledPrice(BigDecimal appLowestSaledPrice) {
		fitSdpProductSearchIndexDto.setAppLowestSaledPrice(appLowestSaledPrice);
	}

	public BigDecimal getWapLowestMarketPrice() {
		return fitSdpProductSearchIndexDto.getWapLowestMarketPrice();
	}

	public void setWapLowestMarketPrice(BigDecimal wapLowestMarketPrice) {
		fitSdpProductSearchIndexDto
				.setWapLowestMarketPrice(wapLowestMarketPrice);
	}

	public BigDecimal getWapLowestSaledPrice() {
		return fitSdpProductSearchIndexDto.getWapLowestSaledPrice();
	}

	public void setWapLowestSaledPrice(BigDecimal wapLowestSaledPrice) {
		fitSdpProductSearchIndexDto.setWapLowestSaledPrice(wapLowestSaledPrice);
	}

	public String getStartDistrict() {
		return fitSdpProductSearchIndexDto.getStartDistrict();
	}

	public void setStartDistrict(String startDistrict) {
		fitSdpProductSearchIndexDto.setStartDistrict(startDistrict);
	}

	public boolean equals(Object obj) {
		return pagination.equals(obj);
	}

	public int hashCode() {
		return pagination.hashCode();
	}

	public void setRowsByCustom(int customRows) {
		pagination.setRowsByCustom(customRows);
	}

	public String toString() {
		return pagination.toString();
	}

	/**   pagination start	 * 	 */
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
    
    public Pagination getPagination() {
		return pagination;
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
	/**   pagination end	 * 	 */
	

}
