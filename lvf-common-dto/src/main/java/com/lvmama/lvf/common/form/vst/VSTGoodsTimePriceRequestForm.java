package com.lvmama.lvf.common.form.vst;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.SeatClassType;
import com.lvmama.lvf.common.dto.status.BatchFlag;
import com.lvmama.lvf.common.dto.vst.FlightVstGoodsTimePriceDto;
import com.lvmama.lvf.common.form.Form;

public class VSTGoodsTimePriceRequestForm implements Serializable, Form {

	private static final long serialVersionUID = 6958988036676721692L;
	
	private FlightVstGoodsTimePriceDto goodsTimePrice = new FlightVstGoodsTimePriceDto();
	
	private Pagination pagination = new Pagination();
	
	private String deptBeginDate;
	
	private String deptEndDate;
	
	private Long deptStartDate;
	
	private String updateBeginTime;
	
	private String updateEndTime;
	
	private Date updateStartTime;
	
	private Long vstProductId;
	
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

	public Long getVstProductId() {
		return vstProductId;
	}

	public void setVstProductId(Long vstProductId) {
		this.vstProductId = vstProductId;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public int getPage() {
		return pagination.getPage();
	}

	public void setPage(int page) {
		pagination.setPage(page);
	}

	public int getRows() {
		return pagination.getRows();
	}

	public void setRows(int rows) {
		pagination.setRows(rows);
	}

	public int getRecords() {
		return pagination.getRecords();
	}

	public void setRecords(int records) {
		pagination.setRecords(records);
	}

	public void countRecords(int records) {
		pagination.countRecords(records);
	}

	public int getTotal() {
		return pagination.getTotal();
	}

	public void setTotal(int total) {
		pagination.setTotal(total);
	}

	public String getSidx() {
		return pagination.getSidx();
	}

	public void setSidx(String sidx) {
		pagination.setSidx(sidx);
	}

	public String getSord() {
		return pagination.getSord();
	}

	public void setSord(String sord) {
		pagination.setSord(sord);
	}

	public int getStartRow() {
		return pagination.getStartRow();
	}

	public int getEndRow() {
		return pagination.getEndRow();
	}

	public boolean isSearch() {
		return pagination.isSearch();
	}

	public void setSearch(boolean search) {
		pagination.setSearch(search);
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

	public Date getUpdateStartTime() {
		return updateStartTime;
	}

	public void setUpdateStartTime(Date updateStartTime) {
		this.updateStartTime = updateStartTime;
	}

	public String getDeptBeginDate() {
		return deptBeginDate;
	}

	public void setDeptBeginDate(String deptBeginDate) {
		this.deptBeginDate = deptBeginDate;
	}

	public Long getDeptStartDate() {
		return deptStartDate;
	}

	public void setDeptStartDate(Long deptStartDate) {
		this.deptStartDate = deptStartDate;
	}

	public String getUpdateBeginTime() {
		return updateBeginTime;
	}

	public void setUpdateBeginTime(String updateBeginTime) {
		this.updateBeginTime = updateBeginTime;
	}

	public String getUpdateEndTime() {
		return updateEndTime;
	}

	public void setUpdateEndTime(String updateEndTime) {
		this.updateEndTime = updateEndTime;
	}

	public String getDeptEndDate() {
		return deptEndDate;
	}
	
	public void setDeptEndDate(String deptEndTime){
		this.deptEndDate = deptEndTime;
	}

	
	
}
