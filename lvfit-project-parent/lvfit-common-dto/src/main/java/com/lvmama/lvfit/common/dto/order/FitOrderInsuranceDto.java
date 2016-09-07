package com.lvmama.lvfit.common.dto.order;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.InsuranceType;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * 订单保险信息
 */
public class FitOrderInsuranceDto extends Entity {

	private static final long serialVersionUID = -6229492192151808029L;
	// 产品ID
	private String insuranceId;
	// 产品名称
	private String insuranceName;
	//产品类型
	private String insuranceType;
	//产品类型
	private String insuranceTypeName;
	//规格id
	private String insuranceBranchId;
	//规格名称
	private String insuranceBranchName;
	// 商品ID
	private String insuranceSuppGoodsId;
	// 商品名称
	private String insuranceSuppGoodsName;
	//购买份数
	private int insuranceCount;
	//使用天数
	private Integer useDays;
    //门票金额
    private BigDecimal  insurancePrice;
    //保险详情
    private String insuranceDetail;
	//游玩日期
    private Date visitDate;     
	
    public String getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}
	public String getInsuranceName() {
		return insuranceName;
	}
	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public String getInsuranceTypeName() {
		
		if(StringUtils.isNotBlank(insuranceType)){
			insuranceTypeName = InsuranceType.getCnName(Long.valueOf(insuranceType));
		}
		return insuranceTypeName;
	}
	public void setInsuranceTypeName(String insuranceTypeName) {
		this.insuranceTypeName = insuranceTypeName;
	}
	public String getInsuranceBranchId() {
		return insuranceBranchId;
	}
	public void setInsuranceBranchId(String insuranceBranchId) {
		this.insuranceBranchId = insuranceBranchId;
	}
	public String getInsuranceBranchName() {
		return insuranceBranchName;
	}
	public void setInsuranceBranchName(String insuranceBranchName) {
		this.insuranceBranchName = insuranceBranchName;
	}
	public String getInsuranceSuppGoodsId() {
		return insuranceSuppGoodsId;
	}
	public void setInsuranceSuppGoodsId(String insuranceSuppGoodsId) {
		this.insuranceSuppGoodsId = insuranceSuppGoodsId;
	}
	public String getInsuranceSuppGoodsName() {
		return insuranceSuppGoodsName;
	}
	public void setInsuranceSuppGoodsName(String insuranceSuppGoodsName) {
		this.insuranceSuppGoodsName = insuranceSuppGoodsName;
	}
	public int getInsuranceCount() {
		return insuranceCount;
	}
	public void setInsuranceCount(int insuranceCount) {
		this.insuranceCount = insuranceCount;
	}
	public Integer getUseDays() {
		return useDays;
	}
	public void setUseDays(Integer useDays) {
		this.useDays = useDays;
	}
	public BigDecimal getInsurancePrice() {
		return insurancePrice;
	}
	public void setInsurancePrice(BigDecimal insurancePrice) {
		this.insurancePrice = insurancePrice;
	}
	public String getInsuranceDetail() {
		return insuranceDetail;
	}
	public void setInsuranceDetail(String insuranceDetail) {
		this.insuranceDetail = insuranceDetail;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
}
