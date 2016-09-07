package com.lvmama.lvf.common.dto.supp;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.status.order.OrderBookingStatus;
import com.lvmama.lvf.common.dto.status.order.OrderCancelStatus;
import com.lvmama.lvf.common.dto.status.order.OrderPayStatus;
import com.lvmama.lvf.common.dto.status.order.OrderTicketStatus;

/**
 * 供应商订单状态信息
 * 
 * @author majun
 * @date 2015-1-30
 */
public class FlightOrderSuppOrderStatusDto extends Entity implements Serializable {
    private static final long serialVersionUID = -4765815520343880576L;

    /** 供应商订单主键 */
    private Long suppOrderId;

    /** 订单订位状态 */
    private OrderBookingStatus orderBookingStatus = OrderBookingStatus.NULL;

    /** 订单支付状态 */
    private OrderPayStatus orderPayStatus = OrderPayStatus.NULL;

    /** 订单机票状态 */
    private OrderTicketStatus orderTicketStatus = OrderTicketStatus.NULL;

    /** 订单取消状态 */
    private OrderCancelStatus orderCancelStatus = OrderCancelStatus.NULL;

    public Long getSuppOrderId() {
        return suppOrderId;
    }

    public void setSuppOrderId(Long suppOrderId) {
        this.suppOrderId = suppOrderId;
    }

    public OrderBookingStatus getOrderBookingStatus() {
        return orderBookingStatus;
    }

    public void setOrderBookingStatus(OrderBookingStatus orderBookingStatus) {
        this.orderBookingStatus = orderBookingStatus;
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

    public void setOrderTicketStatus(OrderTicketStatus orderTicketStatus) {
        this.orderTicketStatus = orderTicketStatus;
    }

    public OrderCancelStatus getOrderCancelStatus() {
        return orderCancelStatus;
    }

    public void setOrderCancelStatus(OrderCancelStatus orderCancelStatus) {
        this.orderCancelStatus = orderCancelStatus;
    }

    /**
     * 同步供应商订单状态信息(xslt)
     * 
     * @param request
     *            供应商订单状态信息
     * @return void
     */
    public void copyFromDto(FlightOrderSuppOrderStatusDto newDto) {
        if (newDto.getOrderBookingStatus() != null) {
            this.setOrderBookingStatus(newDto.getOrderBookingStatus());
        }
        if (newDto.getOrderCancelStatus() != null) {
            this.setOrderCancelStatus(newDto.getOrderCancelStatus());
        }
        if (newDto.getOrderPayStatus() != null) {
            this.setOrderPayStatus(newDto.getOrderPayStatus());
        }
        if (newDto.getOrderTicketStatus() != null) {
            this.setOrderTicketStatus(newDto.getOrderTicketStatus());
        }
        this.setUpdateTime(new Date());
    }

}
