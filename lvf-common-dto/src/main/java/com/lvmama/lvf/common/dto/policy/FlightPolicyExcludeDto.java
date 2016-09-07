package com.lvmama.lvf.common.dto.policy;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.AEEntity;

/**
 * 政策不适用的航班信息
 */
@XmlRootElement
public class FlightPolicyExcludeDto extends AEEntity implements Serializable {

	private static final long serialVersionUID = 1387466340745560941L;

	/**政策Id*/
	private Long policyId;
	
	/**航班号*/
	private String flightNo;
	
	/**航班日期*/
	private Long departureDate;

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public Long getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Long departureDate) {
		this.departureDate = departureDate;
	}

	
}
