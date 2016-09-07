package com.lvmama.lvf.common.form.vst;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.enums.SeatClassType;
import com.lvmama.lvf.common.dto.status.BatchFlag;
import com.lvmama.lvf.common.dto.vst.FlightVstGoodsTimePriceDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

public class VSTGoodsTimePriceResponseForm implements Serializable, Form {
	
	private static final long serialVersionUID = 2072670579737056471L;
	
	private FlightVstGoodsTimePriceDto goodsTimePrice = new FlightVstGoodsTimePriceDto();

	public BatchFlag getBatchFlag() {
		return goodsTimePrice.getBatchFlag();
	}

	public void setBatchFlag(BatchFlag batchFlag) {
		goodsTimePrice.setBatchFlag(batchFlag);
	}
	
	public FlightVstGoodsTimePriceDto getGoodsTimePrice() {
		return goodsTimePrice;
	}

	public void setGoodsTimePrice(FlightVstGoodsTimePriceDto goodsTimePrice) {
		this.goodsTimePrice = goodsTimePrice;
	}
	
	public Long getVstGoodsId() {
		return goodsTimePrice.getVstGoodsId();
	}

	public void setVstGoodsId(Long vstGoodsId) {
		goodsTimePrice.setVstGoodsId(vstGoodsId);
	}

	public Long getDepartureDate() {
		return goodsTimePrice.getDepartureDate();
	}

	public void setDepartureDate(Long departureDate) {
		goodsTimePrice.setDepartureDate(departureDate);
	}

	public String getFlightNo() {
		return goodsTimePrice.getFlightNo();
	}

	public void setFlightNo(String flightNo) {
		goodsTimePrice.setFlightNo(flightNo);
	}

	public String getFlightSeatCode() {
		return goodsTimePrice.getFlightSeatCode();
	}

	public void setFlightSeatCode(String flightSeatCode) {
		goodsTimePrice.setFlightSeatCode(flightSeatCode);
	}

	public String getMd5Sign() {
		return goodsTimePrice.getMd5Sign();
	}

	public void setMd5Sign(String md5Sign) {
		goodsTimePrice.setMd5Sign(md5Sign);
	}

	public Date getDepartureTime() {
		return goodsTimePrice.getDepartureTime();
	}

	public void setDepartureTime(Date departureTime) {
		goodsTimePrice.setDepartureTime(departureTime);
	}

	public BigDecimal getParPrice() {
		return goodsTimePrice.getParPrice();
	}

	public void setParPrice(BigDecimal parPrice) {
		goodsTimePrice.setParPrice(parPrice);
	}

	public SeatClassType getSeatClassType() {
		return goodsTimePrice.getSeatClassType();
	}

	public void setSeatClassType(SeatClassType seatClassType) {
		goodsTimePrice.setSeatClassType(seatClassType);
	}

	public Long getFlightInfoId() {
		return goodsTimePrice.getFlightInfoId();
	}

	public void setFlightInfoId(Long flightInfoId) {
		goodsTimePrice.setFlightInfoId(flightInfoId);
	}

	public BigDecimal getFuelSurTax() {
		return goodsTimePrice.getFuelSurTax();
	}

	public void setFuelSurTax(BigDecimal fuelSurTax) {
		goodsTimePrice.setFuelSurTax(fuelSurTax);
	}

	public BigDecimal getAirportFee() {
		return goodsTimePrice.getAirportFee();
	}

	public void setAirportFee(BigDecimal airportFee) {
		goodsTimePrice.setAirportFee(airportFee);
	}

	public BigDecimal getChildrenFuelsurTax() {
		return goodsTimePrice.getChildrenFuelsurTax();
	}

	public void setChildrenFuelsurTax(BigDecimal childrenFuelsurTax) {
		goodsTimePrice.setChildrenFuelsurTax(childrenFuelsurTax);
	}

	public BigDecimal getChildrenAirportFee() {
		return goodsTimePrice.getChildrenAirportFee();
	}

	public void setChildrenAirportFee(BigDecimal childrenAirportFee) {
		goodsTimePrice.setChildrenAirportFee(childrenAirportFee);
	}
	
	public Date getUpdateTime(){
		return goodsTimePrice.getUpdateTime();
	}
	
	public void setUpdateTime(Date updateTime){
		goodsTimePrice.setUpdateTime(updateTime);
	}
	
	public Date getCreateTime(){
		return goodsTimePrice.getCreateTime();
	}
	
	public void setCreateTime(Date createTime){
		goodsTimePrice.setCreateTime(createTime);
	}
	
	public String getUpdateTimeStr(){
		if(this.getUpdateTime()!=null){
			return DateUtils.formatDate(this.getUpdateTime(), DateUtils.YYYY_MM_DD_HH_MM_SS);
		}
		return null;
	}
	
	public String getCreateTimeStr(){
		if(this.getCreateTime()!=null){
			return DateUtils.formatDate(this.getCreateTime(), DateUtils.YYYY_MM_DD_HH_MM_SS);
		}
		return null;
	}
	
	public String getDeptDateStr(){
		if(this.getDepartureDate()!=null){
			return DateUtils.formatDate(this.getDepartureDate(), DateUtils.YYYY_MM_DD);
		}
		return null;
	}

}
