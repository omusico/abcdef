package com.lvmama.lvf.common.form.md;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.BusinessType;
import com.lvmama.lvf.common.dto.OpLog;
import com.lvmama.lvf.common.dto.OperType;
import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.StringUtil;

public class OpLogViewForm implements Serializable, Form {

	private static final long serialVersionUID = -3953622072596198425L;

	private String createDate;

	private OpLog opLog;

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

	public String getOperId() {
		return opLog.getOperId();
	}

	public void setId(Long id) {
		opLog.setId(id);
	}

	public void setOperId(String operId) {
		opLog.setOperId(operId);
	}

	public String getUuid() {
		return opLog.getUuid();
	}

	public String getOper() {
		if (StringUtil.isEmptyString(opLog.getOper())) {
			return "";
		}
		return opLog.getOper();
	}

	public void setUuid(String uuid) {
		opLog.setUuid(uuid);
	}

	public void setOper(String oper) {
		opLog.setOper(oper);
	}

	public Date getCreateTime() {
		return opLog.getCreateTime();
	}

	public String getRemark() {
		return opLog.getRemark();
	}

	public void setCreateTime(Date createTime) {
		opLog.setCreateTime(createTime);
	}

	public void setRemark(String remark) {
		opLog.setRemark(remark);
	}

	public Date getUpdateTime() {
		return opLog.getUpdateTime();
	}

	public String getDesc() {
		return opLog.getDesc();
	}

	public void setDesc(String desc) {
		opLog.setDesc(desc);
	}

	public void setUpdateTime(Date updateTime) {
		opLog.setUpdateTime(updateTime);
	}

	public String getBusinessType() {
		return opLog.getBusinessType().getCnName();
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

	public String getCreateDate() {
		if (null != this.opLog) {
			if (null != this.opLog.getCreateTime()) {
				this.createDate = DateUtils.formatCnHmDate(this.opLog.getCreateTime());
			}
		}
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getResult() {
		return opLog.getResult();
	}

	public void setResult(String result) {
		opLog.setResult(result);
	}
	
	

}
