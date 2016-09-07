package com.lvmama.lvf.common.dto.supp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.ChangerType;
import com.lvmama.lvf.common.dto.status.order.OrderTicketStatus;

/**
 * 供应商订单改签返回信息对象
 * 
 * @author yuanweihong
 * @date 2015-10-13
 */
@XmlRootElement
public class FlightOrderSuppOrderChangeDto extends Entity implements Serializable {

    private static final long serialVersionUID = 5096346298207356160L;

    /** 供应商订单NO */
    private String suppOrderNo;

    /** 改签时间 */
    private Date factChangeTime;

    /** 改期升舱类型 */
    private ChangerType changerType;

    /** 订单机票状态 */
    private OrderTicketStatus orderTicketStatus;

    /** 供应商订单改签详细基本信息 */
    private List<FlightOrderSuppOrderChangeDetailDto> changeDetails = new ArrayList<FlightOrderSuppOrderChangeDetailDto>();

    public String getSuppOrderNo() {
        return suppOrderNo;
    }

    public void setSuppOrderNo(String suppOrderNo) {
        this.suppOrderNo = suppOrderNo;
    }

    public Date getFactChangeTime() {
        return factChangeTime;
    }

    public void setFactChangeTime(Date factChangeTime) {
        this.factChangeTime = factChangeTime;
    }

    public ChangerType getChangerType() {
        return changerType;
    }

    public void setChangerType(ChangerType changerType) {
        this.changerType = changerType;
    }

    public OrderTicketStatus getOrderTicketStatus() {
        return orderTicketStatus;
    }

    public void setOrderTicketStatus(OrderTicketStatus orderTicketStatus) {
        this.orderTicketStatus = orderTicketStatus;
    }

    public List<FlightOrderSuppOrderChangeDetailDto> getChangeDetails() {
        return changeDetails;
    }

    public void setChangeDetails(List<FlightOrderSuppOrderChangeDetailDto> changeDetails) {
        this.changeDetails = changeDetails;
    }

}
