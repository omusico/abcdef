package com.lvmama.lvfit.common.dto.order;

import com.lvmama.lvf.common.dto.OpLog;
import com.lvmama.lvfit.common.dto.enums.OrderOpType;

public class FitOrderOpLogDto extends OpLog {

    private static final long serialVersionUID = -413767876664750803L;

    /** 主订单主键 */
    private Long orderMainId;

    /** 订单主键 */
    private Long orderId;

    /** 监控号 */
    private String traceNo;

    private OrderOpType orderOpType;

    public Long getOrderMainId() {
        return orderMainId;
    }

    public void setOrderMainId(Long orderMainId) {
        this.orderMainId = orderMainId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public OrderOpType getOrderOpType() {
        return orderOpType;
    }

    public void setOrderOpType(OrderOpType orderOpType) {
        this.orderOpType = orderOpType;
    }
}
