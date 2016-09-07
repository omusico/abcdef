package com.lvmama.lvfit.common.dto.enums;

/**
 * 航班起飞类型
 * @author majun
 * @date   2015-1-24
 */
public enum FlightFlyType 
{
	BEFORE_BEFORE("起飞前","起飞前%s小时前"),
	BEFORE_AFTER("起飞前","起飞前%s小时后"),
	AFTER("起飞后",""),
	OTHER("其他情况","");
	
	private String cnName;
	
	private String messageFmt;

	private FlightFlyType(String cnName,String messageFmt) {
		this.cnName = cnName;
		this.messageFmt = messageFmt;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	
	public String getMessageFmt() {
		return messageFmt;
	}

	public void setMessageFmt(String messageFmt) {
		this.messageFmt = messageFmt;
	}

	public static String getShowKey(Integer minDepartureHour, Integer maxDepartureHour){
		    if(maxDepartureHour<0){
	        	if(minDepartureHour==0){
	        		return BEFORE_BEFORE.cnName;
	        	}
	        	return String.format(BEFORE_BEFORE.messageFmt, -minDepartureHour);
	        }		
	        if(maxDepartureHour>0){
	        	if(minDepartureHour==0){
	        		return AFTER.cnName;
	        	}
	        	return String.format(BEFORE_AFTER.messageFmt, -minDepartureHour);
	        }
	        return null;
	}
	
	
}
