package com.lvmama.lvfit.common.dto.sdp.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.JudgeType;
import com.lvmama.lvfit.common.dto.enums.ProductAuditType;

/**
 * 打包产品基本信息Dto
 * @author lizongze
 *
 */
public class FitSdpProductBasicInfoDto  extends Entity {

    private static final long serialVersionUID = -9123552864841610587L;
    // 产品ID
    private Long productId;
    //分销ID
    private Long attributionId;
    // 产品名称
    private String productName;
    // 业务类型
    private Long bizCategoryId;
    // 业务类型名称
    private String bizCategoryName;
    //子业务类型
    private Long subCategoryId;
    // 默认出发地
    private FitSdpCityGroupDto defDeparture;//
    // 成人数
    private Long adultQuantity;
    // 儿童数
    private Long childQuantity;
    // 产品价格
    private BigDecimal productPrice;
    // 产品价格单位
    private String priceUnit;
    //景点图片多个url，用,隔开
    private String photoUrls;
    // 产品经理
    private String managerName;
    // 多出发地标志，'N'非多出发地，'Y'多出发地
    private JudgeType muiltDpartureFlag;
	// 被打包产品Id
    private Long packagedCategoryId;
	// 被打包产品Id
	private Long packagedProductId;
    // 是否含有酒店套餐
    private JudgeType homeComboFlag;
    //行程天数
    private Integer routeNum;
    //入住天数
    private Integer stayNum;
   //产品审核状态
    private ProductAuditType auditType; 
    //是否有效
    private  JudgeType cancelFlag;
    //是否可售
    private  JudgeType saleFlag;
    //是否自动打包交通
    private  JudgeType packageTrafficFlag;
    //是否对接优先(用于包机切位的标记.)
    private  JudgeType packCharterFlightFlag;
    //是否使用被打包产品行程明细，'N'否，'Y'是
    private JudgeType routeDetailUseFlag;
    //是否使用被打包产品费用说明，'N'否，'Y'是
    private JudgeType feeExplainUseFlag;
    // 品类CODE
    private String categoryCode;
    // 产品经理ID
    private Long managerId;
    // 产品额外信息
    private FitSdpProductAdditionalInfoDto additionalInfoDto;//
    //产品城市组信息
    private List<FitSdpCityGroupDto> cityGroups = new ArrayList<FitSdpCityGroupDto>();
    // 儿童价说明
    private String childPriceDesc;
    //交通规则
    private List<FitSdpProductTrafficRulesDto> trafficRulesDtos = new ArrayList<FitSdpProductTrafficRulesDto>();
    //费用规则
    private  List<FitSdpProductFeeRulesDto> feeRulesDtos = new ArrayList<FitSdpProductFeeRulesDto>();//
    
     

	public JudgeType getPackCharterFlightFlag() {
		return packCharterFlightFlag;
	}

	private String productShowName;

	public String getProductShowName() {
		return productShowName;
	}

	public void setProductShowName(String productShowName) {
		this.productShowName = productShowName;
	}

	public void setPackCharterFlightFlag(JudgeType packCharterFlightFlag) {
		this.packCharterFlightFlag = packCharterFlightFlag;
	}

	//当前同步状态
    private  JudgeType curSyncFlag;
    
    /***********************************************************************************************************/
    private Long recommendLevel;

    private String productType;

    private String packageType;
	
	private String urlId;
	
	private String photoUrl;

	private String photoContent;
	// 线路概况
	List<List<String>> routeList;
	
	/**行程Id */
	private Long lineRouteId;
    
    public Long getLineRouteId() {
		return lineRouteId;
	}

	public void setLineRouteId(Long lineRouteId) {
		this.lineRouteId = lineRouteId;
	}
    
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getAttributionId() {
		return attributionId;
	}
	public void setAttributionId(Long attributionId) {
		this.attributionId = attributionId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getBizCategoryId() {
		return bizCategoryId;
	}
	public void setBizCategoryId(Long bizCategoryId) {
		this.bizCategoryId = bizCategoryId;
	}
	public String getBizCategoryName() {
		return bizCategoryName;
	}
	public void setBizCategoryName(String bizCategoryName) {
		this.bizCategoryName = bizCategoryName;
	}
	public Long getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(Long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public FitSdpCityGroupDto getDefDeparture() {
		return defDeparture;
	}
	public void setDefDeparture(FitSdpCityGroupDto defDeparture) {
		this.defDeparture = defDeparture;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public String getPriceUnit() {
		return priceUnit;
	}
	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit;
	}
	public String getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(String photoUrls) {
		this.photoUrls = photoUrls;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public JudgeType getMuiltDpartureFlag() {
		return muiltDpartureFlag;
	}
	public void setMuiltDpartureFlag(JudgeType muiltDpartureFlag) {
		this.muiltDpartureFlag = muiltDpartureFlag;
	}
	public Long getPackagedProductId() {
		return packagedProductId;
	}
	public void setPackagedProductId(Long packagedProductId) {
		this.packagedProductId = packagedProductId;
	}
	public Integer getRouteNum() {
		return routeNum;
	}
	public void setRouteNum(Integer routeNum) {
		this.routeNum = routeNum;
	}
	public Integer getStayNum() {
		return stayNum;
	}
	public void setStayNum(Integer stayNum) {
		this.stayNum = stayNum;
	}
	public ProductAuditType getAuditType() {
		return auditType;
	}
	public void setAuditType(ProductAuditType auditType) {
		this.auditType = auditType;
	}
	public JudgeType getCancelFlag() {
		return cancelFlag;
	}
	public void setCancelFlag(JudgeType cancelFlag) {
		this.cancelFlag = cancelFlag;
	}
	public JudgeType getSaleFlag() {
		return saleFlag;
	}
	public void setSaleFlag(JudgeType saleFlag) {
		this.saleFlag = saleFlag;
	}
	public JudgeType getPackageTrafficFlag() {
		return packageTrafficFlag;
	}
	public void setPackageTrafficFlag(JudgeType packageTrafficFlag) {
		this.packageTrafficFlag = packageTrafficFlag;
	}
	public JudgeType getRouteDetailUseFlag() {
		return routeDetailUseFlag;
	}
	public void setRouteDetailUseFlag(JudgeType routeDetailUseFlag) {
		this.routeDetailUseFlag = routeDetailUseFlag;
	}
	public JudgeType getFeeExplainUseFlag() {
		return feeExplainUseFlag;
	}
	public void setFeeExplainUseFlag(JudgeType feeExplainUseFlag) {
		this.feeExplainUseFlag = feeExplainUseFlag;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public Long getManagerId() {
		return managerId;
	}
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
	public FitSdpProductAdditionalInfoDto getAdditionalInfoDto() {
		return additionalInfoDto;
	}
	public void setAdditionalInfoDto(FitSdpProductAdditionalInfoDto additionalInfoDto) {
		this.additionalInfoDto = additionalInfoDto;
	}
	public List<FitSdpCityGroupDto> getCityGroups() {
		return cityGroups;
	}
	public void setCityGroups(List<FitSdpCityGroupDto> cityGroups) {
		this.cityGroups = cityGroups;
	}
    public Long getAdultQuantity() {
        return adultQuantity;
    }
    public void setAdultQuantity(Long adultQuantity) {
        this.adultQuantity = adultQuantity;
    }
    public Long getChildQuantity() {
        return childQuantity;
    }
    public void setChildQuantity(Long childQuantity) {
        this.childQuantity = childQuantity;
    }
    public JudgeType getHomeComboFlag() {
        return homeComboFlag;
    }
    public void setHomeComboFlag(JudgeType homeComboFlag) {
        this.homeComboFlag = homeComboFlag;
    }
    public String getChildPriceDesc() {
        return childPriceDesc;
    }
    public void setChildPriceDesc(String childPriceDesc) {
        this.childPriceDesc = childPriceDesc;
    }
	public List<FitSdpProductTrafficRulesDto> getTrafficRulesDtos() {
		return trafficRulesDtos;
	}
	public void setTrafficRulesDtos(List<FitSdpProductTrafficRulesDto> trafficRulesDtos) {
		this.trafficRulesDtos = trafficRulesDtos;
	}
	public List<FitSdpProductFeeRulesDto> getFeeRulesDtos() {
		return feeRulesDtos;
	}
	public void setFeeRulesDtos(List<FitSdpProductFeeRulesDto> feeRulesDtos) {
		this.feeRulesDtos = feeRulesDtos;
	}

	public Long getRecommendLevel() {
		return recommendLevel;
	}

	public void setRecommendLevel(Long recommendLevel) {
		this.recommendLevel = recommendLevel;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public String getUrlId() {
		return urlId;
	}

	public void setUrlId(String urlId) {
		this.urlId = urlId;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getPhotoContent() {
		return photoContent;
	}

	public void setPhotoContent(String photoContent) {
		this.photoContent = photoContent;
	}

	public JudgeType getCurSyncFlag() {
		return curSyncFlag;
	}

	public void setCurSyncFlag(JudgeType curSyncFlag) {
		this.curSyncFlag = curSyncFlag;
	}

    public List<List<String>> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<List<String>> routeList) {
        this.routeList = routeList;
    }

	public Long getPackagedCategoryId() {
		return packagedCategoryId;
	}

	public void setPackagedCategoryId(Long packagedCategoryId) {
		this.packagedCategoryId = packagedCategoryId;
	}
}
