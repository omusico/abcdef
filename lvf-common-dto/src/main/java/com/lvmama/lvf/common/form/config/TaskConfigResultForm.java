package com.lvmama.lvf.common.form.config;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.schedule.TaskConfigDto;
import com.lvmama.lvf.common.form.Form;


public class TaskConfigResultForm implements Serializable, Form {


	private static final long serialVersionUID = 6012897445144069692L;

	private TaskConfigDto taskConfigDto;

	public TaskConfigDto getTaskConfigDto() {
		return taskConfigDto;
	}
	
	

	public TaskConfigResultForm(TaskConfigDto taskConfigDto) {
		super();
		this.taskConfigDto = taskConfigDto;
	}



	public void setTaskConfigDto(TaskConfigDto taskConfigDto) {
		this.taskConfigDto = taskConfigDto;
	}

	public PersistenceType getPtype() {
		return taskConfigDto.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		taskConfigDto.setPtype(ptype);
	}

	public String getUserId() {
		return taskConfigDto.getUserId();
	}

	public void setUserId(String userId) {
		taskConfigDto.setUserId(userId);
	}

	public String getSequence() {
		return taskConfigDto.getSequence();
	}

	public String getDepCityCode() {
		return taskConfigDto.getDepCityCode();
	}

	public Long getId() {
		return taskConfigDto.getId();
	}

	public void setId(Long id) {
		taskConfigDto.setId(id);
	}

	public void setDepCityCode(String depCityCode) {
		taskConfigDto.setDepCityCode(depCityCode);
	}

	public String getUuid() {
		return taskConfigDto.getUuid();
	}

	public void setUuid(String uuid) {
		taskConfigDto.setUuid(uuid);
	}

	public String getArrCityCode() {
		return taskConfigDto.getArrCityCode();
	}

	public Date getCreateTime() {
		return taskConfigDto.getCreateTime();
	}

	public void setArrCityCode(String arrCityCode) {
		taskConfigDto.setArrCityCode(arrCityCode);
	}

	public void setCreateTime(Date createTime) {
		taskConfigDto.setCreateTime(createTime);
	}

	public Integer getStartDay() {
		return taskConfigDto.getStartDay();
	}

	public Date getUpdateTime() {
		return taskConfigDto.getUpdateTime();
	}

	public void setStartDay(Integer startDay) {
		taskConfigDto.setStartDay(startDay);
	}

	public void setUpdateTime(Date updateTime) {
		taskConfigDto.setUpdateTime(updateTime);
	}

	public Integer getEndDay() {
		return taskConfigDto.getEndDay();
	}

	public void setEndDay(Integer endDay) {
		taskConfigDto.setEndDay(endDay);
	}

	public Integer getStartHour() {
		return taskConfigDto.getStartHour();
	}

	public void setStartHour(Integer startHour) {
		taskConfigDto.setStartHour(startHour);
	}

	public Integer getEndHour() {
		return taskConfigDto.getEndHour();
	}

	public void setEndHour(Integer endHour) {
		taskConfigDto.setEndHour(endHour);
	}

	public Integer getRate() {
		return taskConfigDto.getRate();
	}

	public void setRate(Integer rate) {
		taskConfigDto.setRate(rate);
	}
	
	
	
	
}
