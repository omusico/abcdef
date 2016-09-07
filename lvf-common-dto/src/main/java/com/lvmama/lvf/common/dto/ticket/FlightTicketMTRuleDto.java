package com.lvmama.lvf.common.dto.ticket;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.enums.MTType;

public class FlightTicketMTRuleDto extends AEEntity implements Serializable {

    private static final long serialVersionUID = -40115306953396347L;

    private MTType mtType;

    /** 签转规定 */
    private String mTDesc;
    private BigDecimal minMTFee;
    private Boolean autoMT;
    
    /** 规定具体信息 */
    private List<FlightTicketSegmentRuleDto> flightTicketSegmentRules;

    @FkId
    private FlightTicketRuleDto flightTicketRule;

    public FlightTicketRuleDto getFlightTicketRule() {
        return flightTicketRule;
    }

    public void setFlightTicketRule(FlightTicketRuleDto flightTicketRule) {
        this.flightTicketRule = flightTicketRule;
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

    public List<FlightTicketSegmentRuleDto> getFlightTicketSegmentRules() {
        return flightTicketSegmentRules;
    }

    public void setFlightTicketSegmentRules(
            List<FlightTicketSegmentRuleDto> flightTicketSegmentRules) {
        this.flightTicketSegmentRules = flightTicketSegmentRules;
    }

}
