package com.lvmama.lvfit.common.dto.order;

import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.CallbackType;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;

/**
 * 供应商订单待回调机票下单留库信息
 * @author leizhengwei
 *
 */
public class FitSuppOrderForFlightCallBackDto extends Entity {

	private static final long serialVersionUID = -2789623983427075946L;
	
	/** 主单绑定关系表Id */
	private Long suppOrderId;
	
	/**vst主单号 */
	private String vstOrderMainNo;
	
	/**vst子单号 */
	private String vstOrderNo;
	
	/**回调机票下单的请求字符串 */
	private String callRequestStr;
	
	/**航程类型 */
	private FlightTripType tripType;
	
	/**回调结果 */
	private CallbackType callbackType;
	
	/**回调时间 */
	private Date callbackTime;
	

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

	public String getCallRequestStr() {
		return callRequestStr;
	}

	public void setCallRequestStr(String callRequestStr) {
		this.callRequestStr = callRequestStr;
	}

	public FlightTripType getTripType() {
		return tripType;
	}

	public void setTripType(FlightTripType tripType) {
		this.tripType = tripType;
	}

	public CallbackType getCallbackType() {
		return callbackType;
	}

	public void setCallbackType(CallbackType callbackType) {
		this.callbackType = callbackType;
	}

	public Date getCallbackTime() {
		return callbackTime;
	}

	public void setCallbackTime(Date callbackTime) {
		this.callbackTime = callbackTime;
	}

}
