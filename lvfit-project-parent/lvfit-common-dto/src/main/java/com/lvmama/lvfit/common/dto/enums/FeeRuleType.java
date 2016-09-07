package com.lvmama.lvfit.common.dto.enums;

import java.math.BigDecimal;

import com.lvmama.lvfit.common.dto.calculator.CalculateRuleDto;

/**
 * 加价规则
 * @author leizhengwei
 *
 */
public enum FeeRuleType {

	ADD_CONSTANT_BY_SALES_PRICE("基于销售价恒定加价"){
		@Override
		public BigDecimal calculate(CalculateRuleDto calculateRuleDto) {
			return calculateRuleDto.getSalesPrice().add(calculateRuleDto.getOperateValue());
		}
	};
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	private FeeRuleType (String cnName) {
		this.cnName = cnName;
	}
	
	/**
	 * 加价规则方法
	 * @param calculateRuleDto
	 * @return
	 */
    public abstract BigDecimal calculate(CalculateRuleDto calculateRuleDto);
	
}
