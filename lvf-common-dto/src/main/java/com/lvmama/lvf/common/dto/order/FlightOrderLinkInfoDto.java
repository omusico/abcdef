package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.LinkStatus;
import com.lvmama.lvf.common.dto.enums.OrderLinkType;

/** 订单关联子订单信息 */
public class FlightOrderLinkInfoDto extends Entity  implements Serializable 
{	
	private static final long serialVersionUID = 4788730562171209498L;
	
	/** 订单主键 */
	private Long orderId;
	
	/** 关联子订单订单号 */
	private String linkOrderNo;
	
	/** 订单关联类型 */
	private OrderLinkType orderLinkType;
	
	/** 关联子订单状态 */
	private LinkStatus linkStatus;
	
	/** 子订单URL */
	private String linkUrl;
	
	/** 描述 */
	private String linkDesc;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getLinkOrderNo() {
		return linkOrderNo;
	}

	public void setLinkOrderNo(String linkOrderNo) {
		this.linkOrderNo = linkOrderNo;
	}

	public OrderLinkType getOrderLinkType() {
		return orderLinkType;
	}

	public void setOrderLinkType(OrderLinkType orderLinkType) {
		this.orderLinkType = orderLinkType;
	}

	public LinkStatus getLinkStatus() {
		return linkStatus;
	}

	public void setLinkStatus(LinkStatus linkStatus) {
		this.linkStatus = linkStatus;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getLinkDesc() {
		return linkDesc;
	}

	public void setLinkDesc(String linkDesc) {
		this.linkDesc = linkDesc;
	}
	
	@Override
	@JsonIgnore
	public String getSequence() {
		return "S_FORD_LINK_INFO";
	}
}
