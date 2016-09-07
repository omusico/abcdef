package com.lvmama.lvf.common.dto.sales;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.Status;
import com.lvmama.lvf.common.dto.enums.VisibleStatus;
import com.lvmama.lvf.common.dto.md.PriceFormula;

/**
 * 虚拟调控
 * @author hedandan
 *
 */
public class SalesRuleSuppDto extends Entity implements Serializable {

	private static final long serialVersionUID = -5152593143437236404L;

	private SalesRuleBase salesRuleBase = new SalesRuleBase();
	
	/**供应商*/
	private String suppCodes;

	/**调控比例*/
	private PriceFormula priceFormula;

	public SalesRuleBase getSalesRuleBase() {
		return salesRuleBase;
	}

	public void setSalesRuleBase(SalesRuleBase salesRuleBase) {
		this.salesRuleBase = salesRuleBase;
	}

	public String getSuppCodes() {
		return suppCodes;
	}

	public void setSuppCodes(String suppCodes) {
		this.suppCodes = suppCodes;
	}

	public PersistenceType getPtype() {
		return salesRuleBase.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		salesRuleBase.setPtype(ptype);
	}

	public String getSequence() {
		return salesRuleBase.getSequence();
	}

	public Long getId() {
		return salesRuleBase.getId();
	}

	public void setId(Long id) {
		salesRuleBase.setId(id);
	}

	public String getUuid() {
		return salesRuleBase.getUuid();
	}

	public void setUuid(String uuid) {
		salesRuleBase.setUuid(uuid);
	}

	public Date getCreateTime() {
		return salesRuleBase.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		salesRuleBase.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return salesRuleBase.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		salesRuleBase.setUpdateTime(updateTime);
	}

	public String getDepartureAirportCodes() {
		return salesRuleBase.getDepartureAirportCodes();
	}

	public void setDepartureAirportCodes(String departureAirportCodes) {
		salesRuleBase.setDepartureAirportCodes(departureAirportCodes);
	}

	public String getArrivalAirportCodes() {
		return salesRuleBase.getArrivalAirportCodes();
	}

	public void setArrivalAirportCodes(String arrivalAirportCodes) {
		salesRuleBase.setArrivalAirportCodes(arrivalAirportCodes);
	}

	public String getCarrierCodes() {
		return salesRuleBase.getCarrierCodes();
	}

	public void setCarrierCodes(String carrierCodes) {
		salesRuleBase.setCarrierCodes(carrierCodes);
	}

	public String getSeatCodes() {
		return salesRuleBase.getSeatCodes();
	}

	public void setSeatCodes(String seatCodes) {
		salesRuleBase.setSeatCodes(seatCodes);
	}

	public String getIncludeFlightNos() {
		return salesRuleBase.getIncludeFlightNos();
	}

	public void setIncludeFlightNos(String includeFlightNos) {
		salesRuleBase.setIncludeFlightNos(includeFlightNos);
	}

	public String getWeekDays() {
		return salesRuleBase.getWeekDays();
	}

	public void setWeekDays(String weekDays) {
		salesRuleBase.setWeekDays(weekDays);
	}

	public Date getDepStartDate() {
		return salesRuleBase.getDepStartDate();
	}

	public void setDepStartDate(Date depStartDate) {
		salesRuleBase.setDepStartDate(depStartDate);
	}

	public Date getDepEndDate() {
		return salesRuleBase.getDepEndDate();
	}

	public void setDepEndDate(Date depEndDate) {
		salesRuleBase.setDepEndDate(depEndDate);
	}

	public Long getPriority() {
		return salesRuleBase.getPriority();
	}

	public void setPriority(Long priority) {
		salesRuleBase.setPriority(priority);
	}

	public Status getStatus() {
		return salesRuleBase.getStatus();
	}

	public void setStatus(Status status) {
		salesRuleBase.setStatus(status);
	}

	public Date getEffectDate() {
		return salesRuleBase.getEffectDate();
	}

	public void setEffectDate(Date effectDate) {
		salesRuleBase.setEffectDate(effectDate);
	}

	public VisibleStatus getVisibleStatus() {
		return salesRuleBase.getVisibleStatus();
	}

	public void setVisibleStatus(VisibleStatus visibleStatus) {
		salesRuleBase.setVisibleStatus(visibleStatus);
	}

	public Date getExpireDate() {
		return salesRuleBase.getExpireDate();
	}

	public void setExpireDate(Date expireDate) {
		salesRuleBase.setExpireDate(expireDate);
	}

	public String getExcludeFlightNos() {
		return salesRuleBase.getExcludeFlightNos();
	}

	public void setExcludeFlightNos(String excludeFlightNos) {
		salesRuleBase.setExcludeFlightNos(excludeFlightNos);
	}

	public PriceFormula getPriceFormula() {
		return priceFormula;
	}

	public void setPriceFormula(PriceFormula priceFormula) {
		this.priceFormula = priceFormula;
	}

}
