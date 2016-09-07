package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.BusinessType;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.DiscountCalculatorBaseType;
import com.lvmama.lvf.common.dto.enums.DiscountType;
import com.lvmama.lvf.common.dto.md.PriceFormula;

/**
 * 订单折扣信息
 * @author majun
 * @date   2015-1-19
 */
public class FlightOrderDiscountDto extends Entity implements Serializable 
{
	private static final long serialVersionUID = 6719236999129733096L;
	
	private Long orderMainId;
	
	private Long flightOrderId;
	
	private BusinessType businessType;
	
	private Long objectId;
	
	/** 折扣类型 */
	private DiscountType discountType;
	
	/** 折扣金额 */
	private BigDecimal discountAmount;
	
	/**
	 * 扣减说明
	 */
	private String desc;
	
	/**
	 * 折扣
	 */
	private DiscountCalculatorBaseType discountCalculatorBaseType;
	/**
	 * 扣减公式
	 */
	private PriceFormula discountFormula;
	public Long getOrderMainId() {
		return orderMainId;
	}
	public void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}
	public Long getFlightOrderId() {
		return flightOrderId;
	}
	public void setFlightOrderId(Long flightOrderId) {
		this.flightOrderId = flightOrderId;
	}
	public BusinessType getBusinessType() {
		return businessType;
	}
	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
	}
	public Long getObjectId() {
		return objectId;
	}
	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}
	public DiscountType getDiscountType() {
		return discountType;
	}
	public void setDiscountType(DiscountType discountType) {
		this.discountType = discountType;
	}
	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public DiscountCalculatorBaseType getDiscountCalculatorBaseType() {
		return discountCalculatorBaseType;
	}
	public void setDiscountCalculatorBaseType(
			DiscountCalculatorBaseType discountCalculatorBaseType) {
		this.discountCalculatorBaseType = discountCalculatorBaseType;
	}
	public PriceFormula getDiscountFormula() {
		return discountFormula;
	}
	public void setDiscountFormula(PriceFormula discountFormula) {
		this.discountFormula = discountFormula;
	}
	
	
}
