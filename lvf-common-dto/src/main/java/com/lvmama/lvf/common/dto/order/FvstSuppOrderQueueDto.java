package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.PackageOrderStatus;

/**
 * 自动补单配置dto
 * 
 * @author zengzhimin
 * @date 2016-08-12
 */
public class FvstSuppOrderQueueDto extends  Entity implements Serializable  {

	private static final long serialVersionUID = -8696022710694240305L;

	/** 主订单主键 */
	private Long orderMainId;

	/** 订单主键 */
	private Long orderId;
	
	/**下单错误码*/
	private String errCode;
	
	/**自动补单次数**/
	private Integer sysCounts;
	
	/**补单状态**/
	private PackageOrderStatus packageOrderStatus;
	/**vst主单**/
	private String salesMainOrderId;
	/**vst子单**/
	private String  salesOrderId;

	public Long getOrderMainId() {
		return orderMainId;
	}

	public void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public Integer getSysCounts() {
		return sysCounts;
	}

	public void setSysCounts(Integer sysCounts) {
		this.sysCounts = sysCounts;
	}

	public PackageOrderStatus getPackageOrderStatus() {
		return packageOrderStatus;
	}

	public void setPackageOrderStatus(PackageOrderStatus packageOrderStatus) {
		this.packageOrderStatus = packageOrderStatus;
	}

	public String getSalesMainOrderId() {
		return salesMainOrderId;
	}

	public void setSalesMainOrderId(String salesMainOrderId) {
		this.salesMainOrderId = salesMainOrderId;
	}

	public String getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(String salesOrderId) {
		this.salesOrderId = salesOrderId;
	}
	
	
	
	
}
	