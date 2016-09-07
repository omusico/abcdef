package com.lvmama.lvfit.common.dto.order;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.status.ResultStatus;

/**
 * 订单PNR和客票同步记录信息
 * @author majun
 * @date   2015-1-19
 */
public class FitOrderProcessDto extends Entity implements Serializable{
    
    private static final long serialVersionUID = -5399616593411555L;

    /** 订单主键*/
	private Long orderId;
	
	/**支付提醒(用于短信发送)*/
	private ResultStatus notifyPaySms;

	
}
