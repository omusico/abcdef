package com.lvmama.lvf.common.dto.policy;

import com.lvmama.lvf.common.dto.AEEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 机票政策详细库存信息
 * 
 * @author yuanweihong
 * @date   2015-1-14
 */
public class FlightPolicyDailyInventoryDto extends AEEntity implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 8367218360050958441L;

    private Long policyId;
	
	/** 入库日期 */
	private Date departureTime;
	
	/** 库存数量 */
	private BigDecimal inventoryCount;
	
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public BigDecimal getInventoryCount() {
		return inventoryCount;
	}
	public void setInventoryCount(BigDecimal inventoryCount) {
		this.inventoryCount = inventoryCount;
	}

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }
}
