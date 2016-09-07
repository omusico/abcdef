package com.lvmama.lvf.common.dto.order.status;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.OrderFlag;
import com.lvmama.lvf.common.dto.status.order.OrderAuditStatus;
import com.lvmama.lvf.common.dto.status.order.OrderBackStatus;
import com.lvmama.lvf.common.dto.status.order.OrderBookingStatus;
import com.lvmama.lvf.common.dto.status.order.OrderCancelStatus;
import com.lvmama.lvf.common.dto.status.order.OrderFrontStatus;
import com.lvmama.lvf.common.dto.status.order.OrderLockStatus;
import com.lvmama.lvf.common.dto.status.order.OrderPayStatus;
import com.lvmama.lvf.common.dto.status.order.OrderReservedStatus;
import com.lvmama.lvf.common.dto.status.order.OrderSettlementStatus;
import com.lvmama.lvf.common.dto.status.order.SuppOrderAuditStatus;
import com.lvmama.lvf.common.dto.status.order.OrderTicketStatus;
import com.lvmama.lvf.common.dto.status.order.OrderVisibleStatus;

/**
 * 订单状态
 * @date   2015-1-30
 */
@XmlRootElement
public class FlightOrderStatusDto extends Entity implements Serializable
{
	private static final long serialVersionUID = 8767467536236403479L;
	
	/** 订单主键 */
	private Long orderId;
	
	/** 订单订位状态 **/
	private OrderBookingStatus orderBookingStatus;
	
	/** 订单审核状态 */
	private OrderAuditStatus orderAuditStatus;
	
	/** 订单支付状态 */
	private OrderPayStatus orderPayStatus;
	
	/** 订单机票状态 */
	private OrderTicketStatus orderTicketStatus;
	
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
	
	/** 订单供应商审核状态 */
	private SuppOrderAuditStatus suppOrderAuditStatus;
	
	/** 订单账户类型*/
	private OrderFlag orderFlag;
	
	/** 先定位 OR 后定位 */
	private OrderReservedStatus orderReservedStatus;

	public OrderVisibleStatus getVisible() {
		return visible;
	}

	public void setVisible(OrderVisibleStatus visible) {
		this.visible = visible;
	}

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

	public OrderTicketStatus getOrderTicketStatus() {
		return orderTicketStatus;
	}

	public void setOrderTicketStatus(
			OrderTicketStatus orderTicketStatus) {
		this.orderTicketStatus = orderTicketStatus;
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
	
	public OrderSettlementStatus getOrderSettlementStatus() {
		return orderSettlementStatus;
	}

	public void setOrderSettlementStatus(OrderSettlementStatus orderSettlementStatus) {
		this.orderSettlementStatus = orderSettlementStatus;
	}
	
	public SuppOrderAuditStatus getSuppOrderAuditStatus() {
		return suppOrderAuditStatus;
	}
	
	public void setSuppOrderAuditStatus(
			SuppOrderAuditStatus suppOrderAuditStatus) {
		this.suppOrderAuditStatus = suppOrderAuditStatus;
	}
	
	public OrderFlag getOrderFlag() {
		return orderFlag;
	}

	public void setOrderFlag(OrderFlag orderFlag) {
		this.orderFlag = orderFlag;
	}

	@Override
	@JsonIgnore
	public String getSequence() {
		return "S_FORD_ORDER_STATUS";
	}

	@Override
	public String toString() {
		return "订单号=" + orderId
				+ ", 订单订位状态=" + orderBookingStatus
				+ ", 订单审核状态=" + orderAuditStatus
				+ ", 订单支付状态=" + orderPayStatus + ", 订单机票状态="
				+ orderTicketStatus + ",  订单取消状态="
				+ orderCancelStatus + ", 订单后台状态=" + orderBackStatus
				+ ", 订单前端状=" + orderFrontStatus
				+ ", 是否已锁定=" + orderLockStatus + ", 是否展现="
				+ visible + ", 订单结算状态=" + orderSettlementStatus
				+ ", 订单供应商审核状态=" + suppOrderAuditStatus + "";
	}

	public OrderReservedStatus getOrderReservedStatus() {
		return orderReservedStatus;
	}

	public void setOrderReservedStatus(OrderReservedStatus orderReservedStatus) {
		this.orderReservedStatus = orderReservedStatus;
	}
	
}
