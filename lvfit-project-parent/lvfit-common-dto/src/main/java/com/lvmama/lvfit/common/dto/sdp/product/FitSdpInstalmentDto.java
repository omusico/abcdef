package com.lvmama.lvfit.common.dto.sdp.product;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 分期付款DTO
 * @author lizongze
 *
 */
public class FitSdpInstalmentDto implements Serializable {

    private static final long serialVersionUID = 2008944520773010979L;
    // 银行Code
    private String bankCode;
    // 银行名称
    private String bankName;
    // 利率
    private BigDecimal interestRate;
    // 期数
    private BigDecimal term;
    // 价格
    private BigDecimal price;
    
    public String getBankCode() {
        return bankCode;
    }
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public BigDecimal getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
    public BigDecimal getTerm() {
        return term;
    }
    public void setTerm(BigDecimal term) {
        this.term = term;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
