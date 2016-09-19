package com.lvmama.lvf.common.dto.enums;

public enum InterfaceKey {
	ALL("全部"),
	SINGLE("单接口"),
	UNKNOW("未知接口"),
	/****************517na**/
	Five17Na_FlightRefundOrder("517Na国内机票退票申请"),
	Five17Na_NewFlightRefundOrder("517Na国内机票退票申请新接口"),
	Five17Na_FlightPayOrder("517Na国内机票支付新接口"),
	Five17Na_FlightPolicyQuery("517Na国内机票获取航班政策接口"),
	Five17Na_FlightCreateOrder("517Na国内机票创单接口"),
	Five17Na_FlightQueryOrderDetail("517Na国内机票订单详情查询接口"),
	Five17Na_FlightCancelPnr("517Na国内机票取消pnr接口"),
	Five17Na_FlightPolicyPushSync_Full("517Na国内机票政策全量推送接口"),
	Five17Na_FlightPolicyPushSync_Add("517Na国内机票政策增量推送接口"),
	/****************51book**/
	GetAvailableFlightWithPriceAndCommisionServiceImpl_1_0Service("AV3航班查询（含票面价、返佣)"),
	AVFlightNOServiceImpl_1_0Service("AV4根据航班号查询座位情况 "),
	CreateOrderByPassengerServiceImpl_1_0Service("CO1根据旅客信息创建PNR及订单"),
	GetDailyLowestPriceServiceImpl_1_0Service("FD2实时获取每日最低价"),
	CancelOrderServiceImpl_1_0Service("OM2订单取消"),
	GetOrderByOrderNoServiceImpl_1_0Service("OM3订单详情查询"),
	PayServiceImpl_1_0Service("PA1订单自动支付"),
	GetPolicyServiceImpl_1_0Service("PQ1全取政策"),
	SyncPolicyServiceImpl_1_0Service("PQ2同步政策"),
	GetPolicyByIdServiceImpl_1_0Service("PQ3根据政策ID获取政策（校验政策）"),
	GetPolicyAndFareByFlightsServiceImpl_1_0Service("PQ5根据航班列表舱位出发日期等查询政策及运价"),
	GetChildPolicyAndFlightServiceImpl_1_0Service("PQ7根据航班舱位出发日期实时匹配儿童政策"),
	ApplyPolicyOrderRefundServiceImpl_1_0Service("RC1订单退废票申请"),
	GetRefundDetailServiceImpl_1_0Service("RC2订单退票详情查询"),
	GetModifyAndRefundStipulateServiceImpl_1_0Service("RC5根据航空公司、舱位获取退改签规定"),
	GetModifyAndRefundStipulatesServiceImpl_1_0Service("RC6获取所有退改签规定"),
	/****************unionlife（保险）**/
	HesitateCancelInsuranceUnionLifeService("UnionLife废保"),
	SingleInsuringInsuranceUnionLifeService("UnionLife投保"),
	/****************众安（保险）**/
	HesitateCancelInsuranceZhongAnService("众安废保"),
	SingleInsuringInsuranceZhongAnService("众安投保"),
	GetOrderUndWrResultZhongAnService("众安通知"),
	
	/****************携程**/
	OAE_FlightSearch("携程国内机票航班查询"),
	OAE_FlightVerify("携程国内机票验舱验价"),
	OAE_FlightSaveOrder("携程国内机票生成订单"),
	CheckOrderAutobookResult("携程国内机票订位结果验证查询"),
	OAE_ViewOrderListDetails("携程国内机票订单详情"),
	Common_FlightAlipayV1("携程国内机票支付/改签升舱支付接口"),
	OpenCancelOrder("携程国内机票取消订单接口"),
	FlightReviseCondition("携程国内机票可退票/改签查询"),
	RescheduleSearch("携程国内机票可改航班查询接口"),
	FlightRebookApplication("携程国内机票改签申请接口"),
	FlightRefundOrder("携程国内机票退票申请"),
	FlightQueryTicketingOrder("携程国内机票退票/改签明细查询"),
	
	/****************易思凯ABE**/
	ABE_CreatePNR("ABE创建旅客订座记录"),
	ABE_PATByFlights("ABE国内运价自动计算"),
	ABE_ETDZ("ABE电子客票出票处理"),
	ABE_RTPNR("ABE提取旅客订座记录(PNR)"),
	ABE_XEPNR("ABE取消旅客订座记录"),
	ABE_DETR("ABE提取电子客票记录"),
	ABE_ETRY("ABE电子票重出功能"),
	
	/****************敬众信息JZINFO**/
	JZINFO_AV("JZINFO航班查询"),
	JZINFO_FD("JZINFO公布运价获取"),
	JZINFO_NFD("JZINFO私有运价获取"),
	JZINFO_AVETIME("JZINFO查询航班可销售信息"),

	/****************VST机票对接**/
	ChangeTraffic("VST更换交通查询航班"),
    QueryGroupLowerSalePrice("VST机票对接查询最低价"),
    QueryFlightNoVoListByDateAndBranch("VST机票对接查询商品"),
	QueryIsGoodsAvailable("VST查询商品是否可售"),
	CancelFlightOrder("VST取消机票订单"),
	PayFlightOrder("VST支付通知"),
	BookingOrderAsync("VST异步锁舱"),
	
   /***************火车票 Interface Key ******start*/
	  //供应商
    GetTimetable("火车票向赶火车查询时刻表接口"),//供应商时刻表地址-timetableurl
    FindTrainsByCondition("火车票向赶火车查询站站车次(包括余票)"),//供应商站站地址-trainsServiceUrl
    FindMoreTicketByCondition("火车票向赶火车查询站站余票"),//供应商余票地址-trainsServiceMoreTicketUrl
    CommitTrainOrder("火车票本地提交提交订单"),
    CommitSuppOrder("火车票向赶火车提交订单"),//供应商提交订单地址-commitThridOrderUrl
    ValidateCommitSuppOrder("验证向赶火车提交订单是否成功"),
    CallbackPayOrder("火车票订单向主站支付平台支付回调"),
    CallbackOnDrawOrder("火车票订单赶火车出票通知回调"),
    SearchOrderDetail("火车票本地查询订单信息"),
    SearchRefundOrderDetail("火车票本地查询可退票订单信息"),
    RefundTicket("火车票向赶火车请求退票"),//供应商退票地址-refundOrderUrl
    CallbackOnRefundOrder("火车票订单赶火车退票通知回调"),

	// 火车票供应商(大拓)
    CommitOrderToDaTuo("火车票提交订单接口(大拓)"),
	GetTimetableToDaTuo("火车票车次余票票价查询接口(大拓)"),
	CancelOrderToDaTuo("火车票取消订单接口(大拓)"),
	ConfirmTicketToDaTuo("火车票确认出票接口(大拓)"),
	ECHOConfirmTicketToDaTuo("火车票重复发起确认出票接口(大拓)"),
	RefundTicketToDaTuo("火车票申请退票接口(大拓)"),
	GetStationToDaTuo("火车票列车次经历站点查询接口(大拓)"),
	CommitOrderCallBackToDaTuo("火车票提交订单回调接口(大拓)"),
	TrainOfflineReturnMoneyNoticeFromDaTuo("火车票线下退款通知回调接口(大拓)"),
	TrainQueryPassengersAsyncFromDaTuo("火车票查询常用联系人异步回调接口(大拓)"),
	CancelOrderCallBackToDaTuo("火车票取消订单回调接口(大拓)"),
	ConfirmTicketCallBackToDaTuo("火车票确认出票回调接口(大拓)"),
	RefundTicketCallBackToDaTuo("火车票申请退票回调接口(大拓)"),
	QueryMoneyToDaTuo("火车票账户余额查询接口(大拓)"),
	QueryMoneyLogToDaTuo("火车票账户资金明细查询接口(大拓)"),
	DeletePassengerDaTuo("火车票删除常用联系人信息(大拓)"),
	UpdatePassengerDaTuo("火车票修改常用联系人信息(大拓)"),
	QueryPassengersDaTuo("火车票获取常用联系人信息(大拓)"),
	AddPassengersDaTuo("火车票添加常用联系人信息(大拓)"),
	CheckAccountDaTuo("火车票账号核验(大拓)"),
	TrainCheckAccountAsyncFromDaTuo("火车票账户核验异步回调接口(大拓)"),
	TrainOrderNotifyStateToCPS("火车票同步状态到CPS(CPS)"),

	//主站
	SendRefund("火车票支付平台发起退款(技术平台)"),//主站支付退款-requestRefundUrl
    GetPayResult("火车票支付平台获取支付结果(技术平台)"),//主站支付查询-payResultUrl
    GetPayPrice("火车票支付平台获取支付金额(技术平台)"),//主站支付查询-payResultUrl
    SendSettlement_OP("火车票出票结算(技术平台)"),//主站出票结算-settlement.requestUrl
    SendSettlement_RT("火车票退票结算(技术平台)"),//主站退票结算-settlementRefund.requestUrl
    CommitInsuranceOrder("火车票提交保险订单(技术平台)"),//提交保险订单到主站保险createInsuranceOrder
    CancelInsuranceOrder("火车票退票取消保险订单(技术平台)"),//火车票向主站退票取消保险订单cancelInsuranceOrder
    PayInsuranceOrder("火车票支付保险订单(技术平台)"),//火车票向主站支付保险订单setInsuranceOrderPaid
	SendSettlement("火车票订单结算(技术平台)"),
	SyncOrderToVst("火车票订单同步到vst状态(技术平台)"),
	
	QUERYCHEZHANTOCTRIP("火车票查询车站信息接口(携程)"),
	QUERYYUPIAOTOCTRIP("火车票查询余票信息接口(携程)"),
	QUERYZHANZHANTOCTRIP("火车票查询站站信息接口(携程)"),
	QUERYCHECITOCTRIP("火车票查询车次信息接口(携程)"),
	TRAINBOOKINGORDERCTRIP("火车票预订订单接口(携程)"),
	TRAINCANCELORDERCTRIP("火车票取消订单接口(携程)"),
	TRAINPAYORDERCTRIP("火车票支付订单接口(携程)"),
	TRAINREFUNDTICKETCTRIP("火车票退票接口(携程)"),
	TRAINTICKETTOCTRIP("火车票有票接口(携程)"),
	TRAINNOTICKETTOCTRIP("火车票无票接口(携程)"),
	TRAINLOCKORDERCTRIP("火车票锁单回调接口(携程)"),
	TRAINREFUNDORDERCTRIP("火车票退款回调接口(携程)"),
	
	 /***************火车票 Interface Key ******End*/
	
	/**************************************Fit Interface Key*******************************************************/
	
	
	APP_FIT_SEARCHFLIGHTCITYINFO("APP机酒查询城市信息"),
	APP_FIT_SEARCHGOODSINFO("APP机酒产品详情页查询默认商品信息"),
	APP_FIT_CHANGEFLIGHTINFO("APP机酒查询航班"),
	APP_FIT_CHANGEHOTELINFO("APP机酒查询酒店"),
	APP_FIT_CALCULATAMOUNT("APP机酒算价"),
	APP_FIT_BOOKING("APP机酒下单"),
	
	APP_FIT_SDP_SEARCHCALENDARINFO("APP交通+x查询低价日历"),
	APP_FIT_SDP_GETGOODSINFO("APP交通+x查询商品信息"),
	APP_FIT_SDP_CALCULATAMOUNT("APP交通+x算价"),
	APP_FIT_SDP_BOOKING("APP交通+x下单"),
	
	
	SearchHotelFromVst("机+酒从vst获取酒店信息"),
    SearchFlight("机+酒从机票侧获取航班数据"),
    SearchSpotTicketFormVst("机+酒从vst获取景点门票信息"),
    SearchInsuranceInfoFromVst("机+酒从vst获取保险信息"),
    SearchSdpProductFromVst("超级自由行从vst获取产品信息"),
    SearchSdpGoodsFromVst("超级自由行从vst获取商品信息"),
    SearchSdpInstalmentFromVst("超级自由行从vst获取产品分期利率"),
    FIT_BOOKING_VST("交通+X-vst下单"),
    FIT_SDP_INDEX_PUSH("超级自由行索引推送"),
    FIT_BOOKING_FLIGHT("交通+X-机票下单"),
    FIT_AMOUNTCALCULATE_FLIGHT("交通+X-机票算价"),
    SearchSdpProductGroupCalendarInfoFromVst("超级自由行从vst获取被打包产品的价格日历");
	/*********************************************************************************************/
	
	
	private InterfaceKey(String cnName) {
		this.cnName = cnName;
	}

	private String cnName;

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	
	public static InterfaceKey valueByCode(String code){
		try{
			return InterfaceKey.valueOf(code);
		}catch(Exception ex){
		}
		return InterfaceKey.UNKNOW;
	}

}
