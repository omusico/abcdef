package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.md.ExpressWay;
import com.lvmama.lvf.common.dto.order.FlightOrderExpressDto;
import com.lvmama.lvf.common.dto.order.status.ExpressStatus;

@XmlRootElement
public class FlightOrderExpressQueryRequest implements Serializable, Dto {

	private static final long serialVersionUID = 2364651782886324883L;

	private Long id;	
	
	private Long orderId;
	private Long orderMainId;
	
	private String orderNo;
	
	/** 航班日期 */
	private String depTime;
	/** 查询起止日期 */
	private String startTime;
	private String endTime;
	
	/** 收件人 */
	private String recipient;
	
	/** 手机号码 */
	private String cellphone;
	
	/** 快递状态 */
	private ExpressStatus expressStatus; 
	
	/** 邮寄世间*/
	private String expressTime;
	
	private String remark;
	
	/** 快递文件号 */
	private String expressFileNo;
	
	/** 快递方式 */
	private ExpressWay expressWay;
	

	
	
	public String getStartTime() {
		return startTime;
	}



	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}



	public String getEndTime() {
		return endTime;
	}



	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}



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



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}



	public String getExpressFileNo() {
		return expressFileNo;
	}



	public void setExpressFileNo(String expressFileNo) {
		this.expressFileNo = expressFileNo;
	}



	public ExpressWay getExpressWay() {
		return expressWay;
	}



	public void setExpressWay(ExpressWay expressWay) {
		this.expressWay = expressWay;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getDepTime() {
		return depTime;
	}

	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public ExpressStatus getExpressStatus() {
		return expressStatus;
	}

	public void setExpressStatus(ExpressStatus expressStatus) {
		this.expressStatus = expressStatus;
	}












	public String getExpressTime() {
		return expressTime;
	}



	public void setExpressTime(String expressTime) {
		this.expressTime = expressTime;
	}



	public Long getId() {
		return id;
	}


	
}

