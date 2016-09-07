package com.lvmama.lvfit.common.dto.order;

import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.Entity;

public class FitOrderRoomDiffDto extends Entity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**份数*/
	private Long selectCount;
	/**价格*/
	private BigDecimal selectPrice;
	/** 主订单主键 */
    private Long orderMainId;
    
	public Long getSelectCount() {
		return selectCount;
	}
	public void setSelectCount(Long selectCount) {
		this.selectCount = selectCount;
	}
	public BigDecimal getSelectPrice() {
		return selectPrice;
	}
	public void setSelectPrice(BigDecimal selectPrice) {
		this.selectPrice = selectPrice;
	}
	public Long getOrderMainId() {
		return orderMainId;
	}
	public void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}

}
