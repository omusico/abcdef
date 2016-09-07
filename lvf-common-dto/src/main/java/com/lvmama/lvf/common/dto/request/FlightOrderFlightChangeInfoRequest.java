package com.lvmama.lvf.common.dto.request;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.FlightChangeType;
import com.lvmama.lvf.common.dto.md.ExpressWay;
import com.lvmama.lvf.common.dto.order.status.ExpressStatus;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

public class FlightOrderFlightChangeInfoRequest implements Serializable, Dto {

	private static final long serialVersionUID = -2358151444625091143L;

	private Long id;

	private String suppOrderNo;//供应商订单号

	private String flightChangePNR;//航变 PNR

	private FlightChangeType flightChangeType;//航变类型

	private String originFlightNo;//原始航班号

	private String originDepartureAirport;//原始出发机场三字码

	private String originDepQueryBegTime;

	private String originDepQueryEndTime;

	@Override
	public Long getId() {
		return id;
	}

	public String getSuppOrderNo() {
		return suppOrderNo;
	}

	public void setSuppOrderNo(String suppOrderNo) {
		this.suppOrderNo = suppOrderNo;
	}

	public String getFlightChangePNR() {
		return flightChangePNR;
	}

	public void setFlightChangePNR(String flightChangePNR) {
		this.flightChangePNR = flightChangePNR;
	}

	public FlightChangeType getFlightChangeType() {
		return flightChangeType;
	}

	public void setFlightChangeType(FlightChangeType flightChangeType) {
		this.flightChangeType = flightChangeType;
	}

	public String getOriginFlightNo() {
		return originFlightNo;
	}

	public void setOriginFlightNo(String originFlightNo) {
		this.originFlightNo = originFlightNo;
	}

	public String getOriginDepartureAirport() {
		return originDepartureAirport;
	}

	public void setOriginDepartureAirport(String originDepartureAirport) {
		this.originDepartureAirport = originDepartureAirport;
	}

	public String getOriginDepQueryBegTime() {
		return originDepQueryBegTime;
	}

	public void setOriginDepQueryBegTime(String originDepQueryBegTime) {
		this.originDepQueryBegTime = originDepQueryBegTime;
	}

	public String getOriginDepQueryEndTime() {
		return originDepQueryEndTime;
	}

	public void setOriginDepQueryEndTime(String originDepQueryEndTime) {
		this.originDepQueryEndTime = originDepQueryEndTime;
	}
}

