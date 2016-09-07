package com.lvmama.lvf.common.dto.settlement;

import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.enums.StatementStatus;
import com.lvmama.lvf.common.dto.status.order.OrderBackStatus;
import com.lvmama.lvf.common.dto.status.order.OrderSettlementStatus;

public class FlightOrderSettlementDelegate {

	private FlightOrderSettlementDto flightOrderSettlementDto = new FlightOrderSettlementDto();


	public Long getId() {
		return flightOrderSettlementDto.getId();
	}

	public void setId(Long id) {
		flightOrderSettlementDto.setId(id);
	}

	public void setUuid(String uuid) {
		flightOrderSettlementDto.setUuid(uuid);
	}

	public Date getCreateTime() {
		return flightOrderSettlementDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		flightOrderSettlementDto.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return flightOrderSettlementDto.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		flightOrderSettlementDto.setUpdateTime(updateTime);
	}

	public Long getOrderId() {
		return flightOrderSettlementDto.getOrderId();
	}

	public void setOrderId(Long orderId) {
		flightOrderSettlementDto.setOrderId(orderId);
	}

	public String  getOrderStatus() {
		return flightOrderSettlementDto.getOrderStatus().getAilas();
	}

	public void setOrderStatus(OrderBackStatus orderStatus) {
		flightOrderSettlementDto.setOrderStatus(orderStatus);
	}

	public Date getOrderPaymentTime() {
		return flightOrderSettlementDto.getOrderPaymentTime();
	}

	public void setOrderPaymentTime(Date orderPaymentTime) {
		flightOrderSettlementDto.setOrderPaymentTime(orderPaymentTime);
	}

	public Date getOrderCreateTime() {
		return flightOrderSettlementDto.getOrderCreateTime();
	}

	public void setOrderCreateTime(Date orderCreateTime) {
		flightOrderSettlementDto.setOrderCreateTime(orderCreateTime);
	}

	public String getOrderPaymentStatus() {
		return flightOrderSettlementDto.getOrderPaymentStatus();
	}

	public void setOrderPaymentStatus(String orderPaymentStatus) {
		flightOrderSettlementDto.setOrderPaymentStatus(orderPaymentStatus);
	}

	public String getOrderContactPerson() {
		return flightOrderSettlementDto.getOrderContactPerson();
	}

	public void setOrderContactPerson(String orderContactPerson) {
		flightOrderSettlementDto.setOrderContactPerson(orderContactPerson);
	}

	public Integer getOrderRefund() {
		return flightOrderSettlementDto.getOrderRefund();
	}

	public void setOrderRefund(Integer orderRefund) {
		flightOrderSettlementDto.setOrderRefund(orderRefund);
	}

	public String getRefundMemo() {
		return flightOrderSettlementDto.getRefundMemo();
	}

	public void setRefundMemo(String refundMemo) {
		flightOrderSettlementDto.setRefundMemo(refundMemo);
	}

	public Long getOrderItemProdId() {
		return flightOrderSettlementDto.getOrderItemProdId();
	}

	public void setOrderItemProdId(Long orderItemProdId) {
		flightOrderSettlementDto.setOrderItemProdId(orderItemProdId);
	}

	public String getProductName() {
		return flightOrderSettlementDto.getProductName();
	}

	public void setProductName(String productName) {
		flightOrderSettlementDto.setProductName(productName);
	}

	public BigDecimal getProductPrice() {
		return flightOrderSettlementDto.getProductPrice();
	}

	public void setProductPrice(BigDecimal productPrice) {
		flightOrderSettlementDto.setProductPrice(productPrice);
	}

	public BigDecimal getSettlementPrice() {
		return flightOrderSettlementDto.getSettlementPrice();
	}

	public void setSettlementPrice(BigDecimal settlementPrice) {
		flightOrderSettlementDto.setSettlementPrice(settlementPrice);
	}

	public BigDecimal getActualSettlementPrice() {
		return flightOrderSettlementDto.getActualSettlementPrice();
	}

	public void setActualSettlementPrice(BigDecimal actualSettlementPrice) {
		flightOrderSettlementDto
				.setActualSettlementPrice(actualSettlementPrice);
	}

	public Long getQuantity() {
		return flightOrderSettlementDto.getQuantity();
	}

	public void setQuantity(Long quantity) {
		flightOrderSettlementDto.setQuantity(quantity);
	}

	public Date getVisitTime() {
		return flightOrderSettlementDto.getVisitTime();
	}

	public void setVisitTime(Date visitTime) {
		flightOrderSettlementDto.setVisitTime(visitTime);
	}

	public String getSettlementStatus() {
		return flightOrderSettlementDto.getSettlementStatus().getAilas();
	}

	public void setSettlementStatus(OrderSettlementStatus settlementStatus) {
		flightOrderSettlementDto.setSettlementStatus(settlementStatus);
	}

	public BigDecimal getTotalSettlementPrice() {
		return flightOrderSettlementDto.getTotalSettlementPrice();
	}

	public void setTotalSettlementPrice(BigDecimal totalSettlementPrice) {
		flightOrderSettlementDto.setTotalSettlementPrice(totalSettlementPrice);
	}

	public StatementStatus getStatus() {
		return flightOrderSettlementDto.getStatus();
	}

	public void setStatus(StatementStatus status) {
		flightOrderSettlementDto.setStatus(status);
	}

	public String getSettlementType() {
		return flightOrderSettlementDto.getSettlementType();
	}

	public void setSettlementType(String settlementType) {
		flightOrderSettlementDto.setSettlementType(settlementType);
	}

	public BigDecimal getRefundedAmount() {
		return flightOrderSettlementDto.getRefundedAmount();
	}

	public void setRefundedAmount(BigDecimal refundedAmount) {
		flightOrderSettlementDto.setRefundedAmount(refundedAmount);
	}

	public BigDecimal getOughtPay() {
		return flightOrderSettlementDto.getOughtPay();
	}

	public void setOughtPay(BigDecimal oughtPay) {
		flightOrderSettlementDto.setOughtPay(oughtPay);
	}

	public BigDecimal getCountSettleAmount() {
		return flightOrderSettlementDto.getCountSettleAmount();
	}

	public void setCountSettleAmount(BigDecimal countSettleAmount) {
		flightOrderSettlementDto.setCountSettleAmount(countSettleAmount);
	}

	public String getBusinessName() {
		return flightOrderSettlementDto.getBusinessName();
	}

	public void setBusinessName(String businessName) {
		flightOrderSettlementDto.setBusinessName(businessName);
	}

	public BigDecimal getPayedAmount() {
		return flightOrderSettlementDto.getPayedAmount();
	}

	public void setPayedAmount(BigDecimal payedAmount) {
		flightOrderSettlementDto.setPayedAmount(payedAmount);
	}

	public String getSetsettlementPeriod() {
		return flightOrderSettlementDto.getSetsettlementPeriod();
	}

	public void setSetsettlementPeriod(String setsettlementPeriod) {
		flightOrderSettlementDto.setSetsettlementPeriod(setsettlementPeriod);
	}

	public Long getMetaProductId() {
		return flightOrderSettlementDto.getMetaProductId();
	}

	public void setMetaProductId(Long metaProductId) {
		flightOrderSettlementDto.setMetaProductId(metaProductId);
	}

	public String getMetaProductName() {
		return flightOrderSettlementDto.getMetaProductName();
	}

	public void setMetaProductName(String metaProductName) {
		flightOrderSettlementDto.setMetaProductName(metaProductName);
	}

	public Long getMetaBranchId() {
		return flightOrderSettlementDto.getMetaBranchId();
	}

	public void setMetaBranchId(Long metaBranchId) {
		flightOrderSettlementDto.setMetaBranchId(metaBranchId);
	}

	public String getMetaBranchName() {
		return flightOrderSettlementDto.getMetaBranchName();
	}

	public void setMetaBranchName(String metaBranchName) {
		flightOrderSettlementDto.setMetaBranchName(metaBranchName);
	}

	public String getProductType() {
		return flightOrderSettlementDto.getProductType();
	}

	public void setProductType(String productType) {
		flightOrderSettlementDto.setProductType(productType);
	}

	public Long getSupplierId() {
		return flightOrderSettlementDto.getSupplierId();
	}

	public void setSupplierId(Long supplierId) {
		flightOrderSettlementDto.setSupplierId(supplierId);
	}

	public Long getTargetId() {
		return flightOrderSettlementDto.getTargetId();
	}

	public void setTargetId(Long targetId) {
		flightOrderSettlementDto.setTargetId(targetId);
	}

	public String getFilialeName() {
		return flightOrderSettlementDto.getFilialeName();
	}

	public void setFilialeName(String filialeName) {
		flightOrderSettlementDto.setFilialeName(filialeName);
	}

	public String getMetaFilialeName() {
		return flightOrderSettlementDto.getMetaFilialeName();
	}

	public void setMetaFilialeName(String metaFilialeName) {
		flightOrderSettlementDto.setMetaFilialeName(metaFilialeName);
	}

	public Long getSettlementNo() {
		return flightOrderSettlementDto.getSettlementNo();
	}

	public void setSettlementNo(Long settlementNo) {
		flightOrderSettlementDto.setSettlementNo(settlementNo);
	}

	public Long getProductId() {
		return flightOrderSettlementDto.getProductId();
	}

	public void setProductId(Long productId) {
		flightOrderSettlementDto.setProductId(productId);
	}

	public Long getOrderItemMetaId() {
		return flightOrderSettlementDto.getOrderItemMetaId();
	}

	public void setOrderItemMetaId(Long orderItemMetaId) {
		flightOrderSettlementDto.setOrderItemMetaId(orderItemMetaId);
	}

	public Long getProductQuantity() {
		return flightOrderSettlementDto.getProductQuantity();
	}

	public void setProductQuantity(Long productQuantity) {
		flightOrderSettlementDto.setProductQuantity(productQuantity);
	}

	public void setFlightOrderSettlementDto(
			FlightOrderSettlementDto flightOrderSettlementDto) {
		this.flightOrderSettlementDto = flightOrderSettlementDto;
	}

	public String getBelongBU() {
		return flightOrderSettlementDto.getBelongBU();
	}

	public void setBelongBU(String belongBU) {
		flightOrderSettlementDto.setBelongBU(belongBU);
	}
	
	
	
	
	
	
}
