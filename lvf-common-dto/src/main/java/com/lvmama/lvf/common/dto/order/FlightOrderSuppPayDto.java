package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.OrderType;
import com.lvmama.lvf.common.dto.status.order.OrderPayStatus;

/**
 * 
 * 供应商支付订单DTO
 * 
 */
public class FlightOrderSuppPayDto implements Serializable, Dto {

	private static final long serialVersionUID = -3484815804683272598L;
	/** 主订单主键 */
	private Long orderMainId;

	/** 订单主键 */
	private Long orderId;

	/** 订单类型 */
	private OrderType orderType;

	/** 订单支付状态 */
	private OrderPayStatus orderPayStatus;
	
	private String suppCode;
	
	private String payNoticeTime;

	/** 订单Root主键(用于标记同一订单的后续退改签关联关系) +*/
    private Long orderRootId;

	

	public Long getOrderMainId() {
		return orderMainId;
	}



	public void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}



	public Long getOrderId() {
		return orderId;
	}



	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}



	public OrderType getOrderType() {
		return orderType;
	}



	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}



	public OrderPayStatus getOrderPayStatus() {
		return orderPayStatus;
	}



	public void setOrderPayStatus(OrderPayStatus orderPayStatus) {
		this.orderPayStatus = orderPayStatus;
	}



	public Long getOrderRootId() {
		return orderRootId;
	}



	public void setOrderRootId(Long orderRootId) {
		this.orderRootId = orderRootId;
	}

   

	public String getSuppCode() {
		return suppCode;
	}



	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

    

	public String getPayNoticeTime() {
		return payNoticeTime;
	}



	public void setPayNoticeTime(String payNoticeTime) {
		this.payNoticeTime = payNoticeTime;
	}



	@JsonIgnore
	@Override
	public Long getId() {
		return null;
	}
}
