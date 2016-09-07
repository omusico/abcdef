package com.lvmama.lvf.common.dto.status.order;


import java.util.Date;

import com.lvmama.lvf.common.dto.enums.OrderType;
import com.lvmama.lvf.common.dto.order.FlightOrderDto;
import com.lvmama.lvf.common.dto.order.status.FlightOrderStatusDto;
import com.lvmama.lvf.common.dto.status.engine.OpContext;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;

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
			FlightOrderDto flightOrderDto = opContext.getOrder();
			OrderType orderType = flightOrderDto.getOrderType();
			FlightOrderStatusDto flightOrderStatusDto = flightOrderDto.getFlightOrderStatus();
			OrderCancelStatus orderCancelStatus = flightOrderStatusDto.getOrderCancelStatus();
			OrderPayStatus orderPayStatus = flightOrderStatusDto.getOrderPayStatus();
			OrderAuditStatus orderAuditStatus = flightOrderStatusDto.getOrderAuditStatus();
			OrderTicketStatus orderTicketStatus = flightOrderStatusDto.getOrderTicketStatus();
			
			switch (orderType) 
			{
            case NORMAL:
                return orderPayStatus != OrderPayStatus.PAY_SUCC
                		&& orderTicketStatus != OrderTicketStatus.ISSUE_SUCC
                		&& orderTicketStatus != OrderTicketStatus.APPLY_ISSUE
                        && (orderCancelStatus == null
                                || orderCancelStatus == OrderCancelStatus.NULL
                                || orderCancelStatus == OrderCancelStatus.APPLY_CANCEL
                                || orderCancelStatus == OrderCancelStatus.CANCEL_FAIL || orderCancelStatus != OrderCancelStatus.CANCEL_SUCC);
            case CTMT:
                return orderPayStatus != OrderPayStatus.PAY_SUCC
                		&& orderTicketStatus != OrderTicketStatus.CTMT_SUCC
                        && (orderAuditStatus != null && orderAuditStatus == OrderAuditStatus.AUDIT_PASS)
                        && (orderCancelStatus == null
                                || orderCancelStatus == OrderCancelStatus.NULL
                                || orderCancelStatus == OrderCancelStatus.APPLY_CANCEL
                                || orderCancelStatus == OrderCancelStatus.CANCEL_FAIL || orderCancelStatus != OrderCancelStatus.CANCEL_SUCC);
            default:
                return false;
			}
		}
	},
	IS_CAN_DELAY("是否可延后取消时间")
	{
		@Override
		public boolean vaildStatus(OpContext opContext) 
		{
			FlightOrderDto flightOrderDto = opContext.getOrder();
			OrderType orderType = flightOrderDto.getOrderType();
			FlightOrderStatusDto flightOrderStatusDto = flightOrderDto.getFlightOrderStatus();
			OrderCancelStatus orderCancelStatus = flightOrderStatusDto.getOrderCancelStatus();
			OrderPayStatus orderPayStatus = flightOrderStatusDto.getOrderPayStatus();
			OrderAuditStatus orderAuditStatus = flightOrderStatusDto.getOrderAuditStatus();
			OrderTicketStatus orderTicketStatus = flightOrderStatusDto.getOrderTicketStatus();
			
			switch (orderType) 
			{
            case NORMAL:
                return orderPayStatus != OrderPayStatus.PAY_SUCC
                		&& orderTicketStatus != OrderTicketStatus.ISSUE_SUCC
                		&& orderTicketStatus != OrderTicketStatus.APPLY_ISSUE
                        && (orderCancelStatus == null
                                || orderCancelStatus == OrderCancelStatus.NULL
                                || orderCancelStatus == OrderCancelStatus.APPLY_CANCEL
                                || orderCancelStatus == OrderCancelStatus.CANCEL_FAIL || orderCancelStatus != OrderCancelStatus.CANCEL_SUCC);
            case CTMT:
                return orderPayStatus != OrderPayStatus.PAY_SUCC
                		&& orderTicketStatus == OrderTicketStatus.APPLY_CTMT
                        && orderAuditStatus == OrderAuditStatus.AUDIT_PASS 
                        && (orderCancelStatus == null
                                || orderCancelStatus == OrderCancelStatus.NULL
                                || orderCancelStatus == OrderCancelStatus.APPLY_CANCEL
                                || orderCancelStatus == OrderCancelStatus.CANCEL_FAIL || orderCancelStatus != OrderCancelStatus.CANCEL_SUCC);
            default:
                return false;
			}
		}
	},
    IS_CAN_PAY("是否可支付")
    {
        @Override
        public boolean vaildStatus(OpContext opContext) 
        {
        	FlightOrderDto flightOrderDto = opContext.getOrder();
			OrderType orderType = flightOrderDto.getOrderType();
            FlightOrderStatusDto flightOrderStatusDto = flightOrderDto.getFlightOrderStatus();
            OrderBookingStatus orderBookingStatus = flightOrderStatusDto.getOrderBookingStatus();
            OrderCancelStatus orderCancelStatus = flightOrderStatusDto.getOrderCancelStatus();
            OrderPayStatus orderPayStatus = flightOrderStatusDto.getOrderPayStatus();
            OrderAuditStatus orderAuditStatus = flightOrderStatusDto.getOrderAuditStatus();
            Date now = new Date();
            Date limitTime = flightOrderDto.getLimitTime()==null?now:flightOrderDto.getLimitTime();
            
            switch(orderType)
            {
            	case NORMAL:
            		return orderBookingStatus == OrderBookingStatus.BOOKING_SUCC
	                	&& (orderCancelStatus == null || orderCancelStatus == OrderCancelStatus.NULL)
	                	&& (orderPayStatus == null || orderPayStatus == OrderPayStatus.NULL 
	                		|| orderPayStatus == OrderPayStatus.NOT_PAY || orderPayStatus == OrderPayStatus.PAY_FAIL)
	                	&& now.before(limitTime);
            	case CTMT:
            		return orderAuditStatus == OrderAuditStatus.AUDIT_PASS  
    	                && (orderCancelStatus == null || orderCancelStatus == OrderCancelStatus.NULL)
            			&&(orderPayStatus == null || orderPayStatus == OrderPayStatus.NULL 
	                	|| orderPayStatus == OrderPayStatus.NOT_PAY || orderPayStatus == OrderPayStatus.PAY_FAIL)
	                	&& now.before(limitTime);
            	default:
            		return false;
            }
        }
    },
    IS_CAN_APPLY_ISSUE("是否可申请出票")
    {
    	@Override
    	public boolean vaildStatus(OpContext opContext) 
    	{
    		FlightOrderDto flightOrderDto = opContext.getOrder();
			OrderType orderType = flightOrderDto.getOrderType();
    		FlightOrderStatusDto flightOrderStatusDto = flightOrderDto.getFlightOrderStatus();
    		OrderPayStatus orderPayStatus = flightOrderStatusDto.getOrderPayStatus();
    		OrderTicketStatus orderTicketStatus = flightOrderStatusDto.getOrderTicketStatus();
    		
    		switch (orderType) 
    		{
				case NORMAL:
                return orderPayStatus == OrderPayStatus.PAY_SUCC && (orderTicketStatus == null
                                || orderTicketStatus == OrderTicketStatus.NOT_ISSUE
                                || orderTicketStatus == OrderTicketStatus.NULL
                                || orderTicketStatus == OrderTicketStatus.ISSUE_FAIL);
				default:
					return false;
			}
    	}
    },
    // 暂时给测试用
    IS_CAN_SYNC_SUPP_ISSUE("是否可同步供应商出票信息")
    {
        @Override
        public boolean vaildStatus(OpContext opContext)
        {
            FlightOrderDto flightOrderDto = opContext.getOrder();
            OrderType orderType = flightOrderDto.getOrderType();
            FlightOrderStatusDto flightOrderStatusDto = flightOrderDto.getFlightOrderStatus();
            OrderAuditStatus orderAuditStatus = flightOrderStatusDto.getOrderAuditStatus();
            SuppOrderAuditStatus suppOrderAuditStatus = flightOrderStatusDto.getSuppOrderAuditStatus();
            OrderTicketStatus orderTicketStatus = flightOrderStatusDto.getOrderTicketStatus();
            
            switch (orderType) 
            {
                case NORMAL:
                    return orderAuditStatus == OrderAuditStatus.AUDIT_PASS
                            && (suppOrderAuditStatus == SuppOrderAuditStatus.APPLY_SUPP_OP || suppOrderAuditStatus == SuppOrderAuditStatus.SUPP_OP_REJECT)
                            && orderTicketStatus == OrderTicketStatus.APPLY_ISSUE;
                default:
                    return false;
            }
        }
    },
    IS_CAN_REFUND("是否可退款")
    {
    	@Override
    	public boolean vaildStatus(OpContext opContext) 
    	{
    		FlightOrderDto flightOrderDto = opContext.getOrder();
			OrderType orderType = flightOrderDto.getOrderType();
    		FlightOrderStatusDto flightOrderStatusDto = flightOrderDto.getFlightOrderStatus();
    		OrderAuditStatus orderAuditStatus = flightOrderStatusDto.getOrderAuditStatus();
    		OrderPayStatus orderPayStatus = flightOrderStatusDto.getOrderPayStatus();
            OrderTicketStatus orderTicketStatus = flightOrderStatusDto.getOrderTicketStatus();
            OrderCancelStatus orderCancelStatus = flightOrderStatusDto.getOrderCancelStatus();
            
    		switch(orderType)
    		{
    			case NORMAL:
                    return (orderAuditStatus == OrderAuditStatus.OP_REJECT
	                    && orderTicketStatus == OrderTicketStatus.ISSUE_FAIL
                       && orderPayStatus == OrderPayStatus.PAY_SUCC) ||
                       (orderCancelStatus == OrderCancelStatus.CANCEL_SUCC 
                       && orderPayStatus == OrderPayStatus.PAY_SUCC) ;
    			case RTVT:
    				return orderAuditStatus == OrderAuditStatus.AUDIT_PASS
    					&& (orderPayStatus != OrderPayStatus.APPLY_REFUND && orderPayStatus != OrderPayStatus.REFUND_SUCC 
    					&& orderPayStatus != OrderPayStatus.REFUND_FAIL);
    			default:
    				return false;
    		}
    	}
    },
    IS_CAN_SUPP_RTVT("是否可供应商退票")
    {
    	@Override
    	public boolean vaildStatus(OpContext opContext)
    	{
    		FlightOrderDto flightOrderDto = opContext.getOrder();
			OrderType orderType = flightOrderDto.getOrderType();
			FlightOrderStatusDto flightOrderStatusDto = flightOrderDto.getFlightOrderStatus();
    		OrderAuditStatus orderAuditStatus = flightOrderStatusDto.getOrderAuditStatus();
			SuppOrderAuditStatus suppOrderAuditStatus = flightOrderStatusDto.getSuppOrderAuditStatus();
    		
			switch (orderType) 
			{
				case RTVT:
					return (suppOrderAuditStatus == null || suppOrderAuditStatus == SuppOrderAuditStatus.NULL)
						&& (orderAuditStatus == OrderAuditStatus.NOT_AUDIT || orderAuditStatus == OrderAuditStatus.AUDIT_PASS);
				default:
					return false;
			}
    	}
    },IS_CAN_SETTLEMENT("是否可申请结算")
    {
    	@Override
    	public boolean vaildStatus(OpContext opContext) 
    	{
    		FlightOrderDto flightOrderDto = opContext.getOrder();
			OrderType orderType = flightOrderDto.getOrderType();
    		FlightOrderStatusDto flightOrderStatusDto = flightOrderDto.getFlightOrderStatus();
    		OrderTicketStatus orderTicketStatus = flightOrderStatusDto.getOrderTicketStatus();
    		
    		switch (orderType) 
    		{
				case NORMAL:
					return orderTicketStatus == OrderTicketStatus.ISSUE_SUCC;
				case CTMT:
	                return orderTicketStatus == OrderTicketStatus.CTMT_SUCC;
				case RTVT:
	                return orderTicketStatus == OrderTicketStatus.RTVT_SUCC;
				default:
					return false;
			}
    	}
    },IS_CAN_DIRECT_REDUCTION("是否可调控支付金额")
    {
    	@Override
    	public boolean vaildStatus(OpContext opContext) 
    	{
    		FlightOrderDto flightOrderDto = opContext.getOrder();
//			OrderType orderType = flightOrderDto.getOrderType();
    		FlightOrderStatusDto flightOrderStatusDto = flightOrderDto.getFlightOrderStatus();
    		OrderPayStatus orderPayStatus = flightOrderStatusDto.getOrderPayStatus();
    		OrderCancelStatus orderCancelStatus = flightOrderStatusDto.getOrderCancelStatus();
//    		List<FlightOrderPaymentDto> flightOrderPaymentDtos = flightOrderDto.getFlightOrderPayments();
//    		switch (orderType) 
//			{
//				case NORMAL:
//					return orderPayStatus == OrderPayStatus.NOT_PAY && orderCancelStatus == OrderCancelStatus.NULL;
//				case CTMT:
//					return orderPayStatus == OrderPayStatus.NOT_PAY && orderCancelStatus == OrderCancelStatus.NULL;
//				default:
//					return false;
//			}
    		if (orderPayStatus == OrderPayStatus.NOT_PAY && orderCancelStatus == OrderCancelStatus.NULL) {
    			return true;
			}
    		return false;
    	}
    }, IS_CAN_ROLLBACK_CANCEL("是否可回退取消"){
		@Override
		public boolean vaildStatus(OpContext opContext) 
		{
			FlightOrderDto flightOrderDto = opContext.getOrder();
			OrderType orderType = flightOrderDto.getOrderType();
			FlightOrderStatusDto flightOrderStatusDto = flightOrderDto.getFlightOrderStatus();
			OrderCancelStatus orderCancelStatus = flightOrderStatusDto.getOrderCancelStatus();
			OrderPayStatus orderPayStatus = flightOrderStatusDto.getOrderPayStatus();
			switch (orderType) 
			{
            case NORMAL:
                return orderPayStatus != null && orderPayStatus == OrderPayStatus.PAY_SUCC && 
                	orderCancelStatus != null && orderCancelStatus == OrderCancelStatus.CANCEL_SUCC;
            default:
                return false;
			}
		}
	
    }, IS_CAN_OP_PASS_ISSUE("是否可出票处理通过") {
    	@Override
		public boolean vaildStatus(OpContext opContext){
			FlightOrderDto flightOrderDto = opContext.getOrder();
			OrderType orderType = flightOrderDto.getOrderType();
			FlightOrderStatusDto flightOrderStatusDto = flightOrderDto.getFlightOrderStatus();
			OrderCancelStatus orderCancelStatus = flightOrderStatusDto.getOrderCancelStatus();
			switch (orderType) 
			{
            case NORMAL:
                return orderCancelStatus != null && orderCancelStatus == OrderCancelStatus.NULL;
            default:
                return false;
			}
		}
	}, IS_CAN_OP_REJECT_ISSUE("是否可出票处理驳回") {
    	@Override
		public boolean vaildStatus(OpContext opContext){
			FlightOrderDto flightOrderDto = opContext.getOrder();
			OrderType orderType = flightOrderDto.getOrderType();
			FlightOrderStatusDto flightOrderStatusDto = flightOrderDto.getFlightOrderStatus();
			OrderCancelStatus orderCancelStatus = flightOrderStatusDto.getOrderCancelStatus();
			switch (orderType) 
			{
            case NORMAL:
                return orderCancelStatus != null && orderCancelStatus == OrderCancelStatus.NULL;
            default:
                return false;
			}
		}
	};
    
    public String cnName;
   
    private OrderStatusVaild(String cnName) {
        this.cnName = cnName;
    }
    
    public boolean vaild(OpContext opContext){
        if(null==opContext.getOrder().getOrderType()){
           throw new ExceptionWrapper(ExceptionCode.NO_FULL_ORDER_INFO); 
        }
        return vaildStatus(opContext);
    };
    
    public abstract boolean vaildStatus(OpContext opContext);
    
}
