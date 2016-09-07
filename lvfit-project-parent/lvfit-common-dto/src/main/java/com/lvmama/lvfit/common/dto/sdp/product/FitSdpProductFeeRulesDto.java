package com.lvmama.lvfit.common.dto.sdp.product;

import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.FeeRuleType;

public class FitSdpProductFeeRulesDto extends Entity {

	private static final long serialVersionUID = -8805145561024400018L;
	
	/**自主打包产品Id */
	private Long productId;
	
	/**费用加价规则 */
	private FeeRuleType feeRuleType;
	/**加价值*/
	private BigDecimal  oprationValue;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public FeeRuleType getFeeRuleType() {
		return feeRuleType;
	}

	public void setFeeRuleType(FeeRuleType feeRuleType) {
		this.feeRuleType = feeRuleType;
	}

	public BigDecimal getOprationValue() {
		return oprationValue;
	}

	public void setOprationValue(BigDecimal oprationValue) {
		this.oprationValue = oprationValue;
	}
	
}
