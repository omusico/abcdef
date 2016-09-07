package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Dto;

/***
 * 
 * 批量短信发送
 * 
 */
public class SmsBatchSendRequest implements Serializable,Dto {
	
	private static final long serialVersionUID = -3235961669153809302L;
	
	//发送内容
	private String smsContent;
	
	//发送手机号
	private String mobiles;
	
	//短信是否已发送
	private Boolean isSend;
	
	//开始查询发送时间
	private String startSendTime;
	
	//结束查询发送时间
	private String endSendTime;
	
	//开始查询创建时间
	private String startCreateTime;
	
	//结束查询创建时间
	private String endCreateTime;
	
	//手机号批次
	private Long batchNo;
	
	private List<Long> ids;
	
	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}
	
	public String getMobiles() {
		return mobiles;
	}

	public void setMobiles(String mobiles) {
		this.mobiles = mobiles;
	}

	public Boolean getIsSend() {
		return isSend;
	}

	public void setIsSend(Boolean isSend) {
		this.isSend = isSend;
	}

	public String getStartSendTime() {
		return startSendTime;
	}

	public void setStartSendTime(String startSendTime) {
		this.startSendTime = startSendTime;
	}

	public String getEndSendTime() {
		return endSendTime;
	}

	public void setEndSendTime(String endSendTime) {
		this.endSendTime = endSendTime;
	}

	public String getStartCreateTime() {
		return startCreateTime;
	}

	public void setStartCreateTime(String startCreateTime) {
		this.startCreateTime = startCreateTime;
	}

	public String getEndCreateTime() {
		return endCreateTime;
	}

	public void setEndCreateTime(String endCreateTime) {
		this.endCreateTime = endCreateTime;
	}

	public Long getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(Long batchNo) {
		this.batchNo = batchNo;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	@JsonIgnore
	@Override
	public Long getId() {
		return null;
	}
	
	
	
}
