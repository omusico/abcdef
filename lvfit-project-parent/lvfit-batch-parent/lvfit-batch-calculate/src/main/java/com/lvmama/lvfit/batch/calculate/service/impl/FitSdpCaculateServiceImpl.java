package com.lvmama.lvfit.batch.calculate.service.impl;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.batch.caculate.service.FitSdpCaculateService;
import com.lvmama.lvfit.common.calculate.FitSdpCalculateUtils;
import com.lvmama.lvfit.common.client.FitAggregateClient;
import com.lvmama.lvfit.common.client.FitVstServiceClient;
import com.lvmama.lvfit.common.dto.enums.JudgeType;
import com.lvmama.lvfit.common.dto.enums.ProductAuditType;
import com.lvmama.lvfit.common.dto.sdp.product.*;
import com.lvmama.lvfit.persistence.mybatis.mapper.*;

import net.sf.jxls.report.ResultSetCollection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Transactional
public class FitSdpCaculateServiceImpl implements FitSdpCaculateService{
	
	public static final Logger logger=Logger.getLogger(FitSdpCaculateServiceImpl.class);
	

	@Autowired
	private FitVstServiceClient fitVstServiceClient;
	
	@Autowired
	private FitSdpProductBasicInfoMapper productBasicInfoMapper;
	
	@Autowired
	private FitOrderMainMapper fitOrderMainMapper;
	
	@Autowired
	private FitSdpProductSearchIndexMapper productSearchIndexMapper;

	@Autowired
	private FitSdpCalculateUtils fitSdpCalculateUtils;

	@Autowired
	private FitSdpProductSearchIndexTrafficMapper fitSdpProductSearchIndexTrafficMapper;
	
	@Autowired
	private FitSdpProductSynMsgMapper fitSdpProductSynMsgMapper;
	
	public static final String PUSH_CONTENT = "T_FITSDP_PRODUCT_SEARCH_INDEX";
	
	public static final String PUSH_DATA_TYPE = "SEARCHINCREMENT";
	
	public static final String PUSH_OBJECT_TYPE = "PRODUCT";


	@Value("syncSdpIndex.machine.count")
	private String syncMachineCount;

	@Value("syncSdpIndex.customRows")
	private String syncCustomRows;

	@Override
	@Async
	public void syncSdpProductIndexsByModValue(Integer modValue) {

		//首次初始化查询可同步产品的查询条件
		BaseQueryDto<Integer> baseQueryDto = new BaseQueryDto<Integer>();
		baseQueryDto.setCondition(modValue);
		Pagination pagination = new Pagination(1,this.getSyncCustomRows());
		baseQueryDto.setPagination(pagination);
		recursion(baseQueryDto);
	}

	/**
	 * 递归执行同步操作
	 * @param baseQueryDto
     */
	private void recursion(BaseQueryDto<Integer> baseQueryDto) {
		int curPage = baseQueryDto.getPagination().getPage();
		BaseResultDto<Long> curResultDto = this.getCanSyncProductsByModValue(baseQueryDto);
		List<Long> curSyncProductIds = curResultDto.getResults();
		if (CollectionUtils.isNotEmpty(curSyncProductIds)){
			this.syncSdpProductSearchIndexs(curResultDto.getResults());
			curPage++;
			baseQueryDto.getPagination().setPage(curPage);
			recursion(baseQueryDto);
		}
	}

	private void syncSdpProductSearchIndexs(List<Long> syncProductIds) {

		String gid = UUID.randomUUID().toString();
		try {
			if(logger.isInfoEnabled()){
				logger.info("GID【"+gid+"】批次，同步的产品索引为：【"+JSONMapper.getInstance().writeValueAsString(syncProductIds)+"】");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		final List<Long> failSyncProductIds = new ArrayList<Long>();
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
		for (final Long productId : syncProductIds) {
			fixedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						syncSdpProductSearchIndex(productId,false);
					} catch (Exception e) {
						failSyncProductIds.add(productId);
					}
				}
			});
		}
		fixedThreadPool.shutdown();
		while (true) {
			if (fixedThreadPool.isTerminated()) {
				break;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				logger.error(e.getMessage());
			}
		}
		try {
			if(logger.isInfoEnabled()){
				logger.info("GID【"+gid+"】批次，同步的产品索引失败的为：【"+JSONMapper.getInstance().writeValueAsString(failSyncProductIds)+"】");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}

	public BaseResultDto<Long> getCanSyncProductsByModValue(BaseQueryDto<Integer> baseQueryDto) {

		Integer syncMachineCount = this.getSyncMachineCount();
		Integer modValue = baseQueryDto.getCondition();
		Integer startRow = baseQueryDto.getPagination().getStartRow();
		Integer endRow = baseQueryDto.getPagination().getEndRow();
		try{
			List<Long> products = productBasicInfoMapper.getCanSyncProductsByModValue(syncMachineCount,startRow,endRow,modValue);
			int records = productBasicInfoMapper.getCanSyncProductCountsByModValue(syncMachineCount,startRow,endRow,modValue);
			Pagination pagination = baseQueryDto.getPagination();
			pagination.setRecords(records);
			pagination.countRecords(records);
			BaseResultDto<Long> baseResultDto = new BaseResultDto<Long>(pagination,products);
			return baseResultDto;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}


	}

	@Override
	public void syncSdpProductSearchIndex(Long productId,boolean isNotSyncAll) {
		
		FitSdpProductBasicInfoDto  dbProductBasicInfoDto = productBasicInfoMapper.getByProductId(productId);
		String operateType = null;
		if(null!=dbProductBasicInfoDto){
			
			int count = productSearchIndexMapper.countByProductId(productId);
			if((dbProductBasicInfoDto.getPackageTrafficFlag()==JudgeType.Y
					&& dbProductBasicInfoDto.getCancelFlag()==JudgeType.Y
					&& dbProductBasicInfoDto.getSaleFlag()==JudgeType.Y
					&& dbProductBasicInfoDto.getAuditType()==ProductAuditType.AUDITTYPE_PASS)){
				//调用vst侧推送接口推送到 com_push 表中，新增，修改，删除以便搜索方及时同步
				Map<Long, List<FitSdpProductCalendarDto>> allCityCalendarInfo = fitSdpCalculateUtils.getAllCityCalendarInfo(productId);
				List<FitSdpProductSearchIndexDto> syncProductSearchIndexs = this.generateProductSearchIndexs(productId, allCityCalendarInfo);
				if(CollectionUtils.isNotEmpty(syncProductSearchIndexs)){
					if(count>=1){
						operateType = FitSdpComPushDto.OPERATE_TYPE.UP.name();
					}else{
						operateType = FitSdpComPushDto.OPERATE_TYPE.ADD.name();
					}
					
					productSearchIndexMapper.deleteByFkId(productId);
					productSearchIndexMapper.insertBatch(syncProductSearchIndexs);
                    productBasicInfoMapper.updateCurSyncFlag(JudgeType.Y, productId);
					//插入交通信息
					FitSdpProductSearchIndexTraffic indexTraffic = new FitSdpProductSearchIndexTraffic();
					indexTraffic.setProductId(productId);
					indexTraffic.setToTraffic(FitSdpLineTraffic.CATEGORY_TRAFFIC_AERO_OTHER.name());
					indexTraffic.setBackTraffic(FitSdpLineTraffic.CATEGORY_TRAFFIC_AERO_OTHER.name());
					indexTraffic.setSalesVolume(String.valueOf(fitOrderMainMapper.getOrderCountByProductId(productId)));
					StringBuffer sb = new StringBuffer();
					for (List<FitSdpProductCalendarDto> list : allCityCalendarInfo.values()) {
						for (int i = 0; i < 6; i++) {
							if(i>list.size()-1){
                               break;
							}
							sb.append(list.get(i).getDepartureDate());
							if (i != 5) {
								sb.append(",");
							}
						}
						break;
					}
					indexTraffic.setDepatureTime(sb.toString());
					if (allCityCalendarInfo.keySet().size() == 1) {
						indexTraffic.setIsMultiDepature(JudgeType.N);
					} else {
						indexTraffic.setIsMultiDepature(JudgeType.Y);
					}

					fitSdpProductSearchIndexTrafficMapper.deleteByFkId(productId);
					fitSdpProductSearchIndexTrafficMapper.insert(indexTraffic);
				}
			}else{
				if(count>=1){
					operateType = FitSdpComPushDto.OPERATE_TYPE.DEL.name();
				}
			}

			if(isNotSyncAll&&StringUtils.isNotBlank(operateType)){
				//不是全量更新的时候才往com_push表推送数据
				FitSdpComPushDto sdpComPushDto = new FitSdpComPushDto();
				sdpComPushDto.setObjectId(productId);
				sdpComPushDto.setObjectType(PUSH_OBJECT_TYPE);
				sdpComPushDto.setCreateTime(new Date());
				//sdpComPushDto.setPushFlag(JudgeType.N.name());//默认从这边是没有推送过的
				sdpComPushDto.setPushCount((long)0);
				sdpComPushDto.setPushContent(PUSH_CONTENT);
				sdpComPushDto.setDataType(PUSH_DATA_TYPE); //必须传SEARCHINCREMENT
				sdpComPushDto.setOperateType(operateType);   //可以传入 ADD DEL  UP
				try {
					ResultStatus resultStatus = fitVstServiceClient.pushComPush(sdpComPushDto);
					logger.info("自主打包产品【"+productId+"】推送com_push:"+resultStatus.getCnName());
				} catch (Exception e) {
					logger.error(e.getMessage(),e);
				}
			}
		}
	}

	private List<FitSdpProductSearchIndexDto> generateProductSearchIndexs(Long productId, Map<Long, List<FitSdpProductCalendarDto>> allCityCalendarInfo) {

		List<FitSdpProductSearchIndexDto> sdpProductSearchIndexs = new ArrayList<FitSdpProductSearchIndexDto>();
		if (MapUtils.isNotEmpty(allCityCalendarInfo)) {
			for (Entry<Long, List<FitSdpProductCalendarDto>> entry : allCityCalendarInfo.entrySet()) {
			    if(entry.getKey()==null) {
				    continue;
			    }
				FitSdpProductSearchIndexDto productSearchIndex = new FitSdpProductSearchIndexDto();
				productSearchIndex.setProductId(productId);
				productSearchIndex.setStartDistrictId(entry.getKey());
				BigDecimal startingPrice = fitSdpCalculateUtils.getStartingPrice(entry.getValue());
				productSearchIndex.setLowestSaledPrice(startingPrice);

			   //目前app价和wap价和pc价一致
			   productSearchIndex.setAppLowestSaledPrice(productSearchIndex.getLowestSaledPrice());
			   productSearchIndex.setWapLowestSaledPrice(productSearchIndex.getLowestSaledPrice());

			   sdpProductSearchIndexs.add(productSearchIndex);
			}
		}
		return sdpProductSearchIndexs;
	}


	public Integer getSyncMachineCount() {
		return Integer.parseInt(CustomizedPropertyPlaceholderConfigurer.getContextProperty(syncMachineCount)+"");
	}

	public Integer getSyncCustomRows() {
		return Integer.parseInt(CustomizedPropertyPlaceholderConfigurer.getContextProperty(syncCustomRows)+"");
	}

	@Override
	public void syncUnfinishedProductsToIndex() {
		final List<Long> productIds = productBasicInfoMapper.queryDataBefore5Am();
		for (Long productId : productIds) {
			this.syncSdpProductSearchIndex(productId, true);
		}
	}
	
	@Override
	public ResultStatus saveSynMsgInfo(FitSdpProductSyncMsgDto request) {
		fitSdpProductSynMsgMapper.insert(request);
		return ResultStatus.SUCCESS;
	}

}
