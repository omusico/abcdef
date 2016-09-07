package com.lvmama.lvf.common.dto.order;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.order.status.GenerateStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单导入记录
 *
 * @author qihuisong
 */
public class FlightOrderImportRecordDto extends Entity implements Serializable {

	private static final long serialVersionUID = 1520210968933869510L;

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

	private List<FlightOrderImportDto> importDtos = new ArrayList<FlightOrderImportDto>();

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

	public List<FlightOrderImportDto> getImportDtos() {
		return importDtos;
	}

	public void setImportDtos(List<FlightOrderImportDto> importDtos) {
		this.importDtos = importDtos;
	}

}
