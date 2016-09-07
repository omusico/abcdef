package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Dto;
/**
 * 订单PNR信息Request
 * @author yangyongni
 * @date 2015-08-26
 */
public class FlightOrderPNRInfoRequest implements Serializable,Dto{

	private static final long serialVersionUID = 4861828284637945622L;
	/** PNR主键*/
	private Long pnrId;
	/** PNR文本*/
	private String pnrTxt; 

	public Long getPnrId() {
		return pnrId;
	}

	public void setPnrId(Long pnrId) {
		this.pnrId = pnrId;
	}

	public String getPnrTxt() {
		return pnrTxt;
	}

	public void setPnrTxt(String pnrTxt) {
		this.pnrTxt = pnrTxt;
	}

	@Override
	public Long getId() {
		return null;
	}


}
