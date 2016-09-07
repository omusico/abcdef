package com.lvmama.lvfit.common.dto.request;

import java.util.Date;

import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvfit.common.dto.order.FitOrderRefundDto;

/**
 * Created by qihuisong on 2015/12/3.
 */
public class FitOrderRefundRequest {

    private FitOrderRefundDto refundDto = new FitOrderRefundDto();

    @JsonIgnore
    @XmlTransient
    public PersistenceType getPtype() {
        return refundDto.getPtype();
    }

    public void setId(Long id) {
        refundDto.setId(id);
    }

    @JsonIgnore
    public String getSequence() {
        return refundDto.getSequence();
    }

    public String getUuid() {
        return refundDto.getUuid();
    }

    public void setUuid(String uuid) {
        refundDto.setUuid(uuid);
    }

    public Date getCreateTime() {
        return refundDto.getCreateTime();
    }

    public Date getUpdateTime() {
        return refundDto.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        refundDto.setUpdateTime(updateTime);
    }

    public Long getId() {
        return refundDto.getId();
    }

    public void setPtype(PersistenceType ptype) {
        refundDto.setPtype(ptype);
    }

    public void setCreateTime(Date createTime) {
        refundDto.setCreateTime(createTime);
    }
}
