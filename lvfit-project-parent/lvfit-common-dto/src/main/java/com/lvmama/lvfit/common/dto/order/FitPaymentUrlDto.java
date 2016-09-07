package com.lvmama.lvfit.common.dto.order;

import java.io.Serializable;
import java.util.Map;

@SuppressWarnings("serial")
public class FitPaymentUrlDto implements Serializable{
	 /** 是正常支付("NORMAL") 还是 预授权"PRE"   **/
	 private String PreOrNormal ;
	 /** 审核通过时间 **/
	 private String  approveTime;
	 /** 业务类型 **/
	 private String bizType;
	 /** 对象类型(订单).  **/
	 private String objectType ; 
	 /** * 订单金额.分   必须  */ 
	 private Long orderAmountFen ;
	 /**	订单name		 */
	 private String orderName ;
	 /**	订单 id	  必须 	 */
	 private Long orderId ;
	 /**	支付金额.分	 必须 	 */
	 private Long payAmountFen ;
	 /**	支付类型(正常支付/预授权).	 */
	 private String paymentType ;
	 /**	游玩时间		 */
	 private String visitTime ;
	 /**	限制支付渠道		 */
	 private String paymentChannel ;
	 /**	订单支付 等待时间.	默认60分钟	 */
	 private String waitPayment = "60";
	 /**	是否必须预授权支付		 */
	 boolean hasNeedPrePay = false ;
	 /**	是否可以预授权支付		 */
	 boolean prepayAble = true ;
	 /**	签名		 */
	 private String signature ;
	 /**   是否可以使用礼品卡支付		 */
	 boolean isCanBoundLipinkaPay = false;
	 /**	显示赠送保险		 */
	 boolean isShowInsurant = false ;
	 /**		 * 分润账号集		 */
	private String royaltyParameters;
	/**		 * 是否可以分期支付		 */
	private boolean isCanInstalment = false;
	/**		 * 分期支付页面初始化数据Map.		 */
	private Map<String,Long> instalmentInfoMap;
	/**		 * 分期支付银行网关		 */
	private String instalmentGateway;
	/**		 * 分期支付需要的品类		 */
	private String categoryCode;
	/**		 * 分期支付需要的具体产品		 */
	private Long suppProductId;
	/**	 * 支付分期 "N" "Y"	 */
	private String instalmentFlag = "N";
	
	
	public final String getPreOrNormal() {
		return PreOrNormal;
	}
	public final void setPreOrNormal(String preOrNormal) {
		PreOrNormal = preOrNormal;
	}
	public final String getApproveTime() {
		return approveTime;
	}
	public final void setApproveTime(String approveTime) {
		this.approveTime = approveTime;
	}
	public final String getBizType() {
		return bizType;
	}
	public final void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public final String getObjectType() {
		return objectType;
	}
	public final void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	public final Long getOrderAmountFen() {
		return orderAmountFen;
	}
	public final void setOrderAmountFen(Long orderAmountFen) {
		this.orderAmountFen = orderAmountFen;
	}
	public final String getOrderName() {
		return orderName;
	}
	public final void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public final Long getOrderId() {
		return orderId;
	}
	public final void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public final Long getPayAmountFen() {
		return payAmountFen;
	}
	public final void setPayAmountFen(Long payAmountFen) {
		this.payAmountFen = payAmountFen;
	}
	public final String getPaymentType() {
		return paymentType;
	}
	public final void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public final String getVisitTime() {
		return visitTime;
	}
	public final void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}
	public final String getPaymentChannel() {
		return paymentChannel;
	}
	public final void setPaymentChannel(String paymentChannel) {
		this.paymentChannel = paymentChannel;
	}
	public final String getWaitPayment() {
		return waitPayment;
	}
	public final void setWaitPayment(String waitPayment) {
		this.waitPayment = waitPayment;
	}
	public final boolean isHasNeedPrePay() {
		return hasNeedPrePay;
	}
	public final void setHasNeedPrePay(boolean hasNeedPrePay) {
		this.hasNeedPrePay = hasNeedPrePay;
	}
	public final boolean isPrepayAble() {
		return prepayAble;
	}
	public final void setPrepayAble(boolean prepayAble) {
		this.prepayAble = prepayAble;
	}
	public final String getSignature() {
		return signature;
	}
	public final void setSignature(String signature) {
		this.signature = signature;
	}
	public final boolean isCanBoundLipinkaPay() {
		return isCanBoundLipinkaPay;
	}
	public final void setCanBoundLipinkaPay(boolean isCanBoundLipinkaPay) {
		this.isCanBoundLipinkaPay = isCanBoundLipinkaPay;
	}
	public final boolean isShowInsurant() {
		return isShowInsurant;
	}
	public final void setShowInsurant(boolean isShowInsurant) {
		this.isShowInsurant = isShowInsurant;
	}
	public final String getRoyaltyParameters() {
		return royaltyParameters;
	}
	public final void setRoyaltyParameters(String royaltyParameters) {
		this.royaltyParameters = royaltyParameters;
	}
	public final boolean isCanInstalment() {
		return isCanInstalment;
	}
	public final void setCanInstalment(boolean isCanInstalment) {
		this.isCanInstalment = isCanInstalment;
	}
	public final Map<String, Long> getInstalmentInfoMap() {
		return instalmentInfoMap;
	}
	public final void setInstalmentInfoMap(Map<String, Long> instalmentInfoMap) {
		this.instalmentInfoMap = instalmentInfoMap;
	}
	public final String getInstalmentGateway() {
		return instalmentGateway;
	}
	public final void setInstalmentGateway(String instalmentGateway) {
		this.instalmentGateway = instalmentGateway;
	}
	public final String getCategoryCode() {
		return categoryCode;
	}
	public final void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public final Long getSuppProductId() {
		return suppProductId;
	}
	public final void setSuppProductId(Long suppProductId) {
		this.suppProductId = suppProductId;
	}
	public final String getInstalmentFlag() {
		return instalmentFlag;
	}
	public final void setInstalmentFlag(String instalmentFlag) {
		this.instalmentFlag = instalmentFlag;
	}
}
