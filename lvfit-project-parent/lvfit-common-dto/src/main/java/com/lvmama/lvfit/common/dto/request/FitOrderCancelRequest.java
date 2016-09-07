package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvfit.common.dto.order.FitOrderRemarkDto;

/**
 * Created by qihuisong on 2015/11/28.
 */
public class FitOrderCancelRequest implements Serializable {

    private static final long serialVersionUID = -4669177873012518170L;

    /** 订单主键 */
    private Long orderMainId;

    /** 子订单主键 */
    private Long orderId;

    /** 订单取消时间 */
    private String limitTime;

    /** 订单备注信息 */
    private FitOrderRemarkDto fitOrderRemarkDto;

    private Long vstOrderId;

    private String cancelCode;//TODO enum

    private String reason;

    private String operatorId;

    private String memo;

    public Long getVstOrderId() {
        return vstOrderId;
    }

    public void setVstOrderId(Long vstOrderId) {
        this.vstOrderId = vstOrderId;
    }

    public String getCancelCode() {
        return cancelCode;
    }

    public void setCancelCode(String cancelCode) {
        this.cancelCode = cancelCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

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

    public String getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(String limitTime) {
        this.limitTime = limitTime;
    }

    public FitOrderRemarkDto getFitOrderRemarkDto() {
        return fitOrderRemarkDto;
    }

    public void setFitOrderRemarkDto(FitOrderRemarkDto fitOrderRemarkDto) {
        this.fitOrderRemarkDto = fitOrderRemarkDto;
    }
}
