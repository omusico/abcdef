package com.lvmama.lvfit.common.dto.sdp.shopping;

import java.io.Serializable;
import java.math.BigDecimal;

public class FitSdpSelectInsuranceDto implements Serializable {

    private static final long serialVersionUID = 8004079132370063601L;

    // 产品名称
    private String productName;
    // 商品ID
    private Long suppGoodsId;
    //保险类型
    private String productType;
    // 规格名称
    private String branchName;
    // 商品名称
    private String goodsName;
    // 详情
    private String branchDesc;
    // 选择的份数
    private Long selectCount;
    // 价格
    private BigDecimal price;
    
    public Long getSuppGoodsId() {
        return suppGoodsId;
    }
    public void setSuppGoodsId(Long suppGoodsId) {
        this.suppGoodsId = suppGoodsId;
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
    public Long getSelectCount() {
        return selectCount;
    }
    public void setSelectCount(Long selectCount) {
        this.selectCount = selectCount;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
