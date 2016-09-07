package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.OperType;
import com.lvmama.lvf.common.dto.enums.RemarkType;
import com.lvmama.lvf.common.dto.other.AttachmentDto;

/**
 * 订单备注信息
 * @author majun
 * @date   2015-1-19
 */
public class FlightOrderRemarkDto extends Entity implements Serializable,Dto 
{
	private static final long serialVersionUID = 7555301901086077710L;
	
	/** 主订单主键 */
	private Long orderMainId;
	
	/** 订单主键 */
	private Long orderId;
	
	/** 订单号 */
	private FlightOrderNoDto flightOrderNo;
	
	/** 备注类型 */
	private RemarkType remarkType;
	
	/** 备注 */
	private String remark;
	
	/** 操作者 */
	private String oper;
	
	/** 操作者Id */
	private String operId;
	
	/**操作者类型*/
	private OperType operType;
	
	
	
	
	
	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public OperType getOperType() {
		return operType;
	}

	public void setOperType(OperType operType) {
		this.operType = operType;
	}

	private List<AttachmentDto> attachments = new ArrayList<AttachmentDto>();

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

	public FlightOrderNoDto getFlightOrderNo() {
		return flightOrderNo;
	}

	public void setFlightOrderNo(FlightOrderNoDto flightOrderNo) {
		this.flightOrderNo = flightOrderNo;
	}

	public RemarkType getRemarkType() {
		return remarkType;
	}

	public void setRemarkType(RemarkType remarkType) {
		this.remarkType = remarkType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<AttachmentDto> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<AttachmentDto> attachments) {
		this.attachments = attachments;
	}
 
    
}