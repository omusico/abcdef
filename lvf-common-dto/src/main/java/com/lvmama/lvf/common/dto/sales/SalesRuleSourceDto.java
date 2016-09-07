package com.lvmama.lvf.common.dto.sales;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.Status;
import com.lvmama.lvf.common.dto.enums.VisibleStatus;

/**
 * 营销调控
 * @author hedandan
 *
 */
public class SalesRuleSourceDto extends Entity implements Serializable {

	private static final long serialVersionUID = -5152593143437236404L;

	private SalesRuleBase salesRuleBase = new SalesRuleBase();
	
	/**适用场景*/
	private String productCategorys;
	
	/**适用渠道*/
	private String bookingSources;
	
	/**绑定险种*/
	private String insuranceClasses;
	
	/**营销调控规则*/
	private String salesRules;
	
	/**营销调控价格（用于页面展示）*/
	private List<SalesRulePriceDto> salesRulePriceDtos=new ArrayList<SalesRulePriceDto>();
	
	public SalesRuleBase getSalesRuleBase() {
		return salesRuleBase;
	}

	public void setSalesRuleBase(SalesRuleBase salesRuleBase) {
		this.salesRuleBase = salesRuleBase;
	}

	public String getProductCategorys() {
		return productCategorys;
	}

	public void setProductCategorys(String productCategorys) {
		this.productCategorys = productCategorys;
	}

	public String getBookingSources() {
		return bookingSources;
	}

	public void setBookingSources(String bookingSources) {
		this.bookingSources = bookingSources;
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

	public String getInsuranceClasses() {
		return insuranceClasses;
	}

	public void setInsuranceClasses(String insuranceClasses) {
		this.insuranceClasses = insuranceClasses;
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

	public String getSalesRules() {
		return salesRules;
	}

	public void setSalesRules(String salesRules) {
		this.salesRules = salesRules;
	}

	public List<SalesRulePriceDto> getSalesRulePriceDtos() {
		return salesRulePriceDtos;
	}

	public void setSalesRulePriceDtos(List<SalesRulePriceDto> salesRulePriceDtos) {
		this.salesRulePriceDtos = salesRulePriceDtos;
	}
	

}
