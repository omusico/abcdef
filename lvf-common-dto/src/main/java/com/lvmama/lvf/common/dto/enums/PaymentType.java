package com.lvmama.lvf.common.dto.enums;

/**
 * 支付方式
 * @author lven
 *
 */
public enum PaymentType {
//	ALIPAY("支付宝 ",PayType.ONLINE),
	PAY("支付宝 ",PayType.ONLINE),
	WEIXIN("微信",PayType.MOBILE),
	BAIDU("百度支付",PayType.ONLINE),
	UNION_PAY("银联",PayType.ONLINE),
	POS("POS",PayType.POS),
	POINT("积分",PayType.PHONE),
	CASH("现金",PayType.CASH),
	COUPON("抵用劵",PayType.COUPON),
    
	YEE("易宝电话",PayType.PHONE),
	HUNDRED("百付电话",PayType.PHONE),
	OFFLINE_CARD("线下拉卡",PayType.CARD),
    KENDRION("彬德POS",PayType.POS),
    DUMMY("虚拟",PayType.DUMMY),
	VST_PAY("打包主单支付",PayType.DUMMY),
	SALES_PAY("分销支付",PayType.DUMMY),
	LVMAMA_TRIP("差旅支付",PayType.DUMMY),
    OTHER("其他",PayType.OTHER),

	//新增PC端支付方式(来源于主站)   2016-03-17
    BOB_BANK("北京银行",PayType.ONLINE),
    CMBC_BANK("民生银行",PayType.ONLINE),
    TENPAY_DIRECT("财付通快捷",PayType.ONLINE),
    ICBC("工商银行",PayType.ONLINE),
    CCB_BANK("中国建设银行",PayType.ONLINE),
    COMM("交通银行",PayType.ONLINE),
    PAB_BANK("平安银行",PayType.ONLINE),
    PSBC_BANK("中国邮政储蓄银行",PayType.ONLINE),
    UNIONPAY_DIRECTOR("银联快捷",PayType.ONLINE),
    GF_BANK("广发银行",PayType.ONLINE),
    NING_BO_BANK("宁波银行",PayType.ONLINE),
    YEEPAY_PHONE("易宝电话支付",PayType.ONLINE),
    SAN_BAI_TIAO("闪白条",PayType.ONLINE),
    BOC("中国银行",PayType.ONLINE),
    CEB_BANK("光大银行",PayType.ONLINE),
    CMB("招商银行",PayType.ONLINE),
    ALIPAY_DIRECTPAY("支付宝快捷",PayType.ONLINE),
    CITIC_BANK("中信银行_WEB",PayType.ONLINE),
    BAIDUPAY_WEB("百度钱包WEB支付",PayType.ONLINE),
    TENPAY("财付通",PayType.ONLINE),
    ABC_BANK("中国农业银行",PayType.ONLINE),
    SHB_BANK("上海银行",PayType.ONLINE),
    BJRCB_BANK("北京农村商业银行",PayType.ONLINE),
    BOC_CREDIT_WEB("中银消费信贷",PayType.ONLINE),
    HZB_BANK("杭州银行",PayType.ONLINE),
    ALIPAY_SCAN("支付宝扫码",PayType.ONLINE),
    WEIXIN_UNIFIED_ORDER_WEB("微信WEB扫码支付",PayType.ONLINE),
    CIB_BANK("兴业银行",PayType.ONLINE),
    YEEPAY_QUICK("易宝快捷支付",PayType.ONLINE),
    WEIXIN_WEB("财付通微信WEB扫码支付",PayType.ONLINE),
    WAN_LI_TONG("万里通",PayType.ONLINE),
    SAND_POS("杉德POS机",PayType.ONLINE),
    UNIONPAY("银联",PayType.ONLINE),
    SPDB("上海浦东发展银行",PayType.ONLINE),
    ALIPAY("支付宝",PayType.ONLINE),
    STORED_CARD("储值卡",PayType.ONLINE),
	LYTXK_STORED_CARD("驴游天下卡",PayType.ONLINE),
    
    //client那边移过来的
	ALIPAY_APP("支付宝APP",PayType.ONLINE),
	ALIPAY_WAP("支付宝Wap",PayType.ONLINE),
	 
	WEIXIN_ANDROID("微信ANDROID",PayType.MOBILE),
	WEIXIN_IOS("微信IOS",PayType.MOBILE),
	WEIXIN_UNIFIED_ORDER_ANDROID("维金微信ANDROID",PayType.MOBILE),
	WEIXIN_UNIFIED_ORDER_IOS("维金微信IOS",PayType.MOBILE),
	
	//2016-04-13从client那边移过来的
	ALIPAY_CLIENT("支付宝客户度",PayType.MOBILE),
    @Deprecated
    CHINAPAY("中国银联",PayType.MOBILE),
    CHINAPAY_PRE("银联预授权",PayType.MOBILE),
    CASH_ACCOUNT("现金账户",PayType.MOBILE),
    CASH_BONUS("奖金账户",PayType.MOBILE),
    @Deprecated
    ONE_CITY_ONE_CARD("新华一卡通",PayType.MOBILE),
    CMB_INSTALMENT("招商银行分期",PayType.MOBILE),
    COMM_POS("交通银行POS机",PayType.MOBILE),
    COMM_POS_CASH("交通银行POS机现金支付",PayType.MOBILE),
    SAND_POS_CASH("杉德POS机现金支付",PayType.MOBILE),
    @Deprecated
    SHENGPAY("盛付通",PayType.MOBILE),
    PAY_0_YUAN("订单金额为0",PayType.MOBILE),
    BOC_INSTALMENT("中国银行分期",PayType.MOBILE),
    UPOMP("手机端银联支付",PayType.MOBILE),
    ALIPAY_WAP_CREDITCARD("支付宝手机WAP信用卡支付",PayType.MOBILE),
    ALIPAY_WAP_DEBITCARD("支付宝手机WAP储值卡支付",PayType.MOBILE),
    CHINAPNR("汇付天下",PayType.MOBILE),
    @Deprecated
    ALLINPAY("通联支付",PayType.MOBILE),
    TELBYPAY("百付电话支付",PayType.MOBILE),
    ALIPAY_OFFLINE("淘宝B店",PayType.MOBILE),
    lvyoupiaowuzhekoudian("旅游票务折扣店—总部淘宝",PayType.MOBILE),
    tehuipiaowuwang("特惠票务网—总部淘宝",PayType.MOBILE),
    LAKALA("拉卡拉支付",PayType.MOBILE),
    ALIPAY_BPTB("支付宝批量付款到银行",PayType.MOBILE),
    ALIPAY_BATCH("支付宝批量付款到支付宝帐号",PayType.MOBILE),
    CHINA_MOBILE_PAY("中国移动支付",PayType.MOBILE),
    ICBC_WAP("工商银行手机WAP支付",PayType.MOBILE),
    TENPAY_APP("财付通手机APP支付",PayType.MOBILE),
    TENPAY_WAP("财付通手机WAP支付",PayType.MOBILE),
    WEIXIN_PUBLIC("财付通微信公众账号支付",PayType.MOBILE),
    WEIXIN_UNIFIED_ORDER_PUBLIC("微信公众账号支付",PayType.MOBILE),
    WEIXIN_UNIFIED_ORDER_WAP("微信WAP支付",PayType.MOBILE),
    BAIDUPAY_APP("百度钱包支付",PayType.MOBILE),
    BAIDUPAY_WAP("百度钱包支付",PayType.MOBILE),
    BAIDUPAY_APP_ACTIVITIES("百度钱包APP手机支付活动",PayType.MOBILE),
    BAIDUPAY_WAP_ACTIVITIES("百度钱包WAP手机支付活动",PayType.MOBILE),
    ICBC_INSTALMENT("工商银行分期",PayType.MOBILE),
    CITIC_WAP("中信异度支付WAP",PayType.MOBILE),
    BOC_CREDIT_PRE("中银消费信贷预授权",PayType.MOBILE),
    CCB_BANK_WAP("中国建设银行WAP",PayType.MOBILE),
    BILL99("快钱支付",PayType.MOBILE),
    BILL99_WAP("快钱移动WAP网关",PayType.MOBILE),
    YEEPAY_APP_PRE("易宝手机预授权支付",PayType.MOBILE),
    YEEPAY_FENXIAO_B2B("易宝分销B2B",PayType.MOBILE),
    UNIONPAY_APP("手机银联控件支付",PayType.MOBILE),
    
    BOC_CREDIT_APP("中银消费信贷APP",PayType.MOBILE),
    BOC_CREDIT_APP_PRE("中银消费信贷APP预授权",PayType.MOBILE),
	PRESELL_CARD("预售券",PayType.MOBILE),
    COMMCI("交通银行信用卡分期",PayType.MOBILE),
    COMMCCDRC("交通银行信用卡快捷",PayType.MOBILE),
	YIHAODIAN("1号店",PayType.MOBILE),
    FENXIAO_ZHONGKANG("中康分销",PayType.MOBILE),
    ZHEJIANGLVYOU_TIANMAO("浙江旅游局天猫店",PayType.MOBILE),
    TCL_FX("TLC-总部-支付渠道",PayType.MOBILE),
    FENXIAO_SPDB("分销浦发银行",PayType.MOBILE),
    FENXIAO_COMM("分销交通银行",PayType.MOBILE),
    FENXIAO_360BUY("分销京东商城",PayType.MOBILE),
    FENXIAO_QUNA("分销去哪儿线路",PayType.MOBILE),
    FENXIAO_ZHOUWU("周五网分销",PayType.MOBILE),
    FENXIAO_QUNA_TUAN("分销去哪儿线路团购",PayType.MOBILE),
    FENXIAO_QUNA_TICKET("分销去哪儿门票",PayType.MOBILE),
    FENXIAO_QUNA_TICKET_TUAN("分销去哪儿门票团购",PayType.MOBILE),
    FENXIAO_JINGDONG("京东分销",PayType.MOBILE),
    FENXIAO_JINZONGLV("分销商支付-金棕榈",PayType.MOBILE),
    FENXIAO_SHMOBILE("上海移动分销",PayType.MOBILE),
    FENXIAO_UNICOM114("联通114分销",PayType.MOBILE),
    FENXIAO_ELONG("分销艺龙",PayType.MOBILE),
    FENXIAO_YINLIAN("分销支付-银联",PayType.MOBILE),
    FENXIAO_NAVIDOG("分销支付-导航犬",PayType.MOBILE),
    FENXIAO_SUNING("分销支付-苏宁易购",PayType.MOBILE),
    FENXIAO_XIEXIE("分销支付-谢谢网团购分销",PayType.MOBILE),
    FENXIAO_LASHOU("分销支付-拉手网团购分销",PayType.MOBILE),
    FENXIAO_YODODO("分销支付-游多多分销",PayType.MOBILE),
    FENXIAO_WONJAM("分销支付-河南万家分销",PayType.MOBILE),
    FENXIAO_114PIAOWU("分销支付-114票务分销",PayType.MOBILE),
    FENXIAO_CKDEVICE("立式设备",PayType.MOBILE),
    FENXIAO_RENWOYOU("分销支付-任我游分销",PayType.MOBILE),
    FENXIAO_YIKUAIQU("分销支付-一块去旅行分销",PayType.MOBILE),
    FENXIAO_PIAOGUANJIA("分销支付-票管家分销",PayType.MOBILE),
    FENXIAO_MEITUAN("分销支付-美团分销",PayType.MOBILE),
    FENXIAO_CHERRY("分销支付-樱桃旅行分销",PayType.MOBILE),
    EXPORT_DIEM("导码专用",PayType.MOBILE),
    DISTRIBUTOR_B2B("分销平台",PayType.MOBILE),
    CREDIT_B2B("分销授信",PayType.MOBILE),
    TUANG0U_360BUY("京东团购",PayType.MOBILE),
    TUANG0U_MANZUO("满座团购",PayType.MOBILE),
    TUANG0U_ENJOYOUNG("星尚团购",PayType.MOBILE),
    TUANG0U_55TUAN("窝窝团团购",PayType.MOBILE),
    TUANG0U_QUNA("去哪儿团购",PayType.MOBILE),
    TUANG0U_FTUAN("F团团购",PayType.MOBILE),
    TUANG0U_TAOBAO_JUHUASUAN("聚划算团购",PayType.MOBILE),
    TUANG0U_NUOMI("糯米团团购",PayType.MOBILE),
    TUANG0U_JUQI("聚齐团购",PayType.MOBILE),
    TUANG0U_XIECHENG("携程团购",PayType.MOBILE),
    TUANG0U_MEITUAN("美团团购",PayType.MOBILE),
    TAOBAO_ZHEKOUDIAN("旅游票务折扣店—总部淘宝",PayType.MOBILE),
    TAOBAO_TEHUIWANG("特惠票务网—总部淘宝",PayType.MOBILE),
    TAOBAO_GUDOU("古兜淘宝店",PayType.MOBILE),
    WECHATE_STORE("微信小店",PayType.MOBILE),
    TUANG0U_ELONG("艺龙团购",PayType.MOBILE);
		
	private String cnName;
	private PayType payType;
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	public PayType getPayType() {
		return payType;
	}
	public void setPayType(PayType payType) {
		this.payType = payType;
	}
	private PaymentType(String cnName, PayType payType) {
		this.cnName = cnName;
		this.payType = payType;
	}
	

	public static PaymentType getPaymentTypeName(String name) {
		if(name==null||"".equals(name)){
			return null;
		}
		for (PaymentType paymentType : PaymentType.values()) {
			if (name.equals(paymentType.name())) {
				return paymentType;
			}
		}
		return null;
	}
}
