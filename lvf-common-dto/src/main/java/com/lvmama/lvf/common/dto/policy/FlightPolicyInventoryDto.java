package com.lvmama.lvf.common.dto.policy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.enums.InventoryType;

@XmlRootElement
public class FlightPolicyInventoryDto implements Serializable {
	
	/** serialVersionUID */
	private static final long serialVersionUID = -4420037178082328645L;
	
	/** 库存类型枚举 */
	private InventoryType inventoryType;
	
	/** 库存信息 */
	private List<FlightPolicyDailyInventoryDto> flightPolicyDailyInventorys = new ArrayList<FlightPolicyDailyInventoryDto>();
	
	
	public InventoryType getInventoryType() {
		return inventoryType;
	}
	public void setInventoryType(InventoryType inventoryType) {
		this.inventoryType = inventoryType;
	}
	public List<FlightPolicyDailyInventoryDto> getFlightPolicyDailyInventorys() {
		return flightPolicyDailyInventorys;
	}
	public void setFlightPolicyDailyInventorys(
			List<FlightPolicyDailyInventoryDto> flightPolicyDailyInventorys) {
		this.flightPolicyDailyInventorys = flightPolicyDailyInventorys;
	}
		
	
	
}
