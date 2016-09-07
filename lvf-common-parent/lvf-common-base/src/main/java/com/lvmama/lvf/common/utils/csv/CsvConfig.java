package com.lvmama.lvf.common.utils.csv;

/**
 * CSV文件信息枚举
 * @author majun
 * @date 2015-6-3
 */
public abstract class CsvConfig{
	
	public static CsvConfig PAYMENT_LIST = new CsvConfig("支付监控列表"){
		@Override
		public String getHead() 
		{
			return "支付单号,支付类型,交易流水号,网关流水号,支付网关,支付金额,支付申请状态,订单支付回调状态,支付时间,对账流水号,机票订单号,VST订单号,VST支付ID,创建时间";
		}
	};
	
	public static CsvConfig REFUND_LIST = new CsvConfig("退款监控列表")
	{
		@Override
		public String getHead() 
		{
			return "退款单号,退款类型,交易流水号,网关流水号,退款网关,退款金额,退款申请状态,订单退款回调状态,退款时间,对账流水号,"
					+ "机票订单号,VST订单号,VST退款ID,创建时间";
		}
	};
	
	public static CsvConfig ORDER_LIST = new CsvConfig("订单列表")
	{
		@Override
		public String getHead() 
		{
			return "订单号,采购主单号,采购子单号,订单类型,供应商,供应商订单号,PNR,航程,航班号,乘机时间,预订人数,乘客类型,直减金额,应收款,支付方式,原始支付方式,联系人,登陆会员,"
				+ "下单时间,订单来源,当前状态";
		}
	};
	public static CsvConfig INSURANCE_ORDER_LIST = new CsvConfig("保单列表")
	{
		@Override
		public String getHead() 
		{
			return "订单号,票号,保单号,产品名称,产品类型,供应商,用户姓名,证件号码,创建时间,投保时间,"
				+ "生效时间,废保时间,订单保险状态,投保状态";
		}
	};
	public static CsvConfig TICKET_DETAIL_LIST = new CsvConfig("客票明细列表")
	{
		@Override
		public String getHead() 
		{
			return "票号,机票状态,PNR,航程,航班号,乘机时间,乘机人,乘客类型,应收款,支付方式,下单时间,渠道,供应商,订单号";
		}
	};
	public static CsvConfig REVENUE_REPORT_LIST = new CsvConfig("营收报表")
	{
		@Override
		public String getHead() 
		{
		    return "主订单号,订单号,采购主单号,采购子单号,收款流水号,收款流水金额,付款流水号,付款流水金额,订单类型,订位状态,支付状态,出票状态,"
		    		+ "下单时间,付款时间,处理时间,变更费用,补差金额,退票费用,供应商实退,退款流水号,退款金额,供应商,供应商订单号,销售渠道,"
                    + "登录用户,联系人,联系电话,原大编码,原小编码,大编码,小编码,航空公司,航班号,始发地,目的地,"
                    + "始发地代码,目的地代码,起飞时间,到达时间,订单人数,乘客类型,舱位,舱型等级,票面总价,总返点,总返现,"
                    + "优惠总金额,票面总结算价,调控比率,调控金额,平台调控,票面总销售价,总基建燃油,机票总结算价,机票总销售价,机票总利润,"
                    + "保险总结算价,保险总销售价,保险总利润,行程单配送费,直减金额,调控金额,应收款,应付款,总利润,支付方式,产品类型,政策ID,出票速度,是否邮寄,政策来源,达成率,已收客人数,已出票人数";
		}
	};
	
	public static CsvConfig SEARCH_RECORD_LIST = new CsvConfig("航班记录列表")
	{
		@Override
		public String getHead() 
		{
			return "索引,查询日期,查询时间,始发地 ,目的地,出发日期,查询结果,耗时,返回记录数,是否击中缓存,是否为航班查询,渠道,客户账号,客户码,客户名,客户IP";
		}
	};
	public static CsvConfig ORDER_REQ_RECORD_LIST = new CsvConfig("下单请求列表"){
		@Override
		public String getHead(){
			return " 下单请求时间 , traceNo,订单号,订单来源 , 预定结果 ,总耗时(ms), 出发车站, 到达车站 ,"
					+ "坐席 , 车次 , 发车时间, 车票实售价 , 保险销售价 , 优惠价格 , 供应商 , "
					+ "驴妈妈帐号名 ,乘客人数,账号类型, 联系人姓名,失败原因,分耗时 ";
		}
	};
	public static CsvConfig ORDER_INTENTION_RECORD_LIST = new CsvConfig("客户预订意向列表"){
		@Override
		public String getHead() {
			return " 航程类型,出发城市,到达城市,出发机场,到达机场,航空公司,航班号,舱位,舱位类型,起飞时间,客户账号,预定来源,创建时间";
		}
	};
	public static CsvConfig API_FLOW_LIST_COUNT = new CsvConfig("流量统计"){
		@Override
		public String getHead(){
			return "调用日期,调用次数,接口,成功次数,失败次数,失败率";
		}
	};
	public static CsvConfig FIT_SEARCH_RECORD_LIST = new CsvConfig("机酒搜索记录列表")
	{
		@Override
		public String getHead() 
		{
			return "indexId,traceId,出发城市,到达城市,去程时间,返程时间,入住城市,入住时间,离店时间,成人数,儿童数,查询结果,错误信息,耗费时间,查询时间,ip地址";
		}
	};
	
	private String fileName;
	
	public CsvConfig(String fileName) 
	{
		this.fileName = fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public abstract String getHead();
	
}
