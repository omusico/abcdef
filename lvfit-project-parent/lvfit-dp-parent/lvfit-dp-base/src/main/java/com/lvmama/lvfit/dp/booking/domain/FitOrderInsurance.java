package com.lvmama.lvfit.dp.booking.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lvmama.lvf.common.domain.Domain;
import com.lvmama.lvfit.common.dto.order.FitOrderInsuranceDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedInsuranceDto;

public class FitOrderInsurance implements Domain<FitOrderInsuranceDto> {
	
	
    private static final Logger logger = LoggerFactory.getLogger(FitOrderSpotTicket.class);
	
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
}
