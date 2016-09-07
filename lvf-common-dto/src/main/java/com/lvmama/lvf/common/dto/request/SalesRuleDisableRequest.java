package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.OpLog;
import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.Status;
import com.lvmama.lvf.common.dto.sales.SalesRuleDisableDto;
import com.lvmama.lvf.common.dto.status.ActiveStatus;
import com.lvmama.lvf.common.dto.status.EffectDates;

/**
 * @Title: SalesRuleDisableRequest.java
 * @Package com.lvmama.lvf.common.dto.request
 * @Description: 禁售规则请求
 * @author Chase_lv
 * @date 2015年8月6日 下午2:59:35
 */
public class SalesRuleDisableRequest implements Serializable, Dto {

	private static final long serialVersionUID = 8413880132513222995L;

	private SalesRuleDisableDto salesRuleDisableDto = new SalesRuleDisableDto();

	/** 录入开始时间 */
	private String startCreateDate;
	/** 录入结束时间 */
	private String endCreateDate;

	/** 最后维护开始时间 */
	private String startUpdateDate;

	/** 最后维护结束时间 */
	private String endUpdateDate;

	public ActiveStatus getActiveStatus() {
		return salesRuleDisableDto.getActiveStatus();
	}

	public String getSequence() {
		return salesRuleDisableDto.getSequence();
	}

	public void setActiveStatus(ActiveStatus activeStatus) {
		salesRuleDisableDto.setActiveStatus(activeStatus);
	}

	public Long getId() {
		return salesRuleDisableDto.getId();
	}

	public void setId(Long id) {
		salesRuleDisableDto.setId(id);
	}

	public EffectDates getEffectDates() {
		return salesRuleDisableDto.getEffectDates();
	}

	public void setEffectDates(EffectDates effectDates) {
		salesRuleDisableDto.setEffectDates(effectDates);
	}

	public Date getCreateTime() {
		return salesRuleDisableDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		salesRuleDisableDto.setCreateTime(createTime);
	}

	public String getCarrierCode() {
		return salesRuleDisableDto.getCarrierCode();
	}

	public Date getUpdateTime() {
		return salesRuleDisableDto.getUpdateTime();
	}

	public void setCarrierCode(String carrierCode) {
		salesRuleDisableDto.setCarrierCode(carrierCode);
	}

	public void setUpdateTime(Date updateTime) {
		salesRuleDisableDto.setUpdateTime(updateTime);
	}

	public Long getPriority() {
		return salesRuleDisableDto.getPriority();
	}

	public void setPriority(Long priority) {
		salesRuleDisableDto.setPriority(priority);
	}

	public String getDepartureCityCode() {
		return salesRuleDisableDto.getDepartureCityCode();
	}

	public void setDepartureCityCode(String departureCityCode) {
		salesRuleDisableDto.setDepartureCityCode(departureCityCode);
	}

	public String getArriveCityCode() {
		return salesRuleDisableDto.getArriveCityCode();
	}

	public void setArriveCityCode(String arriveCityCode) {
		salesRuleDisableDto.setArriveCityCode(arriveCityCode);
	}

	public Status getStatus() {
		return salesRuleDisableDto.getStatus();
	}

	public void setStatus(Status status) {
		salesRuleDisableDto.setStatus(status);
	}

	public String getFlightNo() {
		return salesRuleDisableDto.getFlightNo();
	}

	public void setFlightNo(String flightNo) {
		salesRuleDisableDto.setFlightNo(flightNo);
	}

	public String getRemark() {
		return salesRuleDisableDto.getRemark();
	}

	public void setRemark(String remark) {
		salesRuleDisableDto.setRemark(remark);
	}

	public List<OpLog> getOpLogs() {
		return salesRuleDisableDto.getOpLogs();
	}

	public void setOpLogs(List<OpLog> opLogs) {
		salesRuleDisableDto.setOpLogs(opLogs);
	}

	public Long getLeadTime() {
		return salesRuleDisableDto.getLeadTime();
	}

	public void setLeadTime(Long leadTime) {
		salesRuleDisableDto.setLeadTime(leadTime);
	}

	public SalesRuleDisableDto getSalesRuleDisableDto() {
		if (null == salesRuleDisableDto.getActiveStatus()) {
			salesRuleDisableDto.setActiveStatus(new ActiveStatus());
		}
		return salesRuleDisableDto;
	}

	public void setSalesRuleDisableDto(SalesRuleDisableDto salesRuleDisableDto) {
		this.salesRuleDisableDto = salesRuleDisableDto;
	}

	public String getStartCreateDate() {
		return startCreateDate;
	}

	public void setStartCreateDate(String startCreateDate) {
		this.startCreateDate = startCreateDate;
	}

	public String getEndCreateDate() {
		return endCreateDate;
	}

	public void setEndCreateDate(String endCreateDate) {
		this.endCreateDate = endCreateDate;
	}

	public String getStartUpdateDate() {
		return startUpdateDate;
	}

	public void setStartUpdateDate(String startUpdateDate) {
		this.startUpdateDate = startUpdateDate;
	}

	public String getEndUpdateDate() {
		return endUpdateDate;
	}

	public void setEndUpdateDate(String endUpdateDate) {
		this.endUpdateDate = endUpdateDate;
	}

	public SalesRuleDisableRequest queryRequest(SalesRuleDisableRequest request) {
		// 如果有效性为空的话，默认查询合法的
		if (null == request.getStatus()) {
			request.setStatus(Status.VALID);
		}
		return request;
	}

	public SalesRuleDisableRequest saveRequest(SalesRuleDisableRequest request) {
		// 如果有效性为空的话，保存时默认为不合法
		if (null == request.getStatus()) {
			request.setStatus(Status.INVALID);
		}
		return request;
	}

}
