package com.lvmama.lvf.common.dto.supp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;

/**
 * 供应商航班产品信息(暂用于Ctrip)
 * @author majun
 * @date 2015-7-9
 */
public class SuppFlightProductDto extends Entity implements Serializable
{
	private static final long serialVersionUID = 1443110525358399710L;
	
	/** 供应商编码 */
	private String suppCode;

	/** 出发城市编码 */
	private String departCityCode;
	
	/** 到达城市编码 */
	private String arriveCityCode;
	
	/** 出发时间 */
	private String departureTime;
	
	/** 承运人编码 */
	private String carrierCode;
	
	/** 航班号 */
	private String flightNo;
	
	/** 舱位编码 */
	private String seatClassCode;
	
	/** 供应商为Ctrip时，表示销售类型枚举值 */
	private String paramStrValue;
	
	/** 供应商为Ctrip时，表示销售类型枚举对应的数字 */
	private Long paramLongValue;
	
	/** 供应商为Ctrip时，表示销售类型描述 */
	private String paramDesc;
	
	/** 结算价，供应商为Ctrip时候，表示销售价 */
	private BigDecimal settlePrice;
	
	/** SUPP政策编码 */
	private String suppPolicyNo;

	/** SUPP政策类型 */
	private String suppPolicyType;
	
	/** 供应商为Ctrip时，表示ProductId */
	private String suppIndexKey;
	
	/** 供应商为Ctrip时，表示ProductType */
	private String suppIndexType;
	
	/** 过期时间(供应商为Ctrip时，ProductId 40分钟失效) */
	private Date expireTime;
	
    /** 机建费 */
    private BigDecimal feeAmount;

    /** 燃油费 */
    private BigDecimal taxAmount;
    
    /** 供应商为Ctrip时，表示PID */
    private String pid;

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	public String getDepartCityCode() {
		return departCityCode;
	}

	public void setDepartCityCode(String departCityCode) {
		this.departCityCode = departCityCode;
	}

	public String getArriveCityCode() {
		return arriveCityCode;
	}

	public void setArriveCityCode(String arriveCityCode) {
		this.arriveCityCode = arriveCityCode;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getSeatClassCode() {
		return seatClassCode;
	}

	public void setSeatClassCode(String seatClassCode) {
		this.seatClassCode = seatClassCode;
	}

	public String getParamStrValue() {
		return paramStrValue;
	}

	public void setParamStrValue(String paramStrValue) {
		this.paramStrValue = paramStrValue;
	}

	public Long getParamLongValue() {
		return paramLongValue;
	}

	public void setParamLongValue(Long paramLongValue) {
		this.paramLongValue = paramLongValue;
	}

	public String getParamDesc() {
		return paramDesc;
	}

	public void setParamDesc(String paramDesc) {
		this.paramDesc = paramDesc;
	}

	public BigDecimal getSettlePrice() {
		return settlePrice;
	}

	public void setSettlePrice(BigDecimal settlePrice) {
		this.settlePrice = settlePrice;
	}

	public String getSuppPolicyNo() {
		return suppPolicyNo;
	}

	public void setSuppPolicyNo(String suppPolicyNo) {
		this.suppPolicyNo = suppPolicyNo;
	}

	public String getSuppPolicyType() {
		return suppPolicyType;
	}

	public void setSuppPolicyType(String suppPolicyType) {
		this.suppPolicyType = suppPolicyType;
	}

	public String getSuppIndexKey() {
		return suppIndexKey;
	}

	public void setSuppIndexKey(String suppIndexKey) {
		this.suppIndexKey = suppIndexKey;
	}

	public String getSuppIndexType() {
		return suppIndexType;
	}

	public void setSuppIndexType(String suppIndexType) {
		this.suppIndexType = suppIndexType;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
}
