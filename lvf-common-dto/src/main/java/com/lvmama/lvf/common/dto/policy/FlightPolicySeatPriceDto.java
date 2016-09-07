package com.lvmama.lvf.common.dto.policy;

import java.io.Serializable;
import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.SeatClassType;
import com.lvmama.lvf.common.dto.md.SeatClass;

public class FlightPolicySeatPriceDto extends Entity implements Serializable {
	
	/** serialVersionUID */
	private static final long serialVersionUID = -8713736919331049755L;
	
	/** 政策表主键*/
	private Long policyId;
	
	/** 舱位类型枚举 */
	private SeatClassType seatClassType; 
	
	/** 适用舱位 */
	private SeatClass seatClass;
	
	/** 舱位报价 */
	private BigDecimal seatPrice;
	
	public Long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}
	public SeatClassType getSeatClassType() {
		return seatClassType;
	}
	public void setSeatClassType(SeatClassType seatClassType) {
		this.seatClassType = seatClassType;
	}

	public SeatClass getSeatClass() {
		return seatClass;
	}
	public void setSeatClass(SeatClass seatClass) {
		this.seatClass = seatClass;
	}
	public BigDecimal getSeatPrice() {
		return seatPrice;
	}
	public void setSeatPrice(BigDecimal seatPrice) {
		this.seatPrice = seatPrice;
	}
	
	
	
}
