package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.CarrierType;
import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.dto.enums.OrderType;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.enums.RouteType;
import com.lvmama.lvf.common.dto.enums.SeatClassType;

/**
 * 订单信息
 * @date 2016-03-04
 */
public class FlightOrderStaticDto extends Entity implements Serializable {
    private static final long serialVersionUID = -3470485440368662800L;
    
    /** 主订单主键 */
    private Long orderMainId;   
    private Long orderId;    
    /** 订单号 */
   	private String orderNo;
    /** 主订单号 */
	private String orderMainNo;
	
	/** 采购主单号(vst主单号) */
    private String salesMainOrderId;
    
    /** 采购子单号 */
    private String salesOrderId;
	/** 订单预订来源 */
	private BookingSource bookingSource;
	
	 /** 订单类型 */
    private OrderType orderType;
	
	/**航班号 */
	private String flightNo;	
	/** 航空公司编码 */
	private String carrierCode;
	/** 航空公司名称 */
	private String carrierName;
	/** 航空公司类型*/
	private CarrierType carrierType;
	/** 出发机场 **/
	private String depAirportCode;
	/** 出发机场 名称**/
	private String depAirportName;
	/** 到达机场 **/
	private String arrAirportCode;
	/** 到达机场名称 **/
	private String arrAirportName;
	/** 出发城市 **/
	private String depCityCode;
	/** 出发城市 名称**/
	private String depCityName;
	/** 到达城市 **/
	private String arrCityCode;
	/** 到达城市 **/
	private String arrCityName;
	/**起飞时间 **/
	private Date depTime;
	/**落地时间 **/
	private Date arrTime;
	/**舱位code**/
	private String seatClassCode;
	/**舱位类型**/
	private SeatClassType seatClassType;
	/**航班类型**/
	private RouteType routeType;
	/**航程类型**/
	private FlightTripType flightTripType;
	
	 /**舱位票面价**/
    private BigDecimal parPrice;
    
    /**Y舱票面价**/
    private BigDecimal yparPrice;
    
    /**返程相关航班信息*/
    private String returnFlightNo;
    private String returnDepAirportCode;
    private String returnDepAirportName;
    private String returnArrAirportCode;
    private String returnArrAirportName;
    private String returnDepCityCode;
    private String returnDepCityName;
    private String returnArrCityCode;
    private String returnArrCityName;
    private Date returnDepTime;
    private Date returnArrTime;
    private String returnSeatClassCode;
    private SeatClassType returnSeatClassType;
	
	
	
	/** 客户ID */
	private String customerId;	
	/** 客户编码 */
	private String customerCode;
	
	/** 客户姓名 */
	private String customerName;
	/** 客户手机号码 */
	private String customerCellphone;
	/**乘客类型 **/
	private PassengerType passengerType;
	/**乘客数量 **/
	private int passengerCount;
	
	/** 联系人姓名 */
	private String  contactName;	
	/** 手机号码 */
	private String  contactCellphone;	
	/** 电话号码 */
	private String contactTelphone;	
	/** 邮箱 */
	private String contactEmail;
	
	
	/**应收款 */
    private BigDecimal receivableAmount;
    /**订单总的票面价**/
    private BigDecimal totalParPrice;
    /**优惠金额**/
    private BigDecimal promotion;
    /**佣金**/
    private BigDecimal profit;
    /**销售价**/
    private BigDecimal salesPrice;
    /**结算价*/
    private BigDecimal settlePrice;
    /**机建**/
    private BigDecimal airportFee;
    /**燃油**/
    private BigDecimal fuelsurTax;
    
    /** 销售类型 */
	private  String saleType;
    
	public Long getOrderMainId() {
		return orderMainId;
	}



	public void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}



	public Long getOrderId() {
		return orderId;
	}



	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}



	public String getOrderNo() {
		return orderNo;
	}



	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}



	public String getOrderMainNo() {
		return orderMainNo;
	}



	public void setOrderMainNo(String orderMainNo) {
		this.orderMainNo = orderMainNo;
	}



	public String getSalesMainOrderId() {
		return salesMainOrderId;
	}



	public void setSalesMainOrderId(String salesMainOrderId) {
		this.salesMainOrderId = salesMainOrderId;
	}



	public String getSalesOrderId() {
		return salesOrderId;
	}



	public void setSalesOrderId(String salesOrderId) {
		this.salesOrderId = salesOrderId;
	}



	public BookingSource getBookingSource() {
		return bookingSource;
	}



	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}



	public OrderType getOrderType() {
		return orderType;
	}



	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}



	public String getFlightNo() {
		return flightNo;
	}



	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}



	public String getCarrierCode() {
		return carrierCode;
	}



	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}



	public String getDepAirportCode() {
		return depAirportCode;
	}



	public void setDepAirportCode(String depAirportCode) {
		this.depAirportCode = depAirportCode;
	}



	public String getArrAirportCode() {
		return arrAirportCode;
	}



	public void setArrAirportCode(String arrAirportCode) {
		this.arrAirportCode = arrAirportCode;
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

	public String getCustomerId() {
		return customerId;
	}



	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}



	public String getCustomerCode() {
		return customerCode;
	}



	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public String getCustomerCellphone() {
		return customerCellphone;
	}



	public void setCustomerCellphone(String customerCellphone) {
		this.customerCellphone = customerCellphone;
	}



	public PassengerType getPassengerType() {
		return passengerType;
	}



	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}



	public int getPassengerCount() {
		return passengerCount;
	}



	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}



	public String getContactName() {
		return contactName;
	}



	public void setContactName(String contactName) {
		this.contactName = contactName;
	}



	public String getContactCellphone() {
		return contactCellphone;
	}



	public void setContactCellphone(String contactCellphone) {
		this.contactCellphone = contactCellphone;
	}



	public String getContactTelphone() {
		return contactTelphone;
	}



	public void setContactTelphone(String contactTelphone) {
		this.contactTelphone = contactTelphone;
	}



	public String getContactEmail() {
		return contactEmail;
	}



	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}



	public BigDecimal getReceivableAmount() {
		return receivableAmount;
	}



	public void setReceivableAmount(BigDecimal receivableAmount) {
		this.receivableAmount = receivableAmount;
	}



	public BigDecimal getParPrice() {
		return parPrice;
	}



	public void setParPrice(BigDecimal parPrice) {
		this.parPrice = parPrice;
	}



	public BigDecimal getTotalParPrice() {
		return totalParPrice;
	}



	public void setTotalParPrice(BigDecimal totalParPrice) {
		this.totalParPrice = totalParPrice;
	}



	public BigDecimal getPromotion() {
		return promotion;
	}



	public void setPromotion(BigDecimal promotion) {
		this.promotion = promotion;
	}



	public BigDecimal getProfit() {
		return profit;
	}



	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}



	public BigDecimal getSalesPrice() {
		return salesPrice;
	}



	public void setSalesPrice(BigDecimal salesPrice) {
		this.salesPrice = salesPrice;
	}



	public BigDecimal getSettlePrice() {
		return settlePrice;
	}



	public void setSettlePrice(BigDecimal settlePrice) {
		this.settlePrice = settlePrice;
	}



	public BigDecimal getAirportFee() {
		return airportFee;
	}



	public void setAirportFee(BigDecimal airportFee) {
		this.airportFee = airportFee;
	}



	public BigDecimal getFuelsurTax() {
		return fuelsurTax;
	}



	public void setFuelsurTax(BigDecimal fuelsurTax) {
		this.fuelsurTax = fuelsurTax;
	}

    

	public String getCarrierName() {
		return carrierName;
	}



	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}



	public CarrierType getCarrierType() {
		return carrierType;
	}



	public void setCarrierType(CarrierType carrierType) {
		this.carrierType = carrierType;
	}



	public String getDepAirportName() {
		return depAirportName;
	}



	public void setDepAirportName(String depAirportName) {
		this.depAirportName = depAirportName;
	}



	public String getArrAirportName() {
		return arrAirportName;
	}



	public void setArrAirportName(String arrAirportName) {
		this.arrAirportName = arrAirportName;
	}



	public String getDepCityName() {
		return depCityName;
	}



	public void setDepCityName(String depCityName) {
		this.depCityName = depCityName;
	}



	public String getArrCityName() {
		return arrCityName;
	}



	public void setArrCityName(String arrCityName) {
		this.arrCityName = arrCityName;
	}



	public Date getDepTime() {
		return depTime;
	}



	public void setDepTime(Date depTime) {
		this.depTime = depTime;
	}



	public Date getArrTime() {
		return arrTime;
	}



	public void setArrTime(Date arrTime) {
		this.arrTime = arrTime;
	}



	public String getSeatClassCode() {
		return seatClassCode;
	}



	public void setSeatClassCode(String seatClassCode) {
		this.seatClassCode = seatClassCode;
	}



	public RouteType getRouteType() {
		return routeType;
	}



	public void setRouteType(RouteType routeType) {
		this.routeType = routeType;
	}



	public FlightTripType getFlightTripType() {
		return flightTripType;
	}



	public void setFlightTripType(FlightTripType flightTripType) {
		this.flightTripType = flightTripType;
	}



	public BigDecimal getYparPrice() {
		return yparPrice;
	}



	public void setYparPrice(BigDecimal yparPrice) {
		this.yparPrice = yparPrice;
	}

    

	public SeatClassType getSeatClassType() {
		return seatClassType;
	}



	public void setSeatClassType(SeatClassType seatClassType) {
		this.seatClassType = seatClassType;
	}



	@Override
    @JsonIgnore
    public String getSequence() {
        return "S_FORD_ORDER_STATIC";
    }



	public String getSaleType() {
		return saleType;
	}



	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}



	public String getReturnFlightNo() {
		return returnFlightNo;
	}



	public void setReturnFlightNo(String returnFlightNo) {
		this.returnFlightNo = returnFlightNo;
	}



	public String getReturnDepAirportCode() {
		return returnDepAirportCode;
	}



	public void setReturnDepAirportCode(String returnDepAirportCode) {
		this.returnDepAirportCode = returnDepAirportCode;
	}



	public String getReturnDepAirportName() {
		return returnDepAirportName;
	}



	public void setReturnDepAirportName(String returnDepAirportName) {
		this.returnDepAirportName = returnDepAirportName;
	}



	public String getReturnArrAirportCode() {
		return returnArrAirportCode;
	}



	public void setReturnArrAirportCode(String returnArrAirportCode) {
		this.returnArrAirportCode = returnArrAirportCode;
	}



	public String getReturnArrAirportName() {
		return returnArrAirportName;
	}



	public void setReturnArrAirportName(String returnArrAirportName) {
		this.returnArrAirportName = returnArrAirportName;
	}



	public String getReturnDepCityCode() {
		return returnDepCityCode;
	}



	public void setReturnDepCityCode(String returnDepCityCode) {
		this.returnDepCityCode = returnDepCityCode;
	}



	public String getReturnDepCityName() {
		return returnDepCityName;
	}



	public void setReturnDepCityName(String returnDepCityName) {
		this.returnDepCityName = returnDepCityName;
	}



	public String getReturnArrCityCode() {
		return returnArrCityCode;
	}



	public void setReturnArrCityCode(String returnArrCityCode) {
		this.returnArrCityCode = returnArrCityCode;
	}



	public String getReturnArrCityName() {
		return returnArrCityName;
	}



	public void setReturnArrCityName(String returnArrCityName) {
		this.returnArrCityName = returnArrCityName;
	}



	public Date getReturnDepTime() {
		return returnDepTime;
	}



	public void setReturnDepTime(Date returnDepTime) {
		this.returnDepTime = returnDepTime;
	}



	public Date getReturnArrTime() {
		return returnArrTime;
	}



	public void setReturnArrTime(Date returnArrTime) {
		this.returnArrTime = returnArrTime;
	}



	public String getReturnSeatClassCode() {
		return returnSeatClassCode;
	}



	public void setReturnSeatClassCode(String returnSeatClassCode) {
		this.returnSeatClassCode = returnSeatClassCode;
	}



	public SeatClassType getReturnSeatClassType() {
		return returnSeatClassType;
	}



	public void setReturnSeatClassType(SeatClassType returnSeatClassType) {
		this.returnSeatClassType = returnSeatClassType;
	}

	
}
