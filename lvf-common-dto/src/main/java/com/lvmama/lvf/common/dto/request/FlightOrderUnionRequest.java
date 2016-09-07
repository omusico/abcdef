package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.Date;

public class FlightOrderUnionRequest implements Serializable {

	private static final long serialVersionUID = 859716331476892488L;

	/** 查询开始时间 */
	private Date startDate;
	
	/** 查询结束时间 */
	private Date endDate;
	
	/** 页码 */
	private Integer page;
	
	/** 查询每页行数 */
	private Integer rows;

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

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}
}
