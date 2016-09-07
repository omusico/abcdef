package com.lvmama.lvf.common.dto.adapter.response;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderAmountDto;

/**
 * 国内机票可退票/改签查询返回信息
 * 
 * @author yuanweihong
 * @date   2015-9-24
 */
@XmlRootElement
public class FlightSuppOrderRefundableResponse extends Entity implements Serializable {

    private static final long serialVersionUID = 8662265309361375774L;

    /** 供应商订单金额信息 */
    private FlightOrderSuppOrderAmountDto flightOrderSuppOrderAmount;

    /** 此订单总体是否可改签 */
    private Boolean rebookable;

    /** 若不可改，不可改的原因 */
    private String unrebookReason;

    /** 此订单是否全部可退 */
    private Boolean refundable;

    /** 不可退原因 */
    private String unrefundReason;

    /** 供应商订单号 */
    private String suppOrderNo;

    /** 退票详细相关信息 */
    private List<FlightSuppOrderRefundableSegmentInfo> refundableSegmentInfos;

    public FlightOrderSuppOrderAmountDto getFlightOrderSuppOrderAmount() {
        return flightOrderSuppOrderAmount;
    }

    public void setFlightOrderSuppOrderAmount(
            FlightOrderSuppOrderAmountDto flightOrderSuppOrderAmount) {
        this.flightOrderSuppOrderAmount = flightOrderSuppOrderAmount;
    }

    public Boolean getRefundable() {
        return refundable;
    }

    public void setRefundable(Boolean refundable) {
        this.refundable = refundable;
    }

    public String getUnrefundReason() {
        return unrefundReason;
    }

    public void setUnrefundReason(String unrefundReason) {
        this.unrefundReason = unrefundReason;
    }

    public String getSuppOrderNo() {
        return suppOrderNo;
    }

    public void setSuppOrderNo(String suppOrderNo) {
        this.suppOrderNo = suppOrderNo;
    }

    public List<FlightSuppOrderRefundableSegmentInfo> getRefundableSegmentInfos() {
        return refundableSegmentInfos;
    }

    public void setRefundableSegmentInfos(
            List<FlightSuppOrderRefundableSegmentInfo> refundableSegmentInfos) {
        this.refundableSegmentInfos = refundableSegmentInfos;
    }

    public Boolean getRebookable() {
        return rebookable;
    }

    public void setRebookable(Boolean rebookable) {
        this.rebookable = rebookable;
    }

    public String getUnrebookReason() {
        return unrebookReason;
    }

    public void setUnrebookReason(String unrebookReason) {
        this.unrebookReason = unrebookReason;
    }
}
