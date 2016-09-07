package com.lvmama.lvfit.business.order.domain.repository;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvfit.business.order.domain.FitOrderMain;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;

/**
 * 主订单Repository
 */
public interface FitOrderMainRepository extends DomainBaseRepository<FitOrderMain, FitOrderMainDto> {
	
	//根据vst主单号获取机酒主订单信息
    FitOrderMainDto  getByVstOrderMainNo(Long vstOrderMainNo);
	
    //根据vst主单号只获取机票相关订单信息
    FitOrderMainDto  getFlightOrderByVstOrderMainNo(Long vstOrderMainNo);
	
    public FitOrderMainDto getOldByVstOrderMainNo(Long vstOrderMainNo);
    
    public List<FitSuppMainOrderDto> getAllOldOrderMainDto();
    
    public void updateSucOldOrderMainDto(Long vstOrderMainNo);
}
