package com.lvmama.lvf.common.dto.policy;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.md.DateRange;

import java.io.Serializable;

public class FlightPolicyArrivalRuleDto extends Entity implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 8555646399206584390L;

    private Long policyId;
    /**
     * 到达日期
     */
    private DateRange arrivalDateRange;

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public DateRange getArrivalDateRange() {
        return arrivalDateRange;
    }

    public void setArrivalDateRange(DateRange arrivalDateRange) {
        this.arrivalDateRange = arrivalDateRange;
    }
}
