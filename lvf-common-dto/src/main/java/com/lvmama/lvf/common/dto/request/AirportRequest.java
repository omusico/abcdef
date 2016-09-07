package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.md.Airport;
import com.lvmama.lvf.common.dto.status.OpSource;

public class AirportRequest implements Serializable, Dto{

	private static final long serialVersionUID = 1L;
	
	/********************前台搜索参数***********************/
	
	/** 万能条件 */
	private String universalCondition;
	
	private Airport airport = new Airport();
	
    /**
     * 操作源
     */
    private OpSource opSource;
    

	public Airport getAirport() {
		return airport;
	}


	public void setAirport(Airport airport) {
		this.airport = airport;
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
