package com.lvmama.lvf.common.form.md;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.BusinessType;
import com.lvmama.lvf.common.dto.OpLog;
import com.lvmama.lvf.common.dto.OperType;
import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;


public class OpLogQueryResultForm implements Serializable, Form {

	private static final long serialVersionUID = 5439052564751372456L;

	private OpLog opLog;
	
	private String businessTypeCnName;
	
	private String operTypeCnName;
	
	private String createTimeStr;

	public OpLogQueryResultForm(){
		
	}
	
	public OpLogQueryResultForm(OpLog opLog) {
		super();
		this.opLog = opLog;
	}
	
	public String getBusinessTypeCnName() {
		if(opLog.getBusinessType() != null)
		{
			return opLog.getBusinessType().getCnName();
		}	
		return businessTypeCnName;
	}

	public void setBusinessTypeCnName(String businessTypeCnName) {
		this.businessTypeCnName = businessTypeCnName;
	}
	
	public OpLog getOpLog() {
		return opLog;
	}

	public void setOpLog(OpLog opLog) {
		this.opLog = opLog;
	}

	public PersistenceType getPtype() {
		return opLog.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		opLog.setPtype(ptype);
	}

	public String getSequence() {
		return opLog.getSequence();
	}

	public Long getId() {
		return opLog.getId();
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

	public Date getCreateTime() {
		return opLog.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		opLog.setCreateTime(createTime);
	}
	
	public String getCreateTimeStr() {
		if(this.getCreateTime() != null)
			return DateUtils.formatDate(this.getCreateTime(), DateUtils.YYYY_MM_DD_HH_MM_SS);
		return createTimeStr;
	}
	
	public void setCreateTime(String createTimeStr) {
		this.setCreateTime(createTimeStr);
	}

	public Date getUpdateTime() {
		return opLog.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		opLog.setUpdateTime(updateTime);
	}

	public int hashCode() {
		return opLog.hashCode();
	}

	public boolean equals(Object obj) {
		return opLog.equals(obj);
	}

	public String toString() {
		return opLog.toString();
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

	public String getRemark() {
		return opLog.getRemark();
	}

	public void setRemark(String remark) {
		opLog.setRemark(remark);
	}

	public String getDesc() {
		return opLog.getDesc();
	}

	public void setDesc(String desc) {
		opLog.setDesc(desc);
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

	public String getOperTypeCnName() {
		if(opLog.getOperType() != null)
		{
			return opLog.getOperType().getCnName();
		}	
		return operTypeCnName;
	}

	public void setOperTypeCnName(String operTypeCnName) {
		this.operTypeCnName = operTypeCnName;
	}
	
}
