package com.lvmama.lvfit.common.dto.request;

import com.lvmama.lvfit.common.dto.enums.BindingStatus;
import com.lvmama.lvfit.common.dto.order.FitOrderRelationDto;

/**
 * Created by qihuisong on 2015/12/3.
 */
public class FitOrderRelationRequest {

    private FitOrderRelationDto relationDto = new FitOrderRelationDto();

    public void setBindingStatus(BindingStatus bindingStatus) {
        relationDto.setBindingStatus(bindingStatus);
    }

    public Long getSalesOrderId() {
        return relationDto.getSalesOrderId();
    }

    public void setSalesOrderId(Long salesOrderId) {
        relationDto.setSalesOrderId(salesOrderId);
    }

    public Long getSalesMainOrderId() {
        return relationDto.getSalesMainOrderId();
    }

    public void setSalesMainOrderId(Long salesMainOrderId) {
        relationDto.setSalesMainOrderId(salesMainOrderId);
    }

    public String getOrderMainNo() {
        return relationDto.getOrderMainNo();
    }

    public void setOrderMainNo(String orderMainNo) {
        relationDto.setOrderMainNo(orderMainNo);
    }

    public Long getOrderMainId() {
        return relationDto.getOrderMainId();
    }

    public void setOrderMainId(Long orderMainId) {
        relationDto.setOrderMainId(orderMainId);
    }

    public BindingStatus getBindingStatus() {
        return relationDto.getBindingStatus();
    }
}
