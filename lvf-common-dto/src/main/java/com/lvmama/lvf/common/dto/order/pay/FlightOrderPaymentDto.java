package com.lvmama.lvf.common.dto.order.pay;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.PaySource;
import com.lvmama.lvf.common.dto.enums.PayType;
import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.order.FlightOrderNoDto;
import com.lvmama.lvf.common.dto.request.FlightOrderPayInfoRequest;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.utils.DateUtils;

/**
 * 订单支付
 * 
 * @author majun
 * @date 2015-1-19
 */
public class FlightOrderPaymentDto extends Entity implements Serializable {

	private static final long serialVersionUID = 8394071053368282421L;

	/** 主订单主键 */
	private Long orderMainId;

	/** 子订单主键 */
	private Long orderId;

	/** 主订单和子订单关联主键 */
	private String refNo;

	/** 订单号信息 */
	private FlightOrderNoDto flightOrderNo;

	/** 支付单号 传给vst支付系统 */
	private String paymentNo;

	/** 支付流水号 */
	private String paymentSerialNumber;

	/** 支付类型 */
	private PayType payType;

	/** 支付方式类型 */
	private PaymentType paymentType;
	
	/** 支付方式原始的值，比如：ALIPAY */
	private String paymentTypeStr;

	/** 支付银行编码 */
	private String paymentBankCode;

	/** 支付金额 */
	private BigDecimal payedAmount;

	/** 支付单支付状态 */
	private ResultStatus paymentStatus;

	/**
	 * 订单回调成功失败状态
	 */
	private ResultStatus orderCallbackStatus;

	/** 支付申请时间 */
	private Date payApplyTime;

	/** 支付完成时间 */
	private Date payedTime;

	/** 支付人ID */
	private String payerId;

	/** 支付人名称 */
	private String payerName;

	/** 回调通知地址（支付成功通知、退款通知），不参与签名 */
	private String lvmamaPaymentSuccessUrl;

	/** md5安全吗 */
	private String signature;
	
	/** 支付来源 */
	private PaySource paySource;
	
	/**回调计数*/
	private Integer syncCount;
	
	
	public String getPaymentTypeStr() {
		return paymentTypeStr;
	}

	public void setPaymentTypeStr(String paymentTypeStr) {
		this.paymentTypeStr = paymentTypeStr;
	}

	@JsonIgnore
	public Integer getSyncCount() {
		return syncCount;
	}

	public void setSyncCount(Integer syncCount) {
		this.syncCount = syncCount;
	}

	public Long getOrderMainId() {
		return orderMainId;
	}

	public void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}

	public String getPaymentSerialNumber() {
		return paymentSerialNumber;
	}

	public void setPaymentSerialNumber(String paymentSerialNumber) {
		this.paymentSerialNumber = paymentSerialNumber;
	}

	public String getPaymentBankCode() {
		return paymentBankCode;
	}

	public void setPaymentBankCode(String paymentBankCode) {
		this.paymentBankCode = paymentBankCode;
	}

	public BigDecimal getPayedAmount() {
		return payedAmount;
	}

	public void setPayedAmount(BigDecimal payedAmount) {
		this.payedAmount = payedAmount;
	}

	public ResultStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(ResultStatus resultStatus) {
		this.paymentStatus = resultStatus;
	}

	public Date getPayApplyTime() {
		return payApplyTime;
	}

	public void setPayApplyTime(Date payApplyTime) {
		this.payApplyTime = payApplyTime;
	}

	public Date getPayedTime() {
		return payedTime;
	}

	public void setPayedTime(Date payedTime) {
		this.payedTime = payedTime;
	}

	public String getPayerId() {
		return payerId;
	}

	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	@Override
	@JsonIgnore
	public String getSequence() {
		return "S_FORD_PAYMENT_REUNFD";
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}

	public FlightOrderNoDto getFlightOrderNo() {
		return flightOrderNo;
	}

	public void setFlightOrderNo(FlightOrderNoDto flightOrderNo) {
		this.flightOrderNo = flightOrderNo;
	}

	public PayType getPayType() {
		return payType;
	}

	public void setPayType(PayType payType) {
		this.payType = payType;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public String getLvmamaPaymentSuccessUrl() {
		return lvmamaPaymentSuccessUrl;
	}

	public void setLvmamaPaymentSuccessUrl(String lvmamaPaymentSuccessUrl) {
		this.lvmamaPaymentSuccessUrl = lvmamaPaymentSuccessUrl;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public PaySource getPaySource() {
		return paySource;
	}

	public void setPaySource(PaySource paySource) {
		this.paySource = paySource;
	}
	
	public void copyFromPayDtoquest(FlightOrderPayInfoRequest request) {
	    this.setPayerId(request.getPayerId());
	    this.setPayerName(request.getPayerName());
	    this.setPaymentType(request.getPaymentType());
	    this.setPaymentTypeStr(request.getPaymentTypeStr());
		if(null!=request && request.getPaymentType()!=null){
			this.setPayType(request.getPaymentType().getPayType());
		}
		this.setPaymentBankCode(request.getPaymentBankCode());
		this.setPayApplyTime(new Date());
		this.setPaySource(request.getPaySource());
		
	}


	public ResultStatus getOrderCallbackStatus() {
		return orderCallbackStatus;
	}

	public void setOrderCallbackStatus(ResultStatus orderCallbackStatus) {
		this.orderCallbackStatus = orderCallbackStatus;
	}

	@Override
	public String toString() {
		String orderNo = null;
		//防止flightOrderNo为Null时报错
		if(flightOrderNo!=null){
			orderNo = flightOrderNo.getOrderNo();
		}
		return "FlightOrderPaymentDto [orderMainId=" + orderMainId + ", orderId=" + orderId + ", refNo=" + refNo + ", flightOrderNo=" + orderNo + ", paymentNo=" + paymentNo
				+ ", paymentSerialNumber=" + paymentSerialNumber + ", payType=" + payType + ", paymentType=" + paymentType + ", paymentBankCode=" + paymentBankCode + ", payedAmount=" + payedAmount
				+ ", paymentStatus=" + paymentStatus + ", orderCallbackStatus=" + orderCallbackStatus + ", payApplyTime=" + payApplyTime + ", payedTime=" + payedTime + ", payerId=" + payerId
				+ ", payerName=" + payerName + ", lvmamaPaymentSuccessUrl=" + lvmamaPaymentSuccessUrl + ", signature=" + signature + ", paySource=" + paySource + ", paymentTypeStr=" + paymentTypeStr+ "]";
	}
	
	/**
	 * @return
	 */
	public String buildExportInfoByCVS(){
		StringBuffer paymentBuffer = new StringBuffer();
		paymentBuffer.append("\t").append(this.getPaymentNo()).append(",");
		paymentBuffer.append("正常支付,");//支付类型
		if(this.getPaymentSerialNumber()!=null){
			paymentBuffer.append(this.getPaymentSerialNumber()).append(",");
		}else{
			paymentBuffer.append(",");
		}
		paymentBuffer.append(",");//网关流水号
		if(this.getPaymentType()!=null){
			paymentBuffer.append(this.getPaymentType().getCnName()).append(",");
		}else{
			paymentBuffer.append(",");
		}
		
		paymentBuffer.append(this.getPayedAmount()).append(",");
		if(this.getPaymentStatus()!=null){
			paymentBuffer.append(this.getPaymentStatus().getCnName()).append(",");
		}else{
			paymentBuffer.append(",");
		}
		
		if(this.getOrderCallbackStatus()!=null){
			paymentBuffer.append(this.getOrderCallbackStatus().getCnName()).append(",");
		}else{
			paymentBuffer.append(",");
		}
		if(this.getPayedTime()!=null){
			paymentBuffer.append("\t").append(DateUtils.formatCnHmDate(this.getPayedTime())).append(",");
		}else{
			paymentBuffer.append(",");
		}
		
		paymentBuffer.append(",");//对账流水号
		if(this.getFlightOrderNo()!=null){
			paymentBuffer.append("\t").append(this.getFlightOrderNo().getOrderNo()).append(",");
		}else{
			paymentBuffer.append(",");
		}
		paymentBuffer.append(",");//VST订单号
		paymentBuffer.append(",");//VST支付ID
		if(this.getCreateTime()!=null){
			paymentBuffer.append("\t").append(DateUtils.formatCnHmDate(this.getCreateTime())).append(",");
		}else{
			paymentBuffer.append(",");
		}
		return paymentBuffer.toString();
	}

	
}
