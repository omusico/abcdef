package com.lvmama.lvfit.common.dto.app;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderStatusDto;

public class FitAppOrderDto implements Serializable {
	

	private static final long serialVersionUID = 2929170747575076821L;
	
	/**
     * 订单号
     */
	private Long orderId;

    private FitSuppMainOrderStatusDto mainOrderStatusDto;

    /**
     * 应付金额
     */
    private BigDecimal oughtAmount;

    /**
     * 下单时间
     */
    private Date createTime;

    /**
     * 订单子项列表
     */
    private List<FitAppOrderItemDto> orderItemList;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public FitSuppMainOrderStatusDto getMainOrderStatusDto() {
		return mainOrderStatusDto;
	}

	public void setMainOrderStatusDto(FitSuppMainOrderStatusDto mainOrderStatusDto) {
		this.mainOrderStatusDto = mainOrderStatusDto;
	}

	public BigDecimal getOughtAmount() {
		return oughtAmount;
	}

	public void setOughtAmount(BigDecimal oughtAmount) {
		this.oughtAmount = oughtAmount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<FitAppOrderItemDto> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<FitAppOrderItemDto> orderItemList) {
		this.orderItemList = orderItemList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
