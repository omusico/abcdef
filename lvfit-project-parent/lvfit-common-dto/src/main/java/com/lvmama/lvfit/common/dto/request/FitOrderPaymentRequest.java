package com.lvmama.lvfit.common.dto.request;

import java.util.Date;

import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvfit.common.dto.order.FitOrderPaymentDto;

/**
 * Created by qihuisong on 2015/12/3.
 */
public class FitOrderPaymentRequest {

    private FitOrderPaymentDto paymentDto = new FitOrderPaymentDto();

    @JsonIgnore
    @XmlTransient
    public PersistenceType getPtype() {
        return paymentDto.getPtype();
    }

    public void setId(Long id) {
        paymentDto.setId(id);
    }

    @JsonIgnore
    public String getSequence() {
        return paymentDto.getSequence();
    }

    public String getUuid() {
        return paymentDto.getUuid();
    }

    public void setUuid(String uuid) {
        paymentDto.setUuid(uuid);
    }

    public Date getCreateTime() {
        return paymentDto.getCreateTime();
    }

    public Date getUpdateTime() {
        return paymentDto.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        paymentDto.setUpdateTime(updateTime);
    }

    public Long getId() {
        return paymentDto.getId();
    }

    public void setPtype(PersistenceType ptype) {
        paymentDto.setPtype(ptype);
    }

    public void setCreateTime(Date createTime) {
        paymentDto.setCreateTime(createTime);
    }
}
