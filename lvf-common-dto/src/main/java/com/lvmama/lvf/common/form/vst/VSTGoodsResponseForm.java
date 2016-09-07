package com.lvmama.lvf.common.form.vst;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.flight.FlightSeatDto;
import com.lvmama.lvf.common.dto.vst.FlightVstBasicFlightDto;
import com.lvmama.lvf.common.dto.vst.FlightVstGoodsDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

public class VSTGoodsResponseForm implements Form, Serializable {

	private static final long serialVersionUID = -8645895946570250435L;
	
	private FlightVstGoodsDto goodsDto = new FlightVstGoodsDto();
	
	
	public FlightVstGoodsDto getGoodsDto() {
		return goodsDto;
	}

	public void setGoodsDto(FlightVstGoodsDto goodsDto) {
		this.goodsDto = goodsDto;
	}

	public Long getVstGoodsId() {
		return goodsDto.getVstGoodsId();
	}

	public void setVstGoodsId(Long vstGoodsId) {
		goodsDto.setVstGoodsId(vstGoodsId);
	}

	public Long getVstProductId() {
		return goodsDto.getVstProductId();
	}

	public void setVstProductId(Long vstProductId) {
		goodsDto.setVstProductId(vstProductId);
	}

	public Long getVstBasicFlightId() {
		return goodsDto.getVstBasicFlightId();
	}

	public void setVstBasicFlightId(Long vstBasicFlightId) {
		goodsDto.setVstBasicFlightId(vstBasicFlightId);
	}

	public String getSeatClassCode() {
		return goodsDto.getSeatClassCode();
	}

	public void setSeatClassCode(String seatClassCode) {
		goodsDto.setSeatClassCode(seatClassCode);
	}

	public Long getVstProductBranchId() {
		return goodsDto.getVstProductBranchId();
	}

	public void setVstProductBranchId(Long vstProductBranchId) {
		goodsDto.setVstProductBranchId(vstProductBranchId);
	}

	public FlightVstBasicFlightDto getVstBasicFlightDto() {
		return goodsDto.getVstBasicFlightDto();
	}

	public void setVstBasicFlightDto(FlightVstBasicFlightDto vstBasicFlightDto) {
		goodsDto.setVstBasicFlightDto(vstBasicFlightDto);
	}
	
	public Long getFliSeatId() {
		return goodsDto.getFliSeatId();
	}

	public void setFliSeatId(Long fliSeatId) {
		goodsDto.setFliSeatId(fliSeatId);
	}

	public FlightSeatDto getFliSeatDto() {
		return goodsDto.getFliSeatDto();
	}

	public void setFliSeatDto(FlightSeatDto fliSeatDto) {
		goodsDto.setFliSeatDto(fliSeatDto);
	}

	public Date getUpdateStartTime() {
		return goodsDto.getUpdateStartTime();
	}

	public void setUpdateStartTime(Date updateStartTime) {
		goodsDto.setUpdateStartTime(updateStartTime);
	}
	
	public Date getUpdateTime(){
		return goodsDto.getUpdateTime();
	}
	
	public void setUpdateTime(Date updateTime){
		goodsDto.setUpdateTime(updateTime);
	}
	
	public Date getCreateTime(){
		return goodsDto.getCreateTime();
	}
	
	public void setCreateTime(Date updateTime){
		goodsDto.setCreateTime(updateTime);
	}

	public String getUpdateTimeStr(){
		if(this.getUpdateTime() != null){
			return DateUtils.formatDate(this.getUpdateTime(), DateUtils.YYYY_MM_DD_HH_MM_SS);
		}
		return null;
	}
	
	public String getCreateTimeStr(){
		if(this.getCreateTime() != null){
			return DateUtils.formatDate(this.getCreateTime(), DateUtils.YYYY_MM_DD_HH_MM_SS);
		}
		return null;
	}
}
