package com.lvmama.lvfit.common.dto.enums;

import java.util.Calendar;
import java.util.Date;

import com.lvmama.lvf.common.utils.DateUtils;

public enum TimeSegment {
	
	MORNING("上午",6,12,"06:00-12:00"),
	NOON("下午",12,18,"12:00-18:00"),
	NIGHT("晚上",18,24,"18:00-24:00");
	
	private String cnName;
	private int start;
	private int end;
	private String showInfo;

	public String getCnName() {
		return cnName;
	}
	
	
	public String getShowInfo() {
		return showInfo;
	}




	private TimeSegment(String cnName,int start,int end,String showInfo) {
		this.cnName = cnName;
		this.start = start;
		this.end = end;
		this.showInfo = showInfo;
	}
	
	public static TimeSegment getTimeSegment(Date time){
		//TODO
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		int hour=cal.get(Calendar.HOUR_OF_DAY);
		if(hour >= MORNING.start&&hour < MORNING.end){
			return MORNING;
		}
		if(hour >= NOON.start&&hour < NOON.end){
			return NOON;
		}
		if(hour >= NIGHT.start&&hour < NIGHT.end){
			return NIGHT;
		}
		return NIGHT;
	}
	
	/**
	 * 获取飞行时长
	 * @param 	departureTime		起飞时间
	 * @param 	arrivalTime			到达时间
	 * @return	String				飞行时长
	 */
	public static String getFlyTime(Date departureTime, Date arrivalTime)
	{
		if(arrivalTime.compareTo(departureTime)<0){
			arrivalTime = DateUtils.addDays(arrivalTime, 1);
		}
		long diffSeconds = (arrivalTime.getTime() - departureTime.getTime()) / 1000 ;
		
		long diffHours = diffSeconds / 3600;
		
		long diffMins = (diffSeconds % 3600)/60;
		
		return diffHours+":"+diffMins;
	}


	public static String getTimeSegmentBegTime(TimeSegment departureTimeSegment) {
		if(null==departureTimeSegment){
			return null;
		}
		return String.valueOf(DateUtils.parseCnHmDate(DateUtils.INIT_DATE+" "+departureTimeSegment.getShowInfo().split("-")[0]+":00").getTime());
	}


	public static String getTimeSegmentEndTime(TimeSegment departureTimeSegment) {
		if(null==departureTimeSegment){
			return null;
		}
		return String.valueOf(DateUtils.parseCnHmDate(DateUtils.INIT_DATE+" "+departureTimeSegment.getShowInfo().split("-")[1]+":00").getTime());
	}
	
}
