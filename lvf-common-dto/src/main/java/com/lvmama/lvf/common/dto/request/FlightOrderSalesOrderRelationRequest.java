package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.enums.BindingStatus;
import com.lvmama.lvf.common.dto.enums.BindingType;
import com.lvmama.lvf.common.dto.enums.BookingSourceType;
import com.lvmama.lvf.common.dto.order.FlightOrderSalesOrderRelationDto;

/**
 * @date   2015年6月15日
 */
public class FlightOrderSalesOrderRelationRequest implements Serializable{
	private static final long serialVersionUID = 1423213230488786465L;
	
	private FlightOrderSalesOrderRelationDto relationDto = new FlightOrderSalesOrderRelationDto();

	public Long getId() {
		return relationDto.getId();
	}

	public void setId(Long id) {
		relationDto.setId(id);
	}

	public Long getLvfMainOrderId() {
		return relationDto.getLvfMainOrderId();
	}

	public void setLvfMainOrderId(Long lvfMainOrderId) {
		relationDto.setLvfMainOrderId(lvfMainOrderId);
	}

	public String getLvfMainOrderNo() {
		return relationDto.getLvfMainOrderNo();
	}

	public void setLvfMainOrderNo(String lvfMainOrderNo) {
		relationDto.setLvfMainOrderNo(lvfMainOrderNo);
	}

	public BindingStatus getBindingStatus() {
		return relationDto.getBindingStatus();
	}

	public void setBindingStatus(BindingStatus bindingStatus) {
		relationDto.setBindingStatus(bindingStatus);
	}
	
	public Long getSalesMainOrderId(){
		return relationDto.getSalesMainOrderId();
	}
	
	public void setSalesMainOrderId(Long salesMainOrderId){
		relationDto.setSalesMainOrderId(salesMainOrderId);
	}
	
	public Long getSalesOrderId(){
		return relationDto.getSalesOrderId();
	}
	
	public void setSalesOrderId(Long salesOrderId){
		relationDto.setSalesOrderId(salesOrderId);
	}

	public FlightOrderSalesOrderRelationDto getRelationDto() {
		return relationDto;
	}

	public void setRelationDto(FlightOrderSalesOrderRelationDto relationDto) {
		this.relationDto = relationDto;
	}

	public Long getLvfOrderId() {
		return relationDto.getLvfOrderId();
	}

	public void setLvfOrderId(Long lvfOrderId) {
		relationDto.setLvfOrderId(lvfOrderId);
	}

	public String getLvfOrderNo() {
		return relationDto.getLvfOrderNo();
	}

	public void setLvfOrderNo(String lvfOrderNo) {
		relationDto.setLvfOrderNo(lvfOrderNo);
	}

	public BindingType getBindingType() {
		return relationDto.getBindingType();
	}

	public void setBindingType(BindingType bindingType) {
		relationDto.setBindingType(bindingType);
	}

	public BookingSourceType getBookingSourceType() {
		return relationDto.getBookingSourceType();
	}

	public void setBookingSourceType(BookingSourceType bookingSourceType) {
		relationDto.setBookingSourceType(bookingSourceType);
	}
	
	public String getLockSeatOrderId() {
		return relationDto.getLockSeatOrderId();
	}

	public void setLockSeatOrderId(String lockSeatOrderId) {
		relationDto.setLockSeatOrderId(lockSeatOrderId);;
	}

}
