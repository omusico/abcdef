package com.lvmama.lvfit.common.form.product;

import com.lvmama.lvf.common.dto.Pagination;

public class FitSuppOrderForFlightCallBackRequest {
	
	private Long suppOrderId;
	
	/**vst主单号 */
	private String vstOrderMainNo;
	
	/**vst子单号 */
	private String vstOrderNo;
	
	private Pagination pagination = new Pagination();

	public Long getSuppOrderId() {
		return suppOrderId;
	}

	public void setSuppOrderId(Long suppOrderId) {
		this.suppOrderId = suppOrderId;
	}

	public String getVstOrderMainNo() {
		return vstOrderMainNo;
	}

	public void setVstOrderMainNo(String vstOrderMainNo) {
		this.vstOrderMainNo = vstOrderMainNo;
	}

	public String getVstOrderNo() {
		return vstOrderNo;
	}

	public void setVstOrderNo(String vstOrderNo) {
		this.vstOrderNo = vstOrderNo;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
	

}
