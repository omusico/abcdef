package com.lvmama.lvf.common.dto.flight;

import java.io.Serializable;
import java.util.List;

import com.lvmama.lvf.common.dto.enums.DirectType;

/**
 * 航班经停主信息
 * @author majun
 * @date   2015-1-19
 */
public class FlightStopInfoDto implements Serializable
{
	private static final long serialVersionUID = -8637137551371752777L;

	/** 停靠次数 */
	private Integer stopCount;
	
	/** 停靠的机场 */
	private List<FlightStopInfoDetailDto> flightStopInfoDetails;
	
	/** 直飞类型 */
	private DirectType directType;
	
	/** 总停靠时间 */
	private String totalStopTime;
	
	public Integer getStopCount() {
		return stopCount;
	}
	
	public void setStopCount(Integer stopCount) {
		this.stopCount = stopCount;
	}
	
	public List<FlightStopInfoDetailDto> getFlightStopInfoDetails() {
		return flightStopInfoDetails;
	}
	
	public void setFlightStopInfoDetails(
			List<FlightStopInfoDetailDto> flightStopInfoDetails) {
		this.flightStopInfoDetails = flightStopInfoDetails;
	}
	
	public DirectType getDirectType() 
	{
		if(stopCount != null && stopCount.intValue() > 0){
			directType=DirectType.NOT_DIRECT;
		}else{
			directType=DirectType.DIRECT;
		}
		return directType;
	}
	
	public void setDirectType(DirectType directType) {
		this.directType = directType;
	}
	
	public String getTotalStopTime() {
		return totalStopTime;
	}
	
	public void setTotalStopTime(String totalStopTime) {
		this.totalStopTime = totalStopTime;
	}
}