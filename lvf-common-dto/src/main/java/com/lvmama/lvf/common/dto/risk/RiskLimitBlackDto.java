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
package com.lvmama.lvf.common.dto.risk;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Entity;

/**
 * 针对南航新规的风控规则优化 实体类
 * <p style="display:none">
 * modifyRecord
 * </p>
 * <p style="display:none">
 * version:V1.0,author:杨小龙yangxiaolong, date:2016-7-28 下午3:52:43,content:
 * </p>
 * 
 * @author 杨小龙yangxiaolong
 * @date 2016-7-28 下午3:52:43
 * @since
 * @version
 */
public class RiskLimitBlackDto extends Entity implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2180157840847754668L;
	// 维度:航班Q维度 OR 航段S维度
	private String dim;
	// 航司
	private String flightCompany;
	// 航班日期
	private String flightDate;
	// 航班号
	private String flightNo;
	// 证件号
	private String idNum;
	// 航段
	private String leg;
	// 旅客姓名
	private String passengerName;
	// 成功的次数
	private Integer succCnt;

	/**
	 * @return the dim
	 */
	public String getDim() {
		return dim;
	}

	/**
	 * @param dim
	 *            the dim to set
	 */
	public void setDim(String dim) {
		this.dim = dim;
	}

	/**
	 * @return the flightCompany
	 */
	public String getFlightCompany() {
		return flightCompany;
	}

	/**
	 * @param flightCompany
	 *            the flightCompany to set
	 */
	public void setFlightCompany(String flightCompany) {
		this.flightCompany = flightCompany;
	}

	/**
	 * @return the flightDate
	 */
	public String getFlightDate() {
		return flightDate;
	}

	/**
	 * @param flightDate
	 *            the flightDate to set
	 */
	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	/**
	 * @return the flightNo
	 */
	public String getFlightNo() {
		return flightNo;
	}

	/**
	 * @param flightNo
	 *            the flightNo to set
	 */
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	/**
	 * @return the idNum
	 */
	public String getIdNum() {
		return idNum;
	}

	/**
	 * @param idNum
	 *            the idNum to set
	 */
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	/**
	 * @return the leg
	 */
	public String getLeg() {
		return leg;
	}

	/**
	 * @param leg
	 *            the leg to set
	 */
	public void setLeg(String leg) {
		this.leg = leg;
	}

	/**
	 * @return the passengerName
	 */
	public String getPassengerName() {
		return passengerName;
	}

	/**
	 * @param passengerName
	 *            the passengerName to set
	 */
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	/**
	 * @return  the succCnt
	 */
	public Integer getSuccCnt() {
		return succCnt;
	}

	/**
	 * @param succCnt the succCnt to set
	 */
	public void setSuccCnt(Integer succCnt) {
		this.succCnt = succCnt;
	}


}
