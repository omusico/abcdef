package com.lvmama.lvf.common.dto.adapter.request.insurance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.DefaultRule;
import com.lvmama.lvf.common.dto.enums.DefaultSupp;
import com.lvmama.lvf.common.dto.enums.InsuranceType;
import com.lvmama.lvf.common.dto.enums.Status;
import com.lvmama.lvf.common.dto.enums.SystemApi;
import com.lvmama.lvf.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvf.common.dto.md.InsuranceClass;
import com.lvmama.lvf.common.dto.supp.Supp;

/**
 * 
 *
 */
public class InsuranceInfoRequest  implements Serializable , Dto{

	private static final long serialVersionUID = -4855561054305781138L;
	
	private InsuranceInfoDto insuranceInfoDto = new InsuranceInfoDto();
	
	private String startUpdateTime;
	
	private String endUpdateTime;

	public InsuranceInfoDto getInsuranceInfoDto() {
		return insuranceInfoDto;
	}

	public void setInsuranceInfoDto(InsuranceInfoDto insuranceInfoDto) {
		this.insuranceInfoDto = insuranceInfoDto;
	}

	public PersistenceType getPtype() {
		return insuranceInfoDto.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		insuranceInfoDto.setPtype(ptype);
	}

	@JsonIgnore
	public String getSequence() {
		return insuranceInfoDto.getSequence();
	}

	public Long getId() {
		return insuranceInfoDto.getId();
	}

	public void setId(Long id) {
		insuranceInfoDto.setId(id);
	}

	public String getUuid() {
		return insuranceInfoDto.getUuid();
	}

	public void setUuid(String uuid) {
		insuranceInfoDto.setUuid(uuid);
	}

	public Date getCreateTime() {
		return insuranceInfoDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		insuranceInfoDto.setCreateTime(createTime);
	}

	public InsuranceClass getInsuranceClass() {
		return insuranceInfoDto.getInsuranceClass();
	}

	public Date getUpdateTime() {
		return insuranceInfoDto.getUpdateTime();
	}

	public void setInsuranceClass(InsuranceClass insuranceClass) {
		insuranceInfoDto.setInsuranceClass(insuranceClass);
	}

	public void setUpdateTime(Date updateTime) {
		insuranceInfoDto.setUpdateTime(updateTime);
	}

	public String getInsuranceLimit() {
		return insuranceInfoDto.getInsuranceLimit();
	}

	public void setInsuranceLimit(String insuranceLimit) {
		insuranceInfoDto.setInsuranceLimit(insuranceLimit);
	}

	public Supp getSupp() {
		return insuranceInfoDto.getSupp();
	}

	public void setSupp(Supp supp) {
		insuranceInfoDto.setSupp(supp);
	}

	public BigDecimal getInsurancePrice() {
		return insuranceInfoDto.getInsurancePrice();
	}

	public void setInsurancePrice(BigDecimal insurancePrice) {
		insuranceInfoDto.setInsurancePrice(insurancePrice);
	}

	public Integer getMinInsureNum() {
		return insuranceInfoDto.getMinInsureNum();
	}

	public void setMinInsureNum(Integer minInsureNum) {
		insuranceInfoDto.setMinInsureNum(minInsureNum);
	}

	public Integer getMaxInsureNum() {
		return insuranceInfoDto.getMaxInsureNum();
	}

	public void setMaxInsureNum(Integer maxInsureNum) {
		insuranceInfoDto.setMaxInsureNum(maxInsureNum);
	}

	public String getInsuranceDesc() {
		return insuranceInfoDto.getInsuranceDesc();
	}

	public void setInsuranceDesc(String insuranceDesc) {
		insuranceInfoDto.setInsuranceDesc(insuranceDesc);
	}

	public SystemApi getSystemApi() {
		return insuranceInfoDto.getSystemApi();
	}

	public void setSystemApi(SystemApi systemApi) {
		insuranceInfoDto.setSystemApi(systemApi);
	}

	public DefaultSupp getDefaultSupp() {
		return insuranceInfoDto.getDefaultSupp();
	}

	public void setDefaultSupp(DefaultSupp defaultSupp) {
		insuranceInfoDto.setDefaultSupp(defaultSupp);
	}

	public BigDecimal getSettleAccounts() {
		return insuranceInfoDto.getSettleAccounts();
	}

	public void setSettleAccounts(BigDecimal settleAccounts) {
		insuranceInfoDto.setSettleAccounts(settleAccounts);
	}
	
	public Status getStatus() {
		return insuranceInfoDto.getStatus();
	}

	public void setStatus(Status status) {
		insuranceInfoDto.setStatus(status);
	}

	public String getStartUpdateTime() {
		return startUpdateTime;
	}

	public void setStartUpdateTime(String startUpdateTime) {
		this.startUpdateTime = startUpdateTime;
	}

	public String getEndUpdateTime() {
		return endUpdateTime;
	}

	public void setEndUpdateTime(String endUpdateTime) {
		this.endUpdateTime = endUpdateTime;
	}

	public String getInsuranceRemark() {
		return insuranceInfoDto.getInsuranceRemark();
	}

	public void setInsuranceRemark(String insuranceRemark) {
		insuranceInfoDto.setInsuranceRemark(insuranceRemark);
	}

	public String getProductTypes() {
		return insuranceInfoDto.getProductTypes();
	}

	public void setProductTypes(String productTypes) {
		insuranceInfoDto.setProductTypes(productTypes);
	}

	public InsuranceType getInsuranceType() {
		return insuranceInfoDto.getInsuranceType();
	}

	public void setInsuranceType(InsuranceType insuranceType) {
		insuranceInfoDto.setInsuranceType(insuranceType);
	}

	public BigDecimal getCostPrice() {
		return insuranceInfoDto.getCostPrice();
	}

	public void setCostPrice(BigDecimal costPrice) {
		insuranceInfoDto.setCostPrice(costPrice);
	}

	public DefaultRule getDefaultRule() {
		return insuranceInfoDto.getDefaultRule();
	}

	public void setDefaultRule(DefaultRule defaultRule) {
		insuranceInfoDto.setDefaultRule(defaultRule);
	}
	
}
