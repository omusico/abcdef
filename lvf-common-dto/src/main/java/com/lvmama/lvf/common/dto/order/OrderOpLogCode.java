package com.lvmama.lvf.common.dto.order;

public enum OrderOpLogCode {

	ORDER_CREATE("0001", "订单创建成功，出发日期：【%s】，出发机场码：【%s】，到达机场码：【%s】，舱位：【%s】，乘客信息：【%s】"),
	ORDER_STATUS_CHANGE("0002", "订单状态变动，操作：【%s】，变动前：【%s】，变动后：【%s】！"),
	ORDER_DETAIL_STATUS_CHANGE("0003", "订单明细状态变动，操作：【%s】，变动前：【%s】，变动后：【%s】！"),
	ORDER_AMOUNT_CHANGE("0004", "订单金额变动：操作：【%s】，变动前：【%s】，变动后：【%s】！"),
	ORDER_DETAIL_AMOUNT_CHANGE("0005", "订单明细金额变动：操作：【%s】，票价信息变动前：【%s】，票价信息变动后：【%s】，"
		+ "审核金额信息变动前：【%s】，审核金额信息变动后：【%s】！"),
	SUPP_ORDER_CREATE_FAIL("0006", "主订单ID：【%s】子订单ID：【%s】，创建供应商订单失败，供应商返回信息，：【%s】"),
	SUPP_ORDER_NET_FAIL("0007", "主订单ID：【%s】子订单ID：【%s】，创建供应商订单失败，调用51接口出现网络错误！"),
	ORDER_TICKET_RTVT_APPLY("0008", "订单退废票申请：订单号：【%s】，PNR：【%s】，票号：【%s】，新退票订单号：【%s】！"),
	ORDER_ISSUE_TICKET_AMOUNT_CHANGE("0009", "人工票号：【%s】，PNR：【%s】，供应商政策ID：【%s】；订单明细金额变动：操作：【%s】，票价信息变动前：【%s】，票价信息变动后：【%s】，"
	           + "审核金额信息变动前：【%s】，审核金额信息变动后：【%s】！"),
	ORDER_AUTO_ISSUE_TICKET_CREATE("0010", "供应商票号：【%s】；订单明细金额信息：操作：【%s】，票价信息：【%s】"),
	ORDER_CTMT_TICKET_APPLY_CHANGE("0011", "改期改签申请成功，新子订单号：【%s】，出发日期：【%s】，航班号：【%s】，舱位：【%s】！乘客信息：【%s】"),
	ORDER_CTMT_TICKET_AMOUNT_CHANGE("0012", "改期改签票号：【%s】，PNR：【%s】，供应商政策ID：【%s】；订单明细金额变动：操作：【%s】，票价信息变动前：【%s】，票价信息变动后：【%s】，"
               + "审核金额信息变动前：【%s】，审核金额信息变动后：【%s】！"),
    ORDER_TICKET_BSP_STORAGE_ADD_CHANGE("0013", "行程单ID：【%s】；行程单入库操作：行程单入库单号【%s】至【%s】入库成功，状态为：【%s】！"),
    ORDER_TICKET_BSP_STORAGE_CHANGE("0014", "行程单ID：【%s】；行程单信息变动操作：行程单入库单号【%s】至【%s】，状态变动前为：【%s】，状态变动后为：【%s】！"),
    ORDER_TICKET_BSP_STORAGE_DETAIL_CHANGE("0015", "行程单ID：【%s】；行程单明细信息变动操作：行程单单号:【%s】，状态变动前为：【%s】，状态变动后为：【%s】！"),
    ORDER_AUTO_CTMT_TICKET_CREATE("0016", "供应商改签票号：【%s】；订单明细金额信息：操作：【%s】，票价信息：【%s】"),

	ORDER_BOOKING_RESULT_CALLBACK("0017","回调通知VST预订结果，VST主订单号：【%s】，机票子订单号：【%s】，回调结果：【%s】"),
	ORDER_TICKET_POLICY_FAIL("0018","主订单ID：【%s】子订单ID：【%s】，自定位后从政策中心获取政策失败！"),
	ORDER_TICKET_SAVE_POLICY_FAIL("0019", "主订单ID：【%s】子订单ID：【%s】，自定位后从政策中心获取的政策存入DB失败！"),
	ORDER_TICKET_LVMAMA_BOOKING_FAIL("0020", "主订单ID：【%s】子订单ID：【%s】，自出政策（后订座）自订位失败，请人工处理!"),
	ORDER_TICKET_SUPP_LVMAMA_BOOKING_FAIL("0021", "主订单ID：【%s】子订单ID：【%s】，供应商政策（后订座）创单失败转自出，自订位失败，请人工处理!"),
	ORDER_TICKET_SUPP_BOOKING_SUCC("0022", "主订单ID：【%s】子订单ID：【%s】，供应商政策（后订座）创单成功，变价超过%s元，请人工处理"),
	SUPP_ORDER_CREATE_MSG("0023", "主订单ID：【%s】子订单ID：【%s】，供应商返回信息：【%s】");

	/** 编码 */
	private String code;
	
	/** 消息格式字符串 */
	private String messageFmt;
	
	private OrderOpLogCode(String code, String messageFmt) 
	{
		this.code = code;
		this.messageFmt = messageFmt;
	}
	
	public String getMessage(Object... vars){
		if(vars != null && vars.length > 0)
		{
			return String.format(this.messageFmt, vars);
		}	
		return this.messageFmt;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessageFmt() {
		return messageFmt;
	}

	public void setMessageFmt(String messageFmt) {
		this.messageFmt = messageFmt;
	}
	
}
