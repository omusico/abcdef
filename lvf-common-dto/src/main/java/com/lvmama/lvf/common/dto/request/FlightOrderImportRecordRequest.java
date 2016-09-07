package com.lvmama.lvf.common.dto.request;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.order.status.GenerateStatus;

import java.io.Serializable;
import java.math.BigDecimal;

public class FlightOrderImportRecordRequest implements Serializable, Dto {

	private static final long serialVersionUID = 7866647270185348923L;

	private Long id;

	/** 文件名 **/
	private String fileName;

	/** 操作账号 **/
	private String accountName;

	/** 公司名称 **/
	private String companyName;

	/** 状态 **/
	private GenerateStatus status;

	/** 操作记录描述 **/
	private String recordDesc;

	/** 导入日期开始时间 **/
	private String queryBegTime;

	/** 导入日期结束时间 **/
	private String queryEndTime;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public GenerateStatus getStatus() {
		return status;
	}

	public void setStatus(GenerateStatus status) {
		this.status = status;
	}

	public String getRecordDesc() {
		return recordDesc;
	}

	public void setRecordDesc(String recordDesc) {
		this.recordDesc = recordDesc;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return null;
	}

	public String getQueryBegTime() {
		return queryBegTime;
	}

	public void setQueryBegTime(String queryBegTime) {
		this.queryBegTime = queryBegTime;
	}

	public String getQueryEndTime() {
		return queryEndTime;
	}

	public void setQueryEndTime(String queryEndTime) {
		this.queryEndTime = queryEndTime;
	}
}

