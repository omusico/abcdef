package com.lvmama.lvfit.common.dto.sdp.goods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

public class FitSdpOtherTicketDto implements Serializable {

    private static final long serialVersionUID = 3162992293126273591L;
    // 产品ID
    private Long productId;
    // 产品名称
    private String productName;
    // 商品ID
    private Long suppGoodsId;
    // 商品名称
    private String goodsName;
    // 商品详情
    private String branchDesc;
    // 最少数量
    private Long minQuantity; 
    // 最大数量
    private Long maxQuantity;
    // 日期价格Map
    private Map<String, BigDecimal> priceMap;
    //默认 选中的价格
    private BigDecimal defaultSelectPrice;
    
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Long getSuppGoodsId() {
        return suppGoodsId;
    }
    public void setSuppGoodsId(Long suppGoodsId) {
        this.suppGoodsId = suppGoodsId;
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
    public Map<String, BigDecimal> getPriceMap() {
        return priceMap;
    }
    public void setPriceMap(Map<String, BigDecimal> priceMap) {
        this.priceMap = priceMap;
    }
	public BigDecimal getDefaultSelectPrice() {
		return defaultSelectPrice;
	}
	public void setDefaultSelectPrice(BigDecimal defaultSelectPrice) {
		this.defaultSelectPrice = defaultSelectPrice;
	}

}
