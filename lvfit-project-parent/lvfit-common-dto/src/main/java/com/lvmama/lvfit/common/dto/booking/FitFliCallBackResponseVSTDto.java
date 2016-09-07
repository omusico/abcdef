package com.lvmama.lvfit.common.dto.booking;

import java.io.Serializable;

import com.lvmama.lvfit.common.dto.request.FitFliBookingCallBackRequest;

public class FitFliCallBackResponseVSTDto implements Serializable {

	private static final long serialVersionUID = -2788934271865217601L;
	
	/**请求对象 */
	private FitFliBookingCallBackRequest callBackRequest;
	
	/**成功与否标志 */
	private boolean successFlag;
	
	/**提示信息 */
	private String returnMsg;

	public FitFliBookingCallBackRequest getCallBackRequest() {
		return callBackRequest;
	}

	public void setCallBackRequest(FitFliBookingCallBackRequest callBackRequest) {
		this.callBackRequest = callBackRequest;
	}

	public boolean isSuccessFlag() {
		return successFlag;
	}

	public void setSuccessFlag(boolean successFlag) {
		this.successFlag = successFlag;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	
	

}
