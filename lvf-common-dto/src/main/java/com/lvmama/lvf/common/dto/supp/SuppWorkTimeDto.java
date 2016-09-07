/*
 * Copyright by Lvmama and the original author or authors.
 * 
 * This document only allow internal use ,Any of your behaviors using the file
 * not internal will pay legal responsibility.
 *
 * You may learn more information about Lvmama from
 *
 *      http://www.lvmama.com
 *
 */
package com.lvmama.lvf.common.dto.supp;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Entity;

/**
 * 供应商默认工作时间 实体
 * <p style="display:none">
 * modifyRecord
 * </p>
 * <p style="display:none">
 * version:V1.0,author:yangxiaolong(杨小龙), date:2016年6月16日 下午7:32:05,content:
 * </p>
 * 
 * @author yangxiaolong(杨小龙)
 * @date 2016年6月16日 下午7:32:05
 * @since
 * @version
 */
public class SuppWorkTimeDto extends Entity implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5825275168569892176L;
	// 星期五
	private String friday;
	// 星期一
	private String monday;
	// 星期六
	private String saturday;
	// 星期天
	private String sunday;
	// 供应商code
	private String suppCode;
	// 星期四
	private String thursday;
	// 星期二
	private String tuesday;
	// 星期三
	private String wednesday;
	/**
	 * @return  the friday
	 */
	public String getFriday() {
		return friday;
	}
	/**
	 * @param friday the friday to set
	 */
	public void setFriday(String friday) {
		this.friday = friday;
	}
	/**
	 * @return  the monday
	 */
	public String getMonday() {
		return monday;
	}
	/**
	 * @param monday the monday to set
	 */
	public void setMonday(String monday) {
		this.monday = monday;
	}
	/**
	 * @return  the saturday
	 */
	public String getSaturday() {
		return saturday;
	}
	/**
	 * @param saturday the saturday to set
	 */
	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}
	/**
	 * @return  the sunday
	 */
	public String getSunday() {
		return sunday;
	}
	/**
	 * @param sunday the sunday to set
	 */
	public void setSunday(String sunday) {
		this.sunday = sunday;
	}
	/**
	 * @return  the suppCode
	 */
	public String getSuppCode() {
		return suppCode;
	}
	/**
	 * @param suppCode the suppCode to set
	 */
	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}
	/**
	 * @return  the thursday
	 */
	public String getThursday() {
		return thursday;
	}
	/**
	 * @param thursday the thursday to set
	 */
	public void setThursday(String thursday) {
		this.thursday = thursday;
	}
	/**
	 * @return  the tuesday
	 */
	public String getTuesday() {
		return tuesday;
	}
	/**
	 * @param tuesday the tuesday to set
	 */
	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}
	/**
	 * @return  the wednesday
	 */
	public String getWednesday() {
		return wednesday;
	}
	/**
	 * @param wednesday the wednesday to set
	 */
	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}
	/**
	 * <p>创建一个新的实例 WorkTime</p>
	 * @author yangxiaolong(杨小龙)
	 * @date 2016年6月20日 下午5:27:01
	 */
	public SuppWorkTimeDto() {
	}

	public SuppWorkTimeDto(String suppCode) {
		this.suppCode = suppCode;
	}

	public String getTimeRange(int i) {
		switch (i) {
			case 0:
				return this.sunday;
			case 1:
				return this.monday;
			case 2:
				return this.tuesday;
			case 3:
				return this.wednesday;
			case 4:
				return this.thursday;
			case 5:
				return this.friday;
			case 6:
				return this.saturday;
			default:
				return null;
		}
	}



}
