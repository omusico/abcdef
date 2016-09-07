package com.lvmama.lvfit.common.dto.supp;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.NameCode;
import com.lvmama.lvfit.common.dto.enums.PayBalanceType;
import com.lvmama.lvfit.common.dto.enums.SelfType;
import com.lvmama.lvfit.common.dto.enums.SuppType;

public class Supp extends NameCode implements Serializable, Dto {
	
	private static final long serialVersionUID = 8575244393534368162L;
	private String address;
	private String fax;
	private String telephone;
	private SuppType suppType;
	private SelfType selfType;
	private PayBalanceType payBalanceType; 
	
	public SuppType getSuppType() {
		return suppType;
	}
	public void setSuppType(SuppType suppType) {
		this.suppType = suppType;
	}
	public SelfType getSelfType() {
		return selfType;
	}
	public void setSelfType(SelfType selfType) {
		this.selfType = selfType;
	}
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
	public PayBalanceType getPayBalanceType() {
		return payBalanceType;
	}
	public void setPayBalanceType(PayBalanceType payBalanceType) {
		this.payBalanceType = payBalanceType;
	}
	
	public void copyFromDto(Supp supp){
		this.setAddress(supp.getAddress());
		this.setFax(supp.getFax());
		this.setCode(supp.getCode());
		this.setName(supp.getName());
		this.setPayBalanceType(supp.getPayBalanceType());
		this.setSuppType(supp.getSuppType());
		this.setTelephone(supp.getTelephone());
	}
	
}
