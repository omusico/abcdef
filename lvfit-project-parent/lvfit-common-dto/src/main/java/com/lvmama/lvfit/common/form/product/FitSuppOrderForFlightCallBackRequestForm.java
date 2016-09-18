package com.lvmama.lvfit.common.form.product;

import com.lvmama.lvf.common.dto.Pagination;

public class FitSuppOrderForFlightCallBackRequestForm {
	
	private FitSuppOrderForFlightCallBackRequest request;
	
	public FitSuppOrderForFlightCallBackRequest getRequest() {
		return request;
	}

	public void setRequest(FitSuppOrderForFlightCallBackRequest request) {
		this.request = request;
	}

	public Long getSuppOrderId() {
		return request.getSuppOrderId();
	}

	public String getVstOrderMainNo() {
		return request.getVstOrderMainNo();
	}

	public String getVstOrderNo() {
		return request.getVstOrderNo();
	}

	public Pagination getPagination() {
		return request.getPagination();
	}

	public int hashCode() {
		return request.hashCode();
	}

	public void setSuppOrderId(Long suppOrderId) {
		request.setSuppOrderId(suppOrderId);
	}

	public void setVstOrderMainNo(String vstOrderMainNo) {
		request.setVstOrderMainNo(vstOrderMainNo);
	}

	public void setVstOrderNo(String vstOrderNo) {
		request.setVstOrderNo(vstOrderNo);
	}

	public void setPagination(Pagination pagination) {
		request.setPagination(pagination);
	}
	
}
