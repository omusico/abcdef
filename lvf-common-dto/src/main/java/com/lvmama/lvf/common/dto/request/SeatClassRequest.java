package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.List;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.SeatClassStatus;
import com.lvmama.lvf.common.dto.md.SeatClass;

public class SeatClassRequest implements Serializable,Dto{

	private static final long serialVersionUID = 2598631270469740929L;
	
	/** 舱位 */
	private String name;

	/** 舱位代码 */
	private String code;

	/** 航空公司 */
	private String carrierCode;
	
	private SeatClass seatClass;
	
	private SeatClassStatus seatClassStatus;
	//private List<SeatRule> seatRules;
	private List<SeatRuleRequest> seatRuleRequest;
	
	@Override
	public Long getId() {
		return null;
	}
	
	public SeatClass getSeatClass() {
		return seatClass;
	}
	
	public void setSeatClass(SeatClass seatClass) {
		this.seatClass = seatClass;
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

	public List<SeatRuleRequest> getSeatRuleRequest() {
		return seatRuleRequest;
	}

	public void setSeatRuleRequest(List<SeatRuleRequest> seatRuleRequest) {
		this.seatRuleRequest = seatRuleRequest;
	}

	public SeatClassStatus getSeatClassStatus() {
		return seatClassStatus;
	}

	public void setSeatClassStatus(SeatClassStatus seatClassStatus) {
		this.seatClassStatus = seatClassStatus;
	}
}
