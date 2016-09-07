package com.lvmama.lvf.common.dto.adapter.request.supp;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.adapter.request.supp.base.SuppRequest;


/**
 * Ctrip国内机票(改签)支付接口请求对象
 * 
 * @author yuanweihong
 * @date 2015-9-17
 */
@XmlRootElement
public class FlightSuppOrderPayRequest extends SuppRequest implements Serializable {

    private static final long serialVersionUID = -3171741725649556342L;

    private List<FlightSuppOrderSimpleOpRequest> suppOrderSimpleOpRequests;

    /** 置收款号 */
    private String externalNo;

    /** 主订单号 */
    private String orderMainNo;

    /** 联盟订单号 */
    private String allianceOrderID;

    public List<FlightSuppOrderSimpleOpRequest> getSuppOrderSimpleOpRequests() {
        return suppOrderSimpleOpRequests;
    }

    public void setSuppOrderSimpleOpRequests(
            List<FlightSuppOrderSimpleOpRequest> suppOrderSimpleOpRequests) {
        this.suppOrderSimpleOpRequests = suppOrderSimpleOpRequests;
    }

    public String getExternalNo() {
        return externalNo;
    }

    public void setExternalNo(String externalNo) {
        this.externalNo = externalNo;
    }

    public String getOrderMainNo() {
        return orderMainNo;
    }

    public void setOrderMainNo(String orderMainNo) {
        this.orderMainNo = orderMainNo;
    }

    public String getAllianceOrderID() {
        return allianceOrderID;
    }

    public void setAllianceOrderID(String allianceOrderID) {
        this.allianceOrderID = allianceOrderID;
    }

}
