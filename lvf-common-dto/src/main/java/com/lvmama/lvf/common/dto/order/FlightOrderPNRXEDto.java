package com.lvmama.lvf.common.dto.order;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.status.ResultStatus;

/**
 * 需要XE的PNR dto
 * @date 2016-07-21
 */
public class FlightOrderPNRXEDto extends Entity {
	
	private static final long serialVersionUID = 6938579954348592860L;

	/** PNR编码 */
	private String pnr;
	
	/** XE后结果 */
	private ResultStatus status;
	
	/** XE的尝试次数 */
	private int times;

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public ResultStatus getStatus() {
		return status;
	}

	public void setStatus(ResultStatus status) {
		this.status = status;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}
}
