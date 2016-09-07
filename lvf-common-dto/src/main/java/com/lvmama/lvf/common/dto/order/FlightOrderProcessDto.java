package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.OrderFlag;
import com.lvmama.lvf.common.dto.enums.OrderType;
import com.lvmama.lvf.common.dto.status.ResultStatus;

/**
 * 订单PNR和客票同步记录信息
 * @author majun
 * @date   2015-1-19
 */
public class FlightOrderProcessDto extends Entity implements Serializable{
    
    private static final long serialVersionUID = -5399616593411555L;

    /** 订单主键*/
	private Long orderId;
	
	/**支付提醒(用于短信发送)*/
	private ResultStatus notifyPaySms;
	
	/**删除vst订单*/
	private ResultStatus deleteVstOrder;
	
	/**重新预订*/
	private ResultStatus bookingAgainSms;
	
	/**PNR同步状态*/
	private ResultStatus pnrSyncStatus;
	
	/**客票同步信息状态 */
	private ResultStatus ticketSyncStatus;
	
	/**PNR同步最新修改时间*/
	private Date pnrSyncUpdateTime=new Date();
	
	/**票号同步最新修改时间*/
	private Date ticketSyncUpdateTime=new Date();
	
	/**PNR已同步次数*/
	private int pnrSyncCount = 0;
	
	/**票号已同步次数*/
	private  int ticketSyncCount =0;
	
	/** 订单类型 */
    private OrderType orderType;
    
    /**起飞时间 （非DB字段）*/
    private Date depTime;
    
    /**出票晚提示短信*/
	private ResultStatus notifyIssueAfterPaySms;
	
	/**供应商支付已同步次数*/
	private int suppPaySyncCount = 0;
	/**供应商支付同步状态*/
	private ResultStatus suppPaySyncStatus;
	
	/**供应商支付同步最新修改时间*/
	private Date suppPaySyncUpdateTime=new Date();
    
	public ResultStatus getDeleteVstOrder() {
		return deleteVstOrder;
	}

	public void setDeleteVstOrder(ResultStatus deleteVstOrder) {
		this.deleteVstOrder = deleteVstOrder;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public ResultStatus getNotifyPaySms() {
		return notifyPaySms;
	}

	public void setNotifyPaySms(ResultStatus notifyPaySms) {
		this.notifyPaySms = notifyPaySms;
	}

	public ResultStatus getBookingAgainSms() {
		return bookingAgainSms;
	}

	public void setBookingAgainSms(ResultStatus bookingAgainSms) {
		this.bookingAgainSms = bookingAgainSms;
	}

	public ResultStatus getPnrSyncStatus() {
		return pnrSyncStatus;
	}

	public void setPnrSyncStatus(ResultStatus pnrSyncStatus) {
		this.pnrSyncStatus = pnrSyncStatus;
	}

	public ResultStatus getTicketSyncStatus() {
		return ticketSyncStatus;
	}

	public void setTicketSyncStatus(ResultStatus ticketSyncStatus) {
		this.ticketSyncStatus = ticketSyncStatus;
	}

	public Date getPnrSyncUpdateTime() {
		return pnrSyncUpdateTime;
	}

	public void setPnrSyncUpdateTime(Date pnrSyncUpdateTime) {
		this.pnrSyncUpdateTime = pnrSyncUpdateTime;
	}

	public Date getTicketSyncUpdateTime() {
		return ticketSyncUpdateTime;
	}

	public void setTicketSyncUpdateTime(Date ticketSyncUpdateTime) {
		this.ticketSyncUpdateTime = ticketSyncUpdateTime;
	}

	public int getPnrSyncCount() {
		return pnrSyncCount;
	}

	public void setPnrSyncCount(int pnrSyncCount) {
		this.pnrSyncCount = pnrSyncCount;
	}

	public int getTicketSyncCount() {
		return ticketSyncCount;
	}

	public void setTicketSyncCount(int ticketSyncCount) {
		this.ticketSyncCount = ticketSyncCount;
	}

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

	public Date getDepTime() {
		return depTime;
	}

	public void setDepTime(Date depTime) {
		this.depTime = depTime;
	}

	public ResultStatus getNotifyIssueAfterPaySms() {
		return notifyIssueAfterPaySms;
	}

	public void setNotifyIssueAfterPaySms(ResultStatus notifyIssueAfterPaySms) {
		this.notifyIssueAfterPaySms = notifyIssueAfterPaySms;
	}

	public int getSuppPaySyncCount() {
		return suppPaySyncCount;
	}

	public void setSuppPaySyncCount(int suppPaySyncCount) {
		this.suppPaySyncCount = suppPaySyncCount;
	}

	public ResultStatus getSuppPaySyncStatus() {
		return suppPaySyncStatus;
	}

	public void setSuppPaySyncStatus(ResultStatus suppPaySyncStatus) {
		this.suppPaySyncStatus = suppPaySyncStatus;
	}

	public Date getSuppPaySyncUpdateTime() {
		return suppPaySyncUpdateTime;
	}

	public void setSuppPaySyncUpdateTime(Date suppPaySyncUpdateTime) {
		this.suppPaySyncUpdateTime = suppPaySyncUpdateTime;
	}
   
}
