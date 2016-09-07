package com.lvmama.lvfit.common.dto.sdp.product;

import java.io.Serializable;

public class FitSdpProductPropDto implements Serializable {

    private static final long serialVersionUID = 5262216837350924563L;

    private Long prodPropId;
    
    private Long productId;
    
    private Long propId;
    
    private String propValue;

    public Long getProdPropId() {
        return prodPropId;
    }

    public void setProdPropId(Long prodPropId) {
        this.prodPropId = prodPropId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getPropId() {
        return propId;
    }

    public void setPropId(Long propId) {
        this.propId = propId;
    }

    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue;
    }
}
