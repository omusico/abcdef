package com.lvmama.lvf.common.dto.policy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FlightPolicyDepartureRuleDtos implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 561753091861898115L;

    private Long policyId;

    /**
     * 出发日期
     */
    private List<FlightPolicyDepartureRuleDto> departureDateRanges = new ArrayList<FlightPolicyDepartureRuleDto>();

    public List<FlightPolicyDepartureRuleDto> getDepartureDateRanges() {
        return departureDateRanges;
    }

    public void setDepartureDateRanges(List<FlightPolicyDepartureRuleDto> departureDateRanges) {
        this.departureDateRanges = departureDateRanges;
    }

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }
}
