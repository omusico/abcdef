package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.md.SeatClassCarrier;
import com.lvmama.lvf.common.dto.md.SeatRule;

public class SeatClassCarrierRequest implements Serializable,Dto{

	private static final long serialVersionUID = 8019336245583049723L;

	/** 舱位 */
	private String name;

	/** 舱位代码 */
	private String code;

	/** 航空公司 */
	private String carrierCode;
	
	private SeatClassCarrier seatClassCarrier;
	
	//private List<SeatRule> seatRules;
	private List<SeatRuleRequest> seatRuleRequest;
	
	
	


	public List<SeatRuleRequest> getSeatRuleRequest() {
		return seatRuleRequest;
	}

	public void setSeatRuleRequest(List<SeatRuleRequest> seatRuleRequest) {
		this.seatRuleRequest = seatRuleRequest;
	}

	@Override
	public Long getId() {
		return null;
	}
	
	public SeatClassCarrier getSeatClassCarrier() {
		return seatClassCarrier;
	}
	
	public void setSeatClassCarrier(SeatClassCarrier seatClassCarrier) {
		this.seatClassCarrier = seatClassCarrier;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCarrierCode() {
		return carrierCode;
	}
	
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}
}
