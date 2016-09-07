package com.lvmama.lvf.common.dto.sales;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.md.PriceFormula;

/**
 * 营销调控类型
 * @author hedandan
 *
 */
public class SalesRulePriceDto extends Entity implements Serializable {

	private static final long serialVersionUID = -2333896191662239378L;

	/** 调控基准*/
	private String formulaBase;
	
	/**调控比例*/
	private PriceFormula priceFormula;
	
	/**票面价区间*/
	private String parPriceRange;

	public String getFormulaBase() {
		return formulaBase;
	}

	public void setFormulaBase(String formulaBase) {
		this.formulaBase = formulaBase;
	}

	public PriceFormula getPriceFormula() {
		return priceFormula;
	}

	public void setPriceFormula(PriceFormula priceFormula) {
		this.priceFormula = priceFormula;
	}

	public String getParPriceRange() {
		return parPriceRange;
	}

	public void setParPriceRange(String parPriceRange) {
		this.parPriceRange = parPriceRange;
	}
	
}
