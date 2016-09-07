package com.lvmama.lvf.common.dto.adapter.request.supp;



import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.adapter.request.supp.base.SuppRequest;
import com.lvmama.lvf.common.dto.enums.PayBalanceType;

/**
 * 供应商订单支付、取消、详情、退废票简单操作对象
 * @author mashengwen
 * PA1 OM2 OM3 RC2  携程支付接口
 */
@XmlRootElement
public class FlightSuppOrderSimpleOpRequest extends SuppRequest implements Serializable 
{
	private static final long serialVersionUID = -6332698232294733898L;

	/** 本平台订单号 */
	private String suppOrderLvNo;
	
	/** 供应商订单号 */
	private String suppOrderNo;
	
	private List<String> suppOrderNos;
	
	/** 供应商退票号 */
	private String suppRefundNo;
	
	/** 是否取消PNR */
	private Boolean cancelPNR;
	
	/** 支付金额 */
	private BigDecimal payAmount;
	
	/** 支付方式枚举 */
	private PayBalanceType payBalanceType;
	/****************517Na新加的**************/
	/**乘机人姓名*/
	private List<String> passengernameStrList;
	/** 需要取消的PNR */
	private String pnr;
	/**创单时取消*/
	private Boolean cancelByCreating = Boolean.FALSE;

	/** 包机切位订单 **/
	private String saleType;
	
	/** 供应商政策id**/
	private String suppPolicyNo;



	public List<String> getSuppOrderNos() {
		return suppOrderNos;
	}

	public void setSuppOrderNos(List<String> suppOrderNos) {
		this.suppOrderNos = suppOrderNos;
	}

	public String getSuppOrderLvNo() {
		return suppOrderLvNo;
	}

	public void setSuppOrderLvNo(String suppOrderLvNo) {
		this.suppOrderLvNo = suppOrderLvNo;
	}

	public String getSuppOrderNo() {
		return suppOrderNo;
	}

	public void setSuppOrderNo(String suppOrderNo) {
		this.suppOrderNo = suppOrderNo;
	}

	public String getSuppRefundNo() {
		return suppRefundNo;
	}

	public void setSuppRefundNo(String suppRefundNo) {
		this.suppRefundNo = suppRefundNo;
	}

	public Boolean getCancelPNR() {
		return cancelPNR;
	}

	public void setCancelPNR(Boolean cancelPNR) {
		this.cancelPNR = cancelPNR;
	}

	public PayBalanceType getPayBalanceType() {
		return payBalanceType;
	}

	public void setPayBalanceType(PayBalanceType payBalanceType) {
		this.payBalanceType = payBalanceType;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public List<String> getPassengernameStrList() {
		return passengernameStrList;
	}

	public void setPassengernameStrList(List<String> passengernameStrList) {
		this.passengernameStrList = passengernameStrList;
	}
	
	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	
	public Boolean isCancelByCreating() {
		return cancelByCreating;
	}

	public void setCancelByCreating(Boolean cancelByCreating) {
		this.cancelByCreating = cancelByCreating;
	}

	public String getSaleType() {
		return saleType;
	}

	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}

	public String getSuppPolicyNo() {
		return suppPolicyNo;
	}

	public void setSuppPolicyNo(String suppPolicyNo) {
		this.suppPolicyNo = suppPolicyNo;
	}
}