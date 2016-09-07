package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.EVENT_TYPE;
import com.lvmama.lvf.common.dto.enums.SEND_STATUS;

@SuppressWarnings("serial")
public class FlightOrderCPSOperationInfoDto extends Entity implements Serializable{
	private Long orderId;
	private Long orderMainId;
	private String cpsId;
	private String orderNo;
	private String orderMainNo;
	private SEND_STATUS sendStatus;
	private EVENT_TYPE eventType;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getOrderMainId() {
		return orderMainId;
	}
	public void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}
	public String getCpsId() {
		return cpsId;
	}
	public void setCpsId(String cpsId) {
		this.cpsId = cpsId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderMainNo() {
		return orderMainNo;
	}
	public void setOrderMainNo(String orderMainNo) {
		this.orderMainNo = orderMainNo;
	}
	public EVENT_TYPE getEventType() {
		return eventType;
	}
	public void setEventType(EVENT_TYPE eventType) {
		this.eventType = eventType;
	}
	public SEND_STATUS getSendStatus() {
		return sendStatus;
	}
	public void setSendStatus(SEND_STATUS sendStatus) {
		this.sendStatus = sendStatus;
	}
}
