package com.lvmama.lvf.common.dto.ticket;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * CTMT改期改签金额信息
 * 
 * @author yuanweihongs
 * @date 2015-6-29
 */
public class FlightOrderTicketCTMTAmountDto implements Serializable {

    private static final long serialVersionUID = 48001495738677269L;

    /** 手续费 */
    private BigDecimal fee;

    /** 服务费 */
    private BigDecimal surcharge;

    /** 应收款 */
    private BigDecimal prepaidAmount;

    /** 实收金额 */
    private BigDecimal paiclupAmount;

    /** 实付金额 */
    private BigDecimal payedAmount;

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(BigDecimal surcharge) {
        this.surcharge = surcharge;
    }

    public BigDecimal getPrepaidAmount() {
        return prepaidAmount;
    }

    public void setPrepaidAmount(BigDecimal prepaidAmount) {
        this.prepaidAmount = prepaidAmount;
    }

    public BigDecimal getPaiclupAmount() {
        return paiclupAmount;
    }

    public void setPaiclupAmount(BigDecimal paiclupAmount) {
        this.paiclupAmount = paiclupAmount;
    }

    public BigDecimal getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(BigDecimal payedAmount) {
        this.payedAmount = payedAmount;
    }

}
