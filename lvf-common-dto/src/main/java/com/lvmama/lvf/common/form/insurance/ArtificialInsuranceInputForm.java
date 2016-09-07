package com.lvmama.lvf.common.form.insurance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.adapter.request.insurance.InsuranceOrderRequest;
import com.lvmama.lvf.common.dto.insurance.InsuranceOrderDto;
import com.lvmama.lvf.common.dto.md.InsuranceClass;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderInsuranceDto;
import com.lvmama.lvf.common.form.Form;

/**
 * 保单列表信息
 * 
 */
public class ArtificialInsuranceInputForm implements Serializable, Form {

	private static final long serialVersionUID = -8217692502220479791L;
	
	private InsuranceOrderRequest request = new InsuranceOrderRequest();

	public InsuranceOrderRequest getRequest() {
		return request;
	}

	public void setRequest(InsuranceOrderRequest request) {
		this.request = request;
	}

	public FlightOrderInsuranceDto getFlightOrderInsuranceDto() {
		return request.getFlightOrderInsuranceDto();
	}

	public void setFlightOrderInsuranceDto(
			FlightOrderInsuranceDto flightOrderInsuranceDto) {
		request.setFlightOrderInsuranceDto(flightOrderInsuranceDto);
	}

	public PersistenceType getPtype() {
		return request.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		request.setPtype(ptype);
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

	public Date getUpdateTime() {
		return request.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		request.setUpdateTime(updateTime);
	}



	public String getFlightNo() {
		return request.getFlightNo();
	}

	public void setFlightNo(String flightNo) {
		request.setFlightNo(flightNo);
	}

	public Long getInsuranceInfoId() {
		return request.getInsuranceInfoId();
	}

	public void setInsuranceInfoId(Long insuranceInfoId) {
		request.setInsuranceInfoId(insuranceInfoId);
	}

	public Long getOrderMainId() {
		return request.getOrderMainId();
	}

	public void setOrderMainId(Long orderMainId) {
		request.setOrderMainId(orderMainId);
	}

	public Long getOrderPassengerId() {
		return request.getOrderPassengerId();
	}

	public void setOrderPassengerId(Long orderPassengerId) {
		request.setOrderPassengerId(orderPassengerId);
	}

	public InsuranceClass getInsuranceClass() {
		return request.getInsuranceClass();
	}

	public void setInsuranceClass(InsuranceClass insuranceClass) {
		request.setInsuranceClass(insuranceClass);
	}

	public BigDecimal getInsurancePrice() {
		return request.getInsurancePrice();
	}

	public void setInsurancePrice(BigDecimal insurancePrice) {
		request.setInsurancePrice(insurancePrice);
	}

	public InsuranceOrderDto getInsuranceOrderDto() {
		return request.getInsuranceOrderDto();
	}

	public void setInsuranceOrderDto(InsuranceOrderDto insuranceOrderDto) {
		request.setInsuranceOrderDto(insuranceOrderDto);
	}

	public String getEmail() {
		return request.getEmail();
	}

	public void setEmail(String email) {
		request.setEmail(email);
	}

	public FlightOrderFlightInfoDto getFlightOrderFlightInfo() {
		return request.getFlightOrderFlightInfo();
	}

	public void setFlightOrderFlightInfo(
			FlightOrderFlightInfoDto flightOrderFlightInfo) {
		request.setFlightOrderFlightInfo(flightOrderFlightInfo);
	}

	public BigDecimal getCostPrice() {
		return request.getCostPrice();
	}

	public void setCostPrice(BigDecimal costPrice) {
		request.setCostPrice(costPrice);
	}

	
}
