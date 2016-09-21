package com.lvmama.lvfit.business.sdpproduct.domain.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvfit.business.sdpproduct.domain.FitSdpCityGroup;
import com.lvmama.lvfit.business.sdpproduct.domain.repository.FitSdpCityGroupRepository;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpCityGroupDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpCityGroupRequest;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSdpCityGroupMapper;

@Repository
public class FitSdpCityGroupRepositoryImpl implements FitSdpCityGroupRepository {
	
	@Autowired
	private FitSdpCityGroupMapper fitSdpCityGroupMapper;
	
	@Override
	public FitSdpCityGroupDto load(Long id) {
		return fitSdpCityGroupMapper.getById(id);
	}

	@Override
	public FitSdpCityGroup load(FitSdpCityGroupDto r) {
		return new FitSdpCityGroup(r);
	}

	@Override
	public int delete(Long id) {
		return fitSdpCityGroupMapper.deleteById(id);
	}

	@Override
	public FitSdpCityGroupDto save(FitSdpCityGroupDto r) {
		if(r.getId() == null){
			fitSdpCityGroupMapper.insert(r);
		}else{
			fitSdpCityGroupMapper.updateById(r.getId(),r);
		}
		return r;
	}

	@Override
	public List<FitSdpCityGroupDto> queryByFkId(Long fkId) {
		return fitSdpCityGroupMapper.queryByFkId(fkId);
	}
	
	@Override
	public List<FitSdpCityGroupDto> queryAllCitysByFkId(Long productId) {
		return fitSdpCityGroupMapper.queryAllCitysByFkId(productId);
	}
	
	@Override
	public int deleteByFkId(Long fkId) {
		return fitSdpCityGroupMapper.deleteByFkId(fkId);
	}
	
	@Override
	public int updateCityUseFlag(FitSdpCityGroupDto dto){
		return fitSdpCityGroupMapper.updateUseFlag(dto);
	}

	@Override
	public FitSdpCityGroupDto queryOneCityById(Long id) {
		return  fitSdpCityGroupMapper.getById(id);
	}

	@Override
	public List<FitSdpCityGroupDto> queryCityGroupByDto(
			BaseQueryDto<FitSdpCityGroupRequest> baseQueryDto) {
		return fitSdpCityGroupMapper.queryCityGroupByDto(baseQueryDto);
	}

	@Override
	public int countSdpProductDepartCityRecords(
			BaseQueryDto<FitSdpCityGroupRequest> baseQueryDto) {
		return fitSdpCityGroupMapper.countSdpProductDepartCityRecords(baseQueryDto);
	}

}
