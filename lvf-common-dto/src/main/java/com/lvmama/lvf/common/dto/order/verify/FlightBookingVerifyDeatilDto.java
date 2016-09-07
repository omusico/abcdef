package com.lvmama.lvf.common.dto.order.verify;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.enums.InventoryStatus;
import com.lvmama.lvf.common.dto.md.SeatClass;

public class FlightBookingVerifyDeatilDto extends AEEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2611586360048765783L;
	
	/**舱位信息 */
	private SeatClass seatClass;
	
	/**票面价*/
	private BigDecimal parPrice;
	
	/**(座位)库存数量Ctrip */
	private Integer inventoryCount;
	
	/**库存状态(是否满仓)Ctrip */
	private InventoryStatus inventoryStatus;
	
	/**政策信息 */
	private List<FlightBookingVerifyDeatilPolicyDto> bookingVerifyDeatilPolicys = new ArrayList<FlightBookingVerifyDeatilPolicyDto>();

	public SeatClass getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(SeatClass seatClass) {
		this.seatClass = seatClass;
	}

	public BigDecimal getParPrice() {
		return parPrice;
	}

	public void setParPrice(BigDecimal parPrice) {
		this.parPrice = parPrice;
	}

	public List<FlightBookingVerifyDeatilPolicyDto> getBookingVerifyDeatilPolicys() {
		return bookingVerifyDeatilPolicys;
	}

	public void setBookingVerifyDeatilPolicys(
			List<FlightBookingVerifyDeatilPolicyDto> bookingVerifyDeatilPolicys) {
		this.bookingVerifyDeatilPolicys = bookingVerifyDeatilPolicys;
	}

	public Integer getInventoryCount() {
		return inventoryCount;
	}

	public void setInventoryCount(Integer inventoryCount) {
		this.inventoryCount = inventoryCount;
	}

	public InventoryStatus getInventoryStatus() {
		return inventoryStatus;
	}

	public void setInventoryStatus(InventoryStatus inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}
	

}
