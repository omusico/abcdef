package com.lvmama.lvf.common.dto.sales;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.NameCode;
import com.lvmama.lvf.common.dto.enums.PayBalanceType;
import com.lvmama.lvf.common.dto.enums.SelfType;

/**
 * 销售渠道基本信息
 * @author majun
 * @date   2015-3-13
 */
public class Sales extends NameCode implements Serializable 
{
	private static final long serialVersionUID = -843847602144972851L;

	/** 地址 */
	private String address;
	
	/** 传真 */
	private String fax;
	
	/** 电话号码*/
	private String telephone;
	
	/** 采购类型 */
	private SelfType selfType;
	
	/** 支付方式类型 */
	private PayBalanceType payBalanceType;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public SelfType getSelfType() {
		return selfType;
	}

	public void setSelfType(SelfType selfType) {
		this.selfType = selfType;
	}

	public PayBalanceType getPayBalanceType() {
		return payBalanceType;
	}

	public void setPayBalanceType(PayBalanceType payBalanceType) {
		this.payBalanceType = payBalanceType;
	} 
}
