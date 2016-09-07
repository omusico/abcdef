package com.lvmama.vst.api.vo.prod;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lvmama.vst.api.route.prod.vo.ApiFlightNoVo;
import com.lvmama.vst.api.vo.ImageBaseVo;

/**
 * 产品规格
 * @author xiexun
 *
 */
public class ProductBranchBaseVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5751793568410797162L;

	/**
	 * 产品规格ID
	 */
	protected Long productBranchId;
	
	/**
	 * 品类规格ID
	 */
	protected Long branchId;

	/**
	 * 产品ID
	 */
	protected Long productId;
	/**
	 * 规格名称
	 */
	protected String branchName;
	/**
	 * 是否有效
	 */
	protected String cancelFlag;
	/**
	 * 是否可售
	 */
	protected String saleFlag;
	/**
	 * 推荐级别
	 */
	protected Long recommendLevel;
	/**
	 * 最多推荐人数
	 */
	protected Long maxVisitor;
	
	/**
	 * 产品名称
	 */
	private String productName;
	
	/**
	 * 品类ID
	 */
	private Long categoryId;
	
	/**
	 * 品类名称
	 */
	private String categoryName;

	/**
	 * 规格属性值
	 */
	protected List<ProdProductBranchPropBaseVo> productBranchPropList;
	
	/**
	 * 商品列表
	 */
	protected List<GoodsBaseVo> goodsBaseVoList;
	
	/**
	 * 推荐商品
	 */
	private List<GoodsBaseVo> recommendBaseVoList;
	
	/**
	 * 推荐机票商品
	 */
	private List<ApiFlightNoVo> apiFlightNoVoList;

	/**
	 * 规格图片
	 */
	private List<ImageBaseVo>  branchImageList;	
	
	/**
	 * 品类规格
	 */
	private BranchVo branchVo;
	
	/**
	 * 签证材料关联对象
	 */
	private ProdBranchVisadocReVo prodBranchVisadocReVo;
	
	/**
	 * 推荐商品的销售总价
	 */
	private Long dailyLowestPrice;
	 /**
     * 价格选择（酒店、当地游、门票），
     * 注：如果是附加产品，则此处 key：日期 value：价格（此处单价）
     */
    private Map<String, Long> selectPriceMap = null;
    
    /**
     * 房差价格 key 日期 value 每份价格
     */
    private Map<String, Long> selectGapPriceMap = null;
    
    /**
     * 附加次规格可选份数范围(多个时使用逗号","分隔)
     */
    private String selectQuantityRange;

    /**
     * 房差选择份数访问(多个时使用逗号","分隔)
     */
    private String selectGapQuantityRange;
    
    /**
     * 规格属性以Map方式存储
     */
    private Map<String, Object> propValue = new HashMap<String, Object>();

	public List<ProdProductBranchPropBaseVo> getProductBranchPropList() {
		return productBranchPropList;
	}

	public void setProductBranchPropList(List<ProdProductBranchPropBaseVo> productBranchPropList) {
		this.productBranchPropList = productBranchPropList;
	}

	public Long getProductBranchId() {
		return productBranchId;
	}

	public void setProductBranchId(Long productBranchId) {
		this.productBranchId = productBranchId;
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
		this.branchName = branchName == null ? null : branchName.trim();
	}

	public String getCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag == null ? null : cancelFlag.trim();
	}

	public Long getRecommendLevel() {
		return recommendLevel;
	}

	public void setRecommendLevel(Long recommendLevel) {
		this.recommendLevel = recommendLevel;
	}

	public String getSaleFlag() {
		return saleFlag;
	}

	public void setSaleFlag(String saleFlag) {
		this.saleFlag = saleFlag;
	}	

	public Long getMaxVisitor() {
		return maxVisitor;
	}

	public void setMaxVisitor(Long maxVisitor) {
		this.maxVisitor = maxVisitor;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public List<ImageBaseVo> getBranchImageList() {
		return branchImageList;
	}

	public void setBranchImageList(List<ImageBaseVo> branchImageList) {
		this.branchImageList = branchImageList;
	}

	public List<GoodsBaseVo> getGoodsBaseVoList() {
		return goodsBaseVoList;
	}

	public void setGoodsBaseVoList(List<GoodsBaseVo> goodsBaseVoList) {
		this.goodsBaseVoList = goodsBaseVoList;
	}

	public BranchVo getBranchVo() {
		return branchVo;
	}

	public void setBranchVo(BranchVo branchVo) {
		this.branchVo = branchVo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<GoodsBaseVo> getRecommendBaseVoList() {
		return recommendBaseVoList;
	}

	public void setRecommendBaseVoList(List<GoodsBaseVo> recommendBaseVoList) {
		this.recommendBaseVoList = recommendBaseVoList;
	}

	public ProdBranchVisadocReVo getProdBranchVisadocReVo() {
		return prodBranchVisadocReVo;
	}

	public void setProdBranchVisadocReVo(ProdBranchVisadocReVo prodBranchVisadocReVo) {
		this.prodBranchVisadocReVo = prodBranchVisadocReVo;
	}

	public Map<String, Long> getSelectPriceMap() {
		return selectPriceMap;
	}

	public void setSelectPriceMap(Map<String, Long> selectPriceMap) {
		this.selectPriceMap = selectPriceMap;
	}

	public Map<String, Long> getSelectGapPriceMap() {
		return selectGapPriceMap;
	}

	public void setSelectGapPriceMap(Map<String, Long> selectGapPriceMap) {
		this.selectGapPriceMap = selectGapPriceMap;
	}

	public String getSelectQuantityRange() {
		return selectQuantityRange;
	}

	public void setSelectQuantityRange(String selectQuantityRange) {
		this.selectQuantityRange = selectQuantityRange;
	}

	public Long getDailyLowestPrice() {
		return dailyLowestPrice;
	}

	public void setDailyLowestPrice(Long dailyLowestPrice) {
		this.dailyLowestPrice = dailyLowestPrice;
	}

	public String getSelectGapQuantityRange() {
		return selectGapQuantityRange;
	}

	public void setSelectGapQuantityRange(String selectGapQuantityRange) {
		this.selectGapQuantityRange = selectGapQuantityRange;
	}

	public List<ApiFlightNoVo> getApiFlightNoVoList() {
		return apiFlightNoVoList;
	}

	public void setApiFlightNoVoList(List<ApiFlightNoVo> apiFlightNoVoList) {
		this.apiFlightNoVoList = apiFlightNoVoList;
	}

	public Map<String, Object> getPropValue() {
		if(null!=propValue&&propValue.isEmpty()) {
			if(productBranchPropList != null && productBranchPropList.size() > 0) {
				for(ProdProductBranchPropBaseVo prodBranchPropVo : productBranchPropList) {
					propValue.put(prodBranchPropVo.getCode(), prodBranchPropVo.getValue());
				}
			}
		}
		return propValue;
	}

	public void setPropValue(Map<String, Object> propValue) {
		this.propValue = propValue;
	}
	
	
}
