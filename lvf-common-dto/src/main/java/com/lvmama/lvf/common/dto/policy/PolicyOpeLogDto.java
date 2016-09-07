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
package com.lvmama.lvf.common.dto.policy;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;

/**
 * 政策操作日志
 * <p style="display:none">modifyRecord</p>
 * <p style="display:none">version:V1.0,author:yangxiaolong(杨小龙),
 *		date:2016年6月22日 上午11:36:52,content: </p>
 * @author yangxiaolong(杨小龙)
 * @date 2016年6月22日 上午11:36:52
 * @since
 * @version
 */
public class PolicyOpeLogDto extends Entity implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7115555159371426799L;
	
	private Date operTime = new Date();
	private String oper;
	private String remark;
	private String policyId;
	private String operType;
	/**
	 * @return  the operTime
	 */
	public Date getOperTime() {
		return operTime;
	}
	/**
	 * @param operTime the operTime to set
	 */
	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}
	/**
	 * @return  the oper
	 */
	public String getOper() {
		return oper;
	}
	/**
	 * @param oper the oper to set
	 */
	public void setOper(String oper) {
		this.oper = oper;
	}
	/**
	 * @return  the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return  the policyId
	 */
	public String getPolicyId() {
		return policyId;
	}
	/**
	 * @param policyId the policyId to set
	 */
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	/**
	 * @return  the operType
	 */
	public String getOperType() {
		return operType;
	}
	/**
	 * @param operType the operType to set
	 */
	public void setOperType(String operType) {
		this.operType = operType;
	}
	

}
