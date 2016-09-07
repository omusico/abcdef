package com.lvmama.lvf.common.dto.ticket;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.enums.AllowVT;
import com.lvmama.lvf.common.dto.enums.VTType;

public class FlightTicketVTRuleDto extends AEEntity implements Serializable {

    private static final long serialVersionUID = 8310391708643970806L;

    private VTType vtType;

    /** 废票规定 */
    private String vTDesc;
    private BigDecimal vTFee;
    private AllowVT allowVT;

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

    public List<FlightTicketSegmentRuleDto> getFlightTicketSegmentRules() {
        return flightTicketSegmentRules;
    }

    public void setFlightTicketSegmentRules(
            List<FlightTicketSegmentRuleDto> flightTicketSegmentRules) {
        this.flightTicketSegmentRules = flightTicketSegmentRules;
    }

    public VTType getVtType() {
        return vtType;
    }

    public void setVtType(VTType vtType) {
        this.vtType = vtType;
    }

    public String getvTDesc() {
        return vTDesc;
    }

    public void setvTDesc(String vTDesc) {
        this.vTDesc = vTDesc;
    }

    public BigDecimal getvTFee() {
        return vTFee;
    }

    public void setvTFee(BigDecimal vTFee) {
        this.vTFee = vTFee;
    }

    public AllowVT getAllowVT() {
        return allowVT;
    }

    public void setAllowVT(AllowVT allowVT) {
        this.allowVT = allowVT;
    }

}
