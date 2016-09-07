package com.lvmama.lvf.common.dto.adapter.request.supp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.adapter.request.supp.base.SuppRequest;
import com.lvmama.lvf.common.dto.enums.ChangerType;
import com.lvmama.lvf.common.dto.enums.ProductSourceType;
import com.lvmama.lvf.common.dto.enums.RouteType;
import com.lvmama.lvf.common.dto.enums.SuppSaleType;
import com.lvmama.lvf.common.dto.enums.SuppTicketType;
import com.lvmama.lvf.common.dto.md.DateRange;
import com.lvmama.lvf.common.dto.request.FlightQueryRequest;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderDto;

/**
 * Ctrip国内机票变更请求对象
 * 
 * @author qihuisong
 * @date 2015-9-22
 */
@XmlRootElement
public class FlightSuppOrderChangeRequest extends SuppRequest implements Serializable {

    private static final long serialVersionUID = -1134065645371584263L;

    /** 改签航段序号 */
    private String suppSegementNo;
    
    /** 供应商订单号 */
    private String suppOrderNo;

    /** 航班查询信息 */
    private FlightQueryRequest flightQueryRequest;

    /** 改签航班号 */
    private String changeFlightNo;

    /** 改签出发日期日期段 */
    private DateRange changeDepartureDateRange;

    /** 供应商票源 */
    private SuppTicketType suppTicketType;

    /** 改签ID */
    private String suppChangeNo;

    /** 改签次数 */
    private Long suppChangeNum;

    /** 退票ID */
    private String suppRefundNo;

    /** 票台ID */
    private String suppAgencyNo;

    /** 销售类型 */
    private SuppSaleType suppSaleType;

    /** 产品来源(普通/竞价平台) */
    private ProductSourceType productSourceType;

    /** 供应商订单列表 */
    private List<FlightOrderSuppOrderDto> flightOrderSuppOrderDtos;

    /** 单程和往返信息 */
    private RouteType routeType;

    /** 变更类型 */
    private ChangerType changerType;

    /** 申请时间 */
    private Date applyTime;
    
    /** 供应商票面总价 */
    private BigDecimal suppTotalParPrice;
    
    /** 供应商总结算价 */
    private BigDecimal suppSettlePrice;

    public String getSuppSegementNo() {
        return suppSegementNo;
    }

    public void setSuppSegementNo(String suppSegementNo) {
        this.suppSegementNo = suppSegementNo;
    }

    public String getSuppOrderNo() {
        return suppOrderNo;
    }

    public void setSuppOrderNo(String suppOrderNo) {
        this.suppOrderNo = suppOrderNo;
    }

    public FlightQueryRequest getFlightQueryRequest() {
        return flightQueryRequest;
    }

    public void setFlightQueryRequest(FlightQueryRequest flightQueryRequest) {
        this.flightQueryRequest = flightQueryRequest;
    }

    public String getChangeFlightNo() {
        return changeFlightNo;
    }

    public void setChangeFlightNo(String changeFlightNo) {
        this.changeFlightNo = changeFlightNo;
    }

    public DateRange getChangeDepartureDateRange() {
        return changeDepartureDateRange;
    }

    public void setChangeDepartureDateRange(DateRange changeDepartureDateRange) {
        this.changeDepartureDateRange = changeDepartureDateRange;
    }

    public SuppTicketType getSuppTicketType() {
        return suppTicketType;
    }

    public void setSuppTicketType(SuppTicketType suppTicketType) {
        this.suppTicketType = suppTicketType;
    }

    public String getSuppChangeNo() {
        return suppChangeNo;
    }

    public void setSuppChangeNo(String suppChangeNo) {
        this.suppChangeNo = suppChangeNo;
    }

    public Long getSuppChangeNum() {
        return suppChangeNum;
    }

    public void setSuppChangeNum(Long suppChangeNum) {
        this.suppChangeNum = suppChangeNum;
    }

    public String getSuppRefundNo() {
        return suppRefundNo;
    }

    public void setSuppRefundNo(String suppRefundNo) {
        this.suppRefundNo = suppRefundNo;
    }

    public String getSuppAgencyNo() {
        return suppAgencyNo;
    }

    public void setSuppAgencyNo(String suppAgencyNo) {
        this.suppAgencyNo = suppAgencyNo;
    }

    public SuppSaleType getSuppSaleType() {
        return suppSaleType;
    }

    public void setSuppSaleType(SuppSaleType suppSaleType) {
        this.suppSaleType = suppSaleType;
    }

    public ProductSourceType getProductSourceType() {
        return productSourceType;
    }

    public void setProductSourceType(ProductSourceType productSourceType) {
        this.productSourceType = productSourceType;
    }

    public List<FlightOrderSuppOrderDto> getFlightOrderSuppOrderDtos() {
        return flightOrderSuppOrderDtos;
    }

    public void setFlightOrderSuppOrderDtos(List<FlightOrderSuppOrderDto> flightOrderSuppOrderDtos) {
        this.flightOrderSuppOrderDtos = flightOrderSuppOrderDtos;
    }

    public RouteType getRouteType() {
        return routeType;
    }

    public void setRouteType(RouteType routeType) {
        this.routeType = routeType;
    }

    public ChangerType getChangerType() {
        return changerType;
    }

    public void setChangerType(ChangerType changerType) {
        this.changerType = changerType;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public BigDecimal getSuppTotalParPrice() {
        return suppTotalParPrice;
    }

    public void setSuppTotalParPrice(BigDecimal suppTotalParPrice) {
        this.suppTotalParPrice = suppTotalParPrice;
    }

    public BigDecimal getSuppSettlePrice() {
        return suppSettlePrice;
    }

    public void setSuppSettlePrice(BigDecimal suppSettlePrice) {
        this.suppSettlePrice = suppSettlePrice;
    }

}
