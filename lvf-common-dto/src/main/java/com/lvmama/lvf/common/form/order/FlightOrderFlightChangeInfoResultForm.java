package com.lvmama.lvf.common.form.order;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.ExpressType;
import com.lvmama.lvf.common.dto.enums.FlightChangeType;
import com.lvmama.lvf.common.dto.enums.FlightSegmentType;
import com.lvmama.lvf.common.dto.md.ExpressWay;
import com.lvmama.lvf.common.dto.order.FlightOrderExpressListDto;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightChangeInfoDto;
import com.lvmama.lvf.common.dto.order.status.ExpressStatus;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class FlightOrderFlightChangeInfoResultForm implements Serializable, Form {

	private static final long serialVersionUID = 4052042163799815935L;

	private FlightOrderFlightChangeInfoDto flightChangeInfoDto;

	private String flightSegmentTypeName;

	private String canRefundAllName;

	private String flightChangeTypeName;

	private String originDepartureTimeString;

	private String originArrivalTimeString;

	private String protectDepartureTimeString;

	private String protectArrivalTimeString;

	private String flightChangeCreateTimeString;

	private String validTypeName;

	public FlightOrderFlightChangeInfoResultForm(FlightOrderFlightChangeInfoDto dto) {
		super();
		this.flightChangeInfoDto = dto;
		this.setFlightSegmentTypeName(dto.getFlightSegmentType().getCnName());
		this.setCanRefundAllName(dto.getCanRefundAll() ? "YES" : "NO");
		this.setFlightChangeTypeName(dto.getFlightChangeType().getCnName());
		this.setOriginDepartureTimeString(DateUtils.formatDate(dto.getOriginDepartureTime(), DateUtils.YYYY_MM_DD_HH_MM));
		this.setOriginArrivalTimeString(DateUtils.formatDate(dto.getOriginArrivalTime(), DateUtils.YYYY_MM_DD_HH_MM));
		this.setProtectDepartureTimeString(DateUtils.formatDate(dto.getProtectDepartureTime(), DateUtils.YYYY_MM_DD_HH_MM));
		this.setProtectArrivalTimeString(DateUtils.formatDate(dto.getProtectArrivalTime(), DateUtils.YYYY_MM_DD_HH_MM));
		this.setFlightChangeCreateTimeString(DateUtils.formatDate(dto.getFlightChangeCreateTime(), DateUtils.YYYY_MM_DD_HH_MM));
		this.setValidTypeName(null==dto.getValidType()?"":(dto.getValidType() ? "准确有效" : "错误无效"));
	}

	public String getSuppOrderNo() {
		return flightChangeInfoDto.getSuppOrderNo();
	}

	public void setSuppOrderNo(String suppOrderNo) {
		flightChangeInfoDto.setSuppOrderNo(suppOrderNo);
	}

	public String getSuppOrderLvNo() {
		return flightChangeInfoDto.getSuppOrderLvNo();
	}

	public void setSuppOrderLvNo(String suppOrderLvNo) {
		flightChangeInfoDto.setSuppOrderLvNo(suppOrderLvNo);
	}

	public Long getOrderId() {
		return flightChangeInfoDto.getOrderId();
	}

	public void setOrderId(Long orderId) {
		flightChangeInfoDto.setOrderId(orderId);
	}

	public String getFlightChangeOrderNo() {
		return flightChangeInfoDto.getFlightChangeOrderNo();
	}

	public void setFlightChangeOrderNo(String flightChangeOrderNo) {
		flightChangeInfoDto.setFlightChangeOrderNo(flightChangeOrderNo);
	}

	public String getDistributorsChannel() {
		return flightChangeInfoDto.getDistributorsChannel();
	}

	public void setDistributorsChannel(String distributorsChannel) {
		flightChangeInfoDto.setDistributorsChannel(distributorsChannel);
	}

	public Boolean getCanRefundAll() {
		return flightChangeInfoDto.getCanRefundAll();
	}

	public void setCanRefundAll(Boolean canRefundAll) {
		flightChangeInfoDto.setCanRefundAll(canRefundAll);
	}

	public FlightSegmentType getFlightSegmentType() {
		return flightChangeInfoDto.getFlightSegmentType();
	}

	public void setFlightSegmentType(FlightSegmentType flightSegmentType) {
		flightChangeInfoDto.setFlightSegmentType(flightSegmentType);
	}

	public String getFlightSequence() {
		return flightChangeInfoDto.getFlightSequence();
	}

	public void setFlightSequence(String flightSequence) {
		flightChangeInfoDto.setFlightSequence(flightSequence);
	}

	public String getAid() {
		return flightChangeInfoDto.getAid();
	}

	public void setAid(String aid) {
		flightChangeInfoDto.setAid(aid);
	}

	public String getSid() {
		return flightChangeInfoDto.getSid();
	}

	public void setSid(String sid) {
		flightChangeInfoDto.setSid(sid);
	}

	public String getFlightChangePNR() {
		return flightChangeInfoDto.getFlightChangePNR();
	}

	public void setFlightChangePNR(String flightChangePNR) {
		flightChangeInfoDto.setFlightChangePNR(flightChangePNR);
	}

	public FlightChangeType getFlightChangeType() {
		return flightChangeInfoDto.getFlightChangeType();
	}

	public void setFlightChangeType(FlightChangeType flightChangeType) {
		flightChangeInfoDto.setFlightChangeType(flightChangeType);
	}

	public String getOriginFlightNo() {
		return flightChangeInfoDto.getOriginFlightNo();
	}

	public void setOriginFlightNo(String originFlightNo) {
		flightChangeInfoDto.setOriginFlightNo(originFlightNo);
	}

	public String getOriginSeatClass() {
		return flightChangeInfoDto.getOriginSeatClass();
	}

	public void setOriginSeatClass(String originSeatClass) {
		flightChangeInfoDto.setOriginSeatClass(originSeatClass);
	}

	public Date getOriginDepartureTime() {
		return flightChangeInfoDto.getOriginDepartureTime();
	}

	public void setOriginDepartureTime(Date originDepartureTime) {
		flightChangeInfoDto.setOriginDepartureTime(originDepartureTime);
	}

	public Date getOriginArrivalTime() {
		return flightChangeInfoDto.getOriginArrivalTime();
	}

	public void setOriginArrivalTime(Date originArrivalTime) {
		flightChangeInfoDto.setOriginArrivalTime(originArrivalTime);
	}

	public String getOriginDepartureAirport() {
		return flightChangeInfoDto.getOriginDepartureAirport();
	}

	public void setOriginDepartureAirport(String originDepartureAirport) {
		flightChangeInfoDto.setOriginDepartureAirport(originDepartureAirport);
	}

	public String getOriginArrivalAirport() {
		return flightChangeInfoDto.getOriginArrivalAirport();
	}

	public void setOriginArrivalAirport(String originArrivalAirport) {
		flightChangeInfoDto.setOriginArrivalAirport(originArrivalAirport);
	}

	public String getOriginDepartureBuilding() {
		return flightChangeInfoDto.getOriginDepartureBuilding();
	}

	public void setOriginDepartureBuilding(String originDepartureBuilding) {
		flightChangeInfoDto.setOriginDepartureBuilding(originDepartureBuilding);
	}

	public String getOriginArrivalBuilding() {
		return flightChangeInfoDto.getOriginArrivalBuilding();
	}

	public void setOriginArrivalBuilding(String originArrivalBuilding) {
		flightChangeInfoDto.setOriginArrivalBuilding(originArrivalBuilding);
	}

	public String getOriginAirplaneType() {
		return flightChangeInfoDto.getOriginAirplaneType();
	}

	public void setOriginAirplaneType(String originAirplaneType) {
		flightChangeInfoDto.setOriginAirplaneType(originAirplaneType);
	}

	public String getProtectFlightNo() {
		return flightChangeInfoDto.getProtectFlightNo();
	}

	public void setProtectFlightNo(String protectFlightNo) {
		flightChangeInfoDto.setProtectFlightNo(protectFlightNo);
	}

	public String getProtectSeatClass() {
		return flightChangeInfoDto.getProtectSeatClass();
	}

	public void setProtectSeatClass(String protectSeatClass) {
		flightChangeInfoDto.setProtectSeatClass(protectSeatClass);
	}

	public Date getProtectDepartureTime() {
		return flightChangeInfoDto.getProtectDepartureTime();
	}

	public void setProtectDepartureTime(Date protectDepartureTime) {
		flightChangeInfoDto.setProtectDepartureTime(protectDepartureTime);
	}

	public Date getProtectArrivalTime() {
		return flightChangeInfoDto.getProtectArrivalTime();
	}

	public void setProtectArrivalTime(Date protectArrivalTime) {
		flightChangeInfoDto.setProtectArrivalTime(protectArrivalTime);
	}

	public String getProtectDepartureAirport() {
		return flightChangeInfoDto.getProtectDepartureAirport();
	}

	public void setProtectDepartureAirport(String protectDepartureAirport) {
		flightChangeInfoDto.setProtectDepartureAirport(protectDepartureAirport);
	}

	public String getProtectArrivalAirport() {
		return flightChangeInfoDto.getProtectArrivalAirport();
	}

	public void setProtectArrivalAirport(String protectArrivalAirport) {
		flightChangeInfoDto.setProtectArrivalAirport(protectArrivalAirport);
	}

	public String getProtectDepartureBuilding() {
		return flightChangeInfoDto.getProtectDepartureBuilding();
	}

	public void setProtectDepartureBuilding(String protectDepartureBuilding) {
		flightChangeInfoDto.setProtectDepartureBuilding(protectDepartureBuilding);
	}

	public String getProtectArrivalBuilding() {
		return flightChangeInfoDto.getProtectArrivalBuilding();
	}

	public void setProtectArrivalBuilding(String protectArrivalBuilding) {
		flightChangeInfoDto.setProtectArrivalBuilding(protectArrivalBuilding);
	}

	public String getProtectAirplaneType() {
		return flightChangeInfoDto.getProtectAirplaneType();
	}

	public void setProtectAirplaneType(String protectAirplaneType) {
		flightChangeInfoDto.setProtectAirplaneType(protectAirplaneType);
	}

	public Date getFlightChangeCreateTime() {
		return flightChangeInfoDto.getFlightChangeCreateTime();
	}

	public void setFlightChangeCreateTime(Date flightChangeCreateTime) {
		flightChangeInfoDto.setFlightChangeCreateTime(flightChangeCreateTime);
	}

	public FlightOrderFlightChangeInfoDto getFlightChangeInfoDto() {
		return flightChangeInfoDto;
	}

	public void setFlightChangeInfoDto(FlightOrderFlightChangeInfoDto flightChangeInfoDto) {
		this.flightChangeInfoDto = flightChangeInfoDto;
	}

	public String getFlightSegmentTypeName() {
		return flightSegmentTypeName;
	}

	public void setFlightSegmentTypeName(String flightSegmentTypeName) {
		this.flightSegmentTypeName = flightSegmentTypeName;
	}

	public String getCanRefundAllName() {
		return canRefundAllName;
	}

	public void setCanRefundAllName(String canRefundAllName) {
		this.canRefundAllName = canRefundAllName;
	}

	public String getFlightChangeTypeName() {
		return flightChangeTypeName;
	}

	public void setFlightChangeTypeName(String flightChangeTypeName) {
		this.flightChangeTypeName = flightChangeTypeName;
	}

	public String getOriginDepartureTimeString() {
		return originDepartureTimeString;
	}

	public void setOriginDepartureTimeString(String originDepartureTimeString) {
		this.originDepartureTimeString = originDepartureTimeString;
	}

	public String getOriginArrivalTimeString() {
		return originArrivalTimeString;
	}

	public void setOriginArrivalTimeString(String originArrivalTimeString) {
		this.originArrivalTimeString = originArrivalTimeString;
	}

	public String getProtectDepartureTimeString() {
		return protectDepartureTimeString;
	}

	public void setProtectDepartureTimeString(String protectDepartureTimeString) {
		this.protectDepartureTimeString = protectDepartureTimeString;
	}

	public String getProtectArrivalTimeString() {
		return protectArrivalTimeString;
	}

	public void setProtectArrivalTimeString(String protectArrivalTimeString) {
		this.protectArrivalTimeString = protectArrivalTimeString;
	}

	public String getFlightChangeCreateTimeString() {
		return flightChangeCreateTimeString;
	}

	public void setFlightChangeCreateTimeString(String flightChangeCreateTimeString) {
		this.flightChangeCreateTimeString = flightChangeCreateTimeString;
	}

	public String getValidTypeName() {
		return validTypeName;
	}

	public void setValidTypeName(String validTypeName) {
		this.validTypeName = validTypeName;
	}
}
