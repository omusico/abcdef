package com.lvmama.lvfit.business.sdpproduct.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvfit.business.order.domain.repository.FitSuppOrderForFlightCallBackRepository;
import com.lvmama.lvfit.business.sdpproduct.domain.repository.FitSdpCityGroupRepository;
import com.lvmama.lvfit.business.sdpproduct.domain.repository.FitSdpProductBasicInfoRepository;
import com.lvmama.lvfit.business.sdpproduct.domain.repository.FitSdpProductFeeRulesRepository;
import com.lvmama.lvfit.business.sdpproduct.domain.repository.FitSdpProductSearchIndexRepository;
import com.lvmama.lvfit.business.sdpproduct.domain.repository.FitSdpProductSearchIndexTrafficRepository;
import com.lvmama.lvfit.business.sdpproduct.domain.repository.FitSdpProductSearchSynInfoRepository;
import com.lvmama.lvfit.business.sdpproduct.domain.repository.FitSdpProductTrafficRulesRepository;
import com.lvmama.lvfit.business.sdpproduct.service.FitSdpProductService;
import com.lvmama.lvfit.common.client.FitBatchClient;
import com.lvmama.lvfit.common.dto.enums.BizEnum.BIZ_CATEGORY_TYPE;
import com.lvmama.lvfit.common.dto.enums.JudgeType;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderForFlightCallBackDto;
import com.lvmama.lvfit.common.dto.request.FitFliBookingCallBackRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpCityGroupDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductFeeRulesDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexTraffic;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSyncMsgDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductTrafficRulesDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpCityGroupRequest;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductBasicInfoRequest;
import com.lvmama.lvfit.common.form.product.FitSuppOrderForFlightCallBackRequest;

@Service
public class FitSdpProductServiceImpl implements FitSdpProductService {
	
	@Autowired
	private FitSdpProductBasicInfoRepository fitSdpProductBasicInfoRepository;
	@Autowired
	private FitSdpProductFeeRulesRepository fitSdpProductFeeRulesRepository;
	@Autowired
	private FitSdpProductTrafficRulesRepository fitSdpProductTrafficRulesRepository;
	@Autowired
	private FitSdpCityGroupRepository fitSdpCityGroupRepository;
	@Autowired
	private FitSdpProductSearchIndexRepository fitSdpProductSearchIndexRepository;
	@Autowired
	private FitSdpProductSearchSynInfoRepository fitSdpProductSearchSynInfoRepository;
	@Autowired
	private FitSdpProductSearchIndexTrafficRepository fitSdpProductSearchIndexTrafficRepository;
	@Autowired
	private FitSuppOrderForFlightCallBackRepository fitSuppOrderForFlightCallBackRepository;
	
	@Autowired
	private FitBatchClient fitBatchClient;
	
	private static final Logger logger = LoggerFactory.getLogger(FitSdpProductServiceImpl.class);
	
	@Override
	public FitSdpProductBasicInfoDto getProductBasicInfoByProductId(Long productId) {
		
		return fitSdpProductBasicInfoRepository.getByProductId(productId);
	}

	@Override
	public List<FitSdpProductBasicInfoDto> getProductBasicInfosByCondition(BaseQueryDto<FitSdpProductBasicInfoRequest> BasicInfoDto) {
		List<FitSdpProductBasicInfoDto> basicInfoList = fitSdpProductBasicInfoRepository.query(BasicInfoDto);
		return basicInfoList;
	}

	@Override
	public List<FitSdpProductTrafficRulesDto> getProductTrafficRulesByProductId(Long productId) {
		return fitSdpProductTrafficRulesRepository.queryByFkId(productId);
	}

	@Override
	public void saveOrUpdateProductTrafficRules(List<FitSdpProductTrafficRulesDto> trafficRulesDtos) {
		if(CollectionUtils.isNotEmpty(trafficRulesDtos)){
			//先删除已保存的规则
			Long productId = trafficRulesDtos.get(0).getProductId();
			fitSdpProductTrafficRulesRepository.deleteByFkId(productId);
			
			for(FitSdpProductTrafficRulesDto trafficRulesDto:trafficRulesDtos ){
				fitSdpProductTrafficRulesRepository.save(trafficRulesDto);
			}
		}
	}

	@Override
	public List<FitSdpProductFeeRulesDto> getProductFeeRulesByProductId(Long productId) {
		return fitSdpProductFeeRulesRepository.queryByFkId(productId);
	}

	@Override
	public void saveOrUpdateProductTFeeRules(List<FitSdpProductFeeRulesDto> feeRulesDtos) {
		if(CollectionUtils.isNotEmpty(feeRulesDtos)){
			//先删除已保存的规则
			Long productId = feeRulesDtos.get(0).getProductId();
			fitSdpProductFeeRulesRepository.deleteByFkId(productId);
			
			for(FitSdpProductFeeRulesDto feeRulesDto:feeRulesDtos ){
				fitSdpProductFeeRulesRepository.save(feeRulesDto);
			}
		}
	}
    
	@Override
    @Async
    public void updateSdpProductSearchIndex(Long productId) {
         try {
             fitBatchClient.syncSdpProductSearchIndex(productId);
         } catch (Exception e) {
             logger.error("自主打包产品【"+productId+"】同步索引失败败！");
         }
     }

	@Override
	public FitSdpProductBasicInfoDto saveOrUpdateProductBasicInfo(FitSdpProductBasicInfoDto productBasicInfoDto) {
		return fitSdpProductBasicInfoRepository.save(productBasicInfoDto);
	}
	
	@Override
	public int countProductInfoList(BaseQueryDto<FitSdpProductBasicInfoRequest> BasicInfoDto){
		return fitSdpProductBasicInfoRepository.count(BasicInfoDto);
	}
	
	@Override
	public List<FitSdpCityGroupDto> getProductCityGroupByProductId(Long productId){
		return fitSdpCityGroupRepository.queryAllCitysByFkId(productId);
	}
	
	@Override
	public List<FitSdpCityGroupDto> getSelectCityGroupByProductId(Long productId){
		return fitSdpCityGroupRepository.queryByFkId(productId);
	}
	@Override
	public void saveOrUpdateProductCityGroup(List<FitSdpCityGroupDto> CityGroupDtos){
		if(CollectionUtils.isNotEmpty(CityGroupDtos)){
			for (FitSdpCityGroupDto fitSdpCityGroupDto : CityGroupDtos) {
				fitSdpCityGroupRepository.save(fitSdpCityGroupDto);
			}
		}
	}
	@Override
	public int deleteProductByProductId(Long productId){
		return fitSdpProductBasicInfoRepository.deleteProductByProductId(productId);
	}

	@Override
	public List<String> querySdpProductReport(BaseQueryDto<FitSdpProductBasicInfoRequest> baseQueryDto) {
		List<String> result = new ArrayList<String>();
		List<FitSdpProductBasicInfoDto> basicInfoList = fitSdpProductBasicInfoRepository.querySdpProductReport(baseQueryDto);
		//构建每一个产品信息
		if (CollectionUtils.isNotEmpty(basicInfoList)) {
			StringBuilder sb = new StringBuilder();
			for (int i=0;i<basicInfoList.size();i++) {
				sb.delete(0, sb.length());
				FitSdpProductBasicInfoDto productInfo = basicInfoList.get(i);
				sb.append(productInfo.getProductId()!=null ? "\t"+productInfo.getProductId()+",":",");
				String productName = productInfo.getProductName();
				if(productName!=null){
					if(productInfo.getProductName().contains(",")){
						productName = productInfo.getProductName().replaceAll(",", " ");
					}
					sb.append("\t"+productName+",");
				}else{
					sb.append(" ,");
				}
				sb.append(productInfo.getManagerName()!=null ? "\t"+productInfo.getManagerName()+",":",");
				sb.append(productInfo.getCancelFlag()!=null ? "\t"+productInfo.getCancelFlag().getCnName()+",":",");
				sb.append(productInfo.getSaleFlag()!=null ? "\t"+productInfo.getSaleFlag().getCnName()+",":",");
				sb.append(productInfo.getPackagedProductId()!=null ? "\t"+productInfo.getPackagedProductId()+",":",");
				sb.append(productInfo.getMuiltDpartureFlag()!=null ? "\t"+productInfo.getMuiltDpartureFlag().getCnName()+",":",");
				if(productInfo.getProductId()!=null){
					List<FitSdpProductFeeRulesDto>  feeList = fitSdpProductFeeRulesRepository.queryByFkId(productInfo.getProductId());
					if(CollectionUtils.isNotEmpty(feeList)){
						sb.append(feeList.get(0).getOprationValue()!=null ? "\t"+feeList.get(0).getOprationValue()+",":",");
					}else{
						sb.append(" ,");
					}
				}else{
					sb.append(" ,");
				}
				sb.append(productInfo.getBizCategoryId()!=null ? "\t"+BIZ_CATEGORY_TYPE.getCnName(productInfo.getBizCategoryId())+",":",");
				String ct = null;
				if(productInfo.getCreateTime()!=null){
					SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					ct = sd.format(productInfo.getCreateTime());
				}
				sb.append(ct!=null?"\t"+ct+",":",");
				result.add(sb.toString());
			}
		}
		return result;
	}
	
	@Override
	public void updateCityUseFlagBatch(List<FitSdpCityGroupDto> CityGroupDtos){
		if(CollectionUtils.isNotEmpty(CityGroupDtos)){
			int selectedCitys = 0;
			for (FitSdpCityGroupDto fitSdpCityGroupDto : CityGroupDtos) {
				fitSdpCityGroupRepository.updateCityUseFlag(fitSdpCityGroupDto);
				
				if(fitSdpCityGroupDto.getIsSelectedDeparture()!=null && 
						JudgeType.Y.name().equals(fitSdpCityGroupDto.getIsSelectedDeparture().name()))
					{
						selectedCitys++;
					}
			}
			if(selectedCitys <= 1 ){
				fitSdpProductBasicInfoRepository.updateMultiDepartureFlag(JudgeType.N, CityGroupDtos.get(0).getProductId());
			}else{
				fitSdpProductBasicInfoRepository.updateMultiDepartureFlag(JudgeType.Y, CityGroupDtos.get(0).getProductId());
			}
		}
	}

	@Override
	public List<FitSdpProductSearchIndexDto> querySdpProductSearchIndex(BaseQueryDto<Long> baseQuery) {
		return fitSdpProductSearchIndexRepository.queryIndexInfoList(baseQuery);
	}

	@Override
	public List<FitSdpProductSearchIndexTraffic> querySdpProductIndexTrafficList(
			BaseQueryDto<Long> baseQuery) {
		return fitSdpProductSearchIndexTrafficRepository.queryIndexTrafficList(baseQuery);
	}

	@Override
	public void saveEditProductCityGroup(FitSdpCityGroupDto cityGroupDtos){
		if(cityGroupDtos!=null){
				fitSdpCityGroupRepository.save(cityGroupDtos);
		}
	}

	@Override
	public FitSdpCityGroupDto getProductCityGroupById(Long id) {
		if(id!=0){
			return fitSdpCityGroupRepository.queryOneCityById(id);
		}else{
			return null;
		}
	}

	@Override
	public List<FitSdpCityGroupDto> getProductCityGroupByDto(
			BaseQueryDto<FitSdpCityGroupRequest> request) {
		if(request!=null){
			return fitSdpCityGroupRepository.queryCityGroupByDto(request);
		}else{
			return null;
		}
	}

	@Override
	public List<FitSuppOrderForFlightCallBackDto> queryFitSuppOrderFlightCallBack(BaseQueryDto<FitSuppOrderForFlightCallBackRequest> request) {
		return fitSuppOrderForFlightCallBackRepository.queryAll(request);
	}

	@Override
	public int countSuppOrderForFlightCallBackRecords(
			BaseQueryDto<FitSuppOrderForFlightCallBackRequest> baseQuery) {
		return fitSuppOrderForFlightCallBackRepository.querySuppOrderForFlightCallBackCounts(baseQuery);
	}

	@Override
	public int countSdpProductDepartCityRecords(
			BaseQueryDto<FitSdpCityGroupRequest> baseQueryDto) {
		return fitSdpCityGroupRepository.countSdpProductDepartCityRecords(baseQueryDto);
	}

	@Override
	public FitSdpProductSearchIndexTraffic queryTrafficIndexById(Long id) {
		return fitSdpProductSearchIndexTrafficRepository.queryTrafficIndexById(id);
	}

	@Override
	@Async
	public void updateOneTrafficIndex(FitSdpProductSearchIndexTraffic dto) {
		if(dto!=null){
			fitSdpProductSearchIndexTrafficRepository.save(dto);
		}
	}

	@Override
	public List<FitFliBookingCallBackRequest> getFlightCallBackByVstMainNo(
			BaseQueryDto<FitFliBookingCallBackRequest> baseQuery) {
		return fitSuppOrderForFlightCallBackRepository.queryByVstMainNo(baseQuery);
	}

	@Override
	public List<FitSdpProductSyncMsgDto> querySdpProductSynMsgInfo(BaseQueryDto<FitSdpProductSyncMsgDto> baseQuery) {
		return fitSdpProductSearchSynInfoRepository.querySdpProductSynMsgInfo(baseQuery);
	}

	@Override
	public int countSdpProductSearchIndex(BaseQueryDto<Long> baseQuery) {
		return fitSdpProductSearchIndexRepository.countSearchIndex(baseQuery);
	}

	@Override
	public int countSdpProductIndexTraffic(BaseQueryDto<Long> baseQuery) {
		return fitSdpProductSearchIndexTrafficRepository.countIndexTraffic(baseQuery);
	}

	@Override
	public int countSdpProductSynMsg(BaseQueryDto<FitSdpProductSyncMsgDto> baseQuery) {
		return fitSdpProductSearchSynInfoRepository.countSdpProductSynMsg(baseQuery);
	}

}
