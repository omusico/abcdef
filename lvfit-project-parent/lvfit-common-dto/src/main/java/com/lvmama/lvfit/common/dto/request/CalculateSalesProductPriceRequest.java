package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

public class CalculateSalesProductPriceRequest implements Serializable {

    private static final long serialVersionUID = -2667549296077468013L;

    private BigDecimal comboPrice;
    private BigDecimal productPrice;
    private BigDecimal discountPrice;
    
    public BigDecimal getComboPrice() {
        return comboPrice;
    }
    public void setComboPrice(BigDecimal comboPrice) {
        this.comboPrice = comboPrice;
    }
    public BigDecimal getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }
    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }
}
