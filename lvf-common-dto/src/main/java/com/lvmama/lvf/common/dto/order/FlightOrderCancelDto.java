package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.OrderType;
import com.lvmama.lvf.common.dto.status.order.OrderCancelStatus;
import com.lvmama.lvf.common.dto.status.order.OrderPayStatus;

/**
 * 
 * 30分钟内未支付取消订单DTO
 * 
 */
public class FlightOrderCancelDto implements Serializable, Dto {

	private static final long serialVersionUID = -3484815804683272598L;
	/** 主订单主键 */
	private Long orderMainId;

	/** 订单主键 */
	private Long orderId;

	/** 订单类型 */
	private OrderType orderType;

	/** 订单支付状态 */
	private OrderPayStatus orderPayStatus;

	private Date queryTime;

	/** 支付等待时间 */
	private Date limitTime;
	
	
	private  OrderCancelStatus orderCancelStatus;

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

	public Date getLimitTime() {
		return limitTime;
	}

	public void setLimitTime(Date limitTime) {
		this.limitTime = limitTime;
	}

	public Date getQueryTime() {
		return queryTime;
	}

	public void setQueryTime(Date queryTime) {
		this.queryTime = queryTime;
	}

	
	
	public OrderCancelStatus getOrderCancelStatus() {
		return orderCancelStatus;
	}

	public void setOrderCancelStatus(OrderCancelStatus orderCancelStatus) {
		this.orderCancelStatus = orderCancelStatus;
	}

	@JsonIgnore
	@Override
	public Long getId() {
		return null;
	}
}
