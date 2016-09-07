package com.lvmama.lvfit.common.dto.md;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.BusinessType;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.OperType;
import com.lvmama.lvf.common.dto.status.ResultStatus;

/**
 * 短信发送日志
 * @date   2015-6-25
 */
public class SmsLogDto extends Entity implements Serializable 
{
	
	private static final long serialVersionUID = -3134098337119334915L;
	
	/********************数据库****************************/

	/** 手机号 */
	public String remark;
	
	/** 短信内容 */
	public String desc;
	
	/** 操作者 */
	public String oper;
	
	/** 操作者Id */
	public String operId;
	
	/**操作者类型*/
	public OperType operType;
	
	/** 业务类型 */
	private BusinessType businessType;
	
	/** 业务类型Id */
	private String businessId;
	
	/** 短信类型 */
	private String businessNo;
	
	/** 短信发送状态 */
	private ResultStatus result;
	
	/** 创建时间 */
	private Date createTime;
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public ResultStatus getResult() {
		return result;
	}

	public void setResult(ResultStatus result) {
		this.result = result;
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public BusinessType getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public OperType getOperType() {
		return operType;
	}

	public void setOperType(OperType operType) {
		this.operType = operType;
	}
	
}
