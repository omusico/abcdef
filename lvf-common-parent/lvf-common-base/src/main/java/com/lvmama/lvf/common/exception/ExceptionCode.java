package com.lvmama.lvf.common.exception;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;



/**
 * 异常编码枚举
 * @author majun
 * @date   2015-1-24
 */
public class ExceptionCode implements Serializable{
    
	private static final long serialVersionUID = 8418873379374631922L;
	
	public final static ExceptionCode UNDEF_ERROR = new ExceptionCode("500","不好意思，系统繁忙，请稍后再试！");
    public final static ExceptionCode REMOTE_INVOKE = new ExceptionCode("0001", "【%s】接口调用异常，接口地址【%s】！");
    public final static ExceptionCode BOOKING_NO_AVAILABLE_SEAT = new ExceptionCode("0002", "没有可利用的座位，【航班号%s】, 【出发日期%s】,【出发城市code：%s】, 【到达城市code：%s】, 【舱位%s】！");
    public final static ExceptionCode BOOKING_VERIFY_PRICE= new ExceptionCode("0003", "验价失败，【航班号%s】, 【出发日期%s】,【出发城市code：%s】, 【到达城市code：%s】, 【舱位%s】！");
    public final static ExceptionCode NO_MATCH_ORDER_BY_NO= new ExceptionCode("0004","订单号为%s的订单不存在");
    public final static ExceptionCode NO_MATCH_ORDER_BY_ID= new ExceptionCode("0005","订单ID为%s的订单不存在");
    public final static ExceptionCode NO_MATCH_ORDERMAIN_BY_ID= new ExceptionCode("0005","订单ID为%s的订单的主订单不存在");
    public final static ExceptionCode NOT_FLIGHT_POLICY_SUPP= new ExceptionCode("0006","没有此供应商ID为%s的政策信息");
    public final static ExceptionCode NOT_CARRIER= new ExceptionCode("0007","没有此承运人编码为%s的信息");
    public final static ExceptionCode NO_MATCH_ORDER_OP_STATUS= new ExceptionCode("0008","订单操作状态%s不存在");
    public final static ExceptionCode SUPP_ORDER_PAY_FAIL= new ExceptionCode("0009","供应商订单%s支付失败");
    public final static ExceptionCode NO_MATCH_SUPP_ORDER_BY_NO= new ExceptionCode("0004","供应商订单号为%s的订单不存在");
    public final static ExceptionCode NO_MATCH_SUPP_ORDER_BY_ID= new ExceptionCode("0005","供应商订单ID为%s的订单不存在");
    public final static ExceptionCode NO_MATCH_PRODUCT_BRANCH= new ExceptionCode("0010","产品规格不数据");
    public final static ExceptionCode NO_MATCH_TRAFFIC_FLIGHT= new ExceptionCode("0011","产品航班信息表无数据");
    public final static ExceptionCode NO_MATCH_GOODS_TIME_PRICE= new ExceptionCode("0012","商品时间价格表无数据");
    public final static ExceptionCode NO_MATCH_ORDER_BY_STATUS= new ExceptionCode("0010","订单状态不满足支付要求");
    public final static ExceptionCode NO_FULL_ORDER_INFO= new ExceptionCode("0011","未传入订单信息,无法进行业务逻辑判断!");
    public final static ExceptionCode EMPTY_SUPP_ORDER_ID= new ExceptionCode("0013","航班供应商ID参数传入为null");
    
    public final static ExceptionCode UNDEF_REMOTE_INVOKE= new ExceptionCode("0012", "接口调用异常，接口地址【%s】！%s");
    public final static ExceptionCode NO_SUCH_POLICY_PUSH= new ExceptionCode("0014","调用517Na政策推送接口【%s】！返回为空-%s");
    public final static ExceptionCode NOT_MATCH_INVENTORY = new ExceptionCode("0015", "很抱歉，舱位售尽，请重新查询预订！");
    public final static ExceptionCode NO_AVAILABLE_COUPON = new ExceptionCode("0016","您的优惠券信息失效或不符合要求，-%s-请您重新确认！"); 
    
    public final static ExceptionCode SUBMIT_SUPP_RTVT_APPLY_FAIL= new ExceptionCode("1001", "提交供应商退废票申请失败，【%s】！");
    public final static ExceptionCode ORDER_BY_ID_ISSUE_APPLY_FAIL= new ExceptionCode("1002","订单ID为%s的订单出票申请失败");
    public final static ExceptionCode SUPP_ORDER_BY_ID_CANCEL_FAIL= new ExceptionCode("1003","订单ID为%s的供应商订单取消失败");
    public final static ExceptionCode VALIDATION_BSP_NO= new ExceptionCode("1006","不能生成，行程单号已被使用");
    public final static ExceptionCode VALIDATION_BSP_DETAIL_TICKET_NO= new ExceptionCode("1007","行程单明细中的票号已被使用，请重新输入");
    public final static ExceptionCode VALIDATION_BSP_TICKET_NO_EXIST= new ExceptionCode("1008","票号不存在，请重新输入");
    public final static ExceptionCode VALIDATION_BSP_STATISTICS_INFO_NO_EXIST= new ExceptionCode("1009","没有统计数据，请检查");
    public final static ExceptionCode VALIDATION_BSP_STORAGE_CAN_NOT_CANCELLED= new ExceptionCode("1010","入库的单号已经被使用，不能取消入库");
    public final static ExceptionCode NOT_FLIGHTOFFICE= new ExceptionCode("1004","没有此供应商officeNo为%s的信息");
    public final static ExceptionCode BOOKING_FAILURE= new ExceptionCode("1011","订位不成功，请重新下单!!!");
    public final static ExceptionCode NOT_NEED_SUPP_RTVT_OP= new ExceptionCode("1005", "该订单非供应商出票，无需供应商处理！");
    public final static ExceptionCode BOOKING_REJECT= new ExceptionCode("1012", "请预订%s天以外的数据！");
    public final static ExceptionCode SETTLEMENT_FAIL= new ExceptionCode("1013","%s");
    public final static ExceptionCode SEARCH_DATE_TOO_EARLY= new ExceptionCode("1014","请勿查询历史航班！");
    public final static ExceptionCode SEARCH_CITY_NOT_EXIST= new ExceptionCode("1015","该城市不存在！");
    public final static ExceptionCode INVALID_CHILDREN_PRICE= new ExceptionCode("1016","无可用的儿童政策或价格!%s:%s:%s:%s");
    public final static ExceptionCode INVALID_PRICE= new ExceptionCode("1017","无可用的政策或价格!%s:%s:%s:%s:%s:%s:%s");
    public final static ExceptionCode TICKET_ISSUE_APPLY_AUDIT_FAIL= new ExceptionCode("1018","自动出票异常，请检查");
    public final static ExceptionCode PASSENGER_AGE_OVER_70= new ExceptionCode("1019","超过70周岁的老年人以及身体欠佳者乘坐飞机，须提供三级甲等医院的健康证明，经航空公司同意方可购票。请您自行联系航空公司购票！");
    public final static ExceptionCode PASSENGER_NAME_FORBIDDEN= new ExceptionCode("1020", "您输入的%s名字不合民航规定，无法下单!");
    public final static ExceptionCode PASSENGER_HAS_BOOKED= new ExceptionCode("1021","航班【%s】已存在乘客【%s】的订座记录，订单号【%s】，请勿重复预订！");
    public final static ExceptionCode ROUTE_CITY_INCORRECT= new ExceptionCode("1022","往返的城市不匹配！");
    public final static ExceptionCode SEAT_AUTO_LIFT= new ExceptionCode("1023","您预定的舱位已售完，现已帮你提升一个舱位，原销售总价[%s]，现销售总价[%s]，是否继续？");
    public final static ExceptionCode SEAT_PRICE_CHANGE_HINT= new ExceptionCode("1024","您预定的舱位价格已变动，原销售总价[%s]，现销售总价[%s]，是否继续？");
    public final static ExceptionCode PASSENGER_NAME_REPEAT= new ExceptionCode("1025", "您输入的乘客名字%s，证件号%s重复，请检查!");
    public final static ExceptionCode PASSENGER_BIRTHDAY_ERROR= new ExceptionCode("1026", "您输入的乘客生日异常，请检查!");
    public final static ExceptionCode PASSENGER_AGE_OF_BABY= new ExceptionCode("1027", "暂不支持婴儿票!");
    
    public final static ExceptionCode NO_CITY_CODE= new ExceptionCode("1101","缺少出发地或者目的地参数！");
    
    //退款1800-1900
    public final static ExceptionCode REFUND_FAIL= new ExceptionCode("1801","%s");
    public final static ExceptionCode REFUND_FAIL_CALLBACK= new ExceptionCode("1802","%s");
    
    //禁售规则
    public final static ExceptionCode SALES_RULE_DISABLE_FAIL= new ExceptionCode("2100","%s");
    
    //支付1900-1999
    public final static ExceptionCode TO_PAY_FAIL= new ExceptionCode("1901","保存支付信息失败,%s");
    public final static ExceptionCode PAYMENT_OUT_OF_TIME= new ExceptionCode("1902","支付超时，%s");
    public final static ExceptionCode PAYMENT_CALlBACK_FAIL= new ExceptionCode("1903","%s");
    
    public final static ExceptionCode RISK_CUSTOMER_BLACK_LIST_ERROR= new ExceptionCode("2001","该会员%s未支付订单过多,禁止继续下单,请尽快支付或取消!");
    
    public final static ExceptionCode NOT_CUSTOMER_ORDER_ERROR= new ExceptionCode("2002","禁止非会员下单,请先登录!");
    
    public final static ExceptionCode RISK_TODAY_TOMORROW_SAMECUSTOMER_PASSENGER_LIMIT= new ExceptionCode("1920","当天或次日订单人数超过三人!用户ID为[%s]");
    public final static ExceptionCode RISK_TODAY_TOMORROW_SAMECUSTOMER_ORDER_LIMIT= new ExceptionCode("1921","当日及次日航班风控规则,对同日期，同航班的客户连续两次下单未支付并取消的，不予第三次下单，进入黑名单!用户ID为[%s]");
    public final static ExceptionCode RISK_TODAY_TOMORROW_SAMECUSTOMER_MINUTES= new ExceptionCode("1922","当日及次日航班风控规则（2天）  同日期、同航班下单间隔时间限制为10分钟!用户ID为[%s]");
    public final static ExceptionCode RISK_TODAY_TOMORROW_SAMECUSTOMER_UNPAY_MINUTES= new ExceptionCode("1923","当日及次日航班风控规则（2天）  5分钟之内连续下单3次不支付直接进入黑名单!用户ID为[%s]");
    
    public final static ExceptionCode API_NOVALID= new ExceptionCode("9999", "当前请求的%s接口限制访问!");
    
    public final static ExceptionCode TOTAL_SALES_NOT_MATCH= new ExceptionCode("1904","航班价格已变动，请重新确认!（备注：原销售总价[%s]，现销售总价[%s]）");
    public final static ExceptionCode TOTAL_SALES_NOT_MATCH_DESC= new ExceptionCode("1905","航班价格变动，出发日期：[%s]，出发机场码：[%s]，到达机场码：[%s]，舱位：[%s]，乘客信息：[%s]");
    public final static ExceptionCode BOOKING_INNER_FAIL= new ExceptionCode("1906","预订出现内部错误,请查看错误日志！");
    public final static ExceptionCode NO_REPEAT_APPLY_RVCMT= new ExceptionCode("1907", "不能重复申请%s！");
    public final static ExceptionCode CTRIP_REVERSE_SELECT_NO_DATA= new ExceptionCode("1908", "调用携程反向查询返回无结果！");
    public final static ExceptionCode BOOKING_EXCEPTION= new ExceptionCode("1909", "预订或者去核对出现异常！");
    public final static ExceptionCode EMPTY_SUPP_CODE= new ExceptionCode("1910","供应商代码为空");
    public final static ExceptionCode CTRIP_CREATE_ORDER_FAIL= new ExceptionCode("2003", "调用携程创建订单返回无结果！");
    public final static ExceptionCode FIVE_ONE_BOOK_GET_TICKET_RULE_FAIL= new ExceptionCode("2004", "调用51Book获取客规返回无结果！");
    public final static ExceptionCode CTRIP_REVISE_CONDITION_NO_DATA= new ExceptionCode("2005", "调用携程国内机票可退票查询返回无结果！");
    public final static ExceptionCode GET_HOTEL_PRICE_FAIL= new ExceptionCode("2006", "您选择的酒店已售完，请更换条件重新查询");
    public final static ExceptionCode GET_FLIGHT_PRICE_FAIL= new ExceptionCode("2007", "您选择的航班已售完，请更换条件重新查询");
    public final static ExceptionCode SYSTEM_FOR_USER_MESSAGE= new ExceptionCode("2008", "未找到您需要的结果，请更换条件重新查询");
    public final static ExceptionCode GET_NO_RESULT= new ExceptionCode("2009", "非常抱歉，没有找到符合您条件的机+酒套餐产品");//没有检索到数据
    public final static ExceptionCode GET_NO_AFFLI_RESULT= new ExceptionCode("2010", "非常抱歉，没有找到符合您条件的相关产品");
    public final static ExceptionCode GET_NO_CACHE_SHOPPING= new ExceptionCode("2011", "页面停留时间过长，将为您重新查询");//没能够从缓存中获取到购物车数据
    public final static ExceptionCode BOOKING_FAIL_FOR_CUSTOMER= new ExceptionCode("2012", "非常抱歉，预订出现异常，请重新查询预订！");//没能够从缓存中获取到购物车数据
    public final static ExceptionCode BOOKING_FAIL_CHANGE_CTRIP= new ExceptionCode("2013", "整单换Ctrip供应商下单失败");

    /*********************************************自主打包产品ExceptionCode*******************************************************************/
    public final static ExceptionCode GET_NO_SDP_PRODUCT= new ExceptionCode("SDP_PRODUCT","自主打包产品Id[%s],未获取到产品信息！");
    public final static ExceptionCode GET_NO_SDP_PRODUCT_GROUP_CALENDAR= new ExceptionCode("SDP_PRODUCT_001","被打包产品Id[%s],未获取到产品团期低价日历信息！");
    public final static ExceptionCode GET_NO_SDP_MATCH_CALENDAR= new ExceptionCode("SDP_PRODUCT_002","自主打包产品Id[%s],vst低价日历和机票低价日历未匹配到数据!");
    public final static ExceptionCode GET_NO_SDP_START_PRICE= new ExceptionCode("SDP_PRODUCT_003","自主打包产品Id[%s],未计算处产品起价!");
    public final static ExceptionCode GET_NO_FLIGHT_CALENDAR= new ExceptionCode("SDP_PRODUCT_003","自主打包产品Id[%s],出发地[%s],目的地[%s],从缓存服务器中获取机票低价日历信息失败!");
    public final static ExceptionCode GET_NO_SDP_HOTEL_COMBO= new ExceptionCode("SDP_GOODS_001","自主打包产品Id[%s],品类Id[%s],行程开始日期[%s],出发城市[%s],到达城市[%s]未获取到合适的酒店套餐！");
    public final static ExceptionCode GET_NO_SDP_LOCAL_TRIP= new ExceptionCode("SDP_GOODS_002","自主打包产品Id[%s],品类Id[%s],行程开始日期[%s],出发城市[%s],到达城市[%s]未获取到合适的当地游套餐！");
    public final static ExceptionCode GET_NO_SDP_DEP_FLIGHT= new ExceptionCode("SDP_GOODS_003","自主打包产品Id[%s],品类Id[%s],行程开始日期[%s],出发城市[%s],到达城市[%s],未获取到合适的去程航班！");
    public final static ExceptionCode GET_NO_SDP_ARR_FLIGHT= new ExceptionCode("SDP_GOODS_004","自主打包产品Id[%s],品类Id[%s],行程开始日期[%s],出发城市[%s],到达城市[%s],未获取到合适的返程航班！");
    public final static ExceptionCode GET_NO_SDP_GOODS= new ExceptionCode("SDP_GOODS","暂时未找到合适的商品！");
    public final static ExceptionCode CALL_INTERFACE_ERROR= new ExceptionCode("FIT_ERROR","调用外部接口出现异常，调用时间~[%s]~，接口方法~[%s]~，参数字符串~[%s]~！，异常信息~[%s]");
    /*********************************************自主打包产品ExceptionCode*******************************************************************/
    
    
    public final static ExceptionCode END_TAG= new ExceptionCode("-1","异常枚举code结束TAG(非正常使用)");

    public ExceptionCode(String code, String messageFmt) {
        this.code = code;
        this.messageFmt = messageFmt;
    }

    /** 编码 */
    private String code;
    
    /** 消息格式字符串 */
    @JsonIgnore
    private String messageFmt;
    
    public ExceptionCode() {
		super();
	}

	public String errMessage(Object... vars){
        return String.format(this.messageFmt,vars);
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
    
    public static void main(String[] args) {
    System.out.println(ExceptionCode.BOOKING_INNER_FAIL.errMessage());
}
    
}
