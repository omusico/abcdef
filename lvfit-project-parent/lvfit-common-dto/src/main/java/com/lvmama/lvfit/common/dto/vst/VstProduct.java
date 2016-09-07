package com.lvmama.lvfit.common.dto.vst;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VstProduct implements Serializable{
	
	/**
	 * serialVersionUID:TODO.
	 * @since JDK 1.6
	 */
	private static final long serialVersionUID = -1855252517004946369L;
	/**
	 * 产品ID
	 * XXX 产品相关字段
	 */
	private Long productId;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 是否有效
	 */
	private String cancelFlag;
	/**
	 * 是否可售
	 */
	private String saleFlag;
	/**
	 * 推荐级别
	 */
	private Long recommendLevel;
	/**
	 * URL ID
	 */
	private String urlId;
	/**
	 * 产品规格
	 */
	private List<VstBranch> branchs;
	/**
	 *  产品属性
	 */
	private Map<String,Object> propValue;
	
	/**
	 * 产品图片详情图片列表
	 */
	private List<VstPicProduct> picProductList;
	
	/**
	 * 产品 好评率
	 */
	private VstCommentStat vstCommentStat;
	
	private List<VstProdProductBranch> productBranchList = new ArrayList<VstProdProductBranch>();

	public List<VstProdProductBranch> getProductBranchList() {
		return productBranchList;
	}

	public void setProductBranchList(List<VstProdProductBranch> productBranchList) {
		this.productBranchList = productBranchList;
	}

	public final Long getProductId() {
		return productId;
	}

	public final void setProductId(Long productId) {
		this.productId = productId;
	}

	public final String getProductName() {
		return productName;
	}

	public final void setProductName(String productName) {
		this.productName = productName;
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

	public final String getUrlId() {
		return urlId;
	}

	public final void setUrlId(String urlId) {
		this.urlId = urlId;
	}

	public final List<VstBranch> getBranchs() {
		return branchs;
	}

	public final void setBranchs(List<VstBranch> branchs) {
		this.branchs = branchs;
	}

	public final Map<String, Object> getPropValue() {
		return propValue;
	}

	public final void setPropValue(Map<String, Object> propValue) {
		this.propValue = propValue;
	}

	public final List<VstPicProduct> getPicProductList() {
		return picProductList;
	}

	public final void setPicProductList(List<VstPicProduct> picProductList) {
		this.picProductList = picProductList;
	}

	public VstCommentStat getVstCommentStat() {
		return vstCommentStat;
	}

	public void setVstCommentStat(VstCommentStat vstCommentStat) {
		this.vstCommentStat = vstCommentStat;
	}
	
}
