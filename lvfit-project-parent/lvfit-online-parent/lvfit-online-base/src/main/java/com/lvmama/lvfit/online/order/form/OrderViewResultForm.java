/**
 * Project Name:lvfit-online-base
 * File Name:OrderViewResultForm.java
 * Package Name:com.lvmama.lvfit.online.order.form
 * Date:2015-12-28下午10:55:26
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.online.order.form;

import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.order.FitOrderAgreementDto;
import com.lvmama.lvfit.common.dto.order.FitOrderAmountDto;
import com.lvmama.lvfit.common.dto.order.FitOrderBasicInfoDto;
import com.lvmama.lvfit.common.dto.order.FitOrderContacterDto;
import com.lvmama.lvfit.common.dto.order.FitOrderCustomerDto;
import com.lvmama.lvfit.common.dto.order.FitOrderDto;
import com.lvmama.lvfit.common.dto.order.FitOrderExpressDto;
import com.lvmama.lvfit.common.dto.order.FitOrderFlightDto;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelDto;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.order.FitOrderNoDto;
import com.lvmama.lvfit.common.dto.order.FitOrderOpLogDto;
import com.lvmama.lvfit.common.dto.order.FitOrderPassengerDto;
import com.lvmama.lvfit.common.dto.order.FitOrderRemarkDto;
import com.lvmama.lvfit.common.dto.order.FitOrderSpotTicketDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;

/**
 * ClassName:OrderViewResultForm <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-12-28 下午10:55:26 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class OrderViewResultForm implements Form{
	
	private FitOrderMainDto orderMainDto;

	public OrderViewResultForm(FitOrderMainDto orderMainDto) {
		super();
		this.orderMainDto = orderMainDto;
	}

	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.Entity#getPtype()
	 */
	public PersistenceType getPtype() {
		return orderMainDto.getPtype();
	}

	/**
	 * @param ptype
	 * @see com.lvmama.lvf.common.dto.Entity#setPtype(com.lvmama.lvf.common.dto.PersistenceType)
	 */
	public void setPtype(PersistenceType ptype) {
		orderMainDto.setPtype(ptype);
	}

	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.Entity#getSequence()
	 */
	public String getSequence() {
		return orderMainDto.getSequence();
	}

	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.Entity#getId()
	 */
	public Long getId() {
		return orderMainDto.getId();
	}

	/**
	 * @param id
	 * @see com.lvmama.lvf.common.dto.Entity#setId(java.lang.Long)
	 */
	public void setId(Long id) {
		orderMainDto.setId(id);
	}

	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.Entity#getUuid()
	 */
	public String getUuid() {
		return orderMainDto.getUuid();
	}

	/**
	 * @param uuid
	 * @see com.lvmama.lvf.common.dto.Entity#setUuid(java.lang.String)
	 */
	public void setUuid(String uuid) {
		orderMainDto.setUuid(uuid);
	}

	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.Entity#getCreateTime()
	 */
	public Date getCreateTime() {
		return orderMainDto.getCreateTime();
	}

	/**
	 * @param createTime
	 * @see com.lvmama.lvf.common.dto.Entity#setCreateTime(java.util.Date)
	 */
	public void setCreateTime(Date createTime) {
		orderMainDto.setCreateTime(createTime);
	}

	/**
	 * @return
	 * @see com.lvmama.lvf.common.dto.Entity#getUpdateTime()
	 */
	public Date getUpdateTime() {
		return orderMainDto.getUpdateTime();
	}

	/**
	 * @param updateTime
	 * @see com.lvmama.lvf.common.dto.Entity#setUpdateTime(java.util.Date)
	 */
	public void setUpdateTime(Date updateTime) {
		orderMainDto.setUpdateTime(updateTime);
	}

	/**
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return orderMainDto.hashCode();
	}

	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#getFitOrderNo()
	 */
	public FitOrderNoDto getFitOrderNo() {
		return orderMainDto.getFitOrderNo();
	}

	/**
	 * @param fitOrderNo
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#setFitOrderNo(com.lvmama.lvfit.common.dto.order.FitOrderNoDto)
	 */
	public void setFitOrderNo(FitOrderNoDto fitOrderNo) {
		orderMainDto.setFitOrderNo(fitOrderNo);
	}

	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#getOrderAmount()
	 */
	public FitOrderAmountDto getOrderAmount() {
		return orderMainDto.getOrderAmount();
	}

	/**
	 * @param orderAmount
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#setOrderAmount(com.lvmama.lvfit.common.dto.order.FitOrderAmountDto)
	 */
	public void setOrderAmount(FitOrderAmountDto orderAmount) {
		orderMainDto.setOrderAmount(orderAmount);
	}

	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#getFitOrderCustomer()
	 */
	public FitOrderCustomerDto getFitOrderCustomer() {
		return orderMainDto.getFitOrderCustomer();
	}

	/**
	 * @param fitOrderCustomer
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#setFitOrderCustomer(com.lvmama.lvfit.common.dto.order.FitOrderCustomerDto)
	 */
	public void setFitOrderCustomer(FitOrderCustomerDto fitOrderCustomer) {
		orderMainDto.setFitOrderCustomer(fitOrderCustomer);
	}

	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#getFitOrderContacter()
	 */
	public FitOrderContacterDto getFitOrderContacter() {
		return orderMainDto.getFitOrderContacter();
	}

	/**
	 * @param fitOrderContacter
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#setFitOrderContacter(com.lvmama.lvfit.common.dto.order.FitOrderContacterDto)
	 */
	public void setFitOrderContacter(FitOrderContacterDto fitOrderContacter) {
		orderMainDto.setFitOrderContacter(fitOrderContacter);
	}

	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#getBookingSource()
	 */
	public BookingSource getBookingSource() {
		return orderMainDto.getBookingSource();
	}

	/**
	 * @param bookingSource
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#setBookingSource(com.lvmama.lvfit.common.dto.enums.BookingSource)
	 */
	public void setBookingSource(BookingSource bookingSource) {
		orderMainDto.setBookingSource(bookingSource);
	}

	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#getFitOrderAgreement()
	 */
	public FitOrderAgreementDto getFitOrderAgreement() {
		return orderMainDto.getFitOrderAgreement();
	}

	/**
	 * @param fitOrderAgreement
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#setFitOrderAgreement(com.lvmama.lvfit.common.dto.order.FitOrderAgreementDto)
	 */
	public void setFitOrderAgreement(FitOrderAgreementDto fitOrderAgreement) {
		orderMainDto.setFitOrderAgreement(fitOrderAgreement);
	}

	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#getFitOrderExpress()
	 */
	public FitOrderExpressDto getFitOrderExpress() {
		return orderMainDto.getFitOrderExpress();
	}

	/**
	 * @param fitOrderExpress
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#setFitOrderExpress(com.lvmama.lvfit.common.dto.order.FitOrderExpressDto)
	 */
	public void setFitOrderExpress(FitOrderExpressDto fitOrderExpress) {
		orderMainDto.setFitOrderExpress(fitOrderExpress);
	}

	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#getFitOrderPassengers()
	 */
	public List<FitOrderPassengerDto> getFitOrderPassengers() {
		return orderMainDto.getFitOrderPassengers();
	}

	/**
	 * @param fitOrderPassengers
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#setFitOrderPassengers(java.util.List)
	 */
	public void setFitOrderPassengers(List<FitOrderPassengerDto> fitOrderPassengers) {
		orderMainDto.setFitOrderPassengers(fitOrderPassengers);
	}

	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#getOrdeOpLogs()
	 */
	public List<FitOrderOpLogDto> getOrdeOpLogs() {
		return orderMainDto.getOrdeOpLogs();
	}

	/**
	 * @param ordeOpLogs
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#setOrdeOpLogs(java.util.List)
	 */
	public void setOrdeOpLogs(List<FitOrderOpLogDto> ordeOpLogs) {
		orderMainDto.setOrdeOpLogs(ordeOpLogs);
	}

	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#getFitOrders()
	 */
	public List<FitOrderDto> getFitOrders() {
		return orderMainDto.getFitOrders();
	}

	/**
	 * @param fitOrders
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#setFitOrders(java.util.List)
	 */
	public void setFitOrders(List<FitOrderDto> fitOrders) {
		orderMainDto.setFitOrders(fitOrders);
	}

	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#getFitOrderRemarks()
	 */
	public List<FitOrderRemarkDto> getFitOrderRemarks() {
		return orderMainDto.getFitOrderRemarks();
	}

	/**
	 * @param fitOrderRemarks
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#setFitOrderRemarks(java.util.List)
	 */
	public void setFitOrderRemarks(List<FitOrderRemarkDto> fitOrderRemarks) {
		orderMainDto.setFitOrderRemarks(fitOrderRemarks);
	}

	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#getFitOrderFlightDtos()
	 */
	public List<FitOrderFlightDto> getFitOrderFlightDtos() {
		return orderMainDto.getFitOrderFlightDtos();
	}

	/**
	 * @param fitOrderFlightDtos
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#setFitOrderFlightDtos(java.util.List)
	 */
	public void setFitOrderFlightDtos(List<FitOrderFlightDto> fitOrderFlightDtos) {
		orderMainDto.setFitOrderFlightDtos(fitOrderFlightDtos);
	}

	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#getFitOrderHotelDtos()
	 */
	public List<FitOrderHotelDto> getFitOrderHotelDtos() {
		return orderMainDto.getFitOrderHotelDtos();
	}

	/**
	 * @param fitOrderHotelDtos
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#setFitOrderHotelDtos(java.util.List)
	 */
	public void setFitOrderHotelDtos(List<FitOrderHotelDto> fitOrderHotelDtos) {
		orderMainDto.setFitOrderHotelDtos(fitOrderHotelDtos);
	}



	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#getFitSuppMainOrderDto()
	 */
	public FitSuppMainOrderDto getFitSuppMainOrderDto() {
		return orderMainDto.getFitSuppMainOrderDto();
	}

	/**
	 * @param fitSuppMainOrderDto
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#setFitSuppMainOrderDto(com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto)
	 */
	public void setFitSuppMainOrderDto(FitSuppMainOrderDto fitSuppMainOrderDto) {
		orderMainDto.setFitSuppMainOrderDto(fitSuppMainOrderDto);
	}

	/**
	 * @return
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#getProductName()
	 */
	public String getProductName() {
		return orderMainDto.getProductName();
	}

	/**
	 * @param productName
	 * @see com.lvmama.lvfit.common.dto.order.FitOrderMainDto#setProductName(java.lang.String)
	 */
	public void setProductName(String productName) {
		orderMainDto.setProductName(productName);
	}


	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return orderMainDto.toString();
	}

    public List<FitOrderSpotTicketDto> getFitOrderSpotTicketDtos() {
        return orderMainDto.getFitOrderSpotTicketDtos();
    }

    public void setFitOrderSpotTicketDtos(List<FitOrderSpotTicketDto> fitOrderSpotTicketDtos) {
        orderMainDto.setFitOrderSpotTicketDtos(fitOrderSpotTicketDtos);
    }

	public FitOrderBasicInfoDto getFitOrderBasicInfoDto() {
		return orderMainDto.getFitOrderBasicInfoDto();
	}

	public void setFitOrderBasicInfoDto(
			FitOrderBasicInfoDto fitOrderBasicInfoDto) {
		orderMainDto.setFitOrderBasicInfoDto(fitOrderBasicInfoDto);
	}
	
}

