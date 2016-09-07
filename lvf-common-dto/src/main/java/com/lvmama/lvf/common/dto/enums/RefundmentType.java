package com.lvmama.lvf.common.dto.enums;
/**
 * 支付方式
 * @author lven
 *
 */
public enum RefundmentType {
//	ALIPAY("支付宝 ",RefundType.ONLINE),
	PAY("支付宝 ",RefundType.ONLINE),
	WEIXIN("微信",RefundType.MOBILE),
	BAIDU("百度支付",RefundType.ONLINE),
	UNION_PAY("银联",RefundType.ONLINE),
	POS("POS",RefundType.POS),
	POINT("积分",RefundType.PHONE),
	CASH("现金",RefundType.CASH),
	COUPON("抵用劵",RefundType.COUPON),
	DISTRIBUTOR_B2B("预存款",RefundType.CASH),
    
	YEE("易宝电话",RefundType.PHONE),
	HUNDRED("百付电话",RefundType.PHONE),
	OFFLINE_CARD("线下拉卡",RefundType.CARD),
    KENDRION("彬德POS",RefundType.POS),
    DUMMY("虚拟",RefundType.DUMMY),
    VST_PAY("打包主单支付",RefundType.DUMMY),
	LVMAMA_TRIP("差旅支付",RefundType.DUMMY),
    
    OTHER("其他",RefundType.OTHER),
    
  //新增PC端支付方式(来源于主站)   2016-03-17
    BOB_BANK("北京银行",RefundType.ONLINE),
    CMBC_BANK("民生银行",RefundType.ONLINE),
    TENPAY_DIRECT("财付通快捷",RefundType.ONLINE),
    ICBC("工商银行",RefundType.ONLINE),
    CCB_BANK("中国建设银行",RefundType.ONLINE),
    COMM("交通银行",RefundType.ONLINE),
    PAB_BANK("平安银行",RefundType.ONLINE),
    PSBC_BANK("中国邮政储蓄银行",RefundType.ONLINE),
    UNIONPAY_DIRECTOR("银联快捷",RefundType.ONLINE),
    GF_BANK("广发银行",RefundType.ONLINE),
    NING_BO_BANK("宁波银行",RefundType.ONLINE),
    YEEPAY_PHONE("易宝电话支付",RefundType.ONLINE),
    SAN_BAI_TIAO("闪白条",RefundType.ONLINE),
    BOC("中国银行",RefundType.ONLINE),
    CEB_BANK("光大银行",RefundType.ONLINE),
    CMB("招商银行",RefundType.ONLINE),
    ALIPAY_DIRECTPAY("支付宝快捷",RefundType.ONLINE),
    CITIC_BANK("中信银行_WEB",RefundType.ONLINE),
    BAIDUPAY_WEB("百度钱包WEB支付",RefundType.ONLINE),
    TENPAY("财付通",RefundType.ONLINE),
    ABC_BANK("中国农业银行",RefundType.ONLINE),
    SHB_BANK("上海银行",RefundType.ONLINE),
    BJRCB_BANK("北京农村商业银行",RefundType.ONLINE),
    BOC_CREDIT_WEB("中银消费信贷",RefundType.ONLINE),
    HZB_BANK("杭州银行",RefundType.ONLINE),
    ALIPAY_SCAN("支付宝扫码",RefundType.ONLINE),
    WEIXIN_UNIFIED_ORDER_WEB("微信WEB扫码支付",RefundType.ONLINE),
    CIB_BANK("兴业银行",RefundType.ONLINE),
    YEEPAY_QUICK("易宝快捷支付",RefundType.ONLINE),
    WEIXIN_WEB("财付通微信WEB扫码支付",RefundType.ONLINE),
    WAN_LI_TONG("万里通",RefundType.ONLINE),
    SAND_POS("杉德POS机",RefundType.ONLINE),
    UNIONPAY("银联",RefundType.ONLINE),
    SPDB("上海浦东发展银行",RefundType.ONLINE),
    ALIPAY("支付宝",RefundType.ONLINE),
    STORED_CARD("储值卡",RefundType.ONLINE),
	LYTXK_STORED_CARD("驴游天下卡",RefundType.ONLINE),
    
    //client那边移过来的
	ALIPAY_APP("支付宝APP",RefundType.ONLINE),
	ALIPAY_WAP("支付宝Wap",RefundType.ONLINE),
	 
	WEIXIN_ANDROID("微信ANDROID",RefundType.MOBILE),
	WEIXIN_IOS("微信IOS",RefundType.MOBILE),
	WEIXIN_UNIFIED_ORDER_ANDROID("维金微信ANDROID",RefundType.MOBILE),
	WEIXIN_UNIFIED_ORDER_IOS("维金微信IOS",RefundType.MOBILE),
	
	//2016-04-13从client那边移过来的
	ALIPAY_CLIENT("支付宝客户度",RefundType.MOBILE),
	@Deprecated
	CHINAPAY("中国银联",RefundType.MOBILE),
	CHINAPAY_PRE("银联预授权",RefundType.MOBILE),
	CASH_ACCOUNT("现金账户",RefundType.MOBILE),
	CASH_BONUS("奖金账户",RefundType.MOBILE),
	@Deprecated
	ONE_CITY_ONE_CARD("新华一卡通",RefundType.MOBILE),
	CMB_INSTALMENT("招商银行分期",RefundType.MOBILE),
	COMM_POS("交通银行POS机",RefundType.MOBILE),
	COMMCCDRC("交通银行信用卡快捷",RefundType.MOBILE),
	COMM_POS_CASH("交通银行POS机现金支付",RefundType.MOBILE),
	SAND_POS_CASH("杉德POS机现金支付",RefundType.MOBILE),
	@Deprecated
	SHENGPAY("盛付通",RefundType.MOBILE),
	PAY_0_YUAN("订单金额为0",RefundType.MOBILE),
	BOC_INSTALMENT("中国银行分期",RefundType.MOBILE),
	UPOMP("手机端银联支付",RefundType.MOBILE),
	ALIPAY_WAP_CREDITCARD("支付宝手机WAP信用卡支付",RefundType.MOBILE),
	ALIPAY_WAP_DEBITCARD("支付宝手机WAP储值卡支付",RefundType.MOBILE),
	CHINAPNR("汇付天下",RefundType.MOBILE),
	@Deprecated
	ALLINPAY("通联支付",RefundType.MOBILE),
	TELBYPAY("百付电话支付",RefundType.MOBILE),
	ALIPAY_OFFLINE("淘宝B店",RefundType.MOBILE),
	lvyoupiaowuzhekoudian("旅游票务折扣店—总部淘宝",RefundType.MOBILE),
	tehuipiaowuwang("特惠票务网—总部淘宝",RefundType.MOBILE),
	LAKALA("拉卡拉支付",RefundType.MOBILE),
	ALIPAY_BPTB("支付宝批量付款到银行",RefundType.MOBILE),
	ALIPAY_BATCH("支付宝批量付款到支付宝帐号",RefundType.MOBILE),
	CHINA_MOBILE_PAY("中国移动支付",RefundType.MOBILE),
	ICBC_WAP("工商银行手机WAP支付",RefundType.MOBILE),
	TENPAY_APP("财付通手机APP支付",RefundType.MOBILE),
	TENPAY_WAP("财付通手机WAP支付",RefundType.MOBILE),
	WEIXIN_PUBLIC("财付通微信公众账号支付",RefundType.MOBILE),
	WEIXIN_UNIFIED_ORDER_PUBLIC("微信公众账号支付",RefundType.MOBILE),
	WEIXIN_UNIFIED_ORDER_WAP("微信WAP支付",RefundType.MOBILE),
	BAIDUPAY_APP("百度钱包支付",RefundType.MOBILE),
	BAIDUPAY_WAP("百度钱包支付",RefundType.MOBILE),
	BAIDUPAY_APP_ACTIVITIES("百度钱包APP手机支付活动",RefundType.MOBILE),
	BAIDUPAY_WAP_ACTIVITIES("百度钱包WAP手机支付活动",RefundType.MOBILE),
	ICBC_INSTALMENT("工商银行分期",RefundType.MOBILE),
	CITIC_WAP("中信异度支付WAP",RefundType.MOBILE),
	BOC_CREDIT_PRE("中银消费信贷预授权",RefundType.MOBILE),
	CCB_BANK_WAP("中国建设银行WAP",RefundType.MOBILE),
	BILL99("快钱支付",RefundType.MOBILE),
	BILL99_WAP("快钱移动WAP网关",RefundType.MOBILE),
	YEEPAY_APP_PRE("易宝手机预授权支付",RefundType.MOBILE),
	YEEPAY_FENXIAO_B2B("易宝分销B2B",RefundType.MOBILE),
	UNIONPAY_APP("手机银联控件支付",RefundType.MOBILE);

	private String cnName;
	private RefundType refundType;
	
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	public RefundType getRefundType() {
		return refundType;
	}

	public void setRefundType(RefundType refundType) {
		this.refundType = refundType;
	}

	private RefundmentType(String cnName, RefundType refundType) {
		this.cnName = cnName;
		this.refundType = refundType;
	}
	
	public static RefundmentType getRefundmentTypeName(String name) {
		if(name==null||"".equals(name)){
			return null;
		}
		for (RefundmentType refundType : RefundmentType.values()) {
			if (name.equals(refundType.name())) {
				return refundType;
			}
		}
		return null;
	}
}
