package com.lvmama.lvf.batch.product.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.lvmama.lvfit.common.utils.StringCn2Py;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.flight.FlightAirLineDto;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.batch.product.service.FitSdpProductBasicInfoSyncService;
import com.lvmama.lvfit.common.calculate.FitSdpCalculateUtils;
import com.lvmama.lvfit.common.client.FitAggregateClient;
import com.lvmama.lvfit.common.client.FitFlightClient;
import com.lvmama.lvfit.common.client.FitSdpClient;
import com.lvmama.lvfit.common.client.FitSearchClient;
import com.lvmama.lvfit.common.dto.enums.JudgeType;
import com.lvmama.lvfit.common.dto.enums.ProductAuditType;
import com.lvmama.lvfit.common.dto.enums.SortRuleType;
import com.lvmama.lvfit.common.dto.enums.TrafficTripeType;
import com.lvmama.lvfit.common.dto.enums.VSTDistrictCityEnum;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpCityGroupDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpDestDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductTrafficRulesDto;
import com.lvmama.lvfit.common.utils.ShortPinYinUtil;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSdpCityGroupMapper;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSdpProductBasicInfoMapper;
import com.lvmama.lvfit.persistence.mybatis.mapper.FitSdpProductTrafficRulesMapper;

@Service
public class FitSdpProductBasicInfoSyncServiceImpl implements FitSdpProductBasicInfoSyncService {

	public static final Logger logger = Logger.getLogger(FitSdpProductBasicInfoSyncServiceImpl.class);

	@Autowired
	private FitSearchClient fitSearchClient;

	@Autowired
	private FitSdpProductBasicInfoMapper fitSdpProductBasicInfoMapper;

	@Autowired
	private FitSdpProductTrafficRulesMapper fitSdpProductTrafficRulesMapper;

	@Autowired
	private FitSdpCityGroupMapper fitSdpCityGroupMapper;

	@Autowired
	private FitFlightClient fitFlightClient;

	@Autowired
	private FitAggregateClient fitAggregateClient;

	@Autowired
	private FitSdpCalculateUtils fitSdpCalculateUtils;

	@Autowired
	private FitSdpClient fitSdpClient;

	/**
	 * 默认出发开始时间
	 */
	public static final String defaultDepBegTime = "00:00";

	/**
	 * 默认出发结束时间
	 */
	public static final String defaultDepEndTime = "23:59";

	/**
	 * 默认出发开始时间
	 */
	public static final String defaultArrBegTime = "06:00";

	/**
	 * 默认出发结束时间
	 */
	public static final String defaultArrEndTime = "23:59";

	/**
	 * 品类跟团游
	 */
	public static final String category_route_group = "category_route_group";

	/**
	 * 品类自由行
	 */
	public static final String category_route_freedom = "category_route_freedom";

	@Override
	public ResultStatus syncSdpProductBasicInfo(Long productId) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		ProductSearchTask task = new ProductSearchTask(productId);

		Future<FitSdpProductBasicInfoDto> future = executor.submit(task);
		FitSdpProductBasicInfoDto basicInfoDto = null;
		try {
			basicInfoDto = future.get(30000, TimeUnit.MILLISECONDS);
		} catch (TimeoutException e) {
			future.cancel(true);
		} catch (Exception e) {
			future.cancel(true);
		} finally {
			executor.shutdown();
		}

		if (basicInfoDto != null) {
			ResultStatus rs = syncProduct(basicInfoDto);
			if (rs.equals(ResultStatus.SUCCESS)) {
				this.flushSdpCache(productId, basicInfoDto.getBizCategoryId());
				return ResultStatus.SUCCESS;
			}
		}
		return ResultStatus.FAIL;
	}

	private ResultStatus syncProduct(FitSdpProductBasicInfoDto productBasicInfoDto) {
		Long productId = productBasicInfoDto.getProductId();
		if (productBasicInfoDto.getPackageTrafficFlag() == JudgeType.Y && (productBasicInfoDto.getCategoryCode().equals(category_route_group) || productBasicInfoDto.getCategoryCode().equals(category_route_freedom))) {

			productBasicInfoDto.setCurSyncFlag(JudgeType.N);//每次走消息队列均更新为未同步状态

			FitSdpProductBasicInfoDto dbSdpProductBasicInfoDto = fitSdpProductBasicInfoMapper.getByProductId(productId);
			//新增或者修改自主打包产品信息
			if ((productBasicInfoDto.getPackageTrafficFlag() == JudgeType.Y
					&& productBasicInfoDto.getCancelFlag() == JudgeType.Y
					&& productBasicInfoDto.getSaleFlag() == JudgeType.Y
					&& productBasicInfoDto.getAuditType() == ProductAuditType.AUDITTYPE_PASS)
					|| (null != dbSdpProductBasicInfoDto)) {
				//设置城市组信息
				List<FitSdpCityGroupDto> cityGroups = new ArrayList<FitSdpCityGroupDto>();
				//若为自主打包交通，且有效、可售、审核通过，则插入我们的产品库
				List<FitSdpDestDto> destinations = productBasicInfoDto.getAdditionalInfoDto().getDestination();
				Long arrivalCityDistrictId = null;
				if (CollectionUtils.isNotEmpty(destinations)) {
					for (FitSdpDestDto destDto : destinations) {
						if (destDto.getDestType().equals("CITY") || destDto.getDestType().equals("COUNTY")) {
							String arrivalCityCode = VSTDistrictCityEnum.getCode(destDto.getDistricId());
							if (StringUtils.isNotBlank(arrivalCityCode)) {
								BaseResultDto<FlightAirLineDto> resultDto = fitFlightClient.getFlightLines(arrivalCityCode);
								if(resultDto !=null && CollectionUtils.isNotEmpty(resultDto.getResults())){
									arrivalCityDistrictId = destDto.getDistricId();
									break;
								}
							}
						}
					}
				}

				boolean isNeedUpdateCityGroups = true;
				Long dbArrivalCityDistrictId = null;
				if(null != dbSdpProductBasicInfoDto){
					List<FitSdpCityGroupDto> dbCityGroupDtos = fitSdpCityGroupMapper.queryAllCitysByFkId(productId);
					if(CollectionUtils.isNotEmpty(dbCityGroupDtos)){
						dbArrivalCityDistrictId = dbCityGroupDtos.get(0).getArrivalCityDistrictId();
					}
				}

				if(arrivalCityDistrictId != null && dbArrivalCityDistrictId != null && arrivalCityDistrictId.equals(dbArrivalCityDistrictId)){
					isNeedUpdateCityGroups = false;
				}

				//默认统一出发地
				if (arrivalCityDistrictId != null && isNeedUpdateCityGroups) {
					String arrivalCityCode = VSTDistrictCityEnum.getCode(arrivalCityDistrictId);
					if (StringUtils.isNotBlank(arrivalCityCode)) {
						String arrivalCityName = VSTDistrictCityEnum.getCnName(arrivalCityCode);
						String arrivalCityShortPinYin = StringCn2Py.cn2py(arrivalCityName).toUpperCase();
						BaseResultDto<FlightAirLineDto> resultDto = fitFlightClient.getFlightLines(arrivalCityCode);
						List<FlightAirLineDto> flightLineDtos = resultDto.getResults();
						if (CollectionUtils.isNotEmpty(flightLineDtos)) {
							for (FlightAirLineDto flightLineDto : flightLineDtos) {
								FitSdpCityGroupDto cityGroup = new FitSdpCityGroupDto();
								cityGroup.setProductId(productId);
								cityGroup.setArrivalCityCode(arrivalCityCode);
								cityGroup.setArrivalCityDistrictId(arrivalCityDistrictId);
								cityGroup.setArrivalCityName(arrivalCityName);
								cityGroup.setArrivalCityShortPinYin(arrivalCityShortPinYin);
								cityGroup.setDepartureCityCode(flightLineDto.getDepartureCity().getCityCode());
								VSTDistrictCityEnum city = VSTDistrictCityEnum.getByCode(cityGroup.getDepartureCityCode());
								if(city == null){
									continue;
								}
								cityGroup.setDepartureCityDistrictId(city.getDistrictId());
								cityGroup.setDepartureCityName(city.getCnName());
								cityGroup.setDepartureCityShortPinYin(city.getPinYin().toUpperCase());
								cityGroups.add(cityGroup);
							}
						}
					}
				}
				

				FitSdpProductBasicInfoDto packagedProduct = fitSearchClient.searchProductInfoOnly(productBasicInfoDto.getPackagedProductId());
				productBasicInfoDto.setPackagedCategoryId(packagedProduct.getBizCategoryId());

				//设置默认交通规则信息
				if (null == dbSdpProductBasicInfoDto) {
					//若是新增，需默认设置交通规则信息
					List<FitSdpProductTrafficRulesDto> trafficRulesDtos = new ArrayList<FitSdpProductTrafficRulesDto>();

					FitSdpProductTrafficRulesDto goTrafficRulesDto = new FitSdpProductTrafficRulesDto();
					goTrafficRulesDto.setProductId(productId);
					goTrafficRulesDto.setRouteDayNum(1);
				/*	goTrafficRulesDto.setDepBegTime(defaultBegTime);
					goTrafficRulesDto.setDepEndTime(defaultEndTime);*/
					goTrafficRulesDto.setArrBegTime(defaultArrBegTime);
					goTrafficRulesDto.setArrEndTime(defaultArrEndTime);
					goTrafficRulesDto.setSortRuleType(SortRuleType.SORT_BY_PRICE_ASC);
					goTrafficRulesDto.setTrafficTripeType(TrafficTripeType.GO_WAY);
					fitSdpProductTrafficRulesMapper.insert(goTrafficRulesDto);

					FitSdpProductTrafficRulesDto backTrafficRulesDto = new FitSdpProductTrafficRulesDto();
					backTrafficRulesDto.setProductId(productId);
					backTrafficRulesDto.setRouteDayNum(productBasicInfoDto.getRouteNum());
					backTrafficRulesDto.setDepBegTime(defaultDepBegTime);
					backTrafficRulesDto.setDepEndTime(defaultDepEndTime);
					/*backTrafficRulesDto.setArrBegTime(defaultBegTime);
					backTrafficRulesDto.setArrEndTime(defaultEndTime);*/
					backTrafficRulesDto.setSortRuleType(SortRuleType.SORT_BY_PRICE_ASC);
					backTrafficRulesDto.setTrafficTripeType(TrafficTripeType.BACK_WAY);

					fitSdpProductTrafficRulesMapper.insert(backTrafficRulesDto);


					for (FitSdpCityGroupDto sdpCityGroupDto : cityGroups) {
						sdpCityGroupDto.setIsSelectedDeparture(JudgeType.Y);
						fitSdpCityGroupMapper.insert(sdpCityGroupDto);
					}
					JudgeType muiltDpartureFlag = JudgeType.Y;
					if(cityGroups.size()<=1){
						muiltDpartureFlag = JudgeType.N;
					}
					productBasicInfoDto.setMuiltDpartureFlag(muiltDpartureFlag);
					fitSdpProductBasicInfoMapper.insert(productBasicInfoDto);

				} else {
					if(isNeedUpdateCityGroups){
						fitSdpCityGroupMapper.deleteByFkId(productId);
						for (FitSdpCityGroupDto sdpCityGroupDto : cityGroups) {
							sdpCityGroupDto.setIsSelectedDeparture(JudgeType.Y);
							fitSdpCityGroupMapper.insert(sdpCityGroupDto);
						}
						JudgeType muiltDpartureFlag = JudgeType.Y;
						if(cityGroups.size()<=1){
							muiltDpartureFlag = JudgeType.N;
						}
						productBasicInfoDto.setMuiltDpartureFlag(muiltDpartureFlag);
					}
					productBasicInfoDto.setMuiltDpartureFlag(dbSdpProductBasicInfoDto.getMuiltDpartureFlag());
					productBasicInfoDto.setId(dbSdpProductBasicInfoDto.getId());
					productBasicInfoDto.setUpdateTime(new Date());
					fitSdpProductBasicInfoMapper.updateById(dbSdpProductBasicInfoDto.getId(), productBasicInfoDto);
				}


				try {
					logger.info("自主打包产品【" + productId + "】入库信息为：【" + JSONMapper.getInstance().writeValueAsString(productBasicInfoDto) + "】");
				} catch (Exception e) {
					logger.error(e);
				}
				return ResultStatus.SUCCESS;
			}else {
				return  ResultStatus.FAIL;
			}
		}
		return  ResultStatus.FAIL;
	}

	class ProductSearchTask implements Callable<FitSdpProductBasicInfoDto> {

		private Long productId;

		public ProductSearchTask(Long productId) {
			this.productId = productId;
		}

		@Override
		public FitSdpProductBasicInfoDto call() throws Exception {
			if (productId != null) {
				return fitSearchClient.searchProductBasicInfo(productId);
			}
			return null;
		}
	}

	@Async
	public void flushSdpCache(Long productId, Long bizCategoryId) {
		try {
			fitAggregateClient.getProBasicInfoAndFlushCache(productId);
			fitSdpCalculateUtils.getAllCityCalendarInfoAndUpdCache(productId);
			fitSdpClient.getBottomInfoAndUpdCache(productId, bizCategoryId);
		} catch (Exception e) {
			logger.error("产品" + productId + "更新缓存失败：", e);
		}
	}
}
