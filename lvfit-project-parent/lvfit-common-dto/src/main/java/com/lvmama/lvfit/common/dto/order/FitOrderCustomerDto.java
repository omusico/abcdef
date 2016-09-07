package com.lvmama.lvfit.common.dto.order;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.shopping.ShoppingDetailDto;

public class FitOrderCustomerDto extends Entity {

    private static final long serialVersionUID = -5243694013487244138L;

    /**
     * 下单用户ID
     */
    private String customerId;

    /**
     * 下单用户userNo
     */
    private String customerCode;

    /**
     * 下单时IP
     */
    private String customerIP;

    /**
     * 下单用户姓名
     */
    private String customerName;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerIP() {
        return customerIP;
    }

    public void setCustomerIP(String customerIP) {
        this.customerIP = customerIP;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public static FitOrderCustomerDto convertCustomerDto(ShoppingDetailDto dto){
    	FitOrderCustomerDto resultDto = new FitOrderCustomerDto();
    	resultDto.setCustomerId(dto.getCustomerId());
    	resultDto.setCustomerCode(dto.getCustomeNo());
    	resultDto.setCustomerName(dto.getCustomerName());
    	return resultDto;
    }
}
