package com.lvmama.lvfit.common.form.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.enums.BizEnum.BIZ_CATEGORY_TYPE;
import com.lvmama.lvfit.common.dto.enums.JudgeType;
import com.lvmama.lvfit.common.dto.enums.ProductAuditType;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpCityGroupDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductAdditionalInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductFeeRulesDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductTrafficRulesDto;

public class FitSdpProductBasicInfoForm implements Serializable ,Form{

	/**
	 * @author lijinlong
	 * @date 2016年5月24日 17:45:00
	 */
	private static final long serialVersionUID = -2300526371837089215L;
	private FitSdpProductBasicInfoDto fitSdpProductBasicInfoDto;
	private String routeStayNum;
	public FitSdpProductBasicInfoDto getFitSdpProductBasicInfoDto() {
		return fitSdpProductBasicInfoDto;
	}

	public void setFitSdpProductBasicInfoDto(FitSdpProductBasicInfoDto fitSdpProductBasicInfoDto) {
		this.fitSdpProductBasicInfoDto = fitSdpProductBasicInfoDto;
		this.setRouteStayNum(fitSdpProductBasicInfoDto.getRouteNum()+"天"+fitSdpProductBasicInfoDto.getStayNum()+"晚");
	}
	

	public Long getProductId() {
		return fitSdpProductBasicInfoDto.getProductId();
	}
	public void setProductId(Long productId) {
		this.fitSdpProductBasicInfoDto.setProductId(productId);
	}
	public Long getAttributionId() {
		return fitSdpProductBasicInfoDto.getAttributionId();
	}
	public void setAttributionId(Long attributionId) {
		fitSdpProductBasicInfoDto.setAttributionId(attributionId);
	}
	public String getProductName() {
		return fitSdpProductBasicInfoDto.getProductName();
	}
	public void setProductName(String productName) {
		fitSdpProductBasicInfoDto.setProductName(productName);
	}
	public String getBizCategoryId() {
		return BIZ_CATEGORY_TYPE.getCnName(fitSdpProductBasicInfoDto.getBizCategoryId());
	}
	public void setBizCategoryId(Long bizCategoryId) {
		fitSdpProductBasicInfoDto.setBizCategoryId(bizCategoryId);
	}
	public String getBizCategoryName() {
		return fitSdpProductBasicInfoDto.getBizCategoryName();
	}
	public void setBizCategoryName(String bizCategoryName) {
		fitSdpProductBasicInfoDto.setBizCategoryName(bizCategoryName);
	}
	public Long getSubCategoryId() {
		return fitSdpProductBasicInfoDto.getSubCategoryId();
	}
	public void setSubCategoryId(Long subCategoryId) {
		fitSdpProductBasicInfoDto.setSubCategoryId(subCategoryId);
	}
	public FitSdpCityGroupDto getDefDeparture() {
		return fitSdpProductBasicInfoDto.getDefDeparture();
	}
	public void setDefDeparture(FitSdpCityGroupDto defDeparture) {
		fitSdpProductBasicInfoDto.setDefDeparture(defDeparture);
	}

	public BigDecimal getProductPrice() {
		return fitSdpProductBasicInfoDto.getProductPrice();
	}
	public void setProductPrice(BigDecimal productPrice) {
		fitSdpProductBasicInfoDto.setProductPrice(productPrice);
	}
	public String getPriceUnit() {
		return fitSdpProductBasicInfoDto.getPriceUnit();
	}
	public void setPriceUnit(String priceUnit) {
		fitSdpProductBasicInfoDto.setPriceUnit(priceUnit);
	}
	public String getPhotoUrls() {
		return fitSdpProductBasicInfoDto.getPhotoUrls();
	}
	public void setPhotoUrls(String photoUrls) {
		fitSdpProductBasicInfoDto.setPhotoUrls(photoUrls);
	}
	public String getManagerName() {
		return fitSdpProductBasicInfoDto.getManagerName();
	}
	public void setManagerName(String managerName) {
		fitSdpProductBasicInfoDto.setManagerName(managerName);
	}
	public String getMuiltDpartureFlag() {
		return fitSdpProductBasicInfoDto.getMuiltDpartureFlag().getCnName();
	}
	public void setMuiltDpartureFlag(JudgeType muiltDpartureFlag) {
		fitSdpProductBasicInfoDto.setMuiltDpartureFlag(muiltDpartureFlag);
	}
	public Long getPackagedProductId() {
		return fitSdpProductBasicInfoDto.getPackagedProductId();
	}
	public void setPackagedProductId(Long packagedProductId) {
		fitSdpProductBasicInfoDto.setPackagedProductId(packagedProductId);
	}
	public Integer getRouteNum() {
		return fitSdpProductBasicInfoDto.getRouteNum();
	}
	public void setRouteNum(Integer routeNum) {
		fitSdpProductBasicInfoDto.setRouteNum(routeNum);
	}
	public Integer getStayNum() {
		return fitSdpProductBasicInfoDto.getStayNum();
	}
	public void setStayNum(Integer stayNum) {
		fitSdpProductBasicInfoDto.setStayNum(stayNum);
	}
	public String getAuditType() {
		return fitSdpProductBasicInfoDto.getAuditType().getCnName();
	}
	public void setAuditType(ProductAuditType auditType) {
		fitSdpProductBasicInfoDto.setAuditType(auditType);
	}
	public String getCancelFlag() {
		return fitSdpProductBasicInfoDto.getCancelFlag().getCnName();
	}
	public void setCancelFlag(JudgeType cancelFlag) {
		fitSdpProductBasicInfoDto.setCancelFlag(cancelFlag);
	}
	public String getSaleFlag() {
		return fitSdpProductBasicInfoDto.getSaleFlag().getCnName();
	}
	public void setSaleFlag(JudgeType saleFlag) {
		fitSdpProductBasicInfoDto.setSaleFlag(saleFlag);
	}
	public Date getCreateTime() {
		return fitSdpProductBasicInfoDto.getCreateTime();
	}
	public void setCreateTime(Date createTime) {
		fitSdpProductBasicInfoDto.setCreateTime(createTime);
	}
	public JudgeType getPackageTrafficFlag() {
		return fitSdpProductBasicInfoDto.getPackageTrafficFlag();
	}
	public void setPackageTrafficFlag(JudgeType packageTrafficFlag) {
		fitSdpProductBasicInfoDto.setPackageTrafficFlag(packageTrafficFlag);
	}
	public JudgeType getRouteDetailUseFlag() {
		return fitSdpProductBasicInfoDto.getRouteDetailUseFlag();
	}
	public void setRouteDetailUseFlag(JudgeType routeDetailUseFlag) {
		fitSdpProductBasicInfoDto.setRouteDetailUseFlag(routeDetailUseFlag);
	}
	public JudgeType getFeeExplainUseFlag() {
		return fitSdpProductBasicInfoDto.getFeeExplainUseFlag();
	}
	public void setFeeExplainUseFlag(JudgeType feeExplainUseFlag) {
		fitSdpProductBasicInfoDto.setFeeExplainUseFlag(feeExplainUseFlag);
	}
	public String getCategoryCode() {
		return fitSdpProductBasicInfoDto.getCategoryCode();
	}
	public void setCategoryCode(String categoryCode) {
		fitSdpProductBasicInfoDto.setCategoryCode(categoryCode);
	}
	public Long getManagerId() {
		return fitSdpProductBasicInfoDto.getManagerId();
	}
	public void setManagerId(Long managerId) {
		fitSdpProductBasicInfoDto.setManagerId(managerId);
	}
	public FitSdpProductAdditionalInfoDto getAdditionalInfoDto() {
		return fitSdpProductBasicInfoDto.getAdditionalInfoDto();
	}
	public void setAdditionalInfoDto(FitSdpProductAdditionalInfoDto additionalInfoDto) {
		fitSdpProductBasicInfoDto.setAdditionalInfoDto(additionalInfoDto);
	}
	public List<FitSdpCityGroupDto> getCityGroups() {
		return fitSdpProductBasicInfoDto.getCityGroups();
	}
	public void setCityGroups(List<FitSdpCityGroupDto> cityGroups) {
		fitSdpProductBasicInfoDto.setCityGroups(cityGroups);
	}
    public Long getAdultQuantity() {
        return fitSdpProductBasicInfoDto.getAdultQuantity();
    }
    public void setAdultQuantity(Long adultQuantity) {
    	fitSdpProductBasicInfoDto.setAdultQuantity(adultQuantity);
    }
    public Long getChildQuantity() {
        return fitSdpProductBasicInfoDto.getChildQuantity();
    }
    public void setChildQuantity(Long childQuantity) {
    	fitSdpProductBasicInfoDto.setChildQuantity(childQuantity);
    }
    public JudgeType getHomeComboFlag() {
        return fitSdpProductBasicInfoDto.getHomeComboFlag();
    }
    public void setHomeComboFlag(JudgeType homeComboFlag) {
    	fitSdpProductBasicInfoDto.setHomeComboFlag(homeComboFlag);
    }
    public String getChildPriceDesc() {
        return fitSdpProductBasicInfoDto.getChildPriceDesc();
    }
    public void setChildPriceDesc(String childPriceDesc) {
    	fitSdpProductBasicInfoDto.setChildPriceDesc(childPriceDesc);
    }
	public List<FitSdpProductTrafficRulesDto> getTrafficRulesDtos() {
		return fitSdpProductBasicInfoDto.getTrafficRulesDtos();
	}
	public void setTrafficRulesDtos(
			List<FitSdpProductTrafficRulesDto> trafficRulesDtos) {
		fitSdpProductBasicInfoDto.setTrafficRulesDtos(trafficRulesDtos);
	}
	public List<FitSdpProductFeeRulesDto> getFeeRulesDtos() {
		return fitSdpProductBasicInfoDto.getFeeRulesDtos();
	}
	public void setFeeRulesDtos(List<FitSdpProductFeeRulesDto> feeRulesDtos) {
		fitSdpProductBasicInfoDto.setFeeRulesDtos(feeRulesDtos);
	}

	public String getRouteStayNum() {
		return routeStayNum;
	}

	public void setRouteStayNum(String routeStayNum) {
		this.routeStayNum = routeStayNum;
	}
	public String getCurSyncFlag() {
		return fitSdpProductBasicInfoDto.getCurSyncFlag().getCnName();
	}

	public void setCurSyncFlag(JudgeType curSyncFlag) {
		fitSdpProductBasicInfoDto.setCurSyncFlag(curSyncFlag);
	}
	

}
