package com.lvmama.lvfit.common.dto.order;

import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.PassengerType;
import com.lvmama.lvfit.common.dto.status.order.OrderBookingStatus;

/**
 *  后台订单查询结果集
 * @author wanghuihui
 * @date:2016年1月6日 上午11:33:31
 */
public class FitOrderQueryListDto  extends Entity{
	private static final long serialVersionUID = -4842341566960811989L;
	/**  订单信息 start  **/
	private Long orderMainId;
	private Long detailCount;
	private BigDecimal orderTotalAmount;
	/**  订单信息 end **/
	private Long categoryId;
    private String bookingSource;
    private Long vstMainOrderNo;
    private Long mainId;
    private String mainOrderNo;
    private String vstOrderNo;  //vst子单号
    private String contactName;
    private String orderNo;
    private String departureDate;
    private String allStatus;
    private String belongDept;
    private String payType;
    private String createDate;
    private String productName;
    private Long adultQuantity;
    private Long childQuantity;
    private String flightInfo;
    /** 机票订单预订状态 */
	private OrderBookingStatus orderBookingStatus;
	/** 机票订单预订状态 */
	private FlightTripType tripType;
	/** 机票订单预订状态 */
	private PassengerType passengerType;
    /**  机票快照信息  **/
    private FitOrderFlightDto fitOrderFlightDto = new FitOrderFlightDto();
    /** 酒店快照信息  用于：导出 **/
    private FitOrderHotelDto fitOrderHotelDto = new FitOrderHotelDto();
    /**  供应商主单状态相关信息 **/
    private FitSuppMainOrderStatusDto fitSuppMainOrderStatusDto = new FitSuppMainOrderStatusDto();
    		
	public final Long getOrderMainId() {
		return orderMainId;
	}
	public final void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}
	public final Long getDetailCount() {
		return detailCount;
	}
	public final void setDetailCount(Long detailCount) {
		this.detailCount = detailCount;
	}
	public final FitOrderFlightDto getFitOrderFlightDto() {
		return fitOrderFlightDto;
	}
	public final void setFitOrderFlightDto(FitOrderFlightDto fitOrderFlightDto) {
		this.fitOrderFlightDto = fitOrderFlightDto;
	}
	public final FitOrderHotelDto getFitOrderHotelDto() {
		return fitOrderHotelDto;
	}
	public final void setFitOrderHotelDto(FitOrderHotelDto fitOrderHotelDto) {
		this.fitOrderHotelDto = fitOrderHotelDto;
	}
	public final String getBookingSource() {
		return bookingSource;
	}
	public final void setBookingSource(String bookingSource) {
		this.bookingSource = bookingSource;
	}
	public final Long getVstMainOrderNo() {
		return vstMainOrderNo;
	}
	public final void setVstMainOrderNo(Long vstMainOrderNo) {
		this.vstMainOrderNo = vstMainOrderNo;
	}
	public final Long getMainId() {
		return mainId;
	}
	public final void setMainId(Long mainId) {
		this.mainId = mainId;
	}
	public final String getMainOrderNo() {
		return mainOrderNo;
	}
	public final void setMainOrderNo(String mainOrderNo) {
		this.mainOrderNo = mainOrderNo;
	}
	public final String getVstOrderNo() {
		return vstOrderNo;
	}
	public final void setVstOrderNo(String vstOrderNo) {
		this.vstOrderNo = vstOrderNo;
	}
	public final String getContactName() {
		return contactName;
	}
	public final void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public final String getOrderNo() {
		return orderNo;
	}
	public final void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public final String getDepartureDate() {
		return departureDate;
	}
	public final void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public final Long getAdultQuantity() {
		return adultQuantity;
	}
	public final void setAdultQuantity(Long adultQuantity) {
		this.adultQuantity = adultQuantity;
	}
	public final Long getChildQuantity() {
		return childQuantity;
	}
	public final FitSuppMainOrderStatusDto getFitSuppMainOrderStatusDto() {
		return fitSuppMainOrderStatusDto;
	}
	public final void setFitSuppMainOrderStatusDto(
			FitSuppMainOrderStatusDto fitSuppMainOrderStatusDto) {
		this.fitSuppMainOrderStatusDto = fitSuppMainOrderStatusDto;
	}
	public final void setChildQuantity(Long childQuantity) {
		this.childQuantity = childQuantity;
	}
	public final String getAllStatus() {
		return allStatus;
	}
	public final void setAllStatus(String allStatus) {
		this.allStatus = allStatus;
	}
	public final String getProductName() {
		return productName;
	}
	public final void setProductName(String productName) {
		this.productName = productName;
	}
	public final String getBelongDept() {
		return belongDept;
	}
	public final void setBelongDept(String belongDept) {
		this.belongDept = belongDept;
	}
	public final String getPayType() {
		return payType;
	}
	public final void setPayType(String payType) {
		this.payType = payType;
	}
	public final String getCreateDate() {
		return createDate;
	}
	public final void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public final BigDecimal getOrderTotalAmount() {
		return orderTotalAmount;
	}
	public final void setOrderTotalAmount(BigDecimal orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}
	public final String getFlightInfo() {
		return flightInfo;
	}
	public final void setFlightInfo(String flightInfo) {
		this.flightInfo = flightInfo;
	}
	public final OrderBookingStatus getOrderBookingStatus() {
		return orderBookingStatus;
	}
	public final void setOrderBookingStatus(OrderBookingStatus orderBookingStatus) {
		this.orderBookingStatus = orderBookingStatus;
	}
	public final FlightTripType getTripType() {
		return tripType;
	}
	public final void setTripType(FlightTripType tripType) {
		this.tripType = tripType;
	}
	public final PassengerType getPassengerType() {
		return passengerType;
	}
	public final void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
}
