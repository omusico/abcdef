package com.lvmama.lvf.common.dto.md;

import java.io.Serializable;
import java.math.BigDecimal;

public class PriceFormula implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1458430033994327505L;

	/** 返点比率 */
	private BigDecimal scale = BigDecimal.ZERO;

	/** 返现定值 */
	private BigDecimal fixed = BigDecimal.ZERO;

	public PriceFormula() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PriceFormula(BigDecimal scale, BigDecimal fixed) {
		super();
		this.scale = scale;
		this.fixed = fixed;
	}

	public BigDecimal getScale() {
		return scale;
	}

	public void setScale(BigDecimal scale) {
		this.scale = scale;
	}

	public BigDecimal getFixed() {
		return fixed;
	}

	public void setFixed(BigDecimal fixed) {
		this.fixed = fixed;
	}

	/**
	 * 价格乘以返点加上返现<br>
	 * 
	 * @param 价格
	 * @return 结果值
	 */
	public BigDecimal calculate(BigDecimal price) {
		if ((price == null || BigDecimal.ZERO.equals(price) || null == fixed || null == scale)
				|| (BigDecimal.ZERO.equals(fixed) && BigDecimal.ZERO
						.equals(scale))) {
			return BigDecimal.ZERO;
		}
		return price.multiply(scale).add(fixed);
	}

	// public static void main(String[] args) {
	// PriceFormula t = new PriceFormula();
	// BigDecimal x = new BigDecimal("0.2");
	// BigDecimal y = new BigDecimal("56");
	// t.setFixed(y);
	// t.setScale(x);
	// BigDecimal one = new BigDecimal("1000");
	// System.out.println( t.calculate(one));
	//
	// }

}
