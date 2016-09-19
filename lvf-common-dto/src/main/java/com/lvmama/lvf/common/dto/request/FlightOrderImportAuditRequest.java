package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Dto;

public class FlightOrderImportAuditRequest  implements Serializable, Dto {

	private static final long serialVersionUID = -877698880735549250L;

	//公司名称
	private String companyName;
	
	//PNR
	private String pnr;
	
	//产品类型
	private String productType;
	
	//主订单号
	private String orderMainNo;
	
	//制单开始时间
	private String begTime;
	
	//制单结束时间
	private String endTime;
	
	@Override
    @JsonIgnore
	public Long getId() {
		return null;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getOrderMainNo() {
		return orderMainNo;
	}

	public void setOrderMainNo(String orderMainNo) {
		this.orderMainNo = orderMainNo;
	}

	public String getBegTime() {
		return begTime;
	}

	public void setBegTime(String begTime) {
		this.begTime = begTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
