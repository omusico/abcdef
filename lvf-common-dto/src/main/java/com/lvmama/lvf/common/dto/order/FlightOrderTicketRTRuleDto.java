package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.enums.RTType;

public class FlightOrderTicketRTRuleDto extends AEEntity implements Serializable {

    private static final long serialVersionUID = -2851635307564658597L;
    private RTType rtType;

    /** 退票规定 */
    private String rTDesc;
    private BigDecimal minRTFee;
    private Boolean autoRT;

    /** 规定具体信息 */
    private List<FlightOrderTicketSegmentRuleDto> flightOrderTicketSegmentRules;

    @FkId
    private Long orderTicketRuleId;

    public Long getOrderTicketRuleId() {
        return orderTicketRuleId;
    }

    public void setOrderTicketRuleId(Long orderTicketRuleId) {
        this.orderTicketRuleId = orderTicketRuleId;
    }

    public RTType getRtType() {
        return rtType;
    }

    public void setRtType(RTType rtType) {
        this.rtType = rtType;
    }

    public String getrTDesc() {
        return rTDesc;
    }

    public void setrTDesc(String rTDesc) {
        this.rTDesc = rTDesc;
    }

    public BigDecimal getMinRTFee() {
        return minRTFee;
    }

    public void setMinRTFee(BigDecimal minRTFee) {
        this.minRTFee = minRTFee;
    }

    public Boolean getAutoRT() {
        return autoRT;
    }

    public void setAutoRT(Boolean autoRT) {
        this.autoRT = autoRT;
    }

    public List<FlightOrderTicketSegmentRuleDto> getFlightOrderTicketSegmentRules() {
        return flightOrderTicketSegmentRules;
    }

    public void setFlightOrderTicketSegmentRules(
            List<FlightOrderTicketSegmentRuleDto> flightOrderTicketSegmentRules) {
        this.flightOrderTicketSegmentRules = flightOrderTicketSegmentRules;
    }

}
