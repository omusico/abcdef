package com.lvmama.lvfit.common.dto.order;

import java.io.Serializable;
public class FitOrderNoDto implements Serializable {

    private static final long serialVersionUID = -7633347400562015605L;

    /** 订单号 */
    private String orderNo;

    public FitOrderNoDto(String orderNo) {
        this.orderNo = orderNo;
    }

    public FitOrderNoDto() {
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

}
