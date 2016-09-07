package com.lvmama.lvf.common.client.path;

import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;

public enum BatchClientPath {

    SYNC_FLIGHT_INFO_FROM_SUP(Path.SYNC_FLIGHT_INFO_FROM_SUP, "从供应商同步航班信息"),
    SYNC_FLIGHT_INFO_TO_SOLR(Path.SYNC_FLIGHT_INFO_TO_SOLR, "从供应商同步航班信息"),
    
    
    INIT_TO_SOLR(Path.INIT_TO_SOLR, "同步航班缓存"),
    
    SYNC_TO_SOLR(Path.SYNC_TO_SOLR, "同步航班信息"),
    SYNC_TO_SOLR_ALL(Path.SYNC_TO_SOLR_ALL, "全量同步航班信息"),
//  SYNC_TO_SOLR_UPDATE(Path.SYNC_TO_SOLR_UPDATE, "增量同步航班信息"),
    
    SYNC_ONE_POLICY(Path.SYNC_ONE_POLICY, "同步单条政策"),
    SYNC_ALL_POLICY(Path.SYNC_ALL_POLICY, "同步全取政策"),
    SYNC_UPDATE_POLICY(Path.SYNC_UPDATE_POLICY, "同步更新政策"),
    
    CREATE_BATCH_SETTLEMENT(Path.CREATE_BATCH_SETTLEMENT, "批量结算"),
    SYNC_VST_DATA(Path.SYNC_VST_DATA, "同步VST数据"),
    RESET_SYNC_VST_FLAG(Path.RESET_SYNC_VST_FLAG, "重置VST同步标识"),
    SYNC_VST_PRODUCT_DATA(Path.SYNC_VST_PRODUCT_DATA,"机票端，同步vst产品航线数据"),
    SYNC_VST_PRODUCT_BRANCH_DATA(Path.SYNC_VST_PRODUCT_BRANCH_DATA,"机票端，同步vst产品规格数据"),
    SYNC_BIZ_DICT_PROP_ALL(Path.SYNC_BIZ_DICT_PROP_ALL,"同步VST字典属性"),
    
    CANCEL_TIMOUT_ORDER(Path.CANCEL_TIMOUT_ORDER, "30分钟内未支付取消订单"),
    CANCELLED_ORDER_AUTO_REFUND(Path.CANCELLED_ORDER_AUTO_REFUND, "非工作时间内,将已取消的订单自动退款给客人"),
    PUSH_DATA_TO_CPS(Path.PUSH_DATA_TO_CPS,"定时推送订单信息到CPS，并更新本地流水信息"),
    INIT_TO_SOLR_BY_PARAM(Path.INIT_TO_SOLR_BY_PARAM,"根据参数初始化solr"),
    
    /** Batch落地相关路径配置START */
    FLIGHT_PRICE_INVENTORY_SYNC(Path.FLIGHT_PRICE_INVENTORY_SYNC, "同步运价库存信息"),
    FLIGHT_SYNC(Path.FLIGHT_SYNC, "原子化同步航班信息"),
    FLIGHT_BASE_INFO_SYNC_FOR_TASK(Path.FLIGHT_BASE_INFO_SYNC_FOR_TASK, "通过51同步航班基本信息与每日航班信息(定时任务的方式缓存信息)"),
    FLIGHT_CTRIP_INFO_SYNC_FOR_TASK (Path.FLIGHT_CTRIP_INFO_SYNC_FOR_TASK,"通过携程同步航班信息（定时任务的方式缓存信息）"),
    
    /** CTRIP */
    FLIGHT_INFO_CTRIP_SYNC(Path.FLIGHT_INFO_CTRIP_SYNC, "Ctrip同步航班信息"),
    FLIGHT_SEAT_CTRIP_SYNC(Path.FLIGHT_SEAT_CTRIP_SYNC, "Ctrip同步舱位信息"),
    FLIGHT_DAILY_CTRIP_SYNC(Path.FLIGHT_DAILY_CTRIP_SYNC, "Ctrip同步每日航班信息"),
    FLIGHT_PRICE_INFO_CTRIP_SYNC(Path.FLIGHT_PRICE_INFO_CTRIP_SYNC, "Ctrip同步航班运价基本信息"),
    FLIGHT_PRICE_POLICY_CTRIP_SYNC(Path.FLIGHT_PRICE_POLICY_CTRIP_SYNC, "Ctrip同步航班运价政策信息"),
    FLIGHT_PRICE_TICKET_RULE_CTRIP_SYNC(Path.FLIGHT_PRICE_TICKET_RULE_CTRIP_SYNC, "Ctrip同步航班客规信息"),
    
    /** 51Book */
    FLIGHT_INFO_51BOOK_SYNC(Path.FLIGHT_INFO_51BOOK_SYNC, "51book同步航班信息"),
    FLIGHT_SEAT_51BOOK_SYNC(Path.FLIGHT_SEAT_51BOOK_SYNC, "51book同步舱位信息"),
    FLIGHT_DAILY_51BOOK_SYNC(Path.FLIGHT_DAILY_51BOOK_SYNC, "51book同步每日航班信息"),
    FLIGHT_PRICE_INFO_51BOOK_SYNC(Path.FLIGHT_PRICE_INFO_51BOOK_SYNC, "51book同步航班运价基本信息"),
    FLIGHT_PRICE_POLICY_51BOOK_SYNC(Path.FLIGHT_PRICE_POLICY_51BOOK_SYNC, "51Book同步航班运价政策信息"),
    
    /** Lvmama */
    FLIGHT_INFO_LVMAMA_SYNC(Path.FLIGHT_INFO_LVMAMA_SYNC, "Lvmama同步航班信息"),
    FLIGHT_SEAT_LVMAMA_SYNC(Path.FLIGHT_SEAT_LVMAMA_SYNC, "Lvmama同步舱位信息"),
    FLIGHT_DAILY_LVMAMA_SYNC(Path.FLIGHT_DAILY_LVMAMA_SYNC, "Lvmama同步每日航班信息"),
    FLIGHT_PRICE_INFO_LVMAMA_SYNC(Path.FLIGHT_PRICE_INFO_LVMAMA_SYNC, "Lvmama同步航班运价基本信息"),
    FLIGHT_PRICE_POLICY_LVMAMA_SYNC(Path.FLIGHT_PRICE_POLICY_LVMAMA_SYNC, "Lvmama同步航班运价政策信息"),
    
    /** Lvmama_domestic */
    FLIGHT_INFO_LVMAMA_DOMESTIC_SYNC(Path.FLIGHT_INFO_LVMAMA_DOMESTIC_SYNC, "Lvmama_domestic同步航班信息"),
    FLIGHT_SEAT_LVMAMA_DOMESTIC_SYNC(Path.FLIGHT_SEAT_LVMAMA_DOMESTIC_SYNC, "Lvmama_domestic同步舱位信息"),
    FLIGHT_DAILY_LVMAMA_DOMESTIC_SYNC(Path.FLIGHT_DAILY_LVMAMA_DOMESTIC_SYNC, "Lvmama_domestic同步每日航班信息"),
    FLIGHT_PRICE_INFO_LVMAMA_DOMESTIC_SYNC(Path.FLIGHT_PRICE_INFO_LVMAMA_DOMESTIC_SYNC, "Lvmama_domestic同步航班运价基本信息"),
    FLIGHT_PRICE_POLICY_LVMAMA_DOMESTIC_SYNC(Path.FLIGHT_PRICE_POLICY_LVMAMA_DOMESTIC_SYNC, "Lvmama_domestic同步航班运价政策信息"),
    
    /** 会员成长值计算接口 */
    QUERY_FLIGHT_NORMAL_ORDER_LIST(Path.QUERY_FLIGHT_NORMAL_ORDER_LIST, "分页订单详情"),
    QUERY_FLIGHT_RTVT_ORDER_LIST(Path.QUERY_FLIGHT_RTVT_ORDER_LIST, "分页退票订单详情"),
    QUERY_FLIGHT_CTMT_ORDER_LIST(Path.QUERY_FLIGHT_CTMT_ORDER_LIST, "分页改期订单详情"),
    QUERY_FLIGHT_NORMAL_ORDER_LIST_COUNT(Path.QUERY_FLIGHT_NORMAL_ORDER_LIST_COUNT, "订单总数"),
    QUERY_FLIGHT_RTVT_ORDER_LIST_COUNT(Path.QUERY_FLIGHT_RTVT_ORDER_LIST_COUNT, "退票订单总数"),
    QUERY_FLIGHT_CTMT_ORDER_LIST_COUNT(Path.QUERY_FLIGHT_CTMT_ORDER_LIST_COUNT, "改期订单总数"),
    
    /**根据航线同步VST数据*/
    SYNC_VST_DATA_BY_AIRLINE(Path.SYNC_VST_DATA_BY_AIRLINE,"根据航线同步VST数据"),
    /** Batch落地相关路径配置END */
    
    /** 同步供应商订单PNR信息 */
    SYNC_PNR_INFO(Path.SYNC_PNR_INFO,"同步供应商订单PNR信息"),
    /** 同步供应商订单客票信息 */
    SYNC_TICKET_INFO(Path.SYNC_TICKET_INFO,"同步供应商订单客票信息 "),
    /** 删除过期机票运价数据 */
    DELETE_OUT_OF_DATE_PRICE_DATA(Path.DELETE_OUT_OF_DATE_PRICE_DATA,"删除过期机票运价数据"),
    /** 缓存航班低价日历数据  */
    CACHE_FLIGHT_CALENDAR(Path.CACHE_FLIGHT_CALENDAR,"缓存航班低价日历数据"),
    /** 批量缓存航班低价日历数据  */
    BATCH_CACHE_FLIGHT_CALENDAR(Path.BATCH_CACHE_FLIGHT_CALENDAR,"批量缓存航班低价日历数据"),
    /** 同步支付给供应商 */
    SYNC_SUPP_PAY_INFO(Path.SYNC_SUPP_PAY_INFO,"同步支付给供应商信息"),
    /** 订单导入 */
    SAVE_ORDER_IMPORT(Path.SAVE_ORDER_IMPORT,"订单导入");
    public String path;
    public String cnName;

    public static class Path{
        public final static String basePath="batch";
        public final static String ctripPath="/ctrip";
        public final static String five1BookPath="/five1Book";
        public final static String lvmamaPath="/lvmama";
        public final static String lvmamaDomesticPath="/lvmamaDomestic";
        public final static String policyPath="/sync/policysync/";
        public final static String SYNC_FLIGHT_INFO_FROM_SUP=basePath+"/flightinfo/sync/inithotline/";
        public final static String SYNC_FLIGHT_INFO_TO_SOLR=basePath+"/flightinfo/syncinfotosolrbyquery/";
        
        public final static String INIT_TO_SOLR=basePath+"/flightinfo/init2solr";
        public final static String INIT_TO_SOLR_BY_PARAM=basePath+"/flightinfo/init2solr/{initCitys}";
        
        public final static String SYNC_TO_SOLR=basePath+"/flightinfo/synctosolr";
        public final static String SYNC_TO_SOLR_ALL=basePath+"/flightinfo/synctosolrall";
        public final static String SYNC_TO_SOLR_UPDATE=basePath+"/flightinfo/synctosolrupdate";
        
        public final static String SYNC_ONE_POLICY= basePath + policyPath + "syncOnePolicy/{suppPolicyNo}";
        public final static String SYNC_ALL_POLICY= basePath + policyPath + "syncAllPolicy";
        public final static String SYNC_UPDATE_POLICY= basePath + policyPath + "syncUpdatedPolicy";
        
        public final static String CREATE_BATCH_SETTLEMENT= basePath + "createBatchSettlement";
        public final static String CALCULATOR_RISK_POLICYINFO= basePath + "calculatorRiskPolicyInfo";
        public final static String SYNC_VST_DATA = basePath + "/vst/syncData/{beginDate}/{endDate}";
        public final static String SYNC_BIZ_DICT_PROP_ALL = basePath + "/vst/syncBizDictPropAll";
        public final static String RESET_SYNC_VST_FLAG = basePath + "/vst/syncData/resetFlag/{syncFlag}";
        public final static String SYNC_VST_PRODUCT_DATA = basePath + "/vst/syncVSTProductData/{beginDate}/{endDate}";
        public final static String SYNC_VST_PRODUCT_BRANCH_DATA = basePath + "/vst/syncVSTProductBranchData";
        public final static String CANCEL_TIMOUT_ORDER = basePath + "/cancelTimoutOrder";
        public final static String CANCELLED_ORDER_AUTO_REFUND = basePath + "/cancelledOrderAutoRefund";
        //
        public final static String PUSH_DATA_TO_CPS = basePath + "/pushDataToCPS";
        /** Batch落地相关路径配置START */
        public final static String FLIGHT_PRICE_INVENTORY_SYNC = basePath + "/flightPriceInventorySync";
        public final static String FLIGHT_SYNC = basePath + "/flightSync";
        public final static String FLIGHT_BASE_INFO_SYNC_FOR_TASK = basePath + "/flightBaseInfoSyncForTask";
        public final static String FLIGHT_CTRIP_INFO_SYNC_FOR_TASK = basePath + "/flightCtripInfoSyncForTask";
        
        
        /** CTRIP */
        public final static String FLIGHT_INFO_CTRIP_SYNC = basePath + ctripPath + "/flightInfoCtripSync";
        public final static String FLIGHT_SEAT_CTRIP_SYNC = basePath + ctripPath + "/flightSeatCtripSync";
        public final static String FLIGHT_DAILY_CTRIP_SYNC = basePath + ctripPath + "/flightDailyCtripSync";
        public final static String FLIGHT_PRICE_INFO_CTRIP_SYNC = basePath + ctripPath + "/flightPriceInfoSync";
        public final static String FLIGHT_PRICE_POLICY_CTRIP_SYNC = basePath + ctripPath + "/flightPricePolicyCtripSync";
        public final static String FLIGHT_PRICE_TICKET_RULE_CTRIP_SYNC = basePath + ctripPath + "/flightPriceTicketRuleCtripSync";

        /** 51Book */
        public final static String FLIGHT_INFO_51BOOK_SYNC = basePath + five1BookPath + "/flightInfo51BookSync";
        public final static String FLIGHT_SEAT_51BOOK_SYNC = basePath + five1BookPath + "/flightSeat51BookSync";
        public final static String FLIGHT_DAILY_51BOOK_SYNC = basePath + five1BookPath + "/flightDaily51BookSync";
        public final static String FLIGHT_PRICE_INFO_51BOOK_SYNC = basePath + five1BookPath + "/flightPriceInfoSync";
        public final static String FLIGHT_PRICE_POLICY_51BOOK_SYNC = basePath + five1BookPath + "/flightPricePolicy51BookSync";
        
        /** Lvmama */
        public final static String FLIGHT_INFO_LVMAMA_SYNC = basePath + lvmamaPath + "/flightInfoLvmamaSync";
        public final static String FLIGHT_SEAT_LVMAMA_SYNC = basePath + lvmamaPath + "/flightSeatLvmamaSync";
        public final static String FLIGHT_DAILY_LVMAMA_SYNC = basePath + lvmamaPath + "/flightDailyLvmamaSync";
        public final static String FLIGHT_PRICE_INFO_LVMAMA_SYNC = basePath + lvmamaPath + "/flightPriceInfoSync";
        public final static String FLIGHT_PRICE_POLICY_LVMAMA_SYNC = basePath + lvmamaPath + "/flightPricePolicyLvmamaSync";
        
        /** Lvmama */
        public final static String FLIGHT_INFO_LVMAMA_DOMESTIC_SYNC = basePath + lvmamaDomesticPath + "/flightInfoLvmamaDomesticSync";
        public final static String FLIGHT_SEAT_LVMAMA_DOMESTIC_SYNC = basePath + lvmamaDomesticPath + "/flightSeatLvmamaDomesticSync";
        public final static String FLIGHT_DAILY_LVMAMA_DOMESTIC_SYNC = basePath + lvmamaDomesticPath + "/flightDailyLvmamaDomesticSync";
        public final static String FLIGHT_PRICE_INFO_LVMAMA_DOMESTIC_SYNC = basePath + lvmamaDomesticPath + "/flightPriceInfoLvmamaDomesticSync";
        public final static String FLIGHT_PRICE_POLICY_LVMAMA_DOMESTIC_SYNC = basePath + lvmamaDomesticPath + "/flightPricePolicyLvmamaDomesticSync";
        
        /** 会员成长值计算接口 */
        public final static String QUERY_FLIGHT_NORMAL_ORDER_LIST = basePath + "/queryFlightNormalOrderList";
        public final static String QUERY_FLIGHT_RTVT_ORDER_LIST = basePath + "/queryFlightRTVTOrderList";
        public final static String QUERY_FLIGHT_CTMT_ORDER_LIST = basePath + "/queryFlightCTMTOrderList";
        public final static String QUERY_FLIGHT_NORMAL_ORDER_LIST_COUNT = basePath + "/queryFlightNormalOrderListCount";
        public final static String QUERY_FLIGHT_RTVT_ORDER_LIST_COUNT = basePath + "/queryFlightRTVTOrderListCount";
        public final static String QUERY_FLIGHT_CTMT_ORDER_LIST_COUNT = basePath + "/queryFlightCTMTOrderListCount";
        
        /** 根据航线同步vst数据 */
        public final static String SYNC_VST_DATA_BY_AIRLINE = basePath + "/vst/syncVstDataByAirline";
        /** Batch落地相关路径配置END */
        
        /** 同步供应商订单PNR信息 */
        public final static String SYNC_PNR_INFO = basePath + "/syncPnrInfo";
        /** 同步供应商订单客票信息 */
        public final static String SYNC_TICKET_INFO = basePath + "/syncTicketInfo";
        
        /** 删除过期机票运价数据 */
        public final static String DELETE_OUT_OF_DATE_PRICE_DATA = basePath + "/deleteOutOfDatePriceData";
        
        /** 同步主站退款流水号  */
        public final static String SYNC_VST_REFUNDMENT_SERIAL_NO = basePath + "/vst/syncVstRefundmentSerialNo";

        
        /** 同步供应商支付信息 */
        public final static String SYNC_SUPP_PAY_INFO = basePath + "/syncSuppPayInfo";

        
        /** 缓存航班低价日历数据  */
        public final static String CACHE_FLIGHT_CALENDAR = basePath + "/flightInfo/cacheFlightCalendar";
        
        /** 批量缓存航班低价日历数据  */
        public final static String BATCH_CACHE_FLIGHT_CALENDAR = basePath + "/flightInfo/batchCacheFlightCalendar";
        
        /** 批量更新航班低价日历数据到solr  */
        public final static String BATCH_SOLR_FLIGHT_CALENDAR = basePath + "/flightInfo/batchSolrFlightCalendar";
        
        /** 营收报表同步数据  */
        public final static String SYNC_REVENUE_REPROT_DATA = basePath + "/flightInfo/syncRevenueReportData/{hours}";

        /** 营收报表同步数据根据创建时间区间  */
        public final static String SYNC_REVENUE_REPROT_DATA_BY_STARTDATE_ENDDATE = basePath + "/flightInfo/syncRevenueReportData/{startDate}/{endDate}";
        
        /**vst/fit锁仓失败自动下单  */
        public final static String SYNC_VST_SUPPLEORDER_ORDER = basePath + "/suppleorder/{minutes}";

        /** 订单导入 */
        public final static String SAVE_ORDER_IMPORT = basePath + "/order/import/saveOrders";
    }
    
    private BatchClientPath(String path, String cnName) {
        this.path = path;
        this.cnName = cnName;
    }
    
    public String url(String baseUrl){
		if(!baseUrl.contains("http")){
			baseUrl = CustomizedPropertyPlaceholderConfigurer.getContextProperty(baseUrl);
		}
    	
        if(baseUrl.endsWith("/")){
            return baseUrl+this.path;
        }
        return baseUrl+"/" +this.path;
    }
    
    public String url(String baseUrl,Object... args){
        String url = url(baseUrl);
        String pat="\\{\\w*\\}";
        return String.format(url.replaceAll(pat,"%s"),args);
    }
    
}
