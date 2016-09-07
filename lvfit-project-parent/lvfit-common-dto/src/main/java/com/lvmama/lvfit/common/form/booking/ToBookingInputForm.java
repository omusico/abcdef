package com.lvmama.lvfit.common.form.booking;

import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.order.*;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;

import java.util.List;

/**
 *  跳转到订单填写页 输入参数
 * @author qihuisong
 * @date:2015年12月16日 下午2:00:46
 */
public class ToBookingInputForm implements Form{

	private FitOrderBookingRequest fitOrderBookingRequest = new FitOrderBookingRequest();
	/** 预定 订单UUID */
	private String shopingUUID;
	/**  用户ID	 */
	private String userId;
	//成人数
	private int adultsCount;
	//儿童数
	private int childCount;
	
	public String getShopingUUID() {
		return shopingUUID;
	}
	public void setShopingUUID(String shopingUUID) {
		this.shopingUUID = shopingUUID;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getAdultsCount() {
		return adultsCount;
	}
	public void setAdultsCount(int adultsCount) {
		this.adultsCount = adultsCount;
	}
	public int getChildCount() {
		return childCount;
	}
	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}
	

	/*public FitOrderBookingRequest getFitOrderBookingRequest() {
		return fitOrderBookingRequest;
	}

	public void setFitOrderBookingRequest(FitOrderBookingRequest fitOrderBookingRequest) {
		this.fitOrderBookingRequest = fitOrderBookingRequest;
	}

	public String getVisitTime() {
		return fitOrderBookingRequest.getVisitTime();
	}

	public void setFitOrderOperDto(FitOrderOperDto fitOrderOperDto) {
		fitOrderBookingRequest.setFitOrderOperDto(fitOrderOperDto);
	}

	public void setFitOrderRemarkDtos(List<FitOrderRemarkDto> fitOrderRemarkDtos) {
		fitOrderBookingRequest.setFitOrderRemarkDtos(fitOrderRemarkDtos);
	}

	public FitOrderExpressDto getFitOrderExpressDto() {
		return fitOrderBookingRequest.getFitOrderExpressDto();
	}

	public void setBookingSource(BookingSource bookingSource) {
		fitOrderBookingRequest.setBookingSource(bookingSource);
	}

	public void setFitOrderExpressDto(FitOrderExpressDto fitOrderExpressDto) {
		fitOrderBookingRequest.setFitOrderExpressDto(fitOrderExpressDto);
	}

	public FitOrderOperDto getFitOrderOperDto() {
		return fitOrderBookingRequest.getFitOrderOperDto();
	}

	public void setFitOrderCustomerDto(FitOrderCustomerDto fitOrderCustomerDto) {
		fitOrderBookingRequest.setFitOrderCustomerDto(fitOrderCustomerDto);
	}

	public FitOrderAmountDto getFitOrderAmountDto() {
		return fitOrderBookingRequest.getFitOrderAmountDto();
	}

	public void setFitOrderPassengerDtos(List<FitOrderPassengerDto> fitOrderPassengerDtos) {
		fitOrderBookingRequest.setFitOrderPassengerDtos(fitOrderPassengerDtos);
	}

	public BookingSource getBookingSource() {
		return fitOrderBookingRequest.getBookingSource();
	}

	public void setVisitTime(String visitTime) {
		fitOrderBookingRequest.setVisitTime(visitTime);
	}

	public FitOrderContacterDto getFitOrderContacterDto() {
		return fitOrderBookingRequest.getFitOrderContacterDto();
	}

	public FitOrderCustomerDto getFitOrderCustomerDto() {
		return fitOrderBookingRequest.getFitOrderCustomerDto();
	}

	public List<FitOrderPassengerDto> getFitOrderPassengerDtos() {
		return fitOrderBookingRequest.getFitOrderPassengerDtos();
	}

	public void setFitOrderContacterDto(FitOrderContacterDto fitOrderContacterDto) {
		fitOrderBookingRequest.setFitOrderContacterDto(fitOrderContacterDto);
	}

	public void setFitOrderAmountDto(FitOrderAmountDto fitOrderAmountDto) {
		fitOrderBookingRequest.setFitOrderAmountDto(fitOrderAmountDto);
	}

	public List<FitOrderRemarkDto> getFitOrderRemarkDtos() {
		return fitOrderBookingRequest.getFitOrderRemarkDtos();
	}*/
}
