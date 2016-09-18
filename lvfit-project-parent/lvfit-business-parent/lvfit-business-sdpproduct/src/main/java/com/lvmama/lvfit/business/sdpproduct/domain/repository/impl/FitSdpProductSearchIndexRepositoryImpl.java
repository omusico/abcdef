package com.lvmama.lvfit.business.sdpproduct.domain.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvfit.business.sdpproduct.domain.FitSdpProductSearchIndexDomain;
import com.lvmama.lvfit.business.sdpproduct.domain.repository.FitSdpProductSearchIndexRepository;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexDto;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSdpProductSearchIndexMapper;

@Repository
public class FitSdpProductSearchIndexRepositoryImpl implements FitSdpProductSearchIndexRepository {
	
	@Autowired
	private FitSdpProductSearchIndexMapper fitSdpProductSearchIndexMapper;
	
	@Override
	public FitSdpProductSearchIndexDto load(Long id) {
		return fitSdpProductSearchIndexMapper.getById(id);
	}

	@Override
	public FitSdpProductSearchIndexDomain load(FitSdpProductSearchIndexDto r) {
		return new FitSdpProductSearchIndexDomain(r);
	}

	@Override
	public int delete(Long id) {
		return fitSdpProductSearchIndexMapper.deleteById(id);
	}

	@Override
	public FitSdpProductSearchIndexDto save(FitSdpProductSearchIndexDto r) {
		if(r.getId()== null){
			fitSdpProductSearchIndexMapper.insert(r);
		}else{
			fitSdpProductSearchIndexMapper.updateById(r.getId(), r);
		}
		return r;
	}

	@Override
	public List<FitSdpProductSearchIndexDto> queryByFkId(Long fkId) {
		return fitSdpProductSearchIndexMapper.queryByFkId(fkId);
	}

	@Override
	public int deleteByFkId(Long fkId) {
		return fitSdpProductSearchIndexMapper.deleteByFkId(fkId);
	}

	@Override
	public List<FitSdpProductSearchIndexDto> queryIndexInfoList(BaseQueryDto<Long> baseQuery) {
		return fitSdpProductSearchIndexMapper.getInfoList(baseQuery);
	}

}
