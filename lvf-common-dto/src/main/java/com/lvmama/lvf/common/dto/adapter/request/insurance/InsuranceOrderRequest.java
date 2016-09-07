package com.lvmama.lvf.common.dto.adapter.request.insurance;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.insurance.InsuranceOrderDto;
import com.lvmama.lvf.common.dto.md.InsuranceClass;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderInsuranceDto;

/**
 * 
 *
 */
public class InsuranceOrderRequest  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8447671010697189913L;
	
	private FlightOrderInsuranceDto flightOrderInsuranceDto = new FlightOrderInsuranceDto();
	
	private Date bookingTime;
	
	private String insSuppCode;
	
	private Long orderId;

	public Date getBookingTime() {
		return bookingTime;
	}

	public String getInsSuppCode() {
		return insSuppCode;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public void setInsSuppCode(String insSuppCode) {
		this.insSuppCode = insSuppCode;
	}

	public void setBookingTime(Date bookingTime) {
		this.bookingTime = bookingTime;
	}

	public FlightOrderInsuranceDto getFlightOrderInsuranceDto() {
		return flightOrderInsuranceDto;
	}

	public void setFlightOrderInsuranceDto(
			FlightOrderInsuranceDto flightOrderInsuranceDto) {
		this.flightOrderInsuranceDto = flightOrderInsuranceDto;
	}

	public PersistenceType getPtype() {
		return flightOrderInsuranceDto.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		flightOrderInsuranceDto.setPtype(ptype);
	}

	public Long getId() {
		return flightOrderInsuranceDto.getId();
	}

	public void setId(Long id) {
		flightOrderInsuranceDto.setId(id);
	}

	public String getUuid() {
		return flightOrderInsuranceDto.getUuid();
	}

	public void setUuid(String uuid) {
		flightOrderInsuranceDto.setUuid(uuid);
	}

	public Date getCreateTime() {
		return flightOrderInsuranceDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		flightOrderInsuranceDto.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return flightOrderInsuranceDto.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		flightOrderInsuranceDto.setUpdateTime(updateTime);
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

	public FlightOrderFlightInfoDto getFlightOrderFlightInfo() {
		return flightOrderInsuranceDto.getFlightOrderFlightInfo();
	}

	public void setFlightOrderFlightInfo(
			FlightOrderFlightInfoDto flightOrderFlightInfo) {
		flightOrderInsuranceDto.setFlightOrderFlightInfo(flightOrderFlightInfo);
	}

	public BigDecimal getCostPrice() {
		return flightOrderInsuranceDto.getCostPrice();
	}

	public void setCostPrice(BigDecimal costPrice) {
		flightOrderInsuranceDto.setCostPrice(costPrice);
	}

}
