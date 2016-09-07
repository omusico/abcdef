package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.RequestResponse;
import com.lvmama.lvf.common.dto.api.ApiFlowDto;
import com.lvmama.lvf.common.dto.enums.InterfaceKey;
import com.lvmama.lvf.common.dto.order.FlightOrderQueryDto;
import com.lvmama.lvf.common.dto.schedule.TaskConfigDto;

@XmlRootElement
public class TaskConfigQueryRequest implements Serializable, Dto {
	private static final long serialVersionUID = 6815249093104077557L;
	
	private Long id;//taskConfigID
	
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








	public void setId(Long id) {
		this.id = id;
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




	public Long getId() {
		return id;
	}




	
	
	
	
	}

