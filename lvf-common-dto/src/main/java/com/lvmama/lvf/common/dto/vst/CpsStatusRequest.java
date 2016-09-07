package com.lvmama.lvf.common.dto.vst;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.enums.EVENT_TYPE;

public class CpsStatusRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/** 主订单id */
	private Long orderMainId;
	
	/** 子订单id */
	private Long orderSubId;
	
	/**机票添加子订单号*/
	private String orderSubNo;
	
	/**机票添加主订单号*/
	private String orderMainNo;
	
	/** 订单状态类型 */
	private EVENT_TYPE eventType;
	
	/**流水创建时间*/
	private Date timePoint;
	
	/**推送CPS信息*/
	private CpsOrderInfoDto cpsOrderInfoDto;
	
	public Long getOrderMainId() {
		return orderMainId;
	}

	public void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}

	public Long getOrderSubId() {
		return orderSubId;
	}

	public void setOrderSubId(Long orderSubId) {
		this.orderSubId = orderSubId;
	}

	public String getOrderSubNo() {
		return orderSubNo;
	}

	public void setOrderSubNo(String orderSubNo) {
		this.orderSubNo = orderSubNo;
	}

	public String getOrderMainNo() {
		return orderMainNo;
	}

	public void setOrderMainNo(String orderMainNo) {
		this.orderMainNo = orderMainNo;
	}

	public CpsOrderInfoDto getCpsOrderInfoDto() {
		return cpsOrderInfoDto;
	}

	public void setCpsOrderInfoDto(CpsOrderInfoDto cpsOrderInfoDto) {
		this.cpsOrderInfoDto = cpsOrderInfoDto;
	}

	public EVENT_TYPE getEventType() {
		return eventType;
	}

	public void setEventType(EVENT_TYPE eventType) {
		this.eventType = eventType;
	}
	public Date getTimePoint() {
		return timePoint;
	}

	public void setTimePoint(Date timePoint) {
		this.timePoint = timePoint;
	}
}
