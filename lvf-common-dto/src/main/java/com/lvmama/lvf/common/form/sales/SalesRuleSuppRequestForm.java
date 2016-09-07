package com.lvmama.lvf.common.form.sales;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.Status;
import com.lvmama.lvf.common.dto.enums.VisibleStatus;
import com.lvmama.lvf.common.dto.md.PriceFormula;
import com.lvmama.lvf.common.dto.request.SalesRuleSuppRequest;
import com.lvmama.lvf.common.dto.sales.SalesRuleBase;
import com.lvmama.lvf.common.dto.sales.SalesRuleSuppDto;
import com.lvmama.lvf.common.form.Form;
/**
 * 营销虚拟调控维护 requestForm
 * @author zhangzongshuang
 * @date 2015年8月12日
 */
public class SalesRuleSuppRequestForm implements Serializable, Form {
	
	private static final long serialVersionUID = -4257907390678349536L;
	
	private SalesRuleSuppRequest salesRuleSuppRequest=new SalesRuleSuppRequest();
    
	private Pagination pagination = new Pagination();

	public SalesRuleSuppRequest getSalesRuleSuppRequest() {
		return salesRuleSuppRequest;
	}

	public void setSalesRuleSuppRequest(SalesRuleSuppRequest salesRuleSuppRequest) {
		this.salesRuleSuppRequest = salesRuleSuppRequest;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public SalesRuleSuppDto getSalesRuleSuppDto() {
		return salesRuleSuppRequest.getSalesRuleSuppDto();
	}

	public void setSalesRuleSuppDto(SalesRuleSuppDto salesRuleSuppDto) {
		salesRuleSuppRequest.setSalesRuleSuppDto(salesRuleSuppDto);
	}

	public SalesRuleBase getSalesRuleBase() {
		return salesRuleSuppRequest.getSalesRuleBase();
	}

	public void setSalesRuleBase(SalesRuleBase salesRuleBase) {
		salesRuleSuppRequest.setSalesRuleBase(salesRuleBase);
	}

	public String getSuppCodes() {
		return salesRuleSuppRequest.getSuppCodes();
	}

	public void setSuppCodes(String suppCodes) {
		salesRuleSuppRequest.setSuppCodes(suppCodes);
	}

	public PersistenceType getPtype() {
		return salesRuleSuppRequest.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		salesRuleSuppRequest.setPtype(ptype);
	}

	public String getSequence() {
		return salesRuleSuppRequest.getSequence();
	}

	public void setId(Long id) {
		salesRuleSuppRequest.setId(id);
	}

	public String getUuid() {
		return salesRuleSuppRequest.getUuid();
	}

	public void setUuid(String uuid) {
		salesRuleSuppRequest.setUuid(uuid);
	}

	public Date getCreateTime() {
		return salesRuleSuppRequest.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		salesRuleSuppRequest.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return salesRuleSuppRequest.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		salesRuleSuppRequest.setUpdateTime(updateTime);
	}

	public String getDepartureAirportCodes() {
		return salesRuleSuppRequest.getDepartureAirportCodes();
	}

	public void setDepartureAirportCodes(String departureAirportCodes) {
		salesRuleSuppRequest.setDepartureAirportCodes(departureAirportCodes);
	}

	public String getArrivalAirportCodes() {
		return salesRuleSuppRequest.getArrivalAirportCodes();
	}

	public void setArrivalAirportCodes(String arrivalAirportCodes) {
		salesRuleSuppRequest.setArrivalAirportCodes(arrivalAirportCodes);
	}

	public String getCarrierCodes() {
		return salesRuleSuppRequest.getCarrierCodes();
	}

	public void setCarrierCodes(String carrierCodes) {
		salesRuleSuppRequest.setCarrierCodes(carrierCodes);
	}

	public String getSeatCodes() {
		return salesRuleSuppRequest.getSeatCodes();
	}

	public void setSeatCodes(String seatCodes) {
		salesRuleSuppRequest.setSeatCodes(seatCodes);
	}

	public String getIncludeFlightNos() {
		return salesRuleSuppRequest.getIncludeFlightNos();
	}

	public void setIncludeFlightNos(String includeFlightNos) {
		salesRuleSuppRequest.setIncludeFlightNos(includeFlightNos);
	}

	public String getWeekDays() {
		return salesRuleSuppRequest.getWeekDays();
	}

	public void setWeekDays(String weekDays) {
		salesRuleSuppRequest.setWeekDays(weekDays);
	}

	public Date getDepStartDate() {
		return salesRuleSuppRequest.getDepStartDate();
	}

	public void setDepStartDate(Date depStartDate) {
		salesRuleSuppRequest.setDepStartDate(depStartDate);
	}

	public Date getDepEndDate() {
		return salesRuleSuppRequest.getDepEndDate();
	}

	public void setDepEndDate(Date depEndDate) {
		salesRuleSuppRequest.setDepEndDate(depEndDate);
	}

	public String getExcludeFlightNos() {
		return salesRuleSuppRequest.getExcludeFlightNos();
	}

	public void setExcludeFlightNos(String excludeFlightNos) {
		salesRuleSuppRequest.setExcludeFlightNos(excludeFlightNos);
	}

	public PriceFormula getPriceFormula() {
		return salesRuleSuppRequest.getPriceFormula();
	}

	public void setPriceFormula(PriceFormula priceFormula) {
		salesRuleSuppRequest.setPriceFormula(priceFormula);
	}

	public Long getPriority() {
		return salesRuleSuppRequest.getPriority();
	}

	public void setPriority(Long priority) {
		salesRuleSuppRequest.setPriority(priority);
	}

	public Status getStatus() {
		return salesRuleSuppRequest.getStatus();
	}

	public void setStatus(Status status) {
		salesRuleSuppRequest.setStatus(status);
	}

	public Date getEffectDate() {
		return salesRuleSuppRequest.getEffectDate();
	}

	public void setEffectDate(Date effectDate) {
		salesRuleSuppRequest.setEffectDate(effectDate);
	}

	public VisibleStatus getVisibleStatus() {
		return salesRuleSuppRequest.getVisibleStatus();
	}

	public void setVisibleStatus(VisibleStatus visibleStatus) {
		salesRuleSuppRequest.setVisibleStatus(visibleStatus);
	}

	public Date getExpireDate() {
		return salesRuleSuppRequest.getExpireDate();
	}

	public void setExpireDate(Date expireDate) {
		salesRuleSuppRequest.setExpireDate(expireDate);
	}

	public Long getId() {
		return salesRuleSuppRequest.getId();
	}

	public List<Long> getIds() {
		return salesRuleSuppRequest.getIds();
	}

	public void setIds(List<Long> ids) {
		salesRuleSuppRequest.setIds(ids);
	}

	public Long getDepartureStartDate() {
		return salesRuleSuppRequest.getDepartureStartDate();
	}

	public void setDepartureStartDate(Long departureStartDate) {
		salesRuleSuppRequest.setDepartureStartDate(departureStartDate);
	}

	public Long getDepartureEndDate() {
		return salesRuleSuppRequest.getDepartureEndDate();
	}

	public void setDepartureEndDate(Long departureEndDate) {
		salesRuleSuppRequest.setDepartureEndDate(departureEndDate);
	}

	public String getDepartureStartTime() {
		return salesRuleSuppRequest.getDepartureStartTime();
	}

	public void setDepartureStartTime(String departureStartTime) {
		salesRuleSuppRequest.setDepartureStartTime(departureStartTime);
	}

	public String getDepartureEndTime() {
		return salesRuleSuppRequest.getDepartureEndTime();
	}

	public void setDepartureEndTime(String departureEndTime) {
		salesRuleSuppRequest.setDepartureEndTime(departureEndTime);
	}

	public String getUpdateStartTime() {
		return salesRuleSuppRequest.getUpdateStartTime();
	}

	public void setUpdateStartTime(String updateStartTime) {
		salesRuleSuppRequest.setUpdateStartTime(updateStartTime);
	}

	public String getUpdateEndTime() {
		return salesRuleSuppRequest.getUpdateEndTime();
	}

	public void setUpdateEndTime(String updateEndTime) {
		salesRuleSuppRequest.setUpdateEndTime(updateEndTime);
	}
	

}
