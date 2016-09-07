package com.lvmama.lvf.common.dto.schedule;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Entity;

public class TaskConfigDto  extends Entity implements Serializable {

	private static final long serialVersionUID = 6048730109104324245L;
	
	private String userId;
	
	
	/**出发到达城市code*/  
	private String depCityCode;
	
	private String arrCityCode;
	
	/**天数范围    	T+N*/  
	private Integer startDay;
	
	private Integer endDay;
	
	
	/**执行时间范围*/  
	private Integer startHour;
	
	private Integer endHour;
	
	
	/**执行频率*/  
	private Integer rate;
	


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}






	public String getDepCityCode() {
		return depCityCode;
	}


	public void setDepCityCode(String depCityCode) {
		this.depCityCode = depCityCode;
	}


	public String getArrCityCode() {
		return arrCityCode;
	}


	public void setArrCityCode(String arrCityCode) {
		this.arrCityCode = arrCityCode;
	}


	public Integer getStartDay() {
		return startDay;
	}


	public void setStartDay(Integer startDay) {
		this.startDay = startDay;
	}


	public Integer getEndDay() {
		return endDay;
	}


	public void setEndDay(Integer endDay) {
		this.endDay = endDay;
	}


	public Integer getStartHour() {
		return startHour;
	}


	public void setStartHour(Integer startHour) {
		this.startHour = startHour;
	}


	public Integer getEndHour() {
		return endHour;
	}


	public void setEndHour(Integer endHour) {
		this.endHour = endHour;
	}


	public Integer getRate() {
		return rate;
	}


	public void setRate(Integer rate) {
		this.rate = rate;
	}
	
	
	
	
	

}
