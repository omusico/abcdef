package com.lvmama.lvf.common.form.insurance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.dto.enums.Gender;
import com.lvmama.lvf.common.dto.insurance.InsuranceOrderDto;
import com.lvmama.lvf.common.dto.md.InsuranceClass;
import com.lvmama.lvf.common.dto.order.FlightOrderDto;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderInsuranceDto;
import com.lvmama.lvf.common.dto.order.FlightOrderInvoiceDto;
import com.lvmama.lvf.common.dto.order.FlightOrderNoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPNRInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderTicketInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderTicketPriceDto;
import com.lvmama.lvf.common.dto.status.detail.DetailTicketStatus;
import com.lvmama.lvf.common.form.Form;

/**
 * 保单列表信息
 * 
 */
public class ArtificialInsuranceResultForm implements Serializable, Form {
 
	private static final long serialVersionUID = 6981968273210799251L;
	
	/** 结果状态枚举 */
	private Boolean status = false;
	
	private String genderType;
	
	private String effectTime;
	
	private String expireTime;
	
	private String idCardType;
	
	private FlightOrderDto flightOrderDto = new FlightOrderDto();

	private FlightOrderTicketInfoDto flightOrderTicketInfoDto = new FlightOrderTicketInfoDto();
	
	private FlightOrderInsuranceDto flightOrderInsuranceDto = new FlightOrderInsuranceDto();
	
	public FlightOrderTicketInfoDto getFlightOrderTicketInfoDto() {
		return flightOrderTicketInfoDto;
	}

	public void setFlightOrderTicketInfoDto(
			FlightOrderTicketInfoDto flightOrderTicketInfoDto) {
		this.flightOrderTicketInfoDto = flightOrderTicketInfoDto;
	}

	public FlightOrderInsuranceDto getFlightOrderInsuranceDto() {
		return flightOrderInsuranceDto;
	}

	public void setFlightOrderInsuranceDto(
			FlightOrderInsuranceDto flightOrderInsuranceDto) {
		this.flightOrderInsuranceDto = flightOrderInsuranceDto;
	}

	public PersistenceType getPtype() {
		return flightOrderTicketInfoDto.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		flightOrderTicketInfoDto.setPtype(ptype);
	}

	public Long getId() {
		return flightOrderTicketInfoDto.getId();
	}

	public void setId(Long id) {
		flightOrderTicketInfoDto.setId(id);
	}

	public String getUuid() {
		return flightOrderTicketInfoDto.getUuid();
	}

	public void setUuid(String uuid) {
		flightOrderTicketInfoDto.setUuid(uuid);
	}

	public Date getCreateTime() {
		return flightOrderTicketInfoDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		flightOrderTicketInfoDto.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return flightOrderTicketInfoDto.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		flightOrderTicketInfoDto.setUpdateTime(updateTime);
	}

	public DetailTicketStatus getDetailTicketStatus() {
		return flightOrderTicketInfoDto.getDetailTicketStatus();
	}

	public void setDetailTicketStatus(DetailTicketStatus detailTicketStatus) {
		flightOrderTicketInfoDto.setDetailTicketStatus(detailTicketStatus);
	}

	public FlightOrderPNRInfoDto getFlightOrderPNRInfo() {
		return flightOrderTicketInfoDto.getFlightOrderPNRInfo();
	}

	public void setFlightOrderPNRInfo(FlightOrderPNRInfoDto flightOrderPNRInfo) {
		flightOrderTicketInfoDto.setFlightOrderPNRInfo(flightOrderPNRInfo);
	}

	public String getTicketNo() {
		return flightOrderTicketInfoDto.getTicketNo();
	}

	public void setTicketNo(String ticketNo) {
		flightOrderTicketInfoDto.setTicketNo(ticketNo);
	}

	public FlightTripType getFlightTripType() {
		return flightOrderTicketInfoDto.getFlightTripType();
	}

	public void setFlightTripType(FlightTripType flightTripType) {
		flightOrderTicketInfoDto.setFlightTripType(flightTripType);
	}

	public FlightOrderFlightInfoDto getFlightOrderFlightInfo() {
		return flightOrderTicketInfoDto.getFlightOrderFlightInfo();
	}

	public void setFlightOrderFlightInfo(
			FlightOrderFlightInfoDto flightOrderFlightInfo) {
		flightOrderTicketInfoDto
				.setFlightOrderFlightInfo(flightOrderFlightInfo);
	}

	public FlightOrderTicketPriceDto getFlightOrderTicketPrice() {
		return flightOrderTicketInfoDto.getFlightOrderTicketPrice();
	}

	public void setFlightOrderTicketPrice(
			FlightOrderTicketPriceDto flightOrderTicketPrice) {
		flightOrderTicketInfoDto
				.setFlightOrderTicketPrice(flightOrderTicketPrice);
	}

	public FlightOrderPassengerDto getFlightOrderPassenger() {
		return flightOrderTicketInfoDto.getFlightOrderPassenger();
	}

	public void setFlightOrderPassenger(
			FlightOrderPassengerDto flightOrderPassenger) {
		flightOrderTicketInfoDto.setFlightOrderPassenger(flightOrderPassenger);
	}

	public FlightOrderInvoiceDto getFlightOrderInvoices() {
		return flightOrderTicketInfoDto.getFlightOrderInvoices();
	}

	public void setFlightOrderInvoices(FlightOrderInvoiceDto flightOrderInvoices) {
		flightOrderTicketInfoDto.setFlightOrderInvoices(flightOrderInvoices);
	}

	public Date getIssueDate() {
		return flightOrderTicketInfoDto.getIssueDate();
	}

	public void setIssueDate(Date issueDate) {
		flightOrderTicketInfoDto.setIssueDate(issueDate);
	}

	public String getOfficeNo() {
		return flightOrderTicketInfoDto.getOfficeNo();
	}

	public void setOfficeNo(String officeNo) {
		flightOrderTicketInfoDto.setOfficeNo(officeNo);
	}

	public String getSequence() {
		return flightOrderTicketInfoDto.getSequence();
	}



	public String getFlightNo() {
		return flightOrderInsuranceDto.getFlightNo();
	}

	public void setFlightNo(String flightNo) {
		flightOrderInsuranceDto.setFlightNo(flightNo);
	}

	public Long getInsuranceInfoId() {
		return flightOrderInsuranceDto.getInsuranceInfoId();
	}

	public void setInsuranceInfoId(Long insuranceInfoId) {
		flightOrderInsuranceDto.setInsuranceInfoId(insuranceInfoId);
	}

	public Long getOrderMainId() {
		return flightOrderInsuranceDto.getOrderMainId();
	}

	public void setOrderMainId(Long orderMainId) {
		flightOrderInsuranceDto.setOrderMainId(orderMainId);
	}

	public Long getOrderPassengerId() {
		return flightOrderInsuranceDto.getOrderPassengerId();
	}

	public void setOrderPassengerId(Long orderPassengerId) {
		flightOrderInsuranceDto.setOrderPassengerId(orderPassengerId);
	}

	public InsuranceClass getInsuranceClass() {
		return flightOrderInsuranceDto.getInsuranceClass();
	}

	public void setInsuranceClass(InsuranceClass insuranceClass) {
		flightOrderInsuranceDto.setInsuranceClass(insuranceClass);
	}

	public BigDecimal getInsurancePrice() {
		return flightOrderInsuranceDto.getInsurancePrice();
	}

	public void setInsurancePrice(BigDecimal insurancePrice) {
		flightOrderInsuranceDto.setInsurancePrice(insurancePrice);
	}

	public InsuranceOrderDto getInsuranceOrderDto() {
		return flightOrderInsuranceDto.getInsuranceOrderDto();
	}

	public void setInsuranceOrderDto(InsuranceOrderDto insuranceOrderDto) {
		flightOrderInsuranceDto.setInsuranceOrderDto(insuranceOrderDto);
	}

	public String getEmail() {
		return flightOrderInsuranceDto.getEmail();
	}

	public void setEmail(String email) {
		flightOrderInsuranceDto.setEmail(email);
	}

	public String getGenderType() {
		 if (null != this.flightOrderTicketInfoDto) {
			if (null != this.flightOrderTicketInfoDto.getFlightOrderPassenger()) {
				if (this.flightOrderTicketInfoDto.getFlightOrderPassenger().getGender().equals(Gender.MALE)) {
					this.genderType = "男";
				}else {
					this.genderType = "女";
				}
			}
		}
		return genderType;
	}

	public void setGenderType(String genderType) {
		this.genderType = genderType;
	}

	public String getEffectTime() {
		return effectTime;
	}

	public void setEffectTime(String effectTime) {
		this.effectTime = effectTime;
	}

	public String getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}

	public String getIdCardType() {
		if (null != this.flightOrderTicketInfoDto) {
			if (null != this.flightOrderTicketInfoDto.getFlightOrderPassenger()) {
				this.idCardType = this.flightOrderTicketInfoDto.getFlightOrderPassenger().getPassengerIDCardType().getCnName();
			}
		}
		return idCardType;
	}

	public void setIdCardType(String idCardType) {
		this.idCardType = idCardType;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public FlightOrderDto getFlightOrderDto() {
		return flightOrderDto;
	}

	public void setFlightOrderDto(FlightOrderDto flightOrderDto) {
		this.flightOrderDto = flightOrderDto;
	}

	public FlightOrderNoDto getFlightOrderNo() {
		return flightOrderDto.getFlightOrderNo();
	}

	public void setFlightOrderNo(FlightOrderNoDto flightOrderNo) {
		flightOrderDto.setFlightOrderNo(flightOrderNo);
	}

	public BigDecimal getCostPrice() {
		return flightOrderInsuranceDto.getCostPrice();
	}

	public void setCostPrice(BigDecimal costPrice) {
		flightOrderInsuranceDto.setCostPrice(costPrice);
	}


	
}
