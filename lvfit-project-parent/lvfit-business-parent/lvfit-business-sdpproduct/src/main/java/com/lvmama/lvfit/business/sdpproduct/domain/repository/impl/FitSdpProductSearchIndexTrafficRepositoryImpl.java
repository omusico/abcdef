package com.lvmama.lvfit.business.sdpproduct.domain.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.sdpproduct.domain.FitSdpProductSearchIndexTrafficDomain;
import com.lvmama.lvfit.business.sdpproduct.domain.FitSdpProductSynMsgDomain;
import com.lvmama.lvfit.business.sdpproduct.domain.repository.FitSdpProductSearchIndexTrafficRepository;
import com.lvmama.lvfit.business.sdpproduct.domain.repository.FitSdpProductSearchSynInfoRepository;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexTraffic;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSynMsg;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSdpProductSearchIndexTrafficMapper;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSdpProductSynMsgMapper;

@Repository
public class FitSdpProductSearchIndexTrafficRepositoryImpl implements FitSdpProductSearchIndexTrafficRepository {

	@Autowired
	private FitSdpProductSearchIndexTrafficMapper fitSdpProductSearchIndexTrafficMapper;

	@Override
	public FitSdpProductSearchIndexTraffic load(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FitSdpProductSearchIndexTrafficDomain load(
			FitSdpProductSearchIndexTraffic r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FitSdpProductSearchIndexTraffic save(
			FitSdpProductSearchIndexTraffic r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FitSdpProductSearchIndexTraffic> queryByFkId(Long fkId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByFkId(Long fkId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FitSdpProductSearchIndexTraffic> queryIndexTrafficList(
			Long productId) {
		return fitSdpProductSearchIndexTrafficMapper.queryIndexTrafficList(productId);
	}
	
}
