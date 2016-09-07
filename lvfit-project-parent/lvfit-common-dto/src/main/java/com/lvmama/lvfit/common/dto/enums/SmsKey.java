package com.lvmama.lvfit.common.dto.enums;


/**
 * sms Map key
 * @author lujingzhong
 *
 */
public enum SmsKey {
	FLIGHTORDERNO("订单号"),
	PASSENGERSTR("乘客信息"),
	FLIGHTNO("航班号"),
	DEPARTUREDAY("出发日期"),
	DEPARTURETIME("出发时刻"),
	ARRIVALTIME("到达时刻"),
	DEPARTUREAIRPORTANDTERMAINALBUILDING("出发机场+航站楼"),
	ARRIVALAIRPORTANDTERMAINALBUILDING("到达机场+航站楼"),
	PREPAYMENTAMOUNT("订单金额"),
	PREREFUNDAMOUNT("退票金额"),
	TICKETNOSTR("票号"),
	
	/**时间*/
	LIMITMINS("提前时间"),
	REFUNDWORKDAYS("退款到账时间"),
	
	/**new*/
	NEWFLIGHTNO("new航班号"),
	NEWDEPARTUREDAY("new出发日期"),
	NEWDEPARTURETIME("new出发时刻"),
	NEWARRIVALTIME("new到达时刻"),
	NEWDEPARTUREAIRPORTANDTERMAINALBUILDING("new出发机场+航站楼"),
	NEWARRIVALAIRPORTANDTERMAINALBUILDING("new到达机场+航站楼"),
	NEWFLIGHTORDERNO("new订单号"),
	NEWPREPAYMENTAMOUNT("new订单金额"),
	NEWTICKETNOSTR("new票号");
	

	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private SmsKey(String cnName) {
		this.cnName = cnName;
	}
	
	

}
