package com.lvmama.lvf.common.dto.vst;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.Oper;
import com.lvmama.lvf.common.dto.status.TaskOpType;

@XmlAccessorType(XmlAccessType.FIELD)
public class VstTaskOpLog extends Entity implements Serializable{

	private static final long serialVersionUID = -7636313239333797127L;
	
	/**
	 * 出发地城市三字码
	 */
	private String deptCityCode;
	
	/**
	 * 目的地城市三字码
	 */
	private String arrvCityCode;
	
	/**
	 * 任务ID
	 */
	private Long vstTaskConfigId;
	
	/**
	 * 基础航班数
	 */
	private int basicFlightCount;
	
	/**
	 * 商品数
	 */
	private int goodsCount;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 操作者
	 */
	private Oper oper;
	
	/**
	 * 任务操作类型
	 */
	private TaskOpType taskOpType;
	
	/**
	 * 操作时间
	 */
	private Date opTime = new Date();

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

	public Long getVstTaskConfigId() {
		return vstTaskConfigId;
	}

	public void setVstTaskConfigId(Long vstTaskConfigId) {
		this.vstTaskConfigId = vstTaskConfigId;
	}

	public int getBasicFlightCount() {
		return basicFlightCount;
	}

	public void setBasicFlightCount(int basicFlightCount) {
		this.basicFlightCount = basicFlightCount;
	}

	public int getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Oper getOper() {
		return oper;
	}

	public void setOper(Oper oper) {
		this.oper = oper;
	}

	public TaskOpType getTaskOpType() {
		return taskOpType;
	}

	public void setTaskOpType(TaskOpType taskOpType) {
		this.taskOpType = taskOpType;
	}

	public Date getOpTime() {
		return opTime;
	}

	public void setOpTime(Date opTime) {
		this.opTime = opTime;
	}
	
	

}
