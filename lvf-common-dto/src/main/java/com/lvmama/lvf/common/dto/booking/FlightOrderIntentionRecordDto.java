package com.lvmama.lvf.common.dto.booking;
import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.dto.enums.SeatClassType;
import com.lvmama.lvf.common.utils.DateUtils;
/**
 * 客户预订意向记录DTO
 * TASK #32247 客户预订意向记录接口
 */
@XmlRootElement
public class FlightOrderIntentionRecordDto extends Entity implements Serializable {
	/**驴妈妈账号*/
	private String lvmamaAccount;
	/**预订来源*/
	private BookingSource bookingSource;
	/**行程类型*/
	private FlightTripType flightTripType;
	/**出发机场城市代码*/
	private String depAirportCityCode;
	/**出发机场城市名称*/
	private String depAirportCityCodeName;
	/**到达机场城市代码*/
	private String arrAirportCityCode;
	/**到达机场城市名称*/
	private String arrAirportCityCodeName;
	/**出发机场代码*/
	private String depCode;
	/**出发机场代码*/
	private String depCodeName;
	/**到达机场代码*/
	private String arrCode;
	/**到达机场代码*/
	private String arrCodeName;
	/**承运人代码*/
	private String carrierCode;
	/**承运人代码*/
	private String carrierCodeName;
	/**航班号*/
	private String flightNo;
	/**舱位代码*/
	private String seatClassCode;
	/**舱位类型*/
	private SeatClassType seatClassType;
	/**起飞时间*/
	private Date depTime;

	/***
	 * 构造客户预订意向Dto字符串
	 */
	public String constructFlightOrdIntentionRecordStr(){
		StringBuffer flightOrderIntentionStr = new StringBuffer();
		/**航程类型*/
		FlightTripType flightTripType = this.getFlightTripType();
		String flightTripTypeStr = StringUtils.EMPTY;
		if(flightTripType!=null){
			flightTripTypeStr = flightTripType.getCnName();
		}
		flightOrderIntentionStr.append("\t"+flightTripTypeStr).append(",");
		/**出发城市*/
		flightOrderIntentionStr.append("\t" + this.getDepAirportCityCodeName()).append(",");
		/**到达城市*/
		flightOrderIntentionStr.append("\t" + this.getArrAirportCityCodeName()).append(",");
		/**出发机场*/
		flightOrderIntentionStr.append("\t" + this.getDepCodeName()).append(",");
		/**到达机场*/
		flightOrderIntentionStr.append("\t" + this.getArrCodeName()).append(",");
		/**航空公司*/
		flightOrderIntentionStr.append("\t" + this.getCarrierCodeName()).append(",");
		/**航班号*/
		flightOrderIntentionStr.append("\t" + this.getFlightNo()).append(",");
		/**舱位*/
		flightOrderIntentionStr.append("\t" + this.getSeatClassCode()).append(",");
		/**舱位类型*/
		String seatClassTypeStr = StringUtils.EMPTY;
		if(this.getSeatClassType()!=null){
			seatClassTypeStr = this.getSeatClassType().getCnName();
		}
		flightOrderIntentionStr.append("\t" + seatClassTypeStr).append(",");
		/**起飞时间*/
		if(this.getDepTime()!=null){
			flightOrderIntentionStr.append("\t" + DateUtils.formatHhMmDate(this.getDepTime())).append(",");
		}else{
			flightOrderIntentionStr.append("").append(",");
		}
		/**驴妈妈帐号名*/
		flightOrderIntentionStr.append("\t" + this.getLvmamaAccount()).append(",");		
		/**预订来源*/
		BookingSource bookingSource = this.getBookingSource();
		String bookingSourceStr = StringUtils.EMPTY;
		if(bookingSource!=null){
			bookingSourceStr = this.getBookingSource().getCnName();
		}
		flightOrderIntentionStr.append("\t" + bookingSourceStr).append(",");
		/**创建时间*/
		if(this.getCreateTime()!=null){
			flightOrderIntentionStr.append("\t" + DateUtils.formatCnHmDate(this.getCreateTime())).append(",");
		}else{
			flightOrderIntentionStr.append("").append(",");
		}
		return flightOrderIntentionStr.toString().replaceAll("null", "");
	}
	
	@Override
	@JsonIgnore
	public String getSequence() {
		return "S_FORD_ORDER_INTENTION_RECORD";
	}

	public String getLvmamaAccount(){
		return lvmamaAccount;
	}

	public void setLvmamaAccount(String lvmamaAccount){
		this.lvmamaAccount = lvmamaAccount;
	}

	public String getDepAirportCityCode(){
		return depAirportCityCode;
	}

	public void setDepAirportCityCode(String depAirportCityCode){
		this.depAirportCityCode = depAirportCityCode;
	}

	public String getArrAirportCityCode(){
		return arrAirportCityCode;
	}

	public void setArrAirportCityCode(String arrAirportCityCode){
		this.arrAirportCityCode = arrAirportCityCode;
	}

	public String getDepCode(){
		return depCode;
	}

	public void setDepCode(String depCode){
		this.depCode = depCode;
	}

	public String getArrCode(){
		return arrCode;
	}

	public void setArrCode(String arrCode){
		this.arrCode = arrCode;
	}

	public String getCarrierCode(){
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode){
		this.carrierCode = carrierCode;
	}

	public String getFlightNo(){
		return flightNo;
	}

	public void setFlightNo(String flightNo){
		this.flightNo = flightNo;
	}

	public String getSeatClassCode(){
		return seatClassCode;
	}

	public void setSeatClassCode(String seatClassCode){
		this.seatClassCode = seatClassCode;
	}

	public Date getDepTime(){
		return depTime;
	}

	public void setDepTime(Date depTime){
		this.depTime = depTime;
	}

	public FlightTripType getFlightTripType() {
		return flightTripType;
	}

	public void setFlightTripType(FlightTripType flightTripType) {
		this.flightTripType = flightTripType;
	}

	public BookingSource getBookingSource() {
		return bookingSource;
	}

	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}

	public String getDepAirportCityCodeName() {
		return depAirportCityCodeName;
	}

	public void setDepAirportCityCodeName(String depAirportCityCodeName) {
		this.depAirportCityCodeName = depAirportCityCodeName;
	}

	public String getArrAirportCityCodeName() {
		return arrAirportCityCodeName;
	}

	public void setArrAirportCityCodeName(String arrAirportCityCodeName) {
		this.arrAirportCityCodeName = arrAirportCityCodeName;
	}

	public String getDepCodeName() {
		return depCodeName;
	}

	public void setDepCodeName(String depCodeName) {
		this.depCodeName = depCodeName;
	}

	public String getArrCodeName() {
		return arrCodeName;
	}

	public void setArrCodeName(String arrCodeName) {
		this.arrCodeName = arrCodeName;
	}

	public String getCarrierCodeName() {
		return carrierCodeName;
	}

	public void setCarrierCodeName(String carrierCodeName) {
		this.carrierCodeName = carrierCodeName;
	}

	public SeatClassType getSeatClassType() {
		return seatClassType;
	}

	public void setSeatClassType(SeatClassType seatClassType) {
		this.seatClassType = seatClassType;
	}
}