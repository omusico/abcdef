package com.lvmama.lvf.common.dto.sales;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.Status;
import com.lvmama.lvf.common.dto.enums.VisibleStatus;

/**
 * 调控
 * @author hedandan
 *
 */
public class SalesRuleBase extends Entity implements Serializable {

	private static final long serialVersionUID = -3898858351085368333L;

	/**起飞机场*/
	private String departureAirportCodes;
	
	/**到达机场*/
	private String arrivalAirportCodes;
	
	/**航空公司*/
	private String carrierCodes;
	
	/**适用舱位*/
	private String seatCodes;
	
	/**适用航班*/
	private String includeFlightNos;
	
	/**不适用航班*/
	private String excludeFlightNos;
	
	/**适用班期*/
	private String weekDays;
	
	/**航班日期(适用航班开始时间)*/
	private Date depStartDate; 
	
	/**航班日期(适用航班结束时间)*/
	private Date depEndDate; 
	
	/**有效日期*/
	private Date effectDate;
	
	/**到期日期*/
	private Date expireDate;
	
	/**优先级别（0~2）*/
	private Long priority;
	
	/**是否有效*/
	private Status status;
	
	private VisibleStatus visibleStatus = VisibleStatus.VISIBLE;

	public String getDepartureAirportCodes() {
		return departureAirportCodes;
	}

	public void setDepartureAirportCodes(String departureAirportCodes) {
		this.departureAirportCodes = departureAirportCodes;
	}

	public String getArrivalAirportCodes() {
		return arrivalAirportCodes;
	}

	public void setArrivalAirportCodes(String arrivalAirportCodes) {
		this.arrivalAirportCodes = arrivalAirportCodes;
	}

	public String getCarrierCodes() {
		return carrierCodes;
	}

	public void setCarrierCodes(String carrierCodes) {
		this.carrierCodes = carrierCodes;
	}

	public String getSeatCodes() {
		return seatCodes;
	}

	public void setSeatCodes(String seatCodes) {
		this.seatCodes = seatCodes;
	}

	public String getIncludeFlightNos() {
		return includeFlightNos;
	}

	public void setIncludeFlightNos(String includeFlightNos) {
		this.includeFlightNos = includeFlightNos;
	}

	public String getWeekDays() {
		return weekDays;
	}

	public void setWeekDays(String weekDays) {
		this.weekDays = weekDays;
	}

	public Date getDepStartDate() {
		return depStartDate;
	}

	public void setDepStartDate(Date depStartDate) {
		this.depStartDate = depStartDate;
	}

	public Date getDepEndDate() {
		return depEndDate;
	}

	public void setDepEndDate(Date depEndDate) {
		this.depEndDate = depEndDate;
	}

	public Long getPriority() {
		return priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getEffectDate() {
		return effectDate;
	}

	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}

	public VisibleStatus getVisibleStatus() {
		return visibleStatus;
	}

	public void setVisibleStatus(VisibleStatus visibleStatus) {
		this.visibleStatus = visibleStatus;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getExcludeFlightNos() {
		return excludeFlightNos;
	}

	public void setExcludeFlightNos(String excludeFlightNos) {
		this.excludeFlightNos = excludeFlightNos;
	}

}
