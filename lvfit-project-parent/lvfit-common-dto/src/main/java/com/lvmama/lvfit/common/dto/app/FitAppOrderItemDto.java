package com.lvmama.lvfit.common.dto.app;

import com.lvmama.lvfit.common.dto.order.FitSuppOrderStatusDto;

public class FitAppOrderItemDto {
	 /**
     * 子项ID
     */
    private Long orderItemId;

    /**
     * 品类ID
     */
    private Long categoryId;

    /**
     * 供应商商品ID
     */
    private Long suppGoodsId;

    /**子单状态 */
    private FitSuppOrderStatusDto suppOrderStatusDto;
    

    public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getSuppGoodsId() {
		return suppGoodsId;
	}

	public void setSuppGoodsId(Long suppGoodsId) {
		this.suppGoodsId = suppGoodsId;
	}

	public FitSuppOrderStatusDto getSuppOrderStatusDto() {
		return suppOrderStatusDto;
	}

	public void setSuppOrderStatusDto(FitSuppOrderStatusDto suppOrderStatusDto) {
		this.suppOrderStatusDto = suppOrderStatusDto;
	}


}
