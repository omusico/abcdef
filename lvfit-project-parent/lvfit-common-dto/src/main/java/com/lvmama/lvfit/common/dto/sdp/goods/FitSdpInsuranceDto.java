package com.lvmama.lvfit.common.dto.sdp.goods;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 打包产品保险信息
 * @author lizongze
 *
 */
public class FitSdpInsuranceDto implements Serializable {

    private static final long serialVersionUID = -1965667634574080501L;
    // 商品ID
    private Long suppGoodsId;
    // 产品ID
    private Long productId;
    // 产品规格ID
    private Long productBranchId;
    // 规格ID
    private Long branchId;
    // 产品名称
    private String productName;
    //保险类型
    private String productType;
    // 规格名称
    private String branchName;
    // 商品名称
    private String goodsName;
    // 详情
    private String branchDesc;
    // 最少数量
    private Long minQuantity;
    // 最大数量
    private Long maxQuantity;
    // 价格
    private BigDecimal price;
    // 产品推荐级别
    private int proRecommendLvl;
    // 商品推荐级别
    private int branchRecommendLvl;
    
	public Long getSuppGoodsId() {
		return suppGoodsId;
	}
	public void setSuppGoodsId(Long suppGoodsId) {
		this.suppGoodsId = suppGoodsId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getBranchDesc() {
		return branchDesc;
	}
	public void setBranchDesc(String branchDesc) {
		this.branchDesc = branchDesc;
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
    public int getProRecommendLvl() {
        return proRecommendLvl;
    }
    public void setProRecommendLvl(int proRecommendLvl) {
        this.proRecommendLvl = proRecommendLvl;
    }
    public int getBranchRecommendLvl() {
        return branchRecommendLvl;
    }
    public void setBranchRecommendLvl(int branchRecommendLvl) {
        this.branchRecommendLvl = branchRecommendLvl;
    }
}
