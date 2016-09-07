package com.lvmama.lvfit.common.dto.order;

import com.lvmama.lvfit.common.dto.enums.FitOrderResultStatus;
import com.lvmama.lvfit.common.dto.enums.FitOrderStatusType;

/**
 * 下单过程,记录VST订单,机票去程订单,机票返程订单用Dto
 * @author lizongze
 *
 */
public class FitOrderMsgDto {
	
	//订单状态类型
	private FitOrderStatusType orderStatusType; 
    // 订单状态, true成功，false失败
    private FitOrderResultStatus status;
    // 错误信息
    private String msg;
    
    public FitOrderMsgDto() {}
    
    public FitOrderMsgDto(FitOrderStatusType orderStatusType,FitOrderResultStatus status, String msg) {
    	this.orderStatusType = orderStatusType;
        this.status = status;
        this.msg = msg;
    }
    
    public FitOrderStatusType getOrderStatusType() {
		return orderStatusType;
	}
	public void setOrderStatusType(FitOrderStatusType orderStatusType) {
		this.orderStatusType = orderStatusType;
	}

	public FitOrderResultStatus getStatus() {
        return status;
    }
    public void setStatus(FitOrderResultStatus status) {
        this.status = status;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
