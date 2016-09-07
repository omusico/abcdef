package com.lvmama.lvf.common.form.sales;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.Status;
import com.lvmama.lvf.common.dto.enums.VisibleStatus;
import com.lvmama.lvf.common.dto.request.SalesRuleSourceRequest;
import com.lvmama.lvf.common.dto.sales.SalesRuleBase;
import com.lvmama.lvf.common.dto.sales.SalesRulePriceDto;
import com.lvmama.lvf.common.dto.sales.SalesRuleSourceDto;
import com.lvmama.lvf.common.form.Form;
/**
 * 营销调控维护 requestForm
 * @author zhangzongshuang
 * @date 2015年8月12日
 */
public class SalesRuleSourceRequestForm implements Serializable, Form {
	
	private static final long serialVersionUID = -3988358607632568060L;
	
	private SalesRuleSourceRequest salesRuleSourceRequest=new SalesRuleSourceRequest();
	
	private Pagination pagination = new Pagination();

	public SalesRuleSourceDto getSalesRuleSourceDto() {
		return salesRuleSourceRequest.getSalesRuleSourceDto();
	}

	public void setSalesRuleSourceDto(SalesRuleSourceDto salesRuleSourceDto) {
		salesRuleSourceRequest.setSalesRuleSourceDto(salesRuleSourceDto);
	}

	public SalesRuleBase getSalesRuleBase() {
		return salesRuleSourceRequest.getSalesRuleBase();
	}

	public void setSalesRuleBase(SalesRuleBase salesRuleBase) {
		salesRuleSourceRequest.setSalesRuleBase(salesRuleBase);
	}

	public String getProductCategorys() {
		return salesRuleSourceRequest.getProductCategorys();
	}

	public void setProductCategorys(String productCategorys) {
		salesRuleSourceRequest.setProductCategorys(productCategorys);
	}

	public String getBookingSources() {
		return salesRuleSourceRequest.getBookingSources();
	}

	public void setBookingSources(String bookingSources) {
		salesRuleSourceRequest.setBookingSources(bookingSources);
	}

	public String getSequence() {
		return salesRuleSourceRequest.getSequence();
	}

	public void setId(Long id) {
		salesRuleSourceRequest.setId(id);
	}

	public String getUuid() {
		return salesRuleSourceRequest.getUuid();
	}

	public void setUuid(String uuid) {
		salesRuleSourceRequest.setUuid(uuid);
	}

	public Date getCreateTime() {
		return salesRuleSourceRequest.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		salesRuleSourceRequest.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return salesRuleSourceRequest.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		salesRuleSourceRequest.setUpdateTime(updateTime);
	}

	public String getDepartureAirportCodes() {
		return salesRuleSourceRequest.getDepartureAirportCodes();
	}

	public void setDepartureAirportCodes(String departureAirportCodes) {
		salesRuleSourceRequest.setDepartureAirportCodes(departureAirportCodes);
	}

	public String getArrivalAirportCodes() {
		return salesRuleSourceRequest.getArrivalAirportCodes();
	}

	public void setArrivalAirportCodes(String arrivalAirportCodes) {
		salesRuleSourceRequest.setArrivalAirportCodes(arrivalAirportCodes);
	}

	public String getCarrierCodes() {
		return salesRuleSourceRequest.getCarrierCodes();
	}

	public void setCarrierCodes(String carrierCodes) {
		salesRuleSourceRequest.setCarrierCodes(carrierCodes);
	}

	public String getSeatCodes() {
		return salesRuleSourceRequest.getSeatCodes();
	}

	public void setSeatCodes(String seatCodes) {
		salesRuleSourceRequest.setSeatCodes(seatCodes);
	}

	public String getIncludeFlightNos() {
		return salesRuleSourceRequest.getIncludeFlightNos();
	}

	public void setIncludeFlightNos(String includeFlightNos) {
		salesRuleSourceRequest.setIncludeFlightNos(includeFlightNos);
	}

	public String getWeekDays() {
		return salesRuleSourceRequest.getWeekDays();
	}

	public void setWeekDays(String weekDays) {
		salesRuleSourceRequest.setWeekDays(weekDays);
	}

	public Date getDepStartDate() {
		return salesRuleSourceRequest.getDepStartDate();
	}

	public Date getDepEndDate() {
		return salesRuleSourceRequest.getDepEndDate();
	}

	public List<Long> getIds() {
		return salesRuleSourceRequest.getIds();
	}

	public void setIds(List<Long> ids) {
		salesRuleSourceRequest.setIds(ids);
	}

	public String getExcludeFlightNos() {
		return salesRuleSourceRequest.getExcludeFlightNos();
	}

	public void setExcludeFlightNos(String excludeFlightNos) {
		salesRuleSourceRequest.setExcludeFlightNos(excludeFlightNos);
	}

	public String getSalesRules() {
		return salesRuleSourceRequest.getSalesRules();
	}

	public void setSalesRules(String salesRules) {
		salesRuleSourceRequest.setSalesRules(salesRules);
	}

	public List<SalesRulePriceDto> getSalesRulePriceDtos() {
		return salesRuleSourceRequest.getSalesRulePriceDtos();
	}

	public void setSalesRulePriceDtos(List<SalesRulePriceDto> salesRulePriceDtos) {
		salesRuleSourceRequest.setSalesRulePriceDtos(salesRulePriceDtos);
	}

	public Long getPriority() {
		return salesRuleSourceRequest.getPriority();
	}

	public void setPriority(Long priority) {
		salesRuleSourceRequest.setPriority(priority);
	}

	public Status getStatus() {
		return salesRuleSourceRequest.getStatus();
	}

	public void setStatus(Status status) {
		salesRuleSourceRequest.setStatus(status);
	}

	public Date getEffectDate() {
		return salesRuleSourceRequest.getEffectDate();
	}

	public VisibleStatus getVisibleStatus() {
		return salesRuleSourceRequest.getVisibleStatus();
	}

	public void setVisibleStatus(VisibleStatus visibleStatus) {
		salesRuleSourceRequest.setVisibleStatus(visibleStatus);
	}

	public String getInsuranceClasses() {
		return salesRuleSourceRequest.getInsuranceClasses();
	}

	public void setInsuranceClasses(String insuranceClasses) {
		salesRuleSourceRequest.setInsuranceClasses(insuranceClasses);
	}

	public Date getExpireDate() {
		return salesRuleSourceRequest.getExpireDate();
	}
	
	public String getUpdateStartTime() {
		return salesRuleSourceRequest.getUpdateStartTime();
	}

	public void setUpdateStartTime(String updateStartTime) {
		salesRuleSourceRequest.setUpdateStartTime(updateStartTime);
	}

	public String getUpdateEndTime() {
		return salesRuleSourceRequest.getUpdateEndTime();
	}

	public void setUpdateEndTime(String updateEndTime) {
		salesRuleSourceRequest.setUpdateEndTime(updateEndTime);
	}

	public Long getId() {
		return salesRuleSourceRequest.getId();
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

	public SalesRuleSourceRequest getSalesRuleSourceRequest() {
		return salesRuleSourceRequest;
	}

	public void setSalesRuleSourceRequest(SalesRuleSourceRequest salesRuleSourceRequest) {
		this.salesRuleSourceRequest = salesRuleSourceRequest;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public Long getDepartureStartDate() {
		return salesRuleSourceRequest.getDepartureStartDate();
	}

	public void setDepartureStartDate(Long departureStartDate) {
		salesRuleSourceRequest.setDepartureStartDate(departureStartDate);
	}

	public Long getDepartureEndDate() {
		return salesRuleSourceRequest.getDepartureEndDate();
	}

	public void setDepartureEndDate(Long departureEndDate) {
		salesRuleSourceRequest.setDepartureEndDate(departureEndDate);
	}

	public String getDepartureStartTime() {
		return salesRuleSourceRequest.getDepartureStartTime();
	}

	public void setDepartureStartTime(String departureStartTime) {
		salesRuleSourceRequest.setDepartureStartTime(departureStartTime);
	}

	public String getDepartureEndTime() {
		return salesRuleSourceRequest.getDepartureEndTime();
	}

	public void setDepartureEndTime(String departureEndTime) {
		salesRuleSourceRequest.setDepartureEndTime(departureEndTime);
	}

	public void setPtype(PersistenceType ptype) {
		salesRuleSourceRequest.setPtype(ptype);
	}
 	
}
