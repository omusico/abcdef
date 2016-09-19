package com.lvmama.lvfit.business.sdpproduct.domain.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvfit.business.sdpproduct.domain.FitSdpProductSearchIndexTrafficDomain;
import com.lvmama.lvfit.business.sdpproduct.domain.repository.FitSdpProductSearchIndexTrafficRepository;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexTraffic;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSdpProductSearchIndexTrafficMapper;

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
		 fitSdpProductSearchIndexTrafficMapper.updateById(r.getId(), r);
		 return r;
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
			BaseQueryDto<Long> baseQuery) {
		return fitSdpProductSearchIndexTrafficMapper.queryIndexTrafficList(baseQuery);
	}

	@Override
	public FitSdpProductSearchIndexTraffic queryTrafficIndexById(Long id) {
		return fitSdpProductSearchIndexTrafficMapper.queryTrafficIndexById(id);
	}

	@Override
	public void updateOneTrafficIndex(FitSdpProductSearchIndexTraffic dto) {
		fitSdpProductSearchIndexTrafficMapper.updateOneTrafficIndex(dto);
	}

	@Override
	public int countIndexTraffic(BaseQueryDto<Long> baseQuery) {
		return fitSdpProductSearchIndexTrafficMapper.countIndexTraffic(baseQuery);
	}

}
