package com.lvmama.lvfit.business.sdpproduct.domain.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvfit.business.sdpproduct.domain.FitSdpProductSynMsgDomain;
import com.lvmama.lvfit.business.sdpproduct.domain.repository.FitSdpProductSearchSynInfoRepository;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSynMsg;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSdpProductSynMsgMapper;

@Repository
public class FitSdpProductSynInfoRepositoryImpl implements FitSdpProductSearchSynInfoRepository {

	@Autowired
	private FitSdpProductSynMsgMapper fitSdpProductSynMsgMapper;
	
	@Override
	public FitSdpProductSynMsg load(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FitSdpProductSynMsgDomain load(FitSdpProductSynMsg r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FitSdpProductSynMsg save(FitSdpProductSynMsg r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FitSdpProductSynMsg> queryByFkId(Long fkId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByFkId(Long fkId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FitSdpProductSynMsg> querySynMsgList(Long productId) {
		return fitSdpProductSynMsgMapper.querySynMsgList(productId);
	}

}
