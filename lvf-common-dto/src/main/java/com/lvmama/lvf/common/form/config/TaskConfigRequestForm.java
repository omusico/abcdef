package com.lvmama.lvf.common.form.config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.schedule.AirlineHotLevelConfigDto;
import com.lvmama.lvf.common.dto.schedule.DayLevelConfigDto;
import com.lvmama.lvf.common.dto.schedule.LevelRConfigDto;
import com.lvmama.lvf.common.dto.schedule.TimePeriodConfigDto;

public class TaskConfigRequestForm implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3376975807186571030L;

	private List<AirlineHotLevelConfigDto> airlineHotLevelConfigDtos = new ArrayList<AirlineHotLevelConfigDto>();
	
	private List<DayLevelConfigDto> dayLevelConfigDtos = new ArrayList<DayLevelConfigDto>();

	private List<TimePeriodConfigDto> timePeriodConfigDtos = new ArrayList<TimePeriodConfigDto>();

	private List<LevelRConfigDto> levelRConfigDtos = new ArrayList<LevelRConfigDto>();

	public List<AirlineHotLevelConfigDto> getAirlineHotLevelConfigDtos() {
		return airlineHotLevelConfigDtos;
	}

	public void setAirlineHotLevelConfigDtos(
			List<AirlineHotLevelConfigDto> airlineHotLevelConfigDtos) {
		this.airlineHotLevelConfigDtos = airlineHotLevelConfigDtos;
	}

	public List<DayLevelConfigDto> getDayLevelConfigDtos() {
		return dayLevelConfigDtos;
	}

	public void setDayLevelConfigDtos(List<DayLevelConfigDto> dayLevelConfigDtos) {
		this.dayLevelConfigDtos = dayLevelConfigDtos;
	}

	public List<TimePeriodConfigDto> getTimePeriodConfigDtos() {
		return timePeriodConfigDtos;
	}

	public void setTimePeriodConfigDtos(
			List<TimePeriodConfigDto> timePeriodConfigDtos) {
		this.timePeriodConfigDtos = timePeriodConfigDtos;
	}

	public List<LevelRConfigDto> getLevelRConfigDtos() {
		return levelRConfigDtos;
	}

	public void setLevelRConfigDtos(List<LevelRConfigDto> levelRConfigDtos) {
		this.levelRConfigDtos = levelRConfigDtos;
	}
	
	
}
