package com.lvmama.lvf.common.dto;


public class BaseInsuranceResponseDto<T> extends BaseResponseDto<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2696508460677619367L;

	/** 返回日期 */
	private String transDate;
	
	/** 返回时间*/
	private String transTime;

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	public String getTransTime() {
		return transTime;
	}

	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}
}
