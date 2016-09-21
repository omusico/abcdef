package com.lvmama.lvf.common.exception;

/**
 * Created by leizhengwei
 * 2016/7/19
 * 13:53
 */
public class FitExceptionCode extends  ExceptionCode{


    public FitExceptionCode(String code, String messageFmt) {
        super(code, messageFmt);
    }

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
    public final static ExceptionCode GET_NO_FLIGHT_CALENDAR= new ExceptionCode("SDP_PRODUCT_004","自主打包产品Id[%s],出发地[%s],目的地[%s],从缓存服务器中获取机票低价日历信息失败!");
    public final static ExceptionCode GET_NO_CITY_GROUPS = new ExceptionCode("SDP_PRODUCT_005","自主打包产品Id[%s], 获取城市组信息失败!");

    public final static ExceptionCode GET_NO_SDP_HOTEL_COMBO= new ExceptionCode("SDP_GOODS_001","自主打包产品Id[%s],品类Id[%s],行程开始日期[%s],出发城市[%s],到达城市[%s]未获取到合适的酒店套餐！");
    public final static ExceptionCode GET_NO_SDP_LOCAL_TRIP= new ExceptionCode("SDP_GOODS_002","自主打包产品Id[%s],品类Id[%s],行程开始日期[%s],出发城市[%s],到达城市[%s]未获取到合适的当地游套餐！");
    public final static ExceptionCode GET_NO_SDP_HOTEL_GROUP= new ExceptionCode("SDP_GOODS_005","自主打包产品Id[%s],品类Id[%s],行程开始日期[%s],出发城市[%s],到达城市[%s]未获取到合适的打包酒店！");
    public final static ExceptionCode GET_NO_SDP_DEP_FLIGHT= new ExceptionCode("SDP_GOODS_003","自主打包产品Id[%s],品类Id[%s],行程开始日期[%s],出发城市[%s],到达城市[%s],未获取到合适的去程航班！");
    public final static ExceptionCode GET_NO_SDP_ARR_FLIGHT= new ExceptionCode("SDP_GOODS_004","自主打包产品Id[%s],品类Id[%s],行程开始日期[%s],出发城市[%s],到达城市[%s],未获取到合适的返程航班！");
    public final static ExceptionCode GET_NO_SDP_GOODS= new ExceptionCode("SDP_GOODS","自主打包产品Id[%s]暂时未找到合适的商品！");
    public final static ExceptionCode CALL_INTERFACE_ERROR= new ExceptionCode("FIT_ERROR","调用外部接口出现异常，调用时间~[%s]~，接口方法~[%s]~，异常信息~[%s]");
    public final static ExceptionCode SDP_AMOUNT_NOT_MATCH= new ExceptionCode("SDP_GOODS_005","计算金额时价格不匹配,传入商品id[%s],传入价格[%s]，实际商品Id[%s],实际价格[%s]，请仔细核对！");
    public final static ExceptionCode APP_NO_SHOPPING_UUID = new ExceptionCode("SDP_GOODS_006","请传入当前shoppingUUid!");
    public final static ExceptionCode APP_NO_BOOKING_SOURCE = new ExceptionCode("SDP_GOODS_007", "当前请求请传入BookingSource!");
    public final static ExceptionCode APP_PEOPLE_COUNT_NO_MATCH = new ExceptionCode("SDP_GOODS_008", "当前传入的成人、儿童总数不匹配,传入成人数[%s],传入儿童数[%s]，实际成人数[%s],实际儿童数[%s]，请仔细核对！");
    public final static ExceptionCode APP_GOODS_NO_MATCH = new ExceptionCode("SDP_GOODS_009", "当前传入的商品有不在可选择的商品范围之内,传入商品id:[%s]");
    public final static ExceptionCode APP_FLIGHT_NO_MATCH = new ExceptionCode("SDP_GOODS_010", "当前传入的航班的 航班号 或 出发日期 或 仓位码 不匹配,传入航班号为:[%s]");
    public final static ExceptionCode APP_TIME_NO_MATCH = new ExceptionCode("SDP_GOODS_010", "当前传入商品日期或日期格式不匹配,传入商品id[%s],传入日期为[%s]");

    public final static ExceptionCode FIT_PARAM_ERROR = new ExceptionCode("FIT_PARAM_ERROR", "传入参数[%s]:[%s]出错！");
    public final static ExceptionCode FIT_PERSON_PARAM_ERROR_1 = new ExceptionCode("FIT_PERSON_PARAM_ERROR_1", "成人数加儿童数不能大于9！");
    public final static ExceptionCode FIT_PERSON_PARAM_ERROR_2 = new ExceptionCode("FIT_PERSON_PARAM_ERROR_2", "每个成人最多携带2个儿童！");
    public final static ExceptionCode FIT_NO_FLIGHT_RESULT = new ExceptionCode("FIT_NO_FLIGHT_RESULT", "未搜索到相应的航班！出发日期日期[%s],出发城市[%s],到达城市[%s]");
    public final static ExceptionCode FIT_NO_HOTEL_RESULT = new ExceptionCode("FIT_NO_FLIGHT_RESULT", "未搜索到相应的酒店信息");
    
    /********************************************************顾客信息ExceptionCode*************************************************************************/
    public final static ExceptionCode FIT_PASSENGER_NOT_FOUND = new ExceptionCode("FIT_PASSENGER_NOT_FOUND", "顾客信息为空禁止下单！");
    public final static ExceptionCode FIT_PASSENGER_NOT_FULL = new ExceptionCode("FIT_PASSENGER_NOT_FULL", "顾客信息不全,请检查该顾客所有填写信息！");
}
