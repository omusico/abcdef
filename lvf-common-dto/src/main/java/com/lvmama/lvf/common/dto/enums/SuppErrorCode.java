package com.lvmama.lvf.common.dto.enums;

import com.lvmama.lvf.common.utils.StringUtil;

public enum SuppErrorCode {

	/** 51BOOK错误编码 */
	FIVE1BOOK_PNR_NULL("5100001", "51BOOK", "pnr与价格为空"),
	FIVE1BOOK_TICKET_RESERVATION_UNKNOWN("5100002", "51BOOK", "订座状态不明"),
	FIVE1BOOK_POLICY_CHANGE("5100003", "51BOOK", "换编政策"),
	FIVE1BOOK_POLICY_BASE_NULL("5100004", "51BOOK", "没有基本政策"),
	FIVE1BOOK_FARE_WITH_POLICY_BASE("5100005", "51BOOK", "运价只适用于基本政策"),
	FIVE1BOOK_PRICE_CHANGE("5100006", "51BOOK", "采购价格"),
	FIVE1BOOK_POLICY_SUSPEND("5100007", "51BOOK", "政策挂起"),
	FIVE1BOOK_POLICY_INVALID("5100008", "51BOOK", "政策状态无效"),
	FIVE1BOOK_TIME_OUT("5100009", "51BOOK", "数据请求超时"),
	FIVE1BOOK_POLICY_DEPARTURE_ERROR("5100010", "51BOOK", "政策出发地不匹配"),
	FIVE1BOOK_CODE_NAME_REPEAT("5100011", "51BOOK", "同一编码名字重复"),
	FIVE1BOOK_NOT_CHILDREN("5100012", "51BOOK", "该乘客已不是儿童"),
	FIVE1BOOK_JD_B2B_OW("5100013", "51BOOK", "JD航空b2b政策只能订单人单程"),
	FIVE1BOOK_PAY_SERVER_EXCEPTION("5100014", "51BOOK", "获取支付链接失败,网络异常"),
	FIVE1BOOK_PAY_PARAMETER_ERROR("5100015", "51BOOK", "获取支付链接失败,客户端请求参数异常,参数未能确认支付宝的任何支付方式"),
	FIVE1BOOK_INTERFACE_SERVER_EXCEPTION("5100016", "51BOOK", "接口系统错误"),
	FIVE1BOOK_POLICY_NOT_CONNECTED("5100017", "51BOOK", "没有连接上政策"),
	FIVE1BOOK_PRICE_VERIFY_FAIL("5100018", "51BOOK", "价格校验失败"),
	FIVE1BOOK_POLICY_ID_INVALID("5100019", "51BOOK", "政策ID无效"),
	FIVE1BOOK_POLICY_ARRIVAL_ERROR("5100020", "51BOOK", "政策的抵达地不匹配"),
	FIVE1BOOK_SEAT_NOT_ENOUGH("5100021", "51BOOK", "当前已无座位或座位数量不足,请重新查询预订"),
	FIVE1BOOK_CREDIBILITY_PERFORMED("5100022", "51BOOK", "旅客包含失信被执行人"),
	FIVE1BOOK_CONFIG_DISCONNECT("5100023", "51BOOK", "配置断开"),
	FIVE1BOOK_CONFIG_DISABLED("5100024", "51BOOK", "没有调用到可用配置"),
	FIVE1BOOK_BSP_NEED_CHANGE_CODE("5100025", "51BOOK", "BSP政策需要换编码出票，检测到无可用配置"),
	FIVE1BOOK_PASSENGER_NAME_FORMAT_ERROR("5100026", "51BOOK", "姓名格式错误"),
	FIVE1BOOK_ORDER_POLICY_INVALID("5100027", "51BOOK", "订单对应的政策无效"),
	FIVE1BOOK_ORDER_CREATE_FAIL("5100028", "51BOOK", "订单创建失败"),
	FIVE1BOOK_SYSTEM_ERROR("5100029", "51BOOK", "SYS_ERROR_UNKNOWN"),
	FIVE1BOOK_PASSENGER_IDNO_NULL("5100030", "51BOOK", "identityNo不能为空name不能为空"),
	FIVE1BOOK_CHILDREN_SEAT_CLASS_ERROR("5100031", "51BOOK", "儿童只能订F，C，Y舱的座位"),
	FIVE1BOOK_PASSENGER_NAME_REPEAT("5100032", "51BOOK", "相同姓名或者姓名谐音相同的乘客不能预定在同一订单中"),

	/** 517NA错误编码 */
	FIVE17NA_PNR_ERROR("5170001", "517NA", "PNR内容解析异常"),
	FIVE17NA_ADULT_TICKETPRICE_UNLIKENESS("5170002", "517NA", "ADULT_TICKETPRICE_UNLIKENESS"),
	FIVE17NA_REQUEST_ERROR("5170003", "517NA", "处理用户请求出错"),
	FIVE17NA_NO_DATA("5170004", "517NA", "NO_DATA"),
	FIVE17NA_SYSTEM_ERROR("5170005", "517NA", "系统异常"),
	FIVE17NA_UNKNOWN_ERROR("5170006", "517NA", "UNKNOWN_ERROR"),
	FIVE17NA_PASSENGER_NAME_UNIDENTIFIED("5170007", "517NA", "包含生僻字"),
	FIVE17NA_ORDER_PNR_STATUS_ERROR("5170008", "517NA", "PNR不为HK/KK/RR/KL/TK"),
	FIVE17NA_ORDER_BOOKING_FAIL("5170009", "517NA", "创建订单失败不能订座"),
	FIVE17NA_PASSENGER_IDNO_INVALID("5170010", "517NA", "无效的证件号"),
	FIVE17NA_AUTO_USING_CONFIG_FAIL("5170011", "517NA", "自动启用配置失败"),
	FIVE17NA_SIGN_ERROR("5170012", "517NA", "SIGN IS ERROR"),
	FIVE17NA_PASSENGER_IDCARD_NULL("5170013", "517NA", "idcard is empty or null"),
	FIVE17NA_PASSENGER_NAME_NULL("5170014", "517NA", "name is empty or null"),
	FIVE17NA_PASSENGER_NAME_CONTAIN_INVALID_CHARACTER("5170015", "517NA", "乘机人姓名含有无效字符"),
	FIVE17NA_ORDER_SEAT_SOLD_OUT("5170016", "517NA", "创单失败;舱位已销售完"),

	/** 驴妈妈自有错误编码 */
	LVMAMA_PNR_STATUS_ERROR("1110001", "LVMAMA_TRAFFIC", "创建pnr成功但是状态非HK，KK，TK，DK，RR，KL"),
	LVMAMA_PNR_ANALYSIS_ERROR("1110002", "LVMAMA_TRAFFIC", "未解析到PNR"),
	LVMAMA_PNR_UNABLE_SELL("1110003", "LVMAMA_TRAFFIC", "座位已售罄或限制销售");


	/** 编码 */
	private String code;

	/** 供应商 **/
	private String supp;

	/** 错误描述 */
	private String errorMessage;

	SuppErrorCode(String code, String supp, String errorMessage) {
		this.code = code;
		this.supp = supp;
		this.errorMessage = errorMessage;
	}

	public String getCode() {
		return code;
	}

	public String getSupp() {
		return supp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public static String matchCode(String supp, String message) {
		if (StringUtil.isEmptyString(supp) || StringUtil.isEmptyString(message)) {
			return null;
		}
		for (SuppErrorCode suppErrorCode : SuppErrorCode.values()) {
			if (supp.equalsIgnoreCase(suppErrorCode.getSupp()) && message.contains(suppErrorCode.getErrorMessage())) {
				return suppErrorCode.getCode();
			}
		}
		return null;
	}

}
