package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 优惠券使用和废除
 * @author lujingzhong
 *
 */
public class UseCouponsRequest implements Serializable {

	private static final long serialVersionUID = 6159895335232886952L;

	/***********************************优惠券使用字段：couponCode used*********************************/
	private String couponCode;
	
	private Boolean used;
	
	/***********************************以下全部为记录日志***************************************************/
	private Long couponCodeId;
    //用来存放订单ID
    private Long objectId;
    //对象类型，订单还是销售产品还是采购产品
    private String objectType;
    
    private Date createTime;
    //优惠了多少钱：单位为分
    private Long amount;
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public Boolean getUsed() {
		return used;
	}
	public void setUsed(Boolean used) {
		this.used = used;
	}
	public Long getCouponCodeId() {
		return couponCodeId;
	}
	public void setCouponCodeId(Long couponCodeId) {
		this.couponCodeId = couponCodeId;
	}
	public Long getObjectId() {
		return objectId;
	}
	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}
	public String getObjectType() {
		return objectType;
	}
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
    
	public static void main(String[] args) {
	 Map map = new HashMap<Object, Object>();
	}
    
	
	
	
}
