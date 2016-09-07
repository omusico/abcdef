package com.lvmama.lvfit.common.dto.status.order;

import com.lvmama.lvfit.common.dto.order.FitOrderDto;
import com.lvmama.lvfit.common.dto.order.FitOrderStatusDto;
import com.lvmama.lvfit.common.dto.status.engine.OpContext;

/**
 * 订单状态验证枚举
 * @author majun
 * @date   2015-5-5
 */
public enum OrderStatusVaild 
{
	IS_CAN_CANCEL("是否可取消")
	{
		@Override
		public boolean vaildStatus(OpContext opContext) 
		{
			FitOrderDto fitOrderDto = opContext.getOrder();
			FitOrderStatusDto orderStatus = fitOrderDto.getOrderStatus();
			OrderCancelStatus orderCancelStatus = orderStatus.getOrderCancelStatus();
			OrderPayStatus orderPayStatus = orderStatus.getOrderPayStatus();
//			OrderTicketStatus orderTicketStatus = orderStatus.getOrderTicketStatus();
			
            return orderPayStatus != OrderPayStatus.PAY_SUCC
//            		&& orderTicketStatus != OrderTicketStatus.ISSUE_SUCC
                    && (orderCancelStatus == null
                            || orderCancelStatus == OrderCancelStatus.NULL
                            || orderCancelStatus == OrderCancelStatus.APPLY_CANCEL
                            || orderCancelStatus == OrderCancelStatus.CANCEL_FAIL || orderCancelStatus != OrderCancelStatus.CANCEL_SUCC);
		}
	};
    
    public String cnName;
   
    private OrderStatusVaild(String cnName) {
        this.cnName = cnName;
    }
    
    public boolean vaild(OpContext opContext){
        return vaildStatus(opContext);
    };
    
    public abstract boolean vaildStatus(OpContext opContext);
    
}
