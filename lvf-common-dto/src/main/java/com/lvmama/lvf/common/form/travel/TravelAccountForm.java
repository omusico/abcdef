package com.lvmama.lvf.common.form.travel;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.travel.TravelAccountType;
import com.lvmama.lvf.common.dto.status.ActiveStatus;
import com.lvmama.lvf.common.dto.travel.TravelAccountDto;
import com.lvmama.lvf.common.dto.travel.TravelCompanyInfoDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

/**
 * 
 * @author zhoubinbin
 *
 */
public class TravelAccountForm implements Serializable,Form{
	
	private static final long serialVersionUID = 2873895918073133501L;
	
	private TravelAccountDto travelAccountDto = new TravelAccountDto();
	
	private Pagination pagination = new Pagination();

	public TravelAccountDto getTravelAccountDto() {
		return travelAccountDto;
	}

	public void setTravelAccountDto(TravelAccountDto travelAccountDto) {
		this.travelAccountDto = travelAccountDto;
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

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public String getAccountNumber() {
		return travelAccountDto.getAccountNumber();
	}

	public void setAccountNumber(String accountNumber) {
		travelAccountDto.setAccountNumber(accountNumber);
	}

	public TravelCompanyInfoDto getCompany() {
		return travelAccountDto.getCompany();
	}

	public ActiveStatus getActiveStatus() {
		return travelAccountDto.getActiveStatus();
	}

	public void setCompany(TravelCompanyInfoDto company) {
		travelAccountDto.setCompany(company);
	}

	public void setActiveStatus(ActiveStatus activeStatus) {
		travelAccountDto.setActiveStatus(activeStatus);
	}

	public Long getId() {
		return travelAccountDto.getId();
	}

	public TravelAccountType getAccountType() {
		return travelAccountDto.getAccountType();
	}

	public void setId(Long id) {
		travelAccountDto.setId(id);
	}

	public void setAccountType(TravelAccountType accountType) {
		travelAccountDto.setAccountType(accountType);
	}

	public Date getCreateTime() {
		return travelAccountDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		travelAccountDto.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return travelAccountDto.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		travelAccountDto.setUpdateTime(updateTime);
	}
	
	public String getCreateTimeStr(){
		return DateUtils.formatDate(getCreateTime(), DateUtils.YYYY_MM_DD_HH_MM_SS);
	}
	
	public String getUpdateTimeStr(){
		return DateUtils.formatDate(getUpdateTime(),DateUtils.YYYY_MM_DD_HH_MM_SS);
	}
	
	public String getStatusStr(){
		return getActiveStatus().getActiveStatus().name();
	}
	
	public String getTypeStr(){
		return getAccountType().getCnName();
	}

	public Long getCompanyId() {
		return travelAccountDto.getCompanyId();
	}

	public void setCompanyId(Long companyId) {
		travelAccountDto.setCompanyId(companyId);
	}
	
}
