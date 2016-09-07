package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

/**
 * 获取未使用优惠券
 *
 */
public class FlightUserCouponRequest implements Serializable {

	private static final long serialVersionUID = -596805641236473483L;

	/**用户短id*/
	private String userId;

	/**优惠券使用状态*/
	private Boolean usedFlag;
	
	/**开始行数*/
	private Integer startRow;
	
	/**结束行数*/
	private Integer endRow;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Boolean getUsedFlag() {
		return usedFlag;
	}

	public void setUsedFlag(Boolean usedFlag) {
		this.usedFlag = usedFlag;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getEndRow() {
		return endRow;
	}

	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}


}
