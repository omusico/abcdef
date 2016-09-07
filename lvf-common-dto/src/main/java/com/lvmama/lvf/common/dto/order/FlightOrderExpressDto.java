package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.ExpressType;
import com.lvmama.lvf.common.dto.md.ExpressWay;
import com.lvmama.lvf.common.dto.order.status.ExpressStatus;

/**
 * 订单快递信息
 * @author majun
 * @date   2015-1-19
 */
public class FlightOrderExpressDto extends Entity implements Serializable 
{
	private static final long serialVersionUID = 2907679191498843723L;
	
	/** 主订单主键 */
	private Long orderMainId;
	
	/** 订单主键 */
	private Long orderId;
	
	/** 快递状态 */
	private ExpressStatus expressStatus; 
	
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
	
	/** 邮寄世间*/
	private Date expressTime;
	
	private String remark;



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
	
	
	
	/**
	 * 从请求中复制数据
	 * @param requestOrderExpressDto
	 */
	public void copyFromDto(FlightOrderExpressDto requestOrderExpressDto){
		this.setAddress(requestOrderExpressDto.getAddress());
		this.setCellphone(requestOrderExpressDto.getCellphone());
		this.setPostCode(requestOrderExpressDto.getPostCode());
		this.setRecipient(requestOrderExpressDto.getRecipient());
		this.setTelephone(requestOrderExpressDto.getTelephone());
		this.setExpressFileNo(requestOrderExpressDto.getExpressFileNo());
		this.setExpressPrice(requestOrderExpressDto.getExpressPrice());
		this.setExpressStatus(requestOrderExpressDto.getExpressStatus());
		this.setExpressType(requestOrderExpressDto.getExpressType());
		this.setExpressWay(requestOrderExpressDto.getExpressWay());
	}
	
	@Override
	@JsonIgnore
	public String getSequence() {
		return "S_FORD_EXPRESS";
	}
	
}
