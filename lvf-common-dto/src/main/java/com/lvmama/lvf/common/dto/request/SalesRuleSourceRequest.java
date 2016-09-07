package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.Status;
import com.lvmama.lvf.common.dto.enums.VisibleStatus;
import com.lvmama.lvf.common.dto.sales.SalesRuleBase;
import com.lvmama.lvf.common.dto.sales.SalesRulePriceDto;
import com.lvmama.lvf.common.dto.sales.SalesRuleSourceDto;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.StringUtil;

/**
 * 营销调控request
 * @author hedandan
 *
 */
public class SalesRuleSourceRequest implements Serializable, Dto {

	private static final long serialVersionUID = 170006824878103759L;

	private SalesRuleSourceDto salesRuleSourceDto = new SalesRuleSourceDto();
	/** 航班日期起*毫秒数*/
	private Long departureStartDate;
	/** 航班日期止*毫秒数*/
	private Long departureEndDate;
	/** 航班日期起*/
	private String departureStartTime;
	/** 航班日期止*/
	private String departureEndTime;
	/** 维护日期起*/
	private String updateStartTime;
	/** 维护日期止*/
	private String updateEndTime;
	/**营销调控规则List*/
	private List<Long> ids = new ArrayList<Long>();
	
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

	public Date getUpdateTime() {
		return salesRuleSourceDto.getUpdateTime();
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

	public Date getDepEndDate() {
		return salesRuleSourceDto.getDepEndDate();
	}

	public Long getPriority() {
		return salesRuleSourceDto.getPriority();
	}

	public void setPriority(Long priority) {
		salesRuleSourceDto.setPriority(priority);
	}

	public Status getStatus() {
		return salesRuleSourceDto.getStatus();
	}

	public void setStatus(Status status) {
		salesRuleSourceDto.setStatus(status);
	}

	public Date getEffectDate() {
		return salesRuleSourceDto.getEffectDate();
	}

	public VisibleStatus getVisibleStatus() {
		return salesRuleSourceDto.getVisibleStatus();
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

	public String getUpdateStartTime() {
		return updateStartTime;
	}

	public void setUpdateStartTime(String updateStartTime) {
		this.updateStartTime = updateStartTime;
	}

	public String getUpdateEndTime() {
		return updateEndTime;
	}

	public void setUpdateEndTime(String updateEndTime) {
		this.updateEndTime = updateEndTime;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public Long getDepartureStartDate() {
		return departureStartDate;
	}

	public void setDepartureStartDate(Long departureStartDate) {
		this.departureStartDate = departureStartDate;
	}

	public Long getDepartureEndDate() {
		return departureEndDate;
	}

	public void setDepartureEndDate(Long departureEndDate) {
		this.departureEndDate = departureEndDate;
	}

	public String getDepartureStartTime() {
		return departureStartTime;
	}

	public void setDepartureStartTime(String departureStartTime) {
		this.departureStartTime = departureStartTime;
		if(StringUtil.isNotEmptyString(departureStartTime)){
			Long departureStartTimeLong = DateUtils.parseCnHmDate(departureStartTime+ " 00:00:00").getTime();
			this.setDepartureStartDate(departureStartTimeLong);
		}
	}

	public String getDepartureEndTime() {
		return departureEndTime;
	}

	public void setDepartureEndTime(String departureEndTime) {
		this.departureEndTime = departureEndTime;
		if(StringUtil.isNotEmptyString(departureEndTime)){
			Long departureEndTimeLong = DateUtils.parseCnHmDate(departureEndTime+ " 00:00:00").getTime();
			this.setDepartureEndDate(departureEndTimeLong);
		}
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

}
