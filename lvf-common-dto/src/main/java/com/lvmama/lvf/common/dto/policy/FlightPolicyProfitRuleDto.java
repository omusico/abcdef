package com.lvmama.lvf.common.dto.policy;

import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.md.PriceFormula;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

public class FlightPolicyProfitRuleDto extends AEEntity implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 4173616740351228804L;

    private Long policyId;

    /** 政策返点返现信息 */
    private PriceFormula profit;

	public PriceFormula getProfit() {
		return profit;
	}

	public void setProfit(PriceFormula profit) {
		this.profit = profit;
	}

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }
    
    @Override
    @JsonIgnore
    public String getSequence() {
    	return "";
    }
}
