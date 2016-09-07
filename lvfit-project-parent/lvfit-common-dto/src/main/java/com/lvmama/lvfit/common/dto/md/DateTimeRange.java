package com.lvmama.lvfit.common.dto.md;

import java.io.Serializable;


public class DateTimeRange  implements Serializable {

	private DateRange dateRange;
	private TimeRange timeRange;
	
	public DateRange getDateRange() {
		return dateRange;
	}
	public void setDateRange(DateRange dateRange) {
		this.dateRange = dateRange;
	}
	public TimeRange getTimeRange() {
		return timeRange;
	}
	public void setTimeRange(TimeRange timeRange) {
		this.timeRange = timeRange;
	}
	
	
	
}
