package com.lvmama.lvf.common.form.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.ExpressType;
import com.lvmama.lvf.common.dto.md.ExpressWay;
import com.lvmama.lvf.common.dto.order.FlightOrderExpressListDto;
import com.lvmama.lvf.common.dto.order.status.ExpressStatus;
import com.lvmama.lvf.common.dto.schedule.TaskConfigDto;
import com.lvmama.lvf.common.form.Form;


public class FlightOrderExpressResultForm implements Serializable, Form {
	/**
	 * 
	 */
	private static final long serialVersionUID = -207112475120755843L;
	
	private FlightOrderExpressListDto expressListDto;
	
	/**邮寄时间*/
	private String orderExpressTime;
	

	public FlightOrderExpressListDto getTaskConfigDto() {
		return expressListDto;
	}

	
	
	public String getOrderMainNo() {
		return expressListDto.getOrderMainNo();
	}



	public void setOrderMainNo(String orderMainNo) {
		expressListDto.setOrderMainNo(orderMainNo);
	}



	public String getOrderExpressTime() {
		return orderExpressTime;
	}



	public void setOrderExpressTime(String orderExpressTime) {
		this.orderExpressTime = orderExpressTime;
	}



	public FlightOrderExpressResultForm(FlightOrderExpressListDto expressListDto) {
		super();
		this.expressListDto = expressListDto;
	}

	public String getExpressStatusName() {
		return expressListDto.getExpressStatusName();
	}

	public void setExpressStatusName(String expressStatusName) {
		expressListDto.setExpressStatusName(expressStatusName);
	}





	public Date getExpressTime() {
		return expressListDto.getExpressTime();
	}



	public void setExpressTime(Date expressTime) {
		expressListDto.setExpressTime(expressTime);
	}



	public String getRemark() {
		return expressListDto.getRemark();
	}

	public void setRemark(String remark) {
		expressListDto.setRemark(remark);
	}

	public FlightOrderExpressListDto getExpressListDto() {
		return expressListDto;
	}

	public void setExpressListDto(FlightOrderExpressListDto expressListDto) {
		this.expressListDto = expressListDto;
	}

	public PersistenceType getPtype() {
		return expressListDto.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		expressListDto.setPtype(ptype);
	}

	public String getSequence() {
		return expressListDto.getSequence();
	}

	public Long getId() {
		return expressListDto.getId();
	}

	public void setId(Long id) {
		expressListDto.setId(id);
	}

	public String getUuid() {
		return expressListDto.getUuid();
	}

	public void setUuid(String uuid) {
		expressListDto.setUuid(uuid);
	}

	public Date getCreateTime() {
		return expressListDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		expressListDto.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return expressListDto.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		expressListDto.setUpdateTime(updateTime);
	}

	public String getDepTime() {
		return expressListDto.getDepTime();
	}

	public void setDepTime(String depTime) {
		expressListDto.setDepTime(depTime);
	}

	public String getOrderNo() {
		return expressListDto.getOrderNo();
	}

	public void setOrderNo(String orderNo) {
		expressListDto.setOrderNo(orderNo);
	}

	public Long getOrderMainId() {
		return expressListDto.getOrderMainId();
	}

	public void setOrderMainId(Long orderMainId) {
		expressListDto.setOrderMainId(orderMainId);
	}

	public Long getOrderId() {
		return expressListDto.getOrderId();
	}

	public void setOrderId(Long orderId) {
		expressListDto.setOrderId(orderId);
	}

	public ExpressStatus getExpressStatus() {
		return expressListDto.getExpressStatus();
	}

	public void setExpressStatus(ExpressStatus expressStatus) {
		expressListDto.setExpressStatus(expressStatus);
	}

	public ExpressType getExpressType() {
		return expressListDto.getExpressType();
	}

	public void setExpressType(ExpressType expressType) {
		expressListDto.setExpressType(expressType);
	}

	public ExpressWay getExpressWay() {
		return expressListDto.getExpressWay();
	}

	public void setExpressWay(ExpressWay expressWay) {
		expressListDto.setExpressWay(expressWay);
	}

	public String getAddress() {
		return expressListDto.getAddress();
	}

	public void setAddress(String address) {
		expressListDto.setAddress(address);
	}

	public String getRecipient() {
		return expressListDto.getRecipient();
	}

	public void setRecipient(String recipient) {
		expressListDto.setRecipient(recipient);
	}

	public String getTelephone() {
		return expressListDto.getTelephone();
	}

	public void setTelephone(String telephone) {
		expressListDto.setTelephone(telephone);
	}

	public String getCellphone() {
		return expressListDto.getCellphone();
	}

	public void setCellphone(String cellphone) {
		expressListDto.setCellphone(cellphone);
	}

	public String getPostCode() {
		return expressListDto.getPostCode();
	}

	public void setPostCode(String postCode) {
		expressListDto.setPostCode(postCode);
	}

	public BigDecimal getExpressPrice() {
		return expressListDto.getExpressPrice();
	}

	public void setExpressPrice(BigDecimal expressPrice) {
		expressListDto.setExpressPrice(expressPrice);
	}

	public String getExpressFileNo() {
		return expressListDto.getExpressFileNo();
	}

	public void setExpressFileNo(String expressFileNo) {
		expressListDto.setExpressFileNo(expressFileNo);
	}


	
	
	
}
