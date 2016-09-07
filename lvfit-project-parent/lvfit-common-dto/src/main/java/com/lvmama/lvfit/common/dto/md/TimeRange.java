package com.lvmama.lvfit.common.dto.md;

import java.io.Serializable;
import java.util.Date;


public class TimeRange implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -4993182827191736829L;
	
	/** 开始时间 */
	private Date startTime;
	
	/** 结束时间 */
	private Date endTime;
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
}
