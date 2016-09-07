package com.lvmama.lvfit.sonline.utils;

import org.apache.commons.lang3.StringUtils;

import com.lvmama.lvfit.sonline.vo.Constant;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * 频道页（门票，周边游，国内，出境游，酒店）常量和公共方法
 * @author nixianjun 2013-6-6
 *
 */
public class PindaoPageUtils {
	/**
	 * 首页
	 */
	public static final Long HOME_COMMONBLOCKID = 10464L;
	public static final String HOME_CHANNELPAGE = "www";
	public static final String HOME_CONTAINERCODE = "HOME_RECOMMEND";
    public static final String MEMCACHED_HOME_PREFIXKEY=getPrefixMemcachedKey(HOME_CHANNELPAGE, HOME_COMMONBLOCKID, HOME_CONTAINERCODE);
	
    /**
     * 新版首页
     */
	public static final Long HOME_COMMONBLOCKID2 =20077L;
	public static final String HOME_CHANNELPAGE2 = "lvwww";
	public static final String HOME_CONTAINERCODE2 = "LVHOME_RECOMMEND";
    public static final String MEMCACHED_HOME_PREFIXKEY2=getPrefixMemcachedKey(HOME_CHANNELPAGE2, HOME_COMMONBLOCKID2, HOME_CONTAINERCODE2);

	/**
	 * 频道-门票
	 */
    public static final   Long TICKET_COMMONBLOCKID = 10699L;
    public static final String TICKET_CHANNELPAGE= "ticket";
    public static final String TICKET_CONTAINERCODE="CHANNEL_TICKET_RECOMMEND";
    public static final String MEMCACHED_TICKET_PREFIXKEY=getPrefixMemcachedKey(TICKET_CHANNELPAGE, TICKET_COMMONBLOCKID, TICKET_CONTAINERCODE);


	/** 
    * 频道-周边 <跟团游,自由行> 
    */ 
    public static final Long FREETOUR_COMMONBLOCKID= 0L; //全国统一
    public static final String FREETOUR_CHANNELPAGE="freetour2";
    public static final String FREETOUR_CONTAINERCODE="CHANNEL_AROUND_RECOMMEND2";
    public static final String MEMCACHED_FREETOUR_PREFIXKEY=getPrefixMemcachedKey(FREETOUR_CHANNELPAGE, FREETOUR_COMMONBLOCKID, FREETOUR_CONTAINERCODE);

	/**
	 * 频道-度假酒店
	 */
	public static final Long HOLIDAY_HOTEL_COMMONBLOCKID = 0L; //全国统一
	public static final String HOLIDAY_HOTEL_CHANNELPAGE = "holidayHotel";
	public static final String HOLIDAY_HOTEL_CONTAINERCODE = "CHANNEL_HOLIDAY_HOTEL_RECOMMEND";
	public static final String MEMCACHED_HOLIDAY_HOTEL_PREFIXKEY = getPrefixMemcachedKey(HOLIDAY_HOTEL_CHANNELPAGE, HOLIDAY_HOTEL_COMMONBLOCKID, HOLIDAY_HOTEL_CONTAINERCODE);

    
    /** 
     * 频道-邮轮 
     */ 
     public static final Long YOULUN_COMMONBLOCKID= 0L; //全国统一
     public static final String YOULUN_CHANNELPAGE="main";
     public static final String YOULUN_CONTAINERCODE="CHANNEL_YOULUN_RECOMMEND2";
     public static final String MEMCACHED_YOULUN_PREFIXKEY=getPrefixMemcachedKey(YOULUN_CHANNELPAGE, YOULUN_COMMONBLOCKID, YOULUN_CONTAINERCODE);
     
     /**
     * 频道-团购
     */
    public static final   Long TUANGOU_COMMONBLOCKID = 14516L;
    public static final String TUANGOU_CHANNELPAGE= "tuangou";
    public static final String TUANGOU_CONTAINERCODE= "TUANGOU_RECOMMEND";
    /**
     * 频道-出境
     */
	public static final Long ABROAD_COMMONBLOCKID = 8413L;
	public static final String ABROAD_CHANNELPAGE = "abroad";
	public static final String ABROAD_CONTAINERCODE = "CHANNEL_ABROAD_RECOMMEND";
    public static final String MEMCACHED_ABROAD_PREFIXKEY=getPrefixMemcachedKey(ABROAD_CHANNELPAGE, ABROAD_COMMONBLOCKID, ABROAD_CONTAINERCODE);

    /**
     * 频道-酒店
     */
	public static final Long HOTEL_COMMONBLOCKID = 7106L;
	public static final String HOTEL_CHANNELPAGE = "main";
	public static final String HOTEL_CONTAINERCODE = "CHANNEL_HOTEL_RECOMMEND";
    public static final String MEMCACHED_HOTEL_PREFIXKEY=getPrefixMemcachedKey(HOTEL_CHANNELPAGE, HOTEL_COMMONBLOCKID, HOTEL_CONTAINERCODE);

	/** 
	* 国内游 
	*/ 
	public static final Long DESTROUTE_COMMONBLOCKID = 8414L; 
	public static final String DESTROUTE_CHANNELPAGE = "destroute"; 
	public static final String DESTROUTE_CONTAINERCODE ="CHANNEL_DESTROUTE_RECOMMEND";
    public static final String MEMCACHED_DESTROUTE_PREFIXKEY=getPrefixMemcachedKey(DESTROUTE_CHANNELPAGE, DESTROUTE_COMMONBLOCKID, DESTROUTE_CONTAINERCODE);


    /**
     * 8个分站placeid
     */
	  public static final Long SH_PLACEID=79L;//上海
	  public static final Long BJ_PLACEID=1L;//北京  
	  public static final Long CD_PLACEID=279L;//成都
	  public static final Long GZ_PLACEID=229L;//广州
	  public static final Long HZ_PLACEID=100L;//杭州
	  public static final Long NJ_PLACEID=82L;//南京
	  public static final Long SZ_PLACEID=231L;//深圳
	  public static final Long SY_PLACEID=272L;//三亚
	  public static final Long NB_PLACEID=104L;// 宁波
	  
	  public static final Long AH_PLACEID=119L;//安徽合肥
	  public static final Long JX_PLACEID=146L;//江西南昌 
	  public static final Long FJ_PLACEID=137L;//福建厦门
	  public static final Long HB_PLACEID=199L;//湖北武汉
	  public static final Long HN_PLACEID=180L;//河南郑州
	  public static final Long LN_PLACEID=42L;//辽宁沈阳
	  public static final Long SD_PLACEID=160L;//山东济南
	  
	  public static final Long CQ_PLACEID=277L;//重庆
	  public static final Long WX_PLACEID=83L; //无锡
	  public static final Long SUZ_PLACEID=87L;//苏州
	  
	  public static final Long GX_PLACEID = 251L;//广西
      public static final Long SX_PLACEID = 339L;//陕西
      public static final Long YN_PLACEID = 312L;//云南
      
      public static final Long YC_PLACEID = 376L;//银川
      public static final Long TJ_PLACEID = 2L;  //天津
      public static final Long HRB_PLACEID = 67L; //哈尔滨
      public static final Long QQHR_PLACEID = 68L; //齐齐哈尔
      public static final Long CC_PLACEID = 57L; //长春
      public static final Long YB_PLACEID = 3882L;//延边
      public static final Long SJZ_PLACEID =4L;//石家庄
      public static final Long TS_PLACEID = 5L;//唐山
      public static final Long DL_PLACEID = 43L;//大连
      public static final Long QD_PLACEID = 161L;//青岛
      public static final Long TA_PLACEID = 159L;//山东 泰安
      public static final Long WZ_PLACEID = 107L;//温州
      public static final Long CS_PLACEID = 213L;//长沙
      public static final Long ZJJ_PLACEID = 221L;//张家界
      public static final Long ZH_PLACEID = 232L;//珠海
      public static final Long NN_PLACEID = 252L;//南宁
      public static final Long WH_PLACEID = 120L;//芜湖
      public static final Long HS_PLACEID = 127L;//黄山
      public static final Long FY_PLACEID = 130L;//阜阳
      public static final Long XM_PLACEID = 135L;//厦门
      public static final Long FZ_PLACEID = 136L;//福州
      public static final Long GL_PLACEID = 254L;//桂林
	  

      public static final Long TY_PLACEID = 16L; //太原
      public static final Long HHHT_PLACEID = 28L; //呼和浩特
      public static final Long BT_PLACEID = 29L; //包头
      public static final Long XA_PLACEID = 340L; //西安
      public static final Long XN_PLACEID = 367L; //西宁
      public static final Long WLMQ_PLACEID = 382L; //乌鲁木齐
      public static final Long LY_PLACEID = 182L; //洛阳
      public static final Long HK_PLACEID = 271L; //海口
      public static final Long KM_PLACEID = 315L; //昆明
      public static final Long LJ_PLACEID = 320L; //丽江
      public static final Long XSBN_PLACEID = 326L; //西双版纳
      public static final Long XGLL_PLACEID = 330L; //香格里拉
      public static final Long GY_PLACEID = 301L; //贵阳
      public static final Long LS_PLACEID = 332L; //拉萨
      public static final Long DLA_PLACEID = 327L; //大理
      

  	/**
  	 * 出发地站和出发地code
  	 * 
  	 * @author nixianjun
  	 * 
  	 */
  	public static enum PLACEID_PLACECODE {
  		SH(SH_PLACEID, "SH","上海"), // 上海
  		BJ(BJ_PLACEID, "BJ","北京"), // 北京
  		CD(CD_PLACEID, "CD","四川"), // 成都
  		GZ(GZ_PLACEID, "GZ","广东"), // 广州
  		HZ(HZ_PLACEID, "HZ","浙江"), // 杭州
  		NJ(NJ_PLACEID, "NJ","江苏"), // 南京
  		SZ(SZ_PLACEID, "SZ","深圳"), // 深圳
  		SY(SY_PLACEID, "SY","海南"), // 三亚

  		AH(AH_PLACEID, "AH", "安徽"), // 安徽合肥
  		JX(JX_PLACEID, "JX", "江西"), // 江西南昌
  		FJ(FJ_PLACEID, "FJ", "福建"), // 福建厦门
  		HB(HB_PLACEID, "HB", "湖北"), // 湖北武汉
  		HN(HN_PLACEID, "HN", "河南"), // 河南郑州
  		LN(LN_PLACEID, "LN", "辽宁"), // 辽宁沈阳
  		SD(SD_PLACEID, "SD", "山东济南"), // 山东济南
  		CQ(CQ_PLACEID, "CQ", "重庆"), // 重庆
  		WX(WX_PLACEID, "WX", "无锡"), // 无锡
  		SUZ(SUZ_PLACEID, "SUZ", "苏州"), // 苏州

  		NB(NB_PLACEID, "NB", "宁波"), // 宁波
  		GX(GX_PLACEID, "GX", "广西"), // 广西
  		SX(SX_PLACEID, "SX", "陕西"), // 陕西
  		YN(YN_PLACEID, "YN", "云南"),// 云南
  		
  		YC(YC_PLACEID,"YC","银川"),//银川
  		TJ(TJ_PLACEID,"TJ","天津"),//天津
  		HRB(HRB_PLACEID,"HRB","哈尔滨"),//哈尔滨
  		QQHR(QQHR_PLACEID,"QQHR","齐齐哈尔"),//齐齐哈尔
  		CC(CC_PLACEID,"CC","长春"),//长春
  		YB(YB_PLACEID,"YB","延边"),//延边
  		SJZ(SJZ_PLACEID,"SJZ","石家庄"),//石家庄
  		TS(TS_PLACEID,"TS","唐山"),//唐山
  		DL(DL_PLACEID,"DL","大连"),//大连
  		QD(QD_PLACEID,"QD","青岛"),//青岛
  		TA(TA_PLACEID,"TA","泰安"),//山东 泰安
  		WZ(WZ_PLACEID,"WZ","温州"),//温州
  		CS(CS_PLACEID,"CS","长沙"),//长沙
  		ZJJ(ZJJ_PLACEID,"ZJJ","张家界"),//张家界
  		ZH(ZH_PLACEID,"ZH","珠海"),//珠海
  		NN(NN_PLACEID,"NN","南宁"),//南宁
  		WH(WH_PLACEID,"WH","芜湖"),//芜湖
  		HS(HS_PLACEID,"HS","黄山"),//黄山
  		FY(FY_PLACEID,"WY","阜阳"),//阜阳
  		XM(XM_PLACEID,"XM","厦门"),//厦门
  		FZ(FZ_PLACEID,"FZ","福州"),//福州
  		GL(GL_PLACEID,"GL","桂林");//桂林
		private Long placeid;
		private String placecode;
		private String stationName;

		PLACEID_PLACECODE(Long placeid, String placecode,String stationName) {
			this.placeid = placeid;
			this.placecode = placecode;
			this.stationName=stationName;
		}

		public Long getPlaceid() {
			return placeid;
		}

		public String getPlacecode() {
			return placecode;
		}
		
		public String getStationName() {
			return stationName;
		}

		public static String getPlacecode(Long placeid) {
			for (PLACEID_PLACECODE type : PLACEID_PLACECODE.values()) {
				if (type.getPlaceid()==placeid) {
					return type.getPlacecode();
				}
			}
			return "SH";
		}
		
		public static String getStationName(Long placeid) {
			for (PLACEID_PLACECODE type : PLACEID_PLACECODE.values()) {
				if (type.getPlaceid()==placeid) {
					return type.getStationName();
				}
			}
			return "上海";
		}
		/**
		 * 获取站名和placeid集合
		 * @return
		 * @author nixianjun 2013-11-5
		 */
		public static Map<String, Object> getPlaceIdAndNameMap(){
			Map<String, Object> map = new java.util.LinkedHashMap<String, Object>();
			for(PLACEID_PLACECODE pla:PLACEID_PLACECODE.values()){
				map.put(pla.getStationName(), pla.getPlaceid());
			}
			return map;
		}

	}
 	  
	 public static final String XIANSHITEMAI="XianShiTeMai";
	 public static final String REXIAOPAIHANG="ReXiaoPaiHang";
     
	/**
	 * 
	 * @param channelPage
	 * @param defaultCommonblockid
	 * @param containerCode
	 * @return
	 * @author:nixianjun 2013-6-25
	 */
	public static final String getPrefixMemcachedKey(String channelPage,Long defaultCommonblockid, String containerCode){
	  return	"base_putRecommentInfoResult_" + channelPage + "_" + defaultCommonblockid + "_" + containerCode + "_";
	}
	/**
	 * com_ctiy表数据
	 * @author zhongshuangxi
	 *
	 */
	public static enum CITY{
		shenzhen("440300","深圳"),
		ningbo("330200", "宁波"),
		wuhan("420100", "武汉"),
		shanghai("310000","上海"),
		chongqin("500108","重庆"),
		suzhou("320500","苏州"),
		wuxi("320200","无锡"),
		yinchuan("640100","银川"),
		haerbin("230100","哈尔滨"),
		qiqihaer("230200","齐齐哈尔"),
		changchun("220100","长春"),
		yanbian("222400","延边朝鲜"),
		shijiazhuang("130100","石家庄"),
		tangshan("130200","唐山"),
		shenyang("210100","沈阳"),
		dalian("210200","大连"),
		jinan("370100","济南"),
		qingdao("370200","青岛"),
		taian("370900","泰安"),
		wenzhou("330300","温州"),
		changsha("430100","长沙"),
		zhangjiajie("430800","张家界"),
		zhuhai("440400","珠海"),
		nanning("450100","南宁"),
		wuhu("340200","芜湖"),
		huangshan("341000","黄山"),
		fuyang("341200","阜阳市"),
		xiamen("350200","厦门"),
		fuzhou("350100","福州"),
		guilin("450300","桂林"),
		baotou("150200","包头"),
		taiyuan("140100","太原"),
		xian("610100","西安"),
		xining("630100","西宁"),
		wulumuqi("650100","乌鲁木齐"),
		huhehaote("150100","呼和浩特"),
		luoyang("410300","洛阳"),
		zhengzhou("410100","郑州"),
		haikou("460100","海口"),
		sanya("460200","三亚"),
		kunming("530100","昆明"),
		lijiang("530700","丽江"),
		dali("532900","大理"),
		xishuangbanna("532800","西双版纳"),
		xianggelila("530001","中甸"),
		guiyang("520100","贵阳"),
		lasa("540100","拉萨"),
		chengdu("510100","成都"),
		guangzhou("440100","广州");
		
		
		private String code;
		private String cnName;
		
		CITY(String code, String cnName) {
			this.code = code;
			this.cnName = cnName;
		}
		
		public String getCode() {
			return code;
		}
		
		public String getCnName() {
			return cnName;
		}
	}

	/**
	 * com_prinvince
	 * 34个省份
	 */
	public static enum PROVINCE {
			shanghai("310000","上海"),
			beijin("110000","北京"),
			guangdong("440000","广东"),
			jiangsu("320000","江苏"),
			zhejiang("330000","浙江"),
			lingxia("640000","宁夏"),
			aomen("F20000","澳门"),
			gansu("620000","甘肃"),
			tianjin("120000","天津"),
			sanxi("610000","陕西"),
			hebei("130000","河北"),
			guangxi("450000","广西"), 
			henan("410000","河南"),
			shandong("370000","山东"),
			guizhou("520000","贵州"),
			hainan("460000","海南"),
			anwei("340000","安徽"),
			liaoning("210000","辽宁"),
			jiangxi("360000","江西"),
			sichuan("510000","四川"),
			hubei("420000","湖北"),
			jilin("220000","吉林"),
			xianggang("F10000","香港"),
			yunnan("530000","云南"),
			shanxi("140000","山西"),
			xizang("540000","西藏"),
			heilongjiang("230000","黑龙江"),
			hunan("430000","湖南"),
			fujian("350000","福建"),
			neimenggu("150000","内蒙古"),
			qinghai("630000","青海"),
			chongqin("500000","重庆"),
			xinjiang("650000","新疆"),
			taiwan("F30000","台湾");
		
		private String code;
		private String cnName;
		
		PROVINCE(String code, String cnName) {
			this.code = code;
			this.cnName = cnName;
		}
		
		public String getCode() {
			return code;
		}
		
		public String getCnName() {
			return cnName;
		}
 
		public static String getCnName(String code) {
			for (PROVINCE type :PROVINCE.values()) {
				if (type.getCode().equals(code)) {
					return type.getCnName();
				}
			}
			return code;
		}
		
		public static Map<String, String> getMap() {
			Map<String, String> map = new LinkedHashMap<String, String>();
			for (PROVINCE type :PROVINCE.values()) {
				map.put(type.getCode(), type.getCnName());
			}
			return map;
		}
		
	}
	/**
	 * 周边游获取fromPlaceId根据城市ID
	 * @return
	 */
	private static Map<String, Long> getFreetourMapByCityID() {
		Map<String, Long> map = new HashMap<String, Long>();
		
		map.put(CITY.yinchuan.getCode(), YC_PLACEID);//银川站
		map.put(CITY.haerbin.getCode(),  HRB_PLACEID);//哈尔滨站
		map.put(CITY.qiqihaer.getCode(), QQHR_PLACEID);//齐齐哈尔站
		map.put(CITY.changchun.getCode(),CC_PLACEID);//长春站
		map.put(CITY.yanbian.getCode(),  YB_PLACEID);//延边朝鲜
		map.put(CITY.shijiazhuang.getCode(), SJZ_PLACEID);//石家庄站
		map.put(CITY.tangshan.getCode(), TS_PLACEID);//唐山站
		map.put(CITY.shenyang.getCode(), LN_PLACEID);//辽宁 沈阳站
		map.put(CITY.dalian.getCode(),   DL_PLACEID);//大连站
		map.put(CITY.jinan.getCode(), 	 SD_PLACEID);//山东 济南站
		map.put(CITY.qingdao.getCode(),  QD_PLACEID);//青岛站
		map.put(CITY.taian.getCode(), 	 TA_PLACEID);//泰安站
		map.put(CITY.wenzhou.getCode(),  WZ_PLACEID);//温州站
		map.put(CITY.changsha.getCode(), CS_PLACEID);//长沙站
		map.put(CITY.zhangjiajie.getCode(), ZJJ_PLACEID);//张家界站
		map.put(CITY.zhuhai.getCode(), ZH_PLACEID);//珠海站
		map.put(CITY.nanning.getCode(), NN_PLACEID);//南宁站
		map.put(CITY.wuhu.getCode(), WH_PLACEID);//芜湖站
		map.put(CITY.huangshan.getCode(), HS_PLACEID);//黄山站
		map.put(CITY.fuyang.getCode(), FY_PLACEID);//阜阳站
		map.put(CITY.xiamen.getCode(), XM_PLACEID);//厦门站
		map.put(CITY.fuzhou.getCode(), FZ_PLACEID);//福州站
		
		map.put(CITY.shenzhen.getCode(), SZ_PLACEID);//深圳站
		//map.put(CITY.wuxi.getCode(), WX_PLACEID);//无锡站
		//map.put(CITY.suzhou.getCode(), SUZ_PLACEID);//苏州站
		map.put(CITY.chongqin.getCode(), CQ_PLACEID);//重庆站


		return map;
	}

	/**
	 * 周边游获取fromPlaceId根据城市ID
	 * @return
	 */
	private static Map<String, Long> getHolidayHotelMapByCityID() {
		Map<String, Long> map = new HashMap<String, Long>();

		map.put(CITY.yinchuan.getCode(), YC_PLACEID);//银川站
		map.put(CITY.haerbin.getCode(),  HRB_PLACEID);//哈尔滨站
		map.put(CITY.qiqihaer.getCode(), QQHR_PLACEID);//齐齐哈尔站
		map.put(CITY.changchun.getCode(),CC_PLACEID);//长春站
		map.put(CITY.yanbian.getCode(),  YB_PLACEID);//延边朝鲜
		map.put(CITY.shijiazhuang.getCode(), SJZ_PLACEID);//石家庄站
		map.put(CITY.tangshan.getCode(), TS_PLACEID);//唐山站
		map.put(CITY.shenyang.getCode(), LN_PLACEID);//辽宁 沈阳站
		map.put(CITY.dalian.getCode(),   DL_PLACEID);//大连站
		map.put(CITY.jinan.getCode(), 	 SD_PLACEID);//山东 济南站
		map.put(CITY.qingdao.getCode(),  QD_PLACEID);//青岛站
		map.put(CITY.taian.getCode(), 	 TA_PLACEID);//泰安站
		map.put(CITY.wenzhou.getCode(),  WZ_PLACEID);//温州站
		map.put(CITY.changsha.getCode(), CS_PLACEID);//长沙站
		map.put(CITY.zhangjiajie.getCode(), ZJJ_PLACEID);//张家界站
		map.put(CITY.zhuhai.getCode(), ZH_PLACEID);//珠海站
		map.put(CITY.nanning.getCode(), NN_PLACEID);//南宁站
		map.put(CITY.wuhu.getCode(), WH_PLACEID);//芜湖站
		map.put(CITY.huangshan.getCode(), HS_PLACEID);//黄山站
		map.put(CITY.fuyang.getCode(), FY_PLACEID);//阜阳站
		map.put(CITY.xiamen.getCode(), XM_PLACEID);//厦门站
		map.put(CITY.fuzhou.getCode(), FZ_PLACEID);//福州站

		map.put(CITY.shenzhen.getCode(), SZ_PLACEID);//深圳站

		/**
		 * 西南、西北调取成都
		 */
		map.put(CITY.chengdu.getCode(), CD_PLACEID);
		map.put(CITY.chongqin.getCode(), CD_PLACEID);
		map.put(CITY.kunming.getCode(), CD_PLACEID);
		map.put(CITY.lijiang.getCode(), CD_PLACEID);
		map.put(CITY.dali.getCode(), CD_PLACEID);
		map.put(CITY.xishuangbanna.getCode(), CD_PLACEID);
		map.put(CITY.xianggelila.getCode(), CD_PLACEID);
		map.put(CITY.guiyang.getCode(), CD_PLACEID);
		map.put(CITY.lasa.getCode(), CD_PLACEID);

		map.put(CITY.xian.getCode(), CD_PLACEID);
		map.put(CITY.yinchuan.getCode(), CD_PLACEID);
		map.put(CITY.xining.getCode(), CD_PLACEID);
		map.put(CITY.wulumuqi.getCode(), CD_PLACEID);

		return map;
	}
	
	 /** 周边游
	 * @return
	 */
	private static Map<String, Long> getFreetourMapByProvinceID() {
		Map<String, Long> map = new HashMap<String, Long>();
		//四川站----陕西，西藏，四川，贵州，重庆，宁夏，青海，新疆，甘肃，
		map.put(PROVINCE.sanxi.getCode(), CD_PLACEID);
		map.put(PROVINCE.xizang.getCode(), CD_PLACEID);
		map.put(PROVINCE.sichuan.getCode(),CD_PLACEID);
		map.put(PROVINCE.guizhou.getCode(),CD_PLACEID);
		map.put(PROVINCE.chongqin.getCode(),CD_PLACEID);
		map.put(PROVINCE.lingxia.getCode(), CD_PLACEID);
		map.put(PROVINCE.qinghai.getCode(), CD_PLACEID);
		map.put(PROVINCE.xinjiang.getCode(), CD_PLACEID);
		map.put(PROVINCE.gansu.getCode(), CD_PLACEID);
		//北京站---内蒙，山西，河北，山东，北京，天津，吉林，辽宁，黑龙江
		map.put(PROVINCE.beijin.getCode(), BJ_PLACEID);
		map.put(PROVINCE.neimenggu.getCode(), BJ_PLACEID);
		map.put(PROVINCE.shanxi.getCode(), BJ_PLACEID);
		map.put(PROVINCE.hebei.getCode(), BJ_PLACEID);
		map.put(PROVINCE.shandong.getCode(), BJ_PLACEID);
//		map.put(PROVINCE.tianjin.getCode(), BJ_PLACEID);
		map.put(PROVINCE.jilin.getCode(), BJ_PLACEID);
		map.put(PROVINCE.liaoning.getCode(), BJ_PLACEID);
		map.put(PROVINCE.heilongjiang.getCode(), BJ_PLACEID);
		//广东站---广东，湖南，澳门，香港, 海南
		map.put(PROVINCE.guangdong.getCode(), GZ_PLACEID);
		
		//广西
		map.put(PROVINCE.guangxi.getCode(), GX_PLACEID);
		
		map.put(PROVINCE.hunan.getCode(), GZ_PLACEID);
		map.put(PROVINCE.aomen.getCode(), GZ_PLACEID);
		map.put(PROVINCE.xianggang.getCode(), GZ_PLACEID);
		map.put(PROVINCE.hainan.getCode(), GZ_PLACEID);
		//上海站--福建，台湾，江西，上海,河南，湖北
		map.put(PROVINCE.shanghai.getCode(), SH_PLACEID);
		//浙江站
		map.put(PROVINCE.zhejiang.getCode(), HZ_PLACEID);
		
		//南京站 苏州站 无锡站
		map.put(PROVINCE.jiangsu.getCode(),NJ_PLACEID);
		//云南
		map.put(PROVINCE.yunnan.getCode(),YN_PLACEID);
		//安徽
		map.put(PROVINCE.anwei.getCode(),AH_PLACEID);
		//天津站
		map.put(PROVINCE.tianjin.getCode(), TJ_PLACEID);
		return map;
	}

	/** 度假酒店
	 * @return
	 */
	private static Map<String, Long> getHolidayHotelMapByProvinceID() {
		Map<String, Long> map = new HashMap<String, Long>();
		//四川站----陕西，西藏，四川，贵州，重庆，宁夏，青海，新疆，甘肃，
		map.put(PROVINCE.sanxi.getCode(), CD_PLACEID);
		map.put(PROVINCE.xizang.getCode(), CD_PLACEID);
		map.put(PROVINCE.sichuan.getCode(),CD_PLACEID);
		map.put(PROVINCE.guizhou.getCode(),CD_PLACEID);
		map.put(PROVINCE.chongqin.getCode(),CD_PLACEID);
		map.put(PROVINCE.lingxia.getCode(), CD_PLACEID);
		map.put(PROVINCE.qinghai.getCode(), CD_PLACEID);
		map.put(PROVINCE.xinjiang.getCode(), CD_PLACEID);
		map.put(PROVINCE.gansu.getCode(), CD_PLACEID);
		//北京站---内蒙，山西，河北，山东，北京，天津，吉林，辽宁，黑龙江
		map.put(PROVINCE.beijin.getCode(), BJ_PLACEID);
		map.put(PROVINCE.neimenggu.getCode(), BJ_PLACEID);
		map.put(PROVINCE.shanxi.getCode(), BJ_PLACEID);
		map.put(PROVINCE.hebei.getCode(), BJ_PLACEID);
		map.put(PROVINCE.shandong.getCode(), BJ_PLACEID);
//		map.put(PROVINCE.tianjin.getCode(), BJ_PLACEID);
		map.put(PROVINCE.jilin.getCode(), BJ_PLACEID);
		map.put(PROVINCE.liaoning.getCode(), BJ_PLACEID);
		map.put(PROVINCE.heilongjiang.getCode(), BJ_PLACEID);
		//广东站---广东，湖南，澳门，香港, 海南
		map.put(PROVINCE.guangdong.getCode(), GZ_PLACEID);

		//广西
		map.put(PROVINCE.guangxi.getCode(), GX_PLACEID);

		map.put(PROVINCE.hunan.getCode(), GZ_PLACEID);
		map.put(PROVINCE.aomen.getCode(), GZ_PLACEID);
		map.put(PROVINCE.xianggang.getCode(), GZ_PLACEID);
		map.put(PROVINCE.hainan.getCode(), GZ_PLACEID);
		//上海站--福建，台湾，江西，上海,河南，湖北
		map.put(PROVINCE.shanghai.getCode(), SH_PLACEID);
		//浙江站
		map.put(PROVINCE.zhejiang.getCode(), HZ_PLACEID);

		//南京站 苏州站 无锡站
		map.put(PROVINCE.jiangsu.getCode(),NJ_PLACEID);
		//云南
		map.put(PROVINCE.yunnan.getCode(),YN_PLACEID);
		//安徽
		map.put(PROVINCE.anwei.getCode(),AH_PLACEID);
		//天津站
		map.put(PROVINCE.tianjin.getCode(), TJ_PLACEID);
		return map;
	}
	
	/**
	 * 邮轮
	 * 通过cityId
	 */
	private static Map<String, Long> getYoulunMapByCityID() {
		Map<String, Long> map = new HashMap<String, Long>();
		//北京


		map.put(CITY.taiyuan.getCode(), TY_PLACEID); //太原站
		map.put(CITY.tangshan.getCode(), TS_PLACEID); //唐山站
		map.put(CITY.huhehaote.getCode(), HHHT_PLACEID); //呼和浩特站
		map.put(CITY.baotou.getCode(), BT_PLACEID); //包头
		map.put(CITY.shijiazhuang.getCode(), SJZ_PLACEID); //石家庄站
		map.put(CITY.shenyang.getCode(), LN_PLACEID); //辽宁 沈阳站
		map.put(CITY.dalian.getCode(), DL_PLACEID); //大连站
		map.put(CITY.haerbin.getCode(),  HRB_PLACEID); //哈尔滨站
		map.put(CITY.changchun.getCode(), CC_PLACEID); //长春站
		map.put(CITY.qiqihaer.getCode(), QQHR_PLACEID); //齐齐哈尔站
		map.put(CITY.yanbian.getCode(),  YB_PLACEID); //延边朝鲜
		map.put(CITY.xian.getCode(),  XA_PLACEID); //西安
		map.put(CITY.yinchuan.getCode(), YC_PLACEID); //银川站
		map.put(CITY.xining.getCode(), XN_PLACEID); //西宁站
		map.put(CITY.wulumuqi.getCode(), WLMQ_PLACEID); //乌鲁木齐站
		map.put(CITY.qingdao.getCode(), QD_PLACEID);//青岛站
		map.put(CITY.jinan.getCode(), SD_PLACEID);//山东 济南站
		map.put(CITY.taian.getCode(), TA_PLACEID);//泰安站
	
		//广州-----深圳、香港、澳门、长沙、南宁、桂林、武汉、洛阳、郑州、海口、三亚、张家界、珠海；
		map.put(CITY.guangzhou.getCode(), GZ_PLACEID); //广州站
		map.put(CITY.shenzhen.getCode(), SZ_PLACEID); //深圳站
		map.put(CITY.changsha.getCode(), CS_PLACEID); //长沙站
		map.put(CITY.nanning.getCode(), NN_PLACEID); //南宁站
		map.put(CITY.guilin.getCode(), GL_PLACEID); //桂林站
		map.put(CITY.wuhan.getCode(), HB_PLACEID); //武汉站
		map.put(CITY.luoyang.getCode(), LY_PLACEID); //洛阳站
		map.put(CITY.zhengzhou.getCode(), HN_PLACEID); //郑州站
		map.put(CITY.haikou.getCode(), HK_PLACEID); //海口站
		map.put(CITY.sanya.getCode(), SY_PLACEID); //三亚站
		map.put(CITY.zhangjiajie.getCode(), ZJJ_PLACEID); //张家界站
		map.put(CITY.zhuhai.getCode(), ZH_PLACEID); //珠海站
		map.put(CITY.xiamen.getCode(), XM_PLACEID); //厦门站
		map.put(CITY.fuzhou.getCode(), FZ_PLACEID); //福州站
		
		//成都-----重庆、昆明、丽江、大理、西双版纳、香格里拉、贵阳、拉萨；
		map.put(CITY.chengdu.getCode(), CD_PLACEID); //成都站
		map.put(CITY.chongqin.getCode(), CQ_PLACEID); //重庆站
		map.put(CITY.kunming.getCode(), KM_PLACEID); //昆明站
		map.put(CITY.lijiang.getCode(), LJ_PLACEID); //丽江站
		map.put(CITY.dali.getCode(), DLA_PLACEID); //大理站
		map.put(CITY.xishuangbanna.getCode(), XSBN_PLACEID); //西双版纳站
		map.put(CITY.xianggelila.getCode(), XGLL_PLACEID); //香格里拉站
		map.put(CITY.guiyang.getCode(), GY_PLACEID); //贵阳站
		map.put(CITY.lasa.getCode(), LS_PLACEID); //拉萨站
		return map;
	}
	
	/**
	 * 邮轮
	 * 通过provinceId
	 */
	private static Map<String, Long> getYoulunMapByProvinceID() {
		Map<String, Long> map = new HashMap<String, Long>();
		map.put(PROVINCE.beijin.getCode(), BJ_PLACEID); //北京站
		map.put(PROVINCE.tianjin.getCode(), BJ_PLACEID); //天津站
		map.put(PROVINCE.xianggang.getCode(), GZ_PLACEID); //香港站
		map.put(PROVINCE.aomen.getCode(), GZ_PLACEID); //澳门站
		map.put(PROVINCE.guangdong.getCode(), GZ_PLACEID);//广东
		map.put(PROVINCE.sichuan.getCode(), CD_PLACEID); //四川
		return map;
	}
	
	
	/***
	 * 周边游查询父类fromPlaceId根据fromPlaceId
	 * @return 
	 */ 
	private static Map<Long, Long> getFreetourMapByParentID() {
		Map<Long, Long> map = new HashMap<Long, Long>();
		
		map.put(YC_PLACEID,CD_PLACEID);//银川站
		map.put(TJ_PLACEID, BJ_PLACEID);//天津站
		map.put(HRB_PLACEID,BJ_PLACEID);//哈尔滨站
		map.put(QQHR_PLACEID,BJ_PLACEID);//齐齐哈尔站
		map.put(CC_PLACEID,BJ_PLACEID);//长春站
		map.put(YB_PLACEID,BJ_PLACEID);//延边朝鲜
		map.put(SJZ_PLACEID,BJ_PLACEID);//石家庄站
		map.put(TS_PLACEID,BJ_PLACEID);//唐山站
		map.put(LN_PLACEID,BJ_PLACEID);//辽宁 沈阳站
		map.put(DL_PLACEID,BJ_PLACEID);//大连站
		map.put(SD_PLACEID,BJ_PLACEID);//山东 济南站
		map.put(QD_PLACEID,BJ_PLACEID);//青岛站
		map.put(TA_PLACEID,BJ_PLACEID);//泰安站
		map.put(WZ_PLACEID,HZ_PLACEID);//温州站
		map.put(CS_PLACEID,GZ_PLACEID);//长沙站
		map.put(ZJJ_PLACEID,GZ_PLACEID);//张家界站
		map.put(ZH_PLACEID,GZ_PLACEID);//珠海站
		map.put(NN_PLACEID,GX_PLACEID);//南宁站
		map.put(WH_PLACEID,AH_PLACEID);//芜湖站
		map.put(HS_PLACEID,AH_PLACEID);//黄山站
		map.put(FY_PLACEID,AH_PLACEID);//阜阳站
		map.put(XM_PLACEID,GZ_PLACEID);//厦门站
		map.put(FZ_PLACEID,GZ_PLACEID);//福州站
	//	map.put(SUZ_PLACEID,NJ_PLACEID);//苏州站
		//map.put(WX_PLACEID,NJ_PLACEID);//无锡站
		return map;
	}

	/***
	 * 度假酒店查询父类fromPlaceId根据fromPlaceId
	 *
	 * @return
	 */
	private static Map<Long, Long> getHolidayHotelMapByParentID() {
		Map<Long, Long> map = new HashMap<Long, Long>();

		map.put(YC_PLACEID, CD_PLACEID);//银川站
		map.put(TJ_PLACEID, BJ_PLACEID);//天津站
		map.put(HRB_PLACEID, BJ_PLACEID);//哈尔滨站
		map.put(QQHR_PLACEID, BJ_PLACEID);//齐齐哈尔站
		map.put(CC_PLACEID, BJ_PLACEID);//长春站
		map.put(YB_PLACEID, BJ_PLACEID);//延边朝鲜
		map.put(SJZ_PLACEID, BJ_PLACEID);//石家庄站
		map.put(TS_PLACEID, BJ_PLACEID);//唐山站
		map.put(LN_PLACEID, BJ_PLACEID);//辽宁 沈阳站
		map.put(DL_PLACEID, BJ_PLACEID);//大连站
		map.put(SD_PLACEID, BJ_PLACEID);//山东 济南站
		map.put(QD_PLACEID, BJ_PLACEID);//青岛站
		map.put(TA_PLACEID, BJ_PLACEID);//泰安站
		map.put(WZ_PLACEID, HZ_PLACEID);//温州站
		map.put(CS_PLACEID, GZ_PLACEID);//长沙站
		map.put(ZJJ_PLACEID, GZ_PLACEID);//张家界站
		map.put(ZH_PLACEID, GZ_PLACEID);//珠海站
		map.put(NN_PLACEID, GX_PLACEID);//南宁站
		map.put(WH_PLACEID, AH_PLACEID);//芜湖站
		map.put(HS_PLACEID, AH_PLACEID);//黄山站
		map.put(FY_PLACEID, AH_PLACEID);//阜阳站
		map.put(XM_PLACEID, GZ_PLACEID);//厦门站
		map.put(FZ_PLACEID, GZ_PLACEID);//福州站
		map.put(CD_PLACEID,SH_PLACEID);//成都
		//map.put(WX_PLACEID,NJ_PLACEID);//无锡站
		return map;
	}
	
	/***
	 * 邮轮查询父类fromPlaceId根据fromPlaceId
	 * @return 
	 */ 
	private static Map<Long, Long> getYoulunMapByParentID() {
		Map<Long, Long> map = new HashMap<Long, Long>();
		//北京
		map.put(TY_PLACEID, BJ_PLACEID); //太原站
		map.put(TS_PLACEID, BJ_PLACEID); //唐山站
		map.put(HHHT_PLACEID, BJ_PLACEID); //呼和浩特站
		map.put(BT_PLACEID, BJ_PLACEID); //包头
		map.put(SJZ_PLACEID, BJ_PLACEID); //石家庄站
		map.put(LN_PLACEID, BJ_PLACEID); //辽宁 沈阳站
		map.put(DL_PLACEID, BJ_PLACEID); //大连站
		map.put(HRB_PLACEID, BJ_PLACEID); //哈尔滨站
		map.put(CC_PLACEID, BJ_PLACEID); //长春站
		map.put(QQHR_PLACEID, BJ_PLACEID); //齐齐哈尔站
		map.put(YB_PLACEID, BJ_PLACEID); //延边朝鲜
		map.put(XA_PLACEID, BJ_PLACEID); //西安
		map.put(YC_PLACEID, BJ_PLACEID); //银川站
		map.put(XN_PLACEID, BJ_PLACEID); //西宁站
		map.put(WLMQ_PLACEID, BJ_PLACEID); //乌鲁木齐站
		map.put(SD_PLACEID, BJ_PLACEID);//山东 济南站
		map.put(QD_PLACEID, BJ_PLACEID);//青岛站
		map.put(TA_PLACEID, BJ_PLACEID);//泰安站
		
		//广州-----深圳、香港、澳门、长沙、南宁、桂林、武汉、洛阳、郑州、海口、三亚、张家界、珠海、厦门、福州
		map.put(SZ_PLACEID, GZ_PLACEID); //深圳站
		map.put(CS_PLACEID, GZ_PLACEID); //长沙站
		map.put(NN_PLACEID, GZ_PLACEID); //南宁站
		map.put(GL_PLACEID, GZ_PLACEID); //桂林站
		map.put(HB_PLACEID, GZ_PLACEID); //武汉站
		map.put(LY_PLACEID, GZ_PLACEID); //洛阳站
		map.put(HN_PLACEID, GZ_PLACEID); //郑州站
		map.put(HK_PLACEID, GZ_PLACEID); //海口站
		map.put(SY_PLACEID, GZ_PLACEID); //三亚站
		map.put(ZJJ_PLACEID, GZ_PLACEID); //张家界站
		map.put(ZH_PLACEID, GZ_PLACEID); //珠海站
		map.put(XM_PLACEID, GZ_PLACEID); //厦门站
		map.put(FZ_PLACEID, GZ_PLACEID); //福州站
		
		//成都-----重庆、昆明、丽江、大理、西双版纳、香格里拉、贵阳、拉萨
		map.put(CQ_PLACEID, CD_PLACEID); //重庆站
		map.put(KM_PLACEID, CD_PLACEID); //昆明站
		map.put(LJ_PLACEID, CD_PLACEID); //丽江站
		map.put(DLA_PLACEID, CD_PLACEID); //大理站
		map.put(XSBN_PLACEID, CD_PLACEID); //西双版纳站
		map.put(XGLL_PLACEID, CD_PLACEID); //香格里拉站
		map.put(GY_PLACEID, CD_PLACEID); //贵阳站
		map.put(LS_PLACEID, CD_PLACEID); //拉萨站
		return map;
	}
	
	/**
	 * 获取首页分站划分推荐规则（fromPlaceId,省份）
	 * @return
	 */
	public static Map<String, Long> getHomeMap() {
		Map<String, Long> map = new HashMap<String, Long>();
			//四川站
 			map.put(PROVINCE.xizang.getCode(),CD_PLACEID);
 			map.put(PROVINCE.sichuan.getCode(),CD_PLACEID);
 			map.put(PROVINCE.guizhou.getCode(),CD_PLACEID);
 			map.put(PROVINCE.chongqin.getCode(),CD_PLACEID);
 			map.put(PROVINCE.lingxia.getCode(),CD_PLACEID);
 			//北京站
  			map.put(PROVINCE.neimenggu.getCode(), BJ_PLACEID);
 			map.put(PROVINCE.shanxi.getCode(), BJ_PLACEID);
 			map.put(PROVINCE.hebei.getCode(), BJ_PLACEID);
 			map.put(PROVINCE.shandong.getCode(), BJ_PLACEID);
 			map.put(PROVINCE.beijin.getCode(), BJ_PLACEID);
 			map.put(PROVINCE.tianjin.getCode(), BJ_PLACEID);
 			map.put(PROVINCE.jilin.getCode(), BJ_PLACEID);
 			map.put(PROVINCE.liaoning.getCode(), BJ_PLACEID);
 			map.put(PROVINCE.heilongjiang.getCode(), BJ_PLACEID);
 			//广东站
 			map.put(PROVINCE.guangdong.getCode(), GZ_PLACEID);
 			map.put(PROVINCE.hunan.getCode(), GZ_PLACEID);
 			map.put(PROVINCE.aomen.getCode(), GZ_PLACEID);
 			map.put(PROVINCE.xianggang.getCode(), GZ_PLACEID);
 			//浙江站
 			map.put(PROVINCE.zhejiang.getCode(), HZ_PLACEID);
 			map.put(PROVINCE.fujian.getCode(),HZ_PLACEID);
 			map.put(PROVINCE.taiwan.getCode(), HZ_PLACEID);
 			map.put(PROVINCE.jiangxi.getCode(), HZ_PLACEID);
 			//江苏站
			map.put(PROVINCE.jiangsu.getCode(), NJ_PLACEID);
			map.put(PROVINCE.anwei.getCode(), NJ_PLACEID);
			//海南
			map.put(PROVINCE.hainan.getCode(), SY_PLACEID);
			//上海
			map.put(PROVINCE.shanghai.getCode(), SH_PLACEID);
			//广西
			map.put(PROVINCE.guangxi.getCode(), GX_PLACEID);
			//云南
			map.put(PROVINCE.yunnan.getCode(),YN_PLACEID);
			//陕西
			map.put(PROVINCE.sanxi.getCode(),SX_PLACEID);
			//湖北武汉
			map.put(PROVINCE.hubei.getCode(), HB_PLACEID);
 		return map;
	}
	
	/**
	 *门票分站划分推荐规则（fromPlaceId,省份）
	 * @return
	 */
	public static Map<String, Long> getTicketMap() {
		Map<String, Long> map = new HashMap<String, Long>();
			//江苏站
			map.put(PROVINCE.jiangsu.getCode(), NJ_PLACEID);
			//浙江站
			map.put(PROVINCE.zhejiang.getCode(), HZ_PLACEID);
			//安徽站
			map.put(PROVINCE.anwei.getCode(), AH_PLACEID);
			//江西站--江西
			map.put(PROVINCE.jiangxi.getCode(), JX_PLACEID);
			//福建站--福建，台湾
			map.put(PROVINCE.fujian.getCode(), FJ_PLACEID);
			map.put(PROVINCE.taiwan.getCode(), FJ_PLACEID);
			//湖北站--湖北
			map.put(PROVINCE.hubei.getCode(), HB_PLACEID);
			//河南站--河南
			map.put(PROVINCE.henan.getCode(), HN_PLACEID);
			//
			//四川站--四川，贵州，重庆，西藏 ，甘肃，宁夏，新疆，青海
			map.put(PROVINCE.xizang.getCode(),CD_PLACEID);
			map.put(PROVINCE.sichuan.getCode(),CD_PLACEID);
			map.put(PROVINCE.guizhou.getCode(),CD_PLACEID);
			map.put(PROVINCE.chongqin.getCode(),CD_PLACEID);
			map.put(PROVINCE.gansu.getCode(), CD_PLACEID);
			map.put(PROVINCE.xinjiang.getCode(), CD_PLACEID);
			
			//陕西
			map.put(PROVINCE.sanxi.getCode(), SX_PLACEID);
	        map.put(PROVINCE.qinghai.getCode(), SX_PLACEID);
	        map.put(PROVINCE.lingxia.getCode(), SX_PLACEID);
			
			//北京站--北京，内蒙，山西，河北，山东，北京，天津，吉林，辽宁，黑龙江
			map.put(PROVINCE.beijin.getCode(), BJ_PLACEID);
			map.put(PROVINCE.shanxi.getCode(), BJ_PLACEID);
			map.put(PROVINCE.hebei.getCode(), BJ_PLACEID);
			map.put(PROVINCE.shandong.getCode(), BJ_PLACEID);
			map.put(PROVINCE.tianjin.getCode(), BJ_PLACEID);
			//辽宁站   10.21 做上线修改
			map.put(PROVINCE.jilin.getCode(), LN_PLACEID);
			map.put(PROVINCE.liaoning.getCode(), LN_PLACEID);
			map.put(PROVINCE.heilongjiang.getCode(), LN_PLACEID);
			map.put(PROVINCE.neimenggu.getCode(), LN_PLACEID);
			//山东站
			map.put(PROVINCE.shandong.getCode(), SD_PLACEID);
			
			//广东站--广东，湖南，澳门，香港, 海南
			map.put(PROVINCE.guangdong.getCode(), GZ_PLACEID);
			map.put(PROVINCE.hunan.getCode(), GZ_PLACEID);
			map.put(PROVINCE.aomen.getCode(), GZ_PLACEID);
			map.put(PROVINCE.xianggang.getCode(), GZ_PLACEID);
			
			//广西
			map.put(PROVINCE.guangxi.getCode(), GX_PLACEID);
			
			//海南站(三亚id)
			map.put(PROVINCE.hainan.getCode(),SY_PLACEID);
			//上海站--上海，其它IP，无法识别IP
			map.put(PROVINCE.shanghai.getCode(), SH_PLACEID);
			//云南
			map.put(PROVINCE.yunnan.getCode(),YN_PLACEID);
 		return map;
	}
	
	/**
	 * 周边游
	 * @return
	 */
	private static Map<String, Long> getFreetourMap() {
		Map<String, Long> map = new HashMap<String, Long>();
		//四川站----陕西，西藏，四川，贵州，重庆，宁夏，青海，新疆，甘肃，
		map.put(PROVINCE.sanxi.getCode(), CD_PLACEID);
		map.put(PROVINCE.xizang.getCode(), CD_PLACEID);
 		map.put(PROVINCE.sichuan.getCode(),CD_PLACEID);
		map.put(PROVINCE.guizhou.getCode(),CD_PLACEID);
		map.put(PROVINCE.chongqin.getCode(),CD_PLACEID);
		map.put(PROVINCE.lingxia.getCode(), CD_PLACEID);
		map.put(PROVINCE.qinghai.getCode(), CD_PLACEID);
		map.put(PROVINCE.xinjiang.getCode(), CD_PLACEID);
		map.put(PROVINCE.gansu.getCode(), CD_PLACEID);
		//北京站---内蒙，山西，河北，山东，北京，天津，吉林，辽宁，黑龙江
		map.put(PROVINCE.beijin.getCode(), BJ_PLACEID);
		map.put(PROVINCE.neimenggu.getCode(), BJ_PLACEID);
		map.put(PROVINCE.shanxi.getCode(), BJ_PLACEID);
		map.put(PROVINCE.hebei.getCode(), BJ_PLACEID);
		map.put(PROVINCE.shandong.getCode(), BJ_PLACEID);
		map.put(PROVINCE.tianjin.getCode(), BJ_PLACEID);
		map.put(PROVINCE.jilin.getCode(), BJ_PLACEID);
		map.put(PROVINCE.liaoning.getCode(), BJ_PLACEID);
		map.put(PROVINCE.heilongjiang.getCode(), BJ_PLACEID);
		//广东站---广东，湖南，澳门，香港, 海南
		map.put(PROVINCE.guangdong.getCode(), GZ_PLACEID);
		
		//广西
		map.put(PROVINCE.guangxi.getCode(), GX_PLACEID);
		
		map.put(PROVINCE.hunan.getCode(), GZ_PLACEID);
		map.put(PROVINCE.aomen.getCode(), GZ_PLACEID);
		map.put(PROVINCE.xianggang.getCode(), GZ_PLACEID);
		map.put(PROVINCE.hainan.getCode(), GZ_PLACEID);
		//上海站--福建，台湾，安徽，江西，上海,河南，湖北
		map.put(PROVINCE.shanghai.getCode(), SH_PLACEID);
		//浙江站
		map.put(PROVINCE.zhejiang.getCode(), HZ_PLACEID);
		
		//南京站 苏州站 无锡站
		map.put(PROVINCE.jiangsu.getCode(),NJ_PLACEID);
		//云南
		map.put(PROVINCE.yunnan.getCode(),YN_PLACEID);
 		return map;
	}
	
	/**
	 * 国内游
	 * @return
	 */
	private static Map<String, Long> getDestrouteMap() {
		Map<String, Long> map = new HashMap<String, Long>();
		//四川站----陕西，西藏，四川，贵州，重庆，宁夏，青海，新疆，甘肃，
		map.put(PROVINCE.sanxi.getCode(), CD_PLACEID);
		map.put(PROVINCE.xizang.getCode(), CD_PLACEID);
 		map.put(PROVINCE.sichuan.getCode(),CD_PLACEID);
		map.put(PROVINCE.guizhou.getCode(),CD_PLACEID);
		map.put(PROVINCE.chongqin.getCode(),CD_PLACEID);
		map.put(PROVINCE.lingxia.getCode(), CD_PLACEID);
		map.put(PROVINCE.qinghai.getCode(), CD_PLACEID);
		map.put(PROVINCE.xinjiang.getCode(), CD_PLACEID);
		map.put(PROVINCE.gansu.getCode(), CD_PLACEID);
		//北京站---内蒙，山西，河北，山东，北京，天津，吉林，辽宁，黑龙江
		map.put(PROVINCE.beijin.getCode(), BJ_PLACEID);
		map.put(PROVINCE.neimenggu.getCode(), BJ_PLACEID);
		map.put(PROVINCE.shanxi.getCode(), BJ_PLACEID);
		map.put(PROVINCE.hebei.getCode(), BJ_PLACEID);
		map.put(PROVINCE.shandong.getCode(), BJ_PLACEID);
		map.put(PROVINCE.tianjin.getCode(), BJ_PLACEID);
		map.put(PROVINCE.jilin.getCode(), BJ_PLACEID);
		map.put(PROVINCE.liaoning.getCode(), BJ_PLACEID);
		map.put(PROVINCE.heilongjiang.getCode(), BJ_PLACEID);
		//广东站---广东，广西，湖南，澳门，香港, 海南
		map.put(PROVINCE.guangdong.getCode(), GZ_PLACEID);
		map.put(PROVINCE.guangxi.getCode(), GZ_PLACEID);
		map.put(PROVINCE.hunan.getCode(), GZ_PLACEID);
		map.put(PROVINCE.aomen.getCode(), GZ_PLACEID);
		map.put(PROVINCE.xianggang.getCode(), GZ_PLACEID);
		map.put(PROVINCE.hainan.getCode(), GZ_PLACEID);
		//上海站--福建，台湾，安徽，江西，上海,河南，湖北
		map.put(PROVINCE.shanghai.getCode(), SH_PLACEID);
		
		//南京站--江苏
        map.put(PROVINCE.jiangsu.getCode(),NJ_PLACEID);
 	    //杭州站--浙江
 		map.put(PROVINCE.zhejiang.getCode(),HZ_PLACEID);
 		//云南
 		map.put(PROVINCE.yunnan.getCode(),YN_PLACEID);

 		return map;
	}
	/**
	 * 出境游
	 * @return
	 */
	private static Map<String, Long> getAbroadMap() {
		Map<String, Long> map = new HashMap<String, Long>();
		//四川站----陕西，西藏，四川，贵州，重庆，宁夏，青海，新疆，甘肃，
		map.put(PROVINCE.sanxi.getCode(), CD_PLACEID);
		map.put(PROVINCE.xizang.getCode(), CD_PLACEID);
 		map.put(PROVINCE.sichuan.getCode(),CD_PLACEID);
		map.put(PROVINCE.guizhou.getCode(),CD_PLACEID);
		map.put(PROVINCE.chongqin.getCode(),CD_PLACEID);
		map.put(PROVINCE.lingxia.getCode(), CD_PLACEID);
		map.put(PROVINCE.qinghai.getCode(), CD_PLACEID);
		map.put(PROVINCE.xinjiang.getCode(), CD_PLACEID);
		map.put(PROVINCE.gansu.getCode(), CD_PLACEID);
		//北京站---内蒙，山西，河北，山东，北京，天津，吉林，辽宁，黑龙江,河南
		map.put(PROVINCE.beijin.getCode(), BJ_PLACEID);
		map.put(PROVINCE.neimenggu.getCode(), BJ_PLACEID);
		map.put(PROVINCE.shanxi.getCode(), BJ_PLACEID);
		map.put(PROVINCE.hebei.getCode(), BJ_PLACEID);
		map.put(PROVINCE.shandong.getCode(), BJ_PLACEID);
		map.put(PROVINCE.tianjin.getCode(), BJ_PLACEID);
		map.put(PROVINCE.jilin.getCode(), BJ_PLACEID);
		map.put(PROVINCE.liaoning.getCode(), BJ_PLACEID);
		map.put(PROVINCE.heilongjiang.getCode(), BJ_PLACEID);
		map.put(PROVINCE.henan.getCode(), BJ_PLACEID);
		//广东站---广东，广西，湖南，澳门，香港, 海南,福建
		map.put(PROVINCE.guangdong.getCode(), GZ_PLACEID);
		map.put(PROVINCE.guangxi.getCode(), GZ_PLACEID);
		map.put(PROVINCE.hunan.getCode(), GZ_PLACEID);
		map.put(PROVINCE.aomen.getCode(), GZ_PLACEID);
		map.put(PROVINCE.xianggang.getCode(), GZ_PLACEID);
		map.put(PROVINCE.hainan.getCode(), GZ_PLACEID);
		map.put(PROVINCE.fujian.getCode(), GZ_PLACEID);
		//上海站--浙江，福建，台湾，江苏，安徽，江西，上海,河南，湖北
		map.put(PROVINCE.shanghai.getCode(), SH_PLACEID);
		//云南
		map.put(PROVINCE.yunnan.getCode(),YN_PLACEID);
 		return map;
	}
	
	
	/**
	 * 频道通过省份获取出发地
	 * @param provinceId 省份ID
	 * @param cityId 城市ID
	 * @param channelPage 渠道
	 * @return fromplaceId 
	 */
	public static Long executeDataForPindao(String cityId,String provinceId,String channelPage) {
		if(StringUtils.isBlank(cityId)||StringUtils.isBlank(provinceId)||StringUtils.isBlank(channelPage)){
			return null;
		}
		Long fromPlaceId = null;
		//周边自由行
		if(channelPage.equals(Constant.CHANNEL_ID.CH_FREETOUR.name())){
			//如果在城市中没有发现 则调取省份fromPlaceId
			if(getFreetourMapByCityID().containsKey(cityId)){
				fromPlaceId = getFreetourMapByCityID().get(cityId)==null?null:getFreetourMapByCityID().get(cityId);
			}
			
			if(null == fromPlaceId && getFreetourMapByProvinceID().containsKey(provinceId)){
				fromPlaceId = getFreetourMapByProvinceID().get(provinceId)==null?SH_PLACEID:getFreetourMapByProvinceID().get(provinceId);
			}
		}
		
		//邮轮
		if(channelPage.equals(Constant.CHANNEL_ID.CH_YOULUN.name())){
			//如果在城市中没有发现，则调取省份fromPlaceId
			if(getYoulunMapByCityID().containsKey(cityId)) {
				fromPlaceId = getYoulunMapByCityID().get(cityId) == null ? null : getYoulunMapByCityID().get(cityId);
			}
			if(null == fromPlaceId && getYoulunMapByProvinceID().containsKey(provinceId)) {
				fromPlaceId = getYoulunMapByProvinceID().get(provinceId) == null ? SH_PLACEID : getYoulunMapByProvinceID().get(provinceId);
			}
		}
		//度假酒店
		if (channelPage.equals(PindaoPageUtils.HOLIDAY_HOTEL_CHANNELPAGE)) {
			//如果在城市中没有发现 则调取省份fromPlaceId
			if (getHolidayHotelMapByCityID().containsKey(cityId)) {
				fromPlaceId = getHolidayHotelMapByCityID().get(cityId) == null ? null : getHolidayHotelMapByCityID().get(cityId);
			}

			if (null == fromPlaceId && getHolidayHotelMapByProvinceID().containsKey(provinceId)) {
				fromPlaceId = getHolidayHotelMapByProvinceID().get(provinceId) == null ? SH_PLACEID : getHolidayHotelMapByProvinceID().get(provinceId);
			}
		}
		return fromPlaceId;
	}
	

	/**
	 * 查询上级fromPlaceId
	 * */
	public static Long parentFromPlaceIdForPindao(String channelPage,Long fromPlaceId){
		if(channelPage.equals(Constant.CHANNEL_ID.CH_FREETOUR.name())){
			if(getFreetourMapByParentID().containsKey(fromPlaceId)){
				return getFreetourMapByParentID().get(fromPlaceId)==null?SH_PLACEID:getFreetourMapByParentID().get(fromPlaceId);
			}
		}
		if(channelPage.equals(Constant.CHANNEL_ID.CH_YOULUN.name())){
			if(getYoulunMapByParentID().containsKey(fromPlaceId)){
				return getYoulunMapByParentID().get(fromPlaceId)==null?SH_PLACEID:getYoulunMapByParentID().get(fromPlaceId);
			}
		}
		//度假酒店
		if (channelPage.equals(PindaoPageUtils.HOLIDAY_HOTEL_CHANNELPAGE)) {
			if (getHolidayHotelMapByParentID().containsKey(fromPlaceId)) {
				return getHolidayHotelMapByParentID().get(fromPlaceId) == null ? SH_PLACEID : getHolidayHotelMapByParentID().get(fromPlaceId);
			}
		}
		return null;
	}
	/**
	 * 频道通过省份获取出发地
	 * @param provinceName
	 * @param channelPage
	 * @return fromplaceId
	 */
	public static Long executeDataForPindao(String provinceId,String channelPage) {
		if(StringUtils.isBlank(provinceId)||StringUtils.isBlank(channelPage)){
			return null;
		}
		if(channelPage.equals(Constant.CHANNEL_ID.CH_INDEX.name())){
			if(getHomeMap().containsKey(provinceId)){
				return getHomeMap().get(provinceId)==null?SH_PLACEID:getHomeMap().get(provinceId);
			}
		}
		if(channelPage.equals(Constant.CHANNEL_ID.CH_TICKET.name())){
			if(getTicketMap().containsKey(provinceId)){
				return getTicketMap().get(provinceId)==null?SH_PLACEID:getTicketMap().get(provinceId);
			}
		}
		if(channelPage.equals(Constant.CHANNEL_ID.CH_FREETOUR.name())){
			if(getFreetourMap().containsKey(provinceId)){
				return getFreetourMap().get(provinceId)==null?SH_PLACEID:getFreetourMap().get(provinceId);
			}
		}
		if(channelPage.equals(Constant.CHANNEL_ID.CH_DESTROUTE.name())){
			if(getDestrouteMap().containsKey(provinceId)){
				return getDestrouteMap().get(provinceId)==null?SH_PLACEID:getDestrouteMap().get(provinceId);
			}
		}
		if(channelPage.equals(Constant.CHANNEL_ID.CH_ABROAD.name())){
			if(getAbroadMap().containsKey(provinceId)){
				return getAbroadMap().get(provinceId)==null?SH_PLACEID:getAbroadMap().get(provinceId);
			}
		}
		return null;
	}
	
	public static String getFromPlaceName2(String fromPlaceName,String channelPage){
		if(channelPage.equals(Constant.CHANNEL_ID.CH_FREETOUR.name())){
			if(contain(fromPlaceName,aroundPageFromPlaceName)){
				return fromPlaceName;
			}
			 
		}
		return "上海";
	}
	
	
	public static String getFromPlaceName(String fromPlaceName,String channelPage){
		if(channelPage.equals(Constant.CHANNEL_ID.CH_INDEX.name())){
			if(contain(fromPlaceName,homePageFromPlaceName)){
				return fromPlaceName;
			}
			 
		}
		if(channelPage.equals(Constant.CHANNEL_ID.CH_TICKET.name())){
			return fromPlaceName;
			 
		}
		if(channelPage.equals(Constant.CHANNEL_ID.CH_FREETOUR.name())){
			if(contain(fromPlaceName,aroundPageFromPlaceName)){
				return fromPlaceName;
			}
			 
		}
		if(channelPage.equals(Constant.CHANNEL_ID.CH_DESTROUTE.name())){
			if(contain(fromPlaceName,nationalPageFromPlaceName)){
				return fromPlaceName;
			}
			 
		}
		if(channelPage.equals(Constant.CHANNEL_ID.CH_ABROAD.name())){
			if(contain(fromPlaceName,abroadPageFromPlaceName)){
				return fromPlaceName;
			}
			 
		}
		return "上海";
	}
	public static final String[] homePageFromPlaceName={"北京","上海","南京","杭州","成都","广州","三亚","长春","沈阳","哈尔滨","大连","北京","天津","石家庄","太原","呼和浩特","上海","南京","杭州","合肥","厦门","济南","南昌","苏州","无锡","宁波","常州","嘉兴","南通","扬州","镇江","绍兴","温州","金华","台州","盐城","郑州","武汉","长沙","广州","深圳","南宁","海口","香港","澳门","重庆","成都","贵阳","拉萨","西安","银川","西宁","乌鲁木齐","昆明","大理","丽江","香格里拉","西双版纳","腾冲"};
	public static final String[] aroundPageFromPlaceName={"北京","上海","南京","杭州","成都","广州","三亚","上海","苏州","无锡","杭州","宁波","常州","南京","嘉兴","温州","南通","扬州","镇江","北京","绍兴","福州","金华","湖州","台州","武汉","青岛","盐城","广州"};
	public static final String[] nationalPageFromPlaceName={"北京","上海","南京","杭州","成都","广州","三亚","深圳","无锡","常州","宁波","南通"};
	public static final String[] abroadPageFromPlaceName={"上海","广州","深圳","北京","成都","南京","杭州","宁波","温州"};

	public static  boolean contain(String targetName,String[] targetList){
		 boolean flag=false;//深圳 深圳
		 for(String v:targetList){
			 if(v.equals(targetName)){
				 flag=true;
			 }
		 }
		 return flag;
	}
	public static void main(String[] args) {
		System.out.print(getFromPlaceName("唐山",Constant.CHANNEL_ID.CH_INDEX.name()));
	}
	/**上海-上海*/
	public static final String homePageFromPlaceNameSH="79";
	/**浙江-浙江 福建 台湾 江西*/
	public static final String homePageFromPlaceNameZJ="96,135,401,145";
	/**四川-陕西 西藏 四川 云南 贵州 宁夏*/
	public static final String homePageFromPlaceNameSC="339,331,278,312,300,375";
	/**广东-广东 广西 湖南 澳门 香港*/
	public static final String homePageFromPlaceNameGD="228,251,212,400,398";
	/**北京-内蒙 山西 河北 山东 北京 天津 吉林 辽宁 黑龙江*///吉林有两个58,56 黑龙江没有placeId
	public static final String homePageFromPlaceNameBJ="27,15,3,159,1,2,58,56,41";
	/**江苏-江苏 安徽*/
	public static final String homePageFromPlaceNameJS="80,118";
	/**深圳-深圳*/
	public static final String homePageFromPlaceNameSZ="231";
	/**重庆-重庆*/
	public static final String homePageFromPlaceNameCQ="277";
	/**海南-海南*/
	public static final String homePageFromPlaceNameHN="267";
	
	public static enum HOT_TYPE {
        _ZZY("自助游"),
        _MPL("门票类"),
        _JDL("酒店类"),
        _ZYX("自由行"),
        _GTY("跟团游"),
        _CJY("出境游"),
        _XLL("线路类");
        
        private String cnName;
        HOT_TYPE(String name){
            this.cnName=name;
        }
        public String getCode(){
            return this.name();
        }
        public String getCnName(){
            return this.cnName;
        }
        public static String getCnName(String code){
            for(HOT_TYPE item:HOT_TYPE.values()){
                if(item.getCode().equals(code))
                {
                    return item.getCnName();
                }
            }
            return code;
        }
	}
	

	public static String parentFromPlaceCodeForPindao(String channel,
			Long fromPlaceId, Long parentFromPlaceId) {
		//邮轮
		if(Constant.CHANNEL_ID.CH_YOULUN.name().equals(channel)){
			if(getYoulunMapByParentCode().containsKey(fromPlaceId)){
				return getYoulunMapByParentCode().get(fromPlaceId);
			}
		}
		return PindaoPageUtils.PLACEID_PLACECODE.getPlacecode(parentFromPlaceId);
	}

	private static Map<Long, String> getYoulunMapByParentCode() {
		Map<Long, String> map = new HashMap<Long, String>();
		map.put(BJ_PLACEID, PindaoPageUtils.PLACEID_PLACECODE.SH.placecode);//北京站
		map.put(GZ_PLACEID, PindaoPageUtils.PLACEID_PLACECODE.SH.placecode);//广州站
		map.put(CD_PLACEID, PindaoPageUtils.PLACEID_PLACECODE.SH.placecode);//成都站
		return map;
	}
}