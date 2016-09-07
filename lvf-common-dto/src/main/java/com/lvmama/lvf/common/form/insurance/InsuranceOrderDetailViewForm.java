package com.lvmama.lvf.common.form.insurance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.Gender;
import com.lvmama.lvf.common.dto.enums.IDCardType;
import com.lvmama.lvf.common.dto.enums.InsuranceStatus;
import com.lvmama.lvf.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvf.common.dto.insurance.InsuranceOrderDto;
import com.lvmama.lvf.common.form.Form;

/**
 * 保单列表信息
 * 
 */
public class InsuranceOrderDetailViewForm implements Serializable, Form {

	private static final long serialVersionUID = -497004369732607641L;
	
	private InsuranceOrderDto insuranceOrderDto = new InsuranceOrderDto();

	public InsuranceOrderDto getInsuranceOrderDto() {
		return insuranceOrderDto;
	}

	public void setInsuranceOrderDto(InsuranceOrderDto insuranceOrderDto) {
		this.insuranceOrderDto = insuranceOrderDto;
	}

	public PersistenceType getPtype() {
		return insuranceOrderDto.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		insuranceOrderDto.setPtype(ptype);
	}

	public String getSequence() {
		return insuranceOrderDto.getSequence();
	}

	public Long getId() {
		return insuranceOrderDto.getId();
	}

	public void setId(Long id) {
		insuranceOrderDto.setId(id);
	}

	public String getUuid() {
		return insuranceOrderDto.getUuid();
	}

	public void setUuid(String uuid) {
		insuranceOrderDto.setUuid(uuid);
	}

	public Date getCreateTime() {
		return insuranceOrderDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		insuranceOrderDto.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return insuranceOrderDto.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		insuranceOrderDto.setUpdateTime(updateTime);
	}

	public String getInsuranceNo() {
		return insuranceOrderDto.getInsuranceNo();
	}

	public void setInsuranceNo(String insuranceNo) {
		insuranceOrderDto.setInsuranceNo(insuranceNo);
	}

	public String getTicketNo() {
		return insuranceOrderDto.getTicketNo();
	}

	public void setTicketNo(String ticketNo) {
		insuranceOrderDto.setTicketNo(ticketNo);
	}

	public Date getInsureDate() {
		return insuranceOrderDto.getInsureDate();
	}

	public void setInsureDate(Date insureDate) {
		insuranceOrderDto.setInsureDate(insureDate);
	}

	public Gender getGender() {
		return insuranceOrderDto.getGender();
	}

	public void setGender(Gender gender) {
		insuranceOrderDto.setGender(gender);
	}

	public InsuranceStatus getInsuranceStatus() {
		return insuranceOrderDto.getInsuranceStatus();
	}

	public void setInsuranceStatus(InsuranceStatus insuranceStatus) {
		insuranceOrderDto.setInsuranceStatus(insuranceStatus);
	}

	public String getInsuredName() {
		return insuranceOrderDto.getInsuredName();
	}

	public void setInsuredName(String insuredName) {
		insuranceOrderDto.setInsuredName(insuredName);
	}

	public InsuranceInfoDto getInsuranceInfoDto() {
		return insuranceOrderDto.getInsuranceInfoDto();
	}

	public void setInsuranceInfoDto(InsuranceInfoDto insuranceInfoDto) {
		insuranceOrderDto.setInsuranceInfoDto(insuranceInfoDto);
	}

	public Date getBirthday() {
		return insuranceOrderDto.getBirthday();
	}

	public void setBirthday(Date birthday) {
		insuranceOrderDto.setBirthday(birthday);
	}

	public Date getEffectDate() {
		return insuranceOrderDto.getEffectDate();
	}

	public void setEffectDate(Date effectDate) {
		insuranceOrderDto.setEffectDate(effectDate);
	}

	public Date getExpireDate() {
		return insuranceOrderDto.getExpireDate();
	}

	public void setExpireDate(Date expireDate) {
		insuranceOrderDto.setExpireDate(expireDate);
	}

	public IDCardType getIdCardType() {
		return insuranceOrderDto.getIdCardType();
	}

	public void setIdCardType(IDCardType idCardType) {
		insuranceOrderDto.setIdCardType(idCardType);
	}

	public String getIdCardNo() {
		return insuranceOrderDto.getIdCardNo();
	}

	public void setIdCardNo(String idCardNo) {
		insuranceOrderDto.setIdCardNo(idCardNo);
	}

	public String getFlightNo() {
		return insuranceOrderDto.getFlightNo();
	}

	public void setFlightNo(String flightNo) {
		insuranceOrderDto.setFlightNo(flightNo);
	}

	public String getInsuranceOrderNo() {
		return insuranceOrderDto.getInsuranceOrderNo();
	}

	public void setInsuranceOrderNo(String insuranceOrderNo) {
		insuranceOrderDto.setInsuranceOrderNo(insuranceOrderNo);
	}

	public Integer getInsuredNum() {
		return insuranceOrderDto.getInsuredNum();
	}

	public void setInsuredNum(Integer insuredNum) {
		insuranceOrderDto.setInsuredNum(insuredNum);
	}

	public BigDecimal getSettleAccounts() {
		return insuranceOrderDto.getSettleAccounts();
	}

	public void setSettleAccounts(BigDecimal settleAccounts) {
		insuranceOrderDto.setSettleAccounts(settleAccounts);
	}

	public String getEmail() {
		return insuranceOrderDto.getEmail();
	}

	public void setEmail(String email) {
		insuranceOrderDto.setEmail(email);
	}
	
}
