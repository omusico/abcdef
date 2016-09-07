package com.lvmama.lvfit.common.dto.search.insurance.result;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class InsuranceProdProductBranch implements Serializable {
	private static final long serialVersionUID = 5869671931927653225L;
	private Long productBranchId;
	private Long branchId;
	private Long productId;
	private String branchName;
	private String cancelFlag;
	private String saleFlag;
	private Long recommendLevel;
	private Long maxVisitor;
	/**
	 * 规格的所有属性,值 如果是文本内容，则：key=编码CODE,value=属性内容 <br>
	 * 如果是字典，则：key=编码CODE,value=
	 * <code>List<com.lvmama.vst.back.prod.po.PropValue></code> <br>
	 * PropValue中，id=字典值,name=字典名,addValue=附加说明
	 */
	private Map<String, Object> propValue;
	/** 一个规格对应多个商品   **/
	private List<InsuranceSuppGoods> insuranceSuppGoodList ;
	
	public final Long getProductBranchId() {
		return productBranchId;
	}
	public final void setProductBranchId(Long productBranchId) {
		this.productBranchId = productBranchId;
	}
	public final Long getBranchId() {
		return branchId;
	}
	public final void setBranchId(Long branchId) {
		this.branchId = branchId;
	}
	public final Long getProductId() {
		return productId;
	}
	public final void setProductId(Long productId) {
		this.productId = productId;
	}
	public final String getBranchName() {
		return branchName;
	}
	public final void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public final String getCancelFlag() {
		return cancelFlag;
	}
	public final void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
	}
	public final String getSaleFlag() {
		return saleFlag;
	}
	public final void setSaleFlag(String saleFlag) {
		this.saleFlag = saleFlag;
	}
	public final Long getRecommendLevel() {
		return recommendLevel;
	}
	public final void setRecommendLevel(Long recommendLevel) {
		this.recommendLevel = recommendLevel;
	}
	public final Long getMaxVisitor() {
		return maxVisitor;
	}
	public final void setMaxVisitor(Long maxVisitor) {
		this.maxVisitor = maxVisitor;
	}
	public final Map<String, Object> getPropValue() {
		return propValue;
	}
	public final void setPropValue(Map<String, Object> propValue) {
		this.propValue = propValue;
	}
	public final List<InsuranceSuppGoods> getInsuranceSuppGoodList() {
		return insuranceSuppGoodList;
	}
	public final void setInsuranceSuppGoodList(
			List<InsuranceSuppGoods> insuranceSuppGoodList) {
		this.insuranceSuppGoodList = insuranceSuppGoodList;
	}
	
	public final String getInsuranceDesc() {
	    String s = (String)propValue.get("branch_desc");
	    return s.replace("\r\n", "<br>");
	}
	
}