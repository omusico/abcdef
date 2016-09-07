package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import com.lvmama.lvf.common.dto.Entity;

@XmlAccessorType(XmlAccessType.FIELD)
public class FlightOrderOperDto extends Entity implements Serializable
{
	private static final long serialVersionUID = -8962059698539864290L;
	
	/** 订单主键 */
	private Long orderId;
	
	/** 操作者 */
	public String oper;
	
	/** 备注 */
	public String remark;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
