package com.lvmama.lvf.common.form.booking;

import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.enums.InventoryStatus;

public class BookingVerifyDetailRForm {

	/** 航班号 */
	private String flightNo;
	
	/** 舱位代码 */
	private String seatClassCode;
	
	/** 库存状态 */
	private InventoryStatus inventoryStatus;  
	
	/** 库存数量*/
	private Integer inventoryCount;
	
	/** 政策主键 */
	private Long policyId;
	
	/** 票面价 */
	private BigDecimal parPrice;
	
	/** 舱位是否足够 */
	private Integer isSeatEnough;

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

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public BigDecimal getParPrice() {
		return parPrice;
	}

	public void setParPrice(BigDecimal parPrice) {
		this.parPrice = parPrice;
	}

	public Integer getIsSeatEnough() {
		return isSeatEnough;
	}

	public void setIsSeatEnough(Integer isSeatEnough) {
		this.isSeatEnough = isSeatEnough;
	}
	
}
