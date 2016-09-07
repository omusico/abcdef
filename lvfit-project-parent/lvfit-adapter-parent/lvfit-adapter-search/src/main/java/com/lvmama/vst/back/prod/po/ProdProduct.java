package com.lvmama.vst.back.prod.po;

import static com.lvmama.vst.back.prod.po.ProdProductAddtional.SALETYPE.COPIES_COMB_HOTEL;
import static com.lvmama.vst.back.prod.po.ProdProductAddtional.SALETYPE.COPIES_OTHER;
import static com.lvmama.vst.back.prod.po.ProdProductAddtional.SALETYPE.PEOPLE;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import com.lvmama.vst.back.biz.po.BizCategory;
import com.lvmama.vst.back.biz.po.BizDistrict;
import com.lvmama.vst.back.dist.po.DistDistributorProd;
import com.lvmama.vst.back.dujia.comm.prod.po.ProdLineBasicInfo;
import com.lvmama.vst.back.dujia.group.prod.vo.ProdProductNameVO;
import com.lvmama.vst.back.goods.po.SuppGoods;
import com.lvmama.vst.back.goods.po.SuppGoodsSaleRe;
import com.lvmama.vst.back.line.po.LineRoute;
import com.lvmama.vst.back.line.po.LineShipDetail;
import com.lvmama.vst.back.prod.vo.ProdLineRouteVO;
import com.lvmama.vst.back.prod.vo.ProdTrafficVO;
import com.lvmama.vst.back.pub.po.ComOrderRequired;
import com.lvmama.vst.back.pub.po.ComPhoto;
import com.lvmama.vst.back.supp.po.SuppSupplier;
import com.lvmama.vst.comm.enumeration.CommEnumSet;
import com.lvmama.vst.comm.utils.StringUtil;
import com.lvmama.vst.comm.vo.Constant;
import com.lvmama.vst.comm.vo.Constant.VST_CATEGORY;

public class ProdProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final double MODEL_VERSION_1D0 = 1.0;

	private Long productId;
	private Long attributionId;
	private String attributionName;

	private String productName;

	private String cancelFlag;

	private String saleFlag;

	private Long recommendLevel;
	
	private Long bizCategoryId;
	
	private Long subCategoryId;//子品类ID
	
	private Long bizDistrictId;
	
	private String imageUrl;
	
	private String senisitiveFlag;
	
	// 电子合同范本
	private ProdEcontract prodEcontract;

	// 产品经理ID
	private Long managerId;

	private String urlId;

	private String filiale;
	
	private String bu;
	//数据源ebk或者vst	
	private String source;
	
	//vo 使用
	private String managerName;
	
	// 出发地(行政区域)
	private String districtName;
	
	// 打包类型
	private String packageType;

	//是否仅组合销售
	private String packageFlag;
	
	//线路类别
	private String productType;
	//线路类别(vo使用)
	private String productTypeName;
	
	/**
	 * 多行程
	 */
	private List<ProdLineRouteVO> prodLineRouteList;
	
	//下单必填项
	private ComOrderRequired comOrderRequired;
	
	//销售渠道
	private String distributorIds;
	
	// 销售渠道集合
	private String[] disIds;
	
	private ProdDestRe prodDestRe;
	
	//景点图片
	private List<ComPhoto> comPhotoList;
	
	//景点活动
	private List<ProdActivity> activityList;
	
	//景点特色
	private List<ProdFeature> featureList;
	
	//游玩景点
	private List<ProdViewSpot> viewSpotList;
	
	//服务保障
	private List<ProdServiceRe> serviceReList;

	//产品附加信息
	private ProdProductAddtional productAddtional;
	
	private Date createTime;
	
	private String createUser;
	
	private Date updateTime;
	
	private String updateUser;
	
	private String auditStatus;
	
	private String currentAuditStatus;
	
    private SuppSupplier suppSupplier;

    private SuppGoods suppGoods;
    
    /** 售卖方式 */
    private List<ProdProductSaleRe> prodProductSaleReList;

    private String abandonFlag;//废弃标识
    
    private String categoryCombTicket;
    public String getAbandonFlag() {
		return abandonFlag;
	}

	public void setAbandonFlag(String abandonFlag) {
		this.abandonFlag = abandonFlag;
	}

	/**
     * 存储预览的url路径
     */
    private String url;

    /**
     * 多出发地标志，'N'非多出发地，'Y'多出发地
     */
    private String muiltDpartureFlag; 

    /**
     * 版本标记，存储1.0、2.0 ......
     */
    private Double modelVersion;

    /**
     * 线路产品基础信息
     */
    private ProdLineBasicInfo prodLineBasicInfo;

    /**
     * 跟团游产品名称对象
     */
    private ProdProductNameVO prodProductNameVO;

    /**
	 * 产品权限
	 */
	private String managerIdPerm;
	
   
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
     * 产录入源
     * 
     * 
     * 
     */
    public static enum PRODUCTSOURCE {

		EBK,BACK;
		}

    
    
    
    /**
     * 推荐商品
     */
    private List<SuppGoods> recommendSuppGoodsList;
    
    // 交通详情
    private ProdTrafficVO prodTrafficVO;
    
    // 产品签证材料关联
//    private List<ProdVisadocRe> prodVisaDocRes;
    
  //交通信息
    private ProdTraffic prodTraffic ;
    
    //供应商产品名称
    private String suppProductName;
    
    /**
     * 参数类型（成人数、儿童数或者套餐份数）
     * =Y 成人数、儿童数 默认值
     * =N 套餐份数
     */
    
    private String hotelCombFlag = "Y";
    
    /**
     * 关联销售
     */
    private List<SuppGoodsSaleRe> suppGoodsSaleReList;
    
    /**
     * 存放供应商打包下的可换组列表
     */
    private List<ProdPackageGroup> prodPackgeGroupList;
    
    private Long dailyLowestPrice;
    
    //后台下单和前台详情页面使用
    //商品上成人数
    private Long baseAdultQuantity = 0L;
    //商品上儿童数
    private Long baseChildQuantity = 0L;
    /**
     * 出发地
     */
    private String district;
    /**
     * 目的地
     */
    private String[] dest;
    
	/**
	 * 产品与主题关联
	 */
	private List<ProdSubject> prodSubjectList;

	/**
	 * 二维码图片
	 */
	private String urlQR;
	/**
	 * 是否开心驴行 Y/N
	 */
	private String isKaixinlvxing;
	
	/**
	 * 公司主体
	 */
	private String companyType;
	
	/**
	 * 与产品关联的其他产品的列表
	 */
    private List<ProdGroup> prodGroupList;
    
    public String getCategoryCombTicket() {
		return categoryCombTicket;
	}

	public void setCategoryCombTicket(String categoryCombTicket) {
		this.categoryCombTicket = categoryCombTicket;
	}

	public List<ProdGroup> getProdGroupList() {
		return prodGroupList;
	}

	public void setProdGroupList(List<ProdGroup> prodGroupList) {
		this.prodGroupList = prodGroupList;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String[] getDest() {
        return dest;
    }

    public void setDest(String[] dest) {
        this.dest = dest;
    }

    public ProdTraffic getProdTraffic() {
		return prodTraffic;
	}

	public void setProdTraffic(ProdTraffic prodTraffic) {
		this.prodTraffic = prodTraffic;
	}
    
   /* public List<ProdVisadocRe> getProdVisaDocRes() {
		return prodVisaDocRes;
	}

	public void setProdVisaDocRes(List<ProdVisadocRe> prodVisaDocRes) {
		this.prodVisaDocRes = prodVisaDocRes;
	}*/

	public ProdTrafficVO getProdTrafficVO() {
		return prodTrafficVO;
	}

	public void setProdTrafficVO(ProdTrafficVO prodTrafficVO) {
		this.prodTrafficVO = prodTrafficVO;
	}

	public SuppGoods getSuppGoods() {
		return suppGoods;
	}

	public void setSuppGoods(SuppGoods suppGoods) {
		this.suppGoods = suppGoods;
	}

    public SuppSupplier getSuppSupplier() {
		return suppSupplier;
	}

	public void setSuppSupplier(SuppSupplier suppSupplier) {
		this.suppSupplier = suppSupplier;
	}
	
	public String getSenisitiveFlag() {
		return senisitiveFlag;
	}

	public void setSenisitiveFlag(String senisitiveFlag) {
		this.senisitiveFlag = senisitiveFlag;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getCurrentAuditStatus() {
		return currentAuditStatus;
	}

	public void setCurrentAuditStatus(String currentAuditStatus) {
		this.currentAuditStatus = currentAuditStatus;
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

	public Map<String, String> getProdProductPropMap() {
		return prodProductPropMap;
	}

	public void setProdProductPropMap(Map<String, String> prodProductPropMap) {
		this.prodProductPropMap = prodProductPropMap;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * 产品所有的属性,值
	 * 如果是文本内容，则：key=编码CODE,value=属性内容
	 * <br>如果是字典，则：key=编码CODE,value=<code>List<com.lvmama.vst.back.prod.po.PropValue></code>
	 * <br>PropValue中，id=字典值,name=字典名,addValue=附加说明
	 */
	private Map<String, Object> propValue;
	
	private BizCategory bizCategory;
	
	private BizCategory subCategory;//子品类
	
	//产品所有属性,值(保存字典ID，不是字典值)
	private List<ProdProductProp> prodProductPropList;
	//所有属性值(包含分解的字典值)
	private Map<String, String> prodProductPropMap;

	private BizDistrict bizDistrict;
	
	private List<BizDistrict> bizDistricts;
	
	//产品规格列表
	private List<ProdProductBranch> prodProductBranchList;
	
	//产品缓存时间
	public static int PRODUCT_MEMCACHED_TIME_OUT = 8*60*60;
	
	/**
	 * 行程设计列表
	 */
	private List<LineRoute> lineRoutes;
	
	/**
	 * 航线设计
	 */
	private List<LineShipDetail> lineShipDetails;
	
	/**
	 * 产品目的地关联表
	 */
	private List<ProdDestRe> prodDestReList;
	
	/**
	 * 线路-门票{组合套餐}产品与销售渠道
	 */
	
	private List<DistDistributorProd> distDistributorProds;
	
	public List<ProdSubject> getProdSubjectList() {
		return prodSubjectList;
	}

	public void setProdSubjectList(List<ProdSubject> prodSubjectList) {
		this.prodSubjectList = prodSubjectList;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName == null ? null : productName.trim();
	}

	public String getCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag == null ? null : cancelFlag.trim();
	}

	public Long getRecommendLevel() {
		return recommendLevel;
	}

	public void setRecommendLevel(Long recommendLevel) {
		this.recommendLevel = recommendLevel;
	}

	public String getSaleFlag() {
		return saleFlag;
	}

	public void setSaleFlag(String saleFlag) {
		this.saleFlag = saleFlag;
	}

	public BizCategory getBizCategory() {
		return bizCategory;
	}

	public void setBizCategory(BizCategory bizCategory) {
		this.bizCategory = bizCategory;
	}
	
	

	public BizCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(BizCategory subCategory) {
		this.subCategory = subCategory;
	}

	public List<ProdProductProp> getProdProductPropList() {
		return prodProductPropList;
	}

	public void setProdProductPropList(List<ProdProductProp> prodProductPropList) {

		this.prodProductPropList = prodProductPropList;
	}

	public String getPackageFlag() {
		return packageFlag;
	}

	public void setPackageFlag(String packageFlag) {
		this.packageFlag = packageFlag;
	}

	public BizDistrict getBizDistrict() {
		return bizDistrict;
	}

	public void setBizDistrict(BizDistrict bizDistrict) {
		this.bizDistrict = bizDistrict;
	}

	public String getProp(String key) {
		if (MapUtils.isEmpty(prodProductPropMap) && CollectionUtils.isNotEmpty(prodProductPropList)) {
			prodProductPropMap = new HashMap<String, String>();
			for (ProdProductProp prop : prodProductPropList) {
				if(prop == null) {
					continue;
				}
				if(prop.getBizCategoryProp() == null){
					continue;
				}
				prodProductPropMap.put(prop.getBizCategoryProp().getPropCode(), prop.getPropValue());
			}
		}
		return prodProductPropMap.get(key);
	}
	
	public String getAddValue(String key) {
		if (MapUtils.isEmpty(prodProductPropMap) && CollectionUtils.isNotEmpty(prodProductPropList)) {
			prodProductPropMap = new HashMap<String, String>();
			for (ProdProductProp prop : prodProductPropList) {
				prodProductPropMap.put(prop.getBizCategoryProp().getPropCode(), prop.getAddValue());
			}
		}
		return prodProductPropMap.get(key);
	}

	public Long getBizCategoryId() {
		return bizCategoryId;
	}

	public void setBizCategoryId(Long bizCategoryId) {
		this.bizCategoryId = bizCategoryId;
	}
	
	
	public Long getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(Long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public Long getBizDistrictId() {
		return bizDistrictId;
	}

	public void setBizDistrictId(Long bizDistrictId) {
		this.bizDistrictId = bizDistrictId;
	}

	/**
	 * @return the propValue
	 */
	public Map<String, Object> getPropValue() {
		return propValue;
	}

	/**
	 * @param propValue the propValue to set
	 */
	public void setPropValue(Map<String, Object> propValue) {
		this.propValue = propValue;
	}

	public List<ProdProductBranch> getProdProductBranchList() {
		return prodProductBranchList;
	}

	public void setProdProductBranchList(List<ProdProductBranch> prodProductBranchList) {
		this.prodProductBranchList = prodProductBranchList;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	/**
	 */
	public String getUrlId() {
		return urlId;
	}

	/**
	 */
	public void setUrlId(String urlId) {
		this.urlId = urlId;
	}
	
	public String getFiliale() {
		return filiale;
	}

	public void setFiliale(String filiale) {
		this.filiale = filiale;
	}

	public String getBu() {
		return bu;
	}

	public void setBu(String bu) {
		this.bu = bu;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public ProdEcontract getProdEcontract() {
		return prodEcontract;
	}

	public void setProdEcontract(ProdEcontract prodEcontract) {
		this.prodEcontract = prodEcontract;
	}
	
	public List<LineRoute> getLineRoutes() {
		return lineRoutes;
	}

	public void setLineRoutes(List<LineRoute> lineRoutes) {
		this.lineRoutes = lineRoutes;
	}
	
	public List<LineShipDetail> getLineShipDetails() {
		return lineShipDetails;
	}

	public void setLineShipDetails(List<LineShipDetail> lineShipDetails) {
		this.lineShipDetails = lineShipDetails;
	}

	public String toString() {
		return "ProdProduct [productId=" + productId + ", productName="
				+ productName + ", cancelFlag=" + cancelFlag + ", saleFlag="
				+ saleFlag + ", recommendLevel=" + recommendLevel
				+ ", bizCategoryId=" + bizCategoryId + ", bizDistrictId="
				+ bizDistrictId + ", imageUrl=" + imageUrl  + ", managerId=" + managerId + ", filiale="
				+ filiale + ", managerName=" + managerName + "]";
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	
	// 打包类型
	public static enum PACKAGETYPE {

		LVMAMA("自主打包"),SUPPLIER("供应商打包");

		private String cnName;

		public static String getCnName(String code) {
			for (PACKAGETYPE item : PACKAGETYPE.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}

		PACKAGETYPE(String name) {
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
	/**
	 * 是否是需要审核的品类
	 * 
	 * 2014年8月28日
	 * @return
	 */
	public boolean isHasAuditCategory(){
		if(this.bizCategoryId == null) {
			return false;
		}
		// 15跟团游 16 当地游 18自由行
		if(this.bizCategoryId.equals(15L) || this.bizCategoryId.equals(16L) || this.bizCategoryId.equals(17L)|| this.bizCategoryId.equals(18L)) {
			return true;
		}
		// 11景区门票 12其它票 13组合套餐票
		if(this.bizCategoryId.equals(11L) || this.bizCategoryId.equals(12L) || this.bizCategoryId.equals(13L) ) {
			return true;
		}
		
		// 8 游轮组合产品
		if(this.bizCategoryId.equals(Long.parseLong(Constant.VST_CATEGORY.CATEGORY_COMB_CRUISE.getCategoryId()))) {
			return true;
		}
		//28WIFI产品
		if(this.bizCategoryId.equals(28L)){
			return true;
		}
		
		return false;
	}
	// 打包类型
	public static enum AUDITTYPE {
		
		AUDITTYPE_NO_SUBMIT("待提交"),
		AUDITTYPE_TO_PM("待产品经理审核"),
		AUDITTYPE_BACK_PM("产品经理退回,待提交"),
		AUDITTYPE_TO_QA("待QA审核"),
		AUDITTYPE_BACK_QA("QA退回，待提交"),
		AUDITTYPE_TO_BUSINESS("待商务审核"),
		AUDITTYPE_BACK_BUSINESS("商务退回，待提交"),
		AUDITTYPE_PASS("审核通过");

		private String cnName;

		public static String getCnName(String code) {
			for (AUDITTYPE item : AUDITTYPE.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}
		
		/**
		 * 获得下一个审核状态
		 * @param auditType
		 * @return
		 */
		public static AUDITTYPE getNextAuditType(AUDITTYPE auditType,String isPass,String isCancel,String source){
			if(auditType==null)
				return null;
			
			AUDITTYPE nextAuditType = null;
			//撤销审核
			if(StringUtils.isNotBlank(isPass)&&isPass.equals("N")&&isCancel.equals("Y")){
				//撤销回退节点
				switch(auditType) {
				case AUDITTYPE_TO_QA:
				{
					nextAuditType = AUDITTYPE_TO_PM;
				};
				break;
				case AUDITTYPE_TO_BUSINESS:{
					nextAuditType = AUDITTYPE_TO_PM;
				};
				break;
				}
				if(auditType.equals(AUDITTYPE_TO_PM)||auditType.equals(AUDITTYPE_TO_QA) || auditType.equals(AUDITTYPE_TO_BUSINESS)){
					
				if(auditType.equals(AUDITTYPE_TO_PM)){
					
					if("BACK".equalsIgnoreCase(source)){
						return  ProdProduct.AUDITTYPE.AUDITTYPE_TO_PM;
					}else {
						return ProdProduct.AUDITTYPE.AUDITTYPE_NO_SUBMIT;
					}
				}else{
					
					//QA和商务审核撤销时统一到产品经理节点
					return nextAuditType;
				}
				}
			}
			
			//QA审核不通过
			if(auditType.equals(AUDITTYPE.AUDITTYPE_TO_QA) && StringUtils.isNotBlank(isPass)&&isPass.equals("N")){
				return AUDITTYPE.AUDITTYPE_BACK_QA;
			}
			
			//商务审核不通过
			if(auditType.equals(AUDITTYPE.AUDITTYPE_TO_BUSINESS) && StringUtils.isNotBlank(isPass)&&isPass.equals("N")){
				return AUDITTYPE.AUDITTYPE_BACK_BUSINESS;
			}
			//产品经理审核不通过，退回
			if(auditType.equals(AUDITTYPE.AUDITTYPE_TO_PM) && StringUtils.isNotBlank(isPass)&&isPass.equals("N")){
				
				return AUDITTYPE.AUDITTYPE_BACK_PM;
			}
			
			
			
			//审核通过
			switch(auditType){
			//待提交
			 case  AUDITTYPE_NO_SUBMIT : {
				 
				 nextAuditType = AUDITTYPE.AUDITTYPE_TO_PM;
			 };
			 break;
			 case  AUDITTYPE_TO_PM : {
					 
				 nextAuditType = AUDITTYPE.AUDITTYPE_TO_QA;
			 };
			 break;
			 //产品经理打回，待提交
			 case  AUDITTYPE_BACK_PM : {
				 nextAuditType = AUDITTYPE.AUDITTYPE_TO_PM;
			 };
			 break;
			 
			 //待QA审核
			 case  AUDITTYPE_TO_QA : {
				 nextAuditType = AUDITTYPE.AUDITTYPE_TO_BUSINESS;
			 };
			 break;
			 //QA打回，待提交
			 case  AUDITTYPE_BACK_QA : {
				 nextAuditType = AUDITTYPE.AUDITTYPE_TO_QA;
			 };
			 break;
			 //待商务审核
			 case  AUDITTYPE_TO_BUSINESS : {
				 nextAuditType = AUDITTYPE.AUDITTYPE_PASS;
			 };
			 break;
			 //商务打回，待提交
			 case  AUDITTYPE_BACK_BUSINESS : {
				 nextAuditType = AUDITTYPE.AUDITTYPE_TO_BUSINESS;
			 };
			 break;
			 //审核通过
			 case  AUDITTYPE_PASS : {
				 nextAuditType = AUDITTYPE.AUDITTYPE_PASS;
			 };
			 break;
			}
			return nextAuditType;
		}

		AUDITTYPE(String name) {
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
	
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	/**
	 * 保险产品的产品类型前缀（保险的险种取自字典主键，前面加上此标识，以区分）
	 */
	public static final String EX_INS_PRODUCTTYPE = "INSURANCE_";
	/**
	 * 产品类型： 线路类别 +快递 （保险暂时没有列出此枚举，是用字典值加前缀而成，并不对外公开）
	 * @author ranlongfei
	 *
	 */
	public static enum PRODUCTTYPE {

		INNERLINE(1,"国内"),INNERSHORTLINE(2,"国内-短线"),INNERLONGLINE(3,"国内-长线"),
		FOREIGNLINE(4,"出境/港澳台"),EXPRESS(5,"快递"),DEPOSIT(6,"押金");

		    private int      index;
			private String cnName;

			public static String getCnName(String code) {
				for (PRODUCTTYPE item : PRODUCTTYPE.values()) {
					if (item.getCode().equals(code)) {
						return item.getCnName();
					}
				}
				return code;
			}
			
			public static String getCodeByIndex(int index) {
				for (PRODUCTTYPE item : PRODUCTTYPE.values()) {
					if (item.index == index) {
						return item.getCode();
					}
				}
				return "";
			}
			
			public static int getIndexByCode(String code) {
				for (PRODUCTTYPE item : PRODUCTTYPE.values()) {
					if (StringUtils.endsWithIgnoreCase(item.name(), code)) {
						return item.index;
					}
				}
				return 0;
			}
			
			

			PRODUCTTYPE(int index,String name) {
				this.index = index;
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
	
	
	public static enum WIFIPRODUCTTYPE {
		WIFI("WIFI"),PHONE("电话卡");
	
	    private int  index;
		private String cnName;

		public static String getCnName(String code) {
			for (WIFIPRODUCTTYPE item : WIFIPRODUCTTYPE.values()) {
				if (item.getCode().equals(code)) {
					return item.getCnName();
				}
			}
			return code;
		}
		
		
		public static int getIndexByCode(String code) {
			for (WIFIPRODUCTTYPE item : WIFIPRODUCTTYPE.values()) {
				if (StringUtils.endsWithIgnoreCase(item.name(), code)) {
					return item.index;
				}
			}
			return 0;
		}
		
		WIFIPRODUCTTYPE(String name) {
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

	public ProdDestRe getProdDestRe() {
		return prodDestRe;
	}
	public List<ProdDestRe> getProdDestReList() {
		return prodDestReList;
	}

	public void setProdDestReList(List<ProdDestRe> prodDestReList) {
		this.prodDestReList = prodDestReList;
	}

    public List<ProdLineRouteVO> getProdLineRouteList() {
        return prodLineRouteList;
    }

    public void setProdLineRouteList(List<ProdLineRouteVO> prodLineRouteList) {
        this.prodLineRouteList = prodLineRouteList;
    }

    public ComOrderRequired getComOrderRequired() {
		return comOrderRequired;
	}

	public void setComOrderRequired(ComOrderRequired comOrderRequired) {
		this.comOrderRequired = comOrderRequired;
	}

	public String getDistributorIds() {
		return distributorIds;
	}

	public void setDistributorIds(String distributorIds) {
		this.distributorIds = distributorIds;
	}

	public void setProdDestRe(ProdDestRe prodDestRe) {
		this.prodDestRe = prodDestRe;
	}

	public List<DistDistributorProd> getDistDistributorProds() {
		return distDistributorProds;
	}

	public void setDistDistributorProds(
			List<DistDistributorProd> distDistributorProds) {
		this.distDistributorProds = distDistributorProds;
	}

	public List<ComPhoto> getComPhotoList() {
		return comPhotoList;
	}

	public void setComPhotoList(List<ComPhoto> comPhotoList) {
		this.comPhotoList = comPhotoList;
	}

	public List<ProdActivity> getActivityList() {
		return activityList;
	}

	public void setActivityList(List<ProdActivity> activityList) {
		this.activityList = activityList;
	}

	public List<ProdFeature> getFeatureList() {
		return featureList;
	}

	public void setFeatureList(List<ProdFeature> featureList) {
		this.featureList = featureList;
	}

	public List<ProdViewSpot> getViewSpotList() {
		return viewSpotList;
	}

	public void setViewSpotList(List<ProdViewSpot> viewSpotList) {
		this.viewSpotList = viewSpotList;
	}

	public List<ProdServiceRe> getServiceReList() {
		return serviceReList;
	}

	public void setServiceReList(List<ProdServiceRe> serviceReList) {
		this.serviceReList = serviceReList;
	}

	public ProdProductAddtional getProductAddtional() {
		return productAddtional;
	}

	public void setProductAddtional(ProdProductAddtional productAddtional) {
		this.productAddtional = productAddtional;
	}

	public static int getPRODUCT_MEMCACHED_TIME_OUT() {
		return PRODUCT_MEMCACHED_TIME_OUT;
	}

	public static void setPRODUCT_MEMCACHED_TIME_OUT(int pRODUCT_MEMCACHED_TIME_OUT) {
		PRODUCT_MEMCACHED_TIME_OUT = pRODUCT_MEMCACHED_TIME_OUT;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getHotelCombFlag() {
		return hotelCombFlag;
	}

	public void setHotelCombFlag(String hotelCombFlag) {
		this.hotelCombFlag = hotelCombFlag;
	}

	public List<SuppGoodsSaleRe> getSuppGoodsSaleReList() {
		return suppGoodsSaleReList;
	}

	public void setSuppGoodsSaleReList(List<SuppGoodsSaleRe> suppGoodsSaleReList) {
		this.suppGoodsSaleReList = suppGoodsSaleReList;
	}
	
	public String[] getDisIds() {
		return disIds;
	}

	public void setDisIds(String[] disIds) {
		this.disIds = disIds;
	}

	public List<SuppGoods> getRecommendSuppGoodsList() {
		return recommendSuppGoodsList;
	}

	public void setRecommendSuppGoodsList(List<SuppGoods> recommendSuppGoodsList) {
		this.recommendSuppGoodsList = recommendSuppGoodsList;
	}

	public List<ProdPackageGroup> getProdPackgeGroupList() {
		return prodPackgeGroupList;
	}

	public void setProdPackgeGroupList(List<ProdPackageGroup> prodPackgeGroupList) {
		this.prodPackgeGroupList = prodPackgeGroupList;
	}

	public Long getDailyLowestPrice() {
		return dailyLowestPrice;
	}

	public void setDailyLowestPrice(Long dailyLowestPrice) {
		this.dailyLowestPrice = dailyLowestPrice;
	}

	public Long getBaseAdultQuantity() {
		return baseAdultQuantity;
	}

	public void setBaseAdultQuantity(Long baseAdultQuantity) {
		this.baseAdultQuantity = baseAdultQuantity;
	}

	public Long getBaseChildQuantity() {
		return baseChildQuantity;
	}

	public void setBaseChildQuantity(Long baseChildQuantity) {
		this.baseChildQuantity = baseChildQuantity;
	}

	public String getSuppProductName() {
		return suppProductName;
	}

	public void setSuppProductName(String suppProductName) {
		this.suppProductName = suppProductName;
	}
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public String getUrlQR() {
		return urlQR;
	}

	public void setUrlQR(String urlQR) {
		this.urlQR = urlQR;
	}

	/**
	 * @return the isKaixinlvxing
	 */
	public String getIsKaixinlvxing() {
		return isKaixinlvxing;
	}

	/**
	 * @param isKaixinlvxing the isKaixinlvxing to set
	 */
	public void setIsKaixinlvxing(String isKaixinlvxing) {
		this.isKaixinlvxing = isKaixinlvxing;
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

	public List<ProdProductSaleRe> getProdProductSaleReList() {
		return prodProductSaleReList;
	}

	public void setProdProductSaleReList(List<ProdProductSaleRe> prodProductSaleReList) {
		this.prodProductSaleReList = prodProductSaleReList;
	}

	public Double getModelVersion() {
		return modelVersion;
	}

	public void setModelVersion(Double modelVersion) {
		this.modelVersion = modelVersion;
	}

	public ProdLineBasicInfo getProdLineBasicInfo() {
		return prodLineBasicInfo;
	}

	public ProdProductNameVO getProdProductNameVO() {
		return prodProductNameVO;
	}

	public void setProdProductNameVO(ProdProductNameVO prodProductNameVO) {
		this.prodProductNameVO = prodProductNameVO;
	}

	public void setProdLineBasicInfo(ProdLineBasicInfo prodLineBasicInfo) {
		this.prodLineBasicInfo = prodLineBasicInfo;
	}

	/**
	 * 是否按份售卖
	 * @param lineProduct
	 * @return
	 */
	public boolean isSaleCopies(){
		List<ProdProductSaleRe> prodProductSaleReList =  getProdProductSaleReList();
		if(prodProductSaleReList!=null && !prodProductSaleReList.isEmpty()){
			ProdProductSaleRe prodProductSaleRe = prodProductSaleReList.get(0);
			//如果是按份售卖
			if(prodProductSaleRe!=null && prodProductSaleRe.getSaleType()!=null && ProdProductSaleRe.SALETYPE.COPIES.name().equals(prodProductSaleRe.getSaleType())){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 是否按人售卖
	 * @param lineProduct
	 * @return
	 */
	public boolean isSalePeople(){
		List<ProdProductSaleRe> prodProductSaleReList =  getProdProductSaleReList();
		if(prodProductSaleReList!=null && !prodProductSaleReList.isEmpty()){
			ProdProductSaleRe prodProductSaleRe = prodProductSaleReList.get(0);
			if(prodProductSaleRe!=null && prodProductSaleRe.getSaleType()!=null 
					&& !ProdProductSaleRe.SALETYPE.PEOPLE.name().equals(prodProductSaleRe.getSaleType())){
				return false;
			}
		}
		return true;
	}


	/**
	 * 前台价格显示单位控制
	 * @return
	 */
	public String getProdProductAdditionSaleType() {
		List<ProdProductSaleRe> prodProductSaleReList = this.getProdProductSaleReList();
		if(prodProductSaleReList != null && !prodProductSaleReList.isEmpty()){
			ProdProductSaleRe prodProductSaleRe = prodProductSaleReList.get(0);
			if(prodProductSaleRe != null && ProdProductSaleRe.SALETYPE.COPIES.name().equals(prodProductSaleRe.getSaleType())){
				if(!"N".equals(this.getHotelCombFlag())) {
					return COPIES_OTHER.name();
				}
			}
		}
		if("N".equals(this.getHotelCombFlag())){
			return COPIES_COMB_HOTEL.name();
		}
		
		return PEOPLE.name();
	}

	/**
	 * 
	 * 获取线路前台详情页与搜索列表对应单位
	 * @param isNeedClusterFlag =true 需要成团人数，false 不需要 
	 * @param specChar 调用方特殊处理，如果传入null则不做任何处理
	 * @return
	 */
	public String getLineRouteProductUnit(boolean isNeedClusterFlag, String specChar){
		StringBuilder unit = new StringBuilder("");
		Long adultQuantity = 0L;// 按份售卖成人数
		Long childQuantity = 0L;// 按份售卖儿童数
		
		if(StringUtil.isEmptyString(specChar)){
			specChar = "";
		}
		
		String categoryId = "";
		if(StringUtil.isNotEmptyString(bizCategoryId+"")){
			categoryId = String.valueOf(bizCategoryId);
		}
		if(VST_CATEGORY.CATEGORY_ROUTE_HOTELCOMB.getCategoryId().equals(categoryId)){
			//供应商打包酒店套餐(品类ID=17)
			// 目的地BU、酒店套餐
			if(CommEnumSet.BU_NAME.DESTINATION_BU.getCode().equals(getBu())){
				if(this.getBaseChildQuantity() < 1){
					unit.append("起/份").append(specChar + "(").append(this.getBaseAdultQuantity()).append("成人").append(")");
				}else{
					unit.append("起/份").append(specChar + "(").append(this.getBaseAdultQuantity()).append("成人").append(this.getBaseChildQuantity()).append("儿童").append(")");
				}
			}else{
				if(this.getBaseChildQuantity() < 1){
					unit.append("起/").append(specChar + "(").append(this.getBaseAdultQuantity()).append("成人").append(")");
				}else{
					unit.append("起/").append(specChar + "(").append(this.getBaseAdultQuantity()).append("成人").append(this.getBaseChildQuantity()).append("儿童").append(")");
				}
			}
		}else if(ProdProduct.PACKAGETYPE.LVMAMA.name().equals(this.getPackageType())){
			//自主打包(售卖方式：份)
			if(isSaleCopies()){
				List<ProdProductSaleRe> prodProductSaleRes = getProdProductSaleReList();
				if(null!=prodProductSaleRes && !prodProductSaleRes.isEmpty()){
					//非酒店套餐按份售卖
					ProdProductSaleRe prodProductSaleRe = prodProductSaleRes.get(0);
					adultQuantity  = prodProductSaleRe.getAdult().longValue();
					childQuantity = prodProductSaleRe.getChild().longValue();					
				}				
				// 目的地BU、酒店套餐
				if(CommEnumSet.BU_NAME.DESTINATION_BU.getCode().equals(getBu()) && "N".equals(this.getHotelCombFlag())){
					if(childQuantity < 1){
						unit.append("起/份").append(specChar + "(").append(adultQuantity).append("成人").append(")");
					}else{
						unit.append("起/份").append(specChar + "(").append(adultQuantity).append("成人").append(childQuantity).append("儿童").append(")");
					}
				}else if(!CommEnumSet.BU_NAME.DESTINATION_BU.getCode().equals(getBu()) && "N".equals(this.getHotelCombFlag())){
					// 非目的地BU、酒店套餐
					unit.append("起/人");
				}else{
					if(childQuantity < 1) {
						unit.append("起/份").append(specChar + "(").append(adultQuantity).append("成人").append(")");
					}else {
						unit.append("起/份").append(specChar + "(").append(adultQuantity).append("成人").append(childQuantity).append("儿童").append(")");
					}
				}
			}else{
				if(isSalePeople()){
					// 自主打包、售卖方式按人
					unit.append("起/人");
				}
			}
		}else if(ProdProduct.PACKAGETYPE.SUPPLIER.name().equals(this.getPackageType())){
			// 供应商打包（跟团游、自由行、当地游）
			if(VST_CATEGORY.CATEGORY_ROUTE_GROUP.getCategoryId().equals(categoryId) || VST_CATEGORY.CATEGORY_ROUTE_FREEDOM.getCategoryId().equals(categoryId) 
					|| VST_CATEGORY.CATEGORY_ROUTE_LOCAL.getCategoryId().equals(categoryId)){
				unit.append("起/人");
			}
		}
		
		if(isNeedClusterFlag){
			String pepoleNumber = "";
			if(null!=propValue){
				// 最少成团人数
				Object obj = propValue.get("least_cluster_person");
				if(null!=obj && obj instanceof String){
					pepoleNumber = (String) obj;
					pepoleNumber = "(最少成团人数:"+pepoleNumber+"人)";
				}
			}
			
			unit.append(pepoleNumber);
		}
		
		return unit.toString();
	}
	
	public String getMuiltDpartureFlag() {
		return muiltDpartureFlag;
	}

	public void setMuiltDpartureFlag(String muiltDpartureFlag) {
		this.muiltDpartureFlag = muiltDpartureFlag;
	}

	/**
	 * 判断产品是否为多出发地产品
	 * @return		true:多出发地产品		false:非多出发地产品
	 */
	public boolean isMultiDparture(){
		if( this.getMuiltDpartureFlag()!=null && "Y".equalsIgnoreCase(this.getMuiltDpartureFlag())){
			return true;
		}
		return false;
	}

	public List<BizDistrict> getBizDistricts() {
		return bizDistricts;
	}

	public void setBizDistricts(List<BizDistrict> bizDistricts) {
		this.bizDistricts = bizDistricts;
	}

	/**
	 * 公司主体
	 * @author xuxueli 2015-6-12 18:34:43
	 */
	public enum COMPANY_TYPE_DIC {
		XINGLV("上海驴妈妈兴旅国际旅行社有限公司"),	// 总公司, 默认
		GUOLV("上海驴妈妈国际旅行社有限公司");		// 子公司
		private String title;
		private COMPANY_TYPE_DIC(String title){
			this.title = title;
		}
		public String getTitle(){
			return this.title;
		}
	}
	public String getManagerIdPerm() {
		return managerIdPerm;
	}

	public void setManagerIdPerm(String managerIdPerm) {
		this.managerIdPerm = managerIdPerm;
	}
	/**
	 * 是否审核通过
	 * @param prod
	 * @return
	 */
	public boolean isAuditProduct() {
		if(ProdProduct.AUDITTYPE.AUDITTYPE_PASS.getCode().equals(this.getAuditStatus())) {
			return true;
		}
		
		return false;
	}
}