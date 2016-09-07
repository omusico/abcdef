package com.lvmama.lvfit.common.dto.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.enums.Paytarget;
import com.lvmama.lvfit.common.dto.enums.SuppVstOrderViewStatus;

public class FitOrderDetail implements Serializable, Dto {

    private static final long serialVersionUID = 520620421225849364L;
// -----游客信息------
    
    // 联系人信息
    private FitOrderContacterDto fitOrderContacterDto = new FitOrderContacterDto();
    // 乘客信息
    private List<FitOrderPassengerDto> fitOrderPassengers = new ArrayList<FitOrderPassengerDto>();
    
    // -----订单信息------
    
    // 订单号
    private String vstOrderMainNo;
    // 订单状态
    private SuppVstOrderViewStatus orderViewStatus;
    // 应付总价
    private BigDecimal totalAmount;
    // 下单时间
    private Date createTime;
    // 支付时间
    private Paytarget paytarget;
    // 产品名称
    private String productName;
    // 游玩日期
    private Date visitTime;
    
    // -----航班信息--------
    List<FitOrderFlightDto> flights = new ArrayList<FitOrderFlightDto>();
    // -----酒店信息--------
    List<FitOrderHotelDto> hotels = new ArrayList<FitOrderHotelDto>();
    // -----门票信息--------
    List<FitOrderSpotTicketDto> spotTickets = new ArrayList<FitOrderSpotTicketDto>();
    // -----保险信息--------
    List<FitOrderInsuranceDto> insurances = new ArrayList<FitOrderInsuranceDto>();
    
    // 票号信息
    Map<String, List<FitSuppOrderTicketInfoDto>> ticketNosMap = new HashMap<String, List<FitSuppOrderTicketInfoDto>>();
    // -----机票子单号------
    List<String> vstFlightOrderNo = new ArrayList<String>();
    
    // -----VST订单信息-----
    List<FitSuppOrderDto> suppOrders = new ArrayList<FitSuppOrderDto>();
    
    // -----航意险信息
    List<FitOrderFliInsuranceDto> flightInsuranceDtos = new ArrayList<FitOrderFliInsuranceDto>();
    
    @Override
    public Long getId() {
        // TODO Auto-generated method stub
        return null;
    }

    public FitOrderContacterDto getFitOrderContacterDto() {
        return fitOrderContacterDto;
    }

    public void setFitOrderContacterDto(FitOrderContacterDto fitOrderContacterDto) {
        this.fitOrderContacterDto = fitOrderContacterDto;
    }

    public List<FitOrderPassengerDto> getFitOrderPassengers() {
        return fitOrderPassengers;
    }

    public void setFitOrderPassengers(List<FitOrderPassengerDto> fitOrderPassengers) {
        this.fitOrderPassengers = fitOrderPassengers;
    }

    public String getVstOrderMainNo() {
        return vstOrderMainNo;
    }

    public void setVstOrderMainNo(String vstOrderMainNo) {
        this.vstOrderMainNo = vstOrderMainNo;
    }

    public SuppVstOrderViewStatus getOrderViewStatus() {
        return orderViewStatus;
    }

    public void setOrderViewStatus(SuppVstOrderViewStatus orderViewStatus) {
        this.orderViewStatus = orderViewStatus;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Paytarget getPaytarget() {
        return paytarget;
    }

    public void setPaytarget(Paytarget paytarget) {
        this.paytarget = paytarget;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public List<FitOrderFlightDto> getFlights() {
        return flights;
    }

    public void setFlights(List<FitOrderFlightDto> flights) {
        this.flights = flights;
    }

    public List<FitOrderHotelDto> getHotels() {
        return hotels;
    }

    public void setHotels(List<FitOrderHotelDto> hotels) {
        this.hotels = hotels;
    }

    public List<FitOrderSpotTicketDto> getSpotTickets() {
        return spotTickets;
    }

    public void setSpotTickets(List<FitOrderSpotTicketDto> spotTickets) {
        this.spotTickets = spotTickets;
    }

    public Map<String, List<FitSuppOrderTicketInfoDto>> getTicketNosMap() {
        return ticketNosMap;
    }

    public final List<FitOrderInsuranceDto> getInsurances() {
		return insurances;
	}

	public final void setInsurances(List<FitOrderInsuranceDto> insurances) {
		this.insurances = insurances;
	}

	public void setTicketNosMap(Map<String, List<FitSuppOrderTicketInfoDto>> ticketNosMap) {
        this.ticketNosMap = ticketNosMap;
    }

    public List<String> getVstFlightOrderNo() {
        return vstFlightOrderNo;
    }

    public void setVstFlightOrderNo(List<String> vstFlightOrderNo) {
        this.vstFlightOrderNo = vstFlightOrderNo;
    }

    public List<FitSuppOrderDto> getSuppOrders() {
        return suppOrders;
    }

    public void setSuppOrders(List<FitSuppOrderDto> suppOrders) {
        this.suppOrders = suppOrders;
    }

    public List<FitOrderFliInsuranceDto> getFlightInsuranceDtos() {
        return flightInsuranceDtos;
    }

    public void setFlightInsuranceDtos(List<FitOrderFliInsuranceDto> flightInsuranceDtos) {
        this.flightInsuranceDtos = flightInsuranceDtos;
    }
}
