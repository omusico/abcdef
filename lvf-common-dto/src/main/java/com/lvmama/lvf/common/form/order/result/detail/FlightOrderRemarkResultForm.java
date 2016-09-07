/**
 * 
 */
package com.lvmama.lvf.common.form.order.result.detail;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.lvmama.lvf.common.dto.OperType;
import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.RemarkType;
import com.lvmama.lvf.common.dto.order.FlightOrderNoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderRemarkDto;
import com.lvmama.lvf.common.dto.other.AttachmentDto;
import com.lvmama.lvf.common.form.Form;

/**
 * 订单备注Form
 * 
 * @author leizhengwei
 * @date 2015-3-18
 */
public class FlightOrderRemarkResultForm implements Serializable, Form {

    private static final long serialVersionUID = -8316181749059969269L;

    private FlightOrderRemarkDto flightOrderRemarkDto = new FlightOrderRemarkDto();

    /** 备注时间 */
    private String remarkTime = StringUtils.EMPTY;

    public FlightOrderRemarkResultForm() {
        super();
    }

    public FlightOrderRemarkResultForm(FlightOrderRemarkDto flightOrderRemarkDto) {
        super();
        this.flightOrderRemarkDto = flightOrderRemarkDto;
    }

    public void setFlightOrderRemarkDto(FlightOrderRemarkDto flightOrderRemarkDto) {
        this.flightOrderRemarkDto = flightOrderRemarkDto;
    }

    public FlightOrderRemarkDto getFlightOrderRemarkDto() {
        return flightOrderRemarkDto;
    }

    public PersistenceType getPtype() {
        return flightOrderRemarkDto.getPtype();
    }

    public void setPtype(PersistenceType ptype) {
        flightOrderRemarkDto.setPtype(ptype);
    }

    public String getSequence() {
        return flightOrderRemarkDto.getSequence();
    }

    public Long getOrderMainId() {
        return flightOrderRemarkDto.getOrderMainId();
    }

    public Long getId() {
        return flightOrderRemarkDto.getId();
    }

    public void setOrderMainId(Long orderMainId) {
        flightOrderRemarkDto.setOrderMainId(orderMainId);
    }

    public void setId(Long id) {
        flightOrderRemarkDto.setId(id);
    }

    public String getUuid() {
        return flightOrderRemarkDto.getUuid();
    }

    public Long getOrderId() {
        return flightOrderRemarkDto.getOrderId();
    }

    public void setUuid(String uuid) {
        flightOrderRemarkDto.setUuid(uuid);
    }

    public void setOrderId(Long orderId) {
        flightOrderRemarkDto.setOrderId(orderId);
    }

    public Date getCreateTime() {
        return flightOrderRemarkDto.getCreateTime();
    }

    public FlightOrderNoDto getFlightOrderNo() {
        return flightOrderRemarkDto.getFlightOrderNo();
    }

    public void setCreateTime(Date createTime) {
        flightOrderRemarkDto.setCreateTime(createTime);
    }

    public void setFlightOrderNo(FlightOrderNoDto flightOrderNo) {
        flightOrderRemarkDto.setFlightOrderNo(flightOrderNo);
    }

    public Date getUpdateTime() {
        return flightOrderRemarkDto.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        flightOrderRemarkDto.setUpdateTime(updateTime);
    }

    public RemarkType getRemarkType() {
        return flightOrderRemarkDto.getRemarkType();
    }

    public void setRemarkType(RemarkType remarkType) {
        flightOrderRemarkDto.setRemarkType(remarkType);
    }

    public String getRemark() {
        return flightOrderRemarkDto.getRemark();
    }

    public void setRemark(String remark) {
        flightOrderRemarkDto.setRemark(remark);
    }

    public String getRemarkTime() {
        return remarkTime;
    }

    public void setRemarkTime(String remarkTime) {
        this.remarkTime = remarkTime;
    }

	public String getOper() {
		return flightOrderRemarkDto.getOper();
	}

	public void setOper(String oper) {
		flightOrderRemarkDto.setOper(oper);
	}

	public String getOperId() {
		return flightOrderRemarkDto.getOperId();
	}

	public void setOperId(String operId) {
		flightOrderRemarkDto.setOperId(operId);
	}

	public OperType getOperType() {
		return flightOrderRemarkDto.getOperType();
	}

	public void setOperType(OperType operType) {
		flightOrderRemarkDto.setOperType(operType);
	}

	public List<AttachmentDto> getAttachments() {
		return flightOrderRemarkDto.getAttachments();
	}

	public void setAttachments(List<AttachmentDto> attachments) {
		flightOrderRemarkDto.setAttachments(attachments);
	}
    
    

}
