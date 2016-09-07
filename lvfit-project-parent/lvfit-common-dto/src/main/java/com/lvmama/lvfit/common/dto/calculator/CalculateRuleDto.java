package com.lvmama.lvfit.common.dto.calculator;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 金额规则Dto
 * @author leizhengwei
 *
 */
public class CalculateRuleDto implements Serializable {

	private static final long serialVersionUID = -3798026599030969440L;
	
	/**销售价 */
	private BigDecimal salesPrice = BigDecimal.ZERO;
	
	/**结算价 */
	private BigDecimal settlePrice = BigDecimal.ZERO;
	
	/**操作百分比 */
	private BigDecimal operateValue = BigDecimal.ZERO;

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

	public BigDecimal getOperateValue() {
		return operateValue;
	}

	public void setOperateValue(BigDecimal operateValue) {
		this.operateValue = operateValue;
	}
	
}
