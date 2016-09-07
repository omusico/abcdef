package com.lvmama.lvf.common.dto.booking;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.BaseReponseHandle;
import com.lvmama.lvf.common.dto.calculator.FlightTicketPriceDto;
import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.dto.enums.InventoryStatus;
import com.lvmama.lvf.common.dto.enums.PassengerType;

/**
 * 预订验仓验价返回的信息
 * @author leizhengwei
 * 2015年8月11日
 */
public class FlightBookingVerifySeatAndPriceDto extends BaseReponseHandle implements Serializable{
	
	private static final long serialVersionUID = -3839188519533826591L;

	/** 往返类型 */
	private FlightTripType flightTripType;
	
	/** 航班号 */
	private String flightNo;
	
	/**舱位Code */
	private String seatClassCode;
	
	/** 库存状态 */
	private InventoryStatus inventoryStatus;  
	
	/** 库存数量*/
	private Integer inventoryCount;
	
	/** 验舱验价后重新返回的成人儿童相关价格信息*/
	private FlightTicketPriceDto ticketPrice;
	
	/**乘客类型*/
	private PassengerType passengerType;

	public FlightTripType getFlightTripType() {
		return flightTripType;
	}

	public void setFlightTripType(FlightTripType flightTripType) {
		this.flightTripType = flightTripType;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getSeatClassCode() {
		return seatClassCode;
	}

	public void setSeatClassCode(String seatClassCode) {
		this.seatClassCode = seatClassCode;
	}

	public InventoryStatus getInventoryStatus() {
		return inventoryStatus;
	}

	public void setInventoryStatus(InventoryStatus inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}

	public Integer getInventoryCount() {
		return inventoryCount;
	}

	public void setInventoryCount(Integer inventoryCount) {
		this.inventoryCount = inventoryCount;
	}

	public FlightTicketPriceDto getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(FlightTicketPriceDto ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	

	public PassengerType getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}


}
