package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.BusinessType;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.OpLog;
import com.lvmama.lvf.common.dto.OperType;
import com.lvmama.lvf.common.dto.PersistenceType;

public class OpLogQueryRequest implements Serializable , Dto{

	private static final long serialVersionUID = -6781725581057222733L;

	/********************前台搜索参数***********************/
	/** 起始日期 */
	private String startTime;

	/** 截止日期 */
	private String endTime;

	/********************数据库***********************/
	private OpLog opLog = new OpLog();

	public OpLog getOpLog() {
		return opLog;
	}

	public void setOpLog(OpLog opLog) {
		this.opLog = opLog;
	}

	public String getOperId() {
		return opLog.getOperId();
	}

	public void setOperId(String operId) {
		opLog.setOperId(operId);
	}

	public String getOper() {
		return opLog.getOper();
	}

	public void setOper(String oper) {
		opLog.setOper(oper);
	}

	public BusinessType getBusinessType() {
		return opLog.getBusinessType();
	}

	public void setBusinessType(BusinessType businessType) {
		opLog.setBusinessType(businessType);
	}

	public String getBusinessId() {
		return opLog.getBusinessId();
	}

	public void setBusinessId(String businessId) {
		opLog.setBusinessId(businessId);
	}

	public String getBusinessNo() {
		return opLog.getBusinessNo();
	}

	public void setBusinessNo(String businessNo) {
		opLog.setBusinessNo(businessNo);
	}

	@JsonIgnore
	@Override
	public Long getId() {
		return null;
	}

	public PersistenceType getPtype() {
		return opLog.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		opLog.setPtype(ptype);
	}

	@JsonIgnore
	public String getSequence() {
		return opLog.getSequence();
	}

	public void setId(Long id) {
		opLog.setId(id);
	}

	public String getUuid() {
		return opLog.getUuid();
	}

	public void setUuid(String uuid) {
		opLog.setUuid(uuid);
	}

	public String getRemark() {
		return opLog.getRemark();
	}

	public Date getCreateTime() {
		return opLog.getCreateTime();
	}

	public void setRemark(String remark) {
		opLog.setRemark(remark);
	}

	public void setCreateTime(Date createTime) {
		opLog.setCreateTime(createTime);
	}

	public String getDesc() {
		return opLog.getDesc();
	}

	public Date getUpdateTime() {
		return opLog.getUpdateTime();
	}

	public void setDesc(String desc) {
		opLog.setDesc(desc);
	}

	public void setUpdateTime(Date updateTime) {
		opLog.setUpdateTime(updateTime);
	}

	public OperType getOperType() {
		return opLog.getOperType();
	}

	public void setOperType(OperType operType) {
		opLog.setOperType(operType);
	}

	public String getResult() {
		return opLog.getResult();
	}

	public void setResult(String result) {
		opLog.setResult(result);
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
