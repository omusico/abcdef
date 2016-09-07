package com.lvmama.lvfit.common.dto.calculator;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单改签金额信息
 * @author majun
 * @date   2015-4-27
 */
public class FlightOrderCTMTAmountDto implements Serializable
{
	private static final long serialVersionUID = -4753037187633916101L;
	
	/** 改签应付金额（客户）*/
	private BigDecimal ctmtPrepaidAmount = BigDecimal.ZERO;
	
	/** 改签实付金额（客户）*/
	private BigDecimal ctmtPayedAmount = BigDecimal.ZERO;
	
    /** 改签机票总结算金额(付给供应商方) */
    private BigDecimal ctmtOrderTotalSettleAmount = BigDecimal.ZERO;

	/** 改签票面差价 */
	private BigDecimal ctmtTicketDiffAmount = BigDecimal.ZERO;
	
	/** 改签优惠金额差价 */
	private BigDecimal ctmtDiscountDiffAmount = BigDecimal.ZERO;
	
	/** 改签机建费差价*/
	private BigDecimal ctmtAirportTaxDiffAmount = BigDecimal.ZERO;
	
	/** 改签燃油费差价 */
	private BigDecimal ctmtFuelTaxDiffAmount = BigDecimal.ZERO;
	
	/** 改签手续费 */
	private BigDecimal ctmtFeeAmount = BigDecimal.ZERO;
	
	/** 改签服务费 */
	private BigDecimal ctmtSurchargeAmount = BigDecimal.ZERO;

	public BigDecimal getCtmtPrepaidAmount() {
		return ctmtPrepaidAmount;
	}

	public void setCtmtPrepaidAmount(BigDecimal ctmtPrepaidAmount) {
		this.ctmtPrepaidAmount = ctmtPrepaidAmount;
	}

	public BigDecimal getCtmtPayedAmount() {
		return ctmtPayedAmount;
	}

	public void setCtmtPayedAmount(BigDecimal ctmtPayedAmount) {
		this.ctmtPayedAmount = ctmtPayedAmount;
	}

	public BigDecimal getCtmtTicketDiffAmount() {
		return ctmtTicketDiffAmount;
	}

	public void setCtmtTicketDiffAmount(BigDecimal ctmtTicketDiffAmount) {
		this.ctmtTicketDiffAmount = ctmtTicketDiffAmount;
	}

	public BigDecimal getCtmtDiscountDiffAmount() {
		return ctmtDiscountDiffAmount;
	}

	public void setCtmtDiscountDiffAmount(BigDecimal ctmtDiscountDiffAmount) {
		this.ctmtDiscountDiffAmount = ctmtDiscountDiffAmount;
	}

	public BigDecimal getCtmtAirportTaxDiffAmount() {
		return ctmtAirportTaxDiffAmount;
	}

	public void setCtmtAirportTaxDiffAmount(BigDecimal ctmtAirportTaxDiffAmount) {
		this.ctmtAirportTaxDiffAmount = ctmtAirportTaxDiffAmount;
	}

	public BigDecimal getCtmtFuelTaxDiffAmount() {
		return ctmtFuelTaxDiffAmount;
	}

	public void setCtmtFuelTaxDiffAmount(BigDecimal ctmtFuelTaxDiffAmount) {
		this.ctmtFuelTaxDiffAmount = ctmtFuelTaxDiffAmount;
	}

	public BigDecimal getCtmtFeeAmount() {
		return ctmtFeeAmount;
	}

	public void setCtmtFeeAmount(BigDecimal ctmtFeeAmount) {
		this.ctmtFeeAmount = ctmtFeeAmount;
	}

	public BigDecimal getCtmtSurchargeAmount() {
		return ctmtSurchargeAmount;
	}

	public void setCtmtSurchargeAmount(BigDecimal ctmtSurchargeAmount) {
		this.ctmtSurchargeAmount = ctmtSurchargeAmount;
	}
	

	public BigDecimal getCtmtOrderTotalSettleAmount() {
        return ctmtOrderTotalSettleAmount;
    }

    public void setCtmtOrderTotalSettleAmount(BigDecimal ctmtOrderTotalSettleAmount) {
        this.ctmtOrderTotalSettleAmount = ctmtOrderTotalSettleAmount;
    }

    @Override
    public String toString() {
        return "改签应付金额=" + ctmtPrepaidAmount + ",  改签实付金额=" + ctmtPayedAmount + ",  改签机票总结算金额="
                + ctmtOrderTotalSettleAmount + ",  改签票面差价=" + ctmtTicketDiffAmount + ", 改签优惠金额差价="
                + ctmtDiscountDiffAmount + ",  改签机建费差价=" + ctmtAirportTaxDiffAmount + ", 改签燃油费差价="
                + ctmtFuelTaxDiffAmount + ", 改签手续费=" + ctmtFeeAmount + ", 改签服务费="
                + ctmtSurchargeAmount;
    }
}
