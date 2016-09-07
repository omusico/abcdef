package com.lvmama.lvf.common.dto.supp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.lvmama.lvf.common.dto.Entity;

/**
 * 供应商订单退款详细基本信息
 * 
 * @author yuanweihong
 * @date 2015-2-2
 */
public class FlightOrderSuppOrderRefundDetailDto extends Entity implements Serializable {

    private static final long serialVersionUID = -197459428249180309L;

    /** 乘客 */
    private String passengerName;

    /** 票号 */
    private String ticketNo;

    /** 航段List */
    private List<String> flightSegments;

    /** 订单主键 */
    private Long orderId;

    /** 订单No */
    private Long orderNo;

    /** 供应商订单主键 */
    private Long suppOrderId;

    /** 供应商订单No */
    private Long suppOrderNo;

    /** 供应商退票主键 */
    private Long suppRefundId;

    // ////////////携程联盟//////////////////
    /** 航班号 */
    private String flightNo;

    /** 已使用销售价 */
    private BigDecimal usedSalesPrice;

    /** 已使用燃油 */
    private BigDecimal usedFuelsurTax;

    /** 退票费率 */
    private BigDecimal refundRate;

    /** 退票费 */
    private BigDecimal refundFee;

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public List<String> getFlightSegments() {
        return flightSegments;
    }

    public void setFlightSegments(List<String> flightSegments) {
        this.flightSegments = flightSegments;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getSuppOrderId() {
        return suppOrderId;
    }

    public void setSuppOrderId(Long suppOrderId) {
        this.suppOrderId = suppOrderId;
    }

    public Long getSuppRefundId() {
        return suppRefundId;
    }

    public void setSuppRefundId(Long suppRefundId) {
        this.suppRefundId = suppRefundId;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Long getSuppOrderNo() {
        return suppOrderNo;
    }

    public void setSuppOrderNo(Long suppOrderNo) {
        this.suppOrderNo = suppOrderNo;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public BigDecimal getUsedSalesPrice() {
        return usedSalesPrice;
    }

    public void setUsedSalesPrice(BigDecimal usedSalesPrice) {
        this.usedSalesPrice = usedSalesPrice;
    }

    public BigDecimal getUsedFuelsurTax() {
        return usedFuelsurTax;
    }

    public void setUsedFuelsurTax(BigDecimal usedFuelsurTax) {
        this.usedFuelsurTax = usedFuelsurTax;
    }

    public BigDecimal getRefundRate() {
        return refundRate;
    }

    public void setRefundRate(BigDecimal refundRate) {
        this.refundRate = refundRate;
    }

    public BigDecimal getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(BigDecimal refundFee) {
        this.refundFee = refundFee;
    }

}
