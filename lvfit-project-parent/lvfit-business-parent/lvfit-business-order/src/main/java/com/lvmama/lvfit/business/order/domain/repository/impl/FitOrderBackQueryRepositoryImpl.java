package com.lvmama.lvfit.business.order.domain.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvfit.business.order.domain.repository.FitOrderBackQueryRepository;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.order.FitOrderQueryListDto;
import com.lvmama.lvfit.common.dto.request.FitOrderQueryRequest;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitOrderBackQueryMapper;

@Repository
public class FitOrderBackQueryRepositoryImpl implements FitOrderBackQueryRepository {
	@Autowired
	private FitOrderBackQueryMapper fitOrderBackQueryMapper;
	
	@Override
	public int count(BaseQueryDto<FitOrderQueryRequest> q){
		return fitOrderBackQueryMapper.count(q);
	}

	@Override
	public List<FitOrderQueryListDto> query(
			BaseQueryDto<FitOrderQueryRequest> baseQueryDto) {
		return fitOrderBackQueryMapper.query(baseQueryDto);
	}
	
	@Override
	public List<FitOrderQueryListDto> queryNoPage(
			BaseQueryDto<FitOrderQueryRequest> baseQueryDto) {
		return fitOrderBackQueryMapper.queryNoPage(baseQueryDto);
	}

	@Override
	public FitOrderMainDto viewOffline(Long mainOrderId) {
		FitOrderMainDto mainDto = fitOrderBackQueryMapper.viewOffline(mainOrderId);
		return mainDto;
	}

	@Override
	public List<FitOrderQueryListDto> queryOrderAllReport(
			BaseQueryDto<FitOrderQueryRequest> baseQueryDto) {
		return fitOrderBackQueryMapper.queryOrderAllReport(baseQueryDto);
	}

	@Override
	public List<FitOrderQueryListDto> queryOrderFlightReport(
			BaseQueryDto<FitOrderQueryRequest> baseQueryDto) {
		return fitOrderBackQueryMapper.queryOrderFlightReport(baseQueryDto);
	}

	@Override
	public List<FitOrderQueryListDto> queryOrderHotelReport(
			BaseQueryDto<FitOrderQueryRequest> baseQueryDto) {
		return fitOrderBackQueryMapper.queryOrderHotelReport(baseQueryDto);
	}

}
