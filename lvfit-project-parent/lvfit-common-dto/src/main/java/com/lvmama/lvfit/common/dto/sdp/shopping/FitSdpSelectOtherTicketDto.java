package com.lvmama.lvfit.common.dto.sdp.shopping;

import java.io.Serializable;
import java.math.BigDecimal;

public class FitSdpSelectOtherTicketDto implements Serializable {

    private static final long serialVersionUID = -6938463208953578960L;

    // 商品名称
    private String productName;
    // 商品ID
    private Long suppGoodsId;
    // 商品名称
    private String goodsName;
    // 商品详情
    private String branchDesc;
    // 选择的份数
    private Long selectCount;
    //选中的日期    
    private String selectDate;
    // 选中的价格
    private BigDecimal selectPrice;
    
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
    public Long getSelectCount() {
        return selectCount;
    }
    public void setSelectCount(Long selectCount) {
        this.selectCount = selectCount;
    }
    public String getSelectDate() {
        return selectDate;
    }
    public void setSelectDate(String selectDate) {
        this.selectDate = selectDate;
    }
    public BigDecimal getSelectPrice() {
        return selectPrice;
    }
    public void setSelectPrice(BigDecimal selectPrice) {
        this.selectPrice = selectPrice;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
}
