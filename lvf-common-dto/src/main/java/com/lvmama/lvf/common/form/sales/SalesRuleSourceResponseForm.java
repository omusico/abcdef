package com.lvmama.lvf.common.form.sales;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.Status;
import com.lvmama.lvf.common.dto.enums.VisibleStatus;
import com.lvmama.lvf.common.dto.sales.SalesRuleBase;
import com.lvmama.lvf.common.dto.sales.SalesRulePriceDto;
import com.lvmama.lvf.common.dto.sales.SalesRuleSourceDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;
/**
 * 营销调控维护 responseForm
 * @author zhangzongshuang
 * @date 2015年8月12日
 */
public class SalesRuleSourceResponseForm  implements Serializable, Form {
	
	private static final long serialVersionUID = 5676341907082936504L;
	
	private SalesRuleSourceDto salesRuleSourceDto=new SalesRuleSourceDto();
	
	/** 航班日期*/
	private String departureDateTime;
	
	/** 有效日期*/
	private String effectDateTime;

	public SalesRuleSourceDto getSalesRuleSourceDto() {
		return salesRuleSourceDto;
	}

	public void setSalesRuleSourceDto(SalesRuleSourceDto salesRuleSourceDto) {
		this.salesRuleSourceDto = salesRuleSourceDto;
	}

	public SalesRuleBase getSalesRuleBase() {
		return salesRuleSourceDto.getSalesRuleBase();
	}

	public void setSalesRuleBase(SalesRuleBase salesRuleBase) {
		salesRuleSourceDto.setSalesRuleBase(salesRuleBase);
	}

	public String getProductCategorys() {
		return salesRuleSourceDto.getProductCategorys();
	}

	public void setProductCategorys(String productCategorys) {
		salesRuleSourceDto.setProductCategorys(productCategorys);
	}

	public String getBookingSources() {
		return salesRuleSourceDto.getBookingSources();
	}

	public void setBookingSources(String bookingSources) {
		salesRuleSourceDto.setBookingSources(bookingSources);
	}

	public PersistenceType getPtype() {
		return salesRuleSourceDto.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		salesRuleSourceDto.setPtype(ptype);
	}

	public String getSequence() {
		return salesRuleSourceDto.getSequence();
	}

	public Long getId() {
		return salesRuleSourceDto.getId();
	}

	public void setId(Long id) {
		salesRuleSourceDto.setId(id);
	}

	public String getUuid() {
		return salesRuleSourceDto.getUuid();
	}

	public void setUuid(String uuid) {
		salesRuleSourceDto.setUuid(uuid);
	}

	public Date getCreateTime() {
		return salesRuleSourceDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		salesRuleSourceDto.setCreateTime(createTime);
	}

	public String getUpdateTime() {
		if(salesRuleSourceDto.getUpdateTime()!=null){
			return DateUtils.formatDate(salesRuleSourceDto.getUpdateTime());
		}
		return "";
	}

	public void setUpdateTime(Date updateTime) {
		salesRuleSourceDto.setUpdateTime(updateTime);
	}

	public String getDepartureAirportCodes() {
		return salesRuleSourceDto.getDepartureAirportCodes();
	}

	public void setDepartureAirportCodes(String departureAirportCodes) {
		salesRuleSourceDto.setDepartureAirportCodes(departureAirportCodes);
	}

	public String getArrivalAirportCodes() {
		return salesRuleSourceDto.getArrivalAirportCodes();
	}

	public void setArrivalAirportCodes(String arrivalAirportCodes) {
		salesRuleSourceDto.setArrivalAirportCodes(arrivalAirportCodes);
	}

	public String getCarrierCodes() {
		return salesRuleSourceDto.getCarrierCodes();
	}

	public void setCarrierCodes(String carrierCodes) {
		salesRuleSourceDto.setCarrierCodes(carrierCodes);
	}

	public String getSeatCodes() {
		return salesRuleSourceDto.getSeatCodes();
	}

	public void setSeatCodes(String seatCodes) {
		salesRuleSourceDto.setSeatCodes(seatCodes);
	}

	public String getIncludeFlightNos() {
		return salesRuleSourceDto.getIncludeFlightNos();
	}

	public void setIncludeFlightNos(String includeFlightNos) {
		salesRuleSourceDto.setIncludeFlightNos(includeFlightNos);
	}

	public String getWeekDays() {
		return salesRuleSourceDto.getWeekDays();
	}

	public void setWeekDays(String weekDays) {
		salesRuleSourceDto.setWeekDays(weekDays);
	}

	public Date getDepStartDate() {
		return salesRuleSourceDto.getDepStartDate();
	}

	public void setDepStartDate(Date depStartDate) {
		salesRuleSourceDto.setDepStartDate(depStartDate);
	}

	public Date getDepEndDate() {
		return salesRuleSourceDto.getDepEndDate();
	}

	public void setDepEndDate(Date depEndDate) {
		salesRuleSourceDto.setDepEndDate(depEndDate);
	}

	public String getExcludeFlightNos() {
		return salesRuleSourceDto.getExcludeFlightNos();
	}

	public void setExcludeFlightNos(String excludeFlightNos) {
		salesRuleSourceDto.setExcludeFlightNos(excludeFlightNos);
	}

	public String getSalesRules() {
		return salesRuleSourceDto.getSalesRules();
	}

	public void setSalesRules(String salesRules) {
		salesRuleSourceDto.setSalesRules(salesRules);
	}

	public List<SalesRulePriceDto> getSalesRulePriceDtos() {
		return salesRuleSourceDto.getSalesRulePriceDtos();
	}

	public void setSalesRulePriceDtos(List<SalesRulePriceDto> salesRulePriceDtos) {
		salesRuleSourceDto.setSalesRulePriceDtos(salesRulePriceDtos);
	}

	public Long getPriority() {
		return salesRuleSourceDto.getPriority();
	}

	public void setPriority(Long priority) {
		salesRuleSourceDto.setPriority(priority);
	}

	public String getStatus() {
		if(salesRuleSourceDto.getStatus()!=null){
			return salesRuleSourceDto.getStatus().getCnName();
		}
		return "";
	}

	public void setStatus(Status status) {
		salesRuleSourceDto.setStatus(status);
	}

	public Date getEffectDate() {
		return salesRuleSourceDto.getEffectDate();
	}

	public void setEffectDate(Date effectDate) {
		salesRuleSourceDto.setEffectDate(effectDate);
	}

	public String getVisibleStatus() {
		if(salesRuleSourceDto.getVisibleStatus()!=null){
			return salesRuleSourceDto.getVisibleStatus().getCnName();
		}
		return "";
	}

	public void setVisibleStatus(VisibleStatus visibleStatus) {
		salesRuleSourceDto.setVisibleStatus(visibleStatus);
	}

	public String getInsuranceClasses() {
		return salesRuleSourceDto.getInsuranceClasses();
	}

	public void setInsuranceClasses(String insuranceClasses) {
		salesRuleSourceDto.setInsuranceClasses(insuranceClasses);
	}

	public Date getExpireDate() {
		return salesRuleSourceDto.getExpireDate();
	}

	public void setExpireDate(Date expireDate) {
		salesRuleSourceDto.setExpireDate(expireDate);
	}

	public String getDepartureDateTime() {
		if(this.getDepStartDate()!=null && this.getDepEndDate()!=null){
			departureDateTime=DateUtils.formatDate(this.getDepStartDate())+"/"
		              +DateUtils.formatDate(this.getDepEndDate());
		}
		return departureDateTime;
	}

	public void setDepartureDateTime(String departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public String getEffectDateTime() {
		if(this.getEffectDate()!=null && this.getExpireDate()!=null){
			effectDateTime=DateUtils.formatDate(this.getEffectDate())+"/"
		              +DateUtils.formatDate(this.getExpireDate());
		}
		return effectDateTime;
	}

	public void setEffectDateTime(String effectDateTime) {
		this.effectDateTime = effectDateTime;
	}
	
}
