package com.lvmama.lvf.common.dto.settlement;

import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.StatementStatus;
import com.lvmama.lvf.common.dto.status.order.OrderBackStatus;
import com.lvmama.lvf.common.dto.status.order.OrderSettlementStatus;

/**   
 * @Title: FlightOrderSettlementDto.java 
 * @Package com.lvmama.lvf.common.dto.order.settlement 
 * @Description: 飞机票结算（适用于出票、退票、改期针对供应商做结算，如51book，携程等）
 * @author Chase_lv
 * @date 2015年4月21日 下午2:56:34 
 */
public class FlightOrderSettlementDto extends Entity {
	
	private static final long serialVersionUID = -8924690465814478052L;

	/** 主订单号*/
	private Long orderId;
	
	/**结算单号*/
	private Long settlementNo;
	
	/**给结算系统设置->orderItemProdId订单ID*/
	private Long serialNo;
	
	/** 订单状态--主订单状态：正常、取消、完成(NORMAL,CANCEL，DONE(转成FINISHED))*/
	private OrderBackStatus orderStatus;
	
	/** 订单支付时间*/
	private Date orderPaymentTime;
	
	/** 订单创建时间*/
	private Date orderCreateTime;			
	
	/** 订单支付状态*/
	private String orderPaymentStatus;		
	
	/** 订单联系人*/
	private String orderContactPerson;		
	
	/** 是否订单有退款 0.没有 1.有退款*/
	private Integer orderRefund = 0;		
	
	/** 订单的退款备注*/
	private String refundMemo;				
	
	/** 订单子项id (是否必须，待定)*/
	private Long orderItemProdId;
	
	/** 产品ID*/
	private Long productId;		
	
	/** 销售产品名称--出发城市-到达城市-出发时间-航班-舱位代码-人数*/
	private String productName;	
	
	/** 销售单价-给结算中心的结算价*/
	private BigDecimal productPrice;				
	
	/** 结算单价--给结算中心的结算价*/
	private BigDecimal settlementPrice;			
	
	/** 实际结算单价--出票后的实际结算价*/
	private BigDecimal actualSettlementPrice;		

	/** 订购数量--按人数*/
	private Long quantity;				
	
	/** 起飞时间*/
	private Date visitTime;					
	
	/** 结算状态-->出票和改签-已结算，退票是未结算*/
	private OrderSettlementStatus settlementStatus = OrderSettlementStatus.NOT_SETTLEMENT;
	
	/** 结算总价--结算单价x人数-应该付给供应商的价格*/
	private BigDecimal totalSettlementPrice;		
	
	/** 状态， 默认：NORMAL,退款：NOSETTLEMENT,取消订单：CANCEL*/
	private StatementStatus status;		
	
	/** 结算项类别（group  or  order），默认为ORDER*/
	private String settlementType = "ORDER";
	
	/** 订单退款金额（分）--退款差额*/
	private BigDecimal refundedAmount;
	
	/** 订单应付总额（分）--用户实际支付金额*/
	private BigDecimal oughtPay;					
	
	/** 实际结算价总金额-实际付给供应商的价格*/
	private BigDecimal countSettleAmount;			
	
	/** 采购主体(所属分公司)	*/
	private String businessName;
	
	/** 订单实付打款金额(分--实际结算价总金额)*/
	private BigDecimal payedAmount;
	

	
	/** 采购产品ID*/
	private Long metaProductId;
	
	/** 采购产品名称*/
	private String metaProductName;
	
	/** 采购产品分类ID*/
	private Long metaBranchId;
	
	/** 采购产品分类名称	*/
	private String metaBranchName;
	
	
	//---------------下面字段从配置文件表里拿--------------------
	
	/** 销售产品类型*/
	private String productType = "23";		
	
	/** 供应商ID*/
	private Long supplierId;				
	
	/** 结算对象ID*/
	private Long targetId;
	
	/** 所属公司 (默认 上海总部SH_FILIALE)*/
	private String filialeName = "SH_FILIALE";
	
	/** 采购主体(所属分公司)--上海总部*/
	private String metaFilialeName = "SH_FILIALE";
	
	/** 机票结算周期*/
	private String setsettlementPeriod;
	
	/** BU事业部--飞机票项目组*/
	private String belongBU;
	//-----------------------------
	/**订单子子项ID*/
	private Long orderItemMetaId;
	
	/** 打包数量--按人数*/
	private Long productQuantity;
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public OrderBackStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderBackStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderPaymentTime() {
		return orderPaymentTime;
	}

	public void setOrderPaymentTime(Date orderPaymentTime) {
		this.orderPaymentTime = orderPaymentTime;
	}

	public Date getOrderCreateTime() {
		return orderCreateTime;
	}

	public void setOrderCreateTime(Date orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}

	public String getOrderPaymentStatus() {
		return orderPaymentStatus;
	}

	public void setOrderPaymentStatus(String orderPaymentStatus) {
		this.orderPaymentStatus = orderPaymentStatus;
	}

	public String getOrderContactPerson() {
		return orderContactPerson;
	}

	public void setOrderContactPerson(String orderContactPerson) {
		this.orderContactPerson = orderContactPerson;
	}

	public Integer getOrderRefund() {
		return orderRefund;
	}

	public void setOrderRefund(Integer orderRefund) {
		this.orderRefund = orderRefund;
	}

	public String getRefundMemo() {
		return refundMemo;
	}

	public void setRefundMemo(String refundMemo) {
		this.refundMemo = refundMemo;
	}

	public Long getOrderItemProdId() {
		return orderItemProdId;
	}

	public void setOrderItemProdId(Long orderItemProdId) {
		this.orderItemProdId = orderItemProdId;
	}


	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public BigDecimal getSettlementPrice() {
		return settlementPrice;
	}

	public void setSettlementPrice(BigDecimal settlementPrice) {
		this.settlementPrice = settlementPrice;
	}

	public BigDecimal getActualSettlementPrice() {
		return actualSettlementPrice;
	}

	public void setActualSettlementPrice(BigDecimal actualSettlementPrice) {
		this.actualSettlementPrice = actualSettlementPrice;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Date getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}

	public OrderSettlementStatus getSettlementStatus() {
		return settlementStatus;
	}

	public void setSettlementStatus(OrderSettlementStatus settlementStatus) {
		this.settlementStatus = settlementStatus;
	}

	public BigDecimal getTotalSettlementPrice() {
		return totalSettlementPrice;
	}

	public void setTotalSettlementPrice(BigDecimal totalSettlementPrice) {
		this.totalSettlementPrice = totalSettlementPrice;
	}

	public StatementStatus getStatus() {
		return status;
	}

	public void setStatus(StatementStatus status) {
		this.status = status;
	}

	public String getSettlementType() {
		return settlementType;
	}

	public void setSettlementType(String settlementType) {
		this.settlementType = settlementType;
	}

	public BigDecimal getRefundedAmount() {
		return refundedAmount;
	}

	public void setRefundedAmount(BigDecimal refundedAmount) {
		this.refundedAmount = refundedAmount;
	}

	public BigDecimal getOughtPay() {
		return oughtPay;
	}

	public void setOughtPay(BigDecimal oughtPay) {
		this.oughtPay = oughtPay;
	}

	public BigDecimal getCountSettleAmount() {
		return countSettleAmount;
	}

	public void setCountSettleAmount(BigDecimal countSettleAmount) {
		this.countSettleAmount = countSettleAmount;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public BigDecimal getPayedAmount() {
		return payedAmount;
	}

	public void setPayedAmount(BigDecimal payedAmount) {
		this.payedAmount = payedAmount;
	}

	public String getSetsettlementPeriod() {
		return setsettlementPeriod;
	}

	public void setSetsettlementPeriod(String setsettlementPeriod) {
		this.setsettlementPeriod = setsettlementPeriod;
	}

	public Long getMetaProductId() {
		return metaProductId;
	}

	public void setMetaProductId(Long metaProductId) {
		this.metaProductId = metaProductId;
	}

	public String getMetaProductName() {
		return metaProductName;
	}

	public void setMetaProductName(String metaProductName) {
		this.metaProductName = metaProductName;
	}

	public Long getMetaBranchId() {
		return metaBranchId;
	}

	public void setMetaBranchId(Long metaBranchId) {
		this.metaBranchId = metaBranchId;
	}

	public String getMetaBranchName() {
		return metaBranchName;
	}

	public void setMetaBranchName(String metaBranchName) {
		this.metaBranchName = metaBranchName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Long getTargetId() {
		return targetId;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

	public String getFilialeName() {
		return filialeName;
	}

	public void setFilialeName(String filialeName) {
		this.filialeName = filialeName;
	}

	public String getMetaFilialeName() {
		return metaFilialeName;
	}

	public void setMetaFilialeName(String metaFilialeName) {
		this.metaFilialeName = metaFilialeName;
	}

	public Long getSettlementNo() {
		return settlementNo;
	}

	public void setSettlementNo(Long settlementNo) {
		this.settlementNo = settlementNo;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getOrderItemMetaId() {
		return orderItemMetaId;
	}

	public void setOrderItemMetaId(Long orderItemMetaId) {
		this.orderItemMetaId = orderItemMetaId;
	}

	public Long getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Long productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getBelongBU() {
		return belongBU;
	}

	public void setBelongBU(String belongBU) {
		this.belongBU = belongBU;
	}

	public Long getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Long serialNo) {
		this.serialNo = serialNo;
	}

	@Override
	public String toString() {
		return "FlightOrderSettlementDto [orderId=" + orderId + ", settlementNo=" + settlementNo + ", serialNo=" + serialNo + ", orderStatus=" + orderStatus + ", orderPaymentTime=" + orderPaymentTime
				+ ", orderCreateTime=" + orderCreateTime + ", orderPaymentStatus=" + orderPaymentStatus + ", orderContactPerson=" + orderContactPerson + ", orderRefund=" + orderRefund
				+ ", refundMemo=" + refundMemo + ", orderItemProdId=" + orderItemProdId + ", productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", settlementPrice=" + settlementPrice + ", actualSettlementPrice=" + actualSettlementPrice + ", quantity=" + quantity + ", visitTime=" + visitTime + ", settlementStatus="
				+ settlementStatus + ", totalSettlementPrice=" + totalSettlementPrice + ", status=" + status + ", settlementType=" + settlementType + ", refundedAmount=" + refundedAmount
				+ ", oughtPay=" + oughtPay + ", countSettleAmount=" + countSettleAmount + ", businessName=" + businessName + ", payedAmount=" + payedAmount + ", metaProductId=" + metaProductId
				+ ", metaProductName=" + metaProductName + ", metaBranchId=" + metaBranchId + ", metaBranchName=" + metaBranchName + ", productType=" + productType + ", supplierId=" + supplierId
				+ ", targetId=" + targetId + ", filialeName=" + filialeName + ", metaFilialeName=" + metaFilialeName + ", setsettlementPeriod=" + setsettlementPeriod + ", belongBU=" + belongBU
				+ ", orderItemMetaId=" + orderItemMetaId + ", productQuantity=" + productQuantity + "]";
	}

	//-------------------------------------


}
