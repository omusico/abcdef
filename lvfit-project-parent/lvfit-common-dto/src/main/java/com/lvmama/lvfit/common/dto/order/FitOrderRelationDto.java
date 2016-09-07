package com.lvmama.lvfit.common.dto.order;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.BindingStatus;

/**
 * 订单与外部订单关系
 * @author qihuisong
 *
 */
public class FitOrderRelationDto extends Entity{

	/**
	 * 外部子订单Id
	 */
	private Long salesOrderId;
	
	/**
	 * 外部主订单id
	 */
	private Long salesMainOrderId;
	
	/**
	 * 主订单id
	 */
	private Long orderMainId;
	
	/**
	 * 主订单编号
	 */
	private String orderMainNo;
	
	/**
	 * 是否绑定
	 */
	private BindingStatus bindingStatus;

	public Long getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(Long salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public Long getSalesMainOrderId() {
		return salesMainOrderId;
	}

	public void setSalesMainOrderId(Long salesMainOrderId) {
		this.salesMainOrderId = salesMainOrderId;
	}

	public String getOrderMainNo() {
		return orderMainNo;
	}

	public void setOrderMainNo(String orderMainNo) {
		this.orderMainNo = orderMainNo;
	}

	public Long getOrderMainId() {
		return orderMainId;
	}

	public void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}

	public BindingStatus getBindingStatus() {
		return bindingStatus;
	}

	public void setBindingStatus(BindingStatus bindingStatus) {
		this.bindingStatus = bindingStatus;
	}

}
