package com.lvmama.lvfit.common.dto.vst;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VstProdProductBranch implements Serializable {

	private static final long serialVersionUID = -1059608684071898688L;

	private Long productBranchId;

	private Long branchId;

	private Long productId;
     
	/**房型**/
	private String branchName;
	
	private List<VstSuppGoods> vstSuppGoods = new ArrayList<VstSuppGoods>();
	private List<VstPicProduct> picList ;
	/**
	 * 规格的所有属性,值 如果是文本内容，则：key=编码CODE,value=属性内容 <br>
	 * 如果是字典，则：key=编码CODE,value=
	 * <code>List<com.lvmama.vst.back.prod.po.PropValue></code> <br>
	 * PropValue中，id=字典值,name=字典名,addValue=附加说明
	 */
	private Map<String, Object> propValue;
	
	//房差价
	private Long gapPrice;

	private String recommendLevel;
	private String saleFlag ;
	private String cancelFlag ;
	private String maxVisitor;
	
	public Long getProductBranchId() {
		return productBranchId;
	}

	public void setProductBranchId(Long productBranchId) {
		this.productBranchId = productBranchId;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Map<String, Object> getPropValue() {
		return propValue;
	}

	public void setPropValue(Map<String, Object> propValue) {
		this.propValue = propValue;
	}

	public Long getGapPrice() {
		return gapPrice;
	}

	public void setGapPrice(Long gapPrice) {
		this.gapPrice = gapPrice;
	}

	public List<VstSuppGoods> getVstSuppGoods() {
		return vstSuppGoods;
	}

	public void setVstSuppGoods(List<VstSuppGoods> vstSuppGoods) {
		this.vstSuppGoods = vstSuppGoods;
	}

	public List<VstPicProduct> getPicList() {
		return picList;
	}

	public void setPicList(List<VstPicProduct> picList) {
		this.picList = picList;
	}

	public String getRecommendLevel() {
		return recommendLevel;
	}

	public void setRecommendLevel(String recommendLevel) {
		this.recommendLevel = recommendLevel;
	}

	public String getSaleFlag() {
		return saleFlag;
	}

	public void setSaleFlag(String saleFlag) {
		this.saleFlag = saleFlag;
	}

	public String getCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	public String getMaxVisitor() {
		return maxVisitor;
	}

	public void setMaxVisitor(String maxVisitor) {
		this.maxVisitor = maxVisitor;
	}

	
    
}
