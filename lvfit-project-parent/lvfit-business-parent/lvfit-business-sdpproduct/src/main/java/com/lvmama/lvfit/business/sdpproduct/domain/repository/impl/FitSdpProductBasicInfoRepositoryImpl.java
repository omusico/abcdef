package com.lvmama.lvfit.business.sdpproduct.domain.repository.impl;

import java.util.List;

import com.lvmama.lvfit.common.dto.enums.JudgeType;
import com.lvmama.lvfit.common.dto.sdp.product.*;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductBasicInfoRequest;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSdpProductSearchIndexTrafficMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvfit.business.sdpproduct.domain.FitSdpProductBasicInfo;
import com.lvmama.lvfit.business.sdpproduct.domain.repository.FitSdpCityGroupRepository;
import com.lvmama.lvfit.business.sdpproduct.domain.repository.FitSdpProductBasicInfoRepository;
import com.lvmama.lvfit.business.sdpproduct.domain.repository.FitSdpProductFeeRulesRepository;
import com.lvmama.lvfit.business.sdpproduct.domain.repository.FitSdpProductSearchIndexRepository;
import com.lvmama.lvfit.business.sdpproduct.domain.repository.FitSdpProductTrafficRulesRepository;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSdpProductBasicInfoMapper;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSdpProductSearchIndexMapper;

/**
 * @author lijinlong.
 * @date 2016.05.25
 *
 */
@Repository
public class FitSdpProductBasicInfoRepositoryImpl implements FitSdpProductBasicInfoRepository {
	
	@Autowired
	private FitSdpProductBasicInfoMapper fitSdpProductBasicInfoMapper;
	
	@Autowired
	private FitSdpProductSearchIndexRepository fitSdpProductSearchIndexRepository;
	
	@Autowired
	private FitSdpProductFeeRulesRepository fitSdpProductFeeRulesRepository;
	@Autowired
	private FitSdpProductTrafficRulesRepository fitSdpProductTrafficRulesRepository;
	@Autowired
	private FitSdpCityGroupRepository fitSdpCityGroupRepository;

	@Autowired
	private FitSdpProductSearchIndexTrafficMapper fitSdpProductSearchIndexTrafficMapper;

	@Override
	public FitSdpProductBasicInfoDto load(Long id) {
		
		FitSdpProductBasicInfoDto  basicInfoDto = fitSdpProductBasicInfoMapper.getById(id);
		//级联查询交通规则+加价规则
		if(basicInfoDto!=null){
			Long productId = basicInfoDto.getProductId();
			if(productId != null){
				List<FitSdpProductFeeRulesDto>  FeeRulesDtoList = fitSdpProductFeeRulesRepository.queryByFkId(productId);
				if(CollectionUtils.isNotEmpty(FeeRulesDtoList)){
					basicInfoDto.setFeeRulesDtos(FeeRulesDtoList);
				}
				List<FitSdpProductTrafficRulesDto>trafficRulesList = fitSdpProductTrafficRulesRepository.queryByFkId(productId);
				if(CollectionUtils.isNotEmpty(trafficRulesList)){
					basicInfoDto.setTrafficRulesDtos(trafficRulesList);
				}
			}
		}
		return basicInfoDto;
	}

	@Override
	public FitSdpProductBasicInfo load(FitSdpProductBasicInfoDto r) {
		FitSdpProductBasicInfo basicInfo = new FitSdpProductBasicInfo(r);
		return basicInfo;
	}

	@Override
	public int delete(Long id) {
		FitSdpProductBasicInfoDto  basicInfoDto = fitSdpProductBasicInfoMapper.getById(id);
		if(basicInfoDto!=null){
			Long productId = basicInfoDto.getProductId();
			if(productId != null){
				fitSdpProductTrafficRulesRepository.deleteByFkId(productId);
				fitSdpProductFeeRulesRepository.deleteByFkId(productId);
				fitSdpCityGroupRepository.deleteByFkId(productId);
				fitSdpProductSearchIndexRepository.deleteByFkId(productId);
			}
			return fitSdpProductBasicInfoMapper.deleteById(id);
		}
		return 0;
	}

	@Override
	public FitSdpProductBasicInfoDto save(FitSdpProductBasicInfoDto r) {
		if(r.getId() == null){
			fitSdpProductBasicInfoMapper.insert(r);
			//级联保存交通规则+城市组
			if(r.getProductId()!=null){
				if(CollectionUtils.isNotEmpty(r.getTrafficRulesDtos())){
					for (FitSdpProductTrafficRulesDto trafficRulesDto : r.getTrafficRulesDtos()) {
						fitSdpProductTrafficRulesRepository.save(trafficRulesDto);
					}
				}
				if(CollectionUtils.isNotEmpty(r.getCityGroups())){
					for (FitSdpCityGroupDto cityGroupDto : r.getCityGroups()) {
						fitSdpCityGroupRepository.save(cityGroupDto);
					}
				}
			}
		}else{
			fitSdpProductBasicInfoMapper.updateById(r.getId(), r);
			//级联更新城市组
			if(r.getProductId()!=null){
				if(CollectionUtils.isNotEmpty(r.getCityGroups())){
					fitSdpCityGroupRepository.deleteByFkId(r.getProductId());
					for (FitSdpCityGroupDto cityGroupDto : r.getCityGroups()) {
						fitSdpCityGroupRepository.save(cityGroupDto);
					}
				}
			}
		}
		return r;
	}

	@Override
	public List<FitSdpProductBasicInfoDto> query(BaseQueryDto<? extends FitSdpProductBasicInfoRequest> q) {
		List<FitSdpProductBasicInfoDto>  list = fitSdpProductBasicInfoMapper.queryByCondition(q);
		if(CollectionUtils.isNotEmpty(list)){
			//级联查询交通规则+加价规则
			for(FitSdpProductBasicInfoDto basicInfoDto:list){
				if(basicInfoDto.getProductId()!=null){
					List<FitSdpProductFeeRulesDto> feeRulesList = fitSdpProductFeeRulesRepository.queryByFkId(basicInfoDto.getProductId());
					basicInfoDto.setFeeRulesDtos(feeRulesList);
					
					List<FitSdpProductTrafficRulesDto> trafficRulesList = fitSdpProductTrafficRulesRepository.queryByFkId(basicInfoDto.getProductId());
					basicInfoDto.setTrafficRulesDtos(trafficRulesList);
				}
			}
		}
		return list;
	}

	@Override
	public int count(BaseQueryDto<? extends FitSdpProductBasicInfoRequest> q) {
		return fitSdpProductBasicInfoMapper.countByCondition(q);
	}

	@Override
	public FitSdpProductBasicInfoDto getByProductId(Long productId) {
		if(productId != null){
			FitSdpProductBasicInfoDto basicInfoDto = fitSdpProductBasicInfoMapper.getByProductId(productId);
			if(basicInfoDto!=null){
				List<FitSdpProductFeeRulesDto>  FeeRulesDtoList = fitSdpProductFeeRulesRepository.queryByFkId(productId);
				if(CollectionUtils.isNotEmpty(FeeRulesDtoList)){
					basicInfoDto.setFeeRulesDtos(FeeRulesDtoList);
				}
				List<FitSdpProductTrafficRulesDto>trafficRulesList = fitSdpProductTrafficRulesRepository.queryByFkId(productId);
				if(CollectionUtils.isNotEmpty(trafficRulesList)){
					basicInfoDto.setTrafficRulesDtos(trafficRulesList);
				}
				List<FitSdpCityGroupDto>cityGroupList = fitSdpCityGroupRepository.queryByFkId(productId);
				if(CollectionUtils.isNotEmpty(cityGroupList)){
					basicInfoDto.setCityGroups(cityGroupList);
				}
				
				return basicInfoDto;
			}
		}
		return null;
	}
	
	@Override
	public int deleteProductByProductId(Long productId){
		if(productId!=null){
			fitSdpProductTrafficRulesRepository.deleteByFkId(productId);
			fitSdpProductFeeRulesRepository.deleteByFkId(productId);
			fitSdpCityGroupRepository.deleteByFkId(productId);
			fitSdpProductSearchIndexRepository.deleteByFkId(productId);
			fitSdpProductSearchIndexTrafficMapper.deleteByFkId(productId);
			return fitSdpProductBasicInfoMapper.deleteByFkId(productId);
		}
		return -1;
	}

	@Override
	public List<FitSdpProductBasicInfoDto> querySdpProductReport(
			BaseQueryDto<FitSdpProductBasicInfoRequest> baseQueryDto) {
		return fitSdpProductBasicInfoMapper.querySdpProductReport(baseQueryDto);
	}

	@Override
	public int updateMultiDepartureFlag(JudgeType muiltDpartureFlag,Long productId) {
		return fitSdpProductBasicInfoMapper.updateMuiltDpartureFlag(muiltDpartureFlag, productId);
	}

}
