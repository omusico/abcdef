package com.lvmama.lvf.common.form.insurance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.adapter.request.insurance.InsuranceInfoRequest;
import com.lvmama.lvf.common.dto.enums.DefaultRule;
import com.lvmama.lvf.common.dto.enums.DefaultSupp;
import com.lvmama.lvf.common.dto.enums.InsuranceType;
import com.lvmama.lvf.common.dto.enums.Status;
import com.lvmama.lvf.common.dto.enums.SystemApi;
import com.lvmama.lvf.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvf.common.dto.md.InsuranceClass;
import com.lvmama.lvf.common.dto.supp.Supp;
import com.lvmama.lvf.common.form.Form;

/**
 * 保单列表信息
 * 
 */
public class InsuranceInfoInputForm implements Serializable, Form {

	private static final long serialVersionUID = -819238834106917964L;

	private InsuranceInfoRequest request = new InsuranceInfoRequest();

	public Status getStatus() {
		return request.getStatus();
	}

	public void setStatus(Status status) {
		request.setStatus(status);
	}

	public String getStartUpdateTime() {
		return request.getStartUpdateTime();
	}

	public void setStartUpdateTime(String startUpdateTime) {
		request.setStartUpdateTime(startUpdateTime);
	}

	public String getEndUpdateTime() {
		return request.getEndUpdateTime();
	}

	public void setEndUpdateTime(String endUpdateTime) {
		request.setEndUpdateTime(endUpdateTime);
	}

	public String getInsuranceRemark() {
		return request.getInsuranceRemark();
	}

	public void setInsuranceRemark(String insuranceRemark) {
		request.setInsuranceRemark(insuranceRemark);
	}

	public String getProductTypes() {
		return request.getProductTypes();
	}

	public void setProductTypes(String productTypes) {
		request.setProductTypes(productTypes);
	}

	public InsuranceType getInsuranceType() {
		return request.getInsuranceType();
	}

	public void setInsuranceType(InsuranceType insuranceType) {
		request.setInsuranceType(insuranceType);
	}

	public InsuranceInfoRequest getRequest() {
		return request;
	}

	public void setRequest(InsuranceInfoRequest request) {
		this.request = request;
	}

	public InsuranceInfoDto getInsuranceInfoDto() {
		return request.getInsuranceInfoDto();
	}

	public void setInsuranceInfoDto(InsuranceInfoDto insuranceInfoDto) {
		request.setInsuranceInfoDto(insuranceInfoDto);
	}

	public PersistenceType getPtype() {
		return request.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		request.setPtype(ptype);
	}

	public String getSequence() {
		return request.getSequence();
	}

	public Long getId() {
		return request.getId();
	}

	public void setId(Long id) {
		request.setId(id);
	}

	public String getUuid() {
		return request.getUuid();
	}

	public void setUuid(String uuid) {
		request.setUuid(uuid);
	}

	public Date getCreateTime() {
		return request.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		request.setCreateTime(createTime);
	}

	public InsuranceClass getInsuranceClass() {
		return request.getInsuranceClass();
	}

	public Date getUpdateTime() {
		return request.getUpdateTime();
	}

	public void setInsuranceClass(InsuranceClass insuranceClass) {
		request.setInsuranceClass(insuranceClass);
	}

	public void setUpdateTime(Date updateTime) {
		request.setUpdateTime(updateTime);
	}

	public String getInsuranceLimit() {
		return request.getInsuranceLimit();
	}

	public void setInsuranceLimit(String insuranceLimit) {
		request.setInsuranceLimit(insuranceLimit);
	}

	public Supp getSupp() {
		return request.getSupp();
	}

	public void setSupp(Supp supp) {
		request.setSupp(supp);
	}

	public BigDecimal getInsurancePrice() {
		return request.getInsurancePrice();
	}

	public void setInsurancePrice(BigDecimal insurancePrice) {
		request.setInsurancePrice(insurancePrice);
	}

	public Integer getMinInsureNum() {
		return request.getMinInsureNum();
	}

	public void setMinInsureNum(Integer minInsureNum) {
		request.setMinInsureNum(minInsureNum);
	}

	public Integer getMaxInsureNum() {
		return request.getMaxInsureNum();
	}

	public void setMaxInsureNum(Integer maxInsureNum) {
		request.setMaxInsureNum(maxInsureNum);
	}

	public String getInsuranceDesc() {
		return request.getInsuranceDesc();
	}

	public void setInsuranceDesc(String insuranceDesc) {
		request.setInsuranceDesc(insuranceDesc);
	}

	public SystemApi getSystemApi() {
		return request.getSystemApi();
	}

	public void setSystemApi(SystemApi systemApi) {
		request.setSystemApi(systemApi);
	}

	public DefaultSupp getDefaultSupp() {
		return request.getDefaultSupp();
	}

	public void setDefaultSupp(DefaultSupp defaultSupp) {
		request.setDefaultSupp(defaultSupp);
	}

	public BigDecimal getSettleAccounts() {
		return request.getSettleAccounts();
	}

	public void setSettleAccounts(BigDecimal settleAccounts) {
		request.setSettleAccounts(settleAccounts);
	}

	public BigDecimal getCostPrice() {
		return request.getCostPrice();
	}

	public void setCostPrice(BigDecimal costPrice) {
		request.setCostPrice(costPrice);
	}

	public DefaultRule getDefaultRule() {
		return request.getDefaultRule();
	}

	public void setDefaultRule(DefaultRule defaultRule) {
		request.setDefaultRule(defaultRule);
	}
	
}
