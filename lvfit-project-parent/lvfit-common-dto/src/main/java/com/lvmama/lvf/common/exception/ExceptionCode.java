package com.lvmama.lvf.common.exception;

public class ExceptionCode {
	
	public final static ExceptionCode UNDEF_ERROR = new ExceptionCode("500","不好意思，系统繁忙，请稍后再试！");
	public final static ExceptionCode REMOTE_INVOKE = new ExceptionCode("0001", "【%s】接口调用异常，接口地址【%s】！");
	public final static ExceptionCode UNDEF_REMOTE_INVOKE= new ExceptionCode("0012", "接口调用异常，接口地址【%s】！%s");
	public final static ExceptionCode NOT_CUSTOMER_ORDER_ERROR= new ExceptionCode("2002","禁止非会员下单,请先登录!");
	
	
	/*********************************************机酒动态打包ExceptionCode*******************************************************************/
	public final static ExceptionCode GET_HOTEL_PRICE_FAIL= new ExceptionCode("2006", "您选择的酒店已售完，请更换条件重新查询");
	public final static ExceptionCode GET_FLIGHT_PRICE_FAIL= new ExceptionCode("2007", "您选择的航班已售完，请更换条件重新查询");
	public final static ExceptionCode GET_NO_RESULT= new ExceptionCode("2009", "非常抱歉，没有找到符合您条件的机+酒套餐产品");//没有检索到数据
	public final static ExceptionCode GET_NO_AFFLI_RESULT= new ExceptionCode("2010", "非常抱歉，没有找到符合您条件的相关产品");
	public final static ExceptionCode GET_NO_CACHE_SHOPPING= new ExceptionCode("2011", "页面停留时间过长，将为您重新查询");//没能够从缓存中获取到购物车数据
	public final static ExceptionCode BOOKING_FAIL_FOR_CUSTOMER= new ExceptionCode("2012", "非常抱歉，预订出现异常，请重新查询预订！");//没能够从缓存中获取到购物车数据
	/*********************************************机酒动态打包ExceptionCode*******************************************************************/
	
	
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
	public final static ExceptionCode CALL_INTERFACE_ERROR= new ExceptionCode("FIT_ERROR","调用外部接口出现异常，调用时间~[%s]~，接口方法~[%s]~，异常信息~[%s]");
	public final static ExceptionCode SDP_AMOUNT_NOT_MATCH= new ExceptionCode("SDP_GOODS_005","计算金额时价格不匹配,传入商品id[%s],传入价格[%s]，实际商品Id[%s],实际价格[%s]，请仔细核对！");
	
	/*********************************************自主打包产品ExceptionCode*******************************************************************/

	
	public final static ExceptionCode END_TAG= new ExceptionCode("-1","异常枚举code结束TAG(非正常使用)");
	
	public ExceptionCode(String code, String messageFmt) {
		this.code = code;
		this.messageFmt = messageFmt;
	}

	/** 编码 */
	private String code;
	
	/** 消息格式字符串 */
	private String messageFmt;
	
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
	
}
