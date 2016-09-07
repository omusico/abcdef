package com.lvmama.lvf.common.dto.md;

import java.io.Serializable;
import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.NameCode;

public class InsuranceClass extends NameCode implements Serializable {
	
//	private BigDecimal price;
	private String desc;
	
//	public BigDecimal getPrice() {
//		return price;
//	}
//	public void setPrice(BigDecimal price) {
//		this.price = price;
//	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}
