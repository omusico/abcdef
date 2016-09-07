package com.lvmama.lvfit.common.dto.app;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 国内游保险信息
 */
public class FitAppInsuranceDto implements Serializable {


    private static final long serialVersionUID = -7813765460788895788L;

    private Long productId;

    private String productType;

    private String productName;

    private Long branchId;

    private String branchName;

    private String suppGoodsId;

    private String suppGoodsName;

    private String insuranceDetail;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getSuppGoodsId() {
        return suppGoodsId;
    }

    public void setSuppGoodsId(String suppGoodsId) {
        this.suppGoodsId = suppGoodsId;
    }

    public String getSuppGoodsName() {
        return suppGoodsName;
    }

    public void setSuppGoodsName(String suppGoodsName) {
        this.suppGoodsName = suppGoodsName;
    }

    public String getInsuranceDetail() {
        return insuranceDetail;
    }

    public void setInsuranceDetail(String insuranceDetail) {
        this.insuranceDetail = insuranceDetail;
    }
}
