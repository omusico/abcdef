package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.ExpressType;
import com.lvmama.lvf.common.dto.md.ExpressWay;
import com.lvmama.lvf.common.dto.order.status.ExpressStatus;

/**
 * 订单快递信息list
 */
public class FlightOrderExpressListDto extends Entity implements Serializable {

	private static final long serialVersionUID = 456232004786211397L;

	/** 主订单主键 */
	private Long orderMainId;
	
	/** 订单主键 */
	private Long orderId;
	
	/** 快递状态 */
	private ExpressStatus expressStatus; 
	private String expressStatusName; 
	
	/** 快递类型 */
	private ExpressType expressType; 
	
	/** 快递方式 */
	private ExpressWay expressWay;
	
	/** 地址 */
	private String address;
	
	/** 收件人 */
	private String recipient;
	
	/** 电话号码 */
	private String telephone;
	
	/** 手机号码 */
	private String cellphone;
	
	/** 邮政编码 */
	private String postCode;
	
	/** 快递费 */
	private BigDecimal expressPrice;
	
	/** 快递文件号 */
	private String expressFileNo;
	
	/**
	 * 	列表新增
	 */	
	private String depTime;
    
	private String orderNo;
	private String orderMainNo;
	
	private Date expressTime;
	
	private String remark;
	
	
	
	
	


	public String getOrderMainNo() {
		return orderMainNo;
	}

	public void setOrderMainNo(String orderMainNo) {
		this.orderMainNo = orderMainNo;
	}

	public String getExpressStatusName() {
		return expressStatusName;
	}

	public void setExpressStatusName(String expressStatusName) {
		this.expressStatusName = expressStatusName;
	}





	public Date getExpressTime() {
		return expressTime;
	}

	public void setExpressTime(Date expressTime) {
		this.expressTime = expressTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDepTime() {
		return depTime;
	}

	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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

	public ExpressStatus getExpressStatus() {
		return expressStatus;
	}

	public void setExpressStatus(ExpressStatus expressStatus) {
		this.expressStatus = expressStatus;
	}

	public ExpressType getExpressType() {
		return expressType;
	}

	public void setExpressType(ExpressType expressType) {
		this.expressType = expressType;
	}

	public ExpressWay getExpressWay() {
		return expressWay;
	}

	public void setExpressWay(ExpressWay expressWay) {
		this.expressWay = expressWay;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public BigDecimal getExpressPrice() {
		return expressPrice;
	}

	public void setExpressPrice(BigDecimal expressPrice) {
		this.expressPrice = expressPrice;
	}

	public String getExpressFileNo() {
		return expressFileNo;
	}

	public void setExpressFileNo(String expressFileNo) {
		this.expressFileNo = expressFileNo;
	}

}
