package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.enums.MTType;

public class FlightOrderTicketMTRuleDto extends AEEntity implements Serializable {

    private static final long serialVersionUID = -40115306953396347L;

    private MTType mtType;

    /** 签转规定 */
    private String mTDesc;
    private BigDecimal minMTFee;
    private Boolean autoMT;

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

    public MTType getMtType() {
        return mtType;
    }

    public void setMtType(MTType mtType) {
        this.mtType = mtType;
    }

    public String getmTDesc() {
        return mTDesc;
    }

    public void setmTDesc(String mTDesc) {
        this.mTDesc = mTDesc;
    }

    public BigDecimal getMinMTFee() {
        return minMTFee;
    }

    public void setMinMTFee(BigDecimal minMTFee) {
        this.minMTFee = minMTFee;
    }

    public Boolean getAutoMT() {
        return autoMT;
    }

    public void setAutoMT(Boolean autoMT) {
        this.autoMT = autoMT;
    }

    public List<FlightOrderTicketSegmentRuleDto> getFlightOrderTicketSegmentRules() {
        return flightOrderTicketSegmentRules;
    }

    public void setFlightOrderTicketSegmentRules(
            List<FlightOrderTicketSegmentRuleDto> flightOrderTicketSegmentRules) {
        this.flightOrderTicketSegmentRules = flightOrderTicketSegmentRules;
    }
}
