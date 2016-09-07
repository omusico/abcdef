package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;
import com.lvmama.lvf.common.dto.order.status.FlightOrderStatusDto;
import com.lvmama.lvf.common.dto.status.OpSource;
/**
 * 
 * @author xumeng
 *
 */
@XmlRootElement
public class FlightSuppOrderQueryRequest implements Serializable, Dto {
	
	private static final long serialVersionUID = 1L;
	private FlightCommonQueryRequest flightCommonQueryRequest = new FlightCommonQueryRequest();
	/**
	 * 供应商Code
	 */
	private String suppCode;
	/**
	 * 供应商驴妈妈编号
	 */
	private String suppOrderLvNo;
	/**
	 * 供应商OfficeNo
	 */
	private String suppOfficeNo;
    /**
     * 操作源
     */
    private OpSource opSource;
	@Override
	public Long getId() {
		return null;
	}
	//供应商订单号
	public String getSuppOrderNo() {
		return flightCommonQueryRequest.getSuppOrderNo();
	}

	public void setSuppOrderNo(String suppOrderNo) {
		flightCommonQueryRequest.setSuppOrderNo(suppOrderNo);
	}
	//pnr
	public String getPnr() {
        return flightCommonQueryRequest.getPnr();
    }

    public void setPnr(String pnr) {
    	flightCommonQueryRequest.setPnr(pnr);
    }
	public String getSuppCode() {
		return suppCode;
	}
	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}
	//下单开始时间
    public String getOrderBookingQueryBegTime() {
        return flightCommonQueryRequest.getOrderBookingQueryBegTime();
    }

    public void setOrderBookingQueryBegTime(String orderBookingQueryBegTime) {
    	flightCommonQueryRequest.setOrderBookingQueryBegTime(orderBookingQueryBegTime);
    }
    //下单结束时间
    public String getOrderBookingQueryEndTime() {
    	return flightCommonQueryRequest.getOrderBookingQueryEndTime();
    }
    
    public void setOrderBookingQueryEndTime(String orderBookingQueryEndTime) {
    	flightCommonQueryRequest.setOrderBookingQueryEndTime(orderBookingQueryEndTime);
    }
    // 订单状态集合
    public FlightOrderStatusDto getFlightOrderStatus() {
        return flightCommonQueryRequest.getFlightOrderStatus();
    }
	public void setFlightOrderStatus(FlightOrderStatusDto flightOrderStatus) {
    	flightCommonQueryRequest.setFlightOrderStatus(flightOrderStatus);
    }
    public OpSource getOpSource() {
		return opSource;
	}
	public void setOpSource(OpSource opSource) {
		this.opSource = opSource;
	}
	//供应商驴妈妈编号
	public String getSuppOrderLvNo() {
		return suppOrderLvNo;
	}
	public void setSuppOrderLvNo(String suppOrderLvNo) {
		this.suppOrderLvNo = suppOrderLvNo;
	}
	//供应商OfficeNo
	public String getSuppOfficeNo() {
		return suppOfficeNo;
	}
	public void setSuppOfficeNo(String suppOfficeNo) {
		this.suppOfficeNo = suppOfficeNo;
	}
	//票号
	public String getTicketNo() {
		return flightCommonQueryRequest.getTicketNo();
	}
	
	public void setTicketNo(String ticketNo) {
		flightCommonQueryRequest.setTicketNo(ticketNo);
	}
	//支付方式
	public List<PaymentType> getPaymentType() {
		return flightCommonQueryRequest.getPaymentType();
	}
	//航班号
	public String getFlightNo() {
		return flightCommonQueryRequest.getFlightNo();
	}
	public void setFlightNo(String flightNo) {
		flightCommonQueryRequest.setFlightNo(flightNo);
	}
	public void setPaymentType(List<PaymentType> paymentType) {
		flightCommonQueryRequest.setPaymentType(paymentType);
	}
	//航空公司
	public String getCarrierName() {
		return flightCommonQueryRequest.getCarrierName();
	}
	public void setCarrierName(String carrierName) {
		flightCommonQueryRequest.setCarrierName(carrierName);
	}
	//出发城市
	public FlightCommonQueryRequest getFlightCommonQueryRequest() {
		return flightCommonQueryRequest;
	}
	//出发城市
	public String getDepartureCity() {
		return flightCommonQueryRequest.getDepartureCity();
	}
	public void setDepartureCity(String departureCity) {
		flightCommonQueryRequest.setDepartureCity(departureCity);
	}
	//到达城市
	public String getArriveCity() {
		return flightCommonQueryRequest.getArriveCity();
	}
	public void setArriveCity(String arriveCity) {
		flightCommonQueryRequest.setArriveCity(arriveCity);
	}
	public void setFlightCommonQueryRequest(
			FlightCommonQueryRequest flightCommonQueryRequest) {
		this.flightCommonQueryRequest = flightCommonQueryRequest;
	}
	//乘机开始时间
	public String getFlightQueryBegTime() {
		return flightCommonQueryRequest.getFlightQueryBegTime();
	}
	public void setFlightQueryBegTime(String flightQueryBegTime) {
		flightCommonQueryRequest.setFlightQueryBegTime(flightQueryBegTime);
	}
	//乘机结束时间
	public String getFlightQueryEndTime() {
		return flightCommonQueryRequest.getFlightQueryEndTime();
	}
	public void setFlightQueryEndTime(String flightQueryEndTime) {
		flightCommonQueryRequest.setFlightQueryEndTime(flightQueryEndTime);
	}
	//乘机人信息
	public FlightOrderPassengerDto getFlightOrderPassenger() {
		return flightCommonQueryRequest.getFlightOrderPassenger();
	}
	public void setFlightOrderPassenger(
			FlightOrderPassengerDto flightOrderPassenger) {
		flightCommonQueryRequest.setFlightOrderPassenger(flightOrderPassenger);
	}

}
