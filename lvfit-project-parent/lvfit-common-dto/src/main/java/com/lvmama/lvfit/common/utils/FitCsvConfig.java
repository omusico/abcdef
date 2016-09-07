package com.lvmama.lvfit.common.utils;

import com.lvmama.lvf.common.utils.csv.CsvConfig;

/**
 * 打包报表头
 * @author leizhengwei
 *
 */
public  class FitCsvConfig {


	public final static CsvConfig SHOPPING_LIST = new CsvConfig(" 购物车列表")
	{
		@Override
		public String getHead() 
		{
			return "购物车编号,用户Id,用户名称,购买人名称,购买人手机号,出发城市,到达城市,入住城市,乘客类型,创建时间,vst订单状态";
		}
	};
	public final static CsvConfig ORDER_ALL_REPORT_LIST = new CsvConfig(" 机酒订单报表列表")
	{
		@Override
		public String getHead() 	{
			return "订单号,VST主单号,产品名称,预订人数,下单时间,订单状态,支付状态,审核状态,支付方式,订单来源,订单金额,产品品类";
		}
	};
	public final static CsvConfig ORDER_FLIGHT_REPORT_LIST = new CsvConfig(" 机酒订单机票报表列表")
	{
		@Override
		public String getHead() 
		{
			return "机酒主单号,VST主单号,机酒子单号,VST子单号,订单类型,  供应商,供应商订单号,PNR, 航程,航班号,乘机时间,预订人数,应收款,支付方式,联系人,下单时间,订单来源,当前状态";
		}
	};
	public final static CsvConfig ORDER_HOTEL_REPORT_LIST = new CsvConfig(" 机酒订单酒店报表列表")
	{
		@Override
		public String getHead() 
		{
			return "机酒主单号,VST主单号,VST子单号,入住城市,酒店名称,房型信息,间数,预订人数,支付金额,支付方式,联系人,下单时间,订单来源";
		}

	};
	public final static CsvConfig FIT_SEARCH_RECORD_LIST = new CsvConfig("机酒搜索记录列表")
	{
		@Override
		public String getHead() 
		{
			return "indexId,traceId,出发城市,到达城市,去程时间,返程时间,入住城市,入住时间,离店时间,成人数,儿童数,查询结果,错误信息,耗费时间,查询时间,ip地址";
		}
	};
	
	public static CsvConfig FIT_REVENUE_REPORT_LIST = new CsvConfig("机酒营收报表")
	{
		@Override
		public String getHead() 
		{
		    return "主订单号,vst订单号,订单金额,收款流水号,收款流水金额,付款流水号,付款流水金额,订单类型,支付状态,下单时间,付款时间";
		}
	};
	
	public static CsvConfig FIT_PRODUCT_REPORT_LIST = new CsvConfig("交通+X产品报表")
	{
		@Override
		public String getHead() 
		{
		    return "产品ID,产品名称,产品经理,产品状态,是否可售,被打包产品Id,是否为多出发地,加价金额,产品品类,创建时间";
		}
	};
			
}
