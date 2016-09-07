package com.lvmama.lvfit.common.dto.order;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.OperType;
import com.lvmama.lvfit.common.dto.enums.RemarkType;

public class FitOrderRemarkDto extends Entity {

    private static final long serialVersionUID = -7208318764310039005L;

    /** 主订单主键 */
    private Long orderMainId;

    /** 订单主键 */
    private Long orderId;

    /** 订单号 */
    private FitOrderNoDto fitOrderNoDto;

    /** 备注类型 */
    private RemarkType remarkType;

    /** 备注 */
    private String remark;

    /** 操作者 */
    private String oper;

    /** 操作者Id */
    private String operId;

    /**操作者类型*/
    private OperType operType;

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

    public FitOrderNoDto getFitOrderNoDto() {
        return fitOrderNoDto;
    }

    public void setFitOrderNoDto(FitOrderNoDto fitOrderNoDto) {
        this.fitOrderNoDto = fitOrderNoDto;
    }

    public RemarkType getRemarkType() {
        return remarkType;
    }

    public void setRemarkType(RemarkType remarkType) {
        this.remarkType = remarkType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId;
    }

    public OperType getOperType() {
        return operType;
    }

    public void setOperType(OperType operType) {
        this.operType = operType;
    }
}
