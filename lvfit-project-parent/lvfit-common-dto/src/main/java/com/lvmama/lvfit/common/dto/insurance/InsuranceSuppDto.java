package com.lvmama.lvfit.common.dto.insurance;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.InsuranceStatus;

/**
 * 
 * 供应商保单信息
 *
 */
public class InsuranceSuppDto extends Entity implements Serializable {

	private static final long serialVersionUID = 1848363666251903957L;

	/** 供应商保单状态*/
	private InsuranceStatus insuranceStatus;
	
	/** 退保时间*/
	private Date cancelDate;
	
	/** 保单号*/
	private String insuranceNo;
	
	/** 投保时间*/
	private Date insuredDate;
	
	/** 投保人*/
	private String insuredName;

	public InsuranceStatus getInsuranceStatus() {
		return insuranceStatus;
	}

	public void setInsuranceStatus(InsuranceStatus insuranceStatus) {
		this.insuranceStatus = insuranceStatus;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public String getInsuranceNo() {
		return insuranceNo;
	}

	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}

	public Date getInsuredDate() {
		return insuredDate;
	}

	public void setInsuredDate(Date insuredDate) {
		this.insuredDate = insuredDate;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	
}
