package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.Date;

public class FlightOrderSyncRequest implements Serializable {

	private static final long serialVersionUID = -7352263451974221817L;

	private Long orderId;
	private String userId;
	private String productType;
	private String platform;
	private String paymentTarget;
	private String viewOrderStatus;
	private String performStatus;
    private String orderStatus;
    private String paymentStatus;
    private Date refundTime;
    private String refundStatus;
    
    //其他
    private Date createTime;
    private Date visitTime;
    //用于log
    private String orderNo;
    private String syncType;
    
    /***
	userid：(32位MD5)
	orderId：订单号
	productType:"FLIGHT"（飞机票另外订）
	platform："FLIGHT"（飞机票另外订）
	PAYMENT_TARGET :支付对象：PREPAID（预付（驴妈妈））")
	VIEW_ORDER_STATUS： 显示的订单状态  font_status
	PERFORM_STATUS :UNPERFORM (需确认默认值是否为null )
	ORDER_STATUS :订单状态
	PAYMENT_STATUS ：支付状态 
	REFUND_TIME NULL 需确认默认值是否为nul 
	REFUND_STATUS ：退款状态，REFUNDED PROCESSING ( 需确认默认值是否为null)
     * */
    
   /* TntConstant.java*/
    /* TntOrder.java*/
    /* OrderEnum.java*/
    		
    
    
    
	public Long getOrderId() {
		return orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getSyncType() {
		return syncType;
	}
	public void setSyncType(String syncType) {
		this.syncType = syncType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getPaymentTarget() {
		return paymentTarget;
	}
	public void setPaymentTarget(String paymentTarget) {
		this.paymentTarget = paymentTarget;
	}
	public String getPerformStatus() {
		return performStatus;
	}
	public void setPerformStatus(String performStatus) {
		this.performStatus = performStatus;
	}
	public String getViewOrderStatus() {
		return viewOrderStatus;
	}
	public void setViewOrderStatus(String viewOrderStatus) {
		this.viewOrderStatus = viewOrderStatus;
	}
	public String getRefundStatus() {
		return refundStatus;
	}
	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Date getRefundTime() {
		return refundTime;
	}
	public void setRefundTime(Date refundTime) {
		this.refundTime = refundTime;
	}
	@Override
	public String toString() {
		return "FlightOrderSyncRequest [orderId=" + orderId + ", userId="
				+ userId + ", productType=" + productType + ", platform="
				+ platform + ", paymentTarget=" + paymentTarget
				+ ", viewOrderStatus=" + viewOrderStatus + ", performStatus="
				+ performStatus + ", orderStatus=" + orderStatus
				+ ", paymentStatus=" + paymentStatus + ", refundTime="
				+ refundTime + ", refundStatus=" + refundStatus
				+ ", createTime=" + createTime + ", visitTime=" + visitTime
				+ ", orderNo=" + orderNo + ", syncType=" + syncType + "]";
	}
    
    

}
