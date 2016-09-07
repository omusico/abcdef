package com.lvmama.lvfit.common.dto.sdp.shopping.request;

import java.io.Serializable;

import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.search.FitPassengerRequest;

public class FitSdpShoppingRequest implements Serializable{
	
	private static final long serialVersionUID = -3652828275077053108L;

	private String shoppingUUID;
	
	private Long quantity;
	
	private BookingSource bookingSource;
	
	private String productId;
	
	private String categoryId;
	
	private String lineRouteId;
	
	private String productName;

	private FitPassengerRequest fitPassengerRequest; 
	
	private String visitDate;
	
	private String depCityCode;
	
	private String arrCityCode;
	
    private Integer routeNum;

    private Integer stayNum;

	/**分销商ID */
	private Long distributionChannel;

	/**分销商代码*/
	private String distributorCode;

	public String getShoppingUUID() {
		return shoppingUUID;
	}

	public void setShoppingUUID(String shoppingUUID) {
		this.shoppingUUID = shoppingUUID;
	}
	
	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public BookingSource getBookingSource() {
		return bookingSource;
	}

	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public FitPassengerRequest getFitPassengerRequest() {
		return fitPassengerRequest;
	}

	public void setFitPassengerRequest(FitPassengerRequest fitPassengerRequest) {
		this.fitPassengerRequest = fitPassengerRequest;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	public String getDepCityCode() {
		return depCityCode;
	}

	public void setDepCityCode(String depCityCode) {
		this.depCityCode = depCityCode;
	}

	public String getArrCityCode() {
		return arrCityCode;
	}

	public void setArrCityCode(String arrCityCode) {
		this.arrCityCode = arrCityCode;
	}

	public Integer getRouteNum() {
		return routeNum;
	}

	public void setRouteNum(Integer routeNum) {
		this.routeNum = routeNum;
	}

	public Integer getStayNum() {
		return stayNum;
	}

	public void setStayNum(Integer stayNum) {
		this.stayNum = stayNum;
	}

	public String getLineRouteId() {
		return lineRouteId;
	}

	public void setLineRouteId(String lineRouteId) {
		this.lineRouteId = lineRouteId;
	}

	public Long getDistributionChannel() {
		return distributionChannel;
	}

	public void setDistributionChannel(Long distributionChannel) {
		this.distributionChannel = distributionChannel;
	}

	public String getDistributorCode() {
		return distributorCode;
	}

	public void setDistributorCode(String distributorCode) {
		this.distributorCode = distributorCode;
	}
}
