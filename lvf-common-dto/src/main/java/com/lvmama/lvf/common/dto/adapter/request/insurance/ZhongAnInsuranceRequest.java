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
import com.lvmama.lvf.common.dto.order.FlightOrderContacterDto;

/**
 * 合众保险请求
 * @author lven
 *
 */
@XmlRootElement
public class ZhongAnInsuranceRequest  implements Serializable, Dto{

	private static final long serialVersionUID = -7255062980486501646L;
	
	/** 订单保险信息*/
	private InsuranceOrderDto insuranceOrderDto = new InsuranceOrderDto();
	
	/** 订单联系人*/
	private FlightOrderContacterDto flightOrderContacterDto;
	
	private Date bookingTime;
	
	private String departureAirportCode;
	
	private String arrivalAirportCode;
	
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

	public String getCellphone() {
		return insuranceOrderDto.getCellphone();
	}

	public void setCellphone(String cellphone) {
		insuranceOrderDto.setCellphone(cellphone);
	}

	public FlightOrderContacterDto getFlightOrderContacterDto() {
		return flightOrderContacterDto;
	}

	public void setFlightOrderContacterDto(
			FlightOrderContacterDto flightOrderContacterDto) {
		this.flightOrderContacterDto = flightOrderContacterDto;
	}

	public Date getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(Date bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getDepartureAirportCode() {
		return departureAirportCode;
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}

	public String getArrivalAirportCode() {
		return arrivalAirportCode;
	}

	public void setArrivalAirportCode(String arrivalAirportCode) {
		this.arrivalAirportCode = arrivalAirportCode;
	}
	
}
