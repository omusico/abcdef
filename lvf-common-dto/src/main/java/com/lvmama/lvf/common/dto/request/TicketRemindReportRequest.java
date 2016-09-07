package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.OrderType;
import com.lvmama.lvf.common.dto.status.order.OrderPayStatus;


@XmlRootElement
public class TicketRemindReportRequest implements Serializable, Dto {

	private static final long serialVersionUID = 5425932982958335253L;



    private Date nowTime;
    
    
    /** 订单NO */
    private String orderNo;

    /** 预定开始时间 */
    private String bookingQueryBegTime;

    /** 预定截止时间 */
    private String bookingQueryEndTime;
    
    /** 处理开始时间 */
    private String commitBegTime;

    /** 处理截止时间 */
    private String commitEndTime;

    /** 航空公司 */
    private String carrierCode;

    /** 供应商 */
    private String suppCode;

    /** 销售渠道 */
    private BookingSource bookingSource;

    /** 航班开始日期 */
    private String flightQueryBegTime;

    /** 航班截止时间 */
    private String flightQueryEndTime;

    /** 订单类型 */
    private OrderType orderType;

    /** 出发机场三字代码 */
    private String depCode;

    /** 出发机场名称 */
    private String depName;

    /** 到达机场三字代码 */
    private String arrCode;

    /** 到达机场名称 */
    private String arrName;
    
    /** 订单支付状态 */
    private OrderPayStatus orderPayStatus;

    /** 订单账号类型(测试、正式、风险) */
    private String orderFlag;
    
    /**销售类型*/
    private String saleType;

	public String getBookingQueryBegTime() {
		return bookingQueryBegTime;
	}

	public String getOrderFlag() {
		return orderFlag;
	}

	public void setOrderFlag(String orderFlag) {
		this.orderFlag = orderFlag;
	}

	public void setBookingQueryBegTime(String bookingQueryBegTime) {
		this.bookingQueryBegTime = bookingQueryBegTime;
	}




	public String getBookingQueryEndTime() {
		return bookingQueryEndTime;
	}




	public void setBookingQueryEndTime(String bookingQueryEndTime) {
		this.bookingQueryEndTime = bookingQueryEndTime;
	}




	public String getCommitBegTime() {
		return commitBegTime;
	}




	public void setCommitBegTime(String commitBegTime) {
		this.commitBegTime = commitBegTime;
	}




	public String getCommitEndTime() {
		return commitEndTime;
	}




	public void setCommitEndTime(String commitEndTime) {
		this.commitEndTime = commitEndTime;
	}




	public String getCarrierCode() {
		return carrierCode;
	}




	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}




	public String getSuppCode() {
		return suppCode;
	}




	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}




	public BookingSource getBookingSource() {
		return bookingSource;
	}




	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}




	public String getFlightQueryBegTime() {
		return flightQueryBegTime;
	}




	public void setFlightQueryBegTime(String flightQueryBegTime) {
		this.flightQueryBegTime = flightQueryBegTime;
	}




	public String getFlightQueryEndTime() {
		return flightQueryEndTime;
	}




	public void setFlightQueryEndTime(String flightQueryEndTime) {
		this.flightQueryEndTime = flightQueryEndTime;
	}




	public OrderType getOrderType() {
		return orderType;
	}




	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}




	public String getDepCode() {
		return depCode;
	}




	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}




	public String getDepName() {
		return depName;
	}




	public void setDepName(String depName) {
		this.depName = depName;
	}




	public String getArrCode() {
		return arrCode;
	}




	public void setArrCode(String arrCode) {
		this.arrCode = arrCode;
	}




	public String getArrName() {
		return arrName;
	}




	public void setArrName(String arrName) {
		this.arrName = arrName;
	}




	public OrderPayStatus getOrderPayStatus() {
		return orderPayStatus;
	}




	public void setOrderPayStatus(OrderPayStatus orderPayStatus) {
		this.orderPayStatus = orderPayStatus;
	}




	public Date getNowTime() {
		return nowTime;
	}




	public void setNowTime(Date nowTime) {
		this.nowTime = nowTime;
	}




	public String getOrderNo() {
		return orderNo;
	}




	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}




	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSaleType() {
		return saleType;
	}

	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}

    
    
}