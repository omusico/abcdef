package com.lvmama.lvfit.common.dto.order;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.OrderFlag;
import com.lvmama.lvfit.common.dto.status.order.*;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 订单状态
 */
@XmlRootElement
public class FitOrderStatusDto extends Entity {

	private static final long serialVersionUID = -1536750104070872991L;

	/** 订单主键 */
	private Long orderId;
	
	/** 订单订位状态 **/
	private OrderBookingStatus orderBookingStatus;
	
	/** 订单审核状态 */
	private OrderAuditStatus orderAuditStatus;
	
	/** 订单支付状态 */
	private OrderPayStatus orderPayStatus;
	
	/** 订单取消状态 */
	private OrderCancelStatus orderCancelStatus;
	
	/** 订单后台状态(订单状态) */
	private OrderBackStatus orderBackStatus; 
	
	/** 订单前端状态(客户订单状态) */
	private OrderFrontStatus orderFrontStatus;
	
	/**是否已锁定(锁定后便不能做任何动作)*/
	private OrderLockStatus orderLockStatus;
	
	private OrderVisibleStatus visible = OrderVisibleStatus.VISIBLE;
	
	/** 订单结算状态 */
	private OrderSettlementStatus orderSettlementStatus;
	
	/** 订单账户类型*/
	private OrderFlag orderFlag;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public OrderBookingStatus getOrderBookingStatus() {
		return orderBookingStatus;
	}

	public void setOrderBookingStatus(OrderBookingStatus orderBookingStatus) {
		this.orderBookingStatus = orderBookingStatus;
	}

	public OrderAuditStatus getOrderAuditStatus() {
		return orderAuditStatus;
	}

	public void setOrderAuditStatus(OrderAuditStatus orderAuditStatus) {
		this.orderAuditStatus = orderAuditStatus;
	}

	public OrderPayStatus getOrderPayStatus() {
		return orderPayStatus;
	}

	public void setOrderPayStatus(OrderPayStatus orderPayStatus) {
		this.orderPayStatus = orderPayStatus;
	}

	public OrderCancelStatus getOrderCancelStatus() {
		return orderCancelStatus;
	}

	public void setOrderCancelStatus(OrderCancelStatus orderCancelStatus) {
		this.orderCancelStatus = orderCancelStatus;
	}

	public OrderBackStatus getOrderBackStatus() {
		return orderBackStatus;
	}

	public void setOrderBackStatus(OrderBackStatus orderBackStatus) {
		this.orderBackStatus = orderBackStatus;
	}

	public OrderFrontStatus getOrderFrontStatus() {
		return orderFrontStatus;
	}

	public void setOrderFrontStatus(OrderFrontStatus orderFrontStatus) {
		this.orderFrontStatus = orderFrontStatus;
	}

	public OrderLockStatus getOrderLockStatus() {
		return orderLockStatus;
	}

	public void setOrderLockStatus(OrderLockStatus orderLockStatus) {
		this.orderLockStatus = orderLockStatus;
	}

	public OrderVisibleStatus getVisible() {
		return visible;
	}

	public void setVisible(OrderVisibleStatus visible) {
		this.visible = visible;
	}

	public OrderSettlementStatus getOrderSettlementStatus() {
		return orderSettlementStatus;
	}

	public void setOrderSettlementStatus(OrderSettlementStatus orderSettlementStatus) {
		this.orderSettlementStatus = orderSettlementStatus;
	}

	public OrderFlag getOrderFlag() {
		return orderFlag;
	}

	public void setOrderFlag(OrderFlag orderFlag) {
		this.orderFlag = orderFlag;
	}
}
