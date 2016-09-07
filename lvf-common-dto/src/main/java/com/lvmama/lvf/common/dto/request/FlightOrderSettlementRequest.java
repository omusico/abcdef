package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.settlement.FlightOrderSettlementDto;

/**   
 * @Title: FlightOrderSettlementRequest.java 
 * @Package com.lvmama.lvf.common.dto.request 
 * @Description: 结算请求
 * @author Chase_lv
 * @date 2015年4月21日 下午6:08:38 
 */
public class FlightOrderSettlementRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 99421658643522944L;

	private FlightOrderSettlementDto settlementDto = new FlightOrderSettlementDto();
	
	/**
	 * 子订单集合
	 */
	private List<Long> orderIds = new ArrayList<Long>();
	
	/**
	 * 是否执行批量，默认不执行
	 */
	private boolean excuteBatch=false;

	public Long getOrderId() {
		return settlementDto.getOrderId();
	}

	public void setOrderId(Long orderId) {
		settlementDto.setOrderId(orderId);
	}

	public boolean getIsExcuteBatch() {
		return excuteBatch;
	}

	public void setIsExcuteBatch(boolean excuteBatch) {
		this.excuteBatch = excuteBatch;
	}

	public List<Long> getOrderIds() {
		return orderIds;
	}

	public void setOrderIds(List<Long> orderIds) {
		this.orderIds = orderIds;
	}

}
