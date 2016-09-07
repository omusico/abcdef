package com.lvmama.lvf.common.form.insurance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.DefaultSupp;
import com.lvmama.lvf.common.dto.enums.SystemApi;
import com.lvmama.lvf.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvf.common.dto.md.InsuranceClass;
import com.lvmama.lvf.common.dto.supp.Supp;
import com.lvmama.lvf.common.form.Form;

public class InsuranceInfoResultForm implements Serializable, Form {

	private static final long serialVersionUID = -9136200917400881205L;

	private InsuranceInfoDto insuranceinfo;

	public InsuranceInfoDto getInsuranceinfo() {
		return insuranceinfo;
	}

	public void setInsuranceinfo(InsuranceInfoDto insuranceinfo) {
		this.insuranceinfo = insuranceinfo;
	}

	public PersistenceType getPtype() {
		return insuranceinfo.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		insuranceinfo.setPtype(ptype);
	}

	public String getSequence() {
		return insuranceinfo.getSequence();
	}

	public Long getId() {
		return insuranceinfo.getId();
	}

	public void setId(Long id) {
		insuranceinfo.setId(id);
	}

	public String getUuid() {
		return insuranceinfo.getUuid();
	}

	public void setUuid(String uuid) {
		insuranceinfo.setUuid(uuid);
	}

	public Date getCreateTime() {
		return insuranceinfo.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		insuranceinfo.setCreateTime(createTime);
	}

	public InsuranceClass getInsuranceClass() {
		return insuranceinfo.getInsuranceClass();
	}

	public Date getUpdateTime() {
		return insuranceinfo.getUpdateTime();
	}

	public void setInsuranceClass(InsuranceClass insuranceClass) {
		insuranceinfo.setInsuranceClass(insuranceClass);
	}

	public void setUpdateTime(Date updateTime) {
		insuranceinfo.setUpdateTime(updateTime);
	}

	public String getInsuranceLimit() {
		return insuranceinfo.getInsuranceLimit();
	}

	public void setInsuranceLimit(String insuranceLimit) {
		insuranceinfo.setInsuranceLimit(insuranceLimit);
	}

	public Supp getSupp() {
		return insuranceinfo.getSupp();
	}

	public void setSupp(Supp supp) {
		insuranceinfo.setSupp(supp);
	}

	public BigDecimal getInsurancePrice() {
		return insuranceinfo.getInsurancePrice();
	}

	public void setInsurancePrice(BigDecimal insurancePrice) {
		insuranceinfo.setInsurancePrice(insurancePrice);
	}

	public Integer getMinInsureNum() {
		return insuranceinfo.getMinInsureNum();
	}

	public void setMinInsureNum(Integer minInsureNum) {
		insuranceinfo.setMinInsureNum(minInsureNum);
	}

	public Integer getMaxInsureNum() {
		return insuranceinfo.getMaxInsureNum();
	}

	public void setMaxInsureNum(Integer maxInsureNum) {
		insuranceinfo.setMaxInsureNum(maxInsureNum);
	}

	public String getInsuranceDesc() {
		return insuranceinfo.getInsuranceDesc();
	}

	public void setInsuranceDesc(String insuranceDesc) {
		insuranceinfo.setInsuranceDesc(insuranceDesc);
	}

	public SystemApi getSystemApi() {
		return insuranceinfo.getSystemApi();
	}

	public void setSystemApi(SystemApi systemApi) {
		insuranceinfo.setSystemApi(systemApi);
	}

	public DefaultSupp getDefaultSupp() {
		return insuranceinfo.getDefaultSupp();
	}

	public void setDefaultSupp(DefaultSupp defaultSupp) {
		insuranceinfo.setDefaultSupp(defaultSupp);
	}

	public BigDecimal getSettleAccounts() {
		return insuranceinfo.getSettleAccounts();
	}

	public void setSettleAccounts(BigDecimal settleAccounts) {
		insuranceinfo.setSettleAccounts(settleAccounts);
	}
	
}
