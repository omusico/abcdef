package com.lvmama.lvf.common.dto.supp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.SuppRefundStatus;
import com.lvmama.lvf.common.dto.order.FlightOrderRemarkDto;

@XmlRootElement
public class FlightOrderSuppOrderRefundDto extends Entity implements Serializable {

    private static final long serialVersionUID = 2796228213320401801L;

    /** 供应商订单ID */
    private String suppOrderId;

    /** 供应商订单NO */
    private String suppOrderNo;

    /** PNR编码 */
    private String pnr;

    /** 供应商退票单号 */
    private String suppRefundNo;

    /** 退废票申请时间 */
    private Date applyRefundTime;

    /** 退款时间 */
    private Date factRefundTime;

    /** 退款金额 */
    private BigDecimal refundAmount;

    /** 外部退款利润 */
    private BigDecimal refundChargeProfit;

    /** 订单ID */
    private String orderId;

    /** 订单NO */
    private String orderNo;

    /** 退款状态 */
    private SuppRefundStatus suppRefundStatus;

    /** 退票备注 */
    private FlightOrderRemarkDto flightOrderRemark;

    /** 供应商订单退款详细基本信息 */
    private List<FlightOrderSuppOrderRefundDetailDto> details = new ArrayList<FlightOrderSuppOrderRefundDetailDto>();

    /** 供应商订单改签返回信息对象 */
    private List<FlightOrderSuppOrderChangeDto> flightOrderSuppOrderChanges = new ArrayList<FlightOrderSuppOrderChangeDto>();

    public String getSuppOrderId() {
        return suppOrderId;
    }

    public void setSuppOrderId(String suppOrderId) {
        this.suppOrderId = suppOrderId;
    }

    public String getSuppOrderNo() {
        return suppOrderNo;
    }

    public void setSuppOrderNo(String suppOrderNo) {
        this.suppOrderNo = suppOrderNo;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getSuppRefundNo() {
        return suppRefundNo;
    }

    public void setSuppRefundNo(String suppRefundNo) {
        this.suppRefundNo = suppRefundNo;
    }

    public Date getApplyRefundTime() {
        return applyRefundTime;
    }

    public void setApplyRefundTime(Date applyRefundTime) {
        this.applyRefundTime = applyRefundTime;
    }

    public Date getFactRefundTime() {
        return factRefundTime;
    }

    public void setFactRefundTime(Date factRefundTime) {
        this.factRefundTime = factRefundTime;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public BigDecimal getRefundChargeProfit() {
        return refundChargeProfit;
    }

    public void setRefundChargeProfit(BigDecimal refundChargeProfit) {
        this.refundChargeProfit = refundChargeProfit;
    }

    public SuppRefundStatus getSuppRefundStatus() {
        return suppRefundStatus;
    }

    public void setSuppRefundStatus(SuppRefundStatus suppRefundStatus) {
        this.suppRefundStatus = suppRefundStatus;
    }

    public List<FlightOrderSuppOrderRefundDetailDto> getDetails() {
        return details;
    }

    public void setDetails(List<FlightOrderSuppOrderRefundDetailDto> details) {
        this.details = details;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public FlightOrderRemarkDto getFlightOrderRemark() {
        return flightOrderRemark;
    }

    public void setFlightOrderRemark(FlightOrderRemarkDto flightOrderRemark) {
        this.flightOrderRemark = flightOrderRemark;
    }

    public List<FlightOrderSuppOrderChangeDto> getFlightOrderSuppOrderChanges() {
        return flightOrderSuppOrderChanges;
    }

    public void setFlightOrderSuppOrderChanges(
            List<FlightOrderSuppOrderChangeDto> flightOrderSuppOrderChanges) {
        this.flightOrderSuppOrderChanges = flightOrderSuppOrderChanges;
    }

}
