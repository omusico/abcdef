package com.lvmama.lvfit.common.dto.order;

import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.Product;

public class FitOrderDto extends Entity {

	private static final long serialVersionUID = 3746116589903268908L;

	/** 主订单主键 */
	private Long orderMainId;

	/** 产品名称 */
	private Product product;

	/** 交通+X 产品快照 */
	private Long orderProductId;

	/** 订单号信息 */
	private FitOrderNoDto fitOrderNo;

	/** 订单金额信息 */
	private FitOrderAmountDto orderAmount;

	/** 订单明细数 */
	private int detailCount;

	/** 订单状态 */
	private FitOrderStatusDto orderStatus = new FitOrderStatusDto();

	/** 订单备注信息 */
	private List<FitOrderRemarkDto> orderRemarks = new ArrayList<FitOrderRemarkDto>();

	/** 订单操作日志 */
	private List<FitOrderOpLogDto> orderOpLogs = new ArrayList<FitOrderOpLogDto>();
	
	/** 供应商订单 */
	private FitSuppOrderDto suppOrderDto = new FitSuppOrderDto();
	
	private String orderKey;
	
	/** 航程类型(仅针对机票单) */
	private FlightTripType tripType; 

	public Long getOrderMainId() {
		return orderMainId;
	}

	public void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getOrderProductId() {
		return orderProductId;
	}

	public void setOrderProductId(Long orderProductId) {
		this.orderProductId = orderProductId;
	}

	public FitOrderNoDto getFitOrderNo() {
		return fitOrderNo;
	}

	public void setFitOrderNo(FitOrderNoDto fitOrderNo) {
		this.fitOrderNo = fitOrderNo;
	}

	public FitOrderAmountDto getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(FitOrderAmountDto orderAmount) {
		this.orderAmount = orderAmount;
	}

	public int getDetailCount() {
		return detailCount;
	}

	public void setDetailCount(int detailCount) {
		this.detailCount = detailCount;
	}

	public FitOrderStatusDto getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(FitOrderStatusDto orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<FitOrderRemarkDto> getOrderRemarks() {
		return orderRemarks;
	}

	public void setOrderRemarks(List<FitOrderRemarkDto> orderRemarks) {
		this.orderRemarks = orderRemarks;
	}

	public List<FitOrderOpLogDto> getOrderOpLogs() {
		return orderOpLogs;
	}

	public void setOrderOpLogs(List<FitOrderOpLogDto> orderOpLogs) {
		this.orderOpLogs = orderOpLogs;
	}

	public String getOrderKey() {
		return orderKey;
	}

	public void setOrderKey(String orderKey) {
		this.orderKey = orderKey;
	}

	public FitSuppOrderDto getSuppOrderDto() {
		return suppOrderDto;
	}

	public void setSuppOrderDto(FitSuppOrderDto suppOrderDto) {
		this.suppOrderDto = suppOrderDto;
	}

	public FlightTripType getTripType() {
		return tripType;
	}

	public void setTripType(FlightTripType tripType) {
		this.tripType = tripType;
	}
	
	@Override
	public String getSequence() {
	    return "S_FITORD_ORDER_NEW";
	}
}
