package com.lvmama.lvf.common.dto.enums;

/**
 * 订单模式类型
 * @author majun
 * @date   2015-3-16
 */
public enum Product{
	
	PACKAGE("打包","11",ProductType.PACKAGE),
	I_FLIGHT("国内机票","12",ProductType.FLIGHT),
	F_FLIGHT("国际机票","13",ProductType.FLIGHT),
	I_HOTEL("国内酒店","14",ProductType.HOTEL),
	F_HOTEL("国际酒店","15",ProductType.HOTEL),
	I_TICKET("国内门票","16",ProductType.TICKET),
	F_TICKET("国际门票","17",ProductType.TICKET),
	I_TRAIN("国内火车票","18",ProductType.TRAIN),
	F_TRAIN("国际火车票","19",ProductType.TRAIN),
	I_VISA("中国签证","20",ProductType.VISA),
	F_VISA("外国签证","21",ProductType.VISA),
	SETTLEMENT("结算","96",ProductType.SETTLEMENT),
	INSURANCE("保险","97",ProductType.INSURANCE),
	REFUND("退款","98",ProductType.REFUND),
	PAYMENT("支付","99",ProductType.PAYMENT);
	
	
	private String cnName;
	private String code;
	private ProductType productType;
	private Product(String cnName, String code, ProductType productType) {
		this.cnName = cnName;
		this.code = code;
		this.productType = productType;
	}
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

}
