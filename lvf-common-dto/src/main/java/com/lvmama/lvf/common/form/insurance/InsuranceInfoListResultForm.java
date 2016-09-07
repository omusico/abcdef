package com.lvmama.lvf.common.form.insurance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.DefaultRule;
import com.lvmama.lvf.common.dto.enums.DefaultSupp;
import com.lvmama.lvf.common.dto.enums.InsuranceType;
import com.lvmama.lvf.common.dto.enums.Product;
import com.lvmama.lvf.common.dto.enums.Status;
import com.lvmama.lvf.common.dto.enums.SystemApi;
import com.lvmama.lvf.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvf.common.dto.md.InsuranceClass;
import com.lvmama.lvf.common.dto.supp.Supp;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

/**
 * 保单列表信息
 * 
 */
public class InsuranceInfoListResultForm implements Serializable, Form {

	private static final long serialVersionUID = 4789033556355767461L;
	
	private InsuranceInfoDto insuranceInfoDto;
	
	private String updateDate;
	
	private String insStatus;
	
	private String productStr;
	
	private String insuranceTypeStr;
	
	private String defaultProductStr;

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

	public Date getUpdateTime() {
		return insuranceInfoDto.getUpdateTime();
	}

	public InsuranceClass getInsuranceClass() {
		return insuranceInfoDto.getInsuranceClass();
	}

	public void setUpdateTime(Date updateTime) {
		insuranceInfoDto.setUpdateTime(updateTime);
	}

	public void setInsuranceClass(InsuranceClass insuranceClass) {
		insuranceInfoDto.setInsuranceClass(insuranceClass);
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

	public String getUpdateDate() {
		if (null != this.insuranceInfoDto.getUpdateTime()) {
			this.updateDate = DateUtils.formatCnHmDate(this.insuranceInfoDto.getUpdateTime());
		}
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getInsStatus() {
		if (null !=this.insuranceInfoDto.getStatus()) {
			this.insStatus = this.insuranceInfoDto.getStatus().getCnName();
		}
		return insStatus;
	}

	public void setInsStatus(String insStatus) {
		this.insStatus = insStatus;
	}

	public String getProductStr() {
		String productNameStr = "";
		if (null != this.insuranceInfoDto && null != this.insuranceInfoDto.getProductTypes()) {
			String [] productStr = this.insuranceInfoDto.getProductTypes().split(",");
			for (int i = 0; i < productStr.length; i++) {
				productNameStr = Product.valueOf(productStr[i]).getCnName();
				if (i==0) {
					this.productStr = productNameStr;
				}else {
					this.productStr = this.productStr + " , " + productNameStr;
				}
				
			}
		}
		return productStr;
	}

	public void setProductStr(String productStr) {
		this.productStr = productStr;
	}

	public String getInsuranceTypeStr() {
		if (null != this.insuranceInfoDto && null != this.insuranceInfoDto.getInsuranceType()) {
			this.insuranceTypeStr = this.insuranceInfoDto.getInsuranceType().getCnName();
		}
		return insuranceTypeStr;
	}

	public void setInsuranceTypeStr(String insuranceTypeStr) {
		this.insuranceTypeStr = insuranceTypeStr;
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

	public String getDefaultProductStr() {
		if (null != this.insuranceInfoDto && null != this.insuranceInfoDto.getDefaultRule()) {
			this.defaultProductStr = this.insuranceInfoDto.getDefaultRule().getCnName();
		}
		return defaultProductStr;
	}

	public void setDefaultProductStr(String defaultProductStr) {
		this.defaultProductStr = defaultProductStr;
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
	
}
