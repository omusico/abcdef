package com.lvmama.lvf.common.dto.order.pay;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author lven
 *
 */
public class FlightOrderPayAmountInfo  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1679948579551856899L;
	
	
	/** 冻结金额 */
	private BigDecimal blockAmount;
	
	/** 支付总金额 */
	private BigDecimal totalPayed;
	
	/** 实退金额 */
	private BigDecimal actualRefunded;
	
	/** 可退金额 */
	private BigDecimal returnAmount;
	
	/** 可退金额明细 */
	private String returnAmountInfo;

	public BigDecimal getReturnAmount() {
		return returnAmount;
	}

	public void setReturnAmount(BigDecimal returnAmount) {
		this.returnAmount = returnAmount;
	}

	public String getReturnAmountInfo() {
		return returnAmountInfo;
	}

	public void setReturnAmountInfo(String returnAmountInfo) {
		this.returnAmountInfo = returnAmountInfo;
	}

	public BigDecimal getBlockAmount() {
		return blockAmount;
	}

	public void setBlockAmount(BigDecimal blockAmount) {
		this.blockAmount = blockAmount;
	}

	public BigDecimal getActualRefunded() {
		return actualRefunded;
	}

	public void setActualRefunded(BigDecimal actualRefunded) {
		this.actualRefunded = actualRefunded;
	}

	public BigDecimal getTotalPayed() {
		return totalPayed;
	}

	public void setTotalPayed(BigDecimal totalPayed) {
		this.totalPayed = totalPayed;
	}


}
