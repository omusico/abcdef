package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Dto;

/**
 * 机票订票查询
 * 
 * @author lishuiqing
 * @date:2016年8月26日 下午9:53:26
 */
public class FitFlightOrderQueryRequest implements Serializable, Dto {
	private static final long serialVersionUID = 6499294250473012342L;
	/**
	 * vst主单号
	 */
	private Long vstMainOrderId;
	/**
	 * vst机票子单号
	 */
	private Long vstFlightOrderId; 
	
	public Long getVstMainOrderId() {
		return vstMainOrderId;
	}

	public void setVstMainOrderId(Long vstMainOrderId) {
		this.vstMainOrderId = vstMainOrderId;
	}

	public Long getVstFlightOrderId() {
		return vstFlightOrderId;
	}

	public void setVstFlightOrderId(Long vstFlightOrderId) {
		this.vstFlightOrderId = vstFlightOrderId;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
