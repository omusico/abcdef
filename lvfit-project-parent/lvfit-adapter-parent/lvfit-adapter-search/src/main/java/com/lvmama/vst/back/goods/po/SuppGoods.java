package com.lvmama.vst.back.goods.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.lvmama.vst.back.biz.po.BizBranch;
import com.lvmama.vst.back.biz.po.BizCategory;
import com.lvmama.vst.back.dist.po.DistDistributorGoods;
import com.lvmama.vst.back.prod.po.ProdPackageDetail;
import com.lvmama.vst.back.prod.po.ProdProduct;
import com.lvmama.vst.back.prod.po.ProdProductBranch;
import com.lvmama.vst.back.supp.po.SuppContract;
import com.lvmama.vst.back.supp.po.SuppFaxRule;
import com.lvmama.vst.back.supp.po.SuppSupplier;
import com.lvmama.vst.back.supp.vo.SuppGoodsLineTimePriceVo;
import com.lvmama.vst.back.wifi.po.SuppGoodsRentedLimit;
import com.lvmama.vst.comm.utils.order.PriceUtil;

public class SuppGoods implements Serializable {

	/**
	 * 序列
	 */
	private static final long serialVersionUID = 2053515765136237506L;

	private Long suppGoodsId;//商品组ID
	
	private Long contractId;
	
	private Long supplierId;
	
	private Long productId;	
	private Long groupId;	
	private Long attributionId;
	private String attributionName;
	private String groupName;
	
	private Long productBranchId;
	
	private Long faxRuleId;

	private SuppContract suppContract;

	private SuppSupplier suppSupplier;

	private ProdProduct prodProduct;

	private ProdProductBranch prodProductBranch;
	
	private BizBranch bizBranch;
	
	private String goodsName;
	
	private String payTarget;//支付对象
	
	private String packageFlag;//是否组合销售
	
	private String faxFlag;//是否使用传真

	private String goodsType;//商品类型

	private Long managerId;	//产品经理
	
	private String expressType;//寄件方

	private String noticeType;//通知方式

	private Long certValidDay;//凭证有效天数

	private Long adult;//成人数

	private Long child;
	
	private String senisitiveFlag;

	private String cancelFlag;//是否有效

	private String onlineFlag;//是否可售（计算得出,有价格有库存可卖）-----(改自是否上架)

	private String goodsDesc;//商品描述

	private String lvmamaFlag;//是否仅驴妈妈自有销售

	private String distributeFlag;//是否可分销
	
	private String filiale;//分公司
	
	private String bu;//bu
	
	private Long minStayDay;//最小连住天数
	
	private Long maxStayDay;//最大连住天数
	
	private Long minQuantity;//最少起订量
	
	private Long maxQuantity;//最大起订量
	
	private SuppFaxRule suppFaxRule;//供应商传真策略
	
	private String managerName;
	
	private String branchName;	
	
	//内容维护人员
	private Long contentManagerId;
	
	private String contentManagerName;
	
	//区域负责人 add by xiaorui.mu begin
     private Long regionalLeaderId;
	
	private String regionalLeaderName;
	//商务人员
    private Long commercialStaffId;
	
	private String commercialStaffName;
	//add by xiaorui.mu end
	//组织ID
	private Long orgId;
	
	private String hasTimePriceFlag;
	//币种
	private String currencyType;
	//价格类型
	private String priceType;
	
	private Date createTime;
	
	private String createUser;
	
	private Date updateTime;
	
	private String updateUser;
	//门票票种
	private String goodsSpec;

	//门票票种显示名称
	private String goodsSpecName;

	//是否期票
	private String aperiodicFlag;
	//排序
	private Integer seq;
	
	private String xingBrigadeFlag;//是否兴旅同业中心可售
	
	private String distributorIds;//分销商列表
	
	//门票商品有效期
	private SuppGoodsExp suppGoodsExp;

    private SuppGoodsAddition suppGoodsAddition;//商品附加信息表
    
    private String stayDays;
    
    private SuppGoodsRelation parentGoodsRelation=null;
   
    //品类ID
    private Long categoryId;
    
    //是否对接
    private String apiFlag;
    
    //是否使用库存
    private String stockApiFlag;
    
    //是否使用ebk
    private String ebkFlag;
    
    /**
     * 是否及时通关，只用于门票（Y：不及时；N or null：及时）
     */
    private String notInTimeFlag;
    
    private Long branchId;
    /**
     * 供应商商品ID
     */
    private Long soaSuppGoodsId;
    
    private BizCategory bizCategory;

    private SuppGoodsDesc suppGoodsDesc;
    
    //是否买断
    private String buyoutFlag;
    
	/**
     * 主规格商品关联次规格商品
     */
    private List<SuppGoodsRelation> suppGoodsRelationList;
    
    /**
     * 满足儿童数
     */
    private Long fitChildQuantity = 0L;
    
    /**
     * 满足成人数
     */
    private Long fitAdultQuantity = 0L;
    
    /**
     * 份数
     */
    private Long fitQuantity ;
    
    /**
     * 价格选择（酒店、门票），
     * 注：如果是附加产品，则此处 key：日期 value：价格（此处单价）
     */
    private Map<String, Long> selectPriceMap = null;
    
    /**
     * 价格选择（当地游）因为价格涉及成人价儿童价和房差价格，
     * 注：如果是附加产品，则此处 key：日期 value：价格（此处单价）
     */
    private Map<String,SuppGoodsLineTimePriceVo> goodsLocalSelectPriceMap=null;
    
    /**
     * 房差价格 key 日期 value 每份价格
     */
    private Map<String, Long> selectGapPriceMap = null;
    
    /**
     * 附加次规格可选份数范围(多个时使用逗号","分隔)
     */
    private String selectQuantityRange;
    
    private String selectAdultQuantityRange;
    
    private String selectChildQuantityRange;
    
    /**
     * 房差选择份数访问(多个时使用逗号","分隔)
     */
    private String selectGapQuantityRange;
    
    /**
     * 成人儿童房差价
     */
    private Long gapPrice = 0L;
    
    private Long childPrice= 0L;
    
    private Long childSellmentPrice= 0L;
    
    private Long adultPrice= 0L;
    
    private Long adultSellmentPrice= 0L;
    
    private Long gapSellmentPrice= 0L;
    
    //排序使用
    private Long stock;
    
    //限制预订天数
    private Long limitBookDay;
    
    //商品租赁限制
    private SuppGoodsRentedLimit suppGoodsRentedLimit;
    
    /**
     * 传真备注
     */
    private String faxRemark;
    
	/**
	 * VO属性
	 * 主次规格关联关系，此处存放的是主规格对次规格的关联关系 对应SuppGoodsRelation.RELATIONTYPE
	 */
	private String relationType;
    
    /**
     * 商品对应的时间价格
     */
    private SuppGoodsBaseTimePrice suppGoodsBaseTimePrice=null;
    
    
    private List<SuppGoodsBaseTimePrice> suppGoodsBaseTimePriceList=null;
    
    private List<SuppGoodsRefund> goodsReFundList; 
    
    private List<SuppGoodsLineTimePriceVo> suppGoodsLineTimePriceVo=new ArrayList<SuppGoodsLineTimePriceVo>();
    /**
     * add by huanggen on 20150423,just for default distributors
     * 逗号分隔的字符串，表示 super系统分销商, 当distributorIds含有‘4’时，这个字段才有意义 <br>
     * 	[10000-968]无线WAP（个人） <br>
     *  [10000-967]无线APP（个人）  <br>
     *  [107-972]特卖会（个人） <br>
     *  [111-2029] 驴悦亲子  <br>
     *  [112-2399]自驾游  <br>
     *  [0-0]其他分销    <br>
     */
    private String distributorUserIds;


	private ProdPackageDetail prodPackageDetail;
	
	private String cancelStrategy;
	/**
	 * 公司主体
	 * @see ProdProduct.COMPANY_TYPE_DIC
	 */
	private String companyType;

    /**
     * 发消息的内容id，映射于APERIODIC_TYPE枚举的id（0代表不发送）
     */
    private int aperiodicTypeId = 0;
	
	//是否是马戏票
	private String isCircus = "0";
	
	public String getIsCircus() {
		return isCircus;
	}

	public void setIsCircus(String isCircus) {
		this.isCircus = isCircus;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public ProdPackageDetail getProdPackageDetail() {
		return prodPackageDetail;
	}

	public void setProdPackageDetail(ProdPackageDetail prodPackageDetail) {
		this.prodPackageDetail = prodPackageDetail;
	}

	public String getDistributorUserIds() {
		return distributorUserIds;
	}

	public void setDistributorUserIds(String distributorUserIds) {
		this.distributorUserIds = distributorUserIds;
	}
	
	public String getCancelStrategy() {
		return cancelStrategy;
	}

	public void setCancelStrategy(String cancelStrategy) {
		this.cancelStrategy = cancelStrategy;
	}

	public List<SuppGoodsRefund> getGoodsReFundList() {
		return goodsReFundList;
	}

	public void setGoodsReFundList(List<SuppGoodsRefund> goodsReFundList) {
		this.goodsReFundList = goodsReFundList;
	}
	
	 /**
     * 票品类商品对应的时间价格
     */
	private List<SuppGoodsAddTimePrice> suppGoodsAddTimePriceList = null;
	
	

    public List<SuppGoodsAddTimePrice> getSuppGoodsAddTimePriceList() {
		return suppGoodsAddTimePriceList;
	}

	public void setSuppGoodsAddTimePriceList(
			List<SuppGoodsAddTimePrice> suppGoodsAddTimePriceList) {
		this.suppGoodsAddTimePriceList = suppGoodsAddTimePriceList;
	}

	/**
	 * 日最低价
	 */
	private Long dailyLowestPrice = 0L;
	
	private Long dailySellmentPrice = 0L;

	private int fitDays = 0;
	
	//是否免运费(Y-免)
	private String postFreeFlag;
	
	public String getSenisitiveFlag() {
		return senisitiveFlag;
	}

	public void setSenisitiveFlag(String senisitiveFlag) {
		this.senisitiveFlag = senisitiveFlag;
	}

	/**
	 * 门票{组合套餐}商品与销售渠道
	 */

	private List<DistDistributorGoods> distDistributorGoods;
	
	public String getPayTargetCn() {
		if(payTarget == null) {
			return "";
		}
		return PAYTARGET.getCnName(payTarget);
	}
	
	
	/* *
	 * -------------------------------------------- static enum ----------------------------------------------------
	 */

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}


	// 销售渠道
	public static enum EXPRESSTYPE {

		LVMAMA("驴妈妈-上海"),
		LVMAMA_BJ("驴妈妈-北京"),
		LVMAMA_CD("驴妈妈-成都"),
		LVMAMA_SY("驴妈妈-三亚"),
		LVMAMA_GZ("驴妈妈-广州"),
		SUPPLIER("供应商");

		private String cnName;

		public static String getCnName(String code) {
			for (EXPRESSTYPE item : EXPRESSTYPE.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		EXPRESSTYPE(String name) {
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
	
	
	// 通知类型
	public static enum NOTICETYPE {

		EMAIL("邮件"), SMS("普通短信"),QRCODE("二维码");

		private String cnName;

		public static String getCnName(String code) {
			for (NOTICETYPE item : NOTICETYPE.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		NOTICETYPE(String name) {
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
	
	// 商品类型
	public static enum GOODSTYPE {

		EXPRESSTYPE_DISPLAY("实体商品"), NOTICETYPE_DISPLAY("虚拟商品");

		private String cnName;

		public static String getCnName(String code) {
			for (GOODSTYPE item : GOODSTYPE.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		GOODSTYPE(String name) {
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
	
	// 商品价格类型
	public static enum PRICETYPE {

	SINGLE_PRICE("单个价格"), MULTIPLE_PRICE("多个价格");

			private String cnName;

			public static String getCnName(String code) {
				for (GOODSTYPE item : GOODSTYPE.values()) {
					if (item.getCode().equals(code)) {
						return item.getCnName();
					}
				}
				return code;
			}

			PRICETYPE(String name) {
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

	// 房态
	public static enum STOCKSTATUS {

		FULL("满房"), NORMAL("正常"), LESS("紧张");

		private String cnName;

		public static String getCnName(String code) {
			for (STOCKSTATUS item : STOCKSTATUS.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		STOCKSTATUS(String name) {
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
	
	// 币种
	public static enum CURRENCYTYPE {

		CNY("人民币"), USD("美元"), CHF("法郎"), MOP("澳门币"), HKD("港币"), JPY("日元"), KRW("韩元"), AUD("澳币"), THB("泰铢"), EUR("欧元"), GBP("英镑");

		private String cnName;

		public static String getCnName(String code) {
			for (CURRENCYTYPE item : CURRENCYTYPE.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		CURRENCYTYPE(String name) {
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

	// 支付对象
	public static enum PAYTARGET {

		PREPAID("预付（驴妈妈）"), PAY("现付（供应商）");

		private String cnName;

		public static String getCnName(String code) {
			for (PAYTARGET item : PAYTARGET.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		PAYTARGET(String name) {
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
	//广告位对应目的地
	public static enum AD_DEST{
		SH("上海"),
		NJ("江苏"),
		HZ("浙江"),
		AH("安徽"),
		SD("山东"),
		FJ("福建"),
		JX("江西"),
		GZ("广东"),
		GX("广西"),
		SY("海南"),
		BJ("北京"),
		TJ("天津"),
		HEB("河北"),
		SAX("山西"),
		NMG("内蒙古"),
		HB("湖北"),
		HN("河南"),
		HUN("湖南"),
		CD("四川"),
		CQ("重庆"),
		GUZ("贵州"),
		YN("云南"),
		XZ("西藏"),
		SX("陕西"),
		GS("甘肃"),
		XJ("新疆"),
		QH("青海"),
		NX("宁夏"),
		JL("吉林"),
		LN("辽宁"),
		HLJ("黑龙江"),
		XG("香港"),
		SZ("深圳"),
		AM("澳门");
		
		private String cnName;
		AD_DEST(String cnName) {
			this.cnName = cnName;
		}
		public static String getNameByCnName(String cnName){
			for (AD_DEST item : AD_DEST.values()) {
				if (item.getCnName().equals(cnName)) {
					return item.getCode();
				}
			}
			return cnName;
		}
		public String getCode() {
			return this.name();
		}
		public String getCnName() {
			return this.cnName;
		}
	}
	
	// 门票票种
	public static enum GOODSSPEC {
		ADULT("成人票[1大0小]","成人票",1,0),
		CHILDREN("儿童票[0大1小]","儿童票",0,1),
		PARENTAGE("亲子票[1大1小]","亲子票",1,1),
		FAMILY("家庭票[2大1小]","家庭票",2,1),
		LOVER("情侣票[2大0小]","情侣票",2,0),
		COUPE("双人票[2大0小]","双人票",2,0),
		OLDMAN("老人票[1大0小]","老人票",1,0),
		STUDENT("学生票[1大0小]","学生票",1,0),
		ACTIVITY("特殊人群票[1大0小]","特殊人群票",1,0),
		SOLDIER("军人票[1大0小]","军人票",1,0),
		//MAN("男士票[1大0小]","男士票",1,0),
		//WOMAN("女士票[1大0小]","女士票",1,0),
		TEACHER("教师票[1大0小]","教师票",1,0),
		DISABILITY("残疾票[1大0小]","残疾票",1,0),
		GROUP("团体票[1大0小]","团体票",1,0),
		FREE("相关票","相关票",0,0);
		
		
		private String cnName;
		private String specName;
		private int adult;
		private int child;

		public static String getCnName(String code) {
			for (GOODSSPEC item : GOODSSPEC.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		public static int getAdult(String code) {
			for (GOODSSPEC item : GOODSSPEC.values()) {
				if (item.getCode().equals(code)) {
					return item.getAdult();
				}
			}
			return 0;
		}
		
		public static int getChild(String code) {
			for (GOODSSPEC item : GOODSSPEC.values()) {
				if (item.getCode().equals(code)) {
					return item.getChild();
				}
			}
			return 0;
		}
		
		public static String getSpecName(String code) {
			for (GOODSSPEC item : GOODSSPEC.values()) {
				if (item.getCode().equals(code)) {
					return item.getSpecName();
				}
			}
			return code;
		}
		
		GOODSSPEC(String name, String specName, int adult, int child) {
			this.cnName = name;
			this.adult = adult;
			this.child = child;
			this.specName = specName; 
		}

		public String getCode() {
			return this.name();
		}

		public int getChild() {
			return this.child;
		}

		public int getAdult() {
			return this.adult;
		}
		
		public String getCnName() {
			return this.cnName;
		}
		
		public String getSpecName() {
			return this.specName;
		}
		
		@Override
		public String toString() {
			return this.name();
		}
	}
	
	
	//判断商品是否有效
	public  boolean isValid(){
		//判断商品是否有效
		if(!"Y".equalsIgnoreCase(getCancelFlag())){
			return Boolean.FALSE;
		}
		//判断产品是否有效
		if(getProdProduct()==null||!"Y".equalsIgnoreCase(getProdProduct().getCancelFlag())){
			return Boolean.FALSE;
		}
		//判断产品规格是否有效
		if(getProdProductBranch() == null || !"Y".equalsIgnoreCase(getProdProductBranch().getCancelFlag())){
			return Boolean.FALSE;
		}
		//判断品类是否有效
		if(getProdProduct().getBizCategory()==null || !"Y".equalsIgnoreCase(getProdProduct().getBizCategory().getCancelFlag())){
			return Boolean.FALSE;
		}
		//判断规格是否有效
		if(getProdProductBranch().getBizBranch() == null || !"Y".equalsIgnoreCase(getProdProductBranch().getBizBranch().getCancelFlag())){
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
	
	/**
	 * 对接接票儿童数量上下限
	 * 
	 * @author dengqianyong
	 *
	 */
	public static enum APIFLIGHTCHILDQUANTITY {
		CHILD_MIN_QUANTITY(0L),
		CHILD_MAX_QUANTITY(4L),
		;
		private Long quantity;
		
		private APIFLIGHTCHILDQUANTITY(Long quantity) {
			this.quantity = quantity;
		}

		public Long getQuantity() {
			return quantity;
		}
		
	}

	/* *
	 * -------------------------------------------- get and set property ----------------------------------------------------
	 */
	public String getContentManagerName() {
		return contentManagerName;
	}

	public void setContentManagerName(String contentManagerName) {
		this.contentManagerName = contentManagerName;
	}

	public Long getContentManagerId() {
		return contentManagerId;
	}

	public void setContentManagerId(Long contentManagerId) {
		this.contentManagerId = contentManagerId;
	}
	
	
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getApiFlag() {
		return apiFlag;
	}

	public void setApiFlag(String apiFlag) {
		this.apiFlag = apiFlag;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public BizBranch getBizBranch() {
		return bizBranch;
	}

	public void setBizBranch(BizBranch bizBranch) {
		this.bizBranch = bizBranch;
	}
	
	public Long getSuppGoodsId() {
		return suppGoodsId;
	}

	public void setSuppGoodsId(Long suppGoodsId) {
		this.suppGoodsId = suppGoodsId;
	}

	public SuppContract getSuppContract() {
		return suppContract;
	}

	public void setSuppContract(SuppContract suppContract) {
		this.suppContract = suppContract;
	}

	public SuppSupplier getSuppSupplier() {
		return suppSupplier;
	}

	public void setSuppSupplier(SuppSupplier suppSupplier) {
		this.suppSupplier = suppSupplier;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public String getPayTarget() {
		return payTarget;
	}

	public void setPayTarget(String payTarget) {
		this.payTarget = payTarget;
	}

	public String getPackageFlag() {
		return packageFlag;
	}

	public void setPackageFlag(String packageFlag) {
		this.packageFlag = packageFlag;
	}

	public String getFaxFlag() {
		return faxFlag;
	}

	public void setFaxFlag(String faxFlag) {
		this.faxFlag = faxFlag;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getExpressType() {
		return expressType;
	}

	public void setExpressType(String expressType) {
		this.expressType = expressType;
	}

	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}

	public Long getCertValidDay() {
		return certValidDay;
	}

	public void setCertValidDay(Long certValidDay) {
		this.certValidDay = certValidDay;
	}

	public Long getAdult() {
		return adult;
	}

	public void setAdult(Long adult) {
		this.adult = adult;
	}

	public Long getChild() {
		return child;
	}

	public void setChild(Long child) {
		this.child = child;
	}

	public String getCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	/**
	 * 是否可售（计算得出）
	 * 2013-12-30
	 * @return
	 */
	public String getOnlineFlag() {
		return onlineFlag;
	}

	public void setOnlineFlag(String onlineFlag) {
		this.onlineFlag = onlineFlag;
	}

	public String getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public ProdProduct getProdProduct() {
		return prodProduct;
	}

	public void setProdProduct(ProdProduct prodProduct) {
		this.prodProduct = prodProduct;
	}

	public ProdProductBranch getProdProductBranch() {
		return prodProductBranch;
	}

	public void setProdProductBranch(ProdProductBranch prodProductBranch) {
		this.prodProductBranch = prodProductBranch;
	}

	public String getLvmamaFlag() {
		return lvmamaFlag;
	}

	public void setLvmamaFlag(String lvmamaFlag) {
		this.lvmamaFlag = lvmamaFlag;
	}

	public String getDistributeFlag() {
		return distributeFlag;
	}

	public void setDistributeFlag(String distributeFlag) {
		this.distributeFlag = distributeFlag;
	}

	public SuppFaxRule getSuppFaxRule() {
		return suppFaxRule;
	}

	public void setSuppFaxRule(SuppFaxRule suppFaxRule) {
		this.suppFaxRule = suppFaxRule;
	}

	public String getFiliale() {
		return filiale;
	}

	public void setFiliale(String filiale) {
		this.filiale = filiale;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getProductBranchId() {
		return productBranchId;
	}

	public void setProductBranchId(Long productBranchId) {
		this.productBranchId = productBranchId;
	}

	public Long getFaxRuleId() {
		return faxRuleId;
	}

	public void setFaxRuleId(Long faxRuleId) {
		this.faxRuleId = faxRuleId;
	}

	
	
	public SuppGoodsRentedLimit getSuppGoodsRentedLimit() {
        return suppGoodsRentedLimit;
    }

    public void setSuppGoodsRentedLimit(SuppGoodsRentedLimit suppGoodsRentedLimit) {
        this.suppGoodsRentedLimit = suppGoodsRentedLimit;
    }

    /**
	 * @return the minStayDay
	 */
	public Long getMinStayDay() {
		return minStayDay;
	}

	/**
	 * @param minStayDay the minStayDay to set
	 */
	public void setMinStayDay(Long minStayDay) {
		this.minStayDay = minStayDay;
	}

	/**
	 * @return the maxStayDay
	 */
	public Long getMaxStayDay() {
		return maxStayDay;
	}

	/**
	 * @param maxStayDay the maxStayDay to set
	 */
	public void setMaxStayDay(Long maxStayDay) {
		this.maxStayDay = maxStayDay;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the minQuantity
	 */
	public Long getMinQuantity() {
		return minQuantity;
	}

	/**
	 * @param minQuantity the minQuantity to set
	 */
	public void setMinQuantity(Long minQuantity) {
		this.minQuantity = minQuantity;
	}

	/**
	 * @return the maxQuantity
	 */
	public Long getMaxQuantity() {
		return maxQuantity;
	}

	/**
	 * @param maxQuantity the maxQuantity to set
	 */
	public void setMaxQuantity(Long maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getHasTimePriceFlag() {
		return hasTimePriceFlag;
	}

	public void setHasTimePriceFlag(String hasTimePriceFlag) {
		this.hasTimePriceFlag = hasTimePriceFlag;
	}

	public String getXingBrigadeFlag() {
		return xingBrigadeFlag;
	}

	public void setXingBrigadeFlag(String xingBrigadeFlag) {
		this.xingBrigadeFlag = xingBrigadeFlag;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getGoodsSpec() {
		return goodsSpec;
	}

	public void setGoodsSpec(String goodsSpec) {
		this.goodsSpec = goodsSpec;
	}

	public String getAperiodicFlag() {
		return aperiodicFlag;
	}

	public void setAperiodicFlag(String aperiodicFlag) {
		this.aperiodicFlag = aperiodicFlag;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDistributorIds() {
		return distributorIds;
	}

	public void setDistributorIds(String distributorIds) {
		this.distributorIds = distributorIds;
	}

	public List<DistDistributorGoods> getDistDistributorGoods() {
		return distDistributorGoods;
	}

	public void setDistDistributorGoods(
			List<DistDistributorGoods> distDistributorGoods) {
		this.distDistributorGoods = distDistributorGoods;
	}
	
	/**
	 * 是否期票
	 * 
	 * @return
	 */
	public boolean hasAperiodic(){
		return "Y".equalsIgnoreCase(aperiodicFlag);
	}

	public SuppGoodsExp getSuppGoodsExp() {
		return suppGoodsExp;
	}

	public void setSuppGoodsExp(SuppGoodsExp suppGoodsExp) {
		this.suppGoodsExp = suppGoodsExp;
	}

    public SuppGoodsAddition getSuppGoodsAddition() {
        return suppGoodsAddition;
    }

    public void setSuppGoodsAddition(SuppGoodsAddition suppGoodsAddition) {
        this.suppGoodsAddition = suppGoodsAddition;
    }

	public Long getDailyLowestPrice() {
		return dailyLowestPrice;
	}

	public void setDailyLowestPrice(Long dailyLowestPrice) {
		this.dailyLowestPrice = dailyLowestPrice;
	}

	public List<SuppGoodsRelation> getSuppGoodsRelationList() {
		return suppGoodsRelationList;
	}

	public void setSuppGoodsRelationList(
			List<SuppGoodsRelation> suppGoodsRelationList) {
		this.suppGoodsRelationList = suppGoodsRelationList;
	}

	public String getStayDays() {
		return stayDays;
	}

	public void setStayDays(String stayDays) {
		this.stayDays = stayDays;
	}
	public SuppGoodsRelation getParentGoodsRelation() {
		return parentGoodsRelation;
	}

	public void setParentGoodsRelation(SuppGoodsRelation parentGoodsRelation) {
		this.parentGoodsRelation = parentGoodsRelation;
	}
    public SuppGoodsBaseTimePrice getSuppGoodsBaseTimePrice() {
		return suppGoodsBaseTimePrice;
	}

	public void setSuppGoodsBaseTimePrice(
			SuppGoodsBaseTimePrice suppGoodsBaseTimePrice) {
		this.suppGoodsBaseTimePrice = suppGoodsBaseTimePrice;
	}
	public Long getFitQuantity() {
		return fitQuantity;
	}

	public void setFitQuantity(Long fitQuantity) {
		this.fitQuantity = fitQuantity;
	}
	
	public Long getFitChildQuantity() {
		return fitChildQuantity;
	}

	public void setFitChildQuantity(Long fitChildQuantity) {
		this.fitChildQuantity = fitChildQuantity;
	}

	public Long getFitAdultQuantity() {
		return fitAdultQuantity;
	}

	public void setFitAdultQuantity(Long fitAdultQuantity) {
		this.fitAdultQuantity = fitAdultQuantity;
	}
	
	public String getDailyLowestPriceYuan(){
		if(this.dailyLowestPrice==null){
			this.dailyLowestPrice=0L;
		}
		return PriceUtil.trans2YuanStr(this.dailyLowestPrice);		
	}
	
	public Long getGapPrice() {
		return gapPrice;
	}

	public void setGapPrice(Long gapPrice) {
		this.gapPrice = gapPrice;
	}
	
	public Long getDailySellmentPrice() {
		return dailySellmentPrice;
	}

	public void setDailySellmentPrice(Long dailySellmentPrice) {
		this.dailySellmentPrice = dailySellmentPrice;
	}
	
	public Class<?> getTimePriceModel(Long categoryId, String aperiodicFlag) {
		return getTimePriceModel(categoryId, aperiodicFlag, "N");
	}

    public Long getSoaSuppGoodsId() {
        return soaSuppGoodsId;
    }

    public void setSoaSuppGoodsId(Long soaSuppGoodsId) {
        this.soaSuppGoodsId = soaSuppGoodsId;
    }
    
	/**
	 * <br/> 1酒店            2邮轮            3保险             4签证            5门票
	 * <br/> 6组合产品      7附加项目      8邮轮组合产品 9岸上观光
	 * <br/> 10邮轮附加项 11景区门票    12其它票        13组合套餐票
	 * <br/> 14线路          15跟团游       16当地游        17酒店套餐
	 * <br/> 18自由行       19大交通       20机票           21其它机票
	 * <br/> 22火车票       23其它火车票 24巴士           25其它巴士
	 * <br/> 26船票          27其它船票    90其它
	 * 
	 * 2014年8月28日
	 * @param categoryId
	 * @param aperiodicFlag 只有门票(5,11,12,13)时需要这个是否期票
	 * @param apiFlag 对接标识
	 * @return 参考用
	 */
	public Class<?> getTimePriceModel(Long categoryId, String aperiodicFlag, String apiFlag) {
		if(categoryId==null) {
			return null;
		}
		switch(categoryId.intValue()) {
		case 1: return SuppGoodsTimePrice.class;
		case 2: return SuppGoodsMultiTimePrice.class;
		case 90:
		case 3: return SuppGoodsNotimeTimePrice.class;
		case 4: return SuppGoodsSimpleTimePrice.class;
		case 5: return null;
		case 6: return null;
		case 7: return null;
		case 8: return null;
		case 9:
		case 10: return SuppGoodsSingleTimePrice.class;
		case 11:
		case 12:
		case 13: {
			if("N".equals(aperiodicFlag))return SuppGoodsAddTimePrice.class;
			if("Y".equals(aperiodicFlag))return SuppGoodsNotimeTimePrice.class;
		}
		case 14:return null;
		case 15:
		case 16:
		case 17:
		case 18:
		case 19:
		case 20:
		case 22:
		case 23:
		case 24:
		case 25:
		case 26:
		case 27:return SuppGoodsLineTimePrice.class;
		case 28:return SuppGoodsAddTimePrice.class;
		case 21:return "Y".equals(apiFlag) ? SuppGoodsFApiTimePrice.class : SuppGoodsLineTimePrice.class;
		default:;
		}
		return null;
	}
	
	/**
	 * 跟换品类Id和是否为期票获取时间价格表名
	 * @param categoryId
	 * @param aperiodicFlag
	 * @return
	 */
	public String getGoodsTimePriceTableName(Long categoryId, String aperiodicFlag){
		if(categoryId==null) {
			return null;
		}
		switch(categoryId.intValue()) {
		case 1: return "supp_goods_time_price";
		case 2: return "supp_goods_multi_time_price";
		case 90:
		case 3: return "supp_goods_notime_time_price";
		case 4: return "supp_goods_simple_time_price";
		case 5: return null;
		case 6: return null;
		case 7: return null;
		case 8: return null;
		case 9:
		case 10:return "supp_goods_single_time_price";
		case 11:
		case 12:
		case 13: {
			if("N".equals(aperiodicFlag))return "supp_goods_add_time_price";
			if("Y".equals(aperiodicFlag))return "supp_goods_notime_time_price";
		}
		case 14:return null;
		case 15:
		case 16:
		case 17:
		case 18:
		case 19:
		case 20:
		case 22:
		case 23:
		case 24:
		case 25:
		case 26:
		case 27:return "supp_goods_line_time_price";
		case 21:return "supp_goods_f_api_time_price";
		default:;
		}
		return null;
	}

	public String getPostFreeFlag() {
		return postFreeFlag;
	}

	public void setPostFreeFlag(String postFreeFlag) {
		this.postFreeFlag = postFreeFlag;
	}

	public String getStockApiFlag() {
		return stockApiFlag;
	}

	public void setStockApiFlag(String stockApiFlag) {
		this.stockApiFlag = stockApiFlag;
	}

	public String getEbkFlag() {
		return ebkFlag;
	}

	public void setEbkFlag(String ebkFlag) {
		this.ebkFlag = ebkFlag;
	}
	
	public String getNotInTimeFlag() {
        return notInTimeFlag;
    }

    public void setNotInTimeFlag(String notInTimeFlag) {
        this.notInTimeFlag = notInTimeFlag;
    }

	public Long getChildPrice() {
		return childPrice;
	}

	public void setChildPrice(Long childPrice) {
		this.childPrice = childPrice;
	}

	public Long getChildSellmentPrice() {
		return childSellmentPrice;
	}

	public void setChildSellmentPrice(Long childSellmentPrice) {
		this.childSellmentPrice = childSellmentPrice;
	}

	public Long getAdultPrice() {
		return adultPrice;
	}

	public void setAdultPrice(Long adultPrice) {
		this.adultPrice = adultPrice;
	}

	public Long getAdultSellmentPrice() {
		return adultSellmentPrice;
	}

	public void setAdultSellmentPrice(Long adultSellmentPrice) {
		this.adultSellmentPrice = adultSellmentPrice;
	}

	public Long getGapSellmentPrice() {
		return gapSellmentPrice;
	}

	public void setGapSellmentPrice(Long gapSellmentPrice) {
		this.gapSellmentPrice = gapSellmentPrice;
	}

	public List<SuppGoodsBaseTimePrice> getSuppGoodsBaseTimePriceList() {
		return suppGoodsBaseTimePriceList;
	}

	public void setSuppGoodsBaseTimePriceList(
			List<SuppGoodsBaseTimePrice> suppGoodsBaseTimePriceList) {
		this.suppGoodsBaseTimePriceList = suppGoodsBaseTimePriceList;
	}
	
	public List<SuppGoodsLineTimePriceVo> getSuppGoodsLineTimePriceVo() {
		return suppGoodsLineTimePriceVo;
	}

	public void setSuppGoodsLineTimePriceVo(
			List<SuppGoodsLineTimePriceVo> suppGoodsLineTimePriceVo) {
		this.suppGoodsLineTimePriceVo = suppGoodsLineTimePriceVo;
	}

	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	public Map<String, Long> getSelectPriceMap() {
		return selectPriceMap;
	}

	public void setSelectPriceMap(Map<String, Long> selectPriceMap) {
		this.selectPriceMap = selectPriceMap;
	}
	
	public Map<String, SuppGoodsLineTimePriceVo> getGoodsLocalSelectPriceMap() {
		return goodsLocalSelectPriceMap;
	}

	public void setGoodsLocalSelectPriceMap(
			Map<String, SuppGoodsLineTimePriceVo> goodsLocalSelectPriceMap) {
		this.goodsLocalSelectPriceMap = goodsLocalSelectPriceMap;
	}

	public Long getLimitBookDay() {
		return limitBookDay;
	}

	public void setLimitBookDay(Long limitBookDay) {
		this.limitBookDay = limitBookDay;
	}

	public String getSelectQuantityRange() {
		return selectQuantityRange;
	}

	public void setSelectQuantityRange(String selectQuantityRange) {
		this.selectQuantityRange = selectQuantityRange;
	}

	public String getSelectAdultQuantityRange() {
		return selectAdultQuantityRange;
	}

	public void setSelectAdultQuantityRange(String selectAdultQuantityRange) {
		this.selectAdultQuantityRange = selectAdultQuantityRange;
	}

	public String getSelectChildQuantityRange() {
		return selectChildQuantityRange;
	}

	public void setSelectChildQuantityRange(String selectChildQuantityRange) {
		this.selectChildQuantityRange = selectChildQuantityRange;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public Map<String, Long> getSelectGapPriceMap() {
		return selectGapPriceMap;
	}

	public void setSelectGapPriceMap(Map<String, Long> selectGapPriceMap) {
		this.selectGapPriceMap = selectGapPriceMap;
	}

	public int getFitDays() {
		return fitDays;
	}

	public void setFitDays(int fitDays) {
		this.fitDays = fitDays;
	}

	public String getBu() {
		return bu;
	}

	public void setBu(String bu) {
		this.bu = bu;
	}

	public Long getAttributionId() {
		return attributionId;
	}

	public void setAttributionId(Long attributionId) {
		this.attributionId = attributionId;
	}

	public String getAttributionName() {
		return attributionName;
	}

	public void setAttributionName(String attributionName) {
		this.attributionName = attributionName;
	}

	public String getSelectGapQuantityRange() {
		return selectGapQuantityRange;
	}

	public void setSelectGapQuantityRange(String selectGapQuantityRange) {
		this.selectGapQuantityRange = selectGapQuantityRange;
	}

	public String getGoodsSpecName() {return goodsSpecName;}

	public void setGoodsSpecName(String goodsSpecName) {
		this.goodsSpecName = goodsSpecName;
	}
	
	public SuppGoodsDesc getSuppGoodsDesc() {
		return suppGoodsDesc;
	}

	public void setSuppGoodsDesc(SuppGoodsDesc suppGoodsDesc) {
		this.suppGoodsDesc = suppGoodsDesc;
	}

	@Override
	public String toString() {
		return "SuppGoods [suppGoodsId=" + suppGoodsId + ", contractId="
				+ contractId + ", supplierId=" + supplierId + ", productId="
				+ productId + ", groupId=" + groupId + ", groupName="
				+ groupName + ", productBranchId=" + productBranchId
				+ ", faxRuleId=" + faxRuleId + ", suppContract=" + suppContract
				+ ", suppSupplier=" + suppSupplier + ", prodProduct="
				+ prodProduct + ", prodProductBranch=" + prodProductBranch
				+ ", bizBranch=" + bizBranch + ", goodsName=" + goodsName
				+ ", payTarget=" + payTarget + ", packageFlag=" + packageFlag
				+ ", faxFlag=" + faxFlag + ", goodsType=" + goodsType
				+ ", managerId=" + managerId + ", expressType=" + expressType
				+ ", noticeType=" + noticeType + ", certValidDay="
				+ certValidDay + ", adult=" + adult + ", child=" + child
				+ ", senisitiveFlag=" + senisitiveFlag + ", cancelFlag="
				+ cancelFlag + ", onlineFlag=" + onlineFlag + ", goodsDesc="
				+ goodsDesc + ", lvmamaFlag=" + lvmamaFlag
				+ ", distributeFlag=" + distributeFlag + ", filiale=" + filiale
				+ ", minStayDay=" + minStayDay + ", maxStayDay=" + maxStayDay
				+ ", minQuantity=" + minQuantity + ", maxQuantity="
				+ maxQuantity + ", suppFaxRule=" + suppFaxRule
				+ ", managerName=" + managerName + ", branchName=" + branchName
				+ ", contentManagerId=" + contentManagerId
				+ ", contentManagerName=" + contentManagerName + ", orgId="
				+ orgId + ", hasTimePriceFlag=" + hasTimePriceFlag
				+ ", currencyType=" + currencyType + ", priceType=" + priceType
				+ ", createTime=" + createTime + ", createUser=" + createUser
				+ ", updateTime=" + updateTime + ", updateUser=" + updateUser
				+ ", goodsSpec=" + goodsSpec + ", aperiodicFlag="
				+ aperiodicFlag + ", seq=" + seq + ", xingBrigadeFlag="
				+ xingBrigadeFlag + ", distributorIds=" + distributorIds
				+ ", suppGoodsExp=" + suppGoodsExp + ", suppGoodsAddition="
				+ suppGoodsAddition + ", stayDays=" + stayDays
				+ ", parentGoodsRelation=" + parentGoodsRelation
				+ ", categoryId=" + categoryId + ", apiFlag=" + apiFlag
				+ ", stockApiFlag=" + stockApiFlag + ", ebkFlag=" + ebkFlag
				+ ", branchId=" + branchId + ", suppGoodsRelationList="
				+ suppGoodsRelationList + ", fitChildQuantity="
				+ fitChildQuantity + ", fitAdultQuantity=" + fitAdultQuantity
				+ ", fitQuantity=" + fitQuantity + ", selectPriceMap="
				+ selectPriceMap + ", selectGapPriceMap=" + selectGapPriceMap
				+ ", selectQuantityRange=" + selectQuantityRange
				+ ", selectGapQuantityRange=" + selectGapQuantityRange
				+ ", gapPrice=" + gapPrice + ", childPrice=" + childPrice
				+ ", childSellmentPrice=" + childSellmentPrice
				+ ", adultPrice=" + adultPrice + ", adultSellmentPrice="
				+ adultSellmentPrice + ", gapSellmentPrice=" + gapSellmentPrice
				+ ", stock=" + stock + ", limitBookDay=" + limitBookDay
				+ ", relationType=" + relationType
				+ ", suppGoodsBaseTimePrice=" + suppGoodsBaseTimePrice
				+ ", suppGoodsBaseTimePriceList=" + suppGoodsBaseTimePriceList
				+ ", goodsReFundList=" + goodsReFundList
				+ ", dailyLowestPrice=" + dailyLowestPrice
				+ ", dailySellmentPrice=" + dailySellmentPrice + ", fitDays="
				+ fitDays + ", postFreeFlag=" + postFreeFlag
				+ ", distDistributorGoods=" + distDistributorGoods 
				+ ",distributorUserIds=" + distributorUserIds + "]";
	}

	public BizCategory getBizCategory() {
		return bizCategory;
	}

	public void setBizCategory(BizCategory bizCategory) {
		this.bizCategory = bizCategory;
	}
	
	public String getFaxRemark() {
		return faxRemark;
	}

	public void setFaxRemark(String faxRemark) {
		this.faxRemark = faxRemark;
	}


    public String getBuyoutFlag() {
        return buyoutFlag;
    }

    public void setBuyoutFlag(String buyoutFlag) {
        this.buyoutFlag = buyoutFlag;
    }


    public int getAperiodicTypeId() {
        return aperiodicTypeId;
    }

    public void setAperiodicTypeId(int aperiodicTypeId) {
        this.aperiodicTypeId = aperiodicTypeId;
    }
//add by xiaorui.mu begin
	public Long getRegionalLeaderId() {
		return regionalLeaderId;
	}

	public void setRegionalLeaderId(Long regionalLeaderId) {
		this.regionalLeaderId = regionalLeaderId;
	}

	public String getRegionalLeaderName() {
		return regionalLeaderName;
	}

	public void setRegionalLeaderName(String regionalLeaderName) {
		this.regionalLeaderName = regionalLeaderName;
	}

	public Long getCommercialStaffId() {
		return commercialStaffId;
	}

	public void setCommercialStaffId(Long commercialStaffId) {
		this.commercialStaffId = commercialStaffId;
	}

	public String getCommercialStaffName() {
		return commercialStaffName;
	}

	public void setCommercialStaffName(String commercialStaffName) {
		this.commercialStaffName = commercialStaffName;
	}
	//add by xiaorui.mu end
}
