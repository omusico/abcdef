package com.lvmama.lvf.common.form.order;

import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.PaySource;
import com.lvmama.lvf.common.dto.enums.PayType;
import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.order.FlightOrderNoDto;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderPayAmountInfo;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderPaymentDto;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

/**
 * 订单支付 ResponseForm
 * 
 * @author zzs
 * 
 */
public class FlightOrderPayResponseForm implements Form {

	private FlightOrderPaymentDto flightOrderPayment = new FlightOrderPaymentDto();

	private FlightOrderPayAmountInfo flightOrderPayAmountInfo = new FlightOrderPayAmountInfo();
	
	
	private String orderNo;
	
	



	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public FlightOrderPayResponseForm() {
		super();
	}

	public FlightOrderPayResponseForm(FlightOrderPaymentDto flightOrderPayment) {
		super();
		this.flightOrderPayment = flightOrderPayment;
	}

	public PersistenceType getPtype() {
		return flightOrderPayment.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		flightOrderPayment.setPtype(ptype);
	}

	public Long getId() {
		return flightOrderPayment.getId();
	}

	public void setId(Long id) {
		flightOrderPayment.setId(id);
	}

	public String getUuid() {
		return flightOrderPayment.getUuid();
	}

	public void setUuid(String uuid) {
		flightOrderPayment.setUuid(uuid);
	}

	public String getCreateTime() {
		return DateUtils.formatCnHmDate(flightOrderPayment.getCreateTime());
	}

	public void setCreateTime(Date createTime) {
		flightOrderPayment.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return flightOrderPayment.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		flightOrderPayment.setUpdateTime(updateTime);
	}

	public Long getOrderMainId() {
		return flightOrderPayment.getOrderMainId();
	}

	public String getOrderCallbackStatus() {
		if (flightOrderPayment.getOrderCallbackStatus() != null) {
			return flightOrderPayment.getOrderCallbackStatus().getCnName();
		}
		return "";
	}

	public void setOrderCallbackStatus(ResultStatus orderCallbackStatus) {
		flightOrderPayment.setOrderCallbackStatus(orderCallbackStatus);
	}

	public void setOrderMainId(Long orderMainId) {
		flightOrderPayment.setOrderMainId(orderMainId);
	}

	public String getPaymentSerialNumber() {
		return flightOrderPayment.getPaymentSerialNumber();
	}

	public void setPaymentSerialNumber(String paymentSerialNumber) {
		flightOrderPayment.setPaymentSerialNumber(paymentSerialNumber);
	}

	public String getPaymentBankCode() {
		return flightOrderPayment.getPaymentBankCode();
	}

	public void setPaymentBankCode(String paymentBankCode) {
		flightOrderPayment.setPaymentBankCode(paymentBankCode);
	}

	public BigDecimal getPayedAmount() {
		return flightOrderPayment.getPayedAmount();
	}

	public void setPayedAmount(BigDecimal payedAmount) {
		flightOrderPayment.setPayedAmount(payedAmount);
	}

	public String getPaymentStatus() {
		if (flightOrderPayment.getPaymentStatus() != null) {
			return flightOrderPayment.getPaymentStatus().getCnName();
		}
		return "";
	}

	public void setPaymentStatus(ResultStatus resultStatus) {
		flightOrderPayment.setPaymentStatus(resultStatus);
	}

	public Date getPayApplyTime() {
		return flightOrderPayment.getPayApplyTime();
	}

	public void setPayApplyTime(Date payApplyTime) {
		flightOrderPayment.setPayApplyTime(payApplyTime);
	}

	public String getPayedTime() {
		return DateUtils.formatCnHmDate(flightOrderPayment.getPayedTime());
	}

	public void setPayedTime(Date payedTime) {
		flightOrderPayment.setPayedTime(payedTime);
	}

	public String getPayerId() {
		return flightOrderPayment.getPayerId();
	}

	public void setPayerId(String payerId) {
		flightOrderPayment.setPayerId(payerId);
	}

	public String getPayerName() {
		return flightOrderPayment.getPayerName();
	}

	public void setPayerName(String payerName) {
		flightOrderPayment.setPayerName(payerName);
	}

	public String getSequence() {
		return flightOrderPayment.getSequence();
	}

	public Long getOrderId() {
		return flightOrderPayment.getOrderId();
	}

	public void setOrderId(Long orderId) {
		flightOrderPayment.setOrderId(orderId);
	}

	public String getPaymentNo() {
		return flightOrderPayment.getPaymentNo();
	}

	public void setPaymentNo(String paymentNo) {
		flightOrderPayment.setPaymentNo(paymentNo);
	}

	public FlightOrderNoDto getFlightOrderNo() {
		return flightOrderPayment.getFlightOrderNo();
	}

	public void setFlightOrderNo(FlightOrderNoDto flightOrderNo) {
		flightOrderPayment.setFlightOrderNo(flightOrderNo);
	}

	public PayType getPayType() {
		return flightOrderPayment.getPayType();
	}

	public void setPayType(PayType payType) {
		flightOrderPayment.setPayType(payType);
	}

	public String getPaymentType() {
		if (flightOrderPayment.getPaymentType() != null) {
			return flightOrderPayment.getPaymentType().getCnName();
		}
		return "";
	}

	public void setPaymentType(PaymentType paymentType) {
		flightOrderPayment.setPaymentType(paymentType);
	}

	public FlightOrderPaymentDto getFlightOrderPayment() {
		return flightOrderPayment;
	}

	public void setFlightOrderPayment(FlightOrderPaymentDto flightOrderPayment) {
		this.flightOrderPayment = flightOrderPayment;
	}

	public PaySource getPaySource() {
		return flightOrderPayment.getPaySource();
	}

	public void setPaySource(PaySource paySource) {
		flightOrderPayment.setPaySource(paySource);
	}

	public String getRefNo() {
		return flightOrderPayment.getRefNo();
	}

	public void setRefNo(String refNo) {
		flightOrderPayment.setRefNo(refNo);
	}

	public BigDecimal getReturnAmount() {
		return flightOrderPayAmountInfo.getReturnAmount();
	}

	public void setReturnAmount(BigDecimal returnAmount) {
		flightOrderPayAmountInfo.setReturnAmount(returnAmount);
	}

	public String getReturnAmountInfo() {
		return flightOrderPayAmountInfo.getReturnAmountInfo();
	}

	public void setReturnAmountInfo(String returnAmountInfo) {
		flightOrderPayAmountInfo.setReturnAmountInfo(returnAmountInfo);
	}

	public FlightOrderPayAmountInfo getFlightOrderPayAmountInfo() {
		return flightOrderPayAmountInfo;
	}

	public void setFlightOrderPayAmountInfo(FlightOrderPayAmountInfo flightOrderPayAmountInfo) {
		this.flightOrderPayAmountInfo = flightOrderPayAmountInfo;
	}

	public BigDecimal getBlockAmount() {
		return flightOrderPayAmountInfo.getBlockAmount();
	}

	public void setBlockAmount(BigDecimal blockAmount) {
		flightOrderPayAmountInfo.setBlockAmount(blockAmount);
	}

	public BigDecimal getActualRefunded() {
		return flightOrderPayAmountInfo.getActualRefunded();
	}

	public void setActualRefunded(BigDecimal actualRefunded) {
		flightOrderPayAmountInfo.setActualRefunded(actualRefunded);
	}

	public BigDecimal getTotalPayed() {
		return flightOrderPayAmountInfo.getTotalPayed();
	}

	public void setTotalPayed(BigDecimal totalPayed) {
		flightOrderPayAmountInfo.setTotalPayed(totalPayed);
	}

	/**
	 * 1:支付来源必须是支付中心
	 * 2:支付申请状态是申请
	 * 3：订单支付回调状态是空
	 * 以上三种情况下才能进行主动抓取操作
	 * @return
	 */
	public boolean isCatchData4VST() {
		if (PaySource.PAY_CENTER == this.flightOrderPayment.getPaySource() && ResultStatus.APPLY == this.flightOrderPayment.getPaymentStatus()
				&& null == this.flightOrderPayment.getOrderCallbackStatus()) {
			return true;
		}
		return false;
	}
}
