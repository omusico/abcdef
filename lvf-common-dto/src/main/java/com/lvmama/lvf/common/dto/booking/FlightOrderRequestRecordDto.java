package com.lvmama.lvf.common.dto.booking;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.OrderFlag;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.status.order.OrderStatus;
import com.lvmama.lvf.common.utils.DateUtils;
/**
 * @author xumeng
 * 下单请求记录Dto
 * TASK #30159 下单请求记录功能
 */
@XmlRootElement
public class FlightOrderRequestRecordDto extends Entity implements Serializable {

	private static final long serialVersionUID = -6768246556593356445L;
	
	private String traceNo;
	/**订单主键*/
	private Long orderId;
	/**主订单主键*/
	private Long orderMainId;
	/**出发机场城市代码*/
	private String depAirportCityCode;
	/**到达机场城市代码*/
	private String arrAirportCityCode;
	/**出发机场代码*/
	private String depCode;
	/**出发机场名称*/
	private String depName;
	/**到达机场代码*/
	private String arrCode;
	/**到达机场名称*/
	private String arrName;
	/**乘机时间*/
	private Date depTime;
	/**所属航空公司编码*/
	private String airplaneCompanyCode;
	/**航班号*/
	private String flightNo;
	/**舱位代码*/
	private String seatClassCode;
	/**舱位类型*/
	private String seatClassType;
	/**供应商编码*/
	private String suppCode;
	/**供应商政策编号*/
	private String suppPolicyNo;
	/**票面价*/
	private BigDecimal parPrice;
	/**结算价*/
	private BigDecimal settlePrice;
	/**燃油费*/
	private BigDecimal fuelsurTax;
	/**机建费*/
	private BigDecimal airportFee;
	/**乘客人数*/
	private Long totalPassenger;
	/**订单总销售价*/
	private BigDecimal sumSalesPrice;
	/**驴妈妈帐号*/
	private String lvmamaAccount;
	/**联系人姓名*/
	private String contactName;
	/**联系人手机号*/
	private String contactCellphone;
	/**预订来源*/
	private BookingSource bookingSource;
	/**预订结果*/
	private OrderStatus orderStatus;
	/**订单号*/
	private String orderNo;
	/**失败原因*/
	private String failDesc;
	/**请求参数json*/
	private String jsonStr;
	/**消耗时长*/
	private String consumeTime;
	/**乘客类型字符串*/
	private String passengerTypeStr;
	/**成人数量*/
	private Long adultNum;
	/**儿童数量*/
	private Long childrenNum;
	/**账号类型*/
	private OrderFlag orderFlag;
	/**原始供应商*/
	private String originSuppCode;
	/**原始报错信息*/
	private String originFailDesc;
	//ip
//	private String ip;
	//设备号
//	private String equipmentNo;
	
	/***
	 * 构造下单请求记录Dto字符串
	 */
	public String constructFlightReqRecordStr(){
		StringBuffer flightReqRecordStr = new StringBuffer();
		/**下单请求时间*/
		if(this.getCreateTime()!=null){
			flightReqRecordStr.append("\t" + DateUtils.formatCnHmDate(this.getCreateTime())).append(",");
		}else{
			flightReqRecordStr.append("").append(",");
		}
		/**traceNo*/
		flightReqRecordStr.append("\t" + this.getTraceNo()).append(",");
		/**订单号*/
		flightReqRecordStr.append("\t" + this.getOrderNo()).append(",");
		/**订单来源*/
		flightReqRecordStr.append("\t" + this.getBookingSource().getCnName()).append(",");
		/**预定结果*/
		if(this.getOrderStatus()!=null){
			flightReqRecordStr.append("\t" + this.getOrderStatus().getCnName()).append(",");
		}else{
			flightReqRecordStr.append("").append(",");
		}
		/**原始供应商*/
		flightReqRecordStr.append("\t"+this.getOriginSuppCode()).append(",");
		/**原始信息*/
		if(this.getOriginFailDesc()!=null){
			flightReqRecordStr.append("\"").append("\t"+this.getOriginFailDesc().replaceAll("\r", "").replaceAll("\n", "").replaceAll("\t", "")).append("\"").append(",");
		}else {
			flightReqRecordStr.append("").append(",");
		}
		/**信息*/
		if(this.getFailDesc()!=null){
			flightReqRecordStr.append("\"").append("\t"+this.getFailDesc().replaceAll("\r", "").replaceAll("\n", "").replaceAll("\t", "")).append("\"").append(",");
		}else {
			flightReqRecordStr.append("").append(",");
		}
		/**耗时*/
		flightReqRecordStr.append("\t" + this.getConsumeTime()).append(",");
		/**始发地代码*/
		flightReqRecordStr.append("\t" + this.getDepAirportCityCode()).append(",");
		/**目的地代码*/
		flightReqRecordStr.append("\t" + this.getArrAirportCityCode()).append(",");
		/**航班号*/
		flightReqRecordStr.append("\t" + this.getFlightNo()).append(",");
		/**舱位*/
		flightReqRecordStr.append("\t" + this.getSeatClassCode()).append(",");
		/**乘机日期*/
		if(this.getDepTime()!=null){
			flightReqRecordStr.append("\t" + DateUtils.formatHhMmDate(this.getDepTime())).append(",");
		}else{
			flightReqRecordStr.append("").append(",");
		}
		/**供应商*/
		flightReqRecordStr.append("\t" + this.getSuppCode()).append(",");
		/**供应商政策号*/
		flightReqRecordStr.append("\t" + this.getSuppPolicyNo()).append(",");
		/**票面价*/
		flightReqRecordStr.append("\t" + this.getParPrice()).append(",");
		/**结算价*/
		flightReqRecordStr.append("\t" + this.getSettlePrice()).append(",");
		/**燃油*/
		flightReqRecordStr.append("\t" + this.getFuelsurTax()).append(",");
		/**机建*/
		flightReqRecordStr.append("\t" + this.getAirportFee()).append(",");
		//处理后的乘客类型
		String passengerType_af = StringUtils.EMPTY;
		if(this.getPassengerTypeStr()!=null){
			String[] passengerTypeArr = this.getPassengerTypeStr().split("，");
			for(String passengerType:passengerTypeArr){
				passengerType_af += PassengerType.valueOf(passengerType).getCnName()+"，";
			}
			if(passengerType_af.endsWith("，")){//去除逗号
				passengerType_af=passengerType_af.substring(0, passengerType_af.lastIndexOf("，"));
			}
			passengerType_af="("+passengerType_af+")";
		}
		/**订单总销售价*/
		flightReqRecordStr.append("\t" + this.getSumSalesPrice()).append(",");
		/**乘客人数*/
		flightReqRecordStr.append("\t" + this.getTotalPassenger()+passengerType_af).append(",");
		/**驴妈妈帐号名*/
		if(this.getLvmamaAccount()==null){
			flightReqRecordStr.append("").append(",");
		}else{
			flightReqRecordStr.append("\"").append("\t" + this.getLvmamaAccount().replaceAll("\t", "")).append("\"").append(",");
		}
		/**帐号类型*/
		OrderFlag orderFlag = this.getOrderFlag();
		if(orderFlag==null){
			flightReqRecordStr.append("").append(",");
		}else{
			flightReqRecordStr.append("\t" + orderFlag.getCnName()).append(",");
		}
		/**联系人姓名*/
		if(this.getContactName()==null){
			flightReqRecordStr.append("").append(",");
		}else{
			flightReqRecordStr.append("\"").append("\t" + this.getContactName().replaceAll("\t", "")).append("\"").append(",");
		}
		/**联系人手机号*/
		flightReqRecordStr.append("\t" + this.getContactCellphone()).append(",");
//		//ip
//		if(StringUtils.isNotBlank(this.getIp())){
//			flightReqRecordStr.append(this.getIp()).append(",");
//		}else{
//			flightReqRecordStr.append(",");
//		}
//		//设备号
//		if(StringUtils.isNotBlank(this.getEquipmentNo())){
//			flightReqRecordStr.append(this.getEquipmentNo());
//		}
		return flightReqRecordStr.toString().replaceAll("null", "");
	}

	@Override
	@JsonIgnore
	public String getSequence() {
		return "S_FORD_ORDER_REQUEST_RECORD";
	}

	public String getTraceNo() {
		return traceNo;
	}

	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}

	public String getDepAirportCityCode() {
		return depAirportCityCode;
	}

	public void setDepAirportCityCode(String depAirportCityCode) {
		this.depAirportCityCode = depAirportCityCode;
	}

	public String getArrAirportCityCode() {
		return arrAirportCityCode;
	}

	public void setArrAirportCityCode(String arrAirportCityCode) {
		this.arrAirportCityCode = arrAirportCityCode;
	}

	public String getDepCode() {
		return depCode;
	}

	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getArrCode() {
		return arrCode;
	}

	public void setArrCode(String arrCode) {
		this.arrCode = arrCode;
	}

	public String getArrName() {
		return arrName;
	}

	public void setArrName(String arrName) {
		this.arrName = arrName;
	}

	public Date getDepTime() {
		return depTime;
	}

	public void setDepTime(Date depTime) {
		this.depTime = depTime;
	}

	public String getAirplaneCompanyCode() {
		return airplaneCompanyCode;
	}

	public void setAirplaneCompanyCode(String airplaneCompanyCode) {
		this.airplaneCompanyCode = airplaneCompanyCode;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getSeatClassCode() {
		return seatClassCode;
	}

	public void setSeatClassCode(String seatClassCode) {
		this.seatClassCode = seatClassCode;
	}

	public String getSeatClassType() {
		return seatClassType;
	}

	public void setSeatClassType(String seatClassType) {
		this.seatClassType = seatClassType;
	}

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	public String getSuppPolicyNo() {
		return suppPolicyNo;
	}

	public void setSuppPolicyNo(String suppPolicyNo) {
		this.suppPolicyNo = suppPolicyNo;
	}


	public Long getTotalPassenger() {
		return totalPassenger;
	}

	public void setTotalPassenger(Long totalPassenger) {
		this.totalPassenger = totalPassenger;
	}

	public String getLvmamaAccount() {
		return lvmamaAccount;
	}

	public void setLvmamaAccount(String lvmamaAccount) {
		this.lvmamaAccount = lvmamaAccount;
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

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getFailDesc() {
		return failDesc;
	}

	public void setFailDesc(String failDesc) {
		this.failDesc = failDesc;
	}

	public String getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}

	public String getConsumeTime() {
		return consumeTime;
	}

	public void setConsumeTime(String consumeTime) {
		this.consumeTime = consumeTime;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public BigDecimal getParPrice() {
		return parPrice;
	}

	public void setParPrice(BigDecimal parPrice) {
		this.parPrice = parPrice;
	}

	public BigDecimal getSettlePrice() {
		return settlePrice;
	}

	public void setSettlePrice(BigDecimal settlePrice) {
		this.settlePrice = settlePrice;
	}

	public BigDecimal getFuelsurTax() {
		return fuelsurTax;
	}

	public void setFuelsurTax(BigDecimal fuelsurTax) {
		this.fuelsurTax = fuelsurTax;
	}

	public BigDecimal getAirportFee() {
		return airportFee;
	}

	public void setAirportFee(BigDecimal airportFee) {
		this.airportFee = airportFee;
	}

	public BigDecimal getSumSalesPrice() {
		return sumSalesPrice;
	}

	public void setSumSalesPrice(BigDecimal sumSalesPrice) {
		this.sumSalesPrice = sumSalesPrice;
	}

	public BookingSource getBookingSource() {
		return bookingSource;
	}

	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderMainId() {
		return orderMainId;
	}

	public void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}

	public String getPassengerTypeStr() {
		return passengerTypeStr;
	}

	public void setPassengerTypeStr(String passengerTypeStr) {
		this.passengerTypeStr = passengerTypeStr;
	}

	public Long getAdultNum() {
		return adultNum;
	}

	public void setAdultNum(Long adultNum) {
		this.adultNum = adultNum;
	}

	public Long getChildrenNum() {
		return childrenNum;
	}

	public void setChildrenNum(Long childrenNum) {
		this.childrenNum = childrenNum;
	}

	public OrderFlag getOrderFlag() {
		return orderFlag;
	}

	public void setOrderFlag(OrderFlag orderFlag) {
		this.orderFlag = orderFlag;
	}

	public String getOriginSuppCode() {
		return originSuppCode;
	}

	public void setOriginSuppCode(String originSuppCode) {
		this.originSuppCode = originSuppCode;
	}

	public String getOriginFailDesc() {
		return originFailDesc;
	}

	public void setOriginFailDesc(String originFailDesc) {
		this.originFailDesc = originFailDesc;
	}
	
//	public String getIp() {
//		return ip;
//	}
//
//	public void setIp(String ip) {
//		this.ip = ip;
//	}
//
//	public String getEquipmentNo() {
//		return equipmentNo;
//	}
//
//	public void setEquipmentNo(String equipmentNo) {
//		this.equipmentNo = equipmentNo;
//	}
}
