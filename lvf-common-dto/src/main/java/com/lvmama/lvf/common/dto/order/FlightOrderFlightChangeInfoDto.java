package com.lvmama.lvf.common.dto.order;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.FlightChangeType;
import com.lvmama.lvf.common.dto.enums.FlightSegmentType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/*
 * 航变通知内容
 */
@XmlRootElement
public class FlightOrderFlightChangeInfoDto extends Entity implements Serializable {

    private static final long serialVersionUID = 7929370961929575848L;
    private String suppOrderNo;//供应商订单号
    private String suppOrderLvNo;//供应商订单对应的驴妈妈编号
    private Long orderId;//子单ID
    private String flightChangeOrderNo;//航变中心订单处理ID号
    private String distributorsChannel;//渠道，Distributors(分销商)
    private Boolean canRefundAll;//能否全退(T:可以全退; F/空:不能全退)
    private FlightSegmentType flightSegmentType;//国内国际(N:国内;I:国际)
    private String flightSequence;//航程
    private String aid;//分销商的 AllianceID
    private String sid;//分销商的 SID
    private String flightChangePNR;//航变 PNR
    private FlightChangeType flightChangeType;//航变类型

    private String originFlightNo;//原始航班号
    private String originSeatClass;//原始仓位
    private Date originDepartureTime;//原始出发日期时间
    private Date originArrivalTime;//原始到达日期时间
    private String originDepartureAirport;//原始出发机场三字码
    private String originArrivalAirport;//原始到达机场三字码
    private String originDepartureBuilding;//原始出发航站楼
    private String originArrivalBuilding;//原始到达航站楼
    private String originAirplaneType;//原始机型

    private String protectFlightNo;//航变新航班号
    private String protectSeatClass;//航变新仓位
    private Date protectDepartureTime;//航变出发日期时间
    private Date protectArrivalTime;//航变到达日期时间
    private String protectDepartureAirport;//航变出发机场三字码
    private String protectArrivalAirport;//航变到达机场三字码
    private String protectDepartureBuilding;//航变出发航站楼
    private String protectArrivalBuilding;//航变到达航站楼
    private String protectAirplaneType;//航变机型

    private Date flightChangeCreateTime;//航变生成时间
    private Boolean validType;//T(准确有效, 默认);F(错误无效)

    public String getSuppOrderNo() {
        return suppOrderNo;
    }

    public void setSuppOrderNo(String suppOrderNo) {
        this.suppOrderNo = suppOrderNo;
    }

    public String getSuppOrderLvNo() {
        return suppOrderLvNo;
    }

    public void setSuppOrderLvNo(String suppOrderLvNo) {
        this.suppOrderLvNo = suppOrderLvNo;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getFlightChangeOrderNo() {
        return flightChangeOrderNo;
    }

    public void setFlightChangeOrderNo(String flightChangeOrderNo) {
        this.flightChangeOrderNo = flightChangeOrderNo;
    }

    public String getDistributorsChannel() {
        return distributorsChannel;
    }

    public void setDistributorsChannel(String distributorsChannel) {
        this.distributorsChannel = distributorsChannel;
    }

    public Boolean getCanRefundAll() {
        return canRefundAll;
    }

    public void setCanRefundAll(Boolean canRefundAll) {
        this.canRefundAll = canRefundAll;
    }

    public FlightSegmentType getFlightSegmentType() {
        return flightSegmentType;
    }

    public void setFlightSegmentType(FlightSegmentType flightSegmentType) {
        this.flightSegmentType = flightSegmentType;
    }

    public String getFlightSequence() {
        return flightSequence;
    }

    public void setFlightSequence(String flightSequence) {
        this.flightSequence = flightSequence;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getFlightChangePNR() {
        return flightChangePNR;
    }

    public void setFlightChangePNR(String flightChangePNR) {
        this.flightChangePNR = flightChangePNR;
    }

    public FlightChangeType getFlightChangeType() {
        return flightChangeType;
    }

    public void setFlightChangeType(FlightChangeType flightChangeType) {
        this.flightChangeType = flightChangeType;
    }

    public String getOriginFlightNo() {
        return originFlightNo;
    }

    public void setOriginFlightNo(String originFlightNo) {
        this.originFlightNo = originFlightNo;
    }

    public String getOriginSeatClass() {
        return originSeatClass;
    }

    public void setOriginSeatClass(String originSeatClass) {
        this.originSeatClass = originSeatClass;
    }

    public Date getOriginDepartureTime() {
        return originDepartureTime;
    }

    public void setOriginDepartureTime(Date originDepartureTime) {
        this.originDepartureTime = originDepartureTime;
    }

    public Date getOriginArrivalTime() {
        return originArrivalTime;
    }

    public void setOriginArrivalTime(Date originArrivalTime) {
        this.originArrivalTime = originArrivalTime;
    }

    public String getOriginDepartureAirport() {
        return originDepartureAirport;
    }

    public void setOriginDepartureAirport(String originDepartureAirport) {
        this.originDepartureAirport = originDepartureAirport;
    }

    public String getOriginArrivalAirport() {
        return originArrivalAirport;
    }

    public void setOriginArrivalAirport(String originArrivalAirport) {
        this.originArrivalAirport = originArrivalAirport;
    }

    public String getOriginDepartureBuilding() {
        return originDepartureBuilding;
    }

    public void setOriginDepartureBuilding(String originDepartureBuilding) {
        this.originDepartureBuilding = originDepartureBuilding;
    }

    public String getOriginArrivalBuilding() {
        return originArrivalBuilding;
    }

    public void setOriginArrivalBuilding(String originArrivalBuilding) {
        this.originArrivalBuilding = originArrivalBuilding;
    }

    public String getOriginAirplaneType() {
        return originAirplaneType;
    }

    public void setOriginAirplaneType(String originAirplaneType) {
        this.originAirplaneType = originAirplaneType;
    }

    public String getProtectFlightNo() {
        return protectFlightNo;
    }

    public void setProtectFlightNo(String protectFlightNo) {
        this.protectFlightNo = protectFlightNo;
    }

    public String getProtectSeatClass() {
        return protectSeatClass;
    }

    public void setProtectSeatClass(String protectSeatClass) {
        this.protectSeatClass = protectSeatClass;
    }

    public Date getProtectDepartureTime() {
        return protectDepartureTime;
    }

    public void setProtectDepartureTime(Date protectDepartureTime) {
        this.protectDepartureTime = protectDepartureTime;
    }

    public Date getProtectArrivalTime() {
        return protectArrivalTime;
    }

    public void setProtectArrivalTime(Date protectArrivalTime) {
        this.protectArrivalTime = protectArrivalTime;
    }

    public String getProtectDepartureAirport() {
        return protectDepartureAirport;
    }

    public void setProtectDepartureAirport(String protectDepartureAirport) {
        this.protectDepartureAirport = protectDepartureAirport;
    }

    public String getProtectArrivalAirport() {
        return protectArrivalAirport;
    }

    public void setProtectArrivalAirport(String protectArrivalAirport) {
        this.protectArrivalAirport = protectArrivalAirport;
    }

    public String getProtectDepartureBuilding() {
        return protectDepartureBuilding;
    }

    public void setProtectDepartureBuilding(String protectDepartureBuilding) {
        this.protectDepartureBuilding = protectDepartureBuilding;
    }

    public String getProtectArrivalBuilding() {
        return protectArrivalBuilding;
    }

    public void setProtectArrivalBuilding(String protectArrivalBuilding) {
        this.protectArrivalBuilding = protectArrivalBuilding;
    }

    public String getProtectAirplaneType() {
        return protectAirplaneType;
    }

    public void setProtectAirplaneType(String protectAirplaneType) {
        this.protectAirplaneType = protectAirplaneType;
    }

    public Date getFlightChangeCreateTime() {
        return flightChangeCreateTime;
    }

    public void setFlightChangeCreateTime(Date flightChangeCreateTime) {
        this.flightChangeCreateTime = flightChangeCreateTime;
    }

    public Boolean getValidType() {
        return validType;
    }

    public void setValidType(Boolean validType) {
        this.validType = validType;
    }
}
