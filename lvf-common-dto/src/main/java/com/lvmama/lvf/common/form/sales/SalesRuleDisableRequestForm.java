package com.lvmama.lvf.common.form.sales;

import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.OpLog;
import com.lvmama.lvf.common.dto.enums.Status;
import com.lvmama.lvf.common.dto.request.SalesRuleDisableRequest;
import com.lvmama.lvf.common.dto.sales.SalesRuleDisableDto;
import com.lvmama.lvf.common.dto.status.ActiveStatus;
import com.lvmama.lvf.common.dto.status.EffectDates;
import com.lvmama.lvf.common.form.Form;

/**   
 * @Title: SalesRuleDisableForm.java 
 * @Package com.lvmama.lvf.business.sales.rule.disable.form 
 * @Description: TODO(..) 
 * @author Chase_lv
 * @date 2015年8月6日 下午8:13:04 
 */
public class SalesRuleDisableRequestForm implements Form{

	
	private SalesRuleDisableRequest request = new SalesRuleDisableRequest();

	public ActiveStatus getActiveStatus() {
		return request.getActiveStatus();
	}

	public String getSequence() {
		return request.getSequence();
	}

	public void setActiveStatus(ActiveStatus activeStatus) {
    	if(request.getActiveStatus()==null){
    		request.setActiveStatus(new ActiveStatus());
    	}
		request.setActiveStatus(activeStatus);
	}

	public Long getId() {
		return request.getId();
	}

	public void setId(Long id) {
		request.setId(id);
	}

	public EffectDates getEffectDates() {
		return request.getEffectDates();
	}

	public void setEffectDates(EffectDates effectDates) {
		request.setEffectDates(effectDates);
	}

	public Date getCreateTime() {
		return request.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		request.setCreateTime(createTime);
	}

	public String getCarrierCode() {
		return request.getCarrierCode();
	}

	public void setCarrierCode(String carrierCode) {
		request.setCarrierCode(carrierCode);
	}

	public Long getPriority() {
		return request.getPriority();
	}

	public void setPriority(Long priority) {
		request.setPriority(priority);
	}

	public String getDepartureCityCode() {
		return request.getDepartureCityCode();
	}

	public void setDepartureCityCode(String departureCityCode) {
		request.setDepartureCityCode(departureCityCode);
	}

	public String getArriveCityCode() {
		return request.getArriveCityCode();
	}

	public void setArriveCityCode(String arriveCityCode) {
		request.setArriveCityCode(arriveCityCode);
	}

	public Status getStatus() {
		return request.getStatus();
	}

	public void setStatus(Status status) {
		request.setStatus(status);
	}

	public String getFlightNo() {
		return request.getFlightNo();
	}

	public void setFlightNo(String flightNo) {
		request.setFlightNo(flightNo);
	}

	public String getRemark() {
		return request.getRemark();
	}

	public void setRemark(String remark) {
		request.setRemark(remark);
	}

	public List<OpLog> getOpLogs() {
		return request.getOpLogs();
	}

	public void setOpLogs(List<OpLog> opLogs) {
		request.setOpLogs(opLogs);
	}

	public Long getLeadTime() {
		return request.getLeadTime();
	}

	public void setLeadTime(Long leadTime) {
		request.setLeadTime(leadTime);
	}

	public SalesRuleDisableDto getSalesRuleDisableDto() {
		return request.getSalesRuleDisableDto();
	}

	public void setSalesRuleDisableDto(SalesRuleDisableDto salesRuleDisableDto) {
		request.setSalesRuleDisableDto(salesRuleDisableDto);
	}

	public SalesRuleDisableRequest getRequest() {
		return request;
	}

	public void setRequest(SalesRuleDisableRequest request) {
		this.request = request;
	}

	public String getStartCreateDate() {
		return request.getStartCreateDate();
	}

	public void setStartCreateDate(String startCreateDate) {
		request.setStartCreateDate(startCreateDate);
	}

	public String getEndCreateDate() {
		return request.getEndCreateDate();
	}

	public void setEndCreateDate(String endCreateDate) {
		request.setEndCreateDate(endCreateDate);
	}

	public String getStartUpdateDate() {
		return request.getStartUpdateDate();
	}

	public void setStartUpdateDate(String startUpdateDate) {
		request.setStartUpdateDate(startUpdateDate);
	}

	public String getEndUpdateDate() {
		return request.getEndUpdateDate();
	}

	public void setEndUpdateDate(String endUpdateDate) {
		request.setEndUpdateDate(endUpdateDate);
	} 

	
}
