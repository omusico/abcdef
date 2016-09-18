package com.lvmama.lvfit.business.sdpproduct.domain.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvfit.business.sdpproduct.domain.FitSdpProductSynMsgDomain;
import com.lvmama.lvfit.business.sdpproduct.domain.repository.FitSdpProductSearchSynInfoRepository;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSyncMsgDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSdpProductSynMsgMapper;

@Repository
public class FitSdpProductSynInfoRepositoryImpl implements FitSdpProductSearchSynInfoRepository {

	@Autowired
	private FitSdpProductSynMsgMapper fitSdpProductSynMsgMapper;
	
	@Override
	public FitSdpProductSyncMsgDto load(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FitSdpProductSynMsgDomain load(FitSdpProductSyncMsgDto r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FitSdpProductSyncMsgDto save(FitSdpProductSyncMsgDto r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FitSdpProductSyncMsgDto> queryByFkId(Long fkId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByFkId(Long fkId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FitSdpProductSyncMsgDto> querySynMsgList(BaseQueryDto<Long> baseQuery) {
		return fitSdpProductSynMsgMapper.querySynMsgList(baseQuery);
	}

	@Override
	public void saveSyncMsgDto(FitSdpProductSyncMsgDto syncMsgDto) {
		fitSdpProductSynMsgMapper.insert(syncMsgDto);
	}

	@Override
	public List<FitSdpProductSyncMsgDto> querySdpProductSynMsgInfo(BaseQueryDto<Long> baseQuery) {
		return fitSdpProductSynMsgMapper.querySdpProductSynMsgInfo(baseQuery);
	}

}
