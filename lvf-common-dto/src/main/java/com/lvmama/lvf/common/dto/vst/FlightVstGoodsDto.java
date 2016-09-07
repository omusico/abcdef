package com.lvmama.lvf.common.dto.vst;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.VSTEntity;
import com.lvmama.lvf.common.dto.flight.FlightSeatDto;

/**
 * VST商品dto
 */
public class FlightVstGoodsDto extends VSTEntity implements Serializable {

	private static final long serialVersionUID = -7756765749628428997L;
	
	/** vst返回的商品id */
	private Long vstGoodsId;	
	
	/** vst产品id */
	private Long vstProductId;
	
	/** vst基础航班id */
	private Long vstBasicFlightId;
	
	/** 舱位代码 */
	private String seatClassCode;
	
	/** vst产品规格id */
	private Long vstProductBranchId;
	
	/** 基础航班信息 */
	private FlightVstBasicFlightDto vstBasicFlightDto;
	
	/** T_FFLI_SEAT航班舱位表的主键 */
	private Long fliSeatId;
	
	/** 舱位信息 */
	private FlightSeatDto fliSeatDto;
	
	private Date updateStartTime;
	
	public Long getVstGoodsId() {
		return vstGoodsId;
	}

	public void setVstGoodsId(Long vstGoodsId) {
		this.vstGoodsId = vstGoodsId;
	}

	public Long getVstProductId() {
		return vstProductId;
	}

	public void setVstProductId(Long vstProductId) {
		this.vstProductId = vstProductId;
	}

	public Long getVstBasicFlightId() {
		return vstBasicFlightId;
	}

	public void setVstBasicFlightId(Long vstBasicFlightId) {
		this.vstBasicFlightId = vstBasicFlightId;
	}

	public String getSeatClassCode() {
		return seatClassCode;
	}

	public void setSeatClassCode(String seatClassCode) {
		this.seatClassCode = seatClassCode;
	}

	public Long getVstProductBranchId() {
		return vstProductBranchId;
	}

	public void setVstProductBranchId(Long vstProductBranchId) {
		this.vstProductBranchId = vstProductBranchId;
	}

	public FlightVstBasicFlightDto getVstBasicFlightDto() {
		return vstBasicFlightDto;
	}

	public void setVstBasicFlightDto(FlightVstBasicFlightDto vstBasicFlightDto) {
		this.vstBasicFlightDto = vstBasicFlightDto;
	}
	
	public Long getFliSeatId() {
		return fliSeatId;
	}

	public void setFliSeatId(Long fliSeatId) {
		this.fliSeatId = fliSeatId;
	}

	public FlightSeatDto getFliSeatDto() {
		return fliSeatDto;
	}

	public void setFliSeatDto(FlightSeatDto fliSeatDto) {
		this.fliSeatDto = fliSeatDto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fliSeatId == null) ? 0 : fliSeatId.hashCode());
		result = prime * result
				+ ((seatClassCode == null) ? 0 : seatClassCode.hashCode());
		result = prime
				* result
				+ ((vstBasicFlightId == null) ? 0 : vstBasicFlightId.hashCode());
		result = prime
				* result
				+ ((vstProductBranchId == null) ? 0 : vstProductBranchId
						.hashCode());
		result = prime * result
				+ ((vstProductId == null) ? 0 : vstProductId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightVstGoodsDto other = (FlightVstGoodsDto) obj;
		if (fliSeatId == null) {
			if (other.fliSeatId != null)
				return false;
		} else if (!fliSeatId.equals(other.fliSeatId))
			return false;
		if (seatClassCode == null) {
			if (other.seatClassCode != null)
				return false;
		} else if (!seatClassCode.equals(other.seatClassCode))
			return false;
		if (vstBasicFlightId == null) {
			if (other.vstBasicFlightId != null)
				return false;
		} else if (!vstBasicFlightId.equals(other.vstBasicFlightId))
			return false;
		if (vstProductBranchId == null) {
			if (other.vstProductBranchId != null)
				return false;
		} else if (!vstProductBranchId.equals(other.vstProductBranchId))
			return false;
		if (vstProductId == null) {
			if (other.vstProductId != null)
				return false;
		} else if (!vstProductId.equals(other.vstProductId))
			return false;
		
		if (getActiveStatus().getActiveStatus() == null) {
			if (other.getActiveStatus().getActiveStatus() != null)
				return false;
		}else if(other.getActiveStatus()==null&&getActiveStatus().getActiveStatus() != null){
			return false;
		}else if (!getActiveStatus().getActiveStatus().equals(other.getActiveStatus().getActiveStatus()))
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "FlightVstGoodsDto [vstGoodsId=" + vstGoodsId
				+ ", vstProductId=" + vstProductId + ", vstBasicFlightId="
				+ vstBasicFlightId + ", seatClassCode=" + seatClassCode
				+ ", vstProductBranchId=" + vstProductBranchId
				+ ", vstBasicFlightDto=" + vstBasicFlightDto + ", fliSeatId="
				+ fliSeatId + ", fliSeatDto=" + fliSeatDto + "]";
	}

	public Date getUpdateStartTime() {
		return updateStartTime;
	}

	public void setUpdateStartTime(Date updateStartTime) {
		this.updateStartTime = updateStartTime;
	}
}
