package com.lvmama.lvf.common.dto.adapter.request.insurance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.Gender;
import com.lvmama.lvf.common.dto.enums.IDCardType;
import com.lvmama.lvf.common.dto.enums.InsuranceStatus;
import com.lvmama.lvf.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvf.common.dto.insurance.InsuranceOrderDto;

/**
 * 合众保险请求
 * @author lven
 *
 */
@XmlRootElement
public class FlightInsuranceRequest  implements Serializable, Dto{

	private static final long serialVersionUID = -7255062980486501646L;
	
	/*
	 * 投保起始查询时间
	 */
	private String startInsureDate;
	
	/*
	 * 投保结束查询时间
	 */
	private String endInsureDate;
	
	/*
	 * 废保起始查询时间
	 */
	private String startHesitateDate;
	
	/*
	 * 废保结束查询时间
	 */
	private String endHesitateDate;
	
	/*
	 * 投保起始查询时间
	 */
	private String startEffectDate;
	
	/*
	 * 投保结束查询时间
	 */
	private String endEffectDate;
	
	/**描述*/
	private String desc;
	
	private String insuranceClassName;
	
	/** 订单保险信息*/
	private InsuranceOrderDto insuranceOrderDto = new InsuranceOrderDto();
	
	private String insSuppCode;
	
	/**适用产品类型*/
	private String productTypes;

	public String getInsSuppCode() {
		return insSuppCode;
	}

	public void setInsSuppCode(String insSuppCode) {
		this.insSuppCode = insSuppCode;
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

	public boolean equals(Object obj) {
		return insuranceOrderDto.equals(obj);
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

	public InsuranceOrderDto getInsuranceOrderDto() {
		return insuranceOrderDto;
	}

	public void setInsuranceOrderDto(InsuranceOrderDto insuranceOrderDto) {
		this.insuranceOrderDto = insuranceOrderDto;
	}

	public void setUuid(String uuid) {
		insuranceOrderDto.setUuid(uuid);
	}

	public String getStartInsureDate() {
		return startInsureDate;
	}

	public void setStartInsureDate(String startInsureDate) {
		this.startInsureDate = startInsureDate;
	}

	public String getEndInsureDate() {
		return endInsureDate;
	}

	public void setEndInsureDate(String endInsureDate) {
		this.endInsureDate = endInsureDate;
	}

	public String getStartEffectDate() {
		return startEffectDate;
	}

	public void setStartEffectDate(String startEffectDate) {
		this.startEffectDate = startEffectDate;
	}

	public String getEndEffectDate() {
		return endEffectDate;
	}

	public void setEndEffectDate(String endEffectDate) {
		this.endEffectDate = endEffectDate;
	}

	public String getOrderNo() {
		return insuranceOrderDto.getOrderNo();
	}

	public void setOrderNo(String orderNo) {
		insuranceOrderDto.setOrderNo(orderNo);
	}
	
	public Long getOrderId() {
		return insuranceOrderDto.getOrderId();
	}

	public void setOrderId(Long orderId) {
		insuranceOrderDto.setOrderId(orderId);
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCellphone() {
		return insuranceOrderDto.getCellphone();
	}

	public void setCellphone(String cellphone) {
		insuranceOrderDto.setCellphone(cellphone);
	}

	public String getStartHesitateDate() {
		return startHesitateDate;
	}

	public void setStartHesitateDate(String startHesitateDate) {
		this.startHesitateDate = startHesitateDate;
	}

	public String getEndHesitateDate() {
		return endHesitateDate;
	}

	public void setEndHesitateDate(String endHesitateDate) {
		this.endHesitateDate = endHesitateDate;
	}

	public String getInsuranceClassName() {
		return insuranceClassName;
	}

	public void setInsuranceClassName(String insuranceClassName) {
		this.insuranceClassName = insuranceClassName;
	}

	public String getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(String productTypes) {
		this.productTypes = productTypes;
	}
}
