package com.lvmama.lvfit.common.dto.order;

import java.io.Serializable;

import com.lvmama.lvfit.common.dto.shopping.ShoppingDetailDto;

public class FitOrderContacterDto implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -8784101262300488588L;

	/**
     * 联系人邮箱
     */
    private String email;

    /**
     * 联系人电话
     */
    private String mobile;

    /**
     * 联系人姓名
     */
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public static FitOrderContacterDto convertContacterDto(ShoppingDetailDto dto){
    	FitOrderContacterDto resultDto = new FitOrderContacterDto();
    	resultDto.setEmail(dto.getContacterEmail());
    	resultDto.setMobile(dto.getContacterMobile());
    	resultDto.setName(dto.getContacterName());
    	return resultDto;
    }
}
