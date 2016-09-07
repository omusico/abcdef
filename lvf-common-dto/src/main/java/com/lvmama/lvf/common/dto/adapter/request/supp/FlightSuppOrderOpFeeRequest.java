package com.lvmama.lvf.common.dto.adapter.request.supp;

import com.lvmama.lvf.common.dto.adapter.request.supp.base.SuppRequest;
import com.lvmama.lvf.common.dto.enums.ProductSourceType;
import com.lvmama.lvf.common.dto.enums.RouteType;
import com.lvmama.lvf.common.dto.enums.SuppSaleType;
import com.lvmama.lvf.common.dto.enums.SuppTicketType;
import com.lvmama.lvf.common.dto.md.DateRange;
import com.lvmama.lvf.common.dto.request.FlightQueryRequest;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderDto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Ctrip国内机票退票、改签手续费查询对象
 * @author qihuisong
 * @date 2015-9-22
 */
@XmlRootElement
public class FlightSuppOrderOpFeeRequest extends SuppRequest implements Serializable {

    private static final long serialVersionUID = -2368256860409538689L;

    private String passengerType;//乘客类型
    private String rid;//退票 ID 对应航班基础查询返回体中的  Refundfeeformulaid 字段
    private String cid;//改签ID  对应航班基础查询返回体中的 RerouteFeeFormularID字段
    private String price;//售价  对应航班基础查询返回体中的 Price 字段
    private String fDPrice;//FD 价  对应航班基础查询返回体中的 FDPrice 字段
    private String standPrice;//标准价  对应航班基础查询返回体中 StandardPriceList 节点下的每个舱位等级对应的标准价 price 字段
    private String printPrice;//票面价  对应航班基础查询返回体中的 PrintPrice 字段
    private String productSourceNum;//产品来源  对应航班基础查询返回体中的 ProductSource 字段
    private Boolean isResetPolicy;//是否替换过退改签规定
    private Boolean nonRef;//是否能退，对应航班基础查询返回体中的 RefundRule 节点下的 RuleRestriction 节点 T 传 true   H 和 F 传 false
    private Boolean nonRer;//是否能改，对应航班基础查询返回体中的 ChangeRule 节点下的 RuleRestriction 节点  T 传 true H 和 F传 false
    private String rCID;//默认  基础查询中的 Refundfeeformulaid 字段

    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getfDPrice() {
        return fDPrice;
    }

    public void setfDPrice(String fDPrice) {
        this.fDPrice = fDPrice;
    }

    public String getStandPrice() {
        return standPrice;
    }

    public void setStandPrice(String standPrice) {
        this.standPrice = standPrice;
    }

    public String getPrintPrice() {
        return printPrice;
    }

    public void setPrintPrice(String printPrice) {
        this.printPrice = printPrice;
    }

    public String getProductSourceNum() {
        return productSourceNum;
    }

    public void setProductSourceNum(String productSourceNum) {
        this.productSourceNum = productSourceNum;
    }

    public String getrCID() {
        return rCID;
    }

    public void setrCID(String rCID) {
        this.rCID = rCID;
    }

    public Boolean getIsResetPolicy() {
        return isResetPolicy;
    }

    public void setIsResetPolicy(Boolean isResetPolicy) {
        this.isResetPolicy = isResetPolicy;
    }

    public Boolean getNonRef() {
        return nonRef;
    }

    public void setNonRef(Boolean nonRef) {
        this.nonRef = nonRef;
    }

    public Boolean getNonRer() {
        return nonRer;
    }

    public void setNonRer(Boolean nonRer) {
        this.nonRer = nonRer;
    }
}
