package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.md.Carrier;
import com.lvmama.lvf.common.dto.status.OpSource;

public class CarrierRequest implements Serializable,Dto{

	private static final long serialVersionUID = -5116953970542124240L;
	
	/********************前台搜索参数***********************/
	
	/** 万能条件 */
	private String universalCondition;
	
	private Carrier carrier = new Carrier();
	
	/**
     * 操作源
     */
    private OpSource opSource;
    
	public Carrier getCarrier() {
		return carrier;
	}
	
	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}
	
	public OpSource getOpSource() {
		return opSource;
	}
	
	public void setOpSource(OpSource opSource) {
		this.opSource = opSource;
	}
	
	@Override
	public Long getId() {
		return null;
	}
    
	public String getUniversalCondition() {
		return universalCondition;
	}

	public void setUniversalCondition(String universalCondition) {
		this.universalCondition = universalCondition;
	}
}
