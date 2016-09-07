package com.lvmama.lvf.common.dto.policy;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.md.DateRange;

import java.io.Serializable;

public class FlightPolicyDepartureRuleDto extends Entity implements Serializable {
	
	/** serialVersionUID */
	private static final long serialVersionUID = 561753091861898115L;

    private Long policyId;

    private DateRange departureDateRange;

    public DateRange getDepartureDateRange() {
        return departureDateRange;
    }

    public void setDepartureDateRange(DateRange departureDateRange) {
        this.departureDateRange = departureDateRange;
    }

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }
}
