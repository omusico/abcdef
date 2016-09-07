package com.lvmama.lvfit.common.dto.search.insurance.result;

import java.io.Serializable;

/**
 * 保险搜索相关 对象
 * @author wanghuihui
 * @date:2016年2月22日 下午6:07:47
 */
public class InsuranceSuppGoods implements Serializable {
	private static final long serialVersionUID = -6748683994513978578L;
	/** 商品组ID **/
	private Long suppGoodsId;
	/** 合同ID **/
	private Long contractId;
	/** 供应商ID **/
	private Long supplierId;
	/** 产品ID **/
	private Long productId;
	/**  产品规格ID  **/
	private Long productBranchId;
	/**   产品相关价格信息  **/
	private InsurancePriceDto insPrice;
	/** 商品名称 **/
	private String goodsName ;
	/** 商品对应的规格信息 **/
	private InsuranceProdProductBranch insuranceGoodBranch;
	/** 是否有效 **/
	private String cancelFlag;
	/** 是否可售**/
	private String onlineFlag;
	/** 最少起订量**/
	private Long minQuantity;
	/** 最大起订量**/
	private Long maxQuantity;
	
	public final Long getSuppGoodsId() {
		return suppGoodsId;
	}

	public final void setSuppGoodsId(Long suppGoodsId) {
		this.suppGoodsId = suppGoodsId;
	}

	public final Long getContractId() {
		return contractId;
	}

	public final void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public final Long getSupplierId() {
		return supplierId;
	}

	public final void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public final Long getProductId() {
		return productId;
	}

	public final void setProductId(Long productId) {
		this.productId = productId;
	}

	public final Long getProductBranchId() {
		return productBranchId;
	}

	public final void setProductBranchId(Long productBranchId) {
		this.productBranchId = productBranchId;
	}

	public final InsurancePriceDto getInsPrice() {
		return insPrice;
	}

	public final void setInsPrice(InsurancePriceDto insPrice) {
		this.insPrice = insPrice;
	}

	public final String getGoodsName() {
		return goodsName;
	}

	public final void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public final InsuranceProdProductBranch getInsuranceGoodBranch() {
		return insuranceGoodBranch;
	}

	public final void setInsuranceGoodBranch(
			InsuranceProdProductBranch insuranceGoodBranch) {
		this.insuranceGoodBranch = insuranceGoodBranch;
	}

	public String getCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	public String getOnlineFlag() {
		return onlineFlag;
	}

	public void setOnlineFlag(String onlineFlag) {
		this.onlineFlag = onlineFlag;
	}

	public Long getMinQuantity() {
		return minQuantity;
	}

	public void setMinQuantity(Long minQuantity) {
		this.minQuantity = minQuantity;
	}

	public Long getMaxQuantity() {
		return maxQuantity;
	}

	public void setMaxQuantity(Long maxQuantity) {
		this.maxQuantity = maxQuantity;
	}


	
}
