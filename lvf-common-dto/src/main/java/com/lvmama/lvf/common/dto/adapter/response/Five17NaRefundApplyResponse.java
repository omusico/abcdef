package com.lvmama.lvf.common.dto.adapter.response;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Five17NaRefundApplyResponse implements Serializable{
	private String refundNo;//517Na的退票单号
	
	public String getRefundNo() {
		return refundNo;
	}
	public void setRefundNo(String refundNo) {
		this.refundNo = refundNo;
	}
}
