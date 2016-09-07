package com.lvmama.lvf.common.dto.policy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FlightPolicyArrivalRuleDtos  implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 8555646399206584390L;

    private Long policyId;

    /**
     * 到达日期
     */
    private List<FlightPolicyArrivalRuleDto> arrivalDateRanges = new ArrayList<FlightPolicyArrivalRuleDto>();

    public List<FlightPolicyArrivalRuleDto> getArrivalDateRanges() {
        return arrivalDateRanges;
    }

    public void setArrivalDateRanges(List<FlightPolicyArrivalRuleDto> arrivalDateRanges) {
        this.arrivalDateRanges = arrivalDateRanges;
    }

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }
}
