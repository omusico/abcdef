package com.lvmama.lvf.common.dto.booking;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.enums.InventoryStatus;

/**
 * 预订验舱返回的舱位信息
 * @author majun
 * @date   2015-2-10
 */
public class FlightBookingSeatInfoDto implements Serializable
{
	private static final long serialVersionUID = -725646795704369625L;
	
	/** 航班号 */
	private String flightNo;
	
	/** 舱位代码 */
	private String seatClassCode;
	
	/** 库存状态 */
	private InventoryStatus inventoryStatus;  
	
	/** 库存数量*/
	private Integer inventoryCount;

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
	
}
