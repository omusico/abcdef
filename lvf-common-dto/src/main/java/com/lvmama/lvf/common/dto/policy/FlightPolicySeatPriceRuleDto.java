package com.lvmama.lvf.common.dto.policy;

import java.io.Serializable;
import java.util.List;

import com.lvmama.lvf.common.dto.AEEntity;

public class FlightPolicySeatPriceRuleDto extends AEEntity implements Serializable {
	
	/** serialVersionUID */
	private static final long serialVersionUID = 8543681234425196274L;
	
	/** 政策舱位及舱位价格规则信息 */
	private List<FlightPolicySeatPriceDto> flightPolicySeatPrices;

	public List<FlightPolicySeatPriceDto> getFlightPolicySeatPrices() {
		return flightPolicySeatPrices;
	}

	public void setFlightPolicySeatPrices(
			List<FlightPolicySeatPriceDto> flightPolicySeatPrices) {
		this.flightPolicySeatPrices = flightPolicySeatPrices;
	}
	
	
	
}
