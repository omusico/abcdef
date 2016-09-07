package com.lvmama.lvf.common.dto.md;

import java.io.Serializable;
import java.util.Date;

public class DateRange implements Serializable{

	/** serialVersionUID */
	private static final long serialVersionUID = 7283192879342972378L;
	
	/** 开始日期 */
	private Date startDate;
	
	/** 结束日期 */
	private Date endDate;

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public boolean include(Date date) {
		if(null==startDate||null==endDate||null==date){
			return false;
		}
		return !date.before(startDate) && date.before(endDate);
	}


}
