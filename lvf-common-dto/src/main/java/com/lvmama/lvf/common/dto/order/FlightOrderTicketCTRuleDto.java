package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.enums.CTType;

public class FlightOrderTicketCTRuleDto extends AEEntity implements Serializable {

    private static final long serialVersionUID = 5331060311753486687L;

    private CTType ctType;

    /** 更改规定 */
    private String cTDesc;
    private BigDecimal minCTFee;
    private Boolean autoCT;

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

    public List<FlightOrderTicketSegmentRuleDto> getFlightOrderTicketSegmentRules() {
        return flightOrderTicketSegmentRules;
    }

    public void setFlightOrderTicketSegmentRules(
            List<FlightOrderTicketSegmentRuleDto> flightOrderTicketSegmentRules) {
        this.flightOrderTicketSegmentRules = flightOrderTicketSegmentRules;
    }

    public CTType getCtType() {
        return ctType;
    }

    public void setCtType(CTType ctType) {
        this.ctType = ctType;
    }

    public String getcTDesc() {
        return cTDesc;
    }

    public void setcTDesc(String cTDesc) {
        this.cTDesc = cTDesc;
    }

    public BigDecimal getMinCTFee() {
        return minCTFee;
    }

    public void setMinCTFee(BigDecimal minCTFee) {
        this.minCTFee = minCTFee;
    }

    public Boolean getAutoCT() {
        return autoCT;
    }

    public void setAutoCT(Boolean autoCT) {
        this.autoCT = autoCT;
    }

}
