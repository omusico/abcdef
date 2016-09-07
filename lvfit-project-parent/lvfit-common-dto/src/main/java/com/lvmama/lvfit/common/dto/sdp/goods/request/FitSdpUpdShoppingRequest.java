package com.lvmama.lvfit.common.dto.sdp.goods.request;

import java.io.Serializable;
import java.math.BigDecimal;

public class FitSdpUpdShoppingRequest implements Serializable {

    private static final long serialVersionUID = 6069460505646769566L;
    // 购物车ID
    private String ShoppingUuid;
    // 产品ID
    private Long suppGoodsId;
    // 商品类型
    private String productType;
    // 日期
    private String selectDate;
    // 份数
    private Long selectCount;
    // 价格
    private BigDecimal selectPrice;

    public String getShoppingUuid() {
        return ShoppingUuid;
    }

    public void setShoppingUuid(String shoppingUuid) {
        ShoppingUuid = shoppingUuid;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Long getSuppGoodsId() {
        return suppGoodsId;
    }

    public void setSuppGoodsId(Long suppGoodsId) {
        this.suppGoodsId = suppGoodsId;
    }

    public String getSelectDate() {
        return selectDate;
    }

    public void setSelectDate(String selectDate) {
        this.selectDate = selectDate;
    }

    public Long getSelectCount() {
        return selectCount;
    }

    public void setSelectCount(Long selectCount) {
        this.selectCount = selectCount;
    }

    public BigDecimal getSelectPrice() {
        return selectPrice;
    }

    public void setSelectPrice(BigDecimal selectPrice) {
        this.selectPrice = selectPrice;
    }
}
