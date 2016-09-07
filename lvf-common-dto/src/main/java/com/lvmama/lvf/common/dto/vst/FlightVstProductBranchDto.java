package com.lvmama.lvf.common.dto.vst;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.VSTEntity;

/**
 * VST产品规格
 */
public class FlightVstProductBranchDto extends VSTEntity implements Serializable {

	
	private static final long serialVersionUID = 9030307128470796703L;
	
	/**
	 * vst返回的产品规格id
	 */
	private Long vstProductBranchId;
	
	/**
	 * vst的产品id
	 */
	private Long vstProductId;
	
	/**
	 * 舱位等级代码
	 */
	private String seatClassTypeCode;
	
	/**
	 * 舱位等级名称
	 */
	private String seatClassTypeName;
	

	public Long getVstProductBranchId() {
		return vstProductBranchId;
	}

	public void setVstProductBranchId(Long vstProductBranchId) {
		this.vstProductBranchId = vstProductBranchId;
	}

	public Long getVstProductId() {
		return vstProductId;
	}

	public void setVstProductId(Long vstProductId) {
		this.vstProductId = vstProductId;
	}

	public String getSeatClassTypeCode() {
		return seatClassTypeCode;
	}

	public void setSeatClassTypeCode(String seatClassTypeCode) {
		this.seatClassTypeCode = seatClassTypeCode;
	}

	public String getSeatClassTypeName() {
		return seatClassTypeName;
	}

	public void setSeatClassTypeName(String seatClassTypeName) {
		this.seatClassTypeName = seatClassTypeName;
	}

	@Override
	public String toString() {
		return "FlightVstProductBranchDto [vstProductBranchId="
				+ vstProductBranchId + ", vstProductId=" + vstProductId
				+ ", seatClassTypeCode=" + seatClassTypeCode
				+ ", seatClassTypeName=" + seatClassTypeName + "]";
	}

}
