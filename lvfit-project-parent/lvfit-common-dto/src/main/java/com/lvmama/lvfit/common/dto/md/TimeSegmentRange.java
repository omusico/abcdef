package com.lvmama.lvfit.common.dto.md;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.dto.enums.TimeSegment;

/**
 * 航段时间范围
 * @author majun
 * @date   2015-1-13
 */
public class TimeSegmentRange implements Serializable
{
	private static final long serialVersionUID = 5495429392635257236L;
	
	/** 起飞时间 */
	private Date departureTime;
	
	/** 到达时间 */
	private Date arrivalTime;
	
	/** 飞行时长  HH:MM*/
	private String flytime;
	
	/** 起飞时间段 */
	private TimeSegment departureTimeSegment;
	
	/** 到达时间段 */
	private TimeSegment arrivalTimeSegment;
	
	/** 起飞时间对应日期毫秒数 */
	private Long departureDate;
	
	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public TimeSegment getDepartureTimeSegment() {
		return departureTimeSegment;
	}

	public void setDepartureTimeSegment(TimeSegment departureTimeSegment) {
		this.departureTimeSegment = departureTimeSegment;
	}

	public TimeSegment getArrivalTimeSegment() {
		return arrivalTimeSegment;
	}

	public void setArrivalTimeSegment(TimeSegment arrivalTimeSegment) {
		this.arrivalTimeSegment = arrivalTimeSegment;
	}

	public String getFlytime() {
		return flytime;
	}

	public void setFlytime(String flytime) {
		this.flytime = flytime;
	}
	
	public void setDepartureDate(Long departureDate)
	{
		this.departureDate = departureDate;
	}
	
	public Long getDepartureDate()
	{
		if(this.departureTime != null)
		{
			return DateUtils.parseDate(DateUtils.formatDate(this.departureTime)).getTime();
		}
		return departureDate;
	}
	
	/**
	 * 计算飞行时长
	 * @param flytime
	 * @return
	 */
	public static Integer getFlyTimeMins(String flytime){
		
		if(StringUtils.isNotBlank(flytime)){
			String[] flytimes = flytime.split(":");
			if(null!=flytimes){
				BigDecimal hour = new BigDecimal(flytimes[0]);
				BigDecimal min = new BigDecimal(flytimes[1]);
				return hour.multiply(new BigDecimal(60)).add(min).intValue();
			}
		}
		return 0;
	}

	
}