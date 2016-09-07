package com.lvmama.lvfit.common.dto.enums;

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
	FLIGHT_ISSUE_SUCCESS("机票出票成功短信","issueSuccess",OrderType.NORMAL),
	FLIGHT_CHANGE_ISSUE_SUCCESS("机票变更出票成功短信","changeIssueSuccess",OrderType.CTMT),
	FLIGHT_BOOK_SUCCESS("机票预订成功短信","bookSuccess",OrderType.NORMAL),
	FLIGHT_CHANGE_SUCCESS("机票变更审核通过短信","changeSuccess",OrderType.CTMT),
	FLIGHT_REFUND_SUCCESS("机票退票成功短信","refundSuccess",OrderType.RTVT),
	FLIGHT_REFUND_PROCESSING("机票退票审核通过短信","refundProcessing",OrderType.RTVT),
	GROUP_SMS_SEND("短信群发","groupSend");

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
