package com.lvmama.lvfit.common.dto.sdp.product.request;

import java.io.Serializable;

public class FitSdpProductAdditionalInfoRequest implements Serializable {

    private static final long serialVersionUID = -8725408332758791891L;

    private Long productId;
    
    private String categoryCode;
    
    private Long managerId;
    
    private Long startDistrictId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Long getStartDistrictId() {
        return startDistrictId;
    }

    public void setStartDistrictId(Long startDistrictId) {
        this.startDistrictId = startDistrictId;
    }
}
