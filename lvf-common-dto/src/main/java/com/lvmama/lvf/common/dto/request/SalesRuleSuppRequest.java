package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.Status;
import com.lvmama.lvf.common.dto.enums.VisibleStatus;
import com.lvmama.lvf.common.dto.md.PriceFormula;
import com.lvmama.lvf.common.dto.sales.SalesRuleBase;
import com.lvmama.lvf.common.dto.sales.SalesRuleSuppDto;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.StringUtil;

/**
 * 虚拟调控request
 * @author hedandan
 *
 */
public class SalesRuleSuppRequest implements Serializable, Dto {

	private static final long serialVersionUID = -976608574464422411L;

	private SalesRuleSuppDto salesRuleSuppDto = new SalesRuleSuppDto();
	
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
	
	public SalesRuleSuppDto getSalesRuleSuppDto() {
		return salesRuleSuppDto;
	}

	public void setSalesRuleSuppDto(SalesRuleSuppDto salesRuleSuppDto) {
		this.salesRuleSuppDto = salesRuleSuppDto;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public SalesRuleBase getSalesRuleBase() {
		return salesRuleSuppDto.getSalesRuleBase();
	}

	public void setSalesRuleBase(SalesRuleBase salesRuleBase) {
		salesRuleSuppDto.setSalesRuleBase(salesRuleBase);
	}

	public String getSuppCodes() {
		return salesRuleSuppDto.getSuppCodes();
	}

	public void setSuppCodes(String suppCodes) {
		salesRuleSuppDto.setSuppCodes(suppCodes);
	}

	public PersistenceType getPtype() {
		return salesRuleSuppDto.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		salesRuleSuppDto.setPtype(ptype);
	}

	public String getSequence() {
		return salesRuleSuppDto.getSequence();
	}

	public Long getId() {
		return salesRuleSuppDto.getId();
	}

	public void setId(Long id) {
		salesRuleSuppDto.setId(id);
	}
	public String getUuid() {
		return salesRuleSuppDto.getUuid();
	}

	public void setUuid(String uuid) {
		salesRuleSuppDto.setUuid(uuid);
	}

	public Date getCreateTime() {
		return salesRuleSuppDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		salesRuleSuppDto.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return salesRuleSuppDto.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		salesRuleSuppDto.setUpdateTime(updateTime);
	}

	public String getDepartureAirportCodes() {
		return salesRuleSuppDto.getDepartureAirportCodes();
	}

	public void setDepartureAirportCodes(String departureAirportCodes) {
		salesRuleSuppDto.setDepartureAirportCodes(departureAirportCodes);
	}

	public String getArrivalAirportCodes() {
		return salesRuleSuppDto.getArrivalAirportCodes();
	}

	public void setArrivalAirportCodes(String arrivalAirportCodes) {
		salesRuleSuppDto.setArrivalAirportCodes(arrivalAirportCodes);
	}

	public String getCarrierCodes() {
		return salesRuleSuppDto.getCarrierCodes();
	}

	public void setCarrierCodes(String carrierCodes) {
		salesRuleSuppDto.setCarrierCodes(carrierCodes);
	}

	public String getSeatCodes() {
		return salesRuleSuppDto.getSeatCodes();
	}

	public void setSeatCodes(String seatCodes) {
		salesRuleSuppDto.setSeatCodes(seatCodes);
	}

	public String getIncludeFlightNos() {
		return salesRuleSuppDto.getIncludeFlightNos();
	}

	public void setIncludeFlightNos(String includeFlightNos) {
		salesRuleSuppDto.setIncludeFlightNos(includeFlightNos);
	}

	public String getWeekDays() {
		return salesRuleSuppDto.getWeekDays();
	}

	public void setWeekDays(String weekDays) {
		salesRuleSuppDto.setWeekDays(weekDays);
	}

	public Date getDepStartDate() {
		return salesRuleSuppDto.getDepStartDate();
	}

	public void setDepStartDate(Date depStartDate) {
		salesRuleSuppDto.setDepStartDate(depStartDate);
	}

	public Date getDepEndDate() {
		return salesRuleSuppDto.getDepEndDate();
	}

	public void setDepEndDate(Date depEndDate) {
		salesRuleSuppDto.setDepEndDate(depEndDate);
	}

	public Long getPriority() {
		return salesRuleSuppDto.getPriority();
	}

	public void setPriority(Long priority) {
		salesRuleSuppDto.setPriority(priority);
	}

	public Status getStatus() {
		return salesRuleSuppDto.getStatus();
	}

	public void setStatus(Status status) {
		salesRuleSuppDto.setStatus(status);
	}

	public Date getEffectDate() {
		return salesRuleSuppDto.getEffectDate();
	}

	public void setEffectDate(Date effectDate) {
		salesRuleSuppDto.setEffectDate(effectDate);
	}

	public VisibleStatus getVisibleStatus() {
		return salesRuleSuppDto.getVisibleStatus();
	}

	public void setVisibleStatus(VisibleStatus visibleStatus) {
		salesRuleSuppDto.setVisibleStatus(visibleStatus);
	}

	public Date getExpireDate() {
		return salesRuleSuppDto.getExpireDate();
	}

	public void setExpireDate(Date expireDate) {
		salesRuleSuppDto.setExpireDate(expireDate);
	}

	public String getExcludeFlightNos() {
		return salesRuleSuppDto.getExcludeFlightNos();
	}

	public void setExcludeFlightNos(String excludeFlightNos) {
		salesRuleSuppDto.setExcludeFlightNos(excludeFlightNos);
	}

	public PriceFormula getPriceFormula() {
		return salesRuleSuppDto.getPriceFormula();
	}

	public void setPriceFormula(PriceFormula priceFormula) {
		salesRuleSuppDto.setPriceFormula(priceFormula);
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
	
	public Long getDepartureStartDate() {
		return departureStartDate;
	}

	public void setDepartureStartDate(Long departureStartDate) {
		this.departureStartDate = departureStartDate;
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

	public Long getDepartureEndDate() {
		return departureEndDate;
	}

}
