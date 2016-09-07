package com.lvmama.lvf.common.dto.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 短信信发送类型
 *
 */
public enum SmsType {

	/**
	 * 请不要随意更改中文释义！！！！！！会直接影响短信查询功能！！！！
	 */
	NULL(null,null),
	FLIGHT_CHANGE_NOTICE("机票航变通知短信","changeNotice"),
	FLIGHT_PAY_NOTICE("支付提醒短信","payNotice"),//2015-07-27
	FLIGHT_ISSUE_AFTER_PAY_NOTICE("支付后发送出票相关的提示短信","issueAfterPayNotice"),//2016-01-04
	FLIGHT_ISSUE_SUCCESS("机票出票成功短信","issueSuccess",OrderType.NORMAL),
	FLIGHT_CHANGE_ISSUE_SUCCESS("机票变更出票成功短信","changeIssueSuccess",OrderType.CTMT),
	FLIGHT_BOOK_SUCCESS("机票预订成功短信","bookSuccess",OrderType.NORMAL),
	FLIGHT_CHANGE_SUCCESS("机票变更审核通过短信","changeSuccess",OrderType.CTMT),
	FLIGHT_REFUND_SUCCESS("机票退票成功短信","refundSuccess",OrderType.RTVT),
	FLIGHT_REFUND_PROCESSING("机票退票审核通过短信","refundProcessing",OrderType.RTVT),
	FLIGHT_PAY_DIRECT_REDUCTION("机票支付金额直减提醒短信","payDirectReductionNotice"),
	GROUP_SMS_SEND("短信群发","groupSend"),
	
	/**
	 * 火车票短信模板
	 */
	NON_PAID("未支付提醒短信", "nonPaid"),
	PAY_SUCCESS("支付成功提醒短信", "paySuccess"),
	ISSUE_SUCCESS("出票成功短信", "issueSuccess"),
	ISSUE_FAIL("出票失败短信", "issueFail"),
	REFUND_TICKET_SUCCESS("退票成功短信", "refundTicketSuccess"),
	REFUND_TICKET_FAIL("退票失败短信", "refundTicketFail"),
	REFUND_SUCCESS("退款成功短信", "refundSuccess"),
	REFUND_SPREAD_SUCCESS("退还差价成功短信", "refundSpreadSuccess"),
	REFUND_TICKET_SUCCESS_FEE_ZERO("退票手续费短信", "refundTicketSuccessFeeZero"),
	OCCUPYSEAT_SUCCESS_NOTPAY("占座成功提醒支付短信", "occupySeatSuccessNotPay"),
	ISSUE_SUCCESS_DELIVERY("出票成功已配送", "issueSuccessDelivery");

	private String cnName;
	private String templateName;
	private OrderType orderType;
	
	private SmsType(String cnName, String templateName,OrderType orderType) {
		this.cnName = cnName;
		this.templateName = templateName;
		this.orderType = orderType;
	}
	
	private SmsType(String cnName, String templateName) {
		this.cnName = cnName;
		this.templateName = templateName;
	}
	
    public static SmsType[] getSmsType(OrderType orderType){
		
		List<SmsType> smsTypes  = new ArrayList<SmsType>();
		smsTypes.add(FLIGHT_CHANGE_NOTICE);
		smsTypes.add(FLIGHT_PAY_NOTICE);
		for(SmsType smsType : SmsType.values())
		{
			if(smsType.getOrderType() == orderType)
			{
				smsTypes.add(smsType );
			}
		}
		return smsTypes.toArray(new SmsType[smsTypes.size()]);
	}

	public String getCnName() {
		return cnName;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
	
	
	
}
