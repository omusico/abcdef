package com.lvmama.lvf.common.form.sales;

import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.OpLog;
import com.lvmama.lvf.common.dto.enums.Status;
import com.lvmama.lvf.common.dto.sales.SalesRuleDisableDto;
import com.lvmama.lvf.common.dto.status.ActiveStatus;
import com.lvmama.lvf.common.dto.status.ActiveStatusEnum;
import com.lvmama.lvf.common.dto.status.EffectDates;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.StringUtil;

/**   
 * @Title: SalesRuleDisableForm.java 
 * @Package com.lvmama.lvf.business.sales.rule.disable.form 
 * @Description: TODO(..) 
 * @author Chase_lv
 * @date 2015年8月6日 下午8:13:04 
 */
public class SalesRuleDisableResponseForm implements Form {

	private SalesRuleDisableDto salesRuleDisableDto = new SalesRuleDisableDto();

	private final static String  UN_LIMITED = "不限";
	public SalesRuleDisableDto getSalesRuleDisableDto() {
		return salesRuleDisableDto;
	}

	public void setSalesRuleDisableDto(SalesRuleDisableDto salesRuleDisableDto) {
		this.salesRuleDisableDto = salesRuleDisableDto;
	}

	public String getSequence() {
		return salesRuleDisableDto.getSequence();
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
		if(StringUtil.isEmptyString(salesRuleDisableDto.getCarrierCode())){
			return UN_LIMITED;
		}
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

	public Boolean getEffect(Date date) {
		return salesRuleDisableDto.getEffect(date);
	}

	public Long getPriority() {
		return salesRuleDisableDto.getPriority();
	}

	public void setPriority(Long priority) {
		salesRuleDisableDto.setPriority(priority);
	}

	public String getDepartureCityCode() {
		if(StringUtil.isEmptyString(salesRuleDisableDto.getDepartureCityCode())){
			return UN_LIMITED;
		}
		return salesRuleDisableDto.getDepartureCityCode();
	}

	public boolean isActiveAndEffcet(Date date) {
		return salesRuleDisableDto.isActiveAndEffcet(date);
	}

	public void setDepartureCityCode(String departureCityCode) {
		salesRuleDisableDto.setDepartureCityCode(departureCityCode);
	}

	public String getArriveCityCode() {
		if(StringUtil.isEmptyString(salesRuleDisableDto.getArriveCityCode())){
			return UN_LIMITED;
		}
		return salesRuleDisableDto.getArriveCityCode();
	}

	public void setArriveCityCode(String arriveCityCode) {
		salesRuleDisableDto.setArriveCityCode(arriveCityCode);
	}

	public String getStatus() {
		return salesRuleDisableDto.getStatus().getCnName();
	}

	public void setStatus(Status status) {
		salesRuleDisableDto.setStatus(status);
	}

	public String getFlightNo() {
		if(StringUtil.isEmptyString(salesRuleDisableDto.getFlightNo())){
			return UN_LIMITED;
		}
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

	public ActiveStatus getActiveStatus() {
		return salesRuleDisableDto.getActiveStatus();
	}
	
	public ActiveStatusEnum getActiveStatusEnum(){
		if(salesRuleDisableDto.getActiveStatus()!=null){
			return salesRuleDisableDto.getActiveStatus().getActiveStatus();
		}
		return null; 
	}



	
}
