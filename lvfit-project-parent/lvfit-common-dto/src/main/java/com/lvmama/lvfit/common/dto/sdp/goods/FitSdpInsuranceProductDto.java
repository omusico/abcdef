package com.lvmama.lvfit.common.dto.sdp.goods;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FitSdpInsuranceProductDto implements Serializable {

    private static final long serialVersionUID = -2311330623693487866L;

    // 产品ID
    private Long productId;
    // 产品名称
    private String productName;
    //保险类型
    private String productType;
    // 产品推荐级别
    private int proRecommendLvl;
    // 规格
    private List<FitSdpInsuranceDto> insBranches = new ArrayList<FitSdpInsuranceDto>();
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
    public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }
    public int getProRecommendLvl() {
        return proRecommendLvl;
    }
    public void setProRecommendLvl(int proRecommendLvl) {
        this.proRecommendLvl = proRecommendLvl;
    }
    public List<FitSdpInsuranceDto> getInsBranches() {
        return insBranches;
    }
    public void setInsBranches(List<FitSdpInsuranceDto> insBranches) {
        this.insBranches = insBranches;
    }
}
