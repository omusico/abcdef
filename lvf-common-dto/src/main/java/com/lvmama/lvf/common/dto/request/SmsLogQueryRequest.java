package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.BusinessType;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.SmsType;
import com.lvmama.lvf.common.dto.status.ResultStatus;

public class SmsLogQueryRequest implements Serializable, Dto {

	private static final long serialVersionUID = 6515701468028950848L;

	/********************前台搜索参数***********************/

	/** 起始日期 */
	private String startTime;

	/** 截止日期 */
	private String endTime;

	/** 早期为手机号，后期为短信类型 */
	private String remark;
	
	/** 后期为短信类型中文 */
	private String remarkCn;

	/** 早期为短信类型，后期为手机号 */
	private SmsType businessNo;

	/** 业务类型 */
	private BusinessType businessType;
	
	/** 短信类型 */
	private ResultStatus result;

	public BusinessType getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
	}
	
	public ResultStatus getResult() {
		return result;
	}

	public void setResult(ResultStatus result) {
		this.result = result;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public SmsType getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(SmsType businessNo) {
		this.businessNo = businessNo;
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

	public String getRemarkCn() {
		return remarkCn;
	}

	public void setRemarkCn(String remarkCn) {
		this.remarkCn = remarkCn;
	}
	
	@Override
	public Long getId() {
		return null;
	}

}

