package com.lvmama.lvf.common.dto.vst;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.AEEntity;

/**
 * @author lutianyu
 * @date   2015年7月2日
 */
public class VSTSyncConfigDto extends AEEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 同步标识位。1：同步正在进行中。2：同步已完成 */
	private Integer syncFlag;
	
	/** 上次同步开始时间 */
	private Date lastStartTime;
	
	/** 上次同步结束时间 */
	private Date lastEndTime;

	public Integer getSyncFlag() {
		return syncFlag;
	}

	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}

	public Date getLastStartTime() {
		return lastStartTime;
	}

	public void setLastStartTime(Date lastStartTime) {
		this.lastStartTime = lastStartTime;
	}

	public Date getLastEndTime() {
		return lastEndTime;
	}

	public void setLastEndTime(Date lastEndTime) {
		this.lastEndTime = lastEndTime;
	}
}
