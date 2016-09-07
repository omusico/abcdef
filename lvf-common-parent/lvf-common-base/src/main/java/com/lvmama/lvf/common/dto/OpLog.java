package com.lvmama.lvf.common.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 操作日志
 * @date   2015-1-13
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class OpLog extends Entity implements Serializable 
{
	private static final long serialVersionUID = -1967586025910485612L;

	/** 备注 */
	public String remark;
	
	/** 描述 */
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
	
	/** 业务编号 */
	private String businessNo;
	
	/** 结果 */
	private String result;

	
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
