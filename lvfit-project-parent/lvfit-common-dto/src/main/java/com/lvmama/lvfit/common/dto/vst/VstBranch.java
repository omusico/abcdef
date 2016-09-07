package com.lvmama.lvfit.common.dto.vst;

import java.io.Serializable;
import java.util.Map;

public class VstBranch implements Serializable{

	/**
	 * serialVersionUID:TODO.
	 * @since JDK 1.6
	 */
	private static final long serialVersionUID = -5656054222095362442L;

	private Long productId;
	
	/**
	 * 规格定义 ID
	 */
	private Long branchId;
	
	/**
	 * 规格名称
	 */
	private String branchName;
	
	/**
	 * 推荐级别
	 */
	private Long branchSeq;
	
	/**
	 *  商品 ID
	 */
	private Long productBranchId;
	
	/**
	 * 商品属性列表(这里不能直接引用vst)
	 */
	//private List<ProdProductBranchProp> productBranchPropList;
	
	/**
	 * 最大入住人
	 */
	private Long maxVisitor;
	
	/**
	 * 是否可售
	 */
	private String saleFlag;
	
	/**
	 * 规格属性值
	 */
	private Map<String,Object> PropValue;
	
	public final Long getProductId() {
		return productId;
	}

	public final void setProductId(Long productId) {
		this.productId = productId;
	}

	public final Long getBranchId() {
		return branchId;
	}

	public final void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public final String getBranchName() {
		return branchName;
	}

	public final void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public final Long getBranchSeq() {
		return branchSeq;
	}

	public final void setBranchSeq(Long branchSeq) {
		this.branchSeq = branchSeq;
	}

	public final Long getProductBranchId() {
		return productBranchId;
	}

	public final void setProductBranchId(Long productBranchId) {
		this.productBranchId = productBranchId;
	}

	public final Long getMaxVisitor() {
		return maxVisitor;
	}

	public final void setMaxVisitor(Long maxVisitor) {
		this.maxVisitor = maxVisitor;
	}

	public final String getSaleFlag() {
		return saleFlag;
	}

	public final void setSaleFlag(String saleFlag) {
		this.saleFlag = saleFlag;
	}

	public final Map<String, Object> getPropValue() {
		return PropValue;
	}

	public final void setPropValue(Map<String, Object> propValue) {
		PropValue = propValue;
	}

	

}
