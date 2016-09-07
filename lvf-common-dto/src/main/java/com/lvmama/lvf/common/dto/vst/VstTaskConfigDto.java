package com.lvmama.lvf.common.dto.vst;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.Oper;

public class VstTaskConfigDto extends AEEntity implements Serializable {

	private static final long serialVersionUID = -4952161332509547482L;
	
	/**
	 * '出发城市';
	 */
	private String  deptCityCode;
	
	/**
	 * '到达城市';
	 */
	private String arrvCityCode;

	/**
	 * '运行时间段起点';
	 */
	private String runTimeStart;

	/**
	 * '运行时间段结束点';
	 */
	private String runTimeEnd;

	/**
	 * '运行频率（分钟/次）';
	 */
	private Long rate;
	   
	/**
	 * '工号';
	 */
	private String workerNo;
	   
	/**
	 * '运行次数';
	 */
	private Long runTimes;
	
	/**
	 * 是否启用标识位
	 */
	private String activeFlag;
	
	/**
	 * 任务名称，用于quartz中标识唯一任务
	 * 例：SHA_PEK_1(其中1为配置信息在数据库中的ID)
	 */
	private String taskName;
	
	/**
	 * 上次运行开始时间
	 */
	private Date lastStartTime;
	
	/**
	 * 上次运行结束时间
	 */
	private Date lastEndTime;
	
	private int runFlag;
	
	private Oper oper;
	
	private Date handleUpdateTime;
	
	/**低价日历获取周期 */
	private Long lowPriceGetPeriod;

	public String getDeptCityCode() {
		return deptCityCode;
	}

	public void setDeptCityCode(String deptCityCode) {
		this.deptCityCode = deptCityCode;
	}

	public String getArrvCityCode() {
		return arrvCityCode;
	}

	public void setArrvCityCode(String arrvCityCode) {
		this.arrvCityCode = arrvCityCode;
	}

	public String getRunTimeStart() {
		return runTimeStart;
	}

	public void setRunTimeStart(String runTimeStart) {
		this.runTimeStart = runTimeStart;
	}

	public String getRunTimeEnd() {
		return runTimeEnd;
	}

	public void setRunTimeEnd(String runTimeEnd) {
		this.runTimeEnd = runTimeEnd;
	}

	public Long getRate() {
		return rate;
	}

	public void setRate(Long rate) {
		this.rate = rate;
	}

	public String getWorkerNo() {
		return workerNo;
	}

	public void setWorkerNo(String workerNo) {
		this.workerNo = workerNo;
	}

	public Long getRunTimes() {
		return runTimes;
	}

	public void setRunTimes(Long runTimes) {
		this.runTimes = runTimes;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Date getLastEndTime() {
		return lastEndTime;
	}

	public void setLastEndTime(Date lastEndTime) {
		this.lastEndTime = lastEndTime;
	}

	public Date getLastStartTime() {
		return lastStartTime;
	}

	public void setLastStartTime(Date lastStartTime) {
		this.lastStartTime = lastStartTime;
	}

	public int getRunFlag() {
		return runFlag;
	}

	public void setRunFlag(int runFlag) {
		this.runFlag = runFlag;
	}

	public Oper getOper() {
		return oper;
	}

	public void setOper(Oper oper) {
		this.oper = oper;
	}

	public Date getHandleUpdateTime() {
		return handleUpdateTime;
	}

	public void setHandleUpdateTime(Date handleUpdateTime) {
		this.handleUpdateTime = handleUpdateTime;
	}

	public Long getLowPriceGetPeriod() {
		return lowPriceGetPeriod;
	}

	public void setLowPriceGetPeriod(Long lowPriceGetPeriod) {
		this.lowPriceGetPeriod = lowPriceGetPeriod;
	}

}
