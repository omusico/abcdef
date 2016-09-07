package com.lvmama.lvf.common.dto.md;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.NameCode;


public class QuickRemark extends NameCode implements Serializable{
	
	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
