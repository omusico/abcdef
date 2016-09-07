package com.lvmama.lvf.common.dto.settlement;

import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.BusinessType;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.StatementStatus;
import com.lvmama.lvf.common.dto.status.order.OrderSettlementStatus;

/**   
 * @Title: SettlementOrderDto.java 
 * @Package com.lvmama.lvf.common.dto.order.settlement 
 * @Description: 飞机票结算（适用于出票、退票、改期针对供应商做结算，如51book，携程等）
 * @author hedandan
 * @date 2015年8月21日
 */
public class SettlementOrderDto extends Entity {
	
	private static final long serialVersionUID = -8924690465814478052L;

	/**结算单号  算号生成*/
	private String settlementOrderNo;
	
	/** 特殊标示 */
	private String specFlag;
	
	/** 主单类型*/
	private BusinessType mainBusinessType;
	
	/** 主单Id */
	private String mainBusinessId;
	
	/** 主单编号 */
	private String mainBusinessNo;	

	/** 子单类型 */
	private BusinessType businessType;
	
	/** 子单Id */
	private String businessId;
	
	/** 子单编号 */
	private String businessNo;	
	
	/** 业务单据状态--主订单状态：正常、取消、完成(NORMAL,CANCEL，DONE(转成FINISHED))*/
	private String businessStatus;
	
	/** 业务单据支付状态 */
	private String businessPayStatus;

	/** 业务单据支付时间*/
	private Date businessPayTime;
	
	/** 业务单据创建时间*/
	private Date businessCreateTime;			
	
	/** 业务单据联系人*/
	private String businessContacter;		
	
	/** 销售产品名称--出发城市-到达城市-出发时间-航班-舱位代码-人数*/
	private String businessDesc;	
	
	/** 销售单价-给结算中心的结算价*/
	private BigDecimal salesPrice;				
	
	/** 结算单价--给结算中心的结算价*/
	private BigDecimal settlePrice;			
	
	/** 实际结算单价--出票后的实际结算价*/
	private BigDecimal to3rdSettlePrice;		

	/** 订购数量--按人数*/
	private Long businessSize;				
	
	/** 使用时间*/
	private Date usedTime;					
	
	/** 状态， 默认：NORMAL,退款：NOSETTLEMENT,取消订单：CANCEL*/
	private StatementStatus statementStatus;		
	
	/** 业务单据有退款*/
	private Boolean isRefund;		
	
	/** 订单的退款备注*/
	private String refundRemark;
	
	/** 订单退款金额--退款差额*/
	private BigDecimal refundedAmount;
	
	/** 结算总价--结算单价x人数-应该付给供应商的价格*/
	private BigDecimal to3rdSettleAmount;		
	
	/** 订单应付总额--用户实际支付金额*/
	private BigDecimal totalPayedAmount;					
	
	/** 实际结算价总金额-实际付给供应商的价格*/
	private BigDecimal to3rdActualSettleAmount;	
	
	/** 订单实付打款金额(实际结算价总金额)*/
	private BigDecimal payedAmount;
	
	/** BU事业部*/
	private String belongBU;
	
	/** 结算周期*/
	private String settlePeriod;
	
	/** 供应商*/
	private String suppCode;
	
	/** 结算状态*/
	private OrderSettlementStatus orderSettlementStatus;
	
	/** 退款单号*/
	private String refundNo;

	public String getSettlementOrderNo() {
		return settlementOrderNo;
	}

	public void setSettlementOrderNo(String settlementOrderNo) {
		this.settlementOrderNo = settlementOrderNo;
	}

	public String getSpecFlag() {
		return specFlag;
	}

	public void setSpecFlag(String specFlag) {
		this.specFlag = specFlag;
	}

	public BusinessType getMainBusinessType() {
		return mainBusinessType;
	}

	public void setMainBusinessType(BusinessType mainBusinessType) {
		this.mainBusinessType = mainBusinessType;
	}

	public String getMainBusinessId() {
		return mainBusinessId;
	}

	public void setMainBusinessId(String mainBusinessId) {
		this.mainBusinessId = mainBusinessId;
	}

	public String getMainBusinessNo() {
		return mainBusinessNo;
	}

	public void setMainBusinessNo(String mainBusinessNo) {
		this.mainBusinessNo = mainBusinessNo;
	}

	public BusinessType getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getBusinessStatus() {
		return businessStatus;
	}

	public void setBusinessStatus(String businessStatus) {
		this.businessStatus = businessStatus;
	}

	public String getBusinessPayStatus() {
		return businessPayStatus;
	}

	public void setBusinessPayStatus(String businessPayStatus) {
		this.businessPayStatus = businessPayStatus;
	}

	public Date getBusinessPayTime() {
		return businessPayTime;
	}

	public void setBusinessPayTime(Date businessPayTime) {
		this.businessPayTime = businessPayTime;
	}

	public Date getBusinessCreateTime() {
		return businessCreateTime;
	}

	public void setBusinessCreateTime(Date businessCreateTime) {
		this.businessCreateTime = businessCreateTime;
	}

	public String getBusinessContacter() {
		return businessContacter;
	}

	public void setBusinessContacter(String businessContacter) {
		this.businessContacter = businessContacter;
	}

	public Boolean getIsRefund() {
		return isRefund;
	}

	public void setIsRefund(Boolean isRefund) {
		this.isRefund = isRefund;
	}

	public String getRefundRemark() {
		return refundRemark;
	}

	public void setRefundRemark(String refundRemark) {
		this.refundRemark = refundRemark;
	}

	public String getBusinessDesc() {
		return businessDesc;
	}

	public void setBusinessDesc(String businessDesc) {
		this.businessDesc = businessDesc;
	}

	public BigDecimal getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(BigDecimal salesPrice) {
		this.salesPrice = salesPrice;
	}

	public BigDecimal getSettlePrice() {
		return settlePrice;
	}

	public void setSettlePrice(BigDecimal settlePrice) {
		this.settlePrice = settlePrice;
	}

	public BigDecimal getTo3rdSettlePrice() {
		return to3rdSettlePrice;
	}

	public void setTo3rdSettlePrice(BigDecimal to3rdSettlePrice) {
		this.to3rdSettlePrice = to3rdSettlePrice;
	}

	public Long getBusinessSize() {
		return businessSize;
	}

	public void setBusinessSize(Long businessSize) {
		this.businessSize = businessSize;
	}

	public Date getUsedTime() {
		return usedTime;
	}

	public void setUsedTime(Date usedTime) {
		this.usedTime = usedTime;
	}

	public StatementStatus getStatementStatus() {
		return statementStatus;
	}

	public void setStatementStatus(StatementStatus statementStatus) {
		this.statementStatus = statementStatus;
	}

	public BigDecimal getRefundedAmount() {
		return refundedAmount;
	}

	public void setRefundedAmount(BigDecimal refundedAmount) {
		this.refundedAmount = refundedAmount;
	}

	public BigDecimal getTo3rdSettleAmount() {
		return to3rdSettleAmount;
	}

	public void setTo3rdSettleAmount(BigDecimal to3rdSettleAmount) {
		this.to3rdSettleAmount = to3rdSettleAmount;
	}

	public BigDecimal getTotalPayedAmount() {
		return totalPayedAmount;
	}

	public void setTotalPayedAmount(BigDecimal totalPayedAmount) {
		this.totalPayedAmount = totalPayedAmount;
	}

	public BigDecimal getTo3rdActualSettleAmount() {
		return to3rdActualSettleAmount;
	}

	public void setTo3rdActualSettleAmount(BigDecimal to3rdActualSettleAmount) {
		this.to3rdActualSettleAmount = to3rdActualSettleAmount;
	}

	public BigDecimal getPayedAmount() {
		return payedAmount;
	}

	public void setPayedAmount(BigDecimal payedAmount) {
		this.payedAmount = payedAmount;
	}

	public String getBelongBU() {
		return belongBU;
	}

	public void setBelongBU(String belongBU) {
		this.belongBU = belongBU;
	}

	public String getSettlePeriod() {
		return settlePeriod;
	}

	public void setSettlePeriod(String settlePeriod) {
		this.settlePeriod = settlePeriod;
	}

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	public OrderSettlementStatus getOrderSettlementStatus() {
		return orderSettlementStatus;
	}

	public void setOrderSettlementStatus(OrderSettlementStatus orderSettlementStatus) {
		this.orderSettlementStatus = orderSettlementStatus;
	}

	public String getRefundNo() {
		return refundNo;
	}

	public void setRefundNo(String refundNo) {
		this.refundNo = refundNo;
	}

}
