package com.lvmama.lvf.common.form.travel;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.travel.TravelCompanyInfoDto;
import com.lvmama.lvf.common.form.Form;

/**
 * @author lutianyu
 * @date   2016年1月20日
 */
public class TravelCompanyForm implements Serializable, Form{
	private static final long serialVersionUID = -2927946536512027147L;

	private TravelCompanyInfoDto travelCompanyInfoDto = new TravelCompanyInfoDto();
	
	private Pagination pagination = new Pagination();

	public TravelCompanyInfoDto getTravelCompanyInfoDto() {
		return travelCompanyInfoDto;
	}

	public void setTravelCompanyInfoDto(TravelCompanyInfoDto travelCompanyInfoDto) {
		this.travelCompanyInfoDto = travelCompanyInfoDto;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public String getCompanyName() {
		return travelCompanyInfoDto.getCompanyName();
	}

	public void setCompanyName(String companyName) {
		travelCompanyInfoDto.setCompanyName(companyName);
	}

	public String getCompanyCode() {
		return travelCompanyInfoDto.getCompanyCode();
	}

	public void setCompanyCode(String companyCode) {
		travelCompanyInfoDto.setCompanyCode(companyCode);
	}

	public Long getId() {
		return travelCompanyInfoDto.getId();
	}

	public void setId(Long id) {
		travelCompanyInfoDto.setId(id);
	}

	public TravelCompanyInfoDto getParentCompany() {
		return travelCompanyInfoDto.getParentCompany();
	}

	public void setParentCompany(TravelCompanyInfoDto parentCompany) {
		travelCompanyInfoDto.setParentCompany(parentCompany);
	}

	public int getPage() {
		return pagination.getPage();
	}

	public void setPage(int page) {
		pagination.setPage(page);
	}

	public int hashCode() {
		return pagination.hashCode();
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

	public String toString() {
		return pagination.toString();
	}

	public boolean equals(Object obj) {
		return pagination.equals(obj);
	}

}
