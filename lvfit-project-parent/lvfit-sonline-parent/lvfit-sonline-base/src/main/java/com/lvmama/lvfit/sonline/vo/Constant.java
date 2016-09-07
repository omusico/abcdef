package com.lvmama.lvfit.sonline.vo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class Constant {
	public static final String ERROR_PAGE = "/error"; // 默认出错页面地址
	public final static String VST_FRONT_IP = "vst_front.Ip";
	public static final String _IP_CITY_PLACE_ID = "_ip_city_place_id";
	public static final String _IP_PROVINCE_PLACE_ID = "_ip_province_place_id";
	public static final String _IP_CITY_NAME ="_ip_city_name";
	public static final String COMMA =",";
	
	// 前台获取产品属性有关的缓存的key
	public static enum MEM_CACH_KEY {

		VST_PRODUCT_NO_BRAND_BASIC_, VST_PRODUCT_HAS_BRAND_BASIC_, HOTELS_VST_PRODUCT_BASIC_, VST_PRODUCT_PHOTO_, HOTELS_VST_PRODUCT_NOTICE_, HOTELS_VST_PRODUCT_SIGN_, VST_BIZ_BRANCH_PROP_, VST_BIZ_DICT_PROP_, VST_BIZ_CATEGORY_PROP_, VST_TICKET_PRODUCT_,VST_LINE_PRODUCT_,
        //visa
        VST_VISA_PRODUCT_,VST_VISA_PRODUCT_RANGE_,VST_VISA_EMAIL_CHECK_,VST_VISA_EMAIL_CHECK_START_TIME_,
		//vst_ticket
		VST_TICKET_PRODUCT_COMMENTS_,VST_TICKET_PRODUCT_COMMENTS_COUNT_,VST_TICKET_PRODUCT_URL_,
		//vst_header
		VST_HEADER_COMIPS_,VST_HEADER_,
		// vst_supp
		VST_SUPP_ELONG_SUPP_GOODS_TIME_PRICE_MAP_, VST_SUPP_ELONG_CREDIT_CARD_,VST_SUPP_ELONG_GOODS_RELATION_BY_RPI_LIST_,VST_SUPP_ELONG_GOODS_RELATION_BY_HC_LIST_,
		//vst_comment
		VST_CMT_COMMENT_,
        //vst_trip
        VST_TICKET_TRIP_,
		VST_DEST_TRIP_,
		//supp_goods_limit
		VST_SUPP_GOODS_LIMIT_;
	}

	public final static String DEFAULT_LOCATION = "www";
	public final static String SESSION_FRONT_USER = "SESSION_FRONT_USER";
	public final static String SESSION_BACK_USER = "SESSION_BACK_USER";
	public final static String SYSTEM_USER = "admin";
	public static final String LV_SESSION_ID = "lvsessionid";
	public static final String VST_EBK_SESSION_ID = "vst_ebk_sessionid";
	
	/**
	 * 监控功能的sessionId
	 */
	public static final String VST_MONITOR_SESSION_ID = "vst_monitor_sessionid";
	/**
	 * 默认filter需要忽略对监控功能的过滤
	 */
	public static final String IGNORE_URL = "ignore_url";
	
	
	/** 客服电话 **/
	public final static String CUSTOMER_SERVICE_PHONE = "10106060";
	/** 公司 **/
	public final static String LVMAMA = "【驴妈妈】";
	/** 彩信申码需要保留 **/
	public final static String SMS_KEEP_CONTENT1 = "稍后您将会收到编码短信作为您购票入园的唯一凭证";
	/** 彩信申码需要保留 **/
	public final static String SMS_KEEP_CONTENT2 = "若您在游玩前未收到此编码短信，请致电客服";	
	/** 客户端签名 **/
	public final static String CLIENT_SIGN = "【下载手机客户端，查订单、买门票、订酒店m.lvmama.com/app】";
	/** 订单详情 **/
	public static final String ORDER_PROCESS_TYPE = "PROCESS_TYPE";
	public static final String ORDER_STATUS = "STATUS";
	public static final String PENALTY_TO_CUSTOMER = "PENALTY_TO_CUSTOMER";
	public static final String PENALTY_CURRENCY_CODE = "PENALTY_CURRENCY_CODE";

	/**时间价格表，类型枚举**/
	public static enum TIME_PRICE_TYPE{
		SUPP_GOODS_TIME_PRICE,SUPP_GOODS_MULTI_TIME_PRICE,SUPP_GOODS_SINGLE_TIME_PRICE,SUPP_GOODS_SIMPLE_TIME_PRICE;
	}
	public static final String ACTIVITY_FIVE_YEAR = "5year";
	public static final String IP_FROM_PLACE_NAME = "ip_from_place_name";
	public static final String IP_AREA_LOCATION = "ip_area_location";// IP的区域信息-属于哪个出发地的
	public static final String IP_FROM_PLACE_ID = "ip_from_place_id";
	public static final String IP_PROVINCE_PLACE_ID = "ip_province_place_id";
	public static final String IP_CITY_PLACE_ID = "ip_city_place_id";
	public static final String IP_LOCATION = "ip_location";// IP信息
	public static final String IP_IF_CHANGED = "ip_if_changed";// 是否IP发生变化；
	public static final String IP_PROVINCE_NAME ="ip_province_name";
	public static final String IP_CITY_NAME ="ip_city_name";
	public static final String DEFAULT_PROVINCE_PLACE_ID = "default_province_place_id";
	public static final String DEFAULT_CITY_PLACE_ID = "default_city_place_id";
	public static final String DEFAULT_PIC = "http://pic.lvmama.com/cmt/images/img_90_90.jpg";
	public static final String HOLIDAY_HOTEL_PLACEID = "HOLIDAY_HOTEL_PLACEID";
	
	//电子合同是否需要与金棕榈同步
	public static final int CONTRACT_NEED_SYNC = 1;
	public static final int CONTRACT_NO_NEED_SYNC = 0;
	
	public static enum LOGIN_TYPE {
		MOBILE("手机"), HTML5("wap");
		private String cnName;

		LOGIN_TYPE(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (LOGIN_TYPE item : LOGIN_TYPE.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		@Override
		public String toString() {
			return "code:" + this.name() + ",cnName:" + this.cnName;
		}
	}

	/**
	 * 点评审核状态
	 */
	public static enum CMT_AUDIT_STATUS {
		/** 待审核 */
		AUDIT_GOING,
		/** 审核通过 */
		AUDIT_SUCCESS,
		/** 审核未通过 */
		AUDIT_FAILED
	}

	public static enum CHANNEL_ID{
		/** 网站首页 seo_index_page.channel_id */
		CH_INDEX,
		/** 门票频道 seo_index_page.channel_id */
		CH_TICKET,
		/**自游自在频道 seo_index_page.channel_id*/
		CH_FREETOUR,
		/**邮轮频道 seo_index_page.channel_id*/
		CH_YOULUN,
		/**周边游频道 seo_index_page.channel_id*/
		CH_AROUND,
		/**国内游频道 seo_index_page.channel_id*/
		CH_DESTROUTE,
		/**出境游频道 seo_index_page.channel_id*/
		CH_ABROAD,
		/**酒店频道 seo_index_page.channel_id*/
		CH_HOTEL,
		CH_TUANGOU,
		/**火车票**/
		CH_TRAIN,


		/**
		 * 周边跟团游seo_index_page.channel_id
		 */
		CH_AROUND_GROUP,
		/**
		 * 特卖会列表页
		 */
		CH_TUANGOULIST,
		/**
		 * vst团购详情页
		 **/
		CH_TUANGOUDEST,
		/**
		 * vst秒杀详情页
		 **/
		CH_SECKILLDEST,
		/**
		 * 驴悦首页seo_index_page.channel_id
		 **/
		LY_INDEX,
		/**
		 * 驴悦线路seo_index_page.channel_id
		 **/
		LY_ROUTE,
		/**
		 * 驴悦门票
		 **/
		LY_TICKET,
		/**
		 * 驴悦酒店
		 **/
		LY_HOTEL,
		/**
		 * 驴悦团队定制
		 **/
		LY_GROUP,
		/**
		 * 驴悦入驻
		 **/
		LY_BUSINESS,
		/**
		 * 驴悦晚期回顾
		 **/
		LY_REVIEW,
		/**
		 * 自驾游
		 **/
		CH_SELF_DRIVING,
		/**
		 * 度假
		 **/
		CH_DUJIA,
		/**
		 * 度假索引页
		 **/
		CH_DUJIA_SUOYIN
	}
	
	/**
	 * 点评回复类型
	 */
	public static enum CMT_REPLY_TYPE {
		/** 商家回复 */
		MERCHANT,
		/** 用户回复 */
		CUSTOMER,
		/** 用户回复 */
		LVMAMA
	}

	/**
	 * 普通点评
	 */
	public static final String COMMON_COMMENT_TYPE = "COMMON";
	/**
	 * 体验点评
	 */
	public static final String EXPERIENCE_COMMENT_TYPE = "EXPERIENCE";

	
	 public static enum PLACE_SEOLINKS{
         INDEX("首页");
         
         private String cnName;
         PLACE_SEOLINKS(String name) {
             this.cnName = name;
         }
         
         public String getCode() {
             return this.name();
         }

         public String getCnName() {
             return this.cnName;
         }
         
         public static String getCnName(String code) {
             for (PLACE_SEOLINKS item : PLACE_SEOLINKS.values()) {
                 if (item.getCode().equals(code)) {
                     return item.getCnName();
                 }
             }
             return code;
         }       
     }
	
	public static enum CMT_EFFECT_TYPE {
		NORMAL("常规"),
		PROPOSAL("建议"),
		COMPLAINT("投诉");

		private String cnName;

		CMT_EFFECT_TYPE(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(CMT_EFFECT_TYPE item: CMT_EFFECT_TYPE.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
        public String toString(){
			return "code:"+this.name()+",cnName:"+this.cnName;
		}
	}

	// 性别
	public static enum SEX_CODE {
		MALE("男", "1"), // 男性
		FEMALE("女", "2"); // 女性

		private final String chName;
		private final String code;

		SEX_CODE(String chName, String code) {
			this.chName = chName;
			this.code = code;
		}

		public String getChName() {
			return chName;
		}

		public String getCode() {
			return code;
		}

		public static String getCnName(String code) {
			if (StringUtils.equals(code, FEMALE.code)) {
				return FEMALE.chName;
			} else if (StringUtils.equals(code, MALE.code)) {
				return MALE.chName;
			} else {
				return "";
			}
		}
	}

	private static Log log = LogFactory.getLog(Constant.class);
	private static volatile Constant instance = null;
	private static Properties properties;

	private Constant() {
		init();
	}

	private void init() {
		try {
			properties = new Properties();
			properties
					.load(getClass().getResourceAsStream("/const.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ResourceBundle.getBundle("const");
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	/**
	 * JOB是否运行
	 *
	 * @return
	 */
	public boolean isJobRunnable() {
		String jobEnabled = properties.getProperty("job.enabled");
		if (log.isDebugEnabled()) {
			log.debug("job is runnable: " + jobEnabled + " => "
					+ ("true".equals(jobEnabled)));
		}
		if (jobEnabled != null) {
			return Boolean.valueOf(jobEnabled);
		} else {
			return true;
		}
	}
	
	
	/**
	 * JOB是否运行
	 *
	 * @return
	 */
	public boolean isClearActHisJobRunnable() {
		String jobEnabled = properties.getProperty("clearActHisJob.enabled");
		if (log.isDebugEnabled()) {
			log.debug("job is runnable: " + jobEnabled + " => "
					+ ("true".equals(jobEnabled)));
		}
		if (jobEnabled != null) {
			return Boolean.valueOf(jobEnabled);
		} else {
			return false;
		}
	}

	/**
	 * comExecutorJob是否运行
	 *
	 * @return
	 */
	public boolean isComExecutorJobRunnable() {
		String comExecutorJobEnabled = properties
				.getProperty("comExecutorJob.enabled");
		if (log.isDebugEnabled()) {
			log.debug("job is runnable: comExecutorJob.enabled => "
					+ comExecutorJobEnabled);
		}
		if (comExecutorJobEnabled != null) {
			return Boolean.valueOf(comExecutorJobEnabled);
		} else {
			return true;
		}
	}

	public static Constant getInstance() {
		if (instance == null) {
			synchronized (Constant.class) {
				if (instance == null) {
					instance = new Constant();
					// instance.init();
				}
			}
		}
		return instance;
	}

	/**
	 * 后台分销
	 */
	public static long DIST_BACK_END = 2L;
	/**
	 * 前台分销
	 */
	public static long DIST_FRONT_END = 3L;
	
	/**
	 * 分销
	 */
	public static long DIST_BRANCH_SELL = 4L;

	public static enum PROPERTY_INPUT_TYPE_ENUM {

		INPUT_TYPE_TEXT("文本"), INPUT_TYPE_RICH("富文本"), INPUT_TYPE_TEXTAREA(
				"多行文本"), INPUT_TYPE_COORDINATE("经纬度"), INPUT_TYPE_DDMM("日期(时分)"), INPUT_TYPE_YYYYMM(
				"日期(年月)"), INPUT_TYPE_YYYYMMDD("日期(年月日)"), INPUT_TYPE_YESNO(
				"是/否"), INPUT_TYPE_CHECKBOX("多选"), INPUT_TYPE_RADIO("单选"), INPUT_TYPE_SELECT(
				"下拉"), INPUT_TYPE_NUMBER("数字"), INPUT_TYPE_IMG_L("大图"), INPUT_TYPE_IMG_M(
				"中图"), INPUT_TYPE_IMG_S("小图");
		private String cnName;

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (PROPERTY_INPUT_TYPE_ENUM item : PROPERTY_INPUT_TYPE_ENUM
					.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		PROPERTY_INPUT_TYPE_ENUM(String cnName) {
			this.cnName = cnName;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}

	/**
	 * Jms消息类型
	 *
	 * @author ranlongfei 2013-12-14
	 * @version
	 */
	public enum JMS_TYPE {
		ORD_REFUNDMENT, // 退款
		ORD_ORDER_ITEM,
		ORD_ORDER;
	}

	/**
	 * Jms消息的事件类型 <br>
	 * <b>同一消息下的不同事件</b>
	 *
	 * @author ranlongfei 2013-12-14
	 * @version
	 */
	public enum EVENT_TYPE {
		ORDER_CREATE_MSG, // 订单创建
		ORDER_INFOPASS_MSG, // 信息审核通过
		ORDER_RESOURCE_MSG, // 资源审核通过
		ORDER_APPROVE_MSG, // 订单审核通过
		ORDER_PAYMENT_MSG, // 支付完成消息
		ORDER_MODIFY_PERSON_MSG,//订单人员修改
		ORDER_CANCEL_MSG, // 订单取消
		ORDER_MODIFY_MSG, // 订单修改
		ORDER_REFUNDED_MSG, // 订单退款
		ORDER_AMOUNT_CHANGE_MSG,//订单金额修改
		ORDER_MODIFY_SETTLEMENT_PRICE_MSG,//订单修改结算价
		ORDER_ITEM_SETTLE_MSG,//手动生成结算单,
		ORDER_ITEM_PERFORM_MSG,//履行成功
		ITEM_PERFROM_SETTLE_MSG,//履行成功
		SUPPLIER_ORDER_CANCEL_APPLY_MSG, // 供应商订单取消
		ORDER_PERFORM_PREVIOUS_DAY_SMS_MSG, // 履行前一天的有效短信
		ORDER_WAIT_PAY_SMS_MSG,// 短信等待时间剩余30分钟时发送短信消息
		/**Lucene索引创建*/
		LUCENE_INDEX_CREATE,
		/**Lucene索引更新*/
		LUCENE_INDEX_UPDATE,
		/**Lucene索引切换*/
		LUCENE_INDEX_SWITCH,
		/**Lucene实时索引*/
		LUCENE_INDEX_REALTIME,
        /** 申请通关码成功 */
        PASSCODE_APPLY_SUCCESS,
        /**申请通关码成功回调*/
        PASSCODE_APPLY_NOTIFY,
        /** 通关码申请处理 */
        PASSCODE_APPLY,
        /** 通关码事件 */
        PASSCODE_EVENT,
        /** 通关码废除 */
        PASSCODE_DESTORY_EVENT,
        /** 通关码申请失败 */
        PASSCODE_APPLY_FAILED,
        /**辅助码已经被使用(EBK通关)*/
        PASSPORT_USED_EVENT,
		/** 订单客户修改 */
		ORDER_CHANGE_PERSON_MSG,
		EMAIL_CREATE,
		/** 修改订单联系人 */
		ORDER_CONTACTS_UPDATE,
		/** 修改订单备注 */
		ORDER_MEMO_UPDATE,
		/** 电子合同修改 */
		ORDER_CONTRACT_UPDATE,
		/**
		 * 产品是否有效修改
		 */
		PRODUCT_CANCLE_UPDATE,
		/**
		 * 产品规格
		 */
		PRODUCT_BRANCH_CANLCE_UPDATE,
		/**
		 * 商品是否有效修改
		 */
		SUPP_GOODS_CANCLE_UPDATE,
		/**
		 * 时间价格表变化（objectId 传递商品Id）
		 */
		SUPP_GOODS_TIME_PRICE,
		/**自动补全更新*/

		AUTO_COMPLETE_UPDATE,
		/**
		 * 分单日志
		 */
		ALLOCATION_LOG_MSG,
		
		/**转码表消息 **/
		TRANSCODE,
		
		/**
		 * 及时分单
		 */
		ORDER_ALLOCATION__MSG,
		
		/**
		 * 配置文件设置
		 */
		CONFIG_INFO_SET,
		/**
		 * 配置文件设置
		 */
		CONFIG_INFO_RESET,
		/**
		 * 强制启动定时任务
		 */
		JOB_FORCE_START,
		
		/**
		 * EBK短信提醒
		 */
		EBK_SMS_MSG;
	}

	public String getFaxServerUrl() {
		return properties.getProperty("fax_server_url");
	}

	public String getFaxRecv() {
		return properties.getProperty("fax_recv");
	}
	
	/**
	 * 得到订单测试设置的值
	 */
	public String getOrderValue(){
		return properties.getProperty("ordervalue");
	}
	
	/**
	 * 是否老搜索跳到新搜索
	 * @return
	 */
	public static boolean getIsSearch301() {
		getInstance(); 
		String is301=properties.getProperty("is_search301");
		if (StringUtils.isEmpty(is301)) {
			return false;
		}
		return Boolean.valueOf(is301);  
	}

	public boolean getFaxSenderEnabled() {
		return Boolean.valueOf(properties.getProperty("faxsender.enabled"));
	}

	public boolean getSeoSiteStatisticsEnabled() {
		return Boolean.valueOf(properties.getProperty("seoSiteStatistics.enabled"));
	}

	public static String getTempDir() {
		return System.getProperty("java.io.tmpdir");
	}

	public static enum PROCESS_TYPE {

		AUTH("授权"), CANCEL_AUTH("取消授权"), CHARGE("授权后扣款"), REFUND("退款"), DIRECT_CHARGE(
				"直接扣款");
		private String cnName;

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (PROCESS_TYPE item : PROCESS_TYPE.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		PROCESS_TYPE(String cnName) {
			this.cnName = cnName;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}

	public static enum STATUS {

		UNPROCESS("未处理"), SUCCEED("成功"), PROCESSING("处理中"), FAIL("失败");
		private String cnName;

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (STATUS item : STATUS.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		STATUS(String cnName) {
			this.cnName = cnName;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}

	public static enum PRODUCT_TYPE {
		/** 大交通 **/
		TRAFFIC("大交通"),
		/** 门票 */
		TICKET("门票"),
		/** 酒店 */
		HOTEL("酒店"),
		/** 境外酒店 */
		HOTEL_FOREIGN("境外酒店"),
		/** 线路 */
		ROUTE("线路"),
		/** 其它 */
		OTHER("其它");

		private String cnName;

		PRODUCT_TYPE(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (PRODUCT_TYPE item : PRODUCT_TYPE.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		@Override
		public String toString() {
			return this.name();
		}

	}
	
	public static enum PRODUCT_TYPES {
		/** 大交通 **/
		TRAFFIC("大交通"),
		/** 门票 */
		TICKET("门票"),
		/** 酒店 */
		HOTEL("酒店"),
		/** 签证 */
		VISA("签证"),
		/** 线路 */
		ROUTE("线路"),
		/** 游轮 */
		LOOSEPULLEY("游轮");

		private String cnName;

		PRODUCT_TYPES(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (PRODUCT_TYPES item : PRODUCT_TYPES.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		@Override
		public String toString() {
			return this.name();
		}

	}
	

	/**
	 * 订单结算项的状态
	 */
	public static enum SET_SETTLEMENT_ITEM_STATUS {
		NORMAL("正常"), CANCEL("取消"), NOSETTLEMENT("不结算");
		private String cnName;

		SET_SETTLEMENT_ITEM_STATUS(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (SET_SETTLEMENT_ITEM_STATUS item : SET_SETTLEMENT_ITEM_STATUS
					.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}

	/**
	 * 是否
	 *
	 * @author Libo Wang 2012-6-26
	 * @version
	 */
	public static enum TRUE_FALSE {
		TRUE("true", "是"), FALSE("false", "否");

		private String attr1;
		private String cnName;

		TRUE_FALSE(String value, String cnName) {
			this.cnName = cnName;
			this.attr1 = value;
		}

		public String getValue() {
			return attr1;
		}

		public String getAttr1() {
			return attr1;
		}

		public String getCode() {
			return this.name().toLowerCase();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (TRUE_FALSE item : TRUE_FALSE.values()) {
				if (item.getCode().equalsIgnoreCase(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		public static String getAttr1(String code) {
			for (TRUE_FALSE item : TRUE_FALSE.values()) {
				if (item.getCode().equalsIgnoreCase(code)) {
					return item.getAttr1();
				}
			}
			return code;
		}

		@Override
		public String toString() {
			return this.name().toLowerCase();
		}
	}

	public static enum REFUNDMENT_STATUS {
		UNVERIFIED("未审核"), REFUND_APPLY("退款单申请"), APPLY_CONFIRM("已确认"), REFUND_VERIFIED(
				"退款单审核通过"), REJECTED(" 不通过（拒绝、驳回）"), VERIFIED("退款审核通过(等待退款)"), REFUNDED(
				"已退款"), REFUNDED_PART("部分退款"), CANCEL("退款单取消"), PROCESSING(
				"退款处理中"), FAIL("退款失败");

		private String cnName;

		REFUNDMENT_STATUS(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (REFUNDMENT_STATUS item : REFUNDMENT_STATUS.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}

	public static enum REFUND_ITEM_TYPE {
		VISITOR_LOSS("游客损失"), SUPPLIER_BEAR("供应商承担金额");

		private String cnName;

		REFUND_ITEM_TYPE(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (REFUND_ITEM_TYPE item : REFUND_ITEM_TYPE.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}

	public static enum ORD_ORDER_STATUS {
		/** 正常 */
		NORMAL("正常"),
		/** 取消 */
		CANCEL("取消"),
		/** 完成 （结束） */
		FINISHED("完成"),
		/** 未确认结束 */
		UNCONFIRM("未确认结束");

		private String cnName;

		ORD_ORDER_STATUS(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (ORD_ORDER_STATUS item : ORD_ORDER_STATUS.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}

	/**
	 * 订单金额修改申请类型
	 *
	 * @author yuzhibing
	 *
	 */
	public static enum ORDER_AMOUNT_MODIFY_STATUS {
		/** 未审核 */
		UNVERIFIED("未审核"),
		/** 已审核 */
		PASS("已审核"),
		/** 已确定 */
		CONFIRM("已确定"),
		/** 取消 */
		CANCEL("取消"),
		/** 审核不通过 */
		FAIL("审核不通过");

		private String cnName;

		ORDER_AMOUNT_MODIFY_STATUS(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (ORDER_AMOUNT_MODIFY_STATUS item : ORDER_AMOUNT_MODIFY_STATUS
					.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}

	public static enum PAYMENT_BIZ_TYPE {
		SUPER_ORDER("老系统订单支付"), BEE_ORDER("自由行订单支付"), ANT_ORDER("代售订单支付"), TRANSHOTEL_ORDER(
				"TRANSHOTEL订单支付"), VST_ORDER("VST订单支付"), CASH_ACCOUNT("现金帐户充值"), MERGE_PAY(
				"合并支付");
		private String cnName;

		PAYMENT_BIZ_TYPE(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (PAYMENT_BIZ_TYPE item : PAYMENT_BIZ_TYPE.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}

	public static enum PAYMENT_OPERATE_TYPE {
		PAY("正常支付"), PRE_PAY("预授权支付");

		private String cnName;

		PAYMENT_OPERATE_TYPE(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (PAYMENT_OPERATE_TYPE item : PAYMENT_OPERATE_TYPE.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}

	public static enum PAYMENT_SERIAL_STATUS {
		/** 新建 */
		CREATE("新建"),
		/** 成功 */
		SUCCESS("成功"),
		/** 失败 */
		FAIL("失败"),
		/** 已转移 */
		TRANSFERRED("已转移");

		private String cnName;

		PAYMENT_SERIAL_STATUS(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (PAYMENT_SERIAL_STATUS item : PAYMENT_SERIAL_STATUS.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}

	public static enum EBK_FAX_TASK_STATUS {
		FAX_SEND_STATUS_SUCCESS("1", "发送成功"), FAX_TASK_STATUS_SENT("10", "发送中"), FAX_SEND_STATUS_MANUAL(
				"100", "手工发送"), FAX_SEND_STATUS_DEFAULT("0", "未处理"), FAX_TASK_STATUS_CANCEL(
				"31", "用户取消"), FAX_TASK_STATUS_UNDEFINED("99", "未知错误"), FAX_TASK_STATUS_DIALTONE(
				"23", "没有拨号音"),FAX_TASK_STATUS_BUSY("24","对方忙"), FAX_TASK_STATUS_BACKTONE("25", "没有回铃音"), FAX_TASK_STATUS_NOTONE(
				"26", "长时间静音"), FAX_TASK_STATUS_BUSYLINE("29", "对方占线"), FAX_SEND_STATUS_REPLIED(
				"33", "已回传"), FAX_TASK_STATUS_PAUSE("-1", "永不发送"), FAX_TASK_STATUS_FAXNUMBER_ERROR(
				"12", "传真号码错误"), FAX_TASK_STATUS_UNMANNED("30", "无人接听或是空号");

		private String status;

		private String cnName;

		EBK_FAX_TASK_STATUS(String status, String cnName) {
			this.status = status;
			this.cnName = cnName;
		}

		public String getCode() {
			return this.name();
		}

		public String getStatus() {
			return this.status;
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnNameByCode(String code) {
			for (EBK_FAX_TASK_STATUS item : EBK_FAX_TASK_STATUS.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		public static String getCnNameByStatus(String status) {
			for (EBK_FAX_TASK_STATUS item : EBK_FAX_TASK_STATUS.values()) {
				if (item.getStatus().equals(status)) {
					return item.getCnName();
				}
			}
			return status;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}

	/**
	 * Fax Receive Status
	 *
	 * @author Libo Wang
	 *
	 */
	public static enum FAX_RECV_STATUS {
		/**
		 * 订单与传真未关联
		 */
		NOT_LINKED("未关联"),
		/**
		 * 已收到，系统自动关联
		 */
		AUTO_LINKED("自动关联"),
		/**
		 * 已收到，人工确认完成
		 */
		LINKED("已关联");

		private String cnName;

		FAX_RECV_STATUS(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (FAX_RECV_STATUS item : FAX_RECV_STATUS.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}

	public static enum SET_SETTLEMENT_BUSINESS_NAME {
		SUPER_ORDER_BUSINESS("super系统"), NEW_SUPPLIER_BUSINESS("新供应商系统");
		private String cnName;

		SET_SETTLEMENT_BUSINESS_NAME(String cnName) {
			this.cnName = cnName;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (SET_SETTLEMENT_BUSINESS_NAME item : SET_SETTLEMENT_BUSINESS_NAME
					.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}

	/**
	 * 分公司
	 *
	 * @author Libo Wang 2012-6-26
	 * @version
	 */
	public static enum FILIALE_NAME {
		SH_FILIALE("上海总部"), BJ_FILIALE("北京分部"), GZ_FILIALE("广州分部"), CD_FILIALE(
				"成都分部"), SY_FILIALE("三亚分部"), HS_FILIALE("黄山办事处"), HZ_FILIALE(
				"杭州分部");

		private String cnName;

		FILIALE_NAME(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (FILIALE_NAME item : FILIALE_NAME.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}

	public static enum SETTLEMENT_COMPANY {
		COMPANY_1("上海景域文化传播有限公司"),
		/** 上海景域旅行社有限公司 */
		COMPANY_2("上海驴妈妈国际旅行社有限公司"),
		/** 兴旅 **/
		COMPANY_3("上海驴妈妈兴旅国际旅行社有限公司");

		private String cnName;

		SETTLEMENT_COMPANY(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (SETTLEMENT_COMPANY item : SETTLEMENT_COMPANY.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}

	public static enum SETTLEMENT_STATUS {
		/** 未结算 */
		UNSETTLEMENTED("未结算"),
		/** 已确认 （不使用） */
		CONFIRMED("已确认"),
		/** 争议单（不使用） */
		DISPUTED("争议单"),
		/** 已结算 */
		SETTLEMENTED("已结算"),
		/** 结算中 */
		SETTLEMENTING("结算中"), NOSETTLEMENT("不结算");

		private String cnName;

		SETTLEMENT_STATUS(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (SETTLEMENT_STATUS item : SETTLEMENT_STATUS.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}

	public static enum SETTLEMENT_PERIOD {
		/** 每单结算 */
		PERORDER("每单结算"),
		/** 按月结算 */
		PERMONTH("按月结算"),
		/** 按季结算 */
		PERQUARTER("按季结算"),
		/** 按周结算 */
		PER_WEEK("按周结算"),
		/** 按半月结算 */
		PER_HALF_MONTH("按半月结算");

		private String cnName;

		SETTLEMENT_PERIOD(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (SETTLEMENT_PERIOD item : SETTLEMENT_PERIOD.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		@Override
		public String toString() {
			return this.name();
		}

	}

	public static enum SUB_PRODUCT_TYPE {
		/** 单票，单一门票 */
		SINGLE("单票"),
		/** 套票，同一景区多人票组合 */
		SUIT("套票"),
		/** 联票，不同景区组合 */
		UNION("联票"),
		/** 通票，同一景区所有项目组合 */
		WHOLE("通票"),
		/** 境内自由行,单人出发 */
		FREENESS("目的地自由行"),
		/** 境内跟团游,多人成团 */
		GROUP("短途跟团游"),
		/** 境外自由行,单人出发 */
		FREENESS_FOREIGN("出境自由行"),
		/** 境外跟团游,多人成团 */
		GROUP_FOREIGN("出境跟团游"),
		/** 保险 */
		INSURANCE("保险"),
		/** 单房间 */
		SINGLE_ROOM("单房间 "),
		/** 酒店套餐 */
		HOTEL_SUIT("酒店套餐"),
		/** 境外酒店 */
		HOTEL_FOREIGN("境外酒店"),
		/** 长途跟团游 */
		GROUP_LONG("长途跟团游"),
		/** 长途自由行 */
		FREENESS_LONG("长途自由行"),
		/** 自助巴士班 */
		SELFHELP_BUS("自助巴士班"),
		/** 签证 **/
		VISA("签证"),
		/** 其它 */
		OTHER("其它"),
		/** 自费 */
		OWNEXPENSE("自费"),
		/** 港务税 */
		PORTTAX("港务税"),
		/** 税金 **/
		TAX("税金"),
		/** 快递费 **/
		EXPRESS("快递费"),
		/** 房差 */
		FANGCHA("房差"),
		/** 小费 */
		TIP("小费"),
		/** 机票 */
		FLIGHT("机票"),
		/** 火车票 **/
		TRAIN("火车票"),
		/** 巴士 */
		BUS("巴士");

		private String cnName;

		SUB_PRODUCT_TYPE(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (SUB_PRODUCT_TYPE item : SUB_PRODUCT_TYPE.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		@Override
		public String toString() {
			return this.name();
		}

	}
	/**
	 * 订单价格修改类型.
	 *
	 * @author liwenzhan
	 */
	public static enum ORDER_AMOUNT_APPLAY_TYPE {
		COST_CHANGE("成本变化 "),
		STAFF_DISCOUNT("员工优惠 "),
		SPECIAL_DISCOUNT("特殊优惠"),
		CUSTOMER_DISCOUNT("大客户优惠"),
		ACTIVITY_DISCOUNT("活动优惠"),
		BUSINESS_PR_DISCOUNT("商务公关价"),
		OTHER_DISCOUNT("其他");
		private String cnName;
		ORDER_AMOUNT_APPLAY_TYPE(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(ORDER_AMOUNT_APPLAY_TYPE item:ORDER_AMOUNT_APPLAY_TYPE.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString(){
			return this.name();
		}
	}


	public static enum REFUND_TYPE {
		/** 补偿 */
		COMPENSATION("补偿"),
		/** 订单退款 */
		ORDER_REFUNDED("订单退款"),
		CASH_ACCOUNT_WITHDRAW("现金账户取现");

		private String cnName;
		REFUND_TYPE(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(REFUND_TYPE item:REFUND_TYPE.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString(){
			return this.name();
		}
	}

	public static enum REFUNDMENT_CHANNEL {
		/** 支付宝 */
		ALIPAY("支付宝"),
		/** 中国银联 */
		CHINAPAY("中国银联"),
		/** 汇付天下 */
		CHINAPNR("汇付天下"),
		/** 现金账户 */
		CASH_ACCOUNT("现金账户"),
		/** 储值卡退款*/
		STORED_CARD("储值卡退款"),
		/** 银行账户 */
		BANK_ACCOUNT("银行账户"),
		/** 中行分期*/
		BOC_INSTALMENT("中行分期");

		private String cnName;
		REFUNDMENT_CHANNEL(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(REFUNDMENT_CHANNEL item:REFUNDMENT_CHANNEL.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString(){
			return this.name();
		}
	}
	/**
	 * 投诉业务系统
	 * @author taiqichao
	 *
	 */
	public static enum COMPLAINT_SYS_CODE {
		SUPER("super系统"),
		VST("vst系统");
		private String cnName;
		COMPLAINT_SYS_CODE(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(COMPLAINT_SYS_CODE item:COMPLAINT_SYS_CODE.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString(){
			return this.name();
		}
	}

	public static enum C_CERTIFICATE_TYPE{
		ENTITY("实体票"),
		DIMENSION("二维码"),
		SMS("普通短信"),
		SUPENTITY("供应商实体票");

		private String cnName;
		C_CERTIFICATE_TYPE(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(C_CERTIFICATE_TYPE item:C_CERTIFICATE_TYPE.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString(){
			return this.name();
		}
	}

	/**
	 * 支付网关
	 * @author ZHANG Nan
	 *
	 */
	public static enum PAYMENT_GATEWAY {
		ALIPAY_CLIENT("支付宝客户度"),
		ALIPAY("支付宝"),
		@Deprecated
		CHINAPAY("中国银联"),
		UNIONPAY("银联"),
		CHINAPAY_PRE("银联预授权"),
		CASH_ACCOUNT("现金账户"),
		CASH_BONUS("奖金账户"),
		@Deprecated
		ONE_CITY_ONE_CARD("新华一卡通"),
		CMB("招商银行"),
		SPDB("上海浦东发展银行"),
		CMB_INSTALMENT("招商银行分期"),
		COMM("交通银行"),
		COMM_POS("交通银行POS机"),
		COMM_POS_CASH("交通银行POS机现金支付"),
		SAND_POS("杉德POS机"),
		SAND_POS_CASH("杉德POS机现金支付"),
		BOC("中国银行"),
		@Deprecated
		SHENGPAY("盛付通"),
		PAY_0_YUAN("订单金额为0"),
		STORED_CARD("储值卡"),
		LYTXK_STORED_CARD("驴游天下卡"),
		BOC_INSTALMENT("中国银行分期"),
		UPOMP("手机端银联支付"),
		ALIPAY_DIRECTPAY("支付宝快捷"),
		ALIPAY_WAP("支付宝手机WAP支付"),
		ALIPAY_WAP_CREDITCARD("支付宝手机WAP信用卡支付"),
		ALIPAY_WAP_DEBITCARD("支付宝手机WAP储值卡支付"),
		ALIPAY_APP("支付宝手机APP支付"),
		CHINAPNR("汇付天下"),
		@Deprecated
		ALLINPAY("通联支付"),
		TELBYPAY("百付电话 支付"),
		ALIPAY_OFFLINE("淘宝订单"),
		LAKALA("拉卡拉支付"),
		ALIPAY_BPTB("支付宝批量付款到银行"),
		ALIPAY_BATCH("支付宝批量付款到支付宝帐号"),
		CHINA_MOBILE_PAY("中国移动支付"),
		NING_BO_BANK("宁波银行"),
		ICBC("工商银行"),
		TENPAY("财付通"),
		TENPAY_APP("财付通手机APP支付"),
		TENPAY_WAP("财付通手机WAP支付"),
		ICBC_INSTALMENT("工商银行分期");

		private String cnName;
		PAYMENT_GATEWAY(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(PAYMENT_GATEWAY item:PAYMENT_GATEWAY.values()){
				if(item.getCode().equals(code)){
					return item.getCnName();
				}
			}
			return code;
		}
	}

	/**
	 * 分销或团购支付网关
	 * @author ZHANG Nan
	 *
	 */
	public static enum PAYMENT_GATEWAY_DIST_MANUAL {
		YIHAODIAN("1号店"),
		ZHEJIANGLVYOU_TIANMAO("浙江旅游局天猫店"),
		FENXIAO_SPDB("分销浦发银行"),
		FENXIAO_COMM("分销交通银行"),
		FENXIAO_360BUY("分销京东商城"),
		FENXIAO_QUNA("分销去哪儿线路"),
		FENXIAO_ZHOUWU("周五网分销"),
		FENXIAO_QUNA_TUAN("分销去哪儿线路团购"),
		FENXIAO_QUNA_TICKET("分销去哪儿门票"),
		FENXIAO_QUNA_TICKET_TUAN("分销去哪儿门票团购"),
		FENXIAO_JINGDONG("京东分销"),
		FENXIAO_JINZONGLV("分销商支付-金棕榈"),
		FENXIAO_SHMOBILE("上海移动分销"),
		FENXIAO_UNICOM114("联通114分销"),
		FENXIAO_ELONG("分销艺龙"),
		FENXIAO_YINLIAN("分销支付-银联"),
		FENXIAO_NAVIDOG("分销支付-导航犬"),
		FENXIAO_SUNING("分销支付-苏宁易购"),
		FENXIAO_XIEXIE("分销支付-谢谢网团购分销"),
		FENXIAO_LASHOU("分销支付-拉手网团购分销"),
		FENXIAO_YODODO("分销支付-游多多分销"),
		FENXIAO_WONJAM("分销支付-河南万家分销"),
		FENXIAO_RENWOYOU("分销支付-任我游分销"),
		ALIPAY_OFFLINE("淘宝B店"),
		EXPORT_DIEM("导码专用"),
		TUANG0U_360BUY("京东团购"),
		TUANG0U_MANZUO("满座团购"),
		TUANG0U_ENJOYOUNG("星尚团购"),
		TUANG0U_55TUAN("窝窝团团购"),
		TUANG0U_QUNA("去哪儿团购"),
		TUANG0U_FTUAN("F团团购"),
		TUANG0U_TAOBAO_JUHUASUAN("聚划算团购"),
		TUANG0U_NUOMI("糯米团团购"),
		TUANG0U_JUQI("聚齐团购"),
		TUANG0U_XIECHENG("携程团购"),
		TUANG0U_MEITUAN("美团团购"),
		TUANG0U_ELONG("艺龙团购");

		private String cnName;
		PAYMENT_GATEWAY_DIST_MANUAL(String name) {
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (PAYMENT_GATEWAY_DIST_MANUAL item : PAYMENT_GATEWAY_DIST_MANUAL.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}
	}
	/**
	 * 其它支付网关
	 * @author ZHANG Nan
	 *
	 */
	public static enum PAYMENT_GATEWAY_OTHER_MANUAL {
		CASH("现金"),
		@Deprecated
		CHEQUE("支票"),
		EXCHANGE("银行转账"),
		POST("邮局汇款"),
		FEIDAN_CHONGXIA("废单重下"),
		MARKET_COST("市场营销费"),
		BENEFITS_COST("福利费"),
		DUOMEIZI("多美滋"),
		TEST("测试付款");

		private String cnName;
		PAYMENT_GATEWAY_OTHER_MANUAL(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(PAYMENT_GATEWAY_OTHER_MANUAL item:PAYMENT_GATEWAY_OTHER_MANUAL.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
	}

	public static enum PAYMENT_PRE_STATUS {
		/** 预授权新建*/
		CREATE("新建"),
		/** 预授权支付*/
		PRE_PAY("预授权支付成功"),
		/** 预授权完成*/
		PRE_SUCC("预授权完成(确认扣款)"),
		/** 预授权完成撤销*/
		PRE_SUCC_CANCEL("预授权完成撤销"),
		/** 预授权撤销*/
		PRE_CANCEL("预授权撤销"),
		/** 预授权退款*/
		PRE_REFUND("预授权退款");

		private String cnName;

		PAYMENT_PRE_STATUS(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(PAYMENT_PRE_STATUS item:PAYMENT_PRE_STATUS.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString(){
			return this.name();
		}
	}

	public static enum CERT_TYPE {
		CUSTOMER_SERVICE_ADVICE("客服联系我"),
		ERTONG("儿童无证件"),
		GANGAO("港澳通行证"),
		HUIXIANG("回乡证"),
		HUZHAO("护照"),
		ID_CARD("身份证"),
		JUNGUAN("军官证"),
		OTHER("其他"),
		TAIBAO("台胞证");

		private String cnName;
		CERT_TYPE(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(CERT_TYPE item:CERT_TYPE.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString(){
			return this.name();
		}
	}
	
	public enum EBK_SMS_SEND_STATUS {
		UNSENT("未发送","UNSENT"),
		SENT("已发送", "SENT"),
		SENT_FAILED("发送失败", "SENT_FAILED");
		
		private String name;
		private String value;
		EBK_SMS_SEND_STATUS(String name, String value) {
			this.name = name;
			this.value = value;
		}
		public String getName() {
			return name;
		}
		public String getValue() {
			return value;
		}
	}

	public static enum ORDER_STATUS_ENUM {
		/** 正常 */
		NORMAL("正常"),
		/** 取消 */
		CANCEL("取消"),
		/** 完成 （结束） */
		FINISHED("完成"),
		/** 未确认结束 */
		UNCONFIRM("未确认结束");

		private String cnName;
		ORDER_STATUS_ENUM(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(ORDER_STATUS_ENUM item: ORDER_STATUS_ENUM.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString(){
			return this.name();
		}
	}

	public static enum ORDER_VIEW_STATUS {
		/** 待签约 */
		UNSIGNED("待签约"),
		/** 已签约 */
		SIGNED("已签约"),
		/** 待审核 */
		UNVERIFIED("待审核"),
		/** 已审核 */
		VERIFIED("已审核"),
		/** 待支付 */
		UNPAY("待支付"),
		/** 部分支付 */
		PARTPAY("部分支付"),
		/** 已支付 */
		PAYED("已支付"),
		/** 完成 */
		FINISHED("完成"),
		/** 取消 */
		CANCEL("已取消"),
		PREPAYED("预授权支付");

		private String cnName;
		ORDER_VIEW_STATUS(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(ORDER_VIEW_STATUS item:ORDER_VIEW_STATUS.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString(){
			return this.name();
		}
	}

	/**
	 * 是否预授权支付
	 *
	 * @return
	 */
	public boolean isPrepayAble() {
		String jobEnabled = properties.getProperty("prepayAble");
		if (log.isDebugEnabled()) {
			log.debug("job is runnable: " + jobEnabled + " => "
					+ ("true".equals(jobEnabled)));
		}
		if (jobEnabled != null) {
			return Boolean.valueOf(jobEnabled);
		} else {
			return true;
		}
	}

	/**
	 * 是否使用工作流
	 * @return
	 */
	public boolean isActivitiAble(){
		String jobEnabled = properties.getProperty("order.activitiAble");
		if (log.isDebugEnabled()&&jobEnabled != null) {
			log.debug("activitiAble: " + jobEnabled + " => "
					+ ("true".equals(jobEnabled)));
		}
		if (jobEnabled != null) {
			return Boolean.valueOf(jobEnabled);
		} else {
			return true;
		}
	}

	public static enum CANCEL_STRATEGY {

		ABLE("可退改"),
		FORBID("不退不改"),
		MANUAL("人工确定退改");

		private String cnName;

		CANCEL_STRATEGY(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(CANCEL_STRATEGY item: CANCEL_STRATEGY.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString(){
			return "code:"+this.name()+",cnName:"+this.cnName;
		}
	}

	public static enum PRICE_TYPE{
		/**固定价**/
		FIXED_PRICE("固定价"),
		/**比例加价**/
		RATE_PRICE("比例加价"),
		/**固定加价**/
		FIXED_ADD_PRICE("固定加价");
		private String cnName;
		PRICE_TYPE(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(PRICE_TYPE item:PRICE_TYPE.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString(){
			return this.name();
		}
	}

	public enum TRAIN_SEAT_CATALOG{
		SC_201("201", "商务座"),
		SC_202("202", "特等座"),
		SC_203("203", "一等座"),
		SC_204("204", "二等座"),
		SC_205("205", "高级软卧"),
		SC_206("206", "高级软卧上"),
		SC_207("207", "高级软卧下"),
		SC_208("208", "软卧"),
		SC_209("209", "软卧上"),
		SC_210("210", "软卧下"),
		SC_211("211", "硬卧"),
		SC_212("212", "硬卧上"),
		SC_213("213", "硬卧中"),
		SC_214("214", "硬卧下"),
		SC_215("215", "软座"),
		SC_216("216", "硬座"),
		SC_217("217", "无座");

		private String attr1;
		private String cnName;

		TRAIN_SEAT_CATALOG(String value, String cnName) {
			this.cnName = cnName;
			this.attr1 = value;
		}

		public String getValue() {
			return attr1;
		}

		public String getAttr1() {
			return attr1;
		}

		public String getCode(){
			return this.name().toLowerCase();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(TRAIN_SEAT_CATALOG item:TRAIN_SEAT_CATALOG.values()){
				if (code.startsWith("SC_")
						&& item.getCode().equalsIgnoreCase(code)
						|| item.getAttr1().equalsIgnoreCase(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		public static String getAttr1(String code){
			for(TRAIN_SEAT_CATALOG item:TRAIN_SEAT_CATALOG.values()){
				if(item.getCode().equalsIgnoreCase(code)) {
					return item.getAttr1();
				}
			}
			return code;
		}

		@Override
		public String toString(){
			return this.name().toLowerCase();
		}
	}

	/**
	 * 取得火车票是否可用
	 * @return String
	 */
	public boolean hasTrainSaleEnable(){
		String str = properties.getProperty("train.sale.enable");
		return StringUtils.equals(str, "true");
	}

	public String getPrefixPic() {
		return properties.getProperty("prefix_pic");
	}

	public static enum ROUTE_SUB_PRODUCT_TYPE{
		/**目的地自由行*/
		FREENESS("目的地自由行"),
		/**短途跟团游*/
		GROUP("短途跟团游"),
		/**出境自由行*/
		FREENESS_FOREIGN("出境自由行"),
		/**出境跟团游*/
		GROUP_FOREIGN("出境跟团游"),
		/**长途跟团游*/
		GROUP_LONG("长途跟团游"),
		/**长途自由行*/
		FREENESS_LONG("长途自由行"),
		/**自助巴士班*/
		SELFHELP_BUS("自助巴士班");

		private String cnName;
		ROUTE_SUB_PRODUCT_TYPE(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(ROUTE_SUB_PRODUCT_TYPE item:ROUTE_SUB_PRODUCT_TYPE.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString(){
			return this.name();
		}
	}

	/**
	 * 产品TagName
	 * @author YuanXueBo
	 *
	 */
	public static enum PROD_TAG_GROUP_NAME {

		BRAND_TAG("品牌标签"),
		GIVE_COUPON("优惠");

		private String cnName;

		PROD_TAG_GROUP_NAME(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(PROD_TAG_GROUP_NAME item: PROD_TAG_GROUP_NAME.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString(){
			return "code:"+this.name()+",cnName:"+this.cnName;
		}
	}

	public static enum CHANNEL {
		WEIXIN("微信"),
		LIANTONG("联通"),
		TAOBAL("淘宝"),
		TAOBAO_DISTRIBUTOR("淘宝分销"),
		TAOBAO_DISTRIBUTOR_CHANGLONG("淘宝分销长隆"),
		ETICKET("淘宝电子平台"),
		OTHER("其它分销"),
		ZHONGKANG("中康分销"),
		BACKEND("驴妈妈后台"),
		FRONTEND("驴妈妈前台"),
		WAP("WAP"),
		WP8("WP8"),
		SERVICESTATION("服务站"),
		CLIENT("客户端"),
		TOUCH("触屏版"),
		//ANDROID("安卓"),
		HUANLEGU("上海欢乐谷"),
		CTRIP("携程分销"),
		//SYBAIN("赛班"),
		TUANGOU("驴妈妈团购"),
		OCJ("东方CJ"),
		HAOYIGO("好易购"),
		SANYA_QUNA("三亚去哪儿"),
		ZHEJIANGLVYOU_TIANMAO("浙江旅游局天猫店"),
		TAOBAO_ZHEKOUDIAN("旅游票务折扣店—总部淘宝"),
		TAOBAO_TEHUIWANG("特惠票务网—总部淘宝"),
		EXPORT_DIEM("导码专用"),
		DIST_YUYUE("分销预约平台"),
		DISTRIBUTION_YIHAODIAN("1号店"),
		DISTRIBUTION_JINGDONG("京东分销"),
		DISTRIBUTION_YINLIAN("银联分销"),
		DISTRIBUTION_QUNA("去哪线路分销"),
		DISTRIBUTION_ZHOUWU("周五网分销"),
		DISTRIBUTION_QUNA_TUAN("去哪儿线路团购平台"),
		DISTRIBUTION_QUNA_TICKET("去哪门票分销"),
		DISTRIBUTION_QUNA_TICKET_TUAN("去哪儿门票团购平台"),
		DISTRIBUTION_JINZONGLV("金棕榈分销"),
		DISTRIBUTION_UNICOM114("联通114分销"),
		DISTRIBUTION_SHMOBILE("上海移动"),
		DISTRIBUTION_NAVIDOG("导航犬"),
		DISTRIBUTION_SUNING("苏宁易购"),
		DISTRIBUTION_XIEXIE("谢谢网团购分销"),
		DISTRIBUTION_LASHOU("拉手网团购分销"),
		DISTRIBUTION_YODODO("游多多分销"),
		DISTRIBUTION_WONJAM("河南万家分销"),
		DISTRIBUTION_CKDEVICE("立式设备"),
		DISTRIBUTION_RENWOYOU("任我游分销"),
		TMALL_CHENGDU("天猫成都店"),
		LVTU_TEAM_BUYING("驴途团购");
		private String cnName;
		CHANNEL(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(CHANNEL item:CHANNEL.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString(){
			return this.name();
		}
	}

	public static enum PLACE_TYPE {
		ISLAND("洲"),
		COUNTRY("国家"),
		PROVINCE("省份/州/郡"),
		ZZQ("自治区"),
		ZXS("直辖市"),
		TBXZQ("特别行政区"),
		CITY("城市 "),
		AREA("区县"),
		//FOREIGN("出境目的地"),
		OTHER("特殊");
		private String cnName;
		PLACE_TYPE(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static List<PageElementModel> getList(){
			List<PageElementModel> list=new ArrayList<PageElementModel>();
			PageElementModel sm=null;
			for(PLACE_TYPE item:PLACE_TYPE.values()){
				sm=new PageElementModel();
				sm.setElementCode(item.getCode());
				sm.setElementValue(item.getCnName());
				list.add(sm);
			}
			return list;
		}
		@Override
		public String toString(){
			return this.name();
		}

		public static String getCnName(String code){
			for(PLACE_TYPE item:PLACE_TYPE.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
	}

	public static enum PLACE_STAGE {
		PLACE_FOR_DEST("1", "目的地"),
		PLACE_FOR_SCENIC("2", "景区"),
		PLACE_FOR_HOTEL("3", "酒店");

		private String code;
		private String cnName;

		PLACE_STAGE(String code, String cnName) {
			this.code = code;
			this.cnName = cnName;
		}

		public String getCode() {
			return code;
		}

		public String getCnName() {
			return cnName;
		}
		/**
		 *
		 * @param code
		 * @return
		 * @author nixianjun 2013.8.15
		 */
		public static String getCnName(String code) {
			for (PLACE_STAGE type :PLACE_STAGE.values()) {
				if (type.getCode().equals(code)) {
					return type.getCnName();
				}
			}
			return code;
		}

		public Map<String, String> getMap() {
			Map<String, String> map = new HashMap<String, String>();
			for (PLACE_STAGE type :PLACE_STAGE.values()) {
				map.put(type.getCode(), type.getCnName());
			}
			return map;
		}
	}

	/**
	 * 纬度的等级分数
	 */
	public static enum LATITUDE_GRADE_SCORE {
		/**
		 * 纬度的等级差
		 */
		BAD("差", 1),
		/**
		 * 纬度的等级一般
		 */
		GENERAL("一般", 2),
		/**
		 * 纬度的等级好
		 */
		GOOD("好", 3),
		/**
		 * 纬度的等级比较好
		 */
		BETTER("比较好", 4),
		/**
		 * 纬度的等级非常好
		 */
		PERFECT("非常好", 5);

		/** 等级名字*/
		private String gradeName;
		/** 等级分数*/
		private int gradeScore;
		/**
		 * 私有构造函数
		 * @param gradeName1 等级名字
		 * @param gradeScore1 等级分数
		 */
		private LATITUDE_GRADE_SCORE(final String gradeName1, final int gradeScore1) {
			this.gradeName = gradeName1;
			this.gradeScore = gradeScore1;
		}
		@Override
		public String toString() {
			return gradeName;
		}
		public int getScore() {
			return gradeScore;
		}
	}

	/**
	 * 旅游电子合同发送人地址
	 *
	 * @return
	 */
	public String getEcontractEmailAddress() {
		return properties.getProperty("econtract.email");
	}
	
	/**
	 * 金棕榈电子合同同步URL
	 * @return
	 */
	public String getContractSyncUrl() {
		return properties.getProperty("contract.sync.webservice.url");
	}
	
	/**
	 * 金棕榈电子合同同步的尝试同步次数
	 * @return
	 */
	public String getContractSyncTimes() {
		return properties.getProperty("contract.sync.try.times");
	}
	
	/**
	 * 金棕榈电子合同同步认证用户名
	 * @return
	 */
	public String getContractSyncUsername() {
		return properties.getProperty("contract.sync.username");
	}
	
	/**
	 * 金棕榈电子合同同步认证密码
	 * @return
	 */
	public String getContractSyncPassword() {
		return properties.getProperty("contract.sync.password");
	}
	
	public String getActivitiClearCreateTime() {
		return properties.getProperty("activiti.clear.createTime");
	}

	public String getActivitiClearVisitTime() {
		return properties.getProperty("activiti.clear.visitTime");
	}

	public String getActivitiClearOrderStatus() {
		return properties.getProperty("activiti.clear.orderStatus");
	}

	public String getActivitiClearPaymentStatus() {
		return properties.getProperty("activiti.clear.paymentStatus");
	}

	public String getActivitiClearPaymentTarget() {
		return properties.getProperty("activiti.clear.paymentTarget");
	}
	
	public String getActivitiClearCount() {
		return properties.getProperty("activiti.clear.count");
	}
	
	public String getActivitiClearExitTime() {
		return properties.getProperty("activiti.clear.exitTime");
	}
	
	public String getFlightOrderDetailUrl() {
		return properties.getProperty("flight.order.detail.url");
	}
	
	public static enum CABIN_TYPE {
		INSIDE_ROOM("内舱房"),
		SEAVIEW_ROOM("海景房"),
		BALCONY_ROOM("阳台房"),
		SUITE_ROOM("套房");

		private String cnName;

		CABIN_TYPE(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}

		public static List<PageElementModel> getList() {
			List<PageElementModel> list = new ArrayList<PageElementModel>();
			PageElementModel sm = null;
			for (CABIN_TYPE item : CABIN_TYPE.values()) {
				sm = new PageElementModel();
				sm.setElementCode(item.getCode());
				sm.setElementValue(item.getCnName());
				list.add(sm);
			}
			return list;
		}
		@Override
		public String toString(){
			return this.name();
		}

		public static String getCnName(String code){
			for(CABIN_TYPE item: CABIN_TYPE.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
	}


	public static enum ACTIVITY_TYPE {
		 eraly_order_type("早订早惠"),
		 more_order_more_favorable("多订多惠"),
		 IMMEDIATELY_FAVORABLE("立减"),
		 LINERfAVORABLE("邮轮优惠"),
		 ORDERCHANNELFAVORABLE("渠道优惠"),
		 hotel_favorable("酒店优惠");
		private String cnName;

		ACTIVITY_TYPE(String name){
			this.cnName=name;
		}

		public String getCode(){
			return this.name();
		}

		public String getCnName(){
			return this.cnName;
		}

		public static String getCnName(String code){
			for(ACTIVITY_TYPE item:ACTIVITY_TYPE.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}

		public static String getCode(String name){
			for(ACTIVITY_TYPE item:ACTIVITY_TYPE.values()){
				if(item.getCnName().equals(name))
				{
					return item.getCode();
				}
			}
			return "";
		}

		@Override
		public String toString(){
			return this.name();
		}
	}

	public static enum POLICY_PERSON {
		APPLICANT("投保人"), INSURANT("被保险人");
		private String cnName;
		POLICY_PERSON(String name) {
			this.cnName = name;
		}
		public String getCode() {
			return this.name();
		}
		public String getCnName() {
			return this.cnName;
		}
		public static String getCnName(String code) {
			for (POLICY_PERSON item : POLICY_PERSON.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString() {
			return this.name();
		}
	}

	//保险服务商
	public static enum POLICY_CODE {
		TAIPING("太平"), RENBAO("人保"),PINGAN("平安"), RENBAOPNC("人保财产"), MEIYA("美亚");
		private String cnName;
		POLICY_CODE(String name) {
			this.cnName = name;
		}
		public String getCode() {
			return this.name();
		}
		public String getCnName() {
			return this.cnName;
		}

        public static String getCnName(String code) {
            POLICY_CODE result = getPolicyCodeByName(code);
            if (null != result) {
                code = result.getCnName();
            }
            return code;
        }
		@Override
		public String toString() {
			return this.name();
		}

        public static POLICY_CODE getPolicyCodeByName(String code) {
            for (POLICY_CODE item : POLICY_CODE.values()) {
                if (item.getCode().equals(code)) {
                    return item;
                }
            }
            return null;
        }
	}

	public boolean isPingAnInsure() {
		String jobEnabled = properties.getProperty("pinganinsure.enabled");
		if (jobEnabled != null) {
			return Boolean.valueOf(jobEnabled);
		} else {
			return true;
		}
	}

	/** 投保几种状态*/
	public static enum POLICY_TYPE {
				
		POLICY_REPLY("投保操作"), REMOVE_REPLY("废保操作");
		private String cnName;
		POLICY_TYPE(String name) {
			this.cnName = name;
		}
		public String getCode() {
			return this.name();
		}
		public String getCnName() {
			return this.cnName;
		}
		public static String getCnName(String code) {
			for (POLICY_TYPE item : POLICY_TYPE.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString() {
			return this.name();
		}
	}
	
	
	public static enum POLICY_RESULT {
		/** 投保成功 */
		REQUEST_SUCCESS("投保成功"),
		/** 投保失败 */
		REQUEST_FAILURE("投保失败"),
		/** 取消成功 */
		CANCEL_SUCCESS("废保成功"),
		/** 取消失败 */
		CANCEL_FAIL("废保失败"),
		/**平安保险保单查询**/
		SEARCH_SUCCESS("查询成功"),
		/**平安保险保单查询失败 */
		SEARCH_FAIL("查询失败"),	
		REQUEST_CANCLE("投保取消"),
		APPLYING("投保中"),
		DESTORYING("废保中"),
		/** 调用对方接口失败：网络连接失败，或等待返回超时等 */
		SOCKET_TIMEOUT("网络连接超时");

		private String cnName;
		POLICY_RESULT(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(POLICY_RESULT item:POLICY_RESULT.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString(){
			return this.name();
		}
	}

	/** 太保--险种代码 */
	public static enum TAIPING_XZDM {
		CODE1("太平旅游意外伤害保险单(特惠型门票)", 1), CODE2("太平旅游意外伤害保险单(尊贵型门票)", 2), CODE3("太平旅游意外伤害保险单(豪华型门票)", 3),
		CODE4("太平旅游意外伤害保险单(特惠型自由行)", 4), CODE5("太平旅游意外伤害保险单(特惠型自由行)", 5), CODE6("太平旅游意外伤害保险单(特惠型短线)", 6),
		CODE7("太平旅游意外伤害保险单(尊贵型短线)", 7), CODE8("太平旅游意外伤害保险单(特惠型长线)", 8), CODE9("太平旅游意外伤害保险单(尊贵型长线)", 9),
		CODE10("太平国内游意外伤害保险单（促销）", 10), CODE11("太平列车意外伤害保险单（20元保费，50万保额）", 11), CODE12("太平列车意外伤害保险单（10元保费，25万保额）", 12),
		CODE13("太平驴妈妈航空意外伤害保险单（方案一50万）", 13), CODE14("太平驴妈妈航空意外伤害保险单（方案二100万）", 14);
		private String cnName;
		private int index;

		private TAIPING_XZDM(String name, int index) {
			this.cnName = name;
			this.index = index;
		}
		public static String getCnName(int index) {
			for (TAIPING_XZDM c : TAIPING_XZDM.values()) {
				if (c.getIndex() == index) {
					return c.cnName;
				}
			}
			return null;
		}
		public String getCode() {
			return this.name();
		}
		public int getIndex() {
			return index;
		}
	}
	/** 人保--险种代码 */
	public static enum RENBAO_XZDM {
		CODE1("人保安心游游轮专属意外伤害保险(基本计划)", "D31007"), CODE2("人保安心游游轮专属意外伤害保险(全面计划)", "D31008"), CODE3("人保安心游游轮专属意外伤害保险(高端计划)", "D31009");
		private String cnName;
		private String index;

		private RENBAO_XZDM(String name, String index) {
			this.cnName = name;
			this.index = index;
		}
		public static String getCnName(String index) {
			for (RENBAO_XZDM c : RENBAO_XZDM.values()) {
				if (c.getIndex().equals(index)) {
					return c.cnName;
				}
			}
			return null;
		}
		public String getCode() {
			return this.name();
		}
		public String getIndex() {
			return index;
		}
	}

	public static enum PINGAN_XZDM {
		CODE1("驴妈妈港澳游(特惠型)", "02217"), CODE2("驴妈妈港澳游(尊贵型)", "02218"), 
		CODE3("驴妈妈亚洲游(除日本、港澳)(经济型)", "02219"),CODE4("驴妈妈亚洲游(除日本、港澳)(特惠型)", "02220"),
		CODE5("驴妈妈亚洲游(除日本、港澳)(尊贵型)", "02221"),CODE6("驴妈妈日本游特惠型(特惠型)", "02222"),
		CODE7("驴妈妈日本游特惠型(尊贵型)", "02223"),CODE8("驴妈妈欧美加非特惠型(特惠型)", "02224"),
		CODE9("驴妈妈欧美加非特惠型(尊贵型)", "02225");
		private String cnName;
		private String index;

		private PINGAN_XZDM(String name, String index) {
			this.cnName = name;
			this.index = index;
		}
		public static String getCnName(String index) {
			for (PINGAN_XZDM c : PINGAN_XZDM.values()) {
				if (c.getIndex().equals(index)) {
					return c.cnName;
				}
			}
			return null;
		}
		public String getCode() {
			return this.name();
		}
		public String getIndex() {
			return index;
		}
	}

	public static enum MARK_PAYMENT_CHANNEL {
//		CIB("兴业银行"),
//		CHINAPAY("中国银联"),
//		ALIPAY_CEBBANK("光大银行"),
		UNIONPAY("银联"),
		BOC_INSTALMENT("中行分期"),
		CMB("招商银行"),
		COMM("交通银行"),
		ALIPAY_APP("支付宝APP"),
		ALIPAY_WAP("支付宝WAP"),
		UPOMP("手机端银联支付"),
		SPDB("上海浦东发展银行"),
		ALIPAY("支付宝"),
		ICBC_INSTALMENT("工商银行分期"),
		ABC_BANK("中国农业银行"),
		BAIDU_PAY("百度支付"),
		WECHAT_PAY("微信支付");
//		ONE_CITY_ONE_CARD("新华一城卡")


		private String cnName;
		MARK_PAYMENT_CHANNEL(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(MARK_PAYMENT_CHANNEL item:MARK_PAYMENT_CHANNEL.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString(){
			return this.name();
		}
	}

	/**
	 * 优惠规则
	 * @author Brian
	 * 备注：规则命名必须AMOUNT_或DISCOUNT_起头
	 */
	public static enum FAVOR_TYPE {

		/**
		 *  ----------  优惠券的关键字  ---------------
		 */
		/** 满X元后，一次性优惠Y元**/
		AMOUNT_AMOUNT_WHOLE("一次性优惠{Y}元"),
		/** 满X元后，每满Y元，优惠Z元**/
		AMOUNT_AMOUNT_INTERVAL("满{X}元后，每满{Y}元，优惠{Z}元"),
		/** 满X份后，一次性优惠Y元**/
		AMOUNT_QUANTITY_WHOLE("满{X}份后，一次性优惠{Y}元"),
		/** 满X份后，每满Y份，优惠Z元**/
		AMOUNT_QUANTITY_INTERVAL("满{X}份后，每满{Y}份，优惠{Z}元"),
		/** 满X份后，每份优惠Y元**/
		AMOUNT_QUANTITY_PRE("满{X}份后，每份优惠{Y}元"),
		/** 满X元后，一次性享受Y折扣**/
		DISCOUNT_AMOUNT_WHOLE("满{X}元后，一次性享受{Y}折扣"),
		/** 满X份，一次性享受Y折扣**/
		DISCOUNT_QUANTITY_WHOLE("满{X}份，一次性享受{Y}折扣"),
		/** 满X份，每满Y份，超出部分销售价享受Z折扣 **/
		DISCOUNT_QUANTITY_PRE("满{X}份，每满{Y}份，超出部分销售价享受{Z}折扣"),

		/**
		 *  ----------  优惠活动的关键字  ---------------
		 *  采购产品金额存Z元，销售产品金额存Y元
		 */
		/** 提前{X}天后，每份优惠{Y/Z}元**/
		AMOUNT_EARLYDAY_QUANTITY_PRE("提前{X}天后，每份(间夜)，价格优惠金额{Y/Z}元"),
		/**提前{X}天后，每份享受{Y}折扣**/
		DISCOUNT_EARLYDAY_QUANTITY_PRE("提前{X}天后，销售价享受{Y/Z}折扣"),
		/** 每满X份后，每份优惠折扣率为Y% **/
		DISCOUNT_MORE_QUANTITY_INTERVAL("每满{X}份后，每份优惠折扣率为{Y/Z}"),
		/** 满X份后，每份优惠{Y}元**/
		DISCOUNT_MORE_QUANTITY_PRE("满{X}份，每份优惠折扣率为{Y/Z}"),
		/** 每满X份后，每份优惠{Y}元**/
		AMOUNT_MORE_QUANTITY_INTERVAL("每满{X}份，总价优惠{Y/Z}元"),
		/**满X份后，每满Y份，每份优惠Z元**/
		AMOUNT_MORE_QUANTITY_WHOLE("满{X}份后，每增加{Y}份，总价优惠{Z}元"),
		/** 满X份后，每份优惠Y元**/
		AMOUNT_MORE_QUANTITY_PRE("满{X}份起，单价优惠{Y/Z}元"),
		/**
		 * 超级优惠，优惠金额由生成订单那时计算出
		 */
		AMOUNT_AMOUNT_SUPER("超级优惠");

		private String cnName;
		FAVOR_TYPE(String cnName){
			this.cnName=cnName;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(FAVOR_TYPE item:FAVOR_TYPE.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString(){
			return "code:"+this.name()+",cnName:"+this.cnName;
		}
	}

	public static enum COUPON_TARGET {
		/**
		 * 针对产品.
		 */
		PRODUCT("针对产品"),
		/**
		 * 针对订单.
		 */
		ORDER("针对订单");

		private String cnName;
		COUPON_TARGET(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(COUPON_TARGET item:COUPON_TARGET.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString(){
			return this.name();
		}
	}

	public static enum COUPON_FAVOR_MODE {
		/**
		 * 按金额.
		 */
		AMOUNT("按金额"),
		/**
		 * 按折扣.
		 */
		DISCOUNT("按折扣");

		private String cnName;
		COUPON_FAVOR_MODE(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(COUPON_FAVOR_MODE item:COUPON_FAVOR_MODE.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString(){
			return "code:"+this.name()+",cnName:"+this.cnName;
		}
	}

	public static enum COUPON_FAVOR_RULE {
		/**
		 * 按订单金额.
		 */
		AMOUNT("按订单金额"),
		/**
		 * 按订购份数.
		 */
		QUANTITY("按订购份数");

		private String cnName;
		COUPON_FAVOR_RULE(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(COUPON_FAVOR_RULE item:COUPON_FAVOR_RULE.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString(){
			return "code:"+this.name()+",cnName:"+this.cnName;
		}
	}

	public static enum COUPON_TYPE {
		/**
		 * A类无限次
		 */
		A("A类无限次"),
		/**
		 * B类只使用一次
		 */
		B("B类只使用一次");

		private String cnName;
		COUPON_TYPE(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(COUPON_TYPE item:COUPON_TYPE.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString(){
			return this.name();
		}
	}

	public static enum LINE_TRAFFIC{
		TRAIN("火车","1"),
		SHIP("邮轮","2"),
		FLIGHT("飞机","3"),
		BUS("大巴","4"),
		CATEGORY_TRAFFIC("大交通","5"),
		CATEGORY_TRAFFIC_AEROPLANE("飞机","6"),
		CATEGORY_TRAFFIC_AERO_OTHER("飞机","7"),
		CATEGORY_TRAFFIC_TRAIN("火车","8"),
		CATEGORY_TRAFFIC_TRAIN_OTHER("火车","9"),
		CATEGORY_TRAFFIC_BUS("大巴","10"),
		CATEGORY_TRAFFIC_BUS_OTHER("大巴","11"),
		CATEGORY_TRAFFIC_SHIP("邮轮","12"),
		CATEGORY_TRAFFIC_SHIP_OTHER("邮轮","13");
		private String cnName;
		private String code;
		LINE_TRAFFIC(String cnName,String code){
			this.cnName=cnName;
			this.code = code;
		}
		public String getCnName() {
			return cnName;
		}
		public void setCnName(String cnName) {
			this.cnName = cnName;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public static boolean hasLineTraffic(String name){
			if (name==null || "".equals(name)) {
				return false;
			}
			for (LINE_TRAFFIC lineTraffic : LINE_TRAFFIC.values()) {
				if (lineTraffic.name().equals(name)) {
					return true;
				}
			}
			return false;
		}
		public static String getCnName(String code){
			for(LINE_TRAFFIC item:LINE_TRAFFIC.values()){
				if(StringUtils.equalsIgnoreCase(item.name(), code))
				{
					return item.getCnName();
				}
			}
			return null;
		}
		public static String getName(String code){
			for(LINE_TRAFFIC item:LINE_TRAFFIC.values()){
				if(StringUtils.equalsIgnoreCase(item.getCode(), code))
				{
					return item.name();
				}
			}
			return "";//不要null
		}

		public static String getCode(String name){
			for(LINE_TRAFFIC item:LINE_TRAFFIC.values()){
				if(StringUtils.equals(item.name(), name))
				{
					return item.getCode();
				}
			}
			return "";
		}
	}
	public static enum SON_CATEGORY_ID{
		TICKET("门票","11,12"),
		ROUTE("全部线路","15,16,17,18"),
		YOULUN("邮轮","8"),
		ALL("全部","8,11,12,15,16,17,18");
		private String cnName;
		private String code;

		SON_CATEGORY_ID(String name, String code){
			this.cnName = name;
			this.code = code;
		};

		public String getCode(){
			return code;
		}

		public String getCnName() {
			return cnName;
		}

		public static String getCnName(String code){
			for(SON_CATEGORY_ID item:SON_CATEGORY_ID.values()){
				if(item.getCode().equalsIgnoreCase(code))
				{
					return item.getCnName();
				}
			}
			return null;
		}
		

		public static String getCode(String name){
			for(SON_CATEGORY_ID item:SON_CATEGORY_ID.values()){
				if(item.getCnName().equals(name))
				{
					return item.getCode();
				}
			}
			return null;
		}

	}
	
	public static enum SEARCH_TYPE_TAG{
		ALL("全部",0),
		ROUTE("旅游线路",14),
		GROUP("跟团游",14),
		LOCAL("当地游",14),
		FREETOUR("自由行",18),
		AROUND("周边跟团游",14),
		TICKET("门票",5),
		YOULUN("邮轮",8),
		HOTEL("酒店",1),
		HOTELCOMB("酒店套餐",17);
        
		private String cnName;
		private int code;

        SEARCH_TYPE_TAG(String name,int code){
			this.cnName = name;
			this.code = code;
		};

		public int getCode(){
			return code;
		}

		public String getCnName() {
			return cnName;
		}

		public static String getCnName(int code){
			for(SEARCH_TYPE_TAG item:SEARCH_TYPE_TAG.values()){
				if(item.getCode()==code)
				{
					return item.getCnName();
				}
			}
			return null;
		}

		public static int getCode(String name){
			for(SEARCH_TYPE_TAG item:SEARCH_TYPE_TAG.values()){
				if(item.getCnName().equals(name))
				{
					return item.getCode();
				}
			}
			return 0;
		}
		
		public static int getCodebyName(String iteam){
			for(SEARCH_TYPE_TAG item:SEARCH_TYPE_TAG.values()){
				if(item.name().equals(iteam)){
					return item.getCode();
				}
				}
			return 0;
		}
		
	} 
	
	public static enum REFUNDMENT_TYPE {
		/** 补偿 */
		COMPENSATION,
		/** 订单退款 */
		ORDER_REFUNDED,

	}
	
	public static enum INVOICE_COMPANY {
		/** 上海景域文化传播有限公司 */
		COMPANY_1("上海景域文化传播有限公司"),
		/** 上海景域旅行社有限公司 */
		COMPANY_2("上海驴妈妈国际旅行社有限公司"),
		/**兴旅**/
		COMPANY_3("上海驴妈妈兴旅国际旅行社有限公司");
		
		private String cnName;
		INVOICE_COMPANY(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(INVOICE_COMPANY item:INVOICE_COMPANY.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		public String toString(){
			return "code:"+this.name()+",cnName:"+this.cnName;
		}
	}
	
	public static enum CODE_TYPE {
		REFUND_BACK("退款银行"),
		ORD_MEMO_TYPE(" 订单备注类型 "),
		THRONG_TYPE(" 人群类型 "),
		EVENT_TYPE(" 事件类型 "),
		WAIT_PAYMENT(" 支付等待时间 "),
		GENDER(" 性别 "),
		SETTLEMENT_PERIOD(" 结算周期 "),
		ORDER_APPROVE_STATUS(" 订单审核状态 "),
		INFO_APPROVE_STATUS(" 信息审核状态 "),
		PRODUCT_CHANNEL(" 产品销售渠道 "),
		ORD_CANCEL_REASON(" 订单废除原因 "),
		FAX_STRATEGY(" 传真策略 "),
		SETTLEMENT_COMPANY(" 我方结算主体 "),
		CHANNEL(" 销售渠道 "),
		FAX_TEMPLATE(" 传真模板 "),
		B_CERTIFICATE_TYPE(" B端凭证类型 "),
		C_CERTIFICATE_TYPE(" C端凭证类型 "),
		CONDITION_TYPE(" 信息提示类型 "),
		CONTRACT_STATUS(" 合同状态 "),
		CONTRACT_TYPE(" 合同类型 "),
		COOPERATION_STATUS(" 合作状态 "),
		EQUIPMENT_TYPE(" 设备类型 "),
		LOG_TYPE(" 日志类型 "),
		ORDER_AMOUNT_TYPE(" 定单金额总类 "),
		ORDER_STATUS(" 订单状态 "),
		PRICE_TYPE(" 价格类型 "),
		PRODUCT_TYPE(" 产品类型 "),
		VIEW_CONTENT_TYPE(" 展示内容类型 "),
		CERT_TYPE(" 证件类型 "),
		OTHER_TYPE(" 其他类型 *"),
		META_RESOURCE_CONFIRM(" 资源确认 "),
		PAYMENT_TARGET(" 支付对象 "),
		PAYMENT_GATEWAY(" 支付网关 "),
		PAYMENT_GATEWAY_OTHER_MANUAL("其它手工支付"),
		PAYMENT_GATEWAY_DIST_MANUAL("分销手工支付"),
		PAYMENT_TYPE(" 支付方式 "),
		TRANSACTION_TYPE(" 交易类型 "),
		PAYMENT_STATUS(" 支付状态 "),
		RESOURCE_GROUP(" 资源组 "),
		CONTACT_TYPE(" 联系人类型 "),
		FAX_STATUS(" 传真发送状态 "),
		ORDER_VIEW_STATUS(" 订单的显示状态 "),
		TRAFFIC_TYPE(" 行程里的交通类型 "),
		PAYMENT_SERIAL_STATUS(" 支付状态 "),
		RESOURCE_STATUS(" 资源状态 "),
		INVOICE_CONTENT(" 发票内容 "),
		COMPANY_1_CONTENT("发票内容1*"),
		COMPANY_2_CONTENT("发票内容2*"),
		COMPANY_3_CONTENT("发票内容3*"),
		COMPANY_4_CONTENT("发票内容4*"),
		COMPANY_5_CONTENT("发票内容5*"),
		SERVICE_TYPE(" 销售服务类型 "),
		REFUNDMENT_STATUS(" 退款状态 "),
		ACCOUNT_TYPE(" 账号状态(支付宝/银行卡) "),
		COUPON_INFO(" 优惠券错误提示信息 "),
		REFUND_TYPE(" 申请退款服务类型 "),
		REFUND_CHANNEL(" 退款渠道 "),
		ORDER_TYPE(" 订单类型 "),
		INVOICE_STATUS(" 发票状态 "),
		ORDER_PERFORM_STATUS(" 定单履行状态 "),
		TRUE_FALSE (" 是/否 "),
		ORD_SALE_STATUS(" 申请售后服务状态 "),
		ORD_SALE_REASON(" 申请售后服务原因 "),
		PASSCODE_STATUS(" 通关码状态 "),
		PASSCODE_ERROR(" 通关码错误信息 "),
		PROD_HOTEL_REATURE(" 酒店房型特色 "),
		PROD_ROUTE_CATEGORY(" 线路分类 "),
		PROD_ROUTE_IS_PLAY(" 是否纯玩 "),
		PROD_ROUTE_ROUTE_STANDARD(" 线路标准 "),
		PROD_ROUTE_ROUTE_TITLE(" 线路主题 "),
		PROD_ROUTE_DEPART_AREA(" 出境区域 "),
		VISA_STATUS("签证类型*"),
		FILIALE_NAME("分公司类型*"),
		ORDER_TRACK_TYPE("领取订单处理结果*"),
		SETTLEMENT_STATUS("结算状态 "),
		DELIVERY_TYPE("送货方式*"),
		STORED_CARD_STATUS(" 储值卡状态."),
		STORED_CARD_ACTIVE_STATUS("储值卡激活状态."),
		STORED_CARD_STOCK_STATUS("储值卡在库状态"),
		STORED_CARD_USAGE_STATUS(" 储值卡消费状态  "),
		ORDER_RESOURCE_LACK_REASON(" 资源不通过原因  "),
		FAX_RECV_STATUS(" 传真回复状态  "),
		BREAKFAST_TYPE("早餐*"),
		BROADBAND_TYPE("宽带*"),
		DISTRIBUTION_ERROR(" 分销异常信息类型"),
		SUPPLIER_TYPE("供应商类型*"),
		MARK_PAYMENT_CHANNEL(" 优惠支付选择渠道"),
		FINC_CASH_STATUS(" 现金帐户状态集"),
		ORDER_AMOUNT_APPLAY_TYPE("订单修改原因"),
		PAY_POS_SUPPLIER_TYPE("POS供应商");
		
		private String cnName;
		CODE_TYPE(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(CODE_TYPE item:CODE_TYPE.values()){
				if(item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}
		public String toString(){
			return this.name();
		}
	}
	
	public static enum INVOICE_CONTENT {
		COMMITTEE_CHARGE("会务费"),
		GROUP_CHARGE("团费"),
		INTEGRATION_CHARGE("综合服务费"),
		REGISTER_PROXY_CHARGE("住宿代理费"),
		SERVICE_CHARGE("服务费"),
		TICKET_HOTEL_PROXY_CHARGE("代理费（门票+酒店）"),
		TICKET_HOTEL_TRAVEL_CHARGE("旅游费（门票+酒店）"),
		TICKET_PROXY_CHARGE("门票代理费"),
		TRAVEL_CHARGE("旅游费"),
		VISA_CHARGE("签证费");
		
		private String cnName;
		INVOICE_CONTENT(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(INVOICE_CONTENT item:INVOICE_CONTENT.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		public String toString(){
			return this.name();
		}
	}
	
	/**送货方式**/
	public static enum DELIVERY_TYPE{
		/**快递**/
		EXPRESS("快递"),
		/**ems**/
		EMS("EMS"),
		/**自取**/
		SELF("自取");
		
		private String cnName;
		DELIVERY_TYPE(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(DELIVERY_TYPE item:DELIVERY_TYPE.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		public String toString(){
			return this.name();
		}
	}
	
	public static enum INVOICE_LOGISTICS{
		NONE("未处理"),
		POST("已发"),
		BACK("退回");
		
		
		private String cnName;
		INVOICE_LOGISTICS(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(INVOICE_LOGISTICS item:INVOICE_LOGISTICS.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		public String toString(){
			return this.name();
		}
	}
	
	public static enum INVOICE_STATUS {
		/** 未开票 */
		UNBILL("未开票"),
		/**已经审核**/
		APPROVE("已经审核"),
		/** 已经开票 */
		BILLED("已经开票"),
		/** 取消 */
		CANCEL("取消"),		
		/**完成**/
		COMPLETE("完成"),
		/**已经红冲**/
		RED("已经红冲");
		
		private String cnName;
		INVOICE_STATUS(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(INVOICE_STATUS item:INVOICE_STATUS.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		public String toString(){
			return this.name();
		}
	}
	
	public static enum COM_LOG_ORDER_EVENT {
		/** 信息审核 */
		approveInfo,
		/** 审核通过 */
		approvePass,
		/** 系统自动审核通过 */
		systemApprovePass,
		/** 废单重下（objectId = 旧订单ID） */
		cancelToCreateNew_original,
		/** 废单重下（objectId = 新订单ID） */
		cancelToCreateNew_new,
		/**订 单 重 下*/
		toCreateOrderNew_new,
		/** 取消 */
		cancel,
		/** 系统自动取消 */
		systemCancel,
		/** 用户取消 */
		userCancel,
		/** 用户下单 */
		create,
		/** 后台下单 */
		placeOrder,
		/** 重拨 */
		redial,
		/** 资源确认 */
		resourceConfirm,
		/** 明细变更 */
		detailChange,
		/** 信息审核领单 */
		orderAuditGoing,
		/** 信息审核分单 */
		orderAuditDeliver,
		/** 无需资源审核分单 */
		orderAuditConfirmDeliver,
		/** 信息审核退单 */
		orderAuditGoBack,
		/** 信息审核回收 */
		orderAuditRecycle,
		/** 资源审核领单 */
		orderItemMetaAuditGoing,
		/** 资源审核退单 */
		orderItemMetaAuditGoBack,
		/** 修改订单内容 */
		updateOrder,
		/** 修改订单子项内容 */
		updateOrderItemProd,
		/** 修改订单子子项内容 */
		updateOrderItemMeta,
		/** 修改采购产品订单子项结算价 */
		orderItemMetaSettlementPrice,
		/** 修改订单子子项传真发送任务状态 */
		updateOrderFaxTaskStatus,
		/** 新增订单发票 */
		insertOrderInvoice,
		/** 修改订单发票 */
		updateOrderInvoice,
		/** 删除订单发票 */
		deleteOrderInvoice,
		/** 新增订单待结算队列 */
		insertOrderSettlementQueue,
		/** 修改订单待结算队列 */
		updateOrderSettlementQueue,
		/** 新增订单待结算队列子项 */
		insertOrderSettlementQueueItem,
		/** 删除订单待结算队列子项 */
		deleteOrderSettlementQueueItem,
		/** 确认结算单 */
		updateOrderSettlementConfirm,
		/** 添加主结算单备注 */
		insertOrderSettlementMemo,
		/** 创建主结算单 */
		insertOrderSettlement,
		/** 修改主结算单 */
		updateOrderSettlement,
		/** 创建子结算单 */
		insertOrderSubSettlement,
		/** 修改子结算单 */
		updateOrderSubSettlement,
		/** 删除子结算单 */
		deleteOrderSubSettlement,
		/** 创建子结算单子项 */
		insertOrderSubSettlementItem,
		/** 删除子结算单子项 */
		deleteOrderSubSettlementItem,
		/** 修改供应商 */
		updateSupSupplier,
		/** 创建供应商 */
		insertSupSupplier,
		/** 删除供应商 */
		deleteSupSupplier,
		/** 修改结算对象 */
		updateSuPSettlementTarget,
		/** 创建结算对象 */
		insertSuPSettlementTarget,
		/** 编辑履行对象 */
		updateSupPerformTarget,
		/** 创建履行对象 */
		insertSupPerformTarget,
		/** 删除履行对象 */
		deleteSupPerformTarget,
		/** 编辑凭证对象 */
		updateSupBCertificateTarget,
		/** 创建凭证对象 */
		insertSupBCertificateTarget,
		/** 删除凭证对象 */
		deleteSupBCertificateTarget,
		/** 编辑销售产品 */
		updateProdProduct,
		/** 创建销售产品 */
		insertProdProduct,
		/** 删除销售产品 */
		delteProdProduct,
		/** 编辑采购产品 */
		updateMetaProduct,
		/** 创建采购产品 */
		insertMetaProduct,
		/** 编辑采购产品酒店 */
		updateProdHotel,
		/** 创建采购产品酒店 */
		insertProdHotel,
		/** 创建采购产品酒店 */
		insertProdProductPlace,
		/** 编辑采购产品酒店 */
		updateProdProductPlace,
		/** 创建渠道对像 */
		insertProdProductChannel,
		/** 编辑渠道对像 */
		updateProdProductChannel,
		/** 创建采购产品时间价格表 */
		insertMetaTimePrice,
		/** 编辑采购产品时间价格表 */
		updateMetaTimePrice,
		/** 创建销售产品时间价格表 */
		insertProdTimePrice,
		/** 编辑销售产品时间价格表 */
		updateProdTimePrice,
		/** 绑定采购产品 */
		insertProdProductItem,
		/** 删除绑定采购产品 */
		deleteProdProductItem,
		/** 添加关联的销售产品 */
		insertProdRelation,
		/** 删除关联的销售产品 */
		deleteProdRelation,
		/** 编辑关联的销售产品 */
		updateProdRelation,
		/** 添加履行对象 */
		insertMetaPerform,
		/** 删除关联的履行对象 */
		deleteMetaPerform,
		/** 添加关联的凭证对象 */
		insertMetaBCertificate,
		/** 删除关联的凭证对象 */
		deleteMetaBCertificate,
		/** 添加关联的结算对象 */
		insertMetaSettlement,
		/** 删除关联的结算对象 */
		deleteMetaSettlement,
		/** 添加取票(联系)人 */
		insertUsrReceivers,
		/** 删除取票(联系)人 */
		updateUsrReceivers,
		/** 添加订单取票(联系)人 */
		insertOrdPerson,
		/** 修改订单取票(联系)人 */
		updateOrdPerson,
		/** 删除订单取票(联系)人 */
		deleteOrdPerson,
		/** 删除传真回传 */
		deleteFaxRecv,
		/** 订单价格修改 */
		modifyOrderAmount,
		/**
		 * 插入一条EDM任务
		 */
		insertEdmTask, 
		/**
		 * 修改一条EDM任务信息
		 */
		updateEdmTask, 
		/**
		 * 插入一条EDM模板
		 */
		insertEdmTemplate,
		/**
		 * 修改一条EDM模板信息
		 */
		updateEdmTemplate, 
		/**
		 * 插入一条EDM用户组信息
		 */
		insertEdmUserGroup,
		/**
		 * 修改EDM用户组信息
		 */
		updateEdmUserGroup,
		/** 创建合同 */
		insertSupContract,
		/** 修改合同 */
		updateSupContract,
		/**创建联系人 */
		insertComContact,
		/**创建合同补充单*/
		insertSupContractChange,
		/**上传文件*/
		uploadFile,
		/**合同审核驳回*/
		rejectContract,
		/** 创建签证材料 **/
		createVisaApplicationDocument,
		/** 删除签证材料 **/
		deleteVisaApplicationDocument,
		/** 创建签证材料明细 **/
		createVisaDocumentDetails,
		/** 更新签证材料明细  **/
		updateVisaDocumentDetails,
		/** 删除签证材料 **/
		deleteVisaDocumentDetails,
		/** 新增增补材料 **/
		addVisaDocumentDetails,
		/** 分销商批量下单 **/
		batchOrderBooking,
		
		/** 分销商批量申码 **/
		batchOrderDownPASSCODE,
		
		/** 团分销预约码操作 **/
		tuanCodeDownPASSCODE,
		
		/** 分销商批量废单 **/
		batchCancelOrder,
		
		/** 分销商订单废单*/
		batchCancelOneOrder,
		
		/**批量废券码*/
		batchCancelCouponCode,
		
		/**重新激活券码**/
		activateCouponCode,
		
		/** 签证审核材料上传快递 **/
		UploadVisaApprovalMaterial
	}
	
	public static void main(String[] args) {
		
//		LINE_TRAFFIC lineTraffic =LINE_TRAFFIC.valueOf("TRAIN1");
		System.out.println(LINE_TRAFFIC.hasLineTraffic("TRAIN1"));
	}

	// 区域类型
		public static enum DISTRICT_TYPE {

			CONTINENT("洲"), 
			COUNTRY("国家"), 
			PROVINCE("省"), 
			PROVINCE_DCG("直辖市"), 
			PROVINCE_SA("特别行政区"), 
			PROVINCE_AN("自治区"), 
			CITY("市"), 
			COUNTY("区/县"),
			TOWN("乡镇/街道");

			private String cnName;

			public static String getCnName(String code) {
				for (DISTRICT_TYPE item : DISTRICT_TYPE.values()) {
					if (item.getCode().equals(code)) {
						return item.getCnName();
					}
				}
				return code;
			}

			public static boolean hasDistrictType(String name){
				for (DISTRICT_TYPE item : DISTRICT_TYPE.values()) {
					if (item.getCode().equals(name)) {
						return true;
					}
				}
				return false;
			}
			
			DISTRICT_TYPE(String name) {
				this.cnName = name;
			}

			public String getCode() {
				return this.name();
			}

			public String getCnName() {
				return this.cnName;
			}

			@Override
			public String toString() {
				return this.name();
			}
		}

	public static enum ORDER_FAVORABLE_TYPE {
		/**
		 * 奖金抵扣
		 */
		bonus("奖金抵扣"),
		/**
		 * 优惠券
		 */
		coupon("优惠券");

		private String cnName;

		ORDER_FAVORABLE_TYPE(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(ORDER_FAVORABLE_TYPE item: ORDER_FAVORABLE_TYPE.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		@Override
		public String toString(){
			return "code:"+this.name()+",cnName:"+this.cnName;
		}
	}
	
	public static enum OBJECT_TYPE{
		PROD_PRODUCT("产品"),
		PROD_PRODUCT_BRANCH("产品规格"),
		SUPP_GOODS("商品"),
		SUPP_GOODS_TIME_PRICE("商品时间价格表");
		
		private String objectType;
		
		OBJECT_TYPE(String objectType){
			this.objectType = objectType;
		}
		
		 public String getCode(){
            return this.name();
        }
		 
		 public String getCnName(){
            return this.objectType;
        }
	}

    public static enum VST_CATEGORY{
        CATEGORY_HOTEL("0","1","酒店"),
        CATEGORY_CRUISE("0","2","邮轮"),
        CATEGORY_INSURANCE("0","3","保险"),
        CATEGORY_VISA("0","4","签证"),
        CATEGORY_COMB("0","6","组合产品"),
        CATEGORY_ADDITION("0","7","附加项目"),
        //邮轮组合产品作为邮轮的子类，这里与vst不同
        CATEGORY_COMB_CRUISE("6","8","邮轮组合产品"),
        CATEGORY_SIGHTSEEING("7","9","岸上观光"),
        CATEGORY_CRUISE_ADDITION("7","10","邮轮附加项"),
        CATEGORY_TICKET("0","5","门票 "),
        CATEGORY_SINGLE_TICKET("5","11","景点门票"),
        CATEGORY_OTHER_TICKET("5","12","其它票"),
        CATEGORY_COMB_TICKET("5","13","组合套餐票"),
        CATEGORY_ROUTE("0","14","线路"),
        CATEGORY_ROUTE_GROUP("14","15","跟团游"),
        CATEGORY_ROUTE_LOCAL("14","16","当地游"),
        CATEGORY_ROUTE_HOTELCOMB("14","17","酒店套餐"),
        CATEGORY_ROUTE_FREEDOM("14","18","自由行"),
        CATEGORY_TRANFFIC("0","19","大交通"),
        CATEGORY_TRANFFIC_AEROPLANE("19","20","机票"),
        CATEGORY_TRANFFIC_AEROPLANE_OTHER("19","21","其它机票"),
        CATEGORY_TRANFFIC_TRAIN("19","22","火车票"),
        CATEGORY_TRANFFIC_TRAIN_OTHER("19","23","其它火车票"),
        CATEGORY_TRANFFIC_BUS("19","24","巴士"),
        CATEGORY_TRANFFIC_BUS_OTHER("19","25","其它巴士"),
        CATEGORY_TRANFFIC_SHIP("19","26","船票"),
        CATEGORY_TRANFFIC_SHIP_OTHER("19","27","其它船票");

        private String fathercategoryId;
        private String categoryId;
        private String cnName;

        VST_CATEGORY(String fathercategoryId,String categoryId,String cnName){
            this.fathercategoryId = fathercategoryId;
            this.categoryId=categoryId;
            this.cnName=cnName;
        }

        public String getCode(){
            return this.name();
        }
        public String getFathercategoryId(){
            return this.fathercategoryId;
        }
        public String getCategoryId(){
            return this.categoryId;
        }
        public String getCnName(){
            return this.cnName;
        }

        public static String getCnNameByCode(String code){
            for(VST_CATEGORY item:VST_CATEGORY.values()){
                if(item.getCode().equals(code)) {
                    return item.getCnName();
                }
            }
            return code;
        }

        public static String getCategoryIdByCode(String code){
            for(VST_CATEGORY item:VST_CATEGORY.values()){
                if(item.getCode().equals(code)){
                    return item.categoryId;
                }
            }
            return null;
        }
        public static String getCnNameByStatus(String categoryId){
            for(VST_CATEGORY item:VST_CATEGORY.values()){
                if(item.categoryId.equals(categoryId)) {
                    return item.getCnName();
                }
            }
            return categoryId;
        }
        public static String getCodeByCategoryId(String categoryId){
            for (VST_CATEGORY item:VST_CATEGORY.values()) {
                if(item.categoryId.equals(categoryId)){
                    return item.name();
                }
            }
            return null;
        }

        public static String getfatherCategoryCode(String code){
            for (VST_CATEGORY item : VST_CATEGORY.values()) {
                if(item.getCode().equals(code)){
                    if(item.fathercategoryId.equals("0")){
                        return item.getCode();
                    }
                    for (VST_CATEGORY itemf : VST_CATEGORY.values()){
                        if(itemf.categoryId.equals(item.fathercategoryId)){
                            return itemf.getCode();
                        }
                    }
                }
            }
            return code;
        }

        public static String getCodeListByCategoryId(String categoryId){
            StringBuffer sb = new StringBuffer();
            for (VST_CATEGORY item : VST_CATEGORY.values()) {
                if(item.fathercategoryId.equals(categoryId)){
                    sb.append(item.getCode()).append(",");
                }
            }

            return sb.toString();
        }

        public String toString(){
            return this.name();
        }
    }
    
    public static enum CAL_TYPE{
		PRICE("价格"),
		SALE_FLAG("可售标识"),
		REBATE("返现");
		
		private String calType;
		
		CAL_TYPE(String calType){
			this.calType = calType;
		}
		
		 public String getCode(){
            return this.name();
        }
		 
		 public String getCnName(){
            return this.calType;
        }
	}

    public static enum CLIENT_FAVORITE_TYPE {
        PLACE("标的"),
        PRODUCT("产品"),
        GUIDE("攻略"),
        TUANGOU("团购");
        private String cnName;

        CLIENT_FAVORITE_TYPE(String name){
            this.cnName=name;
        }
        public String getCode(){
            return this.name();
        }
        public String getCnName(){
            return this.cnName;
        }
        public static String getCnName(String code){
            for(CLIENT_FAVORITE_TYPE item: CLIENT_FAVORITE_TYPE.values()){
                if(item.getCode().equals(code))
                {
                    return item.getCnName();
                }
            }
            return code;
        }
        public String toString(){
            return "code:"+this.name()+",cnName:"+this.cnName;
        }
    }
      
    public static enum LANDMARK_TYPE {
    	landmarkId("2000","地标"),
    	businessDistrictId("2001","商圈"),
    	scenicId("2002","景区"),
    	airportId("2003","飞机场"),
    	railwayStationId("2004","火车站"),
    	busStationId("2005","长途汽车站"),
    	metroId("2006","地铁");
    	private String id;
    	private String cnName;
    	
    	LANDMARK_TYPE(String id,String cnName){
    		this.id=id;
    		this.cnName=cnName;
    	}
    	public String getCode(){
    		return this.name();
    	}
    	public String getId(){
    		return this.id;
    	}
    	public String getCnName(){
    		return this.cnName;
    	}
    	public static String getPropertyName(String id){
    		for(LANDMARK_TYPE item: LANDMARK_TYPE.values()){
//    			System.out.println("item: "+item);
    			if(item.getId().equals(id))
    			{
    				return item.name();
    			}
    		}
    		return id;
    	}
    	public String toString(){
    		return "code:"+this.name()+",id:"+this.id+",propertyName:"+this.cnName;
    	}
    }

    //审核状态
    public static enum REST_RESULT_STATUS {

        AUDITED("已审核"), UNAUDITED("审核未通过"), FAILED("失败"), AUDITTING("审核中");

        private String cnName;

        public static String getCnName(String code) {
            for (REST_RESULT_STATUS item : REST_RESULT_STATUS.values()) {
                if (item.getCode().equals(code)) {
                    return item.getCnName();
                }
            }
            return code;
        }

        REST_RESULT_STATUS(String name) {
            this.cnName = name;
        }

        public String getCode() {
            return this.name();
        }

        public String getCnName() {
            return this.cnName;
        }

        @Override
        public String toString() {
            return this.name();
        }
    }
    
  //审核人
    public static enum REST_OPERATOR {

       SYSTEM("系统"),JOB("定时器");

        private String cnName;

        public static String getCnName(String code) {
            for (REST_OPERATOR item : REST_OPERATOR.values()) {
                if (item.getCode().equals(code)) {
                    return item.getCnName();
                }
            }
            return code;
        }

        REST_OPERATOR(String name) {
            this.cnName = name;
        }

        public String getCode() {
            return this.name();
        }

        public String getCnName() {
            return this.cnName;
        }

        @Override
        public String toString() {
            return this.name();
        }
    }
    
    //产品信息查询返回结果
    public static enum RESULT_STATUS {

    	SUCCESS("成功"), FAILD("失败");
		private String cnName;

		public String getCode() {
			return this.name();
		}

		public String getCnName() {
			return this.cnName;
		}

		public static String getCnName(String code) {
			for (STATUS item : STATUS.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		RESULT_STATUS(String cnName) {
			this.cnName = cnName;
		}

		@Override
		public String toString() {
			return this.name();
		}
	}
    
    /** 帮助中心
     * @author ""
     *
     */
    public static enum INFO_TYPE{
		/**帮助中心**/
		INFO_QUES_HELP_CENTER,
		/*faq*/
		INFO_QUES_NORMAL,
		INFO_QUES_COUNT,
	}
    /**
	 * 结算单状态
	 */
	public static enum NEW_SET_SETTLEMENT_STATUS {
		UNPAY("未打款"),
		PARTPAY("部分打款"),
		PAYED("已打款"),
		INVOICE_CONFIRM("发票已确认"),
		INVOICE_REJECTED("发票已退回"),
		SETTLEMENTED("已结算");
		
		private String cnName;
		NEW_SET_SETTLEMENT_STATUS(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(NEW_SET_SETTLEMENT_STATUS item:NEW_SET_SETTLEMENT_STATUS.values()){
				if(item.getCode().equals(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		public String toString(){
			return this.name();
		}
	}
}
