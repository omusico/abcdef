package com.lvmama.lvfit.sdp.booking.domain;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitOrderInsuranceDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpSelectInsuranceDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedInsuranceDto;

public class FitOrderInsurance implements Domain<FitOrderInsuranceDto> {
	
	
    private FitOrderInsuranceDto self = new FitOrderInsuranceDto();

    public FitOrderInsurance() {
    	
    }

    @Override
    public FitOrderInsuranceDto self() {
        return this.self;
    }

    public FitOrderInsurance(FitOrderInsuranceDto self) {
        super();
        this.self = self;
    }

    public FitOrderInsuranceDto buildFitOrderInsuranceDto(FitShoppingSelectedInsuranceDto selectedInsuranceDto) {
    	this.self().setInsuranceId(selectedInsuranceDto.getProductId());
    	this.self().setInsuranceName(selectedInsuranceDto.getProductName());
    	this.self().setInsuranceType(selectedInsuranceDto.getProductType());
    	this.self().setInsuranceBranchId(selectedInsuranceDto.getBranchId());
    	this.self().setInsuranceBranchName(selectedInsuranceDto.getBranchName());
    	this.self().setInsuranceSuppGoodsId(selectedInsuranceDto.getSuppGoodsId());
    	this.self().setInsuranceSuppGoodsName(selectedInsuranceDto.getSuppGoodsName());
    	this.self().setInsuranceCount(selectedInsuranceDto.getInsuranceCount());
    	this.self().setUseDays(selectedInsuranceDto.getUseDays());
       	this.self().setVisitDate(selectedInsuranceDto.getVisitDate());
    	this.self().setInsurancePrice(selectedInsuranceDto.getInsurancePrice());
    	this.self().setInsuranceDetail(selectedInsuranceDto.getInsuranceDetail());
        return this.self;
    }
    
    public FitOrderInsuranceDto buildFitOrderInsuranceDto(FitSdpSelectInsuranceDto selectedInsuranceDto) {
    	this.self().setInsuranceName(selectedInsuranceDto.getProductName());
    	this.self().setInsuranceType(selectedInsuranceDto.getProductType());
    	this.self().setInsuranceBranchName(selectedInsuranceDto.getBranchName());
    	this.self().setInsuranceSuppGoodsId(selectedInsuranceDto.getSuppGoodsId().toString());
    	this.self().setInsuranceSuppGoodsName(selectedInsuranceDto.getGoodsName());
    	this.self().setInsuranceCount(selectedInsuranceDto.getSelectCount().intValue());
    	this.self().setInsurancePrice(selectedInsuranceDto.getPrice());
    	this.self().setInsuranceDetail(selectedInsuranceDto.getBranchDesc());
        return this.self;
    }
}
